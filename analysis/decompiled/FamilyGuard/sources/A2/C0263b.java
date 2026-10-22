package A2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import android.widget.FrameLayout;
import com.stepos.familyguard.ui.widget.chart.histogram.HistogramView;
import y2.AbstractC1325f;

/* renamed from: A2.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0263b<ChartInfoData, BalloonData> extends l {

    /* renamed from: d, reason: collision with root package name */
    private final AbstractC0268g<ChartInfoData> f95d;

    /* renamed from: e, reason: collision with root package name */
    private final AbstractC0262a<BalloonData> f96e;

    /* renamed from: f, reason: collision with root package name */
    private final Paint f97f;

    /* renamed from: g, reason: collision with root package name */
    private View f98g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f99h;

    /* renamed from: i, reason: collision with root package name */
    private Rect f100i;

    /* renamed from: j, reason: collision with root package name */
    private int f101j;

    /* renamed from: k, reason: collision with root package name */
    private int f102k;

    /* renamed from: l, reason: collision with root package name */
    private int f103l;

    /* renamed from: m, reason: collision with root package name */
    private final int f104m;

    /* renamed from: n, reason: collision with root package name */
    private final int f105n;

    /* renamed from: o, reason: collision with root package name */
    private final int f106o;

    /* renamed from: p, reason: collision with root package name */
    private final int f107p;

    public C0263b(Context context, AbstractC0268g<ChartInfoData> abstractC0268g, AbstractC0262a<BalloonData> abstractC0262a, int i5, int i6, int i7, int i8, int i9) {
        super(context);
        this.f101j = 0;
        this.f102k = 0;
        this.f103l = 0;
        this.f95d = abstractC0268g;
        this.f96e = abstractC0262a;
        Paint paint = new Paint();
        this.f97f = paint;
        paint.setColor(i5);
        this.f105n = i6;
        this.f106o = i7;
        this.f104m = i8;
        this.f107p = i9;
    }

    @Override // y2.i
    public void a(z2.f fVar) {
        o(fVar);
        AbstractC0268g<ChartInfoData> abstractC0268g = this.f95d;
        if (abstractC0268g != null) {
            abstractC0268g.e();
        }
        this.f96e.d();
    }

    @Override // A2.l, y2.i
    public void c(Canvas canvas) {
        super.c(canvas);
        if (this.f99h) {
            canvas.drawRect(this.f100i, this.f97f);
        }
    }

    @Override // A2.l, y2.i
    public void l(AbstractC1325f abstractC1325f, boolean z5, int i5, int i6, int i7, int i8) {
        super.l(abstractC1325f, z5, i5, i6, i7, i8);
        int iB = this.f96e.b(this.f101j);
        int left = this.f96e.f93b.getLeft();
        int right = this.f96e.f93b.getRight();
        this.f96e.f93b.setLeft(left + iB);
        this.f96e.f93b.setRight(right + iB);
        int height = this.f96e.f93b.getHeight();
        int i9 = this.f102k - this.f104m;
        this.f96e.f93b.setBottom(i9);
        this.f96e.f93b.setTop(i9 - height);
        this.f100i = new Rect(this.f101j - (this.f107p / 2), this.f98g.getBottom() + this.f105n, this.f101j + (this.f107p / 2), this.f103l - this.f106o);
    }

    @Override // A2.l
    protected FrameLayout m(Context context) {
        View viewB;
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        AbstractC0268g<ChartInfoData> abstractC0268g = this.f95d;
        if (abstractC0268g != null && (viewB = abstractC0268g.b(context)) != null) {
            viewB.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            frameLayout.addView(viewB);
        }
        AbstractC0262a<BalloonData> abstractC0262a = this.f96e;
        if (abstractC0262a != null) {
            View viewC = abstractC0262a.c(context);
            this.f98g = viewC;
            if (viewC != null) {
                viewC.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
                frameLayout.addView(this.f98g);
            }
        }
        return frameLayout;
    }

    public void o(z2.f fVar) {
        AbstractC0268g<ChartInfoData> abstractC0268g = this.f95d;
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
        this.f99h = z5;
        if (!z5) {
            AbstractC0268g<ChartInfoData> abstractC0268g = this.f95d;
            if (abstractC0268g != null) {
                abstractC0268g.e();
            }
            this.f96e.d();
            return;
        }
        AbstractC0268g<ChartInfoData> abstractC0268g2 = this.f95d;
        if (abstractC0268g2 != null) {
            abstractC0268g2.c();
        }
        this.f96e.f();
        this.f96e.a(obj);
        histogramView.requestLayout();
        this.f101j = p(histogramView, i5);
        R1.a.a("BalloonForegroundLayer", "doHoveredHistogramChanged index = " + i5 + " centerX = " + this.f101j);
        m mVar = (m) histogramView.getDataLayer().f()[i5];
        this.f102k = mVar.getBounds().top;
        this.f103l = mVar.b().top;
    }
}
