package kotlinx.coroutines.b.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlinx.coroutines.ca;
import kotlinx.coroutines.internal.ah;

/* JADX INFO: compiled from: SafeCollector.common.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class w {

    /* JADX INFO: compiled from: SafeCollector.common.kt */
    static final class a extends d.h.b.p implements d.h.a.m<Integer, d.c.g.b, Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ u<?> f38949a;

        a(u<?> r1) {
            this.f38949a = r1;
            super(2);
        }

        @Override // d.h.a.m
        public /* synthetic */ Integer invoke(Integer r3, d.c.g.b r4) {
            return a(((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.aiagent.plugin")).intValue(), (d.c.g.b) ZeusTransformUtils.preCheckCast(r4, d.c.g.b.class, "com.obric.aiagent.plugin"));
        }

        public final Integer a(int r4, d.c.g.b r5) {
            d.c.g.b r6 = (d.c.g.b) ZeusTransformUtils.wrapperContextForParams(r5, d.c.g.b.class, "com.obric.aiagent.plugin");
            d.c.g.c<?> r0 = r6.getKey();
            d.c.g.b r3 = this.f38949a.f38942b.get(r0);
            if (r0 == ca.f39180a) goto L9;
            if (r6 == r3) goto L6;
            int r7 = Integer.MIN_VALUE;
        L8:
            return Integer.valueOf(r7);
        L6:
            r7 = r4 + 1;
            goto L8
        L9:
            ca r8 = (ca) ZeusTransformUtils.preCheckCast(r3, ca.class, "com.obric.aiagent.plugin");
            d.h.b.o.a(r6, "null cannot be cast to non-null type kotlinx.coroutines.Job");
            ca r9 = w.a((ca) ZeusTransformUtils.preCheckCast(r6, ca.class, "com.obric.aiagent.plugin"), r8);
            if (r9 != r8) goto L17;
            if (r8 == null) goto L15;
            r4 = r4 + 1;
        L15:
            return Integer.valueOf(r4);
        L17:
            throw new IllegalStateException(("Flow invariant is violated:\n\t\tEmission from another coroutine is detected.\n\t\tChild of " + r9 + ", expected child of " + r8 + ".\n\t\tFlowCollector is not thread-safe and concurrent emissions are prohibited.\n\t\tTo mitigate this restriction please use 'channelFlow' builder instead of 'flow'").toString());
        }
    }

    public static final void a(u<?> r4, d.c.g r5) {
        d.c.g r6 = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r5, d.c.g.class, "com.obric.aiagent.plugin");
        if (((Number) ZeusTransformUtils.preCheckCast(r6.fold(0, (d.h.a.m) ZeusTransformUtils.preCheckCast(new a(r4), d.h.a.m.class, "com.obric.aiagent.plugin")), Number.class, "com.obric.aiagent.plugin")).intValue() != r4.f38943c) goto L6;
        return;
    L6:
        throw new IllegalStateException(("Flow invariant is violated:\n\t\tFlow was collected in " + r4.f38942b + ",\n\t\tbut emission happened in " + r6 + ".\n\t\tPlease refer to 'flow' documentation or use 'flowOn' instead").toString());
    }

    public static final ca a(ca r2, ca r3) {
        ca r4 = (ca) ZeusTransformUtils.wrapperContextForParams(r2, ca.class, "com.obric.aiagent.plugin");
        ca r5 = (ca) ZeusTransformUtils.wrapperContextForParams(r3, ca.class, "com.obric.aiagent.plugin");
    L3:
        if (r4 == null) goto L4;
        if (r4 == r5) goto L7;
        if (ZeusTransformUtils.instanceOf(r4, ah.class) == false) goto L10;
        r4 = r4.h();
        goto L3
    L10:
        return r4;
    L7:
        return r4;
    L4:
        return null;
    }
}
