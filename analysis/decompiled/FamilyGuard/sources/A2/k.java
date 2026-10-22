package A2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import android.widget.FrameLayout;
import com.stepos.familyguard.ui.widget.chart.histogram.HistogramView;
import y2.AbstractC1325f;

/* loaded from: classes.dex */
public class k<ChartInfoData, BalloonData> extends l {

    /* renamed from: d, reason: collision with root package name */
    private final AbstractC0268g<ChartInfoData> f127d;

    /* renamed from: e, reason: collision with root package name */
    private final AbstractC0262a<BalloonData> f128e;

    /* renamed from: f, reason: collision with root package name */
    private final Paint f129f;

    /* renamed from: g, reason: collision with root package name */
    private final int f130g;

    /* renamed from: h, reason: collision with root package name */
    private final int f131h;

    /* renamed from: i, reason: collision with root package name */
    private final int f132i;

    /* renamed from: j, reason: collision with root package name */
    private final int f133j;

    /* renamed from: k, reason: collision with root package name */
    private View f134k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f135l;

    /* renamed from: m, reason: collision with root package name */
    private Rect f136m;

    /* renamed from: n, reason: collision with root package name */
    private int f137n;

    /* renamed from: o, reason: collision with root package name */
    private int f138o;

    /* renamed from: p, reason: collision with root package name */
    private int f139p;

    /* renamed from: q, reason: collision with root package name */
    private final HistogramView f140q;

    public k(Context context, FrameLayout frameLayout, HistogramView histogramView, AbstractC0262a<BalloonData> abstractC0262a, int i5, int i6, int i7, int i8, int i9) {
        super(context, frameLayout);
        this.f127d = null;
        this.f137n = 0;
        this.f138o = 0;
        this.f139p = 0;
        this.f128e = abstractC0262a;
        Paint paint = new Paint();
        this.f129f = paint;
        paint.setColor(i5);
        this.f131h = i6;
        this.f132i = i7;
        this.f130g = i8;
        this.f133j = i9;
        this.f140q = histogramView;
    }

    @Override // y2.i
    public void a(z2.f fVar) {
        o(fVar);
        AbstractC0268g<ChartInfoData> abstractC0268g = this.f127d;
        if (abstractC0268g != null) {
            abstractC0268g.e();
        }
        this.f128e.d();
    }

    @Override // A2.l, y2.i
    public void c(Canvas canvas) {
        canvas.save();
        if (this.f135l) {
            canvas.drawRect(this.f136m, this.f129f);
        }
        canvas.restore();
    }

    @Override // A2.l, y2.i
    public void l(AbstractC1325f abstractC1325f, boolean z5, int i5, int i6, int i7, int i8) {
        super.l(abstractC1325f, z5, i5, i6, i7, i8);
        int iB = this.f128e.b(this.f137n);
        int height = this.f128e.f93b.getHeight();
        int i9 = this.f137n;
        int i10 = this.f133j;
        this.f136m = new Rect(i9 - (i10 / 2), 0, i9 + (i10 / 2), this.f139p - this.f132i);
        Rect rect = new Rect();
        Rect rect2 = new Rect();
        this.f140q.getGlobalVisibleRect(rect);
        this.f128e.f93b.setTranslationX(iB);
        this.f141c.getGlobalVisibleRect(rect2);
        this.f128e.f93b.setTranslationY(((rect.top - rect2.top) - height) - this.f130g);
    }

    @Override // A2.l
    protected FrameLayout m(Context context) {
        View viewB;
        if (this.f141c == null) {
            FrameLayout frameLayout = new FrameLayout(context);
            this.f141c = frameLayout;
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        }
        AbstractC0268g<ChartInfoData> abstractC0268g = this.f127d;
        if (abstractC0268g != null && (viewB = abstractC0268g.b(context)) != null) {
            viewB.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.f141c.addView(viewB);
        }
        AbstractC0262a<BalloonData> abstractC0262a = this.f128e;
        if (abstractC0262a != null) {
            View viewC = abstractC0262a.c(context);
            this.f134k = viewC;
            if (viewC != null) {
                viewC.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
                this.f141c.addView(this.f134k);
            }
        }
        this.f141c.setClipChildren(false);
        return this.f141c;
    }

    public void o(z2.f fVar) {
        AbstractC0268g<ChartInfoData> abstractC0268g = this.f127d;
        if (abstractC0268g != null) {
            abstractC0268g.a(fVar);
        }
    }

    public int p(HistogramView histogramView, int i5) {
        y2.h dataLayer;
        y2.g[] gVarArrF;
        if (histogramView != null && (dataLayer = histogramView.getDataLayer()) != null && (gVarArrF = dataLayer.f()) != null && (gVarArrF instanceof m[]) && i5 < gVarArrF.length && i5 >= 0) {
            return ((m) gVarArrF[i5]).getBounds().centerX();
        }
        return -1;
    }

    public void q(HistogramView histogramView, boolean z5, int i5, Object obj) {
        this.f135l = z5;
        if (!z5) {
            AbstractC0268g<ChartInfoData> abstractC0268g = this.f127d;
            if (abstractC0268g != null) {
                abstractC0268g.e();
            }
            this.f128e.d();
            return;
        }
        AbstractC0268g<ChartInfoData> abstractC0268g2 = this.f127d;
        if (abstractC0268g2 != null) {
            abstractC0268g2.c();
        }
        this.f128e.f();
        this.f128e.a(obj);
        histogramView.requestLayout();
        this.f137n = p(histogramView, i5);
        R1.a.a("FloatForegroundBalloonLayer", "doHoveredHistogramChanged index = " + i5 + " centerX = " + this.f137n);
        m mVar = (m) histogramView.getDataLayer().f()[i5];
        this.f138o = mVar.getBounds().top;
        this.f139p = mVar.b().top;
    }
}
