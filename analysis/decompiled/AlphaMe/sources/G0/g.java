package G0;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import com.airbnb.lottie.AbstractC0398c;
import com.airbnb.lottie.v;
import com.airbnb.lottie.z;
import f1.AbstractC0557a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* loaded from: classes.dex */
public final class g implements e, H0.a, k {

    /* renamed from: a, reason: collision with root package name */
    public final Path f499a;

    /* renamed from: b, reason: collision with root package name */
    public final Paint f500b;

    /* renamed from: c, reason: collision with root package name */
    public final M0.b f501c;

    /* renamed from: d, reason: collision with root package name */
    public final String f502d;

    /* renamed from: e, reason: collision with root package name */
    public final ArrayList f503e;

    /* renamed from: f, reason: collision with root package name */
    public final H0.b f504f;

    /* renamed from: g, reason: collision with root package name */
    public final H0.b f505g;

    /* renamed from: h, reason: collision with root package name */
    public H0.j f506h;

    /* renamed from: i, reason: collision with root package name */
    public final v f507i;

    public g(v vVar, M0.b bVar, L0.l lVar) {
        K0.a aVar;
        Path path = new Path();
        this.f499a = path;
        this.f500b = new Paint(1);
        this.f503e = new ArrayList();
        this.f501c = bVar;
        this.f502d = lVar.f1195c;
        this.f507i = vVar;
        K0.a aVar2 = lVar.f1196d;
        if (aVar2 == null || (aVar = lVar.f1197e) == null) {
            this.f504f = null;
            this.f505g = null;
            return;
        }
        path.setFillType(lVar.f1194b);
        H0.b bVarC = aVar2.c();
        this.f504f = bVarC;
        bVarC.a(this);
        bVar.c(bVarC);
        H0.b bVarC2 = aVar.c();
        this.f505g = bVarC2;
        bVarC2.a(this);
        bVar.c(bVarC2);
    }

    @Override // H0.a
    public final void a() {
        this.f507i.invalidateSelf();
    }

    @Override // G0.c
    public final void b(List list, List list2) {
        for (int i4 = 0; i4 < list2.size(); i4++) {
            c cVar = (c) list2.get(i4);
            if (cVar instanceof m) {
                this.f503e.add((m) cVar);
            }
        }
    }

    @Override // G0.e
    public final void d(Canvas canvas, Matrix matrix, int i4) {
        HashSet hashSet = AbstractC0398c.f4541a;
        Paint paint = this.f500b;
        paint.setColor(((Integer) this.f504f.e()).intValue());
        int i5 = 0;
        paint.setAlpha(Math.max(0, Math.min(255, (int) ((((i4 / 255.0f) * ((Integer) this.f505g.e()).intValue()) / 100.0f) * 255.0f))));
        H0.j jVar = this.f506h;
        if (jVar != null) {
            paint.setColorFilter((ColorFilter) jVar.e());
        }
        Path path = this.f499a;
        path.reset();
        while (true) {
            ArrayList arrayList = this.f503e;
            if (i5 >= arrayList.size()) {
                canvas.drawPath(path, paint);
                AbstractC0398c.a();
                return;
            } else {
                path.addPath(((m) arrayList.get(i5)).e(), matrix);
                i5++;
            }
        }
    }

    @Override // J0.f
    public final void f(Object obj, Q0.b bVar) {
        PointF pointF = z.f4588a;
        if (obj == 1) {
            this.f504f.i(bVar);
            return;
        }
        if (obj == 4) {
            this.f505g.i(bVar);
            return;
        }
        if (obj == z.f4607t) {
            if (bVar == null) {
                this.f506h = null;
                return;
            }
            H0.j jVar = new H0.j(bVar);
            this.f506h = jVar;
            jVar.a(this);
            this.f501c.c(this.f506h);
        }
    }

    @Override // J0.f
    public final void g(J0.e eVar, int i4, ArrayList arrayList, J0.e eVar2) {
        AbstractC0557a.X(eVar, i4, arrayList, eVar2, this);
    }

    @Override // G0.c
    public final String getName() {
        return this.f502d;
    }

    @Override // G0.e
    public final void h(RectF rectF, Matrix matrix) {
        Path path = this.f499a;
        path.reset();
        int i4 = 0;
        while (true) {
            ArrayList arrayList = this.f503e;
            if (i4 >= arrayList.size()) {
                path.computeBounds(rectF, false);
                rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
                return;
            } else {
                path.addPath(((m) arrayList.get(i4)).e(), matrix);
                i4++;
            }
        }
    }
}
