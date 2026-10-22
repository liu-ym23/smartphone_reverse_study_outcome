package androidx.room.coroutines;

import C7.f;
import C7.r;
import D6.i;
import H7.g;
import H7.h;
import J7.c;
import S7.n;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteDriver;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.b;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;
import m9.AbstractC1683A;
import m9.InterfaceC1733z;
import z2.l;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u0001\u001fB[\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012B\b\u0002\u0010\u000b\u001a<\b\u0001\u0012\u0018\u0012\u0016\b\u0001\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u0006j\b\u0012\u0002\b\u0003\u0018\u0001`\n¢\u0006\u0004\b\f\u0010\rJB\u0010\u0013\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u000e2\u0006\u0010\u0010\u001a\u00020\u000f2\"\u0010\u0012\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006H\u0096@¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0018R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0019RN\u0010\u000b\u001a<\b\u0001\u0012\u0018\u0012\u0016\b\u0001\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u0006j\b\u0012\u0002\b\u0003\u0018\u0001`\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u001aR\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006 "}, d2 = {"Landroidx/room/coroutines/PassthroughConnectionPool;", "Landroidx/room/coroutines/ConnectionPool;", "Landroidx/sqlite/SQLiteDriver;", "driver", "", "fileName", "Lkotlin/Function2;", "Lkotlin/Function1;", "LH7/c;", "", "Landroidx/room/coroutines/TransactionWrapper;", "transactionWrapper", AppAgent.CONSTRUCT, "(Landroidx/sqlite/SQLiteDriver;Ljava/lang/String;LS7/n;)V", "R", "", "isReadOnly", "Landroidx/room/Transactor;", "block", "useConnection", "(ZLS7/n;LH7/c;)Ljava/lang/Object;", "LC7/r;", "close", "()V", "Landroidx/sqlite/SQLiteDriver;", "Ljava/lang/String;", "LS7/n;", "LC7/f;", "Landroidx/sqlite/SQLiteConnection;", "connection", "LC7/f;", "ConnectionElement", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PassthroughConnectionPool implements ConnectionPool {
    private final f connection;
    private final SQLiteDriver driver;
    private final String fileName;
    private final n transactionWrapper;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00000\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Landroidx/room/coroutines/PassthroughConnectionPool$ConnectionElement;", "LH7/f;", "Landroidx/room/coroutines/PassthroughConnection;", "connectionWrapper", AppAgent.CONSTRUCT, "(Landroidx/room/coroutines/PassthroughConnection;)V", "Landroidx/room/coroutines/PassthroughConnection;", "getConnectionWrapper", "()Landroidx/room/coroutines/PassthroughConnection;", "LH7/g;", "getKey", "()LH7/g;", "key", "Key", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ConnectionElement implements H7.f {

        /* renamed from: Key, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final PassthroughConnection connectionWrapper;

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Landroidx/room/coroutines/PassthroughConnectionPool$ConnectionElement$Key;", "LH7/g;", "Landroidx/room/coroutines/PassthroughConnectionPool$ConnectionElement;", AppAgent.CONSTRUCT, "()V", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* renamed from: androidx.room.coroutines.PassthroughConnectionPool$ConnectionElement$Key, reason: from kotlin metadata */
        public static final class Companion implements g {
            public /* synthetic */ Companion(e eVar) {
                this();
            }

            private Companion() {
            }
        }

        public ConnectionElement(PassthroughConnection connectionWrapper) {
            k.f(connectionWrapper, "connectionWrapper");
            this.connectionWrapper = connectionWrapper;
        }

        @Override // H7.h
        public <R> R fold(R r5, n nVar) {
            return (R) l.w(this, r5, nVar);
        }

        @Override // H7.h
        public <E extends H7.f> E get(g gVar) {
            return (E) l.x(this, gVar);
        }

        public final PassthroughConnection getConnectionWrapper() {
            return this.connectionWrapper;
        }

        @Override // H7.f
        public g getKey() {
            return INSTANCE;
        }

        @Override // H7.h
        public h minusKey(g gVar) {
            return l.C(this, gVar);
        }

        @Override // H7.h
        public h plus(h hVar) {
            return l.H(this, hVar);
        }
    }

    @c(c = "androidx.room.coroutines.PassthroughConnectionPool$useConnection$2", f = "PassthroughConnectionPool.kt", l = {59}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\n"}, d2 = {"R", "Lm9/z;", "<anonymous>"}, k = 3, mv = {2, 1, 0})
    /* renamed from: androidx.room.coroutines.PassthroughConnectionPool$useConnection$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements n {
        final /* synthetic */ n $block;
        final /* synthetic */ PassthroughConnection $connectionWrapper;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(n nVar, PassthroughConnection passthroughConnection, H7.c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$block = nVar;
            this.$connectionWrapper = passthroughConnection;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new AnonymousClass2(this.$block, this.$connectionWrapper, cVar);
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
            PassthroughConnection passthroughConnection = this.$connectionWrapper;
            this.label = 1;
            Object objInvoke = nVar.invoke(passthroughConnection, this);
            return objInvoke == coroutineSingletons ? coroutineSingletons : objInvoke;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super R> cVar) {
            return ((AnonymousClass2) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    public PassthroughConnectionPool(SQLiteDriver driver, String fileName, n nVar) {
        k.f(driver, "driver");
        k.f(fileName, "fileName");
        this.driver = driver;
        this.fileName = fileName;
        this.transactionWrapper = nVar;
        this.connection = kotlin.a.a(new i(this, 14));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SQLiteConnection connection$lambda$0(PassthroughConnectionPool passthroughConnectionPool) {
        return passthroughConnectionPool.driver.open(passthroughConnectionPool.fileName);
    }

    @Override // androidx.room.coroutines.ConnectionPool, java.lang.AutoCloseable
    public void close() {
        if (this.connection.isInitialized()) {
            ((SQLiteConnection) this.connection.getF4884a()).close();
        }
    }

    @Override // androidx.room.coroutines.ConnectionPool
    public <R> Object useConnection(boolean z10, n nVar, H7.c<? super R> cVar) {
        ConnectionElement connectionElement = (ConnectionElement) cVar.getContext().get(ConnectionElement.INSTANCE);
        PassthroughConnection connectionWrapper = connectionElement != null ? connectionElement.getConnectionWrapper() : null;
        if (connectionWrapper != null) {
            return nVar.invoke(connectionWrapper, cVar);
        }
        PassthroughConnection passthroughConnection = new PassthroughConnection(this.transactionWrapper, (SQLiteConnection) this.connection.getF4884a());
        return AbstractC1683A.w(new ConnectionElement(passthroughConnection), new AnonymousClass2(nVar, passthroughConnection, null), cVar);
    }

    public /* synthetic */ PassthroughConnectionPool(SQLiteDriver sQLiteDriver, String str, n nVar, int i, e eVar) {
        this(sQLiteDriver, str, (i & 4) != 0 ? null : nVar);
    }
}
