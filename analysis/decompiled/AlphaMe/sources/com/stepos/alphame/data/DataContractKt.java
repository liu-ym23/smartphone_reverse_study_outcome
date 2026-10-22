package com.stepos.alphame.data;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0004\u001a\u000e\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0011\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"ACTION_APP_EVENT", "", "DAILY_USAGE_FILE_NAME", "DEFAULT_USER_ID_IN_NORMAL_MODE", "", "DIGITAL_HEALTH_FEATURE", "EXTRA_END_TIME", "EXTRA_PACKAGE_NAME", "EXTRA_START_TIME", "EXTRA_STATE", "EXTRA_TYPE", "INVALID_VALUE", "KEY_TIME_RESTRICTED_APPS", "PACKAGE_NAME_SCENE_INFO", "PERMISSION_APP_EVENT", "TAG", "USER_MODE_MINORS", "", "USER_MODE_NORMAL", "isUserIdInvalid", "", "userId", "isUserModeValid", "mode", "data_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DataContractKt {

    @NotNull
    public static final String ACTION_APP_EVENT = "com.stepos.alphame.intent.action.APP_EVENT";

    @NotNull
    public static final String DAILY_USAGE_FILE_NAME = "daily_usage";
    public static final long DEFAULT_USER_ID_IN_NORMAL_MODE = -1;

    @NotNull
    public static final String DIGITAL_HEALTH_FEATURE = "digital_health";

    @NotNull
    public static final String EXTRA_END_TIME = "end_time";

    @NotNull
    public static final String EXTRA_PACKAGE_NAME = "package_name";

    @NotNull
    public static final String EXTRA_START_TIME = "start_time";

    @NotNull
    public static final String EXTRA_STATE = "state";

    @NotNull
    public static final String EXTRA_TYPE = "type";
    public static final long INVALID_VALUE = -1;

    @NotNull
    public static final String KEY_TIME_RESTRICTED_APPS = "time_restricted_apps";

    @NotNull
    public static final String PACKAGE_NAME_SCENE_INFO = "com.stepos.familyguard";

    @NotNull
    public static final String PERMISSION_APP_EVENT = "com.stepos.alphame.permission.APP_EVENT";

    @NotNull
    public static final String TAG = "engine_data";
    public static final int USER_MODE_MINORS = 1;
    public static final int USER_MODE_NORMAL = 0;

    public static final boolean isUserIdInvalid(long j4) {
        return j4 == -1;
    }

    public static final boolean isUserModeValid(int i4) {
        return i4 == 0 || i4 == 1;
    }
}
