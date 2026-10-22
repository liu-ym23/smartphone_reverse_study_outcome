package kotlinx.coroutines.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.x;

/* JADX INFO: compiled from: Channel.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class g {
    public static /* synthetic */ d a(int r1, a r2, d.h.a.b r3, int r4, Object r5) {
        d.h.a.b r6 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
        if ((r4 & 1) == 0) goto L6;
        r1 = 0;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = a.f38771a;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r6 = null;
    L12:
        return a(r1, r2, r6);
    }

    public static final <E> d<E> a(int r4, a r5, d.h.a.b<? super E, x> r6) {
        d.h.a.b r7 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r6, d.h.a.b.class, "com.obric.aiagent.plugin");
        if (r4 == (-2)) goto L28;
        boolean r3 = false;
        if (r4 == (-1)) goto L21;
        if (r4 == 0) goto L16;
        if (r4 == Integer.MAX_VALUE) goto L34;
        if (r5 != a.f38771a) goto L12;
        b r8 = new b(r4, r7);
    L33:
        return (d) ZeusTransformUtils.preCheckCast(r8, d.class, "com.obric.aiagent.plugin");
    L12:
        r8 = (b) ZeusTransformUtils.preCheckCast(new n(r4, r5, r7), b.class, "com.obric.aiagent.plugin");
        goto L33
    L34:
        return (d) ZeusTransformUtils.preCheckCast(new b(Integer.MAX_VALUE, r7), d.class, "com.obric.aiagent.plugin");
    L16:
        if (r5 != a.f38771a) goto L18;
        b r9 = new b(0, r7);
    L35:
        return (d) ZeusTransformUtils.preCheckCast(r9, d.class, "com.obric.aiagent.plugin");
    L18:
        r9 = (b) ZeusTransformUtils.preCheckCast(new n(1, r5, r7), b.class, "com.obric.aiagent.plugin");
        goto L35
    L21:
        if (r5 != a.f38771a) goto L23;
        r3 = true;
    L23:
        if (r3 == false) goto L26;
        return (d) ZeusTransformUtils.preCheckCast(new n(1, a.f38772b, r7), d.class, "com.obric.aiagent.plugin");
    L26:
        throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow".toString());
    L28:
        if (r5 != a.f38771a) goto L30;
        b r10 = new b(d.f38805b.a(), r7);
    L32:
        return (d) ZeusTransformUtils.preCheckCast(r10, d.class, "com.obric.aiagent.plugin");
    L30:
        r10 = (b) ZeusTransformUtils.preCheckCast(new n(1, r5, r7), b.class, "com.obric.aiagent.plugin");
        goto L32
    }
}
