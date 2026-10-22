package com.bytedance.android.livesdk.utils;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.util.Property;
import android.view.View;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.livesdk.utils.animate.frame.FrameAnimatorSet;
import com.bytedance.android.livesdk.utils.animate.frame.ValueFrameAnimator;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class q4 {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static boolean f159128i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a f159129j = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f159130a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TimeInterpolator f159131b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Animator f159132c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList<Animator> f159133d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Function0<Unit> f159134e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function0<Unit> f159135f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Function0<Unit> f159136g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f159137h;

    public static final class a {

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.utils.q4$a$a, reason: collision with other inner class name */
        public static final class C2432a implements ValueAnimator.AnimatorUpdateListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Property f159138a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ View f159139b;

            public C2432a(Property r100, View r101) {
                this.f159138a = r100;
                this.f159139b = r101;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator r100) {
                Intrinsics.checkNotNullParameter(r100, "animator");
                Property r101 = this.f159138a;
                if (r101 == null) goto L9;
                View r102 = this.f159139b;
                Object r103 = r100.getAnimatedValue();
                if (r103 == null) goto L8;
                r101.set(r102, (Float) r103);
                return;
            L8:
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
            }
        }

        public a() {
        }

        public static boolean a() {
            if (q4.f159128i == true) goto L5;
        L7:
            return false;
        L5:
            if (LiveInfraSettingKeys.LIVE_VALUE_ANIM_CAN_FALLBACK_TO_FRAME.getValue().booleanValue() == false) goto L7;
            return true;
        }

        @JvmStatic
        public static ValueAnimator b(View r100, String r101, float... r102) {
            Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
            Intrinsics.checkNotNullParameter(r101, "propertyName");
            Intrinsics.checkNotNullParameter(r102, "values");
            switch(r101.hashCode()) {
                case -1249320806: goto L33;
                case -1249320805: goto L30;
                case -1225497657: goto L27;
                case -1225497656: goto L24;
                case -908189618: goto L21;
                case -908189617: goto L18;
                case -40300674: goto L15;
                case 120: goto L12;
                case 121: goto L9;
                case 92909918: goto L6;
                default: goto L36;
            };
        L6:
            if (r101.equals("alpha") == false) goto L36;
            Property r103 = View.ALPHA;
        L38:
            float[] r104 = Arrays.copyOf(r102, r102.length);
            Intrinsics.checkNotNullParameter(r104, "values");
            if (a() == false) goto L41;
            int r105 = ValueFrameAnimator.f158837q;
            ValueAnimator r106 = ValueFrameAnimator.Companion.a(Arrays.copyOf(r104, r104.length));
        L42:
            r106.addUpdateListener(new C2432a(r103, r100));
            return r106;
        L41:
            r106 = ValueAnimator.ofFloat(Arrays.copyOf(r104, r104.length));
            goto L42
        L9:
            if (r101.equals("y") == false) goto L36;
            r103 = View.Y;
            goto L38
        L12:
            if (r101.equals("x") == false) goto L36;
            r103 = View.X;
            goto L38
        L15:
            if (r101.equals("rotation") == false) goto L36;
            r103 = View.ROTATION;
            goto L38
        L18:
            if (r101.equals(LiveDegradeFpsAnimator.SCALE_Y) == false) goto L36;
            r103 = View.SCALE_Y;
            goto L38
        L21:
            if (r101.equals(LiveDegradeFpsAnimator.SCALE_X) == false) goto L36;
            r103 = View.SCALE_X;
            goto L38
        L24:
            if (r101.equals(LiveDegradeFpsAnimator.TRANSLATION_Y) == false) goto L36;
            r103 = View.TRANSLATION_Y;
            goto L38
        L27:
            if (r101.equals(LiveDegradeFpsAnimator.TRANSLATION_X) == false) goto L36;
            r103 = View.TRANSLATION_X;
            goto L38
        L30:
            if (r101.equals("rotationY") == false) goto L36;
            r103 = View.ROTATION_Y;
            goto L38
        L33:
            if (r101.equals("rotationX") == false) goto L36;
            r103 = View.ROTATION_X;
        L36:
            if (com.bytedance.android.live.core.utils.v.a() == true) goto L45;
            r103 = null;
            goto L38
        L45:
            throw new IllegalArgumentException("not support property: ".concat(r101));
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final q4 f159140a;

        public final void a() {
            this.f159140a.f159132c.cancel();
        }

        public final boolean b() {
            return this.f159140a.f159132c.isRunning();
        }

        public final void c() {
            q4 r100 = this.f159140a;
            r100.f159132c.cancel();
            r100.f159132c.removeAllListeners();
            if (r100.f159134e == null) goto L5;
        L8:
            r100.f159132c.addListener(new t4(r100));
        L9:
            Animator r101 = null;
            if (r100.f159137h == false) goto L18;
            Animator r102 = r100.f159132c;
            if ((r102 instanceof FrameAnimatorSet) == false) goto L15;
            r101 = r102;
        L15:
            FrameAnimatorSet r103 = (FrameAnimatorSet) r101;
            if (r103 == null) goto L25;
            r103.b(r100.f159133d);
        L25:
            r100.f159132c.start();
            return;
        L18:
            Animator r104 = r100.f159132c;
            if ((r104 instanceof AnimatorSet) == false) goto L22;
            r101 = r104;
        L22:
            AnimatorSet r105 = (AnimatorSet) r101;
            if (r105 == null) goto L25;
            r105.playSequentially(r100.f159133d);
            goto L25
        L5:
            if (r100.f159135f != null) goto L8;
            if (r100.f159136g == null) goto L9;
            goto L8
        }

        public b(q4 r100) {
            Intrinsics.checkNotNullParameter(r100, "animator");
            this.f159140a = r100;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ConcurrentHashMap<String, b> f159141a = null;

        static {
            f159141a = new ConcurrentHashMap();
        }
    }

    static {
        f159129j = new a();
    }

    public q4(boolean r100) {
        this.f159137h = r100;
        this.f159130a = -1;
        if (r100 == false) goto L5;
        Animator r101 = new FrameAnimatorSet();
    L6:
        this.f159132c = r101;
        this.f159133d = new ArrayList();
        return;
    L5:
        r101 = new AnimatorSet();
        goto L6
    }

    public final void a(long r100) {
        if (this.f159137h == false) goto L5;
        int r101 = ValueFrameAnimator.f158837q;
        ValueFrameAnimator r102 = ValueFrameAnimator.Companion.a(new float[]{0.0f, 1.0f});
        Intrinsics.checkNotNullParameter("DelayFrameAnimator", "<set-?>");
        r102.f158840c = "DelayFrameAnimator";
        ValueAnimator r103 = r102;
    L6:
        r103.setDuration(r100);
        this.f159133d.add(r103);
        return;
    L5:
        r103 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        goto L6
    }

    public final void b(Function1<? super AnAnimator, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "anim");
        boolean r101 = this.f159137h;
        AnAnimator r102 = new AnAnimator(r101);
        r100.invoke(r102);
        Animator r103 = r102.f158728a;
        if (r102.f158733f == null) goto L5;
    L7:
        r103.addListener(new f(r102));
    L8:
        r103.setDuration(r102.f158732e);
        r103.setInterpolator(r102.f158735h);
        r103.setStartDelay(r102.f158736i);
        Animator r104 = null;
        if (r101 == false) goto L18;
        if ((r103 instanceof FrameAnimatorSet) == false) goto L14;
        r104 = r103;
    L14:
        FrameAnimatorSet r105 = (FrameAnimatorSet) r104;
        if (r105 == null) goto L24;
        r105.c(r102.f158729b);
    L24:
        long r106 = this.f159130a;
        if (r106 < 0) goto L27;
        r103.setDuration(r106);
    L27:
        TimeInterpolator r107 = this.f159131b;
        if (r107 == null) goto L30;
        r103.setInterpolator(r107);
    L30:
        this.f159133d.add(r103);
        return;
    L18:
        if ((r103 instanceof AnimatorSet) == false) goto L21;
        r104 = r103;
    L21:
        AnimatorSet r108 = (AnimatorSet) r104;
        if (r108 == null) goto L24;
        r108.playTogether(r102.f158729b);
        goto L24
    L5:
        if (r102.f158734g != null) goto L7;
        goto L7
    }

    public final void c(Function1<? super q4, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "init");
        boolean r101 = this.f159137h;
        q4 r102 = new q4(r101);
        r100.invoke(r102);
        Animator r103 = r102.f159132c;
        if (r103.getDuration() < 0) goto L5;
        r103.setDuration(r102.f159130a);
    L5:
        TimeInterpolator r104 = r102.f159131b;
        if (r104 == null) goto L9;
        r103.setInterpolator(r104);
    L9:
        if (r102.f159134e == null) goto L11;
    L14:
        r103.addListener(new r4(r102));
    L15:
        Animator r105 = null;
        if (r101 == false) goto L25;
        if ((r103 instanceof FrameAnimatorSet) == false) goto L21;
        r105 = r103;
    L21:
        FrameAnimatorSet r106 = (FrameAnimatorSet) r105;
        if (r106 == null) goto L31;
        r106.b(r102.f159133d);
    L31:
        this.f159133d.add(r103);
        return;
    L25:
        if ((r103 instanceof AnimatorSet) == false) goto L28;
        r105 = r103;
    L28:
        AnimatorSet r107 = (AnimatorSet) r105;
        if (r107 == null) goto L31;
        r107.playSequentially(r102.f159133d);
        goto L31
    L11:
        if (r102.f159135f != null) goto L14;
        if (r102.f159136g == null) goto L15;
        goto L14
    }

    public final void d(Function1<? super q4, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "init");
        boolean r101 = this.f159137h;
        q4 r102 = new q4(r101);
        r100.invoke(r102);
        Animator r103 = r102.f159132c;
        if (r103.getDuration() < 0) goto L5;
        r103.setDuration(r102.f159130a);
    L5:
        TimeInterpolator r104 = r102.f159131b;
        if (r104 == null) goto L9;
        r103.setInterpolator(r104);
    L9:
        if (r102.f159134e == null) goto L11;
    L14:
        r103.addListener(new s4(r102));
    L15:
        Animator r105 = null;
        if (r101 == false) goto L25;
        if ((r103 instanceof FrameAnimatorSet) == false) goto L21;
        r105 = r103;
    L21:
        FrameAnimatorSet r106 = (FrameAnimatorSet) r105;
        if (r106 == null) goto L31;
        r106.c(r102.f159133d);
    L31:
        this.f159133d.add(r103);
        return;
    L25:
        if ((r103 instanceof AnimatorSet) == false) goto L28;
        r105 = r103;
    L28:
        AnimatorSet r107 = (AnimatorSet) r105;
        if (r107 == null) goto L31;
        r107.playTogether(r102.f159133d);
        goto L31
    L11:
        if (r102.f159135f != null) goto L14;
        if (r102.f159136g == null) goto L15;
        goto L14
    }
}
