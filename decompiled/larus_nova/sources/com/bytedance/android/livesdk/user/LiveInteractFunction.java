package com.bytedance.android.livesdk.user;

import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livehostapi.foundation.IHostPlugin;

/* JADX INFO: loaded from: classes11.dex */
public final enum LiveInteractFunction extends Enum<LiveInteractFunction> {
    public static final LiveInteractFunction AT = null;
    public static final LiveInteractFunction COMMENT = null;
    public static final LiveInteractFunction COMMENT_GUIDE = null;
    public static final LiveInteractFunction GIFT = null;
    public static final LiveInteractFunction GUARD = null;
    public static final LiveInteractFunction INTERACT = null;
    public static final LiveInteractFunction LUCKYBOX = null;
    public static final LiveInteractFunction RECHARGE = null;
    public static final LiveInteractFunction RECHARGE_GUIDE = null;
    public static final LiveInteractFunction START_LIVE = null;
    public static final LiveInteractFunction TASK_GIFT = null;
    public static final LiveInteractFunction TURNTABLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveInteractFunction[] f158632a = null;
    String func;

    static {
        LiveInteractFunction r100 = new LiveInteractFunction("COMMENT", 0, "comment");
        COMMENT = r100;
        LiveInteractFunction r101 = new LiveInteractFunction("AT", 1, "AT");
        AT = r101;
        LiveInteractFunction r102 = new LiveInteractFunction("INTERACT", 2, IHostPlugin.ENTER_FROM_LINKMIC_TYPE);
        INTERACT = r102;
        LiveInteractFunction r103 = new LiveInteractFunction("GIFT", 3, PbRequest.SwitchType.GIFT);
        GIFT = r103;
        LiveInteractFunction r104 = new LiveInteractFunction("TASK_GIFT", 4, "task_gift");
        TASK_GIFT = r104;
        LiveInteractFunction r105 = new LiveInteractFunction("RECHARGE", 5, PbRequest.SwitchType.RECHARGE);
        RECHARGE = r105;
        LiveInteractFunction r110 = new LiveInteractFunction("TURNTABLE", 6, "turntable");
        TURNTABLE = r110;
        LiveInteractFunction r111 = new LiveInteractFunction("LUCKYBOX", 7, PbRequest.SwitchType.LUCKY_BOX);
        LUCKYBOX = r111;
        LiveInteractFunction r112 = new LiveInteractFunction("GUARD", 8, "guard");
        GUARD = r112;
        LiveInteractFunction r113 = new LiveInteractFunction("START_LIVE", 9, "start_live");
        START_LIVE = r113;
        LiveInteractFunction r114 = new LiveInteractFunction("COMMENT_GUIDE", 10, "comment_guide");
        COMMENT_GUIDE = r114;
        LiveInteractFunction r106 = new LiveInteractFunction("RECHARGE_GUIDE", 11, "recharge_guide");
        RECHARGE_GUIDE = r106;
        f158632a = new LiveInteractFunction[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106};
    }

    public static LiveInteractFunction[] values() {
        return (LiveInteractFunction[]) f158632a.clone();
    }

    public String getFunc() {
        return this.func;
    }

    public static LiveInteractFunction valueOf(String r100) {
        return (LiveInteractFunction) r27.a.a(LiveInteractFunction.class, r100);
    }

    public LiveInteractFunction(String r100, int r101, String r102) {
        super(r100, r101);
        this.func = r102;
    }
}
