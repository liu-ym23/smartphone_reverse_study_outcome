package com.obric.oui.button;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.appcompat.widget.AppCompatImageView;
import com.obric.common.oui.R$styleable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ3\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0015H\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u0006¢\u0006\u0004\b\u001a\u0010\u0014J\u0015\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001a\u0010\u001dJ\u0017\u0010\u001f\u001a\u00020\u000f2\b\b\u0001\u0010\u001e\u001a\u00020\u0006¢\u0006\u0004\b\u001f\u0010\u0014J\u0015\u0010\u001f\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020 ¢\u0006\u0004\b\u001f\u0010!J\u0017\u0010\"\u001a\u00020\u000f2\b\b\u0001\u0010\u001e\u001a\u00020\u0006¢\u0006\u0004\b\"\u0010\u0014R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006'"}, d2 = {"Lcom/obric/oui/button/OIconButtonFloating;", "Lcom/obric/oui/button/OShadowFrame;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Landroid/widget/FrameLayout;", "contentView", "Landroid/content/res/TypedArray;", "typedArray", "", "c", "(Landroid/content/Context;Landroid/widget/FrameLayout;Landroid/util/AttributeSet;Landroid/content/res/TypedArray;)V", "themeStyle", "applyDynamicTheme", "(I)V", "", "enabled", "k", "(Z)V", "drawableResId", "setIcon", "Landroid/graphics/drawable/Drawable;", "drawable", "(Landroid/graphics/drawable/Drawable;)V", "color", "setIconTintColor", "Landroid/content/res/ColorStateList;", "(Landroid/content/res/ColorStateList;)V", "setIconBgColor", "Landroidx/appcompat/widget/AppCompatImageView;", "w", "Landroidx/appcompat/widget/AppCompatImageView;", "iconView", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OIconButtonFloating extends OShadowFrame {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public AppCompatImageView f12511w;

    @JvmOverloads
    public OIconButtonFloating(@NotNull Context r10) {
        q.g(r10, "context");
        AttributeSet r11 = null;
        int r12 = 0;
        int r13 = 0;
        this(r10, r11, r12, r13, 14, null);
    }

    @Override // com.obric.oui.button.OShadowFrame, com.obric.oui.common.style.ODynamicThemeWidget
    public void applyDynamicTheme(int r10) {
        super.applyDynamicTheme(r10);
    }

    @Override // com.obric.oui.button.OShadowFrame
    public void c(Context r10, FrameLayout r11, AttributeSet r12, TypedArray r13) {
        q.g(r10, "context");
        q.g(r11, "contentView");
        if (r13 != null) goto L5;
        return;
    L5:
        ColorStateList r14 = r13.getColorStateList(R$styleable.OShadowFrame_oui_widgetTintColor);
        Drawable r15 = r13.getDrawable(R$styleable.OShadowFrame_oui_widgetIcon);
        AppCompatImageView r16 = new AppCompatImageView(r10);
        this.f12511w = r16;
        r16.setDuplicateParentStateEnabled(true);
        View r17 = null;
        if (r15 == null) goto L16;
        AppCompatImageView r18 = this.f12511w;
        if (r18 != null) goto L10;
        q.y("iconView");
        r18 = null;
    L10:
        r18.setImageDrawable(r15);
        if (r14 == null) goto L16;
        AppCompatImageView r19 = this.f12511w;
        if (r19 != null) goto L15;
        q.y("iconView");
        r19 = null;
    L15:
        r19.setImageTintList(r14);
    L16:
        View r20 = this.f12511w;
        if (r20 != null) goto L19;
        q.y("iconView");
    L20:
        FrameLayout.LayoutParams r21 = new FrameLayout.LayoutParams(-1, -1);
        r21.gravity = 17;
        Unit r22 = Unit.f21064a;
        r11.addView(r17, r21);
        if (getEnableMaterial() == false) goto L24;
        d(r10, r13);
        return;
    L24:
        return;
    L19:
        r17 = r20;
        goto L20
    }

    @Override // com.obric.oui.button.OShadowFrame
    public void k(boolean r10) {
        super.k(r10);
        AppCompatImageView r11 = null;
        if (r10 == false) goto L9;
        AppCompatImageView r12 = this.f12511w;
        if (r12 != null) goto L7;
        q.y("iconView");
    L8:
        r11.setAlpha(1.0f);
        return;
    L7:
        r11 = r12;
        goto L8
    L9:
        AppCompatImageView r13 = this.f12511w;
        if (r13 != null) goto L12;
        q.y("iconView");
    L13:
        r11.setAlpha(0.3f);
        return;
    L12:
        r11 = r13;
        goto L13
    }

    public final void setIcon(int r10) {
        AppCompatImageView r11 = this.f12511w;
        if (r11 != null) goto L5;
        q.y("iconView");
        r11 = null;
    L5:
        r11.setImageResource(r10);
    }

    public final void setIconBgColor(@ColorInt int r10) {
        setBgColor(r10);
    }

    public final void setIconTintColor(@ColorInt int r10) {
        AppCompatImageView r11 = this.f12511w;
        if (r11 != null) goto L5;
        q.y("iconView");
        r11 = null;
    L5:
        r11.setColorFilter(r10);
    }

    @JvmOverloads
    public OIconButtonFloating(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        int r12 = 0;
        int r13 = 0;
        this(r10, r11, r12, r13, 12, null);
    }

    public final void setIcon(@NotNull Drawable r10) {
        q.g(r10, "drawable");
        AppCompatImageView r11 = this.f12511w;
        if (r11 != null) goto L5;
        q.y("iconView");
        r11 = null;
    L5:
        r11.setImageDrawable(r10);
    }

    public final void setIconTintColor(@NotNull ColorStateList r10) {
        q.g(r10, "color");
        AppCompatImageView r11 = this.f12511w;
        if (r11 != null) goto L5;
        q.y("iconView");
        r11 = null;
    L5:
        r11.setImageTintList(r10);
    }

    @JvmOverloads
    public OIconButtonFloating(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        int r13 = 0;
        this(r10, r11, r12, r13, 8, null);
    }

    public /* synthetic */ OIconButtonFloating(Context r10, AttributeSet r11, int r12, int r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r14 & 4) == 0) goto L9;
        r12 = 0;
    L9:
        if ((r14 & 8) == 0) goto L11;
        r13 = 0;
    L11:
        this(r10, r11, r12, r13);
    }

    public OIconButtonFloating(Context r10, AttributeSet r11, int r12, int r13) {
        q.g(r10, "context");
        super(r10, r11, r12, r13);
    }
}
