package com.gyf.barlibrary;

import android.R;
import android.app.Activity;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
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

    FitsKeyboard(ImmersionBar r3, Activity r4, Window r5) {
        Activity r6 = (Activity) ZeusTransformUtils.wrapperContextForParams(r4, Activity.class, "com.obric.aiagent.plugin");
        this.mPaddingLeft = 0;
        this.mPaddingTop = 0;
        this.mPaddingRight = 0;
        this.mPaddingBottom = 0;
        this.mImmersionBar = r3;
        this.mActivity = ZeusTransformUtils.wrapperContext2Activity(r6, "com.obric.aiagent.plugin");
        this.mWindow = r5;
        View r7 = r5.getDecorView();
        this.mDecorView = r7;
        FrameLayout r8 = (FrameLayout) ZeusTransformUtils.preCheckCast(r7.findViewById(R.id.content), FrameLayout.class, "com.obric.aiagent.plugin");
        View r9 = r8.getChildAt(0);
        this.mChildView = r9;
        if (r9 != null) goto L5;
    L10:
        View r10 = this.mChildView;
        View r11 = r8;
        if (r10 == null) goto L13;
        r11 = r10;
    L13:
        this.mContentView = r11;
        a r12 = new a(this.mActivity);
        this.mStatusBarHeight = r12.b();
        this.mActionBarHeight = r12.c();
        return;
    L5:
        if (ZeusTransformUtils.instanceOf(r9, DrawerLayout.class) == false) goto L7;
        this.mChildView = ((DrawerLayout) ZeusTransformUtils.preCheckCast(this.mChildView, DrawerLayout.class, "com.obric.aiagent.plugin")).getChildAt(0);
    L7:
        View r13 = this.mChildView;
        if (r13 == null) goto L10;
        this.mPaddingLeft = r13.getPaddingLeft();
        this.mPaddingTop = this.mChildView.getPaddingTop();
        this.mPaddingRight = this.mChildView.getPaddingRight();
        this.mPaddingBottom = this.mChildView.getPaddingBottom();
        goto L10
    }

    void enable(int r3) {
        if (Build.VERSION.SDK_INT < 19) goto L8;
        this.mWindow.setSoftInputMode(r3);
        if (this.mIsAddListener == true) goto L9;
        this.mDecorView.getViewTreeObserver().addOnGlobalLayoutListener(this);
        this.mIsAddListener = true;
        return;
    L9:
        return;
    }

    void disable() {
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        return;
    L5:
        if (this.mIsAddListener == true) goto L7;
        return;
    L7:
        if (this.mChildView == null) goto L9;
        this.mContentView.setPadding(this.mPaddingLeft, this.mPaddingTop, this.mPaddingRight, this.mPaddingBottom);
        return;
    L9:
        this.mContentView.setPadding(this.mImmersionBar.getPaddingLeft(), this.mImmersionBar.getPaddingTop(), this.mImmersionBar.getPaddingRight(), this.mImmersionBar.getPaddingBottom());
    }

    void cancel() {
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        return;
    L5:
        if (this.mIsAddListener == false) goto L9;
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
        if (this.mImmersionBar.getBarParams().C == false) goto L42;
        int r1 = ImmersionBar.getNavigationBarHeight(this.mActivity);
        Rect r2 = new Rect();
        this.mDecorView.getWindowVisibleDisplayFrame(r2);
        int r3 = this.mContentView.getHeight() - r2.bottom;
        if (r3 == this.mTempKeyboardHeight) goto L43;
        this.mTempKeyboardHeight = r3;
        boolean r4 = true;
        int r5 = 0;
        if (ImmersionBar.checkFitsSystemWindows(this.mWindow.getDecorView().findViewById(R.id.content)) == false) goto L13;
        r3 = r3 - r1;
        if (r3 > r1) goto L33;
        r4 = false;
    L33:
        if (r3 < 0) goto L37;
        r5 = r3;
    L37:
        if (this.mImmersionBar.getBarParams().I == null) goto L44;
        this.mImmersionBar.getBarParams().I.a(r4, r5);
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
        if (this.mImmersionBar.getBarParams().B == false) goto L18;
        r3 = r3 + (this.mActionBarHeight + this.mStatusBarHeight);
    L18:
        if (this.mImmersionBar.getBarParams().x == false) goto L20;
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
