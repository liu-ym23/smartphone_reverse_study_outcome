package com.stepos.familyguard.ui.widget.chart.histogram;

import A2.n;
import android.content.Context;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import f2.C0702g;
import y2.AbstractC1325f;

/* loaded from: classes.dex */
public class c extends n {

    /* renamed from: l, reason: collision with root package name */
    private a f15326l;

    /* renamed from: m, reason: collision with root package name */
    private final Handler f15327m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f15328n;

    /* renamed from: o, reason: collision with root package name */
    private int f15329o;

    /* renamed from: p, reason: collision with root package name */
    private VelocityTracker f15330p;

    private class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public float f15331a;

        /* renamed from: b, reason: collision with root package name */
        public AbstractC1325f f15332b;

        @Override // java.lang.Runnable
        public void run() {
            C0702g.b("HoverableHistogramDataLayer", "LongPressRunnable run x = " + this.f15331a);
            c.this.f15328n = true;
            c.this.x(this.f15332b, this.f15331a);
        }

        private a() {
        }
    }

    public c(Context context, z2.e eVar) {
        super(context, eVar);
        this.f15327m = new Handler();
        this.f15329o = -1;
    }

    public void A(boolean z5) {
        this.f15328n = z5;
    }

    @Override // A2.n, y2.i
    public boolean d() {
        return true;
    }

    @Override // A2.n, y2.i
    public boolean g(MotionEvent motionEvent, AbstractC1325f abstractC1325f) {
        int action = motionEvent.getAction();
        float x5 = motionEvent.getX();
        C0702g.b("HoverableHistogramDataLayer", "onTouchEvent event = " + motionEvent + " x = " + motionEvent.getX());
        if (action == 0) {
            if (this.f15330p == null) {
                this.f15330p = VelocityTracker.obtain();
            }
            if (this.f15326l == null) {
                this.f15326l = new a();
            }
            this.f15326l.f15331a = motionEvent.getX();
            C0702g.b("HoverableHistogramDataLayer", "mLongPressRunnable set x = " + x5);
            a aVar = this.f15326l;
            aVar.f15332b = abstractC1325f;
            this.f15327m.postDelayed(aVar, 80L);
            return true;
        }
        if (action != 1) {
            if (action == 2) {
                this.f15330p.addMovement(motionEvent);
                this.f15330p.computeCurrentVelocity(1000);
                Math.abs(this.f15330p.getYVelocity());
                if (!z()) {
                    return false;
                }
                x(abstractC1325f, x5);
                return true;
            }
            if (action != 3 && action != 4) {
                return super.g(motionEvent, abstractC1325f);
            }
        }
        VelocityTracker velocityTracker = this.f15330p;
        if (velocityTracker != null) {
            velocityTracker.clear();
            this.f15330p.recycle();
            this.f15330p = null;
        }
        this.f15327m.removeCallbacks(this.f15326l);
        this.f15326l = null;
        y(abstractC1325f);
        return true;
    }

    @Override // A2.n
    public boolean u() {
        return true;
    }

    protected void x(AbstractC1325f abstractC1325f, float f5) {
        A(true);
        int iO = o(f5);
        C0702g.b("HoverableHistogramDataLayer", "handleHover x = " + f5 + " hoveredIndex = " + iO);
        if (iO != this.f15329o) {
            t(iO);
            this.f15329o = iO;
            if (abstractC1325f instanceof HistogramView) {
                ((HistogramView) abstractC1325f).h(true, iO);
            }
            abstractC1325f.invalidate();
        }
    }

    protected void y(AbstractC1325f abstractC1325f) {
        C0702g.b("HoverableHistogramDataLayer", "handleHoverEnd");
        A(false);
        t(-1);
        this.f15329o = -1;
        if (abstractC1325f instanceof HistogramView) {
            ((HistogramView) abstractC1325f).h(false, -1);
        }
        abstractC1325f.invalidate();
    }

    public boolean z() {
        return this.f15328n;
    }
}
