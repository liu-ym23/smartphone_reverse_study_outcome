package com.google.android.material.textfield;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.graphics.Rect;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import com.google.android.material.R;
import com.google.android.material.internal.ManufacturerUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

/* JADX INFO: loaded from: classes3.dex */
public class TextInputEditText extends AppCompatEditText {
    private final Rect parentRect;
    private boolean textInputLayoutFocusedRectEnabled;

    public TextInputEditText(@NonNull Context r10) {
        this(r10, null);
    }

    @NonNull
    private String getAccessibilityNodeInfoText(@NonNull TextInputLayout r10) {
        Editable r11 = getText();
        CharSequence r12 = r10.getHint();
        boolean r13 = TextUtils.isEmpty(r11);
        boolean r14 = TextUtils.isEmpty(r12);
        setLabelFor(R.id.textinput_helper_text);
        String r15 = "";
        if (r14 == true) goto L5;
        String r16 = r12.toString();
    L6:
        if (r13 == true) goto L13;
        StringBuilder r17 = new StringBuilder();
        r17.append(r11);
        if (TextUtils.isEmpty(r16) == true) goto L10;
        r15 = ", " + r16;
    L10:
        r17.append(r15);
        return r17.toString();
    L13:
        if (TextUtils.isEmpty(r16) == true) goto L15;
        return r16;
    L15:
        return "";
    L5:
        r16 = "";
        goto L6
    }

    @Nullable
    private CharSequence getHintFromLayout() {
        TextInputLayout r10 = getTextInputLayout();
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.getHint();
    }

    @Nullable
    private TextInputLayout getTextInputLayout() {
        ViewParent r10 = getParent();
    L4:
        if ((r10 instanceof View) == false) goto L10;
        if ((r10 instanceof TextInputLayout) == true) goto L8;
        r10 = r10.getParent();
        goto L4
    L8:
        return (TextInputLayout) r10;
    L10:
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public void getFocusedRect(@Nullable Rect r10) {
        super.getFocusedRect(r10);
        TextInputLayout r11 = getTextInputLayout();
        if (r11 != null) goto L5;
        return;
    L5:
        if (this.textInputLayoutFocusedRectEnabled == false) goto L10;
        if (r10 == null) goto L11;
        r11.getFocusedRect(this.parentRect);
        r10.bottom = this.parentRect.bottom;
        return;
    L11:
        return;
    }

    @Override // android.view.View
    public boolean getGlobalVisibleRect(@Nullable Rect r10, @Nullable Point r11) {
        boolean r12 = super.getGlobalVisibleRect(r10, r11);
        TextInputLayout r13 = getTextInputLayout();
        if (r13 != null) goto L5;
    L8:
        return r12;
    L5:
        if (this.textInputLayoutFocusedRectEnabled == false) goto L8;
        if (r10 == null) goto L8;
        r13.getGlobalVisibleRect(this.parentRect, r11);
        r10.bottom = this.parentRect.bottom;
        goto L8
    }

    @Override // android.widget.TextView
    @Nullable
    public CharSequence getHint() {
        TextInputLayout r10 = getTextInputLayout();
        if (r10 == null) goto L9;
        if (r10.isProvidingHint() == false) goto L9;
        return r10.getHint();
    L9:
        return super.getHint();
    }

    public boolean isTextInputLayoutFocusedRectEnabled() {
        return this.textInputLayoutFocusedRectEnabled;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextInputLayout r10 = getTextInputLayout();
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

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.TextView, android.view.View
    @Nullable
    public InputConnection onCreateInputConnection(@NonNull EditorInfo r10) {
        InputConnection r11 = super.onCreateInputConnection(r10);
        if (r11 != null) goto L5;
    L7:
        return r11;
    L5:
        if (r10.hintText != null) goto L7;
        r10.hintText = getHintFromLayout();
        goto L7
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo r10) {
        super.onInitializeAccessibilityNodeInfo(r10);
        getTextInputLayout();
    }

    @Override // android.view.View
    public boolean requestRectangleOnScreen(@Nullable Rect r10) {
        boolean r11 = super.requestRectangleOnScreen(r10);
        TextInputLayout r12 = getTextInputLayout();
        if (r12 != null) goto L5;
    L7:
        return r11;
    L5:
        if (this.textInputLayoutFocusedRectEnabled == false) goto L7;
        this.parentRect.set(0, r12.getHeight() - getResources().getDimensionPixelOffset(R.dimen.mtrl_edittext_rectangle_top_offset), r12.getWidth(), r12.getHeight());
        r12.requestRectangleOnScreen(this.parentRect, true);
        goto L7
    }

    public void setTextInputLayoutFocusedRectEnabled(boolean r10) {
        this.textInputLayoutFocusedRectEnabled = r10;
    }

    public TextInputEditText(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, R.attr.editTextStyle);
    }

    public TextInputEditText(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        super(MaterialThemeOverlay.wrap(r10, r11, r12, 0), r11, r12);
        this.parentRect = new Rect();
        TypedArray r13 = ThemeEnforcement.obtainStyledAttributes(r10, r11, R.styleable.TextInputEditText, r12, R.style.Widget_Design_TextInputEditText, new int[0]);
        setTextInputLayoutFocusedRectEnabled(r13.getBoolean(R.styleable.TextInputEditText_textInputLayoutFocusedRectEnabled, false));
        r13.recycle();
    }
}
