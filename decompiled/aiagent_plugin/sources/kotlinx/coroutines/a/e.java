package kotlinx.coroutines.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.x;
import java.util.concurrent.CancellationException;
import kotlinx.coroutines.ca;
import kotlinx.coroutines.cb;
import kotlinx.coroutines.ci;

/* JADX INFO: compiled from: ChannelCoroutine.kt */
/* JADX INFO: loaded from: classes4.dex */
public class e<E> extends kotlinx.coroutines.a<x> implements d<E> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d<E> f38808c;

    @Override // kotlinx.coroutines.a.s
    public Object a(d.c.d<? super E> r3) {
        d.c.d<? super E> r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
        return this.f38808c.a(r4);
    }

    @Override // kotlinx.coroutines.a.t
    public Object a(E r3, d.c.d<? super x> r4) {
        d.c.d<? super x> r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        return this.f38808c.a(r3, r5);
    }

    @Override // kotlinx.coroutines.a.t
    public void a(d.h.a.b<? super Throwable, x> r3) {
        d.h.a.b<? super Throwable, x> r4 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
        this.f38808c.a(r4);
    }

    @Override // kotlinx.coroutines.a.t
    public boolean a(Throwable r1) {
        return this.f38808c.a(r1);
    }

    @Override // kotlinx.coroutines.a.s
    public Object a_(d.c.d<? super h<? extends E>> r3) {
        d.c.d<? super h<? extends E>> r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
        Object r2 = this.f38808c.a_(r4);
        d.c.a.b.a();
        return r2;
    }

    @Override // kotlinx.coroutines.a.t
    public Object a_(E r1) {
        return this.f38808c.a_(r1);
    }

    @Override // kotlinx.coroutines.a.s
    public kotlinx.coroutines.e.g<E> f() {
        return this.f38808c.f();
    }

    @Override // kotlinx.coroutines.a.s
    public f<E> g() {
        return this.f38808c.g();
    }

    @Override // kotlinx.coroutines.a.t
    public boolean l() {
        return this.f38808c.l();
    }

    @Override // kotlinx.coroutines.a.s
    public Object r_() {
        return this.f38808c.r_();
    }

    public final d<E> t() {
        return this.f38808c;
    }

    public e(d.c.g r3, d<E> r4, boolean r5, boolean r6) {
        d.c.g r7 = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r3, d.c.g.class, "com.obric.aiagent.plugin");
        d<E> r8 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
        super(r7, r5, r6);
        this.f38808c = r8;
    }

    @Override // kotlinx.coroutines.ci, kotlinx.coroutines.ca, kotlinx.coroutines.a.s
    public final void a(CancellationException r6) {
        if (j() == false) goto L6;
        return;
    L6:
        if (r6 != null) goto L8;
        r6 = (CancellationException) ZeusTransformUtils.preCheckCast(new cb(ci.a((ci) ZeusTransformUtils.preCheckCast(this, ci.class, "com.obric.aiagent.plugin")), null, (ca) ZeusTransformUtils.preCheckCast((ci) ZeusTransformUtils.preCheckCast(this, ci.class, "com.obric.aiagent.plugin"), ca.class, "com.obric.aiagent.plugin")), CancellationException.class, "com.obric.aiagent.plugin");
    L8:
        b((Throwable) ZeusTransformUtils.preCheckCast(r6, Throwable.class, "com.obric.aiagent.plugin"));
    }

    @Override // kotlinx.coroutines.ci
    public void b(Throwable r5) {
        CancellationException r6 = ci.a((ci) ZeusTransformUtils.preCheckCast(this, ci.class, "com.obric.aiagent.plugin"), r5, null, 1, null);
        this.f38808c.a(r6);
        d((Throwable) ZeusTransformUtils.preCheckCast(r6, Throwable.class, "com.obric.aiagent.plugin"));
    }
}
