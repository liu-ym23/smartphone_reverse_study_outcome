package com.obric.oui.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import com.obric.aiagent.plugin.R;
import com.obric.common.oea.foundation.animation.h.e;
import com.obric.common.oea.foundation.animation.manager.d;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.m;
import d.h.a.q;
import d.h.b.h;
import d.h.b.o;
import d.h.b.p;
import d.l.n;
import d.x;

/* JADX INFO: compiled from: OProgressButton.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OProgressButton extends OButton {
    private final int coveredTextColor;
    private int currentProgress;
    private float currentProgressFloat;
    private Integer defaultBackgroundColor;
    private boolean isInProgressMode;
    private d progressAnimator;
    private final int progressBgDrawableRes;
    private final int uncoveredTextColor;

    /* JADX INFO: compiled from: OProgressButton.kt */
    static final class a extends p implements q<String, Object, Object, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OProgressButton f34308a;

        a(OProgressButton r1) {
            this.f34308a = r1;
            super(3);
        }

        @Override // d.h.a.q
        public /* synthetic */ x invoke(String r3, Object r4, Object r5) {
            a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), r4, r5);
            return x.f38692a;
        }

        public final void a(String r2, Object r3, Object r4) {
            o.e(r2, "$noName_0");
            o.e(r3, "value");
            o.e(r4, "velocity");
            OProgressButton.access$setCurrentProgressFloat$p(this.f34308a, ((Float) ZeusTransformUtils.preCheckCast(r3, Float.class, "com.obric.aiagent.plugin")).floatValue());
            OProgressButton r5 = this.f34308a;
            r5.updateBackgroundProgress(OProgressButton.access$getCurrentProgressFloat$p(r5));
            if (OProgressButton.access$isInProgressMode$p(this.f34308a) == false) goto L5;
            OProgressButton.access$updateTextShader(this.f34308a);
        L5:
            this.f34308a.invalidate();
        }
    }

    /* JADX INFO: compiled from: OProgressButton.kt */
    static final class b extends p implements m<Boolean, Throwable, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OProgressButton f34309a;

        b(OProgressButton r1) {
            this.f34309a = r1;
            super(2);
        }

        @Override // d.h.a.m
        public /* synthetic */ x invoke(Boolean r3, Throwable r4) {
            a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue(), (Throwable) ZeusTransformUtils.preCheckCast(r4, Throwable.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }

        public final void a(boolean r1, Throwable r2) {
            if (r1 == false) goto L7;
            OProgressButton r3 = this.f34309a;
            OProgressButton.access$setCurrentProgressFloat$p(r3, OProgressButton.access$getCurrentProgress$p(r3));
            OProgressButton r4 = this.f34309a;
            r4.updateBackgroundProgress(OProgressButton.access$getCurrentProgressFloat$p(r4));
            if (OProgressButton.access$isInProgressMode$p(this.f34309a) == false) goto L8;
            OProgressButton.access$updateTextShader(this.f34309a);
            return;
        L8:
            return;
        }
    }

    public OProgressButton(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public /* synthetic */ OProgressButton(Context r2, AttributeSet r3, int r4, int r5, h r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r5 & 4) == 0) goto L5;
        r4 = 0;
    L5:
        this(r7, r8, r4);
    }

    public static final /* synthetic */ int access$getCurrentProgress$p(OProgressButton r0) {
        return r0.currentProgress;
    }

    public static final /* synthetic */ float access$getCurrentProgressFloat$p(OProgressButton r0) {
        return r0.currentProgressFloat;
    }

    public static final /* synthetic */ boolean access$isInProgressMode$p(OProgressButton r0) {
        return r0.isInProgressMode;
    }

    public static final /* synthetic */ void access$setCurrentProgressFloat$p(OProgressButton r0, float r1) {
        r0.currentProgressFloat = r1;
    }

    public static final /* synthetic */ void access$updateTextShader(OProgressButton r0) {
        r0.updateTextShader();
    }

    public OProgressButton(Context r11, AttributeSet r12, int r13) {
        Context r14 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r15 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r12, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r14, "context");
        super(r14, r15, r13, 0, null, 24, null);
        TypedArray r16 = r14.obtainStyledAttributes(r15, R.styleable.OProgressButton);
        o.c(r16, "context.obtainStyledAttr…tyleable.OProgressButton)");
        this.coveredTextColor = r16.getColor(ZeusTransformUtils.mapRes(R.styleable.OProgressButton_android_textColor, "styleable", "OProgressButton_android_textColor"), androidx.core.content.a.c(r14, ZeusTransformUtils.mapRes(R.color.oui_on_accent_default, "color", "oui_on_accent_default")));
        this.uncoveredTextColor = r16.getColor(ZeusTransformUtils.mapRes(R.styleable.OProgressButton_oui_progress_button_uncovered_text_color, "styleable", "OProgressButton_oui_progress_button_uncovered_text_color"), androidx.core.content.a.c(r14, ZeusTransformUtils.mapRes(R.color.oui_accent_6_bg, "color", "oui_accent_6_bg")));
        this.progressBgDrawableRes = r16.getResourceId(ZeusTransformUtils.mapRes(R.styleable.OProgressButton_oui_progress_bg_resource, "styleable", "OProgressButton_oui_progress_bg_resource"), ZeusTransformUtils.mapRes(R.drawable.o_button_progress_drawable_primary, "drawable", "o_button_progress_drawable_primary"));
        r16.recycle();
        Drawable r17 = getBackground();
        if (ZeusTransformUtils.instanceOf(r17, ColorDrawable.class) == false) goto L6;
        this.defaultBackgroundColor = Integer.valueOf(((ColorDrawable) ZeusTransformUtils.preCheckCast(r17, ColorDrawable.class, "com.obric.aiagent.plugin")).getColor());
        return;
    }

    private final void updateButtonMode() {
        if (this.isInProgressMode == false) goto L5;
        changeToProgressDrawable();
        return;
    L5:
        getPaint().setShader(null);
        setTextColor(this.coveredTextColor);
        if (this.defaultBackgroundColor == null) goto L8;
        Integer r1 = this.defaultBackgroundColor;
        o.a(r1);
        setBackground((Drawable) ZeusTransformUtils.preCheckCast(new ColorDrawable(r1.intValue()), Drawable.class, "com.obric.aiagent.plugin"));
    L8:
        invalidate();
    }

    private final void changeToProgressDrawable() {
        Drawable r0 = androidx.core.content.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), this.progressBgDrawableRes);
        ClipDrawable r2 = null;
        if (r0 != null) goto L5;
        Drawable r1 = null;
    L6:
        setBackground(r1);
        Drawable r3 = getBackground();
        if (ZeusTransformUtils.instanceOf(r3, LayerDrawable.class) == false) goto L16;
        Drawable r4 = ((LayerDrawable) ZeusTransformUtils.preCheckCast(r3, LayerDrawable.class, "com.obric.aiagent.plugin")).findDrawableByLayerId(android.R.id.progress);
        if (ZeusTransformUtils.instanceOf(r4, ClipDrawable.class) == false) goto L11;
        r2 = (ClipDrawable) ZeusTransformUtils.preCheckCast(r4, ClipDrawable.class, "com.obric.aiagent.plugin");
    L11:
        Integer r5 = this.defaultBackgroundColor;
        if (r5 == null) goto L16;
        if (r2 == null) goto L16;
        o.a(r5);
        r2.setTint(r5.intValue());
    L16:
        updateBackgroundProgress(this.currentProgressFloat);
        updateTextShader();
        return;
    L5:
        r1 = r0.mutate();
        goto L6
    }

    public final void setProgressMode(boolean r2) {
        if (this.isInProgressMode == r2) goto L6;
        this.isInProgressMode = r2;
        updateButtonMode();
        return;
    }

    public final void setProgress(int r5) {
        if (this.currentProgress != r5) goto L5;
        return;
    L5:
        d r0 = this.progressAnimator;
        if (r0 == null) goto L9;
        d.a(r0, false, 1, null);
    L9:
        this.currentProgress = r5;
        float r6 = r5;
        this.currentProgressFloat = r6;
        updateBackgroundProgress(r6);
        if (this.isInProgressMode == false) goto L13;
        updateTextShader();
        return;
    }

    public final void updateProgress(int r2) {
        updateProgress(r2, false);
    }

    public final void updateProgress(int r10, boolean r11) {
        if (r11 == true) goto L6;
        setProgress(r10);
        return;
    L6:
        if (this.currentProgress != r10) goto L8;
        return;
    L8:
        this.currentProgress = r10;
        if (this.isInProgressMode == true) goto L11;
        return;
    L11:
        d r12 = this.progressAnimator;
        if (r12 == null) goto L15;
        d.a(r12, false, 1, null);
    L15:
        float r13 = Math.abs(this.currentProgressFloat - r10);
        int r1 = 100;
        if (r13 <= 10.0f) goto L18;
        r1 = (int) (100 + ((50 * r13) / 10));
    L18:
        this.progressAnimator = com.obric.common.oea.foundation.animation.a.d.a.a(new com.obric.common.oea.foundation.animation.a.d.a(), this.currentProgressFloat, this.currentProgress, (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.preCheckCast(com.obric.common.oea.foundation.animation.g.b.a(r1, 0, e.d.f32443a), com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin"), null, 8, null).a((q) ZeusTransformUtils.preCheckCast(new a(this), q.class, "com.obric.aiagent.plugin")).a((m) ZeusTransformUtils.preCheckCast(new b(this), m.class, "com.obric.aiagent.plugin")).a().a();
        if (this.isInProgressMode == false) goto L22;
        updateTextShader();
        return;
    }

    public final void updateBackgroundProgress(float r3) {
        Drawable r2 = getBackground();
        if (ZeusTransformUtils.instanceOf(r2, LayerDrawable.class) == false) goto L12;
        Drawable r4 = ((LayerDrawable) ZeusTransformUtils.preCheckCast(r2, LayerDrawable.class, "com.obric.aiagent.plugin")).findDrawableByLayerId(android.R.id.progress);
        if (ZeusTransformUtils.instanceOf(r4, ClipDrawable.class) == false) goto L7;
        ClipDrawable r5 = (ClipDrawable) ZeusTransformUtils.preCheckCast(r4, ClipDrawable.class, "com.obric.aiagent.plugin");
    L8:
        if (r5 == null) goto L13;
        r5.setLevel((int) (r3 * 100));
        return;
    L13:
        return;
    L7:
        r5 = null;
        goto L8
    }

    @Override // android.view.View
    public void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        if (this.isInProgressMode == false) goto L6;
        updateTextShader();
        return;
    }

    private final void updateTextShader() {
        if (getWidth() > 0) goto L5;
        return;
    L5:
        float r0 = this.currentProgressFloat / 100.0f;
        float r5 = getWidth();
        float r1 = n.a(r0, 0.0f, 1.0f);
        if (r1 > 0.0f) goto L9;
        getPaint().setShader(null);
        setTextColor(this.uncoveredTextColor);
    L12:
        invalidate();
        return;
    L9:
        if (r1 < 1.0f) goto L11;
        getPaint().setShader(null);
        setTextColor(this.coveredTextColor);
        goto L12
    L11:
        int r9 = this.coveredTextColor;
        int r10 = this.uncoveredTextColor;
        getPaint().setShader((Shader) ZeusTransformUtils.preCheckCast(new LinearGradient(0.0f, 0.0f, r5, 0.0f, new int[]{r9, r9, r10, r10}, new float[]{0.0f, r1, r1, 1.0f}, Shader.TileMode.CLAMP), Shader.class, "com.obric.aiagent.plugin"));
        setTextColor(this.coveredTextColor);
        goto L12
    }
}
