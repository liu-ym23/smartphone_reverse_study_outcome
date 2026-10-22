package com.bytedance.android.live.profit.redpacket.model;

import com.bytedance.tools.kcp.aio.runtime.RpcEnum;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@RpcEnum(messageName = "webcast.revenue.biz.luckyBox.LuckyBoxStatus")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/profit/redpacket/model/LuckyBoxStatus;", "", "LuckyBoxStatusUnknow", "LuckyBoxStatusCountDown", "LuckyBoxStatusReady", "LuckyBoxStatusBlock", "LuckyBoxStatusGamedraw", "LuckyBoxStatusExpired", "LuckyBoxStatusEnd", "live-redpacket-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum LuckyBoxStatus extends Enum<LuckyBoxStatus> {
    public static final LuckyBoxStatus LuckyBoxStatusBlock = null;
    public static final LuckyBoxStatus LuckyBoxStatusCountDown = null;
    public static final LuckyBoxStatus LuckyBoxStatusEnd = null;
    public static final LuckyBoxStatus LuckyBoxStatusExpired = null;
    public static final LuckyBoxStatus LuckyBoxStatusGamedraw = null;
    public static final LuckyBoxStatus LuckyBoxStatusReady = null;
    public static final LuckyBoxStatus LuckyBoxStatusUnknow = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LuckyBoxStatus[] f88660a = null;

    static {
        LuckyBoxStatus r100 = new LuckyBoxStatus("LuckyBoxStatusUnknow", 0);
        LuckyBoxStatusUnknow = r100;
        LuckyBoxStatus r101 = new LuckyBoxStatus("LuckyBoxStatusCountDown", 1);
        LuckyBoxStatusCountDown = r101;
        LuckyBoxStatus r102 = new LuckyBoxStatus("LuckyBoxStatusReady", 2);
        LuckyBoxStatusReady = r102;
        LuckyBoxStatus r103 = new LuckyBoxStatus("LuckyBoxStatusBlock", 3);
        LuckyBoxStatusBlock = r103;
        LuckyBoxStatus r104 = new LuckyBoxStatus("LuckyBoxStatusGamedraw", 4);
        LuckyBoxStatusGamedraw = r104;
        LuckyBoxStatus r105 = new LuckyBoxStatus("LuckyBoxStatusExpired", 5);
        LuckyBoxStatusExpired = r105;
        LuckyBoxStatus r106 = new LuckyBoxStatus("LuckyBoxStatusEnd", 6);
        LuckyBoxStatusEnd = r106;
        f88660a = new LuckyBoxStatus[]{r100, r101, r102, r103, r104, r105, r106};
    }

    public static LuckyBoxStatus valueOf(String r100) {
        return (LuckyBoxStatus) r27.a.a(LuckyBoxStatus.class, r100);
    }

    public static LuckyBoxStatus[] values() {
        return (LuckyBoxStatus[]) f88660a.clone();
    }

    public LuckyBoxStatus(String r100, int r101) {
        super(r100, r101);
    }
}
