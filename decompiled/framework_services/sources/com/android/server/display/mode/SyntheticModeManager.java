package com.android.server.display.mode;

import android.util.Size;
import android.view.Display;
import com.android.server.display.DisplayDeviceConfig;
import com.android.server.display.feature.DisplayManagerFlags;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class SyntheticModeManager {
    private static final float FLOAT_TOLERANCE = 0.01f;
    private static final float SYNTHETIC_MODE_HIGH_BOUNDARY = 60.01f;
    private static final float SYNTHETIC_MODE_REFRESH_RATE = 60.0f;
    private final boolean mHasArrSupportEnabled;
    private final boolean mSynthetic60HzModesEnabled;

    public SyntheticModeManager(DisplayManagerFlags flags) {
        this.mSynthetic60HzModesEnabled = flags.isSynthetic60HzModesEnabled();
        this.mHasArrSupportEnabled = flags.hasArrSupportFlag();
    }

    public Display.Mode[] createAppSupportedModes(DisplayDeviceConfig config, Display.Mode[] modes, boolean hasArrSupport) {
        if (this.mHasArrSupportEnabled == false) goto L5;
        boolean isArrSupported = hasArrSupport;
    L6:
        if (isArrSupported == true) goto L8;
    L31:
        return modes;
    L8:
        if (this.mSynthetic60HzModesEnabled == false) goto L31;
        List<Display.Mode> appSupportedModes = new ArrayList();
        Map<Size, int[]> sizes = new LinkedHashMap();
        int nextModeId = 0;
        int r6 = modes.length;
        int r8 = 0;
    L11:
        if (r8 >= r6) goto L25;
        Display.Mode mode = modes[r8];
        if (mode.getRefreshRate() <= SYNTHETIC_MODE_HIGH_BOUNDARY) goto L16;
        appSupportedModes.add(mode);
    L16:
        if (mode.getModeId() <= nextModeId) goto L18;
        nextModeId = mode.getModeId();
    L18:
        float divisor = mode.getVsyncRate() / 60.0f;
        if (Math.abs(divisor - Math.round(divisor)) >= 0.01f) goto L21;
        boolean is60HzAchievable = true;
    L22:
        if (is60HzAchievable == false) goto L24;
        sizes.put(new Size(mode.getPhysicalWidth(), mode.getPhysicalHeight()), mode.getSupportedHdrTypes());
    L24:
        r8 = r8 + 1;
        goto L11
    L21:
        is60HzAchievable = false;
        goto L22
    L25:
        Iterator<Map.Entry<Size, int[]>> r7 = sizes.entrySet().iterator();
    L27:
        if (r7.hasNext() == false) goto L29;
        Map.Entry<Size, int[]> entry = r7.next();
        int nextModeId2 = nextModeId + 1;
        Size size = entry.getKey();
        int[] hdrTypes = entry.getValue();
        appSupportedModes.add(new Display.Mode(nextModeId2, size.getWidth(), size.getHeight(), 60.0f, 60.0f, true, new float[0], hdrTypes));
        nextModeId = nextModeId2;
        goto L27
    L29:
        Display.Mode[] appSupportedModesArr = new Display.Mode[appSupportedModes.size()];
        return (Display.Mode[]) appSupportedModes.toArray(appSupportedModesArr);
    L5:
        isArrSupported = config.isVrrSupportEnabled();
        goto L6
    }
}
