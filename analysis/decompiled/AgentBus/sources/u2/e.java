package u2;

import c7.r;
import h4.n;
import ob.z;
import q7.m;

/* loaded from: classes.dex */
public final class e extends m implements p7.a {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f9969g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ f f9970h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e(f fVar, int i2) {
        super(0);
        this.f9969g = i2;
        this.f9970h = fVar;
    }

    @Override // p7.a
    public final Object c() {
        switch (this.f9969g) {
            case 0:
                t9.h hVar = this.f9970h.f9975c;
                z zVar = (z) hVar.c();
                if (pb.c.a(zVar) != -1) {
                    return n.l(zVar.f8043f.r(), true);
                }
                throw new IllegalStateException(("OkioStorage requires absolute paths, but did not get an absolute path from producePath = " + hVar + ", instead got " + zVar).toString());
            default:
                n nVar = f.f9972f;
                f fVar = this.f9970h;
                synchronized (nVar) {
                    f.f9971e.remove(((z) fVar.f9976d.getValue()).f8043f.r());
                }
                return r.f1986a;
        }
    }
}
