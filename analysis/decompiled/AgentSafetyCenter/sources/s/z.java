package s;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class z implements y {

    /* renamed from: a, reason: collision with root package name */
    public final float f11169a;

    /* renamed from: b, reason: collision with root package name */
    public final n0 f11170b;

    public z(float f5, float f10) {
        this.f11169a = f10;
        n0 n0Var = new n0();
        n0Var.f11057a = 1.0f;
        double dSqrt = Math.sqrt(50.0d);
        n0Var.f11058b = dSqrt;
        n0Var.f11059c = false;
        if (((float) (dSqrt * dSqrt)) <= 0.0f) {
            g5.f.s("Spring stiffness constant must be positive.");
            throw null;
        }
        n0Var.f11058b = Math.sqrt(f5);
        n0Var.f11059c = false;
        this.f11170b = n0Var;
    }

    @Override // s.y
    public final float b(long j10, float f5, float f10, float f11) {
        n0 n0Var = this.f11170b;
        n0Var.f11057a = f10;
        return Float.intBitsToFloat((int) (n0Var.a(f5, f11, j10 / 1000000) & 4294967295L));
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x0165  */
    @Override // s.y
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long c(float r28, float r29, float r30) {
        /*
            Method dump skipped, instructions count: 652
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: s.z.c(float, float, float):long");
    }

    @Override // s.y
    public final float d(float f5, float f10, float f11) {
        return 0.0f;
    }

    @Override // s.y
    public final float e(long j10, float f5, float f10, float f11) {
        n0 n0Var = this.f11170b;
        n0Var.f11057a = f10;
        return Float.intBitsToFloat((int) (n0Var.a(f5, f11, j10 / 1000000) >> 32));
    }
}
