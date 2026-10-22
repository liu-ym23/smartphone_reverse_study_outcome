package kotlinx.coroutines.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SharedFlow.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ad {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final kotlinx.coroutines.internal.al f38969a = null;

    public static final /* synthetic */ Object a(Object[] r0, long r1) {
        return b(r0, r1);
    }

    public static final /* synthetic */ void a(Object[] r0, long r1, Object r3) {
        b(r0, r1, r3);
    }

    public static /* synthetic */ w a(int r1, int r2, kotlinx.coroutines.a.a r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = 0;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = 0;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = kotlinx.coroutines.a.a.f38771a;
    L12:
        return a(r1, r2, r3);
    }

    public static final <T> w<T> a(int r3, int r4, kotlinx.coroutines.a.a r5) {
        boolean r0 = true;
        if (r3 < 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L28;
        if (r4 < 0) goto L9;
        boolean r6 = true;
    L10:
        if (r6 == false) goto L26;
        if (r3 > 0) goto L17;
        if (r4 > 0) goto L17;
        if (r5 == kotlinx.coroutines.a.a.f38771a) goto L17;
        r0 = false;
    L17:
        if (r0 == false) goto L24;
        int r7 = r4 + r3;
        if (r7 >= 0) goto L22;
        r7 = Integer.MAX_VALUE;
    L22:
        return (w) ZeusTransformUtils.preCheckCast(new ac(r3, r7, r5), w.class, "com.obric.aiagent.plugin");
    L24:
        throw new IllegalArgumentException(("replay or extraBufferCapacity must be positive with non-default onBufferOverflow strategy " + r5).toString());
    L26:
        throw new IllegalArgumentException(("extraBufferCapacity cannot be negative, but was " + r4).toString());
    L9:
        r6 = false;
        goto L10
    L28:
        throw new IllegalArgumentException(("replay cannot be negative, but was " + r3).toString());
    L5:
        r2 = false;
        goto L6
    }

    static {
        f38969a = new kotlinx.coroutines.internal.al("NO_VALUE");
    }

    private static final Object b(Object[] r0, long r1) {
        return r0[((int) r1) & (r0.length - 1)];
    }

    private static final void b(Object[] r0, long r1, Object r3) {
        r0[((int) r1) & (r0.length - 1)] = r3;
    }

    public static final <T> h<T> a(ab<? extends T> r3, d.c.g r4, int r5, kotlinx.coroutines.a.a r6) {
        ab r7 = (ab) ZeusTransformUtils.wrapperContextForParams(r3, ab.class, "com.obric.aiagent.plugin");
        d.c.g r8 = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r4, d.c.g.class, "com.obric.aiagent.plugin");
        if (r5 == 0) goto L7;
        if (r5 == (-3)) goto L7;
    L11:
        return (h) ZeusTransformUtils.preCheckCast(new kotlinx.coroutines.b.a.h((h) ZeusTransformUtils.preCheckCast(r7, h.class, "com.obric.aiagent.plugin"), r8, r5, r6), h.class, "com.obric.aiagent.plugin");
    L7:
        if (r6 != kotlinx.coroutines.a.a.f38771a) goto L11;
        return (h) ZeusTransformUtils.preCheckCast(r7, h.class, "com.obric.aiagent.plugin");
    }
}
