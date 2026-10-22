package com.gyf.barlibrary;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.drawerlayout.widget.DrawerLayout;

/* JADX INFO: loaded from: classes3.dex */
public class FitsKeyboard implements ViewTreeObserver.OnGlobalLayoutListener {
    private final int mActionBarHeight;
    private Activity mActivity;
    private View mChildView;
    private View mContentView;
    private View mDecorView;
    private ImmersionBar mImmersionBar;
    private boolean mIsAddListener;
    private int mPaddingBottom;
    private int mPaddingLeft;
    private int mPaddingRight;
    private int mPaddingTop;
    private final int mStatusBarHeight;
    private int mTempKeyboardHeight;
    private Window mWindow;

    FitsKeyboard(ImmersionBar r2, Activity r3, Window r4) {
        this.mPaddingLeft = 0;
        this.mPaddingTop = 0;
        this.mPaddingRight = 0;
        this.mPaddingBottom = 0;
        this.mImmersionBar = r2;
        this.mActivity = r3;
        this.mWindow = r4;
        View r5 = r4.getDecorView();
        this.mDecorView = r5;
        FrameLayout r6 = (FrameLayout) r5.findViewById(android.R.id.content);
        View r7 = r6.getChildAt(0);
        this.mChildView = r7;
        if (r7 != null) goto L5;
    L10:
        View r8 = this.mChildView;
        View r9 = r6;
        if (r8 == null) goto L13;
        r9 = r8;
    L13:
        this.mContentView = r9;
        BarConfig r10 = new BarConfig(this.mActivity);
        this.mStatusBarHeight = r10.getStatusBarHeight();
        this.mActionBarHeight = r10.getActionBarHeight();
        return;
    L5:
        if ((r7 instanceof DrawerLayout) == false) goto L7;
        this.mChildView = ((DrawerLayout) r7).getChildAt(0);
    L7:
        View r11 = this.mChildView;
        if (r11 == null) goto L10;
        this.mPaddingLeft = r11.getPaddingLeft();
        this.mPaddingTop = this.mChildView.getPaddingTop();
        this.mPaddingRight = this.mChildView.getPaddingRight();
        this.mPaddingBottom = this.mChildView.getPaddingBottom();
        goto L10
    }

    void enable(int r2) {
        this.mWindow.setSoftInputMode(r2);
        if (this.mIsAddListener == true) goto L6;
        this.mDecorView.getViewTreeObserver().addOnGlobalLayoutListener(this);
        this.mIsAddListener = true;
        return;
    }

    void disable() {
        if (this.mIsAddListener == true) goto L5;
        return;
    L5:
        if (this.mChildView == null) goto L7;
        this.mContentView.setPadding(this.mPaddingLeft, this.mPaddingTop, this.mPaddingRight, this.mPaddingBottom);
        return;
    L7:
        this.mContentView.setPadding(this.mImmersionBar.getPaddingLeft(), this.mImmersionBar.getPaddingTop(), this.mImmersionBar.getPaddingRight(), this.mImmersionBar.getPaddingBottom());
    }

    void cancel() {
        if (this.mIsAddListener == false) goto L6;
        this.mDecorView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        this.mIsAddListener = false;
        return;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        ImmersionBar r0 = this.mImmersionBar;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getBarParams() != null) goto L7;
        return;
    L7:
        if (this.mImmersionBar.getBarParams().keyboardEnable == false) goto L42;
        int r1 = ImmersionBar.getNavigationBarHeight(this.mActivity);
        Rect r2 = new Rect();
        this.mDecorView.getWindowVisibleDisplayFrame(r2);
        int r3 = this.mContentView.getHeight() - r2.bottom;
        if (r3 == this.mTempKeyboardHeight) goto L43;
        this.mTempKeyboardHeight = r3;
        boolean r4 = true;
        int r5 = 0;
        if (ImmersionBar.checkFitsSystemWindows(this.mWindow.getDecorView().findViewById(android.R.id.content)) == false) goto L13;
        r3 = r3 - r1;
        if (r3 > r1) goto L33;
        r4 = false;
    L33:
        if (r3 < 0) goto L37;
        r5 = r3;
    L37:
        if (this.mImmersionBar.getBarParams().onKeyboardListener == null) goto L44;
        this.mImmersionBar.getBarParams().onKeyboardListener.onKeyboardChange(r4, r5);
        return;
    L44:
        return;
    L13:
        if (this.mChildView != null) goto L15;
        int r6 = this.mImmersionBar.getPaddingBottom();
        r3 = r3 - r1;
        if (r3 <= r1) goto L27;
        r6 = r3 + r1;
    L28:
        this.mContentView.setPadding(this.mImmersionBar.getPaddingLeft(), this.mImmersionBar.getPaddingTop(), this.mImmersionBar.getPaddingRight(), r6);
        goto L33
    L27:
        r4 = false;
        goto L28
    L15:
        if (this.mImmersionBar.getBarParams().isSupportActionBar == false) goto L18;
        r3 = r3 + (this.mActionBarHeight + this.mStatusBarHeight);
    L18:
        if (this.mImmersionBar.getBarParams().fits == false) goto L20;
        r3 = r3 + this.mStatusBarHeight;
    L20:
        if (r3 <= r1) goto L22;
        int r7 = this.mPaddingBottom + r3;
    L23:
        this.mContentView.setPadding(this.mPaddingLeft, this.mPaddingTop, this.mPaddingRight, r7);
        goto L33
    L22:
        r7 = 0;
        r4 = false;
        goto L23
    L43:
        return;
    }
}
