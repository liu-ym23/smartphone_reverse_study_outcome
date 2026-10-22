package com.obric.oui.oswitch;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.ColorFilter;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.graphics.drawable.a;
import androidx.core.graphics.e;
import com.obric.aiagent.plugin.R;
import com.obric.oui.common.util.SimpleColorFilter;
import com.obric.oui.common.util.g;
import com.obric.oui.common.util.k;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.Objects;

/* JADX INFO: compiled from: OSwitchBak.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OSwitchBak extends SwitchCompat {
    private boolean adaptForCSR;
    private boolean isAlwaysDark;
    private boolean isAlwaysLight;

    public OSwitchBak(Context r7) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin"), null, 0, 6, null);
    }

    public OSwitchBak(Context r9, AttributeSet r10) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin"), 0, 4, null);
    }

    public /* synthetic */ OSwitchBak(Context r2, AttributeSet r3, int r4, int r5, h r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r8, r4);
    }

    public OSwitchBak(Context r20, AttributeSet r21, int r22) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r20, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r3 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r21, AttributeSet.class, "com.obric.aiagent.plugin");
        super(r1, r3, r22);
        this.adaptForCSR = true;
        if (r1 != null) goto L5;
    L4:
        TypedArray r4 = null;
    L10:
        if (r4 != null) goto L45;
        boolean r8 = false;
    L13:
        this.isAlwaysLight = r8;     // Catch: Throwable -> L40
        if (r4 != null) goto L16;
        boolean r7 = false;
    L17:
        this.isAlwaysDark = r7;     // Catch: Throwable -> L40
        if (r4 == null) goto L21;
        r4.recycle();
    L21:
        setLayerType(1, null);
        ShapeDrawable r5 = new ShapeDrawable((Shape) ZeusTransformUtils.preCheckCast(new OvalShapeWithShadow(r1), Shape.class, "com.obric.aiagent.plugin"));
        r5.setIntrinsicHeight(g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 21));
        r5.setIntrinsicWidth(g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 21));
        setThumbDrawable((Drawable) ZeusTransformUtils.preCheckCast(r5, Drawable.class, "com.obric.aiagent.plugin"));
        ShapeDrawable r6 = new ShapeDrawable();
        r6.setIntrinsicHeight(g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 24));
        r6.setIntrinsicWidth(g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 36));
        r6.setShape((Shape) ZeusTransformUtils.preCheckCast(new RoundRectShape(new float[]{g.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 12.5d), g.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 12.5d), g.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 12.5d), g.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 12.5d), g.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 12.5d), g.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 12.5d), g.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 12.5d), g.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 12.5d)}, new RectF(), new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f}), Shape.class, "com.obric.aiagent.plugin"));
        if (this.isAlwaysLight == false) goto L25;
        int r9 = ZeusTransformUtils.mapRes(R.color.LineReverse, "color", "LineReverse");
    L29:
        if (Build.VERSION.SDK_INT < 21) goto L31;
        Drawable r10 = (Drawable) ZeusTransformUtils.preCheckCast(r6, Drawable.class, "com.obric.aiagent.plugin");
        o.a(r1);
        a.a(r10, androidx.core.content.a.c(r1, r9));
    L32:
        ShapeDrawable r11 = new ShapeDrawable();
        r11.setIntrinsicHeight(g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 25));
        r11.setIntrinsicWidth(g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 43));
        r11.setShape((Shape) ZeusTransformUtils.preCheckCast(new RoundRectShape(new float[]{g.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 12.5d), g.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 12.5d), g.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 12.5d), g.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 12.5d), g.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 12.5d), g.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 12.5d), g.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 12.5d), g.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 12.5d)}, new RectF(), new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f}), Shape.class, "com.obric.aiagent.plugin"));
        if (Build.VERSION.SDK_INT < 21) goto L35;
        a.a((Drawable) ZeusTransformUtils.preCheckCast(r11, Drawable.class, "com.obric.aiagent.plugin"), androidx.core.content.a.c(r1, ZeusTransformUtils.mapRes(R.color.blue_2761f2_100, "color", "blue_2761f2_100")));
    L36:
        TransitionDrawable r2 = new TransitionDrawable((Drawable[]) ZeusTransformUtils.preCheckCast(new ShapeDrawable[]{r6, r11}, Drawable[].class, "com.obric.aiagent.plugin"));
        r2.setCrossFadeEnabled(true);
        setTrackDrawable((Drawable) ZeusTransformUtils.preCheckCast(r2, Drawable.class, "com.obric.aiagent.plugin"));
        Drawable r12 = getTrackDrawable();
        Objects.requireNonNull(r12, "null cannot be cast to non-null type android.graphics.drawable.TransitionDrawable");
        ((TransitionDrawable) ZeusTransformUtils.preCheckCast(r12, TransitionDrawable.class, "com.obric.aiagent.plugin")).resetTransition();
        setThumbConstraintRight(g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 2));
        setThumbConstraintLeft(g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 2));
        if (isChecked() == false) goto L47;
        Drawable r0 = getTrackDrawable();
        Objects.requireNonNull(r0, "null cannot be cast to non-null type android.graphics.drawable.TransitionDrawable");
        ((TransitionDrawable) ZeusTransformUtils.preCheckCast(r0, TransitionDrawable.class, "com.obric.aiagent.plugin")).startTransition(180);
        return;
    L47:
        return;
    L35:
        r11.setColorFilter((ColorFilter) ZeusTransformUtils.preCheckCast(new SimpleColorFilter(androidx.core.content.a.c(r1, ZeusTransformUtils.mapRes(R.color.blue_2761f2_100, "color", "blue_2761f2_100"))), ColorFilter.class, "com.obric.aiagent.plugin"));
        goto L36
    L31:
        o.a(r1);
        r6.setColorFilter((ColorFilter) ZeusTransformUtils.preCheckCast(new SimpleColorFilter(e.a(androidx.core.content.a.c(r1, r9), androidx.core.content.a.c(r1, ZeusTransformUtils.mapRes(R.color.BGPrimary, "color", "BGPrimary")))), ColorFilter.class, "com.obric.aiagent.plugin"));
        goto L32
    L25:
        if (this.isAlwaysDark == false) goto L27;
        r9 = ZeusTransformUtils.mapRes(R.color.ConstLineInverse, "color", "ConstLineInverse");
        goto L29
    L27:
        r9 = ZeusTransformUtils.mapRes(R.color.LinePrimary2, "color", "LinePrimary2");
    L40:
        th = move-exception;
        if (r4 == null) goto L44;
        r4.recycle();
    L44:
        throw th;
    L16:
        r7 = r4.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OSwitch_oui_isAlwaysDark, "styleable", "OSwitch_oui_isAlwaysDark"), false);     // Catch: Throwable -> L40
        goto L17
    L45:
        r8 = r4.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OSwitch_oui_isAlwaysLight, "styleable", "OSwitch_oui_isAlwaysLight"), false);     // Catch: Throwable -> L40
        goto L13
    L5:
        Resources.Theme r13 = r1.getTheme();
        if (r13 == null) goto L4;
        r4 = r13.obtainStyledAttributes(r3, R.styleable.OSwitch, 0, 0);
        goto L10
    }

    @Override // com.obric.oui.oswitch.SwitchCompat, android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean r2) {
        setCheckedInner(r2, true, true);
    }

    public final void setCheckedWithoutFeedback(boolean r3) {
        setCheckedInner(r3, false, true);
    }

    private final void setCheckedInner(boolean r4, boolean r5, boolean r6) {
        if (r4 == isChecked()) goto L13;
        if (r6 == false) goto L13;
        if (ZeusTransformUtils.instanceOf(getTrackDrawable(), TransitionDrawable.class) == false) goto L13;
        if (r4 == false) goto L10;
        Drawable r2 = getTrackDrawable();
        Objects.requireNonNull(r2, "null cannot be cast to non-null type android.graphics.drawable.TransitionDrawable");
        ((TransitionDrawable) ZeusTransformUtils.preCheckCast(r2, TransitionDrawable.class, "com.obric.aiagent.plugin")).startTransition(180);
    L11:
        if (r5 == false) goto L13;
        performHapticFeedback(1, 2);
        goto L13
    L10:
        Drawable r3 = getTrackDrawable();
        Objects.requireNonNull(r3, "null cannot be cast to non-null type android.graphics.drawable.TransitionDrawable");
        ((TransitionDrawable) ZeusTransformUtils.preCheckCast(r3, TransitionDrawable.class, "com.obric.aiagent.plugin")).reverseTransition(180);
    L13:
        super.setChecked(r4);
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean r1) {
        super.setEnabled(r1);
        if (r1 == false) goto L5;
        float r2 = 1.0f;
    L6:
        setAlpha(r2);
        return;
    L5:
        r2 = 0.5f;
        goto L6
    }

    public final void disableAdaptForCSR() {
        this.adaptForCSR = false;
        if (ZeusTransformUtils.instanceOf(getParent(), ViewGroup.class) == false) goto L6;
        ViewParent r2 = getParent();
        Objects.requireNonNull(r2, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) ZeusTransformUtils.preCheckCast(r2, ViewGroup.class, "com.obric.aiagent.plugin")).setTouchDelegate(null);
        return;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.adaptForCSR == false) goto L6;
        k.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 45));
        return;
    }
}
