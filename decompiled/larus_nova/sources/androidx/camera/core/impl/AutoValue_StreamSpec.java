package androidx.camera.core.impl;

import android.util.Range;
import android.util.Size;
import androidx.camera.core.DynamicRange;

/* JADX INFO: loaded from: classes2.dex */
final class AutoValue_StreamSpec extends StreamSpec {
    private final DynamicRange dynamicRange;
    private final Range<Integer> expectedFrameRateRange;
    private final Config implementationOptions;
    private final Size resolution;
    private final boolean zslDisabled;

    /* JADX INFO: renamed from: androidx.camera.core.impl.AutoValue_StreamSpec$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder extends StreamSpec.Builder {
        private DynamicRange dynamicRange;
        private Range<Integer> expectedFrameRateRange;
        private Config implementationOptions;
        private Size resolution;
        private Boolean zslDisabled;

        @Override // androidx.camera.core.impl.StreamSpec.Builder
        public StreamSpec build() {
            if (this.resolution != null) goto L5;
            String r100 = " resolution";
        L7:
            if (this.dynamicRange != null) goto L10;
            r100 = r100 + " dynamicRange";
        L10:
            if (this.expectedFrameRateRange != null) goto L13;
            r100 = r100 + " expectedFrameRateRange";
        L13:
            if (this.zslDisabled != null) goto L16;
            r100 = r100 + " zslDisabled";
        L16:
            if (r100.isEmpty() == false) goto L20;
            return new AutoValue_StreamSpec(this.resolution, this.dynamicRange, this.expectedFrameRateRange, this.implementationOptions, this.zslDisabled.booleanValue(), null);
        L20:
            throw new IllegalStateException("Missing required properties:".concat(r100));
        L5:
            r100 = "";
            goto L7
        }

        public Builder() {
        }

        private Builder(StreamSpec r100) {
            this.resolution = r100.getResolution();
            this.dynamicRange = r100.getDynamicRange();
            this.expectedFrameRateRange = r100.getExpectedFrameRateRange();
            this.implementationOptions = r100.getImplementationOptions();
            this.zslDisabled = Boolean.valueOf(r100.getZslDisabled());
        }

        @Override // androidx.camera.core.impl.StreamSpec.Builder
        public StreamSpec.Builder setDynamicRange(DynamicRange r100) {
            if (r100 == null) goto L6;
            this.dynamicRange = r100;
            return this;
        L6:
            throw new NullPointerException("Null dynamicRange");
        }

        @Override // androidx.camera.core.impl.StreamSpec.Builder
        public StreamSpec.Builder setExpectedFrameRateRange(Range<Integer> r100) {
            if (r100 == null) goto L6;
            this.expectedFrameRateRange = r100;
            return this;
        L6:
            throw new NullPointerException("Null expectedFrameRateRange");
        }

        @Override // androidx.camera.core.impl.StreamSpec.Builder
        public StreamSpec.Builder setImplementationOptions(Config r100) {
            this.implementationOptions = r100;
            return this;
        }

        @Override // androidx.camera.core.impl.StreamSpec.Builder
        public StreamSpec.Builder setResolution(Size r100) {
            if (r100 == null) goto L6;
            this.resolution = r100;
            return this;
        L6:
            throw new NullPointerException("Null resolution");
        }

        @Override // androidx.camera.core.impl.StreamSpec.Builder
        public StreamSpec.Builder setZslDisabled(boolean r100) {
            this.zslDisabled = Boolean.valueOf(r100);
            return this;
        }

        public /* synthetic */ Builder(StreamSpec r100, AnonymousClass1 r101) {
            this(r100);
        }
    }

    public int hashCode() {
        int r100 = (((((this.resolution.hashCode() ^ 1000003) * 1000003) ^ this.dynamicRange.hashCode()) * 1000003) ^ this.expectedFrameRateRange.hashCode()) * 1000003;
        Config r101 = this.implementationOptions;
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (r100 ^ r102) * 1000003;
        if (this.zslDisabled == false) goto L9;
        int r104 = 1231;
    L11:
        return r103 ^ r104;
    L9:
        r104 = 1237;
        goto L11
    L5:
        r102 = r101.hashCode();
        goto L6
    }

    @Override // androidx.camera.core.impl.StreamSpec
    public StreamSpec.Builder toBuilder() {
        return new Builder(this, null);
    }

    public String toString() {
        return "StreamSpec{resolution=" + this.resolution + ", dynamicRange=" + this.dynamicRange + ", expectedFrameRateRange=" + this.expectedFrameRateRange + ", implementationOptions=" + this.implementationOptions + ", zslDisabled=" + this.zslDisabled + com.alipay.sdk.m.u.i.f25855d;
    }

    @Override // androidx.camera.core.impl.StreamSpec
    public DynamicRange getDynamicRange() {
        return this.dynamicRange;
    }

    @Override // androidx.camera.core.impl.StreamSpec
    public Range<Integer> getExpectedFrameRateRange() {
        return this.expectedFrameRateRange;
    }

    @Override // androidx.camera.core.impl.StreamSpec
    public Config getImplementationOptions() {
        return this.implementationOptions;
    }

    @Override // androidx.camera.core.impl.StreamSpec
    public Size getResolution() {
        return this.resolution;
    }

    @Override // androidx.camera.core.impl.StreamSpec
    public boolean getZslDisabled() {
        return this.zslDisabled;
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof StreamSpec) == false) goto L25;
        StreamSpec r101 = (StreamSpec) r100;
        if (this.resolution.equals(r101.getResolution()) == true) goto L10;
    L23:
        return false;
    L10:
        if (this.dynamicRange.equals(r101.getDynamicRange()) == false) goto L23;
        if (this.expectedFrameRateRange.equals(r101.getExpectedFrameRateRange()) == false) goto L23;
        Config r102 = this.implementationOptions;
        if (r102 != null) goto L19;
        if (r101.getImplementationOptions() != null) goto L23;
    L21:
        if (this.zslDisabled != r101.getZslDisabled()) goto L23;
        return true;
    L19:
        if (r102.equals(r101.getImplementationOptions()) == false) goto L23;
    L25:
        return false;
    }

    private AutoValue_StreamSpec(Size r100, DynamicRange r101, Range<Integer> r102, Config r103, boolean r104) {
        this.resolution = r100;
        this.dynamicRange = r101;
        this.expectedFrameRateRange = r102;
        this.implementationOptions = r103;
        this.zslDisabled = r104;
    }

    public /* synthetic */ AutoValue_StreamSpec(Size r100, DynamicRange r101, Range r102, Config r103, boolean r104, AnonymousClass1 r105) {
        this(r100, r101, r102, r103, r104);
    }
}
