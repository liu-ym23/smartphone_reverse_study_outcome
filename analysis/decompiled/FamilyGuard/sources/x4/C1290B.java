package x4;

import a4.C0428b;
import s4.AbstractC1060a;
import s4.C1053B;

/* renamed from: x4.B, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1290B<T> extends AbstractC1060a<T> implements kotlin.coroutines.jvm.internal.e {

    /* renamed from: d, reason: collision with root package name */
    public final Z3.e<T> f23827d;

    /* JADX WARN: Multi-variable type inference failed */
    public C1290B(Z3.i iVar, Z3.e<? super T> eVar) {
        super(iVar, true, true);
        this.f23827d = eVar;
    }

    @Override // s4.AbstractC1060a
    protected void J0(Object obj) {
        Z3.e<T> eVar = this.f23827d;
        eVar.resumeWith(C1053B.a(obj, eVar));
    }

    @Override // kotlin.coroutines.jvm.internal.e
    public final kotlin.coroutines.jvm.internal.e getCallerFrame() {
        Z3.e<T> eVar = this.f23827d;
        if (eVar instanceof kotlin.coroutines.jvm.internal.e) {
            return (kotlin.coroutines.jvm.internal.e) eVar;
        }
        return null;
    }

    @Override // s4.u0
    protected final boolean j0() {
        return true;
    }

    @Override // s4.u0
    protected void l(Object obj) {
        C1311k.c(C0428b.c(this.f23827d), C1053B.a(obj, this.f23827d), null, 2, null);
    }
}
