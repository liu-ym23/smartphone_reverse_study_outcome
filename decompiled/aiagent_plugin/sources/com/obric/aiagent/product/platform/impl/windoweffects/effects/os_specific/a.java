package com.obric.aiagent.product.platform.impl.windoweffects.effects.os_specific;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.IBinder;
import android.util.Pair;
import android.view.Display;
import android.view.WindowManager;
import bytedanceos.api.DisplayManagerSmt;
import bytedanceos.api.TransactionSmt;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.product.ObricProductSdk;
import com.obric.aiagent.product.a.e;
import com.obric.aiagent.product.platform.impl.windoweffects.effects.android_common.SmoothInterpolator;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.f;
import d.g;
import d.n;
import d.o;
import d.x;
import java.util.ArrayList;

/* JADX INFO: compiled from: OSGlobalEffectManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {
    private static final String TAG = "OSGlobalEffectManager";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f18897a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Animator f18898b;

    /* JADX INFO: renamed from: com.obric.aiagent.product.platform.impl.windoweffects.effects.os_specific.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ThreadUtils.kt */
    public static final class RunnableC0413a implements Runnable {
        public RunnableC0413a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            Animator r13 = a.b();
            if (r13 == null) goto L5;
            r13.cancel();
        L5:
            final f r14 = g.a((d.h.a.a) ZeusTransformUtils.preCheckCast(b.f18899a, d.h.a.a.class, "com.obric.aiagent.plugin"));
            if (a.a(r14) != null) goto L8;
            ILogDepend.Companion.w(a.TAG, "playRippleEffect: display token is null");
            return;
        L8:
            final Point r0 = a.a(a.f18897a, (Context) ZeusTransformUtils.preCheckCast((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
            final float r3 = Resources.getSystem().getDisplayMetrics().density;
            ILogDepend.Companion.i(a.TAG, "playRippleEffect: screenWith = " + r0.x + ", screenHeight = " + r0.y + ", density = " + r3);
            a r6 = a.f18897a;
            n.a r7 = n.f38560a;     // Catch: Throwable -> L11
            TransactionSmt.getInstance().stopAnimation(a.a(r14));     // Catch: Throwable -> L11
            TransactionSmt r8 = TransactionSmt.getInstance();     // Catch: Throwable -> L11
            IBinder r9 = a.a(r14);     // Catch: Throwable -> L11
            ArrayList<Pair<String, String>> r10 = new ArrayList();     // Catch: Throwable -> L11
            r10.add(new Pair("shader", "\n        uniform vec2 uResolution;\n        uniform float uDensity;\n        uniform float uProgress;\n        uniform shader uScreen;\n        \n        const vec2 EFFECT_ORIGIN = vec2(0.5, 1.0);\n        const float SHIMMER_RING_WIDTH_RATIO = 0.5;\n        const float SHIMMER_RING_SOFTNESS = 0.2;\n        const float SHIMMER_RING_OPACITY = 0.25;\n        const float BACKGROUND_DISTORTION_PIXELS = 24.0;\n        \n        float sdCircle(vec2 position, vec2 center, float radius) {\n            return length(position - center) - radius;\n        }\n        \n        float easeArc(float t) {\n            return 4.0 * t * (1.0 - t);\n        }\n        \n        float createStroke(float offset, float width, float edge, float sdf) {\n            float inner = smoothstep(offset - edge, offset + edge, sdf + width * 0.5);\n            float outer = smoothstep(offset - edge, offset + edge, sdf - width * 0.5);\n            return saturate(inner - outer);\n        }\n        \n        vec4 main(vec2 pixelCoord) {\n            vec2 effectOrigin = EFFECT_ORIGIN * uResolution;\n            float maxCircleRadius = length(uResolution);\n\n            float circleSDF = 1.0 - sdCircle(pixelCoord, effectOrigin, maxCircleRadius * uProgress);\n            float shimmerRing = createStroke(0.0, maxCircleRadius * SHIMMER_RING_WIDTH_RATIO, maxCircleRadius * SHIMMER_RING_SOFTNESS, circleSDF) * SHIMMER_RING_OPACITY;\n            shimmerRing *= easeArc(uProgress);\n            \n            float distortionPixels = BACKGROUND_DISTORTION_PIXELS * uDensity;\n            vec2 distortedScreenCoord = pixelCoord + shimmerRing * normalize(pixelCoord - effectOrigin) * distortionPixels;\n            vec4 distortedScreenColor = uScreen.eval(distortedScreenCoord);\n        \n            return vec4(distortedScreenColor.rgb, 1.0);\n        }\n    "));     // Catch: Throwable -> L11
            r10.add(new Pair("duration", String.valueOf(((long) 200) + 882)));     // Catch: Throwable -> L11
            x r11 = x.f38692a;     // Catch: Throwable -> L11
            r8.setAnimationProperty(r9, r10);     // Catch: Throwable -> L11
            TransactionSmt.getInstance().startAnimation(a.a(r14));     // Catch: Throwable -> L11
            Object r12 = n.f(x.f38692a);     // Catch: Throwable -> L11
        L13:
            Throwable r15 = n.c(r12);
            if (r15 == null) goto L16;
            ILogDepend.Companion.w(a.TAG, "playRippleEffect: start ripple effect failed: " + r15.getMessage(), r15);
        L16:
            ValueAnimator r2 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            r2.setDuration(882);
            r2.setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(new SmoothInterpolator(), TimeInterpolator.class, "com.obric.aiagent.plugin"));
            r2.addUpdateListener((ValueAnimator.AnimatorUpdateListener) ZeusTransformUtils.preCheckCast(new OSGlobalEffectManager$playRippleEffect$1$3(r14, r0, r3), ValueAnimator.AnimatorUpdateListener.class, "com.obric.aiagent.plugin"));
            r2.addListener((Animator.AnimatorListener) ZeusTransformUtils.preCheckCast(new OSGlobalEffectManager$playRippleEffect$1$4(), Animator.AnimatorListener.class, "com.obric.aiagent.plugin"));
            a r16 = a.f18897a;
            a.a((Animator) ZeusTransformUtils.preCheckCast(r2, Animator.class, "com.obric.aiagent.plugin"));
            r2.start();
            return;
        L11:
            th = move-exception;
            n.a r17 = n.f38560a;
            r12 = n.f(o.a(th));
            goto L13
        }
    }

    /* JADX INFO: compiled from: OSGlobalEffectManager.kt */
    static final class b implements d.h.a.a<IBinder> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f18899a = null;

        static {
            f18899a = new b();
        }

        b() {
        }

        @Override // d.h.a.a
        public /* synthetic */ IBinder invoke() {
            return a();
        }

        public final IBinder a() {
            a r0 = a.f18897a;
            n.a r1 = n.f38560a;     // Catch: Throwable -> L5
            Object r2 = n.f(DisplayManagerSmt.getInstance().getDisplayToken((Context) ZeusTransformUtils.preCheckCast((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), 0));     // Catch: Throwable -> L5
        L7:
            Throwable r3 = n.c(r2);
            if (r3 == null) goto L11;
            ILogDepend.Companion.w(a.TAG, "playRippleEffect: get display token failed: " + r3.getMessage(), r3);
        L11:
            if (n.b(r2) == false) goto L14;
            r2 = null;
        L14:
            return (IBinder) ZeusTransformUtils.preCheckCast(r2, IBinder.class, "com.obric.aiagent.plugin");
        L5:
            th = move-exception;
            n.a r4 = n.f38560a;
            r2 = n.f(o.a(th));
            goto L7
        }
    }

    static {
        f18897a = new a();
    }

    private a() {
    }

    public static final /* synthetic */ Point a(a r2, Context r3) {
        return r2.a((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ IBinder a(f r2) {
        return b((f) ZeusTransformUtils.wrapperContextForParams(r2, f.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ void a(Animator r0) {
        f18898b = r0;
    }

    public static final /* synthetic */ Animator b() {
        return f18898b;
    }

    public final void a() {
        if (ObricProductSdk.INSTANCE.featureService().isObricOs() == true) goto L6;
        ILogDepend.Companion.i(TAG, "not play ripple effect");
        return;
    L6:
        ILogDepend.Companion.i(TAG, "play ripple effect start");
        e.f18781a.b((Runnable) ZeusTransformUtils.preCheckCast(new RunnableC0413a(), Runnable.class, "com.obric.aiagent.plugin"));
    }

    private static final IBinder b(f<? extends IBinder> r2) {
        return (IBinder) ZeusTransformUtils.preCheckCast(((f) ZeusTransformUtils.wrapperContextForParams(r2, f.class, "com.obric.aiagent.plugin")).b(), IBinder.class, "com.obric.aiagent.plugin");
    }

    private final Point a(Context r2) {
        Object r1 = ((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin")).getSystemService("window");
        d.h.b.o.a(r1, "null cannot be cast to non-null type android.view.WindowManager");
        Display r3 = ((WindowManager) ZeusTransformUtils.preCheckCast(r1, WindowManager.class, "com.obric.aiagent.plugin")).getDefaultDisplay();
        Point r4 = new Point();
        r3.getRealSize(r4);
        return r4;
    }
}
