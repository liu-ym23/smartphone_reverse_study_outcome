package androidx.lifecycle;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: Lifecycling.kt */
/* JADX INFO: loaded from: classes.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t f2076a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<Class<?>, Integer> f2077b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Map<Class<?>, List<Constructor<? extends f>>> f2078c = null;

    private t() {
    }

    static {
        f2076a = new t();
        f2077b = (Map) ZeusTransformUtils.preCheckCast(new HashMap(), Map.class, "com.obric.aiagent.plugin");
        f2078c = (Map) ZeusTransformUtils.preCheckCast(new HashMap(), Map.class, "com.obric.aiagent.plugin");
    }

    public static final m a(Object r8) {
        d.h.b.o.e(r8, "object");
        boolean r0 = ZeusTransformUtils.instanceOf(r8, m.class);
        boolean r1 = ZeusTransformUtils.instanceOf(r8, d.class);
        if (r0 == false) goto L7;
        if (r1 == false) goto L7;
        return (m) ZeusTransformUtils.preCheckCast(new DefaultLifecycleObserverAdapter((d) ZeusTransformUtils.preCheckCast(r8, d.class, "com.obric.aiagent.plugin"), (m) ZeusTransformUtils.preCheckCast(r8, m.class, "com.obric.aiagent.plugin")), m.class, "com.obric.aiagent.plugin");
    L7:
        if (r1 == true) goto L9;
        if (r0 == true) goto L12;
        Class<?> r2 = r8.getClass();
        t r3 = f2076a;
        if (r3.b(r2) != 2) goto L25;
        List<Constructor<? extends f>> r4 = f2078c.get(r2);
        d.h.b.o.a(r4);
        List r5 = (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.aiagent.plugin");
        int r6 = 0;
        if (r5.size() == 1) goto L18;
        int r7 = r5.size();
        f[] r9 = new f[r7];
    L20:
        if (r6 >= r7) goto L23;
        r9[r6] = f2076a.a((Constructor) ZeusTransformUtils.preCheckCast(r5.get(r6), Constructor.class, "com.obric.aiagent.plugin"), r8);
        r6 = r6 + 1;
        goto L20
    L23:
        return (m) ZeusTransformUtils.preCheckCast(new CompositeGeneratedAdaptersObserver(r9), m.class, "com.obric.aiagent.plugin");
    L18:
        return (m) ZeusTransformUtils.preCheckCast(new SingleGeneratedAdapterObserver(r3.a((Constructor) ZeusTransformUtils.preCheckCast(r5.get(0), Constructor.class, "com.obric.aiagent.plugin"), r8)), m.class, "com.obric.aiagent.plugin");
    L25:
        return (m) ZeusTransformUtils.preCheckCast(new ReflectiveGenericLifecycleObserver(r8), m.class, "com.obric.aiagent.plugin");
    L12:
        return (m) ZeusTransformUtils.preCheckCast(r8, m.class, "com.obric.aiagent.plugin");
    L9:
        return (m) ZeusTransformUtils.preCheckCast(new DefaultLifecycleObserverAdapter((d) ZeusTransformUtils.preCheckCast(r8, d.class, "com.obric.aiagent.plugin"), null), m.class, "com.obric.aiagent.plugin");
    }

    private final f a(Constructor<? extends f> r3, Object r4) {
        f r5 = r3.newInstance(new Object[]{r4});     // Catch: InvocationTargetException -> L5 InstantiationException -> L8 IllegalAccessException -> L11
        d.h.b.o.c(r5, "{\n            constructo…tance(`object`)\n        }");     // Catch: InvocationTargetException -> L5 InstantiationException -> L8 IllegalAccessException -> L11
        return (f) ZeusTransformUtils.preCheckCast(r5, f.class, "com.obric.aiagent.plugin");
    L11:
        e = move-exception;
        throw new RuntimeException((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    L8:
        e = move-exception;
        throw new RuntimeException((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    L5:
        e = move-exception;
        throw new RuntimeException((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    }

    private final Constructor<? extends f> a(Class<?> r6) {
        Package r0 = r6.getPackage();     // Catch: NoSuchMethodException -> L25 ClassNotFoundException -> L28
        String r1 = r6.getCanonicalName();     // Catch: NoSuchMethodException -> L25 ClassNotFoundException -> L28
        if (r0 == null) goto L6;
        String r2 = r0.getName();     // Catch: NoSuchMethodException -> L25 ClassNotFoundException -> L28
    L7:
        d.h.b.o.c(r2, "fullPackage");     // Catch: NoSuchMethodException -> L25 ClassNotFoundException -> L28
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L10;
        boolean r3 = true;
    L11:
        if (r3 == true) goto L14;
        d.h.b.o.c(r1, "name");     // Catch: NoSuchMethodException -> L25 ClassNotFoundException -> L28
        r1 = r1.substring(r2.length() + 1);     // Catch: NoSuchMethodException -> L25 ClassNotFoundException -> L28
        d.h.b.o.c(r1, "this as java.lang.String).substring(startIndex)");     // Catch: NoSuchMethodException -> L25 ClassNotFoundException -> L28
    L14:
        d.h.b.o.c(r1, "if (fullPackage.isEmpty(…g(fullPackage.length + 1)");     // Catch: NoSuchMethodException -> L25 ClassNotFoundException -> L28
        String r4 = a(r1);     // Catch: NoSuchMethodException -> L25 ClassNotFoundException -> L28
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L17;
        boolean r5 = true;
    L18:
        if (r5 == true) goto L21;
        r4 = r2 + '.' + r4;     // Catch: NoSuchMethodException -> L25 ClassNotFoundException -> L28
    L21:
        Class r7 = ZeusTransformUtils.forName(r4, "com.obric.aiagent.plugin");     // Catch: NoSuchMethodException -> L25 ClassNotFoundException -> L28
        d.h.b.o.a(r7, "null cannot be cast to non-null type java.lang.Class<out androidx.lifecycle.GeneratedAdapter>");     // Catch: NoSuchMethodException -> L25 ClassNotFoundException -> L28
        Constructor<? extends f> r8 = r7.getDeclaredConstructor(new Class[]{r6});     // Catch: NoSuchMethodException -> L25 ClassNotFoundException -> L28
        if (r8.isAccessible() == true) goto L32;
        r8.setAccessible(true);     // Catch: NoSuchMethodException -> L25 ClassNotFoundException -> L28
    L33:
        return r8;
    L32:
        return r8;
    L17:
        r5 = false;
        goto L18
    L10:
        r3 = false;
        goto L11
    L6:
        r2 = "";
    L28:
        return null;
    L25:
        e = move-exception;
        throw new RuntimeException((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    }

    private final int b(Class<?> r5) {
        Map<Class<?>, Integer> r0 = f2077b;
        Integer r1 = (Integer) ZeusTransformUtils.preCheckCast(r0.get(r5), Integer.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L5;
        int r4 = c(r5);
        r0.put(r5, Integer.valueOf(r4));
        return r4;
    L5:
        return r1.intValue();
    }

    private final int c(Class<?> r10) {
        if (r10.getCanonicalName() != null) goto L5;
        return 1;
    L5:
        Constructor<? extends f> r0 = a(r10);
        if (r0 == null) goto L10;
        f2078c.put(r10, d.a.p.a(r0));
        return 2;
    L10:
        if (b.f2038a.a(r10) == false) goto L12;
        return 1;
    L12:
        Class<? super Object> r1 = r10.getSuperclass();
        List<Constructor<? extends f>> r3 = null;
        if (d(r1) == false) goto L18;
        d.h.b.o.c(r1, "superclass");
        if (b(r1) != 1) goto L17;
        return 1;
    L17:
        List<Constructor<? extends f>> r2 = f2078c.get(r1);
        d.h.b.o.a(r2);
        r3 = (List) ZeusTransformUtils.preCheckCast(new ArrayList((Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.aiagent.plugin")), List.class, "com.obric.aiagent.plugin");
    L18:
        Class<?>[] r4 = r10.getInterfaces();
        d.h.b.o.c(r4, "klass.interfaces");
        int r5 = 0;
        int r6 = r4.length;
    L19:
        if (r5 >= r6) goto L30;
        Class<?> r7 = r4[r5];
        if (d(r7) == false) goto L29;
        d.h.b.o.c(r7, "intrface");
        if (b(r7) == 1) goto L25;
        if (r3 != null) goto L28;
        r3 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
    L28:
        List<Constructor<? extends f>> r8 = f2078c.get(r7);
        d.h.b.o.a(r8);
        r3.addAll((Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, "com.obric.aiagent.plugin"));
        goto L29
    L25:
        return 1;
    L29:
        r5 = r5 + 1;
        goto L19
    L30:
        if (r3 == null) goto L33;
        f2078c.put(r10, r3);
        return 2;
    L33:
        return 1;
    }

    private final boolean d(Class<?> r1) {
        if (r1 != null) goto L4;
    L6:
        return false;
    L4:
        if (o.class.isAssignableFrom(r1) == false) goto L6;
        return true;
    }

    public static final String a(String r7) {
        d.h.b.o.e(r7, "className");
        return d.o.o.a(r7, ".", "_", false, 4, null) + "_LifecycleAdapter";
    }
}
