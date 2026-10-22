package com.obric.matrix.sdk.push.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: BDPushMsg.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f33763a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f33764b;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
        return false;
    L8:
        a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
        if (o.a(this.f33763a, r6.f33763a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f33764b, r6.f33764b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f33763a.hashCode() * 31) + this.f33764b.hashCode();
    }

    public String toString() {
        return "Message(msgId=" + this.f33763a + ", data=" + this.f33764b + ')';
    }

    public a(String r2, String r3) {
        o.e(r2, "msgId");
        o.e(r3, "data");
        this.f33763a = r2;
        this.f33764b = r3;
    }

    public final String a() {
        return this.f33764b;
    }
}
