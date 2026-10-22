package net.zetetic.database.sqlcipher;

import B7.a;
import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import androidx.compose.foundation.b;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.io.File;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import net.zetetic.database.DatabaseErrorHandler;
import net.zetetic.database.sqlcipher.SQLiteDatabase;

/* loaded from: classes4.dex */
public abstract class SQLiteOpenHelper implements SupportSQLiteOpenHelper {

    /* renamed from: a, reason: collision with root package name */
    public final Context f5404a;
    public final String b;
    public final SQLiteDatabase.CursorFactory c;
    public final int d;
    public final int e;
    public SQLiteDatabase f;
    public final byte[] g;
    public boolean h;
    public boolean i;

    /* renamed from: j, reason: collision with root package name */
    public final DatabaseErrorHandler f5405j;
    public final SQLiteDatabaseHook k;

    public SQLiteOpenHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
        this(context, str, cursorFactory, i, null);
    }

    public final SQLiteDatabase b(boolean z10) {
        Context context = this.f5404a;
        SQLiteDatabase sQLiteDatabase = this.f;
        if (sQLiteDatabase != null) {
            if (!sQLiteDatabase.isOpen()) {
                this.f = null;
            } else if (!z10 || !this.f.isReadOnly()) {
                return this.f;
            }
        }
        if (this.h) {
            throw new IllegalStateException("getDatabase called recursively");
        }
        SQLiteDatabase sQLiteDatabaseW = this.f;
        try {
            this.h = true;
            String str = this.b;
            if (sQLiteDatabaseW != null) {
                if (z10 && sQLiteDatabaseW.isReadOnly()) {
                    sQLiteDatabaseW.H();
                }
            } else if (str == null) {
                sQLiteDatabaseW = SQLiteDatabase.w(268435456, ":memory:", null, null, null, new byte[0]);
            } else {
                try {
                    String path = !str.startsWith("file:") ? context.getDatabasePath(str).getPath() : str;
                    File file = new File(new File(path).getParent());
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    sQLiteDatabaseW = SQLiteDatabase.w(this.i ? 805306368 : 268435456, path, this.f5405j, this.c, this.k, this.g);
                } catch (SQLiteException e) {
                    if (z10) {
                        throw e;
                    }
                    Log.e("SQLiteOpenHelper", "Couldn't open " + str + " for writing (will try read-only):", e);
                    sQLiteDatabaseW = SQLiteDatabase.w(1, context.getDatabasePath(str).getPath(), this.f5405j, this.c, this.k, this.g);
                }
            }
            c(sQLiteDatabaseW);
            int version = sQLiteDatabaseW.getVersion();
            int i = this.d;
            if (version != i) {
                if (sQLiteDatabaseW.isReadOnly()) {
                    throw new SQLiteException("Can't upgrade read-only database from version " + sQLiteDatabaseW.getVersion() + " to " + i + ": " + str);
                }
                if (version > 0 && version < this.e) {
                    File file2 = new File(sQLiteDatabaseW.getPath());
                    sQLiteDatabaseW.f();
                    if (!SQLiteDatabase.k(file2)) {
                        throw new IllegalStateException("Unable to delete obsolete database " + str + " with version " + version);
                    }
                    this.h = false;
                    SQLiteDatabase sQLiteDatabaseB = b(z10);
                    this.h = false;
                    if (sQLiteDatabaseW != this.f) {
                        sQLiteDatabaseW.f();
                    }
                    return sQLiteDatabaseB;
                }
                sQLiteDatabaseW.beginTransaction();
                try {
                    if (version == 0) {
                        f(sQLiteDatabaseW);
                    } else if (version > i) {
                        g(sQLiteDatabaseW, version, i);
                    } else {
                        k(sQLiteDatabaseW, version, i);
                    }
                    sQLiteDatabaseW.setVersion(i);
                    sQLiteDatabaseW.setTransactionSuccessful();
                    sQLiteDatabaseW.endTransaction();
                } catch (Throwable th) {
                    sQLiteDatabaseW.endTransaction();
                    throw th;
                }
            }
            i(sQLiteDatabaseW);
            if (sQLiteDatabaseW.isReadOnly()) {
                Log.w("SQLiteOpenHelper", "Opened " + str + " in read-only mode");
            }
            this.f = sQLiteDatabaseW;
            this.h = false;
            return sQLiteDatabaseW;
        } catch (Throwable th2) {
            this.h = false;
            if (sQLiteDatabaseW != null && sQLiteDatabaseW != this.f) {
                sQLiteDatabaseW.f();
            }
            throw th2;
        }
    }

    public void c(SQLiteDatabase sQLiteDatabase) {
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper, java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        if (this.h) {
            throw new IllegalStateException("Closed during initialization");
        }
        SQLiteDatabase sQLiteDatabase = this.f;
        if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
            this.f.f();
            this.f = null;
        }
    }

    public abstract void f(SQLiteDatabase sQLiteDatabase);

    public void g(SQLiteDatabase sQLiteDatabase, int i, int i6) {
        throw new SQLiteException(b.n(i, i6, "Can't downgrade database from version ", " to "));
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    /* renamed from: getDatabaseName */
    public final String getName() {
        return this.b;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public final SupportSQLiteDatabase getReadableDatabase() {
        SQLiteDatabase sQLiteDatabaseB;
        synchronized (this) {
            sQLiteDatabaseB = b(false);
        }
        return sQLiteDatabaseB;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public final SupportSQLiteDatabase getWritableDatabase() {
        SQLiteDatabase sQLiteDatabaseB;
        synchronized (this) {
            sQLiteDatabaseB = b(true);
        }
        return sQLiteDatabaseB;
    }

    public void i(SQLiteDatabase sQLiteDatabase) {
    }

    public abstract void k(SQLiteDatabase sQLiteDatabase, int i, int i6);

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public final void setWriteAheadLoggingEnabled(boolean z10) {
        synchronized (this) {
            try {
                if (this.i != z10) {
                    SQLiteDatabase sQLiteDatabase = this.f;
                    if (sQLiteDatabase != null && sQLiteDatabase.isOpen() && !this.f.isReadOnly()) {
                        if (z10) {
                            this.f.enableWriteAheadLogging();
                        } else {
                            this.f.disableWriteAheadLogging();
                        }
                    }
                    this.i = z10;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public SQLiteOpenHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i, DatabaseErrorHandler databaseErrorHandler) {
        this(context, str, cursorFactory, i, 0, databaseErrorHandler);
    }

    public SQLiteOpenHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i, int i6, DatabaseErrorHandler databaseErrorHandler) {
        this(context, str, new byte[0], cursorFactory, i, i6, databaseErrorHandler, (SQLiteDatabaseHook) null, false);
    }

    public SQLiteOpenHelper(Context context, String str, byte[] bArr, SQLiteDatabase.CursorFactory cursorFactory, int i, int i6, DatabaseErrorHandler databaseErrorHandler, SQLiteDatabaseHook sQLiteDatabaseHook, boolean z10) {
        if (i >= 1) {
            this.f5404a = context;
            this.b = str;
            this.g = bArr;
            this.c = cursorFactory;
            this.d = i;
            this.f5405j = databaseErrorHandler;
            this.k = sQLiteDatabaseHook;
            this.i = z10;
            this.e = Math.max(0, i6);
            return;
        }
        throw new IllegalArgumentException(a.h(i, "Version must be >= 1, was "));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public SQLiteOpenHelper(Context context, String str, String str2, SQLiteDatabase.CursorFactory cursorFactory, int i, int i6, DatabaseErrorHandler databaseErrorHandler, SQLiteDatabaseHook sQLiteDatabaseHook, boolean z10) {
        byte[] bArr;
        if (str2 != null && str2.length() != 0) {
            ByteBuffer byteBufferEncode = Charset.forName("UTF-8").encode(CharBuffer.wrap(str2));
            bArr = new byte[byteBufferEncode.limit()];
            byteBufferEncode.get(bArr);
        } else {
            bArr = new byte[0];
        }
        this(context, str, bArr, cursorFactory, i, i6, databaseErrorHandler, sQLiteDatabaseHook, z10);
    }
}
