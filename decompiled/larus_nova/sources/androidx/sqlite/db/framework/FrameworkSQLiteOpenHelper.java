package androidx.sqlite.db.framework;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteCompat;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.util.ProcessLock;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.File;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \"2\u00020\u0001:\u0003\"#$B5\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bJ\b\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\tH\u0017R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\u0004\u0018\u00010\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\u001a\u0004\b\u0013\u0010\u0014*\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u00020\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\u00020\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001aR\u000e\u0010\u001d\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper;", "Landroidx/sqlite/db/SupportSQLiteOpenHelper;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "name", "", "callback", "Landroidx/sqlite/db/SupportSQLiteOpenHelper$Callback;", "useNoBackupDirectory", "", "allowDataLossOnRecovery", "(Landroid/content/Context;Ljava/lang/String;Landroidx/sqlite/db/SupportSQLiteOpenHelper$Callback;ZZ)V", "databaseName", "getDatabaseName", "()Ljava/lang/String;", "delegate", "Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$OpenHelper;", "getDelegate$delegate", "(Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper;)Ljava/lang/Object;", "getDelegate", "()Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$OpenHelper;", "lazyDelegate", "Lkotlin/Lazy;", "readableDatabase", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "getReadableDatabase", "()Landroidx/sqlite/db/SupportSQLiteDatabase;", "writableDatabase", "getWritableDatabase", "writeAheadLoggingEnabled", "close", "", "setWriteAheadLoggingEnabled", "enabled", "Companion", "DBRefHolder", "OpenHelper", "sqlite-framework_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FrameworkSQLiteOpenHelper implements SupportSQLiteOpenHelper {
    public static final Companion Companion = null;
    private static final String TAG = "SupportSQLite";
    private final boolean allowDataLossOnRecovery;
    private final SupportSQLiteOpenHelper.Callback callback;
    private final Context context;
    private final Lazy<OpenHelper> lazyDelegate;
    private final String name;
    private final boolean useNoBackupDirectory;
    private boolean writeAheadLoggingEnabled;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$Companion;", "", "()V", "TAG", "", "sqlite-framework_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\b"}, d2 = {"Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$DBRefHolder;", "", "db", "Landroidx/sqlite/db/framework/FrameworkSQLiteDatabase;", "(Landroidx/sqlite/db/framework/FrameworkSQLiteDatabase;)V", "getDb", "()Landroidx/sqlite/db/framework/FrameworkSQLiteDatabase;", "setDb", "sqlite-framework_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class DBRefHolder {

        /* JADX INFO: renamed from: db, reason: collision with root package name */
        private FrameworkSQLiteDatabase f15673db;

        public final FrameworkSQLiteDatabase getDb() {
            return this.f15673db;
        }

        public DBRefHolder(FrameworkSQLiteDatabase r100) {
            this.f15673db = r100;
        }

        public final void setDb(FrameworkSQLiteDatabase r100) {
            this.f15673db = r100;
        }
    }

    @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\b\u0002\u0018\u0000 /2\u00020\u0001:\u0003-./B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u000bJ\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!J\u0010\u0010\"\u001a\u00020!2\u0006\u0010\u001d\u001a\u00020\u000bH\u0002J\u0010\u0010#\u001a\u00020!2\u0006\u0010\u001d\u001a\u00020\u000bH\u0002J\u0010\u0010$\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020!H\u0016J\u0010\u0010&\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020!H\u0016J \u0010'\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020!2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020)H\u0016J\u0010\u0010+\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020!H\u0016J \u0010,\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020!2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020)H\u0016R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$OpenHelper;", "Landroid/database/sqlite/SQLiteOpenHelper;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "name", "", "dbRef", "Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$DBRefHolder;", "callback", "Landroidx/sqlite/db/SupportSQLiteOpenHelper$Callback;", "allowDataLossOnRecovery", "", "(Landroid/content/Context;Ljava/lang/String;Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$DBRefHolder;Landroidx/sqlite/db/SupportSQLiteOpenHelper$Callback;Z)V", "getAllowDataLossOnRecovery", "()Z", "getCallback", "()Landroidx/sqlite/db/SupportSQLiteOpenHelper$Callback;", "getContext", "()Landroid/content/Context;", "getDbRef", "()Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$DBRefHolder;", "lock", "Landroidx/sqlite/util/ProcessLock;", "migrated", "opened", "close", "", "getSupportDatabase", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "writable", "getWrappedDb", "Landroidx/sqlite/db/framework/FrameworkSQLiteDatabase;", "sqLiteDatabase", "Landroid/database/sqlite/SQLiteDatabase;", "getWritableOrReadableDatabase", "innerGetDatabase", "onConfigure", "db", WidgetCostModule.TYPE_ON_CREATE, "onDowngrade", "oldVersion", "", "newVersion", "onOpen", "onUpgrade", "CallbackException", "CallbackName", "Companion", "sqlite-framework_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class OpenHelper extends SQLiteOpenHelper {
        public static final Companion Companion = null;
        private final boolean allowDataLossOnRecovery;
        private final SupportSQLiteOpenHelper.Callback callback;
        private final Context context;
        private final DBRefHolder dbRef;
        private final ProcessLock lock;
        private boolean migrated;
        private boolean opened;

        /* JADX INFO: loaded from: classes6.dex */
        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0006\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$OpenHelper$CallbackException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "callbackName", "Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$OpenHelper$CallbackName;", "cause", "", "(Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$OpenHelper$CallbackName;Ljava/lang/Throwable;)V", "getCallbackName", "()Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$OpenHelper$CallbackName;", "getCause", "()Ljava/lang/Throwable;", "sqlite-framework_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class CallbackException extends RuntimeException {
            private final CallbackName callbackName;
            private final Throwable cause;

            public final CallbackName getCallbackName() {
                return this.callbackName;
            }

            @Override // java.lang.Throwable
            public Throwable getCause() {
                return this.cause;
            }

            public CallbackException(CallbackName r100, Throwable r101) {
                Intrinsics.checkNotNullParameter(r100, "callbackName");
                Intrinsics.checkNotNullParameter(r101, "cause");
                super(r101);
                this.callbackName = r100;
                this.cause = r101;
            }
        }

        /* JADX INFO: loaded from: classes17.dex */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$OpenHelper$CallbackName;", "", "(Ljava/lang/String;I)V", "ON_CONFIGURE", "ON_CREATE", "ON_UPGRADE", "ON_DOWNGRADE", "ON_OPEN", "sqlite-framework_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final enum CallbackName extends Enum<CallbackName> {
            private static final /* synthetic */ CallbackName[] $VALUES = null;
            public static final CallbackName ON_CONFIGURE = null;
            public static final CallbackName ON_CREATE = null;
            public static final CallbackName ON_DOWNGRADE = null;
            public static final CallbackName ON_OPEN = null;
            public static final CallbackName ON_UPGRADE = null;

            private static final /* synthetic */ CallbackName[] $values() {
                return new CallbackName[]{ON_CONFIGURE, ON_CREATE, ON_UPGRADE, ON_DOWNGRADE, ON_OPEN};
            }

            public static CallbackName valueOf(String r100) {
                return (CallbackName) r27.a.a(CallbackName.class, r100);
            }

            public static CallbackName[] values() {
                return (CallbackName[]) $VALUES.clone();
            }

            static {
                ON_CONFIGURE = new CallbackName("ON_CONFIGURE", 0);
                ON_CREATE = new CallbackName("ON_CREATE", 1);
                ON_UPGRADE = new CallbackName("ON_UPGRADE", 2);
                ON_DOWNGRADE = new CallbackName("ON_DOWNGRADE", 3);
                ON_OPEN = new CallbackName("ON_OPEN", 4);
                $VALUES = $values();
            }

            private CallbackName(String r100, int r101) {
                super(r100, r101);
            }
        }

        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$OpenHelper$Companion;", "", "()V", "getWrappedDb", "Landroidx/sqlite/db/framework/FrameworkSQLiteDatabase;", "refHolder", "Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$DBRefHolder;", "sqLiteDatabase", "Landroid/database/sqlite/SQLiteDatabase;", "sqlite-framework_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r100) {
                this();
            }

            public final FrameworkSQLiteDatabase getWrappedDb(DBRefHolder r100, SQLiteDatabase r101) {
                Intrinsics.checkNotNullParameter(r100, "refHolder");
                Intrinsics.checkNotNullParameter(r101, "sqLiteDatabase");
                FrameworkSQLiteDatabase r102 = r100.getDb();
                if (r102 != null) goto L5;
            L6:
                FrameworkSQLiteDatabase r103 = new FrameworkSQLiteDatabase(r101);
                r100.setDb(r103);
                return r103;
            L5:
                if (r102.isDelegate(r101) == false) goto L6;
                return r102;
            }
        }

        /* JADX INFO: loaded from: classes17.dex */
        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

            static {
                int[] r100 = new int[CallbackName.values().length];
                r100[CallbackName.ON_CONFIGURE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
            L15:
                r100[CallbackName.ON_CREATE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
            L23:
                r100[CallbackName.ON_UPGRADE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
            L17:
                r100[CallbackName.ON_DOWNGRADE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
            L19:
                r100[CallbackName.ON_OPEN.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
            L8:
                $EnumSwitchMapping$0 = r100;
            }
        }

        static {
            Companion = new Companion(null);
        }

        public static /* synthetic */ void a(SupportSQLiteOpenHelper.Callback r100, DBRefHolder r101, SQLiteDatabase r102) {
            _init_$lambda$0(r100, r101, r102);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
        public void close() {
            ProcessLock.lock$default(this.lock, false, 1, null);     // Catch: Throwable -> L5
            super.close();     // Catch: Throwable -> L5
            this.dbRef.setDb(null);     // Catch: Throwable -> L5
            this.opened = false;     // Catch: Throwable -> L5
            this.lock.unlock();
            return;
        L5:
            th = move-exception;
            this.lock.unlock();
            throw th;
        }

        public final boolean getAllowDataLossOnRecovery() {
            return this.allowDataLossOnRecovery;
        }

        public final SupportSQLiteOpenHelper.Callback getCallback() {
            return this.callback;
        }

        public final Context getContext() {
            return this.context;
        }

        public final DBRefHolder getDbRef() {
            return this.dbRef;
        }

        private final SQLiteDatabase getWritableOrReadableDatabase(boolean r100) {
            if (r100 == false) goto L5;
            return getWritableDatabase();
        L5:
            return getReadableDatabase();
        }

        private final SQLiteDatabase innerGetDatabase(boolean r100) {
            String r101 = getDatabaseName();
            boolean r102 = this.opened;
            if (r101 == null) goto L50;
            if (r102 == true) goto L50;
            File r103 = this.context.getDatabasePath(r101).getParentFile();
            if (r103 == null) goto L50;
            r103.mkdirs();
            if (r103.isDirectory() == true) goto L50;
            r103.toString();
        L50:
            return getWritableOrReadableDatabase(r100);
        L12:
            super.close();
            Thread.sleep(500);     // Catch: InterruptedException -> L45
        L48:
            return getWritableOrReadableDatabase(r100);
        L16:
            th = move-exception;
            super.close();
            if ((th instanceof CallbackException) == false) goto L33;
            CallbackException r104 = th;
            Throwable r105 = r104.getCause();
            CallbackName r106 = r104.getCallbackName();
            int r107 = WhenMappings.$EnumSwitchMapping$0[r106.ordinal()];
            if (r107 != 1) goto L22;
            throw r105;
        L22:
            if (r107 != 2) goto L24;
            throw r105;
        L24:
            if (r107 != 3) goto L26;
            throw r105;
        L26:
            if (r107 != 4) goto L28;
            throw r105;
        L28:
            if ((r105 instanceof SQLiteException) == true) goto L37;
            throw r105;
        L37:
            this.context.deleteDatabase(r101);
            return getWritableOrReadableDatabase(r100);
        L40:
            e = move-exception;
            throw e.getCause();
        L33:
            if ((th instanceof SQLiteException) == false) goto L44;
            if (r101 != null) goto L36;
        L43:
            throw th;
        L36:
            if (this.allowDataLossOnRecovery == false) goto L43;
        L44:
            throw th;
        }

        public final SupportSQLiteDatabase getSupportDatabase(boolean r100) {
            ProcessLock r101 = this.lock;     // Catch: Throwable -> L16
            if (this.opened == false) goto L5;
        L7:
            boolean r102 = false;
        L8:
            r101.lock(r102);     // Catch: Throwable -> L16
            this.migrated = false;     // Catch: Throwable -> L16
            SQLiteDatabase r103 = innerGetDatabase(r100);     // Catch: Throwable -> L16
            if (this.migrated == false) goto L13;
            close();     // Catch: Throwable -> L16
            SupportSQLiteDatabase r104 = getSupportDatabase(r100);     // Catch: Throwable -> L16
            this.lock.unlock();
            return r104;
        L13:
            FrameworkSQLiteDatabase r105 = getWrappedDb(r103);     // Catch: Throwable -> L16
            this.lock.unlock();
            return r105;
        L5:
            if (getDatabaseName() == null) goto L7;
            r102 = true;
        L16:
            th = move-exception;
            this.lock.unlock();
            throw th;
        }

        public final FrameworkSQLiteDatabase getWrappedDb(SQLiteDatabase r100) {
            Intrinsics.checkNotNullParameter(r100, "sqLiteDatabase");
            return Companion.getWrappedDb(this.dbRef, r100);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onConfigure(SQLiteDatabase r100) {
            Intrinsics.checkNotNullParameter(r100, "db");
            if (this.migrated == false) goto L5;
        L12:
            this.callback.onConfigure(getWrappedDb(r100));     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            throw new CallbackException(CallbackName.ON_CONFIGURE, th);
        L5:
            if (this.callback.version == r100.getVersion()) goto L12;
            r100.setMaxSqlCacheSize(1);
            goto L12
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase r100) {
            Intrinsics.checkNotNullParameter(r100, "sqLiteDatabase");
            this.callback.onCreate(getWrappedDb(r100));     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            throw new CallbackException(CallbackName.ON_CREATE, th);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onOpen(SQLiteDatabase r100) {
            Intrinsics.checkNotNullParameter(r100, "db");
            if (this.migrated == false) goto L11;
        L9:
            this.opened = true;
            return;
        L11:
            this.callback.onOpen(getWrappedDb(r100));     // Catch: Throwable -> L6
        L6:
            th = move-exception;
            throw new CallbackException(CallbackName.ON_OPEN, th);
        }

        private static final void _init_$lambda$0(SupportSQLiteOpenHelper.Callback r100, DBRefHolder r101, SQLiteDatabase r102) {
            Intrinsics.checkNotNullParameter(r100, "$callback");
            Intrinsics.checkNotNullParameter(r101, "$dbRef");
            r100.onCorruption(Companion.getWrappedDb(r101, r102));
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase r100, int r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "db");
            this.migrated = true;
            this.callback.onDowngrade(getWrappedDb(r100), r101, r102);     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            throw new CallbackException(CallbackName.ON_DOWNGRADE, th);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase r100, int r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "sqLiteDatabase");
            this.migrated = true;
            this.callback.onUpgrade(getWrappedDb(r100), r101, r102);     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            throw new CallbackException(CallbackName.ON_UPGRADE, th);
        }

        public OpenHelper(Context r100, String r101, final DBRefHolder r110, final SupportSQLiteOpenHelper.Callback r111, boolean r112) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r110, "dbRef");
            Intrinsics.checkNotNullParameter(r111, "callback");
            super(r100, r101, null, r111.version, new c(r111, r110));
            this.context = r100;
            this.dbRef = r110;
            this.callback = r111;
            this.allowDataLossOnRecovery = r112;
            if (r101 != null) goto L5;
            r101 = UUID.randomUUID().toString();
        L5:
            this.lock = new ProcessLock(r101, r100.getCacheDir(), false);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public FrameworkSQLiteOpenHelper(Context r110, String r111, SupportSQLiteOpenHelper.Callback r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r112, "callback");
        this(r110, r111, r112, false, false, 24, null);
    }

    public FrameworkSQLiteOpenHelper(Context r110, String r111, SupportSQLiteOpenHelper.Callback r112, boolean r113) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r112, "callback");
        this(r110, r111, r112, r113, false, 16, null);
    }

    private final OpenHelper getDelegate() {
        return this.lazyDelegate.getValue();
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.lazyDelegate.isInitialized() == false) goto L6;
        getDelegate().close();
        return;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public SupportSQLiteDatabase getReadableDatabase() {
        return getDelegate().getSupportDatabase(false);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public SupportSQLiteDatabase getWritableDatabase() {
        return getDelegate().getSupportDatabase(true);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public String getDatabaseName() {
        return this.name;
    }

    public static final /* synthetic */ boolean access$getAllowDataLossOnRecovery$p(FrameworkSQLiteOpenHelper r100) {
        return r100.allowDataLossOnRecovery;
    }

    public static final /* synthetic */ SupportSQLiteOpenHelper.Callback access$getCallback$p(FrameworkSQLiteOpenHelper r100) {
        return r100.callback;
    }

    public static final /* synthetic */ Context access$getContext$p(FrameworkSQLiteOpenHelper r100) {
        return r100.context;
    }

    public static final /* synthetic */ String access$getName$p(FrameworkSQLiteOpenHelper r100) {
        return r100.name;
    }

    public static final /* synthetic */ boolean access$getUseNoBackupDirectory$p(FrameworkSQLiteOpenHelper r100) {
        return r100.useNoBackupDirectory;
    }

    public static final /* synthetic */ boolean access$getWriteAheadLoggingEnabled$p(FrameworkSQLiteOpenHelper r100) {
        return r100.writeAheadLoggingEnabled;
    }

    private static Object getDelegate$delegate(FrameworkSQLiteOpenHelper r100) {
        return r100.lazyDelegate;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public void setWriteAheadLoggingEnabled(boolean r100) {
        if (this.lazyDelegate.isInitialized() == false) goto L5;
        SupportSQLiteCompat.Api16Impl.setWriteAheadLoggingEnabled(getDelegate(), r100);
    L5:
        this.writeAheadLoggingEnabled = r100;
    }

    public FrameworkSQLiteOpenHelper(Context r100, String r101, SupportSQLiteOpenHelper.Callback r102, boolean r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "callback");
        this.context = r100;
        this.name = r101;
        this.callback = r102;
        this.useNoBackupDirectory = r103;
        this.allowDataLossOnRecovery = r104;
        this.lazyDelegate = LazyKt.lazy(new FrameworkSQLiteOpenHelper$lazyDelegate$1(this));
    }

    public /* synthetic */ FrameworkSQLiteOpenHelper(Context r100, String r101, SupportSQLiteOpenHelper.Callback r110, boolean r111, boolean r112, int r113, DefaultConstructorMarker r114) {
        if ((r113 & 8) == 0) goto L5;
        boolean r102 = false;
    L7:
        if ((r113 & 16) == 0) goto L9;
        boolean r103 = false;
    L10:
        this(r100, r101, r110, r102, r103);
        return;
    L9:
        r103 = r112;
        goto L10
    L5:
        r102 = r111;
        goto L7
    }
}
