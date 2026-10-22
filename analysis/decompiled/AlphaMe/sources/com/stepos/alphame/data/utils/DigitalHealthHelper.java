package com.stepos.alphame.data.utils;

import B0.g;
import android.content.Context;
import android.provider.Settings;
import android.util.Log;
import ch.qos.logback.core.CoreConstants;
import com.stepos.alphame.common.data.DataStoreManager;
import com.stepos.alphame.data.DataContractKt;
import com.stepos.alphame.model.event.DailyUsageMessage;
import com.stepos.alphame.model.event.DailyUsageUserChangedMessage;
import com.stepos.alphame.model.event.DailyUsageUserDeletedMessage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u0010\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u0017\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0012R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/stepos/alphame/data/utils/DigitalHealthHelper;", "", "()V", "KEY_ACTIVE_MINOR_ID", "", "KEY_MINORS_MODE_AGE_RANGE", "KEY_MINOR_MODE", "KEY_SUPPORT_MINOR_MODE", "MINORS_MODE_DISABLED", "", "MINORS_MODE_ENABLED", "getActiveMinorsId", "", CoreConstants.CONTEXT_SCOPE_VALUE, "Landroid/content/Context;", "getCurrentMode", "getCurrentUserId", "isDigitalHealthFeatureEnable", "", "isDigitalHealthMessage", "dailyUsageMessage", "Lcom/stepos/alphame/model/event/DailyUsageMessage;", "isMinorModeFeatureSupport", "isMinorsModeEnable", "setDigitalHealthFeatureEnableStatus", "", "enable", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DigitalHealthHelper {

    @NotNull
    public static final DigitalHealthHelper INSTANCE = new DigitalHealthHelper();

    @NotNull
    public static final String KEY_ACTIVE_MINOR_ID = "active_minor_id";

    @NotNull
    public static final String KEY_MINORS_MODE_AGE_RANGE = "minors_mode_age_range";

    @NotNull
    public static final String KEY_MINOR_MODE = "minors_mode_enabled";

    @NotNull
    public static final String KEY_SUPPORT_MINOR_MODE = "minors_mode";
    public static final int MINORS_MODE_DISABLED = 0;
    public static final int MINORS_MODE_ENABLED = 1;

    private DigitalHealthHelper() {
    }

    public final long getActiveMinorsId(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return Settings.Secure.getLong(context.getContentResolver(), "active_minor_id", -1L);
    }

    public final int getCurrentMode(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        boolean zIsMinorsModeEnable = isMinorsModeEnable(context);
        g.z("get current mode ", zIsMinorsModeEnable ? 1 : 0, DataContractKt.TAG);
        return zIsMinorsModeEnable ? 1 : 0;
    }

    public final long getCurrentUserId(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        long activeMinorsId = isMinorsModeEnable(context) ? getActiveMinorsId(context) : -1L;
        Log.d(DataContractKt.TAG, "get current user id " + activeMinorsId);
        return activeMinorsId;
    }

    public final boolean isDigitalHealthFeatureEnable() {
        return ((Boolean) DataStoreManager.INSTANCE.getDataStore(DataContractKt.DAILY_USAGE_FILE_NAME).getData(DataContractKt.DIGITAL_HEALTH_FEATURE, Boolean.TRUE)).booleanValue();
    }

    public final boolean isDigitalHealthMessage(@NotNull DailyUsageMessage dailyUsageMessage) {
        Intrinsics.checkNotNullParameter(dailyUsageMessage, "dailyUsageMessage");
        return (dailyUsageMessage instanceof DailyUsageUserDeletedMessage) || (dailyUsageMessage instanceof DailyUsageUserChangedMessage);
    }

    public final boolean isMinorModeFeatureSupport(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            return Settings.Secure.getInt(context.getContentResolver(), "minors_mode", 0) == 1;
        } catch (Exception e4) {
            e4.printStackTrace();
            return false;
        }
    }

    public final boolean isMinorsModeEnable(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            return 1 == Settings.Secure.getInt(context.getContentResolver(), "minors_mode_enabled", 0);
        } catch (Exception e4) {
            e4.printStackTrace();
            return false;
        }
    }

    public final void setDigitalHealthFeatureEnableStatus(boolean enable) {
        Log.i(DataContractKt.TAG, "set digital health feature " + enable);
        DataStoreManager.INSTANCE.getDataStore(DataContractKt.DAILY_USAGE_FILE_NAME).putData(DataContractKt.DIGITAL_HEALTH_FEATURE, Boolean.valueOf(enable));
    }
}
