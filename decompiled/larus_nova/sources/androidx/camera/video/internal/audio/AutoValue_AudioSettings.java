package androidx.camera.video.internal.audio;

/* JADX INFO: loaded from: classes2.dex */
final class AutoValue_AudioSettings extends AudioSettings {
    private final int audioFormat;
    private final int audioSource;
    private final int channelCount;
    private final int sampleRate;

    /* JADX INFO: renamed from: androidx.camera.video.internal.audio.AutoValue_AudioSettings$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder extends AudioSettings.Builder {
        private Integer audioFormat;
        private Integer audioSource;
        private Integer channelCount;
        private Integer sampleRate;

        @Override // androidx.camera.video.internal.audio.AudioSettings.Builder
        public AudioSettings autoBuild() {
            if (this.audioSource != null) goto L5;
            String r100 = " audioSource";
        L7:
            if (this.sampleRate != null) goto L10;
            r100 = r100 + " sampleRate";
        L10:
            if (this.channelCount != null) goto L13;
            r100 = r100 + " channelCount";
        L13:
            if (this.audioFormat != null) goto L16;
            r100 = r100 + " audioFormat";
        L16:
            if (r100.isEmpty() == false) goto L20;
            return new AutoValue_AudioSettings(this.audioSource.intValue(), this.sampleRate.intValue(), this.channelCount.intValue(), this.audioFormat.intValue(), null);
        L20:
            throw new IllegalStateException("Missing required properties:".concat(r100));
        L5:
            r100 = "";
            goto L7
        }

        public Builder() {
        }

        private Builder(AudioSettings r100) {
            this.audioSource = Integer.valueOf(r100.getAudioSource());
            this.sampleRate = Integer.valueOf(r100.getSampleRate());
            this.channelCount = Integer.valueOf(r100.getChannelCount());
            this.audioFormat = Integer.valueOf(r100.getAudioFormat());
        }

        @Override // androidx.camera.video.internal.audio.AudioSettings.Builder
        public AudioSettings.Builder setAudioFormat(int r100) {
            this.audioFormat = Integer.valueOf(r100);
            return this;
        }

        @Override // androidx.camera.video.internal.audio.AudioSettings.Builder
        public AudioSettings.Builder setAudioSource(int r100) {
            this.audioSource = Integer.valueOf(r100);
            return this;
        }

        @Override // androidx.camera.video.internal.audio.AudioSettings.Builder
        public AudioSettings.Builder setChannelCount(int r100) {
            this.channelCount = Integer.valueOf(r100);
            return this;
        }

        @Override // androidx.camera.video.internal.audio.AudioSettings.Builder
        public AudioSettings.Builder setSampleRate(int r100) {
            this.sampleRate = Integer.valueOf(r100);
            return this;
        }

        public /* synthetic */ Builder(AudioSettings r100, AnonymousClass1 r101) {
            this(r100);
        }
    }

    public int hashCode() {
        return ((((((this.audioSource ^ 1000003) * 1000003) ^ this.sampleRate) * 1000003) ^ this.channelCount) * 1000003) ^ this.audioFormat;
    }

    @Override // androidx.camera.video.internal.audio.AudioSettings
    public AudioSettings.Builder toBuilder() {
        return new Builder(this, null);
    }

    public String toString() {
        return "AudioSettings{audioSource=" + this.audioSource + ", sampleRate=" + this.sampleRate + ", channelCount=" + this.channelCount + ", audioFormat=" + this.audioFormat + com.alipay.sdk.m.u.i.f25855d;
    }

    @Override // androidx.camera.video.internal.audio.AudioSettings
    public int getAudioFormat() {
        return this.audioFormat;
    }

    @Override // androidx.camera.video.internal.audio.AudioSettings
    public int getAudioSource() {
        return this.audioSource;
    }

    @Override // androidx.camera.video.internal.audio.AudioSettings
    public int getChannelCount() {
        return this.channelCount;
    }

    @Override // androidx.camera.video.internal.audio.AudioSettings
    public int getSampleRate() {
        return this.sampleRate;
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof AudioSettings) == false) goto L18;
        AudioSettings r101 = (AudioSettings) r100;
        if (this.audioSource == r101.getAudioSource()) goto L10;
    L16:
        return false;
    L10:
        if (this.sampleRate != r101.getSampleRate()) goto L16;
        if (this.channelCount != r101.getChannelCount()) goto L16;
        if (this.audioFormat != r101.getAudioFormat()) goto L16;
        return true;
    L18:
        return false;
    }

    private AutoValue_AudioSettings(int r100, int r101, int r102, int r103) {
        this.audioSource = r100;
        this.sampleRate = r101;
        this.channelCount = r102;
        this.audioFormat = r103;
    }

    public /* synthetic */ AutoValue_AudioSettings(int r100, int r101, int r102, int r103, AnonymousClass1 r104) {
        this(r100, r101, r102, r103);
    }
}
