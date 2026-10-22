package io.requery.android.database;

import android.database.CharArrayBuffer;
import io.requery.android.database.sqlite.SQLiteClosable;

/* loaded from: classes4.dex */
public class CursorWindow extends SQLiteClosable {
    private static final int WINDOW_SIZE_KB = 2048;
    private static final int sDefaultCursorWindowSize = 2097152;
    private final String mName;
    private int mStartPos;
    public long mWindowPtr;
    private final int mWindowSizeBytes;

    public CursorWindow(String str) {
        this(str, sDefaultCursorWindowSize);
    }

    private void dispose() {
        long j10 = this.mWindowPtr;
        if (j10 != 0) {
            nativeDispose(j10);
            this.mWindowPtr = 0L;
        }
    }

    private static native boolean nativeAllocRow(long j10);

    private static native void nativeClear(long j10);

    private static native long nativeCreate(String str, int i10);

    private static native void nativeDispose(long j10);

    private static native void nativeFreeLastRow(long j10);

    private static native byte[] nativeGetBlob(long j10, int i10, int i11);

    private static native double nativeGetDouble(long j10, int i10, int i11);

    private static native long nativeGetLong(long j10, int i10, int i11);

    private static native String nativeGetName(long j10);

    private static native int nativeGetNumRows(long j10);

    private static native String nativeGetString(long j10, int i10, int i11);

    private static native int nativeGetType(long j10, int i10, int i11);

    private static native boolean nativePutBlob(long j10, byte[] bArr, int i10, int i11);

    private static native boolean nativePutDouble(long j10, double d10, int i10, int i11);

    private static native boolean nativePutLong(long j10, long j11, int i10, int i11);

    private static native boolean nativePutNull(long j10, int i10, int i11);

    private static native boolean nativePutString(long j10, String str, int i10, int i11);

    private static native boolean nativeSetNumColumns(long j10, int i10);

    public boolean allocRow() {
        return nativeAllocRow(this.mWindowPtr);
    }

    public void clear() {
        this.mStartPos = 0;
        nativeClear(this.mWindowPtr);
    }

    public void copyStringToBuffer(int i10, int i11, CharArrayBuffer charArrayBuffer) {
        if (charArrayBuffer == null) {
            throw new IllegalArgumentException("CharArrayBuffer should not be null");
        }
        char[] charArray = getString(i10, i11).toCharArray();
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

    public byte[] getBlob(int i10, int i11) {
        return nativeGetBlob(this.mWindowPtr, i10 - this.mStartPos, i11);
    }

    public double getDouble(int i10, int i11) {
        return nativeGetDouble(this.mWindowPtr, i10 - this.mStartPos, i11);
    }

    public float getFloat(int i10, int i11) {
        return (float) getDouble(i10, i11);
    }

    public int getInt(int i10, int i11) {
        return (int) getLong(i10, i11);
    }

    public long getLong(int i10, int i11) {
        return nativeGetLong(this.mWindowPtr, i10 - this.mStartPos, i11);
    }

    public String getName() {
        return this.mName;
    }

    public int getNumRows() {
        return nativeGetNumRows(this.mWindowPtr);
    }

    public short getShort(int i10, int i11) {
        return (short) getLong(i10, i11);
    }

    public int getStartPosition() {
        return this.mStartPos;
    }

    public String getString(int i10, int i11) {
        return nativeGetString(this.mWindowPtr, i10 - this.mStartPos, i11);
    }

    public int getType(int i10, int i11) {
        return nativeGetType(this.mWindowPtr, i10 - this.mStartPos, i11);
    }

    public int getWindowSizeBytes() {
        return this.mWindowSizeBytes;
    }

    @Override // io.requery.android.database.sqlite.SQLiteClosable
    public void onAllReferencesReleased() {
        dispose();
    }

    public boolean putBlob(byte[] bArr, int i10, int i11) {
        return nativePutBlob(this.mWindowPtr, bArr, i10 - this.mStartPos, i11);
    }

    public boolean putDouble(double d10, int i10, int i11) {
        return nativePutDouble(this.mWindowPtr, d10, i10 - this.mStartPos, i11);
    }

    public boolean putLong(long j10, int i10, int i11) {
        return nativePutLong(this.mWindowPtr, j10, i10 - this.mStartPos, i11);
    }

    public boolean putNull(int i10, int i11) {
        return nativePutNull(this.mWindowPtr, i10 - this.mStartPos, i11);
    }

    public boolean putString(String str, int i10, int i11) {
        return nativePutString(this.mWindowPtr, str, i10 - this.mStartPos, i11);
    }

    public boolean setNumColumns(int i10) {
        return nativeSetNumColumns(this.mWindowPtr, i10);
    }

    public void setStartPosition(int i10) {
        this.mStartPos = i10;
    }

    public String toString() {
        return getName() + " {" + Long.toHexString(this.mWindowPtr) + "}";
    }

    public CursorWindow(String str, int i10) {
        this.mStartPos = 0;
        this.mWindowSizeBytes = i10;
        str = (str == null || str.length() == 0) ? "<unnamed>" : str;
        this.mName = str;
        long jNativeCreate = nativeCreate(str, i10);
        this.mWindowPtr = jNativeCreate;
        if (jNativeCreate != 0) {
            return;
        }
        throw new CursorWindowAllocationException("Cursor window allocation of " + (i10 / 1024) + " kb failed. ");
    }
}
