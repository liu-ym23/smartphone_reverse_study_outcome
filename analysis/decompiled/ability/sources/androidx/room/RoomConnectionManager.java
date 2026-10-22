package androidx.room;

import B9.Q;
import C7.r;
import D7.v;
import S7.n;
import androidx.room.BaseRoomConnectionManager;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenDelegate;
import androidx.room.coroutines.ConnectionPool;
import androidx.room.coroutines.ConnectionPoolKt;
import androidx.room.coroutines.PassthroughConnectionPool;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteDriver;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.driver.SupportSQLiteConnection;
import androidx.sqlite.driver.SupportSQLiteDriver;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\b\u0000\u0018\u00002\u00020\u0001:\u0002?@BW\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012<\u0010\u000b\u001a8\b\u0001\u0012\u0018\u0012\u0016\b\u0001\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006j\u0006\u0012\u0002\b\u0003`\n¢\u0006\u0004\b\f\u0010\rBc\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000e0\u0007\u0012<\u0010\u000b\u001a8\b\u0001\u0012\u0018\u0012\u0016\b\u0001\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006j\u0006\u0012\u0002\b\u0003`\n¢\u0006\u0004\b\f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J'\u0010\u0016\u001a\u00020\u0002*\u00020\u00022\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0007H\u0002¢\u0006\u0004\b\u0016\u0010\u0017JB\u0010\u001d\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00182\u0006\u0010\u001a\u001a\u00020\u00192\"\u0010\u001c\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006H\u0096@¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010#\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001fH\u0010¢\u0006\u0004\b!\u0010\"J\r\u0010$\u001a\u00020\u0011¢\u0006\u0004\b$\u0010\u0013J\r\u0010%\u001a\u00020\u0019¢\u0006\u0004\b%\u0010&R\u001a\u0010'\u001a\u00020\u00028\u0014X\u0094\u0004¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u001a\u0010\u0005\u001a\u00020\u00048\u0014X\u0094\u0004¢\u0006\f\n\u0004\b\u0005\u0010+\u001a\u0004\b,\u0010-R \u00100\u001a\b\u0012\u0004\u0012\u00020/0.8\u0014X\u0094\u0004¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\u001a\u00105\u001a\u0002048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\u001c\u00109\u001a\u0004\u0018\u00010\u000e8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<R\u0018\u0010=\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>¨\u0006A"}, d2 = {"Landroidx/room/RoomConnectionManager;", "Landroidx/room/BaseRoomConnectionManager;", "Landroidx/room/DatabaseConfiguration;", "config", "Landroidx/room/RoomOpenDelegate;", "openDelegate", "Lkotlin/Function2;", "Lkotlin/Function1;", "LH7/c;", "", "Landroidx/room/coroutines/TransactionWrapper;", "transactionWrapper", AppAgent.CONSTRUCT, "(Landroidx/room/DatabaseConfiguration;Landroidx/room/RoomOpenDelegate;LS7/n;)V", "Landroidx/sqlite/db/SupportSQLiteOpenHelper;", "supportOpenHelperFactory", "(Landroidx/room/DatabaseConfiguration;LS7/k;LS7/n;)V", "LC7/r;", "init", "()V", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "onOpen", "installOnOpenCallback", "(Landroidx/room/DatabaseConfiguration;LS7/k;)Landroidx/room/DatabaseConfiguration;", "R", "", "isReadOnly", "Landroidx/room/Transactor;", "block", "useConnection", "(ZLS7/n;LH7/c;)Ljava/lang/Object;", "", "fileName", "resolveFileName$room_runtime", "(Ljava/lang/String;)Ljava/lang/String;", "resolveFileName", "close", "isSupportDatabaseOpen", "()Z", "configuration", "Landroidx/room/DatabaseConfiguration;", "getConfiguration", "()Landroidx/room/DatabaseConfiguration;", "Landroidx/room/RoomOpenDelegate;", "getOpenDelegate", "()Landroidx/room/RoomOpenDelegate;", "", "Landroidx/room/RoomDatabase$Callback;", "callbacks", "Ljava/util/List;", "getCallbacks", "()Ljava/util/List;", "Landroidx/room/coroutines/ConnectionPool;", "connectionPool", "Landroidx/room/coroutines/ConnectionPool;", "getConnectionPool$room_runtime", "()Landroidx/room/coroutines/ConnectionPool;", "supportOpenHelper", "Landroidx/sqlite/db/SupportSQLiteOpenHelper;", "getSupportOpenHelper$room_runtime", "()Landroidx/sqlite/db/SupportSQLiteOpenHelper;", "supportDatabase", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "SupportOpenHelperCallback", "NoOpOpenDelegate", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RoomConnectionManager extends BaseRoomConnectionManager {
    private final List<RoomDatabase.Callback> callbacks;
    private final DatabaseConfiguration configuration;
    private final ConnectionPool connectionPool;
    private final RoomOpenDelegate openDelegate;
    private SupportSQLiteDatabase supportDatabase;
    private final SupportSQLiteOpenHelper supportOpenHelper;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\bJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\bJ\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\bJ\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\bJ\u0017\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\b¨\u0006\u0011"}, d2 = {"Landroidx/room/RoomConnectionManager$NoOpOpenDelegate;", "Landroidx/room/RoomOpenDelegate;", AppAgent.CONSTRUCT, "()V", "Landroidx/sqlite/SQLiteConnection;", "connection", "LC7/r;", AppAgent.ON_CREATE, "(Landroidx/sqlite/SQLiteConnection;)V", "onPreMigrate", "Landroidx/room/RoomOpenDelegate$ValidationResult;", "onValidateSchema", "(Landroidx/sqlite/SQLiteConnection;)Landroidx/room/RoomOpenDelegate$ValidationResult;", "onPostMigrate", "onOpen", "createAllTables", "dropAllTables", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class NoOpOpenDelegate extends RoomOpenDelegate {
        public NoOpOpenDelegate() {
            super(-1, "", "");
        }

        @Override // androidx.room.RoomOpenDelegate
        public void createAllTables(SQLiteConnection connection) {
            k.f(connection, "connection");
            throw new IllegalStateException("NOP delegate should never be called");
        }

        @Override // androidx.room.RoomOpenDelegate
        public void dropAllTables(SQLiteConnection connection) {
            k.f(connection, "connection");
            throw new IllegalStateException("NOP delegate should never be called");
        }

        @Override // androidx.room.RoomOpenDelegate
        public void onCreate(SQLiteConnection connection) {
            k.f(connection, "connection");
            throw new IllegalStateException("NOP delegate should never be called");
        }

        @Override // androidx.room.RoomOpenDelegate
        public void onOpen(SQLiteConnection connection) {
            k.f(connection, "connection");
            throw new IllegalStateException("NOP delegate should never be called");
        }

        @Override // androidx.room.RoomOpenDelegate
        public void onPostMigrate(SQLiteConnection connection) {
            k.f(connection, "connection");
            throw new IllegalStateException("NOP delegate should never be called");
        }

        @Override // androidx.room.RoomOpenDelegate
        public void onPreMigrate(SQLiteConnection connection) {
            k.f(connection, "connection");
            throw new IllegalStateException("NOP delegate should never be called");
        }

        @Override // androidx.room.RoomOpenDelegate
        public RoomOpenDelegate.ValidationResult onValidateSchema(SQLiteConnection connection) {
            k.f(connection, "connection");
            throw new IllegalStateException("NOP delegate should never be called");
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ'\u0010\r\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000eJ'\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0010\u0010\n¨\u0006\u0011"}, d2 = {"Landroidx/room/RoomConnectionManager$SupportOpenHelperCallback;", "Landroidx/sqlite/db/SupportSQLiteOpenHelper$Callback;", "", "version", AppAgent.CONSTRUCT, "(Landroidx/room/RoomConnectionManager;I)V", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "db", "LC7/r;", AppAgent.ON_CREATE, "(Landroidx/sqlite/db/SupportSQLiteDatabase;)V", "oldVersion", "newVersion", "onUpgrade", "(Landroidx/sqlite/db/SupportSQLiteDatabase;II)V", "onDowngrade", "onOpen", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class SupportOpenHelperCallback extends SupportSQLiteOpenHelper.Callback {
        public SupportOpenHelperCallback(int i) {
            super(i);
        }

        @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
        public void onCreate(SupportSQLiteDatabase db) {
            k.f(db, "db");
            RoomConnectionManager.this.onCreate(new SupportSQLiteConnection(db));
        }

        @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
        public void onDowngrade(SupportSQLiteDatabase db, int oldVersion, int newVersion) {
            k.f(db, "db");
            onUpgrade(db, oldVersion, newVersion);
        }

        @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
        public void onOpen(SupportSQLiteDatabase db) {
            k.f(db, "db");
            RoomConnectionManager.this.onOpen(new SupportSQLiteConnection(db));
            RoomConnectionManager.this.supportDatabase = db;
        }

        @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
        public void onUpgrade(SupportSQLiteDatabase db, int oldVersion, int newVersion) {
            k.f(db, "db");
            RoomConnectionManager.this.onMigrate(new SupportSQLiteConnection(db), oldVersion, newVersion);
        }
    }

    public RoomConnectionManager(DatabaseConfiguration config, RoomOpenDelegate openDelegate, n transactionWrapper) {
        ConnectionPool connectionPoolNewSingleConnectionPool;
        k.f(config, "config");
        k.f(openDelegate, "openDelegate");
        k.f(transactionWrapper, "transactionWrapper");
        this.configuration = config;
        this.openDelegate = openDelegate;
        List<RoomDatabase.Callback> list = config.callbacks;
        this.callbacks = list == null ? EmptyList.f4893a : list;
        SQLiteDriver sQLiteDriver = config.sqliteDriver;
        if (sQLiteDriver != null) {
            this.supportOpenHelper = null;
            if (sQLiteDriver.hasConnectionPool()) {
                BaseRoomConnectionManager.DriverWrapper driverWrapper = new BaseRoomConnectionManager.DriverWrapper(this, config.sqliteDriver);
                String str = config.name;
                connectionPoolNewSingleConnectionPool = new PassthroughConnectionPool(driverWrapper, str != null ? str : ":memory:", transactionWrapper);
            } else {
                connectionPoolNewSingleConnectionPool = config.name == null ? ConnectionPoolKt.newSingleConnectionPool(new BaseRoomConnectionManager.DriverWrapper(this, config.sqliteDriver), ":memory:") : ConnectionPoolKt.newConnectionPool(new BaseRoomConnectionManager.DriverWrapper(this, config.sqliteDriver), config.name, getMaxNumberOfReaders(config.journalMode), getMaxNumberOfWriters(config.journalMode));
            }
            this.connectionPool = connectionPoolNewSingleConnectionPool;
        } else {
            if (config.sqliteOpenHelperFactory == null) {
                throw new IllegalArgumentException("SQLiteManager was constructed with both null driver and open helper factory!");
            }
            SupportSQLiteOpenHelper supportSQLiteOpenHelperCreate = config.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.INSTANCE.builder(config.context).name(config.name).callback(new SupportOpenHelperCallback(openDelegate.getVersion())).build());
            this.supportOpenHelper = supportSQLiteOpenHelperCreate;
            SupportSQLiteDriver supportSQLiteDriver = new SupportSQLiteDriver(supportSQLiteOpenHelperCreate);
            String str2 = config.name;
            this.connectionPool = new PassthroughConnectionPool(supportSQLiteDriver, str2 != null ? str2 : ":memory:", transactionWrapper);
        }
        init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r _init_$lambda$1(RoomConnectionManager roomConnectionManager, SupportSQLiteDatabase db) {
        k.f(db, "db");
        roomConnectionManager.supportDatabase = db;
        return r.f317a;
    }

    private final void init() {
        boolean z10 = getConfiguration().journalMode == RoomDatabase.JournalMode.WRITE_AHEAD_LOGGING;
        SupportSQLiteOpenHelper supportSQLiteOpenHelper = this.supportOpenHelper;
        if (supportSQLiteOpenHelper != null) {
            supportSQLiteOpenHelper.setWriteAheadLoggingEnabled(z10);
        }
    }

    private final DatabaseConfiguration installOnOpenCallback(DatabaseConfiguration databaseConfiguration, final S7.k kVar) {
        Collection collection = databaseConfiguration.callbacks;
        if (collection == null) {
            collection = EmptyList.f4893a;
        }
        return DatabaseConfiguration.copy$default(databaseConfiguration, null, null, null, null, v.R0(collection, new RoomDatabase.Callback() { // from class: androidx.room.RoomConnectionManager$installOnOpenCallback$newCallbacks$1
            @Override // androidx.room.RoomDatabase.Callback
            public void onOpen(SupportSQLiteDatabase db) {
                k.f(db, "db");
                kVar.invoke(db);
            }
        }), false, null, null, null, null, false, false, null, null, null, null, null, null, null, false, null, null, 4194287, null);
    }

    public final void close() {
        this.connectionPool.close();
        SupportSQLiteOpenHelper supportSQLiteOpenHelper = this.supportOpenHelper;
        if (supportSQLiteOpenHelper != null) {
            supportSQLiteOpenHelper.close();
        }
    }

    @Override // androidx.room.BaseRoomConnectionManager
    public List<RoomDatabase.Callback> getCallbacks() {
        return this.callbacks;
    }

    @Override // androidx.room.BaseRoomConnectionManager
    public DatabaseConfiguration getConfiguration() {
        return this.configuration;
    }

    /* renamed from: getConnectionPool$room_runtime, reason: from getter */
    public final ConnectionPool getConnectionPool() {
        return this.connectionPool;
    }

    @Override // androidx.room.BaseRoomConnectionManager
    public RoomOpenDelegate getOpenDelegate() {
        return this.openDelegate;
    }

    /* renamed from: getSupportOpenHelper$room_runtime, reason: from getter */
    public final SupportSQLiteOpenHelper getSupportOpenHelper() {
        return this.supportOpenHelper;
    }

    public final boolean isSupportDatabaseOpen() {
        SupportSQLiteDatabase supportSQLiteDatabase = this.supportDatabase;
        if (supportSQLiteDatabase != null) {
            return supportSQLiteDatabase.isOpen();
        }
        return false;
    }

    @Override // androidx.room.BaseRoomConnectionManager
    public String resolveFileName$room_runtime(String fileName) {
        k.f(fileName, "fileName");
        if (fileName.equals(":memory:")) {
            return fileName;
        }
        String absolutePath = getConfiguration().context.getDatabasePath(fileName).getAbsolutePath();
        k.c(absolutePath);
        return absolutePath;
    }

    @Override // androidx.room.BaseRoomConnectionManager
    public <R> Object useConnection(boolean z10, n nVar, H7.c<? super R> cVar) {
        return this.connectionPool.useConnection(z10, nVar, cVar);
    }

    public RoomConnectionManager(DatabaseConfiguration config, S7.k supportOpenHelperFactory, n transactionWrapper) {
        k.f(config, "config");
        k.f(supportOpenHelperFactory, "supportOpenHelperFactory");
        k.f(transactionWrapper, "transactionWrapper");
        this.configuration = config;
        this.openDelegate = new NoOpOpenDelegate();
        List<RoomDatabase.Callback> list = config.callbacks;
        this.callbacks = list == null ? EmptyList.f4893a : list;
        SupportSQLiteOpenHelper supportSQLiteOpenHelper = (SupportSQLiteOpenHelper) supportOpenHelperFactory.invoke(installOnOpenCallback(config, new Q(this, 18)));
        this.supportOpenHelper = supportSQLiteOpenHelper;
        SupportSQLiteDriver supportSQLiteDriver = new SupportSQLiteDriver(supportSQLiteOpenHelper);
        String str = config.name;
        this.connectionPool = new PassthroughConnectionPool(supportSQLiteDriver, str == null ? ":memory:" : str, transactionWrapper);
        init();
    }
}
