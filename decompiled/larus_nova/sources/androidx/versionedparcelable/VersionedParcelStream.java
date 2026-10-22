package androidx.versionedparcelable;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcelable;
import androidx.collection.ArrayMap;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes17.dex */
class VersionedParcelStream extends VersionedParcel {
    private static final int TYPE_BOOLEAN = 5;
    private static final int TYPE_BOOLEAN_ARRAY = 6;
    private static final int TYPE_DOUBLE = 7;
    private static final int TYPE_DOUBLE_ARRAY = 8;
    private static final int TYPE_FLOAT = 13;
    private static final int TYPE_FLOAT_ARRAY = 14;
    private static final int TYPE_INT = 9;
    private static final int TYPE_INT_ARRAY = 10;
    private static final int TYPE_LONG = 11;
    private static final int TYPE_LONG_ARRAY = 12;
    private static final int TYPE_NULL = 0;
    private static final int TYPE_STRING = 3;
    private static final int TYPE_STRING_ARRAY = 4;
    private static final int TYPE_SUB_BUNDLE = 1;
    private static final int TYPE_SUB_PERSISTABLE_BUNDLE = 2;
    private static final Charset UTF_16 = null;
    int mCount;
    private DataInputStream mCurrentInput;
    private DataOutputStream mCurrentOutput;
    private FieldBuffer mFieldBuffer;
    private int mFieldId;
    int mFieldSize;
    private boolean mIgnoreParcelables;
    private final DataInputStream mMasterInput;
    private final DataOutputStream mMasterOutput;

    public static class FieldBuffer {
        final DataOutputStream mDataStream;
        private final int mFieldId;
        final ByteArrayOutputStream mOutput;
        private final DataOutputStream mTarget;

        public void flushField() throws IOException {
            this.mDataStream.flush();
            int r100 = this.mOutput.size();
            int r101 = this.mFieldId << 16;
            if (r100 < 65535) goto L5;
            int r102 = 65535;
        L6:
            int r103 = r101 | r102;
            this.mTarget.writeInt(r103);
            if (r100 < 65535) goto L9;
            this.mTarget.writeInt(r100);
        L9:
            this.mOutput.writeTo(this.mTarget);
            return;
        L5:
            r102 = r100;
            goto L6
        }

