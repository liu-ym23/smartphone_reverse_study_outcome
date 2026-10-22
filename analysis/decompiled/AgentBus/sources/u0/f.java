package u0;

import android.graphics.Path;
import android.graphics.RectF;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final Path f9903a;

    /* renamed from: b, reason: collision with root package name */
    public RectF f9904b;

    /* renamed from: c, reason: collision with root package name */
    public float[] f9905c;

    public f(Path path) {
        this.f9903a = path;
    }

    public static void a(f fVar, t0.c cVar) {
        Path.Direction direction;
        x[] xVarArr = x.f9928f;
        float f10 = cVar.f9656a;
        float f11 = cVar.f9659d;
        float f12 = cVar.f9658c;
        float f13 = cVar.f9657b;
        if (Float.isNaN(f10) || Float.isNaN(f13) || Float.isNaN(f12) || Float.isNaN(f11)) {
            h.b("Invalid rectangle, make sure no value is NaN");
        }
        if (fVar.f9904b == null) {
            fVar.f9904b = new RectF();
        }
        RectF rectF = fVar.f9904b;
        q7.k.b(rectF);
        rectF.set(f10, f13, f12, f11);
        Path path = fVar.f9903a;
        RectF rectF2 = fVar.f9904b;
        q7.k.b(rectF2);
        int i2 = g.$EnumSwitchMapping$0[0];
        if (i2 == 1) {
            direction = Path.Direction.CCW;
        } else {
            if (i2 != 2) {
                throw new a4.u();
            }
            direction = Path.Direction.CW;
        }
        path.addRect(rectF2, direction);
    }

    public static void b(f fVar, t0.d dVar) {
        Path.Direction direction;
        x[] xVarArr = x.f9928f;
        if (fVar.f9904b == null) {
            fVar.f9904b = new RectF();
        }
        RectF rectF = fVar.f9904b;
        q7.k.b(rectF);
        float f10 = dVar.f9660a;
        long j2 = dVar.f9667h;
        long j4 = dVar.f9666g;
        long j10 = dVar.f9665f;
        long j11 = dVar.f9664e;
        rectF.set(f10, dVar.f9661b, dVar.f9662c, dVar.f9663d);
        if (fVar.f9905c == null) {
            fVar.f9905c = new float[8];
        }
        float[] fArr = fVar.f9905c;
        q7.k.b(fArr);
        fArr[0] = Float.intBitsToFloat((int) (j11 >> 32));
        fArr[1] = Float.intBitsToFloat((int) (j11 & 4294967295L));
        fArr[2] = Float.intBitsToFloat((int) (j10 >> 32));
        fArr[3] = Float.intBitsToFloat((int) (j10 & 4294967295L));
        fArr[4] = Float.intBitsToFloat((int) (j4 >> 32));
        fArr[5] = Float.intBitsToFloat((int) (j4 & 4294967295L));
        fArr[6] = Float.intBitsToFloat((int) (j2 >> 32));
        fArr[7] = Float.intBitsToFloat((int) (j2 & 4294967295L));
        Path path = fVar.f9903a;
        RectF rectF2 = fVar.f9904b;
        q7.k.b(rectF2);
        float[] fArr2 = fVar.f9905c;
        q7.k.b(fArr2);
        int i2 = g.$EnumSwitchMapping$0[0];
        if (i2 == 1) {
            direction = Path.Direction.CCW;
        } else {
            if (i2 != 2) {
                throw new a4.u();
            }
            direction = Path.Direction.CW;
        }
        path.addRoundRect(rectF2, fArr2, direction);
    }

    public final t0.c c() {
        if (this.f9904b == null) {
            this.f9904b = new RectF();
        }
        RectF rectF = this.f9904b;
        q7.k.b(rectF);
        this.f9903a.computeBounds(rectF, true);
        return new t0.c(rectF.left, rectF.top, rectF.right, rectF.bottom);
    }

    public final boolean d(f fVar, f fVar2, int i2) {
        Path.Op op = i2 == 0 ? Path.Op.DIFFERENCE : i2 == 1 ? Path.Op.INTERSECT : i2 == 4 ? Path.Op.REVERSE_DIFFERENCE : i2 == 2 ? Path.Op.UNION : Path.Op.XOR;
        if (!(fVar instanceof f)) {
            throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
        }
        Path path = fVar.f9903a;
        if (fVar2 instanceof f) {
            return this.f9903a.op(path, fVar2.f9903a, op);
        }
        throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
    }

    public final void e() {
        this.f9903a.reset();
    }
}
