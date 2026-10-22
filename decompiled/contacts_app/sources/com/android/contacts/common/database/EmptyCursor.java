package com.android.contacts.common.database;

import android.database.AbstractCursor;
import android.database.CursorIndexOutOfBoundsException;

/* JADX INFO: loaded from: classes.dex */
public final class EmptyCursor extends AbstractCursor {
    private String[] mColumns;

    @Override // android.database.AbstractCursor, android.database.Cursor
    public int getCount() {
        return 0;
    }

    public EmptyCursor(String[] r1) {
        this.mColumns = r1;
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public String[] getColumnNames() {
        return this.mColumns;
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public String getString(int r1) {
        throw cursorException();
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public short getShort(int r1) {
        throw cursorException();
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public int getInt(int r1) {
        throw cursorException();
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public long getLong(int r1) {
        throw cursorException();
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public float getFloat(int r1) {
        throw cursorException();
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public double getDouble(int r1) {
        throw cursorException();
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public boolean isNull(int r1) {
        throw cursorException();
    }

    private CursorIndexOutOfBoundsException cursorException() {
        return new CursorIndexOutOfBoundsException("Operation not permitted on an empty cursor.");
    }
}
