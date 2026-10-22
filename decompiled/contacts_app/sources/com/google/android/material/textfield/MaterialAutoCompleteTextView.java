package com.google.android.material.textfield;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Filterable;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.appcompat.widget.ListPopupWindow;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ManufacturerUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

/* JADX INFO: loaded from: classes2.dex */
public class MaterialAutoCompleteTextView extends AppCompatAutoCompleteTextView {
    private static final int MAX_ITEMS_MEASURED = 15;
    private final AccessibilityManager accessibilityManager;
    private final ListPopupWindow modalListPopup;
    private final float popupElevation;
    private final int simpleItemLayout;
    private int simpleItemSelectedColor;
    private ColorStateList simpleItemSelectedRippleColor;
    private final Rect tempRect;

    private class MaterialArrayAdapter<T> extends ArrayAdapter<String> {
        private ColorStateList pressedRippleColor;
        private ColorStateList selectedItemRippleOverlaidColor;
        final /* synthetic */ MaterialAutoCompleteTextView this$0;

        MaterialArrayAdapter(MaterialAutoCompleteTextView r1, Context r2, int r3, String[] r4) {
            this.this$0 = r1;
            super(r2, r3, r4);
            updateSelectedItemColorStateList();
        }

        void updateSelectedItemColorStateList() {
            this.pressedRippleColor = sanitizeDropdownItemSelectedRippleColor();
            this.selectedItemRippleOverlaidColor = createItemSelectedColorStateList();
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int r2, View r3, ViewGroup r4) {
            View r5 = super.getView(r2, r3, r4);
            if ((r5 instanceof TextView) == false) goto L9;
            TextView r6 = (TextView) r5;
            if (this.this$0.getText().toString().contentEquals(r6.getText()) == false) goto L7;
            Drawable r1 = getSelectedItemDrawable();
        L8:
            ViewCompat.setBackground(r6, r1);
            goto L9
        L7:
            r1 = null;
        L9:
            return r5;
        }

        private Drawable getSelectedItemDrawable() {
            if (hasSelectedColor() == false) goto L9;
            ColorDrawable r0 = new ColorDrawable(MaterialAutoCompleteTextView.access$200(this.this$0));
            if (this.pressedRippleColor == null) goto L8;
            DrawableCompat.setTintList(r0, this.selectedItemRippleOverlaidColor);
            return new RippleDrawable(this.pressedRippleColor, r0, null);
        L8:
            return r0;
        L9:
            return null;
        }

        private ColorStateList createItemSelectedColorStateList() {
            if (hasSelectedColor() == true) goto L5;
            return null;
        L5:
            if (hasSelectedRippleColor() == false) goto L10;
            int[] r1 = {R.attr.state_hovered, -16842919};
            int[] r2 = {R.attr.state_selected, -16842919};
            int[] r7 = {MaterialColors.layer(MaterialAutoCompleteTextView.access$200(this.this$0), MaterialAutoCompleteTextView.access$300(this.this$0).getColorForState(r2, 0)), MaterialColors.layer(MaterialAutoCompleteTextView.access$200(this.this$0), MaterialAutoCompleteTextView.access$300(this.this$0).getColorForState(r1, 0)), MaterialAutoCompleteTextView.access$200(this.this$0)};
            return new ColorStateList(new int[][]{r2, r1, new int[0]}, r7);
        L10:
            return null;
        }

        private ColorStateList sanitizeDropdownItemSelectedRippleColor() {
            if (hasSelectedRippleColor() == true) goto L6;
            return null;
        L6:
            int[] r1 = {R.attr.state_pressed};
            int[] r4 = {MaterialAutoCompleteTextView.access$300(this.this$0).getColorForState(r1, 0), 0};
            return new ColorStateList(new int[][]{r1, new int[0]}, r4);
        }

