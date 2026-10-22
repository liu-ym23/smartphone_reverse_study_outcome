package com.bytedance.android.shopping.commentv3.action.handler.tracker;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0015\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/shopping/commentv3/action/handler/tracker/EntranceType;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "COMMENT_PAGE", "SKU_PANEL", "SKU_CONFIRM", "SKU_RESET", "SKU_CLOSE", "LIST_PIC_MODE_SWITCH", "LIST_IMAGE_SCROLL_TOP", "LIST_IMAGE_PREVIEW", "LIST_IMAGE_PREVIEW_LIKE", "LIST_IMAGE_PREVIEW_EXIT", "LIST_IMAGE_PREVIEW_SCROLL", "LIST_IMAGE_PREVIEW_ALBUM", "LIST_IMAGE_PREVIEW_EXPAND", "FETCH_COMMENT_LIST", "SLICE_BIND_DATA", "SLICE_ACTION_HANDLE", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum EntranceType extends Enum<EntranceType> {
    public static final EntranceType COMMENT_PAGE = null;
    public static final EntranceType FETCH_COMMENT_LIST = null;
    public static final EntranceType LIST_IMAGE_PREVIEW = null;
    public static final EntranceType LIST_IMAGE_PREVIEW_ALBUM = null;
    public static final EntranceType LIST_IMAGE_PREVIEW_EXIT = null;
    public static final EntranceType LIST_IMAGE_PREVIEW_EXPAND = null;
    public static final EntranceType LIST_IMAGE_PREVIEW_LIKE = null;
    public static final EntranceType LIST_IMAGE_PREVIEW_SCROLL = null;
    public static final EntranceType LIST_IMAGE_SCROLL_TOP = null;
    public static final EntranceType LIST_PIC_MODE_SWITCH = null;
    public static final EntranceType SKU_CLOSE = null;
    public static final EntranceType SKU_CONFIRM = null;
    public static final EntranceType SKU_PANEL = null;
    public static final EntranceType SKU_RESET = null;
    public static final EntranceType SLICE_ACTION_HANDLE = null;
    public static final EntranceType SLICE_BIND_DATA = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EntranceType[] f172594a = null;
    private final String type;

    public static EntranceType valueOf(String r100) {
        return (EntranceType) a.a(EntranceType.class, r100);
    }

    public static EntranceType[] values() {
        return (EntranceType[]) f172594a.clone();
    }

    static {
        EntranceType r100 = new EntranceType("COMMENT_PAGE", 0, "comment_page");
        COMMENT_PAGE = r100;
        EntranceType r101 = new EntranceType("SKU_PANEL", 1, "list_sku_view");
        SKU_PANEL = r101;
        EntranceType r102 = new EntranceType("SKU_CONFIRM", 2, "list_sku_view_confirm");
        SKU_CONFIRM = r102;
        EntranceType r103 = new EntranceType("SKU_RESET", 3, "list_sku_view_reset");
        SKU_RESET = r103;
        EntranceType r104 = new EntranceType("SKU_CLOSE", 4, "list_sku_view_close");
        SKU_CLOSE = r104;
        EntranceType r105 = new EntranceType("LIST_PIC_MODE_SWITCH", 5, "list_pic_mode_switch");
        LIST_PIC_MODE_SWITCH = r105;
        EntranceType r106 = new EntranceType("LIST_IMAGE_SCROLL_TOP", 6, "list_image_scroll_top");
        LIST_IMAGE_SCROLL_TOP = r106;
        EntranceType r107 = new EntranceType("LIST_IMAGE_PREVIEW", 7, "list_image_preview");
        LIST_IMAGE_PREVIEW = r107;
        EntranceType r108 = new EntranceType("LIST_IMAGE_PREVIEW_LIKE", 8, "list_image_preview_like");
        LIST_IMAGE_PREVIEW_LIKE = r108;
        EntranceType r109 = new EntranceType("LIST_IMAGE_PREVIEW_EXIT", 9, "list_image_preview_exit");
        LIST_IMAGE_PREVIEW_EXIT = r109;
        EntranceType r110 = new EntranceType("LIST_IMAGE_PREVIEW_SCROLL", 10, "list_image_preview_scroll");
        LIST_IMAGE_PREVIEW_SCROLL = r110;
        EntranceType r111 = new EntranceType("LIST_IMAGE_PREVIEW_ALBUM", 11, "list_image_preview_album");
        LIST_IMAGE_PREVIEW_ALBUM = r111;
        EntranceType r112 = new EntranceType("LIST_IMAGE_PREVIEW_EXPAND", 12, "list_image_preview_expand");
        LIST_IMAGE_PREVIEW_EXPAND = r112;
        EntranceType r113 = new EntranceType("FETCH_COMMENT_LIST", 13, "fetch_comment_list");
        FETCH_COMMENT_LIST = r113;
        EntranceType r114 = new EntranceType("SLICE_BIND_DATA", 14, "slice_bind_data");
        SLICE_BIND_DATA = r114;
        EntranceType r115 = new EntranceType("SLICE_ACTION_HANDLE", 15, "slice_action_handle");
        SLICE_ACTION_HANDLE = r115;
        f172594a = new EntranceType[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115};
    }

    public final String getType() {
        return this.type;
    }

    public EntranceType(String r100, int r101, String r102) {
        super(r100, r101);
        this.type = r102;
    }
}
