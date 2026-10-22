package android.media.alwayson;

import android.media.AudioFormat;
import android.media.AudioRecord;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class AlwaysOnCaptureAudioFormat implements Parcelable {
    public static final Parcelable.Creator<AlwaysOnCaptureAudioFormat> CREATOR = new Parcelable.Creator<AlwaysOnCaptureAudioFormat>() { // from class: android.media.alwayson.AlwaysOnCaptureAudioFormat.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AlwaysOnCaptureAudioFormat createFromParcel(Parcel in) {
            return new AlwaysOnCaptureAudioFormat(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AlwaysOnCaptureAudioFormat[] newArray(int size) {
            return new AlwaysOnCaptureAudioFormat[size];
        }
    };
    public final int audioSessionId;
    public final int channelCount;
    public final int channelMask;
    public final int encoding;
    public final int frameSizeInBytes;
    public final int sampleRate;

    public AlwaysOnCaptureAudioFormat(int sampleRate, int channelMask, int channelCount, int encoding, int frameSizeInBytes, int audioSessionId) {
        this.sampleRate = sampleRate;
        this.channelMask = channelMask;
        this.channelCount = channelCount;
        this.encoding = encoding;
        this.frameSizeInBytes = frameSizeInBytes;
        this.audioSessionId = audioSessionId;
    }

    private AlwaysOnCaptureAudioFormat(Parcel in) {
        this.sampleRate = in.readInt();
        this.channelMask = in.readInt();
        this.channelCount = in.readInt();
        this.encoding = in.readInt();
        this.frameSizeInBytes = in.readInt();
        this.audioSessionId = in.readInt();
    }

    public static AlwaysOnCaptureAudioFormat fromAudioRecord(AudioRecord record) {
        AudioFormat format = record.getFormat();
        int frameSize = Math.max(1, format.getChannelCount()) * Math.max(1, AudioFormat.getBytesPerSample(format.getEncoding()));
        return new AlwaysOnCaptureAudioFormat(record.getSampleRate(), format.getChannelMask(), format.getChannelCount(), format.getEncoding(), frameSize, record.getAudioSessionId());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.sampleRate);
        dest.writeInt(this.channelMask);
        dest.writeInt(this.channelCount);
        dest.writeInt(this.encoding);
        dest.writeInt(this.frameSizeInBytes);
        dest.writeInt(this.audioSessionId);
    }
}
