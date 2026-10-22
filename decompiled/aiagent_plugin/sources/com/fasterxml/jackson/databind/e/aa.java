package com.fasterxml.jackson.databind.e;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: compiled from: MethodGenericTypeResolver.java */
/* JADX INFO: loaded from: classes2.dex */
final class aa {
    public static ag a(Method r2, com.fasterxml.jackson.databind.k r3, com.fasterxml.jackson.databind.k.o r4, ag r5) {
        ag r6 = (ag) ZeusTransformUtils.wrapperContextForParams(r5, ag.class, "com.obric.aiagent.plugin");
        com.fasterxml.jackson.databind.k.n r7 = a(r2, r3, r6);
        if (r7 != null) goto L6;
        return r6;
    L6:
        return new ag.a(r4, r7);
    }

    static com.fasterxml.jackson.databind.k.n a(Method r10, com.fasterxml.jackson.databind.k r11, ag r12) {
        ag r13 = (ag) ZeusTransformUtils.wrapperContextForParams(r12, ag.class, "com.obric.aiagent.plugin");
        TypeVariable<Method>[] r0 = r10.getTypeParameters();
        if (r0.length != 0) goto L5;
    L49:
        return null;
    L5:
        if (r11.A().b() == true) goto L49;
        Type r14 = r10.getGenericReturnType();
        if (ZeusTransformUtils.instanceOf(r14, ParameterizedType.class) == true) goto L10;
        return null;
    L10:
        ParameterizedType r15 = (ParameterizedType) ZeusTransformUtils.preCheckCast(r14, ParameterizedType.class, "com.obric.aiagent.plugin");
        if (Objects.equals(r11.e(), r15.getRawType()) == true) goto L13;
        return null;
    L13:
        Type[] r16 = r15.getActualTypeArguments();
        ArrayList r2 = new ArrayList(r0.length);
        ArrayList r4 = new ArrayList(r0.length);
        int r5 = 0;
    L15:
        if (r5 >= r16.length) goto L45;
        TypeVariable<?> r6 = a(r16[r5]);
        if (r6 == null) goto L43;
        String r7 = r6.getName();
        if (r7 == null) goto L20;
        com.fasterxml.jackson.databind.k r8 = r11.A().a(r5);
        if (r8 == null) goto L23;
        TypeVariable<?> r9 = a(r0, r7);
        if (r9 == null) goto L26;
        if (a(r13, r8, r9.getBounds()) == false) goto L43;
        int r17 = r2.indexOf(r7);
        if (r17 == (-1)) goto L42;
        com.fasterxml.jackson.databind.k r18 = (com.fasterxml.jackson.databind.k) ZeusTransformUtils.preCheckCast(r4.get(r17), com.fasterxml.jackson.databind.k.class, "com.obric.aiagent.plugin");
        if (r8.equals(r18) == true) goto L43;
        boolean r19 = r18.b(r8.e());
        boolean r20 = r8.b(r18.e());
        if (r19 == true) goto L39;
        if (r20 == true) goto L39;
        return null;
    L39:
        if ((r19 ^ r20) == false) goto L43;
        if (r20 == false) goto L43;
        r4.set(r17, r8);
        goto L43
    L42:
        r2.add(r7);
        r4.add(r8);
        goto L43
    L26:
        return null;
    L23:
        return null;
    L20:
        return null;
    L43:
        r5 = r5 + 1;
        goto L15
    L45:
        if (r2.isEmpty() == false) goto L48;
        return null;
    L48:
        return com.fasterxml.jackson.databind.k.n.a(r2, r4);
    }

    private static TypeVariable<?> a(Type r3) {
        Type r4 = (Type) ZeusTransformUtils.wrapperContextForParams(r3, Type.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, TypeVariable.class) == false) goto L7;
        return (TypeVariable) ZeusTransformUtils.preCheckCast(r4, TypeVariable.class, "com.obric.aiagent.plugin");
    L7:
        if (ZeusTransformUtils.instanceOf(r4, WildcardType.class) == false) goto L15;
        WildcardType r5 = (WildcardType) ZeusTransformUtils.preCheckCast(r4, WildcardType.class, "com.obric.aiagent.plugin");
        if (r5.getLowerBounds().length == 0) goto L11;
        return null;
    L11:
        Type[] r6 = r5.getUpperBounds();
        if (r6.length != 1) goto L15;
        return a(r6[0]);
    L15:
        return null;
    }

    private static ParameterizedType b(Type r3) {
        Type r4 = (Type) ZeusTransformUtils.wrapperContextForParams(r3, Type.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, ParameterizedType.class) == false) goto L7;
        return (ParameterizedType) ZeusTransformUtils.preCheckCast(r4, ParameterizedType.class, "com.obric.aiagent.plugin");
    L7:
        if (ZeusTransformUtils.instanceOf(r4, WildcardType.class) == false) goto L15;
        WildcardType r5 = (WildcardType) ZeusTransformUtils.preCheckCast(r4, WildcardType.class, "com.obric.aiagent.plugin");
        if (r5.getLowerBounds().length == 0) goto L11;
        return null;
    L11:
        Type[] r6 = r5.getUpperBounds();
        if (r6.length != 1) goto L15;
        return b(r6[0]);
    L15:
        return null;
    }

    private static boolean a(ag r4, com.fasterxml.jackson.databind.k r5, Type[] r6) {
        ag r7 = (ag) ZeusTransformUtils.wrapperContextForParams(r4, ag.class, "com.obric.aiagent.plugin");
        int r0 = r6.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L8;
        if (a(r7, r5, r6[r2]) == false) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return false;
    L8:
        return true;
    }

    private static boolean a(ag r4, com.fasterxml.jackson.databind.k r5, Type r6) {
        ag r7 = (ag) ZeusTransformUtils.wrapperContextForParams(r4, ag.class, "com.obric.aiagent.plugin");
        Type r8 = (Type) ZeusTransformUtils.wrapperContextForParams(r6, Type.class, "com.obric.aiagent.plugin");
        if (r5.b(r7.a(r8).e()) == true) goto L5;
        return false;
    L5:
        ParameterizedType r9 = b(r8);
        if (r9 != null) goto L8;
        return true;
    L8:
        if (Objects.equals(r5.e(), r9.getRawType()) == false) goto L23;
        Type[] r10 = r9.getActualTypeArguments();
        com.fasterxml.jackson.databind.k.n r11 = r5.A();
        if (r11.c() == r10.length) goto L12;
        return false;
    L12:
        int r0 = 0;
    L14:
        if (r0 >= r11.c()) goto L24;
        if (a(r7, r11.a(r0), r10[r0]) == false) goto L17;
        r0 = r0 + 1;
        goto L14
    L17:
        return false;
    L24:
        return true;
    L23:
        return true;
    }

    private static TypeVariable<?> a(TypeVariable<?>[] r5, String r6) {
        if (r5 == null) goto L12;
        if (r6 == null) goto L12;
        int r1 = r5.length;
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L12;
        TypeVariable<?> r3 = r5[r2];
        if (r6.equals(r3.getName()) == true) goto L10;
        r2 = r2 + 1;
        goto L7
    L10:
        return r3;
    L12:
        return null;
    }
}
