package kotlinx.coroutines.e;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.q;
import d.x;

/* JADX INFO: compiled from: Select.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class f implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f39281a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final q<Object, j<?>, Object, x> f39282b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final q<j<?>, Object, Object, d.h.a.b<Throwable, x>> f39283c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final q<Object, Object, Object, Object> f39284d;

    public f(Object r3, q<Object, ? super j<?>, Object, x> r4, q<? super j<?>, Object, Object, ? extends d.h.a.b<? super Throwable, x>> r5) {
        q<Object, j<?>, Object, x> r6 = (q) ZeusTransformUtils.wrapperContextForParams(r4, q.class, "com.obric.aiagent.plugin");
        q<j<?>, Object, Object, d.h.a.b<Throwable, x>> r7 = (q) ZeusTransformUtils.wrapperContextForParams(r5, q.class, "com.obric.aiagent.plugin");
        this.f39281a = r3;
        this.f39282b = r6;
        this.f39283c = r7;
        this.f39284d = l.b();
    }

    public /* synthetic */ f(Object r2, q r3, q r4, int r5, d.h.b.h r6) {
        q r7 = (q) ZeusTransformUtils.wrapperContextForParams(r3, q.class, "com.obric.aiagent.plugin");
        q r8 = (q) ZeusTransformUtils.wrapperContextForParams(r4, q.class, "com.obric.aiagent.plugin");
        if ((r5 & 4) == 0) goto L5;
        r8 = null;
    L5:
        this(r2, r7, r8);
    }

    @Override // kotlinx.coroutines.e.d
    public Object a() {
        return this.f39281a;
    }

    @Override // kotlinx.coroutines.e.d
    public q<Object, j<?>, Object, x> b() {
        return this.f39282b;
    }

    @Override // kotlinx.coroutines.e.d
    public q<j<?>, Object, Object, d.h.a.b<Throwable, x>> d() {
        return this.f39283c;
    }

    @Override // kotlinx.coroutines.e.d
    public q<Object, Object, Object, Object> c() {
        return this.f39284d;
    }
}
