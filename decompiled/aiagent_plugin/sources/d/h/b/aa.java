package d.h.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: Reflection.java */
/* JADX INFO: loaded from: classes4.dex */
public class aa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ab f38482a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final d.m.c[] f38483b = null;

    static {
        ab r1 = null;
        r1 = (ab) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl", "com.obric.aiagent.plugin").newInstance(), ab.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L10
    L5:
        if (r1 != null) goto L8;
        r1 = new ab();
    L8:
        f38482a = r1;
        f38483b = new d.m.c[0];
    }

    public static d.m.d a(Class r2) {
        return f38482a.a(r2, "");
    }

    public static d.m.c b(Class r1) {
        return f38482a.a(r1);
    }

    public static String a(p r1) {
        return f38482a.a(r1);
    }

    public static String a(j r2) {
        j r3 = (j) ZeusTransformUtils.wrapperContextForParams(r2, j.class, "com.obric.aiagent.plugin");
        return f38482a.a(r3);
    }

    public static d.m.e a(k r1) {
        return f38482a.a(r1);
    }

    public static d.m.i a(v r1) {
        return f38482a.a(r1);
    }

    public static d.m.j a(x r1) {
        return f38482a.a(r1);
    }

    public static d.m.g a(r r1) {
        return f38482a.a(r1);
    }
}
