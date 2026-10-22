package com.bytedance.android.livesdkapi.config;

import com.bytedance.android.livesdkapi.depend.prefs.Property;

/* JADX INFO: loaded from: classes12.dex */
public interface HostProperties {
    public static final Property<Boolean> AGREE_DIAMOND_PROTOCOL = null;
    public static final Property<Boolean> CAN_PLAY_IN_MOBILE = null;
    public static final Property<Long> LAST_TIME_SHOW_MOBILE_NETWORK_TIP = null;
    public static final Property<Boolean> LIVE_FRAGMENT_OPEN = null;
    public static final Property<Boolean> MORE_CHARGE_REDDOT_SHOWN = null;
    public static final Property<Boolean> SETTING_LOADED = null;
    public static final Property<Boolean> SHOW_DEBUG_INFO = null;
    public static final String SP_LIVE_APP_CORE = "live-app-core";

    static {
        Boolean r100 = Boolean.FALSE;
        SHOW_DEBUG_INFO = new Property(SP_LIVE_APP_CORE, "show_debug_info", r100);
        CAN_PLAY_IN_MOBILE = new Property(SP_LIVE_APP_CORE, "play_in_mobile", r100);
        LIVE_FRAGMENT_OPEN = new Property("live_fragment_open", r100);
        SETTING_LOADED = new Property("setting_loaded", r100);
        LAST_TIME_SHOW_MOBILE_NETWORK_TIP = new Property("last_time_show_mobile_network_tip", 0L);
        AGREE_DIAMOND_PROTOCOL = new Property(SP_LIVE_APP_CORE, "agree_diamond_protocol_v2", Boolean.TRUE);
        MORE_CHARGE_REDDOT_SHOWN = new Property("more_charge_reddot_shown", r100);
    }
}
