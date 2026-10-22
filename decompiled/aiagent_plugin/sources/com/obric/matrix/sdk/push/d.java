package com.obric.matrix.sdk.push;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: PushApi.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f33772a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f33773b;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, d.class) == true) goto L8;
        return false;
    L8:
        d r6 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.aiagent.plugin");
        if (o.a(this.f33772a, r6.f33772a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f33773b, r6.f33773b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f33772a.hashCode() * 31) + this.f33773b.hashCode();
    }

    public String toString() {
        return "PushConfiguration(appId=" + this.f33772a + ", appKey=" + this.f33773b + ')';
    }

    public d(String r2, String r3) {
        o.e(r2, "appId");
        o.e(r3, "appKey");
        this.f33772a = r2;
        this.f33773b = r3;
    }

    public final String a() {
        return this.f33772a;
    }

    public final String b() {
        return this.f33773b;
    }
}
