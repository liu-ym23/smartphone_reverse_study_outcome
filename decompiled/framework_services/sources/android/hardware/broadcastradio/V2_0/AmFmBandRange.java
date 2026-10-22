package android.hardware.broadcastradio.V2_0;

import android.os.HidlSupport;
import android.os.HwBlob;
import android.os.HwParcel;
import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class AmFmBandRange {
    public int lowerBound;
    public int scanSpacing;
    public int spacing;
    public int upperBound;

    public AmFmBandRange() {
        this.lowerBound = 0;
        this.upperBound = 0;
        this.spacing = 0;
        this.scanSpacing = 0;
    }

    public final boolean equals(Object otherObject) {
        if (this != otherObject) goto L6;
        return true;
    L6:
        if (otherObject != null) goto L9;
        return false;
    L9:
        if (otherObject.getClass() == AmFmBandRange.class) goto L11;
        return false;
    L11:
        AmFmBandRange other = (AmFmBandRange) otherObject;
        if (this.lowerBound == other.lowerBound) goto L15;
        return false;
    L15:
        if (this.upperBound == other.upperBound) goto L18;
        return false;
    L18:
        if (this.spacing == other.spacing) goto L21;
        return false;
    L21:
        if (this.scanSpacing == other.scanSpacing) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.lowerBound))), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.upperBound))), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.spacing))), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.scanSpacing)))});
    }

    public final String toString() {
        return "{.lowerBound = " + this.lowerBound + ", .upperBound = " + this.upperBound + ", .spacing = " + this.spacing + ", .scanSpacing = " + this.scanSpacing + "}";
    }

    public final void readFromParcel(HwParcel parcel) {
        HwBlob blob = parcel.readBuffer(16);
        readEmbeddedFromParcel(parcel, blob, 0);
    }

    public static final ArrayList<AmFmBandRange> readVectorFromParcel(HwParcel parcel) {
        ArrayList<AmFmBandRange> _hidl_vec = new ArrayList();
        HwBlob _hidl_blob = parcel.readBuffer(16);
        int _hidl_vec_size = _hidl_blob.getInt32(8);
        HwBlob childBlob = parcel.readEmbeddedBuffer(_hidl_vec_size * 16, _hidl_blob.handle(), 0, true);
        _hidl_vec.clear();
        int _hidl_index_0 = 0;
    L3:
        if (_hidl_index_0 >= _hidl_vec_size) goto L6;
        AmFmBandRange _hidl_vec_element = new AmFmBandRange();
        _hidl_vec_element.readEmbeddedFromParcel(parcel, childBlob, _hidl_index_0 * 16);
        _hidl_vec.add(_hidl_vec_element);
        _hidl_index_0 = _hidl_index_0 + 1;
        goto L3
    L6:
        return _hidl_vec;
    }

    public final void readEmbeddedFromParcel(HwParcel parcel, HwBlob _hidl_blob, long _hidl_offset) {
        this.lowerBound = _hidl_blob.getInt32(0 + _hidl_offset);
        this.upperBound = _hidl_blob.getInt32(4 + _hidl_offset);
        this.spacing = _hidl_blob.getInt32(8 + _hidl_offset);
        this.scanSpacing = _hidl_blob.getInt32(12 + _hidl_offset);
    }

    public final void writeToParcel(HwParcel parcel) {
        HwBlob _hidl_blob = new HwBlob(16);
        writeEmbeddedToBlob(_hidl_blob, 0);
        parcel.writeBuffer(_hidl_blob);
    }

    public static final void writeVectorToParcel(HwParcel parcel, ArrayList<AmFmBandRange> _hidl_vec) {
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
        _hidl_blob.putInt32(0 + _hidl_offset, this.lowerBound);
        _hidl_blob.putInt32(4 + _hidl_offset, this.upperBound);
        _hidl_blob.putInt32(8 + _hidl_offset, this.spacing);
        _hidl_blob.putInt32(12 + _hidl_offset, this.scanSpacing);
    }
}
