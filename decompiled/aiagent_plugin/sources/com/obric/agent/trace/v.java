package com.obric.agent.trace;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: compiled from: TaskStateData.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("state_name")
    private final String f15953a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("start_time")
    private final long f15954b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("end_time")
    private Long f15955c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SerializedName("dm_event")
    private final e f15956d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @SerializedName("extra_state_info")
    private final Map<String, Object> f15957e;

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, v.class) == true) goto L8;
        return false;
    L8:
        v r10 = (v) ZeusTransformUtils.preCheckCast(r9, v.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f15953a, r10.f15953a) == true) goto L12;
        return false;
    L12:
        if (this.f15954b == r10.f15954b) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f15955c, r10.f15955c) == true) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f15956d, r10.f15956d) == true) goto L21;
        return false;
    L21:
        if (d.h.b.o.a(this.f15957e, r10.f15957e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.f15953a.hashCode() * 31) + Long.hashCode(this.f15954b)) * 31;
        Long r1 = this.f15955c;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        e r5 = this.f15956d;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        Map<String, Object> r8 = this.f15957e;
        if (r8 == null) goto L15;
        r2 = r8.hashCode();
    L15:
        return r7 + r2;
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "TaskStateData(stateName=" + this.f15953a + ", startTime=" + this.f15954b + ", endTime=" + this.f15955c + ", dMEvent=" + this.f15956d + ", extraStateInfo=" + this.f15957e + ')';
    }

    public v(String r3, long r4, Long r6, e r7, Map<String, ? extends Object> r8) {
        Map<String, Object> r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "stateName");
        this.f15953a = r3;
        this.f15954b = r4;
        this.f15955c = r6;
        this.f15956d = r7;
        this.f15957e = r9;
    }

    public /* synthetic */ v(String r11, long r12, Long r14, e r15, Map r16, int r17, d.h.b.h r18) {
        Map r0 = (Map) ZeusTransformUtils.wrapperContextForParams(r16, Map.class, "com.obric.aiagent.plugin");
        if ((r17 & 4) == 0) goto L5;
        Long r7 = null;
    L7:
        if ((r17 & 8) == 0) goto L9;
        e r8 = null;
    L11:
        if ((r17 & 16) == 0) goto L13;
        Map r9 = null;
    L14:
        this(r11, r12, r7, r8, r9);
        return;
    L13:
        r9 = r0;
        goto L14
    L9:
        r8 = r15;
        goto L11
    L5:
        r7 = r14;
        goto L7
    }

    public final String a() {
        return this.f15953a;
    }

    public final long b() {
        return this.f15954b;
    }

    public final void a(Long r1) {
        this.f15955c = r1;
    }

    public final Long c() {
        return this.f15955c;
    }

    public final e d() {
        return this.f15956d;
    }

    public final Map<String, Object> e() {
        return this.f15957e;
    }
}
