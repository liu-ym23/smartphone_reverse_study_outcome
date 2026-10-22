package kotlinx.coroutines.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: compiled from: Channels.kt */
/* JADX INFO: loaded from: classes4.dex */
final class d<T> extends kotlinx.coroutines.b.a.e<T> {
    private static final /* synthetic */ AtomicIntegerFieldUpdater f = null;
    private volatile /* synthetic */ int consumed$volatile;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final kotlinx.coroutines.a.s<T> f39016d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f39017e;

    static {
        f = AtomicIntegerFieldUpdater.newUpdater(d.class, "consumed$volatile");
    }

    private static final /* synthetic */ AtomicIntegerFieldUpdater f() {
        return f;
    }

    public /* synthetic */ d(kotlinx.coroutines.a.s r8, boolean r9, d.c.g r10, int r11, kotlinx.coroutines.a.a r12, int r13, d.h.b.h r14) {
        kotlinx.coroutines.a.s r2 = (kotlinx.coroutines.a.s) ZeusTransformUtils.wrapperContextForParams(r8, kotlinx.coroutines.a.s.class, "com.obric.aiagent.plugin");
        d.c.g r15 = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r10, d.c.g.class, "com.obric.aiagent.plugin");
        if ((r13 & 4) == 0) goto L5;
        r15 = (d.c.g) ZeusTransformUtils.preCheckCast(d.c.h.f38423a, d.c.g.class, "com.obric.aiagent.plugin");
    L5:
        d.c.g r4 = r15;
        if ((r13 & 8) == 0) goto L8;
        r11 = -3;
    L8:
        int r5 = r11;
        if ((r13 & 16) == 0) goto L11;
        r12 = kotlinx.coroutines.a.a.f38771a;
    L11:
        this(r2, r9, r4, r5, r12);
    }

    public d(kotlinx.coroutines.a.s<? extends T> r3, boolean r4, d.c.g r5, int r6, kotlinx.coroutines.a.a r7) {
        kotlinx.coroutines.a.s<T> r8 = (kotlinx.coroutines.a.s) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.a.s.class, "com.obric.aiagent.plugin");
        super((d.c.g) ZeusTransformUtils.wrapperContextForParams(r5, d.c.g.class, "com.obric.aiagent.plugin"), r6, r7);
        this.f39016d = r8;
        this.f39017e = r4;
        this.consumed$volatile = 0;
    }

    private final void e() {
        if (this.f39017e == false) goto L12;
        boolean r1 = true;
        if (f().getAndSet(this, 1) == 0) goto L8;
        r1 = false;
    L8:
        if (r1 == false) goto L11;
        return;
    L11:
        throw new IllegalStateException("ReceiveChannel.consumeAsFlow can be collected just once".toString());
    }

    @Override // kotlinx.coroutines.b.a.e
    public kotlinx.coroutines.b.a.e<T> a(d.c.g r9, int r10, kotlinx.coroutines.a.a r11) {
        d.c.g r5 = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r9, d.c.g.class, "com.obric.aiagent.plugin");
        return (kotlinx.coroutines.b.a.e) ZeusTransformUtils.preCheckCast(new d(this.f39016d, this.f39017e, r5, r10, r11), kotlinx.coroutines.b.a.e.class, "com.obric.aiagent.plugin");
    }

    @Override // kotlinx.coroutines.b.a.e
    public h<T> a() {
        return (h) ZeusTransformUtils.preCheckCast(new d(this.f39016d, this.f39017e, null, 0, null, 28, null), h.class, "com.obric.aiagent.plugin");
    }

    @Override // kotlinx.coroutines.b.a.e
    public Object a(kotlinx.coroutines.a.q<? super T> r4, d.c.d<? super d.x> r5) {
        kotlinx.coroutines.a.q r6 = (kotlinx.coroutines.a.q) ZeusTransformUtils.wrapperContextForParams(r4, kotlinx.coroutines.a.q.class, "com.obric.aiagent.plugin");
        d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        Object r3 = l.a((i) ZeusTransformUtils.preCheckCast(new kotlinx.coroutines.b.a.x((kotlinx.coroutines.a.t) ZeusTransformUtils.preCheckCast(r6, kotlinx.coroutines.a.t.class, "com.obric.aiagent.plugin")), i.class, "com.obric.aiagent.plugin"), this.f39016d, this.f39017e, r7);
        if (r3 != d.c.a.b.a()) goto L6;
        return r3;
    L6:
        return d.x.f38692a;
    }

    @Override // kotlinx.coroutines.b.a.e
    public kotlinx.coroutines.a.s<T> a(kotlinx.coroutines.am r3) {
        kotlinx.coroutines.am r4 = (kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin");
        e();
        if (this.f38883b != (-3)) goto L6;
        return this.f39016d;
    L6:
        return super.a(r4);
    }

    @Override // kotlinx.coroutines.b.a.e, kotlinx.coroutines.b.h
    public Object collect(i<? super T> r3, d.c.d<? super d.x> r4) {
        i<? super T> r5 = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.aiagent.plugin");
        d.c.d<? super d.x> r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        if (this.f38883b != (-3)) goto L9;
        e();
        Object r2 = l.a(r5, this.f39016d, this.f39017e, r6);
        if (r2 != d.c.a.b.a()) goto L8;
        return r2;
    L8:
        return d.x.f38692a;
    L9:
        Object r7 = super.collect(r5, r6);
        if (r7 != d.c.a.b.a()) goto L13;
        return r7;
    L13:
        return d.x.f38692a;
    }

    @Override // kotlinx.coroutines.b.a.e
    public String b() {
        return "channel=" + this.f39016d;
    }
}
