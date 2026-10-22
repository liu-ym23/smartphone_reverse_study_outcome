package e3;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.BitSet;

/* loaded from: classes3.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    public final z[] f4372a = new z[4];
    public final Matrix[] b = new Matrix[4];
    public final Matrix[] c = new Matrix[4];
    public final PointF d = new PointF();
    public final Path e = new Path();
    public final Path f = new Path();
    public final z g = new z();
    public final float[] h = new float[2];
    public final float[] i = new float[2];

    /* renamed from: j, reason: collision with root package name */
    public final Path f4373j = new Path();
    public final Path k = new Path();
    public final boolean l = true;

    public r() {
        for (int i = 0; i < 4; i++) {
            this.f4372a[i] = new z();
            this.b[i] = new Matrix();
            this.c[i] = new Matrix();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v1 */
    /* JADX WARN: Type inference failed for: r16v5 */
    public final void a(p pVar, float[] fArr, float f, RectF rectF, h2.d dVar, Path path) {
        Matrix[] matrixArr;
        float[] fArr2;
        int i;
        z[] zVarArr;
        boolean z10;
        Matrix[] matrixArr2;
        boolean z11;
        int i6;
        path.rewind();
        Path path2 = this.e;
        path2.rewind();
        Path path3 = this.f;
        path3.rewind();
        path3.addRect(rectF, Path.Direction.CW);
        int i10 = 0;
        while (true) {
            matrixArr = this.c;
            fArr2 = this.h;
            zVarArr = this.f4372a;
            z10 = 0;
            matrixArr2 = this.b;
            if (i10 >= 4) {
                break;
            }
            InterfaceC1415d c1414c = fArr == null ? i10 != 1 ? i10 != 2 ? i10 != 3 ? pVar.f : pVar.e : pVar.h : pVar.g : new C1414c(fArr[i10]);
            com.stepos.statsrpk.d dVar2 = i10 != 1 ? i10 != 2 ? i10 != 3 ? pVar.b : pVar.f4369a : pVar.d : pVar.c;
            z zVar = zVarArr[i10];
            dVar2.getClass();
            dVar2.z(zVar, f, c1414c.a(rectF));
            int i11 = i10 + 1;
            float f7 = (i11 % 4) * 90;
            matrixArr2[i10].reset();
            PointF pointF = this.d;
            if (i10 == 1) {
                i6 = i10;
                pointF.set(rectF.right, rectF.bottom);
            } else if (i10 == 2) {
                i6 = i10;
                pointF.set(rectF.left, rectF.bottom);
            } else if (i10 != 3) {
                i6 = i10;
                pointF.set(rectF.right, rectF.top);
            } else {
                i6 = i10;
                pointF.set(rectF.left, rectF.top);
            }
            matrixArr2[i6].setTranslate(pointF.x, pointF.y);
            matrixArr2[i6].preRotate(f7);
            z zVar2 = zVarArr[i6];
            fArr2[0] = zVar2.c;
            fArr2[1] = zVar2.d;
            matrixArr2[i6].mapPoints(fArr2);
            matrixArr[i6].reset();
            matrixArr[i6].setTranslate(fArr2[0], fArr2[1]);
            matrixArr[i6].preRotate(f7);
            i10 = i11;
        }
        char c = 1;
        int i12 = 0;
        for (i = 4; i12 < i; i = 4) {
            z zVar3 = zVarArr[i12];
            fArr2[z10] = zVar3.f4376a;
            fArr2[c] = zVar3.b;
            matrixArr2[i12].mapPoints(fArr2);
            if (i12 == 0) {
                path.moveTo(fArr2[z10], fArr2[c]);
            } else {
                path.lineTo(fArr2[z10], fArr2[c]);
            }
            zVarArr[i12].b(matrixArr2[i12], path);
            if (dVar != null) {
                z zVar4 = zVarArr[i12];
                Matrix matrix = matrixArr2[i12];
                k kVar = (k) dVar.f4555a;
                BitSet bitSet = kVar.e;
                zVar4.getClass();
                bitSet.set(i12, z10);
                y[] yVarArr = kVar.c;
                zVar4.a(zVar4.f);
                yVarArr[i12] = new s(new ArrayList(zVar4.h), new Matrix(matrix));
            }
            int i13 = i12 + 1;
            int i14 = i13 % 4;
            z zVar5 = zVarArr[i12];
            fArr2[0] = zVar5.c;
            fArr2[1] = zVar5.d;
            matrixArr2[i12].mapPoints(fArr2);
            z zVar6 = zVarArr[i14];
            float f9 = zVar6.f4376a;
            float[] fArr3 = this.i;
            fArr3[0] = f9;
            fArr3[1] = zVar6.b;
            matrixArr2[i14].mapPoints(fArr3);
            z[] zVarArr2 = zVarArr;
            float fMax = Math.max(((float) Math.hypot(fArr2[0] - fArr3[0], fArr2[1] - fArr3[1])) - 0.001f, 0.0f);
            z zVar7 = zVarArr2[i12];
            fArr2[0] = zVar7.c;
            fArr2[1] = zVar7.d;
            matrixArr2[i12].mapPoints(fArr2);
            float fAbs = (i12 == 1 || i12 == 3) ? Math.abs(rectF.centerX() - fArr2[0]) : Math.abs(rectF.centerY() - fArr2[1]);
            z zVar8 = this.g;
            zVar8.d(0.0f, 0.0f, 270.0f, 0.0f);
            C1417f c1417f = i12 != 1 ? i12 != 2 ? i12 != 3 ? pVar.f4370j : pVar.i : pVar.l : pVar.k;
            c1417f.n(fMax, fAbs, f, zVar8);
            Path path4 = this.f4373j;
            path4.reset();
            zVar8.b(matrixArr[i12], path4);
            if (this.l && (c1417f.m() || b(path4, i12) || b(path4, i14))) {
                path4.op(path4, path3, Path.Op.DIFFERENCE);
                fArr2[0] = zVar8.f4376a;
                c = 1;
                fArr2[1] = zVar8.b;
                matrixArr[i12].mapPoints(fArr2);
                path2.moveTo(fArr2[0], fArr2[1]);
                zVar8.b(matrixArr[i12], path2);
            } else {
                c = 1;
                zVar8.b(matrixArr[i12], path);
            }
            if (dVar != null) {
                Matrix matrix2 = matrixArr[i12];
                k kVar2 = (k) dVar.f4555a;
                z11 = false;
                kVar2.e.set(i12 + 4, false);
                y[] yVarArr2 = kVar2.d;
                zVar8.a(zVar8.f);
                yVarArr2[i12] = new s(new ArrayList(zVar8.h), new Matrix(matrix2));
            } else {
                z11 = false;
            }
            i12 = i13;
            z10 = z11;
            zVarArr = zVarArr2;
        }
        path.close();
        path2.close();
        if (path2.isEmpty()) {
            return;
        }
        path.op(path2, Path.Op.UNION);
    }

    public final boolean b(Path path, int i) {
        Path path2 = this.k;
        path2.reset();
        this.f4372a[i].b(this.b[i], path2);
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        path2.computeBounds(rectF, true);
        path.op(path2, Path.Op.INTERSECT);
        path.computeBounds(rectF, true);
        return !rectF.isEmpty() || (rectF.width() > 1.0f && rectF.height() > 1.0f);
    }
}
