package com.android.server.companion.transport;

import android.companion.AssociationInfo;
import android.util.ArrayMap;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class TransportUtils {
    private static final Map<String, Integer> DEVICE_PROFILE_TRANSPORT_FLAGS_ALLOWLIST = null;

    static {
        Map<String, Integer> map = new ArrayMap();
        map.put("android.companion.COMPANION_DEVICE_WEARABLE_SENSING", 1);
        DEVICE_PROFILE_TRANSPORT_FLAGS_ALLOWLIST = Collections.unmodifiableMap(map);
    }

    public static void enforceAssociationCanUseTransportFlags(AssociationInfo association, int flags) {
        if (flags != 0) goto L4;
        return;
    L4:
        String deviceProfile = association.getDeviceProfile();
        if (DEVICE_PROFILE_TRANSPORT_FLAGS_ALLOWLIST.containsKey(deviceProfile) == false) goto L12;
        int allowedFlags = DEVICE_PROFILE_TRANSPORT_FLAGS_ALLOWLIST.get(deviceProfile).intValue();
        if ((allowedFlags & flags) != flags) goto L10;
        return;
    L10:
        throw new IllegalArgumentException("Association (id=" + association.getId() + ") does not have the device profile required to use at least one of the flags in this transport.");
    L12:
        throw new IllegalArgumentException("Association (id=" + association.getId() + ") with device profile " + deviceProfile + " does not support the usage of transport flags.");
    }

    private TransportUtils() {
    }
}
