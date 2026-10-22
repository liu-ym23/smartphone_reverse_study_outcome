package com.android.contacts.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

/* JADX INFO: loaded from: classes2.dex */
public class SearchEditText extends EditText implements TextView.OnEditorActionListener, TextWatcher {
    private OnFilterTextListener mListener;
    private boolean mMaginfyingGlassEnabled;
    private Drawable mMagnifyingGlass;
    private boolean mMagnifyingGlassShown;

    public interface OnFilterTextListener {
        void onCancelSearch();

        void onFilterChange(String r1);
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    @Override // android.widget.TextView, android.text.TextWatcher
    public void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    public SearchEditText(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.mMaginfyingGlassEnabled = true;
        addTextChangedListener(this);
        setOnEditorActionListener(this);
        this.mMagnifyingGlass = getCompoundDrawables()[2];
        setCompoundDrawables(null, null, null, null);
    }

    public boolean isMaginfyingGlassEnabled() {
        return this.mMaginfyingGlassEnabled;
    }

    public void setMaginfyingGlassEnabled(boolean r1) {
        this.mMaginfyingGlassEnabled = r1;
    }

    public void setOnFilterTextListener(OnFilterTextListener r1) {
        this.mListener = r1;
    }

    @Override // android.widget.TextView, android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        boolean r0 = TextUtils.isEmpty(getText());
        if (this.mMagnifyingGlassShown == r0) goto L13;
        this.mMagnifyingGlassShown = r0;
        if (r0 == true) goto L7;
    L9:
        setCompoundDrawables(null, null, null, null);
        return false;
    L7:
        if (this.mMaginfyingGlassEnabled == false) goto L9;
        setCompoundDrawables(null, null, this.mMagnifyingGlass, null);
        return false;
    L13:
        return super.onPreDraw();
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onKeyPreIme(int r1, KeyEvent r2) {
        if (r1 == 4) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(getText()) == false) goto L12;
        OnFilterTextListener r0 = this.mListener;
        if (r0 == null) goto L13;
        r0.onCancelSearch();
        return true;
    L13:
        return false;
    L12:
        return false;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable r2) {
        OnFilterTextListener r0 = this.mListener;
        if (r0 == null) goto L6;
        r0.onFilterChange(trim(r2));
        return;
    }

    private String trim(Editable r1) {
        return r1.toString().trim();
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView r1, int r2, KeyEvent r3) {
        if (r2 != 6) goto L11;
        hideSoftKeyboard();
        if (TextUtils.isEmpty(trim(getText())) == false) goto L13;
        OnFilterTextListener r0 = this.mListener;
        if (r0 == null) goto L14;
        r0.onCancelSearch();
        return true;
    L14:
        return true;
    L13:
        return true;
    L11:
        return false;
    }

    private void hideSoftKeyboard() {
        ((InputMethodManager) getContext().getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 0);
    }
}
