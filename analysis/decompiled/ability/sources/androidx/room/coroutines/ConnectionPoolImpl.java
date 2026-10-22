package androidx.room.coroutines;

import C7.r;
import H7.h;
import J7.c;
import S7.n;
import android.database.SQLException;
import androidx.compose.material3.MenuKt;
import androidx.room.concurrent.ThreadLocal_jvmAndroidKt;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteDriver;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.taskrobot.llmapi.stepfun.InjectExperienceResult;
import java.util.concurrent.atomic.AtomicBoolean;
import k9.C1650a;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.b;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.k;
import kotlin.time.DurationUnit;
import m9.InterfaceC1733z;
import z2.l;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0000\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B)\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b¢\u0006\u0004\b\u0006\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0014\u0010\u0015JB\u0010\u001c\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00162\u0006\u0010\u0012\u001a\u00020\u00112\"\u0010\u001b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0017H\u0096@¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u001e\u0010\u001fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010 R\u0014\u0010\"\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010#R\u0014\u0010&\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R$\u0010*\u001a\u0012\u0012\u0004\u0012\u00020\f0(j\b\u0012\u0004\u0012\u00020\f`)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0018\u0010.\u001a\u00060,j\u0002`-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\"\u00101\u001a\u0002008\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\"\u0010\u0014\u001a\u00020\b8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0014\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u0014\u0010<\u001a\u00020\u00118BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b<\u0010=¨\u0006>"}, d2 = {"Landroidx/room/coroutines/ConnectionPoolImpl;", "Landroidx/room/coroutines/ConnectionPool;", "Landroidx/sqlite/SQLiteDriver;", "driver", "", "fileName", AppAgent.CONSTRUCT, "(Landroidx/sqlite/SQLiteDriver;Ljava/lang/String;)V", "", "maxNumOfReaders", "maxNumOfWriters", "(Landroidx/sqlite/SQLiteDriver;Ljava/lang/String;II)V", "Landroidx/room/coroutines/PooledConnectionImpl;", "connection", "LH7/h;", "createConnectionContext", "(Landroidx/room/coroutines/PooledConnectionImpl;)LH7/h;", "", "isReadOnly", "LC7/r;", "onTimeout", "(Z)V", "R", "Lkotlin/Function2;", "Landroidx/room/Transactor;", "LH7/c;", "", "block", "useConnection", "(ZLS7/n;LH7/c;)Ljava/lang/Object;", "close", "()V", "Landroidx/sqlite/SQLiteDriver;", "Landroidx/room/coroutines/Pool;", "readers", "Landroidx/room/coroutines/Pool;", "writers", "Landroidx/room/coroutines/ConnectionElementKey;", "connectionElementKey", "Landroidx/room/coroutines/ConnectionElementKey;", "Ljava/lang/ThreadLocal;", "Landroidx/room/concurrent/ThreadLocal;", "connectionThreadLocal", "Ljava/lang/ThreadLocal;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Landroidx/room/concurrent/AtomicBoolean;", "_isClosed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Lk9/a;", InjectExperienceResult.REASON_TIMEOUT, "J", "getTimeout-UwyO8pc$room_runtime", "()J", "setTimeout-LRDsOJo$room_runtime", "(J)V", "I", "getOnTimeout$room_runtime", "()I", "setOnTimeout$room_runtime", "(I)V", "isClosed", "()Z", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ConnectionPoolImpl implements ConnectionPool {
    private final AtomicBoolean _isClosed;
    private final ConnectionElementKey connectionElementKey;
    private final ThreadLocal<PooledConnectionImpl> connectionThreadLocal;
    private final SQLiteDriver driver;
    private int onTimeout;
    private final Pool readers;
    private long timeout;
    private final Pool writers;

    @c(c = "androidx.room.coroutines.ConnectionPoolImpl", f = "ConnectionPoolImpl.kt", l = {MenuKt.InTransitionDuration, 124, 143, 148}, m = "useConnection")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: androidx.room.coroutines.ConnectionPoolImpl$useConnection$1, reason: invalid class name */
    public static final class AnonymousClass1<R> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(H7.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ConnectionPoolImpl.this.useConnection(false, null, this);
        }
    }

    @c(c = "androidx.room.coroutines.ConnectionPoolImpl$useConnection$2", f = "ConnectionPoolImpl.kt", l = {121}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\n"}, d2 = {"R", "Lm9/z;", "<anonymous>"}, k = 3, mv = {2, 1, 0})
    /* renamed from: androidx.room.coroutines.ConnectionPoolImpl$useConnection$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements n {
        final /* synthetic */ n $block;
        final /* synthetic */ PooledConnectionImpl $confinedConnection;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(n nVar, PooledConnectionImpl pooledConnectionImpl, H7.c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$block = nVar;
            this.$confinedConnection = pooledConnectionImpl;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new AnonymousClass2(this.$block, this.$confinedConnection, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                b.b(obj);
                return obj;
            }
            b.b(obj);
            n nVar = this.$block;
            PooledConnectionImpl pooledConnectionImpl = this.$confinedConnection;
            this.label = 1;
            Object objInvoke = nVar.invoke(pooledConnectionImpl, this);
            return objInvoke == coroutineSingletons ? coroutineSingletons : objInvoke;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super R> cVar) {
            return ((AnonymousClass2) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @c(c = "androidx.room.coroutines.ConnectionPoolImpl$useConnection$4", f = "ConnectionPoolImpl.kt", l = {148}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\n"}, d2 = {"R", "Lm9/z;", "<anonymous>"}, k = 3, mv = {2, 1, 0})
    /* renamed from: androidx.room.coroutines.ConnectionPoolImpl$useConnection$4, reason: invalid class name */
    public static final class AnonymousClass4 extends SuspendLambda implements n {
        final /* synthetic */ n $block;
        final /* synthetic */ Ref$ObjectRef<PooledConnectionImpl> $connection;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(n nVar, Ref$ObjectRef<PooledConnectionImpl> ref$ObjectRef, H7.c<? super AnonymousClass4> cVar) {
            super(2, cVar);
            this.$block = nVar;
            this.$connection = ref$ObjectRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new AnonymousClass4(this.$block, this.$connection, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                b.b(obj);
                return obj;
            }
            b.b(obj);
            n nVar = this.$block;
            Object obj2 = this.$connection.f4920a;
            this.label = 1;
            Object objInvoke = nVar.invoke(obj2, this);
            return objInvoke == coroutineSingletons ? coroutineSingletons : objInvoke;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super R> cVar) {
            return ((AnonymousClass4) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    public ConnectionPoolImpl(final SQLiteDriver driver, final String fileName) {
        k.f(driver, "driver");
        k.f(fileName, "fileName");
        this.connectionElementKey = new ConnectionElementKey();
        this.connectionThreadLocal = new ThreadLocal<>();
        this._isClosed = new AtomicBoolean(false);
        int i = C1650a.d;
        this.timeout = l.I(30, DurationUnit.d);
        final int i6 = 2;
        this.onTimeout = 2;
        this.driver = driver;
        Pool pool = new Pool(1, new S7.a() { // from class: androidx.room.coroutines.a
            @Override // S7.a
            public final Object invoke() {
                switch (i6) {
                }
                return driver.open(fileName);
            }
        });
        this.readers = pool;
        this.writers = pool;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SQLiteConnection _init_$lambda$4(SQLiteDriver sQLiteDriver, String str) {
        SQLiteConnection sQLiteConnectionOpen = sQLiteDriver.open(str);
        SQLite.execSQL(sQLiteConnectionOpen, "PRAGMA query_only = 1");
        return sQLiteConnectionOpen;
    }

    private final h createConnectionContext(PooledConnectionImpl connection) {
        return new ConnectionElement(this.connectionElementKey, connection).plus(ThreadLocal_jvmAndroidKt.asContextElement(this.connectionThreadLocal, connection));
    }

    private final boolean isClosed() {
        return this._isClosed.get();
    }

    private final void onTimeout(boolean isReadOnly) {
        String str = isReadOnly ? "reader" : "writer";
        StringBuilder sb = new StringBuilder();
        sb.append("Timed out attempting to acquire a " + str + " connection.");
        sb.append("\n\nWriter pool:\n");
        this.writers.dump(sb);
        sb.append("Reader pool:");
        sb.append('\n');
        this.readers.dump(sb);
        try {
            SQLite.throwSQLiteException(5, sb.toString());
            throw new KotlinNothingValueException();
        } catch (SQLException e) {
            int i = this.onTimeout;
            if (i == 1) {
                throw e;
            }
            if (i != 2) {
                return;
            }
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r useConnection$lambda$6(ConnectionPoolImpl connectionPoolImpl, boolean z10) {
        connectionPoolImpl.onTimeout(z10);
        return r.f317a;
    }

    @Override // androidx.room.coroutines.ConnectionPool, java.lang.AutoCloseable
    public void close() {
        if (this._isClosed.compareAndSet(false, true)) {
            this.readers.close();
            this.writers.close();
        }
    }

    /* renamed from: getOnTimeout$room_runtime, reason: from getter */
    public final int getOnTimeout() {
        return this.onTimeout;
    }

    /* renamed from: getTimeout-UwyO8pc$room_runtime, reason: not valid java name and from getter */
    public final long getTimeout() {
        return this.timeout;
    }

    public final void setOnTimeout$room_runtime(int i) {
        this.onTimeout = i;
    }

    /* renamed from: setTimeout-LRDsOJo$room_runtime, reason: not valid java name */
    public final void m7166setTimeoutLRDsOJo$room_runtime(long j5) {
        this.timeout = j5;
    }

    /* JADX WARN: Removed duplicated region for block: B:71:0x013a A[Catch: all -> 0x0174, TRY_LEAVE, TryCatch #1 {all -> 0x0174, blocks: (B:64:0x011e, B:69:0x012f, B:71:0x013a, B:81:0x0178, B:82:0x017f), top: B:99:0x011e }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0178 A[Catch: all -> 0x0174, TRY_ENTER, TryCatch #1 {all -> 0x0174, blocks: (B:64:0x011e, B:69:0x012f, B:71:0x013a, B:81:0x0178, B:82:0x017f), top: B:99:0x011e }] */
    @Override // androidx.room.coroutines.ConnectionPool
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public <R> java.lang.Object useConnection(boolean r18, S7.n r19, H7.c<? super R> r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 428
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.coroutines.ConnectionPoolImpl.useConnection(boolean, S7.n, H7.c):java.lang.Object");
    }

    public ConnectionPoolImpl(final SQLiteDriver driver, final String fileName, int i, int i6) {
        k.f(driver, "driver");
        k.f(fileName, "fileName");
        this.connectionElementKey = new ConnectionElementKey();
        this.connectionThreadLocal = new ThreadLocal<>();
        final int i10 = 0;
        this._isClosed = new AtomicBoolean(false);
        int i11 = C1650a.d;
        this.timeout = l.I(30, DurationUnit.d);
        this.onTimeout = 2;
        if (i <= 0) {
            throw new IllegalArgumentException("Maximum number of readers must be greater than 0");
        }
        if (i6 > 0) {
            this.driver = driver;
            this.readers = new Pool(i, new S7.a() { // from class: androidx.room.coroutines.a
                @Override // S7.a
                public final Object invoke() {
                    switch (i10) {
                    }
                    return driver.open(fileName);
                }
            });
            final int i12 = 1;
            this.writers = new Pool(i6, new S7.a() { // from class: androidx.room.coroutines.a
                @Override // S7.a
                public final Object invoke() {
                    switch (i12) {
                    }
                    return driver.open(fileName);
                }
            });
            return;
        }
        throw new IllegalArgumentException("Maximum number of writers must be greater than 0");
    }
}
