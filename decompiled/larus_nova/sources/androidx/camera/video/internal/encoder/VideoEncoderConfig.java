package androidx.camera.video.internal.encoder;

import android.media.MediaFormat;
import android.util.Size;
import androidx.camera.core.impl.Timebase;

/* JADX INFO: loaded from: classes2.dex */
public abstract class VideoEncoderConfig implements EncoderConfig {
    private static final int VIDEO_COLOR_FORMAT_DEFAULT = 2130708361;
    private static final int VIDEO_INTRA_FRAME_INTERVAL_DEFAULT = 1;

    public static abstract class Builder {
        public abstract VideoEncoderConfig build();

        public abstract Builder setBitrate(int r100);

        public abstract Builder setColorFormat(int r100);

        public abstract Builder setDataSpace(VideoEncoderDataSpace r100);

        public abstract Builder setFrameRate(int r100);

        public abstract Builder setIFrameInterval(int r100);

        public abstract Builder setInputTimebase(Timebase r100);

        public abstract Builder setMimeType(String r100);

        public abstract Builder setProfile(int r100);

        public abstract Builder setResolution(Size r100);

        public Builder() {
        }
    }

    public abstract int getBitrate();

    public abstract int getColorFormat();

    public abstract VideoEncoderDataSpace getDataSpace();

    public abstract int getFrameRate();

    public abstract int getIFrameInterval();

    @Override // androidx.camera.video.internal.encoder.EncoderConfig
    public abstract Timebase getInputTimebase();

    @Override // androidx.camera.video.internal.encoder.EncoderConfig
    public abstract String getMimeType();

    @Override // androidx.camera.video.internal.encoder.EncoderConfig
    public abstract int getProfile();

    public abstract Size getResolution();

    public static Builder builder() {
        return new AutoValue_VideoEncoderConfig.Builder().setProfile(-1).setIFrameInterval(1).setColorFormat(VIDEO_COLOR_FORMAT_DEFAULT).setDataSpace(VideoEncoderDataSpace.ENCODER_DATA_SPACE_UNSPECIFIED);
    }

    @Override // androidx.camera.video.internal.encoder.EncoderConfig
    public MediaFormat toMediaFormat() {
        Size r100 = getResolution();
        MediaFormat r101 = MediaFormat.createVideoFormat(getMimeType(), r100.getWidth(), r100.getHeight());
        r101.setInteger("color-format", getColorFormat());
        r101.setInteger("bitrate", getBitrate());
        r101.setInteger(com.ss.ttm.player.MediaFormat.KEY_FRAME_RATE, getFrameRate());
        r101.setInteger("i-frame-interval", getIFrameInterval());
        if (getProfile() == (-1)) goto L5;
        r101.setInteger("profile", getProfile());
    L5:
        VideoEncoderDataSpace r102 = getDataSpace();
        if (r102.getStandard() == 0) goto L9;
        r101.setInteger("color-standard", r102.getStandard());
    L9:
        if (r102.getTransfer() == 0) goto L12;
        r101.setInteger("color-transfer", r102.getTransfer());
    L12:
        if (r102.getRange() == 0) goto L14;
        r101.setInteger("color-range", r102.getRange());
    L14:
        return r101;
    }

    public VideoEncoderConfig() {
    }
}
