package com.bytedance.android.livesdk.chatroom.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes8.dex */
public class AlwaysConsumeEventFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f112081a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f112082b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f112083c;

    public AlwaysConsumeEventFrameLayout(Context r100) {
        super(r100);
        this.f112083c = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        if (this.f112083c == true) goto L7;
        return super.dispatchTouchEvent(r100);
    L7:
        if (com.bytedance.android.livesdk.config.l3.f120650a.getValue().booleanValue() == false) goto L26;
        this.f112081a = r100.getY();
        if (r100.getAction() != 0) goto L15;
        ViewParent r101 = getParent();
        if (r101 == null) goto L13;
        r101.requestDisallowInterceptTouchEvent(true);
    L13:
        this.f112082b = r100.getY();
    L25:
        return super.dispatchTouchEvent(r100);
    L15:
        if (r100.getAction() != 2) goto L25;
        if (Math.abs(this.f112081a - this.f112082b) <= 10.0f) goto L21;
        ViewParent r102 = getParent();
        if (r102 == null) goto L25;
        r102.requestDisallowInterceptTouchEvent(false);
        goto L25
    L21:
        ViewParent r103 = getParent();
        if (r103 == null) goto L25;
        r103.requestDisallowInterceptTouchEvent(true);
        goto L25
    L26:
        requestDisallowInterceptTouchEvent(true);
        super.dispatchTouchEvent(r100);
        return true;
    }

    public void setAlwaysConsume(boolean r100) {
        this.f112083c = r100;
    }

    public AlwaysConsumeEventFrameLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f112083c = true;
    }

    public AlwaysConsumeEventFrameLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f112083c = true;
    }
}
