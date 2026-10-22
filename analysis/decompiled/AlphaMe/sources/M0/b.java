package M0;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import com.airbnb.lottie.AbstractC0398c;
import com.airbnb.lottie.D;
import com.airbnb.lottie.v;
import com.stepos.alphame.utils.Property;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import q.C0818b;

/* loaded from: classes.dex */
public abstract class b implements G0.e, H0.a, J0.f {

    /* renamed from: a, reason: collision with root package name */
    public final Path f1362a = new Path();

    /* renamed from: b, reason: collision with root package name */
    public final Matrix f1363b = new Matrix();

    /* renamed from: c, reason: collision with root package name */
    public final Paint f1364c = new Paint(1);

    /* renamed from: d, reason: collision with root package name */
    public final Paint f1365d;

    /* renamed from: e, reason: collision with root package name */
    public final Paint f1366e;

    /* renamed from: f, reason: collision with root package name */
    public final Paint f1367f;

    /* renamed from: g, reason: collision with root package name */
    public final Paint f1368g;

    /* renamed from: h, reason: collision with root package name */
    public final RectF f1369h;

    /* renamed from: i, reason: collision with root package name */
    public final RectF f1370i;

    /* renamed from: j, reason: collision with root package name */
    public final RectF f1371j;

    /* renamed from: k, reason: collision with root package name */
    public final RectF f1372k;

    /* renamed from: l, reason: collision with root package name */
    public final Matrix f1373l;

    /* renamed from: m, reason: collision with root package name */
    public final v f1374m;

    /* renamed from: n, reason: collision with root package name */
    public final e f1375n;

    /* renamed from: o, reason: collision with root package name */
    public final android.support.v4.media.session.c f1376o;

    /* renamed from: p, reason: collision with root package name */
    public b f1377p;

    /* renamed from: q, reason: collision with root package name */
    public b f1378q;

    /* renamed from: r, reason: collision with root package name */
    public List f1379r;

    /* renamed from: s, reason: collision with root package name */
    public final ArrayList f1380s;

    /* renamed from: t, reason: collision with root package name */
    public final o2.d f1381t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f1382u;

    public b(v vVar, e eVar) {
        Paint paint = new Paint(1);
        this.f1365d = paint;
        Paint paint2 = new Paint(1);
        this.f1366e = paint2;
        Paint paint3 = new Paint(1);
        this.f1367f = paint3;
        Paint paint4 = new Paint();
        this.f1368g = paint4;
        this.f1369h = new RectF();
        this.f1370i = new RectF();
        this.f1371j = new RectF();
        this.f1372k = new RectF();
        this.f1373l = new Matrix();
        this.f1380s = new ArrayList();
        this.f1382u = true;
        this.f1374m = vVar;
        this.f1375n = eVar;
        B0.g.r(new StringBuilder(), eVar.f1395c, "#draw");
        paint4.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        PorterDuff.Mode mode = PorterDuff.Mode.DST_IN;
        paint.setXfermode(new PorterDuffXfermode(mode));
        PorterDuff.Mode mode2 = PorterDuff.Mode.DST_OUT;
        paint2.setXfermode(new PorterDuffXfermode(mode2));
        if (eVar.f1413u == 3) {
            paint3.setXfermode(new PorterDuffXfermode(mode2));
        } else {
            paint3.setXfermode(new PorterDuffXfermode(mode));
        }
        o2.d dVarB = eVar.f1401i.b();
        this.f1381t = dVarB;
        dVarB.g(this);
        List list = eVar.f1400h;
        if (list != null && !list.isEmpty()) {
            android.support.v4.media.session.c cVar = new android.support.v4.media.session.c(list);
            this.f1376o = cVar;
            Iterator it = ((List) cVar.f2364b).iterator();
            while (it.hasNext()) {
                ((H0.b) it.next()).a(this);
            }
            for (H0.b bVar : (List) this.f1376o.f2365c) {
                c(bVar);
                bVar.a(this);
            }
        }
        e eVar2 = this.f1375n;
        if (eVar2.f1412t.isEmpty()) {
            if (true != this.f1382u) {
                this.f1382u = true;
                this.f1374m.invalidateSelf();
                return;
            }
            return;
        }
        H0.c cVar2 = new H0.c(1, eVar2.f1412t);
        cVar2.f688b = true;
        cVar2.a(new a(this, cVar2));
        boolean z4 = ((Float) cVar2.e()).floatValue() == 1.0f;
        if (z4 != this.f1382u) {
            this.f1382u = z4;
            this.f1374m.invalidateSelf();
        }
        c(cVar2);
    }

    @Override // H0.a
    public final void a() {
        this.f1374m.invalidateSelf();
    }

    @Override // G0.c
    public final void b(List list, List list2) {
    }

    public final void c(H0.b bVar) {
        this.f1380s.add(bVar);
    }

