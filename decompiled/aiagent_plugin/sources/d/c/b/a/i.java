package d.c.b.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: DebugMetadata.kt */
/* JADX INFO: loaded from: classes4.dex */
final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f38410a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final a f38411b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static a f38412c;

    /* JADX INFO: compiled from: DebugMetadata.kt */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Method f38413a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Method f38414b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Method f38415c;

        public a(Method r1, Method r2, Method r3) {
            this.f38413a = r1;
            this.f38414b = r2;
            this.f38415c = r3;
        }
    }

    private i() {
    }

    static {
        f38410a = new i();
        f38411b = new a(null, null, null);
    }

    public final String a(d.c.b.a.a r5) {
        o.e(r5, "continuation");
        a r0 = f38412c;
        if (r0 != null) goto L6;
        r0 = b(r5);
    L6:
        if (r0 != f38411b) goto L8;
        return null;
    L8:
        Method r4 = r0.f38413a;
        if (r4 == null) goto L11;
        Object r6 = r4.invoke(r5.getClass(), new Object[0]);
    L12:
        if (r6 != null) goto L14;
        return null;
    L14:
        Method r7 = r0.f38414b;
        if (r7 == null) goto L17;
        Object r8 = r7.invoke(r6, new Object[0]);
    L18:
        if (r8 != null) goto L20;
        return null;
    L20:
        Method r9 = r0.f38415c;
        if (r9 == null) goto L23;
        Object r10 = r9.invoke(r8, new Object[0]);
    L25:
        if (ZeusTransformUtils.instanceOf(r10, String.class) == true) goto L27;
        return null;
    L27:
        return (String) ZeusTransformUtils.preCheckCast(r10, String.class, "com.obric.aiagent.plugin");
    L23:
        r10 = null;
        goto L25
    L17:
        r8 = null;
        goto L18
    L11:
        r6 = null;
        goto L12
    }

    private final a b(d.c.b.a.a r5) {
        a r1 = new a(Class.class.getDeclaredMethod("getModule", new Class[0]), r5.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", new Class[0]), r5.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", new Class[0]));     // Catch: Exception -> L4
        f38412c = r1;     // Catch: Exception -> L4
        return r1;
    L4:
        a r4 = f38411b;
        f38412c = r4;
        return r4;
    }
}
