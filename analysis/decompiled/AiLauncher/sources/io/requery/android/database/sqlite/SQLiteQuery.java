package io.requery.android.database.sqlite;

import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import io.requery.android.database.CursorWindow;
import x0.d;

/* loaded from: classes4.dex */
public final class SQLiteQuery extends SQLiteProgram {
    private static final String TAG = "SQLiteQuery";
    private final d mCancellationSignal;

    public SQLiteQuery(SQLiteDatabase sQLiteDatabase, String str, Object[] objArr, d dVar) {
        super(sQLiteDatabase, str, objArr, dVar);
        this.mCancellationSignal = dVar;
    }

    public int fillWindow(CursorWindow cursorWindow, int i10, int i11, boolean z10) {
        acquireReference();
        try {
            try {
                cursorWindow.acquireReference();
            } catch (Throwable th) {
                releaseReference();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
        } catch (SQLiteDatabaseCorruptException e10) {
            e = e10;
        } catch (SQLiteException e11) {
            e = e11;
        } catch (Throwable th3) {
            th = th3;
            Throwable th4 = th;
            cursorWindow.releaseReference();
            throw th4;
        }
        try {
            int iExecuteForCursorWindow = getSession().executeForCursorWindow(getSql(), getBindArgs(), cursorWindow, i10, i11, z10, getConnectionFlags(), this.mCancellationSignal);
            cursorWindow.releaseReference();
            releaseReference();
            return iExecuteForCursorWindow;
        } catch (SQLiteDatabaseCorruptException e12) {
            e = e12;
            SQLiteDatabaseCorruptException sQLiteDatabaseCorruptException = e;
            onCorruption();
            throw sQLiteDatabaseCorruptException;
        } catch (SQLiteException e13) {
            e = e13;
            SQLiteException sQLiteException = e;
            Log.e(TAG, "exception: " + sQLiteException.getMessage() + "; query: " + getSql());
            throw sQLiteException;
        }
    }

    public String toString() {
        return "SQLiteQuery: " + getSql();
    }
}
