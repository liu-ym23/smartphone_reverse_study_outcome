package com.bytedance.android.livesdk.livecommerce.network.response;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/network/response/PromotionHeaderTabStyleType;", "", "", "value", "I", "getValue", "()I", "DEFAULT", "NO_BORDER", "ROUND_RECT", "DESIGN_UPGRADE", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PromotionHeaderTabStyleType extends Enum<PromotionHeaderTabStyleType> {
    public static final PromotionHeaderTabStyleType DEFAULT = null;
    public static final PromotionHeaderTabStyleType DESIGN_UPGRADE = null;
    public static final PromotionHeaderTabStyleType NO_BORDER = null;
    public static final PromotionHeaderTabStyleType ROUND_RECT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PromotionHeaderTabStyleType[] f149509a = null;
    private final int value;

    static {
        PromotionHeaderTabStyleType r100 = new PromotionHeaderTabStyleType("DEFAULT", 0, 0);
        DEFAULT = r100;
        PromotionHeaderTabStyleType r101 = new PromotionHeaderTabStyleType("NO_BORDER", 1, 1);
        NO_BORDER = r101;
        PromotionHeaderTabStyleType r102 = new PromotionHeaderTabStyleType("ROUND_RECT", 2, 2);
        ROUND_RECT = r102;
        PromotionHeaderTabStyleType r103 = new PromotionHeaderTabStyleType("DESIGN_UPGRADE", 3, 3);
        DESIGN_UPGRADE = r103;
        f149509a = new PromotionHeaderTabStyleType[]{r100, r101, r102, r103};
    }

    public static PromotionHeaderTabStyleType valueOf(String r100) {
        return (PromotionHeaderTabStyleType) a.a(PromotionHeaderTabStyleType.class, r100);
    }

    public static PromotionHeaderTabStyleType[] values() {
        return (PromotionHeaderTabStyleType[]) f149509a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public PromotionHeaderTabStyleType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
