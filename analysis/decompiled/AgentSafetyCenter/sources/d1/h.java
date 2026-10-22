package d1;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public Path f2990a;

    /* renamed from: b, reason: collision with root package name */
    public RectF f2991b;

    /* renamed from: c, reason: collision with root package name */
    public float[] f2992c;

    /* renamed from: d, reason: collision with root package name */
    public Matrix f2993d;

    public static void a(h hVar, c1.d dVar) {
        d0[] d0VarArr = d0.f2965c;
        if (hVar.f2991b == null) {
            hVar.f2991b = new RectF();
        }
        RectF rectF = hVar.f2991b;
        rectF.getClass();
        float f5 = dVar.f2171a;
        long j10 = dVar.f2178h;
        long j11 = dVar.f2177g;
        long j12 = dVar.f2176f;
        long j13 = dVar.f2175e;
        rectF.set(f5, dVar.f2172b, dVar.f2173c, dVar.f2174d);
        if (hVar.f2992c == null) {
            hVar.f2992c = new float[8];
        }
        float[] fArr = hVar.f2992c;
        fArr.getClass();
        fArr[0] = Float.intBitsToFloat((int) (j13 >> 32));
        fArr[1] = Float.intBitsToFloat((int) (j13 & 4294967295L));
        fArr[2] = Float.intBitsToFloat((int) (j12 >> 32));
        fArr[3] = Float.intBitsToFloat((int) (j12 & 4294967295L));
        fArr[4] = Float.intBitsToFloat((int) (j11 >> 32));
        fArr[5] = Float.intBitsToFloat((int) (j11 & 4294967295L));
        fArr[6] = Float.intBitsToFloat((int) (j10 >> 32));
        fArr[7] = Float.intBitsToFloat((int) (j10 & 4294967295L));
        Path path = hVar.f2990a;
        RectF rectF2 = hVar.f2991b;
        rectF2.getClass();
        float[] fArr2 = hVar.f2992c;
        fArr2.getClass();
        path.addRoundRect(rectF2, fArr2, Path.Direction.CCW);
    }

    public final c1.c b() {
        if (this.f2991b == null) {
            this.f2991b = new RectF();
        }
        RectF rectF = this.f2991b;
        rectF.getClass();
        this.f2990a.computeBounds(rectF, true);
        return new c1.c(rectF.left, rectF.top, rectF.right, rectF.bottom);
    }

    public final boolean c(h hVar, h hVar2, int i) {
        Path.Op op = i == 0 ? Path.Op.DIFFERENCE : i == 1 ? Path.Op.INTERSECT : i == 4 ? Path.Op.REVERSE_DIFFERENCE : i == 2 ? Path.Op.UNION : Path.Op.XOR;
        Path path = this.f2990a;
        if (!(hVar instanceof h)) {
            g5.f.o("Unable to obtain android.graphics.Path");
            return false;
        }
        Path path2 = hVar.f2990a;
        if (hVar2 instanceof h) {
            return path.op(path2, hVar2.f2990a, op);
        }
        g5.f.o("Unable to obtain android.graphics.Path");
        return false;
    }
}
