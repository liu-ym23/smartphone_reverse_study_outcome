package com.stepos.familyguard.ui.widget.chart.histogram;

import A2.AbstractC0264c;
import A2.q;
import A2.z;
import T1.g;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.PathEffect;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import com.stepos.digitalwellbeing.server.data.NotificationTimesStats;
import com.stepos.digitalwellbeing.server.data.PickupTimesStats;
import com.stepos.digitalwellbeing.server.data.StatsDataSet;
import com.stepos.digitalwellbeing.server.data.UsingTimeStats;
import com.stepos.familyguard.R;
import com.stepos.familyguard.ui.widget.chart.histogram.b;
import f2.C0702g;
import g2.C0737g;
import y2.AbstractC1321b;
import y2.AbstractC1325f;
import y2.InterfaceC1323d;
import y2.h;
import z2.f;
import z2.i;
import z2.k;
import z2.n;

/* loaded from: classes.dex */
public class HistogramView extends AbstractC1325f {

    /* renamed from: g0, reason: collision with root package name */
    public static final float[] f15231g0 = {g.f(3.0f), g.f(1.5f)};

    /* renamed from: A, reason: collision with root package name */
    private int[] f15232A;

    /* renamed from: B, reason: collision with root package name */
    private int[] f15233B;

    /* renamed from: C, reason: collision with root package name */
    private int f15234C;

    /* renamed from: D, reason: collision with root package name */
    private int f15235D;

    /* renamed from: E, reason: collision with root package name */
    private boolean f15236E;

    /* renamed from: F, reason: collision with root package name */
    private boolean f15237F;

    /* renamed from: G, reason: collision with root package name */
    private boolean f15238G;

    /* renamed from: H, reason: collision with root package name */
    private boolean f15239H;

    /* renamed from: I, reason: collision with root package name */
    private boolean f15240I;

    /* renamed from: J, reason: collision with root package name */
    private int f15241J;

    /* renamed from: K, reason: collision with root package name */
    private int f15242K;

    /* renamed from: L, reason: collision with root package name */
    private int f15243L;

    /* renamed from: M, reason: collision with root package name */
    private String f15244M;

    /* renamed from: Q, reason: collision with root package name */
    private int f15245Q;

    /* renamed from: R, reason: collision with root package name */
    private PathEffect f15246R;

    /* renamed from: S, reason: collision with root package name */
    private int f15247S;

    /* renamed from: T, reason: collision with root package name */
    private int f15248T;

    /* renamed from: U, reason: collision with root package name */
    private int f15249U;

    /* renamed from: V, reason: collision with root package name */
    private boolean f15250V;

    /* renamed from: W, reason: collision with root package name */
    private boolean f15251W;

    /* renamed from: a0, reason: collision with root package name */
    private float f15252a0;

    /* renamed from: b0, reason: collision with root package name */
    private int f15253b0;

    /* renamed from: c0, reason: collision with root package name */
    private int f15254c0;

    /* renamed from: d0, reason: collision with root package name */
    private int f15255d0;

    /* renamed from: e0, reason: collision with root package name */
    private b f15256e0;

    /* renamed from: f0, reason: collision with root package name */
    private c f15257f0;

    /* renamed from: g, reason: collision with root package name */
    protected boolean f15258g;

    /* renamed from: h, reason: collision with root package name */
    private int[] f15259h;

    /* renamed from: i, reason: collision with root package name */
    private int[] f15260i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f15261j;

    /* renamed from: k, reason: collision with root package name */
    private int f15262k;

    /* renamed from: l, reason: collision with root package name */
    private int f15263l;

    /* renamed from: m, reason: collision with root package name */
    private PathEffect f15264m;

    /* renamed from: n, reason: collision with root package name */
    private PathEffect f15265n;

    /* renamed from: o, reason: collision with root package name */
    private int f15266o;

    /* renamed from: p, reason: collision with root package name */
    private int f15267p;

    /* renamed from: q, reason: collision with root package name */
    private int f15268q;

    /* renamed from: r, reason: collision with root package name */
    private int f15269r;

    /* renamed from: s, reason: collision with root package name */
    private int f15270s;

    /* renamed from: t, reason: collision with root package name */
    private int f15271t;

    /* renamed from: u, reason: collision with root package name */
    private int f15272u;

