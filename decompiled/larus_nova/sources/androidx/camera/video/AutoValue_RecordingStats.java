package androidx.camera.video;

/* JADX INFO: loaded from: classes2.dex */
final class AutoValue_RecordingStats extends RecordingStats {
    private final AudioStats audioStats;
    private final long numBytesRecorded;
    private final long recordedDurationNanos;

    public int hashCode() {
        long r100 = this.recordedDurationNanos;
        int r101 = (((int) (r100 ^ (r100 >>> 32))) ^ 1000003) * 1000003;
        long r102 = this.numBytesRecorded;
        int r103 = this.audioStats.hashCode();
        return r103 ^ ((r101 ^ ((int) ((r102 >>> 32) ^ r102))) * 1000003);
    }

    public String toString() {
        return "RecordingStats{recordedDurationNanos=" + this.recordedDurationNanos + ", numBytesRecorded=" + this.numBytesRecorded + ", audioStats=" + this.audioStats + com.alipay.sdk.m.u.i.f25855d;
    }

    @Override // androidx.camera.video.RecordingStats
    public AudioStats getAudioStats() {
        return this.audioStats;
    }

    @Override // androidx.camera.video.RecordingStats
    public long getNumBytesRecorded() {
        return this.numBytesRecorded;
    }

    @Override // androidx.camera.video.RecordingStats
    public long getRecordedDurationNanos() {
        return this.recordedDurationNanos;
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof RecordingStats) == false) goto L16;
        RecordingStats r101 = (RecordingStats) r100;
        if (this.recordedDurationNanos == r101.getRecordedDurationNanos()) goto L10;
    L14:
        return false;
    L10:
        if (this.numBytesRecorded != r101.getNumBytesRecorded()) goto L14;
        if (this.audioStats.equals(r101.getAudioStats()) == false) goto L14;
        return true;
    L16:
        return false;
    }

    public AutoValue_RecordingStats(long r100, long r101, AudioStats r102) {
        this.recordedDurationNanos = r100;
        this.numBytesRecorded = r101;
        if (r102 == null) goto L7;
        this.audioStats = r102;
        return;
    L7:
        throw new NullPointerException("Null audioStats");
    }
}
