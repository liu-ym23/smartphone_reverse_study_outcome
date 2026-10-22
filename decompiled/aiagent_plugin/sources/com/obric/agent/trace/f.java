package com.obric.agent.trace;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: IntentExecutionResult.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("status")
    private final n f15446a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("msg")
    private final String f15447b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("resultCode")
    private final int f15448c;

    public final f a(n r1, String r2, int r3) {
        d.h.b.o.e(r1, "status");
        return new f(r1, r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, f.class) == true) goto L8;
        return false;
    L8:
        f r6 = (f) ZeusTransformUtils.preCheckCast(r5, f.class, "com.obric.aiagent.plugin");
        if (this.f15446a == r6.f15446a) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f15447b, r6.f15447b) == true) goto L15;
        return false;
    L15:
        if (this.f15448c == r6.f15448c) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r0 = this.f15446a.hashCode() * 31;
        String r1 = this.f15447b;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((r0 + r2) * 31) + Integer.hashCode(this.f15448c);
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "ExecutionResult(status=" + this.f15446a + ", msg=" + this.f15447b + ", resultCode=" + this.f15448c + ')';
    }

    public f(n r2, String r3, int r4) {
        d.h.b.o.e(r2, "status");
        this.f15446a = r2;
        this.f15447b = r3;
        this.f15448c = r4;
    }

    public /* synthetic */ f(n r1, String r2, int r3, int r4, d.h.b.h r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public final n a() {
        return this.f15446a;
    }

    public final String b() {
        return this.f15447b;
    }

    public final int c() {
        return this.f15448c;
    }
}
