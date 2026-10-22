package b;

import java.util.UUID;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e extends yb.l implements xb.a {

    /* renamed from: f, reason: collision with root package name */
    public static final e f1692f;

    /* renamed from: g, reason: collision with root package name */
    public static final e f1693g;

    /* renamed from: h, reason: collision with root package name */
    public static final e f1694h;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f1695c;

    static {
        int i = 0;
        f1692f = new e(i, 0);
        f1693g = new e(i, 1);
        f1694h = new e(i, 2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e(int i, int i3) {
        super(i);
        this.f1695c = i3;
    }

    @Override // xb.a
    public final Object invoke() {
        switch (this.f1695c) {
            case 0:
                return UUID.randomUUID().toString();
            case 1:
                return null;
            default:
                return null;
        }
    }
}
