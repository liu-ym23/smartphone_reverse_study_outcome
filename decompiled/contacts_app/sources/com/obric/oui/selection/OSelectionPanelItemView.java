package com.obric.oui.selection;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import com.obric.common.oui.R;
import com.obric.oui.checkbox.OCheckBox;
import com.obric.oui.common.util.ViewExtensionsKt;
import com.obric.oui.layout.OUIConstraintLayout;
import com.obric.oui.radio.ORadio;
import com.obric.oui.text.OTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OSelectionPanelItemView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\b\u0010\u001d\u001a\u00020\u001eH\u0002J\u0006\u0010\u001f\u001a\u00020\u001eJ\u0006\u0010 \u001a\u00020\u000bJ\u0006\u0010!\u001a\u00020\u0015J\u0006\u0010\"\u001a\u00020\u0017J\u0006\u0010#\u001a\u00020\u001cJ\u0006\u0010$\u001a\u00020\u001eJ\u0010\u0010%\u001a\u00020\u001e2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u000e\u0010&\u001a\u00020\u001e2\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\u001a\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020\u0007J\u0006\u0010(\u001a\u00020\u001eR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0010\"\u0004\b\u0013\u0010\u0012R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0010\"\u0004\b\u0019\u0010\u0012R\u000e\u0010\u001a\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/obric/oui/selection/OSelectionPanelItemView;", "Lcom/obric/oui/layout/OUIConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "isMultiSelect", "", "showDivider", "(Landroid/content/Context;Landroid/util/AttributeSet;ZZ)V", "checkbox", "Lcom/obric/oui/checkbox/OCheckBox;", "divider", "Landroid/view/View;", "value", "isItemSelected", "()Z", "setItemSelected", "(Z)V", "setMultiSelect", "ivIcon", "Landroid/widget/ImageView;", "radio", "Lcom/obric/oui/radio/ORadio;", "getShowDivider", "setShowDivider", "showSelectLabel", "tvText", "Lcom/obric/oui/text/OTextView;", "addAccessibilityCompat", "", "dismissDivider", "getCheckBox", "getIconView", "getRadioView", "getTextView", "select", "setDividerMode", "setSelectMode", "show", "unSelect", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OSelectionPanelItemView extends OUIConstraintLayout {
    private final OCheckBox checkbox;
    private final View divider;
    private boolean isMultiSelect;
    private final ImageView ivIcon;
    private final ORadio radio;
    private boolean showDivider;
    private boolean showSelectLabel;
    private final OTextView tvText;

    public OSelectionPanelItemView(Context r9) {
        Intrinsics.checkNotNullParameter(r9, "context");
        this(r9, null, false, false, 14, null);
    }

    public OSelectionPanelItemView(Context r9, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r9, "context");
        this(r9, r10, false, false, 12, null);
    }

    public OSelectionPanelItemView(Context r9, AttributeSet r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r9, "context");
        this(r9, r10, r11, false, 8, null);
    }

    public /* synthetic */ OSelectionPanelItemView(Context r2, AttributeSet r3, boolean r4, boolean r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = false;
    L9:
        if ((r6 & 8) == 0) goto L11;
        r5 = false;
    L11:
        this(r2, r3, r4, r5);
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

    public OSelectionPanelItemView(Context r9, AttributeSet r10, boolean r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r9, "context");
        super(r9, r10, 0, null, 12, null);
        this.isMultiSelect = r11;
        this.showDivider = r12;
        this.showSelectLabel = true;
        ConstraintLayout.inflate(r9, R.layout.o_view_selection_item, this);
        setMinHeight((int) getResources().getDimension(R.dimen.oui_h_l2));
        View r13 = findViewById(R.id.iv_icon);
        Intrinsics.checkNotNullExpressionValue(r13, "findViewById(R.id.iv_icon)");
        this.ivIcon = (ImageView) r13;
        View r14 = findViewById(R.id.tv_text);
        Intrinsics.checkNotNullExpressionValue(r14, "findViewById(R.id.tv_text)");
        this.tvText = (OTextView) r14;
        View r15 = findViewById(R.id.radio);
        Intrinsics.checkNotNullExpressionValue(r15, "findViewById(R.id.radio)");
        this.radio = (ORadio) r15;
        View r16 = findViewById(R.id.checkbox);
        Intrinsics.checkNotNullExpressionValue(r16, "findViewById(R.id.checkbox)");
        OCheckBox r17 = (OCheckBox) r16;
        this.checkbox = r17;
        View r18 = findViewById(R.id.divider);
        Intrinsics.checkNotNullExpressionValue(r18, "findViewById(R.id.divider)");
        this.divider = r18;
        r17.setClickable(false);
        setRadius((int) getResources().getDimension(R.dimen.oui_r_l3_rect));
        setSelectMode(this.isMultiSelect);
        setDividerMode(this.showDivider);
        setPadding(getResources().getDimensionPixelSize(R.dimen.oui_p_list_item_2), getPaddingTop(), getResources().getDimensionPixelSize(R.dimen.oui_p_list_item_2), getPaddingBottom());
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
        ViewExtensionsKt.makeInvisible(this.radio);
        return;
    L10:
        return;
    L5:
        this.radio.setChecked(r2);
        goto L7
    }

    private final void addAccessibilityCompat() {
        ViewCompat.setAccessibilityDelegate(this, new AnonymousClass1(this));
    }

    public final void dismissDivider() {
        ViewExtensionsKt.makeGone(this.divider);
    }

    public final void select() {
        setItemSelected(true);
    }

    public final void unSelect() {
        setItemSelected(false);
    }

    private final void setDividerMode(boolean r1) {
        if (r1 == false) goto L4;
        ViewExtensionsKt.makeVisible(this.divider);
        return;
    L4:
        ViewExtensionsKt.makeGone(this.divider);
    }

    public final void showSelectLabel(boolean r1) {
        this.showSelectLabel = r1;
        if (r1 == false) goto L5;
        setSelectMode(this.isMultiSelect);
        return;
    L5:
        ViewExtensionsKt.makeGone(this.checkbox);
        ViewExtensionsKt.makeGone(this.radio);
    }

    public final void setSelectMode(boolean r1) {
        this.isMultiSelect = r1;
        if (r1 == false) goto L5;
        ViewExtensionsKt.makeVisible(this.checkbox);
        ViewExtensionsKt.makeGone(this.radio);
    L6:
        setItemSelected(isItemSelected());
        return;
    L5:
        ViewExtensionsKt.makeGone(this.checkbox);
        ViewExtensionsKt.makeVisible(this.radio);
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
