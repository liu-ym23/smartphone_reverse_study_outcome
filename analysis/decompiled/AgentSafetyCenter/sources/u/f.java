package u;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f implements d {

    /* renamed from: b, reason: collision with root package name */
    public s.h1 f13452b;

    @Override // u.d
    public final float a(float f5, float f10, float f11) {
        float fAbs = Math.abs((f10 + f5) - f5);
        float f12 = (0.3f * f11) - (0.0f * fAbs);
        float f13 = f11 - f12;
        if ((fAbs <= f11) && f13 < fAbs) {
            f12 = f11 - fAbs;
        }
        return f5 - f12;
    }

    @Override // u.d
    public final s.h b() {
        return this.f13452b;
    }
}
