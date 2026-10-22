package com.stepos.common.widget;

import android.content.Context;
import android.view.GestureDetector;
import android.view.animation.PathInterpolator;
import android.widget.Scroller;
import androidx.appcompat.app.C0186l;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class D {

    /* renamed from: a, reason: collision with root package name */
    public final com.google.android.gms.common.api.internal.p f11511a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f11512b;

    /* renamed from: c, reason: collision with root package name */
    public final GestureDetector f11513c;

    /* renamed from: d, reason: collision with root package name */
    public Scroller f11514d;

    /* renamed from: e, reason: collision with root package name */
    public int f11515e;

    /* renamed from: f, reason: collision with root package name */
    public float f11516f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f11517g;

    /* renamed from: h, reason: collision with root package name */
    public final w f11518h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ ScrollTextView f11519i;

    public D(ScrollTextView scrollTextView, Context context, com.google.android.gms.common.api.internal.p pVar) {
        this.f11519i = scrollTextView;
        C c4 = new C(this);
        this.f11518h = new w(this);
        GestureDetector gestureDetector = new GestureDetector(context, c4);
        this.f11513c = gestureDetector;
        gestureDetector.setIsLongpressEnabled(false);
        this.f11514d = new Scroller(context, new PathInterpolator(0.3f, 1.56f, 0.3f, 1.0f));
        this.f11511a = pVar;
        this.f11512b = context;
    }

    public final void a() {
        if (this.f11517g) {
            com.google.android.gms.common.api.internal.p pVar = this.f11511a;
            ScrollTextView scrollTextView = (ScrollTextView) pVar.f9664b;
            if (scrollTextView.f11758k) {
                x xVar = scrollTextView.f11765r;
                if (xVar != null) {
                    ((C0186l) xVar).c(scrollTextView.getCurrentItem());
                }
                Iterator it = scrollTextView.f11745L.iterator();
                while (it.hasNext()) {
                    ((z) it.next()).a(scrollTextView);
                }
                ((ScrollTextView) pVar.f9664b).f11758k = false;
            }
            ScrollTextView scrollTextView2 = (ScrollTextView) pVar.f9664b;
            scrollTextView2.f11759l = 0;
            scrollTextView2.removeCallbacks(scrollTextView2.f11743J);
            ((ScrollTextView) pVar.f9664b).f11738E = r1.getWidth() / 2.0f;
            ScrollTextView scrollTextView3 = (ScrollTextView) pVar.f9664b;
            if (scrollTextView3.f11758k) {
                scrollTextView3.postInvalidate();
            } else {
                scrollTextView3.postDelayed(scrollTextView3.f11743J, 10L);
            }
            ((ScrollTextView) pVar.f9664b).invalidate();
            this.f11517g = false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b() {
        /*
            r6 = this;
            com.google.android.gms.common.api.internal.p r0 = r6.f11511a
            java.lang.Object r1 = r0.f9664b
            com.stepos.common.widget.ScrollTextView r1 = (com.stepos.common.widget.ScrollTextView) r1
            boolean r2 = r1.f11762o
            r3 = 2
            r4 = 0
            if (r2 != 0) goto L2e
            int r1 = r1.getCurrentItem()
            java.lang.Object r2 = r0.f9664b
            com.stepos.common.widget.ScrollTextView r2 = (com.stepos.common.widget.ScrollTextView) r2
            com.stepos.common.widget.B r5 = r2.f11764q
            int r5 = r5.f11443a
            if (r1 >= r5) goto L2e
            int r0 = r2.getCurrentItem()
            int r5 = r5 - r0
            int r0 = r2.getItemHeight()
            int r0 = r0 * r5
            int r1 = r2.f11759l
            int r0 = r0 + r1
            com.stepos.common.widget.D r1 = r2.f11757j
            r1.c(r0, r4)
            goto Lb6
        L2e:
            java.lang.Object r1 = r0.f9664b
            com.stepos.common.widget.ScrollTextView r1 = (com.stepos.common.widget.ScrollTextView) r1
            boolean r2 = r1.f11762o
            if (r2 != 0) goto L57
            int r1 = r1.getCurrentItem()
            java.lang.Object r2 = r0.f9664b
            com.stepos.common.widget.ScrollTextView r2 = (com.stepos.common.widget.ScrollTextView) r2
            com.stepos.common.widget.B r5 = r2.f11764q
            int r5 = r5.f11444b
            if (r1 <= r5) goto L57
            int r0 = r2.getCurrentItem()
            int r5 = r5 - r0
            int r0 = r2.getItemHeight()
            int r0 = r0 * r5
            int r1 = r2.f11759l
            int r0 = r0 + r1
            com.stepos.common.widget.D r1 = r2.f11757j
            r1.c(r0, r4)
            goto Lb6
        L57:
            java.lang.Object r1 = r0.f9664b
            com.stepos.common.widget.ScrollTextView r1 = (com.stepos.common.widget.ScrollTextView) r1
            int r1 = r1.f11759l
            int r1 = java.lang.Math.abs(r1)
            java.lang.Object r2 = r0.f9664b
            com.stepos.common.widget.ScrollTextView r2 = (com.stepos.common.widget.ScrollTextView) r2
            int r2 = r2.getItemHeight()
            int r2 = r2 / r3
            if (r1 <= r2) goto L99
            java.lang.Object r1 = r0.f9664b
            com.stepos.common.widget.ScrollTextView r1 = (com.stepos.common.widget.ScrollTextView) r1
            int r2 = r1.f11759l
            if (r2 <= 0) goto L81
            int r1 = r1.getItemHeight()
            int r1 = -r1
            java.lang.Object r2 = r0.f9664b
            com.stepos.common.widget.ScrollTextView r2 = (com.stepos.common.widget.ScrollTextView) r2
            int r2 = r2.f11759l
        L7f:
            int r1 = r1 + r2
            goto L8f
        L81:
            if (r2 >= 0) goto L8e
            int r1 = r1.getItemHeight()
            java.lang.Object r2 = r0.f9664b
            com.stepos.common.widget.ScrollTextView r2 = (com.stepos.common.widget.ScrollTextView) r2
            int r2 = r2.f11759l
            goto L7f
        L8e:
            r1 = r4
        L8f:
            java.lang.Object r0 = r0.f9664b
            com.stepos.common.widget.ScrollTextView r0 = (com.stepos.common.widget.ScrollTextView) r0
            com.stepos.common.widget.D r0 = r0.f11757j
            r0.c(r1, r4)
            goto Lb6
        L99:
            java.lang.Object r1 = r0.f9664b
            com.stepos.common.widget.ScrollTextView r1 = (com.stepos.common.widget.ScrollTextView) r1
            int r2 = r1.f11759l
            if (r2 == 0) goto Lb6
            com.stepos.common.widget.D r1 = r1.f11757j
            int r5 = java.lang.Math.abs(r2)
            int r5 = r5 * 650
            java.lang.Object r0 = r0.f9664b
            com.stepos.common.widget.ScrollTextView r0 = (com.stepos.common.widget.ScrollTextView) r0
            int r0 = r0.getItemHeight()
            int r0 = r0 / r3
            int r5 = r5 / r0
            r1.c(r2, r5)
        Lb6:
            com.stepos.common.widget.w r6 = r6.f11518h
            r6.removeMessages(r4)
            r0 = 1
            r6.removeMessages(r0)
            r6.removeMessages(r3)
            r6.sendEmptyMessage(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.common.widget.D.b():void");
    }

    public final void c(int i4, int i5) {
        this.f11514d.forceFinished(true);
        this.f11515e = 0;
        Scroller scroller = this.f11514d;
        if (i5 == 0) {
            i5 = 650;
        }
        scroller.startScroll(0, 0, 0, i4, i5);
        w wVar = this.f11518h;
        wVar.removeMessages(0);
        wVar.removeMessages(1);
        wVar.removeMessages(2);
        wVar.sendEmptyMessage(0);
        d();
    }

    public final void d() {
        if (this.f11517g) {
            return;
        }
        this.f11517g = true;
        com.google.android.gms.common.api.internal.p pVar = this.f11511a;
        ScrollTextView scrollTextView = (ScrollTextView) pVar.f9664b;
        scrollTextView.f11758k = true;
        scrollTextView.removeCallbacks(scrollTextView.f11743J);
        Iterator it = ((ScrollTextView) pVar.f9664b).f11745L.iterator();
        while (it.hasNext()) {
            ((z) it.next()).getClass();
        }
    }
}
