package com.stepos.widget.internal;

import Y8.t;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.dynamicanimation.animation.e;
import com.stepos.widget.internal.FluidPressMotion;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;
import v9.C5685n;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0011\b\u0000\u0018\u0000 =2\u00020\u0001:\u0001=B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\f\u001a\u00020\bH\u0002¢\u0006\u0004\b\f\u0010\rJ/\u0010\u0015\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0017\u0010\rJ\u0017\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\u0018\u0010\nJ\u000f\u0010\u001b\u001a\u00020\bH\u0000¢\u0006\u0004\b\u001a\u0010\rJ\u000f\u0010\u001d\u001a\u00020\bH\u0000¢\u0006\u0004\b\u001c\u0010\rJ\u000f\u0010\u001f\u001a\u00020\bH\u0000¢\u0006\u0004\b\u001e\u0010\rR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010 R\u0016\u0010\"\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010%\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010'\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010)\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010(R\u0016\u0010*\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010&R\u0016\u0010+\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010(R\u0016\u0010,\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010(R\u0016\u0010.\u001a\u00020-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00100\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u0010(R\u0016\u00101\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u0010(R\u0016\u00102\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u0010(R\u0016\u00103\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u0010(R\u0016\u00104\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u0010(R\u0014\u00105\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0014\u00107\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00106R\u0014\u00108\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00106R\u0014\u00109\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0014\u0010;\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010:R\u0014\u0010<\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010:¨\u0006>"}, d2 = {"Lcom/stepos/widget/internal/FluidPressMotion;", "", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "Landroid/view/MotionEvent;", "event", "LY8/t;", "begin", "(Landroid/view/MotionEvent;)V", com.stepos.ailauncher.container.wallpaper.a.PHASE_MOVE, "finish", "()V", "Landroidx/dynamicanimation/animation/i;", "animation", "Landroidx/dynamicanimation/animation/g;", "holder", "", "position", "velocity", "releaseAxis", "(Landroidx/dynamicanimation/animation/i;Landroidx/dynamicanimation/animation/g;FF)V", "applyTransform", "onTouchEvent$StepOSWidget_release", "onTouchEvent", "reset$StepOSWidget_release", "reset", "allowOverflow$StepOSWidget_release", "allowOverflow", "reapply$StepOSWidget_release", "reapply", "Landroid/view/View;", "", "pointerId", "I", "", "tracking", "Z", "originRawX", "F", "originRawY", "hasSample", "lastDx", "lastDy", "", "lastTime", "J", "velocityX", "velocityY", "pressAmt", "dx", "dy", "pressHolder", "Landroidx/dynamicanimation/animation/g;", "dxHolder", "dyHolder", "pressSpring", "Landroidx/dynamicanimation/animation/i;", "dxSpring", "dySpring", "Companion", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class FluidPressMotion {
    private static final Companion Companion = new Companion(null);
    private static final float DRAG_FOLLOW = 0.1f;
    private static final float MAX_DIST_DP = 60.0f;
    private static final float MAX_FOLLOW_DP = 40.0f;
    private static final float MAX_STRETCH = 0.3f;
    private static final float PRESS_DAMPING = 0.5f;
    private static final float PRESS_SCALE = 1.05f;
    private static final float PRESS_STIFFNESS = 320.0f;
    private static final float RELEASE_DAMPING = 0.5f;
    private static final float RELEASE_STIFFNESS = 300.0f;
    private static final float RELEASE_VEL = 0.45f;
    private static final float SQUASH = 0.8f;
    private float dx;
    private final androidx.dynamicanimation.animation.g dxHolder;
    private final androidx.dynamicanimation.animation.i dxSpring;
    private float dy;
    private final androidx.dynamicanimation.animation.g dyHolder;
    private final androidx.dynamicanimation.animation.i dySpring;
    private boolean hasSample;
    private float lastDx;
    private float lastDy;
    private long lastTime;
    private float originRawX;
    private float originRawY;
    private int pointerId;
    private float pressAmt;
    private final androidx.dynamicanimation.animation.g pressHolder;
    private final androidx.dynamicanimation.animation.i pressSpring;
    private boolean tracking;
    private float velocityX;
    private float velocityY;
    private final View view;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JC\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b0\nH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0019\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001a\u0010\u0015R\u0014\u0010\u001b\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001b\u0010\u0015R\u0014\u0010\u001c\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001c\u0010\u0015R\u0014\u0010\u001d\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001d\u0010\u0015R\u0014\u0010\u001e\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001e\u0010\u0015R\u0014\u0010\u001f\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001f\u0010\u0015¨\u0006 "}, d2 = {"Lcom/stepos/widget/internal/FluidPressMotion$Companion;", "", "<init>", "()V", "Landroidx/dynamicanimation/animation/g;", "holder", "", "stiffness", "damping", "minimumVisibleChange", "Lkotlin/Function1;", "LY8/t;", "onUpdate", "Landroidx/dynamicanimation/animation/i;", "spring", "(Landroidx/dynamicanimation/animation/g;FFFLp9/l;)Landroidx/dynamicanimation/animation/i;", "distance", "edge", "smoothstep", "(FF)F", "PRESS_SCALE", "F", "PRESS_STIFFNESS", "PRESS_DAMPING", "MAX_DIST_DP", "MAX_STRETCH", "SQUASH", "DRAG_FOLLOW", "MAX_FOLLOW_DP", "RELEASE_VEL", "RELEASE_STIFFNESS", "RELEASE_DAMPING", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final float smoothstep(float distance, float edge) {
            if (edge <= 0.0f) {
                return 0.0f;
            }
            float fM = C5685n.m(distance / edge, 0.0f, 1.0f);
            return fM * fM * (3.0f - (fM * 2.0f));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final androidx.dynamicanimation.animation.i spring(androidx.dynamicanimation.animation.g holder, float stiffness, float damping, float minimumVisibleChange, final InterfaceC5074l<? super Float, t> onUpdate) {
            androidx.dynamicanimation.animation.i iVar = new androidx.dynamicanimation.animation.i(holder);
            iVar.B(new androidx.dynamicanimation.animation.j(0.0f).h(stiffness).f(damping));
            iVar.o(minimumVisibleChange);
            iVar.c(new e.r() { // from class: com.stepos.widget.internal.d
                @Override // androidx.dynamicanimation.animation.e.r
                public final void b(androidx.dynamicanimation.animation.e eVar, float f10, float f11) {
                    FluidPressMotion.Companion.spring$lambda$1$lambda$0(onUpdate, eVar, f10, f11);
                }
            });
            return iVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void spring$lambda$1$lambda$0(InterfaceC5074l interfaceC5074l, androidx.dynamicanimation.animation.e eVar, float f10, float f11) {
            interfaceC5074l.invoke(Float.valueOf(f10));
        }

        private Companion() {
        }
    }

    public FluidPressMotion(View view) {
        p.i(view, "view");
        this.view = view;
        this.pointerId = -1;
        androidx.dynamicanimation.animation.g gVar = new androidx.dynamicanimation.animation.g(0.0f);
        this.pressHolder = gVar;
        androidx.dynamicanimation.animation.g gVar2 = new androidx.dynamicanimation.animation.g(0.0f);
        this.dxHolder = gVar2;
        androidx.dynamicanimation.animation.g gVar3 = new androidx.dynamicanimation.animation.g(0.0f);
        this.dyHolder = gVar3;
        Companion companion = Companion;
        this.pressSpring = companion.spring(gVar, PRESS_STIFFNESS, 0.5f, 0.001f, new InterfaceC5074l() { // from class: com.stepos.widget.internal.a
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return FluidPressMotion.pressSpring$lambda$0(this.f31245a, ((Float) obj).floatValue());
            }
        });
        this.dxSpring = companion.spring(gVar2, 300.0f, 0.5f, 0.5f, new InterfaceC5074l() { // from class: com.stepos.widget.internal.b
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return FluidPressMotion.dxSpring$lambda$1(this.f31246a, ((Float) obj).floatValue());
            }
        });
        this.dySpring = companion.spring(gVar3, 300.0f, 0.5f, 0.5f, new InterfaceC5074l() { // from class: com.stepos.widget.internal.c
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return FluidPressMotion.dySpring$lambda$2(this.f31247a, ((Float) obj).floatValue());
            }
        });
    }

    private final void applyTransform() {
        if (this.view.getWidth() <= 0 || this.view.getHeight() <= 0) {
            return;
        }
        if (!this.tracking && Math.abs(this.pressAmt) < 5.0E-4f && Math.abs(this.dx) < 0.05f && Math.abs(this.dy) < 0.05f) {
            this.view.setScaleX(1.0f);
            this.view.setScaleY(1.0f);
            this.view.setTranslationX(0.0f);
            this.view.setTranslationY(0.0f);
            return;
        }
        float f10 = this.view.getResources().getDisplayMetrics().density;
        float f11 = 60.0f * f10;
        float f12 = f10 * 40.0f;
        float f13 = (this.pressAmt * 0.049999952f) + 1.0f;
        Companion companion = Companion;
        float fSmoothstep = companion.smoothstep(Math.abs(this.dx), f11) * 0.3f;
        float fSmoothstep2 = companion.smoothstep(Math.abs(this.dy), f11) * 0.3f;
        this.view.setPivotX(r5.getWidth() / 2.0f);
        this.view.setPivotY(r5.getHeight() / 2.0f);
        this.view.setScaleX((fSmoothstep + 1.0f) * f13 * (1.0f - (fSmoothstep2 * 0.8f)));
        this.view.setScaleY(f13 * (fSmoothstep2 + 1.0f) * (1.0f - (fSmoothstep * 0.8f)));
        float fHypot = (float) Math.hypot(this.dx, this.dy);
        if (fHypot < 1.0E-4f || f12 <= 0.0f) {
            this.view.setTranslationX(0.0f);
            this.view.setTranslationY(0.0f);
        } else {
            float fExp = f12 * (1.0f - ((float) Math.exp((-fHypot) / f12)));
            this.view.setTranslationX((this.dx / fHypot) * fExp);
            this.view.setTranslationY((this.dy / fHypot) * fExp);
        }
    }

    private final void begin(MotionEvent event) {
        this.pointerId = event.getPointerId(0);
        this.tracking = true;
        this.originRawX = event.getRawX();
        this.originRawY = event.getRawY();
        this.hasSample = false;
        this.lastTime = event.getEventTime();
        this.velocityX = 0.0f;
        this.velocityY = 0.0f;
        ViewParent parent = this.view.getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        this.dxSpring.d();
        this.dySpring.d();
        this.pressHolder.b(this.pressAmt);
        this.pressSpring.w(1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t dxSpring$lambda$1(FluidPressMotion fluidPressMotion, float f10) {
        fluidPressMotion.dx = f10;
        fluidPressMotion.applyTransform();
        return t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t dySpring$lambda$2(FluidPressMotion fluidPressMotion, float f10) {
        fluidPressMotion.dy = f10;
        fluidPressMotion.applyTransform();
        return t.f7040a;
    }

    private final void finish() {
        if (this.tracking || this.pointerId != -1) {
            this.tracking = false;
            this.hasSample = false;
            this.pointerId = -1;
            ViewParent parent = this.view.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(false);
            }
            this.pressHolder.b(this.pressAmt);
            this.pressSpring.w(0.0f);
            releaseAxis(this.dxSpring, this.dxHolder, this.dx, this.velocityX);
            releaseAxis(this.dySpring, this.dyHolder, this.dy, this.velocityY);
            this.velocityX = 0.0f;
            this.velocityY = 0.0f;
        }
    }

    private final void move(MotionEvent event) {
        int iFindPointerIndex;
        if (this.tracking && (iFindPointerIndex = event.findPointerIndex(this.pointerId)) >= 0) {
            float rawX = (event.getRawX(iFindPointerIndex) - this.originRawX) * DRAG_FOLLOW;
            float rawY = (event.getRawY(iFindPointerIndex) - this.originRawY) * DRAG_FOLLOW;
            if (this.hasSample) {
                float fG = C5685n.g(event.getEventTime() - this.lastTime, 1L) / 1000.0f;
                this.velocityX = (rawX - this.lastDx) / fG;
                this.velocityY = (rawY - this.lastDy) / fG;
            } else {
                this.hasSample = true;
                this.velocityX = 0.0f;
                this.velocityY = 0.0f;
            }
            this.lastDx = rawX;
            this.lastDy = rawY;
            this.lastTime = event.getEventTime();
            this.dxSpring.d();
            this.dySpring.d();
            this.dx = rawX;
            this.dy = rawY;
            this.dxHolder.b(rawX);
            this.dyHolder.b(rawY);
            applyTransform();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t pressSpring$lambda$0(FluidPressMotion fluidPressMotion, float f10) {
        fluidPressMotion.pressAmt = f10;
        fluidPressMotion.applyTransform();
        return t.f7040a;
    }

    private final void releaseAxis(androidx.dynamicanimation.animation.i animation, androidx.dynamicanimation.animation.g holder, float position, float velocity) {
        animation.d();
        holder.b(position);
        animation.r(velocity * RELEASE_VEL);
        animation.w(0.0f);
    }

    public final void allowOverflow$StepOSWidget_release() {
        ViewParent parent = this.view.getParent();
        for (int i10 = 0; (parent instanceof ViewGroup) && i10 < 2; i10++) {
            ViewGroup viewGroup = (ViewGroup) parent;
            viewGroup.setClipChildren(false);
            viewGroup.setClipToPadding(false);
            parent = viewGroup.getParent();
        }
    }

    public final void onTouchEvent$StepOSWidget_release(MotionEvent event) {
        p.i(event, "event");
        int actionMasked = event.getActionMasked();
        if (actionMasked == 0) {
            begin(event);
            return;
        }
        if (actionMasked != 1) {
            if (actionMasked == 2) {
                move(event);
                return;
            } else if (actionMasked != 3) {
                if (actionMasked == 6 && event.getPointerId(event.getActionIndex()) == this.pointerId) {
                    finish();
                    return;
                }
                return;
            }
        }
        finish();
    }

    public final void reapply$StepOSWidget_release() {
        if (this.pressAmt == 0.0f && this.dx == 0.0f && this.dy == 0.0f && !this.tracking) {
            return;
        }
        applyTransform();
    }

    public final void reset$StepOSWidget_release() {
        this.tracking = false;
        this.hasSample = false;
        this.pointerId = -1;
        this.pressSpring.d();
        this.dxSpring.d();
        this.dySpring.d();
        this.pressAmt = 0.0f;
        this.dx = 0.0f;
        this.dy = 0.0f;
        this.velocityX = 0.0f;
        this.velocityY = 0.0f;
        this.pressHolder.b(0.0f);
        this.dxHolder.b(0.0f);
        this.dyHolder.b(0.0f);
        this.view.setScaleX(1.0f);
        this.view.setScaleY(1.0f);
        this.view.setTranslationX(0.0f);
        this.view.setTranslationY(0.0f);
    }
}
