package kotlinx.coroutines.e;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.q;
import d.h.b.ae;
import d.h.b.o;
import d.x;
import kotlinx.coroutines.ax;

/* JADX INFO: compiled from: OnTimeout.kt */
/* JADX INFO: loaded from: classes4.dex */
final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f39277a;

    /* JADX INFO: renamed from: kotlinx.coroutines.e.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Runnable.kt */
    public static final class RunnableC1057a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ j f39278a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f39279b;

        public RunnableC1057a(j r3, a r4) {
            this.f39278a = (j) ZeusTransformUtils.wrapperContextForParams(r3, j.class, "com.obric.aiagent.plugin");
            this.f39279b = r4;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f39278a.a(this.f39279b, x.f38692a);
        }
    }

    /* JADX INFO: compiled from: OnTimeout.kt */
    /* synthetic */ class b extends d.h.b.l implements q<a, j<?>, Object, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f39280a = null;

        static {
            f39280a = new b();
        }

        b() {
            super(3, a.class, "register", "register(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);
        }

        public final void a(a r2, j<?> r3, Object r4) {
            a.a(r2, (j) ZeusTransformUtils.wrapperContextForParams(r3, j.class, "com.obric.aiagent.plugin"), r4);
        }

        @Override // d.h.a.q
        public /* synthetic */ x invoke(a r3, j<?> r4, Object r5) {
            a((a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.aiagent.plugin"), (j) ZeusTransformUtils.preCheckCast(r4, j.class, "com.obric.aiagent.plugin"), r5);
            return x.f38692a;
        }
    }

    public a(long r1) {
        this.f39277a = r1;
    }

    public static final /* synthetic */ void a(a r2, j r3, Object r4) {
        r2.a((j) ZeusTransformUtils.wrapperContextForParams(r3, j.class, "com.obric.aiagent.plugin"), r4);
    }

    public final e a() {
        b r0 = b.f39280a;
        o.a(r0, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        return (e) ZeusTransformUtils.preCheckCast(new f(this, (q) ZeusTransformUtils.preCheckCast(ae.b(r0, 3), q.class, "com.obric.aiagent.plugin"), null, 4, null), e.class, "com.obric.aiagent.plugin");
    }

    private final void a(j<?> r6, Object r7) {
        j r8 = (j) ZeusTransformUtils.wrapperContextForParams(r6, j.class, "com.obric.aiagent.plugin");
        if (this.f39277a > 0) goto L6;
        r8.a(x.f38692a);
        return;
    L6:
        Runnable r9 = (Runnable) ZeusTransformUtils.preCheckCast(new RunnableC1057a(r8, this), Runnable.class, "com.obric.aiagent.plugin");
        o.a(r8, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>");
        i r0 = (i) ZeusTransformUtils.preCheckCast(r8, i.class, "com.obric.aiagent.plugin");
        d.c.g r1 = r8.getContext();
        r8.a(ax.a(r1).a(this.f39277a, r9, r1));
    }
}
