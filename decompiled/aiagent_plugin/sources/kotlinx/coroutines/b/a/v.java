package kotlinx.coroutines.b.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.ae;

/* JADX INFO: compiled from: SafeCollector.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final d.h.a.q<kotlinx.coroutines.b.i<Object>, Object, d.c.d<? super d.x>, Object> f38947a = null;

    /* JADX INFO: compiled from: SafeCollector.kt */
    /* synthetic */ class a extends d.h.b.l implements d.h.a.q<kotlinx.coroutines.b.i<? super Object>, Object, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f38948a = null;

        static {
            f38948a = new a();
        }

        a() {
            super(3, kotlinx.coroutines.b.i.class, "emit", "emit(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        }

        public final Object a(kotlinx.coroutines.b.i<Object> r2, Object r3, d.c.d<? super d.x> r4) {
            return ((kotlinx.coroutines.b.i) ZeusTransformUtils.wrapperContextForParams(r2, kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin")).emit(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.h.a.q
        public /* synthetic */ Object invoke(kotlinx.coroutines.b.i<? super Object> r3, Object r4, d.c.d<? super d.x> r5) {
            return a((kotlinx.coroutines.b.i) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin"), r4, (d.c.d) ZeusTransformUtils.preCheckCast(r5, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    public static final /* synthetic */ d.h.a.q a() {
        return f38947a;
    }

    static {
        a r0 = a.f38948a;
        d.h.b.o.a(r0, "null cannot be cast to non-null type kotlin.Function3<kotlinx.coroutines.flow.FlowCollector<kotlin.Any?>, kotlin.Any?, kotlin.coroutines.Continuation<kotlin.Unit>, kotlin.Any?>");
        f38947a = (d.h.a.q) ZeusTransformUtils.preCheckCast(ae.b(r0, 3), d.h.a.q.class, "com.obric.aiagent.plugin");
    }
}
