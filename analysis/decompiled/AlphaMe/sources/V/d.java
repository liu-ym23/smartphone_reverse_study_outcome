package V;

import S.InterfaceC0103i;
import S.M;
import b3.InterfaceC0379h;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class d implements InterfaceC0103i {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC0103i f1920a;

    public d(M delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.f1920a = delegate;
    }

    @Override // S.InterfaceC0103i
    public final Object a(Function2 function2, Continuation continuation) {
        return this.f1920a.a(new c(function2, null), continuation);
    }

    @Override // S.InterfaceC0103i
    public final InterfaceC0379h b() {
        return this.f1920a.b();
    }
}
