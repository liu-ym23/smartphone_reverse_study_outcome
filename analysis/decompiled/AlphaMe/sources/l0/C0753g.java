package l0;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.util.Pair;
import d.C0527a;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import k0.AbstractC0675c;
import k0.InterfaceC0674b;
import kotlin.jvm.internal.Intrinsics;
import m0.C0768a;

/* renamed from: l0.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0753g extends SQLiteOpenHelper {

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f13437h = 0;

    /* renamed from: a, reason: collision with root package name */
    public final Context f13438a;

    /* renamed from: b, reason: collision with root package name */
    public final C0527a f13439b;

    /* renamed from: c, reason: collision with root package name */
    public final AbstractC0675c f13440c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f13441d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f13442e;

    /* renamed from: f, reason: collision with root package name */
    public final C0768a f13443f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f13444g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0753g(Context context, String str, final C0527a dbRef, final AbstractC0675c callback, boolean z4) {
        super(context, str, null, callback.f13321a, new DatabaseErrorHandler() { // from class: l0.d
            @Override // android.database.DatabaseErrorHandler
            public final void onCorruption(SQLiteDatabase dbObj) {
                AbstractC0675c callback2 = callback;
                Intrinsics.checkNotNullParameter(callback2, "$callback");
                C0527a dbRef2 = dbRef;
                Intrinsics.checkNotNullParameter(dbRef2, "$dbRef");
                int i4 = C0753g.f13437h;
                Intrinsics.checkNotNullExpressionValue(dbObj, "dbObj");
                C0749c db = E3.b.i(dbRef2, dbObj);
                callback2.getClass();
                Intrinsics.checkNotNullParameter(db, "db");
                Log.e("SupportSQLite", "Corruption reported by sqlite on database: " + db + ".path");
                SQLiteDatabase sQLiteDatabase = db.f13426a;
                if (!sQLiteDatabase.isOpen()) {
                    String path = sQLiteDatabase.getPath();
                    if (path != null) {
                        AbstractC0675c.a(path);
                        return;
                    }
                    return;
                }
                List<Pair<String, String>> attachedDbs = null;
                try {
                    try {
                        attachedDbs = sQLiteDatabase.getAttachedDbs();
                    } finally {
                        if (attachedDbs != null) {
                            Iterator<T> it = attachedDbs.iterator();
                            while (it.hasNext()) {
                                Object obj = ((Pair) it.next()).second;
                                Intrinsics.checkNotNullExpressionValue(obj, "p.second");
                                AbstractC0675c.a((String) obj);
                            }
                        } else {
                            String path2 = sQLiteDatabase.getPath();
                            if (path2 != null) {
                                AbstractC0675c.a(path2);
                            }
                        }
                    }
                } catch (SQLiteException unused) {
                }
                try {
                    db.close();
                } catch (IOException unused2) {
                }
                if (attachedDbs != null) {
                    return;
                }
            }
        });
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dbRef, "dbRef");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.f13438a = context;
        this.f13439b = dbRef;
        this.f13440c = callback;
        this.f13441d = z4;
        if (str == null) {
            str = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(str, "randomUUID().toString()");
        }
        this.f13443f = new C0768a(str, context.getCacheDir());
    }

    public final InterfaceC0674b a(boolean z4) throws IOException {
        C0768a c0768a = this.f13443f;
        try {
            c0768a.a((this.f13444g || getDatabaseName() == null) ? false : true);
            this.f13442e = false;
            SQLiteDatabase sQLiteDatabaseE = e(z4);
            if (!this.f13442e) {
                C0749c c0749cB = b(sQLiteDatabaseE);
                c0768a.b();
                return c0749cB;
            }
            close();
            InterfaceC0674b interfaceC0674bA = a(z4);
            c0768a.b();
            return interfaceC0674bA;
        } catch (Throwable th) {
            c0768a.b();
            throw th;
        }
    }

    public final C0749c b(SQLiteDatabase sqLiteDatabase) {
        Intrinsics.checkNotNullParameter(sqLiteDatabase, "sqLiteDatabase");
        return E3.b.i(this.f13439b, sqLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
    public final void close() {
        C0768a c0768a = this.f13443f;
        try {
            HashMap map = C0768a.f13522d;
            c0768a.getClass();
            c0768a.a(false);
            super.close();
            this.f13439b.f12410b = null;
            this.f13444g = false;
        } finally {
            c0768a.b();
        }
    }

    public final SQLiteDatabase d(boolean z4) {
        if (z4) {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            Intrinsics.checkNotNullExpressionValue(writableDatabase, "{\n                super.…eDatabase()\n            }");
            return writableDatabase;
        }
        SQLiteDatabase readableDatabase = getReadableDatabase();
        Intrinsics.checkNotNullExpressionValue(readableDatabase, "{\n                super.…eDatabase()\n            }");
        return readableDatabase;
    }

    public final SQLiteDatabase e(boolean z4) throws Throwable {
        File parentFile;
        String databaseName = getDatabaseName();
        boolean z5 = this.f13444g;
        Context context = this.f13438a;
        if (databaseName != null && !z5 && (parentFile = context.getDatabasePath(databaseName).getParentFile()) != null) {
            parentFile.mkdirs();
            if (!parentFile.isDirectory()) {
                Log.w("SupportSQLite", "Invalid database parent file, not a directory: " + parentFile);
            }
        }
        try {
            return d(z4);
        } catch (Throwable unused) {
            super.close();
            try {
                Thread.sleep(500L);
            } catch (InterruptedException unused2) {
            }
            try {
                return this.d(z4);
            } catch (Throwable th) {
                super.close();
                if (th instanceof C0751e) {
                    C0751e c0751e = th;
                    int iOrdinal = c0751e.f13429a.ordinal();
                    Throwable th2 = c0751e.f13430b;
                    if (iOrdinal == 0 || iOrdinal == 1 || iOrdinal == 2 || iOrdinal == 3 || !(th2 instanceof SQLiteException)) {
                        throw th2;
                    }
                } else if (!(th instanceof SQLiteException) || databaseName == null || !this.f13441d) {
                    throw th;
                }
                context.deleteDatabase(databaseName);
                try {
                    return this.d(z4);
                } catch (C0751e e4) {
                    throw e4.f13430b;
                }
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onConfigure(SQLiteDatabase db) {
        Intrinsics.checkNotNullParameter(db, "db");
        boolean z4 = this.f13442e;
        AbstractC0675c abstractC0675c = this.f13440c;
        if (!z4 && abstractC0675c.f13321a != db.getVersion()) {
            db.setMaxSqlCacheSize(1);
        }
        try {
            abstractC0675c.b(b(db));
        } catch (Throwable th) {
            throw new C0751e(EnumC0752f.f13431a, th);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sqLiteDatabase) {
        Intrinsics.checkNotNullParameter(sqLiteDatabase, "sqLiteDatabase");
        try {
            this.f13440c.c(b(sqLiteDatabase));
        } catch (Throwable th) {
            throw new C0751e(EnumC0752f.f13432b, th);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onDowngrade(SQLiteDatabase db, int i4, int i5) {
        Intrinsics.checkNotNullParameter(db, "db");
        this.f13442e = true;
        try {
            this.f13440c.d(b(db), i4, i5);
        } catch (Throwable th) {
            throw new C0751e(EnumC0752f.f13434d, th);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onOpen(SQLiteDatabase db) {
        Intrinsics.checkNotNullParameter(db, "db");
        if (!this.f13442e) {
            try {
                this.f13440c.e(b(db));
            } catch (Throwable th) {
                throw new C0751e(EnumC0752f.f13435e, th);
            }
        }
        this.f13444g = true;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sqLiteDatabase, int i4, int i5) {
        Intrinsics.checkNotNullParameter(sqLiteDatabase, "sqLiteDatabase");
        this.f13442e = true;
        try {
            this.f13440c.f(b(sqLiteDatabase), i4, i5);
        } catch (Throwable th) {
            throw new C0751e(EnumC0752f.f13433c, th);
        }
    }
}
