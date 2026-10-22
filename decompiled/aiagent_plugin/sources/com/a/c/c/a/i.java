package com.a.c.c.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: FieldValueGeneratorFactory.java */
/* JADX INFO: loaded from: classes.dex */
public class i {
    public static h a(com.a.c.b.a r3) {
        com.a.c.b.c.e r0 = r3.b();
        if (ZeusTransformUtils.instanceOf(r0, com.a.c.b.c.a.class) == false) goto L7;
        return new a(r3);
    L7:
        if (ZeusTransformUtils.instanceOf(r0, com.a.c.b.c.b.class) == false) goto L11;
        return new c(r3);
    L11:
        if (ZeusTransformUtils.instanceOf(r0, com.a.c.b.c.c.class) == false) goto L15;
        return new e(r3);
    L15:
        if (ZeusTransformUtils.instanceOf(r0, com.a.c.b.c.d.class) == false) goto L19;
        return new g(r3);
    L19:
        if (ZeusTransformUtils.instanceOf(r0, com.a.c.b.c.f.class) == false) goto L27;
        com.a.c.b.c.f r1 = (com.a.c.b.c.f) ZeusTransformUtils.preCheckCast(r0, com.a.c.b.c.f.class, "com.obric.aiagent.plugin");
        if (com.a.c.b.d.c.f.equals(r1.f().b()) == false) goto L25;
        return new o(r3);
    L25:
        throw new IllegalArgumentException(String.format("Cannot create instance for On instance with %s value", new Object[]{r1.f()}));
    L27:
        return new k(r3);
    }

    public static h a(com.a.c.b.a r0, int r1) {
        return a(r0);
    }

    public static h a(com.a.c.b.a r3, int r4, int r5) {
        com.a.c.b.c.e r0 = r3.b();
        if (ZeusTransformUtils.instanceOf(r0, com.a.c.b.c.f.class) == false) goto L9;
        com.a.c.b.c.f r1 = (com.a.c.b.c.f) ZeusTransformUtils.preCheckCast(r0, com.a.c.b.c.f.class, "com.obric.aiagent.plugin");
        if (com.a.c.b.d.c.f.equals(r1.f().b()) == true) goto L9;
        return new m(r3, r4, r5);
    L9:
        return a(r3);
    }

    public static h a(com.a.c.b.a r2, int r3, int r4, com.a.b.b r5) {
        com.a.c.b.c.e r0 = r2.b();
        if (ZeusTransformUtils.instanceOf(r0, com.a.c.b.c.f.class) == false) goto L7;
        return new n(r2, r3, r4, r5);
    L7:
        if (ZeusTransformUtils.instanceOf(r0, com.a.c.b.c.c.class) == false) goto L11;
        return new d(r2, r3, r4, r5);
    L11:
        if (ZeusTransformUtils.instanceOf(r0, com.a.c.b.c.b.class) == false) goto L15;
        return new b(r2, r3, r4, r5);
    L15:
        if (ZeusTransformUtils.instanceOf(r0, com.a.c.b.c.d.class) == false) goto L19;
        return new f(r2, r3, r4, r5);
    L19:
        return a(r2);
    }

    public static h b(com.a.c.b.a r0) {
        return a(r0);
    }
}
