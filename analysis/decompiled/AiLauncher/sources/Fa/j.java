package Fa;

import C9.n;
import E9.i0;
import Fa.f;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import ya.S;

/* loaded from: classes5.dex */
public final class j implements f {

    /* renamed from: a, reason: collision with root package name */
    public static final j f2650a = new j();

    /* renamed from: b, reason: collision with root package name */
    public static final String f2651b = "second parameter must be of type KProperty<*> or its supertype";

    @Override // Fa.f
    public /* bridge */ String a(kotlin.reflect.jvm.internal.impl.descriptors.e eVar) {
        return f.a.a(this, eVar);
    }

    @Override // Fa.f
    public boolean b(kotlin.reflect.jvm.internal.impl.descriptors.e functionDescriptor) {
        kotlin.jvm.internal.p.i(functionDescriptor, "functionDescriptor");
        i0 i0Var = functionDescriptor.i().get(1);
        n.b bVar = C9.n.f1796k;
        kotlin.jvm.internal.p.f(i0Var);
        S sA = bVar.a(DescriptorUtilsKt.s(i0Var));
        if (sA == null) {
            return false;
        }
        S type = i0Var.getType();
        kotlin.jvm.internal.p.h(type, "getType(...)");
        return Da.d.w(sA, Da.d.A(type));
    }

    @Override // Fa.f
    public String getDescription() {
        return f2651b;
    }
}
