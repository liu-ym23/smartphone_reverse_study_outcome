package com.bytedance.android.livesdk.revenue.experience;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/revenue/experience/RevExpBizScene;", "", "DEGRADE_BUSINESS_REVENUE_RANK", "DEGRADE_BUSINESS_REVENUE_GIFT_TRAY", "DEGRADE_BUSINESS_REVENUE_GIFT_TRAY_ANIMATION", "DEGRADE_BUSINESS_REVENUE_GIFT_VIDEO", "revenue-host-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum RevExpBizScene extends Enum<RevExpBizScene> {
    public static final RevExpBizScene DEGRADE_BUSINESS_REVENUE_GIFT_TRAY = null;
    public static final RevExpBizScene DEGRADE_BUSINESS_REVENUE_GIFT_TRAY_ANIMATION = null;
    public static final RevExpBizScene DEGRADE_BUSINESS_REVENUE_GIFT_VIDEO = null;
    public static final RevExpBizScene DEGRADE_BUSINESS_REVENUE_RANK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RevExpBizScene[] f157149a = null;

    static {
        RevExpBizScene r100 = new RevExpBizScene("DEGRADE_BUSINESS_REVENUE_RANK", 0);
        DEGRADE_BUSINESS_REVENUE_RANK = r100;
        RevExpBizScene r101 = new RevExpBizScene("DEGRADE_BUSINESS_REVENUE_GIFT_TRAY", 1);
        DEGRADE_BUSINESS_REVENUE_GIFT_TRAY = r101;
        RevExpBizScene r102 = new RevExpBizScene("DEGRADE_BUSINESS_REVENUE_GIFT_TRAY_ANIMATION", 2);
        DEGRADE_BUSINESS_REVENUE_GIFT_TRAY_ANIMATION = r102;
        RevExpBizScene r103 = new RevExpBizScene("DEGRADE_BUSINESS_REVENUE_GIFT_VIDEO", 3);
        DEGRADE_BUSINESS_REVENUE_GIFT_VIDEO = r103;
        f157149a = new RevExpBizScene[]{r100, r101, r102, r103};
    }

    public static RevExpBizScene valueOf(String r100) {
        return (RevExpBizScene) r27.a.a(RevExpBizScene.class, r100);
    }

    public static RevExpBizScene[] values() {
        return (RevExpBizScene[]) f157149a.clone();
    }

    public RevExpBizScene(String r100, int r101) {
        super(r100, r101);
    }
}
