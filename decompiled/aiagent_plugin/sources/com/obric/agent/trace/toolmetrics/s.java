package com.obric.agent.trace.toolmetrics;

import com.obric.aiagent.applog.IAppLog;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;
import kotlinx.coroutines.am;
import org.json.JSONObject;

/* JADX INFO: compiled from: OmniClientToolTraceEventReporter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class s implements t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f15919a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final am f15920b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final r f15921c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final q f15922d;

    /* JADX INFO: compiled from: OmniClientToolTraceEventReporter.kt */
    private static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: OmniClientToolTraceEventReporter.kt */
    @d.c.b.a.f(b = "OmniClientToolTraceEventReporter.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.trace.toolmetrics.OmniClientToolTraceEventReporter$emit$1")
    static final class b extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f15923a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ s f15924b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ w f15925c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private /* synthetic */ Object f15926d;

        b(s r3, w r4, d.c.d<? super b> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15924b = r3;
            this.f15925c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            b r0 = new b(this.f15924b, this.f15925c, r6);
            r0.f15926d = r4;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            d.c.a.b.a();
            if (this.f15923a != 0) goto L22;
            d.o.a(r6);
            am r7 = (am) ZeusTransformUtils.preCheckCast(this.f15926d, am.class, "com.obric.aiagent.plugin");
            s r8 = this.f15924b;
            w r0 = this.f15925c;
            d.n.a r2 = d.n.f38560a;     // Catch: Throwable -> L14
            JSONObject r3 = new JSONObject();     // Catch: Throwable -> L14
            Iterator<Map.Entry<String, Object>> r9 = s.a(r8).a(r0).entrySet().iterator();     // Catch: Throwable -> L14
        L7:
            if (r9.hasNext() == false) goto L9;
            Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r9.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
            r3.put((String) ZeusTransformUtils.preCheckCast(r1.getKey(), String.class, "com.obric.aiagent.plugin"), r1.getValue());     // Catch: Throwable -> L14
            goto L7
        L9:
            IAppLog r10 = (IAppLog) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppLog.class), IAppLog.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
            if (r10 == null) goto L13;
            ILogDepend.Companion.d("OmniClientToolTraceEventReporter", "doReport obric_omni_client_tool_exec: " + r3);     // Catch: Throwable -> L14
            r10.reportToFlow("obric_omni_client_tool_exec", r3);     // Catch: Throwable -> L14
            Object r11 = d.n.f(d.x.f38692a);     // Catch: Throwable -> L14
        L16:
            s r4 = this.f15924b;
            w r5 = this.f15925c;
            if (d.n.c(r11) == null) goto L20;
            s.b(r4).a("report_failed", r5.a());
        L20:
            return d.x.f38692a;
        L13:
            throw new IllegalStateException("IAppLog service is unavailable".toString());     // Catch: Throwable -> L14
        L14:
            th = move-exception;
            d.n.a r12 = d.n.f38560a;
            r11 = d.n.f(d.o.a(th));
            goto L16
        L22:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        f15919a = new a(null);
    }

    public s(am r3, r r4, q r5) {
        am r6 = (am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin");
        q r7 = (q) ZeusTransformUtils.wrapperContextForParams(r5, q.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r6, "scope");
        d.h.b.o.e(r4, "flattener");
        d.h.b.o.e(r7, "diagnosticSink");
        this.f15920b = r6;
        this.f15921c = r4;
        this.f15922d = r7;
    }

    public static final /* synthetic */ r a(s r0) {
        return r0.f15921c;
    }

    public static final /* synthetic */ q b(s r0) {
        return r0.f15922d;
    }

    @Override // com.obric.agent.trace.toolmetrics.t
    public void a(w r8) {
        d.h.b.o.e(r8, "snapshot");
        kotlinx.coroutines.i.a(this.f15920b, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new b(this, r8, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }
}
