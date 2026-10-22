package io.requery.android.database;

import android.database.CharArrayBuffer;
import android.database.StaleDataException;

/* loaded from: classes4.dex */
public abstract class AbstractWindowedCursor extends AbstractCursor {
    protected CursorWindow mWindow;

    @Override // io.requery.android.database.AbstractCursor
    public void checkPosition() {
        super.checkPosition();
        if (this.mWindow == null) {
            throw new StaleDataException("Attempting to access a closed CursorWindow.Most probable cause: cursor is deactivated prior to calling this method.");
        }
    }

    public void clearOrCreateWindow(String str) {
        CursorWindow cursorWindow = this.mWindow;
        if (cursorWindow == null) {
            this.mWindow = new CursorWindow(str);
        } else {
            cursorWindow.clear();
        }
    }

    public void closeWindow() {
        CursorWindow cursorWindow = this.mWindow;
        if (cursorWindow != null) {
            cursorWindow.close();
            this.mWindow = null;
        }
    }

    @Override // io.requery.android.database.AbstractCursor, android.database.Cursor
    public void copyStringToBuffer(int i10, CharArrayBuffer charArrayBuffer) {
        this.mWindow.copyStringToBuffer(this.mPos, i10, charArrayBuffer);
    }

    @Override // io.requery.android.database.AbstractCursor, android.database.Cursor
    public byte[] getBlob(int i10) {
        checkPosition();
        return this.mWindow.getBlob(this.mPos, i10);
    }

    @Override // io.requery.android.database.AbstractCursor, android.database.Cursor
    public double getDouble(int i10) {
        checkPosition();
        return this.mWindow.getDouble(this.mPos, i10);
    }

    @Override // io.requery.android.database.AbstractCursor, android.database.Cursor
    public float getFloat(int i10) {
        checkPosition();
        return this.mWindow.getFloat(this.mPos, i10);
    }

    @Override // io.requery.android.database.AbstractCursor, android.database.Cursor
    public int getInt(int i10) {
        checkPosition();
        return this.mWindow.getInt(this.mPos, i10);
    }

    @Override // io.requery.android.database.AbstractCursor, android.database.Cursor
    public long getLong(int i10) {
        checkPosition();
        return this.mWindow.getLong(this.mPos, i10);
    }

    @Override // io.requery.android.database.AbstractCursor, android.database.Cursor
    public short getShort(int i10) {
        checkPosition();
        return this.mWindow.getShort(this.mPos, i10);
    }

    @Override // io.requery.android.database.AbstractCursor, android.database.Cursor
    public String getString(int i10) {
        checkPosition();
        return this.mWindow.getString(this.mPos, i10);
    }

    @Override // io.requery.android.database.AbstractCursor, android.database.Cursor
    public int getType(int i10) {
        return this.mWindow.getType(this.mPos, i10);
    }

    public CursorWindow getWindow() {
        return this.mWindow;
    }

    public boolean hasWindow() {
        return this.mWindow != null;
    }

    @Override // io.requery.android.database.AbstractCursor, android.database.Cursor
    public boolean isNull(int i10) {
        return this.mWindow.getType(this.mPos, i10) == 0;
    }

    @Override // io.requery.android.database.AbstractCursor
    public void onDeactivateOrClose() {
        super.onDeactivateOrClose();
        closeWindow();
    }

    public void setWindow(CursorWindow cursorWindow) {
        if (cursorWindow != this.mWindow) {
            closeWindow();
            this.mWindow = cursorWindow;
        }
    }
}
