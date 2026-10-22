package G0;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.v;
import com.airbnb.lottie.z;
import f1.AbstractC0557a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/* loaded from: classes.dex */
public final class p implements e, m, j, H0.a, k {

    /* renamed from: a, reason: collision with root package name */
    public final Matrix f561a = new Matrix();

    /* renamed from: b, reason: collision with root package name */
    public final Path f562b = new Path();

    /* renamed from: c, reason: collision with root package name */
    public final v f563c;

    /* renamed from: d, reason: collision with root package name */
    public final M0.b f564d;

    /* renamed from: e, reason: collision with root package name */
    public final String f565e;

    /* renamed from: f, reason: collision with root package name */
    public final H0.c f566f;

    /* renamed from: g, reason: collision with root package name */
    public final H0.c f567g;

    /* renamed from: h, reason: collision with root package name */
    public final o2.d f568h;

    /* renamed from: i, reason: collision with root package name */
    public d f569i;

    public p(v vVar, M0.b bVar, L0.j jVar) {
        this.f563c = vVar;
        this.f564d = bVar;
        int i4 = jVar.f1185a;
        this.f565e = jVar.f1186b;
        H0.b bVarC = jVar.f1187c.c();
        this.f566f = (H0.c) bVarC;
        bVar.c(bVarC);
        bVarC.a(this);
        H0.b bVarC2 = ((K0.b) jVar.f1188d).c();
        this.f567g = (H0.c) bVarC2;
        bVar.c(bVarC2);
        bVarC2.a(this);
        o2.d dVarB = ((K0.c) jVar.f1189e).b();
        this.f568h = dVarB;
        dVarB.f(bVar);
        dVarB.g(this);
    }

    @Override // H0.a
    public final void a() {
        this.f563c.invalidateSelf();
    }

    @Override // G0.c
    public final void b(List list, List list2) {
        this.f569i.b(list, list2);
    }

    @Override // G0.j
    public final void c(ListIterator listIterator) {
        if (this.f569i != null) {
            return;
        }
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        ArrayList arrayList = new ArrayList();
        while (listIterator.hasPrevious()) {
            arrayList.add(listIterator.previous());
            listIterator.remove();
        }
        Collections.reverse(arrayList);
        this.f569i = new d(this.f563c, this.f564d, "Repeater", arrayList, null);
    }

    @Override // G0.e
    public final void d(Canvas canvas, Matrix matrix, int i4) {
        float fFloatValue = ((Float) this.f566f.e()).floatValue();
        float fFloatValue2 = ((Float) this.f567g.e()).floatValue();
        o2.d dVar = this.f568h;
        float fFloatValue3 = ((Float) ((H0.b) dVar.f13802g).e()).floatValue() / 100.0f;
        float fFloatValue4 = ((Float) ((H0.b) dVar.f13803h).e()).floatValue() / 100.0f;
        for (int i5 = ((int) fFloatValue) - 1; i5 >= 0; i5--) {
            Matrix matrix2 = this.f561a;
            matrix2.set(matrix);
            float f4 = i5;
            matrix2.preConcat(dVar.j(f4 + fFloatValue2));
            this.f569i.d(canvas, matrix2, (int) (AbstractC0557a.M(fFloatValue3, fFloatValue4, f4 / fFloatValue) * i4));
        }
    }

    @Override // G0.m
    public final Path e() {
        Path pathE = this.f569i.e();
        Path path = this.f562b;
        path.reset();
        float fFloatValue = ((Float) this.f566f.e()).floatValue();
        float fFloatValue2 = ((Float) this.f567g.e()).floatValue();
        for (int i4 = ((int) fFloatValue) - 1; i4 >= 0; i4--) {
            Matrix matrix = this.f561a;
            matrix.set(this.f568h.j(i4 + fFloatValue2));
            path.addPath(pathE, matrix);
        }
        return path;
    }

    @Override // J0.f
    public final void f(Object obj, Q0.b bVar) {
        if (this.f568h.h(obj, bVar)) {
            return;
        }
        if (obj == z.f4596i) {
            this.f566f.i(bVar);
        } else if (obj == z.f4597j) {
            this.f567g.i(bVar);
        }
    }

    @Override // J0.f
    public final void g(J0.e eVar, int i4, ArrayList arrayList, J0.e eVar2) {
        AbstractC0557a.X(eVar, i4, arrayList, eVar2, this);
    }

    @Override // G0.c
    public final String getName() {
        return this.f565e;
    }

    @Override // G0.e
    public final void h(RectF rectF, Matrix matrix) {
        this.f569i.h(rectF, matrix);
    }
}
