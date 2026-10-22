package androidx.camera.video.internal;

import androidx.camera.core.impl.EncoderProfilesProxy;
import com.alipay.sdk.m.u.i;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
final class AutoValue_VideoValidatedEncoderProfilesProxy extends VideoValidatedEncoderProfilesProxy {
    private final List<EncoderProfilesProxy.AudioProfileProxy> audioProfiles;
    private final EncoderProfilesProxy.AudioProfileProxy defaultAudioProfile;
    private final int defaultDurationSeconds;
    private final EncoderProfilesProxy.VideoProfileProxy defaultVideoProfile;
    private final int recommendedFileFormat;
    private final List<EncoderProfilesProxy.VideoProfileProxy> videoProfiles;

    public int hashCode() {
        int r100 = (((((((this.defaultDurationSeconds ^ 1000003) * 1000003) ^ this.recommendedFileFormat) * 1000003) ^ this.audioProfiles.hashCode()) * 1000003) ^ this.videoProfiles.hashCode()) * 1000003;
        EncoderProfilesProxy.AudioProfileProxy r101 = this.defaultAudioProfile;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return ((r100 ^ r102) * 1000003) ^ this.defaultVideoProfile.hashCode();
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public String toString() {
        return "VideoValidatedEncoderProfilesProxy{defaultDurationSeconds=" + this.defaultDurationSeconds + ", recommendedFileFormat=" + this.recommendedFileFormat + ", audioProfiles=" + this.audioProfiles + ", videoProfiles=" + this.videoProfiles + ", defaultAudioProfile=" + this.defaultAudioProfile + ", defaultVideoProfile=" + this.defaultVideoProfile + i.f25855d;
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProxy
    public List<EncoderProfilesProxy.AudioProfileProxy> getAudioProfiles() {
        return this.audioProfiles;
    }

    @Override // androidx.camera.video.internal.VideoValidatedEncoderProfilesProxy
    public EncoderProfilesProxy.AudioProfileProxy getDefaultAudioProfile() {
        return this.defaultAudioProfile;
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProxy
    public int getDefaultDurationSeconds() {
        return this.defaultDurationSeconds;
    }

    @Override // androidx.camera.video.internal.VideoValidatedEncoderProfilesProxy
    public EncoderProfilesProxy.VideoProfileProxy getDefaultVideoProfile() {
        return this.defaultVideoProfile;
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
        if ((r100 instanceof VideoValidatedEncoderProfilesProxy) == false) goto L27;
        VideoValidatedEncoderProfilesProxy r101 = (VideoValidatedEncoderProfilesProxy) r100;
        if (this.defaultDurationSeconds == r101.getDefaultDurationSeconds()) goto L10;
    L25:
        return false;
    L10:
        if (this.recommendedFileFormat != r101.getRecommendedFileFormat()) goto L25;
        if (this.audioProfiles.equals(r101.getAudioProfiles()) == false) goto L25;
        if (this.videoProfiles.equals(r101.getVideoProfiles()) == false) goto L25;
        EncoderProfilesProxy.AudioProfileProxy r102 = this.defaultAudioProfile;
        if (r102 != null) goto L21;
        if (r101.getDefaultAudioProfile() != null) goto L25;
    L23:
        if (this.defaultVideoProfile.equals(r101.getDefaultVideoProfile()) == false) goto L25;
        return true;
    L21:
        if (r102.equals(r101.getDefaultAudioProfile()) == false) goto L25;
    L27:
        return false;
    }

    public AutoValue_VideoValidatedEncoderProfilesProxy(int r100, int r101, List<EncoderProfilesProxy.AudioProfileProxy> r102, List<EncoderProfilesProxy.VideoProfileProxy> r103, EncoderProfilesProxy.AudioProfileProxy r104, EncoderProfilesProxy.VideoProfileProxy r105) {
        this.defaultDurationSeconds = r100;
        this.recommendedFileFormat = r101;
        if (r102 == null) goto L15;
        this.audioProfiles = r102;
        if (r103 == null) goto L13;
        this.videoProfiles = r103;
        this.defaultAudioProfile = r104;
        if (r105 == null) goto L11;
        this.defaultVideoProfile = r105;
        return;
    L11:
        throw new NullPointerException("Null defaultVideoProfile");
    L13:
        throw new NullPointerException("Null videoProfiles");
    L15:
        throw new NullPointerException("Null audioProfiles");
    }
}
