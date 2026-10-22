package android.hardware.audio.common.V2_0;

import android.os.HidlSupport;
import android.os.HwBlob;
import android.os.HwParcel;
import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class AudioOffloadInfo {
    public int bitRatePerSecond;
    public int bitWidth;
    public int bufferSize;
    public int channelMask;
    public long durationMicroseconds;
    public int format;
    public boolean hasVideo;
    public boolean isStreaming;
    public int sampleRateHz;
    public int streamType;
    public int usage;

    public AudioOffloadInfo() {
        this.sampleRateHz = 0;
        this.channelMask = 0;
        this.format = 0;
        this.streamType = 0;
        this.bitRatePerSecond = 0;
        this.durationMicroseconds = 0;
        this.hasVideo = false;
        this.isStreaming = false;
        this.bitWidth = 0;
        this.bufferSize = 0;
        this.usage = 0;
    }

    public final boolean equals(Object otherObject) {
        if (this != otherObject) goto L6;
        return true;
    L6:
        if (otherObject != null) goto L9;
        return false;
    L9:
        if (otherObject.getClass() == AudioOffloadInfo.class) goto L11;
        return false;
    L11:
        AudioOffloadInfo other = (AudioOffloadInfo) otherObject;
        if (this.sampleRateHz == other.sampleRateHz) goto L15;
        return false;
    L15:
        if (this.channelMask == other.channelMask) goto L18;
        return false;
    L18:
        if (this.format == other.format) goto L21;
        return false;
    L21:
        if (this.streamType == other.streamType) goto L24;
        return false;
    L24:
        if (this.bitRatePerSecond == other.bitRatePerSecond) goto L27;
        return false;
    L27:
        if (this.durationMicroseconds == other.durationMicroseconds) goto L30;
        return false;
    L30:
        if (this.hasVideo == other.hasVideo) goto L33;
        return false;
    L33:
        if (this.isStreaming == other.isStreaming) goto L36;
        return false;
    L36:
        if (this.bitWidth == other.bitWidth) goto L39;
        return false;
    L39:
        if (this.bufferSize == other.bufferSize) goto L42;
        return false;
    L42:
        if (this.usage == other.usage) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.sampleRateHz))), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.channelMask))), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.format))), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.streamType))), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.bitRatePerSecond))), Integer.valueOf(HidlSupport.deepHashCode(Long.valueOf(this.durationMicroseconds))), Integer.valueOf(HidlSupport.deepHashCode(Boolean.valueOf(this.hasVideo))), Integer.valueOf(HidlSupport.deepHashCode(Boolean.valueOf(this.isStreaming))), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.bitWidth))), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.bufferSize))), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.usage)))});
    }

    public final String toString() {
        return "{.sampleRateHz = " + this.sampleRateHz + ", .channelMask = " + AudioChannelMask.toString(this.channelMask) + ", .format = " + AudioFormat.toString(this.format) + ", .streamType = " + AudioStreamType.toString(this.streamType) + ", .bitRatePerSecond = " + this.bitRatePerSecond + ", .durationMicroseconds = " + this.durationMicroseconds + ", .hasVideo = " + this.hasVideo + ", .isStreaming = " + this.isStreaming + ", .bitWidth = " + this.bitWidth + ", .bufferSize = " + this.bufferSize + ", .usage = " + AudioUsage.toString(this.usage) + "}";
    }

    public final void readFromParcel(HwParcel parcel) {
        HwBlob blob = parcel.readBuffer(48);
        readEmbeddedFromParcel(parcel, blob, 0);
    }

    public static final ArrayList<AudioOffloadInfo> readVectorFromParcel(HwParcel parcel) {
        ArrayList<AudioOffloadInfo> _hidl_vec = new ArrayList();
        HwBlob _hidl_blob = parcel.readBuffer(16);
        int _hidl_vec_size = _hidl_blob.getInt32(8);
        HwBlob childBlob = parcel.readEmbeddedBuffer(_hidl_vec_size * 48, _hidl_blob.handle(), 0, true);
        _hidl_vec.clear();
        int _hidl_index_0 = 0;
    L3:
        if (_hidl_index_0 >= _hidl_vec_size) goto L6;
        AudioOffloadInfo _hidl_vec_element = new AudioOffloadInfo();
        _hidl_vec_element.readEmbeddedFromParcel(parcel, childBlob, _hidl_index_0 * 48);
        _hidl_vec.add(_hidl_vec_element);
        _hidl_index_0 = _hidl_index_0 + 1;
        goto L3
    L6:
        return _hidl_vec;
    }

    public final void readEmbeddedFromParcel(HwParcel parcel, HwBlob _hidl_blob, long _hidl_offset) {
        this.sampleRateHz = _hidl_blob.getInt32(0 + _hidl_offset);
        this.channelMask = _hidl_blob.getInt32(4 + _hidl_offset);
        this.format = _hidl_blob.getInt32(8 + _hidl_offset);
        this.streamType = _hidl_blob.getInt32(12 + _hidl_offset);
        this.bitRatePerSecond = _hidl_blob.getInt32(16 + _hidl_offset);
        this.durationMicroseconds = _hidl_blob.getInt64(24 + _hidl_offset);
        this.hasVideo = _hidl_blob.getBool(32 + _hidl_offset);
        this.isStreaming = _hidl_blob.getBool(33 + _hidl_offset);
        this.bitWidth = _hidl_blob.getInt32(36 + _hidl_offset);
        this.bufferSize = _hidl_blob.getInt32(40 + _hidl_offset);
        this.usage = _hidl_blob.getInt32(44 + _hidl_offset);
    }

    public final void writeToParcel(HwParcel parcel) {
        HwBlob _hidl_blob = new HwBlob(48);
        writeEmbeddedToBlob(_hidl_blob, 0);
        parcel.writeBuffer(_hidl_blob);
    }

    public static final void writeVectorToParcel(HwParcel parcel, ArrayList<AudioOffloadInfo> _hidl_vec) {
        HwBlob _hidl_blob = new HwBlob(16);
        int _hidl_vec_size = _hidl_vec.size();
        _hidl_blob.putInt32(8, _hidl_vec_size);
        _hidl_blob.putBool(12, false);
        HwBlob childBlob = new HwBlob(_hidl_vec_size * 48);
        int _hidl_index_0 = 0;
    L3:
        if (_hidl_index_0 >= _hidl_vec_size) goto L5;
        _hidl_vec.get(_hidl_index_0).writeEmbeddedToBlob(childBlob, _hidl_index_0 * 48);
        _hidl_index_0 = _hidl_index_0 + 1;
        goto L3
    L5:
        _hidl_blob.putBlob(0, childBlob);
        parcel.writeBuffer(_hidl_blob);
    }

    public final void writeEmbeddedToBlob(HwBlob _hidl_blob, long _hidl_offset) {
        _hidl_blob.putInt32(0 + _hidl_offset, this.sampleRateHz);
        _hidl_blob.putInt32(4 + _hidl_offset, this.channelMask);
        _hidl_blob.putInt32(8 + _hidl_offset, this.format);
        _hidl_blob.putInt32(12 + _hidl_offset, this.streamType);
        _hidl_blob.putInt32(16 + _hidl_offset, this.bitRatePerSecond);
        _hidl_blob.putInt64(24 + _hidl_offset, this.durationMicroseconds);
        _hidl_blob.putBool(32 + _hidl_offset, this.hasVideo);
        _hidl_blob.putBool(33 + _hidl_offset, this.isStreaming);
        _hidl_blob.putInt32(36 + _hidl_offset, this.bitWidth);
        _hidl_blob.putInt32(40 + _hidl_offset, this.bufferSize);
        _hidl_blob.putInt32(44 + _hidl_offset, this.usage);
    }
}
