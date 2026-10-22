package com.bytedance.android.shopping.abscontainer.common_biz.constant;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/abscontainer/common_biz/constant/PopupCode;", "", "", "code", "Ljava/lang/String;", "getCode", "()Ljava/lang/String;", com.bytedance.android.shopping.buynow.data.model.PopupCode.PAY_SWITCH_CARD_POPUP, com.bytedance.android.shopping.buynow.data.model.PopupCode.PRICE_DETAIL_CARD_POPUP, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PopupCode extends Enum<PopupCode> {
    public static final PopupCode PAY_SWITCH_CARD_POPUP = null;
    public static final PopupCode PRICE_DETAIL_CARD = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PopupCode[] f164225a = null;
    private final String code;

    static {
        PopupCode r100 = new PopupCode(com.bytedance.android.shopping.buynow.data.model.PopupCode.PAY_SWITCH_CARD_POPUP, 0, com.bytedance.android.shopping.buynow.data.model.PopupCode.PAY_SWITCH_CARD_POPUP);
        PAY_SWITCH_CARD_POPUP = r100;
        PopupCode r101 = new PopupCode(com.bytedance.android.shopping.buynow.data.model.PopupCode.PRICE_DETAIL_CARD_POPUP, 1, com.bytedance.android.shopping.buynow.data.model.PopupCode.PRICE_DETAIL_CARD_POPUP);
        PRICE_DETAIL_CARD = r101;
        f164225a = new PopupCode[]{r100, r101};
    }

    public static PopupCode valueOf(String r100) {
        return (PopupCode) a.a(PopupCode.class, r100);
    }

    public static PopupCode[] values() {
        return (PopupCode[]) f164225a.clone();
    }

    public final String getCode() {
        return this.code;
    }

    public PopupCode(String r100, int r101, String r102) {
        super(r100, r101);
        this.code = r102;
    }
}
