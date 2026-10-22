package androidx.core.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.view.InputDevice;
import android.view.ViewConfiguration;
import java.util.Objects;

/* loaded from: classes.dex */
public final class L {

    static class a {
        static float a(ViewConfiguration viewConfiguration) {
            return viewConfiguration.getScaledHorizontalScrollFactor();
        }

        static float b(ViewConfiguration viewConfiguration) {
            return viewConfiguration.getScaledVerticalScrollFactor();
        }
    }

    static class b {
        static int a(ViewConfiguration viewConfiguration) {
            return viewConfiguration.getScaledHoverSlop();
        }

        static boolean b(ViewConfiguration viewConfiguration) {
            return viewConfiguration.shouldShowMenuShortcutsWhenKeyboardPresent();
        }
    }

    static class c {
        static int a(ViewConfiguration viewConfiguration, int i5, int i6, int i7) {
            return viewConfiguration.getScaledMaximumFlingVelocity(i5, i6, i7);
        }

        static int b(ViewConfiguration viewConfiguration, int i5, int i6, int i7) {
            return viewConfiguration.getScaledMinimumFlingVelocity(i5, i6, i7);
        }
    }

    private static int a(Resources resources, int i5, D.i<Integer> iVar, int i6) {
        int dimensionPixelSize;
        return i5 != -1 ? (i5 == 0 || (dimensionPixelSize = resources.getDimensionPixelSize(i5)) < 0) ? i6 : dimensionPixelSize : iVar.get().intValue();
    }

    private static int b(Resources resources, String str, String str2) {
        return resources.getIdentifier(str, str2, "android");
    }

    private static int c(Resources resources, int i5, int i6) {
        if (i5 == 4194304 && i6 == 26) {
            return b(resources, "config_viewMaxRotaryEncoderFlingVelocity", "dimen");
        }
        return -1;
    }

    private static int d(Resources resources, int i5, int i6) {
        if (i5 == 4194304 && i6 == 26) {
            return b(resources, "config_viewMinRotaryEncoderFlingVelocity", "dimen");
        }
        return -1;
    }

    public static float e(ViewConfiguration viewConfiguration, Context context) {
        return a.a(viewConfiguration);
    }

    public static int f(Context context, final ViewConfiguration viewConfiguration, int i5, int i6, int i7) {
        if (Build.VERSION.SDK_INT >= 34) {
            return c.a(viewConfiguration, i5, i6, i7);
        }
        if (!k(i5, i6, i7)) {
            return Integer.MIN_VALUE;
        }
        Resources resources = context.getResources();
        int iC = c(resources, i7, i6);
        Objects.requireNonNull(viewConfiguration);
        return a(resources, iC, new D.i() { // from class: androidx.core.view.J
            @Override // D.i
            public final Object get() {
                return Integer.valueOf(viewConfiguration.getScaledMaximumFlingVelocity());
            }
        }, Integer.MIN_VALUE);
    }

    public static int g(Context context, final ViewConfiguration viewConfiguration, int i5, int i6, int i7) {
        if (Build.VERSION.SDK_INT >= 34) {
            return c.b(viewConfiguration, i5, i6, i7);
        }
        if (!k(i5, i6, i7)) {
            return Integer.MAX_VALUE;
        }
        Resources resources = context.getResources();
        int iD = d(resources, i7, i6);
        Objects.requireNonNull(viewConfiguration);
        return a(resources, iD, new D.i() { // from class: androidx.core.view.K
            @Override // D.i
            public final Object get() {
                return Integer.valueOf(viewConfiguration.getScaledMinimumFlingVelocity());
            }
        }, Integer.MAX_VALUE);
    }

    @Deprecated
    public static int h(ViewConfiguration viewConfiguration) {
        return viewConfiguration.getScaledPagingTouchSlop();
    }

    public static float i(ViewConfiguration viewConfiguration, Context context) {
        return a.b(viewConfiguration);
    }

    @Deprecated
    public static boolean j(ViewConfiguration viewConfiguration) {
        return viewConfiguration.hasPermanentMenuKey();
    }

    private static boolean k(int i5, int i6, int i7) {
        InputDevice device = InputDevice.getDevice(i5);
        return (device == null || device.getMotionRange(i6, i7) == null) ? false : true;
    }

    public static boolean l(ViewConfiguration viewConfiguration, Context context) {
        return b.b(viewConfiguration);
    }
}
