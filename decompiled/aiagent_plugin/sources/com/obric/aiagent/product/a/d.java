package com.obric.aiagent.product.a;

import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;

/* JADX INFO: compiled from: SystemProperties.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f18776a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Method f18777b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Method f18778c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Method f18779d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Method f18780e;

    private d() {
    }

    static {
        f18776a = new d();
        Iterator r1 = d.h.b.c.a(ZeusTransformUtils.forName("android.os.SystemProperties", "com.obric.aiagent.plugin").getMethods());     // Catch: ClassNotFoundException -> L27
    L4:
        if (r1.hasNext() == false) goto L57;
        Method r2 = (Method) ZeusTransformUtils.preCheckCast(r1.next(), Method.class, "com.obric.aiagent.plugin");     // Catch: ClassNotFoundException -> L27
        String r3 = r2.getName();     // Catch: ClassNotFoundException -> L27
        if (r3 == null) goto L4;
        switch(r3.hashCode()) {
            case -1249359687: goto L23;
            case -75354382: goto L19;
            case 102230: goto L16;
            case 113762: goto L12;
            default: goto L4;
        };     // Catch: ClassNotFoundException -> L27
    L12:
        if (r3.equals("set") == false) goto L4;
        f18780e = r2;     // Catch: ClassNotFoundException -> L27
        goto L4
    L16:
        if (r3.equals(MonitorConstants.CONNECT_TYPE_GET) == false) goto L4;
        f18777b = r2;     // Catch: ClassNotFoundException -> L27
        goto L4
    L19:
        if (r3.equals("getLong") == false) goto L4;
        f18778c = r2;     // Catch: ClassNotFoundException -> L27
        goto L4
    L23:
        if (r3.equals("getInt") == false) goto L4;
        f18779d = r2;     // Catch: ClassNotFoundException -> L27
        goto L4
    L57:
        return;
    L27:
        e = move-exception;
        e.printStackTrace();
    }

    public final String a(String r4, String r5) {
        o.e(r5, "default_value");
        Method r3 = f18777b;
        if (r3 != null) goto L5;
        return r5;
    L5:
        Object r0 = null;
        if (r3 != null) goto L21;
    L15:
        o.a(r0, "null cannot be cast to non-null type kotlin.String");     // Catch: InvocationTargetException -> L9 IllegalAccessException -> L11 IllegalArgumentException -> L13
        return (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.aiagent.plugin");
    L11:
        e = move-exception;
        e.printStackTrace();
    L20:
        return r5;
    L13:
        e = move-exception;
        e.printStackTrace();
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L20
    L21:
        r0 = r3.invoke(null, new Object[]{r4, r5});     // Catch: InvocationTargetException -> L9 IllegalAccessException -> L11 IllegalArgumentException -> L13
        goto L15
    }

    public final int a(String r4, int r5) {
        Method r3 = f18779d;
        if (r3 != null) goto L5;
        return r5;
    L5:
        Object r0 = null;
        if (r3 != null) goto L21;
    L15:
        Integer r6 = (Integer) ZeusTransformUtils.preCheckCast(r0, Integer.class, "com.obric.aiagent.plugin");     // Catch: InvocationTargetException -> L9 IllegalAccessException -> L11 IllegalArgumentException -> L13
        o.a(r6);     // Catch: InvocationTargetException -> L9 IllegalAccessException -> L11 IllegalArgumentException -> L13
        return r6.intValue();
    L11:
        e = move-exception;
        e.printStackTrace();
    L20:
        return r5;
    L13:
        e = move-exception;
        e.printStackTrace();
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L20
    L21:
        r0 = r3.invoke(null, new Object[]{r4, Integer.valueOf(r5)});     // Catch: InvocationTargetException -> L9 IllegalAccessException -> L11 IllegalArgumentException -> L13
        goto L15
    }
}
