package com.gyf.immersionbar;

import android.R;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
class FitsKeyboard implements ViewTreeObserver.OnGlobalLayoutListener {
    private View mChildView;
    private View mContentView;
    private View mDecorView;
    private g mImmersionBar;
    private boolean mIsAddListener;
    private int mPaddingBottom;
    private int mPaddingLeft;
    private int mPaddingRight;
    private int mPaddingTop;
    private int mTempKeyboardHeight;
    private Window mWindow;

    FitsKeyboard(g r5) {
        this.mPaddingLeft = 0;
        this.mPaddingTop = 0;
        this.mPaddingRight = 0;
        this.mPaddingBottom = 0;
        this.mImmersionBar = r5;
        Window r1 = r5.k();
        this.mWindow = r1;
        View r2 = r1.getDecorView();
        this.mDecorView = r2;
        FrameLayout r3 = (FrameLayout) ZeusTransformUtils.preCheckCast(r2.findViewById(R.id.content), FrameLayout.class, "com.obric.aiagent.plugin");
        if (r5.n() == false) goto L10;
        Fragment r0 = r5.l();
        if (r0 == null) goto L7;
        this.mChildView = r0.getView();
    L15:
        View r6 = this.mChildView;
        if (r6 == null) goto L18;
        this.mPaddingLeft = r6.getPaddingLeft();
        this.mPaddingTop = this.mChildView.getPaddingTop();
        this.mPaddingRight = this.mChildView.getPaddingRight();
        this.mPaddingBottom = this.mChildView.getPaddingBottom();
    L18:
        View r7 = this.mChildView;
        View r4 = r3;
        if (r7 == null) goto L21;
        r4 = r7;
    L21:
        this.mContentView = r4;
        return;
    L7:
        android.app.Fragment r8 = r5.m();
        if (r8 == null) goto L15;
        this.mChildView = r8.getView();
        goto L15
    L10:
        View r9 = r3.getChildAt(0);
        this.mChildView = r9;
        if (r9 == null) goto L15;
        if (ZeusTransformUtils.instanceOf(r9, DrawerLayout.class) == false) goto L15;
        this.mChildView = ((DrawerLayout) ZeusTransformUtils.preCheckCast(this.mChildView, DrawerLayout.class, "com.obric.aiagent.plugin")).getChildAt(0);
        goto L15
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
        this.mContentView.setPadding(this.mImmersionBar.g(), this.mImmersionBar.h(), this.mImmersionBar.i(), this.mImmersionBar.j());
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

    void resetKeyboardHeight() {
        this.mTempKeyboardHeight = 0;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        g r0 = this.mImmersionBar;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.f() != null) goto L7;
        return;
    L7:
        if (this.mImmersionBar.f().F == false) goto L52;
        a r1 = this.mImmersionBar.p();
        if (r1.a() == false) goto L11;
        int r2 = r1.e();
    L12:
        Rect r3 = new Rect();
        this.mDecorView.getWindowVisibleDisplayFrame(r3);
        int r4 = this.mContentView.getHeight() - r3.bottom;
        if (r4 == this.mTempKeyboardHeight) goto L53;
        this.mTempKeyboardHeight = r4;
        boolean r5 = true;
        int r6 = 0;
        if (g.a(this.mWindow.getDecorView().findViewById(R.id.content)) == false) goto L17;
        r4 = r4 - r2;
        if (r4 > r2) goto L37;
        r5 = false;
    L37:
        if (r4 < 0) goto L41;
        r6 = r4;
    L41:
        if (this.mImmersionBar.f().L == null) goto L43;
        this.mImmersionBar.f().L.a(r5, r6);
    L43:
        if (r5 == false) goto L45;
    L47:
        if (r5 == true) goto L54;
        this.mImmersionBar.e();
        return;
    L54:
        return;
    L45:
        if (this.mImmersionBar.f().j == b.f13829d) goto L47;
        this.mImmersionBar.d();
        goto L47
    L17:
        if (this.mChildView != null) goto L19;
        int r7 = this.mImmersionBar.j();
        r4 = r4 - r2;
        if (r4 <= r2) goto L31;
        r7 = r4 + r2;
    L32:
        this.mContentView.setPadding(this.mImmersionBar.g(), this.mImmersionBar.h(), this.mImmersionBar.i(), r7);
        goto L37
    L31:
        r5 = false;
        goto L32
    L19:
        if (this.mImmersionBar.f().E == false) goto L22;
        r4 = r4 + (this.mImmersionBar.q() + r1.b());
    L22:
        if (this.mImmersionBar.f().y == false) goto L24;
        r4 = r4 + r1.b();
    L24:
        if (r4 <= r2) goto L26;
        int r8 = this.mPaddingBottom + r4;
    L27:
        this.mContentView.setPadding(this.mPaddingLeft, this.mPaddingTop, this.mPaddingRight, r8);
        goto L37
    L26:
        r8 = 0;
        r5 = false;
        goto L27
    L53:
        return;
    L11:
        r2 = r1.f();
        goto L12
    }
}
