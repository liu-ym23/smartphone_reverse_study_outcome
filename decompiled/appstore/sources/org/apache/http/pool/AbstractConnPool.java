package org.apache.http.pool;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.pool.PoolEntry;
import org.apache.http.util.Args;
import org.apache.http.util.Asserts;

/* JADX INFO: loaded from: classes4.dex */
@Contract(threading = ThreadingBehavior.SAFE_CONDITIONAL)
public abstract class AbstractConnPool<T, C, E extends PoolEntry<T, C>> implements ConnPool<T, E>, ConnPoolControl<T> {
    private final LinkedList<E> available;
    private final Condition condition;
    private final ConnFactory<T, C> connFactory;
    private volatile int defaultMaxPerRoute;
    private volatile boolean isShutDown;
    private final Set<E> leased;
    private final Lock lock;
    private final Map<T, Integer> maxPerRoute;
    private volatile int maxTotal;
    private final LinkedList<Future<E>> pending;
    private final Map<T, RouteSpecificPool<T, C, E>> routeToPool;
    private volatile int validateAfterInactivity;

    public AbstractConnPool(ConnFactory<T, C> r10, int r11, int r12) {
        this.connFactory = (ConnFactory) Args.notNull(r10, "Connection factory");
        this.defaultMaxPerRoute = Args.positive(r11, "Max per route value");
        this.maxTotal = Args.positive(r12, "Max total value");
        ReentrantLock r13 = new ReentrantLock();
        this.lock = r13;
        this.condition = r13.newCondition();
        this.routeToPool = new HashMap();
        this.leased = new HashSet();
        this.available = new LinkedList();
        this.pending = new LinkedList();
        this.maxPerRoute = new HashMap();
    }

    public static /* synthetic */ Lock access$000(AbstractConnPool r10) {
        return r10.lock;
    }

    public static /* synthetic */ Condition access$100(AbstractConnPool r10) {
        return r10.condition;
    }

    public static /* synthetic */ PoolEntry access$200(AbstractConnPool r10, Object r11, Object r12, long r13, TimeUnit r14, Future r15) throws IOException, InterruptedException, TimeoutException {
        return r10.getPoolEntryBlocking(r11, r12, r13, r14, r15);
    }

    public static /* synthetic */ int access$300(AbstractConnPool r10) {
        return r10.validateAfterInactivity;
    }

    private int getMax(T r10) {
        Integer r11 = this.maxPerRoute.get(r10);
        if (r11 == null) goto L6;
        return r11.intValue();
    L6:
        return this.defaultMaxPerRoute;
    }

