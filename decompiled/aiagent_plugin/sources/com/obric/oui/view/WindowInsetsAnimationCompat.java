package com.obric.oui.view;

import android.animation.ValueAnimator;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.WindowInsetsAnimation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.core.view.OneShotPreDrawListener;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
public final class WindowInsetsAnimationCompat {
    private static final String TAG = "WindowInsetsAnimCompat";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private c f36804a;

    private static class Impl21 extends c {

        private static class Impl21OnApplyWindowInsetsListener implements View.OnApplyWindowInsetsListener {
            private static final int COMPAT_ANIMATION_DURATION = 160;
            final b mCallback;
            private g mLastInsets;

            Impl21OnApplyWindowInsetsListener(View r1, b r2) {
                this.mCallback = r2;
                g r3 = ViewCompat.d(r1);
                if (r3 == null) goto L5;
                g r4 = new g.b(r3).a();
            L6:
                this.mLastInsets = r4;
                return;
            L5:
                r4 = null;
                goto L6
            }

            @Override // android.view.View.OnApplyWindowInsetsListener
            public WindowInsets onApplyWindowInsets(final View r16, WindowInsets r17) {
                if (r16.isLaidOut() == true) goto L6;
                this.mLastInsets = g.a(r17, r16);
                return Impl21.a(r16, r17);
            L6:
                final g r10 = g.a(r17, r16);
                if (this.mLastInsets != null) goto L10;
                this.mLastInsets = ViewCompat.d(r16);
            L10:
                if (this.mLastInsets != null) goto L13;
                this.mLastInsets = r10;
                return Impl21.a(r16, r17);
            L13:
                b r0 = Impl21.a(r16);
                if (r0 != null) goto L16;
            L19:
                final int r5 = Impl21.a(r10, this.mLastInsets);
                if (r5 == 0) goto L22;
                final g r4 = this.mLastInsets;
                final WindowInsetsAnimationCompat r11 = new WindowInsetsAnimationCompat(r5, new DecelerateInterpolator(), 160);
                r11.a(0.0f);
                final ValueAnimator r12 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(r11.b());
                final a r13 = Impl21.a(r10, r4, r5);
                Impl21.a(r16, r11, r17, false);
                r12.addUpdateListener(new AnonymousClass1(this, r11, r10, r4, r5, r16));
                r12.addListener(new AnonymousClass2(this, r11, r16));
                OneShotPreDrawListener.add(r16, new AnonymousClass3(this, r16, r11, r13, r12));
                this.mLastInsets = r10;
                return Impl21.a(r16, r17);
            L22:
                return Impl21.a(r16, r17);
            L16:
                if (Objects.equals(r0.f36813a, r17) == false) goto L19;
                return Impl21.a(r16, r17);
            }
        }

        Impl21(int r3, Interpolator r4, long r5) {
            super(r3, (Interpolator) ZeusTransformUtils.wrapperContextForParams(r4, Interpolator.class, "com.obric.aiagent.plugin"), r5);
        }

        static a a(g r4, g r5, int r6) {
            com.obric.oui.view.b r7 = r4.a(r6);
            com.obric.oui.view.b r8 = r5.a(r6);
            return new a(com.obric.oui.view.b.a(Math.min(r7.f36821b, r8.f36821b), Math.min(r7.f36822c, r8.f36822c), Math.min(r7.f36823d, r8.f36823d), Math.min(r7.f36824e, r8.f36824e)), com.obric.oui.view.b.a(Math.max(r7.f36821b, r8.f36821b), Math.max(r7.f36822c, r8.f36822c), Math.max(r7.f36823d, r8.f36823d), Math.max(r7.f36824e, r8.f36824e)));
        }

        static int a(g r4, g r5) {
            int r0 = 1;
            int r1 = 0;
        L4:
            if (r0 > 256) goto L9;
            if (r4.a(r0).equals(r5.a(r0)) == true) goto L8;
            r1 = r1 | r0;
        L8:
            r0 = r0 << 1;
            goto L4
        L9:
            return r1;
        }

