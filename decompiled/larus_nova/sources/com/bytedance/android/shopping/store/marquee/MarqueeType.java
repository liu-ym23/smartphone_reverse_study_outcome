package com.bytedance.android.shopping.store.marquee;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/store/marquee/MarqueeType;", "", "", "type", "I", "getType", "()I", "OrderMarquee", "RateMarquee", "FootMarquee", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum MarqueeType extends Enum<MarqueeType> {
    public static final MarqueeType FootMarquee = null;
    public static final MarqueeType OrderMarquee = null;
    public static final MarqueeType RateMarquee = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MarqueeType[] f185623a = null;
    private final int type;

    static {
        MarqueeType r100 = new MarqueeType("OrderMarquee", 0, 1);
        OrderMarquee = r100;
        MarqueeType r101 = new MarqueeType("RateMarquee", 1, 2);
        RateMarquee = r101;
        MarqueeType r102 = new MarqueeType("FootMarquee", 2, 3);
        FootMarquee = r102;
        f185623a = new MarqueeType[]{r100, r101, r102};
    }

    public static MarqueeType valueOf(String r100) {
        return (MarqueeType) a.a(MarqueeType.class, r100);
    }

    public static MarqueeType[] values() {
        return (MarqueeType[]) f185623a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public MarqueeType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
