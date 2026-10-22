package com.obric.agent.trace.omni;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: PrivacyGrantAuditLogger.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f15695a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f15696b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f15697c;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, n.class) == true) goto L8;
        return false;
    L8:
        n r6 = (n) ZeusTransformUtils.preCheckCast(r5, n.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f15695a, r6.f15695a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f15696b, r6.f15696b) == true) goto L15;
        return false;
    L15:
        if (this.f15697c == r6.f15697c) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.f15695a.hashCode() * 31) + this.f15696b.hashCode()) * 31) + Boolean.hashCode(this.f15697c);
    }

    public String toString() {
        return "PrivacyGrantAuditEvent(messageId=" + this.f15695a + ", actionType=" + this.f15696b + ", isGranted=" + this.f15697c + ')';
    }

    public n(String r2, String r3, boolean r4) {
        d.h.b.o.e(r2, "messageId");
        d.h.b.o.e(r3, "actionType");
        this.f15695a = r2;
        this.f15696b = r3;
        this.f15697c = r4;
    }

    public final String a() {
        return this.f15695a;
    }

    public final String b() {
        return this.f15696b;
    }

    public final boolean c() {
        return this.f15697c;
    }
}
