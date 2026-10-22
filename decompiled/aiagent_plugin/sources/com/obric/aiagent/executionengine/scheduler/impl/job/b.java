package com.obric.aiagent.executionengine.scheduler.impl.job;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: ToolExecutionAuditLogger.kt */
/* JADX INFO: loaded from: classes2.dex */
final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f18459a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<a> f18460b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f18461c;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
        return false;
    L8:
        b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
        if (o.a(this.f18459a, r6.f18459a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f18460b, r6.f18460b) == true) goto L15;
        return false;
    L15:
        if (o.a(this.f18461c, r6.f18461c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.f18459a.hashCode() * 31) + this.f18460b.hashCode()) * 31;
        String r2 = this.f18461c;
        if (r2 != null) goto L5;
        int r3 = 0;
    L7:
        return r0 + r3;
    L5:
        r3 = r2.hashCode();
        goto L7
    }

    public String toString() {
        return "AuditMetaBundle(common=" + this.f18459a + ", toolInputs=" + this.f18460b + ", instructionId=" + this.f18461c + ')';
    }

    public b(a r3, List<a> r4, String r5) {
        List<a> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        o.e(r3, "common");
        o.e(r6, "toolInputs");
        this.f18459a = r3;
        this.f18460b = r6;
        this.f18461c = r5;
    }

    public final a a() {
        return this.f18459a;
    }

    public final List<a> b() {
        return this.f18460b;
    }

    public final a a(int r4) {
        a r5 = (a) ZeusTransformUtils.preCheckCast(p.d(this.f18460b, r4), a.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L14;
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(this.f18461c, CharSequence.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L7;
    L10:
        boolean r1 = true;
    L11:
        if (r1 == false) goto L14;
        return this.f18459a;
    L7:
        if (d.o.o.d(r0) == true) goto L10;
        r1 = false;
    L14:
        JSONObject r2 = new JSONObject();
        if (r5 == null) goto L17;
        j.a(r2, r5.c());
    L17:
        String r6 = this.f18461c;
        if (r6 == null) goto L20;
        j.b(r2, "instruction_id", r6);
    L20:
        j.a(r2, this.f18459a.c());
        if (j.a(r2) == false) goto L24;
        j.a(r2, j.a(r2, new String[]{"instruction_id"}), j.a(r2, new String[]{"o_reference_msg_id"}));
    L24:
        return new a(r2);
    }
}
