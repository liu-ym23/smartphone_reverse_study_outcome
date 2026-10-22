package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.view.View;
import androidx.core.util.g;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.m;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
class FloatingActionButtonImplLollipop extends FloatingActionButtonImpl {

    static class AlwaysStatefulMaterialShapeDrawable extends MaterialShapeDrawable {
        @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
        public boolean isStateful() {
            return true;
        }

        AlwaysStatefulMaterialShapeDrawable(m r1) {
            super(r1);
        }
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    void j() {
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    boolean s() {
        return false;
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    void x() {
    }

    FloatingActionButtonImplLollipop(FloatingActionButton r3, com.google.android.material.h.b r4) {
        super(r3, (com.google.android.material.h.b) ZeusTransformUtils.wrapperContextForParams(r4, com.google.android.material.h.b.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    void a(ColorStateList r5, PorterDuff.Mode r6, ColorStateList r7, int r8) {
        this.f13397c = u();
        this.f13397c.setTintList(r5);
        if (r6 == null) goto L5;
        this.f13397c.setTintMode(r6);
    L5:
        this.f13397c.initializeElevationOverlay((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.s.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        if (r8 <= 0) goto L8;
        this.f13399e = a(r8, r5);
        Drawable r9 = new LayerDrawable(new Drawable[]{(Drawable) ZeusTransformUtils.preCheckCast(g.a(this.f13399e), Drawable.class, "com.obric.aiagent.plugin"), (Drawable) ZeusTransformUtils.preCheckCast(g.a(this.f13397c), Drawable.class, "com.obric.aiagent.plugin")});
    L9:
        this.f13398d = new RippleDrawable(com.google.android.material.ripple.a.b(r7), r9, null);
        this.f = this.f13398d;
        return;
    L8:
        this.f13399e = null;
        r9 = this.f13397c;
        goto L9
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    void b(ColorStateList r3) {
        if (ZeusTransformUtils.instanceOf(this.f13398d, RippleDrawable.class) == false) goto L5;
        ((RippleDrawable) ZeusTransformUtils.preCheckCast(this.f13398d, RippleDrawable.class, "com.obric.aiagent.plugin")).setColor(com.google.android.material.ripple.a.b(r3));
        return;
    L5:
        super.b(r3);
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    void a(float r9, float r10, float r11) {
        if (Build.VERSION.SDK_INT != 21) goto L5;
        this.s.refreshDrawableState();
    L12:
        if (p() == false) goto L15;
        o();
        return;
    L15:
        return;
    L5:
        StateListAnimator r0 = new StateListAnimator();
        r0.addState(m, a(r9, r11));
        r0.addState(n, a(r9, r10));
        r0.addState(o, a(r9, r10));
        r0.addState(p, a(r9, r10));
        AnimatorSet r12 = new AnimatorSet();
        ArrayList r13 = new ArrayList();
        r13.add(ObjectAnimator.ofFloat(this.s, "elevation", new float[]{r9}).setDuration(0));
        if (Build.VERSION.SDK_INT >= 22) goto L8;
    L10:
        r13.add(ObjectAnimator.ofFloat(this.s, View.TRANSLATION_Z, new float[]{0.0f}).setDuration(100));
        r12.playSequentially((Animator[]) ZeusTransformUtils.preCheckCast(r13.toArray(new Animator[0]), Animator[].class, "com.obric.aiagent.plugin"));
        r12.setInterpolator(f13394a);
        r0.addState(q, r12);
        r0.addState(r, a(0.0f, 0.0f));
        this.s.setStateListAnimator(r0);
        goto L12
    L8:
        if (Build.VERSION.SDK_INT > 24) goto L10;
        r13.add(ObjectAnimator.ofFloat(this.s, View.TRANSLATION_Z, new float[]{this.s.getTranslationZ()}).setDuration(100));
        goto L10
    }

    private Animator a(float r8, float r9) {
        AnimatorSet r0 = new AnimatorSet();
        r0.play(ObjectAnimator.ofFloat(this.s, "elevation", new float[]{r8}).setDuration(0)).with(ObjectAnimator.ofFloat(this.s, View.TRANSLATION_Z, new float[]{r9}).setDuration(100));
        r0.setInterpolator(f13394a);
        return r0;
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    public float a() {
        return this.s.getElevation();
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    void n() {
        o();
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    boolean p() {
        if (this.t.a() == false) goto L5;
    L8:
        return true;
    L5:
        if (h() == false) goto L8;
        return false;
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    void a(int[] r3) {
        if (Build.VERSION.SDK_INT == 21) goto L5;
        return;
    L5:
        if (this.s.isEnabled() == false) goto L16;
        this.s.setElevation(this.i);
        if (this.s.isPressed() == false) goto L10;
        this.s.setTranslationZ(this.k);
        return;
    L10:
        if (this.s.isFocused() == false) goto L12;
    L15:
        this.s.setTranslationZ(this.j);
        return;
    L12:
        if (this.s.isHovered() == true) goto L15;
        this.s.setTranslationZ(0.0f);
        return;
    L16:
        this.s.setElevation(0.0f);
        this.s.setTranslationZ(0.0f);
    }

    BorderDrawable a(int r8, ColorStateList r9) {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.s.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        BorderDrawable r2 = new BorderDrawable((m) ZeusTransformUtils.preCheckCast(g.a(this.f13396b), m.class, "com.obric.aiagent.plugin"));
        r2.setGradientColors(androidx.core.content.a.c(r0, ZeusTransformUtils.mapRes(R.color.design_fab_stroke_top_outer_color, "color", "design_fab_stroke_top_outer_color")), androidx.core.content.a.c(r0, ZeusTransformUtils.mapRes(R.color.design_fab_stroke_top_inner_color, "color", "design_fab_stroke_top_inner_color")), androidx.core.content.a.c(r0, ZeusTransformUtils.mapRes(R.color.design_fab_stroke_end_inner_color, "color", "design_fab_stroke_end_inner_color")), androidx.core.content.a.c(r0, ZeusTransformUtils.mapRes(R.color.design_fab_stroke_end_outer_color, "color", "design_fab_stroke_end_outer_color")));
        r2.setBorderWidth(r8);
        r2.setBorderTint(r9);
        return r2;
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    MaterialShapeDrawable u() {
        return new AlwaysStatefulMaterialShapeDrawable((m) ZeusTransformUtils.preCheckCast(g.a(this.f13396b), m.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    void a(Rect r2) {
        if (this.t.a() == false) goto L6;
        super.a(r2);
        return;
    L6:
        if (h() == true) goto L8;
        int r0 = (this.l - this.s.getSizeDimension()) / 2;
        r2.set(r0, r0, r0, r0);
        return;
    L8:
        r2.set(0, 0, 0, 0);
    }
}
