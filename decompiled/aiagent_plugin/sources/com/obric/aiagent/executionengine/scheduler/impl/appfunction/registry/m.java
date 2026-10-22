package com.obric.aiagent.executionengine.scheduler.impl.appfunction.registry;

import com.google.gson.JsonObject;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import java.util.Map;

/* JADX INFO: compiled from: AppFunctionEntry.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f18266a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f18267b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f18268c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f18269d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f18270e;
    private final String f;
    private final JsonObject g;
    private final Map<String, String> h;
    private final h i;
    private final i j;
    private final String k;

    public static /* synthetic */ m a(m r11, String r12, String r13, String r14, String r15, String r16, String r17, JsonObject r18, Map r19, h r20, i r21, int r22, Object r23) {
        Map<String, String> r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r19, Map.class, "com.obric.aiagent.plugin");
        if ((r22 & 1) == 0) goto L5;
        String r3 = r11.f18266a;
    L7:
        if ((r22 & 2) == 0) goto L9;
        String r4 = r11.f18267b;
    L11:
        if ((r22 & 4) == 0) goto L13;
        String r5 = r11.f18268c;
    L15:
        if ((r22 & 8) == 0) goto L17;
        String r6 = r11.f18269d;
    L19:
        if ((r22 & 16) == 0) goto L21;
        String r7 = r11.f18270e;
    L23:
        if ((r22 & 32) == 0) goto L25;
        String r8 = r11.f;
    L27:
        if ((r22 & 64) == 0) goto L29;
        JsonObject r9 = r11.g;
    L31:
        if ((r22 & 128) == 0) goto L34;
        r2 = r11.h;
    L34:
        if ((r22 & 256) == 0) goto L36;
        h r10 = r11.i;
    L38:
        if ((r22 & 512) == 0) goto L40;
        i r1 = r11.j;
    L42:
        return r11.a(r3, r4, r5, r6, r7, r8, r9, r2, r10, r1);
    L40:
        r1 = r21;
        goto L42
    L36:
        r10 = r20;
        goto L38
    L29:
        r9 = r18;
        goto L31
    L25:
        r8 = r17;
        goto L27
    L21:
        r7 = r16;
        goto L23
    L17:
        r6 = r15;
        goto L19
    L13:
        r5 = r14;
        goto L15
    L9:
        r4 = r13;
        goto L11
    L5:
        r3 = r12;
        goto L7
    }

    public final m a(String r13, String r14, String r15, String r16, String r17, String r18, JsonObject r19, Map<String, String> r20, h r21, i r22) {
        Map r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r20, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r15, "packageName");
        d.h.b.o.e(r16, "functionId");
        d.h.b.o.e(r17, "toolName");
        d.h.b.o.e(r9, "obricParameterTypes");
        d.h.b.o.e(r21, "components");
        return new m(r13, r14, r15, r16, r17, r18, r19, r9, r21, r22);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, m.class) == true) goto L8;
        return false;
    L8:
        m r6 = (m) ZeusTransformUtils.preCheckCast(r5, m.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f18266a, r6.f18266a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f18267b, r6.f18267b) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f18268c, r6.f18268c) == true) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f18269d, r6.f18269d) == true) goto L21;
        return false;
    L21:
        if (d.h.b.o.a(this.f18270e, r6.f18270e) == true) goto L24;
        return false;
    L24:
        if (d.h.b.o.a(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (d.h.b.o.a(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (d.h.b.o.a(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (d.h.b.o.a(this.i, r6.i) == true) goto L36;
        return false;
    L36:
        if (d.h.b.o.a(this.j, r6.j) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public int hashCode() {
        String r0 = this.f18266a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.f18267b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (((((((r3 + r5) * 31) + this.f18268c.hashCode()) * 31) + this.f18269d.hashCode()) * 31) + this.f18270e.hashCode()) * 31;
        String r7 = this.f;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        JsonObject r10 = this.g;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (((((r9 + r11) * 31) + this.h.hashCode()) * 31) + this.i.hashCode()) * 31;
        i r13 = this.j;
        if (r13 == null) goto L23;
        r1 = r13.hashCode();
    L23:
        return r12 + r1;
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "AppFunctionEntry(schemaCategory=" + this.f18266a + ", schemaName=" + this.f18267b + ", packageName=" + this.f18268c + ", functionId=" + this.f18269d + ", toolName=" + this.f18270e + ", description=" + this.f + ", parametersSchema=" + this.g + ", obricParameterTypes=" + this.h + ", components=" + this.i + ", returnSchema=" + this.j + ')';
    }

    public m(String r3, String r4, String r5, String r6, String r7, String r8, JsonObject r9, Map<String, String> r10, h r11, i r12) {
        Map<String, String> r13 = (Map) ZeusTransformUtils.wrapperContextForParams(r10, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "packageName");
        d.h.b.o.e(r6, "functionId");
        d.h.b.o.e(r7, "toolName");
        d.h.b.o.e(r13, "obricParameterTypes");
        d.h.b.o.e(r11, "components");
        this.f18266a = r3;
        this.f18267b = r4;
        this.f18268c = r5;
        this.f18269d = r6;
        this.f18270e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r13;
        this.i = r11;
        this.j = r12;
        this.k = com.obric.aiagent.executionengine.capabilitymanager.api.appfunction.b.f16414a.a(r5, r6);
    }

    public final String a() {
        return this.f18266a;
    }

    public final String b() {
        return this.f18267b;
    }

    public final String c() {
        return this.f18268c;
    }

    public final String d() {
        return this.f18269d;
    }

    public final String e() {
        return this.f18270e;
    }

    public final String f() {
        return this.f;
    }

    public final JsonObject g() {
        return this.g;
    }

    public /* synthetic */ m(String r14, String r15, String r16, String r17, String r18, String r19, JsonObject r20, Map r21, h r22, i r23, int r24, d.h.b.h r25) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r21, Map.class, "com.obric.aiagent.plugin");
        if ((r24 & 128) == 0) goto L5;
        r1 = ao.b();
    L5:
        Map r10 = r1;
        if ((r24 & 256) == 0) goto L8;
        h r11 = new h(null, 1, null);
    L10:
        if ((r24 & 512) == 0) goto L12;
        i r12 = null;
    L13:
        this(r14, r15, r16, r17, r18, r19, r20, r10, r11, r12);
        return;
    L12:
        r12 = r23;
        goto L13
    L8:
        r11 = r22;
        goto L10
    }

    public final Map<String, String> h() {
        return this.h;
    }

    public final h i() {
        return this.i;
    }

    public final i j() {
        return this.j;
    }

    public final String k() {
        return this.k;
    }

    public final boolean l() {
        if (this.f18266a == null) goto L5;
    L7:
        return false;
    L5:
        if (this.f18267b != null) goto L7;
        return true;
    }
}
