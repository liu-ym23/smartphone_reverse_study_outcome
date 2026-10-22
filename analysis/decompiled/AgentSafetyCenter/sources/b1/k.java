package b1;

import jb.v;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class k extends yb.l implements xb.l {

    /* renamed from: f, reason: collision with root package name */
    public static final k f1826f;

    /* renamed from: g, reason: collision with root package name */
    public static final k f1827g;

    /* renamed from: h, reason: collision with root package name */
    public static final k f1828h;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f1829c;

    static {
        int i = 1;
        f1826f = new k(i, 0);
        f1827g = new k(i, 1);
        f1828h = new k(i, 2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ k(int i, int i3) {
        super(i);
        this.f1829c = i3;
    }

    @Override // xb.l
    public final Object invoke(Object obj) {
        switch (this.f1829c) {
            case 0:
                return v.f6774a;
            case 1:
                return v.f6774a;
            default:
                return Boolean.valueOf(((q) obj).F0(7));
        }
    }
}