    private RouteSpecificPool<T, C, E> getPool(final T r10) {
        RouteSpecificPool<T, C, E> r11 = this.routeToPool.get(r10);
        if (r11 != null) goto L6;
        RouteSpecificPool<T, C, E> r12 = (RouteSpecificPool<T, C, E>) new AnonymousClass1(this, r10, r10);
        this.routeToPool.put(r10, r12);
        return r12;
    L6:
        return r11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private E getPoolEntryBlocking(T r10, Object r11, long r12, TimeUnit r13, Future<E> r14) throws IOException, InterruptedException, TimeoutException {
        if (r12 <= 0) goto L5;
        Date r15 = new Date(System.currentTimeMillis() + r13.toMillis(r12));
    L6:
        this.lock.lock();
        RouteSpecificPool r16 = getPool(r10);     // Catch: Throwable -> L15
    L8:
        boolean r17 = true;
        Asserts.check(!this.isShutDown, "Connection pool shut down");     // Catch: Throwable -> L15
    L9:
        E r18 = (E) r16.getFree(r11);
        if (r18 == null) goto L20;
        if (r18.isExpired(System.currentTimeMillis()) == false) goto L18;
        r18.close();     // Catch: Throwable -> L15
    L18:
        if (r18.isClosed() == false) goto L20;
        this.available.remove(r18);     // Catch: Throwable -> L15
        r16.free(r18, false);     // Catch: Throwable -> L15
    L20:
        if (r18 != null) goto L21;
        int r19 = getMax(r10);     // Catch: Throwable -> L15
        int r20 = Math.max(0, (r16.getAllocatedCount() + 1) - r19);     // Catch: Throwable -> L15
        if (r20 <= 0) goto L33;
        int r21 = 0;
    L27:
        if (r21 >= r20) goto L33;
        PoolEntry r22 = r16.getLastUsed();     // Catch: Throwable -> L15
        if (r22 == null) goto L33;
        r22.close();     // Catch: Throwable -> L15
        this.available.remove(r22);     // Catch: Throwable -> L15
        r16.remove(r22);     // Catch: Throwable -> L15
        r21 = r21 + 1;     // Catch: Throwable -> L15
    L33:
        if (r16.getAllocatedCount() >= r19) goto L71;
        int r110 = Math.max(this.maxTotal - this.leased.size(), 0);     // Catch: Throwable -> L15
        if (r110 <= 0) goto L71;
        if (this.available.size() > (r110 - 1)) goto L39;
    L41:
        E r23 = (E) r16.add(this.connFactory.create(r10));
        this.leased.add(r23);     // Catch: Throwable -> L15
        this.lock.unlock();
        return r23;
    L39:
        if (this.available.isEmpty() == true) goto L41;
        E r24 = this.available.removeLast();     // Catch: Throwable -> L15
        r24.close();     // Catch: Throwable -> L15
        getPool(r24.getRoute()).remove(r24);     // Catch: Throwable -> L15
    L71:
    L50:
        th = move-exception;
        r16.unqueue(r14);     // Catch: Throwable -> L15
        this.pending.remove(r14);     // Catch: Throwable -> L15
        throw th;     // Catch: Throwable -> L15
    L46:
        if (r14.isCancelled() == true) goto L66;
        r16.queue(r14);     // Catch: Throwable -> L50
        this.pending.add(r14);     // Catch: Throwable -> L50
        if (r15 == null) goto L52;
        r17 = this.condition.awaitUntil(r15);     // Catch: Throwable -> L50
    L54:
        if (r14.isCancelled() == true) goto L64;
        r16.unqueue(r14);     // Catch: Throwable -> L15
        this.pending.remove(r14);     // Catch: Throwable -> L15
        if (r17 == true) goto L8;
        if (r15 == null) goto L8;
        if (r15.getTime() > System.currentTimeMillis()) goto L8;
        throw new TimeoutException("Timeout waiting for connection");     // Catch: Throwable -> L15
    L64:
        throw new InterruptedException("Operation interrupted");     // Catch: Throwable -> L50
    L52:
        this.condition.await();     // Catch: Throwable -> L50
        goto L54
    L66:
        throw new InterruptedException("Operation interrupted");     // Catch: Throwable -> L50
    L21:
        this.available.remove(r18);     // Catch: Throwable -> L15
        this.leased.add(r18);     // Catch: Throwable -> L15
        onReuse(r18);     // Catch: Throwable -> L15
        this.lock.unlock();
        return r18;
    L15:
        th = move-exception;
        this.lock.unlock();
        throw th;
    L5:
        r15 = null;
        goto L6
    }

    private void purgePoolMap() {
        Iterator<Map.Entry<T, RouteSpecificPool<T, C, E>>> r10 = this.routeToPool.entrySet().iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        RouteSpecificPool<T, C, E> r11 = r10.next().getValue();
        if ((r11.getPendingCount() + r11.getAllocatedCount()) != 0) goto L4;
        r10.remove();
        goto L4
    }

    public void closeExpired() {
        final long r10 = System.currentTimeMillis();
        enumAvailable(new AnonymousClass4(this, r10));
    }

    public void closeIdle(long r10, TimeUnit r11) {
        Args.notNull(r11, "Time unit");
        long r12 = r11.toMillis(r10);
        if (r12 >= 0) goto L5;
        r12 = 0;
    L5:
        final long r13 = System.currentTimeMillis() - r12;
        enumAvailable(new AnonymousClass3(this, r13));
    }

    public abstract E createEntry(T r10, C r11);

    public void enumAvailable(PoolEntryCallback<T, C> r10) {
        this.lock.lock();
        Iterator<E> r11 = this.available.iterator();     // Catch: Throwable -> L9
    L5:
        if (r11.hasNext() == false) goto L11;
        E r12 = r11.next();     // Catch: Throwable -> L9
        r10.process(r12);     // Catch: Throwable -> L9
        if (r12.isClosed() == false) goto L5;
        getPool(r12.getRoute()).remove(r12);     // Catch: Throwable -> L9
        r11.remove();     // Catch: Throwable -> L9
        goto L5
    L11:
        purgePoolMap();     // Catch: Throwable -> L9
        this.lock.unlock();
        return;
    L9:
        th = move-exception;
        this.lock.unlock();
        throw th;
    }

    public void enumLeased(PoolEntryCallback<T, C> r10) {
        this.lock.lock();
        Iterator<E> r11 = this.leased.iterator();     // Catch: Throwable -> L8
    L5:
        if (r11.hasNext() == false) goto L10;
        r10.process(r11.next());     // Catch: Throwable -> L8
        goto L5
    L10:
        this.lock.unlock();
        return;
    L8:
        th = move-exception;
        this.lock.unlock();
        throw th;
    }

    @Override // org.apache.http.pool.ConnPoolControl
    public int getDefaultMaxPerRoute() {
        this.lock.lock();
        int r10 = this.defaultMaxPerRoute;     // Catch: Throwable -> L6
        this.lock.unlock();
        return r10;
    L6:
        th = move-exception;
        this.lock.unlock();
        throw th;
    }

    @Override // org.apache.http.pool.ConnPoolControl
    public int getMaxPerRoute(T r10) {
        Args.notNull(r10, "Route");
        this.lock.lock();
        int r11 = getMax(r10);     // Catch: Throwable -> L6
        this.lock.unlock();
        return r11;
    L6:
        th = move-exception;
        this.lock.unlock();
        throw th;
    }

    @Override // org.apache.http.pool.ConnPoolControl
    public int getMaxTotal() {
        this.lock.lock();
        int r10 = this.maxTotal;     // Catch: Throwable -> L6
        this.lock.unlock();
        return r10;
    L6:
        th = move-exception;
        this.lock.unlock();
        throw th;
    }

    public Set<T> getRoutes() {
        this.lock.lock();
        HashSet r10 = new HashSet(this.routeToPool.keySet());     // Catch: Throwable -> L6
        this.lock.unlock();
        return r10;
    L6:
        th = move-exception;
        this.lock.unlock();
        throw th;
    }

    @Override // org.apache.http.pool.ConnPoolControl
    public PoolStats getStats(T r10) {
        Args.notNull(r10, "Route");
        this.lock.lock();
        RouteSpecificPool<T, C, E> r11 = getPool(r10);     // Catch: Throwable -> L6
        PoolStats r12 = new PoolStats(r11.getLeasedCount(), r11.getPendingCount(), r11.getAvailableCount(), getMax(r10));     // Catch: Throwable -> L6
        this.lock.unlock();
        return r12;
    L6:
        th = move-exception;
        this.lock.unlock();
        throw th;
    }

    @Override // org.apache.http.pool.ConnPoolControl
    public PoolStats getTotalStats() {
        this.lock.lock();
        PoolStats r10 = new PoolStats(this.leased.size(), this.pending.size(), this.available.size(), this.maxTotal);     // Catch: Throwable -> L6
        this.lock.unlock();
        return r10;
    L6:
        th = move-exception;
        this.lock.unlock();
        throw th;
    }

    public int getValidateAfterInactivity() {
        return this.validateAfterInactivity;
    }

    public boolean isShutdown() {
        return this.isShutDown;
    }

    @Override // org.apache.http.pool.ConnPool
    public Future<E> lease(final T r10, final Object r11, final FutureCallback<E> r12) {
        Args.notNull(r10, "Route");
        Asserts.check(!this.isShutDown, "Connection pool shut down");
        return (Future<E>) new AnonymousClass2(this, r12, r10, r11);
    }

    public void onLease(E r10) {
    }

    public void onRelease(E r10) {
    }

    public void onReuse(E r10) {
    }

    @Override // org.apache.http.pool.ConnPool
    public /* bridge */ /* synthetic */ void release(Object r10, boolean r11) {
        release((PoolEntry) r10, r11);
    }

    @Override // org.apache.http.pool.ConnPoolControl
    public void setDefaultMaxPerRoute(int r10) {
        Args.positive(r10, "Max per route value");
        this.lock.lock();
        this.defaultMaxPerRoute = r10;     // Catch: Throwable -> L6
        this.lock.unlock();
        return;
    L6:
        th = move-exception;
        this.lock.unlock();
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [org.apache.http.pool.AbstractConnPool, org.apache.http.pool.AbstractConnPool<T, C, E extends org.apache.http.pool.PoolEntry<T, C>>] */
    /* JADX WARN: Type inference failed for: r1v1, types: [org.apache.http.pool.AbstractConnPool] */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.util.concurrent.locks.Lock] */
    @Override // org.apache.http.pool.ConnPoolControl
    public void setMaxPerRoute(T r10, int r11) {
        Args.notNull(r10, "Route");
        this.lock.lock();
        if (r11 <= (-1)) goto L7;
        this.maxPerRoute.put(r10, Integer.valueOf(r11));     // Catch: Throwable -> L5
    L8:
        AbstractConnPool<T, C, E> this = (AbstractConnPool<T, C, E>) this.lock;
        this.unlock();
        return;
    L7:
        this.maxPerRoute.remove(r10);     // Catch: Throwable -> L5
    L5:
        th = move-exception;
        this.lock.unlock();
        throw th;
    }

    @Override // org.apache.http.pool.ConnPoolControl
    public void setMaxTotal(int r10) {
        Args.positive(r10, "Max value");
        this.lock.lock();
        this.maxTotal = r10;     // Catch: Throwable -> L6
        this.lock.unlock();
        return;
    L6:
        th = move-exception;
        this.lock.unlock();
        throw th;
    }

    public void setValidateAfterInactivity(int r10) {
        this.validateAfterInactivity = r10;
    }

    public void shutdown() throws IOException {
        if (this.isShutDown == false) goto L5;
        return;
    L5:
        this.isShutDown = true;
        this.lock.lock();
        Iterator<E> r10 = this.available.iterator();     // Catch: Throwable -> L10
    L8:
        if (r10.hasNext() == false) goto L12;
        r10.next().close();     // Catch: Throwable -> L10
        goto L8
    L12:
        Iterator<E> r11 = this.leased.iterator();     // Catch: Throwable -> L10
    L14:
        if (r11.hasNext() == false) goto L16;
        r11.next().close();     // Catch: Throwable -> L10
        goto L14
    L16:
        Iterator<RouteSpecificPool<T, C, E>> r12 = this.routeToPool.values().iterator();     // Catch: Throwable -> L10
    L18:
        if (r12.hasNext() == false) goto L20;
        r12.next().shutdown();     // Catch: Throwable -> L10
        goto L18
    L20:
        this.routeToPool.clear();     // Catch: Throwable -> L10
        this.leased.clear();     // Catch: Throwable -> L10
        this.available.clear();     // Catch: Throwable -> L10
        this.lock.unlock();
        return;
    L10:
        th = move-exception;
        this.lock.unlock();
        throw th;
    }

    public String toString() {
        this.lock.lock();
        String r10 = "[leased: " + this.leased + "][available: " + this.available + "][pending: " + this.pending + "]";     // Catch: Throwable -> L6
        this.lock.unlock();
        return r10;
    L6:
        th = move-exception;
        this.lock.unlock();
        throw th;
    }

    public boolean validate(E r10) {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void release(E r10, boolean r11) {
        this.lock.lock();
    L10:
        th = move-exception;
        this.lock.unlock();
        throw th;
    L4:
        if (this.leased.remove(r10) == false) goto L19;
        RouteSpecificPool r12 = getPool(r10.getRoute());     // Catch: Throwable -> L10
        r12.free(r10, r11);     // Catch: Throwable -> L10
        if (r11 == true) goto L8;
    L12:
        r10.close();     // Catch: Throwable -> L10
    L13:
        onRelease(r10);     // Catch: Throwable -> L10
        Future<E> r13 = r12.nextPending();     // Catch: Throwable -> L10
        if (r13 == null) goto L16;
        this.pending.remove(r13);     // Catch: Throwable -> L10
    L17:
        if (r13 == null) goto L19;
        this.condition.signalAll();     // Catch: Throwable -> L10
        goto L19
    L16:
        r13 = this.pending.poll();     // Catch: Throwable -> L10
        goto L17
    L8:
        if (this.isShutDown == true) goto L12;
        this.available.addFirst(r10);     // Catch: Throwable -> L10
    L19:
        this.lock.unlock();
    }

    public Future<E> lease(T r10, Object r11) {
        return lease(r10, r11, null);
    }
}
