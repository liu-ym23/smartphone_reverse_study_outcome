package androidx.core.view;

import android.animation.ValueAnimator;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.WindowInsetsAnimation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import androidx.core.graphics.Insets;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class WindowInsetsAnimationCompat {
    private static final boolean DEBUG = false;
    private static final String TAG = "WindowInsetsAnimCompat";
    private Impl mImpl;

    /* JADX INFO: loaded from: classes17.dex */
    public static final class BoundsCompat {
        private final Insets mLowerBound;
        private final Insets mUpperBound;

        public String toString() {
            return "Bounds{lower=" + this.mLowerBound + " upper=" + this.mUpperBound + com.alipay.sdk.m.u.i.f25855d;
        }

        public WindowInsetsAnimation.Bounds toBounds() {
            return Impl30.createPlatformBounds(this);
        }

        public Insets getLowerBound() {
            return this.mLowerBound;
        }

        public Insets getUpperBound() {
            return this.mUpperBound;
        }

        private BoundsCompat(WindowInsetsAnimation.Bounds r100) {
            this.mLowerBound = Impl30.getLowerBounds(r100);
            this.mUpperBound = Impl30.getHigherBounds(r100);
        }

        public static BoundsCompat toBoundsCompat(WindowInsetsAnimation.Bounds r100) {
            return new BoundsCompat(r100);
        }

        public BoundsCompat inset(Insets r100) {
            return new BoundsCompat(WindowInsetsCompat.insetInsets(this.mLowerBound, r100.left, r100.top, r100.right, r100.bottom), WindowInsetsCompat.insetInsets(this.mUpperBound, r100.left, r100.top, r100.right, r100.bottom));
        }

        public BoundsCompat(Insets r100, Insets r101) {
            this.mLowerBound = r100;
            this.mUpperBound = r101;
        }
    }

    public static abstract class Callback {
        public static final int DISPATCH_MODE_CONTINUE_ON_SUBTREE = 1;
        public static final int DISPATCH_MODE_STOP = 0;
        WindowInsets mDispachedInsets;
        private final int mDispatchMode;

        /* JADX INFO: loaded from: classes17.dex */
        @Retention(RetentionPolicy.SOURCE)
        public @interface DispatchMode {
        }

        public void onEnd(WindowInsetsAnimationCompat r100) {
        }

        public void onPrepare(WindowInsetsAnimationCompat r100) {
        }

        public abstract WindowInsetsCompat onProgress(WindowInsetsCompat r100, List<WindowInsetsAnimationCompat> r101);

        public BoundsCompat onStart(WindowInsetsAnimationCompat r100, BoundsCompat r101) {
            return r101;
        }

        public final int getDispatchMode() {
            return this.mDispatchMode;
        }

        public Callback(int r100) {
            this.mDispatchMode = r100;
        }
    }

    public static class Impl {
        private float mAlpha;
        private final long mDurationMillis;
        private float mFraction;
        private final Interpolator mInterpolator;
        private final int mTypeMask;

        public float getInterpolatedFraction() {
            Interpolator r100 = this.mInterpolator;
            if (r100 == null) goto L7;
            return r100.getInterpolation(this.mFraction);
        L7:
            return this.mFraction;
        }

        public float getAlpha() {
            return this.mAlpha;
        }

        public long getDurationMillis() {
            return this.mDurationMillis;
        }

        public float getFraction() {
            return this.mFraction;
        }

        public Interpolator getInterpolator() {
            return this.mInterpolator;
        }

        public int getTypeMask() {
            return this.mTypeMask;
        }

        public void setAlpha(float r100) {
            this.mAlpha = r100;
        }

        public void setFraction(float r100) {
            this.mFraction = r100;
        }

        public Impl(int r100, Interpolator r101, long r102) {
            this.mTypeMask = r100;
            this.mInterpolator = r101;
            this.mDurationMillis = r102;
        }
    }

    /* JADX INFO: loaded from: classes17.dex */
    public static class Impl21 extends Impl {
        private static final Interpolator DEFAULT_INSET_INTERPOLATOR = null;
        private static final Interpolator HIDE_IME_INTERPOLATOR = null;
        private static final Interpolator SHOW_IME_INTERPOLATOR = null;

        public static class Impl21OnApplyWindowInsetsListener implements View.OnApplyWindowInsetsListener {
            private static final int COMPAT_ANIMATION_DURATION = 160;
            final Callback mCallback;
            private WindowInsetsCompat mLastInsets;

            public Impl21OnApplyWindowInsetsListener(View r100, Callback r101) {
                this.mCallback = r101;
                WindowInsetsCompat r102 = ViewCompat.getRootWindowInsets(r100);
                if (r102 == null) goto L5;
                WindowInsetsCompat r103 = new WindowInsetsCompat.Builder(r102).build();
            L6:
                this.mLastInsets = r103;
                return;
            L5:
                r103 = null;
                goto L6
            }

            @Override // android.view.View.OnApplyWindowInsetsListener
            public WindowInsets onApplyWindowInsets(final View r110, WindowInsets r111) {
                if (r110.isLaidOut() == true) goto L6;
                this.mLastInsets = WindowInsetsCompat.toWindowInsetsCompat(r111, r110);
                return Impl21.forwardToViewIfNeeded(r110, r111);
            L6:
                final WindowInsetsCompat r112 = WindowInsetsCompat.toWindowInsetsCompat(r111, r110);
                if (this.mLastInsets != null) goto L10;
                this.mLastInsets = ViewCompat.getRootWindowInsets(r110);
            L10:
                if (this.mLastInsets != null) goto L13;
                this.mLastInsets = r112;
                return Impl21.forwardToViewIfNeeded(r110, r111);
            L13:
                Callback r100 = Impl21.getCallback(r110);
                if (r100 != null) goto L16;
            L19:
                final int r101 = Impl21.buildAnimationMask(r112, this.mLastInsets);
                if (r101 == 0) goto L22;
                final WindowInsetsCompat r102 = this.mLastInsets;
                final WindowInsetsAnimationCompat r113 = new WindowInsetsAnimationCompat(r101, Impl21.createInsetInterpolator(r101, r112, r102), 160);
                r113.setFraction(0.0f);
                final ValueAnimator r114 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(r113.getDurationMillis());
                final BoundsCompat r115 = Impl21.computeAnimationBounds(r112, r102, r101);
                Impl21.dispatchOnPrepare(r110, r113, r111, false);
                r114.addUpdateListener(new AnonymousClass1(this, r113, r112, r102, r101, r110));
                r114.addListener(new AnonymousClass2(this, r113, r110));
                OneShotPreDrawListener.add(r110, new AnonymousClass3(this, r110, r113, r115, r114));
                this.mLastInsets = r112;
                return Impl21.forwardToViewIfNeeded(r110, r111);
            L22:
                return Impl21.forwardToViewIfNeeded(r110, r111);
            L16:
                if (Objects.equals(r100.mDispachedInsets, r111) == false) goto L19;
                return Impl21.forwardToViewIfNeeded(r110, r111);
            }
        }

        static {
            SHOW_IME_INTERPOLATOR = new PathInterpolator(0.0f, 1.1f, 0.0f, 1.0f);
            HIDE_IME_INTERPOLATOR = new FastOutLinearInInterpolator();
            DEFAULT_INSET_INTERPOLATOR = new DecelerateInterpolator();
        }

        public static Callback getCallback(View r100) {
            Object r101 = r100.getTag(R.id.tag_window_insets_animation_callback);
            if ((r101 instanceof Impl21OnApplyWindowInsetsListener) == true) goto L7;
            return null;
        L7:
            return ((Impl21OnApplyWindowInsetsListener) r101).mCallback;
        }

        public static int buildAnimationMask(WindowInsetsCompat r100, WindowInsetsCompat r101) {
            int r102 = 0;
            int r103 = 1;
        L4:
            if (r103 > 256) goto L9;
            if (r100.getInsets(r103).equals(r101.getInsets(r103)) == true) goto L8;
            r102 = r102 | r103;
        L8:
            r103 = r103 << 1;
            goto L4
        L9:
            return r102;
        }

        private static View.OnApplyWindowInsetsListener createProxyListener(View r100, Callback r101) {
            return new Impl21OnApplyWindowInsetsListener(r100, r101);
        }

        public static void dispatchOnEnd(View r100, WindowInsetsAnimationCompat r101) {
            Callback r102 = getCallback(r100);
            if (r102 == null) goto L8;
            r102.onEnd(r101);
            if (r102.getDispatchMode() != 0) goto L8;
            return;
        L8:
            if ((r100 instanceof ViewGroup) == false) goto L13;
            ViewGroup r103 = (ViewGroup) r100;
            int r104 = 0;
        L11:
            if (r104 >= r103.getChildCount()) goto L15;
            dispatchOnEnd(r103.getChildAt(r104), r101);
            r104 = r104 + 1;
            goto L11
        L15:
            return;
        }

        public static WindowInsets forwardToViewIfNeeded(View r100, WindowInsets r101) {
            if (r100.getTag(R.id.tag_on_apply_window_listener) == null) goto L6;
            return r101;
        L6:
            return r100.onApplyWindowInsets(r101);
        }

        public static void setCallback(View r100, Callback r101) {
            Object r102 = r100.getTag(R.id.tag_on_apply_window_listener);
            if (r101 != null) goto L7;
            r100.setTag(R.id.tag_window_insets_animation_callback, null);
            if (r102 != null) goto L11;
            r100.setOnApplyWindowInsetsListener(null);
            return;
        L11:
            return;
        L7:
            View.OnApplyWindowInsetsListener r103 = createProxyListener(r100, r101);
            r100.setTag(R.id.tag_window_insets_animation_callback, r103);
            if (r102 != null) goto L13;
            r100.setOnApplyWindowInsetsListener(r103);
            return;
        }

        public Impl21(int r100, Interpolator r101, long r102) {
            super(r100, r101, r102);
        }

        public static BoundsCompat computeAnimationBounds(WindowInsetsCompat r100, WindowInsetsCompat r101, int r102) {
            Insets r103 = r100.getInsets(r102);
            Insets r104 = r101.getInsets(r102);
            return new BoundsCompat(Insets.of(Math.min(r103.left, r104.left), Math.min(r103.top, r104.top), Math.min(r103.right, r104.right), Math.min(r103.bottom, r104.bottom)), Insets.of(Math.max(r103.left, r104.left), Math.max(r103.top, r104.top), Math.max(r103.right, r104.right), Math.max(r103.bottom, r104.bottom)));
        }

        public static Interpolator createInsetInterpolator(int r100, WindowInsetsCompat r101, WindowInsetsCompat r102) {
            if ((r100 & 8) == 0) goto L11;
            if (r101.getInsets(WindowInsetsCompat.Type.ime()).bottom <= r102.getInsets(WindowInsetsCompat.Type.ime()).bottom) goto L9;
            return SHOW_IME_INTERPOLATOR;
        L9:
            return HIDE_IME_INTERPOLATOR;
        L11:
            return DEFAULT_INSET_INTERPOLATOR;
        }

        public static void dispatchOnProgress(View r100, WindowInsetsCompat r101, List<WindowInsetsAnimationCompat> r102) {
            Callback r103 = getCallback(r100);
            if (r103 == null) goto L8;
            r101 = r103.onProgress(r101, r102);
            if (r103.getDispatchMode() != 0) goto L8;
            return;
        L8:
            if ((r100 instanceof ViewGroup) == false) goto L13;
            ViewGroup r104 = (ViewGroup) r100;
            int r105 = 0;
        L11:
            if (r105 >= r104.getChildCount()) goto L15;
            dispatchOnProgress(r104.getChildAt(r105), r101, r102);
            r105 = r105 + 1;
            goto L11
        L15:
            return;
        }

        public static void dispatchOnStart(View r100, WindowInsetsAnimationCompat r101, BoundsCompat r102) {
            Callback r103 = getCallback(r100);
            if (r103 == null) goto L8;
            r103.onStart(r101, r102);
            if (r103.getDispatchMode() != 0) goto L8;
            return;
        L8:
            if ((r100 instanceof ViewGroup) == false) goto L13;
            ViewGroup r104 = (ViewGroup) r100;
            int r105 = 0;
        L11:
            if (r105 >= r104.getChildCount()) goto L15;
            dispatchOnStart(r104.getChildAt(r105), r101, r102);
            r105 = r105 + 1;
            goto L11
        L15:
            return;
        }

        public static void dispatchOnPrepare(View r100, WindowInsetsAnimationCompat r101, WindowInsets r102, boolean r103) {
            Callback r104 = getCallback(r100);
            int r105 = 0;
            if (r104 == null) goto L11;
            r104.mDispachedInsets = r102;
            if (r103 == true) goto L11;
            r104.onPrepare(r101);
            if (r104.getDispatchMode() != 0) goto L9;
            r103 = true;
            goto L11
        L9:
            r103 = false;
        L11:
            if ((r100 instanceof ViewGroup) == false) goto L16;
            ViewGroup r106 = (ViewGroup) r100;
        L14:
            if (r105 >= r106.getChildCount()) goto L18;
            dispatchOnPrepare(r106.getChildAt(r105), r101, r102, r103);
            r105 = r105 + 1;
            goto L14
        L18:
            return;
        }

        public static WindowInsetsCompat interpolateInsets(WindowInsetsCompat r110, WindowInsetsCompat r111, float r112, int r113) {
            WindowInsetsCompat.Builder r100 = new WindowInsetsCompat.Builder(r110);
            int r101 = 1;
        L4:
            if (r101 > 256) goto L11;
            if ((r113 & r101) != 0) goto L8;
            r100.setInsets(r101, r110.getInsets(r101));
        L9:
            r101 = r101 << 1;
            goto L4
        L8:
            Insets r102 = r110.getInsets(r101);
            Insets r103 = r111.getInsets(r101);
            float r104 = 1.0f - r112;
            r100.setInsets(r101, WindowInsetsCompat.insetInsets(r102, (int) (((double) ((r102.left - r103.left) * r104)) + 0.5d), (int) (((double) ((r102.top - r103.top) * r104)) + 0.5d), (int) (((double) ((r102.right - r103.right) * r104)) + 0.5d), (int) (((double) ((r102.bottom - r103.bottom) * r104)) + 0.5d)));
            goto L9
        L11:
            return r100.build();
        }
    }

    public static class Impl30 extends Impl {
        private final WindowInsetsAnimation mWrapped;

        public static class ProxyCallback extends WindowInsetsAnimation.Callback {
            private final HashMap<WindowInsetsAnimation, WindowInsetsAnimationCompat> mAnimations;
            private final Callback mCompat;
            private List<WindowInsetsAnimationCompat> mRORunningAnimations;
            private ArrayList<WindowInsetsAnimationCompat> mTmpRunningAnimations;

            public ProxyCallback(Callback r100) {
                super(r100.getDispatchMode());
                this.mAnimations = new HashMap();
                this.mCompat = r100;
            }

            private WindowInsetsAnimationCompat getWindowInsetsAnimationCompat(WindowInsetsAnimation r100) {
                WindowInsetsAnimationCompat r101 = this.mAnimations.get(r100);
                if (r101 != null) goto L6;
                WindowInsetsAnimationCompat r102 = WindowInsetsAnimationCompat.toWindowInsetsAnimationCompat(r100);
                this.mAnimations.put(r100, r102);
                return r102;
            L6:
                return r101;
            }

            @Override // android.view.WindowInsetsAnimation.Callback
            public void onEnd(WindowInsetsAnimation r100) {
                this.mCompat.onEnd(getWindowInsetsAnimationCompat(r100));
                this.mAnimations.remove(r100);
            }

            @Override // android.view.WindowInsetsAnimation.Callback
            public void onPrepare(WindowInsetsAnimation r100) {
                this.mCompat.onPrepare(getWindowInsetsAnimationCompat(r100));
            }

            @Override // android.view.WindowInsetsAnimation.Callback
            public WindowInsets onProgress(WindowInsets r100, List<WindowInsetsAnimation> r101) {
                ArrayList<WindowInsetsAnimationCompat> r102 = this.mTmpRunningAnimations;
                if (r102 != null) goto L5;
                ArrayList<WindowInsetsAnimationCompat> r103 = new ArrayList(r101.size());
                this.mTmpRunningAnimations = r103;
                this.mRORunningAnimations = Collections.unmodifiableList(r103);
            L6:
                int r104 = r101.size() - 1;
            L7:
                if (r104 < 0) goto L10;
                WindowInsetsAnimation r105 = (WindowInsetsAnimation) ListProtector.get(r101, r104);
                WindowInsetsAnimationCompat r106 = getWindowInsetsAnimationCompat(r105);
                r106.setFraction(r105.getFraction());
                this.mTmpRunningAnimations.add(r106);
                r104 = r104 - 1;
                goto L7
            L10:
                return this.mCompat.onProgress(WindowInsetsCompat.toWindowInsetsCompat(r100), this.mRORunningAnimations).toWindowInsets();
            L5:
                r102.clear();
                goto L6
            }

            @Override // android.view.WindowInsetsAnimation.Callback
            public WindowInsetsAnimation.Bounds onStart(WindowInsetsAnimation r100, WindowInsetsAnimation.Bounds r101) {
                return this.mCompat.onStart(getWindowInsetsAnimationCompat(r100), BoundsCompat.toBoundsCompat(r101)).toBounds();
            }
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.Impl
        public long getDurationMillis() {
            return this.mWrapped.getDurationMillis();
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.Impl
        public float getFraction() {
            return this.mWrapped.getFraction();
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.Impl
        public float getInterpolatedFraction() {
            return this.mWrapped.getInterpolatedFraction();
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.Impl
        public Interpolator getInterpolator() {
            return this.mWrapped.getInterpolator();
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.Impl
        public int getTypeMask() {
            return this.mWrapped.getTypeMask();
        }

        public Impl30(WindowInsetsAnimation r100) {
            super(0, null, 0);
            this.mWrapped = r100;
        }

        public static WindowInsetsAnimation.Bounds createPlatformBounds(BoundsCompat r100) {
            return new WindowInsetsAnimation.Bounds(r100.getLowerBound().toPlatformInsets(), r100.getUpperBound().toPlatformInsets());
        }

        public static Insets getHigherBounds(WindowInsetsAnimation.Bounds r100) {
            return Insets.toCompatInsets(r100.getUpperBound());
        }

        public static Insets getLowerBounds(WindowInsetsAnimation.Bounds r100) {
            return Insets.toCompatInsets(r100.getLowerBound());
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.Impl
        public void setFraction(float r100) {
            this.mWrapped.setFraction(r100);
        }

        public static void setCallback(View r100, Callback r101) {
            if (r101 == null) goto L4;
            ProxyCallback r102 = new ProxyCallback(r101);
        L5:
            r100.setWindowInsetsAnimationCallback(r102);
            return;
        L4:
            r102 = null;
            goto L5
        }

        public Impl30(int r100, Interpolator r101, long r102) {
            this(new WindowInsetsAnimation(r100, r101, r102));
        }
    }

    public float getAlpha() {
        return this.mImpl.getAlpha();
    }

    public long getDurationMillis() {
        return this.mImpl.getDurationMillis();
    }

    public float getFraction() {
        return this.mImpl.getFraction();
    }

    public float getInterpolatedFraction() {
        return this.mImpl.getInterpolatedFraction();
    }

    public Interpolator getInterpolator() {
        return this.mImpl.getInterpolator();
    }

    public int getTypeMask() {
        return this.mImpl.getTypeMask();
    }

    private WindowInsetsAnimationCompat(WindowInsetsAnimation r100) {
        this(0, null, 0);
        if (Build.VERSION.SDK_INT < 30) goto L6;
        this.mImpl = new Impl30(r100);
        return;
    }

    public static WindowInsetsAnimationCompat toWindowInsetsAnimationCompat(WindowInsetsAnimation r100) {
        return new WindowInsetsAnimationCompat(r100);
    }

    public void setAlpha(float r100) {
        this.mImpl.setAlpha(r100);
    }

    public void setFraction(float r100) {
        this.mImpl.setFraction(r100);
    }

    public static void setCallback(View r100, Callback r101) {
        if (Build.VERSION.SDK_INT < 30) goto L5;
        Impl30.setCallback(r100, r101);
        return;
    L5:
        Impl21.setCallback(r100, r101);
    }

    public WindowInsetsAnimationCompat(int r100, Interpolator r101, long r102) {
        if (Build.VERSION.SDK_INT < 30) goto L5;
        this.mImpl = new Impl30(r100, r101, r102);
        return;
    L5:
        this.mImpl = new Impl21(r100, r101, r102);
    }
}
