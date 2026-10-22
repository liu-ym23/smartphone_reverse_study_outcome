package com.bytedance.android.shopping.deepfeed.ui.popup;

import com.bytedance.android.ec.common.api.inflow.AnchorBenefitToast;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/ui/popup/DeepFeedPopupType;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "COUPON", "FEEDBACK_POPUP", "SCREEN_SHOT", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum DeepFeedPopupType extends Enum<DeepFeedPopupType> {
    public static final DeepFeedPopupType COUPON = null;
    public static final DeepFeedPopupType FEEDBACK_POPUP = null;
    public static final DeepFeedPopupType SCREEN_SHOT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DeepFeedPopupType[] f173748a = null;
    private final String value;

    static {
        DeepFeedPopupType r100 = new DeepFeedPopupType("COUPON", 0, AnchorBenefitToast.TYPE_COUPON);
        COUPON = r100;
        DeepFeedPopupType r101 = new DeepFeedPopupType("FEEDBACK_POPUP", 1, "feedback_popup");
        FEEDBACK_POPUP = r101;
        DeepFeedPopupType r102 = new DeepFeedPopupType("SCREEN_SHOT", 2, "screen_shot");
        SCREEN_SHOT = r102;
        f173748a = new DeepFeedPopupType[]{r100, r101, r102};
    }

    public static DeepFeedPopupType valueOf(String r100) {
        return (DeepFeedPopupType) a.a(DeepFeedPopupType.class, r100);
    }

    public static DeepFeedPopupType[] values() {
        return (DeepFeedPopupType[]) f173748a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public DeepFeedPopupType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
