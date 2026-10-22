package ab;

import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;

/* loaded from: classes.dex */
public final class k extends q7.m implements p7.a {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f571g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ q7.m f572h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public k(p7.a aVar, int i2) {
        super(0);
        this.f571g = i2;
        switch (i2) {
            case 1:
                this.f572h = (q7.m) aVar;
                super(0);
                break;
            default:
                this.f572h = (q7.m) aVar;
                break;
        }
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [p7.a, q7.m] */
    /* JADX WARN: Type inference failed for: r1v5, types: [p7.a, q7.m] */
    @Override // p7.a
    public final Object c() {
        switch (this.f571g) {
            case 0:
                try {
                    return (List) this.f572h.c();
                } catch (SSLPeerUnverifiedException unused) {
                    return d7.z.f2978f;
                }
            default:
                return d7.r.q1((Iterable) this.f572h.c());
        }
    }
}
