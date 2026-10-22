package com.bytedance.android.annie.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes43.dex */
public class ForceInterceptConstraintLayout extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f40094a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function1<KeyEvent, Boolean> f40095b;

    public ForceInterceptConstraintLayout(Context r100) {
        super(r100);
        this.f40094a = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent r100) {
        Function1<KeyEvent, Boolean> r101 = this.f40095b;
        if (r101 == null) goto L9;
        if (r101.invoke(r100).booleanValue() == false) goto L9;
        return true;
    L9:
        return super.dispatchKeyEvent(r100);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        if (this.f40094a == false) goto L9;
        if (r100.getAction() == 0) goto L9;
        return true;
    L9:
        return super.onInterceptTouchEvent(r100);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        if (r100.getAction() != 1) goto L5;
    L6:
        setForceInterceptTouchEvent(false);
    L8:
        return super.onTouchEvent(r100);
    L5:
        if (r100.getAction() != 3) goto L8;
        goto L6
    }

    public void setForceInterceptTouchEvent(boolean r100) {
        this.f40094a = r100;
    }

    public void setOnDispatchKeyEvent(Function1<KeyEvent, Boolean> r100) {
        this.f40095b = r100;
    }

    public ForceInterceptConstraintLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f40094a = false;
    }

    public ForceInterceptConstraintLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f40094a = false;
    }
}
