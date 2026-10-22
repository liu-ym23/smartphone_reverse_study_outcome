package com.tmall.wireless.tangram.ext;

import android.view.MotionEvent;
import android.view.View;
import me.everything.android.ui.overscroll.a;
import me.everything.android.ui.overscroll.adapters.IOverScrollDecoratorAdapter;

/* JADX INFO: loaded from: classes4.dex */
public class HorizontalOverScrollBounceEffectDecoratorExt extends a {
    private OnMotionEventListener motionEventListener;
    private OnOverScrollListener overScrollListener;

    public interface OnMotionEventListener {
        void onMotionEvent(View r10, MotionEvent r11);
    }

    public interface OnOverScrollListener {
        void onOverScroll(View r10, float r11);
    }

    public HorizontalOverScrollBounceEffectDecoratorExt(IOverScrollDecoratorAdapter r10) {
        super(r10);
    }

    @Override // me.everything.android.ui.overscroll.OverScrollBounceEffectDecoratorBase, android.view.View.OnTouchListener
    public boolean onTouch(View r10, MotionEvent r11) {
        OnMotionEventListener r12 = this.motionEventListener;
        if (r12 == null) goto L6;
        r12.onMotionEvent(r10, r11);
    L6:
        return super.onTouch(r10, r11);
    }

    public void setOnMotionEventListener(OnMotionEventListener r10) {
        this.motionEventListener = r10;
    }

    public void setOnOverScrollListener(OnOverScrollListener r10) {
        this.overScrollListener = r10;
    }

    @Override // me.everything.android.ui.overscroll.a, me.everything.android.ui.overscroll.OverScrollBounceEffectDecoratorBase
    public void translateView(View r10, float r11) {
        super.translateView(r10, r11);
        OnOverScrollListener r12 = this.overScrollListener;
        if (r12 == null) goto L6;
        r12.onOverScroll(r10, r11);
        return;
    }

    public HorizontalOverScrollBounceEffectDecoratorExt(IOverScrollDecoratorAdapter r10, float r11, float r12, float r13) {
        super(r10, r11, r12, r13);
    }
}
