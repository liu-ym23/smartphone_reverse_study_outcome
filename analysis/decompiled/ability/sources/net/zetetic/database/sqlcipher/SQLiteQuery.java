package net.zetetic.database.sqlcipher;

import android.database.CursorWindow;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteException;
import android.os.CancellationSignal;
import android.util.Log;

/* loaded from: classes4.dex */
public final class SQLiteQuery extends SQLiteProgram {
    public final CancellationSignal i;

    public SQLiteQuery(SQLiteDatabase sQLiteDatabase, String str, CancellationSignal cancellationSignal) {
        super(sQLiteDatabase, str, null, cancellationSignal);
        this.i = cancellationSignal;
    }

    public final int l(CursorWindow cursorWindow, int i, int i6, boolean z10) {
        b();
        try {
            try {
                cursorWindow.acquireReference();
            } catch (Throwable th) {
                f();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
        } catch (SQLiteDatabaseCorruptException e) {
            e = e;
        } catch (SQLiteException e6) {
            e = e6;
        } catch (Throwable th3) {
            th = th3;
            Throwable th4 = th;
            cursorWindow.releaseReference();
            throw th4;
        }
        try {
            int iF = this.b.s().f(this.c, this.g, cursorWindow, i, i6, z10, i(), this.i);
            cursorWindow.releaseReference();
            f();
            return iF;
        } catch (SQLiteDatabaseCorruptException e9) {
            e = e9;
            SQLiteDatabaseCorruptException sQLiteDatabaseCorruptException = e;
            k();
            throw sQLiteDatabaseCorruptException;
        } catch (SQLiteException e10) {
            e = e10;
            SQLiteException sQLiteException = e;
            Log.e("SQLiteQuery", "exception: " + sQLiteException.getMessage() + "; query: " + this.c);
            throw sQLiteException;
        }
    }

    public final String toString() {
        return "SQLiteQuery: " + this.c;
    }
}
