package com.obric.matrix.sdk.push.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: BDPushMsg.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f33765a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f33766b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f33767c;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
        return false;
    L8:
        b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
        if (o.a(this.f33765a, r6.f33765a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f33766b, r6.f33766b) == true) goto L15;
        return false;
    L15:
        if (o.a(this.f33767c, r6.f33767c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.f33765a.hashCode() * 31) + this.f33766b.hashCode()) * 31;
        String r2 = this.f33767c;
        if (r2 != null) goto L5;
        int r3 = 0;
    L7:
        return r0 + r3;
    L5:
        r3 = r2.hashCode();
        goto L7
    }

    public String toString() {
        return "RevokeMsg(msgId=" + this.f33765a + ", revokeId=" + this.f33766b + ", revokeData=" + this.f33767c + ')';
    }

    public final String a() {
        return this.f33767c;
    }
}
