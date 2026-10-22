package android.hardware.soundtrigger.V2_3;

import android.os.HidlSupport;
import android.os.HwBlob;
import android.os.HwParcel;
import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class Properties {
    public int audioCapabilities;
    public android.hardware.soundtrigger.V2_0.ISoundTriggerHw.Properties base;
    public String supportedModelArch;

    public Properties() {
        this.base = new android.hardware.soundtrigger.V2_0.ISoundTriggerHw.Properties();
        this.supportedModelArch = new String();
    }

    public final boolean equals(Object otherObject) {
        if (this != otherObject) goto L6;
        return true;
    L6:
        if (otherObject != null) goto L9;
        return false;
    L9:
        if (otherObject.getClass() == Properties.class) goto L11;
        return false;
    L11:
        Properties other = (Properties) otherObject;
        if (HidlSupport.deepEquals(this.base, other.base) == true) goto L15;
        return false;
    L15:
        if (HidlSupport.deepEquals(this.supportedModelArch, other.supportedModelArch) == true) goto L18;
        return false;
    L18:
        if (HidlSupport.deepEquals(Integer.valueOf(this.audioCapabilities), Integer.valueOf(other.audioCapabilities)) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(HidlSupport.deepHashCode(this.base)), Integer.valueOf(HidlSupport.deepHashCode(this.supportedModelArch)), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.audioCapabilities)))});
    }

    public final String toString() {
        return "{.base = " + this.base + ", .supportedModelArch = " + this.supportedModelArch + ", .audioCapabilities = " + AudioCapabilities.dumpBitfield(this.audioCapabilities) + "}";
    }

    public final void readFromParcel(HwParcel parcel) {
        HwBlob blob = parcel.readBuffer(112);
        readEmbeddedFromParcel(parcel, blob, 0);
    }

    public static final ArrayList<Properties> readVectorFromParcel(HwParcel parcel) {
        ArrayList<Properties> _hidl_vec = new ArrayList();
        HwBlob _hidl_blob = parcel.readBuffer(16);
        int _hidl_vec_size = _hidl_blob.getInt32(8);
        HwBlob childBlob = parcel.readEmbeddedBuffer(_hidl_vec_size * 112, _hidl_blob.handle(), 0, true);
        _hidl_vec.clear();
        int _hidl_index_0 = 0;
    L3:
        if (_hidl_index_0 >= _hidl_vec_size) goto L6;
        Properties _hidl_vec_element = new Properties();
        _hidl_vec_element.readEmbeddedFromParcel(parcel, childBlob, _hidl_index_0 * 112);
        _hidl_vec.add(_hidl_vec_element);
        _hidl_index_0 = _hidl_index_0 + 1;
        goto L3
    L6:
        return _hidl_vec;
    }

    public final void readEmbeddedFromParcel(HwParcel parcel, HwBlob _hidl_blob, long _hidl_offset) {
        this.base.readEmbeddedFromParcel(parcel, _hidl_blob, _hidl_offset + 0);
        this.supportedModelArch = _hidl_blob.getString(_hidl_offset + 88);
        parcel.readEmbeddedBuffer(this.supportedModelArch.getBytes().length + 1, _hidl_blob.handle(), (_hidl_offset + 88) + 0, false);
        this.audioCapabilities = _hidl_blob.getInt32(_hidl_offset + 104);
    }

    public final void writeToParcel(HwParcel parcel) {
        HwBlob _hidl_blob = new HwBlob(112);
        writeEmbeddedToBlob(_hidl_blob, 0);
        parcel.writeBuffer(_hidl_blob);
    }

    public static final void writeVectorToParcel(HwParcel parcel, ArrayList<Properties> _hidl_vec) {
        HwBlob _hidl_blob = new HwBlob(16);
        int _hidl_vec_size = _hidl_vec.size();
        _hidl_blob.putInt32(8, _hidl_vec_size);
        _hidl_blob.putBool(12, false);
        HwBlob childBlob = new HwBlob(_hidl_vec_size * 112);
        int _hidl_index_0 = 0;
    L3:
        if (_hidl_index_0 >= _hidl_vec_size) goto L5;
        _hidl_vec.get(_hidl_index_0).writeEmbeddedToBlob(childBlob, _hidl_index_0 * 112);
        _hidl_index_0 = _hidl_index_0 + 1;
        goto L3
    L5:
        _hidl_blob.putBlob(0, childBlob);
        parcel.writeBuffer(_hidl_blob);
    }

    public final void writeEmbeddedToBlob(HwBlob _hidl_blob, long _hidl_offset) {
        this.base.writeEmbeddedToBlob(_hidl_blob, 0 + _hidl_offset);
        _hidl_blob.putString(88 + _hidl_offset, this.supportedModelArch);
        _hidl_blob.putInt32(104 + _hidl_offset, this.audioCapabilities);
    }
}
