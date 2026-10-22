package com.stepos.ailauncher.chat.voice.longpress;

import android.animation.ValueAnimator;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voice.motionkit.C3080u;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000_\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u00011\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\u000b¢\u0006\u0004\b\u0010\u0010\u000fJ\u0015\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0005¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0014\u001a\u00020\u000b¢\u0006\u0004\b\u0014\u0010\u000fJ\r\u0010\u0015\u001a\u00020\u000b¢\u0006\u0004\b\u0015\u0010\u000fJ\r\u0010\u0016\u001a\u00020\u000b¢\u0006\u0004\b\u0016\u0010\u000fJ\u0017\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0018\u0010\u0013J\u000f\u0010\u0019\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0019\u0010\u000fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001aR\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u001bR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\u001f\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010!\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010 R\u0016\u0010\"\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010 R\u0016\u0010#\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010&\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010)\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010,\u001a\u00020+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0014\u0010/\u001a\u00020.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0014\u00102\u001a\u0002018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0014\u00105\u001a\u0002048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106¨\u00067"}, d2 = {"Lcom/stepos/ailauncher/chat/voice/longpress/q;", "", "Landroid/view/ViewGroup;", "mainInput", "Lkotlin/Function0;", "", "cornerRadiusDp", "<init>", "(Landroid/view/ViewGroup;Lp9/a;)V", "", "cancel", "LY8/t;", "m", "(Z)V", "k", "()V", "r", "volume", "o", "(F)V", "l", "q", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "progress", Const.INTENT_KEY_BACKGROUND_COMMAND, "p", "Landroid/view/ViewGroup;", "Lp9/a;", "Lcom/stepos/ailauncher/chat/voice/motionkit/u;", "animation", "Lcom/stepos/ailauncher/chat/voice/motionkit/u;", "pendingStart", "Z", "isCancelState", "releasing", "cancelProgress", "F", "Landroid/animation/ValueAnimator;", "cancelAnimator", "Landroid/animation/ValueAnimator;", "Landroid/view/animation/PathInterpolator;", "cancelInterpolator", "Landroid/view/animation/PathInterpolator;", "Lcom/stepos/ailauncher/chat/voice/longpress/V;", "amplitude", "Lcom/stepos/ailauncher/chat/voice/longpress/V;", "Landroid/view/View$OnLayoutChangeListener;", "boundsListener", "Landroid/view/View$OnLayoutChangeListener;", "com/stepos/ailauncher/chat/voice/longpress/q$a", "attachListener", "Lcom/stepos/ailauncher/chat/voice/longpress/q$a;", "Ljava/lang/Runnable;", "cleanup", "Ljava/lang/Runnable;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.chat.voice.longpress.q, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3052q {
    private final V amplitude;
    private C3080u animation;
    private final a attachListener;
    private final View.OnLayoutChangeListener boundsListener;
    private ValueAnimator cancelAnimator;
    private final PathInterpolator cancelInterpolator;
    private float cancelProgress;
    private final Runnable cleanup;
    private final InterfaceC5063a<Float> cornerRadiusDp;
    private boolean isCancelState;
    private final ViewGroup mainInput;
    private boolean pendingStart;
    private boolean releasing;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"com/stepos/ailauncher/chat/voice/longpress/q$a", "Landroid/view/View$OnAttachStateChangeListener;", "Landroid/view/View;", "v", "LY8/t;", "onViewAttachedToWindow", "(Landroid/view/View;)V", "onViewDetachedFromWindow", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.voice.longpress.q$a */
    public static final class a implements View.OnAttachStateChangeListener {
        public a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View v10) {
            kotlin.jvm.internal.p.i(v10, "v");
            C3052q.this.p();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View v10) {
            kotlin.jvm.internal.p.i(v10, "v");
            C3052q.this.q();
        }
    }

    public C3052q(ViewGroup mainInput, InterfaceC5063a<Float> cornerRadiusDp) {
        kotlin.jvm.internal.p.i(mainInput, "mainInput");
        kotlin.jvm.internal.p.i(cornerRadiusDp, "cornerRadiusDp");
        this.mainInput = mainInput;
        this.cornerRadiusDp = cornerRadiusDp;
        this.cancelInterpolator = new PathInterpolator(0.3f, 0.0f, 0.66f, 1.0f);
        this.amplitude = new V(mainInput, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.voice.longpress.m
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return C3052q.f(this.f26477a, ((Float) obj).floatValue());
            }
        });
        View.OnLayoutChangeListener onLayoutChangeListener = new View.OnLayoutChangeListener() { // from class: com.stepos.ailauncher.chat.voice.longpress.n
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
                C3052q.h(this.f26479a, view, i10, i11, i12, i13, i14, i15, i16, i17);
            }
        };
        this.boundsListener = onLayoutChangeListener;
        a aVar = new a();
        this.attachListener = aVar;
        this.cleanup = new Runnable() { // from class: com.stepos.ailauncher.chat.voice.longpress.o
            @Override // java.lang.Runnable
            public final void run() {
                C3052q.i(this.f26480a);
            }
        };
        mainInput.addOnLayoutChangeListener(onLayoutChangeListener);
        mainInput.addOnAttachStateChangeListener(aVar);
    }

    public static final Y8.t f(C3052q c3052q, float f10) {
        C3080u c3080u = c3052q.animation;
        if (c3080u != null) {
            c3080u.n(f10);
        }
        return Y8.t.f7040a;
    }

    public static final void h(C3052q c3052q, View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        c3052q.r();
        c3052q.p();
    }

    public static final void i(C3052q c3052q) {
        c3052q.q();
    }

    public static final void n(C3052q c3052q, ValueAnimator it) {
        kotlin.jvm.internal.p.i(it, "it");
        Object animatedValue = it.getAnimatedValue();
        kotlin.jvm.internal.p.g(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        c3052q.g(((Float) animatedValue).floatValue());
    }

    public final void g(float progress) {
        this.cancelProgress = progress;
        C3080u c3080u = this.animation;
        if (c3080u != null) {
            c3080u.k(progress);
        }
    }

    public final void j() {
        q();
        this.mainInput.removeOnLayoutChangeListener(this.boundsListener);
        this.mainInput.removeOnAttachStateChangeListener(this.attachListener);
    }

    public final void k() {
        q();
        this.pendingStart = true;
        p();
    }

    public final void l() {
        if (this.releasing) {
            return;
        }
        this.releasing = true;
        this.pendingStart = false;
        this.amplitude.i();
        C3080u c3080u = this.animation;
        if (c3080u != null) {
            c3080u.f();
        }
        this.mainInput.removeCallbacks(this.cleanup);
        this.mainInput.postDelayed(this.cleanup, 433L);
    }

    public final void m(boolean cancel) {
        if (this.releasing || this.isCancelState == cancel) {
            return;
        }
        this.isCancelState = cancel;
        ValueAnimator valueAnimator = this.cancelAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.cancelAnimator = null;
        float f10 = cancel ? 1.0f : 0.0f;
        if (this.animation == null || !ValueAnimator.areAnimatorsEnabled()) {
            g(f10);
            return;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.cancelProgress, f10);
        valueAnimatorOfFloat.setDuration(200L);
        valueAnimatorOfFloat.setInterpolator(this.cancelInterpolator);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.stepos.ailauncher.chat.voice.longpress.p
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                C3052q.n(this.f26481a, valueAnimator2);
            }
        });
        valueAnimatorOfFloat.start();
        this.cancelAnimator = valueAnimatorOfFloat;
    }

    public final void o(float volume) {
        this.amplitude.g(volume);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void p() {
        Object objB;
        if (!this.pendingStart || !this.mainInput.isAttachedToWindow() || this.mainInput.getWidth() <= 0 || this.mainInput.getHeight() <= 0) {
            return;
        }
        this.pendingStart = false;
        try {
            Result.Companion companion = Result.INSTANCE;
            Y8.t tVar = null;
            this.animation = new C3080u(this.mainInput, 0 == true ? 1 : 0, 2, 0 == true ? 1 : 0);
            g(this.cancelProgress);
            r();
            this.amplitude.h();
            C3080u c3080u = this.animation;
            if (c3080u != null) {
                c3080u.o();
                tVar = Y8.t.f7040a;
            }
            objB = Result.b(tVar);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            Log.e("InputBarLongPress", "Unable to start InputBar effect", thE);
            q();
        }
    }

    public final void q() {
        this.pendingStart = false;
        ValueAnimator valueAnimator = this.cancelAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.cancelAnimator = null;
        this.mainInput.removeCallbacks(this.cleanup);
        this.amplitude.i();
        C3080u c3080u = this.animation;
        if (c3080u != null) {
            c3080u.e();
        }
        this.animation = null;
        this.releasing = false;
        this.isCancelState = false;
        this.cancelProgress = 0.0f;
    }

    public final void r() {
        C3080u c3080u = this.animation;
        if (c3080u != null) {
            c3080u.s(this.mainInput.getWidth(), this.mainInput.getHeight());
        }
        C3080u c3080u2 = this.animation;
        if (c3080u2 != null) {
            c3080u2.l(this.cornerRadiusDp.invoke().floatValue() * this.mainInput.getResources().getDisplayMetrics().density);
        }
    }
}
