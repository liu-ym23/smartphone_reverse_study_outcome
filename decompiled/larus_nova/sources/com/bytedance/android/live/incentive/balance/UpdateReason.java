package com.bytedance.android.live.incentive.balance;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/incentive/balance/UpdateReason;", "", "Unknown", "EnterRoom", "OpenGiftPanel", "AfterExchange", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum UpdateReason extends Enum<UpdateReason> {
    public static final UpdateReason AfterExchange = null;
    public static final UpdateReason EnterRoom = null;
    public static final UpdateReason OpenGiftPanel = null;
    public static final UpdateReason Unknown = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ UpdateReason[] f69327a = null;

    static {
        UpdateReason r100 = new UpdateReason("Unknown", 0);
        Unknown = r100;
        UpdateReason r101 = new UpdateReason("EnterRoom", 1);
        EnterRoom = r101;
        UpdateReason r102 = new UpdateReason("OpenGiftPanel", 2);
        OpenGiftPanel = r102;
        UpdateReason r103 = new UpdateReason("AfterExchange", 3);
        AfterExchange = r103;
        f69327a = new UpdateReason[]{r100, r101, r102, r103};
    }

    public static UpdateReason valueOf(String r100) {
        return (UpdateReason) r27.a.a(UpdateReason.class, r100);
    }

    public static UpdateReason[] values() {
        return (UpdateReason[]) f69327a.clone();
    }

    public UpdateReason(String r100, int r101) {
        super(r100, r101);
    }
}
