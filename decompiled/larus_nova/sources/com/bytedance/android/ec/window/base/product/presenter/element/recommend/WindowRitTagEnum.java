package com.bytedance.android.ec.window.base.product.presenter.element.recommend;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/ec/window/base/product/presenter/element/recommend/WindowRitTagEnum;", "", "", "labelName", "Ljava/lang/String;", "getLabelName", "()Ljava/lang/String;", "WINDOW_SELLPOINT_INVENTORY", "WINDOW_SELLPOINT_RANK", "WINDOW_SELLPOINT_AUTHOR_SAY", "WINDOW_LIMIT_TIME_SPECIAL", "WINDOW_EQUAL_LIVE", "WINDOW_HOT_LIVE", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum WindowRitTagEnum extends Enum<WindowRitTagEnum> {
    public static final WindowRitTagEnum WINDOW_EQUAL_LIVE = null;
    public static final WindowRitTagEnum WINDOW_HOT_LIVE = null;
    public static final WindowRitTagEnum WINDOW_LIMIT_TIME_SPECIAL = null;
    public static final WindowRitTagEnum WINDOW_SELLPOINT_AUTHOR_SAY = null;
    public static final WindowRitTagEnum WINDOW_SELLPOINT_INVENTORY = null;
    public static final WindowRitTagEnum WINDOW_SELLPOINT_RANK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ WindowRitTagEnum[] f49406a = null;
    private final String labelName;

    static {
        WindowRitTagEnum r100 = new WindowRitTagEnum("WINDOW_SELLPOINT_INVENTORY", 0, "window_sellpoint_inventory");
        WINDOW_SELLPOINT_INVENTORY = r100;
        WindowRitTagEnum r101 = new WindowRitTagEnum("WINDOW_SELLPOINT_RANK", 1, "window_sellpoint_rank");
        WINDOW_SELLPOINT_RANK = r101;
        WindowRitTagEnum r102 = new WindowRitTagEnum("WINDOW_SELLPOINT_AUTHOR_SAY", 2, "window_sellpoint_author_say");
        WINDOW_SELLPOINT_AUTHOR_SAY = r102;
        WindowRitTagEnum r103 = new WindowRitTagEnum("WINDOW_LIMIT_TIME_SPECIAL", 3, "window_limit_time_special");
        WINDOW_LIMIT_TIME_SPECIAL = r103;
        WindowRitTagEnum r104 = new WindowRitTagEnum("WINDOW_EQUAL_LIVE", 4, "window_equal_live");
        WINDOW_EQUAL_LIVE = r104;
        WindowRitTagEnum r105 = new WindowRitTagEnum("WINDOW_HOT_LIVE", 5, "window_hot_live");
        WINDOW_HOT_LIVE = r105;
        f49406a = new WindowRitTagEnum[]{r100, r101, r102, r103, r104, r105};
    }

    public static WindowRitTagEnum valueOf(String r100) {
        return (WindowRitTagEnum) r27.a.a(WindowRitTagEnum.class, r100);
    }

    public static WindowRitTagEnum[] values() {
        return (WindowRitTagEnum[]) f49406a.clone();
    }

    public final String getLabelName() {
        return this.labelName;
    }

    public WindowRitTagEnum(String r100, int r101, String r102) {
        super(r100, r101);
        this.labelName = r102;
    }
}
