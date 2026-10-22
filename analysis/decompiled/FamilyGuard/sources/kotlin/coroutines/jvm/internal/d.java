package kotlin.coroutines.jvm.internal;

import Z3.i;

/* loaded from: classes.dex */
public abstract class d extends a {
    private final Z3.i _context;
    private transient Z3.e<Object> intercepted;

    public d(Z3.e<Object> eVar, Z3.i iVar) {
        super(eVar);
        this._context = iVar;
    }

    @Override // Z3.e
    public Z3.i getContext() {
        Z3.i iVar = this._context;
        j4.k.d(iVar);
        return iVar;
    }

    public final Z3.e<Object> intercepted() {
        Z3.e<Object> eVarS = this.intercepted;
        if (eVarS == null) {
            Z3.f fVar = (Z3.f) getContext().a(Z3.f.f6654N);
            if (fVar == null || (eVarS = fVar.S(this)) == null) {
                eVarS = this;
            }
            this.intercepted = eVarS;
        }
        return eVarS;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    protected void releaseIntercepted() {
        Z3.e<?> eVar = this.intercepted;
        if (eVar != null && eVar != this) {
            i.b bVarA = getContext().a(Z3.f.f6654N);
            j4.k.d(bVarA);
            ((Z3.f) bVarA).D(eVar);
        }
        this.intercepted = c.f17939a;
    }

    public d(Z3.e<Object> eVar) {
        this(eVar, eVar != null ? eVar.getContext() : null);
    }
}
