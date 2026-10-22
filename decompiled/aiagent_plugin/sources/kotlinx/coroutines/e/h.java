package kotlinx.coroutines.e;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.q;
import d.x;

/* JADX INFO: compiled from: Select.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class h<Q> implements g<Q> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f39285a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final q<Object, j<?>, Object, x> f39286b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final q<Object, Object, Object, Object> f39287c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final q<j<?>, Object, Object, d.h.a.b<Throwable, x>> f39288d;

    public h(Object r3, q<Object, ? super j<?>, Object, x> r4, q<Object, Object, Object, ? extends Object> r5, q<? super j<?>, Object, Object, ? extends d.h.a.b<? super Throwable, x>> r6) {
        q<Object, j<?>, Object, x> r7 = (q) ZeusTransformUtils.wrapperContextForParams(r4, q.class, "com.obric.aiagent.plugin");
        q<Object, Object, Object, Object> r8 = (q) ZeusTransformUtils.wrapperContextForParams(r5, q.class, "com.obric.aiagent.plugin");
        q<j<?>, Object, Object, d.h.a.b<Throwable, x>> r9 = (q) ZeusTransformUtils.wrapperContextForParams(r6, q.class, "com.obric.aiagent.plugin");
        this.f39285a = r3;
        this.f39286b = r7;
        this.f39287c = r8;
        this.f39288d = r9;
    }

    public /* synthetic */ h(Object r2, q r3, q r4, q r5, int r6, d.h.b.h r7) {
        q r8 = (q) ZeusTransformUtils.wrapperContextForParams(r3, q.class, "com.obric.aiagent.plugin");
        q r9 = (q) ZeusTransformUtils.wrapperContextForParams(r4, q.class, "com.obric.aiagent.plugin");
        q r10 = (q) ZeusTransformUtils.wrapperContextForParams(r5, q.class, "com.obric.aiagent.plugin");
        if ((r6 & 8) == 0) goto L5;
        r10 = null;
    L5:
        this(r2, r8, r9, r10);
    }

    @Override // kotlinx.coroutines.e.d
    public Object a() {
        return this.f39285a;
    }

    @Override // kotlinx.coroutines.e.d
    public q<Object, j<?>, Object, x> b() {
        return this.f39286b;
    }

    @Override // kotlinx.coroutines.e.d
    public q<Object, Object, Object, Object> c() {
        return this.f39287c;
    }

    @Override // kotlinx.coroutines.e.d
    public q<j<?>, Object, Object, d.h.a.b<Throwable, x>> d() {
        return this.f39288d;
    }
}
