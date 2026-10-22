package androidx.camera.core.impl;

/* JADX INFO: loaded from: classes2.dex */
final class AutoValue_EncoderProfilesProxy_VideoProfileProxy extends EncoderProfilesProxy.VideoProfileProxy {
    private final int bitDepth;
    private final int bitrate;
    private final int chromaSubsampling;
    private final int codec;
    private final int frameRate;
    private final int hdrFormat;
    private final int height;
    private final String mediaType;
    private final int profile;
    private final int width;

    public int hashCode() {
        return ((((((((((((((((((this.codec ^ 1000003) * 1000003) ^ this.mediaType.hashCode()) * 1000003) ^ this.bitrate) * 1000003) ^ this.frameRate) * 1000003) ^ this.width) * 1000003) ^ this.height) * 1000003) ^ this.profile) * 1000003) ^ this.bitDepth) * 1000003) ^ this.chromaSubsampling) * 1000003) ^ this.hdrFormat;
    }

    public String toString() {
        return "VideoProfileProxy{codec=" + this.codec + ", mediaType=" + this.mediaType + ", bitrate=" + this.bitrate + ", frameRate=" + this.frameRate + ", width=" + this.width + ", height=" + this.height + ", profile=" + this.profile + ", bitDepth=" + this.bitDepth + ", chromaSubsampling=" + this.chromaSubsampling + ", hdrFormat=" + this.hdrFormat + com.alipay.sdk.m.u.i.f25855d;
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProxy.VideoProfileProxy
    public int getBitDepth() {
        return this.bitDepth;
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProxy.VideoProfileProxy
    public int getBitrate() {
        return this.bitrate;
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProxy.VideoProfileProxy
    public int getChromaSubsampling() {
        return this.chromaSubsampling;
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProxy.VideoProfileProxy
    public int getCodec() {
        return this.codec;
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProxy.VideoProfileProxy
    public int getFrameRate() {
        return this.frameRate;
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProxy.VideoProfileProxy
    public int getHdrFormat() {
        return this.hdrFormat;
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProxy.VideoProfileProxy
    public int getHeight() {
        return this.height;
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProxy.VideoProfileProxy
    public String getMediaType() {
        return this.mediaType;
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProxy.VideoProfileProxy
    public int getProfile() {
        return this.profile;
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProxy.VideoProfileProxy
    public int getWidth() {
        return this.width;
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof EncoderProfilesProxy.VideoProfileProxy) == false) goto L30;
        EncoderProfilesProxy.VideoProfileProxy r101 = (EncoderProfilesProxy.VideoProfileProxy) r100;
        if (this.codec == r101.getCodec()) goto L10;
    L28:
        return false;
    L10:
        if (this.mediaType.equals(r101.getMediaType()) == false) goto L28;
        if (this.bitrate != r101.getBitrate()) goto L28;
        if (this.frameRate != r101.getFrameRate()) goto L28;
        if (this.width != r101.getWidth()) goto L28;
        if (this.height != r101.getHeight()) goto L28;
        if (this.profile != r101.getProfile()) goto L28;
        if (this.bitDepth != r101.getBitDepth()) goto L28;
        if (this.chromaSubsampling != r101.getChromaSubsampling()) goto L28;
        if (this.hdrFormat != r101.getHdrFormat()) goto L28;
        return true;
    L30:
        return false;
    }

    public AutoValue_EncoderProfilesProxy_VideoProfileProxy(int r100, String r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108, int r110) {
        this.codec = r100;
        if (r101 == null) goto L7;
        this.mediaType = r101;
        this.bitrate = r102;
        this.frameRate = r103;
        this.width = r104;
        this.height = r105;
        this.profile = r106;
        this.bitDepth = r107;
        this.chromaSubsampling = r108;
        this.hdrFormat = r110;
        return;
    L7:
        throw new NullPointerException("Null mediaType");
    }
}
