package com.bytedance.android.live.recharge.util;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/recharge/util/GiftToRechargeParamsKey;", "", "", "keyName", "Ljava/lang/String;", "getKeyName", "()Ljava/lang/String;", "KEY_GIFT_NO_BALANCE_SCENE", "KEY_SEND_GIFT_CHARGE_REASON", "KEY_GIFT_PANEL_SESSION_ID", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum GiftToRechargeParamsKey extends Enum<GiftToRechargeParamsKey> {
    public static final GiftToRechargeParamsKey KEY_GIFT_NO_BALANCE_SCENE = null;
    public static final GiftToRechargeParamsKey KEY_GIFT_PANEL_SESSION_ID = null;
    public static final GiftToRechargeParamsKey KEY_SEND_GIFT_CHARGE_REASON = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GiftToRechargeParamsKey[] f90412a = null;
    private final String keyName;

    static {
        GiftToRechargeParamsKey r100 = new GiftToRechargeParamsKey("KEY_GIFT_NO_BALANCE_SCENE", 0, "gift_no_balance_scene");
        KEY_GIFT_NO_BALANCE_SCENE = r100;
        GiftToRechargeParamsKey r101 = new GiftToRechargeParamsKey("KEY_SEND_GIFT_CHARGE_REASON", 1, "charge_reason");
        KEY_SEND_GIFT_CHARGE_REASON = r101;
        GiftToRechargeParamsKey r102 = new GiftToRechargeParamsKey("KEY_GIFT_PANEL_SESSION_ID", 2, "gift_panel_session_id");
        KEY_GIFT_PANEL_SESSION_ID = r102;
        f90412a = new GiftToRechargeParamsKey[]{r100, r101, r102};
    }

    public static GiftToRechargeParamsKey valueOf(String r100) {
        return (GiftToRechargeParamsKey) r27.a.a(GiftToRechargeParamsKey.class, r100);
    }

    public static GiftToRechargeParamsKey[] values() {
        return (GiftToRechargeParamsKey[]) f90412a.clone();
    }

    public final String getKeyName() {
        return this.keyName;
    }

    public GiftToRechargeParamsKey(String r100, int r101, String r102) {
        super(r100, r101);
        this.keyName = r102;
    }
}
