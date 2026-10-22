package com.android.server.companion.utils;

import android.util.ArrayMap;
import com.android.internal.util.FrameworkStatsLog;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class MetricUtils {
    private static final Map<String, Integer> METRIC_DEVICE_PROFILE = null;

    public MetricUtils() {
    }

    static {
        Map<String, Integer> map = new ArrayMap();
        map.put(null, 0);
        map.put("android.app.role.COMPANION_DEVICE_WATCH", 1);
        map.put("android.app.role.COMPANION_DEVICE_APP_STREAMING", 2);
        map.put("android.app.role.SYSTEM_AUTOMOTIVE_PROJECTION", 3);
        map.put("android.app.role.COMPANION_DEVICE_COMPUTER", 4);
        map.put("android.app.role.COMPANION_DEVICE_GLASSES", 5);
        map.put("android.app.role.COMPANION_DEVICE_NEARBY_DEVICE_STREAMING", 6);
        map.put("android.app.role.COMPANION_DEVICE_VIRTUAL_DEVICE", 7);
        map.put("android.companion.COMPANION_DEVICE_WEARABLE_SENSING", 8);
        METRIC_DEVICE_PROFILE = Collections.unmodifiableMap(map);
    }

    public static void logCreateAssociation(String profile) {
        FrameworkStatsLog.write(FrameworkStatsLog.CDM_ASSOCIATION_ACTION, 1, METRIC_DEVICE_PROFILE.get(profile).intValue());
    }

    public static void logRemoveAssociation(String profile) {
        FrameworkStatsLog.write(FrameworkStatsLog.CDM_ASSOCIATION_ACTION, 2, METRIC_DEVICE_PROFILE.get(profile).intValue());
    }
}
