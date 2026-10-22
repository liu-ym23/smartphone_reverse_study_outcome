package r8;

import S7.k;
import X8.w;
import e8.n;
import h8.InterfaceC1540w;
import k8.Q;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;

/* renamed from: r8.d, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1882d implements k {

    /* renamed from: a, reason: collision with root package name */
    public static final C1882d f5682a = new C1882d();

    @Override // S7.k
    public final Object invoke(Object obj) {
        w type;
        InterfaceC1540w module = (InterfaceC1540w) obj;
        Object obj2 = AbstractC1883e.f5683a;
        kotlin.jvm.internal.k.f(module, "module");
        Q qB = com.stepos.ability.task.executor.e.B(AbstractC1881c.b, module.c().i(n.f4421t));
        return (qB == null || (type = qB.getType()) == null) ? Z8.i.c(ErrorTypeKind.f5151C, new String[0]) : type;
    }
}
