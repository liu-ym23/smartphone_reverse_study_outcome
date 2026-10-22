package com.stepos.policy.sdk.util;

import android.content.Context;
import com.stepos.policy.sdk.R;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class PolicySdkPermissionManifestUtils {
    public static final String ACCESS_BACKGROUND_LOCATION = "android.permission.ACCESS_BACKGROUND_LOCATION";
    public static final String ACCESS_COARSE_LOCATION = "android.permission.ACCESS_COARSE_LOCATION";
    public static final String ACCESS_FINE_LOCATION = "android.permission.ACCESS_FINE_LOCATION";
    public static final String ACCESS_MEDIA_LOCATION = "android.permission.ACCESS_MEDIA_LOCATION";
    public static final String ACTIVITY_RECOGNITION = "android.permission.ACTIVITY_RECOGNITION";
    public static final String CALENDAR_GROUP = "android.permission-group.CALENDAR";
    public static final String CALL_LOG_GROUP = "android.permission-group.CALL_LOG";
    public static final String CONTACTS_GROUP = "android.permission-group.CONTACTS";
    public static final PolicySdkPermissionManifestUtils INSTANCE = new PolicySdkPermissionManifestUtils();
    public static final String LOCATION_GROUP = "android.permission-group.LOCATION";
    public static final String MICROPHONE_GROUP = "android.permission-group.MICROPHONE";
    public static final String READ_MEDIA_AUDIO = "android.permission.READ_MEDIA_AUDIO";
    public static final String READ_MEDIA_AURAL_GROUP = "android.permission-group.READ_MEDIA_AURAL";
    public static final String READ_MEDIA_IMAGES = "android.permission.READ_MEDIA_IMAGES";
    public static final String READ_MEDIA_VIDEO = "android.permission.READ_MEDIA_VIDEO";
    public static final String READ_MEDIA_VISUAL_GROUP = "android.permission-group.READ_MEDIA_VISUAL";
    public static final String READ_PHONE_STATE = "android.permission.READ_PHONE_STATE";
    public static final String RECORD_AUDIO = "android.permission.RECORD_AUDIO";
    public static final String WRITE_CALENDAR = "android.permission.WRITE_CALENDAR";
    public static final String WRITE_CALL_LOG = "android.permission.WRITE_CALL_LOG";
    public static final String WRITE_CONTACTS = "android.permission.WRITE_CONTACTS";

    private PolicySdkPermissionManifestUtils() {
    }

    public final String getPolicyModifyPerKey(Context context, String str) {
        context.getClass();
        str.getClass();
        String str2 = getPolicyModifyPermissionMap(context).get(str);
        return str2 == null ? str : str2;
    }

    public final Map<String, String> getPolicyModifyPermissionMap(Context context) {
        context.getClass();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        androidx.activity.b.r(context, R.string.policy_sdk_permission_read_phone_state, linkedHashMap, READ_PHONE_STATE);
        androidx.activity.b.r(context, R.string.policy_sdk_permission_location, linkedHashMap, ACCESS_COARSE_LOCATION);
        androidx.activity.b.r(context, R.string.policy_sdk_permission_fine_location, linkedHashMap, ACCESS_FINE_LOCATION);
        androidx.activity.b.r(context, R.string.policy_sdk_permission_location, linkedHashMap, ACCESS_BACKGROUND_LOCATION);
        androidx.activity.b.r(context, R.string.policy_sdk_permission_location, linkedHashMap, LOCATION_GROUP);
        androidx.activity.b.r(context, R.string.policy_sdk_permission_activity_recognition, linkedHashMap, ACTIVITY_RECOGNITION);
        androidx.activity.b.r(context, R.string.policy_sdk_permission_write_calendar, linkedHashMap, WRITE_CALENDAR);
        androidx.activity.b.r(context, R.string.policy_sdk_permission_write_calendar, linkedHashMap, CALENDAR_GROUP);
        androidx.activity.b.r(context, R.string.policy_sdk_permission_write_call_log, linkedHashMap, WRITE_CALL_LOG);
        androidx.activity.b.r(context, R.string.policy_sdk_permission_write_call_log, linkedHashMap, CALL_LOG_GROUP);
        androidx.activity.b.r(context, R.string.policy_sdk_permission_write_contacts, linkedHashMap, WRITE_CONTACTS);
        androidx.activity.b.r(context, R.string.policy_sdk_permission_write_contacts, linkedHashMap, CONTACTS_GROUP);
        androidx.activity.b.r(context, R.string.policy_sdk_permission_record_audio, linkedHashMap, RECORD_AUDIO);
        androidx.activity.b.r(context, R.string.policy_sdk_permission_record_audio, linkedHashMap, MICROPHONE_GROUP);
        androidx.activity.b.r(context, R.string.policy_sdk_permission_access_media_location, linkedHashMap, ACCESS_MEDIA_LOCATION);
        androidx.activity.b.r(context, R.string.policy_sdk_permission_read_media_audio, linkedHashMap, READ_MEDIA_AUDIO);
        androidx.activity.b.r(context, R.string.policy_sdk_permission_read_media_audio, linkedHashMap, READ_MEDIA_AURAL_GROUP);
        androidx.activity.b.r(context, R.string.policy_sdk_permission_read_media, linkedHashMap, READ_MEDIA_IMAGES);
        androidx.activity.b.r(context, R.string.policy_sdk_permission_read_media, linkedHashMap, READ_MEDIA_VIDEO);
        androidx.activity.b.r(context, R.string.policy_sdk_permission_read_media, linkedHashMap, READ_MEDIA_VISUAL_GROUP);
        return linkedHashMap;
    }
}
