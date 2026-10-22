package com.android.server.backup.transport;

import android.content.ComponentName;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;

/* JADX INFO: loaded from: classes.dex */
public class TransportStats {
    private final Object mStatsLock;
    private final Map<ComponentName, Stats> mTransportStats;

    public static final class Stats {
        public double average;
        public long max;
        public long min;
        public int n;

        /* JADX INFO: renamed from: -$$Nest$mregister, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m2548$$Nest$mregister(Stats r0, long r1) {
            r0.register(r1);
        }

        /* synthetic */ Stats(Stats r1, TransportStatsIA r2) {
            this(r1);
        }

        public static Stats merge(Stats a, Stats b) {
            return new Stats(a.n + b.n, ((a.average * ((double) a.n)) + (b.average * ((double) b.n))) / ((double) (a.n + b.n)), Math.max(a.max, b.max), Math.min(a.min, b.min));
        }

        public Stats() {
            this.n = 0;
            this.average = 0.0d;
            this.max = 0;
            this.min = Long.MAX_VALUE;
        }

        private Stats(int n, double average, long max, long min) {
            this.n = n;
            this.average = average;
            this.max = max;
            this.min = min;
        }

        private Stats(Stats original) {
            this(original.n, original.average, original.max, original.min);
        }

        private void register(long sample) {
            this.average = ((this.average * ((double) this.n)) + sample) / ((double) (this.n + 1));
            this.n++;
            this.max = Math.max(this.max, sample);
            this.min = Math.min(this.min, sample);
        }
    }

    public TransportStats() {
        this.mStatsLock = new Object();
        this.mTransportStats = new HashMap();
    }

    void registerConnectionTime(ComponentName transportComponent, long timeMs) {
        Object r0 = this.mStatsLock;
        monitor-enter(r0);
        Stats stats = this.mTransportStats.get(transportComponent);     // Catch: Throwable -> L7
        if (stats != null) goto L9;
        stats = new Stats();     // Catch: Throwable -> L7
        this.mTransportStats.put(transportComponent, stats);     // Catch: Throwable -> L7
    L9:
        Stats.m2548$$Nest$mregister(stats, timeMs);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public Stats getStatsForTransport(ComponentName transportComponent) {
        Object r0 = this.mStatsLock;
        monitor-enter(r0);
        Stats stats = this.mTransportStats.get(transportComponent);     // Catch: Throwable -> L8
        TransportStatsIA r2 = null;
        if (stats != null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return null;
    L10:
        Stats r3 = new Stats(stats, r2);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return r3;
    L8:
        th = move-exception;
        throw th;
    }

    public void dump(PrintWriter pw) {
        Object r0 = this.mStatsLock;
        monitor-enter(r0);
        Optional<Stats> aggregatedStats = this.mTransportStats.values().stream().reduce(new TransportStats$$ExternalSyntheticLambda0());     // Catch: Throwable -> L7
        if (aggregatedStats.isPresent() == false) goto L10;
        dumpStats(pw, "", aggregatedStats.get());     // Catch: Throwable -> L7
    L10:
        if (this.mTransportStats.isEmpty() == true) goto L15;
        pw.println("Per transport:");     // Catch: Throwable -> L7
        Iterator<ComponentName> r2 = this.mTransportStats.keySet().iterator();     // Catch: Throwable -> L7
    L13:
        if (r2.hasNext() == false) goto L15;
        ComponentName transportComponent = r2.next();     // Catch: Throwable -> L7
        Stats stats = this.mTransportStats.get(transportComponent);     // Catch: Throwable -> L7
        pw.println("    " + transportComponent.flattenToShortString());     // Catch: Throwable -> L7
        dumpStats(pw, "        ", stats);     // Catch: Throwable -> L7
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static void dumpStats(PrintWriter pw, String prefix, Stats stats) {
        pw.println(String.format(Locale.US, "%sAverage connection time: %.2f ms", new Object[]{prefix, Double.valueOf(stats.average)}));
        pw.println(String.format(Locale.US, "%sMax connection time: %d ms", new Object[]{prefix, Long.valueOf(stats.max)}));
        pw.println(String.format(Locale.US, "%sMin connection time: %d ms", new Object[]{prefix, Long.valueOf(stats.min)}));
        pw.println(String.format(Locale.US, "%sNumber of connections: %d ", new Object[]{prefix, Integer.valueOf(stats.n)}));
    }
}
