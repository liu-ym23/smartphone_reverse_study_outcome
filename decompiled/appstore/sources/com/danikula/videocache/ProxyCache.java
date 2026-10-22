package com.danikula.videocache;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
class ProxyCache {
    private static final int MAX_READ_SOURCE_ATTEMPTS = 1;
    private final Cache cache;
    private volatile int percentsAvailable;
    private final AtomicInteger readSourceErrorsCount;
    private final Source source;
    private volatile Thread sourceReaderThread;
    private final Object stopLock;
    private volatile boolean stopped;

    /* JADX INFO: renamed from: wc, reason: collision with root package name */
    private final Object f10260wc;

    /* JADX INFO: renamed from: com.danikula.videocache.ProxyCache$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public class SourceReaderRunnable implements Runnable {
        final /* synthetic */ ProxyCache this$0;

        private SourceReaderRunnable(ProxyCache r10) {
            this.this$0 = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            ProxyCache.access$100(this.this$0);
        }

        public /* synthetic */ SourceReaderRunnable(ProxyCache r10, AnonymousClass1 r11) {
            this(r10);
        }
    }

    public ProxyCache(Source r10, Cache r11) {
        this.f10260wc = new Object();
        this.stopLock = new Object();
        this.percentsAvailable = -1;
        this.source = (Source) Preconditions.checkNotNull(r10);
        this.cache = (Cache) Preconditions.checkNotNull(r11);
        this.readSourceErrorsCount = new AtomicInteger();
    }

    public static /* synthetic */ void access$100(ProxyCache r10) {
        r10.readSource();
    }

    private void checkReadSourceErrorsCount() throws ProxyCacheException {
        int r10 = this.readSourceErrorsCount.get();
        if (r10 >= 1) goto L5;
        return;
    L5:
        this.readSourceErrorsCount.set(0);
        throw new ProxyCacheException("Error reading source " + r10 + " times");
    }

    private void closeSource() {
        this.source.close();     // Catch: ProxyCacheException -> L4
        return;
    L4:
        e = move-exception;
        onError(new ProxyCacheException("Error closing source " + this.source, e));
    }

    private boolean isStopped() {
        if (Thread.currentThread().isInterrupted() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.stopped == true) goto L8;
        return false;
    }

    private void notifyNewCacheDataAvailable(long r10, long r11) {
        onCacheAvailable(r10, r11);
        Object r12 = this.f10260wc;
        monitor-enter(r12);
        this.f10260wc.notifyAll();     // Catch: Throwable -> L7
        monitor-exit(r12);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void onSourceRead() {
        this.percentsAvailable = 100;
        onCachePercentsAvailableChanged(this.percentsAvailable);
    }

    private void readSource() {
        long r10 = -1;
        long r11 = 0;
        r11 = this.cache.available();     // Catch: Throwable -> L20
        this.source.open(r11);     // Catch: Throwable -> L20
        r10 = this.source.length();     // Catch: Throwable -> L20
        byte[] r12 = new byte[8192];     // Catch: Throwable -> L20
    L4:
        int r13 = this.source.read(r12);     // Catch: Throwable -> L20
        if (r13 == (-1)) goto L24;
        Object r14 = this.stopLock;     // Catch: Throwable -> L20
        monitor-enter(r14);     // Catch: Throwable -> L20
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    L9:
        if (isStopped() == true) goto L10;
        this.cache.append(r12, r13);     // Catch: Throwable -> L13
        monitor-exit(r14);     // Catch: Throwable -> L13
        r11 = r11 + ((long) r13);
        notifyNewCacheDataAvailable(r11, r10);     // Catch: Throwable -> L20
        goto L4
    L10:
        monitor-exit(r14);     // Catch: Throwable -> L13
        closeSource();
        notifyNewCacheDataAvailable(r11, r10);
        return;
    L24:
        tryComplete();     // Catch: Throwable -> L20
        onSourceRead();     // Catch: Throwable -> L20
    L25:
        closeSource();
        notifyNewCacheDataAvailable(r11, r10);
        return;
    L20:
        th = move-exception;
        this.readSourceErrorsCount.incrementAndGet();     // Catch: Throwable -> L29
        onError(th);     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        closeSource();
        notifyNewCacheDataAvailable(r11, r10);
        throw th;
    }

    private synchronized void readSourceAsync() throws ProxyCacheException {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.sourceReaderThread != null) goto L6;
    L10:
        boolean r10 = false;
    L12:
        if (this.stopped == false) goto L14;
    L17:
        monitor-exit(this);
        return;
    L14:
        if (this.cache.isCompleted() == true) goto L17;
        if (r10 == true) goto L17;
        this.sourceReaderThread = new Thread(new SourceReaderRunnable(this, null), "Source reader for " + this.source);     // Catch: Throwable -> L8
        this.sourceReaderThread.start();     // Catch: Throwable -> L8
        goto L17
    L6:
        if (this.sourceReaderThread.getState() == Thread.State.TERMINATED) goto L10;
        r10 = true;
        goto L12
    }

    private void tryComplete() throws ProxyCacheException {
        Object r10 = this.stopLock;
        monitor-enter(r10);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (isStopped() == false) goto L7;
    L11:
        monitor-exit(r10);     // Catch: Throwable -> L9
        return;
    L7:
        if (this.cache.available() != this.source.length()) goto L11;
        this.cache.complete();     // Catch: Throwable -> L9
        goto L11
    }

    private void waitForSourceData() throws ProxyCacheException {
        Object r10 = this.f10260wc;
        monitor-enter(r10);
        this.f10260wc.wait(1000);     // Catch: Throwable -> L7 InterruptedException -> L9
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L9:
        e = move-exception;
        throw new ProxyCacheException("Waiting source data is interrupted!", e);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    public void onCacheAvailable(long r10, long r11) {
        if (r11 != 0) goto L5;
        int r12 = 100;
    L7:
        if (r12 == this.percentsAvailable) goto L9;
        boolean r13 = true;
    L10:
        if (r11 < 0) goto L13;
        if (r13 == false) goto L13;
        onCachePercentsAvailableChanged(r12);
    L13:
        this.percentsAvailable = r12;
        return;
    L9:
        r13 = false;
        goto L10
    L5:
        r12 = (int) ((r10 / r11) * 100.0f);
        goto L7
    }

    public void onCachePercentsAvailableChanged(int r10) {
    }

    public final void onError(Throwable r10) {
        if ((r10 instanceof InterruptedProxyCacheException) == false) goto L5;
        KLog.d("ProxyCache is interrupted");
        return;
    L5:
        KLog.e("ProxyCache error", new Object[]{r10});
    }

    public int read(byte[] r10, long r11, int r12) throws ProxyCacheException {
        ProxyCacheUtils.assertBuffer(r10, r11, r12);
    L4:
        if (this.cache.isCompleted() == true) goto L10;
        if (this.cache.available() >= (((long) r12) + r11)) goto L10;
        if (this.stopped == true) goto L10;
        readSourceAsync();
        waitForSourceData();
        checkReadSourceErrorsCount();
    L10:
        int r13 = this.cache.read(r10, r11, r12);
        if (this.cache.isCompleted() == true) goto L13;
    L15:
        return r13;
    L13:
        if (this.percentsAvailable == 100) goto L15;
        this.percentsAvailable = 100;
        onCachePercentsAvailableChanged(100);
        goto L15
    }

    public void shutdown() {
        Object r10 = this.stopLock;
        monitor-enter(r10);
        KLog.d("Shutdown proxy for " + this.source);     // Catch: Throwable -> L9
        this.stopped = true;     // Catch: Throwable -> L9 ProxyCacheException -> L11
        if (this.sourceReaderThread == null) goto L13;
        this.sourceReaderThread.interrupt();     // Catch: Throwable -> L9 ProxyCacheException -> L11
    L13:
        this.cache.close();     // Catch: Throwable -> L9 ProxyCacheException -> L11
    L16:
        monitor-exit(r10);     // Catch: Throwable -> L9
        return;
    L11:
        e = move-exception;
        onError(e);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }
}
