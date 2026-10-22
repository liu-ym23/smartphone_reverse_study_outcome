package u;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public interface d {

    /* renamed from: a, reason: collision with root package name */
    public static final c f13437a = c.f13430a;

    default float a(float f5, float f10, float f11) {
        f13437a.getClass();
        float f12 = f10 + f5;
        if ((f5 >= 0.0f && f12 <= f11) || (f5 < 0.0f && f12 > f11)) {
            return 0.0f;
        }
        float f13 = f12 - f11;
        return Math.abs(f5) < Math.abs(f13) ? f5 : f13;
    }

    default s.h b() {
        f13437a.getClass();
        return c.f13431b;
    }
}
