package com.bytedance.android.gamecp.common.network.core.network;

import r27.a;

/* JADX INFO: loaded from: classes44.dex */
public final enum NetworkStat$Status extends Enum<NetworkStat$Status> {
    public static final NetworkStat$Status FAILED = null;
    public static final NetworkStat$Status RUNNING = null;
    public static final NetworkStat$Status SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ NetworkStat$Status[] f56689a = null;
    public final int mStatus;

    static {
        NetworkStat$Status r100 = new NetworkStat$Status("RUNNING", 0, 0);
        RUNNING = r100;
        NetworkStat$Status r101 = new NetworkStat$Status("SUCCESS", 1, 1);
        SUCCESS = r101;
        NetworkStat$Status r102 = new NetworkStat$Status("FAILED", 2, -1);
        FAILED = r102;
        f56689a = new NetworkStat$Status[]{r100, r101, r102};
    }

    public static NetworkStat$Status[] values() {
        return (NetworkStat$Status[]) f56689a.clone();
    }

    public static NetworkStat$Status valueOf(String r100) {
        return (NetworkStat$Status) a.a(NetworkStat$Status.class, r100);
    }

    public NetworkStat$Status(String r100, int r101, int r102) {
        super(r100, r101);
        this.mStatus = r102;
    }
}
