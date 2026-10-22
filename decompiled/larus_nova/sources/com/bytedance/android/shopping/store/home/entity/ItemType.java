package com.bytedance.android.shopping.store.home.entity;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/store/home/entity/ItemType;", "", "", "type", "I", "getType", "()I", "PURE_TEXT", "ICON", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ItemType extends Enum<ItemType> {
    public static final ItemType ICON = null;
    public static final ItemType PURE_TEXT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ItemType[] f183639a = null;
    private final int type;

    static {
        ItemType r100 = new ItemType("PURE_TEXT", 0, 1);
        PURE_TEXT = r100;
        ItemType r101 = new ItemType("ICON", 1, 2);
        ICON = r101;
        f183639a = new ItemType[]{r100, r101};
    }

    public static ItemType valueOf(String r100) {
        return (ItemType) r27.a.a(ItemType.class, r100);
    }

    public static ItemType[] values() {
        return (ItemType[]) f183639a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public ItemType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
