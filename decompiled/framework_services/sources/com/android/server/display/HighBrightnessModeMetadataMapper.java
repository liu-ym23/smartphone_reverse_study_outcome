package com.android.server.display;

import android.util.ArrayMap;
import android.util.Slog;

/* JADX INFO: loaded from: classes2.dex */
class HighBrightnessModeMetadataMapper {
    private static final String TAG = "HighBrightnessModeMetadataMapper";
    private final ArrayMap<String, HighBrightnessModeMetadata> mHighBrightnessModeMetadataMap;

    HighBrightnessModeMetadataMapper() {
        this.mHighBrightnessModeMetadataMap = new ArrayMap();
    }

    HighBrightnessModeMetadata getHighBrightnessModeMetadataLocked(LogicalDisplay display) {
        DisplayDevice device = display.getPrimaryDisplayDeviceLocked();
        if (device != null) goto L7;
        Slog.wtf(TAG, "Display Device is null in DisplayPowerController for display: " + display.getDisplayIdLocked());
        return null;
    L7:
        if (device.getDisplayDeviceConfig().getHighBrightnessModeData() != null) goto L9;
        return null;
    L9:
        String uniqueId = device.getUniqueId();
        if (this.mHighBrightnessModeMetadataMap.containsKey(uniqueId) == true) goto L12;
        HighBrightnessModeMetadata hbmInfo = new HighBrightnessModeMetadata();
        this.mHighBrightnessModeMetadataMap.put(uniqueId, hbmInfo);
        return hbmInfo;
    L12:
        return this.mHighBrightnessModeMetadataMap.get(uniqueId);
    }
}
