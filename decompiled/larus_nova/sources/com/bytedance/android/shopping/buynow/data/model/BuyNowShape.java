package com.bytedance.android.shopping.buynow.data.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/shopping/buynow/data/model/BuyNowShape;", "", "", "shape", "I", "getShape", "()I", "DEFAULT", "HALF", "FINAL", "ZERO_BUY", "REFUEL", "AUCTION", "DIRECT", "SUPERMARKET_HOUR", "RECHARGE", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum BuyNowShape extends Enum<BuyNowShape> {
    public static final BuyNowShape AUCTION = null;
    public static final BuyNowShape DEFAULT = null;
    public static final BuyNowShape DIRECT = null;
    public static final BuyNowShape FINAL = null;
    public static final BuyNowShape HALF = null;
    public static final BuyNowShape RECHARGE = null;
    public static final BuyNowShape REFUEL = null;
    public static final BuyNowShape SUPERMARKET_HOUR = null;
    public static final BuyNowShape ZERO_BUY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BuyNowShape[] f170882a = null;
    private final int shape;

    public static BuyNowShape valueOf(String r100) {
        return (BuyNowShape) a.a(BuyNowShape.class, r100);
    }

    public static BuyNowShape[] values() {
        return (BuyNowShape[]) f170882a.clone();
    }

    static {
        BuyNowShape r100 = new BuyNowShape("DEFAULT", 0, 0);
        DEFAULT = r100;
        BuyNowShape r101 = new BuyNowShape("HALF", 1, 1);
        HALF = r101;
        BuyNowShape r102 = new BuyNowShape("FINAL", 2, 2);
        FINAL = r102;
        BuyNowShape r103 = new BuyNowShape("ZERO_BUY", 3, 3);
        ZERO_BUY = r103;
        BuyNowShape r104 = new BuyNowShape("REFUEL", 4, 4);
        REFUEL = r104;
        BuyNowShape r105 = new BuyNowShape("AUCTION", 5, 5);
        AUCTION = r105;
        BuyNowShape r106 = new BuyNowShape("DIRECT", 6, 6);
        DIRECT = r106;
        BuyNowShape r107 = new BuyNowShape("SUPERMARKET_HOUR", 7, 8);
        SUPERMARKET_HOUR = r107;
        BuyNowShape r108 = new BuyNowShape("RECHARGE", 8, 9);
        RECHARGE = r108;
        f170882a = new BuyNowShape[]{r100, r101, r102, r103, r104, r105, r106, r107, r108};
    }

    public final int getShape() {
        return this.shape;
    }

    public BuyNowShape(String r100, int r101, int r102) {
        super(r100, r101);
        this.shape = r102;
    }
}
