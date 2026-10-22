package com.bytedance.android.shopping.buynow.data.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/shopping/buynow/data/model/GoodsType;", "", "", "type", "I", "getType", "()I", "NORMALGOOD", "DEPOSITGOODDepositGood", "TAILGOOD", "REFUEL", "AUCTION", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum GoodsType extends Enum<GoodsType> {
    public static final GoodsType AUCTION = null;
    public static final GoodsType DEPOSITGOODDepositGood = null;
    public static final GoodsType NORMALGOOD = null;
    public static final GoodsType REFUEL = null;
    public static final GoodsType TAILGOOD = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GoodsType[] f170888a = null;
    private final int type;

    static {
        GoodsType r100 = new GoodsType("NORMALGOOD", 0, 0);
        NORMALGOOD = r100;
        GoodsType r101 = new GoodsType("DEPOSITGOODDepositGood", 1, 1);
        DEPOSITGOODDepositGood = r101;
        GoodsType r102 = new GoodsType("TAILGOOD", 2, 2);
        TAILGOOD = r102;
        GoodsType r103 = new GoodsType("REFUEL", 3, 3);
        REFUEL = r103;
        GoodsType r104 = new GoodsType("AUCTION", 4, 4);
        AUCTION = r104;
        f170888a = new GoodsType[]{r100, r101, r102, r103, r104};
    }

    public static GoodsType valueOf(String r100) {
        return (GoodsType) a.a(GoodsType.class, r100);
    }

    public static GoodsType[] values() {
        return (GoodsType[]) f170888a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public GoodsType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
