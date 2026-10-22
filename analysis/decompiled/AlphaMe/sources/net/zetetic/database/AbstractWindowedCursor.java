package net.zetetic.database;

import android.database.CharArrayBuffer;
import android.database.StaleDataException;

/* loaded from: classes2.dex */
public abstract class AbstractWindowedCursor extends AbstractCursor {
    protected CursorWindow mWindow;

    @Override // net.zetetic.database.AbstractCursor
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

    @Override // net.zetetic.database.AbstractCursor, android.database.Cursor
    public void copyStringToBuffer(int i4, CharArrayBuffer charArrayBuffer) {
        this.mWindow.copyStringToBuffer(this.mPos, i4, charArrayBuffer);
    }

    @Override // net.zetetic.database.AbstractCursor, android.database.Cursor
    public byte[] getBlob(int i4) {
        checkPosition();
        return this.mWindow.getBlob(this.mPos, i4);
    }

    @Override // net.zetetic.database.AbstractCursor, android.database.Cursor
    public double getDouble(int i4) {
        checkPosition();
        return this.mWindow.getDouble(this.mPos, i4);
    }

    @Override // net.zetetic.database.AbstractCursor, android.database.Cursor
    public float getFloat(int i4) {
        checkPosition();
        return this.mWindow.getFloat(this.mPos, i4);
    }

    @Override // net.zetetic.database.AbstractCursor, android.database.Cursor
    public int getInt(int i4) {
        checkPosition();
        return this.mWindow.getInt(this.mPos, i4);
    }

    @Override // net.zetetic.database.AbstractCursor, android.database.Cursor
    public long getLong(int i4) {
        checkPosition();
        return this.mWindow.getLong(this.mPos, i4);
    }

    @Override // net.zetetic.database.AbstractCursor, android.database.Cursor
    public short getShort(int i4) {
        checkPosition();
        return this.mWindow.getShort(this.mPos, i4);
    }

    @Override // net.zetetic.database.AbstractCursor, android.database.Cursor
    public String getString(int i4) {
        checkPosition();
        return this.mWindow.getString(this.mPos, i4);
    }

    @Override // net.zetetic.database.AbstractCursor, android.database.Cursor
    public int getType(int i4) {
        return this.mWindow.getType(this.mPos, i4);
    }

    public CursorWindow getWindow() {
        return this.mWindow;
    }

    public boolean hasWindow() {
        return this.mWindow != null;
    }

    @Override // net.zetetic.database.AbstractCursor, android.database.Cursor
    public boolean isNull(int i4) {
        return this.mWindow.getType(this.mPos, i4) == 0;
    }

    @Override // net.zetetic.database.AbstractCursor
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
