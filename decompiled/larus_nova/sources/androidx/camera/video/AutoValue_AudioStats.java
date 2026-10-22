package androidx.camera.video;

/* JADX INFO: loaded from: classes2.dex */
final class AutoValue_AudioStats extends AudioStats {
    private final double audioAmplitudeInternal;
    private final int audioState;
    private final Throwable errorCause;

    public int hashCode() {
        int r100 = (((this.audioState ^ 1000003) * 1000003) ^ ((int) ((Double.doubleToLongBits(this.audioAmplitudeInternal) >>> 32) ^ Double.doubleToLongBits(this.audioAmplitudeInternal)))) * 1000003;
        Throwable r101 = this.errorCause;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 ^ r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public String toString() {
        return "AudioStats{audioState=" + this.audioState + ", audioAmplitudeInternal=" + this.audioAmplitudeInternal + ", errorCause=" + this.errorCause + com.alipay.sdk.m.u.i.f25855d;
    }

    @Override // androidx.camera.video.AudioStats
    public double getAudioAmplitudeInternal() {
        return this.audioAmplitudeInternal;
    }

    @Override // androidx.camera.video.AudioStats
    public int getAudioState() {
        return this.audioState;
    }

    @Override // androidx.camera.video.AudioStats
    public Throwable getErrorCause() {
        return this.errorCause;
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof AudioStats) == false) goto L21;
        AudioStats r101 = (AudioStats) r100;
        if (this.audioState == r101.getAudioState()) goto L10;
    L19:
        return false;
    L10:
        if (Double.doubleToLongBits(this.audioAmplitudeInternal) != Double.doubleToLongBits(r101.getAudioAmplitudeInternal())) goto L19;
        Throwable r102 = this.errorCause;
        if (r102 != null) goto L17;
        if (r101.getErrorCause() != null) goto L19;
        return true;
    L17:
        if (r102.equals(r101.getErrorCause()) == false) goto L19;
        return true;
    L21:
        return false;
    }

    public AutoValue_AudioStats(int r100, double r101, Throwable r102) {
        this.audioState = r100;
        this.audioAmplitudeInternal = r101;
        this.errorCause = r102;
    }
}
