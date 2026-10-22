package com.obric.autogui.platforms.tools.internal;

import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: ReflectiveMethodHelper.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {
    private static final String TAG = "ReflectiveMethodHelper";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f30360a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f30361b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Class<?> f30362c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f30363d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Method f30364e;

    /* JADX INFO: compiled from: ReflectiveMethodHelper.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }

        public static final /* synthetic */ boolean a(a r0, Class r1, Class r2) {
            return r0.a(r1, r2);
        }

        private final boolean a(Class<?> r2, Class<?> r3) {
            if (r2.isAssignableFrom(r3) == false) goto L6;
            return true;
        L6:
            if (r2.isPrimitive() == true) goto L8;
            return false;
        L8:
            if (o.a(r2, Boolean.TYPE) == false) goto L13;
            if (o.a(r3, Boolean.class) == false) goto L13;
            return true;
        L13:
            if (o.a(r2, Integer.TYPE) == false) goto L18;
            if (o.a(r3, Integer.class) == false) goto L18;
            return true;
        L18:
            if (o.a(r2, Long.TYPE) == false) goto L23;
            if (o.a(r3, Long.class) == false) goto L23;
            return true;
        L23:
            if (o.a(r2, Float.TYPE) == false) goto L28;
            if (o.a(r3, Float.class) == false) goto L28;
            return true;
        L28:
            if (o.a(r2, Double.TYPE) == false) goto L33;
            if (o.a(r3, Double.class) == false) goto L33;
            return true;
        L33:
            if (o.a(r2, Short.TYPE) == false) goto L38;
            if (o.a(r3, Short.class) == false) goto L38;
            return true;
        L38:
            if (o.a(r2, Byte.TYPE) == false) goto L43;
            if (o.a(r3, Byte.class) == false) goto L43;
            return true;
        L43:
            if (o.a(r2, Character.TYPE) == true) goto L45;
            return false;
        L45:
            if (o.a(r3, Character.class) == false) goto L50;
            return true;
        L50:
            return false;
        }
    }

    static {
        f30360a = new a(null);
    }

    private c(String r1, Class<?> r2, String r3) {
        this.f30361b = r1;
        this.f30362c = r2;
        this.f30363d = r3;
    }

    public c(Class<?> r2, String r3) {
        o.e(r2, "clazz");
        o.e(r3, "methodName");
        this(null, r2, r3);
    }

    public c(String r6, String r7) {
        o.e(r6, "className");
        o.e(r7, "methodName");
        Class r0 = ZeusTransformUtils.forName(r6, "com.obric.aiagent.plugin");     // Catch: Exception -> L5
    L7:
        this(r6, r0, r7);
        return;
    L5:
        e = move-exception;
        Loog.INSTANCE.e(TAG, "Class not found: " + r6, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        r0 = null;
        goto L7
    }

    public final <T> T a(Object... r2) {
        o.e(r2, "args");
        return (T) b(null, Arrays.copyOf(r2, r2.length));
    }

    public final boolean b(Object... r2) {
        o.e(r2, "args");
        if (c(r2) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final <T> T a(Object r2, Object... r3) {
        o.e(r2, "instance");
        o.e(r3, "args");
        return (T) b(r2, Arrays.copyOf(r3, r3.length));
    }

    public final <T> T b(Object r4, Object... r5) {
        o.e(r5, "args");
        Method r0 = c(r5);
        if (r0 != null) goto L15;
        return null;
    L15:
    L12:
        e = move-exception;
        Loog.INSTANCE.e(TAG, "Failed to invoke method: " + this.f30363d, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return null;
    L6:
        if (r0.isAccessible() == true) goto L8;
        r0.setAccessible(true);     // Catch: Exception -> L12
    L8:
        T r3 = (T) r0.invoke(r4, Arrays.copyOf(r5, r5.length));
        if (r3 != null) goto L17;
        return null;
    L17:
        return r3;
    }

    private final synchronized Method c(Object[] r12) {
        monitor-enter(this);
        Method r0 = this.f30364e;     // Catch: Throwable -> L80
        if (r0 == null) goto L84;
        monitor-exit(this);
        return r0;
    L84:
        Class<?> r1 = this.f30362c;     // Catch: Exception -> L75 Throwable -> L80
        Method r2 = null;
        int r3 = 0;
        if (r1 == null) goto L56;
        Method[] r4 = r1.getDeclaredMethods();     // Catch: Exception -> L75 Throwable -> L80
        if (r4 == null) goto L56;
        Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L75 Throwable -> L80
        int r6 = r4.length;     // Catch: Exception -> L75 Throwable -> L80
        int r7 = 0;
    L12:
        if (r7 >= r6) goto L17;
        Method r8 = r4[r7];     // Catch: Exception -> L75 Throwable -> L80
        if (o.a(r8.getName(), this.f30363d) == false) goto L16;
        r5.add(r8);     // Catch: Exception -> L75 Throwable -> L80
    L16:
        r7 = r7 + 1;     // Catch: Exception -> L75 Throwable -> L80
        goto L12
    L17:
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L75 Throwable -> L80
        Collection r10 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L75 Throwable -> L80
        Iterator r11 = r9.iterator();     // Catch: Exception -> L75 Throwable -> L80
    L18:
        boolean r13 = true;
        if (r11.hasNext() == false) goto L26;
        Object r14 = r11.next();     // Catch: Exception -> L75 Throwable -> L80
        if (((Method) ZeusTransformUtils.preCheckCast(r14, Method.class, "com.obric.aiagent.plugin")).getParameterTypes().length == r12.length) goto L24;
        r13 = false;
    L24:
        if (r13 == false) goto L18;
        r10.add(r14);     // Catch: Exception -> L75 Throwable -> L80
        goto L18
    L26:
        Iterator r15 = ((List) ZeusTransformUtils.preCheckCast(r10, List.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Exception -> L75 Throwable -> L80
    L28:
        if (r15.hasNext() == false) goto L43;
        Method r16 = (Method) ZeusTransformUtils.preCheckCast(r15.next(), Method.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L75 Throwable -> L80
        Class<?>[] r17 = r16.getParameterTypes();     // Catch: Exception -> L75 Throwable -> L80
        int r18 = r17.length;     // Catch: Exception -> L75 Throwable -> L80
        int r19 = 0;
    L30:
        if (r19 >= r18) goto L40;
        Object r20 = r12[r19];     // Catch: Exception -> L75 Throwable -> L80
        Class<?> r21 = r17[r19];     // Catch: Exception -> L75 Throwable -> L80
        if (r20 == null) goto L34;
        a r110 = f30360a;     // Catch: Exception -> L75 Throwable -> L80
        o.a(r21);     // Catch: Exception -> L75 Throwable -> L80
        if (a.a(r110, r21, r20.getClass()) == true) goto L39;
    L35:
        boolean r22 = false;
    L41:
        if (r22 == false) goto L28;
        r2 = r16;
    L39:
        r19 = r19 + 1;     // Catch: Exception -> L75 Throwable -> L80
        goto L30
    L34:
        if (r21.isPrimitive() == false) goto L39;
    L40:
        r22 = true;
    L43:
        if (r2 == null) goto L45;
        this.f30364e = r2;     // Catch: Exception -> L75 Throwable -> L80
    L77:
        Method r111 = this.f30364e;     // Catch: Throwable -> L80
        monitor-exit(this);
        return r111;
    L45:
        Loog r23 = Loog.INSTANCE;     // Catch: Exception -> L75 Throwable -> L80
        StringBuilder r24 = new StringBuilder().append("Method not found: ").append(this.f30363d).append(" with args: ");     // Catch: Exception -> L75 Throwable -> L80
        Collection r25 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r12.length), Collection.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L75 Throwable -> L80
        int r26 = r12.length;     // Catch: Exception -> L75 Throwable -> L80
    L46:
        if (r3 >= r26) goto L55;
        Object r27 = r12[r3];     // Catch: Exception -> L75 Throwable -> L80
        if (r27 == null) goto L53;
        Class<?> r28 = r27.getClass();     // Catch: Exception -> L75 Throwable -> L80
        if (r28 == null) goto L53;
        String r29 = r28.getSimpleName();     // Catch: Exception -> L75 Throwable -> L80
        if (r29 == null) goto L53;
    L54:
        r25.add(r29);     // Catch: Exception -> L75 Throwable -> L80
        r3 = r3 + 1;     // Catch: Exception -> L75 Throwable -> L80
    L53:
        r29 = "null";
        goto L54
    L55:
        r23.e(TAG, r24.append((List) ZeusTransformUtils.preCheckCast(r25, List.class, "com.obric.aiagent.plugin")).toString());     // Catch: Exception -> L75 Throwable -> L80
    L56:
        c r30 = (c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L75 Throwable -> L80
        Loog r31 = Loog.INSTANCE;     // Catch: Exception -> L75 Throwable -> L80
        StringBuilder r32 = new StringBuilder().append("Method not found: ").append(r30.f30363d).append(" in class: ");     // Catch: Exception -> L75 Throwable -> L80
        String r33 = r30.f30361b;     // Catch: Exception -> L75 Throwable -> L80
        if (r33 != null) goto L62;
        Class<?> r34 = r30.f30362c;     // Catch: Exception -> L75 Throwable -> L80
        if (r34 == null) goto L61;
        r33 = r34.getSimpleName();     // Catch: Exception -> L75 Throwable -> L80
        goto L62
    L61:
        r33 = null;
    L62:
        StringBuilder r35 = r32.append(r33).append(" with args: ");     // Catch: Exception -> L75 Throwable -> L80
        Collection r36 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r12.length), Collection.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L75 Throwable -> L80
        int r37 = r12.length;     // Catch: Exception -> L75 Throwable -> L80
    L63:
        if (r3 >= r37) goto L72;
        Object r38 = r12[r3];     // Catch: Exception -> L75 Throwable -> L80
        if (r38 == null) goto L70;
        Class<?> r39 = r38.getClass();     // Catch: Exception -> L75 Throwable -> L80
        if (r39 == null) goto L70;
        String r40 = r39.getSimpleName();     // Catch: Exception -> L75 Throwable -> L80
        if (r40 == null) goto L70;
    L71:
        r36.add(r40);     // Catch: Exception -> L75 Throwable -> L80
        r3 = r3 + 1;     // Catch: Exception -> L75 Throwable -> L80
    L70:
        r40 = "null";
        goto L71
    L72:
        r31.e(TAG, r35.append((List) ZeusTransformUtils.preCheckCast(r36, List.class, "com.obric.aiagent.plugin")).toString());     // Catch: Exception -> L75 Throwable -> L80
        monitor-exit(this);
        return null;
    L75:
        e = move-exception;
        Loog.INSTANCE.e(TAG, "Error looking up method: " + this.f30363d, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L80
    L80:
        th = move-exception;
        throw th;
    }
}
