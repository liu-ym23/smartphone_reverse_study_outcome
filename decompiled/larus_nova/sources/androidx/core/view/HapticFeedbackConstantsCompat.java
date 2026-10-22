package androidx.core.view;

import android.os.Build;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes17.dex */
public final class HapticFeedbackConstantsCompat {
    public static final int CLOCK_TICK = 4;
    public static final int CONFIRM = 16;
    public static final int CONTEXT_CLICK = 6;
    public static final int DRAG_START = 25;
    static final int FIRST_CONSTANT_INT = 0;
    public static final int FLAG_IGNORE_VIEW_SETTING = 1;
    public static final int GESTURE_END = 13;
    public static final int GESTURE_START = 12;
    public static final int GESTURE_THRESHOLD_ACTIVATE = 23;
    public static final int GESTURE_THRESHOLD_DEACTIVATE = 24;
    public static final int KEYBOARD_PRESS = 3;
    public static final int KEYBOARD_RELEASE = 7;
    public static final int KEYBOARD_TAP = 3;
    static final int LAST_CONSTANT_INT = 27;
    public static final int LONG_PRESS = 0;
    public static final int NO_HAPTICS = -1;
    public static final int REJECT = 17;
    public static final int SEGMENT_FREQUENT_TICK = 27;
    public static final int SEGMENT_TICK = 26;
    public static final int TEXT_HANDLE_MOVE = 9;
    public static final int TOGGLE_OFF = 22;
    public static final int TOGGLE_ON = 21;
    public static final int VIRTUAL_KEY = 1;
    public static final int VIRTUAL_KEY_RELEASE = 8;

    @Retention(RetentionPolicy.SOURCE)
    public @interface HapticFeedbackFlags {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface HapticFeedbackType {
    }

    private HapticFeedbackConstantsCompat() {
    }

    public static int getFeedbackConstantOrFallback(int r100) {
        int r101 = -1;
        if (r100 != (-1)) goto L5;
        return -1;
    L5:
        int r102 = Build.VERSION.SDK_INT;
        int r103 = 0;
        if (r102 >= 34) goto L13;
        switch(r100) {
            case 21: goto L11;
            case 22: goto L10;
            case 23: goto L11;
            case 24: goto L10;
            case 25: goto L9;
            case 26: goto L11;
            case 27: goto L10;
            default: goto L13;
        };
    L9:
        r100 = 0;
        goto L13
    L10:
        r100 = 4;
        goto L13
    L11:
        r100 = 6;
    L13:
        if (r102 < 30) goto L15;
    L25:
        r103 = r100;
    L27:
        if (r102 < 27) goto L29;
    L34:
        r101 = r103;
    L36:
        if (r102 >= 23) goto L39;
        if (r101 != 6) goto L39;
        return 4;
    L39:
        return r101;
    L29:
        if (r103 == 7) goto L36;
        if (r103 == 8) goto L36;
        if (r103 == 9) goto L36;
    L15:
        if (r100 != 12) goto L17;
    L24:
        r103 = 1;
        goto L27
    L17:
        if (r100 != 13) goto L19;
        r103 = 6;
        goto L27
    L19:
        if (r100 == 16) goto L24;
        if (r100 == 17) goto L27;
        goto L25
    }
}
