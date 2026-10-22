package com.bytedance.apm.perf.traffic;

/* JADX INFO: loaded from: classes2.dex */
public class TrafficStatisticWrapper {
    private ITrafficStatistics mTrafficStatistics;

    /* JADX INFO: renamed from: com.bytedance.apm.perf.traffic.TrafficStatisticWrapper$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class Holder {
        private static TrafficStatisticWrapper sInstance;

        private Holder() {
        }

        static /* synthetic */ TrafficStatisticWrapper access$000() {
            return sInstance;
        }

        static {
            sInstance = new TrafficStatisticWrapper(null);
        }
    }

    /* synthetic */ TrafficStatisticWrapper(AnonymousClass1 r1) {
        this();
    }

    private TrafficStatisticWrapper() {
        NewTrafficStatisticsImpl r0 = new NewTrafficStatisticsImpl();
        this.mTrafficStatistics = r0;
        r0.init();
    }

    public static TrafficStatisticWrapper getInstance() {
        return Holder.access$000();
    }

    public long getMobileBytes() {
        return this.mTrafficStatistics.getMobileBytes();
    }

    public long getWifiBytes() {
        return this.mTrafficStatistics.getWifiBytes();
    }

    public long getBackBytes() {
        return this.mTrafficStatistics.getBackBytes();
    }

    public long getBackPackets() {
        return this.mTrafficStatistics.getBackPackets();
    }

    public long getFrontBytes() {
        return this.mTrafficStatistics.getFrontBytes();
    }

    public long getFrontPackets() {
        return this.mTrafficStatistics.getFrontPackets();
    }

    public long getMobileFrontBytes() {
        return this.mTrafficStatistics.getMobileFrontBytes();
    }

    public long getMobileBackBytes() {
        return this.mTrafficStatistics.getMobileBackBytes();
    }

    public long getWifiFrontBytes() {
        return this.mTrafficStatistics.getWifiFrontBytes();
    }

    public long getWifiBackBytes() {
        return this.mTrafficStatistics.getWifiBackBytes();
    }

    public long getTotalBytes() {
        return this.mTrafficStatistics.getTotalBytes();
    }

    void onStatusChange(boolean r1) {
        this.mTrafficStatistics.onStatusChange(r1);
    }
}
