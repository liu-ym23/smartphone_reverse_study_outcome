package y4;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.BitSet;
import y4.g;
import y4.m;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public final m[] f14084a = new m[4];

    /* renamed from: b, reason: collision with root package name */
    public final Matrix[] f14085b = new Matrix[4];

    /* renamed from: c, reason: collision with root package name */
    public final Matrix[] f14086c = new Matrix[4];

    /* renamed from: d, reason: collision with root package name */
    public final PointF f14087d = new PointF();

    /* renamed from: e, reason: collision with root package name */
    public final Path f14088e = new Path();

    /* renamed from: f, reason: collision with root package name */
    public final Path f14089f = new Path();

    /* renamed from: g, reason: collision with root package name */
    public final m f14090g = new m();
    public final float[] h = new float[2];

    /* renamed from: i, reason: collision with root package name */
    public final float[] f14091i = new float[2];

    /* renamed from: j, reason: collision with root package name */
    public final Path f14092j = new Path();

    /* renamed from: k, reason: collision with root package name */
    public final Path f14093k = new Path();

    /* renamed from: l, reason: collision with root package name */
    public final boolean f14094l = true;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static final k f14095a = new k();
    }

    public k() {
        for (int i10 = 0; i10 < 4; i10++) {
            this.f14084a[i10] = new m();
            this.f14085b[i10] = new Matrix();
            this.f14086c[i10] = new Matrix();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v1 */
    /* JADX WARN: Type inference failed for: r16v5 */
    public final void a(j jVar, float[] fArr, float f8, RectF rectF, g.b bVar, Path path) {
        Matrix[] matrixArr;
        float[] fArr2;
        int i10;
        m[] mVarArr;
        Matrix[] matrixArr2;
        boolean z;
        float f9;
        boolean z3;
        int i11;
        path.rewind();
        Path path2 = this.f14088e;
        path2.rewind();
        Path path3 = this.f14089f;
        path3.rewind();
        path3.addRect(rectF, Path.Direction.CW);
        int i12 = 0;
        while (true) {
            matrixArr = this.f14086c;
            fArr2 = this.h;
            mVarArr = this.f14084a;
            matrixArr2 = this.f14085b;
            z = 0;
            if (i12 >= 4) {
                break;
            }
            d cVar = fArr == null ? i12 != 1 ? i12 != 2 ? i12 != 3 ? jVar.f14067f : jVar.f14066e : jVar.h : jVar.f14068g : new c(fArr[i12]);
            xb.a aVar = i12 != 1 ? i12 != 2 ? i12 != 3 ? jVar.f14063b : jVar.f14062a : jVar.f14065d : jVar.f14064c;
            m mVar = mVarArr[i12];
            aVar.getClass();
            aVar.d(mVar, f8, cVar.a(rectF));
            int i13 = i12 + 1;
            float f10 = (i13 % 4) * 90;
            matrixArr2[i12].reset();
            PointF pointF = this.f14087d;
            if (i12 == 1) {
                i11 = i12;
                pointF.set(rectF.right, rectF.bottom);
            } else if (i12 == 2) {
                i11 = i12;
                pointF.set(rectF.left, rectF.bottom);
            } else if (i12 != 3) {
                i11 = i12;
                pointF.set(rectF.right, rectF.top);
            } else {
                i11 = i12;
                pointF.set(rectF.left, rectF.top);
            }
            matrixArr2[i11].setTranslate(pointF.x, pointF.y);
            matrixArr2[i11].preRotate(f10);
            m mVar2 = mVarArr[i11];
            fArr2[0] = mVar2.f14097b;
            fArr2[1] = mVar2.f14098c;
            matrixArr2[i11].mapPoints(fArr2);
            matrixArr[i11].reset();
            matrixArr[i11].setTranslate(fArr2[0], fArr2[1]);
            matrixArr[i11].preRotate(f10);
            i12 = i13;
        }
        int i14 = 0;
        for (i10 = 4; i14 < i10; i10 = 4) {
            m mVar3 = mVarArr[i14];
            mVar3.getClass();
            fArr2[z] = 0.0f;
            fArr2[1] = mVar3.f14096a;
            matrixArr2[i14].mapPoints(fArr2);
            if (i14 == 0) {
                path.moveTo(fArr2[z], fArr2[1]);
            } else {
                path.lineTo(fArr2[z], fArr2[1]);
            }
            mVarArr[i14].b(matrixArr2[i14], path);
            if (bVar != null) {
                m mVar4 = mVarArr[i14];
                Matrix matrix = matrixArr2[i14];
                g gVar = g.this;
                f9 = 0.0f;
                BitSet bitSet = gVar.f14026e;
                mVar4.getClass();
                bitSet.set(i14, z);
                m.f[] fVarArr = gVar.f14024c;
                mVar4.a(mVar4.f14100e);
                fVarArr[i14] = new l(new ArrayList(mVar4.f14102g), new Matrix(matrix));
            } else {
                f9 = 0.0f;
            }
            int i15 = i14 + 1;
            int i16 = i15 % 4;
            m mVar5 = mVarArr[i14];
            fArr2[0] = mVar5.f14097b;
            fArr2[1] = mVar5.f14098c;
            matrixArr2[i14].mapPoints(fArr2);
            m mVar6 = mVarArr[i16];
            mVar6.getClass();
            float[] fArr3 = this.f14091i;
            fArr3[0] = f9;
            fArr3[1] = mVar6.f14096a;
            matrixArr2[i16].mapPoints(fArr3);
            Matrix[] matrixArr3 = matrixArr;
            m[] mVarArr2 = mVarArr;
            float fMax = Math.max(((float) Math.hypot(fArr2[0] - fArr3[0], fArr2[1] - fArr3[1])) - 0.001f, f9);
            m mVar7 = mVarArr2[i14];
            fArr2[0] = mVar7.f14097b;
            fArr2[1] = mVar7.f14098c;
            matrixArr2[i14].mapPoints(fArr2);
            if (i14 == 1 || i14 == 3) {
                Math.abs(rectF.centerX() - fArr2[0]);
            } else {
                Math.abs(rectF.centerY() - fArr2[1]);
            }
            m mVar8 = this.f14090g;
            mVar8.d(0.0f, 270.0f, 0.0f);
            (i14 != 1 ? i14 != 2 ? i14 != 3 ? jVar.f14070j : jVar.f14069i : jVar.f14072l : jVar.f14071k).getClass();
            mVar8.c(fMax, 0.0f);
            Path path4 = this.f14092j;
            path4.reset();
            mVar8.b(matrixArr3[i14], path4);
            if (this.f14094l && (b(path4, i14) || b(path4, i16))) {
                path4.op(path4, path3, Path.Op.DIFFERENCE);
                fArr2[0] = 0.0f;
                fArr2[1] = mVar8.f14096a;
                matrixArr3[i14].mapPoints(fArr2);
                path2.moveTo(fArr2[0], fArr2[1]);
                mVar8.b(matrixArr3[i14], path2);
            } else {
                mVar8.b(matrixArr3[i14], path);
            }
            if (bVar != null) {
                Matrix matrix2 = matrixArr3[i14];
                g gVar2 = g.this;
                z3 = false;
                gVar2.f14026e.set(i14 + 4, false);
                m.f[] fVarArr2 = gVar2.f14025d;
                mVar8.a(mVar8.f14100e);
                fVarArr2[i14] = new l(new ArrayList(mVar8.f14102g), new Matrix(matrix2));
            } else {
                z3 = false;
            }
            matrixArr = matrixArr3;
            i14 = i15;
            z = z3;
            mVarArr = mVarArr2;
        }
        path.close();
        path2.close();
        if (path2.isEmpty()) {
            return;
        }
        path.op(path2, Path.Op.UNION);
    }

    public final boolean b(Path path, int i10) {
        Path path2 = this.f14093k;
        path2.reset();
        this.f14084a[i10].b(this.f14085b[i10], path2);
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        path2.computeBounds(rectF, true);
        path.op(path2, Path.Op.INTERSECT);
        path.computeBounds(rectF, true);
        return !rectF.isEmpty() || (rectF.width() > 1.0f && rectF.height() > 1.0f);
    }
}
