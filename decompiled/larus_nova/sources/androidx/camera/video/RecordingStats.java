package androidx.camera.video;

import androidx.core.util.Preconditions;

/* JADX INFO: loaded from: classes2.dex */
public abstract class RecordingStats {
    public abstract AudioStats getAudioStats();

    public abstract long getNumBytesRecorded();

    public abstract long getRecordedDurationNanos();

    public RecordingStats() {
    }

    public static RecordingStats of(long r100, long r110, AudioStats r111) {
        boolean r101 = true;
        if (r100 < 0) goto L5;
        boolean r102 = true;
    L6:
        Preconditions.checkArgument(r102, "duration must be positive value.");
        if (r110 >= 0) goto L10;
        r101 = false;
    L10:
        Preconditions.checkArgument(r101, "bytes must be positive value.");
        return new AutoValue_RecordingStats(r100, r110, r111);
    L5:
        r102 = false;
        goto L6
    }
}
