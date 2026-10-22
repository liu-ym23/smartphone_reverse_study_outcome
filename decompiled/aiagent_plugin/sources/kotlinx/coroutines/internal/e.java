package kotlinx.coroutines.internal;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ConcurrentLinkedList.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final al f39391a = null;

    public static final /* synthetic */ al a() {
        return f39391a;
    }

    public static final <S extends ai<S>> Object a(S r6, long r7, d.h.a.m<? super Long, ? super S, ? extends S> r9) {
        d.h.a.m r10 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r9, d.h.a.m.class, "com.obric.aiagent.plugin");
    L4:
        if (r6.f39364a >= r7) goto L6;
    L10:
        Object r0 = f.b((f) ZeusTransformUtils.preCheckCast(r6, f.class, "com.obric.aiagent.plugin"));
        if (r0 == a()) goto L13;
        ai r1 = (ai) ZeusTransformUtils.preCheckCast((f) ZeusTransformUtils.preCheckCast(r0, f.class, "com.obric.aiagent.plugin"), ai.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L16;
        r1 = (ai) ZeusTransformUtils.preCheckCast(r10.invoke(Long.valueOf(r6.f39364a + 1), r6), ai.class, "com.obric.aiagent.plugin");
        if (r6.a((f) ZeusTransformUtils.preCheckCast(r1, f.class, "com.obric.aiagent.plugin")) == false) goto L4;
        if (r6.h() == false) goto L16;
        r6.i();
    L16:
        r6 = (S) r1;
        goto L4
    L13:
        return aj.e(f39391a);
    L6:
        if (r6.h() == true) goto L10;
        return aj.e(r6);
    }

    static {
        f39391a = new al("CLOSED");
    }

    public static final <N extends f<N>> N a(N r3) {
    L2:
        Object r0 = f.b(r3);
        if (r0 == a()) goto L4;
        f r1 = (f) ZeusTransformUtils.preCheckCast(r0, f.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L8;
        r3 = (N) r1;
        goto L2
    L8:
        if (r3.g() == false) goto L2;
        return r3;
    L4:
        return r3;
    }
}
