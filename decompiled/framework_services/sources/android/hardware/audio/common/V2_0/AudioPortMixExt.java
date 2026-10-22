package android.hardware.audio.common.V2_0;

import android.os.HidlSupport;
import android.os.HwBlob;
import android.os.HwParcel;
import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class AudioPortMixExt {
    public int hwModule;
    public int ioHandle;
    public int latencyClass;

    public AudioPortMixExt() {
        this.hwModule = 0;
        this.ioHandle = 0;
        this.latencyClass = 0;
    }

    public final boolean equals(Object otherObject) {
        if (this != otherObject) goto L6;
        return true;
    L6:
        if (otherObject != null) goto L9;
        return false;
    L9:
        if (otherObject.getClass() == AudioPortMixExt.class) goto L11;
        return false;
    L11:
        AudioPortMixExt other = (AudioPortMixExt) otherObject;
        if (this.hwModule == other.hwModule) goto L15;
        return false;
    L15:
        if (this.ioHandle == other.ioHandle) goto L18;
        return false;
    L18:
        if (this.latencyClass == other.latencyClass) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.hwModule))), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.ioHandle))), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.latencyClass)))});
    }

    public final String toString() {
        return "{.hwModule = " + this.hwModule + ", .ioHandle = " + this.ioHandle + ", .latencyClass = " + AudioMixLatencyClass.toString(this.latencyClass) + "}";
    }

    public final void readFromParcel(HwParcel parcel) {
        HwBlob blob = parcel.readBuffer(12);
        readEmbeddedFromParcel(parcel, blob, 0);
    }

    public static final ArrayList<AudioPortMixExt> readVectorFromParcel(HwParcel parcel) {
        ArrayList<AudioPortMixExt> _hidl_vec = new ArrayList();
        HwBlob _hidl_blob = parcel.readBuffer(16);
        int _hidl_vec_size = _hidl_blob.getInt32(8);
        HwBlob childBlob = parcel.readEmbeddedBuffer(_hidl_vec_size * 12, _hidl_blob.handle(), 0, true);
        _hidl_vec.clear();
        int _hidl_index_0 = 0;
    L3:
        if (_hidl_index_0 >= _hidl_vec_size) goto L6;
        AudioPortMixExt _hidl_vec_element = new AudioPortMixExt();
        _hidl_vec_element.readEmbeddedFromParcel(parcel, childBlob, _hidl_index_0 * 12);
        _hidl_vec.add(_hidl_vec_element);
        _hidl_index_0 = _hidl_index_0 + 1;
        goto L3
    L6:
        return _hidl_vec;
    }

    public final void readEmbeddedFromParcel(HwParcel parcel, HwBlob _hidl_blob, long _hidl_offset) {
        this.hwModule = _hidl_blob.getInt32(0 + _hidl_offset);
        this.ioHandle = _hidl_blob.getInt32(4 + _hidl_offset);
        this.latencyClass = _hidl_blob.getInt32(8 + _hidl_offset);
    }

    public final void writeToParcel(HwParcel parcel) {
        HwBlob _hidl_blob = new HwBlob(12);
        writeEmbeddedToBlob(_hidl_blob, 0);
        parcel.writeBuffer(_hidl_blob);
    }

    public static final void writeVectorToParcel(HwParcel parcel, ArrayList<AudioPortMixExt> _hidl_vec) {
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
        _hidl_blob.putInt32(0 + _hidl_offset, this.hwModule);
        _hidl_blob.putInt32(4 + _hidl_offset, this.ioHandle);
        _hidl_blob.putInt32(8 + _hidl_offset, this.latencyClass);
    }
}
