package com.stepos.common.widget;

import android.view.GestureDetector;
import android.view.MotionEvent;

/* loaded from: classes.dex */
public final class C extends GestureDetector.SimpleOnGestureListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ D f11447a;

    public C(D d4) {
        this.f11447a = d4;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f4, float f5) {
        D d4 = this.f11447a;
        d4.f11515e = 0;
        ScrollTextView scrollTextView = d4.f11519i;
        int i4 = (int) (-f5);
        d4.f11514d.fling(0, d4.f11515e, 0, i4, 0, 0, scrollTextView.getYScrollStart(), scrollTextView.getYScrollEnd());
        int finalY = d4.f11514d.getFinalY();
        int itemHeight = finalY % scrollTextView.getItemHeight();
        if (itemHeight != 0) {
            int itemHeight2 = itemHeight > 0 ? (scrollTextView.getItemHeight() - itemHeight) + finalY : finalY - (scrollTextView.getItemHeight() + itemHeight);
            int i5 = scrollTextView.f11759l;
            int itemHeight3 = i5 > 0 ? (itemHeight2 + i5) - scrollTextView.getItemHeight() : scrollTextView.getItemHeight() + itemHeight2 + scrollTextView.f11759l;
            if (itemHeight3 > scrollTextView.getItemHeight()) {
                itemHeight3 -= scrollTextView.getItemHeight();
            } else {
                if (itemHeight3 < (-scrollTextView.getItemHeight())) {
                    finalY = scrollTextView.getItemHeight() + itemHeight3;
                }
                d4.f11514d.setFinalY(finalY);
            }
            finalY = itemHeight3;
            d4.f11514d.setFinalY(finalY);
        }
        W.m mVar = scrollTextView.f11740G;
        if (mVar != null && mVar.f1967f) {
            mVar.c();
        }
        int i6 = 1;
        if (scrollTextView.f11740G == null) {
            W.m mVar2 = new W.m(new W.l());
            scrollTextView.f11740G = mVar2;
            mVar2.a(new com.google.android.material.appbar.l(i6, this));
            scrollTextView.f11740G.b(new com.stepos.common.animator.f(i6, this));
        }
        W.n nVar = new W.n();
        nVar.f1985i = finalY;
        nVar.b(scrollTextView.f11741H);
        nVar.a(scrollTextView.f11742I);
        W.m mVar3 = scrollTextView.f11740G;
        mVar3.f1974m = nVar;
        mVar3.f1962a = i4;
        mVar3.i();
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f4, float f5) {
        return true;
    }
}
