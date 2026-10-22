package com.stepos.alphame.data.utils;

import com.stepos.alphame.appinfo.AppInfoDbHelper;
import com.stepos.alphame.model.event.DailyUsageAudioMessage;
import com.stepos.alphame.model.event.DailyUsageDataClearMessage;
import com.stepos.alphame.model.event.DailyUsageInitMessage;
import com.stepos.alphame.model.event.DailyUsageNotificationMessage;
import com.stepos.alphame.model.event.DailyUsageScreenMessage;
import com.stepos.alphame.model.event.DailyUsageShutdownMessage;
import com.stepos.alphame.model.event.DailyUsageTimeChangedMessage;
import com.stepos.alphame.model.event.DailyUsageUserChangedMessage;
import com.stepos.alphame.model.event.DailyUsageUserDeletedMessage;
import com.stepos.alphame.model.event.DailyUsageUserModeChangedMessage;
import com.stepos.alphame.model.event.DailyUsageWindowMessage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import m3.e;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u0016\n\u0002\b\u0004\u001a\u001e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u001e\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u000e\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u0016\u0010\f\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u0016\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u000e\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u0016\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007\u001a&\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u001e\u0010\u0016\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u001e\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u0016\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\u001c"}, d2 = {"sendDailyUsageAudioMessage", "", AppInfoDbHelper.TAG_U_PACKAGE_NAME, "", "audioPlayedState", "", "triggerTime", "", "sendDailyUsageDataClearMessage", "mode", "userId", "sendDailyUsageInitMessage", "sendDailyUsageNotificationMessage", "sendDailyUsageScreenMessage", "state", "sendDailyUsageShutdownMessage", "sendDailyUsageTimeChangedMessage", "action", "sendDailyUsageUserChangeMessage", "currentMode", "currentUserId", "oldUserId", "sendDailyUsageUserDeletedMessage", "userIds", "", "sendDailyUsageUserModeChangeMessage", "oldMode", "sendDailyUsageWindowMessage", "data_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DailyUsageMessageHelperKt {
    public static final void sendDailyUsageAudioMessage(@NotNull String packageName, int i4, long j4) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        e.b().e(new DailyUsageAudioMessage(j4, packageName, i4));
    }

    public static final void sendDailyUsageDataClearMessage(int i4, long j4, long j5) {
        e.b().e(new DailyUsageDataClearMessage(j5, i4, j4));
    }

    public static final void sendDailyUsageInitMessage(long j4) {
        e.b().e(new DailyUsageInitMessage(j4));
    }

    public static final void sendDailyUsageNotificationMessage(@NotNull String packageName, long j4) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        e.b().e(new DailyUsageNotificationMessage(j4, packageName));
    }

    public static final void sendDailyUsageScreenMessage(@NotNull String state, long j4) {
        Intrinsics.checkNotNullParameter(state, "state");
        e.b().e(new DailyUsageScreenMessage(j4, state));
    }

    public static final void sendDailyUsageShutdownMessage(long j4) {
        e.b().e(new DailyUsageShutdownMessage(j4));
    }

    public static final void sendDailyUsageTimeChangedMessage(@NotNull String action, long j4) {
        Intrinsics.checkNotNullParameter(action, "action");
        e.b().e(new DailyUsageTimeChangedMessage(j4, action));
    }

    public static final void sendDailyUsageUserChangeMessage(int i4, long j4, long j5, long j6) {
        e.b().e(new DailyUsageUserChangedMessage(j6, i4, j4, j5));
    }

    public static final void sendDailyUsageUserDeletedMessage(int i4, @NotNull long[] userIds, long j4) {
        Intrinsics.checkNotNullParameter(userIds, "userIds");
        e.b().e(new DailyUsageUserDeletedMessage(j4, i4, userIds));
    }

    public static final void sendDailyUsageUserModeChangeMessage(int i4, int i5, long j4) {
        e.b().e(new DailyUsageUserModeChangedMessage(j4, i4, i5));
    }

    public static final void sendDailyUsageWindowMessage(@NotNull String packageName, long j4) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        e.b().e(new DailyUsageWindowMessage(j4, packageName));
    }
}
