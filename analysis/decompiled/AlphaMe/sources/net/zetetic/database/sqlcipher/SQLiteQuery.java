package net.zetetic.database.sqlcipher;

import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteException;
import android.os.CancellationSignal;
import net.zetetic.database.CursorWindow;
import net.zetetic.database.Logger;

/* loaded from: classes2.dex */
public final class SQLiteQuery extends SQLiteProgram {
    private static final String TAG = "SQLiteQuery";
    private final CancellationSignal mCancellationSignal;

    public SQLiteQuery(SQLiteDatabase sQLiteDatabase, String str, CancellationSignal cancellationSignal) {
        super(sQLiteDatabase, str, null, cancellationSignal);
        this.mCancellationSignal = cancellationSignal;
    }

    public int fillWindow(CursorWindow cursorWindow, int i4, int i5, boolean z4) {
        acquireReference();
        try {
            cursorWindow.acquireReference();
            try {
                try {
                    return getSession().executeForCursorWindow(getSql(), getBindArgs(), cursorWindow, i4, i5, z4, getConnectionFlags(), this.mCancellationSignal);
                } catch (SQLiteDatabaseCorruptException e4) {
                    onCorruption(e4);
                    throw e4;
                } catch (SQLiteException e5) {
                    Logger.e(TAG, "exception: " + e5.getMessage() + "; query: " + getSql());
                    throw e5;
                }
            } finally {
                cursorWindow.releaseReference();
            }
        } finally {
            releaseReference();
        }
    }

    public String toString() {
        return "SQLiteQuery: " + getSql();
    }
}
