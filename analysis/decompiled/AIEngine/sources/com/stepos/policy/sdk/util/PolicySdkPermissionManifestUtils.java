package com.stepos.policy.sdk.util;

import android.content.Context;
import com.stepos.aiengine.R;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
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

    public final String getPolicyModifyPerKey(Context context, String permissionKey) {
        kotlin.jvm.internal.g.f(context, "context");
        kotlin.jvm.internal.g.f(permissionKey, "permissionKey");
        String str = getPolicyModifyPermissionMap(context).get(permissionKey);
        return str == null ? permissionKey : str;
    }

    public final Map<String, String> getPolicyModifyPermissionMap(Context context) {
        kotlin.jvm.internal.g.f(context, "context");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        ai.onnxruntime.a.v(context, R.string.policy_sdk_permission_read_phone_state, "context.getString(R.stri…mission_read_phone_state)", linkedHashMap, READ_PHONE_STATE);
        ai.onnxruntime.a.v(context, R.string.policy_sdk_permission_location, "context.getString(R.stri…_sdk_permission_location)", linkedHashMap, ACCESS_COARSE_LOCATION);
        ai.onnxruntime.a.v(context, R.string.policy_sdk_permission_fine_location, "context.getString(R.stri…permission_fine_location)", linkedHashMap, ACCESS_FINE_LOCATION);
        ai.onnxruntime.a.v(context, R.string.policy_sdk_permission_location, "context.getString(R.stri…_sdk_permission_location)", linkedHashMap, ACCESS_BACKGROUND_LOCATION);
        ai.onnxruntime.a.v(context, R.string.policy_sdk_permission_location, "context.getString(R.stri…_sdk_permission_location)", linkedHashMap, LOCATION_GROUP);
        ai.onnxruntime.a.v(context, R.string.policy_sdk_permission_activity_recognition, "context.getString(R.stri…ion_activity_recognition)", linkedHashMap, ACTIVITY_RECOGNITION);
        ai.onnxruntime.a.v(context, R.string.policy_sdk_permission_write_calendar, "context.getString(R.stri…ermission_write_calendar)", linkedHashMap, WRITE_CALENDAR);
        ai.onnxruntime.a.v(context, R.string.policy_sdk_permission_write_calendar, "context.getString(R.stri…ermission_write_calendar)", linkedHashMap, CALENDAR_GROUP);
        ai.onnxruntime.a.v(context, R.string.policy_sdk_permission_write_call_log, "context.getString(R.stri…ermission_write_call_log)", linkedHashMap, WRITE_CALL_LOG);
        ai.onnxruntime.a.v(context, R.string.policy_sdk_permission_write_call_log, "context.getString(R.stri…ermission_write_call_log)", linkedHashMap, CALL_LOG_GROUP);
        ai.onnxruntime.a.v(context, R.string.policy_sdk_permission_write_contacts, "context.getString(R.stri…ermission_write_contacts)", linkedHashMap, WRITE_CONTACTS);
        ai.onnxruntime.a.v(context, R.string.policy_sdk_permission_write_contacts, "context.getString(R.stri…ermission_write_contacts)", linkedHashMap, CONTACTS_GROUP);
        ai.onnxruntime.a.v(context, R.string.policy_sdk_permission_record_audio, "context.getString(R.stri…_permission_record_audio)", linkedHashMap, RECORD_AUDIO);
        ai.onnxruntime.a.v(context, R.string.policy_sdk_permission_record_audio, "context.getString(R.stri…_permission_record_audio)", linkedHashMap, MICROPHONE_GROUP);
        ai.onnxruntime.a.v(context, R.string.policy_sdk_permission_access_media_location, "context.getString(R.stri…on_access_media_location)", linkedHashMap, ACCESS_MEDIA_LOCATION);
        ai.onnxruntime.a.v(context, R.string.policy_sdk_permission_read_media_audio, "context.getString(R.stri…mission_read_media_audio)", linkedHashMap, READ_MEDIA_AUDIO);
        ai.onnxruntime.a.v(context, R.string.policy_sdk_permission_read_media_audio, "context.getString(R.stri…mission_read_media_audio)", linkedHashMap, READ_MEDIA_AURAL_GROUP);
        ai.onnxruntime.a.v(context, R.string.policy_sdk_permission_read_media, "context.getString(R.stri…dk_permission_read_media)", linkedHashMap, READ_MEDIA_IMAGES);
        ai.onnxruntime.a.v(context, R.string.policy_sdk_permission_read_media, "context.getString(R.stri…dk_permission_read_media)", linkedHashMap, READ_MEDIA_VIDEO);
        ai.onnxruntime.a.v(context, R.string.policy_sdk_permission_read_media, "context.getString(R.stri…dk_permission_read_media)", linkedHashMap, READ_MEDIA_VISUAL_GROUP);
        return linkedHashMap;
    }
}
