package com.stepos.ailauncher.task.detail;

import android.animation.ValueAnimator;
import android.view.View;
import androidx.dynamicanimation.animation.e;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.sheet.SheetSpring;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000e\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\b¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\b¢\u0006\u0004\b\u0012\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0014R$\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000b8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001a\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001d\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001cR\u0016\u0010\u001e\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001cR\u0014\u0010 \u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!¨\u0006\""}, d2 = {"Lcom/stepos/ailauncher/task/detail/n;", "", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "", "offset", "LY8/t;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(F)V", "", "shown", "animate", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(ZZ)V", "e", "()V", Const.INTENT_KEY_UMID, "c", "Landroid/view/View;", UxipConstants.f30680s, "isShown", "Z", "f", "()Z", "initialized", "targetTranslation", "F", "motionOffset", "hostOffset", "Landroidx/dynamicanimation/animation/i;", "spring", "Landroidx/dynamicanimation/animation/i;", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.task.detail.n, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3534n {
    private float hostOffset;
    private boolean initialized;
    private boolean isShown;
    private float motionOffset;
    private final androidx.dynamicanimation.animation.i spring;
    private float targetTranslation;
    private final View view;

    public C3534n(View view) {
        kotlin.jvm.internal.p.i(view, "view");
        this.view = view;
        this.isShown = true;
        androidx.dynamicanimation.animation.i iVar = new androidx.dynamicanimation.animation.i(new androidx.dynamicanimation.animation.g());
        iVar.c(new e.r() { // from class: com.stepos.ailauncher.task.detail.l
            @Override // androidx.dynamicanimation.animation.e.r
            public final void b(androidx.dynamicanimation.animation.e eVar, float f10, float f11) {
                C3534n.i(this.f28655a, eVar, f10, f11);
            }
        });
        iVar.b(new e.q() { // from class: com.stepos.ailauncher.task.detail.m
            @Override // androidx.dynamicanimation.animation.e.q
            public final void a(androidx.dynamicanimation.animation.e eVar, boolean z10, float f10, float f11) {
                C3534n.j(this.f28657a, eVar, z10, f10, f11);
            }
        });
        this.spring = iVar;
    }

    public static final void i(C3534n c3534n, androidx.dynamicanimation.animation.e eVar, float f10, float f11) {
        c3534n.motionOffset = f10;
        c3534n.c();
    }

    public static final void j(C3534n c3534n, androidx.dynamicanimation.animation.e eVar, boolean z10, float f10, float f11) {
        if (z10 || c3534n.isShown) {
            return;
        }
        c3534n.view.setVisibility(4);
    }

    public final void c() {
        this.view.setTranslationY(this.hostOffset + this.motionOffset);
    }

    public final void d() {
        this.spring.d();
    }

    public final void e() {
        this.spring.d();
        this.motionOffset = this.targetTranslation;
        c();
        this.view.setVisibility(this.isShown ? 0 : 4);
    }

    /* renamed from: f, reason: from getter */
    public final boolean getIsShown() {
        return this.isShown;
    }

    public final void g(float offset) {
        this.hostOffset = offset;
        c();
    }

    public final void h(boolean shown, boolean animate) {
        boolean z10 = this.initialized;
        if (z10 && shown == this.isShown) {
            if (animate) {
                return;
            }
            e();
            return;
        }
        boolean z11 = z10 && animate && this.view.isLaidOut() && ValueAnimator.areAnimatorsEnabled();
        this.initialized = true;
        this.isShown = shown;
        float f10 = shown ? 0.0f : 355.0f;
        this.targetTranslation = f10;
        this.view.setImportantForAccessibility(shown ? 0 : 4);
        if (!z11) {
            this.spring.d();
            this.motionOffset = f10;
            c();
            this.view.setVisibility(shown ? 0 : 4);
            return;
        }
        this.view.setVisibility(0);
        SheetSpring sheetSpring = shown ? new SheetSpring(350.0f, 1.0f) : new SheetSpring(320.0f, 1.0f);
        if (this.spring.y() == null) {
            this.spring.B(com.stepos.ailauncher.sheet.h0.d(sheetSpring, f10));
        } else {
            androidx.dynamicanimation.animation.j jVarY = this.spring.y();
            kotlin.jvm.internal.p.f(jVarY);
            jVarY.h(sheetSpring.getStiffness());
            jVarY.f(sheetSpring.getDampingRatio());
        }
        if (!this.spring.i()) {
            this.spring.q(this.motionOffset);
        }
        this.spring.w(f10);
    }
}
