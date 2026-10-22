package com.android.server.display.mode;

import com.android.server.display.config.SupportedModeData;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
interface Vote {
    public static final int APP_REQUEST_REFRESH_RATE_RANGE_PRIORITY_CUTOFF = 5;
    public static final int INVALID_SIZE = -1;
    public static final int MAX_PRIORITY = 23;
    public static final int MIN_PRIORITY = 0;
    public static final int PRIORITY_APP_REQUEST_BASE_MODE_REFRESH_RATE = 6;
    public static final int PRIORITY_APP_REQUEST_RENDER_FRAME_RATE_RANGE = 5;
    public static final int PRIORITY_APP_REQUEST_SIZE = 7;
    public static final int PRIORITY_AUTH_OPTIMIZER_RENDER_FRAME_RATE = 14;
    public static final int PRIORITY_DEFAULT_RENDER_FRAME_RATE = 0;
    public static final int PRIORITY_FLICKER_REFRESH_RATE = 1;
    public static final int PRIORITY_FLICKER_REFRESH_RATE_SWITCH = 20;
    public static final int PRIORITY_HIGH_BRIGHTNESS_MODE = 2;
    public static final int PRIORITY_LAYOUT_LIMITED_FRAME_RATE = 16;
    public static final int PRIORITY_LAYOUT_LIMITED_REFRESH_RATE = 15;
    public static final int PRIORITY_LIMIT_MODE = 13;
    public static final int PRIORITY_LOW_POWER_MODE_MODES = 18;
    public static final int PRIORITY_LOW_POWER_MODE_RENDER_RATE = 19;
    public static final int PRIORITY_PROXIMITY = 22;
    public static final int PRIORITY_REJECTED_MODES = 8;
    public static final int PRIORITY_SKIN_TEMPERATURE = 21;
    public static final int PRIORITY_SYNCHRONIZED_REFRESH_RATE = 11;
    public static final int PRIORITY_SYNCHRONIZED_RENDER_FRAME_RATE = 12;
    public static final int PRIORITY_SYSTEM_REQUESTED_MODES = 17;
    public static final int PRIORITY_UDFPS = 23;
    public static final int PRIORITY_USER_SETTING_DISPLAY_PREFERRED_SIZE = 4;
    public static final int PRIORITY_USER_SETTING_MIN_RENDER_FRAME_RATE = 3;
    public static final int PRIORITY_USER_SETTING_PEAK_REFRESH_RATE = 9;
    public static final int PRIORITY_USER_SETTING_PEAK_RENDER_FRAME_RATE = 10;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Priority {
    }

    void updateSummary(VoteSummary r1);

    static Vote forPhysicalRefreshRates(float minRefreshRate, float maxRefreshRate) {
        RefreshRateVote.PhysicalVote r1 = new RefreshRateVote.PhysicalVote(minRefreshRate, maxRefreshRate);
        if (minRefreshRate != maxRefreshRate) goto L5;
        boolean r3 = true;
    L7:
        return new CombinedVote(List.of(r1, new DisableRefreshRateSwitchingVote(r3)));
    L5:
        r3 = false;
        goto L7
    }

    static Vote forRenderFrameRates(float minFrameRate, float maxFrameRate) {
        return new RefreshRateVote.RenderVote(minFrameRate, maxFrameRate);
    }

    static Vote forSize(int width, int height) {
        return new SizeVote(width, height, width, height);
    }

    static Vote forSizeAndPhysicalRefreshRatesRange(int minWidth, int minHeight, int width, int height, float minRefreshRate, float maxRefreshRate) {
        SizeVote r1 = new SizeVote(width, height, minWidth, minHeight);
        RefreshRateVote.PhysicalVote r2 = new RefreshRateVote.PhysicalVote(minRefreshRate, maxRefreshRate);
        if (minRefreshRate != maxRefreshRate) goto L5;
        boolean r4 = true;
    L7:
        return new CombinedVote(List.of(r1, r2, new DisableRefreshRateSwitchingVote(r4)));
    L5:
        r4 = false;
        goto L7
    }

    static Vote forDisableRefreshRateSwitching() {
        return new DisableRefreshRateSwitchingVote(true);
    }

