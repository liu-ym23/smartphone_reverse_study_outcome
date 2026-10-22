package android.hardware.weaver.V1_0;

import android.os.HidlSupport;
import android.os.HwBlob;
import android.os.HwParcel;
import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class WeaverConfig {
    public int keySize;
    public int slots;
    public int valueSize;

    public WeaverConfig() {
        this.slots = 0;
        this.keySize = 0;
        this.valueSize = 0;
    }

    public final boolean equals(Object otherObject) {
        if (this != otherObject) goto L6;
        return true;
    L6:
        if (otherObject != null) goto L9;
        return false;
    L9:
        if (otherObject.getClass() == WeaverConfig.class) goto L11;
        return false;
    L11:
        WeaverConfig other = (WeaverConfig) otherObject;
        if (this.slots == other.slots) goto L15;
        return false;
    L15:
        if (this.keySize == other.keySize) goto L18;
        return false;
    L18:
        if (this.valueSize == other.valueSize) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.slots))), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.keySize))), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.valueSize)))});
    }

    public final String toString() {
        return "{.slots = " + this.slots + ", .keySize = " + this.keySize + ", .valueSize = " + this.valueSize + "}";
    }

    public final void readFromParcel(HwParcel parcel) {
        HwBlob blob = parcel.readBuffer(12);
        readEmbeddedFromParcel(parcel, blob, 0);
    }

    public static final ArrayList<WeaverConfig> readVectorFromParcel(HwParcel parcel) {
        ArrayList<WeaverConfig> _hidl_vec = new ArrayList();
        HwBlob _hidl_blob = parcel.readBuffer(16);
        int _hidl_vec_size = _hidl_blob.getInt32(8);
        HwBlob childBlob = parcel.readEmbeddedBuffer(_hidl_vec_size * 12, _hidl_blob.handle(), 0, true);
        _hidl_vec.clear();
        int _hidl_index_0 = 0;
    L3:
        if (_hidl_index_0 >= _hidl_vec_size) goto L6;
        WeaverConfig _hidl_vec_element = new WeaverConfig();
        _hidl_vec_element.readEmbeddedFromParcel(parcel, childBlob, _hidl_index_0 * 12);
        _hidl_vec.add(_hidl_vec_element);
        _hidl_index_0 = _hidl_index_0 + 1;
        goto L3
    L6:
        return _hidl_vec;
    }

    public final void readEmbeddedFromParcel(HwParcel parcel, HwBlob _hidl_blob, long _hidl_offset) {
        this.slots = _hidl_blob.getInt32(0 + _hidl_offset);
        this.keySize = _hidl_blob.getInt32(4 + _hidl_offset);
        this.valueSize = _hidl_blob.getInt32(8 + _hidl_offset);
    }

    public final void writeToParcel(HwParcel parcel) {
        HwBlob _hidl_blob = new HwBlob(12);
        writeEmbeddedToBlob(_hidl_blob, 0);
        parcel.writeBuffer(_hidl_blob);
    }

    public static final void writeVectorToParcel(HwParcel parcel, ArrayList<WeaverConfig> _hidl_vec) {
        HwBlob _hidl_blob = new HwBlob(16);
        int _hidl_vec_size = _hidl_vec.size();
        _hidl_blob.putInt32(8, _hidl_vec_size);
        _hidl_blob.putBool(12, false);
        HwBlob childBlob = new HwBlob(_hidl_vec_size * 12);
        int _hidl_index_0 = 0;
    L3:
        if (_hidl_index_0 >= _hidl_vec_size) goto L5;
        _hidl_vec.get(_hidl_index_0).writeEmbeddedToBlob(childBlob, _hidl_index_0 * 12);
        _hidl_index_0 = _hidl_index_0 + 1;
        goto L3
    L5:
        _hidl_blob.putBlob(0, childBlob);
        parcel.writeBuffer(_hidl_blob);
    }

    public final void writeEmbeddedToBlob(HwBlob _hidl_blob, long _hidl_offset) {
        _hidl_blob.putInt32(0 + _hidl_offset, this.slots);
        _hidl_blob.putInt32(4 + _hidl_offset, this.keySize);
        _hidl_blob.putInt32(8 + _hidl_offset, this.valueSize);
    }
}
