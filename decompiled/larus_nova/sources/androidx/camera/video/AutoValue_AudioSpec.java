package androidx.camera.video;

import android.util.Range;

/* JADX INFO: loaded from: classes2.dex */
final class AutoValue_AudioSpec extends AudioSpec {
    private final Range<Integer> bitrate;
    private final int channelCount;
    private final Range<Integer> sampleRate;
    private final int source;
    private final int sourceFormat;

    /* JADX INFO: renamed from: androidx.camera.video.AutoValue_AudioSpec$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder extends AudioSpec.Builder {
        private Range<Integer> bitrate;
        private Integer channelCount;
        private Range<Integer> sampleRate;
        private Integer source;
        private Integer sourceFormat;

        @Override // androidx.camera.video.AudioSpec.Builder
        public AudioSpec build() {
            if (this.bitrate != null) goto L5;
            String r100 = " bitrate";
        L7:
            if (this.sourceFormat != null) goto L10;
            r100 = r100 + " sourceFormat";
        L10:
            if (this.source != null) goto L13;
            r100 = r100 + " source";
        L13:
            if (this.sampleRate != null) goto L16;
            r100 = r100 + " sampleRate";
        L16:
            if (this.channelCount != null) goto L19;
            r100 = r100 + " channelCount";
        L19:
            if (r100.isEmpty() == false) goto L23;
            return new AutoValue_AudioSpec(this.bitrate, this.sourceFormat.intValue(), this.source.intValue(), this.sampleRate, this.channelCount.intValue(), null);
        L23:
            throw new IllegalStateException("Missing required properties:".concat(r100));
        L5:
            r100 = "";
            goto L7
        }

        public Builder() {
        }

        private Builder(AudioSpec r100) {
            this.bitrate = r100.getBitrate();
            this.sourceFormat = Integer.valueOf(r100.getSourceFormat());
            this.source = Integer.valueOf(r100.getSource());
            this.sampleRate = r100.getSampleRate();
            this.channelCount = Integer.valueOf(r100.getChannelCount());
        }

        @Override // androidx.camera.video.AudioSpec.Builder
        public AudioSpec.Builder setBitrate(Range<Integer> r100) {
            if (r100 == null) goto L6;
            this.bitrate = r100;
            return this;
        L6:
            throw new NullPointerException("Null bitrate");
        }

        @Override // androidx.camera.video.AudioSpec.Builder
        public AudioSpec.Builder setChannelCount(int r100) {
            this.channelCount = Integer.valueOf(r100);
            return this;
        }

        @Override // androidx.camera.video.AudioSpec.Builder
        public AudioSpec.Builder setSampleRate(Range<Integer> r100) {
            if (r100 == null) goto L6;
            this.sampleRate = r100;
            return this;
        L6:
            throw new NullPointerException("Null sampleRate");
        }

        @Override // androidx.camera.video.AudioSpec.Builder
        public AudioSpec.Builder setSource(int r100) {
            this.source = Integer.valueOf(r100);
            return this;
        }

        @Override // androidx.camera.video.AudioSpec.Builder
        public AudioSpec.Builder setSourceFormat(int r100) {
            this.sourceFormat = Integer.valueOf(r100);
            return this;
        }

        public /* synthetic */ Builder(AudioSpec r100, AnonymousClass1 r101) {
            this(r100);
        }
    }

    public int hashCode() {
        return ((((((((this.bitrate.hashCode() ^ 1000003) * 1000003) ^ this.sourceFormat) * 1000003) ^ this.source) * 1000003) ^ this.sampleRate.hashCode()) * 1000003) ^ this.channelCount;
    }

    @Override // androidx.camera.video.AudioSpec
    public AudioSpec.Builder toBuilder() {
        return new Builder(this, null);
    }

    public String toString() {
        return "AudioSpec{bitrate=" + this.bitrate + ", sourceFormat=" + this.sourceFormat + ", source=" + this.source + ", sampleRate=" + this.sampleRate + ", channelCount=" + this.channelCount + com.alipay.sdk.m.u.i.f25855d;
    }

    @Override // androidx.camera.video.AudioSpec
    public Range<Integer> getBitrate() {
        return this.bitrate;
    }

    @Override // androidx.camera.video.AudioSpec
    public int getChannelCount() {
        return this.channelCount;
    }

    @Override // androidx.camera.video.AudioSpec
    public Range<Integer> getSampleRate() {
        return this.sampleRate;
    }

    @Override // androidx.camera.video.AudioSpec
    public int getSource() {
        return this.source;
    }

    @Override // androidx.camera.video.AudioSpec
    public int getSourceFormat() {
        return this.sourceFormat;
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof AudioSpec) == false) goto L20;
        AudioSpec r101 = (AudioSpec) r100;
        if (this.bitrate.equals(r101.getBitrate()) == true) goto L10;
    L18:
        return false;
    L10:
        if (this.sourceFormat != r101.getSourceFormat()) goto L18;
        if (this.source != r101.getSource()) goto L18;
        if (this.sampleRate.equals(r101.getSampleRate()) == false) goto L18;
        if (this.channelCount != r101.getChannelCount()) goto L18;
        return true;
    L20:
        return false;
    }

    private AutoValue_AudioSpec(Range<Integer> r100, int r101, int r102, Range<Integer> r103, int r104) {
        this.bitrate = r100;
        this.sourceFormat = r101;
        this.source = r102;
        this.sampleRate = r103;
        this.channelCount = r104;
    }

    public /* synthetic */ AutoValue_AudioSpec(Range r100, int r101, int r102, Range r103, int r104, AnonymousClass1 r105) {
        this(r100, r101, r102, r103, r104);
    }
}
