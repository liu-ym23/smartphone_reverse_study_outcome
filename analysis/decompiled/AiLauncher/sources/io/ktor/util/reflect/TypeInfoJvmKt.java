package io.ktor.util.reflect;

import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.reflect.TypesJVMKt;
import o9.C5013a;
import w9.InterfaceC5745d;
import w9.InterfaceC5755n;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\u001a1\u0010\b\u001a\u00020\u00072\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u00012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0007¢\u0006\u0004\b\b\u0010\t\u001a\u001d\u0010\r\u001a\u00020\f*\u00020\n2\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0004\b\r\u0010\u000e\"\u001b\u0010\u0002\u001a\u00020\u0000*\u00020\u00078F¢\u0006\f\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010\"\"\u0010\u0017\u001a\u00060\u0000j\u0002`\u0001*\u00020\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014*\f\b\u0007\u0010\u0018\"\u00020\u00002\u00020\u0000¨\u0006\u0019"}, d2 = {"Ljava/lang/reflect/Type;", "Lio/ktor/util/reflect/Type;", "reifiedType", "Lw9/d;", "kClass", "Lw9/n;", "kType", "Lio/ktor/util/reflect/TypeInfo;", "typeInfoImpl", "(Ljava/lang/reflect/Type;Lw9/d;Lw9/n;)Lio/ktor/util/reflect/TypeInfo;", "", "type", "", "instanceOf", "(Ljava/lang/Object;Lw9/d;)Z", "getReifiedType", "(Lio/ktor/util/reflect/TypeInfo;)Ljava/lang/reflect/Type;", "getReifiedType$annotations", "(Lio/ktor/util/reflect/TypeInfo;)V", "getPlatformType", "(Lw9/n;)Ljava/lang/reflect/Type;", "getPlatformType$annotations", "(Lw9/n;)V", "platformType", "Type", "ktor-utils"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class TypeInfoJvmKt {
    public static /* synthetic */ void Type$annotations() {
    }

    public static final Type getPlatformType(InterfaceC5755n interfaceC5755n) {
        p.i(interfaceC5755n, "<this>");
        return TypesJVMKt.f(interfaceC5755n);
    }

    public static /* synthetic */ void getPlatformType$annotations(InterfaceC5755n interfaceC5755n) {
    }

    public static final Type getReifiedType(TypeInfo typeInfo) {
        Type typeF;
        p.i(typeInfo, "<this>");
        InterfaceC5755n kotlinType = typeInfo.getKotlinType();
        return (kotlinType == null || (typeF = TypesJVMKt.f(kotlinType)) == null) ? C5013a.b(typeInfo.getType()) : typeF;
    }

    public static /* synthetic */ void getReifiedType$annotations(TypeInfo typeInfo) {
    }

    public static final boolean instanceOf(Object obj, InterfaceC5745d<?> type) {
        p.i(obj, "<this>");
        p.i(type, "type");
        return C5013a.b(type).isInstance(obj);
    }

    public static final TypeInfo typeInfoImpl(Type reifiedType, InterfaceC5745d<?> kClass, InterfaceC5755n interfaceC5755n) {
        p.i(reifiedType, "reifiedType");
        p.i(kClass, "kClass");
        return new TypeInfo(kClass, interfaceC5755n);
    }
}
