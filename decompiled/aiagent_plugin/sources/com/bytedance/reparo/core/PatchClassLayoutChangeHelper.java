package com.bytedance.reparo.core;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class PatchClassLayoutChangeHelper {
    public static Map<String, Object> mAddedFieldMap;

    public PatchClassLayoutChangeHelper() {
    }

    static {
        mAddedFieldMap = new HashMap();
    }

    public static void classForName(String r3) {
        ZeusTransformUtils.forName(r3, "com.obric.aiagent.plugin");     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        com.bytedance.reparo.core.f.a.b("error classForName " + r3, th);
    }

    public static synchronized Object getInstanceField(Object r1, String r2, String r3) {
        monitor-enter(PatchClassLayoutChangeHelper.class);
        String r4 = a(r1, r2);     // Catch: Throwable -> L10
        if (mAddedFieldMap.containsKey(r4) == true) goto L7;
        mAddedFieldMap.put(r4, b(r3));     // Catch: Throwable -> L10
    L7:
        Object r5 = mAddedFieldMap.get(r4);     // Catch: Throwable -> L10
        monitor-exit(PatchClassLayoutChangeHelper.class);
        return r5;
    L10:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L15
        return null;
    L15:
        th = move-exception;
        throw th;
    }

    public static synchronized void setInstanceField(Object r2, String r3, Object r4) {
        monitor-enter(PatchClassLayoutChangeHelper.class);
        mAddedFieldMap.put(a(r2, r3), r4);     // Catch: Throwable -> L6
    L8:
        monitor-exit(PatchClassLayoutChangeHelper.class);
        return;
    L6:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    private static String a(Object r2, String r3) {
        return r2.getClass().getName() + "_" + r2.hashCode() + "_" + r3;
    }

    public static Object invokePrivateSuperMethod(Object r7, String r8, String r9, ArrayList<String> r10, ArrayList<Object> r11) {
        Class r0 = a(r8);     // Catch: Exception -> L12 InvocationTargetException -> L15
        Class[] r1 = new Class[r10.size()];     // Catch: Exception -> L12 InvocationTargetException -> L15
        int r3 = 0;
    L4:
        if (r3 >= r10.size()) goto L6;
        r1[r3] = a((String) ZeusTransformUtils.preCheckCast(r10.get(r3), String.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L12 InvocationTargetException -> L15
        r3 = r3 + 1;     // Catch: Exception -> L12 InvocationTargetException -> L15
        goto L4
    L6:
        Method r2 = com.bytedance.reparo.core.i.j.b(r0, r9, r1);     // Catch: Exception -> L12 InvocationTargetException -> L15
        r2.setAccessible(true);     // Catch: Exception -> L12 InvocationTargetException -> L15
        if (r2.getParameterTypes().length != (r11.size() + 1)) goto L11;
        r11.add(0, r7);     // Catch: Exception -> L12 InvocationTargetException -> L15
        return r2.invoke(r7, r11.toArray());
    L11:
        return WandTrick.callMethodDirect(r0, r2, r7, r10.toArray(), r11.toArray(), l.a(r2.getReturnType()), r2.getReturnType());
    L15:
        e = move-exception;
        throw e.getCause();
    L12:
        e = move-exception;
        com.bytedance.reparo.core.f.a.a("error when cls: " + r8 + "." + r9 + "(" + r10, e);
        return null;
    }

    public static Object invokePrivateMethod(Object r8, String r9, String r10, ArrayList<String> r11, ArrayList<Object> r12) {
        Class r1 = a(r9);     // Catch: Exception -> L16 InvocationTargetException -> L19
        Class<?>[] r2 = new Class[r11.size()];     // Catch: Exception -> L16 InvocationTargetException -> L19
        int r4 = 0;
    L5:
        if (r4 >= r11.size()) goto L8;
        r2[r4] = a((String) ZeusTransformUtils.preCheckCast(r11.get(r4), String.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L16 InvocationTargetException -> L19
        r4 = r4 + 1;     // Catch: Exception -> L16 InvocationTargetException -> L19
        goto L5
    L8:
        if (r10.equals("<init>") == false) goto L11;
        WandTrick.callMethodDirect(r1, r1.getDeclaredConstructor(r2), r8, r11.toArray(), r12.toArray(), null, null);     // Catch: Exception -> L16 InvocationTargetException -> L19
        return null;
    L11:
        Method r3 = com.bytedance.reparo.core.i.j.b(r1, r10, r2);     // Catch: Exception -> L16 InvocationTargetException -> L19
        r3.setAccessible(true);     // Catch: Exception -> L16 InvocationTargetException -> L19
        if (r3.getParameterTypes().length != (r12.size() + 1)) goto L15;
        r12.add(0, r8);     // Catch: Exception -> L16 InvocationTargetException -> L19
    L15:
        return r3.invoke(r8, r12.toArray());
    L19:
        e = move-exception;
        throw e.getCause();
    L16:
        e = move-exception;
        com.bytedance.reparo.core.f.a.a("error when cls: " + r9 + "." + r10 + "(" + r11, e);
        return null;
    }

    public static Object newWithPrivateConstructor(String r6, ArrayList<String> r7, ArrayList<Object> r8) {
        Class r0 = a(r6);     // Catch: Throwable -> L8
        Class<?>[] r1 = new Class[r7.size()];     // Catch: Throwable -> L8
        int r2 = 0;
    L4:
        if (r2 >= r7.size()) goto L6;
        r1[r2] = a((String) ZeusTransformUtils.preCheckCast(r7.get(r2), String.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L8
        r2 = r2 + 1;     // Catch: Throwable -> L8
        goto L4
    L6:
        Constructor r3 = r0.getDeclaredConstructor(r1);     // Catch: Throwable -> L8
        r3.setAccessible(true);     // Catch: Throwable -> L8
        return WandTrick.createInstance(r0, r3, r7.toArray(), r8.toArray());
    L8:
        th = move-exception;
        com.bytedance.reparo.core.f.a.a("newWithPrivateConstructor " + r6, th);
        return null;
    }

    public static Object getPrivateField(Object r0, String r1, String r2) {
        Field r3 = com.bytedance.reparo.core.i.j.a(a(r1), r2);     // Catch: Exception -> L4
        r3.setAccessible(true);     // Catch: Exception -> L4
        return r3.get(r0);
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static void setPrivateField(Object r0, String r1, String r2, ArrayList<Object> r3) {
        Field r4 = com.bytedance.reparo.core.i.j.a(a(r1), r2);     // Catch: Exception -> L4
        r4.setAccessible(true);     // Catch: Exception -> L4
        r4.set(r0, r3.get(0));     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    private static Class a(String r5) {
        byte r0 = -1;
        int r1 = r5.hashCode();     // Catch: Throwable -> L68
        if (r1 == 70) goto L37;
        if (r1 == 83) goto L34;
        if (r1 == 90) goto L31;
        if (r1 == 73) goto L28;
        if (r1 == 74) goto L25;
        switch(r1) {
            case 66: goto L22;
            case 67: goto L19;
            case 68: goto L16;
            default: goto L39;
        };     // Catch: Throwable -> L68
    L39:
        switch(r0) {
            case 0: goto L56;
            case 1: goto L54;
            case 2: goto L52;
            case 3: goto L50;
            case 4: goto L48;
            case 5: goto L46;
            case 6: goto L44;
            case 7: goto L42;
            default: goto L57;
        };     // Catch: Throwable -> L68
    L57:
        if ('[' != r5.charAt(0)) goto L61;
        return Array.newInstance(a(r5.substring(1)), 0).getClass();
    L61:
        if (r5.startsWith("L") == true) goto L63;
    L65:
        String r2 = r5;
    L67:
        return Class.forName(r2, false, h.class.getClassLoader());
    L63:
        if (r5.endsWith(";") == false) goto L65;
        r2 = r5.substring(1, r5.length() - 1).replace('/', '.');     // Catch: Throwable -> L68
        goto L67
    L42:
        return Long.TYPE;
    L44:
        return Double.TYPE;
    L46:
        return Float.TYPE;
    L48:
        return Integer.TYPE;
    L50:
        return Character.TYPE;
    L52:
        return Short.TYPE;
    L54:
        return Byte.TYPE;
    L56:
        return Boolean.TYPE;
    L16:
        if (r5.equals("D") == false) goto L39;
        r0 = 6;
        goto L39
    L19:
        if (r5.equals("C") == false) goto L39;
        r0 = 3;
        goto L39
    L22:
        if (r5.equals("B") == false) goto L39;
        r0 = 1;
        goto L39
    L25:
        if (r5.equals("J") == false) goto L39;
        r0 = 7;
        goto L39
    L28:
        if (r5.equals("I") == false) goto L39;
        r0 = 4;
        goto L39
    L31:
        if (r5.equals("Z") == false) goto L39;
        r0 = 0;
        goto L39
    L34:
        if (r5.equals("S") == false) goto L39;
        r0 = 2;
        goto L39
    L37:
        if (r5.equals("F") == false) goto L39;
        r0 = 5;
    L68:
        th = move-exception;
        th.printStackTrace();
        System.err.println("getClassByClassType " + r5);
        com.bytedance.reparo.core.f.a.b("getClassByClassType " + r5, th);
        return null;
    }

    private static Object b(String r3) {
        r3.hashCode();
        byte r2 = -1;
        switch(r3.hashCode()) {
            case 66: goto L34;
            case 67: goto L30;
            case 68: goto L26;
            case 70: goto L22;
            case 73: goto L18;
            case 74: goto L14;
            case 83: goto L10;
            case 90: goto L6;
            default: goto L37;
        };
    L37:
        switch(r2) {
            case 0: goto L55;
            case 1: goto L53;
            case 2: goto L51;
            case 3: goto L49;
            case 4: goto L47;
            case 5: goto L45;
            case 6: goto L43;
            case 7: goto L41;
            default: goto L38;
        };
    L38:
        return null;
    L41:
        return false;
    L43:
        return (short) 0;
    L45:
        return 0L;
    L47:
        return 0;
    L49:
        return Float.valueOf(0.0f);
    L51:
        return Double.valueOf(0.0d);
    L53:
        return (char) 0;
    L55:
        return (byte) 0;
    L6:
        if (r3.equals("Z") == false) goto L37;
        r2 = 7;
        goto L37
    L10:
        if (r3.equals("S") == false) goto L37;
        r2 = 6;
        goto L37
    L14:
        if (r3.equals("J") == false) goto L37;
        r2 = 5;
        goto L37
    L18:
        if (r3.equals("I") == false) goto L37;
        r2 = 4;
        goto L37
    L22:
        if (r3.equals("F") == false) goto L37;
        r2 = 3;
        goto L37
    L26:
        if (r3.equals("D") == false) goto L37;
        r2 = 2;
        goto L37
    L30:
        if (r3.equals("C") == false) goto L37;
        r2 = 1;
        goto L37
    L34:
        if (r3.equals("B") == false) goto L37;
        r2 = 0;
        goto L37
    }

    public static Object newInstanceWithoutConstruct(String r0) {
        return WandTrick.allocObject(a(r0));
    }
}
