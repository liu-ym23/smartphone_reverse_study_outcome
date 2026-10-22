package com.byted.cast.common.utils;

import android.text.TextUtils;
import com.byted.cast.common.ContextManager;
import com.byted.cast.common.bean.ConnectStatusSetting;
import com.byted.cast.common.bean.DeviceOfflineDetectSettings;
import com.byted.cast.common.bean.DlnaCycleSearchSettings;
import com.byted.cast.common.bean.DlnaUpnpErrorRepushSetting;
import com.byted.cast.common.bean.GetPositionSetting;
import com.byted.cast.common.bean.GetStateSetting;
import com.byted.cast.common.config.ConfigConstants;
import com.byted.cast.common.config.ConfigManager;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;

/* JADX INFO: loaded from: classes39.dex */
public class DLNAOptionUtils {
    private static final String TAG = null;

    public DLNAOptionUtils() {
    }

    public static long getBdlinkDeviceOfflineDetectInterval() {
        return getBdlinkDeviceOfflineDetectInterval(null);
    }

    public static int getDlnaOfflineInterval() {
        return getDlnaOfflineInterval(null);
    }

    public static boolean isEnableBdlinkDiskCache() {
        return isEnableBdlinkDiskCache(null);
    }

    public static boolean isEnableBdlinkQuickQuery() {
        return isEnableBdlinkQuickQuery(null);
    }

    public static boolean isEnableBroadcastSearch() {
        return isEnableBroadcastSearch(null);
    }

    public static boolean isEnableCache() {
        return isEnableCache(null);
    }

    public static boolean isEnableDeviceOffline() {
        return isEnableDeviceOffline(null);
    }

    public static boolean isEnableMdnsSearch() {
        return isEnableMdnsSearch(null);
    }

    public static boolean isEnableSearch() {
        if (isEnableSearch(null) == false) goto L5;
    L8:
        return true;
    L5:
        if (isEnableDlnaCycleSearch(null) == true) goto L8;
        return false;
    }

    public static boolean isEnableSinkSsdpServer() {
        return isEnableSinkSsdpServer(null);
    }

    public static boolean isEnableSsdpCycleSearch() {
        return isEnableSsdpCycleSearch(null);
    }

    public static boolean isEnableSsdpSearch() {
        return isEnableSsdpSearch(null);
    }

    static {
        TAG = "DLNAOptionUtils";
    }

    public static int getDlnaSinkNotifyInterval() {
        return ConfigManager.getInstance().getInitConfig().getDlnaSinkNotifyInterval();
    }

    public static boolean isOpenDlnaLowPerformanceMode() {
        return ConfigManager.getInstance().getInitConfig().getDlnaLowPerformanceMode();
    }

    public static boolean enableDlnaUserAgent(ContextManager.CastContext r100) {
        if (r100 != null) goto L4;
        ConfigManager r101 = ConfigManager.getInstance();
    L6:
        return r101.getInitConfig().isEnableDlnaUserAgent();
    L4:
        r101 = ContextManager.getConfigManager(r100);
        goto L6
    }

    public static long getBdlinkDeviceOfflineDetectInterval(ContextManager.CastContext r100) {
        if (r100 != null) goto L4;
        ConfigManager r101 = ConfigManager.getInstance();
    L5:
        DeviceOfflineDetectSettings r102 = r101.getInitConfig().getDeviceOfflineDetectSettings();
        if (r102 == null) goto L10;
        long r103 = r102.getDetectIntervalMills();
        if (r103 <= 0) goto L10;
        return r103;
    L10:
        Object r104 = r101.getLocalGrayConfig(ConfigConstants.FEATURE_BDLINK_DEVICE_OFFLINE_INTERVAL);
    L16:
        e = move-exception;
        e.printStackTrace();
        return 30000;
    L12:
        if ((r104 instanceof String) == false) goto L22;
        return ((long) CastIntegerProtector.parseInt((String) r104)) * 1000;
    L22:
        return 30000;
    L4:
        r101 = ContextManager.getConfigManager(r100);
        goto L5
    }

