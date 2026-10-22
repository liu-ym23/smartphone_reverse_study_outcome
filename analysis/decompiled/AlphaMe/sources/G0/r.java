package G0;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import com.airbnb.lottie.v;
import com.airbnb.lottie.z;

/* loaded from: classes.dex */
public final class r extends b {

    /* renamed from: o, reason: collision with root package name */
    public final M0.b f575o;

    /* renamed from: p, reason: collision with root package name */
    public final String f576p;

    /* renamed from: q, reason: collision with root package name */
    public final H0.b f577q;

    /* renamed from: r, reason: collision with root package name */
    public H0.j f578r;

    /* JADX WARN: Illegal instructions before constructor call */
    public r(v vVar, M0.b bVar, L0.o oVar) {
        int iA = t.h.a(oVar.f1209g);
        Paint.Cap cap = iA != 0 ? iA != 1 ? Paint.Cap.SQUARE : Paint.Cap.ROUND : Paint.Cap.BUTT;
        int iA2 = t.h.a(oVar.f1210h);
        super(vVar, bVar, cap, iA2 != 0 ? iA2 != 1 ? iA2 != 2 ? null : Paint.Join.BEVEL : Paint.Join.ROUND : Paint.Join.MITER, oVar.f1211i, oVar.f1207e, oVar.f1208f, oVar.f1205c, oVar.f1204b);
        this.f575o = bVar;
        this.f576p = oVar.f1203a;
        H0.b bVarC = oVar.f1206d.c();
        this.f577q = bVarC;
        bVarC.a(this);
        bVar.c(bVarC);
    }

    @Override // G0.b, G0.e
    public final void d(Canvas canvas, Matrix matrix, int i4) {
        Paint paint = this.f477i;
        paint.setColor(((Integer) this.f577q.e()).intValue());
        H0.j jVar = this.f578r;
        if (jVar != null) {
            paint.setColorFilter((ColorFilter) jVar.e());
        }
        super.d(canvas, matrix, i4);
    }

    @Override // G0.b, J0.f
    public final void f(Object obj, Q0.b bVar) {
        super.f(obj, bVar);
        PointF pointF = z.f4588a;
        H0.b bVar2 = this.f577q;
        if (obj == 2) {
            bVar2.i(bVar);
            return;
        }
        if (obj == z.f4607t) {
            if (bVar == null) {
                this.f578r = null;
                return;
            }
            H0.j jVar = new H0.j(bVar);
            this.f578r = jVar;
            jVar.a(this);
            this.f575o.c(bVar2);
        }
    }

    @Override // G0.c
    public final String getName() {
        return this.f576p;
    }
}
