package androidx.sqlite.db.framework;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.util.Pair;
import androidx.sqlite.db.framework.FrameworkSQLiteDatabase;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.jvm.internal.g;
import lb.d;
import y1.b;
import y1.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class FrameworkSQLiteOpenHelper implements c {

    /* renamed from: a, reason: collision with root package name */
    public final Context f2632a;

    /* renamed from: b, reason: collision with root package name */
    public final String f2633b;

    /* renamed from: c, reason: collision with root package name */
    public final c.a f2634c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f2635d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f2636e;
    public final d<OpenHelper> h;

    /* renamed from: j, reason: collision with root package name */
    public boolean f2637j;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class OpenHelper extends SQLiteOpenHelper {

        /* renamed from: k, reason: collision with root package name */
        public static final /* synthetic */ int f2638k = 0;

        /* renamed from: a, reason: collision with root package name */
        public final Context f2639a;

        /* renamed from: b, reason: collision with root package name */
        public final a f2640b;

        /* renamed from: c, reason: collision with root package name */
        public final c.a f2641c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f2642d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f2643e;
        public final a2.a h;

        /* renamed from: j, reason: collision with root package name */
        public boolean f2644j;

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public static final class CallbackException extends RuntimeException {

            /* renamed from: a, reason: collision with root package name */
            public final CallbackName f2645a;

            /* renamed from: b, reason: collision with root package name */
            public final Throwable f2646b;

            public CallbackException(CallbackName callbackName, Throwable th) {
                super(th);
                this.f2645a = callbackName;
                this.f2646b = th;
            }

            @Override // java.lang.Throwable
            public final Throwable getCause() {
                return this.f2646b;
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public static final class CallbackName {

            /* renamed from: a, reason: collision with root package name */
            public static final CallbackName f2647a;

            /* renamed from: b, reason: collision with root package name */
            public static final CallbackName f2648b;

            /* renamed from: c, reason: collision with root package name */
            public static final CallbackName f2649c;

            /* renamed from: d, reason: collision with root package name */
            public static final CallbackName f2650d;

            /* renamed from: e, reason: collision with root package name */
            public static final CallbackName f2651e;
            public static final /* synthetic */ CallbackName[] h;

            static {
                CallbackName callbackName = new CallbackName("ON_CONFIGURE", 0);
                f2647a = callbackName;
                CallbackName callbackName2 = new CallbackName("ON_CREATE", 1);
                f2648b = callbackName2;
                CallbackName callbackName3 = new CallbackName("ON_UPGRADE", 2);
                f2649c = callbackName3;
                CallbackName callbackName4 = new CallbackName("ON_DOWNGRADE", 3);
                f2650d = callbackName4;
                CallbackName callbackName5 = new CallbackName("ON_OPEN", 4);
                f2651e = callbackName5;
                h = new CallbackName[]{callbackName, callbackName2, callbackName3, callbackName4, callbackName5};
            }

            public CallbackName() {
                throw null;
            }

            public static CallbackName valueOf(String str) {
                return (CallbackName) Enum.valueOf(CallbackName.class, str);
            }

            public static CallbackName[] values() {
                return (CallbackName[]) h.clone();
            }
        }

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public static final class a {
            public static FrameworkSQLiteDatabase a(a refHolder, SQLiteDatabase sQLiteDatabase) {
                g.f(refHolder, "refHolder");
                FrameworkSQLiteDatabase frameworkSQLiteDatabase = refHolder.f2652a;
                if (frameworkSQLiteDatabase != null && frameworkSQLiteDatabase.f2630a.equals(sQLiteDatabase)) {
                    return frameworkSQLiteDatabase;
                }
                FrameworkSQLiteDatabase frameworkSQLiteDatabase2 = new FrameworkSQLiteDatabase(sQLiteDatabase);
                refHolder.f2652a = frameworkSQLiteDatabase2;
                return frameworkSQLiteDatabase2;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OpenHelper(Context context, String str, final a aVar, final c.a callback, boolean z) {
            String string;
            super(context, str, null, callback.f13967a, new DatabaseErrorHandler() { // from class: z1.b
                @Override // android.database.DatabaseErrorHandler
                public final void onCorruption(SQLiteDatabase dbObj) {
                    c.a callback2 = callback;
                    g.f(callback2, "$callback");
                    int i10 = FrameworkSQLiteOpenHelper.OpenHelper.f2638k;
                    g.e(dbObj, "dbObj");
                    FrameworkSQLiteDatabase frameworkSQLiteDatabaseA = FrameworkSQLiteOpenHelper.OpenHelper.a.a(aVar, dbObj);
                    Log.e("SupportSQLite", "Corruption reported by sqlite on database: " + frameworkSQLiteDatabaseA + ".path");
                    SQLiteDatabase sQLiteDatabase = frameworkSQLiteDatabaseA.f2630a;
                    if (!sQLiteDatabase.isOpen()) {
                        String path = sQLiteDatabase.getPath();
                        if (path != null) {
                            c.a.a(path);
                            return;
                        }
                        return;
                    }
                    List<Pair<String, String>> attachedDbs = null;
                    try {
                        try {
                            attachedDbs = sQLiteDatabase.getAttachedDbs();
                        } catch (SQLiteException unused) {
                        }
                        try {
                            frameworkSQLiteDatabaseA.close();
                        } catch (IOException unused2) {
                        }
                        if (attachedDbs != null) {
                            return;
                        }
                    } finally {
                        if (attachedDbs != null) {
                            Iterator<T> it = attachedDbs.iterator();
                            while (it.hasNext()) {
                                Object obj = ((Pair) it.next()).second;
                                g.e(obj, "p.second");
                                c.a.a((String) obj);
                            }
                        } else {
                            String path2 = sQLiteDatabase.getPath();
                            if (path2 != null) {
                                c.a.a(path2);
                            }
                        }
                    }
                }
            });
            g.f(context, "context");
            g.f(callback, "callback");
            this.f2639a = context;
            this.f2640b = aVar;
            this.f2641c = callback;
            this.f2642d = z;
            if (str == null) {
                string = UUID.randomUUID().toString();
                g.e(string, "randomUUID().toString()");
            } else {
                string = str;
            }
            this.h = new a2.a(string, context.getCacheDir(), false);
        }

        public final b a(boolean z) throws IOException {
            a2.a aVar = this.h;
            try {
                aVar.a((this.f2644j || getDatabaseName() == null) ? false : true);
                this.f2643e = false;
                SQLiteDatabase sQLiteDatabaseW = w(z);
                if (!this.f2643e) {
                    FrameworkSQLiteDatabase frameworkSQLiteDatabaseA = a.a(this.f2640b, sQLiteDatabaseW);
                    aVar.b();
                    return frameworkSQLiteDatabaseA;
                }
                close();
                b bVarA = a(z);
                aVar.b();
                return bVarA;
            } catch (Throwable th) {
                aVar.b();
                throw th;
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
        public final void close() throws IOException {
            a2.a aVar = this.h;
            try {
                aVar.a(aVar.f4a);
                super.close();
                this.f2640b.f2652a = null;
                this.f2644j = false;
            } finally {
                aVar.b();
            }
        }

        public final SQLiteDatabase o(boolean z) {
            if (z) {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                g.e(writableDatabase, "{\n                super.…eDatabase()\n            }");
                return writableDatabase;
            }
            SQLiteDatabase readableDatabase = getReadableDatabase();
            g.e(readableDatabase, "{\n                super.…eDatabase()\n            }");
            return readableDatabase;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onConfigure(SQLiteDatabase db2) {
            g.f(db2, "db");
            boolean z = this.f2643e;
            c.a aVar = this.f2641c;
            if (!z && aVar.f13967a != db2.getVersion()) {
                db2.setMaxSqlCacheSize(1);
            }
            try {
                aVar.b(a.a(this.f2640b, db2));
            } catch (Throwable th) {
                throw new CallbackException(CallbackName.f2647a, th);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onCreate(SQLiteDatabase sqLiteDatabase) {
            g.f(sqLiteDatabase, "sqLiteDatabase");
            try {
                this.f2641c.c(a.a(this.f2640b, sqLiteDatabase));
            } catch (Throwable th) {
                throw new CallbackException(CallbackName.f2648b, th);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onDowngrade(SQLiteDatabase db2, int i10, int i11) {
            g.f(db2, "db");
            this.f2643e = true;
            try {
                this.f2641c.d(a.a(this.f2640b, db2), i10, i11);
            } catch (Throwable th) {
                throw new CallbackException(CallbackName.f2650d, th);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onOpen(SQLiteDatabase db2) {
            g.f(db2, "db");
            if (!this.f2643e) {
                try {
                    this.f2641c.e(a.a(this.f2640b, db2));
                } catch (Throwable th) {
                    throw new CallbackException(CallbackName.f2651e, th);
                }
            }
            this.f2644j = true;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onUpgrade(SQLiteDatabase sqLiteDatabase, int i10, int i11) {
            g.f(sqLiteDatabase, "sqLiteDatabase");
            this.f2643e = true;
            try {
                this.f2641c.f(a.a(this.f2640b, sqLiteDatabase), i10, i11);
            } catch (Throwable th) {
                throw new CallbackException(CallbackName.f2649c, th);
            }
        }

        public final SQLiteDatabase w(boolean z) throws Throwable {
            File parentFile;
            String databaseName = getDatabaseName();
            boolean z3 = this.f2644j;
            Context context = this.f2639a;
            if (databaseName != null && !z3 && (parentFile = context.getDatabasePath(databaseName).getParentFile()) != null) {
                parentFile.mkdirs();
                if (!parentFile.isDirectory()) {
                    Log.w("SupportSQLite", "Invalid database parent file, not a directory: " + parentFile);
                }
            }
            try {
                return o(z);
            } catch (Throwable unused) {
                super.close();
                try {
                    Thread.sleep(500L);
                } catch (InterruptedException unused2) {
                }
                try {
                    return this.o(z);
                } catch (Throwable th) {
                    super.close();
                    if (th instanceof CallbackException) {
                        CallbackException callbackException = th;
                        int iOrdinal = callbackException.f2645a.ordinal();
                        Throwable th2 = callbackException.f2646b;
                        if (iOrdinal == 0 || iOrdinal == 1 || iOrdinal == 2 || iOrdinal == 3 || !(th2 instanceof SQLiteException)) {
                            throw th2;
                        }
                    } else if (!(th instanceof SQLiteException) || databaseName == null || !this.f2642d) {
                        throw th;
                    }
                    context.deleteDatabase(databaseName);
                    try {
                        return this.o(z);
                    } catch (CallbackException e10) {
                        throw e10.f2646b;
                    }
                }
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public FrameworkSQLiteDatabase f2652a = null;
    }

    public FrameworkSQLiteOpenHelper(Context context, String str, c.a callback, boolean z, boolean z3) {
        g.f(context, "context");
        g.f(callback, "callback");
        this.f2632a = context;
        this.f2633b = str;
        this.f2634c = callback;
        this.f2635d = z;
        this.f2636e = z3;
        this.h = kotlin.b.b(new zb.a<OpenHelper>() { // from class: androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper$lazyDelegate$1
            {
                super(0);
            }

            @Override // zb.a
            public final FrameworkSQLiteOpenHelper.OpenHelper invoke() {
                FrameworkSQLiteOpenHelper.OpenHelper openHelper;
                FrameworkSQLiteOpenHelper frameworkSQLiteOpenHelper = this.f2653a;
                String str2 = frameworkSQLiteOpenHelper.f2633b;
                if (str2 == null || !frameworkSQLiteOpenHelper.f2635d) {
                    openHelper = new FrameworkSQLiteOpenHelper.OpenHelper(frameworkSQLiteOpenHelper.f2632a, frameworkSQLiteOpenHelper.f2633b, new FrameworkSQLiteOpenHelper.a(), frameworkSQLiteOpenHelper.f2634c, frameworkSQLiteOpenHelper.f2636e);
                } else {
                    Context context2 = frameworkSQLiteOpenHelper.f2632a;
                    g.f(context2, "context");
                    File noBackupFilesDir = context2.getNoBackupFilesDir();
                    g.e(noBackupFilesDir, "context.noBackupFilesDir");
                    openHelper = new FrameworkSQLiteOpenHelper.OpenHelper(frameworkSQLiteOpenHelper.f2632a, new File(noBackupFilesDir, str2).getAbsolutePath(), new FrameworkSQLiteOpenHelper.a(), frameworkSQLiteOpenHelper.f2634c, frameworkSQLiteOpenHelper.f2636e);
                }
                openHelper.setWriteAheadLoggingEnabled(frameworkSQLiteOpenHelper.f2637j);
                return openHelper;
            }
        });
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        d<OpenHelper> dVar = this.h;
        if (dVar.a()) {
            dVar.getValue().close();
        }
    }

    @Override // y1.c
    public final b n0() {
        return this.h.getValue().a(true);
    }

    @Override // y1.c
    public final void setWriteAheadLoggingEnabled(boolean z) {
        d<OpenHelper> dVar = this.h;
        if (dVar.a()) {
            OpenHelper sQLiteOpenHelper = dVar.getValue();
            g.f(sQLiteOpenHelper, "sQLiteOpenHelper");
            sQLiteOpenHelper.setWriteAheadLoggingEnabled(z);
        }
        this.f2637j = z;
    }
}
