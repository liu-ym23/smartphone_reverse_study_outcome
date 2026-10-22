package com.stepos.alphame.utils;

/* loaded from: classes.dex */
public class LocalConsts {
    public static final String ACTION_ACTIVITY_DETECT = "ACTIVITY_DETECT";
    public static final String ACTION_APP_CREATED = "APP_CREATED";
    public static final String ACTION_APP_DIED = "APP_DIED";
    public static final String ACTION_BLUETOOTH_CHANGED = "ACTION_BLUETOOTH_CHANGED";
    public static final String ACTION_CHARGING_CHANGED = "ACTION_CHARGING_CHANGED";
    public static final String ACTION_CITY_CHANGED = "ACTION_CITY_CHANGED";
    public static final String ACTION_COUNTRY_CHANGED = "ACTION_COUNTRY_CHANGED";
    public static final String ACTION_HEADSET_CHANGED = "ACTION_HEADSET_CHANGED";
    public static final String ACTION_LOCATION_CHANGED = "ACTION_LOCATION_CHANGED";
    public static final String ACTION_OCR_DETECT = "OCR_DETECT";
    public static final String ACTION_QUERY_HOME_COMPANY_RESULT = "ACTION_QUERY_HOME_COMPANY_RESULT";
    public static final String ACTION_SCREEN_OFF_BY_PAUSE = "SCREEN_OFF_BY_PAUSE";
    public static final String ACTION_WIFI_STATE_CHANGED = "ACTION_WIFI_STATE_CHANGED";
    public static final String FUNC_CHOOSE_COMPANY = "chooseCompany";
    public static final String FUNC_CHOOSE_HOME = "chooseHome";
    public static final String FUNC_CHOOSE_VEHICLE_BLUETOOTH = "chooseVehicleBluetooth";
    public static final String FUNC_CUT_IMAGE_ACQUIRE = "cutImageAcquire";
    public static final String FUNC_CUT_IMAGE_BY_URI = "cutImageByUri";
    public static final String FUNC_CUT_IMAGE_INIT = "cutImageInit";
    public static final String FUNC_CUT_IMAGE_RELEASE = "cutImageRelease";
    public static final String FUNC_DETECT_ACTIVITY_SCENE = "detectActivityScene";
    public static final String FUNC_DETECT_ACTIVITY_SCENE_ALL = "detectActivitySceneAll";
    public static final String FUNC_DETECT_ACTIVITY_SCENE_BY_ACTIVITY = "detectActivitySceneByActivity";
    public static final String FUNC_DETECT_OCR_BOUNDS_BY_PATH = "detectOCRBoundsByPath";
    public static final String FUNC_DETECT_OCR_BYTE_SYNC = "detectOCRByByteSync";
    public static final String FUNC_DETECT_OCR_BY_PATH = "detectOCRByPath";
    public static final String FUNC_DETECT_OCR_POINT_BINDER = "detectOCRPointByBinder";
    public static final String FUNC_DETECT_OCR_POINT_BYTE = "detectOCRPointByByte";
    public static final String FUNC_ENTER_DEBUG_SCENE = "enterDebugScene";
    public static final String FUNC_GET_ALL_UNBOUNDED_PACKAGES = "getAllUnboundedPackages";
    public static final String FUNC_GET_ALL_WIFI = "getAllWifiInfo";
    public static final String FUNC_GET_APP_BLACK_LIST_FOR_USER_GENERATE_CONTENT = "getAppBlackListForUserGeneratedContent";
    public static final String FUNC_GET_APP_INFO = "getAppInfo";
    public static final String FUNC_GET_CDN_INFO = "getCdnInfo";
    public static final String FUNC_GET_CHOSEN_COMPANY = "getChosenCompany";
    public static final String FUNC_GET_CHOSEN_HOME = "getChosenHome";
    public static final String FUNC_GET_CITY_HISTORY = "getCityHistory";
    public static final String FUNC_GET_COMPANY_WIFI_LIST = "getCompanyWifiList";
    public static final String FUNC_GET_CURRENT_SCENE = "getCurrentScene";
    public static final String FUNC_GET_FREQUENT_LOCATIONS = "getFrequentLocations";
    public static final String FUNC_GET_GAME_TYPE = "getGameType";
    public static final String FUNC_GET_HOME_WIFI_LIST = "getHomeWifiList";
    public static final String FUNC_GET_LOCATION_INFO_BY_ID = "getLocationInfoByID";
    public static final String FUNC_GET_PREDICTION = "getPrediction";
    public static final String FUNC_GET_PREDICTION3 = "getPrediction3";
    public static final String FUNC_GET_PREDICTION_WITH_USERID = "getPredictionWithUserId";
    public static final String FUNC_GET_SCENE_FREQUENCY = "getSceneFrequency";
    public static final String FUNC_GET_VEHICLES = "getVehicles";
    public static final String FUNC_GET_VEHICLE_BLUETOOTHES = "getVehicleBluetoothes";
    public static final String FUNC_GET_VEHICLE_BLUETOOTH_INFO = "getVehicleBluetoothInfo";
    public static final String FUNC_IS_GAME = "isGame";
    public static final String FUNC_IS_GAME_PACKAGES = "isGamePackages";
    public static final String FUNC_IS_MINI_GAME = "isMiniGame";
    public static final String FUNC_IS_UNBOUNDED_PACKAGES = "isUnboundedPackages";
    public static final String FUNC_MAKE_LOCATION = "makeLocation";
    public static final String FUNC_NOTI_PREDICT = "notiPredict";
    public static final String FUNC_OCR_INIT = "ocrInit";
    public static final String FUNC_OCR_RELEASE = "ocrRelease";
    public static final String FUNC_RECOGNIZE_OCR_BINDER = "recognizeOCRByBinder";
    public static final String FUNC_RECOGNIZE_OCR_BINDER_WITH_VERSION = "recognizeOCRByBinderWithVersion";
    public static final String FUNC_RECOGNIZE_OCR_BYTE = "recognizeOCRByByte";
    public static final String FUNC_RECOGNIZE_OCR_PATH = "recognizeOCRByPath";
    public static final String FUNC_RECOGNIZE_OCR_PATH_EXT = "recognizeOCRByPathExt";
    public static final String FUNC_RECOGNIZE_OCR_POINT_BYTE = "recognizeOCRByPointByte";
    public static final String FUNC_RECOGNIZE_OCR_URI = "recognizeOCRByUri";
    public static final String FUNC_RECOGNIZE_OCR_URI_WITH_VERSION = "recognizeOCRByUriWithVersion";
    public static final String FUNC_SET_ALL_PACKAGES_CUSTOM_GAME_MODE = "setAllPackagesCustomGameMode";
    public static final String FUNC_SET_BROADCAST_EXACTLY_GAME_INFO = "setBroadcastExactlyGameInfo";
    public static final String FUNC_SET_CUSTOM_GAME_MODE_FOR_PACKAGE = "setCustomGameModeForPackage";
    public static final String FUNC_WORD_MATCH = "wordMatch";
    public static final int INT_CHANGED = 2;
    public static final int INT_FALSE = 0;
    public static final int INT_NULL = -1;
    public static final int INT_TRUE = 1;
    public static final String PERMISSION_DUMP = "stepos.alphame.dump";