        static g a(g r12, g r13, float r14, int r15) {
            g.b r0 = new g.b(r12);
            int r1 = 1;
        L4:
            if (r1 > 256) goto L11;
            if ((r15 & r1) != 0) goto L8;
            r0.a(r1, r12.a(r1));
        L9:
            r1 = r1 << 1;
            goto L4
        L8:
            com.obric.oui.view.b r2 = r12.a(r1);
            com.obric.oui.view.b r3 = r13.a(r1);
            float r5 = 1.0f - r14;
            r0.a(r1, g.a(r2, (int) (((double) ((r2.f36821b - r3.f36821b) * r5)) + 0.5d), (int) (((double) ((r2.f36822c - r3.f36822c) * r5)) + 0.5d), (int) (((double) ((r2.f36823d - r3.f36823d) * r5)) + 0.5d), (int) (((double) ((r2.f36824e - r3.f36824e) * r5)) + 0.5d)));
            goto L9
        L11:
            return r0.a();
        }

        static WindowInsets a(View r3, WindowInsets r4) {
            if (r3.getTag(ZeusTransformUtils.mapRes(R.id.o_tag_on_apply_window_listener, DbHelper.COL_ID, "o_tag_on_apply_window_listener")) == null) goto L6;
            return r4;
        L6:
            return r3.onApplyWindowInsets(r4);
        }

        static void a(View r3, WindowInsetsAnimationCompat r4, WindowInsets r5, boolean r6) {
            b r0 = a(r3);
            int r1 = 0;
            if (r0 == null) goto L11;
            r0.f36813a = r5;
            if (r6 == true) goto L11;
            r0.a(r4);
            if (r0.a() != 0) goto L9;
            r6 = true;
            goto L11
        L9:
            r6 = false;
        L11:
            if (ZeusTransformUtils.instanceOf(r3, ViewGroup.class) == false) goto L16;
            ViewGroup r7 = (ViewGroup) ZeusTransformUtils.preCheckCast(r3, ViewGroup.class, "com.obric.aiagent.plugin");
        L14:
            if (r1 >= r7.getChildCount()) goto L18;
            a(r7.getChildAt(r1), r4, r5, r6);
            r1 = r1 + 1;
            goto L14
        L18:
            return;
        }

        static void a(View r2, WindowInsetsAnimationCompat r3, a r4) {
            b r0 = a(r2);
            if (r0 == null) goto L8;
            r0.a(r3, r4);
            if (r0.a() != 0) goto L8;
            return;
        L8:
            if (ZeusTransformUtils.instanceOf(r2, ViewGroup.class) == false) goto L13;
            ViewGroup r5 = (ViewGroup) ZeusTransformUtils.preCheckCast(r2, ViewGroup.class, "com.obric.aiagent.plugin");
            int r1 = 0;
        L11:
            if (r1 >= r5.getChildCount()) goto L15;
            a(r5.getChildAt(r1), r3, r4);
            r1 = r1 + 1;
            goto L11
        L15:
            return;
        }

        static void a(View r2, g r3, List<WindowInsetsAnimationCompat> r4) {
            List<WindowInsetsAnimationCompat> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            b r0 = a(r2);
            if (r0 == null) goto L8;
            r3 = r0.a(r3, r5);
            if (r0.a() != 0) goto L8;
            return;
        L8:
            if (ZeusTransformUtils.instanceOf(r2, ViewGroup.class) == false) goto L13;
            ViewGroup r6 = (ViewGroup) ZeusTransformUtils.preCheckCast(r2, ViewGroup.class, "com.obric.aiagent.plugin");
            int r1 = 0;
        L11:
            if (r1 >= r6.getChildCount()) goto L15;
            a(r6.getChildAt(r1), r3, r5);
            r1 = r1 + 1;
            goto L11
        L15:
            return;
        }

        static void a(View r2, WindowInsetsAnimationCompat r3) {
            b r0 = a(r2);
            if (r0 == null) goto L8;
            r0.b(r3);
            if (r0.a() != 0) goto L8;
            return;
        L8:
            if (ZeusTransformUtils.instanceOf(r2, ViewGroup.class) == false) goto L13;
            ViewGroup r4 = (ViewGroup) ZeusTransformUtils.preCheckCast(r2, ViewGroup.class, "com.obric.aiagent.plugin");
            int r1 = 0;
        L11:
            if (r1 >= r4.getChildCount()) goto L15;
            a(r4.getChildAt(r1), r3);
            r1 = r1 + 1;
            goto L11
        L15:
            return;
        }

