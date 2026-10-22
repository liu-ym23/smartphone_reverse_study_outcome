package com.obric.aiagent.skill.credentials.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: CredentialModels.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f18964a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f18965b;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, i.class) == true) goto L8;
        return false;
    L8:
        i r6 = (i) ZeusTransformUtils.preCheckCast(r5, i.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f18964a, r6.f18964a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f18965b, r6.f18965b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f18964a.hashCode() * 31) + this.f18965b.hashCode();
    }

    public String toString() {
        return "CredentialUserInfo(userOpenId=" + this.f18964a + ", userName=" + this.f18965b + ')';
    }

    public i(String r2, String r3) {
        d.h.b.o.e(r2, "userOpenId");
        d.h.b.o.e(r3, "userName");
        this.f18964a = r2;
        this.f18965b = r3;
    }

    public final String a() {
        return this.f18964a;
    }

    public final String b() {
        return this.f18965b;
    }
}
