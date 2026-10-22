package com.byted.cast.common;

import android.content.Context;
import android.text.TextUtils;
import com.byted.cast.common.api.IAppCommonDataListener;
import com.byted.cast.common.api.IMonitor;
import com.byted.cast.common.auth.AuthConstants;
import com.byted.cast.common.auth.ICastAuth;
import com.byted.cast.common.ble.WifiUtils;
import com.byted.cast.common.utils.DLNAOptionUtils;
import com.byted.cast.linkcommon.cybergarage.upnp.device.ST;
import com.bytedance.android.livesdk.chatroom.broadcast.BroadcastSDKServiceImpl;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitorUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class CastMonitor {
    public static final String ABNORMAL_OFFLINE = "abnormal_offline";
    private static final String AID = "1014";
    public static final String AIRPLAY_LATENCY_STAT = "airplay_latency_stat";
    public static final String AIRPLAY_LOADMIRROR = "airplay_loadMirror";
    public static final String AIRPLAY_ONCAST = "airplay_onCast";
    public static final String AIRPLAY_ONCONNECT = "airplay_onConnect";
    public static final String AIRPLAY_ONDISCONNECT = "airplay_onDisConnect";
    public static final String AIRPLAY_ONERROR = "airplay_onError";
    public static final String AIRPLAY_ONVOLUME = "airplay_onVolume";
    public static final String AIRPLAY_SERVER_ONSTOP = "airplay_server_onStop";
    public static final String AIRPLAY_START_SERVER = "airplay_start_server";
    public static final String AIRPLAY_START_SERVER_FAILED = "airplay_start_server_failed";
    public static final String AIRPLAY_START_SERVER_SUCCESS = "airplay_start_server_success";
    public static final String AIRPLAY_STOP_SERVER = "airplay_stop_server";
    public static final String AIRPLAY_STUCK_STAT = "airplay_stuck_stat";
    public static final String AirPlayMonitor = "AirPlayMonitor";
    public static final String BDCLOUD_ADDVOLUME = "bdcloud_addvolume";
    public static final String BDCLOUD_BINDSDK = "bdcloud_bindsdk";
    public static final String BDCLOUD_CMD_URI_FAILURE_INFO = "bdcloud_cmd_uri_failure_info";
    public static final String BDCLOUD_CONNECT = "bdcloud_connect";
    public static final String BDCLOUD_GETVOLUME = "bdcloud_getvolume";
    public static final String BDCLOUD_HTTP_RESPONSE = "bdcloud_http_response";
    public static final String BDCLOUD_INITBDCLOUD = "bdcloud_initbdcloud";
    public static final String BDCLOUD_NOTIFYPREEMPT = "bdcloud_notifypreempt";
    public static final String BDCLOUD_PAUSE = "bdcloud_pause";
    public static final String BDCLOUD_PLAY = "bdcloud_play";
    public static final String BDCLOUD_PLAY_CMD_SUCCESS = "BDCloud_Play_Cmd_Success";
    public static final String BDCLOUD_RECEIVEDATA = "bdcloud_receivedata";
    public static final String BDCLOUD_RESOLVE_FAILURE = "bdcloud_resolve_failure";
    public static final String BDCLOUD_RESUME = "bdcloud_resume";
    public static final String BDCLOUD_RETRY = "bdcloud_retry";
    public static final String BDCLOUD_SEEKTO = "bdcloud_seekto";
    public static final String BDCLOUD_SENDEVENT = "bdcloud_sendevent";
    public static final String BDCLOUD_SETBULLET = "bdcloud_setbullet";
    public static final String BDCLOUD_SETRESOLUTION = "bdcloud_setresolution";
    public static final String BDCLOUD_SETSPEED = "bdcloud_setspeed";
    public static final String BDCLOUD_SETVOLUME = "bdcloud_setvolume";
    public static final String BDCLOUD_STARTSERVER = "bdcloud_startserver";
    public static final String BDCLOUD_STOP = "bdcloud_stop";
    public static final String BDCLOUD_STOPSERVER = "bdcloud_stopserver";
    public static final String BDCLOUD_SUBSCRIBE = "bdcloud_subscribe";
    public static final String BDCLOUD_SUBVOLUME = "bdcloud_subvolume";
    public static final String BDCLOUD_UNBINDSDK = "bdcloud_unbindsdk";
    public static final String BDCLOUD_UNSUBSCRIBE = "bdcloud_unsubscribe";
    public static final String BDDLNA_BROWSE_CACHE = "BDDLNA_Browse_Cache";
    public static final String BDDLNA_BROWSE_CACHE_CHECK = "BDDLNA_Browse_Cache_Check";
    public static final String BDDLNA_BROWSE_CACHE_READ = "BDDLNA_Browse_Cache_Read";
    public static final String BDDLNA_BROWSE_CACHE_WRITE = "BDDLNA_Browse_Cache_Write";
    public static final String BDDLNA_BROWSE_ERROR = "bddlna_browse_error";
    public static final String BDDLNA_BROWSE_RESULT_ALL_SUCCESS = "bddlna_browse_result_all";
    public static final String BDDLNA_BROWSE_SCHEDULE = "BDDLNA_Browse_Schedule";
    public static final String BDDLNA_BROWSE_SUCCESS = "BDDLNA_Browse_Success";
    public static final String BDDLNA_CMD_PLAY_FAILURE_INFO = "bddlna_cmd_play_failure_info";
    public static final String BDDLNA_CMD_URI_FAILURE_INFO = "bddlna_cmd_uri_failure_info";
    public static final String BDDLNA_PARSE_URL_FAILURE_INFO = "bddlna_parse_url_failure_info";
    public static final String BDDLNA_PLAY = "BDDLNA_Play";
    public static final String BDDLNA_PLAY_CMD_SUCCESS = "BDDLNA_Play_Cmd_Success";
    public static final String BDDLNA_PLAY_FAILURE = "BDDLNA_Play_Failure";
    public static final String BDDLNA_PLAY_FAILURE_INFO = "BDDLNA_Play_Failure_Info";
    public static final String BDDLNA_PLAY_SUCCESS = "BDDLNA_Play_Success";
    public static final String BDDLNA_RECEIVE_ACTION = "BDDLNA_Receive_Action";
    public static final String BDDLNA_RECEIVE_ACTION_RESPONSE = "BDDLNA_Receive_Action_Response";
    public static final String BDDLNA_RECEIVE_EVENT = "BDDLNA_Receive_Event";
    public static final String BDDLNA_SEARCH_SEND_SUCCESS = "bddlna_search_send_success";
    public static final String BDDLNA_SEND_ACTION = "BDDLNA_Send_Action";
    public static final String BDDLNA_SEND_EVENT = "BDDLNA_Send_Event";
    public static final String BDDLNA_START_BROWSE = "BDDLNA_Start_Browse";
    public static final String BDDLNA_START_SERVER = "BDDLNA_Start_Server";
    public static final String BDDLNA_START_SERVER_ERROR = "BDDLNA_Start_Server_Error";
    public static final String BDDLNA_START_SERVER_FAILURE = "BDDLNA_Start_Server_Failure";
    public static final String BDDLNA_START_SERVER_INFO = "BDDLNA_Start_Server_Info";
    public static final String BDDLNA_START_SERVER_SUCCESS = "BDDLNA_Start_Server_Success";
    public static final String BDDLNA_STOP_BROWSE = "BDDLNA_Stop_Browse";
    public static final String BDDLNA_STOP_SERVER = "BDDLNA_Stop_Server";
    public static final String BDDLNA_STOP_SERVER_ERROR = "BDDLNA_Stop_Server_Error";
    public static final String BDLE_PROTOCOL_ERROR = "bdle_protocol_error";
    public static final String BDLE_SERVICE_RESTART = "bdle_service_restart";
    public static final String BDLINK_BROWSE_SUCCESS = "BDLink_Browse_Success";
    public static final String BDLINK_CMD_RESULT = "bdlink_cmd_result";
    public static final String BDLINK_DISK_CACHE_CHECK_RESULT = "bdlink_disk_cache_check_result";
    public static final String BDLINK_GET_REGISTER_LIST = "BDLink_Get_Register_List";
    public static final String BDLINK_PLAY = "BDLink_Play";
    public static final String BDLINK_PLAY_CMD_SUCCESS = "BDLink_Play_Cmd_Success";
    public static final String BDLINK_PLAY_FAILURE = "BDLink_Play_Failure";
    public static final String BDLINK_PLAY_SUCCESS = "BDLink_Play_Success";
    public static final String BDLINK_RECEIVE_MESSAGE = "BDLink_Receive_Message";
    public static final String BDLINK_REGISTER = "BDLink_Register";
    public static final String BDLINK_REGISTER_FAILURE = "BDLink_Register_Failure";
    public static final String BDLINK_REGISTER_SUCCESS = "BDLink_Register_Success";
    public static final String BDLINK_SEND_MESSAGE = "BDLink_Send_Message";
    public static final String BDLINK_SEND_MESSAGE_FAILURE = "BDLink_Send_Message_Failure";
    public static final String BDLINK_SEND_MESSAGE_SUCCESS = "BDLink_Send_Message_Success";
    public static final String BDLINK_START_BROWSE = "BDLink_Start_Browse";
    public static final String BDLINK_START_SERVER = "BDLink_Start_Server";
    public static final String BDLINK_START_SERVER_ERROR = "BDLink_Start_Server_Error";
    public static final String BDLINK_START_SERVER_FAILURE = "BDLink_Start_Server_Failure";
    public static final String BDLINK_START_SERVER_INFO = "BDLink_Start_Server_Info";
    public static final String BDLINK_START_SERVER_RESULT = "bdlink_start_server_result";
    public static final String BDLINK_START_SERVER_SUCCESS = "BDLink_Start_Server_Success";
    public static final String BDLINK_STOP_BROWSE = "BDLink_Stop_Browse";
    public static final String BDLINK_STOP_SERVER = "BDLink_Stop_Server";
    public static final String BDLINK_UNREGISTER = "BDLink_Unregister";
    public static final String BDLINK_UNREGISTER_FAILURE = "BDLink_Unregister_Failure";
    public static final String BDLINK_UNREGISTER_SUCCESS = "BDLink_Unregister_Success";
    public static final String BLE_BROADCAST_PUBLISH_FAILURE = "Ble_Broadcast_Publis_Failure";
    public static final String BLE_BROADCAST_PUBLISH_SUCCESS = "Ble_Broadcast_Publis_Success";
    public static final String BLE_BROWSE_SUCCESS = "Ble_Browse_Success";
    public static final String BLE_PUBLISH_BROADCAST = "Ble_Publish_Broadcast";
    public static final String BLE_SCAN_FAILURE = "Ble_Scan_Failure";
    public static final String BLE_SCAN_FOUND = "Ble_Scan_Found";
    public static final String BLE_START_BROWSE = "Ble_Start_Browse";
    public static final String BLE_START_SCAN = "Ble_Start_Scan";
    public static final String BLE_STOP_PUBLISH_BROADCAST = "Ble_Stop_Publish_Broadcast";
    public static final String BLE_STOP_SCAN = "Ble_Stop_Scan";
    public static final String BYTECAST_APPEND_BDLINK_INFO_RESULT = "bytecast_append_bdlink_info_result";
    public static final String BYTECAST_AUTH = "ByteCast_Auth";
    public static final String BYTECAST_AUTH_FAILURE = "ByteCast_Auth_Failure";
    public static final String BYTECAST_AUTH_SUCCESS = "ByteCast_Auth_Success";
    public static final String BYTECAST_BIND_SDK_INFO_FAILURE = "ByteCast_BindSdk_Info_Failure";
    public static final String BYTECAST_BIND_SDK_INFO_SUCCESS = "ByteCast_BindSdk_Info_Success";
    public static final String BYTECAST_BIND_SDK_LELINK_FAILURE = "ByteCast_BindSdk_Lelink_Failure";
    public static final String BYTECAST_BIND_SDK_LELINK_SUCCESS = "ByteCast_BindSdk_Lelink_Success";
    public static final String BYTECAST_BIND_SDK_RESULT = "ByteCast_BindSdk_Result";
    public static final String BYTECAST_BROWSE_FAILED_AUTH_INVALID = "bytecast_browse_failed_auth_invalid";
    public static final String BYTECAST_BROWSE_INFO = "bytecast_browse_info";
    public static final String BYTECAST_BROWSE_LELINK_VERSION = "ByteCast_Browse_Lelink_Version";
    public static final String BYTECAST_BROWSE_RESULT = "ByteCast_Browse_Result";
    public static final String BYTECAST_BROWSE_RESULT_PROTOCOL_V2 = "bytecast_browse_result_protocol_v2";
    public static final String BYTECAST_BROWSE_RESULT_V2 = "bytecast_browse_result_v2";
    public static final String BYTECAST_CAST = "bytecast_cast";
    public static final String BYTECAST_CASTPROXY_DECODE_DATA = "ByteCast_CastProxy_Decode_Data";
    public static final String BYTECAST_CASTPROXY_EXCEPTION = "bytecast_castproxy_exception";
    public static final String BYTECAST_CASTPROXY_PACK_PROXY_URL = "bytecast_castproxy_pack_proxy_url";
    public static final String BYTECAST_CASTPROXY_RECEIVE_ENCRYPT_DATA = "bytecast_castproxy_receive_encrypt_data";
    public static final String BYTECAST_CASTPROXY_RECEIVE_URL = "ByteCast_CastProxy_Receive_URL";
    public static final String BYTECAST_CASTPROXY_RETURN_DATA = "ByteCast_CastProxy_Return_Data";
    public static final String BYTECAST_CASTPROXY_START = "ByteCast_CastProxy_Start";
    public static final String BYTECAST_CASTPROXY_STOP = "ByteCast_CastProxy_STOP";
    public static final String BYTECAST_CONFIG_FAILURE = "ByteCast_Config_Failure";
    public static final String BYTECAST_CONFIG_SUCCESS = "ByteCast_Config_Success";
    public static final String BYTECAST_CRYPTO_DECRYPT = "ByteCast_Crypto_Decrypt";
    public static final String BYTECAST_CRYPTO_ENCRYPT = "ByteCast_Crypto_Encrypt";
    public static final String BYTECAST_CRYPTO_FILL_DEVICEINFO = "ByteCast_Crypto_Fill_DeviceInfo";
    public static final String BYTECAST_CRYPTO_PARSE_DEVICEINFO = "ByteCast_Crypto_Parse_DeviceInfo";
    public static final String BYTECAST_DANMAKU_SETTING = "bytecast_danmaku_setting";
    public static final String BYTECAST_DRAMA_CLEAR = "bytecast_drama_clear";
    public static final String BYTECAST_DRAMA_DELETE = "bytecast_drama_delete";
    public static final String BYTECAST_DRAMA_ERROR_ID_NULL = "bytecast_drama_error_id_null";
    public static final String BYTECAST_DRAMA_ERROR_LIST_NULL = "bytecast_drama_error_list_null";
    public static final String BYTECAST_DRAMA_NEXT = "bytecast_drama_next";
    public static final String BYTECAST_DRAMA_PLAY = "bytecast_drama_play";
    public static final String BYTECAST_DRAMA_PRE = "bytecast_drama_pre";
    public static final String BYTECAST_DRAMA_SET_URL = "bytecast_drama_set_url";
    public static final String BYTECAST_GENERATE_LINK_INFO = "bytecast_generate_link_info";
    public static final String BYTECAST_GENERATE_LINK_INFO_FAILURE = "bytecast_generate_link_info_failure";
    public static final String BYTECAST_GET_DEVICE_INFO = "ByteCast_Get_Device_Info";
    public static final String BYTECAST_GRAY_CONFIG_REQUEST = "bytecast_gray_config_request";
    public static final String BYTECAST_GRAY_CONFIG_RESPONSE = "bytecast_gray_config_response";
    public static final String BYTECAST_LICENSE_AUTH_RESULT = "bytecast_license_auth_result";
    public static final String BYTECAST_LICENSE_CACHE = "bytecast_license_cache";
    public static final String BYTECAST_LICENSE_CHECK = "bytecast_license_check";
    public static final String BYTECAST_LICENSE_DOWNLOAD = "bytecast_license_download";
    public static final String BYTECAST_LICENSE_IMPORT = "bytecast_license_import";
    public static final String BYTECAST_LICENSE_SAVE = "bytecast_license_save";
    public static final String BYTECAST_LOADMIRROR = "loadMirror";
    public static final String BYTECAST_MIRROR_ON_CAST_CANCEL = "bytecast_mirror_on_cast_cancel";
    public static final String BYTECAST_MIRROR_ON_CAST_SUCCESS = "bytecast_mirror_on_cast_success";
    public static final String BYTECAST_MIRROR_ON_CONNECT_SUCCESS = "bytecast_mirror_on_connect_success";
    public static final String BYTECAST_MIRROR_ON_DISCONNECT = "bytecast_mirror_on_disconnect";
    public static final String BYTECAST_MIRROR_ON_ERROR = "bytecast_mirror_on_error";
    public static final String BYTECAST_NETWORK = "bytecast_network";
    public static final String BYTECAST_ONCAST_REQUEST = "bytecast_on_cast_request";
    public static final String BYTECAST_ON_CONNECT_SUCCESS_PROTOCOL_V2 = "bytecast_on_connect_success_protocol_v2";
    public static final String BYTECAST_ON_DISCONNECT_PROTOCOL_V2 = "bytecast_on_disconnect_protocol_v2";
    public static final String BYTECAST_PARAM_STATE_FAILURE = "failure";
    public static final String BYTECAST_PARAM_STATE_START = "start";
    public static final String BYTECAST_PARAM_STATE_SUCCESS = "success";
    public static final String BYTECAST_PARSE_LINK_INFO = "bytecast_parse_link_info";
    public static final String BYTECAST_PARSE_LINK_INFO_FAILURE = "bytecast_parse_link_info_failure";
    public static final String BYTECAST_PAUSE = "ByteCast_Pause";
    public static final String BYTECAST_PLAY = "ByteCast_Play";
    public static final String BYTECAST_PLAY_FAILURE = "ByteCast_Play_Failure";
    public static final String BYTECAST_PLAY_FAILURE_INFO = "ByteCast_Play_Failure_Info";
    public static final String BYTECAST_PLAY_PROTOCOL_V2 = "bytecast_play_protocol_v2";
    public static final String BYTECAST_PLAY_SUCCESS = "ByteCast_Play_Success";
    public static final String BYTECAST_PLAY_SUCCESS_PROTOCOL_V2 = "bytecast_play_success_protocol_v2";
    public static final String BYTECAST_RESOLUTION = "bytecast_resolution";
    public static final String BYTECAST_RESUME = "ByteCast_Resume";
    public static final String BYTECAST_SEEK = "bytecast_seek";
    public static final String BYTECAST_SET_DEVICE_NAME = "ByteCast_Set_Device_Name";
    public static final String BYTECAST_SET_MANUFACTURER = "bytecast_manufacturer_v2";
    public static final String BYTECAST_SINK_AUTH_LOCAL = "ByteCast_SINK_Auth_LOCAL";
    public static final String BYTECAST_SINK_AUTH_ONLINE = "ByteCast_SINK_Auth_Online";
    public static final String BYTECAST_SINK_DRAMA_INFO = "bytecast_sink_drama_info";
    public static final String BYTECAST_SINK_GET_DRAMA_ID = "bytecast_sink_get_drama_id";
    public static final String BYTECAST_SINK_GET_DRAMA_LIST = "bytecast_sink_get_drama_list";
    public static final String BYTECAST_SINK_GET_PROTOCOLS_VERSION = "ByteCast_Sink_Get_Protocols_Version";
    public static final String BYTECAST_SINK_NET_CHANGED = "bytecast_sink_network_changed";
    public static final String BYTECAST_SINK_NET_LOST = "bytecast_sink_network_lost";
    public static final String BYTECAST_SINK_PLAY_DURATION = "bytecast_sink_play_duration";
    public static final String BYTECAST_SINK_PLAY_POSTION = "bytecast_sink_play_position";
    public static final String BYTECAST_SINK_PLAY_SCHEDULE = "bytecast_sink_play_schedule";
    public static final String BYTECAST_SINK_PLAY_STATE = "bytecast_sink_play_state";
    public static final String BYTECAST_SOURCE_AUTH_LOCAL = "ByteCast_Source_Auth_LOCAL";
    public static final String BYTECAST_SOURCE_GET_PROTOCOLS_VERSION = "ByteCast_Source_Get_Protocols_Version";
    public static final String BYTECAST_SOURCE_TRACK_DRAMA = "bytecast_source_track_drama";
    public static final String BYTECAST_SPEED = "bytecast_speed";
    public static final String BYTECAST_START_BROWSE_ALL = "ByteCast_Start_Browse_All";
    public static final String BYTECAST_START_BROWSE_PROTOCOL = "ByteCast_Start_Browse_Protocol";
    public static final String BYTECAST_START_BROWSE_PROTOCOL_V2 = "bytecast_start_browse_protocol_v2";
    public static final String BYTECAST_START_BROWSE_V2 = "bytecast_start_browse_v2";
    public static final String BYTECAST_START_MIRROR = "bytecast_start_mirror";
    public static final String BYTECAST_START_SERVER = "bytecast_start_server";
    public static final String BYTECAST_START_SERVER_FAILURE = "bytecast_start_server_failure";
    public static final String BYTECAST_START_SERVER_SUCCESS = "bytecast_start_server_success";
    public static final String BYTECAST_STOP = "ByteCast_Stop";
    public static final String BYTECAST_STOP_BROWSE_ALL = "ByteCast_Stop_Browse_All";
    public static final String BYTECAST_STOP_BROWSE_PROTOCOL = "ByteCast_Stop_Browse_Protocol";
    public static final String BYTECAST_STOP_BROWSE_PROTOCOL_V2 = "bytecast_stop_browse_protocol_v2";
    public static final String BYTECAST_STOP_BROWSE_V2 = "bytecast_stop_browse_v2";
    public static final String BYTECAST_STOP_MIRROR = "bytecast_stop_mirror";
    public static final String BYTECAST_STOP_SERVER = "bytecast_stop_server";
    public static final String BYTECAST_THREAD_POOL_DISCARD_ERROR = "bytecast_threadpool_discard_oldest_policy_error";
    public static final String BYTECAST_UNBIND_SDK = "bytecast_unbind_sdk";
    public static final String BYTECAST_VIDEO_DURATION = "bytecast_video_duration";
    public static final String BYTECAST_VOLUME = "bytecast_volume";
    public static final String BYTELINK_BROWSE_SUCCESS = "bytelink_browse_success";
    public static final String BYTELINK_CAST_FAILED = "bytelink_cast_failed";
    public static final String BYTELINK_CAST_ONSTOP = "bytelink_cast_onStop";
    public static final String BYTELINK_CAST_SUCCESS = "bytelink_cast_success";
    public static final String BYTELINK_CONNECT = "bytelink_connect";
    public static final String BYTELINK_CONNECT_FAILED = "bytelink_connect_failed";
    public static final String BYTELINK_CONNECT_SUCCESS = "bytelink_connect_success";
    public static final String BYTELINK_DISCONNECT = "bytelink_disconnect";
    public static final String BYTELINK_FIRST_REMOTE_VIDEO = "bytelink_first_remote_video";
    public static final String BYTELINK_LATENCY_STAT = "bytelink_latency_stat";
    public static final String BYTELINK_MIRROR_QOS = "bytelink_mirror_qos";
    public static final String BYTELINK_MIRROR_STATS = "bytelink_mirror_stats";
    public static final String BYTELINK_ONBROWSE = "bytelink_onBrowse";
    public static final String BYTELINK_ONCAST = "bytelink_onCast";
    public static final String BYTELINK_ONCONNECT = "bytelink_onConnect";
    public static final String BYTELINK_ONDISCONNECT = "bytelink_onDisConnect";
    public static final String BYTELINK_ONERROR = "bytelink_onError";
    public static final String BYTELINK_ONINFO = "bytelink_onInfo";
    public static final String BYTELINK_ONVOLUME = "bytelink_onVolume";
    public static final String BYTELINK_SERVER_ONSTOP = "bytelink_server_onStop";
    public static final String BYTELINK_START_BROWSE = "bytelink_start_browse";
    public static final String BYTELINK_START_CAST = "bytelink_start_cast";
    public static final String BYTELINK_START_SERVER = "bytelink_start_server";
    public static final String BYTELINK_START_SERVER_FAILED = "bytelink_start_server_failed";
    public static final String BYTELINK_START_SERVER_SUCCESS = "bytelink_start_server_success";
    public static final String BYTELINK_STOP_BROWSE = "bytelink_stop_browse";
    public static final String BYTELINK_STOP_CAST = "bytelink_stop_cast";
    public static final String BYTELINK_STOP_SERVER = "bytelink_stop_server";
    public static final String BYTELINK_STUCK_STAT = "bytelink_stuck_stat";
    public static final String ByteLinkMonitor = "ByteLinkMonitor";
    public static final String CHROMECAST_PLAY_FAILURE = "chromecast_play_failure";
    public static final String DISPATCHER_COUNT = "Dispatcher_Count";
    public static final int EVENT_LOG_LIMIT = 65539;
    public static final int EVENT_LOG_NORMAL = 65538;
    public static final String EVENT_PARAM_BYTECAST_NETWORK_STATE = "state";
    public static final String EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED = "changed";
    public static final String EVENT_PARAM_BYTECAST_NETWORK_STATE_LOST = "lost";
    public static final String EVENT_PARAM_BYTECAST_NETWORK_TYPE = "network_type";
    public static final String EVENT_PARAM_BYTECAST_NETWORK_TYPE_WIFI = "wifi";
    public static final String EVENT_PARAM_BYTECAST_NETWORK_TYPE_WWAN = "wwan";
    public static final String EVENT_PLAY = "event_play";
    public static final int EVENT_TRACK = 65537;
    public static final String HTTP_POST_FAIlURE = "Http_Post_Failure";
    public static final String LELINK_AUTH_FAILURE = "LeLink_Auth_Failure";
    public static final String LELINK_AUTH_INFO = "LeLink_Auth_Info";
    public static final String LELINK_AUTH_SUCCESS = "LeLink_Auth_Success";
    public static final String LELINK_BROWSE_SUCCESS = "LeLink_Browse_Success";
    public static final String LELINK_LOADING = "LeLink_Loading";
    public static final String LELINK_PLAY = "LeLink_Play";
    public static final String LELINK_PLAY_FAILURE = "LeLink_Play_Failure";
    public static final String LELINK_PLAY_SUCCESS = "LeLink_Play_Success";
    public static final String LELINK_START_BROWSE = "LeLink_Start_Browse";
    public static final String LELINK_STOP_BROWSE = "LeLink_Stop_Browse";
    public static final String NORMAL_OFFLINE = "normal_offline";
    public static final String NSD_GET_DEVICE_INFO_RESULT = "nsd_get_device_info_result";
    public static final String NSD_ONERROR = "Nsd_onError";
    public static final String NSD_REGISTER_SERVICE = "Nsd_Register_Service";
    public static final String NSD_SERVICE_BROWSE_SUCCESS = "nsd_service_browse_success";
    public static final String NSD_SERVICE_DISCOVERY_FAILURE = "Nsd_Service_Discovery_Failure";
    public static final String NSD_SERVICE_FOUND = "Nsd_Service_Found";
    public static final String NSD_SERVICE_LOST = "Nsd_Service_Lost";
    public static final String NSD_SERVICE_OFFLINE = "Nsd_Service_Offline";
    public static final String NSD_SERVICE_QUERY_ANSWERED = "Nsd_Service_Query_Answered";
    public static final String NSD_SERVICE_QUERY_ANSWERED_EXT = "Nsd_Service_Query_Answered_Ext";
    public static final String NSD_SERVICE_QUERY_FAILURE = "Nsd_Service_Query_Failure";
    public static final String NSD_SERVICE_REGISTER_FAILURE = "Nsd_Service_Register_Failure";
    public static final String NSD_SERVICE_REGISTER_SUCCESS = "Nsd_Service_Register_Success";
    public static final String NSD_SERVICE_RESOLVED = "Nsd_Service_Resolved";
    public static final String NSD_SERVICE_RESOLVED_EXT = "Nsd_Service_Resolved_Ext";
    public static final String NSD_SERVICE_RESOLVE_FAILURE = "Nsd_Service_Resolve_Failure";
    public static final String NSD_SERVICE_STOP_DISCOVERY_FAILURE = "Nsd_Service_Stop_Discovery_Failure";
    public static final String NSD_SERVICE_UNREGISTERED = "Nsd_Service_Unregistered";
    public static final String NSD_SERVICE_UNREGISTER_FAILURE = "Nsd_Service_Unregister_Failure";
    public static final String NSD_START_DISCOVERY = "Nsd_Start_Discovery";
    public static final String NSD_START_QUERY_RECORDS = "Nsd_Start_Query_Records";
    public static final String NSD_START_RESOLVE = "Nsd_Start_Resolve";
    public static final String NSD_STOP_DISCOVERY = "Nsd_Stop_Discovery";
    public static final String NSD_UNREGISTER_SERVICE = "Nsd_Unregister_Service";
    public static final String PRIVATE_PROTOCOL_ERROR = "private_protocol_error";
    public static final String PRIVATE_PROTOCOL_RECEIVE = "private_protocol_receive";
    public static final String PRIVATE_PROTOCOL_SEND = "private_protocol_send";
    public static final String RTCLINK_SINK_JOIN_ROOM = "rtclink_sink_join_room";
    public static final String RTCLINK_SINK_JOIN_ROOM_FAILURE = "rtclink_sink_join_failure";
    public static final String RTCLINK_SINK_JOIN_ROOM_SUCCESS = "rtclink_sink_join_success";
    public static final String RTCLINK_SINK_LEAVE_ROOM = "rtclink_sink_leave_room";
    public static final String RTCLINK_SINK_PEER_JOIN_ROOM = "rtclink_sink_peer_join_room";
    public static final String RTCLINK_SOURCE_JOIN_ROOM = "rtclink_source_join_room";
    public static final String RTCLINK_SOURCE_JOIN_ROOM_FAILURE = "rtclink_source_join_failure";
    public static final String RTCLINK_SOURCE_JOIN_ROOM_SUCCESS = "rtclink_source_join_success";
    public static final String RTCLINK_SOURCE_LEAVE_ROOM = "rtclink_source_leave_room";
    public static final String RTCLINK_SOURCE_PEER_JOIN_ROOM = "rtclink_source_peer_join_room";
    public static final String SSDP_RECEIVE_SUCCESS = "ssdp_receive_success";
    public static final String SSDP_START_BROWSE = "ssdp_start_browse";
    public static final String SSDP_START_BROWSE_FAILED = "ssdp_start_browse_failed";
    public static final String SSDP_START_BROWSE_SUCCESS = "ssdp_start_browse_success";
    public static final String SSDP_START_SERVER = "ssdp_start_server";
    public static final String SSDP_START_SERVER_FAILED = "ssdp_start_server_failed";
    public static final String SSDP_START_SERVER_SUCCESS = "ssdp_start_server_success";
    public static final String SSDP_STOP_BROWSE = "ssdp_stop_browse";
    public static final String SSDP_STOP_SERVER = "ssdp_stop_server";
    private static final String TAG = "Monitor";
    public static final String WIFI_P2P_CAST_TYPE_BYTELINK = "p2p_bytelink";
    public static final String WIFI_P2P_CONNECT = "wifi_p2p_connect";
    public static final String WIFI_P2P_CONNECT_FAILURE = "wifi_p2p_connect_failure";
    public static final String WIFI_P2P_CONNECT_SUCCESS = "wifi_p2p_connect_success";
    public static String WifiP2PType = "";
    private static volatile Boolean isMonitorExist;
    private static volatile CastMonitor sInst;
    private String HOST_AID;
    private IAppCommonDataListener appCommonDataListener;
    private String appKey;
    public String browseId;
    public String castId;
    private JSONObject categoryAirLogMonitor;
    public String clientId;
    private Context context;
    private String deviceId;
    private ContextManager.CastContext mCastContext;
    private CastLogger mLogger;
    private SourceMonitorUtils mSourceMonitor;
    private final Map<String, Integer> mapAirplayTag;
    private int num;
    private String projectId;
    private String protocols;
    public String role;
    private String sessionID;
    public String sourceConnectID;

    public static /* synthetic */ Class access$001(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public void setSessionID(String r100) {
    }

    private CastMonitor getInst() {
        if (sInst != null) goto L10;
        if (Constants.isDebugMode == true) goto L8;
        this.mLogger.e(TAG, "Please use getInst with args method first.");
        goto L10
    L8:
        throw new IllegalArgumentException("Please use getInst with args method first.");
    L10:
        return sInst;
    }

    public static CastMonitor getInstance() {
        if (sInst != null) goto L15;
        monitor-enter(CastMonitor.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInst != null) goto L9;
        sInst = new CastMonitor(null);     // Catch: Throwable -> L11
    L9:
        monitor-exit(CastMonitor.class);     // Catch: Throwable -> L11
    L15:
        return sInst;
    }

    public static boolean isMonitorUtilsExist() {
        if (isMonitorExist != null) goto L17;
        monitor-enter(CastMonitor.class);
    L13:
        th = move-exception;
        throw th;
    L7:
        if (isMonitorExist == null) goto L23;
    L11:
        monitor-exit(CastMonitor.class);     // Catch: Throwable -> L13
        goto L17
    L23:
        INVOKESTATIC_com_byted_cast_common_CastMonitor_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.bytedance.framwork.core.sdkmonitor.SDKMonitorUtils");     // Catch: Throwable -> L10
        isMonitorExist = Boolean.TRUE;     // Catch: Throwable -> L10
    L10:
        Logger.w(TAG, "no sdk monitor class found");     // Catch: Throwable -> L13
        isMonitorExist = Boolean.FALSE;     // Catch: Throwable -> L13
    L17:
        if (isMonitorExist != Boolean.TRUE) goto L19;
        return true;
    L19:
        return false;
    }

    private void endAirLog() {
        if (isMonitorUtilsExist() == true) goto L6;
        return;
    L6:
        if (this.categoryAirLogMonitor == null) goto L9;
        JSONObject r100 = new JSONObject();
        addParametersToJSON(r100, "session_id", this.sessionID);
        SDKMonitorUtils.getInstance(AID).monitorEvent(AirPlayMonitor, this.categoryAirLogMonitor, null, r100);
        this.categoryAirLogMonitor = null;
        return;
    }

    private void initSdkMonitor() {
        if (isMonitorUtilsExist() == true) goto L5;
        return;
    L5:
        JSONObject r100 = new JSONObject();
        this.mLogger.d(TAG, "device id:" + this.deviceId);
        addParametersToJSON(r100, "device_id", this.deviceId);
        addParametersToJSON(r100, "host_aid", this.HOST_AID);
        addParametersToJSON(r100, "sdk_version", BuildConfig.VERSION_NAME);
        addParametersToJSON(r100, "channel", Utils.getAppName(this.context));
        addParametersToJSON(r100, "app_version", Utils.getAppVersionName(this.context));
        addParametersToJSON(r100, "time_stamp", String.valueOf(System.currentTimeMillis()));
        SDKMonitorUtils.setConfigUrl(AID, UrlUtils.getDefaultMonitorConfigUrl());
        SDKMonitorUtils.setDefaultReportUrl(AID, UrlUtils.getDefaultMonitorReportUrl());
        SDKMonitorUtils.initMonitor(this.context.getApplicationContext(), AID, r100, new AnonymousClass1(this));
    }

    public String getSessionID() {
        return this.sessionID;
    }

    public SourceMonitorUtils getSourceMonitor() {
        return this.mSourceMonitor;
    }

    private CastMonitor(ContextManager.CastContext r100) {
        this.HOST_AID = Constants.DEMO_HOST_AID;
        this.sessionID = "";
        this.appKey = "";
        this.projectId = "";
        this.role = "";
        this.sourceConnectID = "";
        this.browseId = "";
        this.castId = "";
        this.clientId = "";
        this.mapAirplayTag = new AnonymousClass2(this);
        this.categoryAirLogMonitor = null;
        this.num = 0;
        this.mCastContext = r100;
        this.mLogger = ContextManager.getLogger(r100);
        this.mSourceMonitor = new SourceMonitorUtils(this);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_byted_cast_common_CastMonitor_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r103 = access$001(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r104 = access$001(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    public static /* synthetic */ String access$000(CastMonitor r100) {
        return r100.HOST_AID;
    }

    private String addAppCommonDataToJSON(JSONObject r310) {
        String r100 = String.valueOf(ContextManager.getNsdHelper(this.mCastContext).isEnableDnssd());
        String r101 = String.valueOf(ContextManager.getNsdHelper(this.mCastContext).isEnableJmdns());
        ContextManager.CastContext r102 = this.mCastContext;
        if (r102 != null) goto L5;
    L7:
        boolean r103 = false;
    L8:
        String r104 = String.valueOf(r103);
        String r105 = String.valueOf(WifiUtils.isBlePublish());
        String r106 = String.valueOf(DLNAOptionUtils.isEnableCache(this.mCastContext));
        String r107 = String.valueOf(DLNAOptionUtils.isEnableDlnaSearch(this.mCastContext));
        String r108 = String.valueOf(DLNAOptionUtils.isEnableBroadcastSearch(this.mCastContext));
        String r110 = String.valueOf(DLNAOptionUtils.isEnableDeviceOffline(this.mCastContext));
        String r111 = String.valueOf(DLNAOptionUtils.getDlnaOfflineInterval(this.mCastContext));
        String r112 = String.valueOf(DLNAOptionUtils.getBdlinkDeviceOfflineDetectInterval(this.mCastContext));
        String r113 = String.valueOf(DLNAOptionUtils.isEnableBdlinkQuickQuery(this.mCastContext));
        ICastAuth r114 = ContextManager.getAuthManager(this.mCastContext);
        String r109 = r114.getLicenseParam(AuthConstants.PARAM_KEY_LICENSE_ID);
        String r115 = r114.getLicenseParam(AuthConstants.PARAM_KEY_LICENSE_BUSINESS_ID);
        String r116 = r114.getLicenseParam(AuthConstants.PARAM_KEY_LICENSE_APP_ID);
        String r117 = r114.getLicenseParam("channel_id");
        String r118 = String.valueOf(DLNAOptionUtils.isEnableBdlinkDiskCache(this.mCastContext));
        String r119 = String.valueOf(DLNAOptionUtils.isEnableSsdpSearch(this.mCastContext));
        String r120 = String.valueOf(DLNAOptionUtils.isEnableSsdpCycleSearch(this.mCastContext));
        String r121 = String.valueOf(DLNAOptionUtils.isEnableSinkSsdpServer(this.mCastContext));
        String r122 = String.valueOf(DLNAOptionUtils.isEnableSinkBDLinkSSDPBroadcast(null));
        String r123 = String.valueOf(DLNAOptionUtils.isEnableSourceBDLinkSSDPBroadcast(this.mCastContext));
        if (TextUtils.equals(this.role, "source") == false) goto L11;
    L14:
        String r124 = String.valueOf(DLNAOptionUtils.isEnableDlnaSourceCustomizedService(this.mCastContext));
    L15:
        String r125 = String.valueOf(DLNAOptionUtils.isOpenDlnaLowPerformanceMode());
        String r311 = r124;
        addParametersToJSON(r310, "browse_id", this.browseId);
        addParametersToJSON(r310, "enable_cache", r106);
        addParametersToJSON(r310, "enable_search", r107);
        addParametersToJSON(r310, "enable_broadcast", r108);
        addParametersToJSON(r310, "enable_dnssd", r100);
        addParametersToJSON(r310, "enable_jmdns", r101);
        addParametersToJSON(r310, "protocols", this.protocols);
        addParametersToJSON(r310, "ble_browse", r104);
        addParametersToJSON(r310, "ble_publish", r105);
        addParametersToJSON(r310, "enable_device_offline", r110);
        addParametersToJSON(r310, "dlna_offline_interval", r111);
        addParametersToJSON(r310, "bdlink_offline_interval", r112);
        addParametersToJSON(r310, "bdlink_enable_quick_query", r113);
        addParametersToJSON(r310, "wifi_p2p_cast_type", WifiP2PType);
        addParametersToJSON(r310, AuthConstants.PARAM_KEY_LICENSE_ID, r109);
        addParametersToJSON(r310, AuthConstants.PARAM_KEY_LICENSE_BUSINESS_ID, r115);
        addParametersToJSON(r310, AuthConstants.PARAM_KEY_LICENSE_APP_ID, r116);
        addParametersToJSON(r310, AuthConstants.PARAM_KEY_LICENSE_PROJECT_ID, this.projectId);
        addParametersToJSON(r310, "channel_id", r117);
        addParametersToJSON(r310, "bdlink_enable_disk_cache", r118);
        addParametersToJSON(r310, "ssdp_search", r119);
        addParametersToJSON(r310, "ssdp_cycle_search", r120);
        addParametersToJSON(r310, "sink_ssdp_server", r121);
        addParametersToJSON(r310, "source_ssdp_broadcast", r123);
        addParametersToJSON(r310, "sink_ssdp_broadcast", r122);
        addParametersToJSON(r310, "enable_dlna_customized_service", r311);
        addParametersToJSON(r310, "enable_dlna_low_performance_mode", r125);
        addParametersToJSON(r310, "cast_did", ContextManager.getConfigManager(this.mCastContext).getInitConfig().getOriginDeviceId());
        String r126 = NetworkUtil.getCurrentNetworkType(Constants.sAppContext).toString();
        String r127 = "1";
        if (NetworkUtil.isWifiProxy() == false) goto L18;
        String r128 = "1";
    L20:
        if (NetworkUtil.isVpnInUse() == true) goto L23;
        r127 = "0";
    L23:
        String r129 = NetworkUtil.getWifiBandWidth();
        String r130 = NetworkUtil.getWifiRTT();
        String r131 = NetworkUtil.getWifiLossRate();
        addParametersToJSON(r310, "net_type", r126);
        addParametersToJSON(r310, "net_proxy_status", r128);
        addParametersToJSON(r310, "net_vpn_status", r127);
        addParametersToJSON(r310, "net_wifi_bandwidth", r129);
        addParametersToJSON(r310, "net_wifi_rtt", r130);
        addParametersToJSON(r310, "net_wifi_loss_rate", r131);
        IAppCommonDataListener r132 = this.appCommonDataListener;
        if (r132 == null) goto L26;
        Map<String, Object> r133 = r132.getData();
        if (r133 == null) goto L42;
        if (r133.size() < 1) goto L42;
        Iterator<String> r134 = r133.keySet().iterator();
    L34:
        if (r134.hasNext() == false) goto L40;
        String r135 = r134.next();     // Catch: Exception -> L37
        addParametersToJSON(r310, r135, String.valueOf(r133.get(r135)));     // Catch: Exception -> L37
    L37:
        e = move-exception;
        this.mLogger.e(TAG, e.toString());
        goto L34
    L40:
        return r310.toString();
    L42:
        return r310.toString();
    L26:
        return r310.toString();
    L18:
        r128 = "0";
        goto L20
    L11:
        if (TextUtils.equals(this.role, "default") == true) goto L14;
        r124 = String.valueOf(DLNAOptionUtils.isEnableDlnaSinkCustomizedService(this.mCastContext));
        goto L15
    L5:
        if (r102.isBleBrowse() == false) goto L7;
        r103 = true;
        goto L8
    }

    public static CastMonitor createInstance(ContextManager.CastContext r100) {
        if (r100 != null) goto L6;
        return getInstance();
    L6:
        return new CastMonitor(r100);
    }

    private String getProtocolByEventName(String r100) {
        String r101 = "BDDLNA";
        if (r100.contains("BDDLNA") == false) goto L5;
    L51:
        return r101;
    L5:
        if (r100.contains("bddlna") == true) goto L51;
        r101 = "BDLink";
        if (r100.contains("BDLink") == true) goto L51;
        if (r100.contains("bdlink") == true) goto L51;
        r101 = "ByteLink";
        if (r100.contains("ByteLink") == true) goto L51;
        if (r100.contains("bytelink") == true) goto L51;
        r101 = "AirPlay";
        if (r100.contains("AirPlay") == true) goto L51;
        if (r100.contains("airplay") == true) goto L51;
        r101 = "CastProxy";
        if (r100.contains("CastProxy") == true) goto L51;
        if (r100.contains("castproxy") == true) goto L51;
        r101 = "LeLink";
        if (r100.contains("LeLink") == true) goto L51;
        if (r100.contains("lelink") == true) goto L51;
        if (r100.contains("VASTCAST") == false) goto L35;
        return "VastCast";
    L35:
        if (r100.contains("v-cast") == false) goto L38;
        return "VastCast";
    L38:
        if (r100.contains("BDCloud") == false) goto L40;
    L48:
        return "bdcloud";
    L40:
        if (r100.contains("bdcloud") == true) goto L48;
        if (r100.contains("USB") == false) goto L46;
        return "wired_android";
    L46:
        return Constants.BYTECAST_DEFAULT_DEVICE_NAME;
    }

    public void sendEvent(String r100) {
        JSONObject r101 = new JSONObject();
        addParametersToJSON(r101, "event", r100);
        sendByteCastSinkEvent(BDDLNA_SEND_EVENT, r101, null, null);
    }

    public void sendGrayConfigRequestEvent(String r100) {
        if (isMonitorUtilsExist() == true) goto L5;
        return;
    L5:
        JSONObject r101 = new JSONObject();
        JSONObject r102 = new JSONObject();
        addParametersToJSON(r102, "config_name", r100);
        addParametersToJSON(r102, "role", this.role);
        addParametersToJSON(r102, "time_stamp", String.valueOf(System.currentTimeMillis()));
        addParametersToJSON(r101, "app_key", this.appKey);
        addParametersToJSON(r101, AuthConstants.PARAM_KEY_LICENSE_PROJECT_ID, this.projectId);
        addParametersToJSON(r101, "session_id", this.sessionID);
        addParametersToJSON(r101, "connect_id", null);
        addParametersToJSON(r101, "cast_id", this.castId);
        addParametersToJSON(r101, "client_id", this.clientId);
        addParametersToJSON(r101, "cast_info", null);
        addParametersToJSON(r101, "player_info", null);
        String r103 = addAppCommonDataToJSON(r101);
        SDKMonitorUtils.getInstance(AID).monitorEvent(BYTECAST_GRAY_CONFIG_REQUEST, r102, null, r101);
        this.mLogger.d(TAG, "sendGrayConfigEvent:bytecast_gray_config_request, role:" + this.role + ", configName:" + r100 + ", data:" + r103);
    }

    public void sentBDCloudSinkRegisterListEvent(String r100) {
        JSONObject r101 = new JSONObject();
        addParametersToJSON(r101, "bdCloudServiceInfos", r100);
        addParametersToJSON(r101, "role", Constants.ROLE_SINK);
        sendByteCastSinkEvent(BDLINK_GET_REGISTER_LIST, r101, null, null);
        this.mLogger.d(TAG, "sentBDCloudSinkRegisterListEvent: " + r100);
    }

    public void sentBDLinkSinkReceiveMessageEvent(String r100) {
        JSONObject r101 = new JSONObject();
        addParametersToJSON(r101, "message", r100);
        addParametersToJSON(r101, "role", Constants.ROLE_SINK);
        sendByteCastSinkEvent(BDLINK_RECEIVE_MESSAGE, r101, null, null);
        this.mLogger.d(TAG, "sentBDLinkSinkReceiveMessageEvent: " + r100);
    }

    public void sentBDLinkSinkRegisterListEvent(String r100) {
        JSONObject r101 = new JSONObject();
        addParametersToJSON(r101, "bdLinkServiceInfos", r100);
        addParametersToJSON(r101, "role", Constants.ROLE_SINK);
        sendByteCastSinkEvent(BDLINK_GET_REGISTER_LIST, r101, null, null);
        this.mLogger.d(TAG, "sentBDLinkSinkRegisterListEvent: " + r100);
    }

    public void sentBDLinkSourceReceiveMessageEvent(String r100) {
        JSONObject r101 = new JSONObject();
        addParametersToJSON(r101, "message", r100);
        addParametersToJSON(r101, "role", "source");
        sendByteCastSourceEvent(BDLINK_RECEIVE_MESSAGE, r101, null);
        this.mLogger.d(TAG, "sentBDLinkSourceReceiveMessageEvent: " + r100);
    }

    public void sentByteCastGetDeviceInfoEvent(String r100) {
        JSONObject r101 = new JSONObject();
        addParametersToJSON(r101, "deviceInfo", r100);
        addParametersToJSON(r101, "role", "source");
        sendByteCastSourceEvent(BYTECAST_GET_DEVICE_INFO, r101, null);
        this.mLogger.d(TAG, "sentByteCastGetDeviceInfoEvent: " + r100);
    }

    public void sentByteCastSetDeviceNameEvent(String r100) {
        JSONObject r101 = new JSONObject();
        addParametersToJSON(r101, "deviceName", r100);
        addParametersToJSON(r101, "role", "source");
        sendByteCastSourceEvent(BYTECAST_SET_DEVICE_NAME, r101, null);
    }

    public void sentByteCastSinkGetDeviceInfoEvent(String r100) {
        JSONObject r101 = new JSONObject();
        addParametersToJSON(r101, "deviceInfo", r100);
        addParametersToJSON(r101, "role", Constants.ROLE_SINK);
        sendByteCastSinkEvent(BYTECAST_GET_DEVICE_INFO, r101, null, null);
        this.mLogger.d(TAG, "sentByteCastSinkGetDeviceInfoEvent: " + r100);
    }

    public void setAppCommonDataListener(IAppCommonDataListener r100) {
        this.appCommonDataListener = r100;
    }

    public void setProtocols(String r100) {
        this.protocols = r100;
    }

    private String getServiceTypeByEventName(String r100, String r101) {
        if (r101 == null) goto L7;
        if (r101.isEmpty() == true) goto L7;
        return r101;
    L7:
        if (r100.contains("BDDLNA") == false) goto L9;
    L55:
        return "push";
    L9:
        if (r100.contains("bddlna") == true) goto L55;
        if (r100.contains("BDLink") == true) goto L55;
        if (r100.contains("bdlink") == true) goto L55;
        if (r100.contains("ByteLink") == false) goto L19;
        return BroadcastSDKServiceImpl.BG_FRAGMENT_TYPE_MIRROR;
    L19:
        if (r100.contains("bytelink") == false) goto L22;
        return BroadcastSDKServiceImpl.BG_FRAGMENT_TYPE_MIRROR;
    L22:
        if (r100.contains("AirPlay") == false) goto L24;
    L52:
        return "push|mirror";
    L24:
        if (r100.contains("airplay") == true) goto L52;
        if (r100.contains("CastProxy") == false) goto L29;
    L51:
        return "proxy";
    L29:
        if (r100.contains("castproxy") == true) goto L51;
        if (r100.contains("LeLink") == false) goto L34;
    L50:
        return "push|mirror";
    L34:
        if (r100.contains("lelink") == true) goto L50;
        if (r100.contains("VASTCAST") == false) goto L39;
    L49:
        return "proxy";
    L39:
        if (r100.contains("v-cast") == true) goto L49;
        if (r100.contains("BDCloud") == false) goto L44;
    L48:
        return "push";
    L44:
        if (r100.contains("bdcloud") == true) goto L48;
        return Constants.BYTECAST_DEFAULT_DEVICE_NAME;
    }

    private void saveAirlog(String r100, String r101) {
        if (this.categoryAirLogMonitor != null) goto L5;
        this.categoryAirLogMonitor = new JSONObject();
    L5:
        Date r102 = Date.getLocalInstance();
        this.num++;
        addParametersToJSON(this.categoryAirLogMonitor, r102.getDateString() + this.num, r100 + ": " + r101);
        int r103 = this.num;
        if ((r103 & 128) == 0) goto L9;
        this.num = r103 >> 8;
        return;
    }

    public void sendAirLogMonitor(String r100, String r101) {
        if (isMonitorUtilsExist() == true) goto L6;
        return;
    L6:
        if (TextUtils.equals(r100, "Airplay_On_Session_End") == false) goto L9;
        endAirLog();
    L9:
        if (this.mapAirplayTag.containsKey(r100) == true) goto L11;
        saveAirlog(r100, r101);
        return;
    L11:
        if (this.mapAirplayTag.get(r100).intValue() != 65537) goto L14;
        saveAirlog(r100, r101);
        JSONObject r102 = new JSONObject();
        addParametersToJSON(r102, "session_id", this.sessionID);
        addParametersToJSON(r102, "cast_end", Constants.ROLE_SINK);
        addParametersToJSON(r102, "cast_protocol", "airplay");
        addParametersToJSON(r102, "content", r101);
        addParametersToJSON(r102, "time_stamp", String.valueOf(System.currentTimeMillis()));
        addAppCommonDataToJSON(r102);
        JSONObject r103 = new JSONObject();
        addParametersToJSON(r103, "session_id", this.sessionID);
        SDKMonitorUtils.getInstance(AID).monitorEvent(r100, r102, null, r103);
        return;
    L14:
        if (this.mapAirplayTag.get(r100).intValue() != 65539) goto L19;
        if (new Random().nextInt(100) >= 3) goto L24;
        saveAirlog(r100, r101);
        return;
    L24:
        return;
    L19:
        if (this.mapAirplayTag.get(r100).intValue() != 65538) goto L26;
        saveAirlog(r100, r101);
        return;
    }

    public void sendByteCastAuthEvent(String r100, int r101) {
        HashMap r102 = new HashMap();
        r102.put("init_mode", "1");
        r102.put("result", r100);
        r102.put("origin_from", "0");
        if (r101 == (-1)) goto L6;
        r102.put("err_code", String.valueOf(r101));
    L6:
        if (TextUtils.equals(this.role, "source") == false) goto L8;
    L11:
        sendSourceEvent(BYTECAST_AUTH, r102, "");
        return;
    L8:
        if (TextUtils.equals(this.role, "default") == true) goto L11;
        sendSinkEvent(BYTECAST_AUTH, r102);
    }

    public void sendSinkEvent(String r100, String r101) {
        if (isMonitorUtilsExist() == true) goto L5;
        return;
    L5:
        JSONObject r102 = new JSONObject();
        JSONObject r103 = new JSONObject();
        addParametersToJSON(r102, "content", r101);
        addParametersToJSON(r102, "role", Constants.ROLE_SINK);
        addParametersToJSON(r102, "service_type", getServiceTypeByEventName(r100, null));
        addParametersToJSON(r102, "protocol", getProtocolByEventName(r100));
        addParametersToJSON(r102, "time_stamp", String.valueOf(System.currentTimeMillis()));
        addParametersToJSON(r103, "app_key", this.appKey);
        addParametersToJSON(r103, AuthConstants.PARAM_KEY_LICENSE_PROJECT_ID, this.projectId);
        addParametersToJSON(r103, "session_id", this.sessionID);
        addParametersToJSON(r103, "connect_id", null);
        addParametersToJSON(r103, "cast_id", this.castId);
        addParametersToJSON(r103, "client_id", this.clientId);
        addParametersToJSON(r103, "player_info", null);
        addParametersToJSON(r103, "cast_info", null);
        String r104 = addAppCommonDataToJSON(r103);
        SDKMonitorUtils.getInstance(AID).monitorEvent(r100, r102, null, r103);
        this.mLogger.d(TAG, "sendSinkEvent event:" + r100 + ", content:" + r101 + ", data:" + r104);
    }

    public void sendSourceEvent(String r100, String r101) {
        if (isMonitorUtilsExist() == true) goto L5;
        return;
    L5:
        JSONObject r102 = new JSONObject();
        JSONObject r103 = new JSONObject();
        addParametersToJSON(r102, "time_stamp", String.valueOf(System.currentTimeMillis()));
        addParametersToJSON(r102, "content", r101);
        addParametersToJSON(r102, "role", "source");
        addParametersToJSON(r102, "service_type", getServiceTypeByEventName(r100, null));
        addParametersToJSON(r102, "protocol", getProtocolByEventName(r100));
        addParametersToJSON(r103, "app_key", this.appKey);
        addParametersToJSON(r103, AuthConstants.PARAM_KEY_LICENSE_PROJECT_ID, this.projectId);
        addParametersToJSON(r103, "session_id", this.sessionID);
        addParametersToJSON(r103, "connect_id", this.sourceConnectID);
        addParametersToJSON(r103, "cast_id", this.castId);
        addParametersToJSON(r103, "client_id", this.clientId);
        addParametersToJSON(r103, "player_info", null);
        addParametersToJSON(r103, "cast_info", null);
        String r104 = addAppCommonDataToJSON(r103);
        SDKMonitorUtils.getInstance(AID).monitorEvent(r100, r102, null, r103);
        this.mLogger.d(TAG, "sendSourceEvent event:" + r100 + ", content:" + r101 + ",data:" + r104);
    }

    public void sendToMetricEvent(String r100, Map<String, String> r110) {
        if (isMonitorUtilsExist() == true) goto L5;
        return;
    L5:
        if (r110 != null) goto L7;
        return;
    L7:
        if (r110.size() < 1) goto L25;
        JSONObject r101 = new JSONObject();
        JSONObject r102 = new JSONObject();
        JSONObject r103 = new JSONObject();
        addParametersToJSON(r101, "time_stamp", String.valueOf(System.currentTimeMillis()));
        addParametersToJSON(r101, "role", this.role);
        addParametersToJSON(r101, "service_type", getServiceTypeByEventName(r100, null));
        addParametersToJSON(r101, "protocol", getProtocolByEventName(r100));
        addParametersToJSON(r102, "app_key", this.appKey);
        addParametersToJSON(r102, AuthConstants.PARAM_KEY_LICENSE_PROJECT_ID, this.projectId);
        addParametersToJSON(r102, "session_id", this.sessionID);
        addParametersToJSON(r102, "connect_id", this.sourceConnectID);
        addParametersToJSON(r102, "player_info", null);
        addParametersToJSON(r102, "cast_info", null);
        String r104 = addAppCommonDataToJSON(r102);
        Iterator<String> r105 = r110.keySet().iterator();
    L11:
        if (r105.hasNext() == false) goto L16;
        String r106 = r105.next();     // Catch: Exception -> L14
        addParametersToJSON(r103, r106, String.valueOf(r110.get(r106)));     // Catch: Exception -> L14
    L14:
        e = move-exception;
        this.mLogger.e(TAG, e.toString());
        goto L11
    L16:
        SDKMonitorUtils.getInstance(AID).monitorEvent(r100, r101, r103, r102);
        this.mLogger.d(TAG, "sendSourceToMetricEvent event:" + r100 + ",metric:" + r103 + ",data:" + r104);
        return;
    }

    public void sentBDLinkRegisterEvent(String r100, String r101) {
        JSONObject r102 = new JSONObject();
        addParametersToJSON(r102, "content", r100);
        addParametersToJSON(r102, com.ss.cast.discovery.mdns.nsdhelper.NsdHelper.serviceInfoKey, r101);
        addParametersToJSON(r102, "role", "source");
        sendByteCastSourceEvent(BDLINK_REGISTER, r102, null);
        this.mLogger.d(TAG, "sentBDLinkRegisterEvent: " + r101);
    }

    public void sentBDLinkRegisterSuccessEvent(String r100, String r101) {
        JSONObject r102 = new JSONObject();
        addParametersToJSON(r102, "content", r100);
        addParametersToJSON(r102, com.ss.cast.discovery.mdns.nsdhelper.NsdHelper.serviceInfoKey, r101);
        addParametersToJSON(r102, "role", "source");
        sendByteCastSourceEvent(BDLINK_REGISTER_SUCCESS, r102, null);
        this.mLogger.d(TAG, "sentBDLinkRegisterSuccessEvent: " + r101);
    }

    public void sentBDLinkSinkSendMessageEvent(String r100, String r101) {
        JSONObject r102 = new JSONObject();
        addParametersToJSON(r102, "messageString", r101);
        addParametersToJSON(r102, com.ss.cast.discovery.mdns.nsdhelper.NsdHelper.serviceInfoKey, r100);
        addParametersToJSON(r102, "role", Constants.ROLE_SINK);
        sendByteCastSinkEvent(BDLINK_SEND_MESSAGE, r102, null, null);
        this.mLogger.d(TAG, "sentBDLinkSinkSendMessageEvent: " + r101);
    }

    public void sentBDLinkSinkSendSuccessMessageEvent(String r100, String r101) {
        JSONObject r102 = new JSONObject();
        addParametersToJSON(r102, "messageString", r101);
        addParametersToJSON(r102, com.ss.cast.discovery.mdns.nsdhelper.NsdHelper.serviceInfoKey, r100);
        addParametersToJSON(r102, "role", Constants.ROLE_SINK);
        sendByteCastSinkEvent(BDLINK_SEND_MESSAGE_SUCCESS, r102, null, null);
        this.mLogger.d(TAG, "sentBDLinkSinkSendSuccessMessageEvent: " + r101);
    }

    public void sentBDLinkSourceSendMessageEvent(String r100, String r101) {
        JSONObject r102 = new JSONObject();
        addParametersToJSON(r102, "messageString", r101);
        addParametersToJSON(r102, com.ss.cast.discovery.mdns.nsdhelper.NsdHelper.serviceInfoKey, r100);
        addParametersToJSON(r102, "role", "source");
        sendByteCastSourceEvent(BDLINK_SEND_MESSAGE, r102, null);
        this.mLogger.d(TAG, "sentBDLinkSourceSendMessageEvent: " + r101);
    }

    public void sentBDLinkSourceSendSuccessMessageEvent(String r100, String r101) {
        JSONObject r102 = new JSONObject();
        addParametersToJSON(r102, "messageString", r101);
        addParametersToJSON(r102, com.ss.cast.discovery.mdns.nsdhelper.NsdHelper.serviceInfoKey, r100);
        addParametersToJSON(r102, "role", "source");
        sendByteCastSourceEvent(BDLINK_SEND_MESSAGE_SUCCESS, r102, null);
        this.mLogger.d(TAG, "sentBDLinkSourceSendSuccessMessageEvent: " + r101);
    }

    public void sentBDLinkUnregisterEvent(String r100, String r101) {
        JSONObject r102 = new JSONObject();
        addParametersToJSON(r102, "content", r100);
        addParametersToJSON(r102, com.ss.cast.discovery.mdns.nsdhelper.NsdHelper.serviceInfoKey, r101);
        addParametersToJSON(r102, "role", "source");
        sendByteCastSourceEvent(BDLINK_UNREGISTER, r102, null);
        this.mLogger.d(TAG, "sentBDLinkUnregisterEvent: " + r101);
    }

    public void sentBDLinkUnregisterSuccessEvent(String r100, String r101) {
        JSONObject r102 = new JSONObject();
        addParametersToJSON(r102, "content", r100);
        addParametersToJSON(r102, com.ss.cast.discovery.mdns.nsdhelper.NsdHelper.serviceInfoKey, r101);
        addParametersToJSON(r102, "role", "source");
        sendByteCastSourceEvent(BDLINK_UNREGISTER_SUCCESS, r102, null);
        this.mLogger.d(TAG, "sentBDLinkUnregisterSuccessEvent: " + r101);
    }

    public void sendSinkEvent(String r100, Map<String, String> r101) {
        sendSinkEvent(r100, r101, null);
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

    public void init(Context r100, String r101, IMonitor r102) {
        this.context = r100;
        if (TextUtils.isEmpty(r101) == false) goto L5;
        this.deviceId = "12345678901";
    L6:
        initSdkMonitor();
        return;
    L5:
        this.deviceId = r101;
        goto L6
    }

    public void receiveAction(String r100, String r101, String r102) {
        JSONObject r103 = new JSONObject();
        addParametersToJSON(r103, "action", r100);
        addParametersToJSON(r103, "header", r101);
        addParametersToJSON(r103, "content", r102);
        sendByteCastSinkEvent(BDDLNA_RECEIVE_ACTION, r103, null, null);
    }

    public void receiveActionResponse(String r100, String r101, String r102) {
        JSONObject r103 = new JSONObject();
        addParametersToJSON(r103, "status_code", r100);
        addParametersToJSON(r103, "header", r101);
        addParametersToJSON(r103, "content", r102);
        sendByteCastSourceEvent(BDDLNA_RECEIVE_ACTION_RESPONSE, r103, null);
    }

    public void sendAction(String r100, String r101, String r102) {
        JSONObject r103 = new JSONObject();
        addParametersToJSON(r103, "action", r100);
        addParametersToJSON(r103, "header", r101);
        addParametersToJSON(r103, "content", r102);
        sendByteCastSourceEvent(BDDLNA_SEND_ACTION, r103, null);
    }

    public void sendByteCastNetworkEvent(String r100, String r101, String r102) {
        HashMap r103 = new HashMap();
        r103.put("content", r102);
        r103.put("state", r100);
        r103.put("net_type", r101);
        if (TextUtils.equals(this.role, "source") == false) goto L5;
    L8:
        sendSourceEvent(BYTECAST_NETWORK, r103, "");
        return;
    L5:
        if (TextUtils.equals(this.role, "default") == true) goto L8;
        sendSinkEvent(BYTECAST_NETWORK, r103);
    }

    public void sendByteCastSourceEvent(String r100, JSONObject r101, String r102) {
        if (isMonitorUtilsExist() == true) goto L5;
        return;
    L5:
        JSONObject r103 = new JSONObject();
        addParametersToJSON(r101, "service_type", getServiceTypeByEventName(r100, null));
        addParametersToJSON(r101, "protocol", getProtocolByEventName(r100));
        addParametersToJSON(r101, "role", "source");
        addParametersToJSON(r101, "time_stamp", String.valueOf(System.currentTimeMillis()));
        addParametersToJSON(r103, "app_key", this.appKey);
        addParametersToJSON(r103, AuthConstants.PARAM_KEY_LICENSE_PROJECT_ID, this.projectId);
        addParametersToJSON(r103, "session_id", this.sessionID);
        addParametersToJSON(r103, "connect_id", this.sourceConnectID);
        addParametersToJSON(r103, "cast_id", this.castId);
        addParametersToJSON(r103, "client_id", this.clientId);
        addParametersToJSON(r103, "player_info", r102);
        addParametersToJSON(r103, "cast_info", null);
        String r104 = addAppCommonDataToJSON(r103);
        SDKMonitorUtils.getInstance(AID).monitorEvent(r100, r101, null, r103);
        if (BDDLNA_SEND_ACTION.equals(r100) == false) goto L8;
        return;
    L8:
        if (BDDLNA_RECEIVE_ACTION_RESPONSE.equals(r100) == false) goto L10;
        return;
    L10:
        if (BDDLNA_RECEIVE_EVENT.equals(r100) == true) goto L15;
        this.mLogger.d(TAG, "sendByteCastSourceEvent event:" + r100 + ", session_id:" + this.sessionID + ",connect_id:" + this.sourceConnectID + ", cast_id:" + this.castId + ", client_id:" + this.clientId + ",playerInfo:" + r102 + ",data:" + r104);
        return;
    }

    public void sendCustomEvent(String r100, String r110, String[][] r111) {
        if (isMonitorUtilsExist() == true) goto L5;
        return;
    L5:
        JSONObject r101 = new JSONObject();
        JSONObject r102 = new JSONObject();
        addParametersToJSON(r101, "who", r110);
        int r112 = r111.length;
        int r103 = 0;
    L6:
        if (r103 >= r112) goto L8;
        String[] r104 = r111[r103];
        addParametersToJSON(r101, r104[0], r104[1]);
        addParametersToJSON(r102, r104[0], r104[1]);
        r103 = r103 + 1;
        goto L6
    L8:
        addParametersToJSON(r101, "time_stamp", String.valueOf(System.currentTimeMillis()));
        String r113 = addAppCommonDataToJSON(r101);
        this.mLogger.d(TAG, "sendCustomEvent event:" + r100 + ",data:" + r113);
        SDKMonitorUtils.getInstance(AID).monitorEvent(r100, r101, r102, null);
    }

    public void sendGrayConfigResponseEvent(String r100, boolean r101, String r102) {
        if (isMonitorUtilsExist() == true) goto L5;
        return;
    L5:
        JSONObject r103 = new JSONObject();
        JSONObject r104 = new JSONObject();
        addParametersToJSON(r104, "config_name", r100);
        if (r101 == false) goto L8;
        String r105 = "success";
    L9:
        addParametersToJSON(r104, "result", r105);
        addParametersToJSON(r104, "content", r102);
        addParametersToJSON(r104, "role", this.role);
        addParametersToJSON(r104, "time_stamp", String.valueOf(System.currentTimeMillis()));
        addParametersToJSON(r103, "app_key", this.appKey);
        addParametersToJSON(r103, AuthConstants.PARAM_KEY_LICENSE_PROJECT_ID, this.projectId);
        addParametersToJSON(r103, "session_id", this.sessionID);
        addParametersToJSON(r103, "connect_id", null);
        addParametersToJSON(r103, "cast_id", this.castId);
        addParametersToJSON(r103, "client_id", this.clientId);
        addParametersToJSON(r103, "cast_info", null);
        addParametersToJSON(r103, "player_info", null);
        String r106 = addAppCommonDataToJSON(r103);
        SDKMonitorUtils.getInstance(AID).monitorEvent(BYTECAST_GRAY_CONFIG_RESPONSE, r104, null, r103);
        this.mLogger.d(TAG, "sendGrayConfigEvent:bytecast_gray_config_response, role:" + this.role + ", configName:" + r100 + ", isSuccess:" + r101 + ", content:" + r102 + ", data:" + r106);
        return;
    L8:
        r105 = "failure";
        goto L9
    }

    public void sendSinkEvent(String r100, Map<String, String> r101, Map<String, String> r102) {
        if (isMonitorUtilsExist() == true) goto L5;
        return;
    L5:
        JSONObject r103 = new JSONObject();
        JSONObject r104 = new JSONObject();
        addParametersToJSON(r103, "time_stamp", String.valueOf(System.currentTimeMillis()));
        addParametersToJSON(r103, "role", Constants.ROLE_SINK);
        addParametersToJSON(r103, "service_type", getServiceTypeByEventName(r100, null));
        addParametersToJSON(r103, "protocol", getProtocolByEventName(r100));
        if (r101 == null) goto L11;
        Iterator<Map.Entry<String, String>> r105 = r101.entrySet().iterator();
    L9:
        if (r105.hasNext() == false) goto L11;
        Map.Entry<String, String> r106 = r105.next();
        addParametersToJSON(r103, r106.getKey(), r106.getValue());
    L11:
        addParametersToJSON(r104, "app_key", this.appKey);
        addParametersToJSON(r104, AuthConstants.PARAM_KEY_LICENSE_PROJECT_ID, this.projectId);
        addParametersToJSON(r104, "session_id", this.sessionID);
        addParametersToJSON(r104, "connect_id", null);
        addParametersToJSON(r104, "cast_id", this.castId);
        addParametersToJSON(r104, "client_id", this.clientId);
        addParametersToJSON(r104, "player_info", null);
        addParametersToJSON(r104, "cast_info", null);
        if (r102 == null) goto L17;
        Iterator<Map.Entry<String, String>> r107 = r102.entrySet().iterator();
    L15:
        if (r107.hasNext() == false) goto L17;
        Map.Entry<String, String> r108 = r107.next();
        addParametersToJSON(r104, r108.getKey(), r108.getValue());
    L17:
        String r109 = addAppCommonDataToJSON(r104);
        SDKMonitorUtils.getInstance(AID).monitorEvent(r100, r103, null, r104);
        this.mLogger.d(TAG, "sendSinkEvent event:" + r100 + ", params:" + r101 + ", extraParams:" + r102 + ",data:" + r109);
    }

    public void sendSourceEvent(String r100, String r101, String r102) {
        if (isMonitorUtilsExist() == true) goto L5;
        return;
    L5:
        JSONObject r103 = new JSONObject();
        JSONObject r104 = new JSONObject();
        addParametersToJSON(r103, "time_stamp", String.valueOf(System.currentTimeMillis()));
        addParametersToJSON(r103, "content", r101);
        addParametersToJSON(r103, "role", "source");
        addParametersToJSON(r103, "service_type", getServiceTypeByEventName(r100, null));
        addParametersToJSON(r103, "protocol", getProtocolByEventName(r100));
        addParametersToJSON(r104, "app_key", this.appKey);
        addParametersToJSON(r104, AuthConstants.PARAM_KEY_LICENSE_PROJECT_ID, this.projectId);
        addParametersToJSON(r104, "session_id", this.sessionID);
        if (TextUtils.isEmpty(r102) == false) goto L8;
        r102 = this.sourceConnectID;
    L8:
        addParametersToJSON(r104, "connect_id", r102);
        addParametersToJSON(r104, "player_info", null);
        addParametersToJSON(r104, "cast_info", null);
        String r105 = addAppCommonDataToJSON(r104);
        SDKMonitorUtils.getInstance(AID).monitorEvent(r100, r103, null, r104);
        this.mLogger.d(TAG, "sendSourceEvent event:" + r100 + ", content:" + r101 + ",data:" + r105);
    }

    public void sentBDLinkRegisterFailureEvent(int r100, String r101, String r102) {
        JSONObject r103 = new JSONObject();
        addParametersToJSON(r103, "statusCode", r100);
        addParametersToJSON(r103, "content", r101);
        addParametersToJSON(r103, com.ss.cast.discovery.mdns.nsdhelper.NsdHelper.serviceInfoKey, r102);
        addParametersToJSON(r103, "role", "source");
        sendByteCastSourceEvent(BDLINK_REGISTER_FAILURE, r103, null);
        this.mLogger.d(TAG, "sentBDLinkRegisterFailureEvent: " + r102);
    }

    public void sentBDLinkSourceSendFailureMessageEvent(int r100, String r101, String r102) {
        JSONObject r103 = new JSONObject();
        addParametersToJSON(r103, "statusCode", r100);
        addParametersToJSON(r103, "messageString", r102);
        addParametersToJSON(r103, com.ss.cast.discovery.mdns.nsdhelper.NsdHelper.serviceInfoKey, r101);
        addParametersToJSON(r103, "role", "source");
        sendByteCastSourceEvent(BDLINK_SEND_MESSAGE_FAILURE, r103, null);
        this.mLogger.d(TAG, "sentBDLinkSourceSendFailureMessageEvent: " + r102);
    }

    public void sentBDLinkUnregisterFailureEvent(int r100, String r101, String r102) {
        JSONObject r103 = new JSONObject();
        addParametersToJSON(r103, "statusCode", r100);
        addParametersToJSON(r103, "content", r101);
        addParametersToJSON(r103, com.ss.cast.discovery.mdns.nsdhelper.NsdHelper.serviceInfoKey, r102);
        addParametersToJSON(r103, "role", "source");
        sendByteCastSourceEvent(BDLINK_UNREGISTER_FAILURE, r103, null);
        this.mLogger.d(TAG, "sentBDLinkUnregisterFailureEvent: " + r102);
    }

    private void addParametersToJSON(JSONObject r100, String r101, int r102) {
        r100.put(r101, r102);     // Catch: JSONException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public void sendCustomEvent(String r100, String r101, String r102) {
        sendCustomEvent(r100, r101, r102, null);
    }

    public void sendSourceEvent(String r100, Map<String, String> r101, String r102) {
        sendSourceEvent(r100, r101, null, r102);
    }

    public void initSessionID(String r100, String r101, String r102, String r103) {
        this.sessionID = MD5.hexdigest(r100 + r101 + System.currentTimeMillis());
        this.appKey = r101;
        this.HOST_AID = r101;
        this.projectId = r102;
        this.role = r103;
        this.mLogger.d(TAG, "setSessionID :" + this.sessionID + " ,AppKey: " + this.appKey + ", projectId: " + this.projectId);
    }

    public void receiveEvent(String r100, long r101, String r102, String r103) {
        JSONObject r104 = new JSONObject();
        addParametersToJSON(r104, ST.UUID_DEVICE, r100);
        addParametersToJSON(r104, OnekeyLoginConstants.CU_KEY_SEQ, String.valueOf(r101));
        addParametersToJSON(r104, "name", r102);
        addParametersToJSON(r104, "value", r103);
        sendByteCastSourceEvent(BDDLNA_RECEIVE_EVENT, r104, null);
    }

    public void sendByteCastSinkEvent(String r100, String r101, String r102, String r103) {
        if (isMonitorUtilsExist() == true) goto L5;
        return;
    L5:
        JSONObject r104 = new JSONObject();
        JSONObject r105 = new JSONObject();
        addParametersToJSON(r105, "content", r101);
        addParametersToJSON(r105, "service_type", getServiceTypeByEventName(r100, null));
        addParametersToJSON(r105, "protocol", getProtocolByEventName(r100));
        addParametersToJSON(r105, "role", Constants.ROLE_SINK);
        addParametersToJSON(r105, "time_stamp", String.valueOf(System.currentTimeMillis()));
        addParametersToJSON(r104, "app_key", this.appKey);
        addParametersToJSON(r104, AuthConstants.PARAM_KEY_LICENSE_PROJECT_ID, this.projectId);
        addParametersToJSON(r104, "session_id", this.sessionID);
        addParametersToJSON(r104, "connect_id", r102);
        addParametersToJSON(r104, "cast_id", this.castId);
        addParametersToJSON(r104, "client_id", this.clientId);
        addParametersToJSON(r104, "cast_info", r103);
        addParametersToJSON(r104, "player_info", null);
        String r106 = addAppCommonDataToJSON(r104);
        SDKMonitorUtils.getInstance(AID).monitorEvent(r100, r105, null, r104);
        this.mLogger.d(TAG, "sendByteCastSinkEvent event:" + r100 + ", connectId:" + r102 + ",castInfo:" + r103 + ",data:" + r106);
    }

    public void sendByteCastSourceEvent(String r100, String r101, String r102, String r110) {
        if (isMonitorUtilsExist() == true) goto L5;
        return;
    L5:
        JSONObject r103 = new JSONObject();
        JSONObject r104 = new JSONObject();
        addParametersToJSON(r104, "content", r101);
        addParametersToJSON(r104, "service_type", getServiceTypeByEventName(r100, null));
        addParametersToJSON(r104, "protocol", getProtocolByEventName(r100));
        addParametersToJSON(r104, "role", "source");
        addParametersToJSON(r104, "time_stamp", String.valueOf(System.currentTimeMillis()));
        addParametersToJSON(r103, "app_key", this.appKey);
        addParametersToJSON(r103, AuthConstants.PARAM_KEY_LICENSE_PROJECT_ID, this.projectId);
        addParametersToJSON(r103, "session_id", this.sessionID);
        if (TextUtils.isEmpty(r110) == false) goto L8;
        r110 = this.sourceConnectID;
    L8:
        addParametersToJSON(r103, "connect_id", r110);
        addParametersToJSON(r103, "cast_id", this.castId);
        addParametersToJSON(r103, "client_id", this.clientId);
        addParametersToJSON(r103, "player_info", r102);
        addParametersToJSON(r103, "cast_info", null);
        String r111 = addAppCommonDataToJSON(r103);
        SDKMonitorUtils.getInstance(AID).monitorEvent(r100, r104, null, r103);
        this.mLogger.d(TAG, "sendByteCastSourceEvent event:" + r100 + ", content:" + r101 + ",playerInfo:" + r102 + ",data:" + r111);
    }

    public void sendCustomEvent(String r100, String r101, String r102, String r110) {
        if (isMonitorUtilsExist() == true) goto L5;
        return;
    L5:
        JSONObject r103 = new JSONObject();
        JSONObject r104 = new JSONObject();
        addParametersToJSON(r103, "content", r102);
        addParametersToJSON(r103, "role", r100);
        addParametersToJSON(r103, "service_type", getServiceTypeByEventName(r101, null));
        addParametersToJSON(r103, "protocol", getProtocolByEventName(r101));
        addParametersToJSON(r103, "time_stamp", String.valueOf(System.currentTimeMillis()));
        addParametersToJSON(r104, "app_key", this.appKey);
        addParametersToJSON(r104, AuthConstants.PARAM_KEY_LICENSE_PROJECT_ID, this.projectId);
        addParametersToJSON(r104, "session_id", this.sessionID);
        addParametersToJSON(r104, "connect_id", r110);
        addParametersToJSON(r104, "cast_id", this.castId);
        addParametersToJSON(r104, "client_id", this.clientId);
        addParametersToJSON(r104, "player_info", null);
        addParametersToJSON(r104, "cast_info", null);
        String r105 = addAppCommonDataToJSON(r104);
        SDKMonitorUtils.getInstance(AID).monitorEvent(r101, r103, null, r104);
        this.mLogger.d(TAG, "sendCustomEvent event:" + r101 + ", role:" + r100 + ", content:" + r102 + ", connectID:" + r110 + ",data:" + r105);
    }

    public void sendSourceEvent(String r100, Map<String, String> r101, Map<String, String> r102, String r110) {
        if (isMonitorUtilsExist() == true) goto L5;
        return;
    L5:
        JSONObject r103 = new JSONObject();
        JSONObject r104 = new JSONObject();
        addParametersToJSON(r103, "time_stamp", String.valueOf(System.currentTimeMillis()));
        addParametersToJSON(r103, "role", "source");
        addParametersToJSON(r103, "service_type", getServiceTypeByEventName(r100, null));
        addParametersToJSON(r103, "protocol", getProtocolByEventName(r100));
        if (r101 == null) goto L11;
        Iterator<Map.Entry<String, String>> r105 = r101.entrySet().iterator();
    L9:
        if (r105.hasNext() == false) goto L11;
        Map.Entry<String, String> r106 = r105.next();
        addParametersToJSON(r103, r106.getKey(), r106.getValue());
    L11:
        addParametersToJSON(r104, "app_key", this.appKey);
        addParametersToJSON(r104, AuthConstants.PARAM_KEY_LICENSE_PROJECT_ID, this.projectId);
        addParametersToJSON(r104, "session_id", this.sessionID);
        if (TextUtils.isEmpty(r110) == false) goto L14;
        r110 = this.sourceConnectID;
    L14:
        addParametersToJSON(r104, "connect_id", r110);
        addParametersToJSON(r104, "cast_id", this.castId);
        addParametersToJSON(r104, "client_id", this.clientId);
        addParametersToJSON(r104, "player_info", null);
        addParametersToJSON(r104, "cast_info", null);
        if (r102 == null) goto L20;
        Iterator<Map.Entry<String, String>> r111 = r102.entrySet().iterator();
    L18:
        if (r111.hasNext() == false) goto L20;
        Map.Entry<String, String> r107 = r111.next();
        addParametersToJSON(r104, r107.getKey(), r107.getValue());
    L20:
        String r112 = addAppCommonDataToJSON(r104);
        SDKMonitorUtils.getInstance(AID).monitorEvent(r100, r103, null, r104);
        this.mLogger.d(TAG, "sendSourceEvent event:" + r100 + ", params:" + r101 + ", extraParams:" + r102 + ",data:" + r112);
    }

    public void sendByteCastSinkEvent(String r100, JSONObject r101, String r102, String r103) {
        if (isMonitorUtilsExist() == true) goto L5;
        return;
    L5:
        JSONObject r104 = new JSONObject();
        addParametersToJSON(r101, "service_type", getServiceTypeByEventName(r100, null));
        addParametersToJSON(r101, "protocol", getProtocolByEventName(r100));
        addParametersToJSON(r101, "role", Constants.ROLE_SINK);
        addParametersToJSON(r101, "time_stamp", String.valueOf(System.currentTimeMillis()));
        addParametersToJSON(r104, "app_key", this.appKey);
        addParametersToJSON(r104, AuthConstants.PARAM_KEY_LICENSE_PROJECT_ID, this.projectId);
        addParametersToJSON(r104, "session_id", this.sessionID);
        addParametersToJSON(r104, "connect_id", r102);
        addParametersToJSON(r104, "cast_id", this.castId);
        addParametersToJSON(r104, "client_id", this.clientId);
        addParametersToJSON(r104, "cast_info", r103);
        addParametersToJSON(r104, "player_info", null);
        String r105 = addAppCommonDataToJSON(r104);
        SDKMonitorUtils.getInstance(AID).monitorEvent(r100, r101, null, r104);
        this.mLogger.d(TAG, "sendByteCastSinkEvent event:" + r100 + ", connectId:" + r102 + ",castInfo:" + r103 + ",data:" + r105);
    }

    public void sendByteCastCryptoEvent(String r100, String r101, String r102, int r103, String r104) {
        HashMap r105 = new HashMap();
        r105.put("content", r102);
        r105.put("state", r101);
        if (TextUtils.equals(r101, "failure") == false) goto L6;
        r105.put("err_code", String.valueOf(r103));
        r105.put(LocationMonitorConst.ERR_MSG, r104);
    L6:
        if (TextUtils.equals(this.role, "source") == false) goto L8;
    L11:
        sendSourceEvent(r100, r105, "");
        return;
    L8:
        if (TextUtils.equals(this.role, "default") == true) goto L11;
        sendSinkEvent(r100, r105);
    }

    public void sendCustomEvent(String r100, String r101, String r102, String r110, String r111) {
        if (isMonitorUtilsExist() == true) goto L5;
        return;
    L5:
        JSONObject r103 = new JSONObject();
        JSONObject r104 = new JSONObject();
        addParametersToJSON(r103, "content", r102);
        addParametersToJSON(r103, "role", r100);
        addParametersToJSON(r103, "service_type", getServiceTypeByEventName(r101, null));
        addParametersToJSON(r103, "protocol", getProtocolByEventName(r101));
        addParametersToJSON(r103, "time_stamp", String.valueOf(System.currentTimeMillis()));
        addParametersToJSON(r104, "app_key", this.appKey);
        addParametersToJSON(r104, AuthConstants.PARAM_KEY_LICENSE_PROJECT_ID, this.projectId);
        addParametersToJSON(r104, "session_id", this.sessionID);
        addParametersToJSON(r104, "connect_id", r110);
        addParametersToJSON(r104, "player_info", null);
        addParametersToJSON(r104, "cast_info", null);
        addParametersToJSON(r104, "browse_id", r111);
        String r105 = addAppCommonDataToJSON(r104);
        SDKMonitorUtils.getInstance(AID).monitorEvent(r101, r103, null, r104);
        this.mLogger.d(TAG, "sendCustomEvent event:" + r101 + ", role:" + r100 + ", content:" + r102 + ", connectID:" + r110 + ", browse_id:" + r111 + ",data:" + r105);
    }

    public void sendCustomExtraEvent(String r100, String r101, String r102, String r110, String r111) {
        if (isMonitorUtilsExist() == true) goto L5;
        return;
    L5:
        JSONObject r103 = new JSONObject();
        JSONObject r104 = new JSONObject();
        addParametersToJSON(r103, "role", r100);
        addParametersToJSON(r103, "service_type", getServiceTypeByEventName(r111, null));
        addParametersToJSON(r103, "protocol", getProtocolByEventName(r111));
        addParametersToJSON(r103, "time_stamp", String.valueOf(System.currentTimeMillis()));
        addParametersToJSON(r104, "app_key", this.appKey);
        addParametersToJSON(r104, "session_id", this.sessionID);
        addParametersToJSON(r104, "connect_id", r110);
        addParametersToJSON(r104, "player_info", null);
        addParametersToJSON(r104, "cast_info", null);
        addParametersToJSON(r104, "content", r102);
        String r105 = addAppCommonDataToJSON(r104);
        SDKMonitorUtils.getInstance(AID).monitorEvent(r101, r103, null, r104);
        this.mLogger.d(TAG, "sendCustomExtraEvent protocol:" + getProtocolByEventName(r111) + ", event:" + r101 + ", role:" + r100 + ", content:" + r102 + ", connectID:" + r110 + ", data:" + r105);
    }

    public void sentBDLinkSinkSendFailureMessageEvent(int r100, String r101, String r102, String r103, String r104) {
        JSONObject r105 = new JSONObject();
        addParametersToJSON(r105, "statusCode", r100);
        addParametersToJSON(r105, "err_code", r103);
        addParametersToJSON(r105, LocationMonitorConst.ERR_MSG, r104);
        addParametersToJSON(r105, "messageString", r102);
        addParametersToJSON(r105, com.ss.cast.discovery.mdns.nsdhelper.NsdHelper.serviceInfoKey, r101);
        addParametersToJSON(r105, "role", Constants.ROLE_SINK);
        sendByteCastSinkEvent(BDLINK_SEND_MESSAGE_FAILURE, r105, null, null);
        this.mLogger.d(TAG, "sentBDLinkSinkSendFailureMessageEvent: " + r102);
    }

    public void sendRawEvent(String r100, String r101, JSONObject r102, JSONObject r103, JSONObject r104, String r110) {
        if (isMonitorUtilsExist() == true) goto L5;
        return;
    L5:
        addParametersToJSON(r102, "role", r100);
        addParametersToJSON(r102, "service_type", getServiceTypeByEventName(r110, null));
        addParametersToJSON(r102, "protocol", getProtocolByEventName(r110));
        addParametersToJSON(r102, "time_stamp", String.valueOf(System.currentTimeMillis()));
        addParametersToJSON(r104, "app_key", this.appKey);
        addParametersToJSON(r104, "session_id", this.sessionID);
        addParametersToJSON(r104, "player_info", null);
        addParametersToJSON(r104, "cast_info", null);
        String r105 = addAppCommonDataToJSON(r104);
        SDKMonitorUtils.getInstance(AID).monitorEvent(r101, r102, r103, r104);
        this.mLogger.d(TAG, "sendRawEvent protocol:" + getProtocolByEventName(r110) + ", event:" + r101 + ", role:" + r100 + ", data:" + r105);
    }

    public void sendByteCastAuthEvent(String r100, String r101, String r102, String r103, String r104, String r105, String r106) {
        JSONObject r107 = new JSONObject();
        addParametersToJSON(r107, "isUserToB", r101);
        addParametersToJSON(r107, "result", String.valueOf(r102));
        addParametersToJSON(r107, "appId", r103);
        addParametersToJSON(r107, "projectId", r104);
        addParametersToJSON(r107, "businessId", r105);
        JSONObject r108 = new JSONObject();
        if (TextUtils.isEmpty(r106) == true) goto L5;
        addParametersToJSON(r108, "error", r106);
    L5:
        addParametersToJSON(r107, "extra", r108.toString());
        sendCustomEvent(this.role, r100, r107.toString());
    }
}
