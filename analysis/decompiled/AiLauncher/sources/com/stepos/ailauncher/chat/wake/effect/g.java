package com.stepos.ailauncher.chat.wake.effect;

import Y8.t;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.view.animation.PathInterpolator;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import s7.k;
import s7.o;
import t7.j;
import v9.C5685n;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 /2\u00020\u0001:\u00010B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\bH\u0007¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\u000b¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0015\u0010\rJ\u0017\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0019\u0010\u0013J\u000f\u0010\u001a\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u001a\u0010\u0013J\u000f\u0010\u001b\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u001b\u0010\u0013R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001cR\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u001dR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010\"\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010$\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010'\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010*\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0018\u0010-\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.¨\u00061"}, d2 = {"Lcom/stepos/ailauncher/chat/wake/effect/g;", "", "Landroid/view/View;", "view", "Lcom/stepos/ailauncher/chat/wake/effect/d;", "config", "<init>", "(Landroid/view/View;Lcom/stepos/ailauncher/chat/wake/effect/d;)V", "", "autoStopAfterMs", "fadeOutMs", "LY8/t;", "k", "(JJ)V", "", "active", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Z)V", "o", "()V", "delayMs", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "durationMs", "m", "(J)V", Const.INTENT_KEY_BACKGROUND_COMMAND, "f", "e", "Landroid/view/View;", "Lcom/stepos/ailauncher/chat/wake/effect/d;", "Ls7/o;", "host", "Ls7/o;", "Ls7/k;", "instance", "Ls7/k;", com.stepos.ailauncher.chat.util.g.REASON_RECORDING, "Z", "Landroid/os/Handler;", "handler", "Landroid/os/Handler;", "Ljava/lang/Runnable;", "autoStopRunnable", "Ljava/lang/Runnable;", "Landroid/animation/ValueAnimator;", "fadeAnimator", "Landroid/animation/ValueAnimator;", "Companion", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class g {
    private static final a Companion = new a(null);
    private static final PathInterpolator FADE_OUT_INTERPOLATOR = new PathInterpolator(0.3f, 0.0f, 0.7f, 1.0f);
    private static final float MIN_UNIFORM_EPSILON = 1.0E-4f;

    @Deprecated
    public static final String TAG = "WakeSpectrumBorder";
    private Runnable autoStopRunnable;
    private SpectrumBorderConfig config;
    private ValueAnimator fadeAnimator;
    private final Handler handler;
    private o host;
    private k instance;
    private boolean recording;
    private final View view;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/stepos/ailauncher/chat/wake/effect/g$a;", "", "<init>", "()V", "", "TAG", "Ljava/lang/String;", "Landroid/view/animation/PathInterpolator;", "FADE_OUT_INTERPOLATOR", "Landroid/view/animation/PathInterpolator;", "", "MIN_UNIFORM_EPSILON", "F", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a {
        public /* synthetic */ a(i iVar) {
            this();
        }

        public a() {
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/ailauncher/chat/wake/effect/g$b", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "LY8/t;", "onAnimationEnd", "(Landroid/animation/Animator;)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            p.i(animation, "animation");
            if (g.this.fadeAnimator == animation) {
                g.this.fadeAnimator = null;
                g.this.o();
            }
        }
    }

    public g(View view, SpectrumBorderConfig config) {
        p.i(view, "view");
        p.i(config, "config");
        this.view = view;
        this.config = config;
        this.handler = new Handler(Looper.getMainLooper());
    }

    public static final void i(g gVar, long j10) {
        gVar.autoStopRunnable = null;
        if (j10 > 0) {
            gVar.m(j10);
        } else {
            gVar.o();
        }
    }

    public static /* synthetic */ void l(g gVar, long j10, long j11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = 0;
        }
        if ((i10 & 2) != 0) {
            j11 = 0;
        }
        gVar.k(j10, j11);
    }

    public static final void n(ValueAnimator valueAnimator, k kVar, float f10, float f11, float f12, ValueAnimator animator) {
        Object objB;
        p.i(animator, "animator");
        Object animatedValue = animator.getAnimatedValue();
        p.g(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float fFloatValue = ((Float) animatedValue).floatValue();
        try {
            Result.Companion companion = Result.INSTANCE;
            kVar.g("glowIntensity", C5685n.e(f10 * fFloatValue, MIN_UNIFORM_EPSILON));
            kVar.g("glowWidth", C5685n.e(f11 * fFloatValue, MIN_UNIFORM_EPSILON));
            kVar.g("amplitude", C5685n.e(f12 * fFloatValue, MIN_UNIFORM_EPSILON));
            kVar.d(C5685n.e(fFloatValue, MIN_UNIFORM_EPSILON));
            objB = Result.b(t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            Log.w(TAG, "fadeOut setUniform failed", thE);
        }
    }

    public final void e() {
        Object objB;
        k kVar = this.instance;
        if (kVar == null) {
            return;
        }
        Float[] fArr = this.recording ? new Float[]{Float.valueOf(this.config.getRecordingGlowIntensity()), Float.valueOf(this.config.getRecordingGlowWidth()), Float.valueOf(this.config.getRecordingBorderRadius()), Float.valueOf(this.config.getRecordingAmplitude())} : new Float[]{Float.valueOf(this.config.getIdleGlowIntensity()), Float.valueOf(this.config.getIdleGlowWidth()), Float.valueOf(this.config.getIdleBorderRadius()), Float.valueOf(this.config.getIdleAmplitude())};
        float fFloatValue = fArr[0].floatValue();
        float fFloatValue2 = fArr[1].floatValue();
        float fFloatValue3 = fArr[2].floatValue();
        float fFloatValue4 = fArr[3].floatValue();
        try {
            Result.Companion companion = Result.INSTANCE;
            kVar.g("glowIntensity", fFloatValue);
            kVar.g("glowWidth", fFloatValue2);
            kVar.g("borderRadius", fFloatValue3);
            kVar.g("amplitude", fFloatValue4);
            objB = Result.b(t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            Log.w(TAG, "setUniform failed", thE);
        }
    }

    public final void f() {
        Runnable runnable = this.autoStopRunnable;
        if (runnable != null) {
            this.handler.removeCallbacks(runnable);
        }
        this.autoStopRunnable = null;
    }

    public final void g() {
        ValueAnimator valueAnimator = this.fadeAnimator;
        if (valueAnimator != null) {
            this.fadeAnimator = null;
            valueAnimator.cancel();
        }
    }

    public final void h(long delayMs, long fadeOutMs) {
        if (delayMs <= 0) {
            return;
        }
        final long jK = C5685n.k(C5685n.g(fadeOutMs, 0L), delayMs);
        Runnable runnable = new Runnable() { // from class: com.stepos.ailauncher.chat.wake.effect.e
            @Override // java.lang.Runnable
            public final void run() {
                g.i(this.f26750a, jK);
            }
        };
        this.autoStopRunnable = runnable;
        this.handler.postDelayed(runnable, delayMs - jK);
    }

    public final void j(boolean active) {
        if (this.recording == active) {
            return;
        }
        this.recording = active;
        e();
    }

    public final void k(long autoStopAfterMs, long fadeOutMs) {
        Object objB;
        f();
        if (this.instance != null) {
            e();
            h(autoStopAfterMs, fadeOutMs);
            return;
        }
        if (this.view.isAttachedToWindow() && !this.view.isHardwareAccelerated()) {
            Log.i(TAG, "SpectrumBorder skip: host view not hardware-accelerated");
            return;
        }
        try {
            o oVarC = j.c(o.INSTANCE, this.view);
            try {
                k kVarG = j.g(j.e(oVarC), t7.c.f42010a.b(), null, 2, null);
                if (kVarG == null) {
                    Log.i(TAG, "SpectrumBorder play returned null (device unsupported), release host");
                    oVarC.k();
                    return;
                }
                this.host = oVarC;
                this.instance = kVarG;
                try {
                    Result.Companion companion = Result.INSTANCE;
                    kVarG.a(60);
                    objB = Result.b(t.f7040a);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objB = Result.b(C4849c.a(th));
                }
                Throwable thE = Result.e(objB);
                if (thE != null) {
                    Log.w(TAG, "fx.setFrameRate(60) failed", thE);
                }
                e();
                h(autoStopAfterMs, fadeOutMs);
            } catch (Throwable th2) {
                Log.w(TAG, "fx.play(SpectrumBorder) failed", th2);
                oVarC.k();
            }
        } catch (Throwable th3) {
            Log.w(TAG, "MotionHost.create failed", th3);
        }
    }

    public final void m(long durationMs) {
        final k kVar = this.instance;
        if (kVar == null) {
            o();
            return;
        }
        g();
        final float recordingGlowIntensity = this.recording ? this.config.getRecordingGlowIntensity() : this.config.getIdleGlowIntensity();
        final float recordingGlowWidth = this.recording ? this.config.getRecordingGlowWidth() : this.config.getIdleGlowWidth();
        final float recordingAmplitude = this.recording ? this.config.getRecordingAmplitude() : this.config.getIdleAmplitude();
        final ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat.setDuration(durationMs);
        valueAnimatorOfFloat.setInterpolator(FADE_OUT_INTERPOLATOR);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.stepos.ailauncher.chat.wake.effect.f
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                g.n(valueAnimatorOfFloat, kVar, recordingGlowIntensity, recordingGlowWidth, recordingAmplitude, valueAnimator);
            }
        });
        valueAnimatorOfFloat.addListener(new b());
        this.fadeAnimator = valueAnimatorOfFloat;
        valueAnimatorOfFloat.start();
    }

    public final void o() {
        Object objB;
        Object objB2;
        f();
        g();
        k kVar = this.instance;
        o oVar = this.host;
        this.instance = null;
        this.host = null;
        this.recording = false;
        if (kVar != null && oVar != null) {
            try {
                Result.Companion companion = Result.INSTANCE;
                j.e(oVar).d(kVar);
                objB2 = Result.b(t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB2 = Result.b(C4849c.a(th));
            }
            Throwable thE = Result.e(objB2);
            if (thE != null) {
                Log.w(TAG, "fx.stop failed", thE);
            }
        }
        if (oVar != null) {
            try {
                Result.Companion companion3 = Result.INSTANCE;
                oVar.k();
                objB = Result.b(t.f7040a);
            } catch (Throwable th2) {
                Result.Companion companion4 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th2));
            }
            Throwable thE2 = Result.e(objB);
            if (thE2 != null) {
                Log.w(TAG, "host.release failed", thE2);
            }
        }
    }
}
