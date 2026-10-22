package net.zetetic.database;

import android.database.CharArrayBuffer;
import net.zetetic.database.sqlcipher.SQLiteClosable;

/* loaded from: classes2.dex */
public class CursorWindow extends SQLiteClosable {
    public static final int DEFAULT_CURSOR_WINDOW_SIZE = 16384;
    public static int PREFERRED_CURSOR_WINDOW_SIZE = 16384;
    private static final int WINDOW_SIZE_KB = 16;
    private final String mName;
    private int mStartPos;
    public long mWindowPtr;
    private final int mWindowSizeBytes;

    public CursorWindow(String str) {
        this(str, 16384);
    }

    private void dispose() {
        long j4 = this.mWindowPtr;
        if (j4 != 0) {
            nativeDispose(j4);
            this.mWindowPtr = 0L;
        }
    }

    private static native boolean nativeAllocRow(long j4);

    private static native void nativeClear(long j4);

    private static native long nativeCreate(String str, int i4);

    private static native void nativeDispose(long j4);

    private static native void nativeFreeLastRow(long j4);

    private static native byte[] nativeGetBlob(long j4, int i4, int i5);

    private static native double nativeGetDouble(long j4, int i4, int i5);

    private static native long nativeGetLong(long j4, int i4, int i5);

    private static native String nativeGetName(long j4);

    private static native int nativeGetNumRows(long j4);

    private static native String nativeGetString(long j4, int i4, int i5);

    private static native int nativeGetType(long j4, int i4, int i5);

    private static native boolean nativePutBlob(long j4, byte[] bArr, int i4, int i5);

    private static native boolean nativePutDouble(long j4, double d4, int i4, int i5);

    private static native boolean nativePutLong(long j4, long j5, int i4, int i5);

    private static native boolean nativePutNull(long j4, int i4, int i5);

    private static native boolean nativePutString(long j4, String str, int i4, int i5);

    private static native boolean nativeSetNumColumns(long j4, int i4);

    public boolean allocRow() {
        return nativeAllocRow(this.mWindowPtr);
    }

    public void clear() {
        this.mStartPos = 0;
        nativeClear(this.mWindowPtr);
    }

    public void copyStringToBuffer(int i4, int i5, CharArrayBuffer charArrayBuffer) {
        if (charArrayBuffer == null) {
            throw new IllegalArgumentException("CharArrayBuffer should not be null");
        }
        char[] charArray = getString(i4, i5).toCharArray();
        charArrayBuffer.data = charArray;
        charArrayBuffer.sizeCopied = charArray.length;
    }

    public void finalize() throws Throwable {
        try {
            dispose();
        } finally {
            super.finalize();
        }
    }

    public void freeLastRow() {
        nativeFreeLastRow(this.mWindowPtr);
    }

    public byte[] getBlob(int i4, int i5) {
        return nativeGetBlob(this.mWindowPtr, i4 - this.mStartPos, i5);
    }

    public double getDouble(int i4, int i5) {
        return nativeGetDouble(this.mWindowPtr, i4 - this.mStartPos, i5);
    }

    public float getFloat(int i4, int i5) {
        return (float) getDouble(i4, i5);
    }

    public int getInt(int i4, int i5) {
        return (int) getLong(i4, i5);
    }

    public long getLong(int i4, int i5) {
        return nativeGetLong(this.mWindowPtr, i4 - this.mStartPos, i5);
    }

    public String getName() {
        return this.mName;
    }

    public int getNumRows() {
        return nativeGetNumRows(this.mWindowPtr);
    }

    public short getShort(int i4, int i5) {
        return (short) getLong(i4, i5);
    }

    public int getStartPosition() {
        return this.mStartPos;
    }

    public String getString(int i4, int i5) {
        return nativeGetString(this.mWindowPtr, i4 - this.mStartPos, i5);
    }

    public int getType(int i4, int i5) {
        return nativeGetType(this.mWindowPtr, i4 - this.mStartPos, i5);
    }

    public int getWindowSizeBytes() {
        return this.mWindowSizeBytes;
    }

    public boolean isBlob(int i4, int i5) {
        int type = getType(i4, i5);
        return type == 4 || type == 0;
    }

    public boolean isNull(int i4, int i5) {
        return getType(i4, i5) == 0;
    }

    @Override // net.zetetic.database.sqlcipher.SQLiteClosable
    public void onAllReferencesReleased() {
        dispose();
    }

    public boolean putBlob(byte[] bArr, int i4, int i5) {
        return nativePutBlob(this.mWindowPtr, bArr, i4 - this.mStartPos, i5);
    }

    public boolean putDouble(double d4, int i4, int i5) {
        return nativePutDouble(this.mWindowPtr, d4, i4 - this.mStartPos, i5);
    }

    public boolean putLong(long j4, int i4, int i5) {
        return nativePutLong(this.mWindowPtr, j4, i4 - this.mStartPos, i5);
    }

    public boolean putNull(int i4, int i5) {
        return nativePutNull(this.mWindowPtr, i4 - this.mStartPos, i5);
    }

    public boolean putString(String str, int i4, int i5) {
        return nativePutString(this.mWindowPtr, str, i4 - this.mStartPos, i5);
    }

    public boolean setNumColumns(int i4) {
        return nativeSetNumColumns(this.mWindowPtr, i4);
    }

    public void setStartPosition(int i4) {
        this.mStartPos = i4;
    }

    public String toString() {
        return getName() + " {" + Long.toHexString(this.mWindowPtr) + "}";
    }

    public CursorWindow(String str, int i4) {
        this.mStartPos = 0;
        this.mWindowSizeBytes = i4;
        str = (str == null || str.length() == 0) ? "<unnamed>" : str;
        this.mName = str;
        long jNativeCreate = nativeCreate(str, i4);
        this.mWindowPtr = jNativeCreate;
        if (jNativeCreate != 0) {
            return;
        }
        throw new CursorWindowAllocationException("Cursor window allocation of " + (i4 / 1024) + " kb failed. ");
    }
}
