package com.bytedance.android.livesdk.chatroom.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.dux.drawable.DoubleColorBallAnimationViewNewV2;
import com.bytedance.dux.drawable.DoubleColorBallAnimationViewOld;

/* JADX INFO: loaded from: classes8.dex */
public class LiveDoubleColorBallAnimationView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.dux.drawable.f f112261a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f112262b;

    public final boolean a() {
        com.bytedance.dux.drawable.f r100 = this.f112261a;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.isAnimating() == false) goto L7;
        return true;
    }

    public final void b() {
        com.bytedance.dux.drawable.f r100 = this.f112261a;
        if (r100 == null) goto L6;
        r100.f();
        return;
    }

    public final void c() {
        this.f112261a.b();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if ((this.f112261a instanceof DoubleColorBallAnimationViewNewV2) == false) goto L13;
        if (getParent() != null) goto L7;
    L9:
        ViewGroup.LayoutParams r100 = getLayoutParams();
        if (r100 == null) goto L13;
        r100.width = dm4.a.b(32);
        r100.height = dm4.a.b(32);
        setLayoutParams(r100);
        goto L13
    L7:
        if ((getParent() instanceof ViewGroup) == false) goto L9;
        ((ViewGroup) getParent()).setClipChildren(false);
    L13:
        if (this.f112262b == true) goto L15;
        return;
    L15:
        if (isShown() == false) goto L19;
        b();
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c();
    }

    public LiveDoubleColorBallAnimationView(Context r100) {
        this(r100, null);
    }

    public void setCycleBias(int r100) {
        if (j40.v.f497309a.getValue().booleanValue() == true) goto L8;
        com.bytedance.dux.drawable.f r101 = this.f112261a;
        if ((r101 instanceof DoubleColorBallAnimationViewOld) == false) goto L9;
        ((DoubleColorBallAnimationViewOld) r101).setCycleBias(r100);
        return;
    L9:
        return;
    }

    public void setProgress(float r100) {
        this.f112261a.setProgress(r100);
    }

    public void setProgressBarInfo(int r100) {
        com.bytedance.dux.drawable.f r101 = this.f112261a;
        if (r101 == null) goto L6;
        r101.setProgressBarInfo(r100);
        return;
    }

    public void setStartAnimationAfterAttach(boolean r100) {
        this.f112262b = r100;
    }

    @Override // android.view.View
    public void setVisibility(int r100) {
        super.setVisibility(r100);
        if (r100 != 0) goto L5;
        b();
        return;
    L5:
        c();
    }

    public LiveDoubleColorBallAnimationView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public LiveDoubleColorBallAnimationView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f112261a = null;
        j40.v r103 = j40.v.f497309a;
        this.f112262b = !r103.getValue().booleanValue();
        if (r103.getValue().booleanValue() == false) goto L5;
        this.f112261a = new DoubleColorBallAnimationViewNewV2(r100, "LiveSdk");
    L6:
        addView((View) this.f112261a);
        return;
    L5:
        this.f112261a = new DoubleColorBallAnimationViewOld(r100);
        goto L6
    }
}
