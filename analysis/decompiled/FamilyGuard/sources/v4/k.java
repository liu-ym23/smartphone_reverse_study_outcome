package v4;

import V3.v;
import a4.C0428b;

/* loaded from: classes.dex */
final class k<T> extends AbstractC1192a<T> {

    /* renamed from: a, reason: collision with root package name */
    private final i4.p<InterfaceC1194c<? super T>, Z3.e<? super v>, Object> f23367a;

    /* JADX WARN: Multi-variable type inference failed */
    public k(i4.p<? super InterfaceC1194c<? super T>, ? super Z3.e<? super v>, ? extends Object> pVar) {
        this.f23367a = pVar;
    }

    @Override // v4.AbstractC1192a
    public Object b(InterfaceC1194c<? super T> interfaceC1194c, Z3.e<? super v> eVar) {
        Object objInvoke = this.f23367a.invoke(interfaceC1194c, eVar);
        return objInvoke == C0428b.e() ? objInvoke : v.f5542a;
    }
}
