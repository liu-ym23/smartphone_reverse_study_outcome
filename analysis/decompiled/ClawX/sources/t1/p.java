package t1;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.BitSet;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public final w[] f5520a = new w[4];

    /* renamed from: b, reason: collision with root package name */
    public final Matrix[] f5521b = new Matrix[4];

    /* renamed from: c, reason: collision with root package name */
    public final Matrix[] f5522c = new Matrix[4];
    public final PointF d = new PointF();

    /* renamed from: e, reason: collision with root package name */
    public final Path f5523e = new Path();

    /* renamed from: f, reason: collision with root package name */
    public final Path f5524f = new Path();

    /* renamed from: g, reason: collision with root package name */
    public final w f5525g = new w();

    /* renamed from: h, reason: collision with root package name */
    public final float[] f5526h = new float[2];

    /* renamed from: i, reason: collision with root package name */
    public final float[] f5527i = new float[2];

    /* renamed from: j, reason: collision with root package name */
    public final Path f5528j = new Path();

    /* renamed from: k, reason: collision with root package name */
    public final Path f5529k = new Path();

    /* renamed from: l, reason: collision with root package name */
    public final boolean f5530l = true;

    public p() {
        for (int i8 = 0; i8 < 4; i8++) {
            this.f5520a[i8] = new w();
            this.f5521b[i8] = new Matrix();
            this.f5522c[i8] = new Matrix();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v1 */
    /* JADX WARN: Type inference failed for: r16v5 */
    public final void a(n nVar, float[] fArr, float f3, RectF rectF, g gVar, Path path) {
        Matrix[] matrixArr;
        float[] fArr2;
        int i8;
        w[] wVarArr;
        Matrix[] matrixArr2;
        boolean z;
        float f7;
        boolean z2;
        int i9;
        path.rewind();
        Path path2 = this.f5523e;
        path2.rewind();
        Path path3 = this.f5524f;
        path3.rewind();
        path3.addRect(rectF, Path.Direction.CW);
        int i10 = 0;
        while (true) {
            matrixArr = this.f5522c;
            fArr2 = this.f5526h;
            wVarArr = this.f5520a;
            matrixArr2 = this.f5521b;
            z = 0;
            if (i10 >= 4) {
                break;
            }
            d cVar = fArr == null ? i10 != 1 ? i10 != 2 ? i10 != 3 ? nVar.f5512f : nVar.f5511e : nVar.f5514h : nVar.f5513g : new c(fArr[i10]);
            k4.v vVar = i10 != 1 ? i10 != 2 ? i10 != 3 ? nVar.f5509b : nVar.f5508a : nVar.d : nVar.f5510c;
            w wVar = wVarArr[i10];
            vVar.getClass();
            vVar.E(wVar, f3, cVar.a(rectF));
            int i11 = i10 + 1;
            float f9 = (i11 % 4) * 90;
            matrixArr2[i10].reset();
            PointF pointF = this.d;
            if (i10 == 1) {
                i9 = i10;
                pointF.set(rectF.right, rectF.bottom);
            } else if (i10 == 2) {
                i9 = i10;
                pointF.set(rectF.left, rectF.bottom);
            } else if (i10 != 3) {
                i9 = i10;
                pointF.set(rectF.right, rectF.top);
            } else {
                i9 = i10;
                pointF.set(rectF.left, rectF.top);
            }
            matrixArr2[i9].setTranslate(pointF.x, pointF.y);
            matrixArr2[i9].preRotate(f9);
            w wVar2 = wVarArr[i9];
            fArr2[0] = wVar2.f5544b;
            fArr2[1] = wVar2.f5545c;
            matrixArr2[i9].mapPoints(fArr2);
            matrixArr[i9].reset();
            matrixArr[i9].setTranslate(fArr2[0], fArr2[1]);
            matrixArr[i9].preRotate(f9);
            i10 = i11;
        }
        int i12 = 0;
        for (i8 = 4; i12 < i8; i8 = 4) {
            w wVar3 = wVarArr[i12];
            wVar3.getClass();
            fArr2[z] = 0.0f;
            fArr2[1] = wVar3.f5543a;
            matrixArr2[i12].mapPoints(fArr2);
            if (i12 == 0) {
                path.moveTo(fArr2[z], fArr2[1]);
            } else {
                path.lineTo(fArr2[z], fArr2[1]);
            }
            wVarArr[i12].b(matrixArr2[i12], path);
            if (gVar != null) {
                w wVar4 = wVarArr[i12];
                Matrix matrix = matrixArr2[i12];
                j jVar = gVar.f5456a;
                f7 = 0.0f;
                BitSet bitSet = jVar.f5477e;
                wVar4.getClass();
                bitSet.set(i12, z);
                v[] vVarArr = jVar.f5476c;
                wVar4.a(wVar4.f5546e);
                vVarArr[i12] = new q(new ArrayList(wVar4.f5548g), new Matrix(matrix));
            } else {
                f7 = 0.0f;
            }
            int i13 = i12 + 1;
            int i14 = i13 % 4;
            w wVar5 = wVarArr[i12];
            fArr2[0] = wVar5.f5544b;
            fArr2[1] = wVar5.f5545c;
            matrixArr2[i12].mapPoints(fArr2);
            w wVar6 = wVarArr[i14];
            wVar6.getClass();
            float[] fArr3 = this.f5527i;
            fArr3[0] = f7;
            fArr3[1] = wVar6.f5543a;
            matrixArr2[i14].mapPoints(fArr3);
            Matrix[] matrixArr3 = matrixArr;
            w[] wVarArr2 = wVarArr;
            float fMax = Math.max(((float) Math.hypot(fArr2[0] - fArr3[0], fArr2[1] - fArr3[1])) - 0.001f, f7);
            w wVar7 = wVarArr2[i12];
            fArr2[0] = wVar7.f5544b;
            fArr2[1] = wVar7.f5545c;
            matrixArr2[i12].mapPoints(fArr2);
            if (i12 == 1 || i12 == 3) {
                Math.abs(rectF.centerX() - fArr2[0]);
            } else {
                Math.abs(rectF.centerY() - fArr2[1]);
            }
            w wVar8 = this.f5525g;
            wVar8.d(0.0f, 270.0f, 0.0f);
            (i12 != 1 ? i12 != 2 ? i12 != 3 ? nVar.f5516j : nVar.f5515i : nVar.f5518l : nVar.f5517k).getClass();
            wVar8.c(fMax, 0.0f);
            Path path4 = this.f5528j;
            path4.reset();
            wVar8.b(matrixArr3[i12], path4);
            if (this.f5530l && (b(path4, i12) || b(path4, i14))) {
                path4.op(path4, path3, Path.Op.DIFFERENCE);
                fArr2[0] = 0.0f;
                fArr2[1] = wVar8.f5543a;
                matrixArr3[i12].mapPoints(fArr2);
                path2.moveTo(fArr2[0], fArr2[1]);
                wVar8.b(matrixArr3[i12], path2);
            } else {
                wVar8.b(matrixArr3[i12], path);
            }
            if (gVar != null) {
                Matrix matrix2 = matrixArr3[i12];
                j jVar2 = gVar.f5456a;
                z2 = false;
                jVar2.f5477e.set(i12 + 4, false);
                v[] vVarArr2 = jVar2.d;
                wVar8.a(wVar8.f5546e);
                vVarArr2[i12] = new q(new ArrayList(wVar8.f5548g), new Matrix(matrix2));
            } else {
                z2 = false;
            }
            matrixArr = matrixArr3;
            i12 = i13;
            z = z2;
            wVarArr = wVarArr2;
        }
        path.close();
        path2.close();
        if (path2.isEmpty()) {
            return;
        }
        path.op(path2, Path.Op.UNION);
    }

    public final boolean b(Path path, int i8) {
        Path path2 = this.f5529k;
        path2.reset();
        this.f5520a[i8].b(this.f5521b[i8], path2);
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        path2.computeBounds(rectF, true);
        path.op(path2, Path.Op.INTERSECT);
        path.computeBounds(rectF, true);
        return !rectF.isEmpty() || (rectF.width() > 1.0f && rectF.height() > 1.0f);
    }
}
