package Fa;

import E9.i0;
import Fa.f;
import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;

/* loaded from: classes5.dex */
public final class m implements f {

    /* renamed from: a, reason: collision with root package name */
    public static final m f2656a = new m();

    /* renamed from: b, reason: collision with root package name */
    public static final String f2657b = "should not have varargs or parameters with default values";

    @Override // Fa.f
    public /* bridge */ String a(kotlin.reflect.jvm.internal.impl.descriptors.e eVar) {
        return f.a.a(this, eVar);
    }

    @Override // Fa.f
    public boolean b(kotlin.reflect.jvm.internal.impl.descriptors.e functionDescriptor) {
        kotlin.jvm.internal.p.i(functionDescriptor, "functionDescriptor");
        List<i0> listI = functionDescriptor.i();
        kotlin.jvm.internal.p.h(listI, "getValueParameters(...)");
        List<i0> list = listI;
        if ((list instanceof Collection) && list.isEmpty()) {
            return true;
        }
        for (i0 i0Var : list) {
            kotlin.jvm.internal.p.f(i0Var);
            if (DescriptorUtilsKt.f(i0Var) || i0Var.p0() != null) {
                return false;
            }
        }
        return true;
    }

    @Override // Fa.f
    public String getDescription() {
        return f2657b;
    }
}
