package androidx.core.view;

import android.view.MotionEvent;
import androidx.annotation.ReplaceWith;

/* JADX INFO: loaded from: classes17.dex */
public final class MotionEventCompat {
    public static final int ACTION_HOVER_ENTER = 9;
    public static final int ACTION_HOVER_EXIT = 10;
    public static final int ACTION_HOVER_MOVE = 7;
    public static final int ACTION_MASK = 255;
    public static final int ACTION_POINTER_DOWN = 5;
    public static final int ACTION_POINTER_INDEX_MASK = 65280;
    public static final int ACTION_POINTER_INDEX_SHIFT = 8;
    public static final int ACTION_POINTER_UP = 6;
    public static final int ACTION_SCROLL = 8;
    public static final int AXIS_BRAKE = 23;
    public static final int AXIS_DISTANCE = 24;
    public static final int AXIS_GAS = 22;
    public static final int AXIS_GENERIC_1 = 32;
    public static final int AXIS_GENERIC_10 = 41;
    public static final int AXIS_GENERIC_11 = 42;
    public static final int AXIS_GENERIC_12 = 43;
    public static final int AXIS_GENERIC_13 = 44;
    public static final int AXIS_GENERIC_14 = 45;
    public static final int AXIS_GENERIC_15 = 46;
    public static final int AXIS_GENERIC_16 = 47;
    public static final int AXIS_GENERIC_2 = 33;
    public static final int AXIS_GENERIC_3 = 34;
    public static final int AXIS_GENERIC_4 = 35;
    public static final int AXIS_GENERIC_5 = 36;
    public static final int AXIS_GENERIC_6 = 37;
    public static final int AXIS_GENERIC_7 = 38;
    public static final int AXIS_GENERIC_8 = 39;
    public static final int AXIS_GENERIC_9 = 40;
    public static final int AXIS_HAT_X = 15;
    public static final int AXIS_HAT_Y = 16;
    public static final int AXIS_HSCROLL = 10;
    public static final int AXIS_LTRIGGER = 17;
    public static final int AXIS_ORIENTATION = 8;
    public static final int AXIS_PRESSURE = 2;
    public static final int AXIS_RELATIVE_X = 27;
    public static final int AXIS_RELATIVE_Y = 28;
    public static final int AXIS_RTRIGGER = 18;
    public static final int AXIS_RUDDER = 20;
    public static final int AXIS_RX = 12;
    public static final int AXIS_RY = 13;
    public static final int AXIS_RZ = 14;
    public static final int AXIS_SCROLL = 26;
    public static final int AXIS_SIZE = 3;
    public static final int AXIS_THROTTLE = 19;
    public static final int AXIS_TILT = 25;
    public static final int AXIS_TOOL_MAJOR = 6;
    public static final int AXIS_TOOL_MINOR = 7;
    public static final int AXIS_TOUCH_MAJOR = 4;
    public static final int AXIS_TOUCH_MINOR = 5;
    public static final int AXIS_VSCROLL = 9;
    public static final int AXIS_WHEEL = 21;
    public static final int AXIS_X = 0;
    public static final int AXIS_Y = 1;
    public static final int AXIS_Z = 11;
    public static final int BUTTON_PRIMARY = 1;

    private MotionEventCompat() {
    }

    @ReplaceWith(expression = "event.getActionIndex()")
    public static int getActionIndex(MotionEvent r100) {
        return r100.getActionIndex();
    }

    @ReplaceWith(expression = "event.getActionMasked()")
    public static int getActionMasked(MotionEvent r100) {
        return r100.getActionMasked();
    }

    @ReplaceWith(expression = "event.getButtonState()")
    public static int getButtonState(MotionEvent r100) {
        return r100.getButtonState();
    }

    @ReplaceWith(expression = "event.getPointerCount()")
    public static int getPointerCount(MotionEvent r100) {
        return r100.getPointerCount();
    }

    @ReplaceWith(expression = "event.getSource()")
    public static int getSource(MotionEvent r100) {
        return r100.getSource();
    }

    @ReplaceWith(expression = "event.findPointerIndex(pointerId)")
    public static int findPointerIndex(MotionEvent r100, int r101) {
        return r100.findPointerIndex(r101);
    }

    @ReplaceWith(expression = "event.getAxisValue(axis)")
    public static float getAxisValue(MotionEvent r100, int r101) {
        return r100.getAxisValue(r101);
    }

    @ReplaceWith(expression = "event.getPointerId(pointerIndex)")
    public static int getPointerId(MotionEvent r100, int r101) {
        return r100.getPointerId(r101);
    }

    @ReplaceWith(expression = "event.getX(pointerIndex)")
    public static float getX(MotionEvent r100, int r101) {
        return r100.getX(r101);
    }

    @ReplaceWith(expression = "event.getY(pointerIndex)")
    public static float getY(MotionEvent r100, int r101) {
        return r100.getY(r101);
    }

    public static boolean isFromSource(MotionEvent r100, int r101) {
        if ((r100.getSource() & r101) != r101) goto L5;
        return true;
    L5:
        return false;
    }

    @ReplaceWith(expression = "event.getAxisValue(axis, pointerIndex)")
    public static float getAxisValue(MotionEvent r100, int r101, int r102) {
        return r100.getAxisValue(r101, r102);
    }
}