    public static int getDlnaCycleSearchCount(ContextManager.CastContext r100) {
        if (r100 != null) goto L4;
        ConfigManager r101 = ConfigManager.getInstance();
    L5:
        DlnaCycleSearchSettings r102 = r101.getInitConfig().getDlnaCycleSearchSettings();
        if (r102 == null) goto L10;
        int r103 = r102.getCycleSearchCount();
        if (r103 <= 0) goto L12;
        return r103;
    L12:
        return 0;
    L10:
        return 0;
    L4:
        r101 = ContextManager.getConfigManager(r100);
        goto L5
    }

    public static int getDlnaCycleSearchInterval(ContextManager.CastContext r100) {
        if (r100 != null) goto L4;
        ConfigManager r101 = ConfigManager.getInstance();
    L5:
        DlnaCycleSearchSettings r102 = r101.getInitConfig().getDlnaCycleSearchSettings();
        if (r102 == null) goto L10;
        int r103 = r102.getCycleSearchInterval();
        if (r103 <= 0) goto L12;
        return r103;
    L12:
        return 5;
    L10:
        return 5;
    L4:
        r101 = ContextManager.getConfigManager(r100);
        goto L5
    }

    public static int getDlnaDetectDeviceMode(ContextManager.CastContext r100) {
        if (r100 != null) goto L4;
        ConfigManager r101 = ConfigManager.getInstance();
    L6:
        return r101.getInitConfig().getDlnaDetectDeviceMode();
    L4:
        r101 = ContextManager.getConfigManager(r100);
        goto L6
    }

    public static int getDlnaOfflineInterval(ContextManager.CastContext r100) {
        if (r100 != null) goto L4;
        ConfigManager r101 = ConfigManager.getInstance();
    L5:
        Object r102 = r101.getLocalGrayConfig(ConfigConstants.FEATURE_DLNA_DEVICE_OFFLINE_INTERVAL);
    L10:
        e = move-exception;
        e.printStackTrace();
        return 60;
    L7:
        if ((r102 instanceof String) == false) goto L16;
        return CastIntegerProtector.parseInt((String) r102);
    L16:
        return 60;
    L4:
        r101 = ContextManager.getConfigManager(r100);
        goto L5
    }

    public static String[] getDlnaUpnpErrorRepushFriendlyNameList(ContextManager.CastContext r100) {
        if (r100 != null) goto L4;
        ConfigManager r101 = ConfigManager.getInstance();
    L5:
        DlnaUpnpErrorRepushSetting r102 = r101.getInitConfig().getDlnaUpnpErrorRepushSetting();
        if (r102 == null) goto L11;
        String r103 = r102.getFriendlyNameList();
        if (TextUtils.isEmpty(r103) == false) goto L10;
        return null;
    L10:
        return r103.split(",");
    L11:
        return null;
    L4:
        r101 = ContextManager.getConfigManager(r100);
        goto L5
    }

    public static String[] getDlnaUpnpErrorRepushManuList(ContextManager.CastContext r100) {
        if (r100 != null) goto L4;
        ConfigManager r101 = ConfigManager.getInstance();
    L5:
        DlnaUpnpErrorRepushSetting r102 = r101.getInitConfig().getDlnaUpnpErrorRepushSetting();
        if (r102 == null) goto L11;
        String r103 = r102.getManufactureList();
        if (TextUtils.isEmpty(r103) == false) goto L10;
        return null;
    L10:
        return r103.split(",");
    L11:
        return null;
    L4:
        r101 = ContextManager.getConfigManager(r100);
        goto L5
    }

    public static int getDlnaUpnpErrorRepushMode(ContextManager.CastContext r100) {
        if (r100 != null) goto L4;
        ConfigManager r101 = ConfigManager.getInstance();
    L5:
        DlnaUpnpErrorRepushSetting r102 = r101.getInitConfig().getDlnaUpnpErrorRepushSetting();
        if (r102 != null) goto L8;
        return 0;
    L8:
        return r102.getRepushMode();
    L4:
        r101 = ContextManager.getConfigManager(r100);
        goto L5
    }

    public static int getFirstQueryStateDelayTime(ContextManager.CastContext r100) {
        if (r100 != null) goto L4;
        ConfigManager r101 = ConfigManager.getInstance();
    L5:
        GetStateSetting r102 = r101.getInitConfig().getGetStateSetting();
        if (r102 != null) goto L8;
        return 500;
    L8:
        if (r102.getFirstQueryStateDelayTime() >= 0) goto L10;
        return 500;
    L10:
        return r102.getFirstQueryStateDelayTime();
    L4:
        r101 = ContextManager.getConfigManager(r100);
        goto L5
    }

