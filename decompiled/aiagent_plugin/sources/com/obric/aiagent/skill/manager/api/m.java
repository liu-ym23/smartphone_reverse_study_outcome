package com.obric.aiagent.skill.manager.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillManagerContracts.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f19279a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f19280b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f19281c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f19282d;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, m.class) == true) goto L8;
        return false;
    L8:
        m r6 = (m) ZeusTransformUtils.preCheckCast(r5, m.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f19279a, r6.f19279a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f19280b, r6.f19280b) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f19281c, r6.f19281c) == true) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f19282d, r6.f19282d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.f19279a.hashCode() * 31) + this.f19280b.hashCode()) * 31) + this.f19281c.hashCode()) * 31) + this.f19282d.hashCode();
    }

    public String toString() {
        return "SkillCreateRequest(displayName=" + this.f19279a + ", description=" + this.f19280b + ", content=" + this.f19281c + ", coverUrl=" + this.f19282d + ')';
    }

    public m(String r2, String r3, String r4, String r5) {
        d.h.b.o.e(r2, "displayName");
        d.h.b.o.e(r3, "description");
        d.h.b.o.e(r4, "content");
        d.h.b.o.e(r5, "coverUrl");
        this.f19279a = r2;
        this.f19280b = r3;
        this.f19281c = r4;
        this.f19282d = r5;
    }

    public final String a() {
        return this.f19279a;
    }

    public final String b() {
        return this.f19280b;
    }

    public final String c() {
        return this.f19281c;
    }

    public final String d() {
        return this.f19282d;
    }
}
