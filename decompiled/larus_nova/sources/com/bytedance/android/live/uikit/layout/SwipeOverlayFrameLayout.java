package com.bytedance.android.live.uikit.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.bytedance.common.utility.UIUtils;

/* JADX INFO: loaded from: classes7.dex */
public class SwipeOverlayFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public GestureDetector f102252a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f102253b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f102254c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f102255d;

    public class a extends GestureDetector.SimpleOnGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SwipeOverlayFrameLayout f102256a;

        public a(SwipeOverlayFrameLayout r100) {
            this.f102256a = r100;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onFling(MotionEvent r100, MotionEvent r101, float r102, float r103) {
            this.f102256a.getClass();
            return false;
        }
    }

    public interface b {
    }

    public void setOnSwipeListener(b r100) {
    }

    public SwipeOverlayFrameLayout(Context r100) {
        super(r100);
        this.f102253b = true;
        this.f102254c = false;
        this.f102255d = false;
        a(r100);
    }

    public final void a(Context r100) {
        a r101 = new a(this);
        UIUtils.dip2Px(r100, 45.0f);
        UIUtils.dip2Px(r100, 65.0f);
        GestureDetector r102 = new GestureDetector(r100.getApplicationContext(), r101);
        this.f102252a = r102;
        r102.setOnDoubleTapListener(null);
        this.f102252a.setIsLongpressEnabled(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        boolean r101 = false;
        if (r100.getAction() != 0) goto L7;
        this.f102255d = false;     // Catch: Exception -> L22
    L7:
        if (this.f102255d == false) goto L12;
        if (this.f102254c == false) goto L12;
        r101 = true;
    L12:
        if (this.f102253b == false) goto L21;
        GestureDetector r102 = this.f102252a;     // Catch: Exception -> L22
        if (r102 == null) goto L21;
        if (r101 == true) goto L21;
        if (r102.onTouchEvent(r100) == false) goto L21;
        r100.setAction(3);     // Catch: Exception -> L22
        super.dispatchTouchEvent(r100);     // Catch: Exception -> L22
        return true;
    L21:
        return super.dispatchTouchEvent(r100);
    L22:
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean r100) {
        super.requestDisallowInterceptTouchEvent(r100);
        this.f102255d = r100;
    }

    public void setDisllowInterceptEnabled(boolean r100) {
        this.f102254c = r100;
    }

    public void setSwipeEnabled(boolean r100) {
        this.f102253b = r100;
    }

    public SwipeOverlayFrameLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f102253b = true;
        this.f102254c = false;
        this.f102255d = false;
        a(r100);
    }

    public SwipeOverlayFrameLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f102253b = true;
        this.f102254c = false;
        this.f102255d = false;
        a(r100);
    }
}
