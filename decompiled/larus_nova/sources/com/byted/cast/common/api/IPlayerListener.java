package com.byted.cast.common.api;

import com.byted.cast.common.bean.DramaBean;
import com.byted.cast.common.source.ServiceInfo;
import com.byted.cast.common.source.Statistics;

/* JADX INFO: loaded from: classes39.dex */
public interface IPlayerListener {
    public static final int AUTH_ERROR = -1;
    public static final int AUTH_ERROR_TIME_OUT = -2;
    public static final int CONFERECE_DELETE_NOTFIND_DEVS = 211035;
    public static final int CONFERECE_DELETE_SUCCESSFUL = 211034;
    public static final int CONFERENCE_PINCODE_CONVERTTODEV_ERROR = 300001;
    public static final int CONFERENCE_PINCODE_ERROR = 300002;
    public static final int CONNECT_ERROR_FAILED = 201;
    public static final int CONNECT_ERROR_FATAL = 407;
    public static final int CONNECT_ERROR_IM_BLACKLIST = 405;
    public static final int CONNECT_ERROR_IM_REJECT = 403;
    public static final int CONNECT_ERROR_IM_TIMEOUT = 404;
    public static final int CONNECT_ERROR_IM_WAITTING = 402;
    public static final int CONNECT_ERROR_IO = 401;
    public static final int CONNECT_ERROR_KICK_OUT = 406;
    public static final int CONNECT_ERROR_NORMAL = 400;
    public static final int CONNECT_INFO_DISCONNECT = 200;
    public static final int FIREWALL_ERROR = 212002;
    public static final int INFO_MIRROR_PAUSE = 300006;
    public static final int INFO_MIRROR_RESUME = 300007;
    public static final int INFO_MIRROR_STATE = 300005;
    public static final int INFO_SCREENSHOT = 300002;
    public static final int INFO_SCREENSHOT_COMPLATION = 300003;
    public static final int INFO_SCREENSHOT_FAILED = 300004;
    public static final int MDNS_ERROR = 212001;
    public static final int MIRROR_ERROR_ACTIVITY_NULL = 211003;
    public static final int MIRROR_ERROR_ANNOUNCE = 211021;
    public static final int MIRROR_ERROR_CHECK_PHONE_NETWORK = 211016;
    public static final int MIRROR_ERROR_CODEC = 211020;
    public static final int MIRROR_ERROR_DEVICE_UNSUPPORTED = 211004;
    public static final int MIRROR_ERROR_FORCE_STOP = 211031;
    public static final int MIRROR_ERROR_GETCODE_FAILED = 211028;
    public static final int MIRROR_ERROR_GETCODE_SUCCESS = 211029;
    public static final int MIRROR_ERROR_GET_INFO = 211012;
    public static final int MIRROR_ERROR_GET_PARAMTER = 211024;
    public static final int MIRROR_ERROR_GET_PORT = 211011;
    public static final int MIRROR_ERROR_INIT = 211000;
    public static final int MIRROR_ERROR_NEED_RETRY = 211017;
    public static final int MIRROR_ERROR_NETWORK_BROKEN = 211036;
    public static final int MIRROR_ERROR_PREEMPT_STOP = 211030;
    public static final int MIRROR_ERROR_PREPARE = 211010;
    public static final int MIRROR_ERROR_PREPARE_ENCODE = 211013;
    public static final int MIRROR_ERROR_RECORD = 211023;
    public static final int MIRROR_ERROR_REJECT_PERMISSION = 211002;
    public static final int MIRROR_ERROR_SERVER_STOP = 211032;
    public static final int MIRROR_ERROR_SETUP = 211022;
    public static final int MIRROR_ERROR_SET_PARAMTER = 211025;
    public static final int MIRROR_ERROR_UNSUPPORTED = 211001;
    public static final int MIRROR_ERROR_UNSUPPORT_PREEMPT = 211015;
    public static final int MIRROR_INFO_BITRATE_CHANGE = 211037;
    public static final int MIRROR_INFO_BITRATE_DOWN = 211039;
    public static final int MIRROR_INFO_BITRATE_UP = 211038;
    public static final int MIRROR_PLAY_ERROR = 211005;
    public static final int MIRROR_PLAY_INFO = 300010;
    public static final int MIRROR_USER_STOP = 211033;
    public static final int NEED_SCREENCODE = 211026;
    public static final int PREEMPT_UNSUPPORTED = 211027;
    public static final int PUSH_ERROR_ADD_VOLUME = 210100;
    public static final int PUSH_ERROR_CLEAR_DRAMA_LIST = 210126;
    public static final int PUSH_ERROR_DISCONNECT = 210013;
    public static final int PUSH_ERROR_DRAMA_ID_NULL = 210128;
    public static final int PUSH_ERROR_DRAMA_LIST_NULL = 210127;
    public static final int PUSH_ERROR_GET_EXTRA_INFO = 210080;
    public static final int PUSH_ERROR_IMAGE = 210002;
    public static final int PUSH_ERROR_IM_OFFLINE = 210004;
    public static final int PUSH_ERROR_IM_UNSUPPORTED_MIMETYPE = 210003;
    public static final int PUSH_ERROR_INIT = 210000;
    public static final int PUSH_ERROR_IO = 210011;
    public static final int PUSH_ERROR_LIST = 210120;
    public static final int PUSH_ERROR_LIST_NOT_SUPPORT = 210121;
    public static final int PUSH_ERROR_NOT_RESPONSED = 210012;
    public static final int PUSH_ERROR_NO_DEVICE = 210129;
    public static final int PUSH_ERROR_NO_MEDIA_PRESENT = 210014;
    public static final int PUSH_ERROR_PAUSE = 210020;
    public static final int PUSH_ERROR_PLAY = 210010;
    public static final int PUSH_ERROR_PLAY_DRAMA_ID = 210123;
    public static final int PUSH_ERROR_PLAY_EXTRA_INVALID_INFO = 210017;
    public static final int PUSH_ERROR_PLAY_EXTRA_NO_DEVICE = 210015;
    public static final int PUSH_ERROR_PLAY_EXTRA_NO_VALID_PROTOCOL = 210016;
    public static final int PUSH_ERROR_PLAY_NEXT_DRAMA = 210125;
    public static final int PUSH_ERROR_PLAY_PRE_DRAMA = 210124;
    public static final int PUSH_ERROR_QUERY_POSITION_STATE = 210060;
    public static final int PUSH_ERROR_RESUME = 210040;
    public static final int PUSH_ERROR_SEEK = 210070;
    public static final int PUSH_ERROR_SET_DRAMA_LIST = 210122;
    public static final int PUSH_ERROR_SET_VOLUME = 210050;
    public static final int PUSH_ERROR_STOP = 210030;
    public static final int PUSH_ERROR_SUB_VOLUME = 210110;
    public static final int PUSH_ERROR_URL_NOT_RESPONSED = 210013;
    public static final int PUSH_ERRROR_FILE_NOT_EXISTED = 210001;
    public static final int PUSH_INFO_TRANS_DATA = 0;
    public static final int PUSH_INFO_VERSION = 1;
    public static final int RELEVANCE_CLOUD_MIRROR = 20;
    public static final int RELEVANCE_CONNECT = 11;
    public static final int RELEVANCE_DANMAKU = 6;
    public static final int RELEVANCE_DANMAKU_PROPERTY = 5;
    public static final int RELEVANCE_DATA = 10000;
    public static final int RELEVANCE_DATA_UNSUPPORTED = 22100;
    public static final int RELEVANCE_DECODE_SUPPORT = 14;
    public static final int RELEVANCE_DISTRIBUTE_INFO = 8;
    public static final int RELEVANCE_ERROR = -1;
    public static final int RELEVANCE_HARASS = 3;
    public static final int RELEVANCE_LEBO_DATA = 100;
    public static final int RELEVANCE_LOG_REPORT = 21;
    public static final int RELEVANCE_MEDIAASSET = 2;
    public static final int RELEVANCE_MIRROR_SCREEN_CAPTURE = 13;
    public static final int RELEVANCE_MULTI_MIRROR_STATE = 9;
    public static final int RELEVANCE_PAUSE_AND_RESUME = 26;
    public static final int RELEVANCE_PLAY_INFO = 1;
    public static final int RELEVANCE_RATE_PALY = 12;
    public static final int RELEVANCE_RATE_QUERY = 15;
    public static final int RELEVANCE_RATE_QUERY_RESPONSE = 16;
    public static final int RELEVANCE_STAFF_INFO = 7;
    public static final int RELEVANCE_VIP_QUERY = 22;
    public static final int STATE_CANCEL_SUCCESS = 205;
    public static final int STATE_CAST_SUCCESS = 203;
    public static final int STATE_CONNECTING = 201;
    public static final int STATE_CONNECT_SUCCESS = 202;
    public static final int STATE_DISCONNECT_SUCCESS = 204;
    public static final int STATE_ERROR = 207;
    public static final int STATE_EXIT = 206;
    public static final int STATE_IDLE = 200;

