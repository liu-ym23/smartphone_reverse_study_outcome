package android.hardware.audio.common.V2_0;

import android.os.HidlSupport;
import android.os.HwBlob;
import android.os.HwParcel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class Uuid {
    public byte[] node;
    public int timeLow;
    public short timeMid;
    public short variantAndClockSeqHigh;
    public short versionAndTimeHigh;

    public Uuid() {
        this.timeLow = 0;
        this.timeMid = 0;
        this.versionAndTimeHigh = 0;
        this.variantAndClockSeqHigh = 0;
        this.node = new byte[6];
    }

    public final boolean equals(Object otherObject) {
        if (this != otherObject) goto L6;
        return true;
    L6:
        if (otherObject != null) goto L9;
        return false;
    L9:
        if (otherObject.getClass() == Uuid.class) goto L11;
        return false;
    L11:
        Uuid other = (Uuid) otherObject;
        if (this.timeLow == other.timeLow) goto L15;
        return false;
    L15:
        if (this.timeMid == other.timeMid) goto L18;
        return false;
    L18:
        if (this.versionAndTimeHigh == other.versionAndTimeHigh) goto L21;
        return false;
    L21:
        if (this.variantAndClockSeqHigh == other.variantAndClockSeqHigh) goto L24;
        return false;
    L24:
        if (HidlSupport.deepEquals(this.node, other.node) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.timeLow))), Integer.valueOf(HidlSupport.deepHashCode(Short.valueOf(this.timeMid))), Integer.valueOf(HidlSupport.deepHashCode(Short.valueOf(this.versionAndTimeHigh))), Integer.valueOf(HidlSupport.deepHashCode(Short.valueOf(this.variantAndClockSeqHigh))), Integer.valueOf(HidlSupport.deepHashCode(this.node))});
    }

    public final String toString() {
        return "{.timeLow = " + this.timeLow + ", .timeMid = " + this.timeMid + ", .versionAndTimeHigh = " + this.versionAndTimeHigh + ", .variantAndClockSeqHigh = " + this.variantAndClockSeqHigh + ", .node = " + Arrays.toString(this.node) + "}";
    }

    public final void readFromParcel(HwParcel parcel) {
        HwBlob blob = parcel.readBuffer(16);
        readEmbeddedFromParcel(parcel, blob, 0);
    }

    public static final ArrayList<Uuid> readVectorFromParcel(HwParcel parcel) {
        ArrayList<Uuid> _hidl_vec = new ArrayList();
        HwBlob _hidl_blob = parcel.readBuffer(16);
        int _hidl_vec_size = _hidl_blob.getInt32(8);
        HwBlob childBlob = parcel.readEmbeddedBuffer(_hidl_vec_size * 16, _hidl_blob.handle(), 0, true);
        _hidl_vec.clear();
        int _hidl_index_0 = 0;
    L3:
        if (_hidl_index_0 >= _hidl_vec_size) goto L6;
        Uuid _hidl_vec_element = new Uuid();
        _hidl_vec_element.readEmbeddedFromParcel(parcel, childBlob, _hidl_index_0 * 16);
        _hidl_vec.add(_hidl_vec_element);
        _hidl_index_0 = _hidl_index_0 + 1;
        goto L3
    L6:
        return _hidl_vec;
    }

    public final void readEmbeddedFromParcel(HwParcel parcel, HwBlob _hidl_blob, long _hidl_offset) {
        this.timeLow = _hidl_blob.getInt32(0 + _hidl_offset);
        this.timeMid = _hidl_blob.getInt16(4 + _hidl_offset);
        this.versionAndTimeHigh = _hidl_blob.getInt16(6 + _hidl_offset);
        this.variantAndClockSeqHigh = _hidl_blob.getInt16(8 + _hidl_offset);
        long _hidl_array_offset_0 = 10 + _hidl_offset;
        _hidl_blob.copyToInt8Array(_hidl_array_offset_0, this.node, 6);
    }

    public final void writeToParcel(HwParcel parcel) {
        HwBlob _hidl_blob = new HwBlob(16);
        writeEmbeddedToBlob(_hidl_blob, 0);
        parcel.writeBuffer(_hidl_blob);
    }

    public static final void writeVectorToParcel(HwParcel parcel, ArrayList<Uuid> _hidl_vec) {
        HwBlob _hidl_blob = new HwBlob(16);
        int _hidl_vec_size = _hidl_vec.size();
        _hidl_blob.putInt32(8, _hidl_vec_size);
        _hidl_blob.putBool(12, false);
        HwBlob childBlob = new HwBlob(_hidl_vec_size * 16);
        int _hidl_index_0 = 0;
    L3:
        if (_hidl_index_0 >= _hidl_vec_size) goto L5;
        _hidl_vec.get(_hidl_index_0).writeEmbeddedToBlob(childBlob, _hidl_index_0 * 16);
        _hidl_index_0 = _hidl_index_0 + 1;
        goto L3
    L5:
        _hidl_blob.putBlob(0, childBlob);
        parcel.writeBuffer(_hidl_blob);
    }

    public final void writeEmbeddedToBlob(HwBlob _hidl_blob, long _hidl_offset) {
        _hidl_blob.putInt32(0 + _hidl_offset, this.timeLow);
        _hidl_blob.putInt16(4 + _hidl_offset, this.timeMid);
        _hidl_blob.putInt16(6 + _hidl_offset, this.versionAndTimeHigh);
        _hidl_blob.putInt16(8 + _hidl_offset, this.variantAndClockSeqHigh);
        long _hidl_array_offset_0 = 10 + _hidl_offset;
        byte[] _hidl_array_item_0 = this.node;
        if (_hidl_array_item_0 == null) goto L9;
        if (_hidl_array_item_0.length != 6) goto L9;
        _hidl_blob.putInt8Array(_hidl_array_offset_0, _hidl_array_item_0);
        return;
    L9:
        throw new IllegalArgumentException("Array element is not of the expected length");
    }
}
