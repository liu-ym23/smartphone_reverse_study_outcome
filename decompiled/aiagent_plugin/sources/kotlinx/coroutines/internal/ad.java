package kotlinx.coroutines.internal;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: OnUndeliveredElement.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ad {

    /* JADX INFO: compiled from: OnUndeliveredElement.kt */
    static final class a extends d.h.b.p implements d.h.a.b<Throwable, d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d.h.a.b<E, d.x> f39358a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ E f39359b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ d.c.g f39360c;

        a(d.h.a.b<? super E, d.x> r3, E r4, d.c.g r5) {
            d.h.a.b<E, d.x> r6 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
            d.c.g r7 = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r5, d.c.g.class, "com.obric.aiagent.plugin");
            this.f39358a = r6;
            this.f39359b = r4;
            this.f39360c = r7;
            super(1);
        }

        public final void a(Throwable r2) {
            ad.a(this.f39358a, this.f39359b, this.f39360c);
        }

        @Override // d.h.a.b
        public /* synthetic */ d.x invoke(Throwable r3) {
            a((Throwable) ZeusTransformUtils.preCheckCast(r3, Throwable.class, "com.obric.aiagent.plugin"));
            return d.x.f38692a;
        }
    }

    public static /* synthetic */ au a(d.h.a.b r1, Object r2, au r3, int r4, Object r5) {
        d.h.a.b r6 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r1, d.h.a.b.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L6;
        r3 = null;
    L6:
        return a(r6, r2, r3);
    }

    public static final <E> au a(d.h.a.b<? super E, d.x> r2, E r3, au r4) {
        ((d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.b.class, "com.obric.aiagent.plugin")).invoke(r3);     // Catch: Throwable -> L5
    L10:
        return r4;
    L5:
        th = move-exception;
        if (r4 == null) goto L12;
        if (r4.getCause() == th) goto L12;
        d.a.a((Throwable) ZeusTransformUtils.preCheckCast(r4, Throwable.class, "com.obric.aiagent.plugin"), th);
    L12:
        return new au("Exception in undelivered element handler for " + r3, th);
    }

    public static final <E> void a(d.h.a.b<? super E, d.x> r2, E r3, d.c.g r4) {
        d.h.a.b r5 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.c.g r6 = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r4, d.c.g.class, "com.obric.aiagent.plugin");
        au r7 = a(r5, r3, null);
        if (r7 == null) goto L6;
        kotlinx.coroutines.aj.a(r6, (Throwable) ZeusTransformUtils.preCheckCast(r7, Throwable.class, "com.obric.aiagent.plugin"));
        return;
    }

    public static final <E> d.h.a.b<Throwable, d.x> b(d.h.a.b<? super E, d.x> r2, E r3, d.c.g r4) {
        return (d.h.a.b) ZeusTransformUtils.preCheckCast(new a((d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.b.class, "com.obric.aiagent.plugin"), r3, (d.c.g) ZeusTransformUtils.wrapperContextForParams(r4, d.c.g.class, "com.obric.aiagent.plugin")), d.h.a.b.class, "com.obric.aiagent.plugin");
    }
}
