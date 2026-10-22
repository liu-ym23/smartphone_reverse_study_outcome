package androidx.camera.video.internal.encoder;

import android.util.Size;
import androidx.camera.core.impl.Timebase;

/* JADX INFO: loaded from: classes2.dex */
final class AutoValue_VideoEncoderConfig extends VideoEncoderConfig {
    private final int IFrameInterval;
    private final int bitrate;
    private final int colorFormat;
    private final VideoEncoderDataSpace dataSpace;
    private final int frameRate;
    private final Timebase inputTimebase;
    private final String mimeType;
    private final int profile;
    private final Size resolution;

    /* JADX INFO: renamed from: androidx.camera.video.internal.encoder.AutoValue_VideoEncoderConfig$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder extends VideoEncoderConfig.Builder {
        private Integer IFrameInterval;
        private Integer bitrate;
        private Integer colorFormat;
        private VideoEncoderDataSpace dataSpace;
        private Integer frameRate;
        private Timebase inputTimebase;
        private String mimeType;
        private Integer profile;
        private Size resolution;

        @Override // androidx.camera.video.internal.encoder.VideoEncoderConfig.Builder
        public VideoEncoderConfig build() {
            if (this.mimeType != null) goto L5;
            String r100 = " mimeType";
        L7:
            if (this.profile != null) goto L10;
            r100 = r100 + " profile";
        L10:
            if (this.inputTimebase != null) goto L13;
            r100 = r100 + " inputTimebase";
        L13:
            if (this.resolution != null) goto L16;
            r100 = r100 + " resolution";
        L16:
            if (this.colorFormat != null) goto L19;
            r100 = r100 + " colorFormat";
        L19:
            if (this.dataSpace != null) goto L22;
            r100 = r100 + " dataSpace";
        L22:
            if (this.frameRate != null) goto L25;
            r100 = r100 + " frameRate";
        L25:
            if (this.IFrameInterval != null) goto L28;
            r100 = r100 + " IFrameInterval";
        L28:
            if (this.bitrate != null) goto L31;
            r100 = r100 + " bitrate";
        L31:
            if (r100.isEmpty() == false) goto L35;
            return new AutoValue_VideoEncoderConfig(this.mimeType, this.profile.intValue(), this.inputTimebase, this.resolution, this.colorFormat.intValue(), this.dataSpace, this.frameRate.intValue(), this.IFrameInterval.intValue(), this.bitrate.intValue(), null);
        L35:
            throw new IllegalStateException("Missing required properties:".concat(r100));
        L5:
            r100 = "";
            goto L7
        }

        public Builder() {
        }

        @Override // androidx.camera.video.internal.encoder.VideoEncoderConfig.Builder
        public VideoEncoderConfig.Builder setBitrate(int r100) {
            this.bitrate = Integer.valueOf(r100);
            return this;
        }

        @Override // androidx.camera.video.internal.encoder.VideoEncoderConfig.Builder
        public VideoEncoderConfig.Builder setColorFormat(int r100) {
            this.colorFormat = Integer.valueOf(r100);
            return this;
        }

        @Override // androidx.camera.video.internal.encoder.VideoEncoderConfig.Builder
        public VideoEncoderConfig.Builder setDataSpace(VideoEncoderDataSpace r100) {
            if (r100 == null) goto L6;
            this.dataSpace = r100;
            return this;
        L6:
            throw new NullPointerException("Null dataSpace");
        }

        @Override // androidx.camera.video.internal.encoder.VideoEncoderConfig.Builder
        public VideoEncoderConfig.Builder setFrameRate(int r100) {
            this.frameRate = Integer.valueOf(r100);
            return this;
        }

        @Override // androidx.camera.video.internal.encoder.VideoEncoderConfig.Builder
        public VideoEncoderConfig.Builder setIFrameInterval(int r100) {
            this.IFrameInterval = Integer.valueOf(r100);
            return this;
        }

        @Override // androidx.camera.video.internal.encoder.VideoEncoderConfig.Builder
        public VideoEncoderConfig.Builder setInputTimebase(Timebase r100) {
            if (r100 == null) goto L6;
            this.inputTimebase = r100;
            return this;
        L6:
            throw new NullPointerException("Null inputTimebase");
        }

        @Override // androidx.camera.video.internal.encoder.VideoEncoderConfig.Builder
        public VideoEncoderConfig.Builder setMimeType(String r100) {
            if (r100 == null) goto L6;
            this.mimeType = r100;
            return this;
        L6:
            throw new NullPointerException("Null mimeType");
        }

        @Override // androidx.camera.video.internal.encoder.VideoEncoderConfig.Builder
        public VideoEncoderConfig.Builder setProfile(int r100) {
            this.profile = Integer.valueOf(r100);
            return this;
        }

        @Override // androidx.camera.video.internal.encoder.VideoEncoderConfig.Builder
        public VideoEncoderConfig.Builder setResolution(Size r100) {
            if (r100 == null) goto L6;
            this.resolution = r100;
            return this;
        L6:
            throw new NullPointerException("Null resolution");
        }
    }

    public int hashCode() {
        return ((((((((((((((((this.mimeType.hashCode() ^ 1000003) * 1000003) ^ this.profile) * 1000003) ^ this.inputTimebase.hashCode()) * 1000003) ^ this.resolution.hashCode()) * 1000003) ^ this.colorFormat) * 1000003) ^ this.dataSpace.hashCode()) * 1000003) ^ this.frameRate) * 1000003) ^ this.IFrameInterval) * 1000003) ^ this.bitrate;
    }

    public String toString() {
        return "VideoEncoderConfig{mimeType=" + this.mimeType + ", profile=" + this.profile + ", inputTimebase=" + this.inputTimebase + ", resolution=" + this.resolution + ", colorFormat=" + this.colorFormat + ", dataSpace=" + this.dataSpace + ", frameRate=" + this.frameRate + ", IFrameInterval=" + this.IFrameInterval + ", bitrate=" + this.bitrate + com.alipay.sdk.m.u.i.f25855d;
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderConfig
    public int getBitrate() {
        return this.bitrate;
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderConfig
    public int getColorFormat() {
        return this.colorFormat;
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderConfig
    public VideoEncoderDataSpace getDataSpace() {
        return this.dataSpace;
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderConfig
    public int getFrameRate() {
        return this.frameRate;
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderConfig
    public int getIFrameInterval() {
        return this.IFrameInterval;
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderConfig, androidx.camera.video.internal.encoder.EncoderConfig
    public Timebase getInputTimebase() {
        return this.inputTimebase;
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderConfig, androidx.camera.video.internal.encoder.EncoderConfig
    public String getMimeType() {
        return this.mimeType;
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderConfig, androidx.camera.video.internal.encoder.EncoderConfig
    public int getProfile() {
        return this.profile;
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderConfig
    public Size getResolution() {
        return this.resolution;
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof VideoEncoderConfig) == false) goto L28;
        VideoEncoderConfig r101 = (VideoEncoderConfig) r100;
        if (this.mimeType.equals(r101.getMimeType()) == true) goto L10;
    L26:
        return false;
    L10:
        if (this.profile != r101.getProfile()) goto L26;
        if (this.inputTimebase.equals(r101.getInputTimebase()) == false) goto L26;
        if (this.resolution.equals(r101.getResolution()) == false) goto L26;
        if (this.colorFormat != r101.getColorFormat()) goto L26;
        if (this.dataSpace.equals(r101.getDataSpace()) == false) goto L26;
        if (this.frameRate != r101.getFrameRate()) goto L26;
        if (this.IFrameInterval != r101.getIFrameInterval()) goto L26;
        if (this.bitrate != r101.getBitrate()) goto L26;
        return true;
    L28:
        return false;
    }

    private AutoValue_VideoEncoderConfig(String r100, int r101, Timebase r102, Size r103, int r104, VideoEncoderDataSpace r105, int r106, int r107, int r108) {
        this.mimeType = r100;
        this.profile = r101;
        this.inputTimebase = r102;
        this.resolution = r103;
        this.colorFormat = r104;
        this.dataSpace = r105;
        this.frameRate = r106;
        this.IFrameInterval = r107;
        this.bitrate = r108;
    }

    public /* synthetic */ AutoValue_VideoEncoderConfig(String r100, int r101, Timebase r102, Size r103, int r104, VideoEncoderDataSpace r105, int r106, int r107, int r108, AnonymousClass1 r110) {
        this(r100, r101, r102, r103, r104, r105, r106, r107, r108);
    }
}
