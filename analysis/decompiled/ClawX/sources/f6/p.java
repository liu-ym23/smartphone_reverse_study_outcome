package f6;

import a6.i0;
import a6.o0;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public class p extends a6.a implements h5.d {
    public final f5.c d;

    public p(f5.c cVar, f5.h hVar) {
        super(hVar, true);
        this.d = cVar;
    }

    @Override // a6.p1
    public final boolean R() {
        return true;
    }

    @Override // h5.d
    public final h5.d getCallerFrame() {
        f5.c cVar = this.d;
        if (cVar instanceof h5.d) {
            return (h5.d) cVar;
        }
        return null;
    }

    @Override // a6.p1
    public void q(Object obj) throws o0 {
        a.h(b8.h.u(this.d), i0.s(obj));
    }

    @Override // a6.p1
    public void r(Object obj) {
        this.d.resumeWith(i0.s(obj));
    }

    public void i0() {
    }
}