        static b a(View r3) {
            Object r4 = r3.getTag(ZeusTransformUtils.mapRes(R.id.o_tag_window_insets_animation_callback, DbHelper.COL_ID, "o_tag_window_insets_animation_callback"));
            if (ZeusTransformUtils.instanceOf(r4, Impl21OnApplyWindowInsetsListener.class) == true) goto L7;
            return null;
        L7:
            return ((Impl21OnApplyWindowInsetsListener) ZeusTransformUtils.preCheckCast(r4, Impl21OnApplyWindowInsetsListener.class, "com.obric.aiagent.plugin")).mCallback;
        }
    }

    private static class Impl30 extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final WindowInsetsAnimation f36810a;

        private static class ProxyCallback extends WindowInsetsAnimation.Callback {
            private final HashMap<WindowInsetsAnimation, WindowInsetsAnimationCompat> mAnimations;
            private final b mCompat;
            private List<WindowInsetsAnimationCompat> mRORunningAnimations;
            private ArrayList<WindowInsetsAnimationCompat> mTmpRunningAnimations;

            ProxyCallback(b r2) {
                super(r2.a());
                this.mAnimations = new HashMap();
                this.mCompat = r2;
            }

            private WindowInsetsAnimationCompat getWindowInsetsAnimationCompat(WindowInsetsAnimation r4) {
                WindowInsetsAnimationCompat r0 = (WindowInsetsAnimationCompat) ZeusTransformUtils.preCheckCast(this.mAnimations.get(r4), WindowInsetsAnimationCompat.class, "com.obric.aiagent.plugin");
                if (r0 != null) goto L6;
                WindowInsetsAnimationCompat r1 = WindowInsetsAnimationCompat.a(r4);
                this.mAnimations.put(r4, r1);
                return r1;
            L6:
                return r0;
            }

            @Override // android.view.WindowInsetsAnimation.Callback
            public void onPrepare(WindowInsetsAnimation r2) {
                this.mCompat.a(getWindowInsetsAnimationCompat(r2));
            }

            @Override // android.view.WindowInsetsAnimation.Callback
            public WindowInsetsAnimation.Bounds onStart(WindowInsetsAnimation r2, WindowInsetsAnimation.Bounds r3) {
                return this.mCompat.a(getWindowInsetsAnimationCompat(r2), a.a(r3)).c();
            }

            @Override // android.view.WindowInsetsAnimation.Callback
            public WindowInsets onProgress(WindowInsets r5, List<WindowInsetsAnimation> r6) {
                List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
                ArrayList<WindowInsetsAnimationCompat> r0 = this.mTmpRunningAnimations;
                if (r0 != null) goto L5;
                ArrayList<WindowInsetsAnimationCompat> r1 = new ArrayList(r7.size());
                this.mTmpRunningAnimations = r1;
                this.mRORunningAnimations = Collections.unmodifiableList(r1);
            L6:
                int r2 = r7.size() - 1;
            L7:
                if (r2 < 0) goto L10;
                WindowInsetsAnimation r3 = (WindowInsetsAnimation) ZeusTransformUtils.preCheckCast(r7.get(r2), WindowInsetsAnimation.class, "com.obric.aiagent.plugin");
                WindowInsetsAnimationCompat r4 = getWindowInsetsAnimationCompat(r3);
                r4.a(r3.getFraction());
                this.mTmpRunningAnimations.add(r4);
                r2 = r2 - 1;
                goto L7
            L10:
                return this.mCompat.a(g.a(r5), this.mRORunningAnimations).g();
            L5:
                r0.clear();
                goto L6
            }

            @Override // android.view.WindowInsetsAnimation.Callback
            public void onEnd(WindowInsetsAnimation r3) {
                this.mCompat.b(getWindowInsetsAnimationCompat(r3));
                this.mAnimations.remove(r3);
            }
        }

        Impl30(WindowInsetsAnimation r5) {
            super(0, null, 0);
            this.f36810a = r5;
        }

        Impl30(int r3, Interpolator r4, long r5) {
            this(new WindowInsetsAnimation(r3, (Interpolator) ZeusTransformUtils.wrapperContextForParams(r4, Interpolator.class, "com.obric.aiagent.plugin"), r5));
        }