    /* renamed from: v, reason: collision with root package name */
    private int f15273v;

    /* renamed from: w, reason: collision with root package name */
    private b.a f15274w;

    /* renamed from: x, reason: collision with root package name */
    private b.a f15275x;

    /* renamed from: y, reason: collision with root package name */
    private String[] f15276y;

    /* renamed from: z, reason: collision with root package name */
    private String[] f15277z;

    protected static class a implements InterfaceC1323d {
        protected a() {
        }

        @Override // y2.InterfaceC1323d
        public f a(Object... objArr) {
            if (objArr instanceof StatsDataSet[]) {
                return new z2.d(objArr);
            }
            if (objArr instanceof PickupTimesStats[]) {
                return new k(objArr);
            }
            if (objArr instanceof NotificationTimesStats[]) {
                return new i(objArr);
            }
            if (objArr instanceof UsingTimeStats[]) {
                return new n(objArr);
            }
            return null;
        }
    }

    public interface b {
        void a(HistogramView histogramView, boolean z5, int i5, Object obj);
    }

    public interface c {
        void a(HistogramView histogramView, int i5, Object obj);
    }

    public HistogramView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    static void l(String str, Canvas canvas, float f5, float f6, TextPaint textPaint) {
        if (textPaint == null) {
            return;
        }
        canvas.drawText(str, f5, f6 - textPaint.getFontMetrics().ascent, textPaint);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0043  */
    @Override // y2.AbstractC1325f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected z2.e a(z2.f r3) {
        /*
            r2 = this;
            java.lang.Object[] r0 = r3.f()
            boolean r1 = r0 instanceof com.stepos.digitalwellbeing.server.data.StatsDataSet[]
            if (r1 == 0) goto L2e
            boolean r0 = r3 instanceof z2.d
            if (r0 == 0) goto L16
            z2.c r3 = new z2.c
            int[] r0 = r2.f15259h
            int[] r1 = r2.f15260i
            r3.<init>(r0, r1)
            goto L4c
        L16:
            boolean r0 = r3 instanceof z2.j
            if (r0 == 0) goto L22
            z2.m r3 = new z2.m
            int[] r0 = r2.f15259h
            r3.<init>(r0)
            goto L4c
        L22:
            boolean r3 = r3 instanceof z2.h
            if (r3 == 0) goto L43
            z2.m r3 = new z2.m
            int[] r0 = r2.f15259h
            r3.<init>(r0)
            goto L4c
        L2e:
            boolean r3 = r0 instanceof com.stepos.digitalwellbeing.server.data.PickupTimesStats[]
            if (r3 != 0) goto L45
            boolean r3 = r0 instanceof com.stepos.digitalwellbeing.server.data.NotificationTimesStats[]
            if (r3 == 0) goto L37
            goto L45
        L37:
            boolean r3 = r0 instanceof com.stepos.digitalwellbeing.server.data.UsingTimeStats[]
            if (r3 == 0) goto L43
            z2.m r3 = new z2.m
            int[] r0 = r2.f15259h
            r3.<init>(r0)
            goto L4c
        L43:
            r3 = 0
            goto L4c
        L45:
            z2.m r3 = new z2.m
            int[] r0 = r2.f15259h
            r3.<init>(r0)
        L4c:
            if (r3 == 0) goto L58
            float r0 = r2.f15252a0
            r3.i(r0)
            int r2 = r2.f15253b0
            r3.h(r2)
        L58:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.familyguard.ui.widget.chart.histogram.HistogramView.a(z2.f):z2.e");
    }

    @Override // y2.AbstractC1325f
    public AbstractC0264c b(AbstractC1325f abstractC1325f) {
        return n() ? new com.stepos.familyguard.ui.widget.chart.histogram.a(getContext(), this.f15262k, this.f15263l, this.f15264m, this.f15265n, this.f15266o, this.f15267p, this.f15268q, this.f15269r, this.f15270s, this.f15271t, this.f15272u, this.f15273v, this.f15274w, this.f15275x, this.f15276y, this.f15277z, this.f15232A, this.f15233B, this.f15234C, this.f15235D, this.f15236E, this.f15237F, this.f15238G, this.f15239H, this.f15255d0, this.f15254c0, this.f15241J, this.f15242K, this.f15244M, this.f15243L, this.f15246R, this.f15245Q) : new e(getContext(), this.f15262k, this.f15263l, this.f15264m, this.f15265n, this.f15266o, this.f15267p, this.f15268q, this.f15269r, this.f15270s, this.f15271t, this.f15272u, this.f15273v, this.f15274w, this.f15275x, this.f15276y, this.f15277z, this.f15232A, this.f15233B, this.f15234C, this.f15235D, this.f15236E, this.f15237F, this.f15238G, this.f15239H, this.f15255d0, this.f15254c0);
    }

    @Override // y2.AbstractC1325f
    public h c(AbstractC1325f abstractC1325f) {
        Log.d("HistogramView", "createDataLayer");
        AbstractC1321b dVar = this.f15251W ? new d(getContext(), null) : this.f15250V ? new com.stepos.familyguard.ui.widget.chart.histogram.c(getContext(), null) : new A2.n(getContext(), null);
        dVar.m(new q(this.f15248T, this.f15249U, this.f15258g, this.f15247S));
        return dVar;
    }

    @Override // y2.AbstractC1325f
    protected InterfaceC1323d d() {
        return new a();
    }

    @Override // y2.AbstractC1325f
    public y2.i e(AbstractC1325f abstractC1325f) {
        return null;
    }

    public int getAverageFontSize() {
        return this.f15243L;
    }

    public int getAverageLineColor() {
        return this.f15241J;
    }

    public PathEffect getAveragePathEffect() {
        return this.f15246R;
    }

    public int getAverageStrokeWidth() {
        return this.f15245Q;
    }

    public String getAverageText() {
        return this.f15244M;
    }

    public int[] getHistogramCategoricalColors() {
        return this.f15260i;
    }

    public int getHistogramGap() {
        return this.f15247S;
    }

    public int getHistogramHeight() {
        return this.f15249U;
    }

    public int[] getHistogramStateColors() {
        return this.f15259h;
    }

    public int getHistogramWidth() {
        return this.f15248T;
    }

    public b getOnHistogramHoveredChangedListener() {
        return this.f15256e0;
    }

    public c getOnHistogramSelectedChangedListener() {
        return this.f15257f0;
    }

    public b.a getXDimensionAlignType() {
        return this.f15274w;
    }

    public int getXDimensionFontSize() {
        return this.f15270s;
    }

    public int[] getXDimensionIndexArray() {
        return this.f15232A;
    }

    public int getXDimensionMargin() {
        return this.f15234C;
    }

    public String[] getXDimensionStrings() {
        return this.f15276y;
    }

    public int getXDimensionTextColor() {
        return this.f15272u;
    }

    public int getXSegmentDividerColor() {
        return this.f15266o;
    }

    public PathEffect getXSegmentDividerPathEffect() {
        return this.f15264m;
    }

    public int getXSegmentDividerStrokeWidth() {
        return this.f15268q;
    }

    public int getXSegmentSize() {
        return this.f15262k;
    }

    public b.a getYDimensionAlignType() {
        return this.f15275x;
    }

    public int getYDimensionFontSize() {
        return this.f15271t;
    }

    public int[] getYDimensionIndexArray() {
        return this.f15233B;
    }

    public int getYDimensionMargin() {
        return this.f15235D;
    }

    public String[] getYDimensionStrings() {
        return this.f15277z;
    }

    public int getYDimensionTextColor() {
        return this.f15273v;
    }

    public int getYSegmentDividerColor() {
        return this.f15267p;
    }

    public PathEffect getYSegmentDividerPathEffect() {
        return this.f15265n;
    }

    public int getYSegmentDividerStrokeWidth() {
        return this.f15269r;
    }

    public int getYSegmentSize() {
        return this.f15263l;
    }

    protected void h(boolean z5, int i5) {
        f fVarB;
        Object[] objArrF;
        C0702g.b("HistogramView", "doHistogramHoveredChang: hovered = " + z5 + " index = " + i5);
        h dataLayer = getDataLayer();
        Object obj = null;
        if (dataLayer != null && (fVarB = dataLayer.b()) != null && (objArrF = fVarB.f()) != null && objArrF.length != 0 && i5 >= 0 && i5 < objArrF.length) {
            obj = objArrF[i5];
        }
        i(z5, i5, obj);
        AbstractC0264c backgroundLayer = getBackgroundLayer();
        if (backgroundLayer instanceof e) {
            ((e) backgroundLayer).N(i5);
        }
    }

    protected void i(boolean z5, int i5, Object obj) {
        b bVar = this.f15256e0;
        if (bVar != null) {
            bVar.a(this, z5, i5, obj);
        }
    }

    protected void j(int i5) {
        f fVarB;
        Object[] objArrF;
        C0702g.b("HistogramView", "doHistogramSelectedChange:index = " + i5);
        h dataLayer = getDataLayer();
        Object obj = null;
        if (dataLayer != null && (fVarB = dataLayer.b()) != null && (objArrF = fVarB.f()) != null && objArrF.length != 0 && i5 >= 0 && i5 < objArrF.length) {
            obj = objArrF[i5];
        }
        k(i5, obj);
        AbstractC0264c backgroundLayer = getBackgroundLayer();
        if (backgroundLayer instanceof e) {
            ((e) backgroundLayer).O(i5);
        }
    }

    protected void k(int i5, Object obj) {
        c cVar = this.f15257f0;
        if (cVar != null) {
            cVar.a(this, i5, obj);
        }
    }

    public boolean m() {
        return this.f15250V;
    }

    public boolean n() {
        return this.f15240I;
    }

    public boolean o() {
        return this.f15251W;
    }

    @Override // y2.AbstractC1325f, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void p() {
        h dataLayer = getDataLayer();
        if (dataLayer instanceof d) {
            ((d) dataLayer).x();
        }
    }

    protected void q() {
        f fVarB = getDataAdapter().b();
        double d6 = fVarB.d() / fVarB.a();
        AbstractC0264c backgroundLayer = getBackgroundLayer();
        if (backgroundLayer instanceof com.stepos.familyguard.ui.widget.chart.histogram.a) {
            ((com.stepos.familyguard.ui.widget.chart.histogram.a) backgroundLayer).R((float) d6);
        }
    }

    public void setAverageFontSize(int i5) {
        this.f15243L = i5;
    }

    public void setAverageLineColor(int i5) {
        this.f15241J = i5;
    }

    public void setAveragePathEffect(PathEffect pathEffect) {
        this.f15246R = pathEffect;
    }

    public void setAverageStrokeWidth(int i5) {
        this.f15245Q = i5;
    }

    public void setAverageText(String str) {
        this.f15244M = str;
    }

    public void setCategorical(boolean z5) {
        this.f15261j = z5;
    }

    @Override // y2.AbstractC1325f
    public void setData(Object... objArr) {
        super.setData(objArr);
        if (n()) {
            q();
        }
    }

    public void setDimensionAtStart(boolean z5) {
        this.f15236E = z5;
        com.stepos.familyguard.ui.widget.chart.histogram.b bVar = (com.stepos.familyguard.ui.widget.chart.histogram.b) getBackgroundLayer();
        if (bVar != null) {
            bVar.D(this.f15236E);
        }
    }

    public void setDimensionAtTop(boolean z5) {
        this.f15237F = z5;
        com.stepos.familyguard.ui.widget.chart.histogram.b bVar = (com.stepos.familyguard.ui.widget.chart.histogram.b) getBackgroundLayer();
        if (bVar != null) {
            bVar.E(this.f15237F);
        }
    }

    public void setHistogramAlignEnd(boolean z5) {
        this.f15258g = z5;
        com.stepos.familyguard.ui.widget.chart.histogram.b bVar = (com.stepos.familyguard.ui.widget.chart.histogram.b) getBackgroundLayer();
        if (bVar != null) {
            bVar.G(this.f15258g);
        }
    }

    public void setHistogramCategoricalColors(int[] iArr) {
        this.f15260i = iArr;
    }

    public void setHistogramGap(int i5) {
        this.f15247S = i5;
    }

    public void setHistogramHeight(int i5) {
        this.f15249U = i5;
    }

    public void setHistogramStateColors(int[] iArr) {
        this.f15259h = iArr;
    }

    public void setHistogramWidth(int i5) {
        this.f15248T = i5;
    }

    public void setHoverable(boolean z5) {
        this.f15250V = z5;
    }

    public void setNeedAverageLine(boolean z5) {
        this.f15240I = z5;
    }

    public void setOnHistogramHoveredChangedListener(b bVar) {
        this.f15256e0 = bVar;
    }

    public void setOnHistogramSelectedChangedListener(c cVar) {
        this.f15257f0 = cVar;
    }

    public void setSelectable(boolean z5) {
        this.f15251W = z5;
    }

    public void setSelectedIndex(int i5) {
        h dataLayer = getDataLayer();
        if (dataLayer instanceof d) {
            ((d) dataLayer).y(i5);
        }
        AbstractC0264c backgroundLayer = getBackgroundLayer();
        if ((backgroundLayer instanceof e) && this.f15251W) {
            ((e) backgroundLayer).O(i5);
        }
    }

    public void setXDimensionAlignType(b.a aVar) {
        this.f15274w = aVar;
        com.stepos.familyguard.ui.widget.chart.histogram.b bVar = (com.stepos.familyguard.ui.widget.chart.histogram.b) getBackgroundLayer();
        if (bVar != null) {
            bVar.F(this.f15274w);
        }
    }

    public void setXDimensionFix(boolean z5) {
        this.f15238G = z5;
        com.stepos.familyguard.ui.widget.chart.histogram.b bVar = (com.stepos.familyguard.ui.widget.chart.histogram.b) getBackgroundLayer();
        if (bVar != null) {
            bVar.G(this.f15238G);
        }
    }

    public void setXDimensionFontSize(int i5) {
        this.f15270s = i5;
        com.stepos.familyguard.ui.widget.chart.histogram.b bVar = (com.stepos.familyguard.ui.widget.chart.histogram.b) getBackgroundLayer();
        if (bVar != null) {
            bVar.H(i5);
        }
    }

    public void setXDimensionIndexArray(int[] iArr) {
        this.f15232A = iArr;
        com.stepos.familyguard.ui.widget.chart.histogram.b bVar = (com.stepos.familyguard.ui.widget.chart.histogram.b) getBackgroundLayer();
        if (bVar != null) {
            bVar.I(iArr);
        }
    }

    public void setXDimensionMargin(int i5) {
        this.f15234C = i5;
    }

    public void setXDimensionStrings(String[] strArr) {
        this.f15276y = strArr;
        com.stepos.familyguard.ui.widget.chart.histogram.b bVar = (com.stepos.familyguard.ui.widget.chart.histogram.b) getBackgroundLayer();
        if (bVar != null) {
            bVar.J(strArr);
        }
    }

    public void setXDimensionTextColor(int i5) {
        this.f15272u = i5;
        com.stepos.familyguard.ui.widget.chart.histogram.b bVar = (com.stepos.familyguard.ui.widget.chart.histogram.b) getBackgroundLayer();
        if (bVar != null) {
            bVar.K(this.f15272u);
        }
    }

    public void setXSegmentDividerColor(int i5) {
        this.f15266o = i5;
        z zVar = (z) getBackgroundLayer();
        if (zVar != null) {
            zVar.r(this.f15266o);
        }
    }

    public void setXSegmentDividerPathEffect(PathEffect pathEffect) {
        this.f15264m = pathEffect;
        z zVar = (z) getBackgroundLayer();
        if (zVar != null) {
            zVar.s(pathEffect);
        }
    }

    public void setXSegmentDividerStrokeWidth(int i5) {
        this.f15268q = i5;
        z zVar = (z) getBackgroundLayer();
        if (zVar != null) {
            zVar.t(this.f15268q);
        }
    }

    public void setXSegmentSize(int i5) {
        this.f15262k = i5;
    }

    public void setYDimensionAlignType(b.a aVar) {
        this.f15275x = aVar;
        com.stepos.familyguard.ui.widget.chart.histogram.b bVar = (com.stepos.familyguard.ui.widget.chart.histogram.b) getBackgroundLayer();
        if (bVar != null) {
            bVar.L(this.f15275x);
        }
    }

    public void setYDimensionFix(boolean z5) {
        this.f15239H = z5;
        com.stepos.familyguard.ui.widget.chart.histogram.b bVar = (com.stepos.familyguard.ui.widget.chart.histogram.b) getBackgroundLayer();
        if (bVar != null) {
            bVar.G(this.f15239H);
        }
    }

    public void setYDimensionFontSize(int i5) {
        this.f15271t = i5;
        com.stepos.familyguard.ui.widget.chart.histogram.b bVar = (com.stepos.familyguard.ui.widget.chart.histogram.b) getBackgroundLayer();
        if (bVar != null) {
            bVar.H(this.f15271t);
        }
    }

    public void setYDimensionIndexArray(int[] iArr) {
        this.f15233B = iArr;
        com.stepos.familyguard.ui.widget.chart.histogram.b bVar = (com.stepos.familyguard.ui.widget.chart.histogram.b) getBackgroundLayer();
        if (bVar != null) {
            bVar.I(this.f15233B);
        }
    }

    public void setYDimensionMargin(int i5) {
        this.f15235D = i5;
    }

    public void setYDimensionStrings(String[] strArr) {
        this.f15277z = strArr;
        com.stepos.familyguard.ui.widget.chart.histogram.b bVar = (com.stepos.familyguard.ui.widget.chart.histogram.b) getBackgroundLayer();
        if (bVar != null) {
            bVar.M(strArr);
        }
    }

    public void setYDimensionTextColor(int i5) {
        this.f15273v = i5;
        com.stepos.familyguard.ui.widget.chart.histogram.b bVar = (com.stepos.familyguard.ui.widget.chart.histogram.b) getBackgroundLayer();
        if (bVar != null) {
            bVar.K(this.f15273v);
        }
    }

    public void setYSegmentDividerColor(int i5) {
        this.f15267p = i5;
        z zVar = (z) getBackgroundLayer();
        if (zVar != null) {
            zVar.r(this.f15267p);
        }
    }

    public void setYSegmentDividerPathEffect(PathEffect pathEffect) {
        this.f15265n = pathEffect;
        z zVar = (z) getBackgroundLayer();
        if (zVar != null) {
            zVar.s(this.f15265n);
        }
    }

    public void setYSegmentDividerStrokeWidth(int i5) {
        this.f15269r = i5;
        z zVar = (z) getBackgroundLayer();
        if (zVar != null) {
            zVar.t(this.f15269r);
        }
    }

    public void setYSegmentSize(int i5) {
        this.f15263l = i5;
    }

    public HistogramView(Context context, AttributeSet attributeSet, int i5) {
        this(context, attributeSet, i5, 0);
    }

    public HistogramView(Context context, AttributeSet attributeSet, int i5, int i6) {
        super(context, attributeSet, i5, i6);
        this.f15258g = false;
        this.f15261j = false;
        Resources.Theme theme = context.getTheme();
        Resources resources = context.getResources();
        TypedArray typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, C0737g.f17380Y0, i5, i6);
        this.f15259h = resources.getIntArray(typedArrayObtainStyledAttributes.getResourceId(13, R.array.us_pickup_state_colors));
        boolean z5 = typedArrayObtainStyledAttributes.getBoolean(6, false);
        this.f15261j = z5;
        if (z5) {
            this.f15260i = resources.getIntArray(typedArrayObtainStyledAttributes.getResourceId(10, R.array.us_categorical_colors));
        }
        this.f15262k = typedArrayObtainStyledAttributes.getInt(32, 4);
        this.f15263l = typedArrayObtainStyledAttributes.getInt(43, 2);
        this.f15266o = typedArrayObtainStyledAttributes.getColor(29, androidx.core.content.res.h.d(resources, R.color.us_widget_divider_color, theme));
        this.f15267p = typedArrayObtainStyledAttributes.getColor(40, androidx.core.content.res.h.d(resources, R.color.us_widget_histogram_y_segment_divider_color, theme));
        this.f15268q = typedArrayObtainStyledAttributes.getDimensionPixelSize(31, 3);
        this.f15269r = typedArrayObtainStyledAttributes.getDimensionPixelSize(42, 3);
        this.f15270s = typedArrayObtainStyledAttributes.getDimensionPixelSize(24, resources.getDimensionPixelSize(R.dimen.us_widget_histogram_label_text_size));
        this.f15271t = typedArrayObtainStyledAttributes.getDimensionPixelSize(35, resources.getDimensionPixelSize(R.dimen.us_widget_histogram_label_text_size));
        this.f15272u = typedArrayObtainStyledAttributes.getColor(28, androidx.core.content.res.h.d(resources, R.color.us_histogram_divider_text_color, theme));
        this.f15273v = typedArrayObtainStyledAttributes.getColor(39, androidx.core.content.res.h.d(resources, R.color.us_histogram_divider_text_color, theme));
        b.a[] aVarArrValues = b.a.values();
        b.a aVar = b.a.CENTER;
        this.f15274w = aVarArrValues[typedArrayObtainStyledAttributes.getInt(22, aVar.ordinal())];
        this.f15275x = b.a.values()[typedArrayObtainStyledAttributes.getInt(33, aVar.ordinal())];
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(27, 0);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(38, 0);
        if (resourceId != 0) {
            this.f15276y = resources.getStringArray(resourceId);
        }
        if (resourceId2 != 0) {
            this.f15277z = resources.getStringArray(resourceId2);
        }
        int resourceId3 = typedArrayObtainStyledAttributes.getResourceId(27, 0);
        int resourceId4 = typedArrayObtainStyledAttributes.getResourceId(38, 0);
        if (resourceId != 0) {
            this.f15232A = resources.getIntArray(resourceId3);
        }
        if (resourceId2 != 0) {
            this.f15233B = resources.getIntArray(resourceId4);
        }
        this.f15234C = typedArrayObtainStyledAttributes.getDimensionPixelOffset(26, 0);
        this.f15235D = typedArrayObtainStyledAttributes.getDimensionPixelOffset(37, 0);
        this.f15236E = typedArrayObtainStyledAttributes.getBoolean(7, true);
        this.f15237F = typedArrayObtainStyledAttributes.getBoolean(8, false);
        this.f15238G = typedArrayObtainStyledAttributes.getBoolean(23, true);
        this.f15239H = typedArrayObtainStyledAttributes.getBoolean(34, false);
        this.f15258g = typedArrayObtainStyledAttributes.getBoolean(9, true);
        this.f15247S = typedArrayObtainStyledAttributes.getDimensionPixelSize(11, 0);
        this.f15248T = typedArrayObtainStyledAttributes.getDimensionPixelSize(14, 0);
        this.f15249U = typedArrayObtainStyledAttributes.getDimensionPixelSize(12, 0);
        this.f15253b0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(17, -1);
        this.f15240I = typedArrayObtainStyledAttributes.getBoolean(18, false);
        this.f15243L = typedArrayObtainStyledAttributes.getDimensionPixelSize(2, 0);
        this.f15245Q = typedArrayObtainStyledAttributes.getDimensionPixelSize(3, 0);
        this.f15241J = typedArrayObtainStyledAttributes.getColor(0, 0);
        this.f15242K = typedArrayObtainStyledAttributes.getColor(5, 0);
        this.f15254c0 = typedArrayObtainStyledAttributes.getColor(16, 0);
        this.f15255d0 = typedArrayObtainStyledAttributes.getColor(21, 0);
        int resourceId5 = typedArrayObtainStyledAttributes.getResourceId(30, 0);
        int resourceId6 = typedArrayObtainStyledAttributes.getResourceId(41, 0);
        int resourceId7 = typedArrayObtainStyledAttributes.getResourceId(1, 0);
        int[] intArray = resourceId5 != 0 ? resources.getIntArray(resourceId5) : null;
        int[] intArray2 = resourceId2 != 0 ? resources.getIntArray(resourceId6) : null;
        int[] intArray3 = resourceId7 != 0 ? resources.getIntArray(resourceId7) : null;
        if (intArray != null) {
            this.f15264m = new DashPathEffect(new float[]{g.f(intArray[0]), g.f(intArray[1])}, 0.0f);
        }
        if (intArray2 != null) {
            this.f15265n = new DashPathEffect(new float[]{g.f(intArray2[0]), g.f(intArray2[1])}, 0.0f);
        }
        if (intArray3 != null) {
            this.f15246R = new DashPathEffect(new float[]{g.f(intArray3[0]), g.f(intArray3[1])}, 0.0f);
        }
        this.f15244M = typedArrayObtainStyledAttributes.getString(4);
        this.f15250V = typedArrayObtainStyledAttributes.getBoolean(15, true);
        this.f15251W = typedArrayObtainStyledAttributes.getBoolean(20, false);
        this.f15252a0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(19, 0);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // y2.AbstractC1325f
    public void setData(f fVar) {
        super.setData(fVar);
        if (n()) {
            q();
        }
    }
}
