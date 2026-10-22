package y2;

import A2.AbstractC0264c;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/* renamed from: y2.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1325f extends View {

    /* renamed from: a, reason: collision with root package name */
    private AbstractC0264c f23921a;

    /* renamed from: b, reason: collision with root package name */
    private i f23922b;

    /* renamed from: c, reason: collision with root package name */
    private h f23923c;

    /* renamed from: d, reason: collision with root package name */
    private InterfaceC1324e f23924d;

    /* renamed from: e, reason: collision with root package name */
    private InterfaceC1323d f23925e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f23926f;

    public AbstractC1325f(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    protected abstract z2.e a(z2.f fVar);

    public abstract AbstractC0264c b(AbstractC1325f abstractC1325f);

    public abstract h c(AbstractC1325f abstractC1325f);

    protected abstract InterfaceC1323d d();

    public abstract i e(AbstractC1325f abstractC1325f);

    protected void f(Context context, z2.f fVar) {
        if (getChartDataSetFactory() == null) {
            setChartDataSetFactory(d());
        }
        InterfaceC1324e chartLayerFactory = getChartLayerFactory();
        if (chartLayerFactory != null) {
            this.f23921a = chartLayerFactory.a(this);
            this.f23922b = chartLayerFactory.b(this);
            this.f23923c = chartLayerFactory.c(this);
        } else {
            this.f23921a = b(this);
            this.f23922b = e(this);
            this.f23923c = c(this);
        }
        setChartDataAdapter(a(fVar));
        this.f23923c.a(fVar);
        i iVar = this.f23922b;
        if (iVar != null) {
            iVar.a(fVar);
        }
        this.f23926f = true;
    }

    protected void g(Context context, Object... objArr) {
        if (getChartDataSetFactory() == null) {
            setChartDataSetFactory(d());
        }
        InterfaceC1324e chartLayerFactory = getChartLayerFactory();
        if (chartLayerFactory != null) {
            this.f23921a = chartLayerFactory.a(this);
            this.f23922b = chartLayerFactory.b(this);
            this.f23923c = chartLayerFactory.c(this);
        } else {
            this.f23921a = b(this);
            this.f23922b = e(this);
            this.f23923c = c(this);
        }
        z2.f fVarA = getChartDataSetFactory().a(objArr);
        setChartDataAdapter(a(fVarA));
        this.f23923c.a(fVarA);
        i iVar = this.f23922b;
        if (iVar != null) {
            iVar.a(fVarA);
        }
        this.f23926f = true;
    }

    public AbstractC0264c getBackgroundLayer() {
        return this.f23921a;
    }

    public InterfaceC1323d getChartDataSetFactory() {
        return this.f23925e;
    }

    public InterfaceC1324e getChartLayerFactory() {
        return this.f23924d;
    }

    public z2.e getDataAdapter() {
        return this.f23923c.h();
    }

    public h getDataLayer() {
        return this.f23923c;
    }

    public i getForegroundLayer() {
        return this.f23922b;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        AbstractC0264c abstractC0264c = this.f23921a;
        if (abstractC0264c != null && abstractC0264c.e()) {
            this.f23921a.c(canvas);
        }
        h hVar = this.f23923c;
        if (hVar != null && hVar.e()) {
            this.f23923c.c(canvas);
        }
        i iVar = this.f23922b;
        if (iVar == null || !iVar.e()) {
            return;
        }
        this.f23922b.c(canvas);
    }

    @Override // android.view.View
    protected void onLayout(boolean z5, int i5, int i6, int i7, int i8) {
        super.onLayout(z5, i5, i6, i7, i8);
        int i9 = i7 - i5;
        int i10 = i8 - i6;
        AbstractC0264c abstractC0264c = this.f23921a;
        if (abstractC0264c != null && abstractC0264c.e()) {
            this.f23921a.l(this, z5, 0, 0, i9, i10);
        }
        h hVar = this.f23923c;
        if (hVar != null && hVar.e()) {
            Rect rectM = this.f23921a.m();
            this.f23923c.l(this, z5, rectM.left, rectM.top, rectM.right, rectM.bottom);
        }
        i iVar = this.f23922b;
        if (iVar == null || !iVar.e()) {
            return;
        }
        this.f23922b.l(this, z5, 0, 0, i9, i10);
    }

    @Override // android.view.View
    protected void onMeasure(int i5, int i6) {
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        super.onMeasure(i5, i6);
        int size = View.MeasureSpec.getSize(i5);
        int size2 = View.MeasureSpec.getSize(i6);
        int mode = View.MeasureSpec.getMode(i5);
        int mode2 = View.MeasureSpec.getMode(i6);
        int[] iArrJ = null;
        int i16 = 0;
        if (mode == 0 || mode2 == 0) {
            h hVar = this.f23923c;
            int[] iArrJ2 = (hVar == null || !hVar.e()) ? null : this.f23923c.j(this, i5, i6);
            if (iArrJ2 == null || iArrJ2.length != 2) {
                i7 = 0;
                i8 = 0;
            } else {
                i8 = iArrJ2[0];
                i7 = iArrJ2[1];
            }
            AbstractC0264c abstractC0264c = this.f23921a;
            int[] iArrJ3 = (abstractC0264c == null || !abstractC0264c.e()) ? null : this.f23921a.j(this, View.MeasureSpec.makeMeasureSpec(i8, mode), View.MeasureSpec.makeMeasureSpec(i7, mode2));
            if (iArrJ3 == null || iArrJ3.length != 2) {
                i9 = 0;
                i10 = 0;
            } else {
                i10 = iArrJ3[0];
                i9 = iArrJ3[1];
            }
            i iVar = this.f23922b;
            if (iVar != null && iVar.e()) {
                iArrJ = this.f23922b.j(this, i5, i6);
            }
            if (iArrJ == null || iArrJ.length != 2) {
                int i17 = i7;
                i11 = i9;
                i12 = i17;
                int i18 = i8;
                i13 = i10;
                i14 = i18;
                i15 = 0;
            } else {
                i16 = iArrJ[0];
                i15 = iArrJ[1];
                int i19 = i7;
                i11 = i9;
                i12 = i19;
                int i20 = i8;
                i13 = i10;
                i14 = i20;
            }
        } else {
            AbstractC0264c abstractC0264c2 = this.f23921a;
            int[] iArrJ4 = (abstractC0264c2 == null || !abstractC0264c2.e()) ? null : this.f23921a.j(this, i5, i6);
            if (iArrJ4 == null || iArrJ4.length != 2) {
                i11 = 0;
                i13 = 0;
            } else {
                i13 = iArrJ4[0];
                i11 = iArrJ4[1];
            }
            h hVar2 = this.f23923c;
            int[] iArrJ5 = (hVar2 == null || !hVar2.e()) ? null : this.f23923c.j(this, View.MeasureSpec.makeMeasureSpec(this.f23921a.o(), mode), View.MeasureSpec.makeMeasureSpec(this.f23921a.n(), mode2));
            i iVar2 = this.f23922b;
            if (iVar2 != null && iVar2.e()) {
                iArrJ = this.f23922b.j(this, i5, i6);
            }
            if (iArrJ5 == null || iArrJ5.length != 2) {
                i12 = 0;
                i14 = 0;
            } else {
                i14 = iArrJ5[0];
                i12 = iArrJ5[1];
            }
            if (iArrJ == null || iArrJ.length != 2) {
                i15 = 0;
            } else {
                i16 = iArrJ[0];
                i15 = iArrJ[1];
            }
        }
        setMeasuredDimension(View.resolveSize(size + Math.max(Math.max(i14, i13), i16), i5), View.resolveSize(size2 + Math.max(Math.max(i12, i11), i15), i6));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        i iVar = this.f23922b;
        if (iVar != null && iVar.e() && this.f23922b.d() && this.f23922b.g(motionEvent, this)) {
            return true;
        }
        h hVar = this.f23923c;
        if (hVar != null && hVar.e() && this.f23923c.d() && this.f23923c.g(motionEvent, this)) {
            return true;
        }
        AbstractC0264c abstractC0264c = this.f23921a;
        if (abstractC0264c != null && abstractC0264c.e() && this.f23921a.d() && this.f23921a.g(motionEvent, this)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setChartDataAdapter(z2.e eVar) {
        this.f23923c.k(eVar);
    }

    public void setChartDataSetFactory(InterfaceC1323d interfaceC1323d) {
        this.f23925e = interfaceC1323d;
    }

    public final void setChartLayerFactory(InterfaceC1324e interfaceC1324e) {
        this.f23924d = interfaceC1324e;
    }

    public void setData(Object... objArr) {
        if (!this.f23926f) {
            g(getContext(), objArr);
            requestLayout();
            return;
        }
        z2.f fVarA = getChartDataSetFactory().a(objArr);
        this.f23923c.a(fVarA);
        i iVar = this.f23922b;
        if (iVar != null) {
            iVar.a(fVarA);
        }
        invalidate();
    }

    public AbstractC1325f(Context context, AttributeSet attributeSet, int i5) {
        this(context, attributeSet, i5, 0);
    }

    public AbstractC1325f(Context context, AttributeSet attributeSet, int i5, int i6) {
        super(context, attributeSet, i5, i6);
        this.f23926f = false;
    }

    public void setData(z2.f fVar) {
        if (!this.f23926f) {
            f(getContext(), fVar);
            requestLayout();
            return;
        }
        this.f23923c.a(fVar);
        i iVar = this.f23922b;
        if (iVar != null) {
            iVar.a(fVar);
        }
        requestLayout();
    }
}
