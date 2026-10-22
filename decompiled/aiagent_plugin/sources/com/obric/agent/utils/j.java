package com.obric.agent.utils;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: ClientToolReportInfo.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f16036a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final JSONObject f16037b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<String, Long> f16038c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map<String, Integer> f16039d;

    /* JADX INFO: compiled from: ClientToolReportInfo.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f16036a = new a(null);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, j.class) == true) goto L8;
        return false;
    L8:
        j r6 = (j) ZeusTransformUtils.preCheckCast(r5, j.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f16037b, r6.f16037b) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f16038c, r6.f16038c) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f16039d, r6.f16039d) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        JSONObject r0 = this.f16037b;
        if (r0 != null) goto L5;
        int r1 = 0;
    L7:
        return (((r1 * 31) + this.f16038c.hashCode()) * 31) + this.f16039d.hashCode();
    L5:
        r1 = r0.hashCode();
        goto L7
    }

    public String toString() {
        return "ClientToolReportInfo(clientInfo=" + this.f16037b + ", timeline=" + this.f16038c + ", feature=" + this.f16039d + ')';
    }

    public j(JSONObject r3, Map<String, Long> r4, Map<String, Integer> r5) {
        Map<String, Long> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        Map<String, Integer> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r6, "timeline");
        d.h.b.o.e(r7, "feature");
        this.f16037b = r3;
        this.f16038c = r6;
        this.f16039d = r7;
    }

    public final String a() {
        JSONObject r0 = new JSONObject();
        JSONObject r1 = this.f16037b;
        if (r1 == null) goto L5;
        r0.put("client_info", r1);
    L5:
        r0.put("timeline", a(this.f16038c));
        if ((!this.f16039d.isEmpty()) == false) goto L8;
        r0.put("feature", b(this.f16039d));
    L8:
        String r3 = r0.toString();
        d.h.b.o.c(r3, "toString(...)");
        return r3;
    }

    private final JSONObject a(Map<String, Long> r6) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
        JSONObject r7 = new JSONObject();
        Iterator r8 = r5.entrySet().iterator();
    L4:
        if (r8.hasNext() == false) goto L6;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r8.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        r7.put((String) ZeusTransformUtils.preCheckCast(r1.getKey(), String.class, "com.obric.aiagent.plugin"), ((Number) ZeusTransformUtils.preCheckCast(r1.getValue(), Number.class, "com.obric.aiagent.plugin")).longValue());
        goto L4
    L6:
        return r7;
    }

    private final JSONObject b(Map<String, Integer> r5) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        JSONObject r6 = new JSONObject();
        Iterator r7 = r4.entrySet().iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        r6.put((String) ZeusTransformUtils.preCheckCast(r1.getKey(), String.class, "com.obric.aiagent.plugin"), ((Number) ZeusTransformUtils.preCheckCast(r1.getValue(), Number.class, "com.obric.aiagent.plugin")).intValue());
        goto L4
    L6:
        return r6;
    }
}
