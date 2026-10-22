package com.obric.aiagent.executionengine.eventstaskmanager.a.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: KnowledgeRepository.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f16639a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f16640b;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
        return false;
    L8:
        b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
        if (this.f16639a == r6.f16639a) goto L12;
        return false;
    L12:
        if (o.a(this.f16640b, r6.f16640b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (Boolean.hashCode(this.f16639a) * 31) + this.f16640b.hashCode();
    }

    public String toString() {
        return "KnowledgeNetworkResponse(ok=" + this.f16639a + ", data=" + this.f16640b + ')';
    }

    public b(boolean r2, String r3) {
        o.e(r3, "data");
        this.f16639a = r2;
        this.f16640b = r3;
    }

    public final boolean a() {
        return this.f16639a;
    }

    public final String b() {
        return this.f16640b;
    }
}
