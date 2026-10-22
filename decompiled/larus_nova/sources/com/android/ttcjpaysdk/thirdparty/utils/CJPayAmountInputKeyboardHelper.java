package com.android.ttcjpaysdk.thirdparty.utils;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.android.ttcjpaysdk.base.ui.component.keyboard.CJAmountKeyboardView;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes39.dex */
public class CJPayAmountInputKeyboardHelper {
    private static boolean sIsInAnimation;
    private CJAmountKeyboardView mCustomKeyboard;
    private OnDeleteListener mOnDeleteListener;
    private OnShowHideListener mOnShowHideListener;
    private boolean mShowCustomKeyboard;

    public interface OnDeleteListener {
        void onDelete();
    }

    public interface OnShowHideListener {
        void onShow(boolean r100);
    }

    public static /* synthetic */ OnDeleteListener access$000(CJPayAmountInputKeyboardHelper r100) {
        return r100.mOnDeleteListener;
    }

    public static /* synthetic */ boolean access$102(boolean r100) {
        sIsInAnimation = r100;
        return r100;
    }

    public static /* synthetic */ CJAmountKeyboardView access$200(CJPayAmountInputKeyboardHelper r100) {
        return r100.mCustomKeyboard;
    }

    public static /* synthetic */ OnShowHideListener access$300(CJPayAmountInputKeyboardHelper r100) {
        return r100.mOnShowHideListener;
    }

    private boolean hideCustomKeyboardAnimated(final Context r100) {
        CJAmountKeyboardView r101 = this.mCustomKeyboard;
        if (r101 != null) goto L5;
        return false;
    L5:
        if (r101.getVisibility() != 8) goto L7;
        return false;
    L7:
        if (this.mCustomKeyboard.getAnimation() != null) goto L14;
        this.mCustomKeyboard.post(new AnonymousClass5(this, r100));
        return true;
    L14:
        return false;
    }

    private void showCustomKeyboardAnimated(final Context r100) {
        CJAmountKeyboardView r101 = this.mCustomKeyboard;
        if (r101 != null) goto L6;
        return;
    L6:
        if (r101.getVisibility() != 0) goto L8;
        return;
    L8:
        this.mCustomKeyboard.setVisibility(0);
        OnShowHideListener r102 = this.mOnShowHideListener;
        if (r102 == null) goto L11;
        r102.onShow(true);
    L11:
        sIsInAnimation = true;
        this.mCustomKeyboard.postDelayed(new AnonymousClass3(this), 350);
        this.mCustomKeyboard.post(new AnonymousClass4(this, r100));
    }

    public boolean hideCustomKeyboard(Context r100) {
        CJAmountKeyboardView r101 = this.mCustomKeyboard;
        if (r101 != null) goto L5;
        return false;
    L5:
        if (r101.getVisibility() != 8) goto L7;
        return false;
    L7:
        if (this.mCustomKeyboard.getAnimation() == null) goto L9;
        return false;
    L9:
        if (sIsInAnimation == false) goto L12;
        return false;
    L12:
        return hideCustomKeyboardAnimated(r100);
    }

    public CJPayAmountInputKeyboardHelper(boolean r100, CJAmountKeyboardView r101) {
        this(r100, r101, false);
    }

    public void hideSystemKeyboard(Context r100, EditText r101) {
        InputMethodManager r102 = (InputMethodManager) r100.getSystemService("input_method");     // Catch: Exception -> L7
        if (r102 == null) goto L15;
        r102.hideSoftInputFromWindow(r101.getWindowToken(), 0);     // Catch: Exception -> L7
    L15:
        Method r103 = EditText.class.getMethod("setShowSoftInputOnFocus", new Class[]{Boolean.TYPE});     // Catch: Exception -> L12
        r103.setAccessible(true);     // Catch: Exception -> L12
        r103.invoke(r101, new Object[]{Boolean.FALSE});     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayAmountInputKeyboardHelper#hideSystemKeyboard", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayAmountInputKeyboardHelper#hideSystemKeyboard", e);
        e.printStackTrace();
        return;
    L7:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayAmountInputKeyboardHelper#hideSystemKeyboard", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayAmountInputKeyboardHelper#hideSystemKeyboard", e);
        goto L15
    }

    public void showCustomKeyboard(final Context r100, final EditText r101) {
        r101.post(new AnonymousClass1(this, r100, r101));
        showCustomKeyboardAnimated(r100);
        this.mCustomKeyboard.setOnKeyListener(new AnonymousClass2(this, r101));
    }

    public void showKeyboard(Context r100, EditText r101) {
        if (this.mShowCustomKeyboard == false) goto L5;
        showCustomKeyboard(r100, r101);
        return;
    L5:
        hideCustomKeyboard(r100);
        showSystemKeyboard(r100, r101);
    }

    public void showSystemKeyboard(Context r100, View r101) {
        InputMethodManager r102 = (InputMethodManager) r100.getSystemService("input_method");     // Catch: Exception -> L6
        if (r102 == null) goto L11;
        r102.showSoftInput(r101, 0);     // Catch: Exception -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayAmountInputKeyboardHelper#showSystemKeyboard", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayAmountInputKeyboardHelper#showSystemKeyboard", e);
    }

    public CJPayAmountInputKeyboardHelper(boolean r100, CJAmountKeyboardView r101, boolean r102) {
        this.mShowCustomKeyboard = r100;
        this.mCustomKeyboard = r101;
    }
}
