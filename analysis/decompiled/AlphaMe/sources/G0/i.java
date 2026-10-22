package G0;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import com.airbnb.lottie.v;

/* loaded from: classes.dex */
public final class i extends b {

    /* renamed from: o, reason: collision with root package name */
    public final String f525o;

    /* renamed from: p, reason: collision with root package name */
    public final q.i f526p;

    /* renamed from: q, reason: collision with root package name */
    public final q.i f527q;

    /* renamed from: r, reason: collision with root package name */
    public final RectF f528r;

    /* renamed from: s, reason: collision with root package name */
    public final L0.f f529s;

    /* renamed from: t, reason: collision with root package name */
    public final int f530t;

    /* renamed from: u, reason: collision with root package name */
    public final H0.b f531u;

    /* renamed from: v, reason: collision with root package name */
    public final H0.b f532v;

    /* renamed from: w, reason: collision with root package name */
    public final H0.b f533w;

    /* JADX WARN: Illegal instructions before constructor call */
    public i(v vVar, M0.b bVar, L0.e eVar) {
        int iA = t.h.a(eVar.f1170h);
        Paint.Cap cap = iA != 0 ? iA != 1 ? Paint.Cap.SQUARE : Paint.Cap.ROUND : Paint.Cap.BUTT;
        int iA2 = t.h.a(eVar.f1171i);
        super(vVar, bVar, cap, iA2 != 0 ? iA2 != 1 ? iA2 != 2 ? null : Paint.Join.BEVEL : Paint.Join.ROUND : Paint.Join.MITER, eVar.f1172j, eVar.f1166d, eVar.f1169g, eVar.f1173k, eVar.f1174l);
        this.f526p = new q.i();
        this.f527q = new q.i();
        this.f528r = new RectF();
        this.f525o = eVar.f1163a;
        this.f529s = eVar.f1164b;
        this.f530t = (int) (vVar.f4575b.getDuration() / 32.0f);
        H0.b bVarC = eVar.f1165c.c();
        this.f531u = bVarC;
        bVarC.a(this);
        bVar.c(bVarC);
        H0.b bVarC2 = eVar.f1167e.c();
        this.f532v = bVarC2;
        bVarC2.a(this);
        bVar.c(bVarC2);
        H0.b bVarC3 = eVar.f1168f.c();
        this.f533w = bVarC3;
        bVarC3.a(this);
        bVar.c(bVarC3);
    }

    public final int c() {
        float f4 = this.f532v.f690d;
        int i4 = this.f530t;
        int iRound = Math.round(f4 * i4);
        int iRound2 = Math.round(this.f533w.f690d * i4);
        int iRound3 = Math.round(this.f531u.f690d * i4);
        int i5 = iRound != 0 ? 527 * iRound : 17;
        if (iRound2 != 0) {
            i5 = i5 * 31 * iRound2;
        }
        return iRound3 != 0 ? i5 * 31 * iRound3 : i5;
    }

    @Override // G0.b, G0.e
    public final void d(Canvas canvas, Matrix matrix, int i4) {
        RectF rectF = this.f528r;
        h(rectF, matrix);
        L0.f fVar = L0.f.f1175a;
        Paint paint = this.f477i;
        L0.f fVar2 = this.f529s;
        H0.b bVar = this.f531u;
        H0.b bVar2 = this.f533w;
        H0.b bVar3 = this.f532v;
        if (fVar2 == fVar) {
            long jC = c();
            q.i iVar = this.f526p;
            LinearGradient linearGradient = (LinearGradient) iVar.d(jC);
            if (linearGradient == null) {
                PointF pointF = (PointF) bVar3.e();
                PointF pointF2 = (PointF) bVar2.e();
                L0.c cVar = (L0.c) bVar.e();
                int[] iArr = cVar.f1152b;
                LinearGradient linearGradient2 = new LinearGradient((int) ((rectF.width() / 2.0f) + rectF.left + pointF.x), (int) ((rectF.height() / 2.0f) + rectF.top + pointF.y), (int) ((rectF.width() / 2.0f) + rectF.left + pointF2.x), (int) ((rectF.height() / 2.0f) + rectF.top + pointF2.y), iArr, cVar.f1151a, Shader.TileMode.CLAMP);
                iVar.f(jC, linearGradient2);
                linearGradient = linearGradient2;
            }
            paint.setShader(linearGradient);
        } else {
            long jC2 = c();
            q.i iVar2 = this.f527q;
            RadialGradient radialGradient = (RadialGradient) iVar2.d(jC2);
            if (radialGradient == null) {
                PointF pointF3 = (PointF) bVar3.e();
                PointF pointF4 = (PointF) bVar2.e();
                L0.c cVar2 = (L0.c) bVar.e();
                int[] iArr2 = cVar2.f1152b;
                RadialGradient radialGradient2 = new RadialGradient((int) ((rectF.width() / 2.0f) + rectF.left + pointF3.x), (int) ((rectF.height() / 2.0f) + rectF.top + pointF3.y), (float) Math.hypot(((int) (((rectF.width() / 2.0f) + rectF.left) + pointF4.x)) - r12, ((int) (((rectF.height() / 2.0f) + rectF.top) + pointF4.y)) - r5), iArr2, cVar2.f1151a, Shader.TileMode.CLAMP);
                iVar2.f(jC2, radialGradient2);
                radialGradient = radialGradient2;
            }
            paint.setShader(radialGradient);
        }
        super.d(canvas, matrix, i4);
    }

    @Override // G0.c
    public final String getName() {
        return this.f525o;
    }
}