    public static int getQueryStateErrorRetryCount(ContextManager.CastContext r100) {
        if (r100 != null) goto L4;
        ConfigManager r101 = ConfigManager.getInstance();
    L5:
        GetStateSetting r102 = r101.getInitConfig().getGetStateSetting();
        if (r102 != null) goto L8;
        return 10;
    L8:
        if (r102.getQueryStateErrorRetryCount() >= 0) goto L10;
        return 10;
    L10:
        return r102.getQueryStateErrorRetryCount();
    L4:
        r101 = ContextManager.getConfigManager(r100);
        goto L5
    }

    public static int getQueryStateInterval(ContextManager.CastContext r100) {
        if (r100 != null) goto L4;
        ConfigManager r101 = ConfigManager.getInstance();
    L5:
        GetStateSetting r102 = r101.getInitConfig().getGetStateSetting();
        if (r102 != null) goto L8;
        return 1000;
    L8:
        if (r102.getQueryStateInterval() >= 500) goto L10;
        return 500;
    L10:
        return r102.getQueryStateInterval();
    L4:
        r101 = ContextManager.getConfigManager(r100);
        goto L5
    }

    public static int getQueryStopStateRetryCount(ContextManager.CastContext r100) {
        if (r100 != null) goto L4;
        ConfigManager r101 = ConfigManager.getInstance();
    L5:
        GetStateSetting r102 = r101.getInitConfig().getGetStateSetting();
        if (r102 != null) goto L8;
        return 10;
    L8:
        if (r102.getQueryStopStateRetryCount() >= 0) goto L10;
        return 10;
    L10:
        return r102.getQueryStopStateRetryCount();
    L4:
        r101 = ContextManager.getConfigManager(r100);
        goto L5
    }

    public static int getSendMsgFailedCount(ContextManager.CastContext r100) {
        if (r100 != null) goto L4;
        ConfigManager r101 = ConfigManager.getInstance();
    L5:
        ConnectStatusSetting r102 = r101.getInitConfig().getConnectStatusSetting();
        if (r102 != null) goto L8;
        return 3;
    L8:
        return r102.getSendMsgFailedCount();
    L4:
        r101 = ContextManager.getConfigManager(r100);
        goto L5
    }

    public static boolean isAlwaysSearch(ContextManager.CastContext r100) {
        if (r100 != null) goto L4;
        ConfigManager r101 = ConfigManager.getInstance();
    L5:
        DlnaCycleSearchSettings r102 = r101.getInitConfig().getDlnaCycleSearchSettings();
        if (r102 != null) goto L8;
        return false;
    L8:
        if (r102.getCycleSearchCount() >= 0) goto L13;
        return true;
    L13:
        return false;
    L4:
        r101 = ContextManager.getConfigManager(r100);
        goto L5
    }

    public static boolean isEnableAddConnectStatus(ContextManager.CastContext r100) {
        if (r100 != null) goto L4;
        ConfigManager r101 = ConfigManager.getInstance();
    L5:
        ConnectStatusSetting r102 = r101.getInitConfig().getConnectStatusSetting();
        if (r102 != null) goto L8;
        return false;
    L8:
        return r102.isEnableAddConnectStatus();
    L4:
        r101 = ContextManager.getConfigManager(r100);
        goto L5
    }

    public static boolean isEnableBdLePrivateProtocol(ContextManager.CastContext r100) {
        if (r100 != null) goto L4;
        ConfigManager r101 = ConfigManager.getInstance();
    L6:
        return r101.getInitConfig().isEnableBdLePrivateProtocol();
    L4:
        r101 = ContextManager.getConfigManager(r100);
        goto L6
    }

    public static boolean isEnableBdlinkDiskCache(ContextManager.CastContext r100) {
        if (r100 != null) goto L4;
        ConfigManager r101 = ConfigManager.getInstance();
    L6:
        return r101.getLocalGrayConfigByBoolean(ConfigConstants.FEATURE_BDLINK_ENABLE_DISK_CACHE, false);
    L4:
        r101 = ContextManager.getConfigManager(r100);
        goto L6
    }

