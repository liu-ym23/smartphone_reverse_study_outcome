package androidx.core.view;

import android.os.Build;
import android.os.CancellationSignal;
import android.view.View;
import android.view.Window;
import android.view.WindowInsetsAnimationControlListener;
import android.view.WindowInsetsController;
import android.view.animation.Interpolator;
import androidx.collection.SimpleArrayMap;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.baidu.platform.comapi.bmsdk.BmLocated;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: classes17.dex */
public final class WindowInsetsControllerCompat {
    public static final int BEHAVIOR_DEFAULT = 1;
    public static final int BEHAVIOR_SHOW_BARS_BY_SWIPE = 1;
    public static final int BEHAVIOR_SHOW_BARS_BY_TOUCH = 0;
    public static final int BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE = 2;
    private final Impl mImpl;

    public static class Impl {
        static final int KEY_BEHAVIOR = 356039078;

        public void addOnControllableInsetsChangedListener(OnControllableInsetsChangedListener r100) {
        }

        public void controlWindowInsetsAnimation(int r100, long r101, Interpolator r102, CancellationSignal r103, WindowInsetsAnimationControlListenerCompat r104) {
        }

        public int getSystemBarsBehavior() {
            return 1;
        }

        public void hide(int r100) {
        }

        public boolean isAppearanceLightNavigationBars() {
            return false;
        }

        public boolean isAppearanceLightStatusBars() {
            return false;
        }

        public void removeOnControllableInsetsChangedListener(OnControllableInsetsChangedListener r100) {
        }

        public void setAppearanceLightNavigationBars(boolean r100) {
        }

        public void setAppearanceLightStatusBars(boolean r100) {
        }

        public void setSystemBarsBehavior(int r100) {
        }

        public void show(int r100) {
        }

        public Impl() {
        }
    }

