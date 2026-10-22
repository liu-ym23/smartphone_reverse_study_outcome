package androidx.camera.video.internal.audio;

/* JADX INFO: loaded from: classes2.dex */
final class AutoValue_AudioStream_PacketInfo extends AudioStream.PacketInfo {
    private final int sizeInBytes;
    private final long timestampNs;

    public int hashCode() {
        int r100 = (this.sizeInBytes ^ 1000003) * 1000003;
        long r101 = this.timestampNs;
        return r100 ^ ((int) (r101 ^ (r101 >>> 32)));
    }

    public String toString() {
        return "PacketInfo{sizeInBytes=" + this.sizeInBytes + ", timestampNs=" + this.timestampNs + com.alipay.sdk.m.u.i.f25855d;
    }

    @Override // androidx.camera.video.internal.audio.AudioStream.PacketInfo
    public int getSizeInBytes() {
        return this.sizeInBytes;
    }

    @Override // androidx.camera.video.internal.audio.AudioStream.PacketInfo
    public long getTimestampNs() {
        return this.timestampNs;
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof AudioStream.PacketInfo) == false) goto L14;
        AudioStream.PacketInfo r101 = (AudioStream.PacketInfo) r100;
        if (this.sizeInBytes == r101.getSizeInBytes()) goto L10;
    L12:
        return false;
    L10:
        if (this.timestampNs != r101.getTimestampNs()) goto L12;
        return true;
    L14:
        return false;
    }

    public AutoValue_AudioStream_PacketInfo(int r100, long r101) {
        this.sizeInBytes = r100;
        this.timestampNs = r101;
    }
}
