package com.bytedance.android.ec.model.promotion;

import com.bytedance.android.ecom.arch.slice.slices.template.TemplateNodeType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import r27.a;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0011\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/ec/model/promotion/Campaign;", "", "", TemplateNodeType.RAW, "I", "getRaw", "()I", "SECKILL", "GROUP", "PRE_SALE", "AUCTION", "PREHEAT", "PLATFORM", "BILLION_SUBSIDIES", "SHOP_VIP_PRODUCT", "ENOUGH_CUT", "LIMIT_BUY", "LIMIT_QUANTITY_BUY", "MULTI_GROUP_BUY", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final enum Campaign extends Enum<Campaign> {
    public static final Campaign AUCTION = null;
    public static final Campaign BILLION_SUBSIDIES = null;
    public static final Campaign ENOUGH_CUT = null;
    public static final Campaign GROUP = null;
    public static final Campaign LIMIT_BUY = null;
    public static final Campaign LIMIT_QUANTITY_BUY = null;
    public static final Campaign MULTI_GROUP_BUY = null;
    public static final Campaign PLATFORM = null;
    public static final Campaign PREHEAT = null;
    public static final Campaign PRE_SALE = null;
    public static final Campaign SECKILL = null;
    public static final Campaign SHOP_VIP_PRODUCT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Campaign[] f47894a = null;
    private final int raw;

    public static Campaign valueOf(String r100) {
        return (Campaign) a.a(Campaign.class, r100);
    }

    public static Campaign[] values() {
        return (Campaign[]) f47894a.clone();
    }

    static {
        Campaign r100 = new Campaign("SECKILL", 0, 0);
        SECKILL = r100;
        Campaign r101 = new Campaign("GROUP", 1, 1);
        GROUP = r101;
        Campaign r102 = new Campaign("PRE_SALE", 2, 2);
        PRE_SALE = r102;
        Campaign r103 = new Campaign("AUCTION", 3, 3);
        AUCTION = r103;
        Campaign r104 = new Campaign("PREHEAT", 4, 4);
        PREHEAT = r104;
        Campaign r105 = new Campaign("PLATFORM", 5, 5);
        PLATFORM = r105;
        Campaign r106 = new Campaign("BILLION_SUBSIDIES", 6, 6);
        BILLION_SUBSIDIES = r106;
        Campaign r107 = new Campaign("SHOP_VIP_PRODUCT", 7, 7);
        SHOP_VIP_PRODUCT = r107;
        Campaign r108 = new Campaign("ENOUGH_CUT", 8, 8);
        ENOUGH_CUT = r108;
        Campaign r109 = new Campaign("LIMIT_BUY", 9, 9);
        LIMIT_BUY = r109;
        Campaign r110 = new Campaign("LIMIT_QUANTITY_BUY", 10, 10);
        LIMIT_QUANTITY_BUY = r110;
        Campaign r111 = new Campaign("MULTI_GROUP_BUY", 11, 11);
        MULTI_GROUP_BUY = r111;
        f47894a = new Campaign[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111};
    }

    public final int getRaw() {
        return this.raw;
    }

    public Campaign(String r100, int r101, int r102) {
        super(r100, r101);
        this.raw = r102;
    }

    public /* synthetic */ Campaign(String r100, int r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L5;
        r102 = 0;
    L5:
        this(r100, r101, r102);
    }
}
