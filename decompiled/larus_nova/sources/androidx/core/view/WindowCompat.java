package androidx.core.view;

import android.os.Build;
import android.view.View;
import android.view.Window;
import com.larus.utils.logger.FLogger;
import com.obric.sva.sdk.data.ISmModel;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: classes17.dex */
public final class WindowCompat {
    public static final int FEATURE_ACTION_BAR = 8;
    public static final int FEATURE_ACTION_BAR_OVERLAY = 9;
    public static final int FEATURE_ACTION_MODE_OVERLAY = 10;

    public static class Api16Impl {
        private Api16Impl() {
        }

        public static View INVOKEVIRTUAL_androidx_core_view_WindowCompat$Api16Impl_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r100) {
            View r101 = r100.getDecorView();
            if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
            FLogger.f375446a.i("DecorViewLancet", "getDecorView");
            Thread r102 = ThreadMethodProxy.currentThread();
            if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
            com.larus.home.impl.utils.c.a(r102, "getDecorView");
        L7:
            return r101;
        }

        public static void setDecorFitsSystemWindows(Window r100, boolean r101) {
            View r102 = INVOKEVIRTUAL_androidx_core_view_WindowCompat$Api16Impl_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r100);
            int r103 = r102.getSystemUiVisibility();
            if (r101 == false) goto L5;
            int r104 = r103 & (-1793);
        L6:
            r102.setSystemUiVisibility(r104);
            return;
        L5:
            r104 = r103 | ISmModel.VERSION_0700;
            goto L6
        }
    }

    public static class Api28Impl {
        private Api28Impl() {
        }

        public static <T> T requireViewById(Window r100, int r101) {
            return (T) r100.requireViewById(r101);
        }
    }

    public static class Api30Impl {
        private Api30Impl() {
        }

        public static View INVOKEVIRTUAL_androidx_core_view_WindowCompat$Api30Impl_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r100) {
            View r101 = r100.getDecorView();
            if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
            FLogger.f375446a.i("DecorViewLancet", "getDecorView");
            Thread r102 = ThreadMethodProxy.currentThread();
            if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
            com.larus.home.impl.utils.c.a(r102, "getDecorView");
        L7:
            return r101;
        }

        public static void setDecorFitsSystemWindows(Window r100, boolean r101) {
            View r102 = INVOKEVIRTUAL_androidx_core_view_WindowCompat$Api30Impl_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r100);
            int r103 = r102.getSystemUiVisibility();
            if (r101 == false) goto L5;
            int r104 = r103 & (-257);
        L6:
            r102.setSystemUiVisibility(r104);
            r100.setDecorFitsSystemWindows(r101);
            return;
        L5:
            r104 = r103 | 256;
            goto L6
        }
    }

    public static class Api35Impl {
        private Api35Impl() {
        }

        public static void setDecorFitsSystemWindows(Window r100, boolean r101) {
            r100.setDecorFitsSystemWindows(r101);
        }
    }

    private WindowCompat() {
    }

    public static WindowInsetsControllerCompat getInsetsController(Window r100, View r101) {
        return new WindowInsetsControllerCompat(r100, r101);
    }

    public static <T extends View> T requireViewById(Window r100, int r101) {
        if (Build.VERSION.SDK_INT >= 28) goto L5;
        T r102 = (T) r100.findViewById(r101);
        if (r102 == null) goto L10;
        return r102;
    L10:
        throw new IllegalArgumentException("ID does not reference a View inside this Window");
    L5:
        return (T) Api28Impl.requireViewById(r100, r101);
    }

    public static void setDecorFitsSystemWindows(Window r100, boolean r101) {
        int r102 = Build.VERSION.SDK_INT;
        if (r102 < 35) goto L6;
        Api35Impl.setDecorFitsSystemWindows(r100, r101);
        return;
    L6:
        if (r102 < 30) goto L8;
        Api30Impl.setDecorFitsSystemWindows(r100, r101);
        return;
    L8:
        Api16Impl.setDecorFitsSystemWindows(r100, r101);
    }
}