    @Override // G0.e
    public final void d(Canvas canvas, Matrix matrix, int i4) {
        HashSet hashSet = AbstractC0398c.f4541a;
        if (!this.f1382u) {
            AbstractC0398c.a();
            return;
        }
        if (this.f1379r == null) {
            if (this.f1378q == null) {
                this.f1379r = Collections.emptyList();
            } else {
                this.f1379r = new ArrayList();
                for (b bVar = this.f1378q; bVar != null; bVar = bVar.f1378q) {
                    this.f1379r.add(bVar);
                }
            }
        }
        HashSet hashSet2 = AbstractC0398c.f4541a;
        Matrix matrix2 = this.f1363b;
        matrix2.reset();
        matrix2.set(matrix);
        for (int size = this.f1379r.size() - 1; size >= 0; size--) {
            matrix2.preConcat(((b) this.f1379r.get(size)).f1381t.i());
        }
        AbstractC0398c.a();
        o2.d dVar = this.f1381t;
        int iIntValue = (int) ((((i4 / 255.0f) * ((Integer) ((H0.b) dVar.f13801f).e()).intValue()) / 100.0f) * 255.0f);
        boolean z4 = false;
        if (!(this.f1377p != null) && !l()) {
            matrix2.preConcat(dVar.i());
            k(canvas, matrix2, iIntValue);
            AbstractC0398c.a();
            AbstractC0398c.a();
            m();
            return;
        }
        RectF rectF = this.f1369h;
        rectF.set(Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE);
        h(rectF, matrix2);
        b bVar2 = this.f1377p;
        if (bVar2 != null && this.f1375n.f1413u != 3) {
            RectF rectF2 = this.f1371j;
            bVar2.h(rectF2, matrix2);
            rectF.set(Math.max(rectF.left, rectF2.left), Math.max(rectF.top, rectF2.top), Math.min(rectF.right, rectF2.right), Math.min(rectF.bottom, rectF2.bottom));
        }
        matrix2.preConcat(dVar.i());
        RectF rectF3 = this.f1370i;
        rectF3.set(Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE);
        int i5 = 2;
        if (l()) {
            android.support.v4.media.session.c cVar = this.f1376o;
            int size2 = ((List) cVar.f2366d).size();
            int i6 = 0;
            while (true) {
                if (i6 >= size2) {
                    rectF.set(Math.max(rectF.left, rectF3.left), Math.max(rectF.top, rectF3.top), Math.min(rectF.right, rectF3.right), Math.min(rectF.bottom, rectF3.bottom));
                    break;
                }
                L0.g gVar = (L0.g) ((List) cVar.f2366d).get(i6);
                Path path = (Path) ((H0.b) ((List) cVar.f2364b).get(i6)).e();
                Path path2 = this.f1362a;
                path2.set(path);
                path2.transform(matrix2);
                int iA = t.h.a(gVar.f1178a);
                if (iA == 1 || iA == i5) {
                    break;
                }
                RectF rectF4 = this.f1372k;
                path2.computeBounds(rectF4, z4);
                if (i6 == 0) {
                    rectF3.set(rectF4);
                } else {
                    rectF3.set(Math.min(rectF3.left, rectF4.left), Math.min(rectF3.top, rectF4.top), Math.max(rectF3.right, rectF4.right), Math.max(rectF3.bottom, rectF4.bottom));
                }
                i6++;
                z4 = false;
                i5 = 2;
            }
        }
        rectF.set(Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE, canvas.getWidth(), canvas.getHeight());
        AbstractC0398c.a();
        canvas.saveLayer(rectF, this.f1364c);
        AbstractC0398c.a();
        j(canvas);
        k(canvas, matrix2, iIntValue);
        AbstractC0398c.a();
        if (l()) {
            i(canvas, matrix2, 1);
            i(canvas, matrix2, 3);
            i(canvas, matrix2, 2);
        }
        if (this.f1377p != null) {
            canvas.saveLayer(rectF, this.f1367f);
            AbstractC0398c.a();
            j(canvas);
            this.f1377p.d(canvas, matrix, iIntValue);
            canvas.restore();
            AbstractC0398c.a();
            AbstractC0398c.a();
        }
        canvas.restore();
        AbstractC0398c.a();
        AbstractC0398c.a();
        m();
    }

    @Override // J0.f
    public void f(Object obj, Q0.b bVar) {
        this.f1381t.h(obj, bVar);
    }

    @Override // J0.f
    public final void g(J0.e eVar, int i4, ArrayList arrayList, J0.e eVar2) {
        e eVar3 = this.f1375n;
        if (eVar.c(i4, eVar3.f1395c)) {
            String str = eVar3.f1395c;
            if (!"__container".equals(str)) {
                eVar2.getClass();
                J0.e eVar4 = new J0.e(eVar2);
                eVar4.f872a.add(str);
                if (eVar.a(i4, str)) {
                    J0.e eVar5 = new J0.e(eVar4);
                    eVar5.f873b = this;
                    arrayList.add(eVar5);
                }
                eVar2 = eVar4;
            }
            if (eVar.d(i4, str)) {
                n(eVar, eVar.b(i4, str) + i4, arrayList, eVar2);
            }
        }
    }

