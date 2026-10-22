package com.bytedance.android.live.initialize.state;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/initialize/state/WTOTaskStatus;", "", "IDLE", "QUEUE", "RUNNING", "FINISHED", "FAILED", "live-initialize-scheduler_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum WTOTaskStatus extends Enum<WTOTaskStatus> {
    public static final WTOTaskStatus FAILED = null;
    public static final WTOTaskStatus FINISHED = null;
    public static final WTOTaskStatus IDLE = null;
    public static final WTOTaskStatus QUEUE = null;
    public static final WTOTaskStatus RUNNING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ WTOTaskStatus[] f69443a = null;

    static {
        WTOTaskStatus r100 = new WTOTaskStatus("IDLE", 0);
        IDLE = r100;
        WTOTaskStatus r101 = new WTOTaskStatus("QUEUE", 1);
        QUEUE = r101;
        WTOTaskStatus r102 = new WTOTaskStatus("RUNNING", 2);
        RUNNING = r102;
        WTOTaskStatus r103 = new WTOTaskStatus("FINISHED", 3);
        FINISHED = r103;
        WTOTaskStatus r104 = new WTOTaskStatus("FAILED", 4);
        FAILED = r104;
        f69443a = new WTOTaskStatus[]{r100, r101, r102, r103, r104};
    }

    public static WTOTaskStatus valueOf(String r100) {
        return (WTOTaskStatus) a.a(WTOTaskStatus.class, r100);
    }

    public static WTOTaskStatus[] values() {
        return (WTOTaskStatus[]) f69443a.clone();
    }

    public WTOTaskStatus(String r100, int r101) {
        super(r100, r101);
    }
}
