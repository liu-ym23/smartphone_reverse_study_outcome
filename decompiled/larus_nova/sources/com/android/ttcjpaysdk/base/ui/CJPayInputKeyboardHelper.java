package com.android.ttcjpaysdk.base.ui;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.android.ttcjpaysdk.base.CJPayConstant;
import com.android.ttcjpaysdk.base.CJPayHostInfo;
import com.android.ttcjpaysdk.base.ui.widget.CJPayKeyboardView;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.larus.home.impl.utils.c;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.reflect.Method;
import java.util.Map;

/* JADX INFO: loaded from: classes28.dex */
public class CJPayInputKeyboardHelper {
    private static boolean sIsInAnimation;
    private CJPayKeyboardView mCustomKeyboard;
    private OnDeleteListener mOnDeleteListener;
    private OnShowHideListener mOnShowHideListener;
    private boolean mShowCustomKeyboard;
    private boolean mShowXInKeyboard;

    public interface OnDeleteListener {
        void onDelete();
    }

    public interface OnShowHideListener {
        void onShow(boolean r100);
    }

    public static View INVOKEVIRTUAL_com_android_ttcjpaysdk_base_ui_CJPayInputKeyboardHelper_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r100) {
        View r101 = r100.getDecorView();
        if (c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == c.f346341a) goto L7;
        c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public static /* synthetic */ OnDeleteListener access$000(CJPayInputKeyboardHelper r100) {
        return r100.mOnDeleteListener;
    }

    static /* synthetic */ boolean access$102(boolean r100) {
        sIsInAnimation = r100;
        return r100;
    }

    public static void hideSystemKeyboard(Context r100) {
        if ((r100 instanceof Activity) == true) goto L5;
        return;
    L5:
        Activity r101 = (Activity) r100;
        InputMethodManager r102 = (InputMethodManager) r100.getSystemService("input_method");
        if (r102 == null) goto L11;
        View r103 = r101.getCurrentFocus();
        if (r103 == null) goto L12;
        r102.hideSoftInputFromWindow(r103.getWindowToken(), 2);
        return;
    L12:
        return;
    }

    public static void hideSystemKeyboardALL(Context r100) {
        if ((r100 instanceof Activity) == true) goto L5;
        return;
    L5:
        Activity r101 = (Activity) r100;
        InputMethodManager r102 = (InputMethodManager) r100.getSystemService("input_method");
        if (r102 != null) goto L8;
        return;
    L8:
        if (r101.getWindow() == null) goto L12;
        r102.hideSoftInputFromWindow(INVOKEVIRTUAL_com_android_ttcjpaysdk_base_ui_CJPayInputKeyboardHelper_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r101.getWindow()).getWindowToken(), 2);
        return;
    }

    private void showCustomKeyboardAnimated(Context r100) {
        CJPayKeyboardView r101 = this.mCustomKeyboard;
        if (r101 != null) goto L6;
        return;
    L6:
        if (this.mShowXInKeyboard == false) goto L8;
        r101.showX();
    L10:
        if (this.mCustomKeyboard.getVisibility() != 0) goto L12;
        return;
    L12:
        this.mCustomKeyboard.setVisibility(0);
        sIsInAnimation = true;
        this.mCustomKeyboard.postDelayed(new AnonymousClass2(this), 500);
        Map<String, Integer> r102 = CJPayHostInfo.animationResourceMap;
        if (r102 != null) goto L15;
        Animation r103 = AnimationUtils.loadAnimation(r100, R.anim.cj_pay_slide_in_from_bottom_with_bezier);
        this.mCustomKeyboard.startAnimation(r103);
    L18:
        OnShowHideListener r104 = this.mOnShowHideListener;
        if (r104 == null) goto L22;
        r104.onShow(true);
        return;
    L22:
        return;
    L15:
        if (r102.containsKey(CJPayConstant.TT_CJ_PAY_KEY_SLIDE_IN_FROM_BOTTOM_ANIMATION_RESOURCE) == false) goto L18;
        Animation r105 = AnimationUtils.loadAnimation(r100, CJPayHostInfo.animationResourceMap.get(CJPayConstant.TT_CJ_PAY_KEY_SLIDE_IN_FROM_BOTTOM_ANIMATION_RESOURCE).intValue());
        this.mCustomKeyboard.startAnimation(r105);
        goto L18
    L8:
        r101.hideX();
        goto L10
    }

    public void setOnDeleteListener(OnDeleteListener r100) {
        this.mOnDeleteListener = r100;
    }

    public void setOnExpandCollapseListener(OnShowHideListener r100) {
        this.mOnShowHideListener = r100;
    }

    public void setShowCustomKeyboard(boolean r100) {
        this.mShowCustomKeyboard = r100;
    }

    public void setShowXInKeyboard(boolean r100) {
        this.mShowXInKeyboard = r100;
    }

    public CJPayInputKeyboardHelper(boolean r100, CJPayKeyboardView r101) {
        this(r100, r101, false);
    }

    public static boolean hideCustomKeyboard(Context r100, CJPayKeyboardView r101) {
        return hideCustomKeyboard(r100, r101, null);
    }

    public static void hideSystemKeyboard(Context r100, EditText r101) {
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
        CJBasicCommonUtils.reportCatchException("CJPayInputKeyboardHelper#hideSystemKeyboard", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayInputKeyboardHelper#hideSystemKeyboard", e);
        e.printStackTrace();
        return;
    L7:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayInputKeyboardHelper#hideSystemKeyboard", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayInputKeyboardHelper#hideSystemKeyboard", e);
        goto L15
    }

    public static void showSystemKeyboard(Context r100, View r101) {
        InputMethodManager r102 = (InputMethodManager) r100.getSystemService("input_method");     // Catch: Exception -> L6
        if (r102 == null) goto L11;
        r102.showSoftInput(r101, 0);     // Catch: Exception -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayInputKeyboardHelper#showSystemKeyboard", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayInputKeyboardHelper#showSystemKeyboard", e);
    }

    public void showCustomKeyboard(Context r100, final EditText r101) {
        hideSystemKeyboard(r100, r101);
        showCustomKeyboardAnimated(r100);
        this.mCustomKeyboard.setOnKeyListener(new AnonymousClass1(this, r101));
    }

    public void showKeyboard(Context r100, EditText r101) {
        if (this.mShowCustomKeyboard == false) goto L5;
        showCustomKeyboard(r100, r101);
        return;
    L5:
        hideCustomKeyboard(r100, this.mCustomKeyboard, this.mOnShowHideListener);
        showSystemKeyboard(r100, r101);
    }

    public CJPayInputKeyboardHelper(boolean r100, CJPayKeyboardView r101, boolean r102) {
        this.mShowCustomKeyboard = r100;
        this.mCustomKeyboard = r101;
        this.mShowXInKeyboard = r102;
    }

    public static boolean hideCustomKeyboard(Context r100, CJPayKeyboardView r101, OnShowHideListener r102) {
        if (r101 != null) goto L4;
        return false;
    L4:
        if (r101.getVisibility() != 8) goto L6;
        return false;
    L6:
        if (r101.getAnimation() == null) goto L8;
        return false;
    L8:
        if (sIsInAnimation == false) goto L11;
        return false;
    L11:
        return hideCustomKeyboardAnimated(r100, r101, r102);
    }

    private static boolean hideCustomKeyboardAnimated(Context r100, final CJPayKeyboardView r101, OnShowHideListener r102) {
        if (r101 != null) goto L5;
    L24:
        return false;
    L5:
        if (r101.getVisibility() == 8) goto L24;
        if (r101.getAnimation() != null) goto L24;
        Map<String, Integer> r103 = CJPayHostInfo.animationResourceMap;
        if (r103 != null) goto L12;
        Animation r104 = AnimationUtils.loadAnimation(r100, R.anim.cj_pay_slide_out_to_bottom_with_bezier);
    L16:
        if (r104 == null) goto L18;
        r104.setAnimationListener(new AnonymousClass3(r101));
    L18:
        if (r102 == null) goto L20;
        r102.onShow(false);
    L20:
        if (r104 == null) goto L25;
        r101.startAnimation(r104);
        return true;
    L25:
        return true;
    L12:
        if (r103.containsKey(CJPayConstant.TT_CJ_PAY_KEY_SLIDE_OUT_TO_BOTTOM_ANIMATION_RESOURCE) == false) goto L14;
        r104 = AnimationUtils.loadAnimation(r100, CJPayHostInfo.animationResourceMap.get(CJPayConstant.TT_CJ_PAY_KEY_SLIDE_OUT_TO_BOTTOM_ANIMATION_RESOURCE).intValue());
        goto L16
    L14:
        r104 = null;
        goto L16
    }
}
