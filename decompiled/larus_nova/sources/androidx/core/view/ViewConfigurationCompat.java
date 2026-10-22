package androidx.core.view;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.InputDevice;
import android.view.ViewConfiguration;
import androidx.annotation.ReplaceWith;
import androidx.core.util.Supplier;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.lang.reflect.Method;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class ViewConfigurationCompat {
    private static final int NO_FLING_MAX_VELOCITY = Integer.MIN_VALUE;
    private static final int NO_FLING_MIN_VELOCITY = Integer.MAX_VALUE;
    private static final int RESOURCE_ID_NOT_SUPPORTED = -1;
    private static final int RESOURCE_ID_SUPPORTED_BUT_NOT_FOUND = 0;
    private static final String TAG = "ViewConfigCompat";
    private static Method sGetScaledScrollFactorMethod;

    public static class Api26Impl {
        private Api26Impl() {
        }

        public static float getScaledHorizontalScrollFactor(ViewConfiguration r100) {
            return r100.getScaledHorizontalScrollFactor();
        }

        public static float getScaledVerticalScrollFactor(ViewConfiguration r100) {
            return r100.getScaledVerticalScrollFactor();
        }
    }

    /* JADX INFO: loaded from: classes17.dex */
    public static class Api28Impl {
        private Api28Impl() {
        }

        public static int getScaledHoverSlop(ViewConfiguration r100) {
            return r100.getScaledHoverSlop();
        }

        public static boolean shouldShowMenuShortcutsWhenKeyboardPresent(ViewConfiguration r100) {
            return r100.shouldShowMenuShortcutsWhenKeyboardPresent();
        }
    }

    /* JADX INFO: loaded from: classes17.dex */
    public static class Api34Impl {
        private Api34Impl() {
        }

        public static int getScaledMaximumFlingVelocity(ViewConfiguration r100, int r101, int r102, int r103) {
            return r100.getScaledMaximumFlingVelocity(r101, r102, r103);
        }

        public static int getScaledMinimumFlingVelocity(ViewConfiguration r100, int r101, int r102, int r103) {
            return r100.getScaledMinimumFlingVelocity(r101, r102, r103);
        }
    }

    static {
        if (Build.VERSION.SDK_INT != 25) goto L9;
        sGetScaledScrollFactorMethod = ViewConfiguration.class.getDeclaredMethod("getScaledScrollFactor", new Class[0]);     // Catch: Exception -> L6
        return;
    L10:
        return;
    }

    private ViewConfigurationCompat() {
    }

    public static DisplayMetrics INVOKEVIRTUAL_androidx_core_view_ViewConfigurationCompat_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public static int getScaledHoverSlop(ViewConfiguration r100) {
        if (Build.VERSION.SDK_INT < 28) goto L7;
        return Api28Impl.getScaledHoverSlop(r100);
    L7:
        return r100.getScaledTouchSlop() / 2;
    }

    @ReplaceWith(expression = "config.getScaledPagingTouchSlop()")
    public static int getScaledPagingTouchSlop(ViewConfiguration r100) {
        return r100.getScaledPagingTouchSlop();
    }

    @ReplaceWith(expression = "config.hasPermanentMenuKey()")
    public static boolean hasPermanentMenuKey(ViewConfiguration r100) {
        return r100.hasPermanentMenuKey();
    }

    private static float getLegacyScrollFactor(ViewConfiguration r100, Context r101) {
        if (Build.VERSION.SDK_INT < 25) goto L11;
        Method r102 = sGetScaledScrollFactorMethod;
        if (r102 == null) goto L11;
        return ((Integer) r102.invoke(r100, new Object[0])).intValue();
    L11:
        TypedValue r103 = new TypedValue();
        if (r101.getTheme().resolveAttribute(R.attr.listPreferredItemHeight, r103, true) == true) goto L14;
        return 0.0f;
    L14:
        return r103.getDimension(INVOKEVIRTUAL_androidx_core_view_ViewConfigurationCompat_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r101.getResources()));
    }

    public static float getScaledHorizontalScrollFactor(ViewConfiguration r100, Context r101) {
        if (Build.VERSION.SDK_INT < 26) goto L7;
        return Api26Impl.getScaledHorizontalScrollFactor(r100);
    L7:
        return getLegacyScrollFactor(r100, r101);
    }

    public static float getScaledVerticalScrollFactor(ViewConfiguration r100, Context r101) {
        if (Build.VERSION.SDK_INT < 26) goto L7;
        return Api26Impl.getScaledVerticalScrollFactor(r100);
    L7:
        return getLegacyScrollFactor(r100, r101);
    }

    public static boolean shouldShowMenuShortcutsWhenKeyboardPresent(ViewConfiguration r100, Context r101) {
        if (Build.VERSION.SDK_INT >= 28) goto L5;
        Resources r102 = r101.getResources();
        int r103 = getPlatformResId(r102, "config_showMenuShortcutsWhenKeyboardPresent", "bool");
        if (r103 != 0) goto L9;
    L11:
        return false;
    L9:
        if (r102.getBoolean(r103) == false) goto L11;
        return true;
    L5:
        return Api28Impl.shouldShowMenuShortcutsWhenKeyboardPresent(r100);
    }

    private static int getPlatformResId(Resources r100, String r101, String r102) {
        return r100.getIdentifier(r101, r102, "android");
    }

    private static int getPreApi34MaximumFlingVelocityResId(Resources r100, int r101, int r102) {
        if (r101 == 4194304) goto L5;
        return -1;
    L5:
        if (r102 == 26) goto L7;
        return -1;
    L7:
        return getPlatformResId(r100, "config_viewMaxRotaryEncoderFlingVelocity", "dimen");
    }

    private static int getPreApi34MinimumFlingVelocityResId(Resources r100, int r101, int r102) {
        if (r101 == 4194304) goto L5;
        return -1;
    L5:
        if (r102 == 26) goto L7;
        return -1;
    L7:
        return getPlatformResId(r100, "config_viewMinRotaryEncoderFlingVelocity", "dimen");
    }

    private static boolean isInputDeviceInfoValid(int r100, int r101, int r102) {
        InputDevice r103 = InputDevice.getDevice(r100);
        if (r103 != null) goto L5;
    L7:
        return false;
    L5:
        if (r103.getMotionRange(r101, r102) == null) goto L7;
        return true;
    }

    private static int getCompatFlingVelocityThreshold(Resources r100, int r101, Supplier<Integer> r102, int r103) {
        if (r101 == (-1)) goto L11;
        if (r101 == 0) goto L12;
        int r104 = r100.getDimensionPixelSize(r101);
        if (r104 >= 0) goto L9;
        return r103;
    L9:
        return r104;
    L12:
        return r103;
    L11:
        return r102.get().intValue();
    }

    public static int getScaledMaximumFlingVelocity(Context r100, final ViewConfiguration r101, int r102, int r103, int r104) {
        if (Build.VERSION.SDK_INT < 34) goto L7;
        return Api34Impl.getScaledMaximumFlingVelocity(r101, r102, r103, r104);
    L7:
        if (isInputDeviceInfoValid(r102, r103, r104) == true) goto L9;
        return Integer.MIN_VALUE;
    L9:
        Resources r105 = r100.getResources();
        int r106 = getPreApi34MaximumFlingVelocityResId(r105, r104, r103);
        Objects.requireNonNull(r101);
        return getCompatFlingVelocityThreshold(r105, r106, new m(r101), Integer.MIN_VALUE);
    }

    public static int getScaledMinimumFlingVelocity(Context r100, final ViewConfiguration r101, int r102, int r103, int r104) {
        if (Build.VERSION.SDK_INT < 34) goto L7;
        return Api34Impl.getScaledMinimumFlingVelocity(r101, r102, r103, r104);
    L7:
        if (isInputDeviceInfoValid(r102, r103, r104) == true) goto L9;
        return Integer.MAX_VALUE;
    L9:
        Resources r105 = r100.getResources();
        int r106 = getPreApi34MinimumFlingVelocityResId(r105, r104, r103);
        Objects.requireNonNull(r101);
        return getCompatFlingVelocityThreshold(r105, r106, new l(r101), Integer.MAX_VALUE);
    }
}
