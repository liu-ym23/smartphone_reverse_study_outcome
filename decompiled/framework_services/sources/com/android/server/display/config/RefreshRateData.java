package com.android.server.display.config;

import android.R;
import android.content.res.Resources;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class RefreshRateData {
    private static final int DEFAULT_PEAK_REFRESH_RATE = 0;
    private static final int DEFAULT_REFRESH_RATE = 60;
    public static RefreshRateData DEFAULT_REFRESH_RATE_DATA;
    private static final int DEFAULT_REFRESH_RATE_IN_HBM = 0;
    public final int defaultPeakRefreshRate;
    public final int defaultRefreshRate;
    public final int defaultRefreshRateInHbmHdr;
    public final int defaultRefreshRateInHbmSunlight;
    public final List<SupportedModeData> lowLightBlockingZoneSupportedModes;
    public final List<SupportedModeData> lowPowerSupportedModes;

    static {
        DEFAULT_REFRESH_RATE_DATA = loadRefreshRateData(null, null);
    }

    public RefreshRateData(int defaultRefreshRate, int defaultPeakRefreshRate, int defaultRefreshRateInHbmHdr, int defaultRefreshRateInHbmSunlight, List<SupportedModeData> lowPowerSupportedModes, List<SupportedModeData> lowLightBlockingZoneSupportedModes) {
        this.defaultRefreshRate = defaultRefreshRate;
        this.defaultPeakRefreshRate = defaultPeakRefreshRate;
        this.defaultRefreshRateInHbmHdr = defaultRefreshRateInHbmHdr;
        this.defaultRefreshRateInHbmSunlight = defaultRefreshRateInHbmSunlight;
        this.lowPowerSupportedModes = Collections.unmodifiableList(lowPowerSupportedModes);
        this.lowLightBlockingZoneSupportedModes = Collections.unmodifiableList(lowLightBlockingZoneSupportedModes);
    }

    public String toString() {
        return "RefreshRateData {defaultRefreshRate: " + this.defaultRefreshRate + ", defaultPeakRefreshRate: " + this.defaultPeakRefreshRate + ", defaultRefreshRateInHbmHdr: " + this.defaultRefreshRateInHbmHdr + ", defaultRefreshRateInHbmSunlight: " + this.defaultRefreshRateInHbmSunlight + ", lowPowerSupportedModes=" + this.lowPowerSupportedModes + ", lowLightBlockingZoneSupportedModes=" + this.lowLightBlockingZoneSupportedModes + "} ";
    }

    public static RefreshRateData loadRefreshRateData(DisplayConfiguration config, Resources resources) {
        NonNegativeFloatToFloatMap lowerZoneModes = null;
        if (config != null) goto L5;
        RefreshRateConfigs refreshRateConfigs = null;
    L6:
        int defaultRefreshRate = loadDefaultRefreshRate(refreshRateConfigs, resources);
        int defaultPeakRefreshRate = loadDefaultPeakRefreshRate(refreshRateConfigs, resources);
        int defaultRefreshRateInHbmHdr = loadDefaultRefreshRateInHbm(refreshRateConfigs, resources);
        int defaultRefreshRateInHbmSunlight = loadDefaultRefreshRateInHbmSunlight(refreshRateConfigs, resources);
        if (refreshRateConfigs != null) goto L9;
        NonNegativeFloatToFloatMap r2 = null;
    L10:
        NonNegativeFloatToFloatMap lowPowerModes = r2;
        List<SupportedModeData> lowPowerSupportedModes = SupportedModeData.load(lowPowerModes);
        if (refreshRateConfigs != null) goto L13;
        BlockingZoneConfig r3 = null;
    L14:
        BlockingZoneConfig lowerZoneConfig = r3;
        if (lowerZoneConfig == null) goto L18;
        lowerZoneModes = lowerZoneConfig.getSupportedModes();
    L18:
        List<SupportedModeData> lowLightSupportedModes = SupportedModeData.load(lowerZoneModes);
        return new RefreshRateData(defaultRefreshRate, defaultPeakRefreshRate, defaultRefreshRateInHbmHdr, defaultRefreshRateInHbmSunlight, lowPowerSupportedModes, lowLightSupportedModes);
    L13:
        r3 = refreshRateConfigs.getLowerBlockingZoneConfigs();
        goto L14
    L9:
        r2 = refreshRateConfigs.getLowPowerSupportedModes();
        goto L10
    L5:
        refreshRateConfigs = config.getRefreshRate();
        goto L6
    }

    private static int loadDefaultRefreshRate(RefreshRateConfigs refreshRateConfigs, Resources resources) {
        if (refreshRateConfigs != null) goto L4;
    L7:
        if (resources != null) goto L9;
        return 60;
    L9:
        return resources.getInteger(R.integer.config_demo_pointing_not_aligned_duration_millis);
    L4:
        if (refreshRateConfigs.getDefaultRefreshRate() == null) goto L7;
        return refreshRateConfigs.getDefaultRefreshRate().intValue();
    }

    private static int loadDefaultPeakRefreshRate(RefreshRateConfigs refreshRateConfigs, Resources resources) {
        if (refreshRateConfigs != null) goto L4;
    L7:
        if (resources != null) goto L9;
        return 0;
    L9:
        return resources.getInteger(R.integer.config_default_cellular_usage_setting);
    L4:
        if (refreshRateConfigs.getDefaultPeakRefreshRate() == null) goto L7;
        return refreshRateConfigs.getDefaultPeakRefreshRate().intValue();
    }

    private static int loadDefaultRefreshRateInHbm(RefreshRateConfigs refreshRateConfigs, Resources resources) {
        if (refreshRateConfigs != null) goto L4;
    L7:
        if (resources != null) goto L9;
        return 0;
    L9:
        return resources.getInteger(R.integer.config_deskDockKeepsScreenOn);
    L4:
        if (refreshRateConfigs.getDefaultRefreshRateInHbmHdr() == null) goto L7;
        return refreshRateConfigs.getDefaultRefreshRateInHbmHdr().intValue();
    }

    private static int loadDefaultRefreshRateInHbmSunlight(RefreshRateConfigs refreshRateConfigs, Resources resources) {
        if (refreshRateConfigs != null) goto L4;
    L7:
        if (resources != null) goto L9;
        return 0;
    L9:
        return resources.getInteger(R.integer.config_deskDockRotation);
    L4:
        if (refreshRateConfigs.getDefaultRefreshRateInHbmSunlight() == null) goto L7;
        return refreshRateConfigs.getDefaultRefreshRateInHbmSunlight().intValue();
    }
}
