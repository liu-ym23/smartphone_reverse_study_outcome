package androidx.camera.core.impl;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
final class AutoValue_EncoderProfilesProxy_ImmutableEncoderProfilesProxy extends EncoderProfilesProxy.ImmutableEncoderProfilesProxy {
    private final List<EncoderProfilesProxy.AudioProfileProxy> audioProfiles;
    private final int defaultDurationSeconds;
    private final int recommendedFileFormat;
    private final List<EncoderProfilesProxy.VideoProfileProxy> videoProfiles;

    public int hashCode() {
        return ((((((this.defaultDurationSeconds ^ 1000003) * 1000003) ^ this.recommendedFileFormat) * 1000003) ^ this.audioProfiles.hashCode()) * 1000003) ^ this.videoProfiles.hashCode();
    }

    public String toString() {
        return "ImmutableEncoderProfilesProxy{defaultDurationSeconds=" + this.defaultDurationSeconds + ", recommendedFileFormat=" + this.recommendedFileFormat + ", audioProfiles=" + this.audioProfiles + ", videoProfiles=" + this.videoProfiles + com.alipay.sdk.m.u.i.f25855d;
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProxy
    public List<EncoderProfilesProxy.AudioProfileProxy> getAudioProfiles() {
        return this.audioProfiles;
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProxy
    public int getDefaultDurationSeconds() {
        return this.defaultDurationSeconds;
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProxy
    public int getRecommendedFileFormat() {
        return this.recommendedFileFormat;
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProxy
    public List<EncoderProfilesProxy.VideoProfileProxy> getVideoProfiles() {
        return this.videoProfiles;
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof EncoderProfilesProxy.ImmutableEncoderProfilesProxy) == false) goto L18;
        EncoderProfilesProxy.ImmutableEncoderProfilesProxy r101 = (EncoderProfilesProxy.ImmutableEncoderProfilesProxy) r100;
        if (this.defaultDurationSeconds == r101.getDefaultDurationSeconds()) goto L10;
    L16:
        return false;
    L10:
        if (this.recommendedFileFormat != r101.getRecommendedFileFormat()) goto L16;
        if (this.audioProfiles.equals(r101.getAudioProfiles()) == false) goto L16;
        if (this.videoProfiles.equals(r101.getVideoProfiles()) == false) goto L16;
        return true;
    L18:
        return false;
    }

    public AutoValue_EncoderProfilesProxy_ImmutableEncoderProfilesProxy(int r100, int r101, List<EncoderProfilesProxy.AudioProfileProxy> r102, List<EncoderProfilesProxy.VideoProfileProxy> r103) {
        this.defaultDurationSeconds = r100;
        this.recommendedFileFormat = r101;
        if (r102 == null) goto L11;
        this.audioProfiles = r102;
        if (r103 == null) goto L9;
        this.videoProfiles = r103;
        return;
    L9:
        throw new NullPointerException("Null videoProfiles");
    L11:
        throw new NullPointerException("Null audioProfiles");
    }
}
