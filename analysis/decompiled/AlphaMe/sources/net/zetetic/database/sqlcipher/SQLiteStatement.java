package net.zetetic.database.sqlcipher;

import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.os.ParcelFileDescriptor;
import k0.j;

/* loaded from: classes2.dex */
public final class SQLiteStatement extends SQLiteProgram implements j {
    public SQLiteStatement(SQLiteDatabase sQLiteDatabase, String str, Object[] objArr) {
        super(sQLiteDatabase, str, objArr, null);
    }

    public void execute() {
        acquireReference();
        try {
            try {
                getSession().execute(getSql(), getBindArgs(), getConnectionFlags(), null);
            } catch (SQLiteDatabaseCorruptException e4) {
                onCorruption(e4);
                throw e4;
            }
        } finally {
            releaseReference();
        }
    }

    @Override // k0.j
    public long executeInsert() {
        acquireReference();
        try {
            try {
                return getSession().executeForLastInsertedRowId(getSql(), getBindArgs(), getConnectionFlags(), null);
            } catch (SQLiteDatabaseCorruptException e4) {
                onCorruption(e4);
                throw e4;
            }
        } finally {
            releaseReference();
        }
    }

    public void executeRaw() {
        acquireReference();
        try {
            try {
                getSession().executeRaw(getSql(), getBindArgs(), getConnectionFlags(), null);
            } catch (SQLiteDatabaseCorruptException e4) {
                onCorruption(e4);
                throw e4;
            }
        } finally {
            releaseReference();
        }
    }

    @Override // k0.j
    public int executeUpdateDelete() {
        acquireReference();
        try {
            try {
                return getSession().executeForChangedRowCount(getSql(), getBindArgs(), getConnectionFlags(), null);
            } catch (SQLiteDatabaseCorruptException e4) {
                onCorruption(e4);
                throw e4;
            }
        } finally {
            releaseReference();
        }
    }

    public ParcelFileDescriptor simpleQueryForBlobFileDescriptor() {
        acquireReference();
        try {
            try {
                return getSession().executeForBlobFileDescriptor(getSql(), getBindArgs(), getConnectionFlags(), null);
            } catch (SQLiteDatabaseCorruptException e4) {
                onCorruption(e4);
                throw e4;
            }
        } finally {
            releaseReference();
        }
    }

    public long simpleQueryForLong() {
        acquireReference();
        try {
            try {
                return getSession().executeForLong(getSql(), getBindArgs(), getConnectionFlags(), null);
            } catch (SQLiteDatabaseCorruptException e4) {
                onCorruption(e4);
                throw e4;
            }
        } finally {
            releaseReference();
        }
    }

    public String simpleQueryForString() {
        acquireReference();
        try {
            try {
                return getSession().executeForString(getSql(), getBindArgs(), getConnectionFlags(), null);
            } catch (SQLiteDatabaseCorruptException e4) {
                onCorruption(e4);
                throw e4;
            }
        } finally {
            releaseReference();
        }
    }

    public String toString() {
        return "SQLiteProgram: " + getSql();
    }
}
