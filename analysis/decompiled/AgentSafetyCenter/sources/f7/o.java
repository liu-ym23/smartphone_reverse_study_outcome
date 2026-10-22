package f7;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.BitSet;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public final v[] f3998a = new v[4];

    /* renamed from: b, reason: collision with root package name */
    public final Matrix[] f3999b = new Matrix[4];

    /* renamed from: c, reason: collision with root package name */
    public final Matrix[] f4000c = new Matrix[4];

    /* renamed from: d, reason: collision with root package name */
    public final PointF f4001d = new PointF();

    /* renamed from: e, reason: collision with root package name */
    public final Path f4002e = new Path();

    /* renamed from: f, reason: collision with root package name */
    public final Path f4003f = new Path();

    /* renamed from: g, reason: collision with root package name */
    public final v f4004g = new v();

    /* renamed from: h, reason: collision with root package name */
    public final float[] f4005h = new float[2];
    public final float[] i = new float[2];

    /* renamed from: j, reason: collision with root package name */
    public final Path f4006j = new Path();

    /* renamed from: k, reason: collision with root package name */
    public final Path f4007k = new Path();

    /* renamed from: l, reason: collision with root package name */
    public final boolean f4008l = true;

    public o() {
        for (int i = 0; i < 4; i++) {
            this.f3998a[i] = new v();
            this.f3999b[i] = new Matrix();
            this.f4000c[i] = new Matrix();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v22, types: [f7.d] */
    /* JADX WARN: Type inference failed for: r13v23, types: [f7.d] */
    /* JADX WARN: Type inference failed for: r13v24, types: [f7.d] */
    /* JADX WARN: Type inference failed for: r13v25, types: [f7.d] */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v1 */
    /* JADX WARN: Type inference failed for: r16v5 */
    public final void a(m mVar, float[] fArr, float f5, RectF rectF, a2.i iVar, Path path) {
        Matrix[] matrixArr;
        float[] fArr2;
        int i;
        v[] vVarArr;
        Matrix[] matrixArr2;
        boolean z10;
        float f10;
        boolean z11;
        c cVar;
        int i3;
        path.rewind();
        Path path2 = this.f4002e;
        path2.rewind();
        Path path3 = this.f4003f;
        path3.rewind();
        path3.addRect(rectF, Path.Direction.CW);
        int i10 = 0;
        while (true) {
            matrixArr = this.f4000c;
            fArr2 = this.f4005h;
            vVarArr = this.f3998a;
            matrixArr2 = this.f3999b;
            z10 = 0;
            if (i10 >= 4) {
                break;
            }
            if (fArr == null) {
                cVar = i10 != 1 ? i10 != 2 ? i10 != 3 ? mVar.f3991f : mVar.f3990e : mVar.f3993h : mVar.f3992g;
            } else {
                float f11 = fArr[i10];
                c cVar2 = new c();
                cVar2.f3932a = f11;
                VarHandle.storeStoreFence();
                cVar = cVar2;
            }
            td.h hVar = i10 != 1 ? i10 != 2 ? i10 != 3 ? mVar.f3987b : mVar.f3986a : mVar.f3989d : mVar.f3988c;
            v vVar = vVarArr[i10];
            hVar.getClass();
            hVar.t(vVar, f5, cVar.a(rectF));
            int i11 = i10 + 1;
            float f12 = (i11 % 4) * 90;
            matrixArr2[i10].reset();
            PointF pointF = this.f4001d;
            if (i10 == 1) {
                i3 = i10;
                pointF.set(rectF.right, rectF.bottom);
            } else if (i10 == 2) {
                i3 = i10;
                pointF.set(rectF.left, rectF.bottom);
            } else if (i10 != 3) {
                i3 = i10;
                pointF.set(rectF.right, rectF.top);
            } else {
                i3 = i10;
                pointF.set(rectF.left, rectF.top);
            }
            matrixArr2[i3].setTranslate(pointF.x, pointF.y);
            matrixArr2[i3].preRotate(f12);
            v vVar2 = vVarArr[i3];
            fArr2[0] = vVar2.f4023b;
            fArr2[1] = vVar2.f4024c;
            matrixArr2[i3].mapPoints(fArr2);
            matrixArr[i3].reset();
            matrixArr[i3].setTranslate(fArr2[0], fArr2[1]);
            matrixArr[i3].preRotate(f12);
            i10 = i11;
        }
        int i12 = 0;
        for (i = 4; i12 < i; i = 4) {
            v vVar3 = vVarArr[i12];
            vVar3.getClass();
            fArr2[z10] = 0.0f;
            fArr2[1] = vVar3.f4022a;
            matrixArr2[i12].mapPoints(fArr2);
            if (i12 == 0) {
                path.moveTo(fArr2[z10], fArr2[1]);
            } else {
                path.lineTo(fArr2[z10], fArr2[1]);
            }
            vVarArr[i12].b(matrixArr2[i12], path);
            if (iVar != null) {
                v vVar4 = vVarArr[i12];
                Matrix matrix = matrixArr2[i12];
                i iVar2 = (i) iVar.f49f;
                f10 = 0.0f;
                BitSet bitSet = iVar2.i;
                vVar4.getClass();
                bitSet.set(i12, z10);
                u[] uVarArr = iVar2.f3955g;
                vVar4.a(vVar4.f4026e);
                uVarArr[i12] = new p(new ArrayList(vVar4.f4028g), new Matrix(matrix));
            } else {
                f10 = 0.0f;
            }
            int i13 = i12 + 1;
            int i14 = i13 % 4;
            v vVar5 = vVarArr[i12];
            fArr2[0] = vVar5.f4023b;
            fArr2[1] = vVar5.f4024c;
            matrixArr2[i12].mapPoints(fArr2);
            v vVar6 = vVarArr[i14];
            vVar6.getClass();
            float[] fArr3 = this.i;
            fArr3[0] = f10;
            fArr3[1] = vVar6.f4022a;
            matrixArr2[i14].mapPoints(fArr3);
            Matrix[] matrixArr3 = matrixArr;
            v[] vVarArr2 = vVarArr;
            float fMax = Math.max(((float) Math.hypot(fArr2[0] - fArr3[0], fArr2[1] - fArr3[1])) - 0.001f, f10);
            v vVar7 = vVarArr2[i12];
            fArr2[0] = vVar7.f4023b;
            fArr2[1] = vVar7.f4024c;
            matrixArr2[i12].mapPoints(fArr2);
            if (i12 == 1 || i12 == 3) {
                Math.abs(rectF.centerX() - fArr2[0]);
            } else {
                Math.abs(rectF.centerY() - fArr2[1]);
            }
            v vVar8 = this.f4004g;
            vVar8.d(0.0f, 270.0f, 0.0f);
            (i12 != 1 ? i12 != 2 ? i12 != 3 ? mVar.f3994j : mVar.i : mVar.f3996l : mVar.f3995k).getClass();
            vVar8.c(fMax, 0.0f);
            Path path4 = this.f4006j;
            path4.reset();
            vVar8.b(matrixArr3[i12], path4);
            if (this.f4008l && (b(path4, i12) || b(path4, i14))) {
                path4.op(path4, path3, Path.Op.DIFFERENCE);
                fArr2[0] = 0.0f;
                fArr2[1] = vVar8.f4022a;
                matrixArr3[i12].mapPoints(fArr2);
                path2.moveTo(fArr2[0], fArr2[1]);
                vVar8.b(matrixArr3[i12], path2);
            } else {
                vVar8.b(matrixArr3[i12], path);
            }
            if (iVar != null) {
                Matrix matrix2 = matrixArr3[i12];
                i iVar3 = (i) iVar.f49f;
                z11 = false;
                iVar3.i.set(i12 + 4, false);
                u[] uVarArr2 = iVar3.f3956h;
                vVar8.a(vVar8.f4026e);
                uVarArr2[i12] = new p(new ArrayList(vVar8.f4028g), new Matrix(matrix2));
            } else {
                z11 = false;
            }
            matrixArr = matrixArr3;
            i12 = i13;
            z10 = z11;
            vVarArr = vVarArr2;
        }
        path.close();
        path2.close();
        if (path2.isEmpty()) {
            return;
        }
        path.op(path2, Path.Op.UNION);
    }

    public final boolean b(Path path, int i) {
        Path path2 = this.f4007k;
        path2.reset();
        this.f3998a[i].b(this.f3999b[i], path2);
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        path2.computeBounds(rectF, true);
        path.op(path2, Path.Op.INTERSECT);
        path.computeBounds(rectF, true);
        return !rectF.isEmpty() || (rectF.width() > 1.0f && rectF.height() > 1.0f);
    }
}
