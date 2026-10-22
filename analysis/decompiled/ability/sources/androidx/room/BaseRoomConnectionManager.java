package androidx.room;

import C7.r;
import H4.o;
import S7.n;
import androidx.annotation.RestrictTo;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenDelegate;
import androidx.room.concurrent.ExclusiveLock;
import androidx.room.migration.Migration;
import androidx.room.util.MigrationUtil;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteDriver;
import androidx.sqlite.SQLiteStatement;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.task.executor.e;
import j9.t;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.collections.builders.ListBuilder;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b'\u0018\u0000 @2\u00020\u0001:\u0002A@B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JB\u0010\u000b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0006\u001a\u00020\u00052\"\u0010\n\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007H¦@¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0011\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0010¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0004¢\u0006\u0004\b\u0015\u0010\u0016J'\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017H\u0004¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0004¢\u0006\u0004\b\u001c\u0010\u0016J\u0013\u0010\u001e\u001a\u00020\u0017*\u00020\u001dH\u0004¢\u0006\u0004\b\u001e\u0010\u001fJ\u0013\u0010 \u001a\u00020\u0017*\u00020\u001dH\u0004¢\u0006\u0004\b \u0010\u001fJ\u0017\u0010!\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b!\u0010\u0016J\u0017\u0010\"\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\"\u0010\u0016J\u0017\u0010#\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b#\u0010\u0016J\u0017\u0010$\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b$\u0010\u0016J\u0017\u0010%\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b%\u0010\u0016J\u0017\u0010&\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b&\u0010'J\u0017\u0010(\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b(\u0010\u0016J\u0017\u0010)\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b)\u0010\u0016J\u0017\u0010*\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b*\u0010\u0016J\u0017\u0010+\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b+\u0010\u0016J\u0017\u0010,\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b,\u0010'J\u0017\u0010-\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b-\u0010\u0016J\u0017\u0010.\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b.\u0010\u0016J\u0017\u0010/\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b/\u0010\u0016R\u0016\u00100\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00102\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00101R\u0014\u00106\u001a\u0002038$X¤\u0004¢\u0006\u0006\u001a\u0004\b4\u00105R\u0014\u0010:\u001a\u0002078$X¤\u0004¢\u0006\u0006\u001a\u0004\b8\u00109R\u001a\u0010?\u001a\b\u0012\u0004\u0012\u00020<0;8$X¤\u0004¢\u0006\u0006\u001a\u0004\b=\u0010>¨\u0006B"}, d2 = {"Landroidx/room/BaseRoomConnectionManager;", "", AppAgent.CONSTRUCT, "()V", "R", "", "isReadOnly", "Lkotlin/Function2;", "Landroidx/room/Transactor;", "LH7/c;", "block", "useConnection", "(ZLS7/n;LH7/c;)Ljava/lang/Object;", "", "fileName", "resolveFileName$room_runtime", "(Ljava/lang/String;)Ljava/lang/String;", "resolveFileName", "Landroidx/sqlite/SQLiteConnection;", "connection", "LC7/r;", AppAgent.ON_CREATE, "(Landroidx/sqlite/SQLiteConnection;)V", "", "oldVersion", "newVersion", "onMigrate", "(Landroidx/sqlite/SQLiteConnection;II)V", "onOpen", "Landroidx/room/RoomDatabase$JournalMode;", "getMaxNumberOfReaders", "(Landroidx/room/RoomDatabase$JournalMode;)I", "getMaxNumberOfWriters", "configureDatabase", "configurationConnection", "configureJournalMode", "configureSynchronousFlag", "configureBusyTimeout", "hasEmptySchema", "(Landroidx/sqlite/SQLiteConnection;)Z", "updateIdentity", "createMasterTableIfNotExists", "dropAllTables", "checkIdentity", "hasRoomMasterTable", "invokeCreateCallback", "invokeDestructiveMigrationCallback", "invokeOpenCallback", "isConfigured", "Z", "isInitializing", "Landroidx/room/DatabaseConfiguration;", "getConfiguration", "()Landroidx/room/DatabaseConfiguration;", "configuration", "Landroidx/room/RoomOpenDelegate;", "getOpenDelegate", "()Landroidx/room/RoomOpenDelegate;", "openDelegate", "", "Landroidx/room/RoomDatabase$Callback;", "getCallbacks", "()Ljava/util/List;", "callbacks", "Companion", "DriverWrapper", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public abstract class BaseRoomConnectionManager {
    public static final int BUSY_TIMEOUT_MS = 3000;
    private boolean isConfigured;
    private boolean isInitializing;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0084\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\f8WX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u000b\u0010\r¨\u0006\u000e"}, d2 = {"Landroidx/room/BaseRoomConnectionManager$DriverWrapper;", "Landroidx/sqlite/SQLiteDriver;", "actual", AppAgent.CONSTRUCT, "(Landroidx/room/BaseRoomConnectionManager;Landroidx/sqlite/SQLiteDriver;)V", "open", "Landroidx/sqlite/SQLiteConnection;", "fileName", "", "openLocked", "filename", "hasConnectionPool", "", "()Z", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class DriverWrapper implements SQLiteDriver {
        private final SQLiteDriver actual;
        final /* synthetic */ BaseRoomConnectionManager this$0;

        public DriverWrapper(BaseRoomConnectionManager baseRoomConnectionManager, SQLiteDriver actual) {
            k.f(actual, "actual");
            this.this$0 = baseRoomConnectionManager;
            this.actual = actual;
        }

        private final SQLiteConnection openLocked(final String filename) {
            return (SQLiteConnection) new ExclusiveLock(filename, (this.this$0.isConfigured || this.this$0.isInitializing || k.b(filename, ":memory:")) ? false : true).withLock(new androidx.compose.runtime.changelist.b(this.this$0, this, filename, 2), new S7.k() { // from class: androidx.room.BaseRoomConnectionManager$DriverWrapper$openLocked$2
                @Override // S7.k
                public final Void invoke(Throwable error) {
                    k.f(error, "error");
                    throw new IllegalStateException(B7.a.q(new StringBuilder("Unable to open database '"), filename, "'. Was a proper path / name used in Room's database builder?"), error);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final SQLiteConnection openLocked$lambda$1(BaseRoomConnectionManager baseRoomConnectionManager, DriverWrapper driverWrapper, String str) {
            if (baseRoomConnectionManager.isInitializing) {
                throw new IllegalStateException("Recursive database initialization detected. Did you try to use the database instance during initialization? Maybe in one of the callbacks?");
            }
            SQLiteConnection sQLiteConnectionOpen = driverWrapper.actual.open(str);
            if (baseRoomConnectionManager.isConfigured) {
                baseRoomConnectionManager.configurationConnection(sQLiteConnectionOpen);
                return sQLiteConnectionOpen;
            }
            try {
                baseRoomConnectionManager.isInitializing = true;
                baseRoomConnectionManager.configureDatabase(sQLiteConnectionOpen);
                return sQLiteConnectionOpen;
            } finally {
                baseRoomConnectionManager.isInitializing = false;
            }
        }

        @Override // androidx.sqlite.SQLiteDriver
        public boolean hasConnectionPool() {
            return this.actual.hasConnectionPool();
        }

        @Override // androidx.sqlite.SQLiteDriver
        public SQLiteConnection open(String fileName) {
            k.f(fileName, "fileName");
            return openLocked(this.this$0.resolveFileName$room_runtime(fileName));
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RoomDatabase.JournalMode.values().length];
            try {
                iArr[RoomDatabase.JournalMode.TRUNCATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RoomDatabase.JournalMode.WRITE_AHEAD_LOGGING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private final void checkIdentity(SQLiteConnection connection) throws Throwable {
        Object objA;
        RoomOpenDelegate.ValidationResult validationResultOnValidateSchema;
        if (hasRoomMasterTable(connection)) {
            SQLiteStatement sQLiteStatementPrepare = connection.prepare(RoomMasterTable.READ_QUERY);
            try {
                String text = sQLiteStatementPrepare.step() ? sQLiteStatementPrepare.getText(0) : null;
                e.s(sQLiteStatementPrepare, null);
                if (k.b(getOpenDelegate().getIdentityHash(), text) || k.b(getOpenDelegate().getLegacyIdentityHash(), text)) {
                    return;
                }
                throw new IllegalStateException(("Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by increasing the version number. Expected identity hash: " + getOpenDelegate().getIdentityHash() + ", found: " + text).toString());
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    e.s(sQLiteStatementPrepare, th);
                    throw th2;
                }
            }
        }
        SQLite.execSQL(connection, "BEGIN EXCLUSIVE TRANSACTION");
        try {
            validationResultOnValidateSchema = getOpenDelegate().onValidateSchema(connection);
        } catch (Throwable th3) {
            objA = kotlin.b.a(th3);
        }
        if (!validationResultOnValidateSchema.isValid) {
            throw new IllegalStateException(("Pre-packaged database has an invalid schema: " + validationResultOnValidateSchema.expectedFoundMsg).toString());
        }
        getOpenDelegate().onPostMigrate(connection);
        updateIdentity(connection);
        objA = r.f317a;
        if (!(objA instanceof Result.Failure)) {
            SQLite.execSQL(connection, "END TRANSACTION");
        }
        Throwable thA = Result.a(objA);
        if (thA == null) {
            return;
        }
        SQLite.execSQL(connection, "ROLLBACK TRANSACTION");
        throw thA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void configurationConnection(SQLiteConnection connection) {
        configureSynchronousFlag(connection);
        configureBusyTimeout(connection);
        getOpenDelegate().onOpen(connection);
    }

    private final void configureBusyTimeout(SQLiteConnection connection) {
        SQLiteStatement sQLiteStatementPrepare = connection.prepare("PRAGMA busy_timeout");
        try {
            sQLiteStatementPrepare.step();
            long j5 = sQLiteStatementPrepare.getLong(0);
            e.s(sQLiteStatementPrepare, null);
            if (j5 < 3000) {
                SQLite.execSQL(connection, "PRAGMA busy_timeout = 3000");
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                e.s(sQLiteStatementPrepare, th);
                throw th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void configureDatabase(SQLiteConnection connection) throws Throwable {
        Object objA;
        configureJournalMode(connection);
        configureSynchronousFlag(connection);
        configureBusyTimeout(connection);
        SQLiteStatement sQLiteStatementPrepare = connection.prepare("PRAGMA user_version");
        try {
            sQLiteStatementPrepare.step();
            int i = (int) sQLiteStatementPrepare.getLong(0);
            e.s(sQLiteStatementPrepare, null);
            if (i != getOpenDelegate().getVersion()) {
                SQLite.execSQL(connection, "BEGIN EXCLUSIVE TRANSACTION");
                try {
                    if (i == 0) {
                        onCreate(connection);
                    } else {
                        onMigrate(connection, i, getOpenDelegate().getVersion());
                    }
                    SQLite.execSQL(connection, "PRAGMA user_version = " + getOpenDelegate().getVersion());
                    objA = r.f317a;
                } catch (Throwable th) {
                    objA = kotlin.b.a(th);
                }
                if (!(objA instanceof Result.Failure)) {
                    SQLite.execSQL(connection, "END TRANSACTION");
                }
                Throwable thA = Result.a(objA);
                if (thA != null) {
                    SQLite.execSQL(connection, "ROLLBACK TRANSACTION");
                    throw thA;
                }
            }
            onOpen(connection);
        } finally {
        }
    }

    private final void configureJournalMode(SQLiteConnection connection) {
        if (getConfiguration().journalMode == RoomDatabase.JournalMode.WRITE_AHEAD_LOGGING) {
            SQLite.execSQL(connection, "PRAGMA journal_mode = WAL");
        } else {
            SQLite.execSQL(connection, "PRAGMA journal_mode = TRUNCATE");
        }
    }

    private final void configureSynchronousFlag(SQLiteConnection connection) {
        if (getConfiguration().journalMode == RoomDatabase.JournalMode.WRITE_AHEAD_LOGGING) {
            SQLite.execSQL(connection, "PRAGMA synchronous = NORMAL");
        } else {
            SQLite.execSQL(connection, "PRAGMA synchronous = FULL");
        }
    }

    private final void createMasterTableIfNotExists(SQLiteConnection connection) {
        SQLite.execSQL(connection, RoomMasterTable.CREATE_QUERY);
    }

    private final void dropAllTables(SQLiteConnection connection) {
        if (!getConfiguration().allowDestructiveMigrationForAllTables) {
            getOpenDelegate().dropAllTables(connection);
            return;
        }
        SQLiteStatement sQLiteStatementPrepare = connection.prepare("SELECT name, type FROM sqlite_master WHERE type = 'table' OR type = 'view'");
        try {
            ListBuilder listBuilderY = o.y();
            while (sQLiteStatementPrepare.step()) {
                String text = sQLiteStatementPrepare.getText(0);
                if (!t.e0(text, "sqlite_", false) && !text.equals("android_metadata")) {
                    listBuilderY.add(new Pair(text, Boolean.valueOf(k.b(sQLiteStatementPrepare.getText(1), "view"))));
                }
            }
            ListBuilder listBuilderQ = o.q(listBuilderY);
            e.s(sQLiteStatementPrepare, null);
            ListIterator listIterator = listBuilderQ.listIterator(0);
            while (true) {
                E7.a aVar = (E7.a) listIterator;
                if (!aVar.hasNext()) {
                    return;
                }
                Pair pair = (Pair) aVar.next();
                String str = (String) pair.f4886a;
                if (((Boolean) pair.b).booleanValue()) {
                    SQLite.execSQL(connection, "DROP VIEW IF EXISTS `" + str + '`');
                } else {
                    SQLite.execSQL(connection, "DROP TABLE IF EXISTS `" + str + '`');
                }
            }
        } finally {
        }
    }

    private final boolean hasEmptySchema(SQLiteConnection connection) {
        SQLiteStatement sQLiteStatementPrepare = connection.prepare("SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'");
        try {
            boolean z10 = false;
            if (sQLiteStatementPrepare.step()) {
                if (sQLiteStatementPrepare.getLong(0) == 0) {
                    z10 = true;
                }
            }
            e.s(sQLiteStatementPrepare, null);
            return z10;
        } finally {
        }
    }

    private final boolean hasRoomMasterTable(SQLiteConnection connection) {
        SQLiteStatement sQLiteStatementPrepare = connection.prepare("SELECT 1 FROM sqlite_master WHERE type = 'table' AND name = 'room_master_table'");
        try {
            boolean z10 = false;
            if (sQLiteStatementPrepare.step()) {
                if (sQLiteStatementPrepare.getLong(0) != 0) {
                    z10 = true;
                }
            }
            e.s(sQLiteStatementPrepare, null);
            return z10;
        } finally {
        }
    }

    private final void invokeCreateCallback(SQLiteConnection connection) {
        Iterator<T> it = getCallbacks().iterator();
        while (it.hasNext()) {
            ((RoomDatabase.Callback) it.next()).onCreate(connection);
        }
    }

    private final void invokeDestructiveMigrationCallback(SQLiteConnection connection) {
        Iterator<T> it = getCallbacks().iterator();
        while (it.hasNext()) {
            ((RoomDatabase.Callback) it.next()).onDestructiveMigration(connection);
        }
    }

    private final void invokeOpenCallback(SQLiteConnection connection) {
        Iterator<T> it = getCallbacks().iterator();
        while (it.hasNext()) {
            ((RoomDatabase.Callback) it.next()).onOpen(connection);
        }
    }

    private final void updateIdentity(SQLiteConnection connection) {
        createMasterTableIfNotExists(connection);
        SQLite.execSQL(connection, RoomMasterTable.createInsertQuery(getOpenDelegate().getIdentityHash()));
    }

    public abstract List<RoomDatabase.Callback> getCallbacks();

    public abstract DatabaseConfiguration getConfiguration();

    public final int getMaxNumberOfReaders(RoomDatabase.JournalMode journalMode) {
        k.f(journalMode, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[journalMode.ordinal()];
        if (i == 1) {
            return 1;
        }
        if (i == 2) {
            return 4;
        }
        throw new IllegalStateException(("Can't get max number of reader for journal mode '" + journalMode + '\'').toString());
    }

    public final int getMaxNumberOfWriters(RoomDatabase.JournalMode journalMode) {
        k.f(journalMode, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[journalMode.ordinal()];
        if (i == 1 || i == 2) {
            return 1;
        }
        throw new IllegalStateException(("Can't get max number of writers for journal mode '" + journalMode + '\'').toString());
    }

    public abstract RoomOpenDelegate getOpenDelegate();

    public final void onCreate(SQLiteConnection connection) {
        k.f(connection, "connection");
        boolean zHasEmptySchema = hasEmptySchema(connection);
        getOpenDelegate().createAllTables(connection);
        if (!zHasEmptySchema) {
            RoomOpenDelegate.ValidationResult validationResultOnValidateSchema = getOpenDelegate().onValidateSchema(connection);
            if (!validationResultOnValidateSchema.isValid) {
                throw new IllegalStateException(("Pre-packaged database has an invalid schema: " + validationResultOnValidateSchema.expectedFoundMsg).toString());
            }
        }
        updateIdentity(connection);
        getOpenDelegate().onCreate(connection);
        invokeCreateCallback(connection);
    }

    public final void onMigrate(SQLiteConnection connection, int oldVersion, int newVersion) {
        k.f(connection, "connection");
        List<Migration> listFindMigrationPath = MigrationUtil.findMigrationPath(getConfiguration().migrationContainer, oldVersion, newVersion);
        if (listFindMigrationPath == null) {
            if (!MigrationUtil.isMigrationRequired(getConfiguration(), oldVersion, newVersion)) {
                dropAllTables(connection);
                invokeDestructiveMigrationCallback(connection);
                getOpenDelegate().createAllTables(connection);
                return;
            } else {
                throw new IllegalStateException(("A migration from " + oldVersion + " to " + newVersion + " was required but not found. Please provide the necessary Migration path via RoomDatabase.Builder.addMigration(...) or allow for destructive migrations via one of the RoomDatabase.Builder.fallbackToDestructiveMigration* functions.").toString());
            }
        }
        getOpenDelegate().onPreMigrate(connection);
        Iterator<T> it = listFindMigrationPath.iterator();
        while (it.hasNext()) {
            ((Migration) it.next()).migrate(connection);
        }
        RoomOpenDelegate.ValidationResult validationResultOnValidateSchema = getOpenDelegate().onValidateSchema(connection);
        if (validationResultOnValidateSchema.isValid) {
            getOpenDelegate().onPostMigrate(connection);
            updateIdentity(connection);
        } else {
            throw new IllegalStateException(("Migration didn't properly handle: " + validationResultOnValidateSchema.expectedFoundMsg).toString());
        }
    }

    public final void onOpen(SQLiteConnection connection) {
        k.f(connection, "connection");
        checkIdentity(connection);
        getOpenDelegate().onOpen(connection);
        invokeOpenCallback(connection);
        this.isConfigured = true;
    }

    public String resolveFileName$room_runtime(String fileName) {
        k.f(fileName, "fileName");
        return fileName;
    }

    public abstract <R> Object useConnection(boolean z10, n nVar, H7.c<? super R> cVar);
}
