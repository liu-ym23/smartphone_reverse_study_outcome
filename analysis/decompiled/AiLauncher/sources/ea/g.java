package ea;

import Z8.C1174w;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.p;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Expression;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter;

/* loaded from: classes5.dex */
public final class g {
    public static final ProtoBuf$Type a(ProtoBuf$Type protoBuf$Type, h typeTable) {
        p.i(protoBuf$Type, "<this>");
        p.i(typeTable, "typeTable");
        if (protoBuf$Type.j0()) {
            return protoBuf$Type.R();
        }
        if (protoBuf$Type.k0()) {
            return typeTable.a(protoBuf$Type.S());
        }
        return null;
    }

    public static final List<ProtoBuf$Type> b(ProtoBuf$Class protoBuf$Class, h typeTable) {
        p.i(protoBuf$Class, "<this>");
        p.i(typeTable, "typeTable");
        List<ProtoBuf$Type> listA0 = protoBuf$Class.A0();
        if (listA0.isEmpty()) {
            listA0 = null;
        }
        if (listA0 == null) {
            List<Integer> listZ0 = protoBuf$Class.z0();
            p.h(listZ0, "getContextReceiverTypeIdList(...)");
            List<Integer> list = listZ0;
            listA0 = new ArrayList<>(C1174w.x(list, 10));
            for (Integer num : list) {
                p.f(num);
                listA0.add(typeTable.a(num.intValue()));
            }
        }
        return listA0;
    }

    public static final List<ProtoBuf$Type> c(ProtoBuf$Function protoBuf$Function, h typeTable) {
        p.i(protoBuf$Function, "<this>");
        p.i(typeTable, "typeTable");
        List<ProtoBuf$Type> listO0 = protoBuf$Function.o0();
        if (listO0.isEmpty()) {
            listO0 = null;
        }
        if (listO0 == null) {
            List<Integer> listN0 = protoBuf$Function.n0();
            p.h(listN0, "getContextReceiverTypeIdList(...)");
            List<Integer> list = listN0;
            listO0 = new ArrayList<>(C1174w.x(list, 10));
            for (Integer num : list) {
                p.f(num);
                listO0.add(typeTable.a(num.intValue()));
            }
        }
        return listO0;
    }

    public static final List<ProtoBuf$Type> d(ProtoBuf$Property protoBuf$Property, h typeTable) {
        p.i(protoBuf$Property, "<this>");
        p.i(typeTable, "typeTable");
        List<ProtoBuf$Type> listY0 = protoBuf$Property.y0();
        if (listY0.isEmpty()) {
            listY0 = null;
        }
        if (listY0 == null) {
            List<Integer> listX0 = protoBuf$Property.x0();
            p.h(listX0, "getContextReceiverTypeIdList(...)");
            List<Integer> list = listX0;
            listY0 = new ArrayList<>(C1174w.x(list, 10));
            for (Integer num : list) {
                p.f(num);
                listY0.add(typeTable.a(num.intValue()));
            }
        }
        return listY0;
    }

    public static final ProtoBuf$Type e(ProtoBuf$TypeAlias protoBuf$TypeAlias, h typeTable) {
        p.i(protoBuf$TypeAlias, "<this>");
        p.i(typeTable, "typeTable");
        if (protoBuf$TypeAlias.h0()) {
            ProtoBuf$Type protoBuf$TypeX = protoBuf$TypeAlias.X();
            p.h(protoBuf$TypeX, "getExpandedType(...)");
            return protoBuf$TypeX;
        }
        if (protoBuf$TypeAlias.i0()) {
            return typeTable.a(protoBuf$TypeAlias.Y());
        }
        throw new IllegalStateException("No expandedType in ProtoBuf.TypeAlias");
    }

