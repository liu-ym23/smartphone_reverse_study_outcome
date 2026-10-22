package androidx.camera.core.impl;

/* JADX INFO: loaded from: classes2.dex */
final class AutoValue_EncoderProfilesProxy_AudioProfileProxy extends EncoderProfilesProxy.AudioProfileProxy {
    private final int bitrate;
    private final int channels;
    private final int codec;
    private final String mediaType;
    private final int profile;
    private final int sampleRate;

    public int hashCode() {
        return ((((((((((this.codec ^ 1000003) * 1000003) ^ this.mediaType.hashCode()) * 1000003) ^ this.bitrate) * 1000003) ^ this.sampleRate) * 1000003) ^ this.channels) * 1000003) ^ this.profile;
    }

    public String toString() {
        return "AudioProfileProxy{codec=" + this.codec + ", mediaType=" + this.mediaType + ", bitrate=" + this.bitrate + ", sampleRate=" + this.sampleRate + ", channels=" + this.channels + ", profile=" + this.profile + com.alipay.sdk.m.u.i.f25855d;
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProxy.AudioProfileProxy
    public int getBitrate() {
        return this.bitrate;
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProxy.AudioProfileProxy
    public int getChannels() {
        return this.channels;
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProxy.AudioProfileProxy
    public int getCodec() {
        return this.codec;
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProxy.AudioProfileProxy
    public String getMediaType() {
        return this.mediaType;
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProxy.AudioProfileProxy
    public int getProfile() {
        return this.profile;
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProxy.AudioProfileProxy
    public int getSampleRate() {
        return this.sampleRate;
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof EncoderProfilesProxy.AudioProfileProxy) == false) goto L22;
        EncoderProfilesProxy.AudioProfileProxy r101 = (EncoderProfilesProxy.AudioProfileProxy) r100;
        if (this.codec == r101.getCodec()) goto L10;
    L20:
        return false;
    L10:
        if (this.mediaType.equals(r101.getMediaType()) == false) goto L20;
        if (this.bitrate != r101.getBitrate()) goto L20;
        if (this.sampleRate != r101.getSampleRate()) goto L20;
        if (this.channels != r101.getChannels()) goto L20;
        if (this.profile != r101.getProfile()) goto L20;
        return true;
    L22:
        return false;
    }

    public AutoValue_EncoderProfilesProxy_AudioProfileProxy(int r100, String r101, int r102, int r103, int r104, int r105) {
        this.codec = r100;
        if (r101 == null) goto L7;
        this.mediaType = r101;
        this.bitrate = r102;
        this.sampleRate = r103;
        this.channels = r104;
        this.profile = r105;
        return;
    L7:
        throw new NullPointerException("Null mediaType");
    }
}
