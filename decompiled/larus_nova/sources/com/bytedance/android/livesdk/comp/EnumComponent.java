package com.bytedance.android.livesdk.comp;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/comp/EnumComponent;", "", "", "key", "Ljava/lang/String;", "getKey", "()Ljava/lang/String;", "PREVIEW_TOP_TYPE_TAB", "PREVIEW_TOP_TYPE_COMPANION", "PREVIEW_VIP_IM", "PREVIEW_VIP_IM_COMPANION", "PREVIEW_TOP_INFO_AREA", "PREVIEW_ANCHOR_COVER", "PREVIEW_ANCHOR_TITLE", "PREVIEW_ANCHOR_VISIBLE_SCOPE", "PREVIEW_ANCHOR_LOCATION", "PREVIEW_START_LIVE_CATEGORY", "PREVIEW_START_LIVE_CATEGORY_GAME", "PREVIEW_START_LIVE_BUTTON", "livecore-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum EnumComponent extends Enum<EnumComponent> {
    public static final EnumComponent PREVIEW_ANCHOR_COVER = null;
    public static final EnumComponent PREVIEW_ANCHOR_LOCATION = null;
    public static final EnumComponent PREVIEW_ANCHOR_TITLE = null;
    public static final EnumComponent PREVIEW_ANCHOR_VISIBLE_SCOPE = null;
    public static final EnumComponent PREVIEW_START_LIVE_BUTTON = null;
    public static final EnumComponent PREVIEW_START_LIVE_CATEGORY = null;
    public static final EnumComponent PREVIEW_START_LIVE_CATEGORY_GAME = null;
    public static final EnumComponent PREVIEW_TOP_INFO_AREA = null;
    public static final EnumComponent PREVIEW_TOP_TYPE_COMPANION = null;
    public static final EnumComponent PREVIEW_TOP_TYPE_TAB = null;
    public static final EnumComponent PREVIEW_VIP_IM = null;
    public static final EnumComponent PREVIEW_VIP_IM_COMPANION = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EnumComponent[] f119736a = null;
    private final String key;

    public static EnumComponent valueOf(String r100) {
        return (EnumComponent) a.a(EnumComponent.class, r100);
    }

    public static EnumComponent[] values() {
        return (EnumComponent[]) f119736a.clone();
    }

    static {
        EnumComponent r100 = new EnumComponent("PREVIEW_TOP_TYPE_TAB", 0, "preview_type_tab");
        PREVIEW_TOP_TYPE_TAB = r100;
        EnumComponent r101 = new EnumComponent("PREVIEW_TOP_TYPE_COMPANION", 1, "preview_type_tab_companion");
        PREVIEW_TOP_TYPE_COMPANION = r101;
        EnumComponent r102 = new EnumComponent("PREVIEW_VIP_IM", 2, "preview_vip_im");
        PREVIEW_VIP_IM = r102;
        EnumComponent r103 = new EnumComponent("PREVIEW_VIP_IM_COMPANION", 3, "preview_vip_im_companion");
        PREVIEW_VIP_IM_COMPANION = r103;
        EnumComponent r104 = new EnumComponent("PREVIEW_TOP_INFO_AREA", 4, "preview_top_info_area");
        PREVIEW_TOP_INFO_AREA = r104;
        EnumComponent r105 = new EnumComponent("PREVIEW_ANCHOR_COVER", 5, "preview_anchor_cover");
        PREVIEW_ANCHOR_COVER = r105;
        EnumComponent r106 = new EnumComponent("PREVIEW_ANCHOR_TITLE", 6, "preview_anchor_title");
        PREVIEW_ANCHOR_TITLE = r106;
        EnumComponent r107 = new EnumComponent("PREVIEW_ANCHOR_VISIBLE_SCOPE", 7, "preview_anchor_visible_scope");
        PREVIEW_ANCHOR_VISIBLE_SCOPE = r107;
        EnumComponent r108 = new EnumComponent("PREVIEW_ANCHOR_LOCATION", 8, "preview_anchor_location");
        PREVIEW_ANCHOR_LOCATION = r108;
        EnumComponent r109 = new EnumComponent("PREVIEW_START_LIVE_CATEGORY", 9, "preview_start_live_category");
        PREVIEW_START_LIVE_CATEGORY = r109;
        EnumComponent r110 = new EnumComponent("PREVIEW_START_LIVE_CATEGORY_GAME", 10, "preview_start_live_category_game");
        PREVIEW_START_LIVE_CATEGORY_GAME = r110;
        EnumComponent r111 = new EnumComponent("PREVIEW_START_LIVE_BUTTON", 11, "preview_start_live_button");
        PREVIEW_START_LIVE_BUTTON = r111;
        f119736a = new EnumComponent[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111};
    }

    public final String getKey() {
        return this.key;
    }

    public EnumComponent(String r100, int r101, String r102) {
        super(r100, r101);
        this.key = r102;
    }
}
