package s1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class i0 implements a1, j {

    /* renamed from: f, reason: collision with root package name */
    public static final i0 f11258f = new i0(0);

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f11259c;

    public /* synthetic */ i0(int i) {
        this.f11259c = i;
    }

    @Override // s1.j
    public long a(long j10, long j11) {
        switch (this.f11259c) {
            case 1:
                float fMax = Math.max(Float.intBitsToFloat((int) (j11 >> 32)) / Float.intBitsToFloat((int) (j10 >> 32)), Float.intBitsToFloat((int) (j11 & 4294967295L)) / Float.intBitsToFloat((int) (j10 & 4294967295L)));
                long jFloatToRawIntBits = (Float.floatToRawIntBits(fMax) << 32) | (Float.floatToRawIntBits(fMax) & 4294967295L);
                int i = t0.f11298a;
                return jFloatToRawIntBits;
            case 2:
                float fD = v0.d(j10, j11);
                long jFloatToRawIntBits2 = (Float.floatToRawIntBits(fD) << 32) | (Float.floatToRawIntBits(fD) & 4294967295L);
                int i3 = t0.f11298a;
                return jFloatToRawIntBits2;
            default:
                if (Float.intBitsToFloat((int) (j10 >> 32)) <= Float.intBitsToFloat((int) (j11 >> 32)) && Float.intBitsToFloat((int) (j10 & 4294967295L)) <= Float.intBitsToFloat((int) (j11 & 4294967295L))) {
                    long jFloatToRawIntBits3 = (Float.floatToRawIntBits(1.0f) << 32) | (Float.floatToRawIntBits(1.0f) & 4294967295L);
                    int i10 = t0.f11298a;
                    return jFloatToRawIntBits3;
                }
                float fD2 = v0.d(j10, j11);
                long jFloatToRawIntBits4 = (Float.floatToRawIntBits(fD2) << 32) | (Float.floatToRawIntBits(fD2) & 4294967295L);
                int i11 = t0.f11298a;
                return jFloatToRawIntBits4;
        }
    }

    @Override // s1.a1
    public boolean b(Object obj, Object obj2) {
        return false;
    }

    @Override // s1.a1
    public void c(p.r0 r0Var) {
        r0Var.clear();
    }

    public String toString() {
        switch (this.f11259c) {
            case 4:
                return "ReusedSlotId";
            default:
                return super.toString();
        }
    }
}
