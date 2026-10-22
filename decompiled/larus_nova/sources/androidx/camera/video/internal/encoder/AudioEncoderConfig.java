package androidx.camera.video.internal.encoder;

import android.media.MediaFormat;
import androidx.camera.core.impl.Timebase;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AudioEncoderConfig implements EncoderConfig {

    public static abstract class Builder {
        public abstract AudioEncoderConfig autoBuild();

        public abstract Builder setBitrate(int r100);

        public abstract Builder setChannelCount(int r100);

        public abstract Builder setInputTimebase(Timebase r100);

        public abstract Builder setMimeType(String r100);

        public abstract Builder setProfile(int r100);

        public abstract Builder setSampleRate(int r100);

        public AudioEncoderConfig build() {
            AudioEncoderConfig r100 = autoBuild();
            if (Objects.equals(r100.getMimeType(), "audio/mp4a-latm") == true) goto L5;
        L9:
            return r100;
        L5:
            if (r100.getProfile() != (-1)) goto L9;
            throw new IllegalArgumentException("Encoder mime set to AAC, but no AAC profile was provided.");
        }

        public Builder() {
        }
    }

    public abstract int getBitrate();

    public abstract int getChannelCount();

    @Override // androidx.camera.video.internal.encoder.EncoderConfig
    public abstract Timebase getInputTimebase();

    @Override // androidx.camera.video.internal.encoder.EncoderConfig
    public abstract String getMimeType();

    @Override // androidx.camera.video.internal.encoder.EncoderConfig
    public abstract int getProfile();

    public abstract int getSampleRate();

    public static Builder builder() {
        return new AutoValue_AudioEncoderConfig.Builder().setProfile(-1);
    }

    @Override // androidx.camera.video.internal.encoder.EncoderConfig
    public MediaFormat toMediaFormat() {
        MediaFormat r100 = MediaFormat.createAudioFormat(getMimeType(), getSampleRate(), getChannelCount());
        r100.setInteger("bitrate", getBitrate());
        if (getProfile() != (-1)) goto L5;
    L8:
        return r100;
    L5:
        if (getMimeType().equals("audio/mp4a-latm") == false) goto L7;
        r100.setInteger("aac-profile", getProfile());
        goto L8
    L7:
        r100.setInteger("profile", getProfile());
        goto L8
    }

    public AudioEncoderConfig() {
    }
}
