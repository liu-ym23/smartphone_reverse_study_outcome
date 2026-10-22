package com.ttnet.org.chromium.base;

import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import java.util.Objects;

/* JADX INFO: compiled from: ParamChecker.java */
/* JADX INFO: loaded from: classes4.dex */
public final class n {
    public static void a(Class<?>[] r7, Object... r8) {
        Objects.requireNonNull(r7, "parameterType should not be null");
        if (r8 != null) goto L6;
        r8 = new Object[0];
    L6:
        if (r7.length != r8.length) goto L21;
        int r1 = 0;
    L9:
        if (r1 >= r7.length) goto L19;
        Class<?> r2 = r7[r1];
        Object r5 = r8[r1];
        if (a(r2, r5) == false) goto L12;
        r1 = r1 + 1;
        goto L9
    L12:
        String r9 = b(r2);
        if (r5 != null) goto L15;
        String r10 = "null";
    L17:
        throw new IllegalArgumentException(String.format("The param %d type mismatch: expected %s, actual %s", new Object[]{Integer.valueOf(r1 + 1), r9, r10}));
    L15:
        r10 = b(r5.getClass());
        goto L17
    L19:
        return;
    L21:
        throw new IllegalArgumentException(String.format("param count mismatch: expected %d, actual %d", new Object[]{Integer.valueOf(r7.length), Integer.valueOf(r8.length)}));
    }

    private static boolean a(Class<?> r0, Object r1) {
        if (r1 != null) goto L6;
        return !r0.isPrimitive();
    L6:
        return a(r0).isAssignableFrom(a(r1.getClass()));
    }

    private static Class<?> a(Class<?> r3) {
        if (r3 != null) goto L4;
        return r3;
    L4:
        if (r3.isPrimitive() == false) goto L66;
        String r0 = r3.getName();
        r0.hashCode();
        byte r1 = -1;
        switch(r0.hashCode()) {
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
        switch(r1) {
            case 0: goto L63;
            case 1: goto L61;
            case 2: goto L59;
            case 3: goto L57;
            case 4: goto L55;
            case 5: goto L53;
            case 6: goto L51;
            case 7: goto L49;
            case 8: goto L47;
            default: goto L46;
        };
    L46:
        return r3;
    L47:
        return Short.class;
    L49:
        return Float.class;
    L51:
        return Boolean.class;
    L53:
        return Void.class;
    L55:
        return Long.class;
    L57:
        return Character.class;
    L59:
        return Byte.class;
    L61:
        return Integer.class;
    L63:
        return Double.class;
    L10:
        if (r0.equals("short") == false) goto L45;
        r1 = 8;
        goto L45
    L14:
        if (r0.equals(WsChannelMultiProcessSharedProvider.FLOAT_TYPE) == false) goto L45;
        r1 = 7;
        goto L45
    L18:
        if (r0.equals(WsChannelMultiProcessSharedProvider.BOOLEAN_TYPE) == false) goto L45;
        r1 = 6;
        goto L45
    L22:
        if (r0.equals("void") == false) goto L45;
        r1 = 5;
        goto L45
    L26:
        if (r0.equals(WsChannelMultiProcessSharedProvider.LONG_TYPE) == false) goto L45;
        r1 = 4;
        goto L45
    L30:
        if (r0.equals("char") == false) goto L45;
        r1 = 3;
        goto L45
    L34:
        if (r0.equals("byte") == false) goto L45;
        r1 = 2;
        goto L45
    L38:
        if (r0.equals("int") == false) goto L45;
        r1 = 1;
        goto L45
    L42:
        if (r0.equals("double") == false) goto L45;
        r1 = 0;
        goto L45
    L66:
        return r3;
    }

    private static String b(Class<?> r1) {
        if (r1 != null) goto L6;
        return "null";
    L6:
        if (r1.isArray() == false) goto L10;
        return r1.getCanonicalName();
    L10:
        if (r1.isPrimitive() == false) goto L14;
        return r1.getName();
    L14:
        return r1.getCanonicalName();
    }
}
