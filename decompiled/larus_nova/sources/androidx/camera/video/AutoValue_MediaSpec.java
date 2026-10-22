package androidx.camera.video;

/* JADX INFO: loaded from: classes2.dex */
final class AutoValue_MediaSpec extends MediaSpec {
    private final AudioSpec audioSpec;
    private final int outputFormat;
    private final VideoSpec videoSpec;

    /* JADX INFO: renamed from: androidx.camera.video.AutoValue_MediaSpec$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder extends MediaSpec.Builder {
        private AudioSpec audioSpec;
        private Integer outputFormat;
        private VideoSpec videoSpec;

        @Override // androidx.camera.video.MediaSpec.Builder
        public MediaSpec build() {
            if (this.videoSpec != null) goto L5;
            String r100 = " videoSpec";
        L7:
            if (this.audioSpec != null) goto L10;
            r100 = r100 + " audioSpec";
        L10:
            if (this.outputFormat != null) goto L13;
            r100 = r100 + " outputFormat";
        L13:
            if (r100.isEmpty() == false) goto L17;
            return new AutoValue_MediaSpec(this.videoSpec, this.audioSpec, this.outputFormat.intValue(), null);
        L17:
            throw new IllegalStateException("Missing required properties:".concat(r100));
        L5:
            r100 = "";
            goto L7
        }

        @Override // androidx.camera.video.MediaSpec.Builder
        public AudioSpec getAudioSpec() {
            AudioSpec r100 = this.audioSpec;
            if (r100 == null) goto L6;
            return r100;
        L6:
            throw new IllegalStateException("Property \"audioSpec\" has not been set");
        }

        @Override // androidx.camera.video.MediaSpec.Builder
        public VideoSpec getVideoSpec() {
            VideoSpec r100 = this.videoSpec;
            if (r100 == null) goto L6;
            return r100;
        L6:
            throw new IllegalStateException("Property \"videoSpec\" has not been set");
        }

        public Builder() {
        }

        private Builder(MediaSpec r100) {
            this.videoSpec = r100.getVideoSpec();
            this.audioSpec = r100.getAudioSpec();
            this.outputFormat = Integer.valueOf(r100.getOutputFormat());
        }

        @Override // androidx.camera.video.MediaSpec.Builder
        public MediaSpec.Builder setAudioSpec(AudioSpec r100) {
            if (r100 == null) goto L6;
            this.audioSpec = r100;
            return this;
        L6:
            throw new NullPointerException("Null audioSpec");
        }

        @Override // androidx.camera.video.MediaSpec.Builder
        public MediaSpec.Builder setOutputFormat(int r100) {
            this.outputFormat = Integer.valueOf(r100);
            return this;
        }

        @Override // androidx.camera.video.MediaSpec.Builder
        public MediaSpec.Builder setVideoSpec(VideoSpec r100) {
            if (r100 == null) goto L6;
            this.videoSpec = r100;
            return this;
        L6:
            throw new NullPointerException("Null videoSpec");
        }

        public /* synthetic */ Builder(MediaSpec r100, AnonymousClass1 r101) {
            this(r100);
        }
    }

    public int hashCode() {
        return ((((this.videoSpec.hashCode() ^ 1000003) * 1000003) ^ this.audioSpec.hashCode()) * 1000003) ^ this.outputFormat;
    }

    @Override // androidx.camera.video.MediaSpec
    public MediaSpec.Builder toBuilder() {
        return new Builder(this, null);
    }

    public String toString() {
        return "MediaSpec{videoSpec=" + this.videoSpec + ", audioSpec=" + this.audioSpec + ", outputFormat=" + this.outputFormat + com.alipay.sdk.m.u.i.f25855d;
    }

    @Override // androidx.camera.video.MediaSpec
    public AudioSpec getAudioSpec() {
        return this.audioSpec;
    }

    @Override // androidx.camera.video.MediaSpec
    public int getOutputFormat() {
        return this.outputFormat;
    }

    @Override // androidx.camera.video.MediaSpec
    public VideoSpec getVideoSpec() {
        return this.videoSpec;
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof MediaSpec) == false) goto L16;
        MediaSpec r101 = (MediaSpec) r100;
        if (this.videoSpec.equals(r101.getVideoSpec()) == true) goto L10;
    L14:
        return false;
    L10:
        if (this.audioSpec.equals(r101.getAudioSpec()) == false) goto L14;
        if (this.outputFormat != r101.getOutputFormat()) goto L14;
        return true;
    L16:
        return false;
    }

    private AutoValue_MediaSpec(VideoSpec r100, AudioSpec r101, int r102) {
        this.videoSpec = r100;
        this.audioSpec = r101;
        this.outputFormat = r102;
    }

    public /* synthetic */ AutoValue_MediaSpec(VideoSpec r100, AudioSpec r101, int r102, AnonymousClass1 r103) {
        this(r100, r101, r102);
    }
}
