package kotlinx.coroutines.b.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlinx.coroutines.internal.ap;

/* JADX INFO: compiled from: ChannelFlow.kt */
/* JADX INFO: loaded from: classes4.dex */
final class aa<T> implements kotlinx.coroutines.b.i<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d.c.g f38871a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f38872b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d.h.a.m<T, d.c.d<? super d.x>, Object> f38873c;

    /* JADX INFO: compiled from: ChannelFlow.kt */
    @d.c.b.a.f(b = "ChannelFlow.kt", c = {208}, d = "invokeSuspend", e = "kotlinx.coroutines.flow.internal.UndispatchedContextCollector$emitRef$1")
    static final class a extends d.c.b.a.l implements d.h.a.m<T, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f38874a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f38875b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.b.i<T> f38876c;

        a(kotlinx.coroutines.b.i<? super T> r3, d.c.d<? super a> r4) {
            kotlinx.coroutines.b.i<T> r5 = (kotlinx.coroutines.b.i) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin");
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f38876c = r5;
            super(2, r6);
        }

        public final Object a(T r3, d.c.d<? super d.x> r4) {
            return ((a) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            a r0 = new a(this.f38876c, r5);
            r0.f38875b = r3;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(Object r3, d.c.d<? super d.x> r4) {
            return a(r3, (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f38874a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r6);
        L12:
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            Object r7 = this.f38875b;
            kotlinx.coroutines.b.i<T> r2 = this.f38876c;
            d.c.d<? super d.x> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f38874a = 1;
            if (r2.emit((T) r7, r3) != r0) goto L12;
            return r0;
        }
    }

    public aa(kotlinx.coroutines.b.i<? super T> r3, d.c.g r4) {
        kotlinx.coroutines.b.i r5 = (kotlinx.coroutines.b.i) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin");
        d.c.g r6 = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r4, d.c.g.class, "com.obric.aiagent.plugin");
        this.f38871a = r6;
        this.f38872b = ap.a(r6);
        this.f38873c = (d.h.a.m) ZeusTransformUtils.preCheckCast(new a(r5, null), d.h.a.m.class, "com.obric.aiagent.plugin");
    }

    @Override // kotlinx.coroutines.b.i
    public Object emit(T r3, d.c.d<? super d.x> r4) {
        d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        Object r2 = f.a(this.f38871a, r3, this.f38872b, this.f38873c, r5);
        if (r2 != d.c.a.b.a()) goto L6;
        return r2;
    L6:
        return d.x.f38692a;
    }
}
