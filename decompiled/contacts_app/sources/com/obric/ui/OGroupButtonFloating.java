package com.obric.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import com.obric.oui.button.OShadowFrame;
import com.obric.oui.layout.OUILinearLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OGroupButtonFloating.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ,\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u000e\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0017R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/obric/ui/OGroupButtonFloating;", "Lcom/obric/oui/button/OShadowFrame;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "iconLeftView", "Landroidx/appcompat/widget/AppCompatImageView;", "iconRightView", "linearLayout", "Lcom/obric/oui/layout/OUILinearLayout;", "initContent", "", "contentView", "Landroid/widget/FrameLayout;", "typedArray", "Landroid/content/res/TypedArray;", "setIconLeft", "leftDrawable", "Landroid/graphics/drawable/Drawable;", "setIconRight", "rightDrawable", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class OGroupButtonFloating extends OShadowFrame {
    private AppCompatImageView iconLeftView;
    private AppCompatImageView iconRightView;
    private OUILinearLayout linearLayout;

    public OGroupButtonFloating(Context r9) {
        Intrinsics.checkNotNullParameter(r9, "context");
        this(r9, null, 0, 0, 14, null);
    }

    public OGroupButtonFloating(Context r9, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r9, "context");
        this(r9, r10, 0, 0, 12, null);
    }

    public OGroupButtonFloating(Context r9, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r9, "context");
        this(r9, r10, r11, 0, 8, null);
    }

    public /* synthetic */ OGroupButtonFloating(Context r2, AttributeSet r3, int r4, int r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = 0;
    L9:
        if ((r6 & 8) == 0) goto L11;
        r5 = 0;
    L11:
        this(r2, r3, r4, r5);
    }

    public OGroupButtonFloating(Context r2, AttributeSet r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4, r5);
    }

    @Override // com.obric.oui.button.OShadowFrame
    public void initContent(Context r9, FrameLayout r10, AttributeSet r11, TypedArray r12) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r10, "contentView");
        if (r12 != null) goto L5;
        return;
    L5:
        int r13 = r12.getColor(20, 0);
        OUILinearLayout r14 = new OUILinearLayout(r9, null, 0, null, 14, null);
        this.linearLayout = r14;
        r14.setOrientation(0);
        this.iconLeftView = new AppCompatImageView(r9);
        this.iconRightView = new AppCompatImageView(r9);
        OUILinearLayout r0 = null;
        if (r13 == 0) goto L14;
        AppCompatImageView r1 = this.iconLeftView;
        if (r1 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("iconLeftView");
        r1 = null;
    L10:
        r1.setColorFilter(r13);
        AppCompatImageView r2 = this.iconRightView;
        if (r2 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("iconRightView");
        r2 = null;
    L13:
        r2.setColorFilter(r13);
    L14:
        OUILinearLayout r15 = this.linearLayout;
        if (r15 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("linearLayout");
        r15 = null;
    L17:
        AppCompatImageView r3 = this.iconLeftView;
        if (r3 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("iconLeftView");
        r3 = null;
    L20:
        FrameLayout.LayoutParams r16 = new FrameLayout.LayoutParams(-2, -2);
        r16.gravity = 17;
        Unit r5 = Unit.INSTANCE;
        r15.addView(r3, r16);
        OUILinearLayout r17 = this.linearLayout;
        if (r17 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("linearLayout");
        r17 = null;
    L23:
        AppCompatImageView r18 = this.iconRightView;
        if (r18 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("iconRightView");
        r18 = null;
    L26:
        FrameLayout.LayoutParams r19 = new FrameLayout.LayoutParams(-2, -2);
        r19.gravity = 17;
        Unit r4 = Unit.INSTANCE;
        r17.addView(r18, r19);
        OUILinearLayout r8 = this.linearLayout;
        if (r8 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("linearLayout");
    L30:
        FrameLayout.LayoutParams r20 = new FrameLayout.LayoutParams(-1, -1);
        r20.gravity = 17;
        Unit r21 = Unit.INSTANCE;
        r10.addView(r0, r20);
        return;
    L29:
        r0 = r8;
        goto L30
    }

    public final void setIconLeft(Drawable r2) {
        Intrinsics.checkNotNullParameter(r2, "leftDrawable");
        AppCompatImageView r1 = this.iconLeftView;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("iconLeftView");
        r1 = null;
    L5:
        r1.setImageDrawable(r2);
    }

    public final void setIconRight(Drawable r2) {
        Intrinsics.checkNotNullParameter(r2, "rightDrawable");
        AppCompatImageView r1 = this.iconRightView;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("iconRightView");
        r1 = null;
    L5:
        r1.setImageDrawable(r2);
    }
}
