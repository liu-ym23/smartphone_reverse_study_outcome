package com.stepos.familyguard.ui.widget.chart.histogram;

import A2.n;
import android.content.Context;
import android.view.MotionEvent;
import y2.AbstractC1325f;

/* loaded from: classes.dex */
public class d extends n {

    /* renamed from: l, reason: collision with root package name */
    private int f15334l;

    public d(Context context, z2.e eVar) {
        super(context, eVar);
        this.f15334l = -1;
    }

    @Override // A2.n, y2.i
    public boolean d() {
        return true;
    }

    @Override // A2.n, y2.i
    public boolean g(MotionEvent motionEvent, AbstractC1325f abstractC1325f) {
        int action = motionEvent.getAction();
        float x5 = motionEvent.getX();
        if (action != 0) {
            if (action == 1) {
                w(abstractC1325f, x5);
            } else if (action != 2 && action != 3 && action != 4) {
                return super.g(motionEvent, abstractC1325f);
            }
        }
        return true;
    }

    @Override // A2.n
    public boolean v() {
        return true;
    }

    protected void w(AbstractC1325f abstractC1325f, float f5) {
        int iO = o(f5);
        if (iO == this.f15334l || iO == -1) {
            return;
        }
        t(iO);
        this.f15334l = iO;
        if (abstractC1325f instanceof HistogramView) {
            ((HistogramView) abstractC1325f).j(iO);
        }
        abstractC1325f.invalidate();
    }

    public void x() {
        this.f15334l = -1;
        t(-1);
    }

    public void y(int i5) {
        this.f15334l = i5;
        t(i5);
    }
}
