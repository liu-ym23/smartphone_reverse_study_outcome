package com.bytedance.android.live.broadcast.api.anchorbizpanel;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/anchorbizpanel/OperateType;", "", "ENTER", "EXIT", "livebroadcast-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum OperateType extends Enum<OperateType> {
    public static final OperateType ENTER = null;
    public static final OperateType EXIT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OperateType[] f58971a = null;

    static {
        OperateType r100 = new OperateType("ENTER", 0);
        ENTER = r100;
        OperateType r101 = new OperateType("EXIT", 1);
        EXIT = r101;
        f58971a = new OperateType[]{r100, r101};
    }

    public static OperateType valueOf(String r100) {
        return (OperateType) a.a(OperateType.class, r100);
    }

    public static OperateType[] values() {
        return (OperateType[]) f58971a.clone();
    }

    public OperateType(String r100, int r101) {
        super(r100, r101);
    }
}