        public FieldBuffer(int r100, DataOutputStream r101) {
            ByteArrayOutputStream r102 = new ByteArrayOutputStream();
            this.mOutput = r102;
            this.mDataStream = new DataOutputStream(r102);
            this.mFieldId = r100;
            this.mTarget = r101;
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public boolean isStream() {
        return true;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public CharSequence readCharSequence() {
        return null;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public <T extends Parcelable> T readParcelable() {
        return null;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public IBinder readStrongBinder() {
        return null;
    }

    static {
        UTF_16 = Charset.forName("UTF-16");
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void closeField() {
        FieldBuffer r100 = this.mFieldBuffer;
        if (r100 != null) goto L12;
        return;
    L12:
    L8:
        e = move-exception;
        throw new VersionedParcel.ParcelException(e);
    L5:
        if (r100.mOutput.size() == 0) goto L7;
        this.mFieldBuffer.flushField();     // Catch: IOException -> L8
    L7:
        this.mFieldBuffer = null;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public VersionedParcel createSubParcel() {
        return new VersionedParcelStream(this.mCurrentInput, this.mCurrentOutput, this.mReadCache, this.mWriteCache, this.mParcelizerCache);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public boolean readBoolean() {
        return this.mCurrentInput.readBoolean();
    L4:
        e = move-exception;
        throw new VersionedParcel.ParcelException(e);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public byte[] readByteArray() {
        int r100 = this.mCurrentInput.readInt();     // Catch: IOException -> L8
        if (r100 <= 0) goto L6;
        byte[] r101 = new byte[r100];     // Catch: IOException -> L8
        this.mCurrentInput.readFully(r101);     // Catch: IOException -> L8
        return r101;
    L6:
        return null;
    L8:
        e = move-exception;
        throw new VersionedParcel.ParcelException(e);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public double readDouble() {
        return this.mCurrentInput.readDouble();
    L4:
        e = move-exception;
        throw new VersionedParcel.ParcelException(e);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public float readFloat() {
        return this.mCurrentInput.readFloat();
    L4:
        e = move-exception;
        throw new VersionedParcel.ParcelException(e);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public int readInt() {
        return this.mCurrentInput.readInt();
    L4:
        e = move-exception;
        throw new VersionedParcel.ParcelException(e);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public long readLong() {
        return this.mCurrentInput.readLong();
    L4:
        e = move-exception;
        throw new VersionedParcel.ParcelException(e);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public String readString() {
        int r100 = this.mCurrentInput.readInt();     // Catch: IOException -> L8
        if (r100 <= 0) goto L6;
        byte[] r101 = new byte[r100];     // Catch: IOException -> L8
        this.mCurrentInput.readFully(r101);     // Catch: IOException -> L8
        return new String(r101, UTF_16);
    L6:
        return null;
    L8:
        e = move-exception;
        throw new VersionedParcel.ParcelException(e);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public Bundle readBundle() {
        int r100 = readInt();
        if (r100 >= 0) goto L6;
        return null;
    L6:
        Bundle r101 = new Bundle();
        int r102 = 0;
    L7:
        if (r102 >= r100) goto L9;
        String r103 = readString();
        readObject(readInt(), r103, r101);
        r102 = r102 + 1;
        goto L7
    L9:
        return r101;
    }

    private void writeObject(Object r100) {
        if (r100 != null) goto L5;
        writeInt(0);
        return;
    L5:
        if ((r100 instanceof Bundle) == false) goto L8;
        writeInt(1);
        writeBundle((Bundle) r100);
        return;
    L8:
        if ((r100 instanceof String) == false) goto L11;
        writeInt(3);
        writeString((String) r100);
        return;
    L11:
        if ((r100 instanceof String[]) == false) goto L14;
        writeInt(4);
        writeArray((String[]) r100);
        return;
    L14:
        if ((r100 instanceof Boolean) == false) goto L17;
        writeInt(5);
        writeBoolean(((Boolean) r100).booleanValue());
        return;
    L17:
        if ((r100 instanceof boolean[]) == false) goto L20;
        writeInt(6);
        writeBooleanArray((boolean[]) r100);
        return;
    L20:
        if ((r100 instanceof Double) == false) goto L23;
        writeInt(7);
        writeDouble(((Double) r100).doubleValue());
        return;
    L23:
        if ((r100 instanceof double[]) == false) goto L26;
        writeInt(8);
        writeDoubleArray((double[]) r100);
        return;
    L26:
        if ((r100 instanceof Integer) == false) goto L29;
        writeInt(9);
        writeInt(((Integer) r100).intValue());
        return;
    L29:
        if ((r100 instanceof int[]) == false) goto L32;
        writeInt(10);
        writeIntArray((int[]) r100);
        return;
    L32:
        if ((r100 instanceof Long) == false) goto L35;
        writeInt(11);
        writeLong(((Long) r100).longValue());
        return;
    L35:
        if ((r100 instanceof long[]) == false) goto L38;
        writeInt(12);
        writeLongArray((long[]) r100);
        return;
    L38:
        if ((r100 instanceof Float) == false) goto L41;
        writeInt(13);
        writeFloat(((Float) r100).floatValue());
        return;
    L41:
        if ((r100 instanceof float[]) == false) goto L45;
        writeInt(14);
        writeFloatArray((float[]) r100);
        return;
    L45:
        throw new IllegalArgumentException("Unsupported type " + r100.getClass());
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public boolean readField(int r100) {
    L19:
        int r101 = this.mFieldId;     // Catch: IOException -> L18
        if (r101 == r100) goto L5;
        if (String.valueOf(r101).compareTo(String.valueOf(r100)) > 0) goto L9;
        int r102 = this.mCount;     // Catch: IOException -> L18
        int r103 = this.mFieldSize;     // Catch: IOException -> L18
        if (r102 >= r103) goto L13;
        this.mMasterInput.skip(r103 - r102);     // Catch: IOException -> L18
    L13:
        this.mFieldSize = -1;     // Catch: IOException -> L18
        int r104 = this.mMasterInput.readInt();     // Catch: IOException -> L18
        this.mCount = 0;     // Catch: IOException -> L18
        int r105 = r104 & 65535;     // Catch: IOException -> L18
        if (r105 != 65535) goto L16;
        r105 = this.mMasterInput.readInt();     // Catch: IOException -> L18
    L16:
        this.mFieldId = (r104 >> 16) & 65535;     // Catch: IOException -> L18
        this.mFieldSize = r105;     // Catch: IOException -> L18
        goto L19
    L9:
        return false;
    L5:
        return true;
    L18:
        return false;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void setOutputField(int r100) {
        closeField();
        FieldBuffer r101 = new FieldBuffer(r100, this.mMasterOutput);
        this.mFieldBuffer = r101;
        this.mCurrentOutput = r101.mDataStream;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeBoolean(boolean r100) {
        this.mCurrentOutput.writeBoolean(r100);     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        throw new VersionedParcel.ParcelException(e);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeBundle(Bundle r100) {
        if (r100 == null) goto L7;
        Set<String> r101 = r100.keySet();     // Catch: IOException -> L9
        this.mCurrentOutput.writeInt(r101.size());     // Catch: IOException -> L9
        Iterator<String> r102 = r101.iterator();     // Catch: IOException -> L9
    L5:
        if (r102.hasNext() == false) goto L14;
        String r103 = r102.next();     // Catch: IOException -> L9
        writeString(r103);     // Catch: IOException -> L9
        writeObject(r100.get(r103));     // Catch: IOException -> L9
        goto L5
    L14:
        return;
    L7:
        this.mCurrentOutput.writeInt(-1);     // Catch: IOException -> L9
        return;
    L9:
        e = move-exception;
        throw new VersionedParcel.ParcelException(e);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeByteArray(byte[] r100) {
        if (r100 == null) goto L4;
        this.mCurrentOutput.writeInt(r100.length);     // Catch: IOException -> L6
        this.mCurrentOutput.write(r100);     // Catch: IOException -> L6
    L9:
        return;
    L4:
        this.mCurrentOutput.writeInt(-1);     // Catch: IOException -> L6
    L6:
        e = move-exception;
        throw new VersionedParcel.ParcelException(e);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeCharSequence(CharSequence r100) {
        if (this.mIgnoreParcelables == false) goto L6;
        return;
    L6:
        throw new RuntimeException("CharSequence cannot be written to an OutputStream");
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeDouble(double r100) {
        this.mCurrentOutput.writeDouble(r100);     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        throw new VersionedParcel.ParcelException(e);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeFloat(float r100) {
        this.mCurrentOutput.writeFloat(r100);     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        throw new VersionedParcel.ParcelException(e);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeInt(int r100) {
        this.mCurrentOutput.writeInt(r100);     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        throw new VersionedParcel.ParcelException(e);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeLong(long r100) {
        this.mCurrentOutput.writeLong(r100);     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        throw new VersionedParcel.ParcelException(e);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeParcelable(Parcelable r100) {
        if (this.mIgnoreParcelables == false) goto L6;
        return;
    L6:
        throw new RuntimeException("Parcelables cannot be written to an OutputStream");
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeString(String r100) {
        if (r100 == null) goto L4;
        byte[] r101 = r100.getBytes(UTF_16);     // Catch: IOException -> L6
        this.mCurrentOutput.writeInt(r101.length);     // Catch: IOException -> L6
        this.mCurrentOutput.write(r101);     // Catch: IOException -> L6
    L9:
        return;
    L4:
        this.mCurrentOutput.writeInt(-1);     // Catch: IOException -> L6
    L6:
        e = move-exception;
        throw new VersionedParcel.ParcelException(e);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeStrongBinder(IBinder r100) {
        if (this.mIgnoreParcelables == false) goto L6;
        return;
    L6:
        throw new RuntimeException("Binders cannot be written to an OutputStream");
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeStrongInterface(IInterface r100) {
        if (this.mIgnoreParcelables == false) goto L6;
        return;
    L6:
        throw new RuntimeException("Binders cannot be written to an OutputStream");
    }

    public VersionedParcelStream(InputStream r100, OutputStream r101) {
        this(r100, r101, new ArrayMap(), new ArrayMap(), new ArrayMap());
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void setSerializationFlags(boolean r100, boolean r101) {
        if (r100 == false) goto L6;
        this.mIgnoreParcelables = r101;
        return;
    L6:
        throw new RuntimeException("Serialization of this object is not allowed");
    }

    private void readObject(int r100, String r101, Bundle r102) {
        switch(r100) {
            case 0: goto L19;
            case 1: goto L18;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L13;
            case 7: goto L12;
            case 8: goto L11;
            case 9: goto L10;
            case 10: goto L9;
            case 11: goto L8;
            case 12: goto L7;
            case 13: goto L6;
            case 14: goto L5;
            default: goto L4;
        };
    L5:
        r102.putFloatArray(r101, readFloatArray());
        return;
    L6:
        r102.putFloat(r101, readFloat());
        return;
    L7:
        r102.putLongArray(r101, readLongArray());
        return;
    L8:
        r102.putLong(r101, readLong());
        return;
    L9:
        r102.putIntArray(r101, readIntArray());
        return;
    L10:
        r102.putInt(r101, readInt());
        return;
    L11:
        r102.putDoubleArray(r101, readDoubleArray());
        return;
    L12:
        r102.putDouble(r101, readDouble());
        return;
    L13:
        r102.putBooleanArray(r101, readBooleanArray());
        return;
    L14:
        r102.putBoolean(r101, readBoolean());
        return;
    L15:
        r102.putStringArray(r101, (String[]) readArray(new String[0]));
        return;
    L16:
        r102.putString(r101, readString());
        return;
    L17:
        r102.putBundle(r101, readBundle());
        return;
    L18:
        r102.putBundle(r101, readBundle());
        return;
    L19:
        r102.putParcelable(r101, null);
        return;
    L4:
        throw new RuntimeException("Unknown type " + r100);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeByteArray(byte[] r100, int r101, int r102) {
        if (r100 == null) goto L4;
        this.mCurrentOutput.writeInt(r102);     // Catch: IOException -> L6
        this.mCurrentOutput.write(r100, r101, r102);     // Catch: IOException -> L6
    L9:
        return;
    L4:
        this.mCurrentOutput.writeInt(-1);     // Catch: IOException -> L6
    L6:
        e = move-exception;
        throw new VersionedParcel.ParcelException(e);
    }

    private VersionedParcelStream(final InputStream r100, OutputStream r101, ArrayMap<String, Method> r102, ArrayMap<String, Method> r103, ArrayMap<String, Class> r104) {
        super(r102, r103, r104);
        this.mCount = 0;
        this.mFieldId = -1;
        this.mFieldSize = -1;
        DataOutputStream r105 = null;
        if (r100 == null) goto L5;
        DataInputStream r106 = new DataInputStream(new AnonymousClass1(this, r100));
    L6:
        this.mMasterInput = r106;
        if (r101 == null) goto L9;
        r105 = new DataOutputStream(r101);
    L9:
        this.mMasterOutput = r105;
        this.mCurrentInput = r106;
        this.mCurrentOutput = r105;
        return;
    L5:
        r106 = null;
        goto L6
    }
}
