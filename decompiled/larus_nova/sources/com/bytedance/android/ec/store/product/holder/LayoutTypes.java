package com.bytedance.android.ec.store.product.holder;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/ec/store/product/holder/LayoutTypes;", "", "", "type", "I", "getType", "()I", "RECYCLER_VIEW_ITEM_SINGLE", "RECYCLER_VIEW_ITEM_DOUBLE", "RECYCLER_VIEW_ITEM_CLOTHES_PREVIEW", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LayoutTypes extends Enum<LayoutTypes> {
    public static final LayoutTypes RECYCLER_VIEW_ITEM_CLOTHES_PREVIEW = null;
    public static final LayoutTypes RECYCLER_VIEW_ITEM_DOUBLE = null;
    public static final LayoutTypes RECYCLER_VIEW_ITEM_SINGLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LayoutTypes[] f48292a = null;
    private final int type;

    static {
        LayoutTypes r100 = new LayoutTypes("RECYCLER_VIEW_ITEM_SINGLE", 0, 0);
        RECYCLER_VIEW_ITEM_SINGLE = r100;
        LayoutTypes r101 = new LayoutTypes("RECYCLER_VIEW_ITEM_DOUBLE", 1, 1);
        RECYCLER_VIEW_ITEM_DOUBLE = r101;
        LayoutTypes r102 = new LayoutTypes("RECYCLER_VIEW_ITEM_CLOTHES_PREVIEW", 2, 2);
        RECYCLER_VIEW_ITEM_CLOTHES_PREVIEW = r102;
        f48292a = new LayoutTypes[]{r100, r101, r102};
    }

    public static LayoutTypes valueOf(String r100) {
        return (LayoutTypes) a.a(LayoutTypes.class, r100);
    }

    public static LayoutTypes[] values() {
        return (LayoutTypes[]) f48292a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public LayoutTypes(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
