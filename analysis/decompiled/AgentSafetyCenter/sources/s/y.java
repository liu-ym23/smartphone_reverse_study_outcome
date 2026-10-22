package s;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public interface y extends h {
    @Override // s.h
    default j1 a(n6.a aVar) {
        return new p5.i(this);
    }

    float b(long j10, float f5, float f10, float f11);

    long c(float f5, float f10, float f11);

    default float d(float f5, float f10, float f11) {
        return b(c(f5, f10, f11), f5, f10, f11);
    }

    float e(long j10, float f5, float f10, float f11);
}
