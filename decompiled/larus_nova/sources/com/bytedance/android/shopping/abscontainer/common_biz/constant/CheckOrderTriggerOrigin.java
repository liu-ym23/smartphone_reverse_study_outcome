package com.bytedance.android.shopping.abscontainer.common_biz.constant;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/abscontainer/common_biz/constant/CheckOrderTriggerOrigin;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "CASHIER_CALLBACK", "ORDER_SUCCESS", "PAGE_VISIBLE", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum CheckOrderTriggerOrigin extends Enum<CheckOrderTriggerOrigin> {
    public static final CheckOrderTriggerOrigin CASHIER_CALLBACK = null;
    public static final CheckOrderTriggerOrigin ORDER_SUCCESS = null;
    public static final CheckOrderTriggerOrigin PAGE_VISIBLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CheckOrderTriggerOrigin[] f164216a = null;
    private final String value;

    static {
        CheckOrderTriggerOrigin r100 = new CheckOrderTriggerOrigin("CASHIER_CALLBACK", 0, com.bytedance.android.shopping.buynow.data.model.CheckOrderTriggerOrigin.CASHIER_CALLBACK);
        CASHIER_CALLBACK = r100;
        CheckOrderTriggerOrigin r101 = new CheckOrderTriggerOrigin("ORDER_SUCCESS", 1, com.bytedance.android.shopping.buynow.data.model.CheckOrderTriggerOrigin.ORDER_SUCCESS);
        ORDER_SUCCESS = r101;
        CheckOrderTriggerOrigin r102 = new CheckOrderTriggerOrigin("PAGE_VISIBLE", 2, "page_visible");
        PAGE_VISIBLE = r102;
        f164216a = new CheckOrderTriggerOrigin[]{r100, r101, r102};
    }

    public static CheckOrderTriggerOrigin valueOf(String r100) {
        return (CheckOrderTriggerOrigin) a.a(CheckOrderTriggerOrigin.class, r100);
    }

    public static CheckOrderTriggerOrigin[] values() {
        return (CheckOrderTriggerOrigin[]) f164216a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public CheckOrderTriggerOrigin(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
