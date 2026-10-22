package z4;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.lang.invoke.VarHandle;
import java.util.UUID;
import n3.r0;
import t.i1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class g extends SQLiteOpenHelper {

    /* renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f16395l = 0;

    /* renamed from: c, reason: collision with root package name */
    public final Context f16396c;

    /* renamed from: f, reason: collision with root package name */
    public final stepos.support.v7.app.f f16397f;

    /* renamed from: g, reason: collision with root package name */
    public final r0 f16398g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f16399h;
    public boolean i;

    /* renamed from: j, reason: collision with root package name */
    public final a5.a f16400j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f16401k;

    public g(Context context, String str, stepos.support.v7.app.f fVar, r0 r0Var, boolean z10) {
        String string;
        context.getClass();
        r0Var.getClass();
        int i = r0Var.f8745c;
        d dVar = new d();
        dVar.f16386a = r0Var;
        dVar.f16387b = fVar;
        VarHandle.storeStoreFence();
        super(context, str, null, i, dVar);
        this.f16396c = context;
        this.f16397f = fVar;
        this.f16398g = r0Var;
        this.f16399h = z10;
        if (str == null) {
            string = UUID.randomUUID().toString();
            string.getClass();
        } else {
            string = str;
        }
        this.f16400j = new a5.a(string, context.getCacheDir(), false);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
    public final void close() throws IOException {
        a5.a aVar = this.f16400j;
        try {
            aVar.a(aVar.f221a);
            super.close();
            this.f16397f.f12315f = null;
            this.f16401k = false;
        } finally {
            aVar.b();
        }
    }

    public final c d(boolean z10) throws IOException {
        a5.a aVar = this.f16400j;
        try {
            aVar.a((this.f16401k || getDatabaseName() == null) ? false : true);
            this.i = false;
            SQLiteDatabase sQLiteDatabaseE = e(z10);
            if (!this.i) {
                c cVarH = i1.h(this.f16397f, sQLiteDatabaseE);
                aVar.b();
                return cVarH;
            }
            close();
            c cVarD = d(z10);
            aVar.b();
            return cVarD;
        } catch (Throwable th) {
            aVar.b();
            throw th;
        }
    }

    public final SQLiteDatabase e(boolean z10) throws Throwable {
        SQLiteDatabase readableDatabase;
        SQLiteDatabase readableDatabase2;
        File parentFile;
        String databaseName = getDatabaseName();
        boolean z11 = this.f16401k;
        Context context = this.f16396c;
        if (databaseName != null && !z11 && (parentFile = context.getDatabasePath(databaseName).getParentFile()) != null) {
            parentFile.mkdirs();
            if (!parentFile.isDirectory()) {
                Log.w("SupportSQLite", "Invalid database parent file, not a directory: " + parentFile);
            }
        }
        try {
            if (z10) {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                writableDatabase.getClass();
                return writableDatabase;
            }
            SQLiteDatabase readableDatabase3 = getReadableDatabase();
            readableDatabase3.getClass();
            return readableDatabase3;
        } catch (Throwable unused) {
            try {
                Thread.sleep(500L);
            } catch (InterruptedException unused2) {
            }
            try {
                if (z10) {
                    readableDatabase2 = getWritableDatabase();
                    readableDatabase2.getClass();
                } else {
                    readableDatabase2 = getReadableDatabase();
                    readableDatabase2.getClass();
                }
                return readableDatabase2;
            } catch (Throwable th) {
                th = th;
                if (th instanceof e) {
                    e eVar = (e) th;
                    Throwable th2 = eVar.f16389f;
                    int iOrdinal = eVar.f16388c.ordinal();
                    if (iOrdinal == 0 || iOrdinal == 1 || iOrdinal == 2 || iOrdinal == 3) {
                        throw th2;
                    }
                    if (iOrdinal != 4) {
                        g5.f.a();
                        return null;
                    }
                    if (!(th2 instanceof SQLiteException)) {
                        throw th2;
                    }
                    th = th2;
                }
                if (!(th instanceof SQLiteException) || databaseName == null || !this.f16399h) {
                    throw th;
                }
                context.deleteDatabase(databaseName);
                try {
                    if (z10) {
                        readableDatabase = getWritableDatabase();
                        readableDatabase.getClass();
                    } else {
                        readableDatabase = getReadableDatabase();
                        readableDatabase.getClass();
                    }
                    return readableDatabase;
                } catch (e e10) {
                    throw e10.f16389f;
                }
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onConfigure(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.getClass();
        boolean z10 = this.i;
        r0 r0Var = this.f16398g;
        if (!z10 && r0Var.f8745c != sQLiteDatabase.getVersion()) {
            sQLiteDatabase.setMaxSqlCacheSize(1);
        }
        try {
            r0Var.b(i1.h(this.f16397f, sQLiteDatabase));
        } catch (Throwable th) {
            f fVar = f.f16390c;
            e eVar = new e(th);
            eVar.f16388c = fVar;
            eVar.f16389f = th;
            VarHandle.storeStoreFence();
            throw eVar;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.getClass();
        try {
            this.f16398g.c(i1.h(this.f16397f, sQLiteDatabase));
        } catch (Throwable th) {
            f fVar = f.f16391f;
            e eVar = new e(th);
            eVar.f16388c = fVar;
            eVar.f16389f = th;
            throw eVar;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i3) {
        sQLiteDatabase.getClass();
        this.i = true;
        try {
            this.f16398g.d(i1.h(this.f16397f, sQLiteDatabase), i, i3);
        } catch (Throwable th) {
            f fVar = f.f16393h;
            e eVar = new e(th);
            eVar.f16388c = fVar;
            eVar.f16389f = th;
            throw eVar;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onOpen(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.getClass();
        if (!this.i) {
            try {
                this.f16398g.f(i1.h(this.f16397f, sQLiteDatabase));
            } catch (Throwable th) {
                f fVar = f.i;
                e eVar = new e(th);
                eVar.f16388c = fVar;
                eVar.f16389f = th;
                throw eVar;
            }
        }
        this.f16401k = true;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i3) {
        sQLiteDatabase.getClass();
        this.i = true;
        try {
            this.f16398g.j(i1.h(this.f16397f, sQLiteDatabase), i, i3);
        } catch (Throwable th) {
            f fVar = f.f16392g;
            e eVar = new e(th);
            eVar.f16388c = fVar;
            eVar.f16389f = th;
            throw eVar;
        }
    }
}
