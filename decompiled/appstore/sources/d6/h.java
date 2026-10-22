package d6;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class h {
    public static Object a(Object r10, InvocationHandler r11) {
        List r12 = b(r10.getClass());
        if (r12 != null) goto L5;
    L7:
        Class[] r13 = new Class[0];
    L9:
        return Proxy.newProxyInstance(r10.getClass().getClassLoader(), r13, r11);
    L5:
        if (r12.size() <= 0) goto L7;
        r13 = (Class[]) r12.toArray(new Class[r12.size()]);
        goto L9
    }

    public static List b(Class r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        LinkedHashSet r11 = new LinkedHashSet();
        c(r10, r11);
        return new ArrayList(r11);
    }

    public static void c(Class r10, HashSet r11) {
    L2:
        if (r10 == null) goto L10;
        Class<?>[] r12 = r10.getInterfaces();
        int r13 = r12.length;
        int r14 = 0;
    L4:
        if (r14 >= r13) goto L9;
        Class<?> r15 = r12[r14];
        if (r11.add(r15) == false) goto L8;
        c(r15, r11);
    L8:
        r14 = r14 + 1;
        goto L4
    L9:
        r10 = r10.getSuperclass();
        goto L2
    }
}
