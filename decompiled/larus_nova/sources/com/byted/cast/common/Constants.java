package com.byted.cast.common;

import android.content.Context;

/* JADX INFO: loaded from: classes39.dex */
public class Constants {
    public static final int BDLINK_DEFAULT_PORT = 3530;
    public static final int BDLINK_DEFAULT_PORT_2 = 4530;
    public static final int BDLINK_DEFAULT_PORT_3 = 15550;
    public static final int[] BDLINK_DEFAULT_PORT_ARRAY = null;
    public static final String BYTECAST_DEFAULT_DEVICE_NAME = "ByteCast";
    public static final String DEMO_HOST_AID = "1013";
    public static final String DIVIDER = "_";
    public static final int DLNA_CUSTOMIZE_PROTOCOL_VERSION = 4;
    public static final int DLNA_DEFAULT_PORT = 4004;
    public static final String DLNA_SEARCH_TAG = "_DLNA_SEARCH";
    public static final String DLNA_START_PLAY_TAG = "_DLNA_START_PLAY";
    public static final String ENDASH = "-";
    public static final String ROLE_DEFAULT = "default";
    public static final String ROLE_SINK = "sink";
    public static final String ROLE_SOURCE = "source";
    public static final String SEARCH_TAG = "_SEARCH";
    public static final String SINK_AIRPLAY_VERSION_KEY = "com.ss.cast:sink-airplay";
    public static final String SINK_BDDLNA_VERSION_KEY = "com.ss.cast:sink-bddlna";
    public static final String SINK_BDLINK_VERSION_KEY = "com.ss.cast:sink-bdlink";
    public static final String SINK_BYTELINK_VERSION_KEY = "com.ss.cast:sink-mirror";
    public static final String SINK_CHROMECAST_VERSION_KEY = "com.ss.cast:sink-bdcloud";
    public static final String SINK_CLOUD_VERSION_KEY = "com.ss.cast:sink-bdcloud";
    public static final String SINK_DIAL_VERSION_KEY = "com.ss.cast:sink-dial";
    public static final String SINK_LELINK_VERSION_KEY = "com.hpplay.sdk:lesink";
    public static final String SINK_LINK_VERSION_KEY = "com.ss.cast:sink-link";
    public static final String SINK_MDNS_VERSION_KEY = "com.ss.cast:sink-mdns";
    public static final String SINK_USER_CUSTOM_INFO = "sink-user-custom-info";
    public static final String SOURCE_BDDLNA_VERSION_KEY = "com.ss.cast:source-bddlna";
    public static final String SOURCE_BDLINK_HAS_DEVICE_INFO = "source_bdlink_has_device_info";
    public static final String SOURCE_BDLINK_VERSION_KEY = "com.ss.cast:source-bdlink";
    public static final String SOURCE_BYTELINK_VERSION_KEY = "com.ss.cast:source-mirror";
    public static final String SOURCE_CHROMECAST_VERSION_KEY = "com.ss.cast:source-chromecast";
    public static final String SOURCE_CLOUD_VERSION_KEY = "com.ss.cast:source-bdcloud";
    public static final String SOURCE_LELINK_VERSION_KEY = "com.ss.cast:source-lelink";
    public static final String SOURCE_LELINK_WRAPPER_VERSION_KEY = "com.ss.cast:source-lelink-wrapper";
    public static final String SOURCE_LINK_VERSION_KEY = "com.ss.cast:source-link";
    public static final String SOURCE_USBSOURCE_VERSION_KEY = "com.ss.cast:UsbCastSource";
    public static final String SOURCE_VAST_VERSION_KEY = "com.ss.cast:vast_cast";
    public static final String START_PLAY_TAG = "_START_PLAY";
    public static boolean isDebugMode;
    public static Context sAppContext;
    public static ContextManager.CastContext sinkCastContext;

    static {
        BDLINK_DEFAULT_PORT_ARRAY = new int[]{BDLINK_DEFAULT_PORT, BDLINK_DEFAULT_PORT_2, BDLINK_DEFAULT_PORT_3};
        sinkCastContext = null;
    }

    public Constants() {
    }

    public static void attachAppContext(Context r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        sAppContext = r100.getApplicationContext();
    }
}
