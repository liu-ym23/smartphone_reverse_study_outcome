package com.stepos.ailauncher.express.capsule;

import Y8.t;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Region;
import android.graphics.Shader;
import android.util.Log;
import android.view.AttachedSurfaceControl;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.wake.Z;
import java.util.ArrayList;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import r9.C5227b;
import v9.C5685n;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 82\u00020\u0001:\u00019B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0007\u0010\bJ/\u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\tH\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0014¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0014\u001a\u00020\u0006¢\u0006\u0004\b\u0014\u0010\bJ\r\u0010\u0015\u001a\u00020\u0006¢\u0006\u0004\b\u0015\u0010\bJ\u000f\u0010\u0016\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0016\u0010\bJ\u000f\u0010\u0017\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0017\u0010\bJ\u001f\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u000b\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001c\u0010\bJ\u000f\u0010\u001d\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001d\u0010\bJ\u000f\u0010\u001e\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001e\u0010\bJ\u001f\u0010!\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\tH\u0002¢\u0006\u0004\b!\u0010\"J\u0017\u0010#\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\tH\u0002¢\u0006\u0004\b#\u0010$R\u0014\u0010&\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010)\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010,\u001a\u00020+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010/\u001a\u00020.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00100R\u0016\u00102\u001a\u00020.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00100R\u0016\u00103\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0018\u00106\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107¨\u0006:"}, d2 = {"Lcom/stepos/ailauncher/express/capsule/q;", "Landroid/view/View;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "LY8/t;", "onAttachedToWindow", "()V", "", "w", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "oldw", "oldh", "onSizeChanged", "(IIII)V", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "p", "t", "k", "u", "", "from", "to", "(FF)V", "l", "m", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "progress", "heightPx", "o", "(FI)F", "n", "(I)F", "Landroid/graphics/Paint;", "paint", "Landroid/graphics/Paint;", "Lcom/stepos/ailauncher/chat/wake/Z;", "wakeBlur", "Lcom/stepos/ailauncher/chat/wake/Z;", "Landroid/view/View$OnLayoutChangeListener;", "layoutListener", "Landroid/view/View$OnLayoutChangeListener;", "", "logged", "Z", "released", "appearStarted", "appearProgress", "F", "Landroid/animation/ValueAnimator;", "appearAnim", "Landroid/animation/ValueAnimator;", "Companion", Const.INTENT_KEY_APIKEY, "express_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
@SuppressLint({"ViewConstructor"})
/* loaded from: classes3.dex */
public final class q extends View {
    private static final int BLUR_BANDS = 32;
    public static final float BLUR_END_DP = 14.0f;
    private static final long FADE_MS = 200;
    public static final int FEATHER_DP = 20;
    public static final float GRADIENT_FRACTION = 0.3846154f;
    private static final int MASK_END = -435944444;
    private static final int MASK_MID = 1929643012;
    private static final int MASK_START = 0;
    private static final String TAG = "ExpressCapsule";
    private ValueAnimator appearAnim;
    private float appearProgress;
    private boolean appearStarted;
    private final View.OnLayoutChangeListener layoutListener;
    private boolean logged;
    private final Paint paint;
    private boolean released;
    private final Z wakeBlur;
    private static final AccelerateInterpolator APPEAR_INTERPOLATOR = new AccelerateInterpolator();

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/ailauncher/express/capsule/q$b", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "LY8/t;", "onAnimationEnd", "(Landroid/animation/Animator;)V", "express_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            kotlin.jvm.internal.p.i(animation, "animation");
            if (q.this.released || q.this.appearProgress > 0.0f) {
                return;
            }
            q.this.m();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(Context context) {
        super(context);
        kotlin.jvm.internal.p.i(context, "context");
        Paint paint = new Paint(1);
        this.paint = paint;
        this.wakeBlur = new Z(this);
        View.OnLayoutChangeListener onLayoutChangeListener = new View.OnLayoutChangeListener() { // from class: com.stepos.ailauncher.express.capsule.m
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
                q.q(this.f27108a, view, i10, i11, i12, i13, i14, i15, i16, i17);
            }
        };
        this.layoutListener = onLayoutChangeListener;
        setImportantForAccessibility(2);
        setClickable(false);
        setFocusable(false);
        paint.setAlpha(0);
        setBackgroundColor(0);
        addOnLayoutChangeListener(onLayoutChangeListener);
    }

    public static final void i(q qVar, ValueAnimator anim) {
        kotlin.jvm.internal.p.i(anim, "anim");
        if (qVar.released) {
            return;
        }
        Object animatedValue = anim.getAnimatedValue();
        kotlin.jvm.internal.p.g(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float fFloatValue = ((Float) animatedValue).floatValue();
        qVar.appearProgress = fFloatValue;
        qVar.paint.setAlpha(C5685n.n((int) (fFloatValue * 255.0f), 0, 255));
        if (qVar.appearProgress <= 0.0f) {
            qVar.m();
        } else {
            qVar.j();
        }
        qVar.invalidate();
    }

    public static final void q(q qVar, View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        qVar.j();
    }

    public static final void r(q qVar) {
        qVar.k();
        qVar.u();
    }

    public static final void s(q qVar) {
        qVar.k();
        if (qVar.appearStarted) {
            qVar.j();
        }
    }

    public final void h(float from, float to) {
        l();
        this.appearStarted = true;
        this.appearProgress = from;
        this.paint.setAlpha(C5685n.n((int) (255.0f * from), 0, 255));
        invalidate();
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(from, to);
        valueAnimatorOfFloat.setDuration(200L);
        valueAnimatorOfFloat.setInterpolator(APPEAR_INTERPOLATOR);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.stepos.ailauncher.express.capsule.p
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                q.i(this.f27111a, valueAnimator);
            }
        });
        if (to <= 0.0f) {
            valueAnimatorOfFloat.addListener(new b());
        }
        valueAnimatorOfFloat.start();
        this.appearAnim = valueAnimatorOfFloat;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void j() {
        int i10;
        float f10;
        int iB;
        if (this.released || !isAttachedToWindow() || getWidth() <= 0 || getHeight() <= 0) {
            return;
        }
        float f11 = 0.0f;
        if (this.appearProgress <= 0.0f) {
            if (this.appearStarted) {
                m();
                return;
            }
            return;
        }
        if (!this.wakeBlur.g()) {
            if (this.logged) {
                return;
            }
            Log.w(TAG, "bottom blur regions unavailable, keep color fade only");
            this.logged = true;
            return;
        }
        float f12 = getResources().getDisplayMetrics().density * 14.0f;
        int height = getHeight();
        int width = getWidth();
        ArrayList arrayList = new ArrayList(32);
        float f13 = 1.0f;
        float fM = C5685n.m(this.appearProgress, 0.0f, 1.0f);
        int i11 = 0;
        int i12 = 0;
        while (i12 < 32) {
            int i13 = (height * i12) / 32;
            int i14 = i12 + 1;
            int i15 = (height * i14) / 32;
            if (i15 <= i13 || (iB = C5227b.b(o(C5685n.m(((i13 + i15) / 2.0f) / height, f11, f13), height) * f12 * this.appearProgress)) < 1) {
                i10 = i11;
                f10 = f13;
            } else {
                f10 = f13;
                i10 = i11;
                arrayList.add(this.wakeBlur.c(iB, fM, 0.0f, 0, i13, width, i15));
            }
            i11 = i10;
            i12 = i14;
            f13 = f10;
            f11 = 0.0f;
        }
        int i16 = i11;
        int i17 = this.appearProgress >= f13 ? 1 : i16;
        Z.b(this.wakeBlur, (float[][]) arrayList.toArray(new float[i16][]), (i17 == 0 || this.logged) ? i16 : 1, false, 4, null);
        if (i17 == 0 || this.logged) {
            return;
        }
        this.logged = true;
        Log.d(TAG, "wake blur strip " + width + "x" + height + " regions=" + arrayList.size());
    }

    public final void k() {
        t tVar;
        try {
            Result.Companion companion = Result.INSTANCE;
            AttachedSurfaceControl rootSurfaceControl = getRootSurfaceControl();
            if (rootSurfaceControl != null) {
                rootSurfaceControl.setTouchableRegion(new Region());
                tVar = t.f7040a;
            } else {
                tVar = null;
            }
            Result.b(tVar);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
    }

    public final void l() {
        ValueAnimator valueAnimator = this.appearAnim;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.appearAnim = null;
    }

    public final void m() {
        if (isAttachedToWindow()) {
            this.wakeBlur.e();
        }
    }

    public final float n(int heightPx) {
        return C5685n.m((20 * getResources().getDisplayMetrics().density) / C5685n.f(heightPx, 1), 0.0f, 0.2f);
    }

    public final float o(float progress, int heightPx) {
        float fN = n(heightPx);
        float fM = C5685n.m(progress, 0.0f, 1.0f);
        if (fM <= fN) {
            return 0.0f;
        }
        float fM2 = C5685n.m((fM - fN) / (1.0f - fN), 0.0f, 1.0f);
        return fM2 * fM2 * (3.0f - (fM2 * 2.0f));
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        post(new Runnable() { // from class: com.stepos.ailauncher.express.capsule.o
            @Override // java.lang.Runnable
            public final void run() {
                q.r(this.f27110a);
            }
        });
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        kotlin.jvm.internal.p.i(canvas, "canvas");
        canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.paint);
    }

    @Override // android.view.View
    public void onSizeChanged(int w10, int h10, int oldw, int oldh) {
        super.onSizeChanged(w10, h10, oldw, oldh);
        if (h10 <= 0) {
            return;
        }
        float fN = n(h10);
        float fM = C5685n.m(0.52f + fN, 0.4f + fN, 0.68f);
        Paint paint = this.paint;
        float f10 = h10;
        int i10 = MASK_START;
        paint.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, f10, new int[]{i10, i10, MASK_MID, MASK_END}, new float[]{0.0f, fN, fM, 1.0f}, Shader.TileMode.CLAMP));
        post(new Runnable() { // from class: com.stepos.ailauncher.express.capsule.n
            @Override // java.lang.Runnable
            public final void run() {
                q.s(this.f27109a);
            }
        });
    }

    public final void p() {
        animate().cancel();
        if (this.released) {
            return;
        }
        float fM = C5685n.m(this.appearProgress, 0.0f, 1.0f);
        if (fM > 0.0f && isAttachedToWindow()) {
            h(fM, 0.0f);
            return;
        }
        l();
        this.paint.setAlpha(0);
        m();
        invalidate();
    }

    public final void t() {
        l();
        animate().cancel();
        this.released = true;
        removeOnLayoutChangeListener(this.layoutListener);
        m();
    }

    public final void u() {
        if (this.released || this.appearStarted) {
            return;
        }
        h(0.0f, 1.0f);
    }
}
