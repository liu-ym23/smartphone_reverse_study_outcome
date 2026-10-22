package com.obric.aiagent.skill.manager.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillSignatureVerifier.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class fz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ga f19960a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ah f19961b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final fw f19962c;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, fz.class) == true) goto L8;
        return false;
    L8:
        fz r6 = (fz) ZeusTransformUtils.preCheckCast(r5, fz.class, "com.obric.aiagent.plugin");
        if (this.f19960a == r6.f19960a) goto L12;
        return false;
    L12:
        if (this.f19961b == r6.f19961b) goto L15;
        return false;
    L15:
        if (this.f19962c == r6.f19962c) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.f19960a.hashCode() * 31) + this.f19961b.hashCode()) * 31;
        fw r2 = this.f19962c;
        if (r2 != null) goto L5;
        int r3 = 0;
    L7:
        return r0 + r3;
    L5:
        r3 = r2.hashCode();
        goto L7
    }

    public String toString() {
        return "SkillSignatureVerificationResult(status=" + this.f19960a + ", reason=" + this.f19961b + ", payloadProfile=" + this.f19962c + ')';
    }

    public fz(ga r2, ah r3, fw r4) {
        d.h.b.o.e(r2, "status");
        d.h.b.o.e(r3, "reason");
        this.f19960a = r2;
        this.f19961b = r3;
        this.f19962c = r4;
    }

    public final ga a() {
        return this.f19960a;
    }

    public final ah b() {
        return this.f19961b;
    }

    public final fw c() {
        return this.f19962c;
    }
}
