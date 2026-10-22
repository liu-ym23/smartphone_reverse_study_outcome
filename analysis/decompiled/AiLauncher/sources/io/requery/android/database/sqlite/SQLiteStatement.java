package io.requery.android.database.sqlite;

import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.os.ParcelFileDescriptor;
import j1.h;

/* loaded from: classes4.dex */
public final class SQLiteStatement extends SQLiteProgram implements h {
    public SQLiteStatement(SQLiteDatabase sQLiteDatabase, String str, Object[] objArr) {
        super(sQLiteDatabase, str, objArr, null);
    }

    @Override // j1.h
    public void execute() {
        acquireReference();
        try {
            try {
                getSession().execute(getSql(), getBindArgs(), getConnectionFlags(), null);
            } catch (SQLiteDatabaseCorruptException e10) {
                onCorruption();
                throw e10;
            }
        } finally {
            releaseReference();
        }
    }

    public long executeInsert() {
        acquireReference();
        try {
            try {
                return getSession().executeForLastInsertedRowId(getSql(), getBindArgs(), getConnectionFlags(), null);
            } catch (SQLiteDatabaseCorruptException e10) {
                onCorruption();
                throw e10;
            }
        } finally {
            releaseReference();
        }
    }

    public int executeUpdateDelete() {
        acquireReference();
        try {
            try {
                return getSession().executeForChangedRowCount(getSql(), getBindArgs(), getConnectionFlags(), null);
            } catch (SQLiteDatabaseCorruptException e10) {
                onCorruption();
                throw e10;
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
            } catch (SQLiteDatabaseCorruptException e10) {
                onCorruption();
                throw e10;
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
            } catch (SQLiteDatabaseCorruptException e10) {
                onCorruption();
                throw e10;
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
            } catch (SQLiteDatabaseCorruptException e10) {
                onCorruption();
                throw e10;
            }
        } finally {
            releaseReference();
        }
    }

    public String toString() {
        return "SQLiteProgram: " + getSql();
    }
}
