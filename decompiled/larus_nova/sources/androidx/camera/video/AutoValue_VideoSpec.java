package androidx.camera.video;

import android.util.Range;

/* JADX INFO: loaded from: classes2.dex */
final class AutoValue_VideoSpec extends VideoSpec {
    private final int aspectRatio;
    private final Range<Integer> bitrate;
    private final Range<Integer> frameRate;
    private final QualitySelector qualitySelector;

    /* JADX INFO: renamed from: androidx.camera.video.AutoValue_VideoSpec$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder extends VideoSpec.Builder {
        private Integer aspectRatio;
        private Range<Integer> bitrate;
        private Range<Integer> frameRate;
        private QualitySelector qualitySelector;

        @Override // androidx.camera.video.VideoSpec.Builder
        public VideoSpec build() {
            if (this.qualitySelector != null) goto L5;
            String r100 = " qualitySelector";
        L7:
            if (this.frameRate != null) goto L10;
            r100 = r100 + " frameRate";
        L10:
            if (this.bitrate != null) goto L13;
            r100 = r100 + " bitrate";
        L13:
            if (this.aspectRatio != null) goto L16;
            r100 = r100 + " aspectRatio";
        L16:
            if (r100.isEmpty() == false) goto L20;
            return new AutoValue_VideoSpec(this.qualitySelector, this.frameRate, this.bitrate, this.aspectRatio.intValue(), null);
        L20:
            throw new IllegalStateException("Missing required properties:".concat(r100));
        L5:
            r100 = "";
            goto L7
        }

        public Builder() {
        }

        private Builder(VideoSpec r100) {
            this.qualitySelector = r100.getQualitySelector();
            this.frameRate = r100.getFrameRate();
            this.bitrate = r100.getBitrate();
            this.aspectRatio = Integer.valueOf(r100.getAspectRatio());
        }

        @Override // androidx.camera.video.VideoSpec.Builder
        public VideoSpec.Builder setAspectRatio(int r100) {
            this.aspectRatio = Integer.valueOf(r100);
            return this;
        }

        @Override // androidx.camera.video.VideoSpec.Builder
        public VideoSpec.Builder setBitrate(Range<Integer> r100) {
            if (r100 == null) goto L6;
            this.bitrate = r100;
            return this;
        L6:
            throw new NullPointerException("Null bitrate");
        }

        @Override // androidx.camera.video.VideoSpec.Builder
        public VideoSpec.Builder setFrameRate(Range<Integer> r100) {
            if (r100 == null) goto L6;
            this.frameRate = r100;
            return this;
        L6:
            throw new NullPointerException("Null frameRate");
        }

        @Override // androidx.camera.video.VideoSpec.Builder
        public VideoSpec.Builder setQualitySelector(QualitySelector r100) {
            if (r100 == null) goto L6;
            this.qualitySelector = r100;
            return this;
        L6:
            throw new NullPointerException("Null qualitySelector");
        }

        public /* synthetic */ Builder(VideoSpec r100, AnonymousClass1 r101) {
            this(r100);
        }
    }

    public int hashCode() {
        return ((((((this.qualitySelector.hashCode() ^ 1000003) * 1000003) ^ this.frameRate.hashCode()) * 1000003) ^ this.bitrate.hashCode()) * 1000003) ^ this.aspectRatio;
    }

    @Override // androidx.camera.video.VideoSpec
    public VideoSpec.Builder toBuilder() {
        return new Builder(this, null);
    }

    public String toString() {
        return "VideoSpec{qualitySelector=" + this.qualitySelector + ", frameRate=" + this.frameRate + ", bitrate=" + this.bitrate + ", aspectRatio=" + this.aspectRatio + com.alipay.sdk.m.u.i.f25855d;
    }

    @Override // androidx.camera.video.VideoSpec
    public int getAspectRatio() {
        return this.aspectRatio;
    }

    @Override // androidx.camera.video.VideoSpec
    public Range<Integer> getBitrate() {
        return this.bitrate;
    }

    @Override // androidx.camera.video.VideoSpec
    public Range<Integer> getFrameRate() {
        return this.frameRate;
    }

    @Override // androidx.camera.video.VideoSpec
    public QualitySelector getQualitySelector() {
        return this.qualitySelector;
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof VideoSpec) == false) goto L18;
        VideoSpec r101 = (VideoSpec) r100;
        if (this.qualitySelector.equals(r101.getQualitySelector()) == true) goto L10;
    L16:
        return false;
    L10:
        if (this.frameRate.equals(r101.getFrameRate()) == false) goto L16;
        if (this.bitrate.equals(r101.getBitrate()) == false) goto L16;
        if (this.aspectRatio != r101.getAspectRatio()) goto L16;
        return true;
    L18:
        return false;
    }

    private AutoValue_VideoSpec(QualitySelector r100, Range<Integer> r101, Range<Integer> r102, int r103) {
        this.qualitySelector = r100;
        this.frameRate = r101;
        this.bitrate = r102;
        this.aspectRatio = r103;
    }

    public /* synthetic */ AutoValue_VideoSpec(QualitySelector r100, Range r101, Range r102, int r103, AnonymousClass1 r104) {
        this(r100, r101, r102, r103);
    }
}
