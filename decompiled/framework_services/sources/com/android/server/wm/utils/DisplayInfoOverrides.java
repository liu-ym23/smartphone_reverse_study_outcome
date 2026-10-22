package com.android.server.wm.utils;

import android.view.DisplayInfo;

/* JADX INFO: loaded from: classes3.dex */
public class DisplayInfoOverrides {
    public static final DisplayInfoFieldsUpdater WM_OVERRIDE_FIELDS = null;

    public interface DisplayInfoFieldsUpdater {
        void setFields(DisplayInfo r1, DisplayInfo r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$jgt4-o-_IMdp6knRL61iyTsmoLA, reason: not valid java name */
    public static /* synthetic */ void m10499$r8$lambda$jgt4o_IMdp6knRL61iyTsmoLA(DisplayInfo r0, DisplayInfo r1) {
        lambda$static$0(r0, r1);
    }

    public DisplayInfoOverrides() {
    }

    static {
        WM_OVERRIDE_FIELDS = new DisplayInfoOverrides$$ExternalSyntheticLambda0();
    }

    private static /* synthetic */ void lambda$static$0(DisplayInfo out, DisplayInfo source) {
        out.appWidth = source.appWidth;
        out.appHeight = source.appHeight;
        out.smallestNominalAppWidth = source.smallestNominalAppWidth;
        out.smallestNominalAppHeight = source.smallestNominalAppHeight;
        out.largestNominalAppWidth = source.largestNominalAppWidth;
        out.largestNominalAppHeight = source.largestNominalAppHeight;
        out.logicalWidth = source.logicalWidth;
        out.logicalHeight = source.logicalHeight;
        out.physicalXDpi = source.physicalXDpi;
        out.physicalYDpi = source.physicalYDpi;
        out.rotation = source.rotation;
        out.displayCutout = source.displayCutout;
        out.logicalDensityDpi = source.logicalDensityDpi;
        out.roundedCorners = source.roundedCorners;
        out.displayShape = source.displayShape;
    }

    public static void copyDisplayInfoFields(DisplayInfo out, DisplayInfo base, DisplayInfo override, DisplayInfoFieldsUpdater fields) {
        out.copyFrom(base);
        if (override == null) goto L6;
        fields.setFields(out, override);
        return;
    }
}
