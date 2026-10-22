package com.obric.assistant.dm.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: HandlePersonalContextResult.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f22456a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f22457b;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
        return false;
    L8:
        b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
        if (this.f22456a == r6.f22456a) goto L12;
        return false;
    L12:
        if (o.a(this.f22457b, r6.f22457b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (Integer.hashCode(this.f22456a) * 31) + this.f22457b.hashCode();
    }

    public String toString() {
        return "HandlePersonalContextResult(ret=" + this.f22456a + ", response=" + this.f22457b + ')';
    }

    public b(int r2, String r3) {
        o.e(r3, "response");
        this.f22456a = r2;
        this.f22457b = r3;
    }

    public final int a() {
        return this.f22456a;
    }

    public final String b() {
        return this.f22457b;
    }
}
