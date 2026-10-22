package com.bytedance.android.live.room.discovery.drawer.processor;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/room/discovery/drawer/processor/LiveEntranceStatus;", "", "NOT_DISPLAYED", "DISPLAYING", "DISPLAY_COMPLETED", "DISPLAY_ERROR", "DISPLAY_POST_INTERCEPT", "experience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveEntranceStatus extends Enum<LiveEntranceStatus> {
    public static final LiveEntranceStatus DISPLAYING = null;
    public static final LiveEntranceStatus DISPLAY_COMPLETED = null;
    public static final LiveEntranceStatus DISPLAY_ERROR = null;
    public static final LiveEntranceStatus DISPLAY_POST_INTERCEPT = null;
    public static final LiveEntranceStatus NOT_DISPLAYED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveEntranceStatus[] f99433a = null;

    static {
        LiveEntranceStatus r100 = new LiveEntranceStatus("NOT_DISPLAYED", 0);
        NOT_DISPLAYED = r100;
        LiveEntranceStatus r101 = new LiveEntranceStatus("DISPLAYING", 1);
        DISPLAYING = r101;
        LiveEntranceStatus r102 = new LiveEntranceStatus("DISPLAY_COMPLETED", 2);
        DISPLAY_COMPLETED = r102;
        LiveEntranceStatus r103 = new LiveEntranceStatus("DISPLAY_ERROR", 3);
        DISPLAY_ERROR = r103;
        LiveEntranceStatus r104 = new LiveEntranceStatus("DISPLAY_POST_INTERCEPT", 4);
        DISPLAY_POST_INTERCEPT = r104;
        f99433a = new LiveEntranceStatus[]{r100, r101, r102, r103, r104};
    }

    public static LiveEntranceStatus valueOf(String r100) {
        return (LiveEntranceStatus) r27.a.a(LiveEntranceStatus.class, r100);
    }

    public static LiveEntranceStatus[] values() {
        return (LiveEntranceStatus[]) f99433a.clone();
    }

    public LiveEntranceStatus(String r100, int r101) {
        super(r100, r101);
    }
}
