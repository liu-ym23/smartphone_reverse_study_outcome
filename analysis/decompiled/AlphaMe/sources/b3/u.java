package b3;

import c3.C0394a;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Ref;

/* loaded from: classes2.dex */
public final class u implements InterfaceC0380i {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f4442a;

    public u(Ref.ObjectRef objectRef) {
        this.f4442a = objectRef;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // b3.InterfaceC0380i
    public final Object emit(Object obj, Continuation continuation) {
        this.f4442a.element = obj;
        throw new C0394a(this);
    }
}
