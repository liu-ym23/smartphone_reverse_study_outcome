package com.stepos.launcher.assistant.utils;

import O6.u;
import android.graphics.Path;

/* loaded from: classes.dex */
public class RoundCornerPathUtils {
    public static final float DEFAULT_ROUND_CORNER_SMOOTHNESS = 0.2f;

    public static Path getRoundCornerPath(boolean z10, float f10, float f11, float f12, float f13, float f14) {
        return getRoundCornerPath(z10, f10, f11, f12, f13, 0.2f, f14);
    }

    public static Path getRoundCornerPath(boolean z10, float f10, float f11, float f12, float f13, float f14, float f15) {
        if (z10) {
            return u.a(f10, f11, f12, f13, f14, f15, true);
        }
        Path path = new Path();
        path.addRoundRect(f10, f11, f12, f13, f15, f15, Path.Direction.CW);
        return path;
    }
}
