package android.hardware.health.V2_0;

import android.os.HidlSupport;
import android.os.HwBlob;
import android.os.HwParcel;
import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class StorageAttribute {
    public boolean isBootDevice;
    public boolean isInternal;
    public String name;

    public StorageAttribute() {
        this.isInternal = false;
        this.isBootDevice = false;
        this.name = new String();
    }

    public final boolean equals(Object otherObject) {
        if (this != otherObject) goto L6;
        return true;
    L6:
        if (otherObject != null) goto L9;
        return false;
    L9:
        if (otherObject.getClass() == StorageAttribute.class) goto L11;
        return false;
    L11:
        StorageAttribute other = (StorageAttribute) otherObject;
        if (this.isInternal == other.isInternal) goto L15;
        return false;
    L15:
        if (this.isBootDevice == other.isBootDevice) goto L18;
        return false;
    L18:
        if (HidlSupport.deepEquals(this.name, other.name) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(HidlSupport.deepHashCode(Boolean.valueOf(this.isInternal))), Integer.valueOf(HidlSupport.deepHashCode(Boolean.valueOf(this.isBootDevice))), Integer.valueOf(HidlSupport.deepHashCode(this.name))});
    }

    public final String toString() {
        return "{.isInternal = " + this.isInternal + ", .isBootDevice = " + this.isBootDevice + ", .name = " + this.name + "}";
    }

    public final void readFromParcel(HwParcel parcel) {
        HwBlob blob = parcel.readBuffer(24);
        readEmbeddedFromParcel(parcel, blob, 0);
    }

    public static final ArrayList<StorageAttribute> readVectorFromParcel(HwParcel parcel) {
        ArrayList<StorageAttribute> _hidl_vec = new ArrayList();
        HwBlob _hidl_blob = parcel.readBuffer(16);
        int _hidl_vec_size = _hidl_blob.getInt32(8);
        HwBlob childBlob = parcel.readEmbeddedBuffer(_hidl_vec_size * 24, _hidl_blob.handle(), 0, true);
        _hidl_vec.clear();
        int _hidl_index_0 = 0;
    L3:
        if (_hidl_index_0 >= _hidl_vec_size) goto L6;
        StorageAttribute _hidl_vec_element = new StorageAttribute();
        _hidl_vec_element.readEmbeddedFromParcel(parcel, childBlob, _hidl_index_0 * 24);
        _hidl_vec.add(_hidl_vec_element);
        _hidl_index_0 = _hidl_index_0 + 1;
        goto L3
    L6:
        return _hidl_vec;
    }

    public final void readEmbeddedFromParcel(HwParcel parcel, HwBlob _hidl_blob, long _hidl_offset) {
        this.isInternal = _hidl_blob.getBool(_hidl_offset + 0);
        this.isBootDevice = _hidl_blob.getBool(_hidl_offset + 1);
        this.name = _hidl_blob.getString(_hidl_offset + 8);
        parcel.readEmbeddedBuffer(this.name.getBytes().length + 1, _hidl_blob.handle(), (_hidl_offset + 8) + 0, false);
    }

    public final void writeToParcel(HwParcel parcel) {
        HwBlob _hidl_blob = new HwBlob(24);
        writeEmbeddedToBlob(_hidl_blob, 0);
        parcel.writeBuffer(_hidl_blob);
    }

    public static final void writeVectorToParcel(HwParcel parcel, ArrayList<StorageAttribute> _hidl_vec) {
        HwBlob _hidl_blob = new HwBlob(16);
        int _hidl_vec_size = _hidl_vec.size();
        _hidl_blob.putInt32(8, _hidl_vec_size);
        _hidl_blob.putBool(12, false);
        HwBlob childBlob = new HwBlob(_hidl_vec_size * 24);
        int _hidl_index_0 = 0;
    L3:
        if (_hidl_index_0 >= _hidl_vec_size) goto L5;
        _hidl_vec.get(_hidl_index_0).writeEmbeddedToBlob(childBlob, _hidl_index_0 * 24);
        _hidl_index_0 = _hidl_index_0 + 1;
        goto L3
    L5:
        _hidl_blob.putBlob(0, childBlob);
        parcel.writeBuffer(_hidl_blob);
    }

    public final void writeEmbeddedToBlob(HwBlob _hidl_blob, long _hidl_offset) {
        _hidl_blob.putBool(0 + _hidl_offset, this.isInternal);
        _hidl_blob.putBool(1 + _hidl_offset, this.isBootDevice);
        _hidl_blob.putString(8 + _hidl_offset, this.name);
    }
}
