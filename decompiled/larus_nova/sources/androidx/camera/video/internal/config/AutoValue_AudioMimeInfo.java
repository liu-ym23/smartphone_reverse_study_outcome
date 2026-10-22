package androidx.camera.video.internal.config;

import androidx.camera.core.impl.EncoderProfilesProxy;
import com.alipay.sdk.m.u.i;

/* JADX INFO: loaded from: classes2.dex */
final class AutoValue_AudioMimeInfo extends AudioMimeInfo {
    private final EncoderProfilesProxy.AudioProfileProxy compatibleAudioProfile;
    private final String mimeType;
    private final int profile;

    /* JADX INFO: renamed from: androidx.camera.video.internal.config.AutoValue_AudioMimeInfo$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder extends AudioMimeInfo.Builder {
        private EncoderProfilesProxy.AudioProfileProxy compatibleAudioProfile;
        private String mimeType;
        private Integer profile;

        @Override // androidx.camera.video.internal.config.AudioMimeInfo.Builder, androidx.camera.video.internal.config.MimeInfo.Builder
        public AudioMimeInfo build() {
            if (this.mimeType != null) goto L5;
            String r100 = " mimeType";
        L7:
            if (this.profile != null) goto L10;
            r100 = r100 + " profile";
        L10:
            if (r100.isEmpty() == false) goto L14;
            return new AutoValue_AudioMimeInfo(this.mimeType, this.profile.intValue(), this.compatibleAudioProfile, null);
        L14:
            throw new IllegalStateException("Missing required properties:".concat(r100));
        L5:
            r100 = "";
            goto L7
        }

        public Builder() {
        }

        @Override // androidx.camera.video.internal.config.AudioMimeInfo.Builder, androidx.camera.video.internal.config.MimeInfo.Builder
        public /* bridge */ /* synthetic */ MimeInfo build() {
            return build();
        }

        @Override // androidx.camera.video.internal.config.AudioMimeInfo.Builder
        public AudioMimeInfo.Builder setCompatibleAudioProfile(EncoderProfilesProxy.AudioProfileProxy r100) {
            this.compatibleAudioProfile = r100;
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.video.internal.config.MimeInfo.Builder
        public AudioMimeInfo.Builder setMimeType(String r100) {
            if (r100 == null) goto L6;
            this.mimeType = r100;
            return this;
        L6:
            throw new NullPointerException("Null mimeType");
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.video.internal.config.MimeInfo.Builder
        public AudioMimeInfo.Builder setProfile(int r100) {
            this.profile = Integer.valueOf(r100);
            return this;
        }

        @Override // androidx.camera.video.internal.config.MimeInfo.Builder
        public /* bridge */ /* synthetic */ AudioMimeInfo.Builder setMimeType(String r100) {
            return setMimeType(r100);
        }

        @Override // androidx.camera.video.internal.config.MimeInfo.Builder
        public /* bridge */ /* synthetic */ AudioMimeInfo.Builder setProfile(int r100) {
            return setProfile(r100);
        }
    }

    public int hashCode() {
        int r100 = (((this.mimeType.hashCode() ^ 1000003) * 1000003) ^ this.profile) * 1000003;
        EncoderProfilesProxy.AudioProfileProxy r101 = this.compatibleAudioProfile;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 ^ r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public String toString() {
        return "AudioMimeInfo{mimeType=" + this.mimeType + ", profile=" + this.profile + ", compatibleAudioProfile=" + this.compatibleAudioProfile + i.f25855d;
    }

    @Override // androidx.camera.video.internal.config.AudioMimeInfo
    public EncoderProfilesProxy.AudioProfileProxy getCompatibleAudioProfile() {
        return this.compatibleAudioProfile;
    }

    @Override // androidx.camera.video.internal.config.MimeInfo
    public String getMimeType() {
        return this.mimeType;
    }

    @Override // androidx.camera.video.internal.config.MimeInfo
    public int getProfile() {
        return this.profile;
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof AudioMimeInfo) == false) goto L21;
        AudioMimeInfo r101 = (AudioMimeInfo) r100;
        if (this.mimeType.equals(r101.getMimeType()) == true) goto L10;
    L19:
        return false;
    L10:
        if (this.profile != r101.getProfile()) goto L19;
        EncoderProfilesProxy.AudioProfileProxy r102 = this.compatibleAudioProfile;
        if (r102 != null) goto L17;
        if (r101.getCompatibleAudioProfile() != null) goto L19;
        return true;
    L17:
        if (r102.equals(r101.getCompatibleAudioProfile()) == false) goto L19;
        return true;
    L21:
        return false;
    }

    private AutoValue_AudioMimeInfo(String r100, int r101, EncoderProfilesProxy.AudioProfileProxy r102) {
        this.mimeType = r100;
        this.profile = r101;
        this.compatibleAudioProfile = r102;
    }

    public /* synthetic */ AutoValue_AudioMimeInfo(String r100, int r101, EncoderProfilesProxy.AudioProfileProxy r102, AnonymousClass1 r103) {
        this(r100, r101, r102);
    }
}
