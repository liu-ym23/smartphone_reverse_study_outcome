package com.bytedance.safetyguard.lxc.internal.e.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: LarkAppRegistrationPollStrategy.kt */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f10294a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f10295b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f10296c;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
        return false;
    L8:
        a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f10294a, r6.f10294a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f10295b, r6.f10295b) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f10296c, r6.f10296c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.f10294a.hashCode() * 31) + this.f10295b.hashCode()) * 31;
        String r2 = this.f10296c;
        if (r2 != null) goto L5;
        int r3 = 0;
    L7:
        return r0 + r3;
    L5:
        r3 = r2.hashCode();
        goto L7
    }

    public String toString() {
        return "AppRegistrationCredentials(appId=" + this.f10294a + ", appSecret=" + this.f10295b + ", userOpenId=" + this.f10296c + ')';
    }

    public a(String r2, String r3, String r4) {
        d.h.b.o.e(r2, "appId");
        d.h.b.o.e(r3, "appSecret");
        this.f10294a = r2;
        this.f10295b = r3;
        this.f10296c = r4;
    }

    public final String a() {
        return this.f10294a;
    }

    public final String b() {
        return this.f10295b;
    }

    public final String c() {
        return this.f10296c;
    }
}
