package com.android.server.accessibility.magnification;

import android.R;
import android.content.Context;
import android.view.ViewConfiguration;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
class MagnificationGestureMatcher {
    private static final int GESTURE_BASE = 100;
    public static final int GESTURE_SINGLE_TAP = 103;
    public static final int GESTURE_SINGLE_TAP_AND_HOLD = 104;
    public static final int GESTURE_SWIPE = 102;
    public static final int GESTURE_TRIPLE_TAP = 105;
    public static final int GESTURE_TRIPLE_TAP_AND_HOLD = 106;
    public static final int GESTURE_TWO_FINGERS_DOWN_OR_SWIPE = 101;

    @Retention(RetentionPolicy.SOURCE)
    @interface GestureId {
    }

    MagnificationGestureMatcher() {
    }

    static String gestureIdToString(int gestureId) {
        switch(gestureId) {
            case 101: goto L15;
            case 102: goto L13;
            case 103: goto L11;
            case 104: goto L9;
            case 105: goto L7;
            case 106: goto L5;
            default: goto L3;
        };
    L3:
        return "none";
    L5:
        return "GESTURE_TRIPLE_TAP_AND_HOLD";
    L7:
        return "GESTURE_TRIPLE_TAP";
    L9:
        return "GESTURE_SINGLE_TAP_AND_HOLD";
    L11:
        return "GESTURE_SINGLE_TAP";
    L13:
        return "GESTURE_SWIPE";
    L15:
        return "GESTURE_TWO_FINGERS_DOWN_OR_SWIPE";
    }

    static int getMagnificationMultiTapTimeout(Context context) {
        return ViewConfiguration.getDoubleTapTimeout() + context.getResources().getInteger(R.integer.config_sideFpsToastTimeout);
    }
}
