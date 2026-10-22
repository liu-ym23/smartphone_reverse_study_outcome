package net.sqlcipher;

import android.database.CharArrayBuffer;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes5.dex */
public class CursorWindow extends android.database.CursorWindow implements Parcelable {
    private int mRequiredPos;
    private int mStartPos;
    private long nWindow;
    private static CursorWindowAllocation allocation = new DefaultCursorWindowAllocation();
    public static final Parcelable.Creator<CursorWindow> CREATOR = new Parcelable.Creator<CursorWindow>() { // from class: net.sqlcipher.CursorWindow.1
        @Override // android.os.Parcelable.Creator
        public CursorWindow createFromParcel(Parcel parcel) {
            return new CursorWindow(parcel, 0);
        }

        @Override // android.os.Parcelable.Creator
        public CursorWindow[] newArray(int i10) {
            return new CursorWindow[i10];
        }
    };

    public CursorWindow(boolean z10) {
        super(z10);
        this.mStartPos = 0;
        if (allocation == null) {
            allocation = new DefaultCursorWindowAllocation();
        }
        native_init(z10, allocation.getInitialAllocationSize(), allocation.getGrowthPaddingSize(), allocation.getMaxAllocationSize());
    }

    private native boolean allocRow_native();

    private native void close_native();

    private native char[] copyStringToBuffer_native(int i10, int i11, int i12, CharArrayBuffer charArrayBuffer);

    private native void freeLastRow_native();

    private native byte[] getBlob_native(int i10, int i11);

    public static CursorWindowAllocation getCursorWindowAllocation() {
        return allocation;
    }

    private native double getDouble_native(int i10, int i11);

    private native long getLong_native(int i10, int i11);

    private native int getNumRows_native();

    private native String getString_native(int i10, int i11);

    private native int getType_native(int i10, int i11);

    private native boolean isBlob_native(int i10, int i11);

    private native boolean isFloat_native(int i10, int i11);

    private native boolean isInteger_native(int i10, int i11);

    private native boolean isNull_native(int i10, int i11);

    private native boolean isString_native(int i10, int i11);

    private native void native_clear();

    private native IBinder native_getBinder();

    private native void native_init(IBinder iBinder);

    private native void native_init(boolean z10, long j10, long j11, long j12);

    public static CursorWindow newFromParcel(Parcel parcel) {
        return CREATOR.createFromParcel(parcel);
    }

    private native boolean putBlob_native(byte[] bArr, int i10, int i11);

    private native boolean putDouble_native(double d10, int i10, int i11);

    private native boolean putLong_native(long j10, int i10, int i11);

    private native boolean putNull_native(int i10, int i11);

    private native boolean putString_native(String str, int i10, int i11);

    public static void setCursorWindowAllocation(CursorWindowAllocation cursorWindowAllocation) {
        allocation = cursorWindowAllocation;
    }

    private native boolean setNumColumns_native(int i10);

    @Override // android.database.CursorWindow
    public boolean allocRow() {
        acquireReference();
        try {
            return allocRow_native();
        } finally {
            releaseReference();
        }
    }

    @Override // android.database.CursorWindow
    public void clear() {
        acquireReference();
        try {
            this.mStartPos = 0;
            native_clear();
        } finally {
            releaseReference();
        }
    }

