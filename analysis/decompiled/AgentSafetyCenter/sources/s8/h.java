package s8;

import java.util.Set;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class h implements xb.l {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f11633c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ j3 f11634f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ t f11635g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Set f11636h;

    @Override // xb.l
    public final Object invoke(Object obj) {
        boolean zS;
        switch (this.f11633c) {
            case 0:
                j3 j3Var = this.f11634f;
                t tVar = this.f11635g;
                Set set = this.f11636h;
                p3 p3Var = (p3) obj;
                p3Var.getClass();
                zS = x0.s(p3Var, j3Var, tVar, set);
                break;
            default:
                j3 j3Var2 = this.f11634f;
                t tVar2 = this.f11635g;
                Set set2 = this.f11636h;
                p3 p3Var2 = (p3) obj;
                p3Var2.getClass();
                zS = x0.s(p3Var2, j3Var2, tVar2, set2);
                break;
        }
        return Boolean.valueOf(zS);
    }
}
