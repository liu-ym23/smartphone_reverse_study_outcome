package kotlinx.coroutines.b.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ChannelFlow.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class h<T> extends g<T, T> {
    public /* synthetic */ h(kotlinx.coroutines.b.h r2, d.c.g r3, int r4, kotlinx.coroutines.a.a r5, int r6, d.h.b.h r7) {
        kotlinx.coroutines.b.h r8 = (kotlinx.coroutines.b.h) ZeusTransformUtils.wrapperContextForParams(r2, kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin");
        d.c.g r9 = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r3, d.c.g.class, "com.obric.aiagent.plugin");
        if ((r6 & 2) == 0) goto L6;
        r9 = (d.c.g) ZeusTransformUtils.preCheckCast(d.c.h.f38423a, d.c.g.class, "com.obric.aiagent.plugin");
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = -3;
    L9:
        if ((r6 & 8) == 0) goto L11;
        r5 = kotlinx.coroutines.a.a.f38771a;
    L11:
        this(r8, r9, r4, r5);
    }

    public h(kotlinx.coroutines.b.h<? extends T> r3, d.c.g r4, int r5, kotlinx.coroutines.a.a r6) {
        super((kotlinx.coroutines.b.h) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin"), (d.c.g) ZeusTransformUtils.wrapperContextForParams(r4, d.c.g.class, "com.obric.aiagent.plugin"), r5, r6);
    }

    @Override // kotlinx.coroutines.b.a.e
    public e<T> a(d.c.g r3, int r4, kotlinx.coroutines.a.a r5) {
        d.c.g r6 = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r3, d.c.g.class, "com.obric.aiagent.plugin");
        return (e) ZeusTransformUtils.preCheckCast(new h(this.f38892d, r6, r4, r5), e.class, "com.obric.aiagent.plugin");
    }

    @Override // kotlinx.coroutines.b.a.e
    public kotlinx.coroutines.b.h<T> a() {
        return (kotlinx.coroutines.b.h<T>) this.f38892d;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // kotlinx.coroutines.b.a.g
    public Object a(kotlinx.coroutines.b.i<? super T> r3, d.c.d<? super d.x> r4) {
        kotlinx.coroutines.b.i r5 = (kotlinx.coroutines.b.i) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin");
        d.c.d<? super d.x> r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        Object r2 = this.f38892d.collect((kotlinx.coroutines.b.i<? super S>) r5, r6);
        if (r2 != d.c.a.b.a()) goto L6;
        return r2;
    L6:
        return d.x.f38692a;
    }
}
