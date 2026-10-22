package kotlinx.coroutines;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: CoroutineDispatcher.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class ai extends d.c.a implements d.c.e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f38837c = null;

    /* JADX INFO: compiled from: CoroutineDispatcher.kt */
    public static final class a extends d.c.b<d.c.e, ai> {

        /* JADX INFO: renamed from: kotlinx.coroutines.ai$a$1, reason: invalid class name */
        /* JADX INFO: compiled from: CoroutineDispatcher.kt */
        static final class AnonymousClass1 extends d.h.b.p implements d.h.a.b<d.c.g.b, ai> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final AnonymousClass1 f38838a = null;

            static {
                f38838a = new AnonymousClass1();
            }

            AnonymousClass1() {
                super(1);
            }

            public final ai a(d.c.g.b r2) {
                d.c.g.b r1 = (d.c.g.b) ZeusTransformUtils.wrapperContextForParams(r2, d.c.g.b.class, "com.obric.aiagent.plugin");
                if (ZeusTransformUtils.instanceOf(r1, ai.class) == true) goto L7;
                return null;
            L7:
                return (ai) ZeusTransformUtils.preCheckCast(r1, ai.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.b
            public /* synthetic */ ai invoke(d.c.g.b r3) {
                return a((d.c.g.b) ZeusTransformUtils.preCheckCast(r3, d.c.g.b.class, "com.obric.aiagent.plugin"));
            }
        }

        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
            super((d.c.g.c) ZeusTransformUtils.preCheckCast(d.c.e.f38420b, d.c.g.c.class, "com.obric.aiagent.plugin"), (d.h.a.b) ZeusTransformUtils.preCheckCast(AnonymousClass1.f38838a, d.h.a.b.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        f38837c = new a(null);
    }

    public abstract void a(d.c.g r1, Runnable r2);

    public boolean a(d.c.g r2) {
        d.c.g r1 = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r2, d.c.g.class, "com.obric.aiagent.plugin");
        return true;
    }

    @Override // d.c.a, d.c.g.b, d.c.g
    public <E extends d.c.g.b> E get(d.c.g.c<E> r3) {
        return (E) d.c.e.a.a(this, (d.c.g.c) ZeusTransformUtils.wrapperContextForParams(r3, d.c.g.c.class, "com.obric.aiagent.plugin"));
    }

    @Override // d.c.a, d.c.g
    public d.c.g minusKey(d.c.g.c<?> r3) {
        return d.c.e.a.b(this, (d.c.g.c) ZeusTransformUtils.wrapperContextForParams(r3, d.c.g.c.class, "com.obric.aiagent.plugin"));
    }

    public ai() {
        super((d.c.g.c) ZeusTransformUtils.preCheckCast(d.c.e.f38420b, d.c.g.c.class, "com.obric.aiagent.plugin"));
    }

    public ai a(int r2) {
        kotlinx.coroutines.internal.u.a(r2);
        return (ai) ZeusTransformUtils.preCheckCast(new kotlinx.coroutines.internal.t(this, r2), ai.class, "com.obric.aiagent.plugin");
    }

    public void b(d.c.g r3, Runnable r4) {
        a((d.c.g) ZeusTransformUtils.wrapperContextForParams(r3, d.c.g.class, "com.obric.aiagent.plugin"), (Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.aiagent.plugin"));
    }

    @Override // d.c.e
    public final <T> d.c.d<T> a(d.c.d<? super T> r3) {
        return (d.c.d) ZeusTransformUtils.preCheckCast(new kotlinx.coroutines.internal.m(this, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), d.c.d.class, "com.obric.aiagent.plugin");
    }

    @Override // d.c.e
    public final void b(d.c.d<?> r2) {
        d.c.d r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin");
        d.h.b.o.a(r1, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        ((kotlinx.coroutines.internal.m) ZeusTransformUtils.preCheckCast(r1, kotlinx.coroutines.internal.m.class, "com.obric.aiagent.plugin")).d();
    }

    public String toString() {
        return ar.b(this) + '@' + ar.a(this);
    }
}