        private boolean hasSelectedColor() {
            if (MaterialAutoCompleteTextView.access$200(this.this$0) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        private boolean hasSelectedRippleColor() {
            if (MaterialAutoCompleteTextView.access$300(this.this$0) == null) goto L5;
            return true;
        L5:
            return false;
        }
    }

    static /* synthetic */ ListPopupWindow access$000(MaterialAutoCompleteTextView r0) {
        return r0.modalListPopup;
    }

    static /* synthetic */ void access$100(MaterialAutoCompleteTextView r0, Object r1) {
        r0.updateText(r1);
    }

    static /* synthetic */ int access$200(MaterialAutoCompleteTextView r0) {
        return r0.simpleItemSelectedColor;
    }

    static /* synthetic */ ColorStateList access$300(MaterialAutoCompleteTextView r0) {
        return r0.simpleItemSelectedRippleColor;
    }

    public MaterialAutoCompleteTextView(Context r2) {
        this(r2, null);
    }

    public MaterialAutoCompleteTextView(Context r2, AttributeSet r3) {
        this(r2, r3, com.google.android.material.R.attr.autoCompleteTextViewStyle);
    }

    public MaterialAutoCompleteTextView(Context r8, AttributeSet r9, int r10) {
        super(MaterialThemeOverlay.wrap(r8, r9, r10, 0), r9, r10);
        this.tempRect = new Rect();
        Context r11 = getContext();
        TypedArray r12 = ThemeEnforcement.obtainStyledAttributes(r11, r9, com.google.android.material.R.styleable.MaterialAutoCompleteTextView, r10, com.google.android.material.R.style.Widget_AppCompat_AutoCompleteTextView, new int[0]);
        if (r12.hasValue(com.google.android.material.R.styleable.MaterialAutoCompleteTextView_android_inputType) == true) goto L5;
    L7:
        this.simpleItemLayout = r12.getResourceId(com.google.android.material.R.styleable.MaterialAutoCompleteTextView_simpleItemLayout, com.google.android.material.R.layout.mtrl_auto_complete_simple_item);
        this.popupElevation = r12.getDimensionPixelOffset(com.google.android.material.R.styleable.MaterialAutoCompleteTextView_android_popupElevation, com.google.android.material.R.dimen.mtrl_exposed_dropdown_menu_popup_elevation);
        this.simpleItemSelectedColor = r12.getColor(com.google.android.material.R.styleable.MaterialAutoCompleteTextView_simpleItemSelectedColor, 0);
        this.simpleItemSelectedRippleColor = MaterialResources.getColorStateList(r11, r12, com.google.android.material.R.styleable.MaterialAutoCompleteTextView_simpleItemSelectedRippleColor);
        this.accessibilityManager = (AccessibilityManager) r11.getSystemService("accessibility");
        ListPopupWindow r13 = new ListPopupWindow(r11);
        this.modalListPopup = r13;
        r13.setModal(true);
        r13.setAnchorView(this);
        r13.setInputMethodMode(2);
        r13.setAdapter(getAdapter());
        r13.setOnItemClickListener(new AnonymousClass1(this));
        if (r12.hasValue(com.google.android.material.R.styleable.MaterialAutoCompleteTextView_simpleItems) == false) goto L10;
        setSimpleItems(r12.getResourceId(com.google.android.material.R.styleable.MaterialAutoCompleteTextView_simpleItems, 0));
    L10:
        r12.recycle();
        return;
    L5:
        if (r12.getInt(com.google.android.material.R.styleable.MaterialAutoCompleteTextView_android_inputType, 0) != 0) goto L7;
        setKeyListener(null);
        goto L7
    }

    @Override // android.widget.AutoCompleteTextView
    public void showDropDown() {
        if (isTouchExplorationEnabled() == false) goto L5;
        this.modalListPopup.show();
        return;
    L5:
        super.showDropDown();
    }

    @Override // android.widget.AutoCompleteTextView
    public void dismissDropDown() {
        if (isTouchExplorationEnabled() == false) goto L5;
        this.modalListPopup.dismiss();
        return;
    L5:
        super.dismissDropDown();
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    public void onWindowFocusChanged(boolean r2) {
        if (isTouchExplorationEnabled() == false) goto L5;
        return;
    L5:
        super.onWindowFocusChanged(r2);
    }

    private boolean isTouchExplorationEnabled() {
        AccessibilityManager r0 = this.accessibilityManager;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isTouchExplorationEnabled() == false) goto L7;
        return true;
    }

    @Override // android.widget.AutoCompleteTextView
    public <T extends ListAdapter & Filterable> void setAdapter(T r1) {
        super.setAdapter(r1);
        this.modalListPopup.setAdapter(getAdapter());
    }

    @Override // android.widget.TextView
    public void setRawInputType(int r1) {
        super.setRawInputType(r1);
        onInputTypeChanged();
    }

    @Override // android.widget.AutoCompleteTextView
    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener r1) {
        super.setOnItemSelectedListener(r1);
        this.modalListPopup.setOnItemSelectedListener(getOnItemSelectedListener());
    }

