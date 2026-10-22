package androidx.camera.video.internal.encoder;

import androidx.camera.core.impl.Timebase;

/* JADX INFO: loaded from: classes2.dex */
final class AutoValue_AudioEncoderConfig extends AudioEncoderConfig {
    private final int bitrate;
    private final int channelCount;
    private final Timebase inputTimebase;
    private final String mimeType;
    private final int profile;
    private final int sampleRate;

    /* JADX INFO: renamed from: androidx.camera.video.internal.encoder.AutoValue_AudioEncoderConfig$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder extends AudioEncoderConfig.Builder {
        private Integer bitrate;
        private Integer channelCount;
        private Timebase inputTimebase;
        private String mimeType;
        private Integer profile;
        private Integer sampleRate;

        @Override // androidx.camera.video.internal.encoder.AudioEncoderConfig.Builder
        public AudioEncoderConfig autoBuild() {
            if (this.mimeType != null) goto L5;
            String r100 = " mimeType";
        L7:
            if (this.profile != null) goto L10;
            r100 = r100 + " profile";
        L10:
            if (this.inputTimebase != null) goto L13;
            r100 = r100 + " inputTimebase";
        L13:
            if (this.bitrate != null) goto L16;
            r100 = r100 + " bitrate";
        L16:
            if (this.sampleRate != null) goto L19;
            r100 = r100 + " sampleRate";
        L19:
            if (this.channelCount != null) goto L22;
            r100 = r100 + " channelCount";
        L22:
            if (r100.isEmpty() == false) goto L26;
            return new AutoValue_AudioEncoderConfig(this.mimeType, this.profile.intValue(), this.inputTimebase, this.bitrate.intValue(), this.sampleRate.intValue(), this.channelCount.intValue(), null);
        L26:
            throw new IllegalStateException("Missing required properties:".concat(r100));
        L5:
            r100 = "";
            goto L7
        }

        public Builder() {
        }

        @Override // androidx.camera.video.internal.encoder.AudioEncoderConfig.Builder
        public AudioEncoderConfig.Builder setBitrate(int r100) {
            this.bitrate = Integer.valueOf(r100);
            return this;
        }

        @Override // androidx.camera.video.internal.encoder.AudioEncoderConfig.Builder
        public AudioEncoderConfig.Builder setChannelCount(int r100) {
            this.channelCount = Integer.valueOf(r100);
            return this;
        }

        @Override // androidx.camera.video.internal.encoder.AudioEncoderConfig.Builder
        public AudioEncoderConfig.Builder setInputTimebase(Timebase r100) {
            if (r100 == null) goto L6;
            this.inputTimebase = r100;
            return this;
        L6:
            throw new NullPointerException("Null inputTimebase");
        }

        @Override // androidx.camera.video.internal.encoder.AudioEncoderConfig.Builder
        public AudioEncoderConfig.Builder setMimeType(String r100) {
            if (r100 == null) goto L6;
            this.mimeType = r100;
            return this;
        L6:
            throw new NullPointerException("Null mimeType");
        }

        @Override // androidx.camera.video.internal.encoder.AudioEncoderConfig.Builder
        public AudioEncoderConfig.Builder setProfile(int r100) {
            this.profile = Integer.valueOf(r100);
            return this;
        }

        @Override // androidx.camera.video.internal.encoder.AudioEncoderConfig.Builder
        public AudioEncoderConfig.Builder setSampleRate(int r100) {
            this.sampleRate = Integer.valueOf(r100);
            return this;
        }
    }

    public int hashCode() {
        return ((((((((((this.mimeType.hashCode() ^ 1000003) * 1000003) ^ this.profile) * 1000003) ^ this.inputTimebase.hashCode()) * 1000003) ^ this.bitrate) * 1000003) ^ this.sampleRate) * 1000003) ^ this.channelCount;
    }

    public String toString() {
        return "AudioEncoderConfig{mimeType=" + this.mimeType + ", profile=" + this.profile + ", inputTimebase=" + this.inputTimebase + ", bitrate=" + this.bitrate + ", sampleRate=" + this.sampleRate + ", channelCount=" + this.channelCount + com.alipay.sdk.m.u.i.f25855d;
    }

    @Override // androidx.camera.video.internal.encoder.AudioEncoderConfig
    public int getBitrate() {
        return this.bitrate;
    }

    @Override // androidx.camera.video.internal.encoder.AudioEncoderConfig
    public int getChannelCount() {
        return this.channelCount;
    }

    @Override // androidx.camera.video.internal.encoder.AudioEncoderConfig, androidx.camera.video.internal.encoder.EncoderConfig
    public Timebase getInputTimebase() {
        return this.inputTimebase;
    }

    @Override // androidx.camera.video.internal.encoder.AudioEncoderConfig, androidx.camera.video.internal.encoder.EncoderConfig
    public String getMimeType() {
        return this.mimeType;
    }

    @Override // androidx.camera.video.internal.encoder.AudioEncoderConfig, androidx.camera.video.internal.encoder.EncoderConfig
    public int getProfile() {
        return this.profile;
    }

    @Override // androidx.camera.video.internal.encoder.AudioEncoderConfig
    public int getSampleRate() {
        return this.sampleRate;
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof AudioEncoderConfig) == false) goto L22;
        AudioEncoderConfig r101 = (AudioEncoderConfig) r100;
        if (this.mimeType.equals(r101.getMimeType()) == true) goto L10;
    L20:
        return false;
    L10:
        if (this.profile != r101.getProfile()) goto L20;
        if (this.inputTimebase.equals(r101.getInputTimebase()) == false) goto L20;
        if (this.bitrate != r101.getBitrate()) goto L20;
        if (this.sampleRate != r101.getSampleRate()) goto L20;
        if (this.channelCount != r101.getChannelCount()) goto L20;
        return true;
    L22:
        return false;
    }

    private AutoValue_AudioEncoderConfig(String r100, int r101, Timebase r102, int r103, int r104, int r105) {
        this.mimeType = r100;
        this.profile = r101;
        this.inputTimebase = r102;
        this.bitrate = r103;
        this.sampleRate = r104;
        this.channelCount = r105;
    }

    public /* synthetic */ AutoValue_AudioEncoderConfig(String r100, int r101, Timebase r102, int r103, int r104, int r105, AnonymousClass1 r106) {
        this(r100, r101, r102, r103, r104, r105);
    }
}
