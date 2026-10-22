package k0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class a0 implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6860c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ int f6861f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f6862g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f6863h;

    public /* synthetic */ a0(int i) {
        this.f6860c = i;
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f6860c) {
            case 0:
                t1 t1Var = (t1) this.f6862g;
                s0.c cVar = (s0.c) this.f6863h;
                int i = this.f6861f;
                ((Integer) obj2).getClass();
                z.a(t1Var, cVar, (s) obj, z.D(i | 1));
                break;
            case 1:
                t1[] t1VarArr = (t1[]) this.f6862g;
                xb.p pVar = (xb.p) this.f6863h;
                int i3 = this.f6861f;
                ((Integer) obj2).getClass();
                z.b(t1VarArr, pVar, (s) obj, z.D(i3 | 1));
                break;
            case 2:
                s0.c cVar2 = (s0.c) this.f6863h;
                Object obj3 = this.f6862g;
                int i10 = this.f6861f;
                ((Integer) obj2).getClass();
                cVar2.e(obj3, (s) obj, z.D(i10) | 1);
                break;
            case 3:
                String str = (String) this.f6862g;
                String str2 = (String) this.f6863h;
                int i11 = this.f6861f;
                ((Integer) obj2).getClass();
                s8.s.b(str, str2, (s) obj, z.D(i11 | 1));
                break;
            case 4:
                ((Integer) obj2).getClass();
                s8.w0.e(this.f6861f, (String) this.f6862g, (w0.m) this.f6863h, (s) obj, z.D(1));
                break;
            default:
                ((Integer) obj2).getClass();
                s8.l2.d((g9.o1) this.f6862g, this.f6861f, (xb.a) this.f6863h, (s) obj, z.D(1));
                break;
        }
        return jb.v.f6774a;
    }
}
