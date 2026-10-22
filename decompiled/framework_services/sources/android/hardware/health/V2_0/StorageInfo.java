package android.hardware.health.V2_0;

import android.os.HidlSupport;
import android.os.HwBlob;
import android.os.HwParcel;
import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class StorageInfo {
    public StorageAttribute attr;
    public short eol;
    public short lifetimeA;
    public short lifetimeB;
    public String version;

    public StorageInfo() {
        this.attr = new StorageAttribute();
        this.eol = 0;
        this.lifetimeA = 0;
        this.lifetimeB = 0;
        this.version = new String();
    }

    public final boolean equals(Object otherObject) {
        if (this != otherObject) goto L6;
        return true;
    L6:
        if (otherObject != null) goto L9;
        return false;
    L9:
        if (otherObject.getClass() == StorageInfo.class) goto L11;
        return false;
    L11:
        StorageInfo other = (StorageInfo) otherObject;
        if (HidlSupport.deepEquals(this.attr, other.attr) == true) goto L15;
        return false;
    L15:
        if (this.eol == other.eol) goto L18;
        return false;
    L18:
        if (this.lifetimeA == other.lifetimeA) goto L21;
        return false;
    L21:
        if (this.lifetimeB == other.lifetimeB) goto L24;
        return false;
    L24:
        if (HidlSupport.deepEquals(this.version, other.version) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(HidlSupport.deepHashCode(this.attr)), Integer.valueOf(HidlSupport.deepHashCode(Short.valueOf(this.eol))), Integer.valueOf(HidlSupport.deepHashCode(Short.valueOf(this.lifetimeA))), Integer.valueOf(HidlSupport.deepHashCode(Short.valueOf(this.lifetimeB))), Integer.valueOf(HidlSupport.deepHashCode(this.version))});
    }

    public final String toString() {
        return "{.attr = " + this.attr + ", .eol = " + this.eol + ", .lifetimeA = " + this.lifetimeA + ", .lifetimeB = " + this.lifetimeB + ", .version = " + this.version + "}";
    }

    public final void readFromParcel(HwParcel parcel) {
        HwBlob blob = parcel.readBuffer(48);
        readEmbeddedFromParcel(parcel, blob, 0);
    }

    public static final ArrayList<StorageInfo> readVectorFromParcel(HwParcel parcel) {
        ArrayList<StorageInfo> _hidl_vec = new ArrayList();
        HwBlob _hidl_blob = parcel.readBuffer(16);
        int _hidl_vec_size = _hidl_blob.getInt32(8);
        HwBlob childBlob = parcel.readEmbeddedBuffer(_hidl_vec_size * 48, _hidl_blob.handle(), 0, true);
        _hidl_vec.clear();
        int _hidl_index_0 = 0;
    L3:
        if (_hidl_index_0 >= _hidl_vec_size) goto L6;
        StorageInfo _hidl_vec_element = new StorageInfo();
        _hidl_vec_element.readEmbeddedFromParcel(parcel, childBlob, _hidl_index_0 * 48);
        _hidl_vec.add(_hidl_vec_element);
        _hidl_index_0 = _hidl_index_0 + 1;
        goto L3
    L6:
        return _hidl_vec;
    }

    public final void readEmbeddedFromParcel(HwParcel parcel, HwBlob _hidl_blob, long _hidl_offset) {
        this.attr.readEmbeddedFromParcel(parcel, _hidl_blob, _hidl_offset + 0);
        this.eol = _hidl_blob.getInt16(_hidl_offset + 24);
        this.lifetimeA = _hidl_blob.getInt16(_hidl_offset + 26);
        this.lifetimeB = _hidl_blob.getInt16(_hidl_offset + 28);
        this.version = _hidl_blob.getString(_hidl_offset + 32);
        parcel.readEmbeddedBuffer(this.version.getBytes().length + 1, _hidl_blob.handle(), (_hidl_offset + 32) + 0, false);
    }

    public final void writeToParcel(HwParcel parcel) {
        HwBlob _hidl_blob = new HwBlob(48);
        writeEmbeddedToBlob(_hidl_blob, 0);
        parcel.writeBuffer(_hidl_blob);
    }

    public static final void writeVectorToParcel(HwParcel parcel, ArrayList<StorageInfo> _hidl_vec) {
        HwBlob _hidl_blob = new HwBlob(16);
        int _hidl_vec_size = _hidl_vec.size();
        _hidl_blob.putInt32(8, _hidl_vec_size);
        _hidl_blob.putBool(12, false);
        HwBlob childBlob = new HwBlob(_hidl_vec_size * 48);
        int _hidl_index_0 = 0;
    L3:
        if (_hidl_index_0 >= _hidl_vec_size) goto L5;
        _hidl_vec.get(_hidl_index_0).writeEmbeddedToBlob(childBlob, _hidl_index_0 * 48);
        _hidl_index_0 = _hidl_index_0 + 1;
        goto L3
    L5:
        _hidl_blob.putBlob(0, childBlob);
        parcel.writeBuffer(_hidl_blob);
    }

    public final void writeEmbeddedToBlob(HwBlob _hidl_blob, long _hidl_offset) {
        this.attr.writeEmbeddedToBlob(_hidl_blob, 0 + _hidl_offset);
        _hidl_blob.putInt16(24 + _hidl_offset, this.eol);
        _hidl_blob.putInt16(26 + _hidl_offset, this.lifetimeA);
        _hidl_blob.putInt16(28 + _hidl_offset, this.lifetimeB);
        _hidl_blob.putString(32 + _hidl_offset, this.version);
    }
}