    public static final ProtoBuf$Type f(ProtoBuf$Type protoBuf$Type, h typeTable) {
        p.i(protoBuf$Type, "<this>");
        p.i(typeTable, "typeTable");
        if (protoBuf$Type.o0()) {
            return protoBuf$Type.b0();
        }
        if (protoBuf$Type.p0()) {
            return typeTable.a(protoBuf$Type.c0());
        }
        return null;
    }

    public static final boolean g(ProtoBuf$Function protoBuf$Function) {
        p.i(protoBuf$Function, "<this>");
        return protoBuf$Function.O0() || protoBuf$Function.P0();
    }

    public static final boolean h(ProtoBuf$Property protoBuf$Property) {
        p.i(protoBuf$Property, "<this>");
        return protoBuf$Property.f1() || protoBuf$Property.g1();
    }

    public static final ProtoBuf$Type i(ProtoBuf$Class protoBuf$Class, h typeTable) {
        p.i(protoBuf$Class, "<this>");
        p.i(typeTable, "typeTable");
        if (protoBuf$Class.k1()) {
            return protoBuf$Class.M0();
        }
        if (protoBuf$Class.l1()) {
            return typeTable.a(protoBuf$Class.N0());
        }
        return null;
    }

    public static final ProtoBuf$Type j(ProtoBuf$Expression protoBuf$Expression, h typeTable) {
        p.i(protoBuf$Expression, "<this>");
        p.i(typeTable, "typeTable");
        if (protoBuf$Expression.Q()) {
            return protoBuf$Expression.H();
        }
        if (protoBuf$Expression.R()) {
            return typeTable.a(protoBuf$Expression.J());
        }
        return null;
    }

    public static final ProtoBuf$Type k(ProtoBuf$Type protoBuf$Type, h typeTable) {
        p.i(protoBuf$Type, "<this>");
        p.i(typeTable, "typeTable");
        if (protoBuf$Type.r0()) {
            return protoBuf$Type.e0();
        }
        if (protoBuf$Type.s0()) {
            return typeTable.a(protoBuf$Type.f0());
        }
        return null;
    }

    public static final ProtoBuf$Type l(ProtoBuf$Function protoBuf$Function, h typeTable) {
        p.i(protoBuf$Function, "<this>");
        p.i(typeTable, "typeTable");
        if (protoBuf$Function.O0()) {
            return protoBuf$Function.y0();
        }
        if (protoBuf$Function.P0()) {
            return typeTable.a(protoBuf$Function.z0());
        }
        return null;
    }

    public static final ProtoBuf$Type m(ProtoBuf$Property protoBuf$Property, h typeTable) {
        p.i(protoBuf$Property, "<this>");
        p.i(typeTable, "typeTable");
        if (protoBuf$Property.f1()) {
            return protoBuf$Property.O0();
        }
        if (protoBuf$Property.g1()) {
            return typeTable.a(protoBuf$Property.P0());
        }
        return null;
    }

    public static final ProtoBuf$Type n(ProtoBuf$Function protoBuf$Function, h typeTable) {
        p.i(protoBuf$Function, "<this>");
        p.i(typeTable, "typeTable");
        if (protoBuf$Function.Q0()) {
            ProtoBuf$Type protoBuf$TypeA0 = protoBuf$Function.A0();
            p.h(protoBuf$TypeA0, "getReturnType(...)");
            return protoBuf$TypeA0;
        }
        if (protoBuf$Function.R0()) {
            return typeTable.a(protoBuf$Function.B0());
        }
        throw new IllegalStateException("No returnType in ProtoBuf.Function");
    }

    public static final ProtoBuf$Type o(ProtoBuf$Property protoBuf$Property, h typeTable) {
        p.i(protoBuf$Property, "<this>");
        p.i(typeTable, "typeTable");
        if (protoBuf$Property.h1()) {
            ProtoBuf$Type protoBuf$TypeQ0 = protoBuf$Property.Q0();
            p.h(protoBuf$TypeQ0, "getReturnType(...)");
            return protoBuf$TypeQ0;
        }
        if (protoBuf$Property.i1()) {
            return typeTable.a(protoBuf$Property.R0());
        }
        throw new IllegalStateException("No returnType in ProtoBuf.Property");
    }

