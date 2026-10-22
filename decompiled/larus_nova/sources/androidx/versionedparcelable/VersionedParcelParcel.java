package androidx.versionedparcelable;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import androidx.collection.ArrayMap;
import java.lang.reflect.Method;
import tb2.c;

/* JADX INFO: loaded from: classes17.dex */
class VersionedParcelParcel extends VersionedParcel {
    private static final boolean DEBUG = false;
    private static final String TAG = "VersionedParcelParcel";
    private int mCurrentField;
    private final int mEnd;
    private int mFieldId;
    private int mNextRead;
    private final int mOffset;
    private final Parcel mParcel;
    private final SparseIntArray mPositionLookup;
    private final String mPrefix;

    @Override // androidx.versionedparcelable.VersionedParcel
    public void closeField() {
        int r100 = this.mCurrentField;
        if (r100 < 0) goto L6;
        int r101 = this.mPositionLookup.get(r100);
        int r102 = this.mParcel.dataPosition();
        int r103 = r102 - r101;
        this.mParcel.setDataPosition(r101);
        this.mParcel.writeInt(r103);
        this.mParcel.setDataPosition(r102);
        return;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public VersionedParcel createSubParcel() {
        Parcel r100 = this.mParcel;
        int r101 = r100.dataPosition();
        int r102 = this.mNextRead;
        if (r102 != this.mOffset) goto L6;
        r102 = this.mEnd;
    L6:
        return new VersionedParcelParcel(r100, r101, r102, this.mPrefix + c.DEFAULT_TEXT, this.mReadCache, this.mWriteCache, this.mParcelizerCache);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public boolean readBoolean() {
        if (this.mParcel.readInt() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public Bundle readBundle() {
        return this.mParcel.readBundle(getClass().getClassLoader());
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public byte[] readByteArray() {
        int r100 = this.mParcel.readInt();
        if (r100 >= 0) goto L6;
        return null;
    L6:
        byte[] r101 = new byte[r100];
        this.mParcel.readByteArray(r101);
        return r101;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public CharSequence readCharSequence() {
        return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.mParcel);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public double readDouble() {
        return this.mParcel.readDouble();
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public float readFloat() {
        return this.mParcel.readFloat();
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public int readInt() {
        return this.mParcel.readInt();
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public long readLong() {
        return this.mParcel.readLong();
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public <T extends Parcelable> T readParcelable() {
        return (T) this.mParcel.readParcelable(getClass().getClassLoader());
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public String readString() {
        return this.mParcel.readString();
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public IBinder readStrongBinder() {
        return this.mParcel.readStrongBinder();
    }

    public VersionedParcelParcel(Parcel r100) {
        this(r100, r100.dataPosition(), r100.dataSize(), "", new ArrayMap(), new ArrayMap(), new ArrayMap());
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public boolean readField(int r100) {
    L3:
        if (this.mNextRead >= this.mEnd) goto L12;
        int r101 = this.mFieldId;
        if (r101 == r100) goto L6;
        if (String.valueOf(r101).compareTo(String.valueOf(r100)) > 0) goto L9;
        this.mParcel.setDataPosition(this.mNextRead);
        int r102 = this.mParcel.readInt();
        this.mFieldId = this.mParcel.readInt();
        this.mNextRead += r102;
        goto L3
    L9:
        return false;
    L6:
        return true;
    L12:
        if (this.mFieldId == r100) goto L19;
        return false;
    L19:
        return true;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void setOutputField(int r100) {
        closeField();
        this.mCurrentField = r100;
        this.mPositionLookup.put(r100, this.mParcel.dataPosition());
        writeInt(0);
        writeInt(r100);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeBoolean(boolean r100) {
        this.mParcel.writeInt(r100 ? 1 : 0);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeBundle(Bundle r100) {
        this.mParcel.writeBundle(r100);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeByteArray(byte[] r100) {
        if (r100 == null) goto L4;
        this.mParcel.writeInt(r100.length);
        this.mParcel.writeByteArray(r100);
        return;
    L4:
        this.mParcel.writeInt(-1);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeCharSequence(CharSequence r100) {
        TextUtils.writeToParcel(r100, this.mParcel, 0);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeDouble(double r100) {
        this.mParcel.writeDouble(r100);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeFloat(float r100) {
        this.mParcel.writeFloat(r100);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeInt(int r100) {
        this.mParcel.writeInt(r100);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeLong(long r100) {
        this.mParcel.writeLong(r100);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeParcelable(Parcelable r100) {
        this.mParcel.writeParcelable(r100, 0);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeString(String r100) {
        this.mParcel.writeString(r100);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeStrongBinder(IBinder r100) {
        this.mParcel.writeStrongBinder(r100);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeStrongInterface(IInterface r100) {
        this.mParcel.writeStrongInterface(r100);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeByteArray(byte[] r100, int r101, int r102) {
        if (r100 == null) goto L4;
        this.mParcel.writeInt(r100.length);
        this.mParcel.writeByteArray(r100, r101, r102);
        return;
    L4:
        this.mParcel.writeInt(-1);
    }

    private VersionedParcelParcel(Parcel r100, int r101, int r102, String r103, ArrayMap<String, Method> r104, ArrayMap<String, Method> r105, ArrayMap<String, Class> r106) {
        super(r104, r105, r106);
        this.mPositionLookup = new SparseIntArray();
        this.mCurrentField = -1;
        this.mFieldId = -1;
        this.mParcel = r100;
        this.mOffset = r101;
        this.mEnd = r102;
        this.mNextRead = r101;
        this.mPrefix = r103;
    }
}
