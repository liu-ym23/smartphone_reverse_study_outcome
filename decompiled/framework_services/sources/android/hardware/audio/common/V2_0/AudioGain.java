package android.hardware.audio.common.V2_0;

import android.os.HidlSupport;
import android.os.HwBlob;
import android.os.HwParcel;
import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class AudioGain {
    public int channelMask;
    public int defaultValue;
    public int maxRampMs;
    public int maxValue;
    public int minRampMs;
    public int minValue;
    public int mode;
    public int stepValue;

    public AudioGain() {
        this.mode = 0;
        this.channelMask = 0;
        this.minValue = 0;
        this.maxValue = 0;
        this.defaultValue = 0;
        this.stepValue = 0;
        this.minRampMs = 0;
        this.maxRampMs = 0;
    }

    public final boolean equals(Object otherObject) {
        if (this != otherObject) goto L6;
        return true;
    L6:
        if (otherObject != null) goto L9;
        return false;
    L9:
        if (otherObject.getClass() == AudioGain.class) goto L11;
        return false;
    L11:
        AudioGain other = (AudioGain) otherObject;
        if (this.mode == other.mode) goto L15;
        return false;
    L15:
        if (this.channelMask == other.channelMask) goto L18;
        return false;
    L18:
        if (this.minValue == other.minValue) goto L21;
        return false;
    L21:
        if (this.maxValue == other.maxValue) goto L24;
        return false;
    L24:
        if (this.defaultValue == other.defaultValue) goto L27;
        return false;
    L27:
        if (this.stepValue == other.stepValue) goto L30;
        return false;
    L30:
        if (this.minRampMs == other.minRampMs) goto L33;
        return false;
    L33:
        if (this.maxRampMs == other.maxRampMs) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.mode))), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.channelMask))), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.minValue))), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.maxValue))), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.defaultValue))), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.stepValue))), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.minRampMs))), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.maxRampMs)))});
    }

    public final String toString() {
        return "{.mode = " + AudioGainMode.toString(this.mode) + ", .channelMask = " + AudioChannelMask.toString(this.channelMask) + ", .minValue = " + this.minValue + ", .maxValue = " + this.maxValue + ", .defaultValue = " + this.defaultValue + ", .stepValue = " + this.stepValue + ", .minRampMs = " + this.minRampMs + ", .maxRampMs = " + this.maxRampMs + "}";
    }

    public final void readFromParcel(HwParcel parcel) {
        HwBlob blob = parcel.readBuffer(32);
        readEmbeddedFromParcel(parcel, blob, 0);
    }

    public static final ArrayList<AudioGain> readVectorFromParcel(HwParcel parcel) {
        ArrayList<AudioGain> _hidl_vec = new ArrayList();
        HwBlob _hidl_blob = parcel.readBuffer(16);
        int _hidl_vec_size = _hidl_blob.getInt32(8);
        HwBlob childBlob = parcel.readEmbeddedBuffer(_hidl_vec_size * 32, _hidl_blob.handle(), 0, true);
        _hidl_vec.clear();
        int _hidl_index_0 = 0;
    L3:
        if (_hidl_index_0 >= _hidl_vec_size) goto L6;
        AudioGain _hidl_vec_element = new AudioGain();
        _hidl_vec_element.readEmbeddedFromParcel(parcel, childBlob, _hidl_index_0 * 32);
        _hidl_vec.add(_hidl_vec_element);
        _hidl_index_0 = _hidl_index_0 + 1;
        goto L3
    L6:
        return _hidl_vec;
    }

    public final void readEmbeddedFromParcel(HwParcel parcel, HwBlob _hidl_blob, long _hidl_offset) {
        this.mode = _hidl_blob.getInt32(0 + _hidl_offset);
        this.channelMask = _hidl_blob.getInt32(4 + _hidl_offset);
        this.minValue = _hidl_blob.getInt32(8 + _hidl_offset);
        this.maxValue = _hidl_blob.getInt32(12 + _hidl_offset);
        this.defaultValue = _hidl_blob.getInt32(16 + _hidl_offset);
        this.stepValue = _hidl_blob.getInt32(20 + _hidl_offset);
        this.minRampMs = _hidl_blob.getInt32(24 + _hidl_offset);
        this.maxRampMs = _hidl_blob.getInt32(28 + _hidl_offset);
    }

    public final void writeToParcel(HwParcel parcel) {
        HwBlob _hidl_blob = new HwBlob(32);
        writeEmbeddedToBlob(_hidl_blob, 0);
        parcel.writeBuffer(_hidl_blob);
    }

    public static final void writeVectorToParcel(HwParcel parcel, ArrayList<AudioGain> _hidl_vec) {
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
        _hidl_blob.putInt32(0 + _hidl_offset, this.mode);
        _hidl_blob.putInt32(4 + _hidl_offset, this.channelMask);
        _hidl_blob.putInt32(8 + _hidl_offset, this.minValue);
        _hidl_blob.putInt32(12 + _hidl_offset, this.maxValue);
        _hidl_blob.putInt32(16 + _hidl_offset, this.defaultValue);
        _hidl_blob.putInt32(20 + _hidl_offset, this.stepValue);
        _hidl_blob.putInt32(24 + _hidl_offset, this.minRampMs);
        _hidl_blob.putInt32(28 + _hidl_offset, this.maxRampMs);
    }
}
