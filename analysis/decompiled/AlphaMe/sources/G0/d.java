package G0;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.v;
import com.stepos.alphame.utils.Property;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class d implements e, m, H0.a, J0.f {

    /* renamed from: a, reason: collision with root package name */
    public final Matrix f483a;

    /* renamed from: b, reason: collision with root package name */
    public final Path f484b;

    /* renamed from: c, reason: collision with root package name */
    public final RectF f485c;

    /* renamed from: d, reason: collision with root package name */
    public final String f486d;

    /* renamed from: e, reason: collision with root package name */
    public final List f487e;

    /* renamed from: f, reason: collision with root package name */
    public final v f488f;

    /* renamed from: g, reason: collision with root package name */
    public ArrayList f489g;

    /* renamed from: h, reason: collision with root package name */
    public final o2.d f490h;

    public d(v vVar, M0.b bVar, L0.m mVar) {
        K0.c cVar;
        String str = mVar.f1198a;
        List list = mVar.f1199b;
        ArrayList arrayList = new ArrayList(list.size());
        int i4 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            c cVarA = ((L0.b) list.get(i5)).a(vVar, bVar);
            if (cVarA != null) {
                arrayList.add(cVarA);
            }
        }
        while (true) {
            if (i4 >= list.size()) {
                cVar = null;
                break;
            }
            L0.b bVar2 = (L0.b) list.get(i4);
            if (bVar2 instanceof K0.c) {
                cVar = (K0.c) bVar2;
                break;
            }
            i4++;
        }
        this(vVar, bVar, str, arrayList, cVar);
    }

    @Override // H0.a
    public final void a() {
        this.f488f.invalidateSelf();
    }

    @Override // G0.c
    public final void b(List list, List list2) {
        int size = list.size();
        List list3 = this.f487e;
        ArrayList arrayList = new ArrayList(list3.size() + size);
        arrayList.addAll(list);
        for (int size2 = list3.size() - 1; size2 >= 0; size2--) {
            c cVar = (c) list3.get(size2);
            cVar.b(arrayList, list3.subList(0, size2));
            arrayList.add(cVar);
        }
    }

    public final List c() {
        if (this.f489g == null) {
            this.f489g = new ArrayList();
            int i4 = 0;
            while (true) {
                List list = this.f487e;
                if (i4 >= list.size()) {
                    break;
                }
                c cVar = (c) list.get(i4);
                if (cVar instanceof m) {
                    this.f489g.add((m) cVar);
                }
                i4++;
            }
        }
        return this.f489g;
    }

    @Override // G0.e
    public final void d(Canvas canvas, Matrix matrix, int i4) {
        Matrix matrix2 = this.f483a;
        matrix2.set(matrix);
        o2.d dVar = this.f490h;
        if (dVar != null) {
            matrix2.preConcat(dVar.i());
            i4 = (int) ((((((Integer) ((H0.b) dVar.f13801f).e()).intValue() / 100.0f) * i4) / 255.0f) * 255.0f);
        }
        List list = this.f487e;
        for (int size = list.size() - 1; size >= 0; size--) {
            Object obj = list.get(size);
            if (obj instanceof e) {
                ((e) obj).d(canvas, matrix2, i4);
            }
        }
    }

    @Override // G0.m
    public final Path e() {
        Matrix matrix = this.f483a;
        matrix.reset();
        o2.d dVar = this.f490h;
        if (dVar != null) {
            matrix.set(dVar.i());
        }
        Path path = this.f484b;
        path.reset();
        List list = this.f487e;
        for (int size = list.size() - 1; size >= 0; size--) {
            c cVar = (c) list.get(size);
            if (cVar instanceof m) {
                path.addPath(((m) cVar).e(), matrix);
            }
        }
        return path;
    }

    @Override // J0.f
    public final void f(Object obj, Q0.b bVar) {
        o2.d dVar = this.f490h;
        if (dVar != null) {
            dVar.h(obj, bVar);
        }
    }

    @Override // J0.f
    public final void g(J0.e eVar, int i4, ArrayList arrayList, J0.e eVar2) {
        String str = this.f486d;
        if (!eVar.c(i4, str)) {
            return;
        }
        if (!"__container".equals(str)) {
            eVar2.getClass();
            J0.e eVar3 = new J0.e(eVar2);
            eVar3.f872a.add(str);
            if (eVar.a(i4, str)) {
                J0.e eVar4 = new J0.e(eVar3);
                eVar4.f873b = this;
                arrayList.add(eVar4);
            }
            eVar2 = eVar3;
        }
        if (!eVar.d(i4, str)) {
            return;
        }
        int iB = eVar.b(i4, str) + i4;
        int i5 = 0;
        while (true) {
            List list = this.f487e;
            if (i5 >= list.size()) {
                return;
            }
            c cVar = (c) list.get(i5);
            if (cVar instanceof J0.f) {
                ((J0.f) cVar).g(eVar, iB, arrayList, eVar2);
            }
            i5++;
        }
    }

    @Override // G0.c
    public final String getName() {
        return this.f486d;
    }

    @Override // G0.e
    public final void h(RectF rectF, Matrix matrix) {
        Matrix matrix2 = this.f483a;
        matrix2.set(matrix);
        o2.d dVar = this.f490h;
        if (dVar != null) {
            matrix2.preConcat(dVar.i());
        }
        RectF rectF2 = this.f485c;
        rectF2.set(Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE);
        List list = this.f487e;
        for (int size = list.size() - 1; size >= 0; size--) {
            c cVar = (c) list.get(size);
            if (cVar instanceof e) {
                ((e) cVar).h(rectF2, matrix2);
                if (rectF.isEmpty()) {
                    rectF.set(rectF2);
                } else {
                    rectF.set(Math.min(rectF.left, rectF2.left), Math.min(rectF.top, rectF2.top), Math.max(rectF.right, rectF2.right), Math.max(rectF.bottom, rectF2.bottom));
                }
            }
        }
    }

    public d(v vVar, M0.b bVar, String str, ArrayList arrayList, K0.c cVar) {
        this.f483a = new Matrix();
        this.f484b = new Path();
        this.f485c = new RectF();
        this.f486d = str;
        this.f488f = vVar;
        this.f487e = arrayList;
        if (cVar != null) {
            o2.d dVarB = cVar.b();
            this.f490h = dVarB;
            dVarB.f(bVar);
            dVarB.g(this);
        }
        ArrayList arrayList2 = new ArrayList();
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            c cVar2 = (c) arrayList.get(size);
            if (cVar2 instanceof j) {
                arrayList2.add((j) cVar2);
            }
        }
        for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
            ((j) arrayList2.get(size2)).c(arrayList.listIterator(arrayList.size()));
        }
    }
}
