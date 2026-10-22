package y2;

import A2.AbstractC0264c;
import A2.C0263b;
import A2.E;
import A2.F;
import A2.G;
import A2.r;
import A2.s;
import A2.t;
import A2.u;
import A2.v;
import A2.w;
import A2.x;
import A2.y;
import android.content.Context;
import android.widget.FrameLayout;
import com.stepos.familyguard.ui.widget.chart.histogram.BalloonHistogramView;
import com.stepos.familyguard.ui.widget.chart.histogram.HistogramView;

/* renamed from: y2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1320a implements InterfaceC1324e {

    /* renamed from: a, reason: collision with root package name */
    private final int f23912a;

    /* renamed from: b, reason: collision with root package name */
    private final FrameLayout f23913b;

    public C1320a(int i5) {
        this(i5, null);
    }

    @Override // y2.InterfaceC1324e
    public AbstractC0264c a(AbstractC1325f abstractC1325f) {
        return abstractC1325f.b(abstractC1325f);
    }

    @Override // y2.InterfaceC1324e
    public i b(AbstractC1325f abstractC1325f) {
        Context context = abstractC1325f.getContext();
        BalloonHistogramView balloonHistogramView = abstractC1325f instanceof BalloonHistogramView ? (BalloonHistogramView) abstractC1325f : null;
        if (balloonHistogramView == null) {
            return null;
        }
        int i5 = this.f23912a;
        if (i5 == 4) {
            HistogramView histogramView = (HistogramView) abstractC1325f;
            BalloonHistogramView balloonHistogramView2 = balloonHistogramView;
            A2.k kVar = new A2.k(context, this.f23913b, histogramView, new E(context, histogramView), balloonHistogramView2.getBalloonLineColor(), balloonHistogramView2.getBalloonLineMarginTop(), balloonHistogramView2.getBalloonLineMarginBottom(), balloonHistogramView2.getBalloonMarginBottom(), balloonHistogramView2.getBalloonLineWidth());
            kVar.n(context);
            return kVar;
        }
        BalloonHistogramView balloonHistogramView3 = balloonHistogramView;
        if (i5 == 6) {
            C0263b c0263b = new C0263b(context, new t(), new r(context, (HistogramView) abstractC1325f), balloonHistogramView3.getBalloonLineColor(), balloonHistogramView3.getBalloonLineMarginTop(), balloonHistogramView3.getBalloonLineMarginBottom(), balloonHistogramView3.getBalloonMarginBottom(), balloonHistogramView3.getBalloonLineWidth());
            c0263b.n(context);
            return c0263b;
        }
        if (i5 == 5) {
            C0263b c0263b2 = new C0263b(context, new x(), new v(context, (HistogramView) abstractC1325f), balloonHistogramView3.getBalloonLineColor(), balloonHistogramView3.getBalloonLineMarginTop(), balloonHistogramView3.getBalloonLineMarginBottom(), balloonHistogramView3.getBalloonMarginBottom(), balloonHistogramView3.getBalloonLineWidth());
            c0263b2.n(context);
            return c0263b2;
        }
        if (i5 == 3) {
            C0263b c0263b3 = new C0263b(context, null, new A2.j(context, (HistogramView) abstractC1325f), balloonHistogramView3.getBalloonLineColor(), balloonHistogramView3.getBalloonLineMarginTop(), balloonHistogramView3.getBalloonLineMarginBottom(), balloonHistogramView3.getBalloonMarginBottom(), balloonHistogramView3.getBalloonLineWidth());
            c0263b3.n(context);
            return c0263b3;
        }
        if (i5 == 24) {
            C0263b c0263b4 = new C0263b(context, new G(), new F(context, (HistogramView) abstractC1325f), balloonHistogramView3.getBalloonLineColor(), balloonHistogramView3.getBalloonLineMarginTop(), balloonHistogramView3.getBalloonLineMarginBottom(), balloonHistogramView3.getBalloonMarginBottom(), balloonHistogramView3.getBalloonLineWidth());
            c0263b4.n(context);
            return c0263b4;
        }
        if (i5 == 26) {
            C0263b c0263b5 = new C0263b(context, new u(), new s(context, (HistogramView) abstractC1325f), balloonHistogramView3.getBalloonLineColor(), balloonHistogramView3.getBalloonLineMarginTop(), balloonHistogramView3.getBalloonLineMarginBottom(), balloonHistogramView3.getBalloonMarginBottom(), balloonHistogramView3.getBalloonLineWidth());
            c0263b5.n(context);
            return c0263b5;
        }
        if (i5 != 25) {
            return null;
        }
        C0263b c0263b6 = new C0263b(context, new y(), new w(context, (HistogramView) abstractC1325f), balloonHistogramView3.getBalloonLineColor(), balloonHistogramView3.getBalloonLineMarginTop(), balloonHistogramView3.getBalloonLineMarginBottom(), balloonHistogramView3.getBalloonMarginBottom(), balloonHistogramView3.getBalloonLineWidth());
        c0263b6.n(context);
        return c0263b6;
    }

    @Override // y2.InterfaceC1324e
    public h c(AbstractC1325f abstractC1325f) {
        return abstractC1325f.c(abstractC1325f);
    }

    public C1320a(int i5, FrameLayout frameLayout) {
        this.f23912a = i5;
        this.f23913b = frameLayout;
    }
}