    public static class Impl20 extends Impl {
        private final SoftwareKeyboardControllerCompat mSoftwareKeyboardControllerCompat;
        protected final Window mWindow;

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public void addOnControllableInsetsChangedListener(OnControllableInsetsChangedListener r100) {
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public void controlWindowInsetsAnimation(int r100, long r101, Interpolator r102, CancellationSignal r103, WindowInsetsAnimationControlListenerCompat r104) {
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public void removeOnControllableInsetsChangedListener(OnControllableInsetsChangedListener r100) {
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public int getSystemBarsBehavior() {
            Object r100 = INVOKEVIRTUAL_androidx_core_view_WindowInsetsControllerCompat$Impl20_com_larus_home_impl_utils_DecorViewLancet_getDecorView(this.mWindow).getTag(356039078);
            if (r100 != null) goto L7;
            return 1;
        L7:
            return ((Integer) r100).intValue();
        }

        public static View INVOKEVIRTUAL_androidx_core_view_WindowInsetsControllerCompat$Impl20_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r100) {
            View r101 = r100.getDecorView();
            if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
            FLogger.f375446a.i("DecorViewLancet", "getDecorView");
            Thread r102 = ThreadMethodProxy.currentThread();
            if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
            com.larus.home.impl.utils.c.a(r102, "getDecorView");
        L7:
            return r101;
        }

        private void hideForType(int r100) {
            if (r100 != 1) goto L5;
            setSystemUiFlag(4);
            return;
        L5:
            if (r100 != 2) goto L7;
            setSystemUiFlag(2);
            return;
        L7:
            if (r100 != 8) goto L15;
            this.mSoftwareKeyboardControllerCompat.hide();
            return;
        }

        private void showForType(int r100) {
            if (r100 != 1) goto L5;
            unsetSystemUiFlag(4);
            unsetWindowFlag(1024);
            return;
        L5:
            if (r100 != 2) goto L7;
            unsetSystemUiFlag(2);
            return;
        L7:
            if (r100 != 8) goto L15;
            this.mSoftwareKeyboardControllerCompat.show();
            return;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public void hide(int r100) {
            int r101 = 1;
        L4:
            if (r101 > 256) goto L10;
            if ((r100 & r101) == 0) goto L9;
            hideForType(r101);
        L9:
            r101 = r101 << 1;
            goto L4
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public void setSystemBarsBehavior(int r100) {
            INVOKEVIRTUAL_androidx_core_view_WindowInsetsControllerCompat$Impl20_com_larus_home_impl_utils_DecorViewLancet_getDecorView(this.mWindow).setTag(356039078, Integer.valueOf(r100));
            if (r100 != 0) goto L5;
            unsetSystemUiFlag(BmLocated.HALF_LEFT_BOTTOM);
            return;
        L5:
            if (r100 != 1) goto L7;
            unsetSystemUiFlag(4096);
            setSystemUiFlag(2048);
            return;
        L7:
            if (r100 != 2) goto L15;
            unsetSystemUiFlag(2048);
            setSystemUiFlag(4096);
            return;
        }

        public void setSystemUiFlag(int r100) {
            View r101 = INVOKEVIRTUAL_androidx_core_view_WindowInsetsControllerCompat$Impl20_com_larus_home_impl_utils_DecorViewLancet_getDecorView(this.mWindow);
            r101.setSystemUiVisibility(r100 | r101.getSystemUiVisibility());
        }

        public void setWindowFlag(int r100) {
            this.mWindow.addFlags(r100);
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public void show(int r100) {
            int r101 = 1;
        L4:
            if (r101 > 256) goto L10;
            if ((r100 & r101) == 0) goto L9;
            showForType(r101);
        L9:
            r101 = r101 << 1;
            goto L4
        }

        public void unsetSystemUiFlag(int r100) {
            View r101 = INVOKEVIRTUAL_androidx_core_view_WindowInsetsControllerCompat$Impl20_com_larus_home_impl_utils_DecorViewLancet_getDecorView(this.mWindow);
            int r102 = r101.getSystemUiVisibility();
            r101.setSystemUiVisibility((~r100) & r102);
        }

        public void unsetWindowFlag(int r100) {
            this.mWindow.clearFlags(r100);
        }

        public Impl20(Window r100, SoftwareKeyboardControllerCompat r101) {
            this.mWindow = r100;
            this.mSoftwareKeyboardControllerCompat = r101;
        }
    }

    public static class Impl23 extends Impl20 {
        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public boolean isAppearanceLightStatusBars() {
            if ((INVOKEVIRTUAL_androidx_core_view_WindowInsetsControllerCompat$Impl23_com_larus_home_impl_utils_DecorViewLancet_getDecorView(this.mWindow).getSystemUiVisibility() & 8192) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public static View INVOKEVIRTUAL_androidx_core_view_WindowInsetsControllerCompat$Impl23_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r100) {
            View r101 = r100.getDecorView();
            if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
            FLogger.f375446a.i("DecorViewLancet", "getDecorView");
            Thread r102 = ThreadMethodProxy.currentThread();
            if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
            com.larus.home.impl.utils.c.a(r102, "getDecorView");
        L7:
            return r101;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public void setAppearanceLightStatusBars(boolean r100) {
            if (r100 == false) goto L5;
            unsetWindowFlag(67108864);
            setWindowFlag(Integer.MIN_VALUE);
            setSystemUiFlag(8192);
            return;
        L5:
            unsetSystemUiFlag(8192);
        }

        public Impl23(Window r100, SoftwareKeyboardControllerCompat r101) {
            super(r100, r101);
        }
    }

    public static class Impl26 extends Impl23 {
        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public boolean isAppearanceLightNavigationBars() {
            if ((INVOKEVIRTUAL_androidx_core_view_WindowInsetsControllerCompat$Impl26_com_larus_home_impl_utils_DecorViewLancet_getDecorView(this.mWindow).getSystemUiVisibility() & 16) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public static View INVOKEVIRTUAL_androidx_core_view_WindowInsetsControllerCompat$Impl26_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r100) {
            View r101 = r100.getDecorView();
            if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
            FLogger.f375446a.i("DecorViewLancet", "getDecorView");
            Thread r102 = ThreadMethodProxy.currentThread();
            if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
            com.larus.home.impl.utils.c.a(r102, "getDecorView");
        L7:
            return r101;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public void setAppearanceLightNavigationBars(boolean r100) {
            if (r100 == false) goto L5;
            unsetWindowFlag(AMapEngineUtils.HALF_MAX_P20_WIDTH);
            setWindowFlag(Integer.MIN_VALUE);
            setSystemUiFlag(16);
            return;
        L5:
            unsetSystemUiFlag(16);
        }

        public Impl26(Window r100, SoftwareKeyboardControllerCompat r101) {
            super(r100, r101);
        }
    }

    public static class Impl30 extends Impl {
        final WindowInsetsControllerCompat mCompatController;
        final WindowInsetsController mInsetsController;
        private final SimpleArrayMap<OnControllableInsetsChangedListener, WindowInsetsController.OnControllableInsetsChangedListener> mListeners;
        final SoftwareKeyboardControllerCompat mSoftwareKeyboardControllerCompat;
        protected Window mWindow;

        public static /* synthetic */ void a(Impl30 r100, OnControllableInsetsChangedListener r101, WindowInsetsController r102, int r103) {
            r100.lambda$addOnControllableInsetsChangedListener$0(r101, r102, r103);
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public int getSystemBarsBehavior() {
            Window r100 = this.mWindow;
            if (r100 == null) goto L10;
            Object r101 = INVOKEVIRTUAL_androidx_core_view_WindowInsetsControllerCompat$Impl30_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r100).getTag(356039078);
            if (r101 != null) goto L11;
            return 1;
        L11:
            return ((Integer) r101).intValue();
        L10:
            return this.mInsetsController.getSystemBarsBehavior();
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public boolean isAppearanceLightNavigationBars() {
            this.mInsetsController.setSystemBarsAppearance(0, 0);
            if ((this.mInsetsController.getSystemBarsAppearance() & 16) == 0) goto L6;
            return true;
        L6:
            return false;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public boolean isAppearanceLightStatusBars() {
            this.mInsetsController.setSystemBarsAppearance(0, 0);
            if ((this.mInsetsController.getSystemBarsAppearance() & 8) == 0) goto L6;
            return true;
        L6:
            return false;
        }

        public static View INVOKEVIRTUAL_androidx_core_view_WindowInsetsControllerCompat$Impl30_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r100) {
            View r101 = r100.getDecorView();
            if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
            FLogger.f375446a.i("DecorViewLancet", "getDecorView");
            Thread r102 = ThreadMethodProxy.currentThread();
            if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
            com.larus.home.impl.utils.c.a(r102, "getDecorView");
        L7:
            return r101;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public void addOnControllableInsetsChangedListener(final OnControllableInsetsChangedListener r100) {
            if (this.mListeners.containsKey(r100) == false) goto L5;
            return;
        L5:
            WindowInsetsController.OnControllableInsetsChangedListener r101 = new p(this, r100);
            this.mListeners.put(r100, r101);
            this.mInsetsController.addOnControllableInsetsChangedListener(r101);
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public void hide(int r100) {
            if ((r100 & 8) == 0) goto L5;
            this.mSoftwareKeyboardControllerCompat.hide();
        L5:
            this.mInsetsController.hide(r100 & (-9));
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public void removeOnControllableInsetsChangedListener(OnControllableInsetsChangedListener r100) {
            WindowInsetsController.OnControllableInsetsChangedListener r101 = this.mListeners.remove(r100);
            if (r101 == null) goto L6;
            this.mInsetsController.removeOnControllableInsetsChangedListener(r101);
            return;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public void setAppearanceLightNavigationBars(boolean r100) {
            if (r100 == false) goto L9;
            if (this.mWindow == null) goto L7;
            setSystemUiFlag(16);
        L7:
            this.mInsetsController.setSystemBarsAppearance(16, 16);
            return;
        L9:
            if (this.mWindow == null) goto L11;
            unsetSystemUiFlag(16);
        L11:
            this.mInsetsController.setSystemBarsAppearance(0, 16);
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public void setAppearanceLightStatusBars(boolean r100) {
            if (r100 == false) goto L9;
            if (this.mWindow == null) goto L7;
            setSystemUiFlag(8192);
        L7:
            this.mInsetsController.setSystemBarsAppearance(8, 8);
            return;
        L9:
            if (this.mWindow == null) goto L11;
            unsetSystemUiFlag(8192);
        L11:
            this.mInsetsController.setSystemBarsAppearance(0, 8);
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public void setSystemBarsBehavior(int r100) {
            Window r101 = this.mWindow;
            if (r101 == null) goto L14;
            INVOKEVIRTUAL_androidx_core_view_WindowInsetsControllerCompat$Impl30_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r101).setTag(356039078, Integer.valueOf(r100));
            if (r100 != 0) goto L7;
            unsetSystemUiFlag(BmLocated.HALF_LEFT_BOTTOM);
            return;
        L7:
            if (r100 != 1) goto L9;
            unsetSystemUiFlag(4096);
            setSystemUiFlag(2048);
            return;
        L9:
            if (r100 != 2) goto L19;
            unsetSystemUiFlag(2048);
            setSystemUiFlag(4096);
            return;
        L19:
            return;
        L14:
            this.mInsetsController.setSystemBarsBehavior(r100);
        }

        public void setSystemUiFlag(int r100) {
            View r101 = INVOKEVIRTUAL_androidx_core_view_WindowInsetsControllerCompat$Impl30_com_larus_home_impl_utils_DecorViewLancet_getDecorView(this.mWindow);
            r101.setSystemUiVisibility(r100 | r101.getSystemUiVisibility());
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public void show(int r100) {
            if ((r100 & 8) == 0) goto L5;
            this.mSoftwareKeyboardControllerCompat.show();
        L5:
            this.mInsetsController.show(r100 & (-9));
        }

        public void unsetSystemUiFlag(int r100) {
            View r101 = INVOKEVIRTUAL_androidx_core_view_WindowInsetsControllerCompat$Impl30_com_larus_home_impl_utils_DecorViewLancet_getDecorView(this.mWindow);
            int r102 = r101.getSystemUiVisibility();
            r101.setSystemUiVisibility((~r100) & r102);
        }

        public Impl30(WindowInsetsController r100, WindowInsetsControllerCompat r101, SoftwareKeyboardControllerCompat r102) {
            this.mListeners = new SimpleArrayMap();
            this.mInsetsController = r100;
            this.mCompatController = r101;
            this.mSoftwareKeyboardControllerCompat = r102;
        }

        private /* synthetic */ void lambda$addOnControllableInsetsChangedListener$0(OnControllableInsetsChangedListener r100, WindowInsetsController r101, int r102) {
            if (this.mInsetsController != r101) goto L6;
            r100.onControllableInsetsChanged(this.mCompatController, r102);
            return;
        }

        public Impl30(Window r100, WindowInsetsControllerCompat r101, SoftwareKeyboardControllerCompat r102) {
            this(r100.getInsetsController(), r101, r102);
            this.mWindow = r100;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public void controlWindowInsetsAnimation(int r100, long r101, Interpolator r110, CancellationSignal r111, final WindowInsetsAnimationControlListenerCompat r112) {
            WindowInsetsAnimationControlListener r102 = new AnonymousClass1(this, r112);
            this.mInsetsController.controlWindowInsetsAnimation(r100, r101, r110, r111, r102);
        }
    }

    public static class Impl31 extends Impl30 {
        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl30, androidx.core.view.WindowInsetsControllerCompat.Impl
        public int getSystemBarsBehavior() {
            return this.mInsetsController.getSystemBarsBehavior();
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl30, androidx.core.view.WindowInsetsControllerCompat.Impl
        public void setSystemBarsBehavior(int r100) {
            this.mInsetsController.setSystemBarsBehavior(r100);
        }

        public Impl31(Window r100, WindowInsetsControllerCompat r101, SoftwareKeyboardControllerCompat r102) {
            super(r100, r101, r102);
        }

        public Impl31(WindowInsetsController r100, WindowInsetsControllerCompat r101, SoftwareKeyboardControllerCompat r102) {
            super(r100, r101, r102);
        }
    }

    public static class Impl35 extends Impl31 {
        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl30, androidx.core.view.WindowInsetsControllerCompat.Impl
        public boolean isAppearanceLightNavigationBars() {
            if ((this.mInsetsController.getSystemBarsAppearance() & 16) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl30, androidx.core.view.WindowInsetsControllerCompat.Impl
        public boolean isAppearanceLightStatusBars() {
            if ((this.mInsetsController.getSystemBarsAppearance() & 8) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public Impl35(Window r100, WindowInsetsControllerCompat r101, SoftwareKeyboardControllerCompat r102) {
            super(r100, r101, r102);
        }

        public Impl35(WindowInsetsController r100, WindowInsetsControllerCompat r101, SoftwareKeyboardControllerCompat r102) {
            super(r100, r101, r102);
        }
    }

    public interface OnControllableInsetsChangedListener {
        void onControllableInsetsChanged(WindowInsetsControllerCompat r100, int r101);
    }

    public int getSystemBarsBehavior() {
        return this.mImpl.getSystemBarsBehavior();
    }

    public boolean isAppearanceLightNavigationBars() {
        return this.mImpl.isAppearanceLightNavigationBars();
    }

    public boolean isAppearanceLightStatusBars() {
        return this.mImpl.isAppearanceLightStatusBars();
    }

    private WindowInsetsControllerCompat(WindowInsetsController r100) {
        if (Build.VERSION.SDK_INT < 35) goto L5;
        this.mImpl = new Impl35(r100, this, new SoftwareKeyboardControllerCompat(r100));
        return;
    L5:
        this.mImpl = new Impl30(r100, this, new SoftwareKeyboardControllerCompat(r100));
    }

    public static WindowInsetsControllerCompat toWindowInsetsControllerCompat(WindowInsetsController r100) {
        return new WindowInsetsControllerCompat(r100);
    }

    public void addOnControllableInsetsChangedListener(OnControllableInsetsChangedListener r100) {
        this.mImpl.addOnControllableInsetsChangedListener(r100);
    }

    public void hide(int r100) {
        this.mImpl.hide(r100);
    }

    public void removeOnControllableInsetsChangedListener(OnControllableInsetsChangedListener r100) {
        this.mImpl.removeOnControllableInsetsChangedListener(r100);
    }

    public void setAppearanceLightNavigationBars(boolean r100) {
        this.mImpl.setAppearanceLightNavigationBars(r100);
    }

    public void setAppearanceLightStatusBars(boolean r100) {
        this.mImpl.setAppearanceLightStatusBars(r100);
    }

    public void setSystemBarsBehavior(int r100) {
        this.mImpl.setSystemBarsBehavior(r100);
    }

    public void show(int r100) {
        this.mImpl.show(r100);
    }

    public WindowInsetsControllerCompat(Window r100, View r101) {
        SoftwareKeyboardControllerCompat r102 = new SoftwareKeyboardControllerCompat(r101);
        int r103 = Build.VERSION.SDK_INT;
        if (r103 < 35) goto L6;
        this.mImpl = new Impl35(r100, this, r102);
        return;
    L6:
        if (r103 < 30) goto L9;
        this.mImpl = new Impl30(r100, this, r102);
        return;
    L9:
        if (r103 < 26) goto L12;
        this.mImpl = new Impl26(r100, r102);
        return;
    L12:
        if (r103 < 23) goto L14;
        this.mImpl = new Impl23(r100, r102);
        return;
    L14:
        this.mImpl = new Impl20(r100, r102);
    }

    public void controlWindowInsetsAnimation(int r100, long r101, Interpolator r110, CancellationSignal r111, WindowInsetsAnimationControlListenerCompat r112) {
        this.mImpl.controlWindowInsetsAnimation(r100, r101, r110, r111, r112);
    }
}
