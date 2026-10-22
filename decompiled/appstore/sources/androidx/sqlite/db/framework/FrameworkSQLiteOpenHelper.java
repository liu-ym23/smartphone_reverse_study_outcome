package androidx.sqlite.db.framework;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.monitor.cloudmessage.consts.CloudControlInf;
import java.io.File;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public final class FrameworkSQLiteOpenHelper implements SupportSQLiteOpenHelper {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f4797h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f4798a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f4799b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SupportSQLiteOpenHelper.a f4800c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f4801d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f4802e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f4803f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f4804g;

    public static final class OpenHelper extends SQLiteOpenHelper {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final a f4805h = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f4806a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final b f4807b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final SupportSQLiteOpenHelper.a f4808c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f4809d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f4810e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final d0.a f4811f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f4812g;

        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0006\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$OpenHelper$CallbackException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "callbackName", "Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$OpenHelper$CallbackName;", "cause", "", "(Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$OpenHelper$CallbackName;Ljava/lang/Throwable;)V", "getCallbackName", "()Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$OpenHelper$CallbackName;", "getCause", "()Ljava/lang/Throwable;", "sqlite-framework_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class CallbackException extends RuntimeException {

            @NotNull
            private final CallbackName callbackName;

            @NotNull
            private final Throwable cause;

            public CallbackException(@NotNull CallbackName r10, @NotNull Throwable r11) {
                q.g(r10, "callbackName");
                q.g(r11, "cause");
                super(r11);
                this.callbackName = r10;
                this.cause = r11;
            }

            @NotNull
            public final CallbackName getCallbackName() {
                return this.callbackName;
            }

            @Override // java.lang.Throwable
            @NotNull
            public Throwable getCause() {
                return this.cause;
            }
        }

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

            static {
                ON_CONFIGURE = new CallbackName("ON_CONFIGURE", 0);
                ON_CREATE = new CallbackName("ON_CREATE", 1);
                ON_UPGRADE = new CallbackName("ON_UPGRADE", 2);
                ON_DOWNGRADE = new CallbackName("ON_DOWNGRADE", 3);
                ON_OPEN = new CallbackName("ON_OPEN", 4);
                $VALUES = $values();
            }

            private CallbackName(String r10, int r11) {
                super(r10, r11);
            }

            public static CallbackName valueOf(String r10) {
                return (CallbackName) Enum.valueOf(CallbackName.class, r10);
            }

            public static CallbackName[] values() {
                return (CallbackName[]) $VALUES.clone();
            }
        }

        public static final class a {
            public /* synthetic */ a(DefaultConstructorMarker r10) {
                this();
            }

            public final FrameworkSQLiteDatabase a(b r10, SQLiteDatabase r11) {
                q.g(r10, "refHolder");
                q.g(r11, "sqLiteDatabase");
                FrameworkSQLiteDatabase r12 = r10.a();
                if (r12 != null) goto L5;
            L6:
                FrameworkSQLiteDatabase r13 = new FrameworkSQLiteDatabase(r11);
                r10.b(r13);
                return r13;
            L5:
                if (r12.c(r11) == false) goto L6;
                return r12;
            }

            public a() {
            }
        }

        public /* synthetic */ class b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f4813a = null;

            static {
                int[] r10 = new int[CallbackName.values().length];
                r10[CallbackName.ON_CONFIGURE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
            L15:
                r10[CallbackName.ON_CREATE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
            L23:
                r10[CallbackName.ON_UPGRADE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
            L17:
                r10[CallbackName.ON_DOWNGRADE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
            L19:
                r10[CallbackName.ON_OPEN.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
            L8:
                f4813a = r10;
            }
        }

        static {
            f4805h = new a(null);
        }

        public OpenHelper(Context r10, String r11, final b r12, final SupportSQLiteOpenHelper.a r13, boolean r14) {
            q.g(r10, "context");
            q.g(r12, "dbRef");
            q.g(r13, "callback");
            super(r10, r11, null, r13.f4780a, new c(r13, r12));
            this.f4806a = r10;
            this.f4807b = r12;
            this.f4808c = r13;
            this.f4809d = r14;
            if (r11 != null) goto L5;
            r11 = UUID.randomUUID().toString();
            q.f(r11, "randomUUID().toString()");
        L5:
            this.f4811f = new d0.a(r11, r10.getCacheDir(), false);
        }

        public static /* synthetic */ void a(SupportSQLiteOpenHelper.a r10, b r11, SQLiteDatabase r12) {
            b(r10, r11, r12);
        }

        public static final void b(SupportSQLiteOpenHelper.a r10, b r11, SQLiteDatabase r12) {
            q.g(r10, "$callback");
            q.g(r11, "$dbRef");
            a r13 = f4805h;
            q.f(r12, "dbObj");
            r10.c(r13.a(r11, r12));
        }

        public final SupportSQLiteDatabase c(boolean r10) {
            d0.a r11 = this.f4811f;     // Catch: Throwable -> L7
            if (this.f4812g == false) goto L5;
        L9:
            boolean r12 = false;
        L10:
            r11.b(r12);     // Catch: Throwable -> L7
            this.f4810e = false;     // Catch: Throwable -> L7
            SQLiteDatabase r13 = f(r10);     // Catch: Throwable -> L7
            if (this.f4810e == false) goto L15;
            close();     // Catch: Throwable -> L7
            SupportSQLiteDatabase r14 = c(r10);     // Catch: Throwable -> L7
            this.f4811f.d();
            return r14;
        L15:
            FrameworkSQLiteDatabase r15 = d(r13);     // Catch: Throwable -> L7
            this.f4811f.d();
            return r15;
        L5:
            if (getDatabaseName() == null) goto L9;
            r12 = true;
        L7:
            th = move-exception;
            this.f4811f.d();
            throw th;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
        public void close() {
            d0.a.c(this.f4811f, false, 1, null);     // Catch: Throwable -> L5
            super.close();     // Catch: Throwable -> L5
            this.f4807b.b(null);     // Catch: Throwable -> L5
            this.f4812g = false;     // Catch: Throwable -> L5
            this.f4811f.d();
            return;
        L5:
            th = move-exception;
            this.f4811f.d();
            throw th;
        }

        public final FrameworkSQLiteDatabase d(SQLiteDatabase r10) {
            q.g(r10, "sqLiteDatabase");
            return f4805h.a(this.f4807b, r10);
        }

        public final SQLiteDatabase e(boolean r10) {
            if (r10 == false) goto L5;
            SQLiteDatabase r11 = super.getWritableDatabase();
            q.f(r11, "{\n                super.…eDatabase()\n            }");
            return r11;
        L5:
            SQLiteDatabase r12 = super.getReadableDatabase();
            q.f(r12, "{\n                super.…eDatabase()\n            }");
            return r12;
        }

        public final SQLiteDatabase f(boolean r10) {
            String r11 = getDatabaseName();
            boolean r12 = this.f4812g;
            if (r11 == null) goto L52;
            if (r12 == true) goto L52;
            File r13 = this.f4806a.getDatabasePath(r11).getParentFile();
            if (r13 == null) goto L52;
            r13.mkdirs();
            if (r13.isDirectory() == true) goto L52;
            Log.w("SupportSQLite", "Invalid database parent file, not a directory: " + r13);
        L52:
            return e(r10);
        L12:
            super.close();
            Thread.sleep(500);     // Catch: InterruptedException -> L45
        L48:
            return e(r10);
        L16:
            th = move-exception;
            super.close();
            if ((th instanceof CallbackException) == false) goto L33;
            CallbackException r14 = th;
            Throwable r15 = r14.getCause();
            int r16 = b.f4813a[r14.getCallbackName().ordinal()];
            if (r16 != 1) goto L22;
            throw r15;
        L22:
            if (r16 != 2) goto L24;
            throw r15;
        L24:
            if (r16 != 3) goto L26;
            throw r15;
        L26:
            if (r16 != 4) goto L28;
            throw r15;
        L28:
            if ((r15 instanceof SQLiteException) == true) goto L37;
            throw r15;
        L37:
            this.f4806a.deleteDatabase(r11);
            return e(r10);
        L40:
            e = move-exception;
            throw e.getCause();
        L33:
            if ((th instanceof SQLiteException) == false) goto L44;
            if (r11 != null) goto L36;
        L43:
            throw th;
        L36:
            if (this.f4809d == false) goto L43;
        L44:
            throw th;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onConfigure(SQLiteDatabase r10) {
            q.g(r10, CloudControlInf.DB);
            if (this.f4810e == false) goto L5;
        L12:
            this.f4808c.b(d(r10));     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            throw new CallbackException(CallbackName.ON_CONFIGURE, th);
        L5:
            if (this.f4808c.f4780a == r10.getVersion()) goto L12;
            r10.setMaxSqlCacheSize(1);
            goto L12
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase r10) {
            q.g(r10, "sqLiteDatabase");
            this.f4808c.d(d(r10));     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            throw new CallbackException(CallbackName.ON_CREATE, th);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase r10, int r11, int r12) {
            q.g(r10, CloudControlInf.DB);
            this.f4810e = true;
            this.f4808c.e(d(r10), r11, r12);     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            throw new CallbackException(CallbackName.ON_DOWNGRADE, th);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onOpen(SQLiteDatabase r10) {
            q.g(r10, CloudControlInf.DB);
            if (this.f4810e == false) goto L11;
        L9:
            this.f4812g = true;
            return;
        L11:
            this.f4808c.f(d(r10));     // Catch: Throwable -> L6
        L6:
            th = move-exception;
            throw new CallbackException(CallbackName.ON_OPEN, th);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase r10, int r11, int r12) {
            q.g(r10, "sqLiteDatabase");
            this.f4810e = true;
            this.f4808c.g(d(r10), r11, r12);     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            throw new CallbackException(CallbackName.ON_UPGRADE, th);
        }
    }

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public FrameworkSQLiteDatabase f4814a;

        public b(FrameworkSQLiteDatabase r10) {
            this.f4814a = r10;
        }

        public final FrameworkSQLiteDatabase a() {
            return this.f4814a;
        }

        public final void b(FrameworkSQLiteDatabase r10) {
            this.f4814a = r10;
        }
    }

    static {
        f4797h = new a(null);
    }

    public FrameworkSQLiteOpenHelper(Context r10, String r11, SupportSQLiteOpenHelper.a r12, boolean r13, boolean r14) {
        q.g(r10, "context");
        q.g(r12, "callback");
        this.f4798a = r10;
        this.f4799b = r11;
        this.f4800c = r12;
        this.f4801d = r13;
        this.f4802e = r14;
        this.f4803f = kotlin.b.b(new FrameworkSQLiteOpenHelper$lazyDelegate$1(this));
    }

    public static final /* synthetic */ boolean a(FrameworkSQLiteOpenHelper r10) {
        return r10.f4802e;
    }

    public static final /* synthetic */ SupportSQLiteOpenHelper.a b(FrameworkSQLiteOpenHelper r10) {
        return r10.f4800c;
    }

    public static final /* synthetic */ Context c(FrameworkSQLiteOpenHelper r10) {
        return r10.f4798a;
    }

    public static final /* synthetic */ String d(FrameworkSQLiteOpenHelper r10) {
        return r10.f4799b;
    }

    public static final /* synthetic */ boolean e(FrameworkSQLiteOpenHelper r10) {
        return r10.f4801d;
    }

    public static final /* synthetic */ boolean f(FrameworkSQLiteOpenHelper r10) {
        return r10.f4804g;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f4803f.isInitialized() == false) goto L6;
        g().close();
        return;
    }

    public final OpenHelper g() {
        return (OpenHelper) this.f4803f.getValue();
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public String getDatabaseName() {
        return this.f4799b;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public SupportSQLiteDatabase getReadableDatabase() {
        return g().c(false);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public SupportSQLiteDatabase getWritableDatabase() {
        return g().c(true);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public void setWriteAheadLoggingEnabled(boolean r10) {
        if (this.f4803f.isInitialized() == false) goto L5;
        c0.b.h(g(), r10);
    L5:
        this.f4804g = r10;
    }
}
