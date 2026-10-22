package com.byted.cast.common;

import android.text.TextUtils;
import com.byted.cast.common.api.IAppCommonDataListener;
import com.byted.cast.common.api.IMonitor;
import com.byted.cast.common.auth.AuthConstants;
import com.byted.cast.common.auth.ICastAuth;
import com.byted.cast.common.ble.WifiUtils;
import com.byted.cast.common.config.Config;
import com.byted.cast.common.sink.SinkModule;
import com.byted.cast.common.utils.DLNAOptionUtils;
import com.bytedance.android.livesdk.chatroom.broadcast.BroadcastSDKServiceImpl;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class TeaEventTrack {
    public static final String ACTION_DRAMA_CLEAR = "clear";
    public static final String ACTION_DRAMA_DELETE = "delete";
    public static final String ACTION_DRAMA_NEXT = "next";
    public static final String ACTION_DRAMA_PLAY = "play";
    public static final String ACTION_DRAMA_PRE = "pre";
    public static final String ACTION_DRAMA_SET_URL = "set_url";
    public static final String BDLINK_INDICATOR_START_SERVER_RESULT = "bytecastsdk_indicator_bdlink_start_server_result";
    public static final String BDLINK_PLAY_TRACE = "bytecastsdk_trace_bdlink_play";
    public static String BYTECASTSDK_DEBUG_BDDLNA_BROWSE = "bytecastsdk_debug_bddlna_browse";
    public static String BYTECASTSDK_DEBUG_BDDLNA_PLAY_COMMAND = "bytecastsdk_debug_bddlna_play_command";
    public static String BYTECASTSDK_DEBUG_BDDLNA_PLAY_STASTE = "bytecastsdk_debug_bddlna_play_state";
    public static final String BYTECASTSDK_DEBUG_DLNA_GET_STATE_REGULAR = "bytecastsdk_debug_dlna_get_state_regular";
    public static String BYTECASTSDK_INDICATOR_AUTH = "bytecastsdk_indicator_auth";
    public static String BYTECASTSDK_INDICATOR_AUTH_TIME = "bytecastsdk_indicator_auth_time";
    public static String BYTECASTSDK_INDICATOR_BDDLNA_PLAY = "bytecastsdk_indicator_bddlna_play";
    public static String BYTECASTSDK_INDICATOR_BDLE_ERROR = "bytecastsdk_indicator_bdle_error";
    public static String BYTECASTSDK_INDICATOR_BDLINK_PLAY = "bytecastsdk_indicator_bdlink_play";
    public static String BYTECASTSDK_INDICATOR_BDLINK_SEND_MESSAGE = "bytecastsdk_indicator_bdlink_send_message";
    public static String BYTECASTSDK_INDICATOR_BROWSE = "bytecastsdk_indicator_browse";
    public static String BYTECASTSDK_INDICATOR_BROWSE_PROTOCOL = "bytecastsdk_indicator_browse_protocol";
    public static String BYTECASTSDK_INDICATOR_BROWSE_TIME = "bytecastsdk_indicator_browse_time";
    public static String BYTECASTSDK_INDICATOR_CAST_TIME = "bytecastsdk_indicator_cast_time";
    public static String BYTECASTSDK_INDICATOR_CONNECT_PROTOCOL = "bytecastsdk_indicator_connect_protocol";
    public static String BYTECASTSDK_INDICATOR_CONNECT_TIME = "bytecastsdk_indicator_connect_time";
    public static final String BYTECASTSDK_INDICATOR_CRYPTO_DECRYPT = "bytecastsdk_indicator_crypto_decrypt";
    public static final String BYTECASTSDK_INDICATOR_CRYPTO_ENCRYPT = "bytecastsdk_indicator_crypto_encrypt";
    public static final String BYTECASTSDK_INDICATOR_CRYPTO_FILL_DEVICEINFO = "bytecastsdk_indicator_crypto_fill_deviceinfo";
    public static final String BYTECASTSDK_INDICATOR_CRYPTO_PARSE_DEVICEINFO = "bytecastsdk_indicator_crypto_parse_deviceinfo";
    public static final String BYTECASTSDK_INDICATOR_DETECT_DEVICE = "bytecastsdk_indicator_detect_device";
    public static String BYTECASTSDK_INDICATOR_DRAMA = "bytecastsdk_indicator_drama";
    public static String BYTECASTSDK_INDICATOR_GET_DEVICE_INFO = "bytecastsdk_indicator_get_device_info";
    public static String BYTECASTSDK_INDICATOR_GET_MEDIA_INFO_PROTOCOL = "bytecastsdk_indicator_get_media_info_protocol";
    public static String BYTECASTSDK_INDICATOR_GRAY_CONFIG = "bytecastsdk_indicator_gray_config";
    public static String BYTECASTSDK_INDICATOR_LATENCY_TIME = "bytecastsdk_indicator_latency_time";
    public static String BYTECASTSDK_INDICATOR_LELINK_PLAY = "bytecastsdk_indicator_lelink_play";
    public static String BYTECASTSDK_INDICATOR_MDNS_DISCOVERY = "bytecastsdk_indicator_mdns_discovery";
    public static String BYTECASTSDK_INDICATOR_MDNS_GET_DEVICE_INFO = "bytecastsdk_indicator_mdns_get_device_info";
    public static String BYTECASTSDK_INDICATOR_MDNS_REGISTER = "bytecastsdk_indicator_mdns_register";
    public static String BYTECASTSDK_INDICATOR_MDNS_RESOLVE = "bytecastsdk_indicator_mdns_resolve";
    public static String BYTECASTSDK_INDICATOR_MDNS_SERVICE_FOUND = "bytecastsdk_indicator_mdns_service_found";
    public static String BYTECASTSDK_INDICATOR_MDNS_STOP_DISCOVERY = "bytecastsdk_indicator_mdns_stop_discovery";
    public static String BYTECASTSDK_INDICATOR_MDNS_UNREGISTER = "bytecastsdk_indicator_mdns_unregister";
    public static String BYTECASTSDK_INDICATOR_MINUTE_CATON = "bytecastsdk_indicator_minute_caton";
    public static String BYTECASTSDK_INDICATOR_MINUTE_CATON_TIME = "bytecastsdk_indicator_minute_caton_time";
    public static String BYTECASTSDK_INDICATOR_NETWORK = "bytecastsdk_indicator_network";
    public static String BYTECASTSDK_INDICATOR_PLAY_PROTOCOL = "bytecastsdk_indicator_play_protocol";
    public static String BYTECASTSDK_INDICATOR_PLAY_TIME = "bytecastsdk_indicator_play_time";
    public static String BYTECASTSDK_INDICATOR_PRIVATE_ERROR = "bytecastsdk_indicator_private_error";
    public static String BYTECASTSDK_INDICATOR_PRIVATE_RECEIVE = "bytecastsdk_indicator_private_receive";
    public static String BYTECASTSDK_INDICATOR_PRIVATE_SEND = "bytecastsdk_indicator_private_send";
    public static String BYTECASTSDK_INDICATOR_PUSH_TIME = "bytecastsdk_indicator_push_time";
    public static String BYTECASTSDK_INDICATOR_RECEIVER_CAST = "bytecastsdk_indicator_receiver_cast";
    public static String BYTECASTSDK_INDICATOR_RECEIVER_PLAY = "bytecastsdk_indicator_receiver_play";
    public static String BYTECASTSDK_INDICATOR_RECEIVER_PREEMPT = "bytecastsdk_indicator_receiver_preempt";
    public static String BYTECASTSDK_INDICATOR_RECEIVER_PUSH = "bytecastsdk_indicator_receiver_push";
    public static String BYTECASTSDK_INDICATOR_RECEIVER_SET_PREEMPT_MODE = "bytecastsdk_indicator_receiver_set_preempt_mode";
    public static final String BYTECASTSDK_INDICATOR_SEND_MESSAGE_SINK = "bytecastsdk_indicator_send_message_sink";
    public static final String BYTECASTSDK_INDICATOR_SEND_MESSAGE_SOURCE = "bytecastsdk_indicator_send_message_source";
    public static String BYTECASTSDK_INDICATOR_SERVICE_RESTART = "bytecastsdk_indicator_service_restart";
    public static String BYTECASTSDK_INDICATOR_START_SERVER = "bytecastsdk_indicator_start_server";
    public static String BYTECASTSDK_INDICATOR_START_SERVER_ERROR = "bytecastsdk_indicator_start_server_error";
    public static String BYTECASTSDK_INDICATOR_TROUBLESHOOTING = "bytecastsdk_indicator_troubleshooting";
    private static final String TAG = "TeaEventTrack";
    public static final String TEA_EVENT_STATE_FAILURE = "failure";
    public static final String TEA_EVENT_STATE_INFO = "info";
    public static final String TEA_EVENT_STATE_PUSH_SUCCESS = "push_success";
    public static final String TEA_EVENT_STATE_START = "start";
    public static final String TEA_EVENT_STATE_STOP = "stop";
    public static final String TEA_EVENT_STATE_SUCCESS = "success";
    private static volatile TeaEventTrack sInstance;
    private IAppCommonDataListener appCommonDataListener;
    private AppLogWrapper appLogWrapper;
    public String browseId;
    public String castProtocol;
    public String castUrl;
    public String connectId;
    public Boolean isSource;
    private final ContextManager.CastContext mCastContext;
    private DeviceTrackInfo mDeviceTrackInfo;
    private final CastLogger mLogger;
    private String mSourceDeviceTrackInfoListStr;
    public String projectId;
    public String sessionID;

    public static class DeviceTrackInfo {
        public String deviceBrand;
        public String deviceModel;
        public String deviceName;
        public String did;

        /* JADX INFO: renamed from: os, reason: collision with root package name */
        public String f33699os;
        public String userId;

        public DeviceTrackInfo() {
        }
    }

    private boolean checkAppLogWrapperInitialized() {
        if (this.appLogWrapper != null) goto L15;
        monitor-enter(AppLogWrapper.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (this.appLogWrapper != null) goto L9;
        this.appLogWrapper = ContextManager.getAppLogWrapper(this.mCastContext);     // Catch: Throwable -> L11
    L9:
        monitor-exit(AppLogWrapper.class);     // Catch: Throwable -> L11
    L15:
        if (this.appLogWrapper == null) goto L17;
        return true;
    L17:
        return false;
    }

    public static TeaEventTrack getInstance() {
        if (sInstance != null) goto L15;
        monitor-enter(TeaEventTrack.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new TeaEventTrack(null);     // Catch: Throwable -> L11
    L9:
        monitor-exit(TeaEventTrack.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    public TeaEventTrack(ContextManager.CastContext r100) {
        this.projectId = "";
        this.isSource = Boolean.TRUE;
        this.sessionID = "";
        this.browseId = "";
        this.connectId = "";
        this.castUrl = "";
        this.castProtocol = "";
        this.mLogger = ContextManager.getLogger(r100);
        this.mCastContext = r100;
    }

    public static TeaEventTrack createInstance(ContextManager.CastContext r100) {
        if (r100 != null) goto L6;
        return getInstance();
    L6:
        return new TeaEventTrack(r100);
    }

    private void fillSinkGeneralField(JSONObject r110) {
        ICastAuth r100 = ContextManager.getAuthManager(this.mCastContext);
        Config r101 = ContextManager.getConfigManager(this.mCastContext).getInitConfig();
        IAppCommonDataListener r111 = this.appCommonDataListener;     // Catch: JSONException -> L70
        if (r111 == null) goto L11;
        Map<String, Object> r112 = r111.getData();     // Catch: JSONException -> L70
        if (r112 == null) goto L11;
        Iterator<Map.Entry<String, Object>> r113 = r112.entrySet().iterator();     // Catch: JSONException -> L70
    L9:
        if (r113.hasNext() == false) goto L11;
        Map.Entry<String, Object> r114 = r113.next();     // Catch: JSONException -> L70
        r110.put(r114.getKey(), r114.getValue());     // Catch: JSONException -> L70
    L11:
        r110.put("bct_session_id", this.sessionID);     // Catch: JSONException -> L70
        String r115 = "";
        if (r100.getLicenseParam(AuthConstants.PARAM_KEY_LICENSE_ID) != null) goto L15;
        String r116 = "";
    L16:
        r110.put(AuthConstants.PARAM_KEY_LICENSE_ID, r116);     // Catch: JSONException -> L70
        if (r100.getLicenseParam(AuthConstants.PARAM_KEY_LICENSE_BUSINESS_ID) != null) goto L19;
        String r102 = "";
    L20:
        r110.put(AuthConstants.PARAM_KEY_LICENSE_BUSINESS_ID, r102);     // Catch: JSONException -> L70
        if (r100.getLicenseParam(AuthConstants.PARAM_KEY_LICENSE_APP_ID) != null) goto L23;
        String r103 = "";
    L24:
        r110.put(AuthConstants.PARAM_KEY_LICENSE_APP_ID, r103);     // Catch: JSONException -> L70
        r110.put(AuthConstants.PARAM_KEY_LICENSE_PROJECT_ID, this.projectId);     // Catch: JSONException -> L70
        r110.put("role", Constants.ROLE_SINK);     // Catch: JSONException -> L70
        r110.put("bct_sdk_version", BuildConfig.VERSION_NAME);     // Catch: JSONException -> L70
        String r104 = "1";
        if (PreferenceUtils.isByteUserToB() == false) goto L28;
        Object r105 = "1";
    L29:
        r110.put("is_user_tob", r105);     // Catch: JSONException -> L70
        r110.put("params_for_bytecast", "bytecastsdk");     // Catch: JSONException -> L70
        if (TextUtils.isEmpty(r110.optString("browse_id")) == false) goto L37;
        if (TextUtils.isEmpty(this.browseId) == false) goto L34;
        String r106 = "";
    L35:
        r110.put("browse_id", r106);     // Catch: JSONException -> L70
        goto L37
    L34:
        r106 = this.browseId;     // Catch: JSONException -> L70
    L37:
        if (TextUtils.isEmpty(r110.optString("cast_url")) == false) goto L44;
        if (TextUtils.isEmpty(this.castUrl) == false) goto L41;
        String r107 = "";
    L42:
        r110.put("cast_url", r107);     // Catch: JSONException -> L70
        goto L44
    L41:
        r107 = this.castUrl;     // Catch: JSONException -> L70
    L44:
        if (TextUtils.isEmpty(r110.optString("connect_id")) == false) goto L47;
        r110.put("connect_id", this.connectId);     // Catch: JSONException -> L70
    L47:
        if (TextUtils.isEmpty(r110.optString("cast_protocol")) == false) goto L49;
        r110.put("cast_protocol", this.castProtocol);     // Catch: JSONException -> L70
    L49:
        String r108 = r110.optString("cast_protocol");     // Catch: JSONException -> L70
        Locale r109 = Locale.ROOT;     // Catch: JSONException -> L70
        r110.put("cast_protocol", r108.toLowerCase(r109));     // Catch: JSONException -> L70
        if (TextUtils.isEmpty(r110.optString("protocol")) == true) goto L52;
        r110.put("protocol", r110.optString("protocol").toLowerCase(r109));     // Catch: JSONException -> L70
    L52:
        r110.put("bct_time_stamp", "" + System.currentTimeMillis());     // Catch: JSONException -> L70
        if (r101.getLocalProtocols() != null) goto L55;
        String r117 = "";
    L56:
        r110.put("protocols_priority", r117);     // Catch: JSONException -> L70
        r110.put("package_name", Constants.sAppContext.getPackageName());     // Catch: JSONException -> L70
        r110.put("sink_ssdp_server", String.valueOf(DLNAOptionUtils.isEnableSinkSsdpServer(this.mCastContext)));     // Catch: JSONException -> L70
        r110.put("sink_ssdp_broadcast", String.valueOf(DLNAOptionUtils.isEnableSinkBDLinkSSDPBroadcast(null)));     // Catch: JSONException -> L70
        r110.put("enable_dlna_customized_service", String.valueOf(DLNAOptionUtils.isEnableDlnaSinkCustomizedService(this.mCastContext)));     // Catch: JSONException -> L70
        r110.put("enable_dlna_low_performance_mode", String.valueOf(DLNAOptionUtils.isOpenDlnaLowPerformanceMode()));     // Catch: JSONException -> L70
        r110.put("net_type", NetworkUtil.getCurrentNetworkType(Constants.sAppContext).toString());     // Catch: JSONException -> L70
        if (NetworkUtil.isWifiProxy() == false) goto L59;
        Object r118 = "1";
    L60:
        r110.put("net_proxy_status", r118);     // Catch: JSONException -> L70
        if (NetworkUtil.isVpnInUse() == true) goto L64;
        r104 = "0";
    L64:
        r110.put("net_vpn_status", r104);     // Catch: JSONException -> L70
        r110.put("net_wifi_bandwidth", NetworkUtil.getWifiBandWidth());     // Catch: JSONException -> L70
        r110.put("net_wifi_rtt", NetworkUtil.getWifiRTT());     // Catch: JSONException -> L70
        r110.put("net_wifi_loss_rate", NetworkUtil.getWifiLossRate());     // Catch: JSONException -> L70
        if (TextUtils.isEmpty(this.mSourceDeviceTrackInfoListStr) == true) goto L68;
        r115 = this.mSourceDeviceTrackInfoListStr;     // Catch: JSONException -> L70
    L68:
        r110.put("source_device_info_list", r115);     // Catch: JSONException -> L70
        return;
    L59:
        r118 = "0";
        goto L60
    L55:
        r117 = r101.getLocalProtocols();     // Catch: JSONException -> L70
        goto L56
    L28:
        r105 = "0";
        goto L29
    L23:
        r103 = r100.getLicenseParam(AuthConstants.PARAM_KEY_LICENSE_APP_ID);     // Catch: JSONException -> L70
        goto L24
    L19:
        r102 = r100.getLicenseParam(AuthConstants.PARAM_KEY_LICENSE_BUSINESS_ID);     // Catch: JSONException -> L70
        goto L20
    L15:
        r116 = r100.getLicenseParam(AuthConstants.PARAM_KEY_LICENSE_ID);     // Catch: JSONException -> L70
    L70:
        e = move-exception;
        throw new RuntimeException(e);
    }

    private void fillSourceGeneralField(JSONObject r110) {
        Config r100 = ContextManager.getConfigManager(this.mCastContext).getInitConfig();
        ICastAuth r101 = ContextManager.getAuthManager(this.mCastContext);
        IAppCommonDataListener r102 = this.appCommonDataListener;     // Catch: JSONException -> L85
        if (r102 == null) goto L11;
        Map<String, Object> r103 = r102.getData();     // Catch: JSONException -> L85
        if (r103 == null) goto L11;
        Iterator<Map.Entry<String, Object>> r104 = r103.entrySet().iterator();     // Catch: JSONException -> L85
    L9:
        if (r104.hasNext() == false) goto L11;
        Map.Entry<String, Object> r111 = r104.next();     // Catch: JSONException -> L85
        r110.put(r111.getKey(), r111.getValue());     // Catch: JSONException -> L85
    L11:
        r110.put("bct_session_id", this.sessionID);     // Catch: JSONException -> L85
        String r112 = "";
        if (r101.getLicenseParam(AuthConstants.PARAM_KEY_LICENSE_ID) != null) goto L15;
        String r105 = "";
    L16:
        r110.put(AuthConstants.PARAM_KEY_LICENSE_ID, r105);     // Catch: JSONException -> L85
        if (r101.getLicenseParam(AuthConstants.PARAM_KEY_LICENSE_BUSINESS_ID) != null) goto L19;
        String r106 = "";
    L20:
        r110.put(AuthConstants.PARAM_KEY_LICENSE_BUSINESS_ID, r106);     // Catch: JSONException -> L85
        if (r101.getLicenseParam(AuthConstants.PARAM_KEY_LICENSE_APP_ID) != null) goto L23;
        String r107 = "";
    L24:
        r110.put(AuthConstants.PARAM_KEY_LICENSE_APP_ID, r107);     // Catch: JSONException -> L85
        r110.put(AuthConstants.PARAM_KEY_LICENSE_PROJECT_ID, this.projectId);     // Catch: JSONException -> L85
        r110.put("role", "source");     // Catch: JSONException -> L85
        r110.put("bct_sdk_version", BuildConfig.VERSION_NAME);     // Catch: JSONException -> L85
        String r108 = "1";
        if (PreferenceUtils.isByteUserToB() == false) goto L28;
        Object r109 = "1";
    L29:
        r110.put("is_user_tob", r109);     // Catch: JSONException -> L85
        r110.put("params_for_bytecast", "bytecastsdk");     // Catch: JSONException -> L85
        r110.put("bct_time_stamp", "" + System.currentTimeMillis());     // Catch: JSONException -> L85
        if (r100.getLocalProtocols() != null) goto L32;
        String r113 = "";
    L33:
        r110.put("protocols_priority", r113);     // Catch: JSONException -> L85
        r110.put("browse_id", this.browseId);     // Catch: JSONException -> L85
        r110.put("package_name", Constants.sAppContext.getPackageName());     // Catch: JSONException -> L85
        if (TextUtils.isEmpty(r110.optString("cast_url")) == false) goto L37;
        r110.put("cast_url", this.castUrl);     // Catch: JSONException -> L85
    L37:
        if (TextUtils.isEmpty(r110.optString("connect_id")) == false) goto L40;
        r110.put("connect_id", this.connectId);     // Catch: JSONException -> L85
    L40:
        if (TextUtils.isEmpty(r110.optString("cast_protocol")) == false) goto L42;
        r110.put("cast_protocol", this.castProtocol);     // Catch: JSONException -> L85
    L42:
        String r114 = r110.optString("cast_protocol");     // Catch: JSONException -> L85
        Locale r115 = Locale.ROOT;     // Catch: JSONException -> L85
        r110.put("cast_protocol", r114.toLowerCase(r115));     // Catch: JSONException -> L85
        ContextManager.CastContext r116 = this.mCastContext;     // Catch: JSONException -> L85
        if (r116 != null) goto L45;
    L47:
        boolean r117 = false;
    L48:
        r110.put("ble_browse", String.valueOf(r117));     // Catch: JSONException -> L85
        r110.put("ble_publish", String.valueOf(WifiUtils.isBlePublish()));     // Catch: JSONException -> L85
        r110.put("enable_cache", String.valueOf(DLNAOptionUtils.isEnableCache(this.mCastContext)));     // Catch: JSONException -> L85
        r110.put("enable_search", String.valueOf(DLNAOptionUtils.isEnableDlnaSearch(this.mCastContext)));     // Catch: JSONException -> L85
        r110.put("enable_broadcast", String.valueOf(DLNAOptionUtils.isEnableBroadcastSearch(this.mCastContext)));     // Catch: JSONException -> L85
        r110.put("enable_device_offline", String.valueOf(DLNAOptionUtils.isEnableDeviceOffline(this.mCastContext)));     // Catch: JSONException -> L85
        r110.put("dlna_offline_interval", String.valueOf(DLNAOptionUtils.getDlnaOfflineInterval(this.mCastContext)));     // Catch: JSONException -> L85
        r110.put("bdlink_offline_interval", String.valueOf(DLNAOptionUtils.getBdlinkDeviceOfflineDetectInterval(this.mCastContext)));     // Catch: JSONException -> L85
        r110.put("bdlink_enable_quick_query", String.valueOf(DLNAOptionUtils.isEnableBdlinkQuickQuery(this.mCastContext)));     // Catch: JSONException -> L85
        r110.put("bdlink_enable_disk_cache", String.valueOf(DLNAOptionUtils.isEnableBdlinkDiskCache(this.mCastContext)));     // Catch: JSONException -> L85
        r110.put("ssdp_search", String.valueOf(DLNAOptionUtils.isEnableSsdpSearch(this.mCastContext)));     // Catch: JSONException -> L85
        r110.put("ssdp_cycle_search", String.valueOf(DLNAOptionUtils.isEnableSsdpCycleSearch(this.mCastContext)));     // Catch: JSONException -> L85
        r110.put("source_ssdp_broadcast", String.valueOf(DLNAOptionUtils.isEnableSourceBDLinkSSDPBroadcast(this.mCastContext)));     // Catch: JSONException -> L85
        r110.put("enable_dlna_customized_service", String.valueOf(DLNAOptionUtils.isEnableDlnaSourceCustomizedService(this.mCastContext)));     // Catch: JSONException -> L85
        r110.put("net_type", NetworkUtil.getCurrentNetworkType(Constants.sAppContext).toString());     // Catch: JSONException -> L85
        if (NetworkUtil.isWifiProxy() == false) goto L51;
        Object r118 = "1";
    L52:
        r110.put("net_proxy_status", r118);     // Catch: JSONException -> L85
        if (NetworkUtil.isVpnInUse() == true) goto L56;
        r108 = "0";
    L56:
        r110.put("net_vpn_status", r108);     // Catch: JSONException -> L85
        r110.put("net_wifi_bandwidth", NetworkUtil.getWifiBandWidth());     // Catch: JSONException -> L85
        r110.put("net_wifi_rtt", NetworkUtil.getWifiRTT());     // Catch: JSONException -> L85
        r110.put("net_wifi_loss_rate", NetworkUtil.getWifiLossRate());     // Catch: JSONException -> L85
        if (TextUtils.isEmpty(r110.optString("protocol")) == true) goto L59;
        r110.put("protocol", r110.optString("protocol").toLowerCase(r115));     // Catch: JSONException -> L85
    L59:
        DeviceTrackInfo r119 = this.mDeviceTrackInfo;     // Catch: JSONException -> L85
        if (r119 != null) goto L62;
        String r120 = "";
    L63:
        r110.put("sink_did", r120);     // Catch: JSONException -> L85
        DeviceTrackInfo r121 = this.mDeviceTrackInfo;     // Catch: JSONException -> L85
        if (r121 != null) goto L66;
        String r122 = "";
    L67:
        r110.put("sink_user_id", r122);     // Catch: JSONException -> L85
        DeviceTrackInfo r123 = this.mDeviceTrackInfo;     // Catch: JSONException -> L85
        if (r123 != null) goto L70;
        String r124 = "";
    L71:
        r110.put("sink_os", r124);     // Catch: JSONException -> L85
        DeviceTrackInfo r125 = this.mDeviceTrackInfo;     // Catch: JSONException -> L85
        if (r125 != null) goto L74;
        String r126 = "";
    L75:
        r110.put("sink_device_model", r126);     // Catch: JSONException -> L85
        DeviceTrackInfo r127 = this.mDeviceTrackInfo;     // Catch: JSONException -> L85
        if (r127 != null) goto L78;
        String r128 = "";
    L79:
        r110.put("sink_device_brand", r128);     // Catch: JSONException -> L85
        DeviceTrackInfo r129 = this.mDeviceTrackInfo;     // Catch: JSONException -> L85
        if (r129 == null) goto L83;
        r112 = r129.deviceName;     // Catch: JSONException -> L85
    L83:
        r110.put("sink_device_name", r112);     // Catch: JSONException -> L85
        return;
    L78:
        r128 = r127.deviceBrand;     // Catch: JSONException -> L85
        goto L79
    L74:
        r126 = r125.deviceModel;     // Catch: JSONException -> L85
        goto L75
    L70:
        r124 = r123.f33699os;     // Catch: JSONException -> L85
        goto L71
    L66:
        r122 = r121.userId;     // Catch: JSONException -> L85
        goto L67
    L62:
        r120 = r119.did;     // Catch: JSONException -> L85
        goto L63
    L51:
        r118 = "0";
        goto L52
    L45:
        if (r116.isBleBrowse() == false) goto L47;
        r117 = true;
        goto L48
    L32:
        r113 = r100.getLocalProtocols();     // Catch: JSONException -> L85
        goto L33
    L28:
        r109 = "0";
        goto L29
    L23:
        r107 = r101.getLicenseParam(AuthConstants.PARAM_KEY_LICENSE_APP_ID);     // Catch: JSONException -> L85
        goto L24
    L19:
        r106 = r101.getLicenseParam(AuthConstants.PARAM_KEY_LICENSE_BUSINESS_ID);     // Catch: JSONException -> L85
        goto L20
    L15:
        r105 = r101.getLicenseParam(AuthConstants.PARAM_KEY_LICENSE_ID);     // Catch: JSONException -> L85
    L85:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public void initSessionID(String r100) {
        Config r101 = ContextManager.getConfigManager(this.mCastContext).getInitConfig();
        this.sessionID = MD5.hexdigest(r101.getDeviceId() + r101.getAppId() + System.currentTimeMillis());
        this.projectId = r100;
        this.mLogger.d(TAG, "setSessionID :" + this.sessionID + " projectId: " + this.projectId);
    }

    public void setAppCommonDataListener(IAppCommonDataListener r100) {
        this.appCommonDataListener = r100;
    }

    public void setDeviceTrackInfo(DeviceTrackInfo r100) {
        this.mDeviceTrackInfo = r100;
    }

    public void setSourceDeviceTrackInfoListStr(String r100) {
        this.mSourceDeviceTrackInfoListStr = r100;
    }

    public void trackMdnsServiceFound(String r100) {
        HashMap r101 = new HashMap();
        r101.put("type", r100);
        trackSourceEvent(BYTECASTSDK_INDICATOR_MDNS_SERVICE_FOUND, new Map[]{r101});
    }

    public void trackSourceBDLinkPlayTrace(String r100) {
        HashMap r101 = new HashMap();
        r101.put("node", r100);
        trackSourceEvent(BDLINK_PLAY_TRACE, new Map[]{r101});
    }

    private void notifyEvent(String r100, JSONObject r101) {
        if (PreferenceUtils.isByteUserToB() == true) goto L5;
        IMonitor r102 = ContextManager.getConfigManager(this.mCastContext).getInitConfig().getMonitor();
        CastLogger r103 = this.mLogger;
        StringBuilder r104 = new StringBuilder("TeaEventTrack -> iMonitor is null: ");
        if (r102 != null) goto L11;
        boolean r105 = true;
    L12:
        r104.append(r105);
        r103.d(TAG, r104.toString());
        if (r102 == null) goto L17;
        r102.onAppLogEvent(r100, r101);
        return;
    L17:
        return;
    L11:
        r105 = false;
        goto L12
    L5:
        if (checkAppLogWrapperInitialized() == false) goto L16;
        this.appLogWrapper.onEventV3(r100, r101);
        return;
    }

    public void trackDlnaBrowse(String r100, HashMap<String, String> r101) {
        HashMap r102 = new HashMap();
        r102.put("state", r100);
        r102.put("browse_protocol", "");
        if (r101 == null) goto L5;
        r102.putAll(r101);
    L5:
        trackSourceEvent(BYTECASTSDK_DEBUG_BDDLNA_BROWSE, new Map[]{r102});
    }

    @SafeVarargs
    public final void trackSinkEvent(String r100, Map<String, String>... r101) {
        if (r101 != null) goto L6;
        this.mLogger.e(TAG, "trackSinkEvent ->  params is null");
        return;
    L6:
        HashMap r102 = new HashMap();
        int r103 = r101.length;
        int r104 = 0;
    L7:
        if (r104 >= r103) goto L12;
        Map<String, String> r105 = r101[r104];
        if (r105 == null) goto L11;
        r102.putAll(r105);
    L11:
        r104 = r104 + 1;
        goto L7
    L12:
        JSONObject r106 = new JSONObject();
        Iterator r107 = r102.entrySet().iterator();     // Catch: Exception -> L19
    L15:
        if (r107.hasNext() == false) goto L17;
        Map.Entry r108 = (Map.Entry) r107.next();     // Catch: Exception -> L19
        r106.put((String) r108.getKey(), r108.getValue());     // Catch: Exception -> L19
        goto L15
    L17:
        trackSinkEvent(r100, r106);     // Catch: Exception -> L19
        return;
    L19:
        e = move-exception;
        this.mLogger.e(TAG, "trackSinkEvent -> " + e.getMessage());
    }

    public void trackSinkReceiverCast(Boolean r100, int r101) {
        HashMap r102 = new HashMap();
        if (r100.booleanValue() == false) goto L5;
        r102.put("cast_type", "push");
    L6:
        r102.put("cast_protocol", SinkModule.getProtocolNameByID(r101).toLowerCase(Locale.ROOT));
        trackSinkEvent(BYTECASTSDK_INDICATOR_RECEIVER_CAST, new Map[]{r102});
        return;
    L5:
        r102.put("cast_type", BroadcastSDKServiceImpl.BG_FRAGMENT_TYPE_MIRROR);
        goto L6
    }

    public void trackSinkReceiverPlay(int r100, String r101) {
        HashMap r102 = new HashMap();
        r102.put("cast_protocol", SinkModule.getProtocolNameByID(r100).toLowerCase(Locale.ROOT));
        r102.put("state", r101);
        trackSinkEvent(BYTECASTSDK_INDICATOR_RECEIVER_PLAY, new Map[]{r102});
    }

    public void trackSinkReceiverPreempt(String r100, String r101) {
        HashMap r102 = new HashMap();
        if (r100 == null) goto L5;
        String r103 = r100.toLowerCase(Locale.ROOT);
    L6:
        r102.put("cast_protocol", r103);
        r102.put("state", r101);
        trackSinkEvent(BYTECASTSDK_INDICATOR_RECEIVER_PREEMPT, new Map[]{r102});
        return;
    L5:
        r103 = "";
        goto L6
    }

    public void trackSinkReceiverPreemptConfig(int r100, int r101) {
        HashMap r102 = new HashMap();
        r102.put("preempt_mode", String.valueOf(r100));
        r102.put("cast_max_num", String.valueOf(r101));
        trackSinkEvent(BYTECASTSDK_INDICATOR_RECEIVER_SET_PREEMPT_MODE, new Map[]{r102});
    }

    public void trackSinkReceiverPush(String r100, String r101) {
        HashMap r102 = new HashMap();
        r102.put("cast_protocol", r100.toLowerCase(Locale.ROOT));
        r102.put("connect_id", r101);
        trackSinkEvent(BYTECASTSDK_INDICATOR_RECEIVER_PUSH, new Map[]{r102});
    }

    @SafeVarargs
    public final void trackSourceEvent(String r100, Map<String, String>... r101) {
        if (r101 != null) goto L6;
        this.mLogger.e(TAG, "trackSourceEvent ->  params is null");
        return;
    L6:
        HashMap r102 = new HashMap();
        int r103 = r101.length;
        int r104 = 0;
    L7:
        if (r104 >= r103) goto L12;
        Map<String, String> r105 = r101[r104];
        if (r105 == null) goto L11;
        r102.putAll(r105);
    L11:
        r104 = r104 + 1;
        goto L7
    L12:
        JSONObject r106 = new JSONObject();
        Iterator r107 = r102.entrySet().iterator();     // Catch: Exception -> L19
    L15:
        if (r107.hasNext() == false) goto L17;
        Map.Entry r108 = (Map.Entry) r107.next();     // Catch: Exception -> L19
        r106.put((String) r108.getKey(), r108.getValue());     // Catch: Exception -> L19
        goto L15
    L17:
        trackSourceEvent(r100, r106);     // Catch: Exception -> L19
        return;
    L19:
        e = move-exception;
        this.mLogger.e(TAG, "trackSourceEvent -> " + e.getMessage());
    }

    public void trackSourceGetDeviceInfoEvent(String r100, Map<String, String> r101) {
        HashMap r102 = new HashMap();
        r102.put("state", r100);
        if (r101 == null) goto L5;
        r102.putAll(r101);
    L5:
        trackSourceEvent(BYTECASTSDK_INDICATOR_GET_DEVICE_INFO, new Map[]{r102});
    }

    public void trackSinkEvent(String r100, JSONObject r101) throws RuntimeException {
        fillSinkGeneralField(r101);
        notifyEvent(r100, r101);
    }

    public void trackSourceEvent(String r100, JSONObject r101) throws RuntimeException {
        fillSourceGeneralField(r101);
        notifyEvent(r100, r101);
    }

    private void addParametersToJSON(JSONObject r100, String r101, String r102) {
        if (r102 != null) goto L9;
        r102 = "";
    L9:
        r100.put(r101, r102);     // Catch: JSONException -> L6
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
    }

    public void trackGrayConfigEvent(String r100, String r101, String r102) {
        JSONObject r103 = new JSONObject();
        addParametersToJSON(r103, "content", "configName :" + r101 + ",content:" + r102);
        addParametersToJSON(r103, "state", r100);
    L8:
        e = move-exception;
        this.mLogger.e(TAG, "trackGrayConfigEvent -> " + e.getMessage());
        return;
    L4:
        if (this.isSource.booleanValue() == false) goto L6;
        trackSourceEvent(BYTECASTSDK_INDICATOR_GRAY_CONFIG, r103);     // Catch: RuntimeException -> L8
    L11:
        return;
    L6:
        trackSinkEvent(BYTECASTSDK_INDICATOR_GRAY_CONFIG, r103);     // Catch: RuntimeException -> L8
        goto L11
    }

    public void trackSinkStartServer(String r100, String r101, Long r102) {
        HashMap r103 = new HashMap();
        r103.put("cast_protocol", r100.toLowerCase(Locale.ROOT));
        r103.put("state", r101);
        if (r102 == null) goto L5;
        r103.put("cast_duration", String.valueOf(System.currentTimeMillis() - r102.longValue()));
    L5:
        trackSinkEvent(BYTECASTSDK_INDICATOR_START_SERVER, new Map[]{r103});
    }

    public void trackSourceMirrorEvent(String r100, String r101, Long r102) {
        HashMap r103 = new HashMap();
        r103.put("cast_protocol", r100.toLowerCase(Locale.ROOT));
        r103.put("state", r101);
        if (r102 == null) goto L5;
        r103.put("cast_duration", String.valueOf(System.currentTimeMillis() - r102.longValue()));
    L5:
        trackSourceEvent(BYTECASTSDK_INDICATOR_PLAY_PROTOCOL, new Map[]{r103});
    }

    public void trackMdnsDiscovery(String r100, String r101, String r102, String r103) {
        if (TextUtils.isEmpty(r102) == false) goto L5;
        r102 = "0";
    L5:
        HashMap r104 = new HashMap();
        r104.put("state", r100);
        r104.put("err_code", r102);
        r104.put(LocationMonitorConst.ERR_MSG, r103);
        r104.put("type", r101);
        trackSourceEvent(BYTECASTSDK_INDICATOR_MDNS_DISCOVERY, new Map[]{r104});
    }

    public void trackMdnsRegisterEvent(String r100, String r101, String r102, String r103) {
        if (TextUtils.isEmpty(r102) == false) goto L5;
        r102 = "0";
    L5:
        HashMap r104 = new HashMap();
        r104.put("state", r100);
        r104.put("err_code", r102);
        r104.put(LocationMonitorConst.ERR_MSG, r103);
        r104.put("type", r101);
        trackSinkEvent(BYTECASTSDK_INDICATOR_MDNS_REGISTER, new Map[]{r104});
    }

    public void trackMdnsStopDiscovery(String r100, String r101, String r102, String r103) {
        if (TextUtils.isEmpty(r102) == false) goto L5;
        r102 = "0";
    L5:
        HashMap r104 = new HashMap();
        r104.put("state", r100);
        r104.put("err_code", r102);
        r104.put(LocationMonitorConst.ERR_MSG, r103);
        r104.put("type", r101);
        trackSourceEvent(BYTECASTSDK_INDICATOR_MDNS_STOP_DISCOVERY, new Map[]{r104});
    }

    public void trackMdnsUnregisterEvent(String r100, String r101, String r102, String r103) {
        if (TextUtils.isEmpty(r102) == false) goto L5;
        r102 = "0";
    L5:
        HashMap r104 = new HashMap();
        r104.put("state", r100);
        r104.put("err_code", r102);
        r104.put(LocationMonitorConst.ERR_MSG, r103);
        r104.put("type", r101);
        trackSinkEvent(BYTECASTSDK_INDICATOR_MDNS_UNREGISTER, new Map[]{r104});
    }

    public void trackBDLinkSourceSendMessageEvent(String r100, String r101, String r102, String r103, String r104) {
        JSONObject r105 = new JSONObject();
        addParametersToJSON(r105, "message", r102);
        addParametersToJSON(r105, "state", r100);
        addParametersToJSON(r105, LocationMonitorConst.ERR_MSG, r104);
        addParametersToJSON(r105, "err_code", r103);
        addParametersToJSON(r105, com.ss.cast.discovery.mdns.nsdhelper.NsdHelper.serviceInfoKey, r101);
        trackSourceEvent(BYTECASTSDK_INDICATOR_BDLINK_SEND_MESSAGE, r105);     // Catch: RuntimeException -> L5
        return;
    L5:
        e = move-exception;
        this.mLogger.e(TAG, "trackBDLinkSourceSendMessageEvent -> " + e.getMessage());
    }

    public void trackCastCryptoEvent(String r100, String r101, String r102, int r103, String r104) {
        JSONObject r105 = new JSONObject();
        addParametersToJSON(r105, "content", r102);
        addParametersToJSON(r105, "state", r101);
        if (TextUtils.equals(r101, "failure") == false) goto L6;
        addParametersToJSON(r105, "err_code", String.valueOf(r103));
        addParametersToJSON(r105, LocationMonitorConst.ERR_MSG, r104);
    L6:
        if (this.isSource.booleanValue() == false) goto L8;
        trackSourceEvent(r100, r105);
        return;
    L8:
        trackSinkEvent(r100, r105);
    }

    public void trackMdnsResolve(String r100, String r101, String r102, String r103, boolean r104) {
        if (TextUtils.isEmpty(r102) == false) goto L5;
        r102 = "0";
    L5:
        HashMap r105 = new HashMap();
        r105.put("state", r100);
        r105.put("err_code", r102);
        r105.put(LocationMonitorConst.ERR_MSG, r103);
        r105.put("type", r101);
        r105.put("mdns_is_retry", String.valueOf(r104));
        trackSourceEvent(BYTECASTSDK_INDICATOR_MDNS_RESOLVE, new Map[]{r105});
    }

    public void trackMdnsGetDeviceInfo(String r100, boolean r101, long r102, boolean r103, boolean r104, boolean r105) {
        HashMap r106 = new HashMap();
        r106.put("state", r100);
        r106.put("is_same_ip", String.valueOf(r101));
        r106.put("rtt", String.valueOf(r102));
        r106.put("is_use_attr_ip", String.valueOf(r103));
        r106.put("is_use_ipv6", String.valueOf(r104));
        r106.put("is_enable_ipv6", String.valueOf(r105));
        trackSourceEvent(BYTECASTSDK_INDICATOR_MDNS_GET_DEVICE_INFO, new Map[]{r106});
    }
}
