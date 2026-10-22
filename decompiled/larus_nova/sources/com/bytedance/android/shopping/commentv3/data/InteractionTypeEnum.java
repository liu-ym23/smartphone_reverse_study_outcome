package com.bytedance.android.shopping.commentv3.data;

import com.bytedance.android.shopping.mall.feed.help.GYLFetchType;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/shopping/commentv3/data/InteractionTypeEnum;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "CLICK_IMPRESSION", "CLICK_SKU", "CLICK_LATEST_BTN", "CLICK_COMPLEX_BTN", "LOAD_MORE", "CLICK_MEANINGLESS", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum InteractionTypeEnum extends Enum<InteractionTypeEnum> {
    public static final InteractionTypeEnum CLICK_COMPLEX_BTN = null;
    public static final InteractionTypeEnum CLICK_IMPRESSION = null;
    public static final InteractionTypeEnum CLICK_LATEST_BTN = null;
    public static final InteractionTypeEnum CLICK_MEANINGLESS = null;
    public static final InteractionTypeEnum CLICK_SKU = null;
    public static final a Companion = null;
    public static final InteractionTypeEnum LOAD_MORE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ InteractionTypeEnum[] f172725a = null;
    private final String type;

    public static final class a {
        public a() {
        }
    }

    static {
        InteractionTypeEnum r100 = new InteractionTypeEnum("CLICK_IMPRESSION", 0, "click_impression");
        CLICK_IMPRESSION = r100;
        InteractionTypeEnum r101 = new InteractionTypeEnum("CLICK_SKU", 1, "click_sku");
        CLICK_SKU = r101;
        InteractionTypeEnum r102 = new InteractionTypeEnum("CLICK_LATEST_BTN", 2, "click_latest_button");
        CLICK_LATEST_BTN = r102;
        InteractionTypeEnum r103 = new InteractionTypeEnum("CLICK_COMPLEX_BTN", 3, "click_complex_button");
        CLICK_COMPLEX_BTN = r103;
        InteractionTypeEnum r104 = new InteractionTypeEnum("LOAD_MORE", 4, GYLFetchType.LOAD_MORE);
        LOAD_MORE = r104;
        InteractionTypeEnum r105 = new InteractionTypeEnum("CLICK_MEANINGLESS", 5, "click_meaningless");
        CLICK_MEANINGLESS = r105;
        f172725a = new InteractionTypeEnum[]{r100, r101, r102, r103, r104, r105};
        Companion = new a();
    }

    public static InteractionTypeEnum valueOf(String r100) {
        return (InteractionTypeEnum) r27.a.a(InteractionTypeEnum.class, r100);
    }

    public static InteractionTypeEnum[] values() {
        return (InteractionTypeEnum[]) f172725a.clone();
    }

    public final String getType() {
        return this.type;
    }

    public InteractionTypeEnum(String r100, int r101, String r102) {
        super(r100, r101);
        this.type = r102;
    }
}
