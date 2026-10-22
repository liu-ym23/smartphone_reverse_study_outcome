package androidx.camera.video.internal.config;

import androidx.camera.core.impl.EncoderProfilesProxy;
import com.alipay.sdk.m.u.i;

/* JADX INFO: loaded from: classes2.dex */
final class AutoValue_VideoMimeInfo extends VideoMimeInfo {
    private final EncoderProfilesProxy.VideoProfileProxy compatibleVideoProfile;
    private final String mimeType;
    private final int profile;

    /* JADX INFO: renamed from: androidx.camera.video.internal.config.AutoValue_VideoMimeInfo$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder extends VideoMimeInfo.Builder {
        private EncoderProfilesProxy.VideoProfileProxy compatibleVideoProfile;
        private String mimeType;
        private Integer profile;

        @Override // androidx.camera.video.internal.config.VideoMimeInfo.Builder, androidx.camera.video.internal.config.MimeInfo.Builder
        public VideoMimeInfo build() {
            if (this.mimeType != null) goto L5;
            String r100 = " mimeType";
        L7:
            if (this.profile != null) goto L10;
            r100 = r100 + " profile";
        L10:
            if (r100.isEmpty() == false) goto L14;
            return new AutoValue_VideoMimeInfo(this.mimeType, this.profile.intValue(), this.compatibleVideoProfile, null);
        L14:
            throw new IllegalStateException("Missing required properties:".concat(r100));
        L5:
            r100 = "";
            goto L7
        }

        public Builder() {
        }

        @Override // androidx.camera.video.internal.config.VideoMimeInfo.Builder, androidx.camera.video.internal.config.MimeInfo.Builder
        public /* bridge */ /* synthetic */ MimeInfo build() {
            return build();
        }

        @Override // androidx.camera.video.internal.config.VideoMimeInfo.Builder
        public VideoMimeInfo.Builder setCompatibleVideoProfile(EncoderProfilesProxy.VideoProfileProxy r100) {
            this.compatibleVideoProfile = r100;
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.video.internal.config.MimeInfo.Builder
        public VideoMimeInfo.Builder setMimeType(String r100) {
            if (r100 == null) goto L6;
            this.mimeType = r100;
            return this;
        L6:
            throw new NullPointerException("Null mimeType");
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.video.internal.config.MimeInfo.Builder
        public VideoMimeInfo.Builder setProfile(int r100) {
            this.profile = Integer.valueOf(r100);
            return this;
        }

        @Override // androidx.camera.video.internal.config.MimeInfo.Builder
        public /* bridge */ /* synthetic */ VideoMimeInfo.Builder setMimeType(String r100) {
            return setMimeType(r100);
        }

        @Override // androidx.camera.video.internal.config.MimeInfo.Builder
        public /* bridge */ /* synthetic */ VideoMimeInfo.Builder setProfile(int r100) {
            return setProfile(r100);
        }
    }

    public int hashCode() {
        int r100 = (((this.mimeType.hashCode() ^ 1000003) * 1000003) ^ this.profile) * 1000003;
        EncoderProfilesProxy.VideoProfileProxy r101 = this.compatibleVideoProfile;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 ^ r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public String toString() {
        return "VideoMimeInfo{mimeType=" + this.mimeType + ", profile=" + this.profile + ", compatibleVideoProfile=" + this.compatibleVideoProfile + i.f25855d;
    }

    @Override // androidx.camera.video.internal.config.VideoMimeInfo
    public EncoderProfilesProxy.VideoProfileProxy getCompatibleVideoProfile() {
        return this.compatibleVideoProfile;
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
        if ((r100 instanceof VideoMimeInfo) == false) goto L21;
        VideoMimeInfo r101 = (VideoMimeInfo) r100;
        if (this.mimeType.equals(r101.getMimeType()) == true) goto L10;
    L19:
        return false;
    L10:
        if (this.profile != r101.getProfile()) goto L19;
        EncoderProfilesProxy.VideoProfileProxy r102 = this.compatibleVideoProfile;
        if (r102 != null) goto L17;
        if (r101.getCompatibleVideoProfile() != null) goto L19;
        return true;
    L17:
        if (r102.equals(r101.getCompatibleVideoProfile()) == false) goto L19;
        return true;
    L21:
        return false;
    }

    private AutoValue_VideoMimeInfo(String r100, int r101, EncoderProfilesProxy.VideoProfileProxy r102) {
        this.mimeType = r100;
        this.profile = r101;
        this.compatibleVideoProfile = r102;
    }

    public /* synthetic */ AutoValue_VideoMimeInfo(String r100, int r101, EncoderProfilesProxy.VideoProfileProxy r102, AnonymousClass1 r103) {
        this(r100, r101, r102);
    }
}
