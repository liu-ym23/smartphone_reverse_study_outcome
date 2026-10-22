package com.bytedance.android.shopping.commentfeed.widget;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes13.dex */
public final class c implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VideoPlaySeekBar f172496a;

    public c(VideoPlaySeekBar r100) {
        this.f172496a = r100;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r110, MotionEvent r111) {
        Rect r112 = new Rect();
        this.f172496a.getHitRect(r112);
        if (r111.getAction() == 0) goto L5;
    L9:
        float r100 = r112.top + (r112.height() / 2);
        float r101 = r111.getX() - r112.left;
        if (r101 >= 0) goto L13;
        float r102 = 0.0f;
    L17:
        return this.f172496a.onTouchEvent(MotionEvent.obtain(r111.getDownTime(), r111.getEventTime(), r111.getAction(), r102, r100, r111.getMetaState()));
    L13:
        if (r101 <= r112.width()) goto L15;
        r102 = r112.width();
        goto L17
    L15:
        r102 = r101;
        goto L17
    L5:
        if (r111.getX() >= r112.left) goto L7;
    L8:
        return false;
    L7:
        if (r111.getX() <= r112.right) goto L9;
        goto L8
    }
}
