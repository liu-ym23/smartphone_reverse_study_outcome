package com.obric.agent.trace;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: compiled from: StateReport.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("state")
    private final o f15950a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("time_cost")
    private final long f15951b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("data")
    private final Map<String, Object> f15952c;

    public u() {
        this(null, 0, null, 7, null);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, u.class) == true) goto L8;
        return false;
    L8:
        u r10 = (u) ZeusTransformUtils.preCheckCast(r9, u.class, "com.obric.aiagent.plugin");
        if (this.f15950a == r10.f15950a) goto L12;
        return false;
    L12:
        if (this.f15951b == r10.f15951b) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f15952c, r10.f15952c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        o r0 = this.f15950a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = ((r2 * 31) + Long.hashCode(this.f15951b)) * 31;
        Map<String, Object> r4 = this.f15952c;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "StateReport(state=" + this.f15950a + ", timeCost=" + this.f15951b + ", data=" + this.f15952c + ')';
    }

    public u(o r3, long r4, Map<String, ? extends Object> r6) {
        Map<String, Object> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
        this.f15950a = r3;
        this.f15951b = r4;
        this.f15952c = r7;
    }

    public final o a() {
        return this.f15950a;
    }

    public /* synthetic */ u(o r2, long r3, Map r5, int r6, d.h.b.h r7) {
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        if ((r6 & 1) == 0) goto L6;
        r2 = o.f15587a;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = 0;
    L9:
        if ((r6 & 4) == 0) goto L11;
        r8 = null;
    L11:
        this(r2, r3, r8);
    }

    public final long b() {
        return this.f15951b;
    }

    public final Map<String, Object> c() {
        return this.f15952c;
    }
}
