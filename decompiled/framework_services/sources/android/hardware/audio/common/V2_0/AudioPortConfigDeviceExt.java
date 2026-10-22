package android.hardware.audio.common.V2_0;

import android.os.HidlSupport;
import android.os.HwBlob;
import android.os.HwParcel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class AudioPortConfigDeviceExt {
    public byte[] address;
    public int hwModule;
    public int type;

    public AudioPortConfigDeviceExt() {
        this.hwModule = 0;
        this.type = 0;
        this.address = new byte[32];
    }

    public final boolean equals(Object otherObject) {
        if (this != otherObject) goto L6;
        return true;
    L6:
        if (otherObject != null) goto L9;
        return false;
    L9:
        if (otherObject.getClass() == AudioPortConfigDeviceExt.class) goto L11;
        return false;
    L11:
        AudioPortConfigDeviceExt other = (AudioPortConfigDeviceExt) otherObject;
        if (this.hwModule == other.hwModule) goto L15;
        return false;
    L15:
        if (this.type == other.type) goto L18;
        return false;
    L18:
        if (HidlSupport.deepEquals(this.address, other.address) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.hwModule))), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.type))), Integer.valueOf(HidlSupport.deepHashCode(this.address))});
    }

    public final String toString() {
        return "{.hwModule = " + this.hwModule + ", .type = " + AudioDevice.toString(this.type) + ", .address = " + Arrays.toString(this.address) + "}";
    }

    public final void readFromParcel(HwParcel parcel) {
        HwBlob blob = parcel.readBuffer(40);
        readEmbeddedFromParcel(parcel, blob, 0);
    }

    public static final ArrayList<AudioPortConfigDeviceExt> readVectorFromParcel(HwParcel parcel) {
        ArrayList<AudioPortConfigDeviceExt> _hidl_vec = new ArrayList();
        HwBlob _hidl_blob = parcel.readBuffer(16);
        int _hidl_vec_size = _hidl_blob.getInt32(8);
        HwBlob childBlob = parcel.readEmbeddedBuffer(_hidl_vec_size * 40, _hidl_blob.handle(), 0, true);
        _hidl_vec.clear();
        int _hidl_index_0 = 0;
    L3:
        if (_hidl_index_0 >= _hidl_vec_size) goto L6;
        AudioPortConfigDeviceExt _hidl_vec_element = new AudioPortConfigDeviceExt();
        _hidl_vec_element.readEmbeddedFromParcel(parcel, childBlob, _hidl_index_0 * 40);
        _hidl_vec.add(_hidl_vec_element);
        _hidl_index_0 = _hidl_index_0 + 1;
        goto L3
    L6:
        return _hidl_vec;
    }

    public final void readEmbeddedFromParcel(HwParcel parcel, HwBlob _hidl_blob, long _hidl_offset) {
        this.hwModule = _hidl_blob.getInt32(0 + _hidl_offset);
        this.type = _hidl_blob.getInt32(4 + _hidl_offset);
        long _hidl_array_offset_0 = 8 + _hidl_offset;
        _hidl_blob.copyToInt8Array(_hidl_array_offset_0, this.address, 32);
    }

    public final void writeToParcel(HwParcel parcel) {
        HwBlob _hidl_blob = new HwBlob(40);
        writeEmbeddedToBlob(_hidl_blob, 0);
        parcel.writeBuffer(_hidl_blob);
    }

    public static final void writeVectorToParcel(HwParcel parcel, ArrayList<AudioPortConfigDeviceExt> _hidl_vec) {
        HwBlob _hidl_blob = new HwBlob(16);
        int _hidl_vec_size = _hidl_vec.size();
        _hidl_blob.putInt32(8, _hidl_vec_size);
        _hidl_blob.putBool(12, false);
        HwBlob childBlob = new HwBlob(_hidl_vec_size * 40);
        int _hidl_index_0 = 0;
    L3:
        if (_hidl_index_0 >= _hidl_vec_size) goto L5;
        _hidl_vec.get(_hidl_index_0).writeEmbeddedToBlob(childBlob, _hidl_index_0 * 40);
        _hidl_index_0 = _hidl_index_0 + 1;
        goto L3
    L5:
        _hidl_blob.putBlob(0, childBlob);
        parcel.writeBuffer(_hidl_blob);
    }

    public final void writeEmbeddedToBlob(HwBlob _hidl_blob, long _hidl_offset) {
        _hidl_blob.putInt32(0 + _hidl_offset, this.hwModule);
        _hidl_blob.putInt32(4 + _hidl_offset, this.type);
        long _hidl_array_offset_0 = 8 + _hidl_offset;
        byte[] _hidl_array_item_0 = this.address;
        if (_hidl_array_item_0 == null) goto L9;
        if (_hidl_array_item_0.length != 32) goto L9;
        _hidl_blob.putInt8Array(_hidl_array_offset_0, _hidl_array_item_0);
        return;
    L9:
        throw new IllegalArgumentException("Array element is not of the expected length");
    }
}
