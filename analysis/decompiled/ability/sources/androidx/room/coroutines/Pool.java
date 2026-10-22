package androidx.room.coroutines;

import D7.v;
import H4.o;
import J7.c;
import androidx.collection.CircularArray;
import androidx.sqlite.SQLiteConnection;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.taskrobot.llmapi.stepfun.InjectExperienceResult;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.collections.builders.ListBuilder;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.k;
import kotlinx.coroutines.sync.b;
import w9.e;
import w9.f;
import w9.g;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ&\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\u0004H\u0086@¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u000fH\u0086@¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u000f¢\u0006\u0004\b\u0016\u0010\u0017J\r\u0010\u0018\u001a\u00020\t¢\u0006\u0004\b\u0018\u0010\u000bJ\u0019\u0010\u001c\u001a\u00020\t2\n\u0010\u001b\u001a\u00060\u0019j\u0002`\u001a¢\u0006\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010!\u001a\u0004\b\"\u0010#R\u0018\u0010&\u001a\u00060$j\u0002`%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010(\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010\u001eR\u0016\u0010*\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u001c\u0010-\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0014\u00100\u001a\u00020/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u001a\u00103\u001a\b\u0012\u0004\u0012\u00020\u000f028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104¨\u00065"}, d2 = {"Landroidx/room/coroutines/Pool;", "", "", "capacity", "Lkotlin/Function0;", "Landroidx/sqlite/SQLiteConnection;", "connectionFactory", AppAgent.CONSTRUCT, "(ILS7/a;)V", "LC7/r;", "tryOpenNewConnectionLocked", "()V", "Lk9/a;", InjectExperienceResult.REASON_TIMEOUT, "onTimeout", "Landroidx/room/coroutines/ConnectionWithLock;", "acquireWithTimeout-KLykuaI", "(JLS7/a;LH7/c;)Ljava/lang/Object;", "acquireWithTimeout", "acquire", "(LH7/c;)Ljava/lang/Object;", "connection", "recycle", "(Landroidx/room/coroutines/ConnectionWithLock;)V", "close", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "builder", "dump", "(Ljava/lang/StringBuilder;)V", "I", "getCapacity", "()I", "LS7/a;", "getConnectionFactory", "()LS7/a;", "Ljava/util/concurrent/locks/ReentrantLock;", "Landroidx/room/concurrent/ReentrantLock;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "size", "", "isClosed", "Z", "", "connections", "[Landroidx/room/coroutines/ConnectionWithLock;", "Lw9/e;", "connectionPermits", "Lw9/e;", "Landroidx/collection/CircularArray;", "availableConnections", "Landroidx/collection/CircularArray;", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
final class Pool {
    private final CircularArray<ConnectionWithLock> availableConnections;
    private final int capacity;
    private final S7.a connectionFactory;
    private final e connectionPermits;
    private final ConnectionWithLock[] connections;
    private boolean isClosed;
    private final ReentrantLock lock;
    private int size;

    @c(c = "androidx.room.coroutines.Pool", f = "ConnectionPoolImpl.kt", l = {236}, m = "acquire")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: androidx.room.coroutines.Pool$acquire$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(H7.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Pool.this.acquire(this);
        }
    }

    public Pool(int i, S7.a connectionFactory) {
        k.f(connectionFactory, "connectionFactory");
        this.capacity = i;
        this.connectionFactory = connectionFactory;
        this.lock = new ReentrantLock();
        this.connections = new ConnectionWithLock[i];
        int i6 = g.f6856a;
        this.connectionPermits = new f(i);
        this.availableConnections = new CircularArray<>(i);
    }

    private final void tryOpenNewConnectionLocked() {
        if (this.size >= this.capacity) {
            return;
        }
        ConnectionWithLock connectionWithLock = new ConnectionWithLock((SQLiteConnection) this.connectionFactory.invoke(), null, 2, null);
        ConnectionWithLock[] connectionWithLockArr = this.connections;
        int i = this.size;
        this.size = i + 1;
        connectionWithLockArr[i] = connectionWithLock;
        this.availableConnections.addLast(connectionWithLock);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object acquire(H7.c<? super androidx.room.coroutines.ConnectionWithLock> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof androidx.room.coroutines.Pool.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r5
            androidx.room.coroutines.Pool$acquire$1 r0 = (androidx.room.coroutines.Pool.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.room.coroutines.Pool$acquire$1 r0 = new androidx.room.coroutines.Pool$acquire$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            kotlin.b.b(r5)
            goto L3f
        L27:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L2f:
            kotlin.b.b(r5)
            w9.e r5 = r4.connectionPermits
            r0.label = r3
            kotlinx.coroutines.sync.b r5 = (kotlinx.coroutines.sync.b) r5
            java.lang.Object r5 = r5.a(r0)
            if (r5 != r1) goto L3f
            return r1
        L3f:
            java.util.concurrent.locks.ReentrantLock r5 = r4.lock     // Catch: java.lang.Throwable -> L62
            r5.lock()     // Catch: java.lang.Throwable -> L62
            boolean r0 = r4.isClosed     // Catch: java.lang.Throwable -> L54
            if (r0 != 0) goto L64
            androidx.collection.CircularArray<androidx.room.coroutines.ConnectionWithLock> r0 = r4.availableConnections     // Catch: java.lang.Throwable -> L54
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L54
            if (r0 == 0) goto L56
            r4.tryOpenNewConnectionLocked()     // Catch: java.lang.Throwable -> L54
            goto L56
        L54:
            r0 = move-exception
            goto L71
        L56:
            androidx.collection.CircularArray<androidx.room.coroutines.ConnectionWithLock> r0 = r4.availableConnections     // Catch: java.lang.Throwable -> L54
            java.lang.Object r0 = r0.popFirst()     // Catch: java.lang.Throwable -> L54
            androidx.room.coroutines.ConnectionWithLock r0 = (androidx.room.coroutines.ConnectionWithLock) r0     // Catch: java.lang.Throwable -> L54
            r5.unlock()     // Catch: java.lang.Throwable -> L62
            return r0
        L62:
            r5 = move-exception
            goto L75
        L64:
            java.lang.String r0 = "Connection pool is closed"
            r1 = 21
            androidx.sqlite.SQLite.throwSQLiteException(r1, r0)     // Catch: java.lang.Throwable -> L54
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException     // Catch: java.lang.Throwable -> L54
            r0.<init>()     // Catch: java.lang.Throwable -> L54
            throw r0     // Catch: java.lang.Throwable -> L54
        L71:
            r5.unlock()     // Catch: java.lang.Throwable -> L62
            throw r0     // Catch: java.lang.Throwable -> L62
        L75:
            w9.e r4 = r4.connectionPermits
            kotlinx.coroutines.sync.b r4 = (kotlinx.coroutines.sync.b) r4
            r4.c()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.coroutines.Pool.acquire(H7.c):java.lang.Object");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:11|44|12|24|46|29|(1:(1:39)(2:35|(1:37)))(1:31)|38|19|48|20|(1:22)(10:23|24|46|29|(0)(0)|38|19|48|20|(0)(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0068, code lost:
    
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x006a, code lost:
    
        r12 = r12;
        r11 = r11;
        r2 = r0;
        r0 = r2;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0073 A[Catch: all -> 0x0077, TryCatch #1 {all -> 0x0077, blocks: (B:29:0x006f, B:31:0x0073, B:35:0x007b, B:39:0x0082), top: B:46:0x006f }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x005c -> B:24:0x005e). Please report as a decompilation issue!!! */
    /* renamed from: acquireWithTimeout-KLykuaI, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m7167acquireWithTimeoutKLykuaI(long r9, S7.a r11, H7.c<? super androidx.room.coroutines.ConnectionWithLock> r12) {
        /*
            r8 = this;
            boolean r0 = r12 instanceof androidx.room.coroutines.Pool$acquireWithTimeout$1
            if (r0 == 0) goto L13
            r0 = r12
            androidx.room.coroutines.Pool$acquireWithTimeout$1 r0 = (androidx.room.coroutines.Pool$acquireWithTimeout$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.room.coroutines.Pool$acquireWithTimeout$1 r0 = new androidx.room.coroutines.Pool$acquireWithTimeout$1
            r0.<init>(r8, r12)
        L18:
            java.lang.Object r12 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            long r9 = r0.J$0
            java.lang.Object r11 = r0.L$1
            kotlin.jvm.internal.Ref$ObjectRef r11 = (kotlin.jvm.internal.Ref$ObjectRef) r11
            java.lang.Object r2 = r0.L$0
            S7.a r2 = (S7.a) r2
            kotlin.b.b(r12)     // Catch: java.lang.Throwable -> L32
            goto L5e
        L32:
            r12 = move-exception
            goto L6a
        L34:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3c:
            kotlin.b.b(r12)
        L3f:
            kotlin.jvm.internal.Ref$ObjectRef r12 = new kotlin.jvm.internal.Ref$ObjectRef
            r12.<init>()
            androidx.room.coroutines.Pool$acquireWithTimeout$2 r2 = new androidx.room.coroutines.Pool$acquireWithTimeout$2     // Catch: java.lang.Throwable -> L68
            r2.<init>(r12, r8, r4)     // Catch: java.lang.Throwable -> L68
            r0.L$0 = r11     // Catch: java.lang.Throwable -> L68
            r0.L$1 = r12     // Catch: java.lang.Throwable -> L68
            r0.J$0 = r9     // Catch: java.lang.Throwable -> L68
            r0.label = r3     // Catch: java.lang.Throwable -> L68
            long r5 = kotlinx.coroutines.a.n(r9)     // Catch: java.lang.Throwable -> L68
            java.lang.Object r2 = kotlinx.coroutines.a.o(r5, r2, r0)     // Catch: java.lang.Throwable -> L68
            if (r2 != r1) goto L5c
            return r1
        L5c:
            r2 = r11
            r11 = r12
        L5e:
            r12 = r11
            r11 = r2
            r2 = r0
            r0 = r4
            goto L6f
        L63:
            r7 = r2
            r2 = r11
            r11 = r12
            r12 = r7
            goto L6a
        L68:
            r2 = move-exception
            goto L63
        L6a:
            r7 = r12
            r12 = r11
            r11 = r2
            r2 = r0
            r0 = r7
        L6f:
            boolean r5 = r0 instanceof kotlinx.coroutines.TimeoutCancellationException     // Catch: java.lang.Throwable -> L77
            if (r5 == 0) goto L79
            r11.invoke()     // Catch: java.lang.Throwable -> L77
            goto L80
        L77:
            r9 = move-exception
            goto L83
        L79:
            if (r0 != 0) goto L82
            java.lang.Object r12 = r12.f4920a     // Catch: java.lang.Throwable -> L77
            if (r12 == 0) goto L80
            return r12
        L80:
            r0 = r2
            goto L3f
        L82:
            throw r0     // Catch: java.lang.Throwable -> L77
        L83:
            java.lang.Object r10 = r12.f4920a
            androidx.room.coroutines.ConnectionWithLock r10 = (androidx.room.coroutines.ConnectionWithLock) r10
            if (r10 == 0) goto L8c
            r8.recycle(r10)
        L8c:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.coroutines.Pool.m7167acquireWithTimeoutKLykuaI(long, S7.a, H7.c):java.lang.Object");
    }

    public final void close() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            this.isClosed = true;
            for (ConnectionWithLock connectionWithLock : this.connections) {
                if (connectionWithLock != null) {
                    connectionWithLock.close();
                }
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void dump(StringBuilder builder) {
        k.f(builder, "builder");
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            ListBuilder listBuilderY = o.y();
            int size = this.availableConnections.size();
            for (int i = 0; i < size; i++) {
                listBuilderY.add(this.availableConnections.get(i));
            }
            ListBuilder listBuilderQ = o.q(listBuilderY);
            builder.append('\t' + toString() + " (");
            builder.append("capacity=" + this.capacity + ", ");
            StringBuilder sb = new StringBuilder();
            sb.append("permits=");
            b bVar = (b) this.connectionPermits;
            bVar.getClass();
            sb.append(Math.max(b.g.get(bVar), 0));
            sb.append(", ");
            builder.append(sb.toString());
            builder.append("queue=(size=" + listBuilderQ.size() + ")[" + v.I0(listBuilderQ, null, null, null, null, 63) + ']');
            builder.append(")");
            builder.append('\n');
            ConnectionWithLock[] connectionWithLockArr = this.connections;
            int length = connectionWithLockArr.length;
            int i6 = 0;
            for (int i10 = 0; i10 < length; i10++) {
                ConnectionWithLock connectionWithLock = connectionWithLockArr[i10];
                i6++;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("\t\t[");
                sb2.append(i6);
                sb2.append("] - ");
                sb2.append(connectionWithLock != null ? connectionWithLock.toString() : null);
                builder.append(sb2.toString());
                builder.append('\n');
                if (connectionWithLock != null) {
                    connectionWithLock.dump(builder);
                }
            }
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final int getCapacity() {
        return this.capacity;
    }

    public final S7.a getConnectionFactory() {
        return this.connectionFactory;
    }

    public final void recycle(ConnectionWithLock connection) {
        k.f(connection, "connection");
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            this.availableConnections.addLast(connection);
            reentrantLock.unlock();
            ((b) this.connectionPermits).c();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }
}
