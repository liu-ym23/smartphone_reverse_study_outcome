package b0;

import java.util.Arrays;
import s1.v0;
import s1.y0;
import y.l0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class u extends yb.l implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f1788c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f1789f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f1790g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Object f1791h;
    public final /* synthetic */ jb.b i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ u(Object obj, Object obj2, jb.b bVar, int i, int i3) {
        super(2);
        this.f1788c = i3;
        this.f1790g = obj;
        this.f1791h = obj2;
        this.i = bVar;
        this.f1789f = i;
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        int i = this.f1788c;
        k0.s sVar = (k0.s) obj;
        ((Number) obj2).intValue();
        switch (i) {
            case 0:
                x xVar = (x) this.f1790g;
                Object[] objArr = (Object[]) this.f1791h;
                xVar.b(Arrays.copyOf(objArr, objArr.length), (xb.l) this.i, sVar, k0.z.D(this.f1789f | 1));
                break;
            case 1:
                v0.b((y0) this.f1790g, (w0.m) this.f1791h, (xb.p) this.i, sVar, k0.z.D(this.f1789f | 1));
                break;
            case 2:
                id.c.b((xb.a) this.f1790g, (s2.k) this.f1791h, (s0.c) this.i, sVar, k0.z.D(this.f1789f | 1));
                break;
            default:
                ((l0) this.f1790g).e(this.f1791h, (s0.c) this.i, sVar, k0.z.D(this.f1789f | 1));
                break;
        }
        return jb.v.f6774a;
    }
}
