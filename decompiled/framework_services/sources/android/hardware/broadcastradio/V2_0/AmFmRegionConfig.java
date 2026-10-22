package android.hardware.broadcastradio.V2_0;

import android.os.HidlSupport;
import android.os.HwBlob;
import android.os.HwParcel;
import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class AmFmRegionConfig {
    public byte fmDeemphasis;
    public byte fmRds;
    public ArrayList<AmFmBandRange> ranges;

    public AmFmRegionConfig() {
        this.ranges = new ArrayList();
    }

    public final boolean equals(Object otherObject) {
        if (this != otherObject) goto L6;
        return true;
    L6:
        if (otherObject != null) goto L9;
        return false;
    L9:
        if (otherObject.getClass() == AmFmRegionConfig.class) goto L11;
        return false;
    L11:
        AmFmRegionConfig other = (AmFmRegionConfig) otherObject;
        if (HidlSupport.deepEquals(this.ranges, other.ranges) == true) goto L15;
        return false;
    L15:
        if (HidlSupport.deepEquals(Byte.valueOf(this.fmDeemphasis), Byte.valueOf(other.fmDeemphasis)) == true) goto L18;
        return false;
    L18:
        if (HidlSupport.deepEquals(Byte.valueOf(this.fmRds), Byte.valueOf(other.fmRds)) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(HidlSupport.deepHashCode(this.ranges)), Integer.valueOf(HidlSupport.deepHashCode(Byte.valueOf(this.fmDeemphasis))), Integer.valueOf(HidlSupport.deepHashCode(Byte.valueOf(this.fmRds)))});
    }

    public final String toString() {
        return "{.ranges = " + this.ranges + ", .fmDeemphasis = " + Deemphasis.dumpBitfield(this.fmDeemphasis) + ", .fmRds = " + Rds.dumpBitfield(this.fmRds) + "}";
    }

    public final void readFromParcel(HwParcel parcel) {
        HwBlob blob = parcel.readBuffer(24);
        readEmbeddedFromParcel(parcel, blob, 0);
    }

    public static final ArrayList<AmFmRegionConfig> readVectorFromParcel(HwParcel parcel) {
        ArrayList<AmFmRegionConfig> _hidl_vec = new ArrayList();
        HwBlob _hidl_blob = parcel.readBuffer(16);
        int _hidl_vec_size = _hidl_blob.getInt32(8);
        HwBlob childBlob = parcel.readEmbeddedBuffer(_hidl_vec_size * 24, _hidl_blob.handle(), 0, true);
        _hidl_vec.clear();
        int _hidl_index_0 = 0;
    L3:
        if (_hidl_index_0 >= _hidl_vec_size) goto L6;
        AmFmRegionConfig _hidl_vec_element = new AmFmRegionConfig();
        _hidl_vec_element.readEmbeddedFromParcel(parcel, childBlob, _hidl_index_0 * 24);
        _hidl_vec.add(_hidl_vec_element);
        _hidl_index_0 = _hidl_index_0 + 1;
        goto L3
    L6:
        return _hidl_vec;
    }

    public final void readEmbeddedFromParcel(HwParcel parcel, HwBlob _hidl_blob, long _hidl_offset) {
        int _hidl_vec_size = _hidl_blob.getInt32((_hidl_offset + 0) + 8);
        HwBlob childBlob = parcel.readEmbeddedBuffer(_hidl_vec_size * 16, _hidl_blob.handle(), (_hidl_offset + 0) + 0, true);
        this.ranges.clear();
        int _hidl_index_0 = 0;
    L3:
        if (_hidl_index_0 >= _hidl_vec_size) goto L5;
        AmFmBandRange _hidl_vec_element = new AmFmBandRange();
        _hidl_vec_element.readEmbeddedFromParcel(parcel, childBlob, _hidl_index_0 * 16);
        this.ranges.add(_hidl_vec_element);
        _hidl_index_0 = _hidl_index_0 + 1;
        goto L3
    L5:
        this.fmDeemphasis = _hidl_blob.getInt8(16 + _hidl_offset);
        this.fmRds = _hidl_blob.getInt8(17 + _hidl_offset);
    }

    public final void writeToParcel(HwParcel parcel) {
        HwBlob _hidl_blob = new HwBlob(24);
        writeEmbeddedToBlob(_hidl_blob, 0);
        parcel.writeBuffer(_hidl_blob);
    }

    public static final void writeVectorToParcel(HwParcel parcel, ArrayList<AmFmRegionConfig> _hidl_vec) {
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
        int _hidl_vec_size = this.ranges.size();
        _hidl_blob.putInt32((_hidl_offset + 0) + 8, _hidl_vec_size);
        _hidl_blob.putBool((_hidl_offset + 0) + 12, false);
        HwBlob childBlob = new HwBlob(_hidl_vec_size * 16);
        int _hidl_index_0 = 0;
    L3:
        if (_hidl_index_0 >= _hidl_vec_size) goto L5;
        this.ranges.get(_hidl_index_0).writeEmbeddedToBlob(childBlob, _hidl_index_0 * 16);
        _hidl_index_0 = _hidl_index_0 + 1;
        goto L3
    L5:
        _hidl_blob.putBlob((_hidl_offset + 0) + 0, childBlob);
        _hidl_blob.putInt8(16 + _hidl_offset, this.fmDeemphasis);
        _hidl_blob.putInt8(17 + _hidl_offset, this.fmRds);
    }
}
