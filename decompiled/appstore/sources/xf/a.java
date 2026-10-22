package xf;

import kotlin.jvm.internal.ClassBasedDeclarationContainer;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.u;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes4.dex */
public abstract class a {
    public static final Class a(KClass r10) {
        q.g(r10, "<this>");
        Class<?> r11 = ((ClassBasedDeclarationContainer) r10).getJClass();
        q.e(r11, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-java>>");
        return r11;
    }

    public static final Class b(KClass r10) {
        q.g(r10, "<this>");
        Class<?> r11 = ((ClassBasedDeclarationContainer) r10).getJClass();
        if (r11.isPrimitive() == true) goto L6;
        q.e(r11, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaObjectType>>");
        return r11;
    L6:
        String r12 = r11.getName();
        switch(r12.hashCode()) {
            case -1325958191: goto L42;
            case 104431: goto L38;
            case 3039496: goto L34;
            case 3052374: goto L30;
            case 3327612: goto L26;
            case 3625364: goto L22;
            case 64711720: goto L18;
            case 97526364: goto L14;
            case 109413500: goto L10;
            default: goto L45;
        };
    L45:
        q.e(r11, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaObjectType>>");
        return r11;
    L10:
        if (r12.equals("short") == false) goto L45;
        r11 = Short.class;
        goto L45
    L14:
        if (r12.equals("float") == false) goto L45;
        r11 = Float.class;
        goto L45
    L18:
        if (r12.equals("boolean") == false) goto L45;
        r11 = Boolean.class;
        goto L45
    L22:
        if (r12.equals("void") == false) goto L45;
        r11 = Void.class;
        goto L45
    L26:
        if (r12.equals("long") == false) goto L45;
        r11 = Long.class;
        goto L45
    L30:
        if (r12.equals("char") == false) goto L45;
        r11 = Character.class;
        goto L45
    L34:
        if (r12.equals("byte") == false) goto L45;
        r11 = Byte.class;
        goto L45
    L38:
        if (r12.equals("int") == false) goto L45;
        r11 = Integer.class;
        goto L45
    L42:
        if (r12.equals("double") == false) goto L45;
        r11 = Double.class;
        goto L45
    }

    public static final KClass c(Class r10) {
        q.g(r10, "<this>");
        return u.b(r10);
    }
}
