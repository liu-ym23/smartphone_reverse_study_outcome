package com.stepos.policy.sdk.util;

import android.content.Context;
import com.stepos.policy.sdk.s;
import j4.k;
import java.util.LinkedHashMap;
import java.util.Map;

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
        k.g(context, "context");
        k.g(str, "permissionKey");
        String str2 = getPolicyModifyPermissionMap(context).get(str);
        return str2 == null ? str : str2;
    }

    public final Map<String, String> getPolicyModifyPermissionMap(Context context) {
        k.g(context, "context");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String string = context.getString(s.f15838p);
        k.f(string, "context.getString(R.stri…mission_read_phone_state)");
        linkedHashMap.put(READ_PHONE_STATE, string);
        int i5 = s.f15835m;
        String string2 = context.getString(i5);
        k.f(string2, "context.getString(R.stri…_sdk_permission_location)");
        linkedHashMap.put(ACCESS_COARSE_LOCATION, string2);
        String string3 = context.getString(s.f15834l);
        k.f(string3, "context.getString(R.stri…permission_fine_location)");
        linkedHashMap.put(ACCESS_FINE_LOCATION, string3);
        String string4 = context.getString(i5);
        k.f(string4, "context.getString(R.stri…_sdk_permission_location)");
        linkedHashMap.put(ACCESS_BACKGROUND_LOCATION, string4);
        String string5 = context.getString(i5);
        k.f(string5, "context.getString(R.stri…_sdk_permission_location)");
        linkedHashMap.put(LOCATION_GROUP, string5);
        String string6 = context.getString(s.f15833k);
        k.f(string6, "context.getString(R.stri…ion_activity_recognition)");
        linkedHashMap.put(ACTIVITY_RECOGNITION, string6);
        int i6 = s.f15840r;
        String string7 = context.getString(i6);
        k.f(string7, "context.getString(R.stri…ermission_write_calendar)");
        linkedHashMap.put(WRITE_CALENDAR, string7);
        String string8 = context.getString(i6);
        k.f(string8, "context.getString(R.stri…ermission_write_calendar)");
        linkedHashMap.put(CALENDAR_GROUP, string8);
        int i7 = s.f15841s;
        String string9 = context.getString(i7);
        k.f(string9, "context.getString(R.stri…ermission_write_call_log)");
        linkedHashMap.put(WRITE_CALL_LOG, string9);
        String string10 = context.getString(i7);
        k.f(string10, "context.getString(R.stri…ermission_write_call_log)");
        linkedHashMap.put(CALL_LOG_GROUP, string10);
        int i8 = s.f15842t;
        String string11 = context.getString(i8);
        k.f(string11, "context.getString(R.stri…ermission_write_contacts)");
        linkedHashMap.put(WRITE_CONTACTS, string11);
        String string12 = context.getString(i8);
        k.f(string12, "context.getString(R.stri…ermission_write_contacts)");
        linkedHashMap.put(CONTACTS_GROUP, string12);
        int i9 = s.f15839q;
        String string13 = context.getString(i9);
        k.f(string13, "context.getString(R.stri…_permission_record_audio)");
        linkedHashMap.put(RECORD_AUDIO, string13);
        String string14 = context.getString(i9);
        k.f(string14, "context.getString(R.stri…_permission_record_audio)");
        linkedHashMap.put(MICROPHONE_GROUP, string14);
        String string15 = context.getString(s.f15832j);
        k.f(string15, "context.getString(R.stri…on_access_media_location)");
        linkedHashMap.put(ACCESS_MEDIA_LOCATION, string15);
        int i10 = s.f15837o;
        String string16 = context.getString(i10);
        k.f(string16, "context.getString(R.stri…mission_read_media_audio)");
        linkedHashMap.put(READ_MEDIA_AUDIO, string16);
        String string17 = context.getString(i10);
        k.f(string17, "context.getString(R.stri…mission_read_media_audio)");
        linkedHashMap.put(READ_MEDIA_AURAL_GROUP, string17);
        int i11 = s.f15836n;
        String string18 = context.getString(i11);
        k.f(string18, "context.getString(R.stri…dk_permission_read_media)");
        linkedHashMap.put(READ_MEDIA_IMAGES, string18);
        String string19 = context.getString(i11);
        k.f(string19, "context.getString(R.stri…dk_permission_read_media)");
        linkedHashMap.put(READ_MEDIA_VIDEO, string19);
        String string20 = context.getString(i11);
        k.f(string20, "context.getString(R.stri…dk_permission_read_media)");
        linkedHashMap.put(READ_MEDIA_VISUAL_GROUP, string20);
        return linkedHashMap;
    }
}
