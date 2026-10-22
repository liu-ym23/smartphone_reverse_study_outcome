package ie;

import java.io.IOException;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class s extends od.q {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f6074f = 1;

    /* renamed from: g, reason: collision with root package name */
    public Object f6075g;

    public s(t tVar, od.k kVar) {
        this.f6075g = tVar;
        kVar.getClass();
        this.f9480c = kVar;
    }

    @Override // od.q, od.i0
    public final long l(od.i iVar, long j10) throws Exception {
        switch (this.f6074f) {
            case 0:
                try {
                    return super.l(iVar, j10);
                } catch (IOException e10) {
                    ((t) this.f6075g).f6079h = e10;
                    throw e10;
                }
            default:
                try {
                    return super.l(iVar, j10);
                } catch (Exception e11) {
                    this.f6075g = e11;
                    throw e11;
                }
        }
    }

    public /* synthetic */ s() {
    }
}
