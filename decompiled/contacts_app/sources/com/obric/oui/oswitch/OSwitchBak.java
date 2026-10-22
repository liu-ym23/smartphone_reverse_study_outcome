package com.obric.oui.oswitch;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.obric.common.oui.R;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.common.util.ViewExtensionsKt;
import com.obric.oui.material.MaterialConfigFormatNames;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OSwitchBak.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B'\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\r\u001a\u00020\u000eJ\b\u0010\u000f\u001a\u00020\u000eH\u0014J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\nH\u0016J \u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\nH\u0002J\u000e\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\nJ\u0010\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\nH\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/obric/oui/oswitch/OSwitchBak;", "Lcom/obric/oui/oswitch/SwitchCompat;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "adaptForCSR", "", "isAlwaysDark", "isAlwaysLight", "disableAdaptForCSR", "", "onAttachedToWindow", "setChecked", MaterialConfigFormatNames.CHECKED, "setCheckedInner", "withHapticFeedback", "withAnim", "setCheckedWithoutFeedback", "setEnabled", "enabled", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OSwitchBak extends SwitchCompat {
    private boolean adaptForCSR;
    private boolean isAlwaysDark;
    private boolean isAlwaysLight;

    public OSwitchBak(Context r7) {
        this(r7, null, 0, 6, null);
    }

    public OSwitchBak(Context r7, AttributeSet r8) {
        this(r7, r8, 0, 4, null);
    }

    public /* synthetic */ OSwitchBak(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public OSwitchBak(Context r19, AttributeSet r20, int r21) {
        super(r19, r20, r21);
        this.adaptForCSR = true;
        if (r19 != null) goto L5;
    L4:
        TypedArray r5 = null;
    L9:
        if (r5 != null) goto L44;
        boolean r6 = false;
    L12:
        this.isAlwaysLight = r6;     // Catch: Throwable -> L39
        if (r5 != null) goto L15;
        boolean r7 = false;
    L16:
        this.isAlwaysDark = r7;     // Catch: Throwable -> L39
        if (r5 == null) goto L20;
        r5.recycle();
    L20:
        setLayerType(1, null);
        ShapeDrawable r3 = new ShapeDrawable(new OvalShapeWithShadow(r19));
        OSwitchBak r8 = this;
        r3.setIntrinsicHeight(OUnitExtensionKt.vdp(r8, 21));
        r3.setIntrinsicWidth(OUnitExtensionKt.vdp(r8, 21));
        setThumbDrawable(r3);
        ShapeDrawable r4 = new ShapeDrawable();
        r4.setIntrinsicHeight(OUnitExtensionKt.vdp(r8, 24));
        r4.setIntrinsicWidth(OUnitExtensionKt.vdp(r8, 36));
        r4.setShape(new RoundRectShape(new float[]{OUnitExtensionKt.vdpFloat(r8, 12.5d), OUnitExtensionKt.vdpFloat(r8, 12.5d), OUnitExtensionKt.vdpFloat(r8, 12.5d), OUnitExtensionKt.vdpFloat(r8, 12.5d), OUnitExtensionKt.vdpFloat(r8, 12.5d), OUnitExtensionKt.vdpFloat(r8, 12.5d), OUnitExtensionKt.vdpFloat(r8, 12.5d), OUnitExtensionKt.vdpFloat(r8, 12.5d)}, new RectF(), new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f}));
        if (this.isAlwaysLight == false) goto L24;
        int r9 = R.color.LineReverse;
    L27:
        Intrinsics.checkNotNull(r19);
        DrawableCompat.setTint(r4, ContextCompat.getColor(r19, r9));
        ShapeDrawable r10 = new ShapeDrawable();
        r10.setIntrinsicHeight(OUnitExtensionKt.vdp(r8, 25));
        r10.setIntrinsicWidth(OUnitExtensionKt.vdp(r8, 43));
        r10.setShape(new RoundRectShape(new float[]{OUnitExtensionKt.vdpFloat(r8, 12.5d), OUnitExtensionKt.vdpFloat(r8, 12.5d), OUnitExtensionKt.vdpFloat(r8, 12.5d), OUnitExtensionKt.vdpFloat(r8, 12.5d), OUnitExtensionKt.vdpFloat(r8, 12.5d), OUnitExtensionKt.vdpFloat(r8, 12.5d), OUnitExtensionKt.vdpFloat(r8, 12.5d), OUnitExtensionKt.vdpFloat(r8, 12.5d)}, new RectF(), new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f}));
        DrawableCompat.setTint(r10, ContextCompat.getColor(r19, R.color.blue_2761f2_100));
        TransitionDrawable r1 = new TransitionDrawable(new ShapeDrawable[]{r4, r10});
        r1.setCrossFadeEnabled(true);
        setTrackDrawable(r1);
        Drawable r2 = getTrackDrawable();
        if (r2 == null) goto L38;
        ((TransitionDrawable) r2).resetTransition();
        setThumbConstraintRight(OUnitExtensionKt.vdp(r8, 2));
        setThumbConstraintLeft(OUnitExtensionKt.vdp(r8, 2));
        if (isChecked() == false) goto L36;
        Drawable r0 = getTrackDrawable();
        if (r0 == null) goto L35;
        ((TransitionDrawable) r0).startTransition(180);
        return;
    L35:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.TransitionDrawable");
    L36:
        return;
    L38:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.TransitionDrawable");
    L24:
        if (this.isAlwaysDark == false) goto L26;
        r9 = R.color.ConstLineInverse;
        goto L27
    L26:
        r9 = R.color.LinePrimary2;
    L39:
        th = move-exception;
        if (r5 == null) goto L43;
        r5.recycle();
    L43:
        throw th;
    L15:
        r7 = r5.getBoolean(R.styleable.OSwitch_oui_isAlwaysDark, false);     // Catch: Throwable -> L39
        goto L16
    L44:
        r6 = r5.getBoolean(R.styleable.OSwitch_oui_isAlwaysLight, false);     // Catch: Throwable -> L39
        goto L12
    L5:
        Resources.Theme r11 = r19.getTheme();
        if (r11 == null) goto L4;
        r5 = r11.obtainStyledAttributes(r20, R.styleable.OSwitch, 0, 0);
        goto L9
    }

    @Override // com.obric.oui.oswitch.SwitchCompat, android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean r2) {
        setCheckedInner(r2, true, true);
    }

    public final void setCheckedWithoutFeedback(boolean r3) {
        setCheckedInner(r3, false, true);
    }

    private final void setCheckedInner(boolean r3, boolean r4, boolean r5) {
        if (r3 == isChecked()) goto L21;
        if (r5 == false) goto L21;
        if ((getTrackDrawable() instanceof TransitionDrawable) == false) goto L21;
        if (r3 == false) goto L14;
        Drawable r1 = getTrackDrawable();
        if (r1 == null) goto L13;
        ((TransitionDrawable) r1).startTransition(180);
    L17:
        if (r4 == false) goto L21;
        performHapticFeedback(1, 2);
        goto L21
    L13:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.TransitionDrawable");
    L14:
        Drawable r2 = getTrackDrawable();
        if (r2 == null) goto L20;
        ((TransitionDrawable) r2).reverseTransition(180);
        goto L17
    L20:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.TransitionDrawable");
    L21:
        super.setChecked(r3);
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
        if ((getParent() instanceof ViewGroup) == false) goto L9;
        ViewParent r1 = getParent();
        if (r1 == null) goto L8;
        ((ViewGroup) r1).setTouchDelegate(null);
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.adaptForCSR == false) goto L6;
        OSwitchBak r1 = this;
        ViewExtensionsKt.expandTouchArea(r1, OUnitExtensionKt.vdp(r1, 45));
        return;
    }
}
