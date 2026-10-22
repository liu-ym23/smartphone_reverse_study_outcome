package com.bytedance.android.ec.core.monitor;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b-\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.¨\u0006/"}, d2 = {"Lcom/bytedance/android/ec/core/monitor/MetricNames;", "", "", "metricNames", "Ljava/lang/String;", "getMetricNames", "()Ljava/lang/String;", "DURATION", "HEADER_DURATION", "INFO_DURATION", "PRELOAD_INFO_DURATION", "ZIP_DURATION", "TAB_DURATION", "API_DURATION", "API_DURATION_2ND", "RENDER_DURATION", "DEAL_DURATION", "POP_API_DURATION", "ENTER_ROOM_DURATION", "METRIC_CREATE_FRAGMENT_DURATION", "LIVE_PROMOTIONS_API_DURATION", "GET_API_DURATION", "POP_CARD_ANIM_DELAY_DURATION", "POP_CARD_ANIM_DURATION", "POP_API_PURE_DURATION", "POP_CARD_VISIBLE_DURATION", "POP_CARD_MAIN_IMAGE_VISIBLE_DURATION", "FIRST_FRAME_TIME", "HEADER_RENDER_DURATION", "ECOM_DRAWER_API_DURATION", "ECOM_DRAWER_API_PURE_DURATION", "ECOM_DRAWER_LOAD_API_DURATION", "ECOM_DRAWER_LOAD_API_PURE_DURATION", "LIVE_CART_REAL_SHOW_DURATION", "LIVE_CART_NEXT_FRAME_SHOW_DURATION", "LIVE_CART_REAL_RENDER_DURATION", "LIVE_CART_NEXT_FRAME_RENDER_DURATION", "LIVE_ENTER_ROOM_API_DURATION", "LIVE_PLAY_ENTER_SUCCEED", "LIVE_PLAY_PART_SHOW_INTERACTION", "LIVE_PLAY_SHOW_INTERACTION", "LIVE_INTERACTION_CREATE", "LIVE_INTERACTION_ACTIVITY_CREATE", "LIVE_INTERACTION_ENTER_ROOM", "LIVE_INTERACTION_RESUME", "LIVE_TOOLBAR_WIDGET_LOAD", "LIVE_TOOLBAR_MANAGER_ROOM_ENTER", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum MetricNames extends Enum<MetricNames> {
    public static final MetricNames API_DURATION = null;
    public static final MetricNames API_DURATION_2ND = null;
    public static final MetricNames DEAL_DURATION = null;
    public static final MetricNames DURATION = null;
    public static final MetricNames ECOM_DRAWER_API_DURATION = null;
    public static final MetricNames ECOM_DRAWER_API_PURE_DURATION = null;
    public static final MetricNames ECOM_DRAWER_LOAD_API_DURATION = null;
    public static final MetricNames ECOM_DRAWER_LOAD_API_PURE_DURATION = null;
    public static final MetricNames ENTER_ROOM_DURATION = null;
    public static final MetricNames FIRST_FRAME_TIME = null;
    public static final MetricNames GET_API_DURATION = null;
    public static final MetricNames HEADER_DURATION = null;
    public static final MetricNames HEADER_RENDER_DURATION = null;
    public static final MetricNames INFO_DURATION = null;
    public static final MetricNames LIVE_CART_NEXT_FRAME_RENDER_DURATION = null;
    public static final MetricNames LIVE_CART_NEXT_FRAME_SHOW_DURATION = null;
    public static final MetricNames LIVE_CART_REAL_RENDER_DURATION = null;
    public static final MetricNames LIVE_CART_REAL_SHOW_DURATION = null;
    public static final MetricNames LIVE_ENTER_ROOM_API_DURATION = null;
    public static final MetricNames LIVE_INTERACTION_ACTIVITY_CREATE = null;
    public static final MetricNames LIVE_INTERACTION_CREATE = null;
    public static final MetricNames LIVE_INTERACTION_ENTER_ROOM = null;
    public static final MetricNames LIVE_INTERACTION_RESUME = null;
    public static final MetricNames LIVE_PLAY_ENTER_SUCCEED = null;
    public static final MetricNames LIVE_PLAY_PART_SHOW_INTERACTION = null;
    public static final MetricNames LIVE_PLAY_SHOW_INTERACTION = null;
    public static final MetricNames LIVE_PROMOTIONS_API_DURATION = null;
    public static final MetricNames LIVE_TOOLBAR_MANAGER_ROOM_ENTER = null;
    public static final MetricNames LIVE_TOOLBAR_WIDGET_LOAD = null;
    public static final MetricNames METRIC_CREATE_FRAGMENT_DURATION = null;
    public static final MetricNames POP_API_DURATION = null;
    public static final MetricNames POP_API_PURE_DURATION = null;
    public static final MetricNames POP_CARD_ANIM_DELAY_DURATION = null;
    public static final MetricNames POP_CARD_ANIM_DURATION = null;
    public static final MetricNames POP_CARD_MAIN_IMAGE_VISIBLE_DURATION = null;
    public static final MetricNames POP_CARD_VISIBLE_DURATION = null;
    public static final MetricNames PRELOAD_INFO_DURATION = null;
    public static final MetricNames RENDER_DURATION = null;
    public static final MetricNames TAB_DURATION = null;
    public static final MetricNames ZIP_DURATION = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MetricNames[] f45123a = null;
    private final String metricNames;

    public static MetricNames valueOf(String r100) {
        return (MetricNames) r27.a.a(MetricNames.class, r100);
    }

    public static MetricNames[] values() {
        return (MetricNames[]) f45123a.clone();
    }

    static {
        MetricNames r100 = new MetricNames("DURATION", 0, "duration");
        DURATION = r100;
        MetricNames r101 = new MetricNames("HEADER_DURATION", 1, "header_duration");
        HEADER_DURATION = r101;
        MetricNames r102 = new MetricNames("INFO_DURATION", 2, "info_duration");
        INFO_DURATION = r102;
        MetricNames r103 = new MetricNames("PRELOAD_INFO_DURATION", 3, "preload_info_duration");
        PRELOAD_INFO_DURATION = r103;
        MetricNames r104 = new MetricNames("ZIP_DURATION", 4, "zip_duration");
        ZIP_DURATION = r104;
        MetricNames r105 = new MetricNames("TAB_DURATION", 5, "tab_duration");
        TAB_DURATION = r105;
        MetricNames r106 = new MetricNames("API_DURATION", 6, com.bytedance.android.ec.core.event.a.KEY_API_DURATION);
        API_DURATION = r106;
        MetricNames r107 = new MetricNames("API_DURATION_2ND", 7, "api_duration_2nd");
        API_DURATION_2ND = r107;
        MetricNames r108 = new MetricNames("RENDER_DURATION", 8, "render_duration");
        RENDER_DURATION = r108;
        MetricNames r109 = new MetricNames("DEAL_DURATION", 9, "deal_duration");
        DEAL_DURATION = r109;
        MetricNames r110 = new MetricNames("POP_API_DURATION", 10, "pop_api_duration");
        POP_API_DURATION = r110;
        MetricNames r111 = new MetricNames("ENTER_ROOM_DURATION", 11, "enter_ec_room_duration");
        ENTER_ROOM_DURATION = r111;
        MetricNames r112 = new MetricNames("METRIC_CREATE_FRAGMENT_DURATION", 12, "create_fragment_duration");
        METRIC_CREATE_FRAGMENT_DURATION = r112;
        MetricNames r113 = new MetricNames("LIVE_PROMOTIONS_API_DURATION", 13, "live_promotions_api_duration");
        LIVE_PROMOTIONS_API_DURATION = r113;
        MetricNames r114 = new MetricNames("GET_API_DURATION", 14, "get_api_duration");
        GET_API_DURATION = r114;
        MetricNames r115 = new MetricNames("POP_CARD_ANIM_DELAY_DURATION", 15, "anim_delay_duration");
        POP_CARD_ANIM_DELAY_DURATION = r115;
        MetricNames r116 = new MetricNames("POP_CARD_ANIM_DURATION", 16, "anim_duration");
        POP_CARD_ANIM_DURATION = r116;
        MetricNames r117 = new MetricNames("POP_API_PURE_DURATION", 17, "pop_api_pure_duration");
        POP_API_PURE_DURATION = r117;
        MetricNames r118 = new MetricNames("POP_CARD_VISIBLE_DURATION", 18, "card_visible_duration");
        POP_CARD_VISIBLE_DURATION = r118;
        MetricNames r119 = new MetricNames("POP_CARD_MAIN_IMAGE_VISIBLE_DURATION", 19, "main_image_visible_duration");
        POP_CARD_MAIN_IMAGE_VISIBLE_DURATION = r119;
        MetricNames r120 = new MetricNames("FIRST_FRAME_TIME", 20, "first_frame_time");
        FIRST_FRAME_TIME = r120;
        MetricNames r121 = new MetricNames("HEADER_RENDER_DURATION", 21, "header_render_duration");
        HEADER_RENDER_DURATION = r121;
        MetricNames r122 = new MetricNames("ECOM_DRAWER_API_DURATION", 22, "ecom_drawer_api_duration");
        ECOM_DRAWER_API_DURATION = r122;
        MetricNames r123 = new MetricNames("ECOM_DRAWER_API_PURE_DURATION", 23, "ecom_drawer_api_pure_duration");
        ECOM_DRAWER_API_PURE_DURATION = r123;
        MetricNames r124 = new MetricNames("ECOM_DRAWER_LOAD_API_DURATION", 24, "ecom_drawer_load_api_duration");
        ECOM_DRAWER_LOAD_API_DURATION = r124;
        MetricNames r125 = new MetricNames("ECOM_DRAWER_LOAD_API_PURE_DURATION", 25, "ecom_drawer_load_api_pure_duration");
        ECOM_DRAWER_LOAD_API_PURE_DURATION = r125;
        MetricNames r126 = new MetricNames("LIVE_CART_REAL_SHOW_DURATION", 26, "real_duration");
        LIVE_CART_REAL_SHOW_DURATION = r126;
        MetricNames r127 = new MetricNames("LIVE_CART_NEXT_FRAME_SHOW_DURATION", 27, "next_frame_duration");
        LIVE_CART_NEXT_FRAME_SHOW_DURATION = r127;
        MetricNames r128 = new MetricNames("LIVE_CART_REAL_RENDER_DURATION", 28, "real_render_duration");
        LIVE_CART_REAL_RENDER_DURATION = r128;
        MetricNames r129 = new MetricNames("LIVE_CART_NEXT_FRAME_RENDER_DURATION", 29, "next_frame_render_duration");
        LIVE_CART_NEXT_FRAME_RENDER_DURATION = r129;
        MetricNames r130 = new MetricNames("LIVE_ENTER_ROOM_API_DURATION", 30, "enter_room_api_duration");
        LIVE_ENTER_ROOM_API_DURATION = r130;
        MetricNames r131 = new MetricNames("LIVE_PLAY_ENTER_SUCCEED", 31, "play_enter_succeed");
        LIVE_PLAY_ENTER_SUCCEED = r131;
        MetricNames r132 = new MetricNames("LIVE_PLAY_PART_SHOW_INTERACTION", 32, "play_part_show_interaction");
        LIVE_PLAY_PART_SHOW_INTERACTION = r132;
        MetricNames r133 = new MetricNames("LIVE_PLAY_SHOW_INTERACTION", 33, "play_show_interaction");
        LIVE_PLAY_SHOW_INTERACTION = r133;
        MetricNames r134 = new MetricNames("LIVE_INTERACTION_CREATE", 34, "interaction_create");
        LIVE_INTERACTION_CREATE = r134;
        MetricNames r135 = new MetricNames("LIVE_INTERACTION_ACTIVITY_CREATE", 35, "interaction_activity_create");
        LIVE_INTERACTION_ACTIVITY_CREATE = r135;
        MetricNames r136 = new MetricNames("LIVE_INTERACTION_ENTER_ROOM", 36, "interaction_enter_room");
        LIVE_INTERACTION_ENTER_ROOM = r136;
        MetricNames r137 = new MetricNames("LIVE_INTERACTION_RESUME", 37, "interaction_resume");
        LIVE_INTERACTION_RESUME = r137;
        MetricNames r138 = new MetricNames("LIVE_TOOLBAR_WIDGET_LOAD", 38, "toolbar_widget_load");
        LIVE_TOOLBAR_WIDGET_LOAD = r138;
        MetricNames r139 = new MetricNames("LIVE_TOOLBAR_MANAGER_ROOM_ENTER", 39, "toolbar_manager_room_enter");
        LIVE_TOOLBAR_MANAGER_ROOM_ENTER = r139;
        f45123a = new MetricNames[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133, r134, r135, r136, r137, r138, r139};
    }

    public final String getMetricNames() {
        return this.metricNames;
    }

    public MetricNames(String r100, int r101, String r102) {
        super(r100, r101);
        this.metricNames = r102;
    }
}
