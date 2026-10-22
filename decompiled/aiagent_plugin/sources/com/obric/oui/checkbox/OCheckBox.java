package com.obric.oui.checkbox;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Checkable;
import androidx.appcompat.widget.AppCompatImageView;
import com.obric.oui.common.util.g;
import com.obric.oui.common.util.k;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: OCheckBox.kt */
/* JADX INFO: loaded from: classes4.dex */
public class OCheckBox extends AppCompatImageView implements Checkable {
    private static final int[] CHECKED_STATE_SET = null;
    public static final int COLOR_DEFAULT = 0;
    public static final int COLOR_ON_IMAGE = 1;
    public static final a Companion = null;
    private static final int[] INDETERMINATE_STATE_SET = null;
    public static final int STATE_CHECKED = 1;
    public static final int STATE_INDETERMINATE = 2;
    public static final int STATE_UNCHECKED = 0;
    private boolean adaptForCSR;
    private boolean alwaysLight;
    private boolean broadcasting;
    private Drawable buttonDrawable;
    private ColorFilter checkedColorFilter;
    private int checkedState;
    private int colorChecked;
    private int colorPrimary;
    private int colorStyle;
    private int colorUnchecked;
    private int iconSize;
    private b onCheckedChangeListener;
    private c onCheckedStateChangedListener;
    private ColorFilter uncheckedColorFilter;

    /* JADX INFO: compiled from: OCheckBox.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: OCheckBox.kt */
    public interface b {
        void a(OCheckBox r1, boolean r2);
    }

    /* JADX INFO: compiled from: OCheckBox.kt */
    public interface c {
        void a(OCheckBox r1, int r2);
    }

    public static /* synthetic */ void getCheckedState$annotations() {
    }

