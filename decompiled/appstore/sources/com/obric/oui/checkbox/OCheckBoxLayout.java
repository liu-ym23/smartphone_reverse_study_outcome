package com.obric.oui.checkbox;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Checkable;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.core.content.ContextCompat;
import com.bytedance.apm.constant.CommonKey;
import com.bytedanceos.common.ui.CommonConfirmDialog;
import com.google.common.primitives.Ints;
import com.obric.common.oui.R$color;
import com.obric.oui.common.style.OStateGradientDrawable;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tc.f;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0012\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0014¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u001e\u0010\u001aJ\u0017\u0010 \u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u0016H\u0016¢\u0006\u0004\b \u0010\u001dJ\u000f\u0010!\u001a\u00020\rH\u0016¢\u0006\u0004\b!\u0010\"J\u0017\u0010%\u001a\u00020\r2\b\u0010$\u001a\u0004\u0018\u00010#¢\u0006\u0004\b%\u0010&J\u0017\u0010(\u001a\u00020\r2\b\u0010$\u001a\u0004\u0018\u00010'¢\u0006\u0004\b(\u0010)J\u0017\u0010+\u001a\u00020\r2\b\b\u0001\u0010*\u001a\u00020\u0007¢\u0006\u0004\b+\u0010,J\u0015\u0010.\u001a\u00020\r2\u0006\u0010-\u001a\u00020\u0016¢\u0006\u0004\b.\u0010\u001dJ\r\u00100\u001a\u00020/¢\u0006\u0004\b0\u00101J\u000f\u00102\u001a\u00020\rH\u0002¢\u0006\u0004\b2\u0010\"R\u0016\u00104\u001a\u00020/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0014\u00108\u001a\u0002058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010;\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R$\u0010@\u001a\u00020\u00072\u0006\u0010<\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b=\u0010>\"\u0004\b?\u0010,¨\u0006A"}, d2 = {"Lcom/obric/oui/checkbox/OCheckBoxLayout;", "Landroid/widget/FrameLayout;", "Landroid/widget/Checkable;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "widthMeasureSpec", "heightMeasureSpec", "", "onMeasure", "(II)V", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "Landroid/view/MotionEvent;", "ev", "", "onInterceptTouchEvent", "(Landroid/view/MotionEvent;)Z", "performClick", "()Z", "enabled", "setEnabled", "(Z)V", "isChecked", CommonConfirmDialog.ARGS_CHECKED, "setChecked", "toggle", "()V", "Lcom/obric/oui/checkbox/OCheckBox$OnCheckedChangeListener;", "listener", "setOnCheckedChangeListener", "(Lcom/obric/oui/checkbox/OCheckBox$OnCheckedChangeListener;)V", "Lcom/obric/oui/checkbox/OCheckBox$OnCheckedStateChangedListener;", "setOnCheckedStateChangedListener", "(Lcom/obric/oui/checkbox/OCheckBox$OnCheckedStateChangedListener;)V", "color", "setPrimaryColor", "(I)V", "light", "setAlwaysLight", "Lcom/obric/oui/checkbox/OCheckBox;", "getCheckBox", "()Lcom/obric/oui/checkbox/OCheckBox;", "a", "Lcom/obric/oui/checkbox/OCheckBox;", "checkBox", "Lcom/obric/oui/common/style/OStateGradientDrawable;", "b", "Lcom/obric/oui/common/style/OStateGradientDrawable;", "backgroundDrawable", "c", "I", "layoutSizePx", CommonKey.KEY_VALUE, "getCheckedState", "()I", "setCheckedState", "checkedState", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OCheckBoxLayout extends FrameLayout implements Checkable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public OCheckBox f12769a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OStateGradientDrawable f12770b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f12771c;

    @JvmOverloads
    public OCheckBoxLayout(@NotNull Context r10) {
        q.g(r10, "context");
        AttributeSet r11 = null;
        int r12 = 0;
        this(r10, r11, r12, 6, null);
    }

    public final void a() {
        this.f12771c = f.r(this, 32);
    }

    @NotNull
    public final OCheckBox getCheckBox() {
        return this.f12769a;
    }

    public final int getCheckedState() {
        return this.f12769a.getCheckedState();
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f12769a.isChecked();
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration r10) {
        super.onConfigurationChanged(r10);
        a();
        this.f12770b.setCornerRadius(this.f12771c);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r10) {
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int r10, int r11) {
        int r12 = View.MeasureSpec.makeMeasureSpec(this.f12771c, Ints.MAX_POWER_OF_TWO);
        super.onMeasure(r12, r12);
    }

    @Override // android.view.View
    public boolean performClick() {
        return this.f12769a.performClick();
    }

    public final void setAlwaysLight(boolean r10) {
        this.f12769a.setAlwaysLight(r10);
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean r10) {
        this.f12769a.setChecked(r10);
    }

    public final void setCheckedState(int r10) {
        this.f12769a.setCheckedState(r10);
    }

    @Override // android.view.View
    public void setEnabled(boolean r10) {
        super.setEnabled(r10);
        this.f12769a.setEnabled(r10);
    }

    public final void setOnCheckedChangeListener(@Nullable OCheckBox.OnCheckedChangeListener r10) {
        this.f12769a.setOnCheckedChangeListener(r10);
    }

    public final void setOnCheckedStateChangedListener(@Nullable OCheckBox.OnCheckedStateChangedListener r10) {
        this.f12769a.setOnCheckedStateChangedListener(r10);
    }

    public final void setPrimaryColor(@ColorInt int r10) {
        this.f12769a.setPrimaryColor(r10);
    }

    @Override // android.widget.Checkable
    public void toggle() {
        this.f12769a.toggle();
    }

    @JvmOverloads
    public OCheckBoxLayout(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        int r12 = 0;
        this(r10, r11, r12, 4, null);
    }

    public /* synthetic */ OCheckBoxLayout(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    @JvmOverloads
    public OCheckBoxLayout(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        super(r10, r11, r12);
        OStateGradientDrawable r13 = new OStateGradientDrawable();
        this.f12770b = r13;
        a();
        if (r11 == null) goto L5;
        OCheckBox r14 = new OCheckBox(r10, r11, r12);
        FrameLayout.LayoutParams r15 = new FrameLayout.LayoutParams(-2, -2);
        r15.gravity = 17;
        r14.setLayoutParams(r15);
        this.f12769a = r14;
        addView(r14);
    L6:
        this.f12769a.setEnableExpandTouchRect(false);
        r13.setCornerRadius(this.f12771c);
        ColorStateList r16 = ContextCompat.c(r10, R$color.o_checkbox_layout_bg_color);
        q.d(r16);
        q.f(r16, "getColorStateList(contex…eckbox_layout_bg_color)!!");
        r13.setSolidColors(r16);
        setBackground(r13);
        setClickable(true);
        return;
    L5:
        OCheckBox r17 = new OCheckBox(r10);
        FrameLayout.LayoutParams r18 = new FrameLayout.LayoutParams(-2, -2);
        r18.gravity = 17;
        r17.setLayoutParams(r18);
        this.f12769a = r17;
        addView(r17);
        goto L6
    }
}
