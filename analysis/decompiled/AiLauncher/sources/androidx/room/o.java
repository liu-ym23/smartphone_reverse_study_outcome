package androidx.room;

import Z8.C1173v;
import androidx.exifinterface.media.ExifInterface;
import androidx.room.AbstractC1405a;
import androidx.room.RoomDatabase;
import androidx.room.coroutines.ConnectionPool;
import androidx.room.coroutines.PassthroughConnectionPool;
import androidx.room.w;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import i1.InterfaceC4160b;
import i1.InterfaceC4161c;
import j1.InterfaceC4756c;
import j1.InterfaceC4757d;
import java.util.List;
import kotlin.Metadata;
import l1.C4859a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0000\u0018\u00002\u00020\u0001:\u0002DEBW\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012<\u0010\u000b\u001a8\b\u0001\u0012\u0018\u0012\u0016\b\u0001\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006j\u0006\u0012\u0002\b\u0003`\n¢\u0006\u0004\b\f\u0010\rBc\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000e0\u0007\u0012<\u0010\u000b\u001a8\b\u0001\u0012\u0018\u0012\u0016\b\u0001\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006j\u0006\u0012\u0002\b\u0003`\n¢\u0006\u0004\b\f\u0010\u0010JB\u0010\u0016\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00112\u0006\u0010\u0013\u001a\u00020\u00122\"\u0010\u0015\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006H\u0096@¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0010¢\u0006\u0004\b\u001a\u0010\u001bJ\r\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001d\u0010\u001eJ\r\u0010\u001f\u001a\u00020\u0012¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u001cH\u0002¢\u0006\u0004\b!\u0010\u001eJ'\u0010$\u001a\u00020\u0002*\u00020\u00022\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u001c0\u0007H\u0002¢\u0006\u0004\b$\u0010%R\u001a\u0010*\u001a\u00020\u00028\u0014X\u0094\u0004¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u001a\u0010\u0005\u001a\u00020\u00048\u0014X\u0094\u0004¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R \u00105\u001a\b\u0012\u0004\u0012\u0002000/8\u0014X\u0094\u0004¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\u001a\u0010;\u001a\u0002068\u0000X\u0080\u0004¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u001c\u0010@\u001a\u0004\u0018\u00010\u000e8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?R\u0018\u0010C\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010B¨\u0006F"}, d2 = {"Landroidx/room/o;", "Landroidx/room/a;", "Landroidx/room/c;", "config", "Landroidx/room/w;", "openDelegate", "Lkotlin/Function2;", "Lkotlin/Function1;", "Le9/c;", "", "Landroidx/room/coroutines/TransactionWrapper;", "transactionWrapper", "<init>", "(Landroidx/room/c;Landroidx/room/w;Lp9/p;)V", "Lj1/d;", "supportOpenHelperFactory", "(Landroidx/room/c;Lp9/l;Lp9/p;)V", "R", "", "isReadOnly", "Landroidx/room/Transactor;", "block", "K", "(ZLp9/p;Le9/c;)Ljava/lang/Object;", "", "fileName", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Ljava/lang/String;)Ljava/lang/String;", "LY8/t;", "F", "()V", "J", "()Z", "H", "Lj1/c;", "onOpen", "I", "(Landroidx/room/c;Lp9/l;)Landroidx/room/c;", Const.INTENT_KEY_UMID, "Landroidx/room/c;", "o", "()Landroidx/room/c;", "configuration", "e", "Landroidx/room/w;", "r", "()Landroidx/room/w;", "", "Landroidx/room/RoomDatabase$b;", "f", "Ljava/util/List;", "n", "()Ljava/util/List;", "callbacks", "Landroidx/room/coroutines/ConnectionPool;", Const.INTENT_KEY_BACKGROUND_COMMAND, "Landroidx/room/coroutines/ConnectionPool;", "getConnectionPool$room_runtime", "()Landroidx/room/coroutines/ConnectionPool;", "connectionPool", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "Lj1/d;", "G", "()Lj1/d;", "supportOpenHelper", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "Lj1/c;", "supportDatabase", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class o extends AbstractC1405a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final C1407c configuration;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final w openDelegate;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final List<RoomDatabase.b> callbacks;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final ConnectionPool connectionPool;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC4757d supportOpenHelper;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public InterfaceC4756c supportDatabase;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\bJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\bJ\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\bJ\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\bJ\u0017\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\b¨\u0006\u0011"}, d2 = {"Landroidx/room/o$a;", "Landroidx/room/w;", "<init>", "()V", "Li1/b;", "connection", "LY8/t;", "f", "(Li1/b;)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "Landroidx/room/w$a;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Li1/b;)Landroidx/room/w$a;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, Const.INTENT_KEY_BACKGROUND_COMMAND, Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a extends w {
        public a() {
            super(-1, "", "");
        }

        @Override // androidx.room.w
        public void a(InterfaceC4160b connection) {
            kotlin.jvm.internal.p.i(connection, "connection");
            throw new IllegalStateException("NOP delegate should never be called");
        }

        @Override // androidx.room.w
        public void b(InterfaceC4160b connection) {
            kotlin.jvm.internal.p.i(connection, "connection");
            throw new IllegalStateException("NOP delegate should never be called");
        }

        @Override // androidx.room.w
        public void f(InterfaceC4160b connection) {
            kotlin.jvm.internal.p.i(connection, "connection");
            throw new IllegalStateException("NOP delegate should never be called");
        }

        @Override // androidx.room.w
        public void g(InterfaceC4160b connection) {
            kotlin.jvm.internal.p.i(connection, "connection");
            throw new IllegalStateException("NOP delegate should never be called");
        }

        @Override // androidx.room.w
        public void h(InterfaceC4160b connection) {
            kotlin.jvm.internal.p.i(connection, "connection");
            throw new IllegalStateException("NOP delegate should never be called");
        }

        @Override // androidx.room.w
        public void i(InterfaceC4160b connection) {
            kotlin.jvm.internal.p.i(connection, "connection");
            throw new IllegalStateException("NOP delegate should never be called");
        }

        @Override // androidx.room.w
        public w.a j(InterfaceC4160b connection) {
            kotlin.jvm.internal.p.i(connection, "connection");
            throw new IllegalStateException("NOP delegate should never be called");
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ'\u0010\r\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000eJ'\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0010\u0010\n¨\u0006\u0011"}, d2 = {"Landroidx/room/o$b;", "Lj1/d$a;", "", "version", "<init>", "(Landroidx/room/o;I)V", "Lj1/c;", "db", "LY8/t;", Const.INTENT_KEY_UMID, "(Lj1/c;)V", "oldVersion", "newVersion", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Lj1/c;II)V", "e", "f", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class b extends InterfaceC4757d.a {
        public b(int i10) {
            super(i10);
        }

        @Override // j1.InterfaceC4757d.a
        public void d(InterfaceC4756c db2) {
            kotlin.jvm.internal.p.i(db2, "db");
            o.this.x(new androidx.sqlite.driver.a(db2));
        }

        @Override // j1.InterfaceC4757d.a
        public void e(InterfaceC4756c db2, int oldVersion, int newVersion) {
            kotlin.jvm.internal.p.i(db2, "db");
            g(db2, oldVersion, newVersion);
        }

        @Override // j1.InterfaceC4757d.a
        public void f(InterfaceC4756c db2) {
            kotlin.jvm.internal.p.i(db2, "db");
            o.this.z(new androidx.sqlite.driver.a(db2));
            o.this.supportDatabase = db2;
        }

        @Override // j1.InterfaceC4757d.a
        public void g(InterfaceC4756c db2, int oldVersion, int newVersion) {
            kotlin.jvm.internal.p.i(db2, "db");
            o.this.y(new androidx.sqlite.driver.a(db2), oldVersion, newVersion);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"androidx/room/o$c", "Landroidx/room/RoomDatabase$b;", "Lj1/c;", "db", "LY8/t;", "f", "(Lj1/c;)V", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class c extends RoomDatabase.b {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InterfaceC5074l<InterfaceC4756c, Y8.t> f14811a;

        /* JADX WARN: Multi-variable type inference failed */
        public c(InterfaceC5074l<? super InterfaceC4756c, Y8.t> interfaceC5074l) {
            this.f14811a = interfaceC5074l;
        }

        @Override // androidx.room.RoomDatabase.b
        public void f(InterfaceC4756c db2) {
            kotlin.jvm.internal.p.i(db2, "db");
            this.f14811a.invoke(db2);
        }
    }

    public o(C1407c config, w openDelegate, p9.p<? super InterfaceC5074l<? super InterfaceC4014c<Object>, ? extends Object>, ? super InterfaceC4014c<Object>, ? extends Object> transactionWrapper) {
        ConnectionPool connectionPoolB;
        kotlin.jvm.internal.p.i(config, "config");
        kotlin.jvm.internal.p.i(openDelegate, "openDelegate");
        kotlin.jvm.internal.p.i(transactionWrapper, "transactionWrapper");
        this.configuration = config;
        this.openDelegate = openDelegate;
        List<RoomDatabase.b> list = config.callbacks;
        this.callbacks = list == null ? C1173v.m() : list;
        InterfaceC4161c interfaceC4161c = config.sqliteDriver;
        if (interfaceC4161c != null) {
            this.supportOpenHelper = null;
            if (interfaceC4161c.b()) {
                AbstractC1405a.b bVar = new AbstractC1405a.b(this, config.sqliteDriver);
                String str = config.name;
                connectionPoolB = new PassthroughConnectionPool(bVar, str != null ? str : ":memory:", transactionWrapper);
            } else {
                connectionPoolB = config.name == null ? c1.g.b(new AbstractC1405a.b(this, config.sqliteDriver), ":memory:", config.getPreparedStatementCacheSize()) : c1.g.a(new AbstractC1405a.b(this, config.sqliteDriver), config.name, p(config.journalMode), q(config.journalMode), config.getPreparedStatementCacheSize());
            }
            this.connectionPool = connectionPoolB;
        } else {
            if (config.sqliteOpenHelperFactory == null) {
                throw new IllegalArgumentException("SQLiteManager was constructed with both null driver and open helper factory!");
            }
            InterfaceC4757d interfaceC4757dCreate = config.sqliteOpenHelperFactory.create(InterfaceC4757d.b.INSTANCE.a(config.context).c(config.name).b(new b(openDelegate.getVersion())).a());
            this.supportOpenHelper = interfaceC4757dCreate;
            C4859a c4859a = new C4859a(interfaceC4757dCreate);
            String str2 = config.name;
            this.connectionPool = new PassthroughConnectionPool(c4859a, str2 != null ? str2 : ":memory:", transactionWrapper);
        }
        H();
    }

    public static final Y8.t D(o oVar, InterfaceC4756c db2) {
        kotlin.jvm.internal.p.i(db2, "db");
        oVar.supportDatabase = db2;
        return Y8.t.f7040a;
    }

    @Override // androidx.room.AbstractC1405a
    public String A(String fileName) {
        kotlin.jvm.internal.p.i(fileName, "fileName");
        if (kotlin.jvm.internal.p.d(fileName, ":memory:")) {
            return fileName;
        }
        String absolutePath = getConfiguration().context.getDatabasePath(fileName).getAbsolutePath();
        kotlin.jvm.internal.p.f(absolutePath);
        return absolutePath;
    }

    public final void F() {
        this.connectionPool.close();
        InterfaceC4757d interfaceC4757d = this.supportOpenHelper;
        if (interfaceC4757d != null) {
            interfaceC4757d.close();
        }
    }

    /* renamed from: G, reason: from getter */
    public final InterfaceC4757d getSupportOpenHelper() {
        return this.supportOpenHelper;
    }

    public final void H() {
        boolean z10 = getConfiguration().journalMode == RoomDatabase.JournalMode.WRITE_AHEAD_LOGGING;
        InterfaceC4757d interfaceC4757d = this.supportOpenHelper;
        if (interfaceC4757d != null) {
            interfaceC4757d.setWriteAheadLoggingEnabled(z10);
        }
    }

    public final C1407c I(C1407c c1407c, InterfaceC5074l<? super InterfaceC4756c, Y8.t> interfaceC5074l) {
        List<RoomDatabase.b> listM = c1407c.callbacks;
        if (listM == null) {
            listM = C1173v.m();
        }
        return C1407c.b(c1407c, null, null, null, null, Z8.F.T0(listM, new c(interfaceC5074l)), false, null, null, null, null, false, false, null, null, null, null, null, null, null, false, null, null, 4194287, null);
    }

    public final boolean J() {
        InterfaceC4756c interfaceC4756c = this.supportDatabase;
        if (interfaceC4756c != null) {
            return interfaceC4756c.isOpen();
        }
        return false;
    }

    public <R> Object K(boolean z10, p9.p<? super Transactor, ? super InterfaceC4014c<? super R>, ? extends Object> pVar, InterfaceC4014c<? super R> interfaceC4014c) {
        return this.connectionPool.y(z10, pVar, interfaceC4014c);
    }

    @Override // androidx.room.AbstractC1405a
    public List<RoomDatabase.b> n() {
        return this.callbacks;
    }

    @Override // androidx.room.AbstractC1405a
    /* renamed from: o, reason: from getter */
    public C1407c getConfiguration() {
        return this.configuration;
    }

    @Override // androidx.room.AbstractC1405a
    /* renamed from: r, reason: from getter */
    public w getOpenDelegate() {
        return this.openDelegate;
    }

    public o(C1407c config, InterfaceC5074l<? super C1407c, ? extends InterfaceC4757d> supportOpenHelperFactory, p9.p<? super InterfaceC5074l<? super InterfaceC4014c<Object>, ? extends Object>, ? super InterfaceC4014c<Object>, ? extends Object> transactionWrapper) {
        kotlin.jvm.internal.p.i(config, "config");
        kotlin.jvm.internal.p.i(supportOpenHelperFactory, "supportOpenHelperFactory");
        kotlin.jvm.internal.p.i(transactionWrapper, "transactionWrapper");
        this.configuration = config;
        this.openDelegate = new a();
        List<RoomDatabase.b> list = config.callbacks;
        this.callbacks = list == null ? C1173v.m() : list;
        InterfaceC4757d interfaceC4757dInvoke = supportOpenHelperFactory.invoke(I(config, new InterfaceC5074l() { // from class: androidx.room.n
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return o.D(this.f14803a, (InterfaceC4756c) obj);
            }
        }));
        this.supportOpenHelper = interfaceC4757dInvoke;
        C4859a c4859a = new C4859a(interfaceC4757dInvoke);
        String str = config.name;
        this.connectionPool = new PassthroughConnectionPool(c4859a, str == null ? ":memory:" : str, transactionWrapper);
        H();
    }
}
