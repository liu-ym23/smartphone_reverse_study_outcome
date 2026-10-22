package com.stepos.launcher.assistant.slidepanel;

import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;

/* loaded from: classes.dex */
public final class MinusOneTransitionSpec {
    public static final Interpolator INCOMING;
    public static final int INCOMING_DELAY_MS = 333;
    public static final int INCOMING_DURATION_MS = 333;
    public static final Interpolator INCOMING_OPACITY;
    public static final float INCOMING_PROGRESS_START = 0.5f;
    public static final float INCOMING_SCALE_START = 0.9f;
    public static final Interpolator LAUNCHER_INCOMING;
    public static final int LAUNCHER_INCOMING_DELAY_MS = 333;
    public static final int LAUNCHER_INCOMING_DURATION_MS = 333;
    public static final float LAUNCHER_INCOMING_SCALE_START = 0.9f;
    public static final int MESH_MASK_TOTAL_DURATION_MS = 583;
    public static final Interpolator OUTGOING;
    public static final int OUTGOING_DURATION_MS = 333;
    public static final Interpolator OUTGOING_OPACITY;
    public static final float OUTGOING_SCALE_END = 0.8f;
    public static final int OVERLAY_CLOSE_DURATION_MS = 450;
    public static final int TOTAL_DURATION_MS = 666;

    static {
        PathInterpolator pathInterpolator = new PathInterpolator(0.3f, 0.0f, 1.0f, 1.0f);
        OUTGOING = pathInterpolator;
        PathInterpolator pathInterpolator2 = new PathInterpolator(0.0f, 0.0f, 0.1f, 1.0f);
        INCOMING = pathInterpolator2;
        INCOMING_OPACITY = pathInterpolator2;
        OUTGOING_OPACITY = pathInterpolator;
        LAUNCHER_INCOMING = pathInterpolator2;
    }

    private MinusOneTransitionSpec() {
    }

    public static float interpolateIncomingScale(float f10) {
        return (INCOMING.getInterpolation(Math.max(0.0f, Math.min(1.0f, f10))) * 0.100000024f) + 0.9f;
    }

    public static float interpolateOutgoingScale(float f10) {
        return (OUTGOING.getInterpolation(Math.max(0.0f, Math.min(1.0f, f10))) * (-0.19999999f)) + 1.0f;
    }
}
