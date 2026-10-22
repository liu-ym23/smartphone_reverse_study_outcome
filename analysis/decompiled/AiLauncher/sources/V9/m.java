package V9;

import E9.InterfaceC0803h;
import E9.b0;
import W9.Z;
import Z9.y;
import Z9.z;
import java.util.Map;
import xa.InterfaceC5864g;

/* loaded from: classes5.dex */
public final class m implements p {

    /* renamed from: a, reason: collision with root package name */
    public final k f6545a;

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC0803h f6546b;

    /* renamed from: c, reason: collision with root package name */
    public final int f6547c;

    /* renamed from: d, reason: collision with root package name */
    public final Map<y, Integer> f6548d;

    /* renamed from: e, reason: collision with root package name */
    public final InterfaceC5864g<y, Z> f6549e;

    public m(k c10, InterfaceC0803h containingDeclaration, z typeParameterOwner, int i10) {
        kotlin.jvm.internal.p.i(c10, "c");
        kotlin.jvm.internal.p.i(containingDeclaration, "containingDeclaration");
        kotlin.jvm.internal.p.i(typeParameterOwner, "typeParameterOwner");
        this.f6545a = c10;
        this.f6546b = containingDeclaration;
        this.f6547c = i10;
        this.f6548d = Ia.a.d(typeParameterOwner.getTypeParameters());
        this.f6549e = c10.e().f(new l(this));
    }

    public static final Z c(m mVar, y typeParameter) {
        kotlin.jvm.internal.p.i(typeParameter, "typeParameter");
        Integer num = mVar.f6548d.get(typeParameter);
        if (num == null) {
            return null;
        }
        return new Z(c.k(c.d(mVar.f6545a, mVar), mVar.f6546b.getAnnotations()), typeParameter, mVar.f6547c + num.intValue(), mVar.f6546b);
    }

    @Override // V9.p
    public b0 a(y javaTypeParameter) {
        kotlin.jvm.internal.p.i(javaTypeParameter, "javaTypeParameter");
        Z zInvoke = this.f6549e.invoke(javaTypeParameter);
        return zInvoke != null ? zInvoke : this.f6545a.f().a(javaTypeParameter);
    }
}
