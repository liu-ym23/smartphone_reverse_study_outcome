package android.hardware.broadcastradio.V2_0;

import android.os.HidlSupport;
import android.os.HwBlob;
import android.os.HwParcel;
import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class Metadata {
    public long intValue;
    public int key;
    public String stringValue;

    public Metadata() {
        this.key = 0;
        this.intValue = 0;
        this.stringValue = new String();
    }

    public final boolean equals(Object otherObject) {
        if (this != otherObject) goto L6;
        return true;
    L6:
        if (otherObject != null) goto L9;
        return false;
    L9:
        if (otherObject.getClass() == Metadata.class) goto L11;
        return false;
    L11:
        Metadata other = (Metadata) otherObject;
        if (this.key == other.key) goto L15;
        return false;
    L15:
        if (this.intValue == other.intValue) goto L18;
        return false;
    L18:
        if (HidlSupport.deepEquals(this.stringValue, other.stringValue) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.key))), Integer.valueOf(HidlSupport.deepHashCode(Long.valueOf(this.intValue))), Integer.valueOf(HidlSupport.deepHashCode(this.stringValue))});
    }

    public final String toString() {
        return "{.key = " + this.key + ", .intValue = " + this.intValue + ", .stringValue = " + this.stringValue + "}";
    }

    public final void readFromParcel(HwParcel parcel) {
        HwBlob blob = parcel.readBuffer(32);
        readEmbeddedFromParcel(parcel, blob, 0);
    }

    public static final ArrayList<Metadata> readVectorFromParcel(HwParcel parcel) {
        ArrayList<Metadata> _hidl_vec = new ArrayList();
        HwBlob _hidl_blob = parcel.readBuffer(16);
        int _hidl_vec_size = _hidl_blob.getInt32(8);
        HwBlob childBlob = parcel.readEmbeddedBuffer(_hidl_vec_size * 32, _hidl_blob.handle(), 0, true);
        _hidl_vec.clear();
        int _hidl_index_0 = 0;
    L3:
        if (_hidl_index_0 >= _hidl_vec_size) goto L6;
        Metadata _hidl_vec_element = new Metadata();
        _hidl_vec_element.readEmbeddedFromParcel(parcel, childBlob, _hidl_index_0 * 32);
        _hidl_vec.add(_hidl_vec_element);
        _hidl_index_0 = _hidl_index_0 + 1;
        goto L3
    L6:
        return _hidl_vec;
    }

    public final void readEmbeddedFromParcel(HwParcel parcel, HwBlob _hidl_blob, long _hidl_offset) {
        this.key = _hidl_blob.getInt32(_hidl_offset + 0);
        this.intValue = _hidl_blob.getInt64(_hidl_offset + 8);
        this.stringValue = _hidl_blob.getString(_hidl_offset + 16);
        parcel.readEmbeddedBuffer(this.stringValue.getBytes().length + 1, _hidl_blob.handle(), (_hidl_offset + 16) + 0, false);
    }

    public final void writeToParcel(HwParcel parcel) {
        HwBlob _hidl_blob = new HwBlob(32);
        writeEmbeddedToBlob(_hidl_blob, 0);
        parcel.writeBuffer(_hidl_blob);
    }

    public static final void writeVectorToParcel(HwParcel parcel, ArrayList<Metadata> _hidl_vec) {
        HwBlob _hidl_blob = new HwBlob(16);
        int _hidl_vec_size = _hidl_vec.size();
        _hidl_blob.putInt32(8, _hidl_vec_size);
        _hidl_blob.putBool(12, false);
        HwBlob childBlob = new HwBlob(_hidl_vec_size * 32);
        int _hidl_index_0 = 0;
    L3:
        if (_hidl_index_0 >= _hidl_vec_size) goto L5;
        _hidl_vec.get(_hidl_index_0).writeEmbeddedToBlob(childBlob, _hidl_index_0 * 32);
        _hidl_index_0 = _hidl_index_0 + 1;
        goto L3
    L5:
        _hidl_blob.putBlob(0, childBlob);
        parcel.writeBuffer(_hidl_blob);
    }

    public final void writeEmbeddedToBlob(HwBlob _hidl_blob, long _hidl_offset) {
        _hidl_blob.putInt32(0 + _hidl_offset, this.key);
        _hidl_blob.putInt64(8 + _hidl_offset, this.intValue);
        _hidl_blob.putString(16 + _hidl_offset, this.stringValue);
    }
}
