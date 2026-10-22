package com.bytedance.android.gamecp.base.gamedetail;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/gamecp/base/gamedetail/ItemViewLayoutStyle;", "", "Normal", "TwoButtonLayout", "InRowSingleButton", "InRowTwoButton", "gamecp-base_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ItemViewLayoutStyle extends Enum<ItemViewLayoutStyle> {
    public static final ItemViewLayoutStyle InRowSingleButton = null;
    public static final ItemViewLayoutStyle InRowTwoButton = null;
    public static final ItemViewLayoutStyle Normal = null;
    public static final ItemViewLayoutStyle TwoButtonLayout = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ItemViewLayoutStyle[] f51531a = null;

    static {
        ItemViewLayoutStyle r100 = new ItemViewLayoutStyle("Normal", 0);
        Normal = r100;
        ItemViewLayoutStyle r101 = new ItemViewLayoutStyle("TwoButtonLayout", 1);
        TwoButtonLayout = r101;
        ItemViewLayoutStyle r102 = new ItemViewLayoutStyle("InRowSingleButton", 2);
        InRowSingleButton = r102;
        ItemViewLayoutStyle r103 = new ItemViewLayoutStyle("InRowTwoButton", 3);
        InRowTwoButton = r103;
        f51531a = new ItemViewLayoutStyle[]{r100, r101, r102, r103};
    }

    public static ItemViewLayoutStyle valueOf(String r100) {
        return (ItemViewLayoutStyle) r27.a.a(ItemViewLayoutStyle.class, r100);
    }

    public static ItemViewLayoutStyle[] values() {
        return (ItemViewLayoutStyle[]) f51531a.clone();
    }

    public ItemViewLayoutStyle(String r100, int r101) {
        super(r100, r101);
    }
}