    public class AppStates {
        public static final int STATE_DOWNLOADING = 1;
        public static final int STATE_MOVING = 16;
        public static final int STATE_NAVIGATION = 4;
        public static final int STATE_NONE = 0;
        public static final int STATE_PLAYBACKING = 2;
        public static final int STATE_RECORDING = 8;
        public static final int STATE_SCREEN_RECORD = 32;

        public AppStates() {
        }
    }

    public class AwarenessScenes {
        public static final int SCENE_APP = 3;
        public static final int SCENE_BLUETOOTH = 4;
        public static final int SCENE_CHARGING = 6;
        public static final int SCENE_HEADSET = 7;
        public static final int SCENE_LOCATION = 2;
        public static final int SCENE_MOVING = 0;
        public static final int SCENE_NOTIFICATIONS = 8;
        public static final int SCENE_PERMISSION_CHECK = 9;
        public static final int SCENE_SYSTEM = 5;
        public static final int SCENE_WIFI = 1;

        public AwarenessScenes() {
        }
    }

    public class SceneStates {
        public static final int FROM_APP_SUGGEST_DATA = 12;
        public static final int FROM_BLUETOOTH_CONNETED = 1;
        public static final int FROM_BLUETOOTH_DISCONNETED = 2;
        public static final int FROM_COUNTRY_SETTING_CHANGED = 10;
        public static final int FROM_MOVE = 7;
        public static final int FROM_PASSIVE_PROVIDER = 11;
        public static final int FROM_RETRY = 8;
        public static final int FROM_THIRD_APP = 9;
        public static final int FROM_UNKNOWN = 0;
        public static final int FROM_WAKEUP = 6;
        public static final int FROM_WIFI_CHANGE = 3;
        public static final int FROM_WIFI_CONNECTED = 4;
        public static final int FROM_WIFI_DISCONNECTED = 5;
        public static final int SCREEN_OFF = 0;
        public static final int SCREEN_ON = 1;
        public static final int STATE_APP_SYSTEM = 0;
        public static final int STATE_CHANGED = 2;
        public static final int STATE_CHARGING_AC = 1;
        public static final int STATE_CHARGING_NONE = 0;
        public static final int STATE_CHARGING_USB = 2;
        public static final int STATE_CHARGING_WIRELESS = 4;
        public static final int STATE_CONNECTED = 1;
        public static final int STATE_DENIED = 0;
        public static final int STATE_DISCONNECTED = 0;
        public static final int STATE_MOVING_RUN = 4;
        public static final int STATE_MOVING_SLOWLY_WALK = 2;
        public static final int STATE_MOVING_STILL = 1;
        public static final int STATE_MOVING_UNKNOWN = 0;
        public static final int STATE_MOVING_WALK = 3;
        public static final int STATE_OFF = -1;
        public static final int STATE_PERMITTED = 1;
        public static final int STATE_PUBLIC = 2;
        public static final int STATE_SYSTEM_BOOT = 0;
        public static final int STATE_SYSTEM_DAILY = 2;
        public static final int STATE_SYSTEM_LOG = 1;
        public static final int STATE_SYSTEM_STEP = 3;
        public static final int STATE_SYSTEM_WIFI = 4;

        public SceneStates() {
        }
    }
}