    public void setSimpleItems(int r2) {
        setSimpleItems(getResources().getStringArray(r2));
    }

    public void setSimpleItems(String[] r4) {
        setAdapter(new MaterialArrayAdapter(this, getContext(), this.simpleItemLayout, r4));
    }

    public void setSimpleItemSelectedColor(int r1) {
        this.simpleItemSelectedColor = r1;
        if ((getAdapter() instanceof MaterialArrayAdapter) == false) goto L6;
        ((MaterialArrayAdapter) getAdapter()).updateSelectedItemColorStateList();
        return;
    }

    public int getSimpleItemSelectedColor() {
        return this.simpleItemSelectedColor;
    }

    public void setSimpleItemSelectedRippleColor(ColorStateList r1) {
        this.simpleItemSelectedRippleColor = r1;
        if ((getAdapter() instanceof MaterialArrayAdapter) == false) goto L6;
        ((MaterialArrayAdapter) getAdapter()).updateSelectedItemColorStateList();
        return;
    }

    public ColorStateList getSimpleItemSelectedRippleColor() {
        return this.simpleItemSelectedRippleColor;
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundDrawable(Drawable r1) {
        super.setDropDownBackgroundDrawable(r1);
        ListPopupWindow r0 = this.modalListPopup;
        if (r0 == null) goto L6;
        r0.setBackgroundDrawable(r1);
        return;
    }

    public float getPopupElevation() {
        return this.popupElevation;
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextInputLayout r0 = findTextInputLayoutAncestor();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isProvidingHint() == true) goto L7;
        return;
    L7:
        if (super.getHint() == null) goto L9;
        return;
    L9:
        if (ManufacturerUtils.isMeizuDevice() == false) goto L15;
        setHint("");
        return;
    }

    @Override // android.widget.AutoCompleteTextView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.modalListPopup.dismiss();
    }

    @Override // android.widget.TextView
    public CharSequence getHint() {
        TextInputLayout r0 = findTextInputLayoutAncestor();
        if (r0 == null) goto L9;
        if (r0.isProvidingHint() == false) goto L9;
        return r0.getHint();
    L9:
        return super.getHint();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int r2, int r3) {
        super.onMeasure(r2, r3);
        if (View.MeasureSpec.getMode(r2) != Integer.MIN_VALUE) goto L6;
        setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), measureContentWidth()), View.MeasureSpec.getSize(r2)), getMeasuredHeight());
        return;
    }

    private int measureContentWidth() {
        ListAdapter r0 = getAdapter();
        TextInputLayout r1 = findTextInputLayoutAncestor();
        int r2 = 0;
        if (r0 == null) goto L20;
        if (r1 == null) goto L20;
        int r3 = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int r4 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int r5 = Math.min(r0.getCount(), Math.max(0, this.modalListPopup.getSelectedItemPosition()) + 15);
        int r8 = Math.max(0, r5 - 15);
        View r9 = null;
        int r6 = 0;
    L7:
        if (r8 >= r5) goto L15;
        int r10 = r0.getItemViewType(r8);
        if (r10 == r2) goto L11;
        r9 = null;
        r2 = r10;
    L11:
        r9 = r0.getView(r8, r9, r1);
        if (r9.getLayoutParams() != null) goto L14;
        r9.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    L14:
        r9.measure(r3, r4);
        r6 = Math.max(r6, r9.getMeasuredWidth());
        r8 = r8 + 1;
        goto L7
    L15:
        Drawable r7 = this.modalListPopup.getBackground();
        if (r7 == null) goto L19;
        r7.getPadding(this.tempRect);
        r6 = r6 + (this.tempRect.left + this.tempRect.right);
    L19:
        return r6 + r1.getEndIconView().getMeasuredWidth();
    L20:
        return 0;
    }

    private void onInputTypeChanged() {
        TextInputLayout r0 = findTextInputLayoutAncestor();
        if (r0 == null) goto L6;
        r0.updateEditTextBoxBackgroundIfNeeded();
        return;
    }

    private TextInputLayout findTextInputLayoutAncestor() {
        ViewParent r1 = getParent();
    L3:
        if (r1 == null) goto L9;
        if ((r1 instanceof TextInputLayout) == true) goto L7;
        r1 = r1.getParent();
        goto L3
    L7:
        return (TextInputLayout) r1;
    L9:
        return null;
    }

    private <T extends ListAdapter & Filterable> void updateText(Object r2) {
        setText(convertSelectionToString(r2), false);
    }
}
