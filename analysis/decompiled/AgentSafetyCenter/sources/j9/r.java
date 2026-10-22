package j9;

import s8.o3;
import s8.p3;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class r implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6709c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ boolean f6710f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f6711g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ boolean f6712h;
    public /* synthetic */ int i;

    /* renamed from: j, reason: collision with root package name */
    public /* synthetic */ Object f6713j;

    public /* synthetic */ r(int i) {
        this.f6709c = i;
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f6709c) {
            case 0:
                boolean z10 = this.f6710f;
                boolean z11 = this.f6712h;
                xb.a aVar = (xb.a) this.f6713j;
                w0.m mVar = (w0.m) this.f6711g;
                int i = this.i;
                ((Integer) obj2).getClass();
                b0.f(z10, z11, aVar, mVar, (k0.s) obj, k0.z.D(i | 1));
                break;
            case 1:
                boolean z12 = this.f6710f;
                xb.l lVar = (xb.l) this.f6713j;
                w0.m mVar2 = (w0.m) this.f6711g;
                boolean z13 = this.f6712h;
                int i3 = this.i;
                ((Integer) obj2).getClass();
                l9.a.e(z12, lVar, mVar2, z13, (k0.s) obj, k0.z.D(i3 | 1));
                break;
            default:
                p3 p3Var = (p3) this.f6713j;
                xb.q qVar = (xb.q) this.f6711g;
                boolean z14 = this.f6710f;
                boolean z15 = this.f6712h;
                int i10 = this.i;
                ((Integer) obj2).getClass();
                o3.d(p3Var, qVar, z14, z15, (k0.s) obj, k0.z.D(i10 | 1));
                break;
        }
        return jb.v.f6774a;
    }
}
