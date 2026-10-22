package d5;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import java.util.ArrayList;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class m {

    /* renamed from: p, reason: collision with root package name */
    public static final Matrix f3233p = new Matrix();

    /* renamed from: d, reason: collision with root package name */
    public Paint f3237d;

    /* renamed from: e, reason: collision with root package name */
    public Paint f3238e;

    /* renamed from: f, reason: collision with root package name */
    public PathMeasure f3239f;

    /* renamed from: c, reason: collision with root package name */
    public Matrix f3236c = new Matrix();

    /* renamed from: h, reason: collision with root package name */
    public float f3241h = 0.0f;
    public float i = 0.0f;

    /* renamed from: j, reason: collision with root package name */
    public float f3242j = 0.0f;

    /* renamed from: k, reason: collision with root package name */
    public float f3243k = 0.0f;

    /* renamed from: l, reason: collision with root package name */
    public int f3244l = 255;

    /* renamed from: m, reason: collision with root package name */
    public String f3245m = null;

    /* renamed from: n, reason: collision with root package name */
    public Boolean f3246n = null;

    /* renamed from: o, reason: collision with root package name */
    public p.e f3247o = new p.e(0);

    /* renamed from: g, reason: collision with root package name */
    public j f3240g = new j();

    /* renamed from: a, reason: collision with root package name */
    public Path f3234a = new Path();

    /* renamed from: b, reason: collision with root package name */
    public Path f3235b = new Path();

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(j jVar, Matrix matrix, Canvas canvas, int i, int i3) {
        int i10;
        int i11;
        Matrix matrix2 = jVar.f3220a;
        ArrayList arrayList = jVar.f3221b;
        matrix2.set(matrix);
        Matrix matrix3 = jVar.f3220a;
        matrix3.preConcat(jVar.f3228j);
        canvas.save();
        char c9 = 0;
        int i12 = 0;
        while (i12 < arrayList.size()) {
            k kVar = (k) arrayList.get(i12);
            if (kVar instanceof j) {
                a((j) kVar, matrix3, canvas, i, i3);
            } else {
                if (kVar instanceof l) {
                    l lVar = (l) kVar;
                    Path path = this.f3234a;
                    Path path2 = this.f3235b;
                    float f5 = i / this.f3242j;
                    float f10 = i3 / this.f3243k;
                    float fMin = Math.min(f5, f10);
                    Matrix matrix4 = this.f3236c;
                    matrix4.set(matrix3);
                    matrix4.postScale(f5, f10);
                    float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
                    matrix3.mapVectors(fArr);
                    boolean z10 = c9;
                    i10 = i12;
                    float fHypot = (float) Math.hypot(fArr[c9], fArr[1]);
                    float fHypot2 = (float) Math.hypot(fArr[2], fArr[3]);
                    float f11 = (fArr[z10 ? 1 : 0] * fArr[3]) - (fArr[1] * fArr[2]);
                    float fMax = Math.max(fHypot, fHypot2);
                    float fAbs = fMax > 0.0f ? Math.abs(f11) / fMax : 0.0f;
                    if (fAbs != 0.0f) {
                        path.reset();
                        f3.c[] cVarArr = lVar.f3230a;
                        if (cVarArr != null) {
                            f3.c.b(cVarArr, path);
                        }
                        path2.reset();
                        if (lVar instanceof h) {
                            path2.setFillType(lVar.f3232c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                            path2.addPath(path, matrix4);
                            canvas.clipPath(path2);
                        } else {
                            i iVar = (i) lVar;
                            float f12 = iVar.i;
                            if (f12 != 0.0f || iVar.f3215j != 1.0f) {
                                float f13 = iVar.f3216k;
                                float f14 = (f12 + f13) % 1.0f;
                                float f15 = (iVar.f3215j + f13) % 1.0f;
                                if (this.f3239f == null) {
                                    this.f3239f = new PathMeasure();
                                }
                                this.f3239f.setPath(path, z10);
                                float length = this.f3239f.getLength();
                                float f16 = f14 * length;
                                float f17 = f15 * length;
                                path.reset();
                                PathMeasure pathMeasure = this.f3239f;
                                if (f16 > f17) {
                                    pathMeasure.getSegment(f16, length, path, true);
                                    this.f3239f.getSegment(0.0f, f17, path, true);
                                } else {
                                    pathMeasure.getSegment(f16, f17, path, true);
                                }
                                path.rLineTo(0.0f, 0.0f);
                            }
                            path2.addPath(path, matrix4);
                            b2.a aVar = iVar.f3212f;
                            if (((Shader) aVar.f1861c) == null && aVar.f1860b == 0) {
                                i11 = 16777215;
                            } else {
                                if (this.f3238e == null) {
                                    Paint paint = new Paint(1);
                                    this.f3238e = paint;
                                    paint.setStyle(Paint.Style.FILL);
                                }
                                Paint paint2 = this.f3238e;
                                Shader shader = (Shader) aVar.f1861c;
                                if (shader != null) {
                                    shader.setLocalMatrix(matrix4);
                                    paint2.setShader(shader);
                                    paint2.setAlpha(Math.round(iVar.f3214h * 255.0f));
                                    i11 = 16777215;
                                } else {
                                    paint2.setShader(null);
                                    paint2.setAlpha(255);
                                    int i13 = aVar.f1860b;
                                    float f18 = iVar.f3214h;
                                    PorterDuff.Mode mode = p.f3260n;
                                    i11 = 16777215;
                                    paint2.setColor((i13 & 16777215) | (((int) (Color.alpha(i13) * f18)) << 24));
                                }
                                paint2.setColorFilter(null);
                                path2.setFillType(iVar.f3232c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                                canvas.drawPath(path2, paint2);
                            }
                            b2.a aVar2 = iVar.f3210d;
                            if (((Shader) aVar2.f1861c) != null || aVar2.f1860b != 0) {
                                if (this.f3237d == null) {
                                    Paint paint3 = new Paint(1);
                                    this.f3237d = paint3;
                                    paint3.setStyle(Paint.Style.STROKE);
                                }
                                Paint paint4 = this.f3237d;
                                Paint.Join join = iVar.f3218m;
                                if (join != null) {
                                    paint4.setStrokeJoin(join);
                                }
                                Paint.Cap cap = iVar.f3217l;
                                if (cap != null) {
                                    paint4.setStrokeCap(cap);
                                }
                                paint4.setStrokeMiter(iVar.f3219n);
                                Shader shader2 = (Shader) aVar2.f1861c;
                                if (shader2 != null) {
                                    shader2.setLocalMatrix(matrix4);
                                    paint4.setShader(shader2);
                                    paint4.setAlpha(Math.round(iVar.f3213g * 255.0f));
                                } else {
                                    paint4.setShader(null);
                                    paint4.setAlpha(255);
                                    int i14 = aVar2.f1860b;
                                    float f19 = iVar.f3213g;
                                    PorterDuff.Mode mode2 = p.f3260n;
                                    paint4.setColor((i14 & i11) | (((int) (Color.alpha(i14) * f19)) << 24));
                                }
                                paint4.setColorFilter(null);
                                paint4.setStrokeWidth(iVar.f3211e * fMin * fAbs);
                                canvas.drawPath(path2, paint4);
                            }
                        }
                    }
                }
                i12 = i10 + 1;
                c9 = 0;
            }
            i10 = i12;
            i12 = i10 + 1;
            c9 = 0;
        }
        canvas.restore();
    }

    public float getAlpha() {
        return getRootAlpha() / 255.0f;
    }

    public int getRootAlpha() {
        return this.f3244l;
    }

    public void setAlpha(float f5) {
        setRootAlpha((int) (f5 * 255.0f));
    }

    public void setRootAlpha(int i) {
        this.f3244l = i;
    }
}
