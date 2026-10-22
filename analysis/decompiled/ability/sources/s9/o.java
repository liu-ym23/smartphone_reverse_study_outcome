package s9;

import m9.AbstractC1683A;
import m9.AbstractC1708a;

/* loaded from: classes4.dex */
public class o extends AbstractC1708a implements J7.b {
    public final H7.c d;

    public o(H7.h hVar, H7.c cVar) {
        super(hVar, true);
        this.d = cVar;
    }

    @Override // kotlinx.coroutines.c
    public final boolean T() {
        return true;
    }

    @Override // J7.b
    public final J7.b getCallerFrame() {
        H7.c cVar = this.d;
        if (cVar instanceof J7.b) {
            return (J7.b) cVar;
        }
        return null;
    }

    @Override // kotlinx.coroutines.c
    public void x(Object obj) {
        AbstractC1921a.h(U7.a.I(this.d), AbstractC1683A.p(obj));
    }

    @Override // kotlinx.coroutines.c
    public void y(Object obj) {
        this.d.resumeWith(AbstractC1683A.p(obj));
    }
}
