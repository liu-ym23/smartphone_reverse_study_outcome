package com.stepos.common.widget;

import android.content.Context;
import android.view.GestureDetector;
import android.view.animation.PathInterpolator;
import android.widget.Scroller;
import java.util.Iterator;
import w0.C2086g;

/* loaded from: classes3.dex */
public final class J {

    /* renamed from: a, reason: collision with root package name */
    public final C2086g f3718a;
    public final Context b;
    public final GestureDetector c;
    public Scroller d;
    public int e;
    public float f;
    public boolean g;
    public final A6.c h;
    public final /* synthetic */ ScrollTextView i;

    public J(ScrollTextView scrollTextView, Context context, C2086g c2086g) {
        this.i = scrollTextView;
        I i = new I(this);
        this.h = new A6.c(this);
        GestureDetector gestureDetector = new GestureDetector(context, i);
        this.c = gestureDetector;
        gestureDetector.setIsLongpressEnabled(false);
        this.d = new Scroller(context, new PathInterpolator(0.3f, 1.56f, 0.3f, 1.0f));
        this.f3718a = c2086g;
        this.b = context;
    }

    public final void a() {
        if (this.g) {
            ScrollTextView scrollTextView = (ScrollTextView) this.f3718a.f6811a;
            B b = scrollTextView.f3749N;
            if (scrollTextView.k) {
                C c = scrollTextView.f3757r;
                if (c != null) {
                    c.b(scrollTextView.getCurrentItem());
                }
                Iterator it = scrollTextView.f3751P.iterator();
                while (it.hasNext()) {
                    ((D) it.next()).a(scrollTextView);
                }
                scrollTextView.k = false;
            }
            scrollTextView.l = 0;
            scrollTextView.removeCallbacks(b);
            scrollTextView.E = scrollTextView.getWidth() / 2.0f;
            if (scrollTextView.k) {
                scrollTextView.postInvalidate();
            } else {
                scrollTextView.postDelayed(b, 10L);
            }
            scrollTextView.invalidate();
            this.g = false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b() {
        /*
            r6 = this;
            w0.g r0 = r6.f3718a
            java.lang.Object r0 = r0.f6811a
            com.stepos.common.widget.ScrollTextView r0 = (com.stepos.common.widget.ScrollTextView) r0
            boolean r1 = r0.o
            r2 = 2
            r3 = 0
            if (r1 != 0) goto L2b
            int r1 = r0.getCurrentItem()
            com.stepos.common.widget.F r4 = r0.f3756q
            r4.getClass()
            if (r1 >= 0) goto L2b
            int r1 = r0.getCurrentItem()
            int r1 = 0 - r1
            int r4 = r0.getItemHeight()
            int r4 = r4 * r1
            int r1 = r0.l
            int r4 = r4 + r1
            com.stepos.common.widget.J r0 = r0.f3755j
            r0.c(r4, r3)
            goto L8b
        L2b:
            boolean r1 = r0.o
            if (r1 != 0) goto L4c
            int r1 = r0.getCurrentItem()
            com.stepos.common.widget.F r4 = r0.f3756q
            int r4 = r4.f3709a
            if (r1 <= r4) goto L4c
            int r1 = r0.getCurrentItem()
            int r4 = r4 - r1
            int r1 = r0.getItemHeight()
            int r1 = r1 * r4
            int r4 = r0.l
            int r1 = r1 + r4
            com.stepos.common.widget.J r0 = r0.f3755j
            r0.c(r1, r3)
            goto L8b
        L4c:
            int r1 = r0.l
            int r1 = java.lang.Math.abs(r1)
            int r4 = r0.getItemHeight()
            int r4 = r4 / r2
            if (r1 <= r4) goto L76
            int r1 = r0.l
            if (r1 <= 0) goto L66
            int r1 = r0.getItemHeight()
            int r1 = -r1
            int r4 = r0.l
        L64:
            int r1 = r1 + r4
            goto L70
        L66:
            if (r1 >= 0) goto L6f
            int r1 = r0.getItemHeight()
            int r4 = r0.l
            goto L64
        L6f:
            r1 = r3
        L70:
            com.stepos.common.widget.J r0 = r0.f3755j
            r0.c(r1, r3)
            goto L8b
        L76:
            int r1 = r0.l
            if (r1 == 0) goto L8b
            com.stepos.common.widget.J r4 = r0.f3755j
            int r5 = java.lang.Math.abs(r1)
            int r5 = r5 * 650
            int r0 = r0.getItemHeight()
            int r0 = r0 / r2
            int r5 = r5 / r0
            r4.c(r1, r5)
        L8b:
            A6.c r6 = r6.h
            r6.removeMessages(r3)
            r0 = 1
            r6.removeMessages(r0)
            r6.removeMessages(r2)
            r6.sendEmptyMessage(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.common.widget.J.b():void");
    }

    public final void c(int i, int i6) {
        this.d.forceFinished(true);
        this.e = 0;
        Scroller scroller = this.d;
        if (i6 == 0) {
            i6 = 650;
        }
        scroller.startScroll(0, 0, 0, i, i6);
        A6.c cVar = this.h;
        cVar.removeMessages(0);
        cVar.removeMessages(1);
        cVar.removeMessages(2);
        cVar.sendEmptyMessage(0);
        d();
    }

    public final void d() {
        if (this.g) {
            return;
        }
        this.g = true;
        ScrollTextView scrollTextView = (ScrollTextView) this.f3718a.f6811a;
        scrollTextView.k = true;
        scrollTextView.removeCallbacks(scrollTextView.f3749N);
        Iterator it = scrollTextView.f3751P.iterator();
        while (it.hasNext()) {
            ((D) it.next()).getClass();
        }
    }
}
