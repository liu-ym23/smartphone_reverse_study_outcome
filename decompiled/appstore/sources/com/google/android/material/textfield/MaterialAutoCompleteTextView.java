package com.google.android.material.textfield;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.Filterable;
import android.widget.ListAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.appcompat.widget.ListPopupWindow;
import com.google.android.material.R;
import com.google.android.material.internal.ManufacturerUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

/* JADX INFO: loaded from: classes3.dex */
public class MaterialAutoCompleteTextView extends AppCompatAutoCompleteTextView {
    private static final int MAX_ITEMS_MEASURED = 15;

    @Nullable
    private final AccessibilityManager accessibilityManager;

    @NonNull
    private final ListPopupWindow modalListPopup;

    @NonNull
    private final Rect tempRect;

    public MaterialAutoCompleteTextView(@NonNull Context r10) {
        this(r10, null);
    }

    public static /* synthetic */ ListPopupWindow access$000(MaterialAutoCompleteTextView r10) {
        return r10.modalListPopup;
    }

    public static /* synthetic */ void access$100(MaterialAutoCompleteTextView r10, Object r11) {
        r10.updateText(r11);
    }

    @Nullable
    private TextInputLayout findTextInputLayoutAncestor() {
        ViewParent r10 = getParent();
    L3:
        if (r10 == null) goto L9;
        if ((r10 instanceof TextInputLayout) == true) goto L7;
        r10 = r10.getParent();
        goto L3
    L7:
        return (TextInputLayout) r10;
    L9:
        return null;
    }

    private int measureContentWidth() {
        ListAdapter r10 = getAdapter();
        TextInputLayout r11 = findTextInputLayoutAncestor();
        int r12 = 0;
        if (r10 == null) goto L20;
        if (r11 == null) goto L20;
        int r13 = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int r14 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int r15 = Math.min(r10.getCount(), Math.max(0, this.modalListPopup.h()) + 15);
        int r16 = Math.max(0, r15 - 15);
        View r17 = null;
        int r18 = 0;
    L7:
        if (r16 >= r15) goto L15;
        int r19 = r10.getItemViewType(r16);
        if (r19 == r12) goto L11;
        r17 = null;
        r12 = r19;
    L11:
        r17 = r10.getView(r16, r17, r11);
        if (r17.getLayoutParams() != null) goto L14;
        r17.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    L14:
        r17.measure(r13, r14);
        r18 = Math.max(r18, r17.getMeasuredWidth());
        r16 = r16 + 1;
        goto L7
    L15:
        Drawable r20 = this.modalListPopup.getBackground();
        if (r20 == null) goto L19;
        r20.getPadding(this.tempRect);
        Rect r110 = this.tempRect;
        r18 = r18 + (r110.left + r110.right);
    L19:
        return r18 + r11.getEndIconView().getMeasuredWidth();
    L20:
        return 0;
    }

    private <T extends ListAdapter & Filterable> void updateText(Object r10) {
        setText(convertSelectionToString(r10), false);
    }

    @Override // android.widget.TextView
    @Nullable
    public CharSequence getHint() {
        TextInputLayout r10 = findTextInputLayoutAncestor();
        if (r10 == null) goto L9;
        if (r10.isProvidingHint() == false) goto L9;
        return r10.getHint();
    L9:
        return super.getHint();
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextInputLayout r10 = findTextInputLayoutAncestor();
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.isProvidingHint() == true) goto L7;
        return;
    L7:
        if (super.getHint() == null) goto L9;
        return;
    L9:
        if (ManufacturerUtils.isMeizuDevice() == false) goto L15;
        setHint("");
        return;
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
        if (View.MeasureSpec.getMode(r10) != Integer.MIN_VALUE) goto L6;
        setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), measureContentWidth()), View.MeasureSpec.getSize(r10)), getMeasuredHeight());
        return;
    }

    @Override // android.widget.AutoCompleteTextView
    public <T extends ListAdapter & Filterable> void setAdapter(@Nullable T r10) {
        super.setAdapter(r10);
        this.modalListPopup.setAdapter(getAdapter());
    }

    @Override // android.widget.AutoCompleteTextView
    public void showDropDown() {
        AccessibilityManager r10 = this.accessibilityManager;
        if (r10 != null) goto L5;
    L7:
        super.showDropDown();
        return;
    L5:
        if (r10.isTouchExplorationEnabled() == false) goto L7;
        this.modalListPopup.show();
    }

    public MaterialAutoCompleteTextView(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, R.attr.autoCompleteTextViewStyle);
    }

    public MaterialAutoCompleteTextView(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        super(MaterialThemeOverlay.wrap(r10, r11, r12, 0), r11, r12);
        this.tempRect = new Rect();
        Context r13 = getContext();
        TypedArray r14 = ThemeEnforcement.obtainStyledAttributes(r13, r11, R.styleable.MaterialAutoCompleteTextView, r12, R.style.Widget_AppCompat_AutoCompleteTextView, new int[0]);
        int r15 = R.styleable.MaterialAutoCompleteTextView_android_inputType;
        if (r14.hasValue(r15) == true) goto L5;
    L7:
        this.accessibilityManager = (AccessibilityManager) r13.getSystemService("accessibility");
        ListPopupWindow r16 = new ListPopupWindow(r13);
        this.modalListPopup = r16;
        r16.t(true);
        r16.n(this);
        r16.s(2);
        r16.setAdapter(getAdapter());
        r16.setOnItemClickListener(new AnonymousClass1(this));
        r14.recycle();
        return;
    L5:
        if (r14.getInt(r15, 0) != 0) goto L7;
        setKeyListener(null);
        goto L7
    }
}
