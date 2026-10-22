package n;

/* loaded from: classes.dex */
public interface w extends h {
    @Override // n.h
    default h1 a(q6.b bVar) {
        return new i5.f(this);
    }

    float b(long j2, float f10, float f11, float f12);

    float c(long j2, float f10, float f11, float f12);

    long d(float f10, float f11, float f12);

    default float e(float f10, float f11, float f12) {
        return c(d(f10, f11, f12), f10, f11, f12);
    }
}
