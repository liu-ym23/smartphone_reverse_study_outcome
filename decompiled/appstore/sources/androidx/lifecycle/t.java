package androidx.lifecycle;

import com.bytedance.librarian.LibrarianImpl;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t f3568a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map f3569b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map f3570c = null;

    static {
        f3568a = new t();
        f3569b = new HashMap();
        f3570c = new HashMap();
    }

    public t() {
    }

    public static final String c(String r10) {
        kotlin.jvm.internal.q.g(r10, "className");
        return kotlin.text.o.x(r10, LibrarianImpl.Constants.DOT, "_", false, 4, null) + "_LifecycleAdapter";
    }

    public static final LifecycleEventObserver f(Object r10) {
        kotlin.jvm.internal.q.g(r10, "object");
        boolean r11 = r10 instanceof LifecycleEventObserver;
        boolean r12 = r10 instanceof DefaultLifecycleObserver;
        if (r11 == false) goto L7;
        if (r12 == false) goto L7;
        return new f((DefaultLifecycleObserver) r10, (LifecycleEventObserver) r10);
    L7:
        if (r12 == true) goto L9;
        if (r11 == true) goto L12;
        Class<?> r13 = r10.getClass();
        t r14 = f3568a;
        if (r14.d(r13) != 2) goto L25;
        Object r15 = f3570c.get(r13);
        kotlin.jvm.internal.q.d(r15);
        List r16 = (List) r15;
        int r17 = 0;
        if (r16.size() == 1) goto L18;
        int r18 = r16.size();
        GeneratedAdapter[] r19 = new GeneratedAdapter[r18];
    L20:
        if (r17 >= r18) goto L23;
        r19[r17] = f3568a.a((Constructor) r16.get(r17), r10);
        r17 = r17 + 1;
        goto L20
    L23:
        return new e(r19);
    L18:
        return new j0(r14.a((Constructor) r16.get(0), r10));
    L25:
        return new z(r10);
    L12:
        return (LifecycleEventObserver) r10;
    L9:
        return new f((DefaultLifecycleObserver) r10, null);
    }

    public final GeneratedAdapter a(Constructor r10, Object r11) {
        Object r12 = r10.newInstance(new Object[]{r11});     // Catch: InvocationTargetException -> L4 InstantiationException -> L6 IllegalAccessException -> L8
        kotlin.jvm.internal.q.f(r12, "{\n            constructo…tance(`object`)\n        }");     // Catch: InvocationTargetException -> L4 InstantiationException -> L6 IllegalAccessException -> L8
        return (GeneratedAdapter) r12;
    L8:
        e = move-exception;
        throw new RuntimeException(e);
    L6:
        e = move-exception;
        throw new RuntimeException(e);
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public final Constructor b(Class r10) {
        Package r11 = r10.getPackage();     // Catch: NoSuchMethodException -> L5 ClassNotFoundException -> L22
        String r12 = r10.getCanonicalName();     // Catch: NoSuchMethodException -> L5 ClassNotFoundException -> L22
        if (r11 == null) goto L7;
        String r13 = r11.getName();     // Catch: NoSuchMethodException -> L5 ClassNotFoundException -> L22
    L8:
        kotlin.jvm.internal.q.f(r13, "fullPackage");     // Catch: NoSuchMethodException -> L5 ClassNotFoundException -> L22
        if (r13.length() == 0) goto L12;
        kotlin.jvm.internal.q.f(r12, "name");     // Catch: NoSuchMethodException -> L5 ClassNotFoundException -> L22
        r12 = r12.substring(r13.length() + 1);     // Catch: NoSuchMethodException -> L5 ClassNotFoundException -> L22
        kotlin.jvm.internal.q.f(r12, "this as java.lang.String).substring(startIndex)");     // Catch: NoSuchMethodException -> L5 ClassNotFoundException -> L22
    L12:
        kotlin.jvm.internal.q.f(r12, "if (fullPackage.isEmpty(…g(fullPackage.length + 1)");     // Catch: NoSuchMethodException -> L5 ClassNotFoundException -> L22
        String r14 = c(r12);     // Catch: NoSuchMethodException -> L5 ClassNotFoundException -> L22
        if (r13.length() == 0) goto L16;
        r14 = r13 + '.' + r14;     // Catch: NoSuchMethodException -> L5 ClassNotFoundException -> L22
    L16:
        Class<?> r15 = Class.forName(r14);     // Catch: NoSuchMethodException -> L5 ClassNotFoundException -> L22
        kotlin.jvm.internal.q.e(r15, "null cannot be cast to non-null type java.lang.Class<out androidx.lifecycle.GeneratedAdapter>");     // Catch: NoSuchMethodException -> L5 ClassNotFoundException -> L22
        Constructor<?> r16 = r15.getDeclaredConstructor(new Class[]{r10});     // Catch: NoSuchMethodException -> L5 ClassNotFoundException -> L22
        if (r16.isAccessible() == true) goto L26;
        r16.setAccessible(true);     // Catch: NoSuchMethodException -> L5 ClassNotFoundException -> L22
    L27:
        return r16;
    L26:
        return r16;
    L7:
        r13 = "";
    L22:
        return null;
    L5:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public final int d(Class r10) {
        Map r11 = f3569b;
        Integer r12 = (Integer) r11.get(r10);
        if (r12 != null) goto L5;
        int r13 = g(r10);
        r11.put(r10, Integer.valueOf(r13));
        return r13;
    L5:
        return r12.intValue();
    }

    public final boolean e(Class r10) {
        if (r10 != null) goto L4;
    L6:
        return false;
    L4:
        if (LifecycleObserver.class.isAssignableFrom(r10) == false) goto L6;
        return true;
    }

    public final int g(Class r10) {
        if (r10.getCanonicalName() != null) goto L5;
        return 1;
    L5:
        Constructor r11 = b(r10);
        if (r11 == null) goto L10;
        f3570c.put(r10, kotlin.collections.s.e(r11));
        return 2;
    L10:
        if (c.f3507c.d(r10) == false) goto L12;
        return 1;
    L12:
        Class r12 = r10.getSuperclass();
        if (e(r12) == false) goto L18;
        kotlin.jvm.internal.q.f(r12, "superclass");
        if (d(r12) != 1) goto L17;
        return 1;
    L17:
        Object r13 = f3570c.get(r12);
        kotlin.jvm.internal.q.d(r13);
        ArrayList r14 = new ArrayList((Collection) r13);
    L19:
        Class<?>[] r15 = r10.getInterfaces();
        kotlin.jvm.internal.q.f(r15, "klass.interfaces");
        int r16 = r15.length;
        int r17 = 0;
    L20:
        if (r17 >= r16) goto L31;
        Class<?> r18 = r15[r17];
        if (e(r18) == false) goto L30;
        kotlin.jvm.internal.q.f(r18, "intrface");
        if (d(r18) == 1) goto L26;
        if (r14 != null) goto L29;
        r14 = new ArrayList();
    L29:
        Object r19 = f3570c.get(r18);
        kotlin.jvm.internal.q.d(r19);
        r14.addAll((Collection) r19);
        goto L30
    L26:
        return 1;
    L30:
        r17 = r17 + 1;
        goto L20
    L31:
        if (r14 == null) goto L34;
        f3570c.put(r10, r14);
        return 2;
    L34:
        return 1;
    L18:
        r14 = null;
        goto L19
    }
}
