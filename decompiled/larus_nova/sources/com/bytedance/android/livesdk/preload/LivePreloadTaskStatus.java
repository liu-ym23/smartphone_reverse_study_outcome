package com.bytedance.android.livesdk.preload;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/preload/LivePreloadTaskStatus;", "", "NEW", "IN_EXECUTOR", "EXECUTING", "SUCCEED", "FAILED", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LivePreloadTaskStatus extends Enum<LivePreloadTaskStatus> {
    public static final LivePreloadTaskStatus EXECUTING = null;
    public static final LivePreloadTaskStatus FAILED = null;
    public static final LivePreloadTaskStatus IN_EXECUTOR = null;
    public static final LivePreloadTaskStatus NEW = null;
    public static final LivePreloadTaskStatus SUCCEED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LivePreloadTaskStatus[] f156316a = null;

    static {
        LivePreloadTaskStatus r100 = new LivePreloadTaskStatus("NEW", 0);
        NEW = r100;
        LivePreloadTaskStatus r101 = new LivePreloadTaskStatus("IN_EXECUTOR", 1);
        IN_EXECUTOR = r101;
        LivePreloadTaskStatus r102 = new LivePreloadTaskStatus("EXECUTING", 2);
        EXECUTING = r102;
        LivePreloadTaskStatus r103 = new LivePreloadTaskStatus("SUCCEED", 3);
        SUCCEED = r103;
        LivePreloadTaskStatus r104 = new LivePreloadTaskStatus("FAILED", 4);
        FAILED = r104;
        f156316a = new LivePreloadTaskStatus[]{r100, r101, r102, r103, r104};
    }

    public static LivePreloadTaskStatus valueOf(String r100) {
        return (LivePreloadTaskStatus) a.a(LivePreloadTaskStatus.class, r100);
    }

    public static LivePreloadTaskStatus[] values() {
        return (LivePreloadTaskStatus[]) f156316a.clone();
    }

    public LivePreloadTaskStatus(String r100, int r101) {
        super(r100, r101);
    }
}
