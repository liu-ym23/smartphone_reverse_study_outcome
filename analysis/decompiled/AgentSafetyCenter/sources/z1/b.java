package z1;

import jb.v;
import yb.l;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b extends l implements xb.l {

    /* renamed from: f, reason: collision with root package name */
    public static final b f16152f;

    /* renamed from: g, reason: collision with root package name */
    public static final b f16153g;

    /* renamed from: h, reason: collision with root package name */
    public static final b f16154h;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f16155c;

    static {
        int i = 1;
        f16152f = new b(i, 0);
        f16153g = new b(i, 1);
        f16154h = new b(i, 2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(int i, int i3) {
        super(i);
        this.f16155c = i3;
    }

    @Override // xb.l
    public final Object invoke(Object obj) {
        switch (this.f16155c) {
            case 0:
                ((Number) obj).longValue();
                return v.f6774a;
            case 1:
                return Integer.valueOf(((j) obj).f16174b);
            default:
                o2.j jVar = ((j) obj).f16175c;
                return Integer.valueOf(jVar.f9121d - jVar.f9119b);
        }
    }
}
