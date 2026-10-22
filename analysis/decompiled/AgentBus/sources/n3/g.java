package n3;

import ab.x;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.util.Pair;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import q7.k;

/* loaded from: classes.dex */
public final class g extends SQLiteOpenHelper {

    /* renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f6823l = 0;

    /* renamed from: f, reason: collision with root package name */
    public final Context f6824f;

    /* renamed from: g, reason: collision with root package name */
    public final d f6825g;

    /* renamed from: h, reason: collision with root package name */
    public final x f6826h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f6827i;

    /* renamed from: j, reason: collision with root package name */
    public final o3.a f6828j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f6829k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(Context context, String str, final d dVar, final x xVar) {
        String string;
        super(context, str, null, xVar.f668b, new DatabaseErrorHandler() { // from class: n3.e
            @Override // android.database.DatabaseErrorHandler
            public final void onCorruption(SQLiteDatabase sQLiteDatabase) {
                k.e(xVar, "$callback");
                int i2 = g.f6823l;
                k.d(sQLiteDatabase, "dbObj");
                c cVarB = ib.k.B(dVar, sQLiteDatabase);
                Log.e("SupportSQLite", "Corruption reported by sqlite on database: " + cVarB + ".path");
                SQLiteDatabase sQLiteDatabase2 = cVarB.f6817f;
                if (!sQLiteDatabase2.isOpen()) {
                    String path = sQLiteDatabase2.getPath();
                    if (path != null) {
                        x.c(path);
                        return;
                    }
                    return;
                }
                List<Pair<String, String>> attachedDbs = null;
                try {
                    try {
                        attachedDbs = sQLiteDatabase2.getAttachedDbs();
                    } catch (SQLiteException unused) {
                    }
                    try {
                        cVarB.close();
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
                            k.d(obj, "p.second");
                            x.c((String) obj);
                        }
                    } else {
                        String path2 = sQLiteDatabase2.getPath();
                        if (path2 != null) {
                            x.c(path2);
                        }
                    }
                }
            }
        });
        k.e(context, "context");
        k.e(xVar, "callback");
        this.f6824f = context;
        this.f6825g = dVar;
        this.f6826h = xVar;
        if (str == null) {
            string = UUID.randomUUID().toString();
            k.d(string, "randomUUID().toString()");
        } else {
            string = str;
        }
        this.f6828j = new o3.a(string, context.getCacheDir(), false);
    }

    public final c a(boolean z4) throws IOException {
        o3.a aVar = this.f6828j;
        try {
            aVar.a((this.f6829k || getDatabaseName() == null) ? false : true);
            this.f6827i = false;
            SQLiteDatabase sQLiteDatabaseD = d(z4);
            if (!this.f6827i) {
                c cVarB = ib.k.B(this.f6825g, sQLiteDatabaseD);
                aVar.b();
                return cVarB;
            }
            close();
            c cVarA = a(z4);
            aVar.b();
            return cVarA;
        } catch (Throwable th) {
            aVar.b();
            throw th;
        }
    }

    public final SQLiteDatabase b(boolean z4) {
        if (z4) {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            k.d(writableDatabase, "{\n                super.…eDatabase()\n            }");
            return writableDatabase;
        }
        SQLiteDatabase readableDatabase = getReadableDatabase();
        k.d(readableDatabase, "{\n                super.…eDatabase()\n            }");
        return readableDatabase;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
    public final void close() {
        o3.a aVar = this.f6828j;
        try {
            aVar.a(aVar.f7256a);
            super.close();
            this.f6825g.f6818a = null;
            this.f6829k = false;
        } finally {
            aVar.b();
        }
    }

    public final SQLiteDatabase d(boolean z4) throws Throwable {
        File parentFile;
        String databaseName = getDatabaseName();
        boolean z10 = this.f6829k;
        Context context = this.f6824f;
        if (databaseName != null && !z10 && (parentFile = context.getDatabasePath(databaseName).getParentFile()) != null) {
            parentFile.mkdirs();
            if (!parentFile.isDirectory()) {
                Log.w("SupportSQLite", "Invalid database parent file, not a directory: " + parentFile);
            }
        }
        try {
            return b(z4);
        } catch (Throwable unused) {
            super.close();
            try {
                Thread.sleep(500L);
            } catch (InterruptedException unused2) {
            }
            try {
                return this.b(z4);
            } catch (Throwable th) {
                super.close();
                if (!(th instanceof f)) {
                    if (th instanceof SQLiteException) {
                        throw th;
                    }
                    throw th;
                }
                f fVar = th;
                int iD = n.f.d(fVar.f6821f);
                Throwable th2 = fVar.f6822g;
                if (iD == 0 || iD == 1 || iD == 2 || iD == 3 || !(th2 instanceof SQLiteException)) {
                    throw th2;
                }
                context.deleteDatabase(databaseName);
                try {
                    return this.b(z4);
                } catch (f e10) {
                    throw e10.f6822g;
                }
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onConfigure(SQLiteDatabase sQLiteDatabase) {
        k.e(sQLiteDatabase, "db");
        boolean z4 = this.f6827i;
        x xVar = this.f6826h;
        if (!z4 && xVar.f668b != sQLiteDatabase.getVersion()) {
            sQLiteDatabase.setMaxSqlCacheSize(1);
        }
        try {
            ib.k.B(this.f6825g, sQLiteDatabase);
            xVar.getClass();
        } catch (Throwable th) {
            throw new f(1, th);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        k.e(sQLiteDatabase, "sqLiteDatabase");
        try {
            this.f6826h.g(ib.k.B(this.f6825g, sQLiteDatabase));
        } catch (Throwable th) {
            throw new f(2, th);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i2, int i10) {
        k.e(sQLiteDatabase, "db");
        this.f6827i = true;
        try {
            this.f6826h.i(ib.k.B(this.f6825g, sQLiteDatabase), i2, i10);
        } catch (Throwable th) {
            throw new f(4, th);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onOpen(SQLiteDatabase sQLiteDatabase) {
        k.e(sQLiteDatabase, "db");
        if (!this.f6827i) {
            try {
                this.f6826h.h(ib.k.B(this.f6825g, sQLiteDatabase));
            } catch (Throwable th) {
                throw new f(5, th);
            }
        }
        this.f6829k = true;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i10) {
        k.e(sQLiteDatabase, "sqLiteDatabase");
        this.f6827i = true;
        try {
            this.f6826h.i(ib.k.B(this.f6825g, sQLiteDatabase), i2, i10);
        } catch (Throwable th) {
            throw new f(3, th);
        }
    }
}
