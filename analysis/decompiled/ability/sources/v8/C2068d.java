package v8;

import X8.F;
import X8.N;
import X8.S;
import X8.w;
import fa.C1449a;
import h8.InterfaceC1507O;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.k;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeFlexibility;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* renamed from: v8.d, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2068d {
    public static N a(InterfaceC1507O interfaceC1507O, C2065a typeAttr, C1449a typeParameterUpperBoundEraser, w wVar) {
        k.f(typeAttr, "typeAttr");
        k.f(typeParameterUpperBoundEraser, "typeParameterUpperBoundEraser");
        if (!typeAttr.d) {
            typeAttr = C2065a.a(typeAttr, JavaTypeFlexibility.f5002a, false, null, null, 61);
        }
        int iOrdinal = typeAttr.c.ordinal();
        if (iOrdinal != 0 && iOrdinal != 1) {
            if (iOrdinal == 2) {
                return new F(wVar, Variance.c);
            }
            throw new NoWhenBranchMatchedException();
        }
        if (!interfaceC1507O.r().b) {
            return new F(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.e(interfaceC1507O).n(), Variance.c);
        }
        List parameters = wVar.Q().getParameters();
        k.e(parameters, "getParameters(...)");
        return !parameters.isEmpty() ? new F(wVar, Variance.e) : S.k(interfaceC1507O, typeAttr);
    }
}
