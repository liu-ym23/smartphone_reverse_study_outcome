package com.obric.agent.utils;

import com.obric.aiagent.platform.depend.ILogDepend;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: ClientToolReportHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f16033a = null;

    /* JADX INFO: compiled from: ClientToolReportHelper.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f16034a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f16035b;

        public boolean equals(Object r7) {
            if (this != r7) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r7, a.class) == true) goto L8;
            return false;
        L8:
            a r8 = (a) ZeusTransformUtils.preCheckCast(r7, a.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f16034a, r8.f16034a) == true) goto L12;
            return false;
        L12:
            if (this.f16035b == r8.f16035b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f16034a.hashCode() * 31) + Long.hashCode(this.f16035b);
        }

        public String toString() {
            return "ClientToolReport(infoJson=" + this.f16034a + ", duration=" + this.f16035b + ')';
        }

        public a(String r2, long r3) {
            d.h.b.o.e(r2, "infoJson");
            this.f16034a = r2;
            this.f16035b = r3;
        }

        public final String a() {
            return this.f16034a;
        }

        public final long b() {
            return this.f16035b;
        }
    }

    static {
        f16033a = new i();
    }

    private i() {
    }

    public final void a() {
        if (com.obric.autogui.common.a.d.f28974a.ae() == true) goto L5;
        return;
    L5:
        e.f16022a.a();
    }

    public final a a(String r6, String r7) {
        d.h.b.o.e(r7, "questionId");
        g r8 = h.f16032a.a(r6);
        if (r8 != null) goto L5;
        return null;
    L5:
        k r9 = l.f16043a.a(r7, r8);
        if (r9 != null) goto L23;
        return null;
    L23:
        d.n.a r10 = d.n.f38560a;     // Catch: Throwable -> L10
        i r5 = (i) ZeusTransformUtils.preCheckCast(this, i.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L10
        Object r11 = d.n.f(new j(r5.c(), r5.a(r9), r5.b()).a());     // Catch: Throwable -> L10
    L12:
        Throwable r12 = d.n.c(r11);
        if (r12 == null) goto L16;
        ILogDepend.Companion.w("ClientToolReportHelper", "build client tool report failed", r12);
    L16:
        if (d.n.b(r11) == false) goto L18;
        r11 = null;
    L18:
        String r13 = (String) ZeusTransformUtils.preCheckCast(r11, String.class, "com.obric.aiagent.plugin");
        if (r13 != null) goto L22;
        return null;
    L22:
        return new a(r13, r9.a());
    L10:
        th = move-exception;
        d.n.a r14 = d.n.f38560a;
        r11 = d.n.f(d.o.a(th));
        goto L12
    }

    private final Map<String, Integer> b() {
        if (com.obric.autogui.common.a.d.f28974a.s() == false) goto L6;
        return ao.a(d.s.a("heif", 1));
    L6:
        return ao.b();
    }

    private final JSONObject c() {
        if (com.obric.autogui.common.a.d.f28974a.ae() == true) goto L7;
        return null;
    L7:
        return e.f16022a.b();
    }

    private final Map<String, Long> a(k r3) {
        return (Map) ZeusTransformUtils.preCheckCast(ao.d(new d.m[]{d.s.a("client_tool_start", Long.valueOf(r3.b())), d.s.a("client_tool_end", Long.valueOf(r3.c()))}), Map.class, "com.obric.aiagent.plugin");
    }
}
