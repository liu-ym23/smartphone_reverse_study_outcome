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
import androidx.core.content.ContextCompat;
import com.bytedanceos.common.ui.CommonConfirmDialog;
import com.bytedanceos.common.ui.animation.AnimationConstants;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$styleable;
import hd.b;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import o.a;
import org.jetbrains.annotations.Nullable;
import tc.f;
import tc.l;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0013\u0018\u00002\u00020\u0001B)\b\u0007\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0011\u0010\u000eJ\u000f\u0010\u0012\u001a\u00020\fH\u0014¢\u0006\u0004\b\u0012\u0010\u0013J'\u0010\u0016\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001c\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u0019¨\u0006\u001f"}, d2 = {"Lcom/obric/oui/oswitch/OSwitchBak;", "Lcom/obric/oui/oswitch/SwitchCompat;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", CommonConfirmDialog.ARGS_CHECKED, "", "setChecked", "(Z)V", "setCheckedWithoutFeedback", "enabled", "setEnabled", "onAttachedToWindow", "()V", "withHapticFeedback", "withAnim", "m", "(ZZZ)V", "W", "Z", "adaptForCSR", "a0", "isAlwaysLight", "b0", "isAlwaysDark", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OSwitchBak extends SwitchCompat {
    public boolean W;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public boolean f15712a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public boolean f15713b0;

    @JvmOverloads
    public OSwitchBak(@Nullable Context r10) {
        AttributeSet r11 = null;
        int r12 = 0;
        this(r10, r11, r12, 6, null);
    }

    public final void m(boolean r10, boolean r11, boolean r12) {
        if (r10 == isChecked()) goto L21;
        if (r12 == false) goto L21;
        if ((getTrackDrawable() instanceof TransitionDrawable) == false) goto L21;
        if (r10 == false) goto L14;
        Drawable r13 = getTrackDrawable();
        if (r13 == null) goto L13;
        ((TransitionDrawable) r13).startTransition(AnimationConstants.DURATION_180);
    L17:
        if (r11 == false) goto L21;
        performHapticFeedback(1, 2);
        goto L21
    L13:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.TransitionDrawable");
    L14:
        Drawable r14 = getTrackDrawable();
        if (r14 == null) goto L20;
        ((TransitionDrawable) r14).reverseTransition(AnimationConstants.DURATION_180);
        goto L17
    L20:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.TransitionDrawable");
    L21:
        super.setChecked(r10);
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.W == false) goto L6;
        l.c(this, f.r(this, 45));
        return;
    }

    @Override // com.obric.oui.oswitch.SwitchCompat, android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean r10) {
        m(r10, true, true);
    }

    public final void setCheckedWithoutFeedback(boolean r10) {
        m(r10, false, true);
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean r10) {
        super.setEnabled(r10);
        if (r10 == false) goto L5;
        float r11 = 1.0f;
    L6:
        setAlpha(r11);
        return;
    L5:
        r11 = 0.5f;
        goto L6
    }

    @JvmOverloads
    public OSwitchBak(@Nullable Context r10, @Nullable AttributeSet r11) {
        int r12 = 0;
        this(r10, r11, r12, 4, null);
    }

    public /* synthetic */ OSwitchBak(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    @JvmOverloads
    public OSwitchBak(@Nullable Context r24, @Nullable AttributeSet r25, int r26) {
        super(r24, r25, r26);
        this.W = true;
        if (r24 != null) goto L5;
    L4:
        TypedArray r12 = null;
    L9:
        if (r12 != null) goto L44;
        boolean r13 = false;
    L12:
        this.f15712a0 = r13;     // Catch: Throwable -> L39
        if (r12 != null) goto L15;
        boolean r14 = false;
    L16:
        this.f15713b0 = r14;     // Catch: Throwable -> L39
        if (r12 == null) goto L20;
        r12.recycle();
    L20:
        setLayerType(1, null);
        ShapeDrawable r10 = new ShapeDrawable(new b(r24));
        r10.setIntrinsicHeight(f.r(this, 21));
        r10.setIntrinsicWidth(f.r(this, 21));
        setThumbDrawable(r10);
        ShapeDrawable r11 = new ShapeDrawable();
        r11.setIntrinsicHeight(f.r(this, 24));
        r11.setIntrinsicWidth(f.r(this, 36));
        r11.setShape(new RoundRectShape(new float[]{f.s(this, 12.5d), f.s(this, 12.5d), f.s(this, 12.5d), f.s(this, 12.5d), f.s(this, 12.5d), f.s(this, 12.5d), f.s(this, 12.5d), f.s(this, 12.5d)}, new RectF(), new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f}));
        if (this.f15712a0 == false) goto L24;
        int r15 = R$color.LineReverse;
    L27:
        q.d(r24);
        a.h(r11, ContextCompat.b(r24, r15));
        ShapeDrawable r16 = new ShapeDrawable();
        r16.setIntrinsicHeight(f.r(this, 25));
        r16.setIntrinsicWidth(f.r(this, 43));
        r16.setShape(new RoundRectShape(new float[]{f.s(this, 12.5d), f.s(this, 12.5d), f.s(this, 12.5d), f.s(this, 12.5d), f.s(this, 12.5d), f.s(this, 12.5d), f.s(this, 12.5d), f.s(this, 12.5d)}, new RectF(), new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f}));
        a.h(r16, ContextCompat.b(r24, R$color.blue_2761f2_100));
        TransitionDrawable r17 = new TransitionDrawable(new ShapeDrawable[]{r11, r16});
        r17.setCrossFadeEnabled(true);
        setTrackDrawable(r17);
        Drawable r18 = getTrackDrawable();
        if (r18 == null) goto L38;
        ((TransitionDrawable) r18).resetTransition();
        setThumbConstraintRight(f.r(this, 2));
        setThumbConstraintLeft(f.r(this, 2));
        if (isChecked() == false) goto L36;
        Drawable r19 = getTrackDrawable();
        if (r19 == null) goto L35;
        ((TransitionDrawable) r19).startTransition(AnimationConstants.DURATION_180);
        return;
    L35:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.TransitionDrawable");
    L36:
        return;
    L38:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.TransitionDrawable");
    L24:
        if (this.f15713b0 == false) goto L26;
        r15 = R$color.ConstLineInverse;
        goto L27
    L26:
        r15 = R$color.LinePrimary2;
    L39:
        th = move-exception;
        if (r12 == null) goto L43;
        r12.recycle();
    L43:
        throw th;
    L15:
        r14 = r12.getBoolean(R$styleable.OSwitch_oui_isAlwaysDark, false);     // Catch: Throwable -> L39
        goto L16
    L44:
        r13 = r12.getBoolean(R$styleable.OSwitch_oui_isAlwaysLight, false);     // Catch: Throwable -> L39
        goto L12
    L5:
        Resources.Theme r110 = r24.getTheme();
        if (r110 == null) goto L4;
        r12 = r110.obtainStyledAttributes(r25, R$styleable.OSwitch, 0, 0);
        goto L9
    }
}
