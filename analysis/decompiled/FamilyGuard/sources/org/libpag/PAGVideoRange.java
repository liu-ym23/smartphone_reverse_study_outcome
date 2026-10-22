package org.libpag;

/* loaded from: classes.dex */
public class PAGVideoRange {
    public long endTime;
    public long playDuration;
    public boolean reversed;
    public long startTime;

    public PAGVideoRange(long j5, long j6, long j7, boolean z5) {
        this.startTime = j5;
        this.endTime = j6;
        this.playDuration = j7;
        this.reversed = z5;
    }
}