    /* JADX INFO: renamed from: com.byted.cast.common.api.IPlayerListener$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$onDramaId(IPlayerListener r100, ServiceInfo r101, String r102) {
        }

        public static void $default$onDramaList(IPlayerListener r100, ServiceInfo r101, DramaBean[] r102) {
        }

        public static void $default$onError(IPlayerListener r100, int r101, int r102, String r103) {
        }

        public static void $default$onInfo(IPlayerListener r100, int r101, int r102, String r103) {
        }

        public static void $default$onPlayCommandSuccess(IPlayerListener r100) {
        }

        public static void $default$onSwitch(IPlayerListener r100, int r101) {
        }
    }

    void onCompletion();

    void onDramaId(ServiceInfo r100, String r101);

    void onDramaList(ServiceInfo r100, DramaBean[] r101);

    void onError(int r100, int r101);

    void onError(int r100, int r101, String r102);

    void onInfo(int r100, int r101);

    void onInfo(int r100, int r101, String r102);

    void onLoading();

    void onPause();

    void onPlayCommandSuccess();

    void onPositionUpdate(long r100, long r101);

    void onSeekComplete(long r100);

    void onStart();

    void onStartMirror();

    void onStatistics(Statistics r100);

    void onStop();

    void onStopMirror();

    void onSwitch(int r100);

    void onVolumeChanged(float r100);
}
