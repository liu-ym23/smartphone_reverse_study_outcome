package androidx.sqlite.db.framework;

import Y8.h;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper;
import com.autonavi.aps.amapapi.config.Const;
import h9.InterfaceC4149a;
import j1.C4755b;
import j1.InterfaceC4756c;
import j1.InterfaceC4757d;
import java.io.File;
import java.io.IOException;
import java.util.UUID;
import k1.C4803e;
import kotlin.C4848b;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.a;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import m1.C4892a;
import p9.InterfaceC5063a;
import x5.d;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\b\u0000\u0018\u0000 02\u00020\u0001:\u00031\u0013\u0015B7\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\n\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001aR\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\u001aR\u0016\u0010%\u001a\u0004\u0018\u00010\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0014\u0010)\u001a\u00020&8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0014\u0010+\u001a\u00020&8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b*\u0010(R\u001b\u0010/\u001a\u00020\u001d8BX\u0082\u0084\u0002¢\u0006\f\u001a\u0004\b\u001b\u0010,*\u0004\b-\u0010.¨\u00062"}, d2 = {"Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper;", "Lj1/d;", "Landroid/content/Context;", "context", "", "name", "Lj1/d$a;", "callback", "", "useNoBackupDirectory", "allowDataLossOnRecovery", "<init>", "(Landroid/content/Context;Ljava/lang/String;Lj1/d$a;ZZ)V", d.EXTRA_ENABLED, "LY8/t;", "setWriteAheadLoggingEnabled", "(Z)V", "close", "()V", Const.INTENT_KEY_APIKEY, "Landroid/content/Context;", Const.INTENT_KEY_PKGNAME, "Ljava/lang/String;", "c", "Lj1/d$a;", Const.INTENT_KEY_UMID, "Z", "e", "LY8/h;", "Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$OpenHelper;", "f", "LY8/h;", "lazyDelegate", Const.INTENT_KEY_BACKGROUND_COMMAND, "writeAheadLoggingEnabled", "getDatabaseName", "()Ljava/lang/String;", "databaseName", "Lj1/c;", "getWritableDatabase", "()Lj1/c;", "writableDatabase", "getReadableDatabase", "readableDatabase", "()Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$OpenHelper;", "getDelegate$delegate", "(Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper;)Ljava/lang/Object;", "delegate", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "OpenHelper", "sqlite-framework"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FrameworkSQLiteOpenHelper implements InterfaceC4757d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final String name;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC4757d.a callback;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final boolean useNoBackupDirectory;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final boolean allowDataLossOnRecovery;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final h<OpenHelper> lazyDelegate;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public boolean writeAheadLoggingEnabled;

    @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u0000 ?2\u00020\u0001:\u0003@A(B1\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\n¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J'\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010 \u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u0012H\u0016¢\u0006\u0004\b \u0010\u0019J'\u0010!\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001aH\u0016¢\u0006\u0004\b!\u0010\u001eJ\u0017\u0010\"\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\"\u0010\u0019J\u000f\u0010#\u001a\u00020\u0017H\u0016¢\u0006\u0004\b#\u0010$J\u0017\u0010%\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\nH\u0002¢\u0006\u0004\b%\u0010&J\u0017\u0010'\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\nH\u0002¢\u0006\u0004\b'\u0010&R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u0016\u00109\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00105R\u0014\u0010=\u001a\u00020:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010>\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u00105¨\u0006B"}, d2 = {"Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$OpenHelper;", "Landroid/database/sqlite/SQLiteOpenHelper;", "Landroid/content/Context;", "context", "", "name", "Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$b;", "dbRef", "Lj1/d$a;", "callback", "", "allowDataLossOnRecovery", "<init>", "(Landroid/content/Context;Ljava/lang/String;Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$b;Lj1/d$a;Z)V", "writable", "Lj1/c;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Z)Lj1/c;", "Landroid/database/sqlite/SQLiteDatabase;", "sqLiteDatabase", "Lk1/e;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Landroid/database/sqlite/SQLiteDatabase;)Lk1/e;", "LY8/t;", "onCreate", "(Landroid/database/sqlite/SQLiteDatabase;)V", "", "oldVersion", "newVersion", "onUpgrade", "(Landroid/database/sqlite/SQLiteDatabase;II)V", "db", "onConfigure", "onDowngrade", "onOpen", "close", "()V", "m", "(Z)Landroid/database/sqlite/SQLiteDatabase;", "l", Const.INTENT_KEY_APIKEY, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", Const.INTENT_KEY_PKGNAME, "Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$b;", "getDbRef", "()Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$b;", "c", "Lj1/d$a;", "getCallback", "()Lj1/d$a;", Const.INTENT_KEY_UMID, "Z", "getAllowDataLossOnRecovery", "()Z", "e", "migrated", "Lm1/a;", "f", "Lm1/a;", "lock", "opened", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "CallbackException", "CallbackName", "sqlite-framework"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class OpenHelper extends SQLiteOpenHelper {

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final Context context;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final b dbRef;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public final InterfaceC4757d.a callback;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        public final boolean allowDataLossOnRecovery;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        public boolean migrated;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        public final C4892a lock;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        public boolean opened;

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u000b\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u001a\u0010\u0006\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$OpenHelper$CallbackException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$OpenHelper$CallbackName;", "callbackName", "", "cause", "<init>", "(Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$OpenHelper$CallbackName;Ljava/lang/Throwable;)V", Const.INTENT_KEY_APIKEY, "Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$OpenHelper$CallbackName;", "()Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$OpenHelper$CallbackName;", Const.INTENT_KEY_PKGNAME, "Ljava/lang/Throwable;", "getCause", "()Ljava/lang/Throwable;", "sqlite-framework"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class CallbackException extends RuntimeException {

            /* renamed from: a, reason: collision with root package name and from kotlin metadata */
            public final CallbackName callbackName;

            /* renamed from: b, reason: collision with root package name and from kotlin metadata */
            public final Throwable cause;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public CallbackException(CallbackName callbackName, Throwable cause) {
                super(cause);
                p.i(callbackName, "callbackName");
                p.i(cause, "cause");
                this.callbackName = callbackName;
                this.cause = cause;
            }

            /* renamed from: a, reason: from getter */
            public final CallbackName getCallbackName() {
                return this.callbackName;
            }

            @Override // java.lang.Throwable
            public Throwable getCause() {
                return this.cause;
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$OpenHelper$CallbackName;", "", "<init>", "(Ljava/lang/String;I)V", "ON_CONFIGURE", "ON_CREATE", "ON_UPGRADE", "ON_DOWNGRADE", "ON_OPEN", "sqlite-framework"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class CallbackName {
            private static final /* synthetic */ InterfaceC4149a $ENTRIES;
            private static final /* synthetic */ CallbackName[] $VALUES;
            public static final CallbackName ON_CONFIGURE = new CallbackName("ON_CONFIGURE", 0);
            public static final CallbackName ON_CREATE = new CallbackName("ON_CREATE", 1);
            public static final CallbackName ON_UPGRADE = new CallbackName("ON_UPGRADE", 2);
            public static final CallbackName ON_DOWNGRADE = new CallbackName("ON_DOWNGRADE", 3);
            public static final CallbackName ON_OPEN = new CallbackName("ON_OPEN", 4);

            private static final /* synthetic */ CallbackName[] $values() {
                return new CallbackName[]{ON_CONFIGURE, ON_CREATE, ON_UPGRADE, ON_DOWNGRADE, ON_OPEN};
            }

            static {
                CallbackName[] callbackNameArr$values = $values();
                $VALUES = callbackNameArr$values;
                $ENTRIES = a.a(callbackNameArr$values);
            }

            private CallbackName(String str, int i10) {
            }

            public static InterfaceC4149a<CallbackName> getEntries() {
                return $ENTRIES;
            }

            public static CallbackName valueOf(String str) {
                return (CallbackName) Enum.valueOf(CallbackName.class, str);
            }

            public static CallbackName[] values() {
                return (CallbackName[]) $VALUES.clone();
            }
        }

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$OpenHelper$a;", "", "<init>", "()V", "Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$b;", "refHolder", "Landroid/database/sqlite/SQLiteDatabase;", "sqLiteDatabase", "Lk1/e;", Const.INTENT_KEY_APIKEY, "(Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$b;Landroid/database/sqlite/SQLiteDatabase;)Lk1/e;", "sqlite-framework"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* renamed from: androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper$OpenHelper$a, reason: from kotlin metadata */
        public static final class Companion {
            public /* synthetic */ Companion(i iVar) {
                this();
            }

            public final C4803e a(b refHolder, SQLiteDatabase sqLiteDatabase) {
                p.i(refHolder, "refHolder");
                p.i(sqLiteDatabase, "sqLiteDatabase");
                C4803e db2 = refHolder.getDb();
                if (db2 != null && db2.J(sqLiteDatabase)) {
                    return db2;
                }
                C4803e c4803e = new C4803e(sqLiteDatabase);
                refHolder.b(c4803e);
                return c4803e;
            }

            public Companion() {
            }
        }

        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        public static final /* synthetic */ class b {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f14945a;

            static {
                int[] iArr = new int[CallbackName.values().length];
                try {
                    iArr[CallbackName.ON_CONFIGURE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[CallbackName.ON_CREATE.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[CallbackName.ON_UPGRADE.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[CallbackName.ON_DOWNGRADE.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[CallbackName.ON_OPEN.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                f14945a = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OpenHelper(Context context, String str, final b dbRef, final InterfaceC4757d.a callback, boolean z10) {
            String string;
            super(context, str, null, callback.version, new DatabaseErrorHandler() { // from class: k1.g
                @Override // android.database.DatabaseErrorHandler
                public final void onCorruption(SQLiteDatabase sQLiteDatabase) {
                    FrameworkSQLiteOpenHelper.OpenHelper.e(callback, dbRef, sQLiteDatabase);
                }
            });
            p.i(context, "context");
            p.i(dbRef, "dbRef");
            p.i(callback, "callback");
            this.context = context;
            this.dbRef = dbRef;
            this.callback = callback;
            this.allowDataLossOnRecovery = z10;
            if (str == null) {
                string = UUID.randomUUID().toString();
                p.h(string, "toString(...)");
            } else {
                string = str;
            }
            this.lock = new C4892a(string, context.getCacheDir(), false);
        }

        public static final void e(InterfaceC4757d.a aVar, b bVar, SQLiteDatabase sQLiteDatabase) {
            Companion companion = INSTANCE;
            p.f(sQLiteDatabase);
            aVar.c(companion.a(bVar, sQLiteDatabase));
        }

        @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
        public void close() throws IOException {
            try {
                C4892a.c(this.lock, false, 1, null);
                super.close();
                this.dbRef.b(null);
                this.opened = false;
            } finally {
                this.lock.d();
            }
        }

        public final InterfaceC4756c g(boolean writable) throws IOException {
            InterfaceC4756c interfaceC4756cI;
            try {
                this.lock.b((this.opened || getDatabaseName() == null) ? false : true);
                this.migrated = false;
                SQLiteDatabase sQLiteDatabaseM = m(writable);
                if (this.migrated) {
                    close();
                    interfaceC4756cI = g(writable);
                } else {
                    interfaceC4756cI = i(sQLiteDatabaseM);
                }
                this.lock.d();
                return interfaceC4756cI;
            } catch (Throwable th) {
                this.lock.d();
                throw th;
            }
        }

        public final C4803e i(SQLiteDatabase sqLiteDatabase) {
            p.i(sqLiteDatabase, "sqLiteDatabase");
            return INSTANCE.a(this.dbRef, sqLiteDatabase);
        }

        public final SQLiteDatabase l(boolean writable) {
            if (writable) {
                SQLiteDatabase writableDatabase = super.getWritableDatabase();
                p.f(writableDatabase);
                return writableDatabase;
            }
            SQLiteDatabase readableDatabase = super.getReadableDatabase();
            p.f(readableDatabase);
            return readableDatabase;
        }

        public final SQLiteDatabase m(boolean writable) throws Throwable {
            File parentFile;
            String databaseName = getDatabaseName();
            boolean z10 = this.opened;
            if (databaseName != null && !z10 && (parentFile = this.context.getDatabasePath(databaseName).getParentFile()) != null) {
                parentFile.mkdirs();
                if (!parentFile.isDirectory()) {
                    Log.w("SupportSQLite", "Invalid database parent file, not a directory: " + parentFile);
                }
            }
            try {
                return l(writable);
            } catch (Throwable unused) {
                try {
                    Thread.sleep(500L);
                } catch (InterruptedException unused2) {
                }
                try {
                    return this.l(writable);
                } catch (Throwable th) {
                    th = th;
                    if (th instanceof CallbackException) {
                        CallbackException callbackException = (CallbackException) th;
                        Throwable cause = callbackException.getCause();
                        int i10 = b.f14945a[callbackException.getCallbackName().ordinal()];
                        if (i10 == 1 || i10 == 2 || i10 == 3 || i10 == 4) {
                            throw cause;
                        }
                        if (i10 != 5) {
                            throw new NoWhenBranchMatchedException();
                        }
                        if (!(cause instanceof SQLiteException)) {
                            throw cause;
                        }
                        th = cause;
                    }
                    if (!(th instanceof SQLiteException) || databaseName == null || !this.allowDataLossOnRecovery) {
                        throw th;
                    }
                    this.context.deleteDatabase(databaseName);
                    try {
                        return this.l(writable);
                    } catch (CallbackException e10) {
                        throw e10.getCause();
                    }
                }
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onConfigure(SQLiteDatabase db2) {
            p.i(db2, "db");
            if (!this.migrated && this.callback.version != db2.getVersion()) {
                db2.setMaxSqlCacheSize(1);
            }
            try {
                this.callback.b(i(db2));
            } catch (Throwable th) {
                throw new CallbackException(CallbackName.ON_CONFIGURE, th);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            p.i(sqLiteDatabase, "sqLiteDatabase");
            try {
                this.callback.d(i(sqLiteDatabase));
            } catch (Throwable th) {
                throw new CallbackException(CallbackName.ON_CREATE, th);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase db2, int oldVersion, int newVersion) {
            p.i(db2, "db");
            this.migrated = true;
            try {
                this.callback.e(i(db2), oldVersion, newVersion);
            } catch (Throwable th) {
                throw new CallbackException(CallbackName.ON_DOWNGRADE, th);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onOpen(SQLiteDatabase db2) {
            p.i(db2, "db");
            if (!this.migrated) {
                try {
                    this.callback.f(i(db2));
                } catch (Throwable th) {
                    throw new CallbackException(CallbackName.ON_OPEN, th);
                }
            }
            this.opened = true;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
            p.i(sqLiteDatabase, "sqLiteDatabase");
            this.migrated = true;
            try {
                this.callback.g(i(sqLiteDatabase), oldVersion, newVersion);
            } catch (Throwable th) {
                throw new CallbackException(CallbackName.ON_UPGRADE, th);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\b\"\u0004\b\t\u0010\u0005¨\u0006\n"}, d2 = {"Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$b;", "", "Lk1/e;", "db", "<init>", "(Lk1/e;)V", Const.INTENT_KEY_APIKEY, "Lk1/e;", "()Lk1/e;", Const.INTENT_KEY_PKGNAME, "sqlite-framework"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public C4803e db;

        public b(C4803e c4803e) {
            this.db = c4803e;
        }

        /* renamed from: a, reason: from getter */
        public final C4803e getDb() {
            return this.db;
        }

        public final void b(C4803e c4803e) {
            this.db = c4803e;
        }
    }

    public FrameworkSQLiteOpenHelper(Context context, String str, InterfaceC4757d.a callback, boolean z10, boolean z11) {
        p.i(context, "context");
        p.i(callback, "callback");
        this.context = context;
        this.name = str;
        this.callback = callback;
        this.useNoBackupDirectory = z10;
        this.allowDataLossOnRecovery = z11;
        this.lazyDelegate = C4848b.b(new InterfaceC5063a() { // from class: k1.f
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return FrameworkSQLiteOpenHelper.g(this.f34584a);
            }
        });
    }

    public static final OpenHelper g(FrameworkSQLiteOpenHelper frameworkSQLiteOpenHelper) {
        OpenHelper openHelper;
        if (frameworkSQLiteOpenHelper.name == null || !frameworkSQLiteOpenHelper.useNoBackupDirectory) {
            openHelper = new OpenHelper(frameworkSQLiteOpenHelper.context, frameworkSQLiteOpenHelper.name, new b(null), frameworkSQLiteOpenHelper.callback, frameworkSQLiteOpenHelper.allowDataLossOnRecovery);
        } else {
            openHelper = new OpenHelper(frameworkSQLiteOpenHelper.context, new File(C4755b.a(frameworkSQLiteOpenHelper.context), frameworkSQLiteOpenHelper.name).getAbsolutePath(), new b(null), frameworkSQLiteOpenHelper.callback, frameworkSQLiteOpenHelper.allowDataLossOnRecovery);
        }
        openHelper.setWriteAheadLoggingEnabled(frameworkSQLiteOpenHelper.writeAheadLoggingEnabled);
        return openHelper;
    }

    @Override // j1.InterfaceC4757d, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.lazyDelegate.isInitialized()) {
            e().close();
        }
    }

    public final OpenHelper e() {
        return this.lazyDelegate.getValue();
    }

    @Override // j1.InterfaceC4757d
    /* renamed from: getDatabaseName, reason: from getter */
    public String getName() {
        return this.name;
    }

    @Override // j1.InterfaceC4757d
    public InterfaceC4756c getReadableDatabase() {
        return e().g(false);
    }

    @Override // j1.InterfaceC4757d
    public InterfaceC4756c getWritableDatabase() {
        return e().g(true);
    }

    @Override // j1.InterfaceC4757d
    public void setWriteAheadLoggingEnabled(boolean enabled) {
        if (this.lazyDelegate.isInitialized()) {
            e().setWriteAheadLoggingEnabled(enabled);
        }
        this.writeAheadLoggingEnabled = enabled;
    }
}