    static {
        Companion = new a(null);
        CHECKED_STATE_SET = new int[]{R.attr.state_checked};
        INDETERMINATE_STATE_SET = new int[]{ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.attr.oui_state_indeterminate, "attr", "oui_state_indeterminate")};
    }

    public final int getCheckedState() {
        return this.checkedState;
    }

    public final void setCheckedState(int r2) {
        if (this.checkedState == r2) goto L19;
        this.checkedState = r2;
        syncButtonCheckState();
        refreshDrawableState();
        if (this.broadcasting == false) goto L7;
        return;
    L7:
        this.broadcasting = true;
        c r3 = this.onCheckedStateChangedListener;
        if (r3 == null) goto L12;
        r3.a(this, this.checkedState);
    L12:
        if (this.checkedState == 2) goto L17;
        b r4 = this.onCheckedChangeListener;
        if (r4 == null) goto L17;
        r4.a(this, isChecked());
    L17:
        this.broadcasting = false;
        return;
    }

    public OCheckBox(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "context");
        this(r4, null);
    }

    public OCheckBox(Context r4, AttributeSet r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        this(r6, r7, ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.attr.OCheckBoxStyle, "attr", "OCheckBoxStyle"));
    }

    public OCheckBox(Context r4, AttributeSet r5, int r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r7, "context");
        this(r7, r8, r6, ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.style.OStyleV2_OCheckBox_DayNight, "style", "OStyleV2_OCheckBox_DayNight"));
    }

    public OCheckBox(Context r3, AttributeSet r4, int r5, int r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r7, "context");
        super(r7, r8, r5);
        this.iconSize = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 18);
        this.colorPrimary = -1;
        this.colorChecked = -1;
        this.colorUnchecked = -1;
        this.adaptForCSR = true;
        init(r7, r8, r5, r6);
    }

    private final void init(Context r3, AttributeSet r4, int r5, int r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        int[] r0 = com.obric.aiagent.plugin.R.styleable.OCheckBox;
        o.c(r0, "OCheckBox");
        TypedArray r9 = r7.obtainStyledAttributes(r8, r0, r5, r6);
        o.c(r9, "obtainStyledAttributes(s…efStyleAttr, defStyleRes)");
        applyAppearanceAttributes(r9);
        this.adaptForCSR = r9.getBoolean(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.ORadio_oui_adapt_for_csr, "styleable", "ORadio_oui_adapt_for_csr"), true);
        if (r9.hasValue(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OCheckBox_oui_checkedState, "styleable", "OCheckBox_oui_checkedState")) == false) goto L5;
        setCheckedState(r9.getInt(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OCheckBox_oui_checkedState, "styleable", "OCheckBox_oui_checkedState"), 0));
    L5:
        r9.recycle();
        createColorFilter();
        syncDrawableStyle();
        setBackground(null);
        syncButtonCheckState();
        setClickable(true);
    }

    private final void applyAppearanceAttributes(TypedArray r6) {
        this.colorStyle = r6.getInt(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OCheckBox_oui_checkBoxColorStyle, "styleable", "OCheckBox_oui_checkBoxColorStyle"), 0);
        this.colorPrimary = r6.getColor(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OCheckBox_oui_checkBoxPrimaryColor, "styleable", "OCheckBox_oui_checkBoxPrimaryColor"), -1);
        this.colorChecked = r6.getColor(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OCheckBox_oui_checkBoxCheckedColor, "styleable", "OCheckBox_oui_checkBoxCheckedColor"), -1);
        this.colorUnchecked = r6.getColor(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OCheckBox_oui_checkBoxUncheckedColor, "styleable", "OCheckBox_oui_checkBoxUncheckedColor"), -1);
        Drawable r0 = r6.getDrawable(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OCheckBox_oui_checkBoxButton, "styleable", "OCheckBox_oui_checkBoxButton"));
        if (r0 != null) goto L5;
        r0 = null;
    L5:
        this.buttonDrawable = r0;
        this.alwaysLight = r6.getBoolean(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OCheckBox_oui_checkBoxAlwaysLight, "styleable", "OCheckBox_oui_checkBoxAlwaysLight"), false);
    }

    public final void setStyle(int r5) {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r0, "context");
        int[] r1 = com.obric.aiagent.plugin.R.styleable.OCheckBox;
        o.c(r1, "OCheckBox");
        TypedArray r6 = r0.obtainStyledAttributes(null, r1, 0, r5);
        o.c(r6, "obtainStyledAttributes(s…efStyleAttr, defStyleRes)");
        applyAppearanceAttributes(r6);
        r6.recycle();
        createColorFilter();
        syncDrawableStyle();
        syncButtonCheckState();
        invalidate();
    }

    public final void setPrimaryColor(int r1) {
        this.colorPrimary = r1;
        syncDrawableStyle();
        invalidate();
    }

    public final void setAlwaysLight(boolean r1) {
        this.alwaysLight = r1;
        syncDrawableStyle();
        invalidate();
    }

    public final void setEnableExpandTouchRect(boolean r1) {
        this.adaptForCSR = r1;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int r1, int r2) {
        int r3 = View.MeasureSpec.makeMeasureSpec(this.iconSize, 1073741824);
        super.onMeasure(r3, r3);
    }

    private final void syncDrawableStyle() {
        if (this.alwaysLight == false) goto L6;
        Drawable r0 = ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getDrawable(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.drawable.o_checkbox_circle_always_light, "drawable", "o_checkbox_circle_always_light"), null);
    L13:
        if (this.colorPrimary != (-1)) goto L15;
    L19:
        setImageDrawable(r0);
        return;
    L15:
        if (ZeusTransformUtils.instanceOf(r0, StateListDrawable.class) == false) goto L19;
        if (Build.VERSION.SDK_INT < 29) goto L19;
        com.obric.oui.d.g.f35016a.a((StateListDrawable) ZeusTransformUtils.preCheckCast(r0, StateListDrawable.class, "com.obric.aiagent.plugin"), "primary_shape", this.colorPrimary);
        goto L19
    L6:
        if (this.colorStyle != 1) goto L8;
        r0 = ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getDrawable(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.drawable.o_checkbox_circle_on_image, "drawable", "o_checkbox_circle_on_image"), null);
        goto L13
    L8:
        r0 = this.buttonDrawable;
        if (r0 != null) goto L13;
        r0 = ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getDrawable(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.drawable.o_checkbox_circle, "drawable", "o_checkbox_circle"), null);
        goto L13
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        if (this.checkedState == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!isChecked());
    }

    @Override // android.view.View
    public boolean performClick() {
        toggle();
        boolean r0 = super.performClick();
        if (r0 == true) goto L6;
        playSoundEffect(0);
    L6:
        if (isChecked() == false) goto L8;
        com.obric.oui.b.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), 1);
    L8:
        return r0;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean r1) {
        setCheckedState(r1 ? 1 : 0);
    }

    public final void setOnCheckedStateChangedListener(c r3) {
        this.onCheckedStateChangedListener = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.aiagent.plugin");
    }

    public final void setOnCheckedChangeListener(b r3) {
        this.onCheckedChangeListener = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
    }

    @Override // android.widget.ImageView, android.view.View
    public int[] onCreateDrawableState(int r3) {
        int[] r4 = super.onCreateDrawableState(r3 + 2);
        if (this.checkedState != 2) goto L6;
        AppCompatImageView.mergeDrawableStates(r4, INDETERMINATE_STATE_SET);
    L6:
        if (isChecked() == false) goto L8;
        View.mergeDrawableStates(r4, CHECKED_STATE_SET);
    L8:
        return r4;
    }

    private final void syncButtonCheckState() {
        Drawable r0 = getDrawable();
        if (r0 == null) goto L6;
        r0.clearColorFilter();
    L6:
        createColorFilter();
        Drawable r1 = getDrawable();
        if (r1 != null) goto L10;
        return;
    L10:
        if (isChecked() == false) goto L12;
        ColorFilter r2 = this.checkedColorFilter;
    L13:
        r1.setColorFilter(r2);
        return;
    L12:
        r2 = this.uncheckedColorFilter;
        goto L13
    }

    private final void createColorFilter() {
        int r0 = this.colorChecked;
        if (r0 == (-1)) goto L6;
        this.checkedColorFilter = (ColorFilter) ZeusTransformUtils.preCheckCast(com.obric.oui.common.util.c.a(r0), ColorFilter.class, "com.obric.aiagent.plugin");
    L6:
        if (this.colorUnchecked == (-1)) goto L9;
        this.uncheckedColorFilter = (ColorFilter) ZeusTransformUtils.preCheckCast(new PorterDuffColorFilter(this.colorUnchecked, PorterDuff.Mode.SRC_IN), ColorFilter.class, "com.obric.aiagent.plugin");
        return;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.adaptForCSR == false) goto L6;
        k.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 44));
        return;
    }

    @Override // android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }
}
