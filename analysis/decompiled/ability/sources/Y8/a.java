package Y8;

import X8.A;
import X8.AbstractC0272c;
import X8.J;
import a9.InterfaceC0310b;
import a9.InterfaceC0311c;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* loaded from: classes4.dex */
public final class a extends AbstractC0272c {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f1571a;
    public final /* synthetic */ kotlin.reflect.jvm.internal.impl.types.a b;

    public a(b bVar, kotlin.reflect.jvm.internal.impl.types.a aVar) {
        this.f1571a = bVar;
        this.b = aVar;
    }

    @Override // X8.AbstractC0272c
    public final InterfaceC0311c D(J state, InterfaceC0310b type) {
        kotlin.jvm.internal.k.f(state, "state");
        kotlin.jvm.internal.k.f(type, "type");
        b bVar = this.f1571a;
        A aM = bVar.m(this.b.g(bVar.X(type), Variance.c));
        kotlin.jvm.internal.k.c(aM);
        return aM;
    }
}
