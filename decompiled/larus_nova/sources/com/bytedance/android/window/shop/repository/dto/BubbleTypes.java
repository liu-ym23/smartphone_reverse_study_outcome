package com.bytedance.android.window.shop.repository.dto;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/window/shop/repository/dto/BubbleTypes;", "", "", "type", "I", "getType", "()I", "GRASS_BUBBLE", "LIVE_BUBBLE", "INVENTORY_BUBBLE", "INVENTORY_LIST_BUBBLE", "GREAT_BUBBLE", "SECKILL_BUBBLE", "BRAND_BUBBLE", "BOOK_LIST_BUBBLE", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum BubbleTypes extends Enum<BubbleTypes> {
    public static final BubbleTypes BOOK_LIST_BUBBLE = null;
    public static final BubbleTypes BRAND_BUBBLE = null;
    public static final BubbleTypes GRASS_BUBBLE = null;
    public static final BubbleTypes GREAT_BUBBLE = null;
    public static final BubbleTypes INVENTORY_BUBBLE = null;
    public static final BubbleTypes INVENTORY_LIST_BUBBLE = null;
    public static final BubbleTypes LIVE_BUBBLE = null;
    public static final BubbleTypes SECKILL_BUBBLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BubbleTypes[] f189416a = null;
    private final int type;

    public static BubbleTypes valueOf(String r100) {
        return (BubbleTypes) r27.a.a(BubbleTypes.class, r100);
    }

    public static BubbleTypes[] values() {
        return (BubbleTypes[]) f189416a.clone();
    }

    static {
        BubbleTypes r100 = new BubbleTypes("GRASS_BUBBLE", 0, 1);
        GRASS_BUBBLE = r100;
        BubbleTypes r101 = new BubbleTypes("LIVE_BUBBLE", 1, 2);
        LIVE_BUBBLE = r101;
        BubbleTypes r102 = new BubbleTypes("INVENTORY_BUBBLE", 2, 3);
        INVENTORY_BUBBLE = r102;
        BubbleTypes r103 = new BubbleTypes("INVENTORY_LIST_BUBBLE", 3, 4);
        INVENTORY_LIST_BUBBLE = r103;
        BubbleTypes r104 = new BubbleTypes("GREAT_BUBBLE", 4, 5);
        GREAT_BUBBLE = r104;
        BubbleTypes r105 = new BubbleTypes("SECKILL_BUBBLE", 5, 6);
        SECKILL_BUBBLE = r105;
        BubbleTypes r106 = new BubbleTypes("BRAND_BUBBLE", 6, 7);
        BRAND_BUBBLE = r106;
        BubbleTypes r107 = new BubbleTypes("BOOK_LIST_BUBBLE", 7, 9);
        BOOK_LIST_BUBBLE = r107;
        f189416a = new BubbleTypes[]{r100, r101, r102, r103, r104, r105, r106, r107};
    }

    public final int getType() {
        return this.type;
    }

    public BubbleTypes(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
