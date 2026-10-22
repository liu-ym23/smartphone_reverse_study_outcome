package e9;

import java.io.IOException;
import java.util.ArrayList;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class w implements xb.l, ad.d {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f3731c;

    /* renamed from: f, reason: collision with root package name */
    public Object f3732f;

    /* renamed from: g, reason: collision with root package name */
    public Object f3733g;

    public /* synthetic */ w(int i) {
        this.f3731c = i;
    }

    @Override // ad.d
    public void a(ed.j jVar, IOException iOException) {
        if (jVar.f3812q) {
            return;
        }
        ((kc.g) this.f3733g).resumeWith(id.c.l(iOException));
    }

    @Override // ad.d
    public void e(ad.e0 e0Var) {
        ((kc.g) this.f3733g).resumeWith(e0Var);
    }

    @Override // xb.l
    public final Object invoke(Object obj) {
        long j10;
        switch (this.f3731c) {
            case 0:
                nb.c cVar = null;
                if (!((Boolean) obj).booleanValue()) {
                    throw null;
                }
                kc.w.u((kc.t) this.f3732f, null, null, new f((h) this.f3733g, cVar, 2), 3);
                return jb.v.f6774a;
            case 1:
                try {
                    ((ed.j) this.f3732f).cancel();
                } catch (Throwable unused) {
                }
                return jb.v.f6774a;
            case 2:
                ab.c cVar2 = (ab.c) this.f3732f;
                Object obj2 = cVar2.f383b;
                kc.g gVar = (kc.g) this.f3733g;
                synchronized (obj2) {
                    ((ArrayList) cVar2.f384c).remove(gVar);
                }
                return jb.v.f6774a;
            default:
                u0.k kVar = (u0.k) obj;
                synchronized (u0.m.f13676c) {
                    j10 = u0.m.f13678e;
                    u0.m.f13678e = 1 + j10;
                }
                return new u0.b(j10, kVar, (xb.l) this.f3732f, (xb.l) this.f3733g);
        }
    }
}
