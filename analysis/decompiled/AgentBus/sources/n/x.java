package n;

/* loaded from: classes.dex */
public final class x implements w {

    /* renamed from: a, reason: collision with root package name */
    public final float f6756a;

    /* renamed from: b, reason: collision with root package name */
    public final k0 f6757b;

    public x(float f10, float f11) {
        this.f6756a = f11;
        k0 k0Var = new k0();
        k0Var.f6642a = 1.0f;
        double dSqrt = Math.sqrt(50.0d);
        k0Var.f6643b = dSqrt;
        k0Var.f6644c = false;
        if (((float) (dSqrt * dSqrt)) <= 0.0f) {
            throw new IllegalArgumentException("Spring stiffness constant must be positive.");
        }
        k0Var.f6643b = Math.sqrt(f10);
        k0Var.f6644c = false;
        this.f6757b = k0Var;
    }

    @Override // n.w
    public final float b(long j2, float f10, float f11, float f12) {
        k0 k0Var = this.f6757b;
        k0Var.f6642a = f11;
        return Float.intBitsToFloat((int) (k0Var.a(f10, f12, j2 / 1000000) >> 32));
    }

    @Override // n.w
    public final float c(long j2, float f10, float f11, float f12) {
        k0 k0Var = this.f6757b;
        k0Var.f6642a = f11;
        return Float.intBitsToFloat((int) (k0Var.a(f10, f12, j2 / 1000000) & 4294967295L));
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x015e  */
    @Override // n.w
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long d(float r32, float r33, float r34) {
        /*
            Method dump skipped, instructions count: 665
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: n.x.d(float, float, float):long");
    }

    @Override // n.w
    public final float e(float f10, float f11, float f12) {
        return 0.0f;
    }
}