    @Override // android.database.sqlite.SQLiteClosable, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        releaseReference();
    }

    @Override // android.database.CursorWindow
    public void copyStringToBuffer(int i10, int i11, CharArrayBuffer charArrayBuffer) {
        if (charArrayBuffer == null) {
            throw new IllegalArgumentException("CharArrayBuffer should not be null");
        }
        if (charArrayBuffer.data == null) {
            charArrayBuffer.data = new char[64];
        }
        acquireReference();
        try {
            char[] cArrCopyStringToBuffer_native = copyStringToBuffer_native(i10 - this.mStartPos, i11, charArrayBuffer.data.length, charArrayBuffer);
            if (cArrCopyStringToBuffer_native != null) {
                charArrayBuffer.data = cArrCopyStringToBuffer_native;
            }
        } finally {
            releaseReference();
        }
    }

    @Override // android.database.CursorWindow, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.database.CursorWindow
    public void finalize() {
        if (this.nWindow == 0) {
            return;
        }
        close_native();
    }

    @Override // android.database.CursorWindow
    public void freeLastRow() {
        acquireReference();
        try {
            freeLastRow_native();
        } finally {
            releaseReference();
        }
    }

    @Override // android.database.CursorWindow
    public byte[] getBlob(int i10, int i11) {
        acquireReference();
        try {
            return getBlob_native(i10 - this.mStartPos, i11);
        } finally {
            releaseReference();
        }
    }

    @Override // android.database.CursorWindow
    public double getDouble(int i10, int i11) {
        acquireReference();
        try {
            return getDouble_native(i10 - this.mStartPos, i11);
        } finally {
            releaseReference();
        }
    }

    @Override // android.database.CursorWindow
    public float getFloat(int i10, int i11) {
        acquireReference();
        try {
            return (float) getDouble_native(i10 - this.mStartPos, i11);
        } finally {
            releaseReference();
        }
    }

    @Override // android.database.CursorWindow
    public int getInt(int i10, int i11) {
        acquireReference();
        try {
            return (int) getLong_native(i10 - this.mStartPos, i11);
        } finally {
            releaseReference();
        }
    }

    @Override // android.database.CursorWindow
    public long getLong(int i10, int i11) {
        acquireReference();
        try {
            return getLong_native(i10 - this.mStartPos, i11);
        } finally {
            releaseReference();
        }
    }

    @Override // android.database.CursorWindow
    public int getNumRows() {
        acquireReference();
        try {
            return getNumRows_native();
        } finally {
            releaseReference();
        }
    }

    public int getRequiredPosition() {
        return this.mRequiredPos;
    }

    @Override // android.database.CursorWindow
    public short getShort(int i10, int i11) {
        acquireReference();
        try {
            return (short) getLong_native(i10 - this.mStartPos, i11);
        } finally {
            releaseReference();
        }
    }

    @Override // android.database.CursorWindow
    public int getStartPosition() {
        return this.mStartPos;
    }

    @Override // android.database.CursorWindow
    public String getString(int i10, int i11) {
        acquireReference();
        try {
            return getString_native(i10 - this.mStartPos, i11);
        } finally {
            releaseReference();
        }
    }

    @Override // android.database.CursorWindow
    public int getType(int i10, int i11) {
        acquireReference();
        try {
            return getType_native(i10 - this.mStartPos, i11);
        } finally {
            releaseReference();
        }
    }

    @Override // android.database.CursorWindow
    public boolean isBlob(int i10, int i11) {
        acquireReference();
        try {
            return isBlob_native(i10 - this.mStartPos, i11);
        } finally {
            releaseReference();
        }
    }

    @Override // android.database.CursorWindow
    public boolean isFloat(int i10, int i11) {
        acquireReference();
        try {
            return isFloat_native(i10 - this.mStartPos, i11);
        } finally {
            releaseReference();
        }
    }

    @Override // android.database.CursorWindow
    public boolean isLong(int i10, int i11) {
        acquireReference();
        try {
            return isInteger_native(i10 - this.mStartPos, i11);
        } finally {
            releaseReference();
        }
    }

    @Override // android.database.CursorWindow
    public boolean isNull(int i10, int i11) {
        acquireReference();
        try {
            return isNull_native(i10 - this.mStartPos, i11);
        } finally {
            releaseReference();
        }
    }

    @Override // android.database.CursorWindow
    public boolean isString(int i10, int i11) {
        acquireReference();
        try {
            return isString_native(i10 - this.mStartPos, i11);
        } finally {
            releaseReference();
        }
    }

    @Override // android.database.CursorWindow, android.database.sqlite.SQLiteClosable
    public void onAllReferencesReleased() {
        close_native();
        super.onAllReferencesReleased();
    }

    @Override // android.database.CursorWindow
    public boolean putBlob(byte[] bArr, int i10, int i11) {
        acquireReference();
        try {
            return putBlob_native(bArr, i10 - this.mStartPos, i11);
        } finally {
            releaseReference();
        }
    }

    @Override // android.database.CursorWindow
    public boolean putDouble(double d10, int i10, int i11) {
        acquireReference();
        try {
            return putDouble_native(d10, i10 - this.mStartPos, i11);
        } finally {
            releaseReference();
        }
    }

    @Override // android.database.CursorWindow
    public boolean putLong(long j10, int i10, int i11) {
        acquireReference();
        try {
            return putLong_native(j10, i10 - this.mStartPos, i11);
        } finally {
            releaseReference();
        }
    }

    @Override // android.database.CursorWindow
    public boolean putNull(int i10, int i11) {
        acquireReference();
        try {
            return putNull_native(i10 - this.mStartPos, i11);
        } finally {
            releaseReference();
        }
    }

    @Override // android.database.CursorWindow
    public boolean putString(String str, int i10, int i11) {
        acquireReference();
        try {
            return putString_native(str, i10 - this.mStartPos, i11);
        } finally {
            releaseReference();
        }
    }

    @Override // android.database.CursorWindow
    public boolean setNumColumns(int i10) {
        acquireReference();
        try {
            return setNumColumns_native(i10);
        } finally {
            releaseReference();
        }
    }

    public void setRequiredPosition(int i10) {
        this.mRequiredPos = i10;
    }

    @Override // android.database.CursorWindow
    public void setStartPosition(int i10) {
        this.mStartPos = i10;
    }

    @Override // android.database.CursorWindow, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeStrongBinder(native_getBinder());
        parcel.writeInt(this.mStartPos);
    }

    public CursorWindow(Parcel parcel, int i10) {
        super(true);
        IBinder strongBinder = parcel.readStrongBinder();
        this.mStartPos = parcel.readInt();
        native_init(strongBinder);
    }
}