    public static boolean isEnableBdlinkQuickQuery(ContextManager.CastContext r100) {
        if (r100 != null) goto L4;
        ConfigManager r101 = ConfigManager.getInstance();
    L6:
        return r101.getLocalGrayConfigByBoolean(ConfigConstants.FEATURE_BDLINK_ENABLE_QUICK_QUERY, false);
    L4:
        r101 = ContextManager.getConfigManager(r100);
        goto L6
    }

    public static boolean isEnableBroadcastSearch(ContextManager.CastContext r100) {
        if (r100 != null) goto L4;
        ConfigManager r101 = ConfigManager.getInstance();
    L5:
        Boolean r102 = r101.getInitConfig().isEnableDLNABroadCast();
        if (r102 != null) goto L8;
        Boolean r103 = r101.getOptionByBoolean(10043);
        if (r103 != null) goto L14;
        return r101.getLocalGrayConfigByBoolean(ConfigConstants.FEATURE_DLNA_BROADCAST_SEARCH, false);
    L14:
        return r103.booleanValue();
    L8:
        return r102.booleanValue();
    L4:
        r101 = ContextManager.getConfigManager(r100);
        goto L5
    }

    public static boolean isEnableCache(ContextManager.CastContext r100) {
        if (r100 != null) goto L4;
        ConfigManager r101 = ConfigManager.getInstance();
    L5:
        Boolean r102 = r101.getInitConfig().isEnableDLNACache();
        if (r102 != null) goto L8;
        Boolean r103 = r101.getOptionByBoolean(10037);
        if (r103 != null) goto L14;
        return r101.getLocalGrayConfigByBoolean(ConfigConstants.FEATURE_DLNA_CACHE, false);
    L14:
        return r103.booleanValue();
    L8:
        return r102.booleanValue();
    L4:
        r101 = ContextManager.getConfigManager(r100);
        goto L5
    }

    public static boolean isEnableDeviceOffline(ContextManager.CastContext r100) {
        if (r100 != null) goto L4;
        ConfigManager r101 = ConfigManager.getInstance();
    L5:
        DeviceOfflineDetectSettings r102 = r101.getInitConfig().getDeviceOfflineDetectSettings();
        if (r102 == null) goto L10;
        return r102.isEnableDetect();
    L10:
        return r101.getLocalGrayConfigByBoolean(ConfigConstants.FEATURE_DEVICE_OFFLINE, false);
    L4:
        r101 = ContextManager.getConfigManager(r100);
        goto L5
    }

    private static boolean isEnableDlnaCycleSearch(ContextManager.CastContext r100) {
        if (r100 != null) goto L4;
        ConfigManager r101 = ConfigManager.getInstance();
    L5:
        DlnaCycleSearchSettings r102 = r101.getInitConfig().getDlnaCycleSearchSettings();
        if (r102 != null) goto L8;
        return false;
    L8:
        return r102.isEnableCycleSearch();
    L4:
        r101 = ContextManager.getConfigManager(r100);
        goto L5
    }

    public static boolean isEnableDlnaSearch(ContextManager.CastContext r100) {
        if (isEnableSearch(r100) == false) goto L5;
    L8:
        return true;
    L5:
        if (isEnableDlnaCycleSearch(r100) == true) goto L8;
        return false;
    }

    public static boolean isEnableDlnaSinkCustomizedService(ContextManager.CastContext r100) {
        if (r100 != null) goto L4;
        ConfigManager r101 = ConfigManager.getInstance();
    L5:
        Boolean r102 = r101.getInitConfig().isEnableDlnaSinkCustomizedService();
        if (r102 != null) goto L8;
        return false;
    L8:
        return r102.booleanValue();
    L4:
        r101 = ContextManager.getConfigManager(r100);
        goto L5
    }

    public static boolean isEnableDlnaSourceCustomizedService(ContextManager.CastContext r100) {
        if (r100 != null) goto L4;
        ConfigManager r101 = ConfigManager.getInstance();
    L5:
        Boolean r102 = r101.getInitConfig().isEnableDlnaSourceCustomizedService();
        if (r102 != null) goto L8;
        return false;
    L8:
        return r102.booleanValue();
    L4:
        r101 = ContextManager.getConfigManager(r100);
        goto L5
    }

