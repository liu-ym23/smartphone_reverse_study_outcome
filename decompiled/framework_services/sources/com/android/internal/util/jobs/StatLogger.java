package com.android.internal.util.jobs;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.IndentingPrintWriter;
import android.util.Slog;
import android.util.proto.ProtoOutputStream;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
public class StatLogger {
    private static final String TAG = "StatLogger";
    private final int SIZE;
    private final int[] mCallsPerSecond;
    private final int[] mCountStats;
    private final long[] mDurationPerSecond;
    private final long[] mDurationStats;
    private final String[] mLabels;
    private final Object mLock;
    private final int[] mMaxCallsPerSecond;
    private final long[] mMaxDurationPerSecond;
    private final long[] mMaxDurationStats;
    private long mNextTickTime;
    private final String mStatsTag;

    public StatLogger(String[] eventLabels) {
        this(null, eventLabels);
    }

    public StatLogger(String statsTag, String[] eventLabels) {
        this.mLock = new Object();
        this.mNextTickTime = SystemClock.elapsedRealtime() + 1000;
        this.mStatsTag = statsTag;
        this.SIZE = eventLabels.length;
        this.mCountStats = new int[this.SIZE];
        this.mDurationStats = new long[this.SIZE];
        this.mCallsPerSecond = new int[this.SIZE];
        this.mMaxCallsPerSecond = new int[this.SIZE];
        this.mDurationPerSecond = new long[this.SIZE];
        this.mMaxDurationPerSecond = new long[this.SIZE];
        this.mMaxDurationStats = new long[this.SIZE];
        this.mLabels = eventLabels;
    }

    public long getTime() {
        return SystemClock.uptimeNanos() / 1000;
    }

    public long logDurationStat(int eventId, long start) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        long duration = getTime() - start;     // Catch: Throwable -> L11
        if (eventId >= 0) goto L7;
    L25:
        Slog.wtf(TAG, "Invalid event ID: " + eventId);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return duration;
    L7:
        if (eventId >= this.SIZE) goto L25;
        int[] r3 = this.mCountStats;     // Catch: Throwable -> L11
        r3[eventId] = r3[eventId] + 1;     // Catch: Throwable -> L11
        long[] r4 = this.mDurationStats;     // Catch: Throwable -> L11
        r4[eventId] = r4[eventId] + duration;     // Catch: Throwable -> L11
        if (this.mMaxDurationStats[eventId] >= duration) goto L13;
        this.mMaxDurationStats[eventId] = duration;     // Catch: Throwable -> L11
    L13:
        long nowRealtime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L11
        if (nowRealtime > this.mNextTickTime) goto L16;
    L22:
        int[] r5 = this.mCallsPerSecond;     // Catch: Throwable -> L11
        r5[eventId] = r5[eventId] + 1;     // Catch: Throwable -> L11
        long[] r6 = this.mDurationPerSecond;     // Catch: Throwable -> L11
        r6[eventId] = r6[eventId] + duration;     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return duration;
    L16:
        if (this.mMaxCallsPerSecond[eventId] >= this.mCallsPerSecond[eventId]) goto L19;
        this.mMaxCallsPerSecond[eventId] = this.mCallsPerSecond[eventId];     // Catch: Throwable -> L11
    L19:
        if (this.mMaxDurationPerSecond[eventId] >= this.mDurationPerSecond[eventId]) goto L21;
        this.mMaxDurationPerSecond[eventId] = this.mDurationPerSecond[eventId];     // Catch: Throwable -> L11
    L21:
        this.mCallsPerSecond[eventId] = 0;     // Catch: Throwable -> L11
        this.mDurationPerSecond[eventId] = 0;     // Catch: Throwable -> L11
        this.mNextTickTime = 1000 + nowRealtime;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public void dump(PrintWriter pw, String prefix) {
        dump(new IndentingPrintWriter(pw, "  ").setIndent(prefix));
    }

    public void dump(IndentingPrintWriter pw) {
        StatLogger r1 = this;
        Object r3 = r1.mLock;
        monitor-enter(r3);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (TextUtils.isEmpty(r1.mStatsTag) == true) goto L9;
        pw.println(r1.mStatsTag + ":");     // Catch: Throwable -> L7
    L10:
        pw.increaseIndent();     // Catch: Throwable -> L7
        int i = 0;
    L12:
        if (i >= r1.SIZE) goto L18;
        int count = r1.mCountStats[i];     // Catch: Throwable -> L7
        double durationMs = r1.mDurationStats[i] / 1000.0d;     // Catch: Throwable -> L7
        String r11 = r1.mLabels[i];     // Catch: Throwable -> L7
        Integer r12 = Integer.valueOf(count);     // Catch: Throwable -> L7
        Double r13 = Double.valueOf(durationMs);     // Catch: Throwable -> L7
        if (count != 0) goto L16;
        double r14 = 0.0d;
    L17:
        int i2 = i;
        pw.println(String.format("%s: count=%d, total=%.1fms, avg=%.3fms, max calls/s=%d max dur/s=%.1fms max time=%.1fms", new Object[]{r11, r12, r13, Double.valueOf(r14), Integer.valueOf(r1.mMaxCallsPerSecond[i]), Double.valueOf(r1.mMaxDurationPerSecond[i] / 1000.0d), Double.valueOf(r1.mMaxDurationStats[i2] / 1000.0d)}));     // Catch: Throwable -> L7
        i = i2 + 1;     // Catch: Throwable -> L7
        r1 = this;
        goto L12
    L16:
        r14 = durationMs / ((double) count);     // Catch: Throwable -> L7
        goto L17
    L18:
        pw.decreaseIndent();     // Catch: Throwable -> L7
        monitor-exit(r3);     // Catch: Throwable -> L7
        return;
    L9:
        pw.println("Stats:");     // Catch: Throwable -> L7
        goto L10
    }

    public void dumpProto(ProtoOutputStream proto, long fieldId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        long outer = proto.start(fieldId);     // Catch: Throwable -> L8
        int i = 0;
    L6:
        if (i >= this.mLabels.length) goto L10;
        long inner = proto.start(2246267895809L);     // Catch: Throwable -> L8
        proto.write(1120986464257L, i);     // Catch: Throwable -> L8
        proto.write(1138166333442L, this.mLabels[i]);     // Catch: Throwable -> L8
        proto.write(1120986464259L, this.mCountStats[i]);     // Catch: Throwable -> L8
        proto.write(1112396529668L, this.mDurationStats[i]);     // Catch: Throwable -> L8
        proto.write(1120986464261L, this.mMaxCallsPerSecond[i]);     // Catch: Throwable -> L8
        proto.write(1112396529670L, this.mMaxDurationPerSecond[i]);     // Catch: Throwable -> L8
        proto.write(1112396529671L, this.mMaxDurationStats[i]);     // Catch: Throwable -> L8
        proto.end(inner);     // Catch: Throwable -> L8
        i = i + 1;     // Catch: Throwable -> L8
        goto L6
    L10:
        proto.end(outer);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