        @Override // com.obric.oui.view.WindowInsetsAnimationCompat.c
        public long b() {
            return this.f36810a.getDurationMillis();
        }

        @Override // com.obric.oui.view.WindowInsetsAnimationCompat.c
        public void a(float r1) {
            this.f36810a.setFraction(r1);
        }

        @Override // com.obric.oui.view.WindowInsetsAnimationCompat.c
        public float a() {
            return this.f36810a.getInterpolatedFraction();
        }

        public static WindowInsetsAnimation.Bounds a(a r2) {
            return new WindowInsetsAnimation.Bounds(r2.a().a(), r2.b().a());
        }

        public static com.obric.oui.view.b a(WindowInsetsAnimation.Bounds r0) {
            return com.obric.oui.view.b.a(r0.getLowerBound());
        }

        public static com.obric.oui.view.b b(WindowInsetsAnimation.Bounds r0) {
            return com.obric.oui.view.b.a(r0.getUpperBound());
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.obric.oui.view.b f36811a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.obric.oui.view.b f36812b;

        public a(com.obric.oui.view.b r1, com.obric.oui.view.b r2) {
            this.f36811a = r1;
            this.f36812b = r2;
        }

        private a(WindowInsetsAnimation.Bounds r2) {
            this.f36811a = Impl30.a(r2);
            this.f36812b = Impl30.b(r2);
        }

        public com.obric.oui.view.b a() {
            return this.f36811a;
        }

        public com.obric.oui.view.b b() {
            return this.f36812b;
        }

        public String toString() {
            return "Bounds{lower=" + this.f36811a + " upper=" + this.f36812b + "}";
        }

        public WindowInsetsAnimation.Bounds c() {
            return Impl30.a(this);
        }

        public static a a(WindowInsetsAnimation.Bounds r1) {
            return new a(r1);
        }
    }

    public static abstract class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        WindowInsets f36813a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f36814b;

        public a a(WindowInsetsAnimationCompat r1, a r2) {
            return r2;
        }

        public abstract g a(g r1, List<WindowInsetsAnimationCompat> r2);

        public void a(WindowInsetsAnimationCompat r1) {
        }

        public void b(WindowInsetsAnimationCompat r1) {
        }

        public final int a() {
            return this.f36814b;
        }
    }

    private static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f36815a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private float f36816b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Interpolator f36817c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final long f36818d;

        c(int r3, Interpolator r4, long r5) {
            Interpolator r6 = (Interpolator) ZeusTransformUtils.wrapperContextForParams(r4, Interpolator.class, "com.obric.aiagent.plugin");
            this.f36815a = r3;
            this.f36817c = r6;
            this.f36818d = r5;
        }

        public float a() {
            Interpolator r0 = this.f36817c;
            if (r0 == null) goto L7;
            return r0.getInterpolation(this.f36816b);
        L7:
            return this.f36816b;
        }

        public long b() {
            return this.f36818d;
        }

        public void a(float r1) {
            this.f36816b = r1;
        }
    }

    public WindowInsetsAnimationCompat(int r3, Interpolator r4, long r5) {
        Interpolator r6 = (Interpolator) ZeusTransformUtils.wrapperContextForParams(r4, Interpolator.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT < 30) goto L6;
        this.f36804a = new Impl30(r3, r6, r5);
        return;
    L6:
        if (Build.VERSION.SDK_INT < 21) goto L8;
        this.f36804a = new Impl21(r3, r6, r5);
        return;
    L8:
        this.f36804a = new c(0, r6, r5);
    }

    private WindowInsetsAnimationCompat(WindowInsetsAnimation r5) {
        this(0, null, 0);
        if (Build.VERSION.SDK_INT < 30) goto L6;
        this.f36804a = new Impl30(r5);
        return;
    }

    public float a() {
        return this.f36804a.a();
    }

    public long b() {
        return this.f36804a.b();
    }

    public void a(float r1) {
        this.f36804a.a(r1);
    }

    static WindowInsetsAnimationCompat a(WindowInsetsAnimation r1) {
        return new WindowInsetsAnimationCompat(r1);
    }
}