    public static boolean isEnableFindDeviceByName(ContextManager.CastContext r100) {
        if (r100 != null) goto L4;
        ConfigManager r101 = ConfigManager.getInstance();
    L6:
        return r101.getInitConfig().isEnableFindDeviceByName();
    L4:
        r101 = ContextManager.getConfigManager(r100);
        goto L6
    }

    public static boolean isEnableMdnsSearch(ContextManager.CastContext r100) {
        if (r100 != null) goto L4;
        ConfigManager r101 = ConfigManager.getInstance();
    L5:
        Boolean r102 = r101.getOptionByBoolean(10082);
        ContextManager.getLogger(r100).d(TAG, "localEnableMdnsSearch is : " + r102);
        if (r102 != null) goto L10;
        return true;
    L10:
        return r102.booleanValue();
    L4:
        r101 = ContextManager.getConfigManager(r100);
        goto L5
    }

    public static boolean isEnableNewDlnaDeviceOffline(ContextManager.CastContext r100) {
        if (r100 != null) goto L4;
        ConfigManager r101 = ConfigManager.getInstance();
    L5:
        Boolean r102 = r101.getInitConfig().isEnableNewDlnaDeviceOffline();
        if (r102 == null) goto L10;
        return r102.booleanValue();
    L10:
        return r101.getLocalGrayConfigByBoolean(ConfigConstants.FEATURE_DLNA_SOURCE_NEW_DEVICE_OFFLINE, false);
    L4:
        r101 = ContextManager.getConfigManager(r100);
        goto L5
    }

    public static boolean isEnableNewSeekLogic(ContextManager.CastContext r100) {
        if (r100 != null) goto L4;
        ConfigManager r101 = ConfigManager.getInstance();
    L6:
        return r101.getInitConfig().isEnableNewSeekLogic();
    L4:
        r101 = ContextManager.getConfigManager(r100);
        goto L6
    }

    public static boolean isEnablePrivateProtPlayOpt(ContextManager.CastContext r100) {
        return ContextManager.getConfigManager(r100).getInitConfig().isEnablePrivateProtPlayOpt();
    }

    private static boolean isEnableSearch(ContextManager.CastContext r100) {
        if (r100 != null) goto L4;
        ConfigManager r101 = ConfigManager.getInstance();
    L5:
        Boolean r102 = r101.getInitConfig().isEnableDLNASearch();
        if (r102 != null) goto L8;
        Boolean r103 = r101.getOptionByBoolean(10038);
        if (r103 != null) goto L14;
        return r101.getLocalGrayConfigByBoolean(ConfigConstants.FEATURE_DLNA_SEARCH, false);
    L14:
        return r103.booleanValue();
    L8:
        return r102.booleanValue();
    L4:
        r101 = ContextManager.getConfigManager(r100);
        goto L5
    }

    public static boolean isEnableSinkBDLinkSSDPBroadcast(ContextManager.CastContext r100) {
        if (r100 != null) goto L4;
        ConfigManager r101 = ConfigManager.getInstance();
    L5:
        Boolean r102 = r101.getInitConfig().isEnableBDLinkSinkBroadcast();
        if (r102 == null) goto L10;
        return r102.booleanValue();
    L10:
        return r101.getLocalGrayConfigByBoolean(ConfigConstants.FEATURE_SINK_BDLINK_SSDP_BROADCAST, false);
    L4:
        r101 = ContextManager.getConfigManager(r100);
        goto L5
    }

    public static boolean isEnableSinkDlnaUdpBroadcast(ContextManager.CastContext r100) {
        if (r100 != null) goto L4;
        ConfigManager r101 = ConfigManager.getInstance();
    L6:
        return r101.getInitConfig().isEnableSinkDlnaUdpBroadcast();
    L4:
        r101 = ContextManager.getConfigManager(r100);
        goto L6
    }

    public static boolean isEnableSinkSsdpServer(ContextManager.CastContext r100) {
        if (r100 != null) goto L4;
        ConfigManager r101 = ConfigManager.getInstance();
    L5:
        Boolean r102 = r101.getInitConfig().isEnableBDLinkSinkSSDPSwitch();
        if (r102 != null) goto L10;
        return r101.getLocalGrayConfigByBoolean(ConfigConstants.FEATURE_BDLINK_SINK_SSDP_SERVER, false);
    L10:
        return r102.booleanValue();
    L4:
        r101 = ContextManager.getConfigManager(r100);
        goto L5
    }