    public static final List<ProtoBuf$Type> p(ProtoBuf$Class protoBuf$Class, h typeTable) {
        p.i(protoBuf$Class, "<this>");
        p.i(typeTable, "typeTable");
        List<ProtoBuf$Type> listW0 = protoBuf$Class.W0();
        if (listW0.isEmpty()) {
            listW0 = null;
        }
        if (listW0 == null) {
            List<Integer> listV0 = protoBuf$Class.V0();
            p.h(listV0, "getSupertypeIdList(...)");
            List<Integer> list = listV0;
            listW0 = new ArrayList<>(C1174w.x(list, 10));
            for (Integer num : list) {
                p.f(num);
                listW0.add(typeTable.a(num.intValue()));
            }
        }
        return listW0;
    }

    public static final ProtoBuf$Type q(ProtoBuf$Type.Argument argument, h typeTable) {
        p.i(argument, "<this>");
        p.i(typeTable, "typeTable");
        if (argument.z()) {
            return argument.w();
        }
        if (argument.A()) {
            return typeTable.a(argument.x());
        }
        return null;
    }

    public static final ProtoBuf$Type r(ProtoBuf$ValueParameter protoBuf$ValueParameter, h typeTable) {
        p.i(protoBuf$ValueParameter, "<this>");
        p.i(typeTable, "typeTable");
        if (protoBuf$ValueParameter.a0()) {
            ProtoBuf$Type protoBuf$TypeT = protoBuf$ValueParameter.T();
            p.h(protoBuf$TypeT, "getType(...)");
            return protoBuf$TypeT;
        }
        if (protoBuf$ValueParameter.b0()) {
            return typeTable.a(protoBuf$ValueParameter.U());
        }
        throw new IllegalStateException("No type in ProtoBuf.ValueParameter");
    }

    public static final ProtoBuf$Type s(ProtoBuf$TypeAlias protoBuf$TypeAlias, h typeTable) {
        p.i(protoBuf$TypeAlias, "<this>");
        p.i(typeTable, "typeTable");
        if (protoBuf$TypeAlias.l0()) {
            ProtoBuf$Type protoBuf$TypeE0 = protoBuf$TypeAlias.e0();
            p.h(protoBuf$TypeE0, "getUnderlyingType(...)");
            return protoBuf$TypeE0;
        }
        if (protoBuf$TypeAlias.m0()) {
            return typeTable.a(protoBuf$TypeAlias.f0());
        }
        throw new IllegalStateException("No underlyingType in ProtoBuf.TypeAlias");
    }

    public static final List<ProtoBuf$Type> t(ProtoBuf$TypeParameter protoBuf$TypeParameter, h typeTable) {
        p.i(protoBuf$TypeParameter, "<this>");
        p.i(typeTable, "typeTable");
        List<ProtoBuf$Type> listS = protoBuf$TypeParameter.S();
        if (listS.isEmpty()) {
            listS = null;
        }
        if (listS == null) {
            List<Integer> listR = protoBuf$TypeParameter.R();
            p.h(listR, "getUpperBoundIdList(...)");
            List<Integer> list = listR;
            listS = new ArrayList<>(C1174w.x(list, 10));
            for (Integer num : list) {
                p.f(num);
                listS.add(typeTable.a(num.intValue()));
            }
        }
        return listS;
    }

    public static final ProtoBuf$Type u(ProtoBuf$ValueParameter protoBuf$ValueParameter, h typeTable) {
        p.i(protoBuf$ValueParameter, "<this>");
        p.i(typeTable, "typeTable");
        if (protoBuf$ValueParameter.c0()) {
            return protoBuf$ValueParameter.V();
        }
        if (protoBuf$ValueParameter.d0()) {
            return typeTable.a(protoBuf$ValueParameter.W());
        }
        return null;
    }
}
