package kotlinx.coroutines.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlinx.coroutines.ca;

/* JADX INFO: compiled from: Context.kt */
/* JADX INFO: loaded from: classes4.dex */
final /* synthetic */ class n {
    public static /* synthetic */ h a(h r1, int r2, kotlinx.coroutines.a.a r3, int r4, Object r5) {
        h r6 = (h) ZeusTransformUtils.wrapperContextForParams(r1, h.class, "com.obric.aiagent.plugin");
        if ((r4 & 1) == 0) goto L6;
        r2 = -2;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r3 = kotlinx.coroutines.a.a.f38771a;
    L9:
        return j.a(r6, r2, r3);
    }

    public static final <T> h<T> a(h<? extends T> r10, int r11, kotlinx.coroutines.a.a r12) {
        h r3 = (h) ZeusTransformUtils.wrapperContextForParams(r10, h.class, "com.obric.aiagent.plugin");
        boolean r13 = true;
        if (r11 < 0) goto L5;
    L9:
        boolean r4 = true;
    L10:
        if (r4 == false) goto L28;
        if (r11 == (-1)) goto L13;
    L16:
        if (r13 == false) goto L26;
        if (r11 != (-1)) goto L19;
        kotlinx.coroutines.a.a r7 = kotlinx.coroutines.a.a.f38772b;
        int r6 = 0;
    L21:
        if (ZeusTransformUtils.instanceOf(r3, kotlinx.coroutines.b.a.q.class) == false) goto L24;
        return kotlinx.coroutines.b.a.q.a.a((kotlinx.coroutines.b.a.q) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.b.a.q.class, "com.obric.aiagent.plugin"), null, r6, r7, 1, null);
    L24:
        return (h) ZeusTransformUtils.preCheckCast(new kotlinx.coroutines.b.a.h(r3, null, r6, r7, 2, null), h.class, "com.obric.aiagent.plugin");
    L19:
        r6 = r11;
        r7 = r12;
        goto L21
    L26:
        throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow".toString());
    L13:
        if (r12 == kotlinx.coroutines.a.a.f38771a) goto L16;
        r13 = false;
        goto L16
    L28:
        throw new IllegalArgumentException(("Buffer size should be non-negative, BUFFERED, or CONFLATED, but was " + r11).toString());
    L5:
        if (r11 == (-2)) goto L9;
        if (r11 == (-1)) goto L9;
        r4 = false;
        goto L10
    }

    public static final <T> h<T> a(h<? extends T> r3) {
        return j.a((h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.aiagent.plugin"), -1, null, 2, null);
    }

    public static final <T> h<T> a(h<? extends T> r10, d.c.g r11) {
        h<T> r3 = (h) ZeusTransformUtils.wrapperContextForParams(r10, h.class, "com.obric.aiagent.plugin");
        d.c.g r5 = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r11, d.c.g.class, "com.obric.aiagent.plugin");
        a(r5);
        if (d.h.b.o.a(r5, d.c.h.f38423a) == false) goto L6;
        return r3;
    L6:
        if (ZeusTransformUtils.instanceOf(r3, kotlinx.coroutines.b.a.q.class) == false) goto L9;
        return kotlinx.coroutines.b.a.q.a.a((kotlinx.coroutines.b.a.q) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.b.a.q.class, "com.obric.aiagent.plugin"), r5, 0, null, 6, null);
    L9:
        return (h) ZeusTransformUtils.preCheckCast(new kotlinx.coroutines.b.a.h(r3, r5, 0, null, 12, null), h.class, "com.obric.aiagent.plugin");
    }

    private static final void a(d.c.g r3) {
        d.c.g r4 = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r3, d.c.g.class, "com.obric.aiagent.plugin");
        if (r4.get((d.c.g.c) ZeusTransformUtils.preCheckCast(ca.f39180a, d.c.g.c.class, "com.obric.aiagent.plugin")) != null) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return;
    L9:
        throw new IllegalArgumentException(("Flow context cannot contain job in it. Had " + r4).toString());
    L5:
        r0 = false;
        goto L6
    }
}
