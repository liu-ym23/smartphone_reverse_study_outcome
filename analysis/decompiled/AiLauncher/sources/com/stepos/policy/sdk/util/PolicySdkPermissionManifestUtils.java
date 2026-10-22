package com.stepos.policy.sdk.util;

import android.content.Context;
import com.stepos.policy.sdk.R$string;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0004J\u001a\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001d2\u0006\u0010\u0019\u001a\u00020\u001aR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/stepos/policy/sdk/util/PolicySdkPermissionManifestUtils;", "", "()V", "ACCESS_BACKGROUND_LOCATION", "", "ACCESS_COARSE_LOCATION", "ACCESS_FINE_LOCATION", "ACCESS_MEDIA_LOCATION", "ACTIVITY_RECOGNITION", "CALENDAR_GROUP", "CALL_LOG_GROUP", "CONTACTS_GROUP", "LOCATION_GROUP", "MICROPHONE_GROUP", "READ_MEDIA_AUDIO", "READ_MEDIA_AURAL_GROUP", "READ_MEDIA_IMAGES", "READ_MEDIA_VIDEO", "READ_MEDIA_VISUAL_GROUP", "READ_PHONE_STATE", "RECORD_AUDIO", "WRITE_CALENDAR", "WRITE_CALL_LOG", "WRITE_CONTACTS", "getPolicyModifyPerKey", "context", "Landroid/content/Context;", "permissionKey", "getPolicyModifyPermissionMap", "", "policysdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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
        p.i(context, "context");
        p.i(permissionKey, "permissionKey");
        String str = getPolicyModifyPermissionMap(context).get(permissionKey);
        return str == null ? permissionKey : str;
    }

    public final Map<String, String> getPolicyModifyPermissionMap(Context context) {
        p.i(context, "context");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String string = context.getString(R$string.policy_sdk_permission_read_phone_state);
        p.h(string, "context.getString(R.stri…mission_read_phone_state)");
        linkedHashMap.put(READ_PHONE_STATE, string);
        int i10 = R$string.policy_sdk_permission_location;
        String string2 = context.getString(i10);
        p.h(string2, "context.getString(R.stri…_sdk_permission_location)");
        linkedHashMap.put(ACCESS_COARSE_LOCATION, string2);
        String string3 = context.getString(R$string.policy_sdk_permission_fine_location);
        p.h(string3, "context.getString(R.stri…permission_fine_location)");
        linkedHashMap.put(ACCESS_FINE_LOCATION, string3);
        String string4 = context.getString(i10);
        p.h(string4, "context.getString(R.stri…_sdk_permission_location)");
        linkedHashMap.put(ACCESS_BACKGROUND_LOCATION, string4);
        String string5 = context.getString(i10);
        p.h(string5, "context.getString(R.stri…_sdk_permission_location)");
        linkedHashMap.put(LOCATION_GROUP, string5);
        String string6 = context.getString(R$string.policy_sdk_permission_activity_recognition);
        p.h(string6, "context.getString(R.stri…ion_activity_recognition)");
        linkedHashMap.put(ACTIVITY_RECOGNITION, string6);
        int i11 = R$string.policy_sdk_permission_write_calendar;
        String string7 = context.getString(i11);
        p.h(string7, "context.getString(R.stri…ermission_write_calendar)");
        linkedHashMap.put(WRITE_CALENDAR, string7);
        String string8 = context.getString(i11);
        p.h(string8, "context.getString(R.stri…ermission_write_calendar)");
        linkedHashMap.put(CALENDAR_GROUP, string8);
        int i12 = R$string.policy_sdk_permission_write_call_log;
        String string9 = context.getString(i12);
        p.h(string9, "context.getString(R.stri…ermission_write_call_log)");
        linkedHashMap.put(WRITE_CALL_LOG, string9);
        String string10 = context.getString(i12);
        p.h(string10, "context.getString(R.stri…ermission_write_call_log)");
        linkedHashMap.put(CALL_LOG_GROUP, string10);
        int i13 = R$string.policy_sdk_permission_write_contacts;
        String string11 = context.getString(i13);
        p.h(string11, "context.getString(R.stri…ermission_write_contacts)");
        linkedHashMap.put(WRITE_CONTACTS, string11);
        String string12 = context.getString(i13);
        p.h(string12, "context.getString(R.stri…ermission_write_contacts)");
        linkedHashMap.put(CONTACTS_GROUP, string12);
        int i14 = R$string.policy_sdk_permission_record_audio;
        String string13 = context.getString(i14);
        p.h(string13, "context.getString(R.stri…_permission_record_audio)");
        linkedHashMap.put(RECORD_AUDIO, string13);
        String string14 = context.getString(i14);
        p.h(string14, "context.getString(R.stri…_permission_record_audio)");
        linkedHashMap.put(MICROPHONE_GROUP, string14);
        String string15 = context.getString(R$string.policy_sdk_permission_access_media_location);
        p.h(string15, "context.getString(R.stri…on_access_media_location)");
        linkedHashMap.put(ACCESS_MEDIA_LOCATION, string15);
        int i15 = R$string.policy_sdk_permission_read_media_audio;
        String string16 = context.getString(i15);
        p.h(string16, "context.getString(R.stri…mission_read_media_audio)");
        linkedHashMap.put(READ_MEDIA_AUDIO, string16);
        String string17 = context.getString(i15);
        p.h(string17, "context.getString(R.stri…mission_read_media_audio)");
        linkedHashMap.put(READ_MEDIA_AURAL_GROUP, string17);
        int i16 = R$string.policy_sdk_permission_read_media;
        String string18 = context.getString(i16);
        p.h(string18, "context.getString(R.stri…dk_permission_read_media)");
        linkedHashMap.put(READ_MEDIA_IMAGES, string18);
        String string19 = context.getString(i16);
        p.h(string19, "context.getString(R.stri…dk_permission_read_media)");
        linkedHashMap.put(READ_MEDIA_VIDEO, string19);
        String string20 = context.getString(i16);
        p.h(string20, "context.getString(R.stri…dk_permission_read_media)");
        linkedHashMap.put(READ_MEDIA_VISUAL_GROUP, string20);
        return linkedHashMap;
    }
}
