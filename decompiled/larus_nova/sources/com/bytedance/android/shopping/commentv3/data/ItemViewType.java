package com.bytedance.android.shopping.commentv3.data;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/shopping/commentv3/data/ItemViewType;", "", "", "type", "I", "getType", "()I", "SLICE", "LYNX", "NATIVE", "SLICE_TAB_FILTER", "SLICE_SORT_HEADER", "SLICE_COMMENT_HEAD", "SLICE_COMMENT_MEDIA", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ItemViewType extends Enum<ItemViewType> {
    public static final ItemViewType LYNX = null;
    public static final ItemViewType NATIVE = null;
    public static final ItemViewType SLICE = null;
    public static final ItemViewType SLICE_COMMENT_HEAD = null;
    public static final ItemViewType SLICE_COMMENT_MEDIA = null;
    public static final ItemViewType SLICE_SORT_HEADER = null;
    public static final ItemViewType SLICE_TAB_FILTER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ItemViewType[] f172726a = null;
    private final int type;

    static {
        ItemViewType r100 = new ItemViewType("SLICE", 0, 1);
        SLICE = r100;
        ItemViewType r101 = new ItemViewType("LYNX", 1, 2);
        LYNX = r101;
        ItemViewType r102 = new ItemViewType("NATIVE", 2, 3);
        NATIVE = r102;
        ItemViewType r103 = new ItemViewType("SLICE_TAB_FILTER", 3, 101);
        SLICE_TAB_FILTER = r103;
        ItemViewType r104 = new ItemViewType("SLICE_SORT_HEADER", 4, 102);
        SLICE_SORT_HEADER = r104;
        ItemViewType r105 = new ItemViewType("SLICE_COMMENT_HEAD", 5, 103);
        SLICE_COMMENT_HEAD = r105;
        ItemViewType r106 = new ItemViewType("SLICE_COMMENT_MEDIA", 6, 104);
        SLICE_COMMENT_MEDIA = r106;
        f172726a = new ItemViewType[]{r100, r101, r102, r103, r104, r105, r106};
    }

    public static ItemViewType valueOf(String r100) {
        return (ItemViewType) r27.a.a(ItemViewType.class, r100);
    }

    public static ItemViewType[] values() {
        return (ItemViewType[]) f172726a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public ItemViewType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
