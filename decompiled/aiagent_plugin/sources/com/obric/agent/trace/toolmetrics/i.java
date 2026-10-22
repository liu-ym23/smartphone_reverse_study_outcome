package com.obric.agent.trace.toolmetrics;

import com.obric.funcall_api.bean.AppActionRequest;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: OmniClientNetworkTraceHooks.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f15892a = null;

    static {
        f15892a = new i();
    }

    private i() {
    }

    public final h a() {
        return new h(0, 1, null);
    }

    public final void a(long r2) {
        a(r2, f.f15882a);
    }

    public final void b(long r2) {
        a(r2, f.f15883b);
    }

    private final void a(long r3, f r5) {
        d.n.a r0 = d.n.f38560a;     // Catch: Throwable -> L4
        i r2 = (i) ZeusTransformUtils.preCheckCast(this, i.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L4
        g.f15887a.a(r3, r5);     // Catch: Throwable -> L4
        d.n.f(d.x.f38692a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        d.n.a r4 = d.n.f38560a;
        d.n.f(d.o.a(th));
    }

    public final void a(h r10, List<AppActionRequest> r11, boolean r12, String r13, Map<String, String> r14) {
        List<AppActionRequest> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin");
        Map<String, String> r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r14, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r10, "trace");
        d.h.b.o.e(r4, "requests");
        d.h.b.o.e(r13, "message");
        d.h.b.o.e(r8, "params");
        a(r10, r4, f.f15882a, r12, r13, r8);
    }

    public final void b(h r10, List<AppActionRequest> r11, boolean r12, String r13, Map<String, String> r14) {
        List<AppActionRequest> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin");
        Map<String, String> r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r14, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r10, "trace");
        d.h.b.o.e(r4, "requests");
        d.h.b.o.e(r13, "message");
        d.h.b.o.e(r8, "params");
        a(r10, r4, f.f15883b, r12, r13, r8);
    }

    private final void a(h r3, List<AppActionRequest> r4, f r5, boolean r6, String r7, Map<String, String> r8) {
        List<AppActionRequest> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        Map<String, String> r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.aiagent.plugin");
        d.n.a r0 = d.n.f38560a;     // Catch: Throwable -> L5
        i r2 = (i) ZeusTransformUtils.preCheckCast(this, i.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        g.f15887a.a(r9, r5, r2.a(r6, r7, r10), r3.a(r5, r10));     // Catch: Throwable -> L5
        d.n.f(d.x.f38692a);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        d.n.a r11 = d.n.f38560a;
        d.n.f(d.o.a(th));
    }

    private final m a(boolean r4, String r5, Map<String, String> r6) {
        Map r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
        String r1 = (String) ZeusTransformUtils.preCheckCast(r3.get(MonitorConstants.CODE), String.class, "com.obric.aiagent.plugin");
        if (r4 == false) goto L5;
        r5 = "";
    L9:
        m r7 = new m(r1, r5);
        if (r7.c() == true) goto L14;
        return null;
    L14:
        return r7;
    L5:
        String r8 = (String) ZeusTransformUtils.preCheckCast(r3.get("msg"), String.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L9;
        r5 = r8;
        goto L9
    }
}
