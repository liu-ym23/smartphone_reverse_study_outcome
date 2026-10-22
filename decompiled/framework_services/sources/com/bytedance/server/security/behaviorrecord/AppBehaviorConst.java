package com.bytedance.server.security.behaviorrecord;

import com.android.server.scene.SceneUtils;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class AppBehaviorConst {
    public static final Set<String> LOCATION_OP_NAME = null;
    public static final Set<String> VALID_ACCESS_APPS = null;
    public static final Map<String, String> VALID_NATIVE_OP_MAP = null;
    public static final Set<Integer> VALID_OPS = null;
    public static final Map<Integer, String> VALID_OP_NAME_MAP = null;
    public static final Set<Integer> VALID_UID_STATES = null;

    public AppBehaviorConst() {
    }

    static {
        VALID_OPS = new HashSet(Arrays.asList(new Integer[]{0, 1, 4, 5, 6, 7, 8, 9, 13, 14, 16, 18, 20, 23, 26, 27, 54, 56, 65, 79, 81, 82, 83, 84, 85, 86, 121, 122, 123, 149, 150, 10000}));
        VALID_UID_STATES = new HashSet(Arrays.asList(new Integer[]{200, 400, 500, 600, 700}));
        VALID_NATIVE_OP_MAP = new HashMap();
        VALID_NATIVE_OP_MAP.put("android.permission.FINE_LOCATION", "FINE_LOCATION");
        VALID_NATIVE_OP_MAP.put("android.permission.COARSE_LOCATION", "COARSE_LOCATION");
        VALID_NATIVE_OP_MAP.put("android.permission.CAMERA", "CAMERA");
        VALID_NATIVE_OP_MAP.put("android.permission.RECORD_AUDIO", "RECORD_AUDIO");
        VALID_NATIVE_OP_MAP.put("android.permission.BODY_SENSORS", "BODY_SENSORS");
        VALID_NATIVE_OP_MAP.put("android.permission.ACTIVITY_RECOGNITION", "ACTIVITY_RECOGNITION");
        VALID_NATIVE_OP_MAP.put("android.permission.READ_EXTERNAL_STORAGE", "READ_EXTERNAL_STORAGE");
        VALID_NATIVE_OP_MAP.put("android.permission.WRITE_EXTERNAL_STORAGE", "WRITE_EXTERNAL_STORAGE");
        VALID_NATIVE_OP_MAP.put("android.permission.ACCESS_MEDIA_LOCATION", "ACCESS_MEDIA_LOCATION");
        VALID_NATIVE_OP_MAP.put("android.permission.MANAGE_EXTERNAL_STORAGE", "MANAGE_EXTERNAL_STORAGE");
        VALID_NATIVE_OP_MAP.put("android.permission.READ_MEDIA_IMAGES", "READ_MEDIA_IMAGES");
        VALID_NATIVE_OP_MAP.put("android.permission.WRITE_MEDIA_IMAGES", "WRITE_MEDIA_IMAGES");
        VALID_NATIVE_OP_MAP.put("android.permission.READ_MEDIA_AUDIO", "READ_MEDIA_AUDIO");
        VALID_NATIVE_OP_MAP.put("android.permission.WRITE_MEDIA_AUDIO", "WRITE_MEDIA_AUDIO");
        VALID_NATIVE_OP_MAP.put("android.permission.READ_MEDIA_VIDEO", "READ_MEDIA_VIDEO");
        VALID_NATIVE_OP_MAP.put("android.permission.WRITE_MEDIA_VIDEO", "WRITE_MEDIA_VIDEO");
        VALID_NATIVE_OP_MAP.put("android.permission.READ_MEDIA_VISUAL_USER_SELECTED", "READ_MEDIA_VISUAL_USER_SELECTED");
        VALID_NATIVE_OP_MAP.put("android.permission.READ_CONTACTS", "READ_CONTACTS");
        VALID_NATIVE_OP_MAP.put("android.permission.WRITE_CONTACTS", "WRITE_CONTACTS");
        VALID_NATIVE_OP_MAP.put("android.permission.READ_CALENDAR", "READ_CALENDAR");
        VALID_NATIVE_OP_MAP.put("android.permission.WRITE_CALENDAR", "WRITE_CALENDAR");
        VALID_NATIVE_OP_MAP.put("android.permission.READ_CALL_LOG", "READ_CALL_LOG");
        VALID_NATIVE_OP_MAP.put("android.permission.WRITE_CALL_LOG", "WRITE_CALL_LOG");
        VALID_NATIVE_OP_MAP.put("android.permission.PROCESS_OUTGOING_CALLS", "PROCESS_OUTGOING_CALLS");
        VALID_NATIVE_OP_MAP.put("android.permission.CALL_PHONE", "CALL_PHONE");
        VALID_NATIVE_OP_MAP.put("android.permission.ANSWER_PHONE_CALLS", "ANSWER_PHONE_CALLS");
        VALID_NATIVE_OP_MAP.put("android.permission.READ_PHONE_STATE", "READ_PHONE_STATE");
        VALID_NATIVE_OP_MAP.put("android.permission.READ_PHONE_NUMBERS", "READ_PHONE_NUMBERS");
        VALID_NATIVE_OP_MAP.put("android.permission.READ_SMS", "READ_SMS");
        VALID_NATIVE_OP_MAP.put("android.permission.RECEIVE_MMS", "RECEIVE_MMS");
        VALID_NATIVE_OP_MAP.put("android.permission.RECEIVE_SMS", "RECEIVE_SMS");
        VALID_NATIVE_OP_MAP.put("android.permission.SEND_SMS", "SEND_SMS");
        VALID_NATIVE_OP_MAP.put("android.permission.BLUETOOTH_SCAN", "BLUETOOTH_SCAN");
        VALID_NATIVE_OP_MAP.put("android.permission.BLUETOOTH_ADVERTISE", "BLUETOOTH_ADVERTISE");
        VALID_NATIVE_OP_MAP.put("android.permission.BLUETOOTH_CONNECT", "BLUETOOTH_CONNECT");
        VALID_NATIVE_OP_MAP.put("android.permission.NEARBY_WIFI_DEVICES", "NEARBY_WIFI_DEVICES");
        VALID_NATIVE_OP_MAP.put("android.permission.GET_USAGE_STATS", "GET_USAGE_STATS");
        VALID_NATIVE_OP_MAP.put("android.permission.ACCESS_NOTIFICATIONS", "ACCESS_NOTIFICATIONS");
        VALID_NATIVE_OP_MAP.put("android.permission.WRITE_SETTINGS", "WRITE_SETTINGS");
        VALID_NATIVE_OP_MAP.put("android.permission.REQUEST_INSTALL_PACKAGES", "REQUEST_INSTALL_PACKAGES");
        VALID_NATIVE_OP_MAP.put("android.permission.QUERY_ALL_PACKAGES", "GET_INSTALLED_APPS");
        VALID_NATIVE_OP_MAP.put("android.permission.BD_SEND_MMS", "BD_SEND_MMS");
        VALID_NATIVE_OP_MAP.put("com.android.permission.GET_INSTALLED_APPS", "GET_INSTALLED_APPS");
        VALID_OP_NAME_MAP = new HashMap();
        VALID_OP_NAME_MAP.put(10000, "MEDIA_PROJECTION_RECORD");
        LOCATION_OP_NAME = new HashSet(Arrays.asList(new String[]{"FINE_LOCATION", "COARSE_LOCATION"}));
        VALID_ACCESS_APPS = new HashSet(Arrays.asList(new String[]{SceneUtils.PKG_SYS_UI, "com.obric.security", "com.android.permissioncontroller"}));
    }
}
