package com.bytedance.android.window.shop.widget;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/window/shop/widget/SubCategoryTypes;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "SUB_LIVE_HOT", "SUB_LIVE_APPOINT", "SUB_LIVE_EQUAL_PRICE", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum SubCategoryTypes extends Enum<SubCategoryTypes> {
    public static final SubCategoryTypes SUB_LIVE_APPOINT = null;
    public static final SubCategoryTypes SUB_LIVE_EQUAL_PRICE = null;
    public static final SubCategoryTypes SUB_LIVE_HOT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SubCategoryTypes[] f189881a = null;
    private final String type;

    static {
        SubCategoryTypes r100 = new SubCategoryTypes("SUB_LIVE_HOT", 0, "112002");
        SUB_LIVE_HOT = r100;
        SubCategoryTypes r101 = new SubCategoryTypes("SUB_LIVE_APPOINT", 1, "112001");
        SUB_LIVE_APPOINT = r101;
        SubCategoryTypes r102 = new SubCategoryTypes("SUB_LIVE_EQUAL_PRICE", 2, "112003");
        SUB_LIVE_EQUAL_PRICE = r102;
        f189881a = new SubCategoryTypes[]{r100, r101, r102};
    }

    public static SubCategoryTypes valueOf(String r100) {
        return (SubCategoryTypes) r27.a.a(SubCategoryTypes.class, r100);
    }

    public static SubCategoryTypes[] values() {
        return (SubCategoryTypes[]) f189881a.clone();
    }

    public final String getType() {
        return this.type;
    }

    public SubCategoryTypes(String r100, int r101, String r102) {
        super(r100, r101);
        this.type = r102;
    }
}
