package D8;

import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter;

/* loaded from: classes4.dex */
public abstract class i {
    public static final ProtoBuf$Type a(ProtoBuf$Type protoBuf$Type, j jVar) {
        kotlin.jvm.internal.k.f(protoBuf$Type, "<this>");
        int i = protoBuf$Type.c;
        if ((i & 256) == 256) {
            return protoBuf$Type.m;
        }
        if ((i & 512) == 512) {
            return jVar.b(protoBuf$Type.n);
        }
        return null;
    }

    public static final ProtoBuf$Type b(ProtoBuf$Function protoBuf$Function, j typeTable) {
        kotlin.jvm.internal.k.f(protoBuf$Function, "<this>");
        kotlin.jvm.internal.k.f(typeTable, "typeTable");
        int i = protoBuf$Function.c;
        if ((i & 32) == 32) {
            return protoBuf$Function.f5048j;
        }
        if ((i & 64) == 64) {
            return typeTable.b(protoBuf$Function.k);
        }
        return null;
    }

    public static final ProtoBuf$Type c(ProtoBuf$Function protoBuf$Function, j typeTable) {
        kotlin.jvm.internal.k.f(protoBuf$Function, "<this>");
        kotlin.jvm.internal.k.f(typeTable, "typeTable");
        int i = protoBuf$Function.c;
        if ((i & 8) == 8) {
            ProtoBuf$Type protoBuf$Type = protoBuf$Function.g;
            kotlin.jvm.internal.k.e(protoBuf$Type, "getReturnType(...)");
            return protoBuf$Type;
        }
        if ((i & 16) == 16) {
            return typeTable.b(protoBuf$Function.h);
        }
        throw new IllegalStateException("No returnType in ProtoBuf.Function");
    }

    public static final ProtoBuf$Type d(ProtoBuf$Property protoBuf$Property, j typeTable) {
        kotlin.jvm.internal.k.f(protoBuf$Property, "<this>");
        kotlin.jvm.internal.k.f(typeTable, "typeTable");
        int i = protoBuf$Property.c;
        if ((i & 8) == 8) {
            ProtoBuf$Type protoBuf$Type = protoBuf$Property.g;
            kotlin.jvm.internal.k.e(protoBuf$Type, "getReturnType(...)");
            return protoBuf$Type;
        }
        if ((i & 16) == 16) {
            return typeTable.b(protoBuf$Property.h);
        }
        throw new IllegalStateException("No returnType in ProtoBuf.Property");
    }

    public static final ProtoBuf$Type e(ProtoBuf$ValueParameter protoBuf$ValueParameter, j typeTable) {
        kotlin.jvm.internal.k.f(typeTable, "typeTable");
        int i = protoBuf$ValueParameter.c;
        if ((i & 4) == 4) {
            ProtoBuf$Type protoBuf$Type = protoBuf$ValueParameter.f;
            kotlin.jvm.internal.k.e(protoBuf$Type, "getType(...)");
            return protoBuf$Type;
        }
        if ((i & 8) == 8) {
            return typeTable.b(protoBuf$ValueParameter.g);
        }
        throw new IllegalStateException("No type in ProtoBuf.ValueParameter");
    }
}
