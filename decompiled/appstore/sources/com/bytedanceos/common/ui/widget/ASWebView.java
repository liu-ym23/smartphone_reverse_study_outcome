package com.bytedanceos.common.ui.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.webkit.WebView;

/* JADX INFO: loaded from: classes2.dex */
public class ASWebView extends WebView {
    private String tag;

    public ASWebView(Context r10) {
        super(r10);
        this.tag = "";
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r10) {
        if (this.tag.equals("scroll") == false) goto L7;
        requestFocus();
        getParent().requestDisallowInterceptTouchEvent(true);
        return true;
    L7:
        return super.onInterceptTouchEvent(r10);
    }

    @Override // android.webkit.WebView, android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent r10) {
        if (r10.getAction() != 0) goto L6;
        onScrollChanged(getScrollX(), getScrollY(), getScrollX(), getScrollY());
    L6:
        return super.onTouchEvent(r10);
    }

    public void setScrollTag(String r10) {
        this.tag = r10;
    }

    public ASWebView(Context r10, AttributeSet r11) {
        super(r10, r11);
        this.tag = "";
    }

    public ASWebView(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.tag = "";
    }

    @SuppressLint({"NewApi"})
    public ASWebView(Context r10, AttributeSet r11, int r12, boolean r13) {
        super(r10, r11, r12, r13);
        this.tag = "";
    }
}
