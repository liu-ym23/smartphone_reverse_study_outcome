package tf;

import java.lang.reflect.Method;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f24805a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f24806b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static a f24807c;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Method f24808a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Method f24809b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Method f24810c;

        public a(Method r10, Method r11, Method r12) {
            this.f24808a = r10;
            this.f24809b = r11;
            this.f24810c = r12;
        }
    }

    static {
        f24805a = new e();
        f24806b = new a(null, null, null);
    }

    public e() {
    }

    public final a a(BaseContinuationImpl r10) {
        a r11 = new a(Class.class.getDeclaredMethod("getModule", null), r10.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", null), r10.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", null));     // Catch: Exception -> L4
        f24807c = r11;     // Catch: Exception -> L4
        return r11;
    L4:
        a r12 = f24806b;
        f24807c = r12;
        return r12;
    }

    public final String b(BaseContinuationImpl r10) {
        q.g(r10, "continuation");
        a r11 = f24807c;
        if (r11 != null) goto L6;
        r11 = a(r10);
    L6:
        if (r11 != f24806b) goto L8;
        return null;
    L8:
        Method r12 = r11.f24808a;
        if (r12 == null) goto L11;
        Object r13 = r12.invoke(r10.getClass(), null);
    L12:
        if (r13 != null) goto L14;
        return null;
    L14:
        Method r14 = r11.f24809b;
        if (r14 == null) goto L17;
        Object r15 = r14.invoke(r13, null);
    L18:
        if (r15 != null) goto L20;
        return null;
    L20:
        Method r16 = r11.f24810c;
        if (r16 == null) goto L23;
        Object r17 = r16.invoke(r15, null);
    L25:
        if ((r17 instanceof String) == true) goto L27;
        return null;
    L27:
        return (String) r17;
    L23:
        r17 = null;
        goto L25
    L17:
        r15 = null;
        goto L18
    L11:
        r13 = null;
        goto L12
    }
}
