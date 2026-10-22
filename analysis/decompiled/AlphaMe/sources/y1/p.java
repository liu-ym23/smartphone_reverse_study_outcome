package y1;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import com.stepos.alphame.utils.Property;
import java.util.ArrayList;
import java.util.BitSet;

/* loaded from: classes.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public final x[] f16285a = new x[4];

    /* renamed from: b, reason: collision with root package name */
    public final Matrix[] f16286b = new Matrix[4];

    /* renamed from: c, reason: collision with root package name */
    public final Matrix[] f16287c = new Matrix[4];

    /* renamed from: d, reason: collision with root package name */
    public final PointF f16288d = new PointF();

    /* renamed from: e, reason: collision with root package name */
    public final Path f16289e = new Path();

    /* renamed from: f, reason: collision with root package name */
    public final Path f16290f = new Path();

    /* renamed from: g, reason: collision with root package name */
    public final x f16291g = new x();

    /* renamed from: h, reason: collision with root package name */
    public final float[] f16292h = new float[2];

    /* renamed from: i, reason: collision with root package name */
    public final float[] f16293i = new float[2];

    /* renamed from: j, reason: collision with root package name */
    public final Path f16294j = new Path();

    /* renamed from: k, reason: collision with root package name */
    public final Path f16295k = new Path();

    /* renamed from: l, reason: collision with root package name */
    public final boolean f16296l = true;

    public p() {
        for (int i4 = 0; i4 < 4; i4++) {
            this.f16285a[i4] = new x();
            this.f16286b[i4] = new Matrix();
            this.f16287c[i4] = new Matrix();
        }
    }

    public static InterfaceC0990d b(int i4, n nVar) {
        return i4 != 1 ? i4 != 2 ? i4 != 3 ? nVar.f16277f : nVar.f16276e : nVar.f16279h : nVar.f16278g;
    }

    public final void a(n nVar, float[] fArr, float f4, RectF rectF, g gVar, Path path) {
        int i4;
        Matrix[] matrixArr;
        float[] fArr2;
        Matrix[] matrixArr2;
        x[] xVarArr;
        int i5;
        p pVar = this;
        path.rewind();
        Path path2 = pVar.f16289e;
        path2.rewind();
        Path path3 = pVar.f16290f;
        path3.rewind();
        path3.addRect(rectF, Path.Direction.CW);
        int i6 = 0;
        while (true) {
            i4 = 4;
            matrixArr = pVar.f16287c;
            fArr2 = pVar.f16292h;
            matrixArr2 = pVar.f16286b;
            xVarArr = pVar.f16285a;
            if (i6 >= 4) {
                break;
            }
            InterfaceC0990d interfaceC0990dB = fArr == null ? b(i6, nVar) : new C0989c(fArr[i6]);
            B0.f fVar = i6 != 1 ? i6 != 2 ? i6 != 3 ? nVar.f16273b : nVar.f16272a : nVar.f16275d : nVar.f16274c;
            x xVar = xVarArr[i6];
            fVar.getClass();
            fVar.A(f4, interfaceC0990dB.a(rectF), xVar);
            int i7 = i6 + 1;
            float f5 = (i7 % 4) * 90;
            matrixArr2[i6].reset();
            PointF pointF = pVar.f16288d;
            if (i6 == 1) {
                i5 = i7;
                pointF.set(rectF.right, rectF.bottom);
            } else if (i6 == 2) {
                i5 = i7;
                pointF.set(rectF.left, rectF.bottom);
            } else if (i6 != 3) {
                i5 = i7;
                pointF.set(rectF.right, rectF.top);
            } else {
                i5 = i7;
                pointF.set(rectF.left, rectF.top);
            }
            matrixArr2[i6].setTranslate(pointF.x, pointF.y);
            matrixArr2[i6].preRotate(f5);
            x xVar2 = xVarArr[i6];
            fArr2[0] = xVar2.f16317c;
            fArr2[1] = xVar2.f16318d;
            matrixArr2[i6].mapPoints(fArr2);
            matrixArr[i6].reset();
            matrixArr[i6].setTranslate(fArr2[0], fArr2[1]);
            matrixArr[i6].preRotate(f5);
            i6 = i5;
        }
        int i8 = 0;
        while (i8 < i4) {
            x xVar3 = xVarArr[i8];
            fArr2[0] = xVar3.f16315a;
            fArr2[1] = xVar3.f16316b;
            matrixArr2[i8].mapPoints(fArr2);
            if (i8 == 0) {
                path.moveTo(fArr2[0], fArr2[1]);
            } else {
                path.lineTo(fArr2[0], fArr2[1]);
            }
            xVarArr[i8].b(matrixArr2[i8], path);
            if (gVar != null) {
                x xVar4 = xVarArr[i8];
                Matrix matrix = matrixArr2[i8];
                j jVar = gVar.f16202a;
                BitSet bitSet = jVar.f16237e;
                xVar4.getClass();
                bitSet.set(i8, false);
                xVar4.a(xVar4.f16320f);
                jVar.f16235c[i8] = new q(new ArrayList(xVar4.f16322h), new Matrix(matrix));
            }
            int i9 = i8 + 1;
            int i10 = i9 % 4;
            x xVar5 = xVarArr[i8];
            fArr2[0] = xVar5.f16317c;
            fArr2[1] = xVar5.f16318d;
            matrixArr2[i8].mapPoints(fArr2);
            x xVar6 = xVarArr[i10];
            float f6 = xVar6.f16315a;
            float[] fArr3 = pVar.f16293i;
            fArr3[0] = f6;
            fArr3[1] = xVar6.f16316b;
            matrixArr2[i10].mapPoints(fArr3);
            float fMax = Math.max(((float) Math.hypot(fArr2[0] - fArr3[0], fArr2[1] - fArr3[1])) - 0.001f, Property.DEFAULT_FLOAT_VALUE);
            x xVar7 = xVarArr[i8];
            fArr2[0] = xVar7.f16317c;
            fArr2[1] = xVar7.f16318d;
            matrixArr2[i8].mapPoints(fArr2);
            if (i8 == 1 || i8 == 3) {
                Math.abs(rectF.centerX() - fArr2[0]);
            } else {
                Math.abs(rectF.centerY() - fArr2[1]);
            }
            x xVar8 = pVar.f16291g;
            xVar8.d(Property.DEFAULT_FLOAT_VALUE, 270.0f, Property.DEFAULT_FLOAT_VALUE);
            (i8 != 1 ? i8 != 2 ? i8 != 3 ? nVar.f16281j : nVar.f16280i : nVar.f16283l : nVar.f16282k).getClass();
            xVar8.c(fMax, Property.DEFAULT_FLOAT_VALUE);
            Path path4 = pVar.f16294j;
            path4.reset();
            xVar8.b(matrixArr[i8], path4);
            if (pVar.f16296l && (pVar.c(path4, i8) || pVar.c(path4, i10))) {
                path4.op(path4, path3, Path.Op.DIFFERENCE);
                fArr2[0] = xVar8.f16315a;
                fArr2[1] = xVar8.f16316b;
                matrixArr[i8].mapPoints(fArr2);
                path2.moveTo(fArr2[0], fArr2[1]);
                xVar8.b(matrixArr[i8], path2);
            } else {
                xVar8.b(matrixArr[i8], path);
            }
            if (gVar != null) {
                Matrix matrix2 = matrixArr[i8];
                j jVar2 = gVar.f16202a;
                jVar2.f16237e.set(i8 + 4, false);
                xVar8.a(xVar8.f16320f);
                jVar2.f16236d[i8] = new q(new ArrayList(xVar8.f16322h), new Matrix(matrix2));
            }
            i4 = 4;
            pVar = this;
            i8 = i9;
        }
        path.close();
        path2.close();
        if (path2.isEmpty()) {
            return;
        }
        path.op(path2, Path.Op.UNION);
    }

    public final boolean c(Path path, int i4) {
        Path path2 = this.f16295k;
        path2.reset();
        this.f16285a[i4].b(this.f16286b[i4], path2);
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        path2.computeBounds(rectF, true);
        path.op(path2, Path.Op.INTERSECT);
        path.computeBounds(rectF, true);
        if (rectF.isEmpty()) {
            return rectF.width() > 1.0f && rectF.height() > 1.0f;
        }
        return true;
    }
}
