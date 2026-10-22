package d;

import b0.p;
import c7.r;
import p7.n;
import w5.e0;
import w5.f0;

/* loaded from: classes.dex */
public final /* synthetic */ class b implements n {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f2730f = 1;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ boolean f2731g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Object f2732h;

    public /* synthetic */ b(f0 f0Var, boolean z4, int i2) {
        this.f2732h = f0Var;
        this.f2731g = z4;
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f2730f) {
            case 0:
                ((Integer) obj2).getClass();
                int iS = b0.b.s(1);
                a.a.a(this.f2731g, (p7.a) this.f2732h, (p) obj, iS);
                break;
            default:
                ((Integer) obj2).getClass();
                int iS2 = b0.b.s(1);
                e0.d((f0) this.f2732h, this.f2731g, (p) obj, iS2);
                break;
        }
        return r.f1986a;
    }

    public /* synthetic */ b(boolean z4, p7.a aVar, int i2) {
        this.f2731g = z4;
        this.f2732h = aVar;
    }
}
