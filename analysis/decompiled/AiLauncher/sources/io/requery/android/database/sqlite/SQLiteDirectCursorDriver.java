package io.requery.android.database.sqlite;

import android.database.Cursor;
import io.requery.android.database.sqlite.SQLiteDatabase;
import x0.d;

/* loaded from: classes4.dex */
public final class SQLiteDirectCursorDriver implements SQLiteCursorDriver {
    private final d mCancellationSignal;
    private final SQLiteDatabase mDatabase;
    private final String mEditTable;
    private SQLiteQuery mQuery;
    private final String mSql;

    public SQLiteDirectCursorDriver(SQLiteDatabase sQLiteDatabase, String str, String str2, d dVar) {
        this.mDatabase = sQLiteDatabase;
        this.mEditTable = str2;
        this.mSql = str;
        this.mCancellationSignal = dVar;
    }

    @Override // io.requery.android.database.sqlite.SQLiteCursorDriver
    public void cursorClosed() {
    }

    @Override // io.requery.android.database.sqlite.SQLiteCursorDriver
    public void cursorDeactivated() {
    }

    @Override // io.requery.android.database.sqlite.SQLiteCursorDriver
    public void cursorRequeried(Cursor cursor) {
    }

    @Override // io.requery.android.database.sqlite.SQLiteCursorDriver
    public Cursor query(SQLiteDatabase.CursorFactory cursorFactory, Object[] objArr) {
        SQLiteQuery sQLiteQuery = new SQLiteQuery(this.mDatabase, this.mSql, objArr, this.mCancellationSignal);
        try {
            Cursor sQLiteCursor = cursorFactory == null ? new SQLiteCursor(this, this.mEditTable, sQLiteQuery) : cursorFactory.newCursor(this.mDatabase, this, this.mEditTable, sQLiteQuery);
            this.mQuery = sQLiteQuery;
            return sQLiteCursor;
        } catch (RuntimeException e10) {
            sQLiteQuery.close();
            throw e10;
        }
    }

    @Override // io.requery.android.database.sqlite.SQLiteCursorDriver
    public void setBindArguments(String[] strArr) {
        this.mQuery.bindAllArgsAsStrings(strArr);
    }

    public String toString() {
        return "SQLiteDirectCursorDriver: " + this.mSql;
    }
}
