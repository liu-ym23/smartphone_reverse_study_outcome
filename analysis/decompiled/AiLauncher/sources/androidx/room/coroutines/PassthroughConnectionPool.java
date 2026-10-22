package androidx.room.coroutines;

import Ua.C1056g;
import Y8.h;
import androidx.room.Transactor;
import androidx.room.coroutines.PassthroughConnectionPool;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import i1.InterfaceC4160b;
import i1.InterfaceC4161c;
import kotlin.C4848b;
import kotlin.Metadata;
import kotlin.coroutines.d;
import kotlin.jvm.internal.i;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import p9.p;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0018B[\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012B\b\u0002\u0010\u000b\u001a<\b\u0001\u0012\u0018\u0012\u0016\b\u0001\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u0006j\b\u0012\u0002\b\u0003\u0018\u0001`\n¢\u0006\u0004\b\f\u0010\rJB\u0010\u0013\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u000e2\u0006\u0010\u0010\u001a\u00020\u000f2\"\u0010\u0012\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006H\u0096@¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bRN\u0010\u000b\u001a<\b\u0001\u0012\u0018\u0012\u0016\b\u0001\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u0006j\b\u0012\u0002\b\u0003\u0018\u0001`\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!¨\u0006#"}, d2 = {"Landroidx/room/coroutines/PassthroughConnectionPool;", "Landroidx/room/coroutines/ConnectionPool;", "Li1/c;", "driver", "", "fileName", "Lkotlin/Function2;", "Lkotlin/Function1;", "Le9/c;", "", "Landroidx/room/coroutines/TransactionWrapper;", "transactionWrapper", "<init>", "(Li1/c;Ljava/lang/String;Lp9/p;)V", "R", "", "isReadOnly", "Landroidx/room/Transactor;", "block", "y", "(ZLp9/p;Le9/c;)Ljava/lang/Object;", "LY8/t;", "close", "()V", Const.INTENT_KEY_APIKEY, "Li1/c;", Const.INTENT_KEY_PKGNAME, "Ljava/lang/String;", "c", "Lp9/p;", "LY8/h;", "Li1/b;", Const.INTENT_KEY_UMID, "LY8/h;", "connection", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PassthroughConnectionPool implements ConnectionPool {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC4161c driver;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final String fileName;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final p<InterfaceC5074l<? super InterfaceC4014c<Object>, ? extends Object>, InterfaceC4014c<Object>, Object> transactionWrapper;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final h<InterfaceC4160b> connection;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\u0006B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\bR\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00000\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Landroidx/room/coroutines/PassthroughConnectionPool$a;", "Lkotlin/coroutines/d$b;", "Landroidx/room/coroutines/PassthroughConnection;", "connectionWrapper", "<init>", "(Landroidx/room/coroutines/PassthroughConnection;)V", Const.INTENT_KEY_APIKEY, "Landroidx/room/coroutines/PassthroughConnection;", "()Landroidx/room/coroutines/PassthroughConnection;", "Lkotlin/coroutines/d$c;", "getKey", "()Lkotlin/coroutines/d$c;", "key", Const.INTENT_KEY_PKGNAME, "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a implements d.b {

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final PassthroughConnection connectionWrapper;

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Landroidx/room/coroutines/PassthroughConnectionPool$a$a;", "Lkotlin/coroutines/d$c;", "Landroidx/room/coroutines/PassthroughConnectionPool$a;", "<init>", "()V", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* renamed from: androidx.room.coroutines.PassthroughConnectionPool$a$a, reason: collision with other inner class name and from kotlin metadata */
        public static final class Companion implements d.c<a> {
            public /* synthetic */ Companion(i iVar) {
                this();
            }

            public Companion() {
            }
        }

        public a(PassthroughConnection connectionWrapper) {
            kotlin.jvm.internal.p.i(connectionWrapper, "connectionWrapper");
            this.connectionWrapper = connectionWrapper;
        }

        /* renamed from: a, reason: from getter */
        public final PassthroughConnection getConnectionWrapper() {
            return this.connectionWrapper;
        }

        @Override // kotlin.coroutines.d
        public <R> R fold(R r10, p<? super R, ? super d.b, ? extends R> pVar) {
            return (R) d.b.a.a(this, r10, pVar);
        }

        @Override // kotlin.coroutines.d.b, kotlin.coroutines.d
        public <E extends d.b> E get(d.c<E> cVar) {
            return (E) d.b.a.b(this, cVar);
        }

        @Override // kotlin.coroutines.d.b
        public d.c<a> getKey() {
            return INSTANCE;
        }

        @Override // kotlin.coroutines.d
        public d minusKey(d.c<?> cVar) {
            return d.b.a.c(this, cVar);
        }

        @Override // kotlin.coroutines.d
        public d plus(d dVar) {
            return d.b.a.d(this, dVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PassthroughConnectionPool(InterfaceC4161c driver, String fileName, p<? super InterfaceC5074l<? super InterfaceC4014c<Object>, ? extends Object>, ? super InterfaceC4014c<Object>, ? extends Object> pVar) {
        kotlin.jvm.internal.p.i(driver, "driver");
        kotlin.jvm.internal.p.i(fileName, "fileName");
        this.driver = driver;
        this.fileName = fileName;
        this.transactionWrapper = pVar;
        this.connection = C4848b.b(new InterfaceC5063a() { // from class: c1.i
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return PassthroughConnectionPool.e(this.f15417a);
            }
        });
    }

    public static final InterfaceC4160b e(PassthroughConnectionPool passthroughConnectionPool) {
        return passthroughConnectionPool.driver.a(passthroughConnectionPool.fileName);
    }

    @Override // androidx.room.coroutines.ConnectionPool, java.lang.AutoCloseable
    public void close() {
        if (this.connection.isInitialized()) {
            this.connection.getValue().close();
        }
    }

    @Override // androidx.room.coroutines.ConnectionPool
    public <R> Object y(boolean z10, p<? super Transactor, ? super InterfaceC4014c<? super R>, ? extends Object> pVar, InterfaceC4014c<? super R> interfaceC4014c) {
        a aVar = (a) interfaceC4014c.getContext().get(a.INSTANCE);
        PassthroughConnection connectionWrapper = aVar != null ? aVar.getConnectionWrapper() : null;
        if (connectionWrapper != null) {
            return pVar.invoke(connectionWrapper, interfaceC4014c);
        }
        PassthroughConnection passthroughConnection = new PassthroughConnection(this.transactionWrapper, this.connection.getValue());
        return C1056g.j(new a(passthroughConnection), new PassthroughConnectionPool$useConnection$2(pVar, passthroughConnection, null), interfaceC4014c);
    }
}
