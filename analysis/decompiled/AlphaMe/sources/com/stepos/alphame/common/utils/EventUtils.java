package com.stepos.alphame.common.utils;

import com.stepos.alphame.appinfo.AppInfoDbHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/stepos/alphame/common/utils/EventUtils;", "", "()V", "SCREEN_OFF", "", "SCREEN_ON", "isScreenOffEvent", "", AppInfoDbHelper.TAG_U_PACKAGE_NAME, "isScreenOnEvent", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class EventUtils {

    @NotNull
    public static final EventUtils INSTANCE = new EventUtils();

    @NotNull
    public static final String SCREEN_OFF = "screen_off";

    @NotNull
    public static final String SCREEN_ON = "screen_on";

    private EventUtils() {
    }

    public final boolean isScreenOffEvent(@NotNull String packageName) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        return Intrinsics.areEqual(packageName, "screen_off");
    }

    public final boolean isScreenOnEvent(@NotNull String packageName) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        return Intrinsics.areEqual(packageName, SCREEN_ON);
    }
}
