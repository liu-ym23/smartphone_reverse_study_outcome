package S9;

import E9.AbstractC0811p;
import E9.m0;
import java.util.Iterator;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.ReportLevel;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;

/* loaded from: classes5.dex */
public final class O {
    public static final F9.c a(V9.k c10, Z9.C wildcardType) {
        F9.c next;
        kotlin.jvm.internal.p.i(c10, "c");
        kotlin.jvm.internal.p.i(wildcardType, "wildcardType");
        if (wildcardType.getBound() == null) {
            throw new IllegalArgumentException("Nullability annotations on unbounded wildcards aren't supported");
        }
        Iterator<F9.c> it = new V9.g(c10, wildcardType, false, 4, null).iterator();
        loop0: while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            F9.c cVar = next;
            for (ga.c cVar2 : x.e()) {
                if (kotlin.jvm.internal.p.d(cVar.f(), cVar2)) {
                    break loop0;
                }
            }
        }
        return next;
    }

    public static final boolean b(CallableMemberDescriptor memberDescriptor) {
        kotlin.jvm.internal.p.i(memberDescriptor, "memberDescriptor");
        return (memberDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.e) && kotlin.jvm.internal.p.d(memberDescriptor.o0(JavaMethodDescriptor.f35121H), Boolean.TRUE);
    }

    public static final boolean c(A javaTypeEnhancementState) {
        kotlin.jvm.internal.p.i(javaTypeEnhancementState, "javaTypeEnhancementState");
        return javaTypeEnhancementState.b().invoke(x.d()) == ReportLevel.STRICT;
    }

    public static final AbstractC0811p d(m0 m0Var) {
        kotlin.jvm.internal.p.i(m0Var, "<this>");
        AbstractC0811p abstractC0811pG = v.g(m0Var);
        kotlin.jvm.internal.p.h(abstractC0811pG, "toDescriptorVisibility(...)");
        return abstractC0811pG;
    }
}
