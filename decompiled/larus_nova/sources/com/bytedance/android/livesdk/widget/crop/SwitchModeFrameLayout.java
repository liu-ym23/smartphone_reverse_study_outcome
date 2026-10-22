package com.bytedance.android.livesdk.widget.crop;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes11.dex */
public class SwitchModeFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f161678a;

    public static class a implements b {
        public a() {
        }

        @Override // com.bytedance.android.livesdk.widget.crop.SwitchModeFrameLayout.b
        public final void a() {
        }
    }

    public interface b {
        void a();

        void onInterceptTouchEvent(MotionEvent r100);
    }

    public SwitchModeFrameLayout(Context r100) {
        super(r100);
        this.f161678a = null;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        b r101 = this.f161678a;
        if (r101 == null) goto L6;
        r101.onInterceptTouchEvent(r100);
    L6:
        return super.onInterceptTouchEvent(r100);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        b r101 = this.f161678a;
        if (r101 == null) goto L6;
        r101.a();
    L6:
        return super.onTouchEvent(r100);
    }

    public void setInterceptor(b r100) {
        this.f161678a = r100;
    }

    public SwitchModeFrameLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f161678a = null;
    }

    public SwitchModeFrameLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f161678a = null;
    }
}
