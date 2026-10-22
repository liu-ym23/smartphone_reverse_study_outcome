package com.bytedance.android.live.broadcast.api.framework.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/framework/model/StopReason;", "", "", "USER_INITIATED", "TIME_OUT", "ERROR", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum StopReason extends Enum<StopReason> {
    public static final StopReason ERROR = null;
    public static final StopReason TIME_OUT = null;
    public static final StopReason USER_INITIATED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ StopReason[] f59000a = null;

    static {
        StopReason r100 = new StopReason("USER_INITIATED", 0);
        USER_INITIATED = r100;
        StopReason r101 = new StopReason("TIME_OUT", 1);
        TIME_OUT = r101;
        StopReason r102 = new StopReason("ERROR", 2);
        ERROR = r102;
        f59000a = new StopReason[]{r100, r101, r102};
    }

    public static StopReason valueOf(String r100) {
        return (StopReason) a.a(StopReason.class, r100);
    }

    public static StopReason[] values() {
        return (StopReason[]) f59000a.clone();
    }

    public StopReason(String r100, int r101) {
        super(r100, r101);
    }
}
