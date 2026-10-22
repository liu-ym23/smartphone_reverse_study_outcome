package s2;

import java.util.UUID;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c extends yb.l implements xb.a {

    /* renamed from: f, reason: collision with root package name */
    public static final c f11339f;

    /* renamed from: g, reason: collision with root package name */
    public static final c f11340g;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f11341c;

    static {
        int i = 0;
        f11339f = new c(i, 0);
        f11340g = new c(i, 1);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c(int i, int i3) {
        super(i);
        this.f11341c = i3;
    }

    @Override // xb.a
    public final Object invoke() {
        switch (this.f11341c) {
            case 0:
                return UUID.randomUUID();
            default:
                return "DEFAULT_TEST_TAG";
        }
    }
}
