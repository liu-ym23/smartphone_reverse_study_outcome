package com.bytedance.android.livesdk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;

/* JADX INFO: loaded from: classes11.dex */
public class LinkNoScrollViewPager extends ViewPager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f160909a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f160910b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f160911c;

    public interface a {
        boolean rB();
    }

    static {
    }

    public LinkNoScrollViewPager(Context r100) {
        super(r100);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        a r101 = this.f160909a;
        boolean r102 = false;
        if (r101 != null) goto L5;
    L7:
        super.onInterceptTouchEvent(r100);
        int r103 = r100.getAction();
        if (r103 != 0) goto L10;
        this.f160910b = (int) r100.getX();
        this.f160911c = (int) r100.getY();
    L21:
        this.f160910b = (int) r100.getX();
        this.f160911c = (int) r100.getY();
        return r102;
    L10:
        if (r103 != 2) goto L21;
        if (Math.abs(r100.getX() - this.f160910b) > Math.abs(r100.getY() - this.f160911c)) goto L15;
    L17:
        boolean r104 = false;
    L18:
        if (r104 == false) goto L21;
        r102 = true;
        goto L21
    L15:
        if (Math.abs(r100.getX() - this.f160910b) <= 15.0f) goto L17;
        r104 = true;
        goto L18
    L5:
        if (r101.rB() == true) goto L7;
        return false;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        a r101 = this.f160909a;
        if (r101 != null) goto L5;
    L13:
        return super.onTouchEvent(r100);
    L10:
        e = move-exception;
        e.printStackTrace();
        return false;
    L5:
        if (r101.rB() == true) goto L13;
        return true;
    }

    public void setScrollEnable(a r100) {
        this.f160909a = r100;
    }

    public LinkNoScrollViewPager(Context r100, AttributeSet r101) {
        super(r100, r101);
    }
}
