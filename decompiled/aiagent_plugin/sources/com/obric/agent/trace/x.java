package com.obric.agent.trace;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: OmniTaskReport.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("tool_id")
    private final String f15963a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("tool_name")
    private final String f15964b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("dispatch_time")
    private final long f15965c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SerializedName("finish_time")
    private final long f15966d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @SerializedName("duration")
    private final long f15967e;

    @SerializedName("tool_args")
    private final String f;

    @SerializedName("action_type")
    private final String g;

    @SerializedName("execute_id")
    private final String h;

    @SerializedName("err_code")
    private final String i;

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, x.class) == true) goto L8;
        return false;
    L8:
        x r10 = (x) ZeusTransformUtils.preCheckCast(r9, x.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f15963a, r10.f15963a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f15964b, r10.f15964b) == true) goto L15;
        return false;
    L15:
        if (this.f15965c == r10.f15965c) goto L18;
        return false;
    L18:
        if (this.f15966d == r10.f15966d) goto L21;
        return false;
    L21:
        if (this.f15967e == r10.f15967e) goto L24;
        return false;
    L24:
        if (d.h.b.o.a(this.f, r10.f) == true) goto L27;
        return false;
    L27:
        if (d.h.b.o.a(this.g, r10.g) == true) goto L30;
        return false;
    L30:
        if (d.h.b.o.a(this.h, r10.h) == true) goto L33;
        return false;
    L33:
        if (d.h.b.o.a(this.i, r10.i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public int hashCode() {
        return (((((((((((((((this.f15963a.hashCode() * 31) + this.f15964b.hashCode()) * 31) + Long.hashCode(this.f15965c)) * 31) + Long.hashCode(this.f15966d)) * 31) + Long.hashCode(this.f15967e)) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31) + this.i.hashCode();
    }

    public String toString() {
        return "ToolExecRecord(toolId=" + this.f15963a + ", toolName=" + this.f15964b + ", dispatchTime=" + this.f15965c + ", finishTime=" + this.f15966d + ", duration=" + this.f15967e + ", toolArgs=" + this.f + ", actionType=" + this.g + ", executeId=" + this.h + ", errCode=" + this.i + ')';
    }

    public x(String r2, String r3, long r4, long r6, long r8, String r10, String r11, String r12, String r13) {
        d.h.b.o.e(r2, "toolId");
        d.h.b.o.e(r3, "toolName");
        d.h.b.o.e(r10, "toolArgs");
        d.h.b.o.e(r11, "actionType");
        d.h.b.o.e(r12, "executeId");
        d.h.b.o.e(r13, "errCode");
        this.f15963a = r2;
        this.f15964b = r3;
        this.f15965c = r4;
        this.f15966d = r6;
        this.f15967e = r8;
        this.f = r10;
        this.g = r11;
        this.h = r12;
        this.i = r13;
    }

    public final String a() {
        return this.f15963a;
    }

    public final String b() {
        return this.f15964b;
    }

    public final long c() {
        return this.f15965c;
    }

    public final long d() {
        return this.f15966d;
    }

    public final long e() {
        return this.f15967e;
    }

    public final String f() {
        return this.f;
    }
}
