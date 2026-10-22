package com.obric.agent.trace;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: OmniTaskReport.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("call_user_type")
    private final String f15417a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("call_user_start")
    private final long f15418b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("taking_over_start")
    private final long f15419c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SerializedName("call_user_end")
    private final long f15420d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @SerializedName("duration")
    private final long f15421e;

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, a.class) == true) goto L8;
        return false;
    L8:
        a r10 = (a) ZeusTransformUtils.preCheckCast(r9, a.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f15417a, r10.f15417a) == true) goto L12;
        return false;
    L12:
        if (this.f15418b == r10.f15418b) goto L15;
        return false;
    L15:
        if (this.f15419c == r10.f15419c) goto L18;
        return false;
    L18:
        if (this.f15420d == r10.f15420d) goto L21;
        return false;
    L21:
        if (this.f15421e == r10.f15421e) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        return (((((((this.f15417a.hashCode() * 31) + Long.hashCode(this.f15418b)) * 31) + Long.hashCode(this.f15419c)) * 31) + Long.hashCode(this.f15420d)) * 31) + Long.hashCode(this.f15421e);
    }

    public String toString() {
        return "CallUserRecord(callUserType=" + this.f15417a + ", callUserStart=" + this.f15418b + ", takingOverStart=" + this.f15419c + ", callUserEnd=" + this.f15420d + ", duration=" + this.f15421e + ')';
    }

    public a(String r2, long r3, long r5, long r7, long r9) {
        d.h.b.o.e(r2, "callUserType");
        this.f15417a = r2;
        this.f15418b = r3;
        this.f15419c = r5;
        this.f15420d = r7;
        this.f15421e = r9;
    }
}