    public static boolean isEnableSourceBDLinkIpv6(ContextManager.CastContext r100) {
        Boolean r101 = ConfigManager.getInstance().getOptionByBoolean(10084);
        ContextManager.getLogger(r100).d(TAG, "localEnableBDLinkIpv6 is : " + r101);
        if (r101 != null) goto L7;
        return ConfigManager.getInstance().getLocalGrayConfigByBoolean(ConfigConstants.FEATURE_BDLINK_SOURCE_IPV6_SWITCH, true);
    L7:
        return r101.booleanValue();
    }

    public static boolean isEnableSourceBDLinkSSDPBroadcast(ContextManager.CastContext r100) {
        if (r100 != null) goto L4;
        ConfigManager r101 = ConfigManager.getInstance();
    L5:
        Boolean r102 = r101.getInitConfig().isEnableBDLinkSourceBroadcast();
        if (r102 == null) goto L10;
        return r102.booleanValue();
    L10:
        return r101.getLocalGrayConfigByBoolean(ConfigConstants.FEATURE_SOURCE_BDLINK_SSDP_BROADCAST, false);
    L4:
        r101 = ContextManager.getConfigManager(r100);
        goto L5
    }

    public static boolean isEnableSourceDlnaIpv6(ContextManager.CastContext r100) {
        Boolean r101 = ConfigManager.getInstance().getOptionByBoolean(10084);
        if (r101 != null) goto L7;
        return ConfigManager.getInstance().getLocalGrayConfigByBoolean(ConfigConstants.FEATURE_DLNA_SOURCE_IPV6_SWITCH, false);
    L7:
        return r101.booleanValue();
    }

    public static boolean isEnableSsdpCycleSearch(ContextManager.CastContext r100) {
        if (r100 != null) goto L4;
        ConfigManager r101 = ConfigManager.getInstance();
    L5:
        Boolean r102 = r101.getInitConfig().isEnableBDLinkSSDPCycleSearch();
        if (r102 != null) goto L10;
        return r101.getLocalGrayConfigByBoolean(ConfigConstants.FEATURE_BDLINK_SSDP_CYCLE_SEARCH_SWITCH, false);
    L10:
        return r102.booleanValue();
    L4:
        r101 = ContextManager.getConfigManager(r100);
        goto L5
    }

    public static boolean isEnableSsdpSearch(ContextManager.CastContext r100) {
        if (r100 != null) goto L4;
        ConfigManager r101 = ConfigManager.getInstance();
    L5:
        Boolean r102 = r101.getInitConfig().isEnableBDLinkSSDPSwitch();
        if (r102 != null) goto L10;
        return r101.getLocalGrayConfigByBoolean(ConfigConstants.FEATURE_BDLINK_SSDP_SEARCH_SWITCH, false);
    L10:
        return r102.booleanValue();
    L4:
        r101 = ContextManager.getConfigManager(r100);
        goto L5
    }

    public static boolean isShouldStopPositionTaskBeforePlay(ContextManager.CastContext r100) {
        if (r100 != null) goto L4;
        ConfigManager r101 = ConfigManager.getInstance();
    L5:
        GetPositionSetting r102 = r101.getInitConfig().getGetPositionSetting();
        if (r102 != null) goto L8;
        return true;
    L8:
        return r102.isShouldStopPositionTaskBeforePlay();
    L4:
        r101 = ContextManager.getConfigManager(r100);
        goto L5
    }

    public static boolean isShouldStopStateTaskBeforePlay(ContextManager.CastContext r100) {
        if (r100 != null) goto L4;
        ConfigManager r101 = ConfigManager.getInstance();
    L5:
        GetStateSetting r102 = r101.getInitConfig().getGetStateSetting();
        if (r102 != null) goto L8;
        return true;
    L8:
        return r102.isShouldStopStateTaskBeforePlay();
    L4:
        r101 = ContextManager.getConfigManager(r100);
        goto L5
    }

    public static boolean isStopDlnaSearchWithoutClearingDevices(ContextManager.CastContext r100) {
        if (r100 != null) goto L4;
        ConfigManager r101 = ConfigManager.getInstance();
    L6:
        return r101.getInitConfig().isStopDlnaSearchWithoutClearingDevices();
    L4:
        r101 = ContextManager.getConfigManager(r100);
        goto L6
    }
}
