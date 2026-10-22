package com.bytedance.safetyguard.lxc.internal.e.a.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: OAuthPollingModels.kt */
/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f10318a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f10319b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f10320c;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, f.class) == true) goto L8;
        return false;
    L8:
        f r6 = (f) ZeusTransformUtils.preCheckCast(r5, f.class, "com.obric.aiagent.plugin");
        if (o.a(this.f10318a, r6.f10318a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f10319b, r6.f10319b) == true) goto L15;
        return false;
    L15:
        if (o.a(this.f10320c, r6.f10320c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.f10318a.hashCode() * 31) + this.f10319b.hashCode()) * 31) + this.f10320c.hashCode();
    }

    public String toString() {
        return "OAuthPollErrorMessages(denied=" + this.f10318a + ", expired=" + this.f10319b + ", timeout=" + this.f10320c + ')';
    }

    public f(String r2, String r3, String r4) {
        o.e(r2, "denied");
        o.e(r3, "expired");
        o.e(r4, "timeout");
        this.f10318a = r2;
        this.f10319b = r3;
        this.f10320c = r4;
    }

    public final String a() {
        return this.f10318a;
    }

    public final String b() {
        return this.f10319b;
    }

    public final String c() {
        return this.f10320c;
    }
}
