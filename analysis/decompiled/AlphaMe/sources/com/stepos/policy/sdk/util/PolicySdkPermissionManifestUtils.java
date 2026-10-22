package com.stepos.policy.sdk.util;

import android.content.Context;
import ch.qos.logback.core.CoreConstants;
import com.stepos.alphame.R;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0004J\u001a\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001d2\u0006\u0010\u0019\u001a\u00020\u001aR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/stepos/policy/sdk/util/PolicySdkPermissionManifestUtils;", "", "()V", "ACCESS_BACKGROUND_LOCATION", "", "ACCESS_COARSE_LOCATION", "ACCESS_FINE_LOCATION", "ACCESS_MEDIA_LOCATION", "ACTIVITY_RECOGNITION", "CALENDAR_GROUP", "CALL_LOG_GROUP", "CONTACTS_GROUP", "LOCATION_GROUP", "MICROPHONE_GROUP", "READ_MEDIA_AUDIO", "READ_MEDIA_AURAL_GROUP", "READ_MEDIA_IMAGES", "READ_MEDIA_VIDEO", "READ_MEDIA_VISUAL_GROUP", "READ_PHONE_STATE", "RECORD_AUDIO", "WRITE_CALENDAR", "WRITE_CALL_LOG", "WRITE_CONTACTS", "getPolicyModifyPerKey", CoreConstants.CONTEXT_SCOPE_VALUE, "Landroid/content/Context;", "permissionKey", "getPolicyModifyPermissionMap", "", "policysdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PolicySdkPermissionManifestUtils {

    @NotNull
    public static final String ACCESS_BACKGROUND_LOCATION = "android.permission.ACCESS_BACKGROUND_LOCATION";

    @NotNull
    public static final String ACCESS_COARSE_LOCATION = "android.permission.ACCESS_COARSE_LOCATION";

    @NotNull
    public static final String ACCESS_FINE_LOCATION = "android.permission.ACCESS_FINE_LOCATION";

    @NotNull
    public static final String ACCESS_MEDIA_LOCATION = "android.permission.ACCESS_MEDIA_LOCATION";

    @NotNull
    public static final String ACTIVITY_RECOGNITION = "android.permission.ACTIVITY_RECOGNITION";

    @NotNull
    public static final String CALENDAR_GROUP = "android.permission-group.CALENDAR";

    @NotNull
    public static final String CALL_LOG_GROUP = "android.permission-group.CALL_LOG";

    @NotNull
    public static final String CONTACTS_GROUP = "android.permission-group.CONTACTS";

    @NotNull
    public static final PolicySdkPermissionManifestUtils INSTANCE = new PolicySdkPermissionManifestUtils();

    @NotNull
    public static final String LOCATION_GROUP = "android.permission-group.LOCATION";

    @NotNull
    public static final String MICROPHONE_GROUP = "android.permission-group.MICROPHONE";

    @NotNull
    public static final String READ_MEDIA_AUDIO = "android.permission.READ_MEDIA_AUDIO";

    @NotNull
    public static final String READ_MEDIA_AURAL_GROUP = "android.permission-group.READ_MEDIA_AURAL";

    @NotNull
    public static final String READ_MEDIA_IMAGES = "android.permission.READ_MEDIA_IMAGES";

    @NotNull
    public static final String READ_MEDIA_VIDEO = "android.permission.READ_MEDIA_VIDEO";

    @NotNull
    public static final String READ_MEDIA_VISUAL_GROUP = "android.permission-group.READ_MEDIA_VISUAL";

    @NotNull
    public static final String READ_PHONE_STATE = "android.permission.READ_PHONE_STATE";

    @NotNull
    public static final String RECORD_AUDIO = "android.permission.RECORD_AUDIO";

    @NotNull
    public static final String WRITE_CALENDAR = "android.permission.WRITE_CALENDAR";

    @NotNull
    public static final String WRITE_CALL_LOG = "android.permission.WRITE_CALL_LOG";

    @NotNull
    public static final String WRITE_CONTACTS = "android.permission.WRITE_CONTACTS";

    private PolicySdkPermissionManifestUtils() {
    }

    @NotNull
    public final String getPolicyModifyPerKey(@NotNull Context context, @NotNull String permissionKey) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(permissionKey, "permissionKey");
        String str = getPolicyModifyPermissionMap(context).get(permissionKey);
        return str == null ? permissionKey : str;
    }

    @NotNull
    public final Map<String, String> getPolicyModifyPermissionMap(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        a.a(context, R.string.policy_sdk_permission_read_phone_state, "context.getString(R.stri…mission_read_phone_state)", linkedHashMap, READ_PHONE_STATE);
        a.a(context, R.string.policy_sdk_permission_location, "context.getString(R.stri…_sdk_permission_location)", linkedHashMap, ACCESS_COARSE_LOCATION);
        a.a(context, R.string.policy_sdk_permission_fine_location, "context.getString(R.stri…permission_fine_location)", linkedHashMap, ACCESS_FINE_LOCATION);
        a.a(context, R.string.policy_sdk_permission_location, "context.getString(R.stri…_sdk_permission_location)", linkedHashMap, ACCESS_BACKGROUND_LOCATION);
        a.a(context, R.string.policy_sdk_permission_location, "context.getString(R.stri…_sdk_permission_location)", linkedHashMap, LOCATION_GROUP);
        a.a(context, R.string.policy_sdk_permission_activity_recognition, "context.getString(R.stri…ion_activity_recognition)", linkedHashMap, ACTIVITY_RECOGNITION);
        a.a(context, R.string.policy_sdk_permission_write_calendar, "context.getString(R.stri…ermission_write_calendar)", linkedHashMap, WRITE_CALENDAR);
        a.a(context, R.string.policy_sdk_permission_write_calendar, "context.getString(R.stri…ermission_write_calendar)", linkedHashMap, CALENDAR_GROUP);
        a.a(context, R.string.policy_sdk_permission_write_call_log, "context.getString(R.stri…ermission_write_call_log)", linkedHashMap, WRITE_CALL_LOG);
        a.a(context, R.string.policy_sdk_permission_write_call_log, "context.getString(R.stri…ermission_write_call_log)", linkedHashMap, CALL_LOG_GROUP);
        a.a(context, R.string.policy_sdk_permission_write_contacts, "context.getString(R.stri…ermission_write_contacts)", linkedHashMap, WRITE_CONTACTS);
        a.a(context, R.string.policy_sdk_permission_write_contacts, "context.getString(R.stri…ermission_write_contacts)", linkedHashMap, CONTACTS_GROUP);
        a.a(context, R.string.policy_sdk_permission_record_audio, "context.getString(R.stri…_permission_record_audio)", linkedHashMap, RECORD_AUDIO);
        a.a(context, R.string.policy_sdk_permission_record_audio, "context.getString(R.stri…_permission_record_audio)", linkedHashMap, MICROPHONE_GROUP);
        a.a(context, R.string.policy_sdk_permission_access_media_location, "context.getString(R.stri…on_access_media_location)", linkedHashMap, ACCESS_MEDIA_LOCATION);
        a.a(context, R.string.policy_sdk_permission_read_media_audio, "context.getString(R.stri…mission_read_media_audio)", linkedHashMap, READ_MEDIA_AUDIO);
        a.a(context, R.string.policy_sdk_permission_read_media_audio, "context.getString(R.stri…mission_read_media_audio)", linkedHashMap, READ_MEDIA_AURAL_GROUP);
        a.a(context, R.string.policy_sdk_permission_read_media, "context.getString(R.stri…dk_permission_read_media)", linkedHashMap, READ_MEDIA_IMAGES);
        a.a(context, R.string.policy_sdk_permission_read_media, "context.getString(R.stri…dk_permission_read_media)", linkedHashMap, READ_MEDIA_VIDEO);
        a.a(context, R.string.policy_sdk_permission_read_media, "context.getString(R.stri…dk_permission_read_media)", linkedHashMap, READ_MEDIA_VISUAL_GROUP);
        return linkedHashMap;
    }
}
