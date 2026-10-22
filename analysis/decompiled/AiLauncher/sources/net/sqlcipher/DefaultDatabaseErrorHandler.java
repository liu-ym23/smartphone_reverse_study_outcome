package net.sqlcipher;

import android.util.Log;
import java.io.File;
import net.sqlcipher.database.SQLiteDatabase;

/* loaded from: classes5.dex */
public final class DefaultDatabaseErrorHandler implements DatabaseErrorHandler {
    private final String TAG = DefaultDatabaseErrorHandler.class.getSimpleName();

    private void deleteDatabaseFile(String str) {
        if (str.equalsIgnoreCase(":memory:") || str.trim().length() == 0) {
            return;
        }
        Log.e(this.TAG, "deleting the database file: " + str);
        try {
            new File(str).delete();
        } catch (Exception e10) {
            Log.w(this.TAG, "delete failed: " + e10.getMessage());
        }
    }

    @Override // net.sqlcipher.DatabaseErrorHandler
    public void onCorruption(SQLiteDatabase sQLiteDatabase) {
        Log.e(this.TAG, "Corruption reported by sqlite on database, deleting: " + sQLiteDatabase.getPath());
        if (sQLiteDatabase.isOpen()) {
            Log.e(this.TAG, "Database object for corrupted database is already open, closing");
            try {
                sQLiteDatabase.close();
            } catch (Exception e10) {
                Log.e(this.TAG, "Exception closing Database object for corrupted database, ignored", e10);
            }
        }
        deleteDatabaseFile(sQLiteDatabase.getPath());
    }
}
