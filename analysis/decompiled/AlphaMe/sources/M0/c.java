package M0;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.airbnb.lottie.AbstractC0398c;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.v;
import com.airbnb.lottie.z;
import com.stepos.alphame.utils.Property;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* loaded from: classes.dex */
public final class c extends b {

    /* renamed from: A, reason: collision with root package name */
    public Boolean f1383A;

    /* renamed from: v, reason: collision with root package name */
    public H0.b f1384v;

    /* renamed from: w, reason: collision with root package name */
    public final ArrayList f1385w;

    /* renamed from: x, reason: collision with root package name */
    public final RectF f1386x;

    /* renamed from: y, reason: collision with root package name */
    public final RectF f1387y;

    /* renamed from: z, reason: collision with root package name */
    public Boolean f1388z;

    public c(v vVar, e eVar, List list, LottieComposition lottieComposition) {
        int i4;
        b bVar;
        b cVar;
        super(vVar, eVar);
        this.f1385w = new ArrayList();
        this.f1386x = new RectF();
        this.f1387y = new RectF();
        K0.b bVar2 = eVar.f1411s;
        if (bVar2 != null) {
            H0.b bVarC = bVar2.c();
            this.f1384v = bVarC;
            c(bVarC);
            this.f1384v.a(this);
        } else {
            this.f1384v = null;
        }
        q.i iVar = new q.i(lottieComposition.getLayers().size());
        int size = list.size() - 1;
        b bVar3 = null;
        while (true) {
            if (size < 0) {
                break;
            }
            e eVar2 = (e) list.get(size);
            int iA = t.h.a(eVar2.f1397e);
            if (iA == 0) {
                cVar = new c(vVar, eVar2, lottieComposition.getPrecomps(eVar2.f1399g), lottieComposition);
            } else if (iA == 1) {
                cVar = new h(vVar, eVar2);
            } else if (iA == 2) {
                cVar = new d(vVar, eVar2);
            } else if (iA == 3) {
                cVar = new f(vVar, eVar2);
            } else if (iA == 4) {
                cVar = new g(vVar, eVar2);
            } else if (iA != 5) {
                AbstractC0398c.b("Unknown layer type ".concat(B0.g.C(eVar2.f1397e)));
                cVar = null;
            } else {
                cVar = new j(vVar, eVar2);
            }
            if (cVar != null) {
                iVar.f(cVar.f1375n.f1396d, cVar);
                if (bVar3 != null) {
                    bVar3.f1377p = cVar;
                    bVar3 = null;
                } else {
                    this.f1385w.add(0, cVar);
                    int iA2 = t.h.a(eVar2.f1413u);
                    if (iA2 == 1 || iA2 == 2) {
                        bVar3 = cVar;
                    }
                }
            }
            size--;
        }
        for (i4 = 0; i4 < iVar.g(); i4++) {
            b bVar4 = (b) iVar.d(iVar.e(i4));
            if (bVar4 != null && (bVar = (b) iVar.d(bVar4.f1375n.f1398f)) != null) {
                bVar4.f1378q = bVar;
            }
        }
    }

    @Override // M0.b, J0.f
    public final void f(Object obj, Q0.b bVar) {
        super.f(obj, bVar);
        if (obj == z.f4606s) {
            if (bVar == null) {
                this.f1384v = null;
                return;
            }
            H0.j jVar = new H0.j(bVar);
            this.f1384v = jVar;
            c(jVar);
        }
    }

    @Override // M0.b, G0.e
    public final void h(RectF rectF, Matrix matrix) {
        super.h(rectF, matrix);
        RectF rectF2 = this.f1386x;
        rectF2.set(Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE);
        ArrayList arrayList = this.f1385w;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            ((b) arrayList.get(size)).h(rectF2, this.f1373l);
            if (rectF.isEmpty()) {
                rectF.set(rectF2);
            } else {
                rectF.set(Math.min(rectF.left, rectF2.left), Math.min(rectF.top, rectF2.top), Math.max(rectF.right, rectF2.right), Math.max(rectF.bottom, rectF2.bottom));
            }
        }
    }

    @Override // M0.b
    public final void k(Canvas canvas, Matrix matrix, int i4) {
        HashSet hashSet = AbstractC0398c.f4541a;
        canvas.save();
        RectF rectF = this.f1387y;
        e eVar = this.f1375n;
        rectF.set(Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE, eVar.f1407o, eVar.f1408p);
        matrix.mapRect(rectF);
        ArrayList arrayList = this.f1385w;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (rectF.isEmpty() || canvas.clipRect(rectF)) {
                ((b) arrayList.get(size)).d(canvas, matrix, i4);
            }
        }
        canvas.restore();
        AbstractC0398c.a();
    }

    @Override // M0.b
    public final void n(J0.e eVar, int i4, ArrayList arrayList, J0.e eVar2) {
        int i5 = 0;
        while (true) {
            ArrayList arrayList2 = this.f1385w;
            if (i5 >= arrayList2.size()) {
                return;
            }
            ((b) arrayList2.get(i5)).g(eVar, i4, arrayList, eVar2);
            i5++;
        }
    }

    @Override // M0.b
    public final void o(float f4) {
        super.o(f4);
        if (this.f1384v != null) {
            f4 = ((long) (((Float) this.f1384v.e()).floatValue() * 1000.0f)) / this.f1374m.f4575b.getDuration();
        }
        e eVar = this.f1375n;
        float f5 = eVar.f1405m;
        if (f5 != Property.DEFAULT_FLOAT_VALUE) {
            f4 /= f5;
        }
        float durationFrames = f4 - (eVar.f1406n / eVar.f1394b.getDurationFrames());
        ArrayList arrayList = this.f1385w;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            ((b) arrayList.get(size)).o(durationFrames);
        }
    }

    public final boolean p() {
        if (this.f1383A == null) {
            ArrayList arrayList = this.f1385w;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                b bVar = (b) arrayList.get(size);
                if (bVar instanceof g) {
                    if (bVar.l()) {
                        this.f1383A = Boolean.TRUE;
                        return true;
                    }
                } else if ((bVar instanceof c) && ((c) bVar).p()) {
                    this.f1383A = Boolean.TRUE;
                    return true;
                }
            }
            this.f1383A = Boolean.FALSE;
        }
        return this.f1383A.booleanValue();
    }
}
