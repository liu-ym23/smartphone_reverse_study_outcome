package net.sqlcipher;

import android.database.CharArrayBuffer;

/* loaded from: classes5.dex */
public abstract class AbstractWindowedCursor extends AbstractCursor {
    protected CursorWindow mWindow;

    @Override // net.sqlcipher.AbstractCursor
    public void checkPosition() {
        super.checkPosition();
        if (this.mWindow == null) {
            throw new StaleDataException("Access closed cursor");
        }
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public void copyStringToBuffer(int i10, CharArrayBuffer charArrayBuffer) {
        checkPosition();
        synchronized (this.mUpdatedRows) {
            try {
                if (isFieldUpdated(i10)) {
                    super.copyStringToBuffer(i10, charArrayBuffer);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.mWindow.copyStringToBuffer(this.mPos, i10, charArrayBuffer);
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public byte[] getBlob(int i10) {
        checkPosition();
        synchronized (this.mUpdatedRows) {
            try {
                if (!isFieldUpdated(i10)) {
                    return this.mWindow.getBlob(this.mPos, i10);
                }
                return (byte[]) getUpdatedField(i10);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public double getDouble(int i10) {
        checkPosition();
        synchronized (this.mUpdatedRows) {
            try {
                if (!isFieldUpdated(i10)) {
                    return this.mWindow.getDouble(this.mPos, i10);
                }
                return ((Number) getUpdatedField(i10)).doubleValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public float getFloat(int i10) {
        checkPosition();
        synchronized (this.mUpdatedRows) {
            try {
                if (!isFieldUpdated(i10)) {
                    return this.mWindow.getFloat(this.mPos, i10);
                }
                return ((Number) getUpdatedField(i10)).floatValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public int getInt(int i10) {
        checkPosition();
        synchronized (this.mUpdatedRows) {
            try {
                if (!isFieldUpdated(i10)) {
                    return this.mWindow.getInt(this.mPos, i10);
                }
                return ((Number) getUpdatedField(i10)).intValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public long getLong(int i10) {
        checkPosition();
        synchronized (this.mUpdatedRows) {
            try {
                if (!isFieldUpdated(i10)) {
                    return this.mWindow.getLong(this.mPos, i10);
                }
                return ((Number) getUpdatedField(i10)).longValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public short getShort(int i10) {
        checkPosition();
        synchronized (this.mUpdatedRows) {
            try {
                if (!isFieldUpdated(i10)) {
                    return this.mWindow.getShort(this.mPos, i10);
                }
                return ((Number) getUpdatedField(i10)).shortValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public String getString(int i10) {
        checkPosition();
        synchronized (this.mUpdatedRows) {
            try {
                if (!isFieldUpdated(i10)) {
                    return this.mWindow.getString(this.mPos, i10);
                }
                return (String) getUpdatedField(i10);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor, net.sqlcipher.Cursor
    public int getType(int i10) {
        checkPosition();
        return this.mWindow.getType(this.mPos, i10);
    }

    public boolean hasWindow() {
        return this.mWindow != null;
    }

    public boolean isBlob(int i10) {
        checkPosition();
        synchronized (this.mUpdatedRows) {
            try {
                if (!isFieldUpdated(i10)) {
                    return this.mWindow.isBlob(this.mPos, i10);
                }
                Object updatedField = getUpdatedField(i10);
                return updatedField == null || (updatedField instanceof byte[]);
            } finally {
            }
        }
    }

    public boolean isFloat(int i10) {
        checkPosition();
        synchronized (this.mUpdatedRows) {
            try {
                if (!isFieldUpdated(i10)) {
                    return this.mWindow.isFloat(this.mPos, i10);
                }
                Object updatedField = getUpdatedField(i10);
                return updatedField != null && ((updatedField instanceof Float) || (updatedField instanceof Double));
            } finally {
            }
        }
    }

    public boolean isLong(int i10) {
        checkPosition();
        synchronized (this.mUpdatedRows) {
            try {
                if (!isFieldUpdated(i10)) {
                    return this.mWindow.isLong(this.mPos, i10);
                }
                Object updatedField = getUpdatedField(i10);
                return updatedField != null && ((updatedField instanceof Integer) || (updatedField instanceof Long));
            } finally {
            }
        }
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public boolean isNull(int i10) {
        checkPosition();
        synchronized (this.mUpdatedRows) {
            try {
                if (isFieldUpdated(i10)) {
                    return getUpdatedField(i10) == null;
                }
                return this.mWindow.isNull(this.mPos, i10);
            } finally {
            }
        }
    }

    public boolean isString(int i10) {
        checkPosition();
        synchronized (this.mUpdatedRows) {
            try {
                if (!isFieldUpdated(i10)) {
                    return this.mWindow.isString(this.mPos, i10);
                }
                Object updatedField = getUpdatedField(i10);
                return updatedField == null || (updatedField instanceof String);
            } finally {
            }
        }
    }

    public void setWindow(CursorWindow cursorWindow) {
        CursorWindow cursorWindow2 = this.mWindow;
        if (cursorWindow2 != null) {
            cursorWindow2.close();
        }
        this.mWindow = cursorWindow;
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.CrossProcessCursor
    public CursorWindow getWindow() {
        return this.mWindow;
    }
}
