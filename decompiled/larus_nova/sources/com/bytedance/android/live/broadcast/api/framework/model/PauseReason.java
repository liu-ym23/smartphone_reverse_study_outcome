package com.bytedance.android.live.broadcast.api.framework.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u0000\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/framework/model/PauseReason;", "", "", "USER_INITIATED", "BACKGROUND", "SCREEN_OFF", "BUSINESS", "OVERLAY", "OVERLAY_BY_MONITOR", "FLOAT_WINDOW_ERROR", "ERROR", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PauseReason extends Enum<PauseReason> {
    public static final PauseReason BACKGROUND = null;
    public static final PauseReason BUSINESS = null;
    public static final PauseReason ERROR = null;
    public static final PauseReason FLOAT_WINDOW_ERROR = null;
    public static final PauseReason OVERLAY = null;
    public static final PauseReason OVERLAY_BY_MONITOR = null;
    public static final PauseReason SCREEN_OFF = null;
    public static final PauseReason USER_INITIATED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PauseReason[] f58997a = null;

    static {
        PauseReason r100 = new PauseReason("USER_INITIATED", 0);
        USER_INITIATED = r100;
        PauseReason r101 = new PauseReason("BACKGROUND", 1);
        BACKGROUND = r101;
        PauseReason r102 = new PauseReason("SCREEN_OFF", 2);
        SCREEN_OFF = r102;
        PauseReason r103 = new PauseReason("BUSINESS", 3);
        BUSINESS = r103;
        PauseReason r104 = new PauseReason("OVERLAY", 4);
        OVERLAY = r104;
        PauseReason r105 = new PauseReason("OVERLAY_BY_MONITOR", 5);
        OVERLAY_BY_MONITOR = r105;
        PauseReason r106 = new PauseReason("FLOAT_WINDOW_ERROR", 6);
        FLOAT_WINDOW_ERROR = r106;
        PauseReason r107 = new PauseReason("ERROR", 7);
        ERROR = r107;
        f58997a = new PauseReason[]{r100, r101, r102, r103, r104, r105, r106, r107};
    }

    public static PauseReason valueOf(String r100) {
        return (PauseReason) a.a(PauseReason.class, r100);
    }

    public static PauseReason[] values() {
        return (PauseReason[]) f58997a.clone();
    }

    public PauseReason(String r100, int r101) {
        super(r100, r101);
    }
}
