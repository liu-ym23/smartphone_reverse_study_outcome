package com.bytedance.android.live.core.network;

import r27.a;

/* JADX INFO: loaded from: classes45.dex */
public class NetworkStat {
    public static final NetworkStat LOADED = null;
    public static final NetworkStat LOADING = null;
    public Status mStatus;
    public Throwable throwable;

    public static final enum Status extends Enum<Status> {
        public static final Status FAILED = null;
        public static final Status RUNNING = null;
        public static final Status SUCCESS = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Status[] f65023a = null;
        public final int mStatus;

        static {
            Status r100 = new Status("RUNNING", 0, 0);
            RUNNING = r100;
            Status r101 = new Status("SUCCESS", 1, 1);
            SUCCESS = r101;
            Status r102 = new Status("FAILED", 2, -1);
            FAILED = r102;
            f65023a = new Status[]{r100, r101, r102};
        }

        public static Status[] values() {
            return (Status[]) f65023a.clone();
        }

        public static Status valueOf(String r100) {
            return (Status) a.a(Status.class, r100);
        }

        public Status(String r100, int r101, int r102) {
            super(r100, r101);
            this.mStatus = r102;
        }
    }

    static {
        LOADING = new NetworkStat(Status.RUNNING, null);
        LOADED = new NetworkStat(Status.SUCCESS, null);
    }

    public boolean isFailed() {
        if (this.mStatus != Status.FAILED) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isLoading() {
        if (this.mStatus != Status.RUNNING) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isSuccess() {
        if (this.mStatus != Status.SUCCESS) goto L5;
        return true;
    L5:
        return false;
    }

    public static NetworkStat error(Throwable r100) {
        return new NetworkStat(Status.FAILED, r100);
    }

    private NetworkStat(Status r100, Throwable r101) {
        this.mStatus = r100;
        this.throwable = r101;
    }
}
