package com.byted.cast.common.config;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes39.dex */
public final class PresetCastConfig {
    private PresetCastConfig() {
    }

    public static Map<String, Object> generateDefaultSinkPresetCastConfig() {
        HashMap r100 = new HashMap();
        Boolean r101 = Boolean.FALSE;
        r100.put(ConfigConstants.FEATURE_DNSSD_SWITCH, r101);
        r100.put(ConfigConstants.FEATURE_JMDNS_SWITCH, r101);
        r100.put(ConfigConstants.FEATURE_BLE_SWITCH, r101);
        Boolean r102 = Boolean.TRUE;
        r100.put(ConfigConstants.FEATURE_BDLINK_SINK_SSDP_SERVER, r102);
        r100.put(ConfigConstants.FEATURE_SINK_BDLINK_SSDP_BROADCAST, r102);
        return r100;
    }

    public static Map<String, Object> generateDefaultSourcePresetCastConfig() {
        HashMap r100 = new HashMap();
        Boolean r101 = Boolean.FALSE;
        r100.put(ConfigConstants.FEATURE_DNSSD_SWITCH, r101);
        r100.put(ConfigConstants.FEATURE_JMDNS_SWITCH, r101);
        r100.put(ConfigConstants.FEATURE_BLE_SWITCH, r101);
        r100.put(ConfigConstants.FEATURE_DLNA_CACHE, r101);
        r100.put(ConfigConstants.FEATURE_DLNA_SEARCH, r101);
        Boolean r102 = Boolean.TRUE;
        r100.put(ConfigConstants.FEATURE_DLNA_BROADCAST_SEARCH, r102);
        r100.put(ConfigConstants.FEATURE_DEVICE_OFFLINE, r102);
        r100.put(ConfigConstants.FEATURE_DLNA_DEVICE_OFFLINE_INTERVAL, 30);
        r100.put(ConfigConstants.FEATURE_BDLINK_DEVICE_OFFLINE_INTERVAL, 30);
        r100.put(ConfigConstants.FEATURE_BDLINK_ENABLE_QUICK_QUERY, r102);
        r100.put(ConfigConstants.FEATURE_BDLINK_ENABLE_DISK_CACHE, r102);
        r100.put(ConfigConstants.FEATURE_BDLINK_SSDP_SEARCH_SWITCH, r101);
        r100.put(ConfigConstants.FEATURE_BDLINK_SSDP_CYCLE_SEARCH_SWITCH, r101);
        r100.put(ConfigConstants.FEATURE_BDLINK_SOURCE_IPV6_SWITCH, r101);
        r100.put(ConfigConstants.FEATURE_DLNA_SOURCE_IPV6_SWITCH, r101);
        r100.put(ConfigConstants.FEATURE_SOURCE_BDLINK_SSDP_BROADCAST, r102);
        r100.put(ConfigConstants.FEATURE_DLNA_SOURCE_NEW_DEVICE_OFFLINE, r102);
        return r100;
    }
}
