package kotlinx.coroutines;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: DebugStrings.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ar {
    public static final String a(Object r0) {
        return Integer.toHexString(System.identityHashCode(r0));
    }

    public static final String a(d.c.d<?> r4) {
        d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r5, kotlinx.coroutines.internal.m.class) == false) goto L16;
        return r5.toString();
    L16:
        d.n.a r2 = d.n.f38560a;     // Catch: Throwable -> L8
        Object r3 = d.n.f(r5 + '@' + a(r5));     // Catch: Throwable -> L8
    L11:
        if (d.n.c(r3) == null) goto L15;
        r3 = r5.getClass().getName() + '@' + a(r5);
    L15:
        return (String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin");
    L8:
        th = move-exception;
        d.n.a r6 = d.n.f38560a;
        r3 = d.n.f(d.o.a(th));
        goto L11
    }

    public static final String b(Object r0) {
        return r0.getClass().getSimpleName();
    }
}
