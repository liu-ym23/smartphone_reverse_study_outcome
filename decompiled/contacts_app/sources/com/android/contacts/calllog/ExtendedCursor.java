package com.android.contacts.calllog;

import android.database.AbstractCursor;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import com.android.common.io.MoreCloseables;

/* JADX INFO: loaded from: classes.dex */
public class ExtendedCursor extends AbstractCursor {
    private final String mColumnName;
    private final Cursor mCursor;
    private final Object mValue;

    public ExtendedCursor(Cursor r1, String r2, Object r3) {
        this.mCursor = r1;
        this.mColumnName = r2;
        this.mValue = r3;
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public int getCount() {
        Cursor r0 = this.mCursor;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.getCount();
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public String[] getColumnNames() {
        String[] r0 = this.mCursor.getColumnNames();
        int r1 = r0.length;
        String[] r2 = new String[r1 + 1];
        System.arraycopy(r0, 0, r2, 0, r1);
        r2[r1] = this.mColumnName;
        return r2;
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public String getString(int r2) {
        if (r2 != this.mCursor.getColumnCount()) goto L7;
        return String.valueOf(r2);
    L7:
        return this.mCursor.getString(r2);
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public short getShort(int r2) {
        if (r2 != this.mCursor.getColumnCount()) goto L7;
        return ((Short) this.mValue).shortValue();
    L7:
        return this.mCursor.getShort(r2);
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public int getInt(int r2) {
        if (r2 != this.mCursor.getColumnCount()) goto L7;
        return ((Integer) this.mValue).intValue();
    L7:
        return this.mCursor.getInt(r2);
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public long getLong(int r2) {
        if (r2 != this.mCursor.getColumnCount()) goto L7;
        return ((Long) this.mValue).longValue();
    L7:
        return this.mCursor.getLong(r2);
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public float getFloat(int r2) {
        if (r2 != this.mCursor.getColumnCount()) goto L7;
        return ((Float) this.mValue).floatValue();
    L7:
        return this.mCursor.getFloat(r2);
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public double getDouble(int r2) {
        if (r2 != this.mCursor.getColumnCount()) goto L7;
        return ((Double) this.mValue).doubleValue();
    L7:
        return this.mCursor.getDouble(r2);
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public boolean isNull(int r2) {
        if (r2 != this.mCursor.getColumnCount()) goto L10;
        if (this.mValue != null) goto L7;
        return true;
    L7:
        return false;
    L10:
        return this.mCursor.isNull(r2);
    }

    public Cursor getCursor() {
        return this.mCursor;
    }

    @Override // android.database.AbstractCursor, android.database.CrossProcessCursor
    public boolean onMove(int r1, int r2) {
        return this.mCursor.moveToPosition(r2);
    }

    @Override // android.database.AbstractCursor, android.database.Cursor, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        MoreCloseables.closeQuietly(this.mCursor);
        super.close();
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public void registerContentObserver(ContentObserver r1) {
        this.mCursor.registerContentObserver(r1);
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public void unregisterContentObserver(ContentObserver r1) {
        this.mCursor.unregisterContentObserver(r1);
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public void registerDataSetObserver(DataSetObserver r1) {
        this.mCursor.registerDataSetObserver(r1);
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public void unregisterDataSetObserver(DataSetObserver r1) {
        this.mCursor.unregisterDataSetObserver(r1);
    }
}
