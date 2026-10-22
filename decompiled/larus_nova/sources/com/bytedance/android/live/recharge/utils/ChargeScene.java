package com.bytedance.android.live.recharge.utils;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/recharge/utils/ChargeScene;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "GIFT_NO_BALANCE", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum ChargeScene extends Enum<ChargeScene> {
    public static final ChargeScene GIFT_NO_BALANCE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ChargeScene[] f90449a = null;
    private final String value;

    static {
        ChargeScene r100 = new ChargeScene();
        GIFT_NO_BALANCE = r100;
        f90449a = new ChargeScene[]{r100};
    }

    public static ChargeScene valueOf(String r100) {
        return (ChargeScene) r27.a.a(ChargeScene.class, r100);
    }

    public static ChargeScene[] values() {
        return (ChargeScene[]) f90449a.clone();
    }

    public ChargeScene() {
        super("GIFT_NO_BALANCE", 0);
        this.value = "gift_no_balance";
    }

    public final String getValue() {
        return this.value;
    }
}
