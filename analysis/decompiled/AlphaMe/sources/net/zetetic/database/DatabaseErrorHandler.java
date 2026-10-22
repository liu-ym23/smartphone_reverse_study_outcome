package net.zetetic.database;

import android.database.sqlite.SQLiteException;
import net.zetetic.database.sqlcipher.SQLiteDatabase;

/* loaded from: classes2.dex */
public interface DatabaseErrorHandler {
    void onCorruption(SQLiteDatabase sQLiteDatabase, SQLiteException sQLiteException);
}