    @Override // G0.c
    public final String getName() {
        return this.f1375n.f1395c;
    }

    @Override // G0.e
    public void h(RectF rectF, Matrix matrix) {
        Matrix matrix2 = this.f1373l;
        matrix2.set(matrix);
        matrix2.preConcat(this.f1381t.i());
    }

    public final void i(Canvas canvas, Matrix matrix, int i4) {
        Paint paint = t.h.a(i4) != 1 ? this.f1365d : this.f1366e;
        android.support.v4.media.session.c cVar = this.f1376o;
        int size = ((List) cVar.f2366d).size();
        for (int i5 = 0; i5 < size; i5++) {
            if (((L0.g) ((List) cVar.f2366d).get(i5)).f1178a == i4) {
                HashSet hashSet = AbstractC0398c.f4541a;
                canvas.saveLayer(this.f1369h, paint);
                AbstractC0398c.a();
                j(canvas);
                for (int i6 = 0; i6 < size; i6++) {
                    if (((L0.g) ((List) cVar.f2366d).get(i6)).f1178a == i4) {
                        Path path = (Path) ((H0.b) ((List) cVar.f2364b).get(i6)).e();
                        Path path2 = this.f1362a;
                        path2.set(path);
                        path2.transform(matrix);
                        H0.b bVar = (H0.b) ((List) cVar.f2365c).get(i6);
                        Paint paint2 = this.f1364c;
                        int alpha = paint2.getAlpha();
                        paint2.setAlpha((int) (((Integer) bVar.e()).intValue() * 2.55f));
                        canvas.drawPath(path2, paint2);
                        paint2.setAlpha(alpha);
                    }
                }
                HashSet hashSet2 = AbstractC0398c.f4541a;
                canvas.restore();
                AbstractC0398c.a();
                AbstractC0398c.a();
                return;
            }
        }
    }

    public final void j(Canvas canvas) {
        HashSet hashSet = AbstractC0398c.f4541a;
        RectF rectF = this.f1369h;
        canvas.drawRect(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f, this.f1368g);
        AbstractC0398c.a();
    }

    public abstract void k(Canvas canvas, Matrix matrix, int i4);

    public final boolean l() {
        android.support.v4.media.session.c cVar = this.f1376o;
        return (cVar == null || ((List) cVar.f2364b).isEmpty()) ? false : true;
    }

    public final void m() {
        D performanceTracker = this.f1374m.f4575b.getPerformanceTracker();
        String str = this.f1375n.f1395c;
        if (performanceTracker.f4530a) {
            HashMap map = performanceTracker.f4532c;
            P0.b bVar = (P0.b) map.get(str);
            if (bVar == null) {
                bVar = new P0.b();
                map.put(str, bVar);
            }
            int i4 = bVar.f1557a + 1;
            bVar.f1557a = i4;
            if (i4 == Integer.MAX_VALUE) {
                bVar.f1557a = i4 / 2;
            }
            if (str.equals("__container")) {
                q.g gVar = performanceTracker.f4531b;
                gVar.getClass();
                C0818b c0818b = new C0818b(gVar);
                if (c0818b.hasNext()) {
                    B0.g.y(c0818b.next());
                    throw null;
                }
            }
        }
    }

    public void n(J0.e eVar, int i4, ArrayList arrayList, J0.e eVar2) {
    }

    public void o(float f4) {
        o2.d dVar = this.f1381t;
        ((H0.b) dVar.f13797b).h(f4);
        ((H0.b) dVar.f13798c).h(f4);
        ((H0.b) dVar.f13799d).h(f4);
        ((H0.b) dVar.f13800e).h(f4);
        ((H0.b) dVar.f13801f).h(f4);
        H0.b bVar = (H0.b) dVar.f13802g;
        if (bVar != null) {
            bVar.h(f4);
        }
        H0.b bVar2 = (H0.b) dVar.f13803h;
        if (bVar2 != null) {
            bVar2.h(f4);
        }
        android.support.v4.media.session.c cVar = this.f1376o;
        int i4 = 0;
        if (cVar != null) {
            for (int i5 = 0; i5 < ((List) cVar.f2364b).size(); i5++) {
                ((H0.b) ((List) cVar.f2364b).get(i5)).h(f4);
            }
        }
        float f5 = this.f1375n.f1405m;
        if (f5 != Property.DEFAULT_FLOAT_VALUE) {
            f4 /= f5;
        }
        b bVar3 = this.f1377p;
        if (bVar3 != null) {
            bVar3.o(bVar3.f1375n.f1405m * f4);
        }
        while (true) {
            ArrayList arrayList = this.f1380s;
            if (i4 >= arrayList.size()) {
                return;
            }
            ((H0.b) arrayList.get(i4)).h(f4);
            i4++;
        }
    }
}
