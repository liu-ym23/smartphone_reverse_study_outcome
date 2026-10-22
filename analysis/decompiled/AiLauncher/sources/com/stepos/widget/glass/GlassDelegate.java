package com.stepos.widget.glass;

import A7.C0743k;
import A7.C0746n;
import Z8.C1172u;
import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Trace;
import android.util.Log;
import android.view.View;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.motionkit.fx.material.capability.BlurGradient;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import com.stepos.widget.internal.StepOSTrace;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import y7.G;

@Metadata(d1 = {"\u0000\u0093\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\f*\u0001W\b\u0001\u0018\u0000 i2\u00020\u0001:\u0001iB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\u0004\u0018\u00010\t*\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ6\u0010\u0014\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\f2\b\b\u0001\u0010\u000f\u001a\u00020\u000e2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u0010H\u0082\b¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0019\u001a\u00020\u0016H\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001b\u001a\u00020\u0016H\u0000¢\u0006\u0004\b\u001a\u0010\u0018J\u000f\u0010\u001d\u001a\u00020\u0016H\u0000¢\u0006\u0004\b\u001c\u0010\u0018J+\u0010$\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u001e2\b\b\u0001\u0010\u000f\u001a\u00020\u000e2\b\u0010!\u001a\u0004\u0018\u00010 H\u0000¢\u0006\u0004\b\"\u0010#J\u000f\u0010'\u001a\u00020\u0013H\u0000¢\u0006\u0004\b%\u0010&J+\u0010,\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\f2\b\b\u0001\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010)\u001a\u00020(H\u0000¢\u0006\u0004\b*\u0010+J5\u0010.\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\f2\b\b\u0001\u0010\u000f\u001a\u00020\u000e2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u0010H\u0000¢\u0006\u0004\b-\u0010\u0015J5\u00103\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\f2\b\b\u0001\u0010\u000f\u001a\u00020\u000e2\b\b\u0001\u0010/\u001a\u00020\u000e2\b\b\u0003\u00100\u001a\u00020\fH\u0000¢\u0006\u0004\b1\u00102Js\u0010>\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\f2\b\b\u0001\u0010\u000f\u001a\u00020\u000e2\b\b\u0001\u0010/\u001a\u00020\u000e2\b\b\u0002\u00105\u001a\u0002042\n\b\u0002\u00106\u001a\u0004\u0018\u00010\f2\b\b\u0003\u00107\u001a\u00020\f2\b\b\u0003\u00108\u001a\u00020\f2\b\b\u0003\u00109\u001a\u00020\f2\b\b\u0003\u0010:\u001a\u00020\u000e2\b\b\u0002\u0010;\u001a\u000204H\u0000¢\u0006\u0004\b<\u0010=J\u0019\u0010A\u001a\u00020\u00162\b\b\u0001\u0010\u000f\u001a\u00020\u000eH\u0000¢\u0006\u0004\b?\u0010@J\u000f\u0010C\u001a\u00020\u0016H\u0000¢\u0006\u0004\bB\u0010\u0018R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010DR\u0018\u0010F\u001a\u0004\u0018\u00010E8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010H\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010IR\u0014\u0010K\u001a\u00020J8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bK\u0010LR\u0014\u0010N\u001a\u00020M8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bN\u0010OR*\u0010Q\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010P8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\u0014\u0010X\u001a\u00020W8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bX\u0010YR$\u0010[\u001a\u00020\u00132\u0006\u0010Z\u001a\u00020\u00138\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\b[\u0010I\u001a\u0004\b\\\u0010&R0\u0010_\u001a\b\u0012\u0004\u0012\u00020^0]2\f\u0010Z\u001a\b\u0012\u0004\u0012\u00020^0]8\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\b_\u0010`\u001a\u0004\ba\u0010bR\u0014\u0010d\u001a\u00020\u00138@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bc\u0010&R\u0014\u0010f\u001a\u00020\u00138@X\u0080\u0004¢\u0006\u0006\u001a\u0004\be\u0010&R\u0014\u0010h\u001a\u00020\u00138@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bg\u0010&¨\u0006j"}, d2 = {"Lcom/stepos/widget/glass/GlassDelegate;", "", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "activityContentView", "()Landroid/view/View;", "Landroid/content/Context;", "Landroid/app/Activity;", "getActivity", "(Landroid/content/Context;)Landroid/app/Activity;", "", "scope", "", "cornerRadiusPx", "Lkotlin/Function1;", "Ly7/B;", "applyEffect", "", "commit", "(IFLp9/l;)Z", "LY8/t;", "showCover$StepOSWidget_release", "()V", "showCover", "cancelCover$StepOSWidget_release", "cancelCover", "scheduleCoverReveal$StepOSWidget_release", "scheduleCoverReveal", "Landroid/graphics/Canvas;", "canvas", "Landroid/graphics/drawable/Drawable;", "fallback", "drawCoverIfPending$StepOSWidget_release", "(Landroid/graphics/Canvas;FLandroid/graphics/drawable/Drawable;)V", "drawCoverIfPending", "retainOnlyIfRealGlass$StepOSWidget_release", "()Z", "retainOnlyIfRealGlass", "Ly7/o;", "effect", "apply$StepOSWidget_release", "(IFLy7/o;)Z", "apply", "applyCustom$StepOSWidget_release", "applyCustom", "blurRadius", "tintColor", "applyBlurOnly$StepOSWidget_release", "(IFFI)Z", "applyBlurOnly", "Lcom/stepos/motionkit/fx/material/capability/BlurGradient;", "direction", "gradientScale", "startColor", "middleColor", "endColor", "colorMidpoint", "colorDirection", "applyGradientBlur$StepOSWidget_release", "(IFFLcom/stepos/motionkit/fx/material/capability/BlurGradient;Ljava/lang/Integer;IIIFLcom/stepos/motionkit/fx/material/capability/BlurGradient;)Z", "applyGradientBlur", "updateCornerRadius$StepOSWidget_release", "(F)V", "updateCornerRadius", "release$StepOSWidget_release", "release", "Landroid/view/View;", "Ly7/E;", "handle", "Ly7/E;", "coverPending", "Z", "Landroid/graphics/Paint;", "coverPaint", "Landroid/graphics/Paint;", "Ljava/lang/Runnable;", "revealCoverRunnable", "Ljava/lang/Runnable;", "Lkotlin/Function0;", "onCoverRevealedListener", "Lp9/a;", "getOnCoverRevealedListener$StepOSWidget_release", "()Lp9/a;", "setOnCoverRevealedListener$StepOSWidget_release", "(Lp9/a;)V", "com/stepos/widget/glass/GlassDelegate$detachReleaseListener$1", "detachReleaseListener", "Lcom/stepos/widget/glass/GlassDelegate$detachReleaseListener$1;", UxipConstants.f30680s, "isActive", "isActive$StepOSWidget_release", "", "", "activeIds", "Ljava/util/Set;", "getActiveIds$StepOSWidget_release", "()Ljava/util/Set;", "isCoverPending$StepOSWidget_release", "isCoverPending", "getHasHandle$StepOSWidget_release", "hasHandle", "getHasRealGlass$StepOSWidget_release", "hasRealGlass", "Companion", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GlassDelegate {
    private static final String ID_GLASS_PREFIX = "glass_";
    public static final long SUBSEQUENT_GLASS_REVEAL_DELAY_MS = 48;
    private static final String TAG = "StepOSGlass";
    private static long applyCount;
    private static int liveHandles;
    private Set<String> activeIds;
    private final Paint coverPaint;
    private boolean coverPending;
    private final GlassDelegate$detachReleaseListener$1 detachReleaseListener;
    private y7.E handle;
    private boolean isActive;
    private InterfaceC5063a<Y8.t> onCoverRevealedListener;
    private final Runnable revealCoverRunnable;
    private final View view;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [android.view.View$OnAttachStateChangeListener, com.stepos.widget.glass.GlassDelegate$detachReleaseListener$1] */
    public GlassDelegate(View view) {
        kotlin.jvm.internal.p.i(view, "view");
        this.view = view;
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.FILL);
        this.coverPaint = paint;
        this.revealCoverRunnable = new Runnable() { // from class: com.stepos.widget.glass.b
            @Override // java.lang.Runnable
            public final void run() {
                GlassDelegate.revealCoverRunnable$lambda$1(this.f31218a);
            }
        };
        ?? r02 = new View.OnAttachStateChangeListener() { // from class: com.stepos.widget.glass.GlassDelegate$detachReleaseListener$1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View v10) {
                kotlin.jvm.internal.p.i(v10, "v");
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View v10) {
                kotlin.jvm.internal.p.i(v10, "v");
                this.this$0.release$StepOSWidget_release();
            }
        };
        this.detachReleaseListener = r02;
        view.addOnAttachStateChangeListener(r02);
        this.activeIds = Z8.Y.e();
    }

    private final View activityContentView() {
        Context context = this.view.getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        Activity activity = getActivity(context);
        if (activity == null) {
            return null;
        }
        return activity.findViewById(R.id.content);
    }

    public static /* synthetic */ boolean apply$StepOSWidget_release$default(GlassDelegate glassDelegate, int i10, float f10, y7.o oVar, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            oVar = y7.o.INSTANCE.i();
        }
        return glassDelegate.apply$StepOSWidget_release(i10, f10, oVar);
    }

    public static /* synthetic */ boolean applyBlurOnly$StepOSWidget_release$default(GlassDelegate glassDelegate, int i10, float f10, float f11, int i11, int i12, Object obj) {
        if ((i12 & 8) != 0) {
            i11 = 0;
        }
        return glassDelegate.applyBlurOnly$StepOSWidget_release(i10, f10, f11, i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t applyBlurOnly$lambda$7$lambda$5(float f10, int i10, int i11, C0746n apply) {
        kotlin.jvm.internal.p.i(apply, "$this$apply");
        apply.n(f10);
        if (1 <= i10 && i10 < 255) {
            apply.o(i11);
        }
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t applyBlurOnly$lambda$7$lambda$6(int i10, C0743k apply) {
        kotlin.jvm.internal.p.i(apply, "$this$apply");
        apply.f(C1172u.e(Y8.j.a(1, Integer.valueOf(i10))));
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t applyGradientBlur$lambda$10$lambda$9(float f10, BlurGradient blurGradient, Integer num, int i10, int i11, int i12, float f11, BlurGradient blurGradient2, A7.B apply) {
        kotlin.jvm.internal.p.i(apply, "$this$apply");
        apply.n(f10);
        apply.z(blurGradient);
        if (num != null) {
            apply.B(num.intValue());
        }
        apply.D(i10);
        apply.C(i11);
        apply.A(i12);
        apply.y(f11);
        apply.x(blurGradient2);
        return Y8.t.f7040a;
    }

    private final boolean commit(int scope, float cornerRadiusPx, InterfaceC5074l<? super y7.B, y7.B> applyEffect) {
        Object objB;
        Set<String> setE;
        List<String> listD;
        StepOSTrace stepOSTrace = StepOSTrace.INSTANCE;
        Trace.beginSection("StepOS:GlassDelegate.apply");
        try {
            release$StepOSWidget_release();
            try {
                Result.Companion companion = Result.INSTANCE;
                objB = Result.b(applyEffect.invoke(y7.H.a(s7.p.f40121a, this.view).x(scope == 1).w(cornerRadiusPx)).u());
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Throwable thE = Result.e(objB);
            if (thE != null) {
                Log.w(TAG, "glass commit failed on " + this.view.getClass().getSimpleName(), thE);
                objB = null;
            }
            y7.E e10 = (y7.E) objB;
            this.handle = e10;
            this.isActive = (e10 != null ? e10.c() : 0) > 0;
            if (e10 == null || (listD = e10.d()) == null || (setE = Z8.F.r1(listD)) == null) {
                setE = Z8.Y.e();
            }
            this.activeIds = setE;
            String simpleName = this.view.getClass().getSimpleName();
            int iIdentityHashCode = System.identityHashCode(this.view);
            boolean z10 = this.isActive;
            int iC = e10 != null ? e10.c() : 0;
            Log.i(TAG, "commit " + simpleName + Const.STR_MART_WELL + iIdentityHashCode + " active=" + z10 + " count=" + iC + " ids=" + this.activeIds + " live=" + liveHandles + " size=" + this.view.getWidth() + "x" + this.view.getHeight());
            if (e10 != null) {
                liveHandles++;
                StepOSTrace stepOSTrace2 = StepOSTrace.INSTANCE;
                stepOSTrace2.counter("glass.liveHandles", liveHandles);
                long j10 = applyCount + 1;
                applyCount = j10;
                stepOSTrace2.counter("glass.applyCount", j10);
            }
            if (!this.isActive) {
                Log.i(TAG, "glass inactive on " + this.view.getClass().getSimpleName() + "（scope=" + scope + "）—— 已降级，改用兜底背景。排障见 MotionKit 文档第 5、6 章");
            }
            boolean z11 = this.isActive;
            kotlin.jvm.internal.n.b(1);
            Trace.endSection();
            kotlin.jvm.internal.n.a(1);
            return z11;
        } catch (Throwable th2) {
            kotlin.jvm.internal.n.b(1);
            Trace.endSection();
            kotlin.jvm.internal.n.a(1);
            throw th2;
        }
    }

    private final Activity getActivity(Context context) {
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void revealCoverRunnable$lambda$1(GlassDelegate glassDelegate) {
        if (glassDelegate.coverPending) {
            glassDelegate.coverPending = false;
            glassDelegate.view.invalidate();
            InterfaceC5063a<Y8.t> interfaceC5063a = glassDelegate.onCoverRevealedListener;
            if (interfaceC5063a != null) {
                interfaceC5063a.invoke();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void scheduleCoverReveal$lambda$2(GlassDelegate glassDelegate) {
        glassDelegate.revealCoverRunnable.run();
    }

    public final boolean apply$StepOSWidget_release(int scope, float cornerRadiusPx, y7.o effect) {
        Object objB;
        Set<String> setE;
        List<String> listD;
        kotlin.jvm.internal.p.i(effect, "effect");
        StepOSTrace stepOSTrace = StepOSTrace.INSTANCE;
        Trace.beginSection("StepOS:GlassDelegate.apply");
        try {
            release$StepOSWidget_release();
            try {
                Result.Companion companion = Result.INSTANCE;
                y7.B bW = y7.H.a(s7.p.f40121a, this.view).x(scope == 1).w(cornerRadiusPx);
                GlassCustomizer glassCustomizerForSmallPreset$StepOSWidget_release = StepOSGlassPresets.INSTANCE.forSmallPreset$StepOSWidget_release(effect, this.view.getResources().getDisplayMetrics().density);
                objB = Result.b((glassCustomizerForSmallPreset$StepOSWidget_release != null ? glassCustomizerForSmallPreset$StepOSWidget_release.customize(bW) : bW.i(effect)).u());
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Throwable thE = Result.e(objB);
            if (thE != null) {
                Log.w(TAG, "glass commit failed on " + this.view.getClass().getSimpleName(), thE);
                objB = null;
            }
            y7.E e10 = (y7.E) objB;
            this.handle = e10;
            this.isActive = (e10 != null ? e10.c() : 0) > 0;
            if (e10 == null || (listD = e10.d()) == null || (setE = Z8.F.r1(listD)) == null) {
                setE = Z8.Y.e();
            }
            this.activeIds = setE;
            String simpleName = this.view.getClass().getSimpleName();
            int iIdentityHashCode = System.identityHashCode(this.view);
            boolean z10 = this.isActive;
            int iC = e10 != null ? e10.c() : 0;
            Log.i(TAG, "commit " + simpleName + Const.STR_MART_WELL + iIdentityHashCode + " active=" + z10 + " count=" + iC + " ids=" + this.activeIds + " live=" + liveHandles + " size=" + this.view.getWidth() + "x" + this.view.getHeight());
            if (e10 != null) {
                liveHandles++;
                StepOSTrace stepOSTrace2 = StepOSTrace.INSTANCE;
                stepOSTrace2.counter("glass.liveHandles", liveHandles);
                long j10 = applyCount + 1;
                applyCount = j10;
                stepOSTrace2.counter("glass.applyCount", j10);
            }
            if (!this.isActive) {
                Log.i(TAG, "glass inactive on " + this.view.getClass().getSimpleName() + "（scope=" + scope + "）—— 已降级，改用兜底背景。排障见 MotionKit 文档第 5、6 章");
            }
            return this.isActive;
        } finally {
            Trace.endSection();
        }
    }

    public final boolean applyBlurOnly$StepOSWidget_release(int scope, float cornerRadiusPx, final float blurRadius, final int tintColor) {
        Object objB;
        Set<String> setE;
        List<String> listD;
        StepOSTrace stepOSTrace = StepOSTrace.INSTANCE;
        Trace.beginSection("StepOS:GlassDelegate.apply");
        try {
            release$StepOSWidget_release();
            try {
                Result.Companion companion = Result.INSTANCE;
                y7.B bW = y7.H.a(s7.p.f40121a, this.view).x(scope == 1).w(cornerRadiusPx);
                final int iAlpha = Color.alpha(tintColor);
                y7.G g10 = y7.G.f43879a;
                y7.B bJ = bW.j(g10.b(), new InterfaceC5074l() { // from class: com.stepos.widget.glass.c
                    @Override // p9.InterfaceC5074l
                    public final Object invoke(Object obj) {
                        return GlassDelegate.applyBlurOnly$lambda$7$lambda$5(blurRadius, iAlpha, tintColor, (C0746n) obj);
                    }
                });
                if (iAlpha == 255) {
                    bJ = bJ.j(g10.a(), new InterfaceC5074l() { // from class: com.stepos.widget.glass.d
                        @Override // p9.InterfaceC5074l
                        public final Object invoke(Object obj) {
                            return GlassDelegate.applyBlurOnly$lambda$7$lambda$6(tintColor, (C0743k) obj);
                        }
                    });
                }
                objB = Result.b(bJ.u());
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Throwable thE = Result.e(objB);
            if (thE != null) {
                Log.w(TAG, "glass commit failed on " + this.view.getClass().getSimpleName(), thE);
                objB = null;
            }
            y7.E e10 = (y7.E) objB;
            this.handle = e10;
            this.isActive = (e10 != null ? e10.c() : 0) > 0;
            if (e10 == null || (listD = e10.d()) == null || (setE = Z8.F.r1(listD)) == null) {
                setE = Z8.Y.e();
            }
            this.activeIds = setE;
            String simpleName = this.view.getClass().getSimpleName();
            int iIdentityHashCode = System.identityHashCode(this.view);
            boolean z10 = this.isActive;
            int iC = e10 != null ? e10.c() : 0;
            Log.i(TAG, "commit " + simpleName + Const.STR_MART_WELL + iIdentityHashCode + " active=" + z10 + " count=" + iC + " ids=" + this.activeIds + " live=" + liveHandles + " size=" + this.view.getWidth() + "x" + this.view.getHeight());
            if (e10 != null) {
                liveHandles++;
                StepOSTrace stepOSTrace2 = StepOSTrace.INSTANCE;
                stepOSTrace2.counter("glass.liveHandles", liveHandles);
                long j10 = applyCount + 1;
                applyCount = j10;
                stepOSTrace2.counter("glass.applyCount", j10);
            }
            if (!this.isActive) {
                Log.i(TAG, "glass inactive on " + this.view.getClass().getSimpleName() + "（scope=" + scope + "）—— 已降级，改用兜底背景。排障见 MotionKit 文档第 5、6 章");
            }
            return this.isActive;
        } finally {
            Trace.endSection();
        }
    }

    public final boolean applyCustom$StepOSWidget_release(int scope, float cornerRadiusPx, InterfaceC5074l<? super y7.B, y7.B> applyEffect) {
        Object objB;
        Set<String> setE;
        List<String> listD;
        kotlin.jvm.internal.p.i(applyEffect, "applyEffect");
        StepOSTrace stepOSTrace = StepOSTrace.INSTANCE;
        Trace.beginSection("StepOS:GlassDelegate.apply");
        try {
            release$StepOSWidget_release();
            try {
                Result.Companion companion = Result.INSTANCE;
                objB = Result.b(applyEffect.invoke(y7.H.a(s7.p.f40121a, this.view).x(scope == 1).w(cornerRadiusPx)).u());
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Throwable thE = Result.e(objB);
            if (thE != null) {
                Log.w(TAG, "glass commit failed on " + this.view.getClass().getSimpleName(), thE);
                objB = null;
            }
            y7.E e10 = (y7.E) objB;
            this.handle = e10;
            this.isActive = (e10 != null ? e10.c() : 0) > 0;
            if (e10 == null || (listD = e10.d()) == null || (setE = Z8.F.r1(listD)) == null) {
                setE = Z8.Y.e();
            }
            this.activeIds = setE;
            String simpleName = this.view.getClass().getSimpleName();
            int iIdentityHashCode = System.identityHashCode(this.view);
            boolean z10 = this.isActive;
            int iC = e10 != null ? e10.c() : 0;
            Log.i(TAG, "commit " + simpleName + Const.STR_MART_WELL + iIdentityHashCode + " active=" + z10 + " count=" + iC + " ids=" + this.activeIds + " live=" + liveHandles + " size=" + this.view.getWidth() + "x" + this.view.getHeight());
            if (e10 != null) {
                liveHandles++;
                StepOSTrace stepOSTrace2 = StepOSTrace.INSTANCE;
                stepOSTrace2.counter("glass.liveHandles", liveHandles);
                long j10 = applyCount + 1;
                applyCount = j10;
                stepOSTrace2.counter("glass.applyCount", j10);
            }
            if (!this.isActive) {
                Log.i(TAG, "glass inactive on " + this.view.getClass().getSimpleName() + "（scope=" + scope + "）—— 已降级，改用兜底背景。排障见 MotionKit 文档第 5、6 章");
            }
            return this.isActive;
        } finally {
            Trace.endSection();
        }
    }

    public final boolean applyGradientBlur$StepOSWidget_release(int scope, float cornerRadiusPx, final float blurRadius, final BlurGradient direction, final Integer gradientScale, final int startColor, final int middleColor, final int endColor, final float colorMidpoint, final BlurGradient colorDirection) {
        Object objB;
        Set<String> setE;
        List<String> listD;
        kotlin.jvm.internal.p.i(direction, "direction");
        kotlin.jvm.internal.p.i(colorDirection, "colorDirection");
        StepOSTrace stepOSTrace = StepOSTrace.INSTANCE;
        Trace.beginSection("StepOS:GlassDelegate.apply");
        try {
            release$StepOSWidget_release();
            try {
                Result.Companion companion = Result.INSTANCE;
                objB = Result.b(y7.H.a(s7.p.f40121a, this.view).x(scope == 1).w(cornerRadiusPx).j(G.a.f43886a, new InterfaceC5074l() { // from class: com.stepos.widget.glass.a
                    @Override // p9.InterfaceC5074l
                    public final Object invoke(Object obj) {
                        return GlassDelegate.applyGradientBlur$lambda$10$lambda$9(blurRadius, direction, gradientScale, startColor, middleColor, endColor, colorMidpoint, colorDirection, (A7.B) obj);
                    }
                }).u());
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Throwable thE = Result.e(objB);
            if (thE != null) {
                Log.w(TAG, "glass commit failed on " + this.view.getClass().getSimpleName(), thE);
                objB = null;
            }
            y7.E e10 = (y7.E) objB;
            this.handle = e10;
            this.isActive = (e10 != null ? e10.c() : 0) > 0;
            if (e10 == null || (listD = e10.d()) == null || (setE = Z8.F.r1(listD)) == null) {
                setE = Z8.Y.e();
            }
            this.activeIds = setE;
            String simpleName = this.view.getClass().getSimpleName();
            int iIdentityHashCode = System.identityHashCode(this.view);
            boolean z10 = this.isActive;
            int iC = e10 != null ? e10.c() : 0;
            Log.i(TAG, "commit " + simpleName + Const.STR_MART_WELL + iIdentityHashCode + " active=" + z10 + " count=" + iC + " ids=" + this.activeIds + " live=" + liveHandles + " size=" + this.view.getWidth() + "x" + this.view.getHeight());
            if (e10 != null) {
                liveHandles++;
                StepOSTrace stepOSTrace2 = StepOSTrace.INSTANCE;
                stepOSTrace2.counter("glass.liveHandles", liveHandles);
                long j10 = applyCount + 1;
                applyCount = j10;
                stepOSTrace2.counter("glass.applyCount", j10);
            }
            if (!this.isActive) {
                Log.i(TAG, "glass inactive on " + this.view.getClass().getSimpleName() + "（scope=" + scope + "）—— 已降级，改用兜底背景。排障见 MotionKit 文档第 5、6 章");
            }
            return this.isActive;
        } finally {
            Trace.endSection();
        }
    }

    public final void cancelCover$StepOSWidget_release() {
        this.coverPending = false;
        this.view.removeCallbacks(this.revealCoverRunnable);
    }

    public final void drawCoverIfPending$StepOSWidget_release(Canvas canvas, float cornerRadiusPx, Drawable fallback) {
        kotlin.jvm.internal.p.i(canvas, "canvas");
        if (!this.coverPending || this.view.getWidth() <= 0 || this.view.getHeight() <= 0) {
            return;
        }
        if (fallback == null || fallback.getOpacity() != -1) {
            this.coverPaint.setColor(androidx.core.content.a.c(this.view.getContext(), com.stepos.widget.R.color.stepos_comp_background_primary));
            canvas.drawRoundRect(0.0f, 0.0f, this.view.getWidth(), this.view.getHeight(), cornerRadiusPx, cornerRadiusPx, this.coverPaint);
        } else {
            fallback.setBounds(0, 0, this.view.getWidth(), this.view.getHeight());
            fallback.draw(canvas);
        }
    }

    public final Set<String> getActiveIds$StepOSWidget_release() {
        return this.activeIds;
    }

    public final boolean getHasHandle$StepOSWidget_release() {
        return this.handle != null;
    }

    public final boolean getHasRealGlass$StepOSWidget_release() {
        Set<String> set = this.activeIds;
        if ((set instanceof Collection) && set.isEmpty()) {
            return false;
        }
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            if (La.D.X((String) it.next(), ID_GLASS_PREFIX, false, 2, null)) {
                return true;
            }
        }
        return false;
    }

    public final InterfaceC5063a<Y8.t> getOnCoverRevealedListener$StepOSWidget_release() {
        return this.onCoverRevealedListener;
    }

    /* renamed from: isActive$StepOSWidget_release, reason: from getter */
    public final boolean getIsActive() {
        return this.isActive;
    }

    /* renamed from: isCoverPending$StepOSWidget_release, reason: from getter */
    public final boolean getCoverPending() {
        return this.coverPending;
    }

    public final void release$StepOSWidget_release() {
        y7.E e10 = this.handle;
        if (e10 == null) {
            this.isActive = false;
            this.activeIds = Z8.Y.e();
            return;
        }
        StepOSTrace stepOSTrace = StepOSTrace.INSTANCE;
        Trace.beginSection("StepOS:GlassDelegate.release");
        try {
            Log.i(TAG, "release " + this.view.getClass().getSimpleName() + Const.STR_MART_WELL + System.identityHashCode(this.view) + " live=" + liveHandles + " size=" + this.view.getWidth() + "x" + this.view.getHeight());
            try {
                Result.Companion companion = Result.INSTANCE;
                e10.g();
                Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.b(C4849c.a(th));
            }
            this.handle = null;
            this.isActive = false;
            this.activeIds = Z8.Y.e();
            liveHandles--;
            StepOSTrace.INSTANCE.counter("glass.liveHandles", liveHandles);
            Y8.t tVar = Y8.t.f7040a;
        } finally {
            Trace.endSection();
        }
    }

    public final boolean retainOnlyIfRealGlass$StepOSWidget_release() {
        if (getHasRealGlass$StepOSWidget_release()) {
            return true;
        }
        if (!getHasHandle$StepOSWidget_release()) {
            return false;
        }
        Log.i(TAG, "glass insufficient ids=" + this.activeIds + " on " + this.view.getClass().getSimpleName() + Const.STR_MART_WELL + System.identityHashCode(this.view) + "; release for solid fallback");
        release$StepOSWidget_release();
        return false;
    }

    public final void scheduleCoverReveal$StepOSWidget_release() {
        this.view.removeCallbacks(this.revealCoverRunnable);
        View viewActivityContentView = activityContentView();
        if (viewActivityContentView != null) {
            kotlin.jvm.internal.p.f(androidx.core.view.D.a(viewActivityContentView, new Runnable() { // from class: com.stepos.widget.glass.e
                @Override // java.lang.Runnable
                public final void run() {
                    GlassDelegate.scheduleCoverReveal$lambda$2(this.f31224a);
                }
            }));
        } else {
            this.view.postOnAnimation(this.revealCoverRunnable);
        }
        this.view.postDelayed(this.revealCoverRunnable, 48L);
    }

    public final void setOnCoverRevealedListener$StepOSWidget_release(InterfaceC5063a<Y8.t> interfaceC5063a) {
        this.onCoverRevealedListener = interfaceC5063a;
    }

    public final void showCover$StepOSWidget_release() {
        this.coverPending = true;
    }

    public final void updateCornerRadius$StepOSWidget_release(float cornerRadiusPx) {
        StepOSTrace stepOSTrace = StepOSTrace.INSTANCE;
        Trace.beginSection("StepOS:GlassDelegate.updateCornerRadius");
        try {
            y7.E e10 = this.handle;
            if (e10 != null) {
                e10.b(cornerRadiusPx);
                Y8.t tVar = Y8.t.f7040a;
            }
        } finally {
            Trace.endSection();
        }
    }
}
