package com.obric.agent.trace;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: OmniTaskReport.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("clarify_start")
    private final long f15434a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("clarify_end")
    private final long f15435b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("duration")
    private final long f15436c;

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, b.class) == true) goto L8;
        return false;
    L8:
        b r10 = (b) ZeusTransformUtils.preCheckCast(r9, b.class, "com.obric.aiagent.plugin");
        if (this.f15434a == r10.f15434a) goto L12;
        return false;
    L12:
        if (this.f15435b == r10.f15435b) goto L15;
        return false;
    L15:
        if (this.f15436c == r10.f15436c) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((Long.hashCode(this.f15434a) * 31) + Long.hashCode(this.f15435b)) * 31) + Long.hashCode(this.f15436c);
    }

    public String toString() {
        return "ClarifyRecord(clarifyStart=" + this.f15434a + ", clarifyEnd=" + this.f15435b + ", duration=" + this.f15436c + ')';
    }

    public b(long r1, long r3, long r5) {
        this.f15434a = r1;
        this.f15435b = r3;
        this.f15436c = r5;
    }
}
