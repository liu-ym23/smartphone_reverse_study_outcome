package com.stepos.common.widget;

import android.view.GestureDetector;
import android.view.MotionEvent;
import androidx.dynamicanimation.animation.FloatValueHolder;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;

/* loaded from: classes3.dex */
public final class I extends GestureDetector.SimpleOnGestureListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ J f3712a;

    public I(J j5) {
        this.f3712a = j5;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f7) {
        J j5 = this.f3712a;
        j5.e = 0;
        ScrollTextView scrollTextView = j5.i;
        int i = (int) (-f7);
        j5.d.fling(0, j5.e, 0, i, 0, 0, scrollTextView.getYScrollStart(), scrollTextView.getYScrollEnd());
        int finalY = j5.d.getFinalY();
        int itemHeight = finalY % scrollTextView.getItemHeight();
        if (itemHeight != 0) {
            int itemHeight2 = itemHeight > 0 ? (scrollTextView.getItemHeight() - itemHeight) + finalY : finalY - (scrollTextView.getItemHeight() + itemHeight);
            int i6 = scrollTextView.l;
            int itemHeight3 = i6 > 0 ? (itemHeight2 + i6) - scrollTextView.getItemHeight() : scrollTextView.getItemHeight() + itemHeight2 + scrollTextView.l;
            if (itemHeight3 > scrollTextView.getItemHeight()) {
                itemHeight3 -= scrollTextView.getItemHeight();
            } else {
                if (itemHeight3 < (-scrollTextView.getItemHeight())) {
                    finalY = scrollTextView.getItemHeight() + itemHeight3;
                }
                j5.d.setFinalY(finalY);
            }
            finalY = itemHeight3;
            j5.d.setFinalY(finalY);
        }
        SpringAnimation springAnimation = scrollTextView.f3746G;
        if (springAnimation != null && springAnimation.isRunning()) {
            scrollTextView.f3746G.cancel();
        }
        if (scrollTextView.f3746G == null) {
            SpringAnimation springAnimation2 = new SpringAnimation(new FloatValueHolder());
            scrollTextView.f3746G = springAnimation2;
            springAnimation2.addEndListener(new G(this));
            scrollTextView.f3746G.addUpdateListener(new H(this));
        }
        SpringForce springForce = new SpringForce();
        springForce.setFinalPosition(finalY);
        springForce.setStiffness(scrollTextView.f3747L);
        springForce.setDampingRatio(scrollTextView.f3748M);
        scrollTextView.f3746G.setSpring(springForce);
        scrollTextView.f3746G.setStartVelocity(i);
        scrollTextView.f3746G.start();
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f7) {
        return true;
    }
}
