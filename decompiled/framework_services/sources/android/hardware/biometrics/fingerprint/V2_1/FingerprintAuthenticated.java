package android.hardware.biometrics.fingerprint.V2_1;

import android.os.HidlSupport;
import android.os.HwBlob;
import android.os.HwParcel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class FingerprintAuthenticated {
    public FingerprintFingerId finger;
    public byte[] hat;

    public FingerprintAuthenticated() {
        this.finger = new FingerprintFingerId();
        this.hat = new byte[69];
    }

    public final boolean equals(Object otherObject) {
        if (this != otherObject) goto L6;
        return true;
    L6:
        if (otherObject != null) goto L9;
        return false;
    L9:
        if (otherObject.getClass() == FingerprintAuthenticated.class) goto L11;
        return false;
    L11:
        FingerprintAuthenticated other = (FingerprintAuthenticated) otherObject;
        if (HidlSupport.deepEquals(this.finger, other.finger) == true) goto L15;
        return false;
    L15:
        if (HidlSupport.deepEquals(this.hat, other.hat) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(HidlSupport.deepHashCode(this.finger)), Integer.valueOf(HidlSupport.deepHashCode(this.hat))});
    }

    public final String toString() {
        return "{.finger = " + this.finger + ", .hat = " + Arrays.toString(this.hat) + "}";
    }

    public final void readFromParcel(HwParcel parcel) {
        HwBlob blob = parcel.readBuffer(80);
        readEmbeddedFromParcel(parcel, blob, 0);
    }

    public static final ArrayList<FingerprintAuthenticated> readVectorFromParcel(HwParcel parcel) {
        ArrayList<FingerprintAuthenticated> _hidl_vec = new ArrayList();
        HwBlob _hidl_blob = parcel.readBuffer(16);
        int _hidl_vec_size = _hidl_blob.getInt32(8);
        HwBlob childBlob = parcel.readEmbeddedBuffer(_hidl_vec_size * 80, _hidl_blob.handle(), 0, true);
        _hidl_vec.clear();
        int _hidl_index_0 = 0;
    L3:
        if (_hidl_index_0 >= _hidl_vec_size) goto L6;
        FingerprintAuthenticated _hidl_vec_element = new FingerprintAuthenticated();
        _hidl_vec_element.readEmbeddedFromParcel(parcel, childBlob, _hidl_index_0 * 80);
        _hidl_vec.add(_hidl_vec_element);
        _hidl_index_0 = _hidl_index_0 + 1;
        goto L3
    L6:
        return _hidl_vec;
    }

    public final void readEmbeddedFromParcel(HwParcel parcel, HwBlob _hidl_blob, long _hidl_offset) {
        this.finger.readEmbeddedFromParcel(parcel, _hidl_blob, 0 + _hidl_offset);
        long _hidl_array_offset_0 = 8 + _hidl_offset;
        _hidl_blob.copyToInt8Array(_hidl_array_offset_0, this.hat, 69);
    }

    public final void writeToParcel(HwParcel parcel) {
        HwBlob _hidl_blob = new HwBlob(80);
        writeEmbeddedToBlob(_hidl_blob, 0);
        parcel.writeBuffer(_hidl_blob);
    }

    public static final void writeVectorToParcel(HwParcel parcel, ArrayList<FingerprintAuthenticated> _hidl_vec) {
        HwBlob _hidl_blob = new HwBlob(16);
        int _hidl_vec_size = _hidl_vec.size();
        _hidl_blob.putInt32(8, _hidl_vec_size);
        _hidl_blob.putBool(12, false);
        HwBlob childBlob = new HwBlob(_hidl_vec_size * 80);
        int _hidl_index_0 = 0;
    L3:
        if (_hidl_index_0 >= _hidl_vec_size) goto L5;
        _hidl_vec.get(_hidl_index_0).writeEmbeddedToBlob(childBlob, _hidl_index_0 * 80);
        _hidl_index_0 = _hidl_index_0 + 1;
        goto L3
    L5:
        _hidl_blob.putBlob(0, childBlob);
        parcel.writeBuffer(_hidl_blob);
    }

    public final void writeEmbeddedToBlob(HwBlob _hidl_blob, long _hidl_offset) {
        this.finger.writeEmbeddedToBlob(_hidl_blob, 0 + _hidl_offset);
        long _hidl_array_offset_0 = 8 + _hidl_offset;
        byte[] _hidl_array_item_0 = this.hat;
        if (_hidl_array_item_0 == null) goto L9;
        if (_hidl_array_item_0.length != 69) goto L9;
        _hidl_blob.putInt8Array(_hidl_array_offset_0, _hidl_array_item_0);
        return;
    L9:
        throw new IllegalArgumentException("Array element is not of the expected length");
    }
}