    static Vote forBaseModeRefreshRate(float baseModeRefreshRate) {
        return new BaseModeRefreshRateVote(baseModeRefreshRate);
    }

    static Vote forRequestedRefreshRate(float refreshRate) {
        return new RequestedRefreshRateVote(refreshRate);
    }

    static Vote forSupportedRefreshRates(List<SupportedModeData> supportedModes) {
        if (supportedModes.isEmpty() == false) goto L6;
        return null;
    L6:
        List<SupportedRefreshRatesVote.RefreshRates> rates = new ArrayList();
        Iterator<SupportedModeData> r1 = supportedModes.iterator();
    L8:
        if (r1.hasNext() == false) goto L11;
        SupportedModeData data = r1.next();
        rates.add(new SupportedRefreshRatesVote.RefreshRates(data.refreshRate, data.vsyncRate));
        goto L8
    L11:
        return new SupportedRefreshRatesVote(rates);
    }

    static Vote forSupportedModes(List<Integer> modeIds) {
        return new SupportedModesVote(modeIds);
    }

    static Vote forRejectedModes(Set<Integer> modeIds) {
        return new RejectedModesVote(modeIds);
    }

    static String priorityToString(int priority) {
        switch(priority) {
            case 0: goto L51;
            case 1: goto L49;
            case 2: goto L47;
            case 3: goto L45;
            case 4: goto L43;
            case 5: goto L41;
            case 6: goto L39;
            case 7: goto L37;
            case 8: goto L35;
            case 9: goto L33;
            case 10: goto L31;
            case 11: goto L29;
            case 12: goto L27;
            case 13: goto L25;
            case 14: goto L23;
            case 15: goto L21;
            case 16: goto L19;
            case 17: goto L17;
            case 18: goto L15;
            case 19: goto L13;
            case 20: goto L11;
            case 21: goto L9;
            case 22: goto L7;
            case 23: goto L5;
            default: goto L4;
        };
    L5:
        return "PRIORITY_UDFPS";
    L7:
        return "PRIORITY_PROXIMITY";
    L9:
        return "PRIORITY_SKIN_TEMPERATURE";
    L11:
        return "PRIORITY_FLICKER_REFRESH_RATE_SWITCH";
    L13:
        return "PRIORITY_LOW_POWER_MODE_RENDER_RATE";
    L15:
        return "PRIORITY_LOW_POWER_MODE_MODES";
    L17:
        return "PRIORITY_SYSTEM_REQUESTED_MODES";
    L19:
        return "PRIORITY_LAYOUT_LIMITED_FRAME_RATE";
    L21:
        return "PRIORITY_LAYOUT_LIMITED_REFRESH_RATE";
    L23:
        return "PRIORITY_AUTH_OPTIMIZER_RENDER_FRAME_RATE";
    L25:
        return "PRIORITY_LIMIT_MODE";
    L27:
        return "PRIORITY_SYNCHRONIZED_RENDER_FRAME_RATE";
    L29:
        return "PRIORITY_SYNCHRONIZED_REFRESH_RATE";
    L31:
        return "PRIORITY_USER_SETTING_PEAK_RENDER_FRAME_RATE";
    L33:
        return "PRIORITY_USER_SETTING_PEAK_REFRESH_RATE";
    L35:
        return "PRIORITY_REJECTED_MODES";
    L37:
        return "PRIORITY_APP_REQUEST_SIZE";
    L39:
        return "PRIORITY_APP_REQUEST_BASE_MODE_REFRESH_RATE";
    L41:
        return "PRIORITY_APP_REQUEST_RENDER_FRAME_RATE_RANGE";
    L43:
        return "PRIORITY_USER_SETTING_DISPLAY_PREFERRED_SIZE";
    L45:
        return "PRIORITY_USER_SETTING_MIN_RENDER_FRAME_RATE";
    L47:
        return "PRIORITY_HIGH_BRIGHTNESS_MODE";
    L49:
        return "PRIORITY_FLICKER_REFRESH_RATE";
    L51:
        return "PRIORITY_DEFAULT_REFRESH_RATE";
    L4:
        return Integer.toString(priority);
    }
}
