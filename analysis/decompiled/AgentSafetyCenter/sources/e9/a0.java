package e9;

import s8.l1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class a0 implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f3612c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ int f3613f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f3614g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f3615h;
    public /* synthetic */ Object i;

    public /* synthetic */ a0(int i) {
        this.f3612c = i;
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f3612c) {
            case 0:
                String str = (String) this.f3614g;
                String str2 = (String) this.f3615h;
                xb.a aVar = (xb.a) this.i;
                int i = this.f3613f;
                ((Integer) obj2).getClass();
                b.b(str, str2, aVar, (k0.s) obj, k0.z.D(i | 1));
                break;
            case 1:
                s0.c cVar = (s0.c) this.f3614g;
                Object obj3 = this.f3615h;
                Object obj4 = this.i;
                int i3 = this.f3613f;
                ((Integer) obj2).getClass();
                cVar.d(obj3, obj4, (k0.s) obj, k0.z.D(i3) | 1);
                break;
            case 2:
                String str3 = (String) this.f3614g;
                String str4 = (String) this.f3615h;
                w0.m mVar = (w0.m) this.i;
                int i10 = this.f3613f;
                ((Integer) obj2).getClass();
                l1.a(str3, str4, mVar, (k0.s) obj, k0.z.D(i10 | 1));
                break;
            default:
                t0.e eVar = (t0.e) this.f3614g;
                Object obj5 = this.f3615h;
                s0.c cVar2 = (s0.c) this.i;
                int i11 = this.f3613f;
                ((Integer) obj2).getClass();
                eVar.e(obj5, cVar2, (k0.s) obj, k0.z.D(i11 | 1));
                break;
        }
        return jb.v.f6774a;
    }
}
