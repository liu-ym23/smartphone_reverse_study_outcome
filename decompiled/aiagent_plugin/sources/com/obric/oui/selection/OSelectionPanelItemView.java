package com.obric.oui.selection;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.b;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.checkbox.OCheckBox;
import com.obric.oui.common.util.k;
import com.obric.oui.layout.OUIConstraintLayout;
import com.obric.oui.radio.ORadio;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: OSelectionPanelItemView.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OSelectionPanelItemView extends OUIConstraintLayout {
    private final OCheckBox checkbox;
    private final View divider;
    private boolean isMultiSelect;
    private final ImageView ivIcon;
    private final ORadio radio;
    private boolean showDivider;
    private boolean showSelectLabel;
    private final OTextView tvText;

    /* JADX INFO: compiled from: OSelectionPanelItemView.kt */
    public static final class a extends AccessibilityDelegateCompat {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OSelectionPanelItemView f36160a;

        a(OSelectionPanelItemView r1) {
            this.f36160a = r1;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void a(View r1, b r2) {
            super.a(r1, r2);
            if (this.f36160a.isMultiSelect() == true) goto L5;
            return;
        L5:
            if (this.f36160a.isItemSelected() == false) goto L11;
            if (r1 == null) goto L12;
            r1.setSelected(true);
            return;
        L12:
            return;
        }
    }

    public OSelectionPanelItemView(Context r8) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, false, false, 14, null);
    }

    public OSelectionPanelItemView(Context r10, AttributeSet r11) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, false, false, 12, null);
    }

    public OSelectionPanelItemView(Context r10, AttributeSet r11, boolean r12) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, r12, false, 8, null);
    }

    public /* synthetic */ OSelectionPanelItemView(Context r2, AttributeSet r3, boolean r4, boolean r5, int r6, h r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r9 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r6 & 2) == 0) goto L6;
        r9 = null;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = false;
    L9:
        if ((r6 & 8) == 0) goto L11;
        r5 = false;
    L11:
        this(r8, r9, r4, r5);
    }

    public final boolean isMultiSelect() {
        return this.isMultiSelect;
    }

    public final void setMultiSelect(boolean r1) {
        this.isMultiSelect = r1;
    }

    public final boolean getShowDivider() {
        return this.showDivider;
    }

    public final void setShowDivider(boolean r1) {
        this.showDivider = r1;
    }

    public OSelectionPanelItemView(Context r10, AttributeSet r11, boolean r12, boolean r13) {
        Context r14 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r14, "context");
        super(r14, r4, 0, null, 12, null);
        this.isMultiSelect = r12;
        this.showDivider = r13;
        this.showSelectLabel = true;
        ConstraintLayout.inflate(r14, ZeusTransformUtils.mapRes(R.layout.o_view_selection_item, "layout", "o_view_selection_item"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.aiagent.plugin"));
        setMinHeight((int) ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getDimension(ZeusTransformUtils.mapRes(R.dimen.oui_h_l2, "dimen", "oui_h_l2")));
        View r15 = findViewById(ZeusTransformUtils.mapRes(R.id.iv_icon, DbHelper.COL_ID, "iv_icon"));
        o.c(r15, "findViewById(R.id.iv_icon)");
        this.ivIcon = (ImageView) ZeusTransformUtils.preCheckCast(r15, ImageView.class, "com.obric.aiagent.plugin");
        View r16 = findViewById(ZeusTransformUtils.mapRes(R.id.tv_text, DbHelper.COL_ID, "tv_text"));
        o.c(r16, "findViewById(R.id.tv_text)");
        this.tvText = (OTextView) ZeusTransformUtils.preCheckCast(r16, OTextView.class, "com.obric.aiagent.plugin");
        View r17 = findViewById(ZeusTransformUtils.mapRes(R.id.radio, DbHelper.COL_ID, "radio"));
        o.c(r17, "findViewById(R.id.radio)");
        this.radio = (ORadio) ZeusTransformUtils.preCheckCast(r17, ORadio.class, "com.obric.aiagent.plugin");
        View r18 = findViewById(ZeusTransformUtils.mapRes(R.id.checkbox, DbHelper.COL_ID, "checkbox"));
        o.c(r18, "findViewById(R.id.checkbox)");
        OCheckBox r19 = (OCheckBox) ZeusTransformUtils.preCheckCast(r18, OCheckBox.class, "com.obric.aiagent.plugin");
        this.checkbox = r19;
        View r110 = findViewById(ZeusTransformUtils.mapRes(R.id.divider, DbHelper.COL_ID, "divider"));
        o.c(r110, "findViewById(R.id.divider)");
        this.divider = r110;
        r19.setClickable(false);
        setRadius((int) ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getDimension(ZeusTransformUtils.mapRes(R.dimen.oui_r_l3_rect, "dimen", "oui_r_l3_rect")));
        setSelectMode(this.isMultiSelect);
        setDividerMode(this.showDivider);
        setPadding(ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.oui_p_list_item_2, "dimen", "oui_p_list_item_2")), getPaddingTop(), ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.oui_p_list_item_2, "dimen", "oui_p_list_item_2")), getPaddingBottom());
        addAccessibilityCompat();
    }

    public final boolean isItemSelected() {
        if (this.isMultiSelect == false) goto L6;
        return this.checkbox.isChecked();
    L6:
        return this.radio.isChecked();
    }

    public final void setItemSelected(boolean r2) {
        if (this.isMultiSelect == false) goto L5;
        this.checkbox.setChecked(r2);
    L7:
        if (this.showSelectLabel == true) goto L10;
        k.c((View) ZeusTransformUtils.preCheckCast(this.radio, View.class, "com.obric.aiagent.plugin"));
        return;
    L10:
        return;
    L5:
        this.radio.setChecked(r2);
        goto L7
    }

    private final void addAccessibilityCompat() {
        ViewCompat.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), (AccessibilityDelegateCompat) ZeusTransformUtils.preCheckCast(new a(this), AccessibilityDelegateCompat.class, "com.obric.aiagent.plugin"));
    }

    public final void dismissDivider() {
        k.b(this.divider);
    }

    public final void select() {
        setItemSelected(true);
    }

    public final void unSelect() {
        setItemSelected(false);
    }

    private final void setDividerMode(boolean r1) {
        if (r1 == false) goto L4;
        k.a(this.divider);
        return;
    L4:
        k.b(this.divider);
    }

    public final void showSelectLabel(boolean r3) {
        this.showSelectLabel = r3;
        if (r3 == false) goto L5;
        setSelectMode(this.isMultiSelect);
        return;
    L5:
        k.b((View) ZeusTransformUtils.preCheckCast(this.checkbox, View.class, "com.obric.aiagent.plugin"));
        k.b((View) ZeusTransformUtils.preCheckCast(this.radio, View.class, "com.obric.aiagent.plugin"));
    }

    public final void setSelectMode(boolean r3) {
        this.isMultiSelect = r3;
        if (r3 == false) goto L5;
        k.a((View) ZeusTransformUtils.preCheckCast(this.checkbox, View.class, "com.obric.aiagent.plugin"));
        k.b((View) ZeusTransformUtils.preCheckCast(this.radio, View.class, "com.obric.aiagent.plugin"));
    L6:
        setItemSelected(isItemSelected());
        return;
    L5:
        k.b((View) ZeusTransformUtils.preCheckCast(this.checkbox, View.class, "com.obric.aiagent.plugin"));
        k.a((View) ZeusTransformUtils.preCheckCast(this.radio, View.class, "com.obric.aiagent.plugin"));
        goto L6
    }

    public final ImageView getIconView() {
        return this.ivIcon;
    }

    public final OTextView getTextView() {
        return this.tvText;
    }

    public final ORadio getRadioView() {
        return this.radio;
    }

    public final OCheckBox getCheckBox() {
        return this.checkbox;
    }
}
