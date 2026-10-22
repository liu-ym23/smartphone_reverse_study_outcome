package com.bytedance.android.shopping.store.aggregate;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/shopping/store/aggregate/CustomIdTypes;", "", "", "type", "I", "getType", "()I", "CouponMetaId", "CategoryId", "NewDecorationCategory", "TargetProductId", "TargetCouponMetaId", "TargetPromotionId", "MaterialId", "ActivityId", "LiveAuthorId", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum CustomIdTypes extends Enum<CustomIdTypes> {
    public static final CustomIdTypes ActivityId = null;
    public static final CustomIdTypes CategoryId = null;
    public static final CustomIdTypes CouponMetaId = null;
    public static final CustomIdTypes LiveAuthorId = null;
    public static final CustomIdTypes MaterialId = null;
    public static final CustomIdTypes NewDecorationCategory = null;
    public static final CustomIdTypes TargetCouponMetaId = null;
    public static final CustomIdTypes TargetProductId = null;
    public static final CustomIdTypes TargetPromotionId = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CustomIdTypes[] f183348a = null;
    private final int type;

    public static CustomIdTypes valueOf(String r100) {
        return (CustomIdTypes) r27.a.a(CustomIdTypes.class, r100);
    }

    public static CustomIdTypes[] values() {
        return (CustomIdTypes[]) f183348a.clone();
    }

    static {
        CustomIdTypes r100 = new CustomIdTypes("CouponMetaId", 0, 1);
        CouponMetaId = r100;
        CustomIdTypes r101 = new CustomIdTypes("CategoryId", 1, 2);
        CategoryId = r101;
        CustomIdTypes r102 = new CustomIdTypes("NewDecorationCategory", 2, 3);
        NewDecorationCategory = r102;
        CustomIdTypes r103 = new CustomIdTypes("TargetProductId", 3, 4);
        TargetProductId = r103;
        CustomIdTypes r104 = new CustomIdTypes("TargetCouponMetaId", 4, 5);
        TargetCouponMetaId = r104;
        CustomIdTypes r105 = new CustomIdTypes("TargetPromotionId", 5, 6);
        TargetPromotionId = r105;
        CustomIdTypes r106 = new CustomIdTypes("MaterialId", 6, 7);
        MaterialId = r106;
        CustomIdTypes r107 = new CustomIdTypes("ActivityId", 7, 8);
        ActivityId = r107;
        CustomIdTypes r108 = new CustomIdTypes("LiveAuthorId", 8, 9);
        LiveAuthorId = r108;
        f183348a = new CustomIdTypes[]{r100, r101, r102, r103, r104, r105, r106, r107, r108};
    }

    public final int getType() {
        return this.type;
    }

    public CustomIdTypes(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
