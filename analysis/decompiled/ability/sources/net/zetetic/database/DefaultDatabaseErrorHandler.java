package net.zetetic.database;

import android.database.sqlite.SQLiteException;
import android.util.Log;
import android.util.Pair;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import net.zetetic.database.sqlcipher.SQLiteConnection;
import net.zetetic.database.sqlcipher.SQLiteDatabase;

/* loaded from: classes4.dex */
public final class DefaultDatabaseErrorHandler implements DatabaseErrorHandler {
    public static void b(String str) {
        if (str.equalsIgnoreCase(":memory:") || str.trim().length() == 0) {
            return;
        }
        Log.e("DefaultDatabaseErrorHandler", "deleting the database file: ".concat(str));
        try {
            SQLiteDatabase.k(new File(str));
        } catch (Exception e) {
            Log.w("DefaultDatabaseErrorHandler", "delete failed: " + e.getMessage());
        }
    }

    @Override // net.zetetic.database.DatabaseErrorHandler
    public final void a(SQLiteDatabase sQLiteDatabase) {
        Log.e("DefaultDatabaseErrorHandler", "Corruption reported by sqlite on database: " + sQLiteDatabase.getPath());
        if (SQLiteConnection.o()) {
            return;
        }
        if (!sQLiteDatabase.isOpen()) {
            b(sQLiteDatabase.getPath());
            return;
        }
        List attachedDbs = null;
        try {
            try {
                attachedDbs = sQLiteDatabase.getAttachedDbs();
            } finally {
                if (attachedDbs != null) {
                    Iterator it = attachedDbs.iterator();
                    while (it.hasNext()) {
                        b((String) ((Pair) it.next()).second);
                    }
                } else {
                    b(sQLiteDatabase.getPath());
                }
            }
        } catch (SQLiteException unused) {
        }
        try {
            sQLiteDatabase.f();
        } catch (SQLiteException unused2) {
        }
    }
}
