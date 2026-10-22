package pc;

import k0.r2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class i extends yb.p implements fc.c, xb.a {

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ int f9965l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ i(int i, int i3, Class cls, Object obj, String str, String str2) {
        super(obj, cls, str, str2, i);
        this.f9965l = i3;
    }

    @Override // yb.c
    public final fc.a a() {
        yb.v.f16099a.getClass();
        return this;
    }

    @Override // xb.a
    public final Object invoke() {
        switch (this.f9965l) {
            case 0:
                return this.f16083f.getClass().getSimpleName();
            default:
                return ((r2) this.f16083f).getValue();
        }
    }
}
