package w5;

import com.bytedance.platform.godzilla.common.Logger;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class c extends b implements InvocationHandler {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Map f25364e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Map f25365f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HashMap f25366a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f25367b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f25368c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f25369d;

    static {
        f25364e = new HashMap();
        HashMap r10 = new HashMap();
        f25365f = r10;
        r10.put(Boolean.class, Boolean.TYPE);
        r10.put(Byte.class, Byte.TYPE);
        r10.put(Character.class, Character.TYPE);
        r10.put(Short.class, Short.TYPE);
        r10.put(Integer.class, Integer.TYPE);
        r10.put(Long.class, Long.TYPE);
        r10.put(Double.class, Double.TYPE);
        r10.put(Float.class, Float.TYPE);
    }

    public c() {
        this.f25366a = new HashMap();
        this.f25368c = true;
    }

    public static void c(String r10, b r11) {
        f25364e.put(r10, r11);
    }

    @Override // w5.b
    public Object a(Object r10, Method r11, Object[] r12, Object r13) {
        b r14 = d(r11.getName());
        if (r14 == null) goto L6;
        return r14.a(r10, r11, r12, r13);
    L6:
        return super.a(r10, r11, r12, r13);
    }

    @Override // w5.b
    public Object b(Object r10, Method r11, Object[] r12) {
        b r13 = d(r11.getName());
        if (r13 == null) goto L6;
        return r13.b(r10, r11, r12);
    L6:
        return super.b(r10, r11, r12);
    }

    public b d(String r10) {
        b r11 = (b) f25364e.get(r10);
        if (r11 == null) goto L5;
        return r11;
    L5:
        return (b) this.f25366a.get(r10);
    }

    public Object e() {
        return this.f25367b;
    }

    public final Object f(Method r10, Object r11) {
        if (r11 == null) goto L4;
        return r11;
    L4:
        Class<?> r12 = r10.getReturnType();
        if (r12 != null) goto L7;
        return null;
    L7:
        if (r12.isPrimitive() == true) goto L12;
        r12 = (Class) f25365f.get(r12);
        if (r12 != null) goto L12;
        return null;
    L12:
        if (r12 != Boolean.TYPE) goto L16;
        return Boolean.FALSE;
    L16:
        if (r12 != Void.TYPE) goto L19;
        return new Object();
    L19:
        return 0;
    }

    public boolean g(Method r10) {
        return true;
    }

    public void h(Object r10) {
        this.f25369d = true;
        this.f25367b = r10;
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object r10, Method r11, Object[] r12) {
        if (this.f25369d == false) goto L31;
        if (r11.isAccessible() == true) goto L8;
        r11.setAccessible(true);
    L8:
        if (this.f25368c == false) goto L10;
        Object r13 = b(this.f25367b, r11, r12);     // Catch: Throwable -> L13
    L15:
        if (r13 == null) goto L36;
    L34:
        r13 = a(this.f25367b, r11, r12, r13);     // Catch: Throwable -> L26
    L29:
        return f(r11, r13);
    L26:
        th = move-exception;
        Logger.c("afterInvokeError.", th.toString());
        goto L29
    L36:
        r13 = r11.invoke(this.f25367b, r12);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        if (g(r11) == false) goto L23;
        Logger.c("MethodProxyError.", th.toString());
        goto L34
    L23:
        throw new RuntimeException(th);
    L13:
        th = move-exception;
        Logger.c("beforeInvoke", th.toString());
        r13 = null;
        goto L15
    L10:
        return r11.invoke(this.f25367b, r12);
    L31:
        throw new IllegalStateException("setTarget must be invoked before this invoke");
    }
}
