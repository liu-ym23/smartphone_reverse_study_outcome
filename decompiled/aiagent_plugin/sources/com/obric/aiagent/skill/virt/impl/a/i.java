package com.obric.aiagent.skill.virt.impl.a;

import com.bytedance.bdturing.localstorage.DbHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: ShellCalling.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f22051a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f22052b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f22053c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final j f22054d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Integer f22055e;
    private final String f;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, i.class) == true) goto L8;
        return false;
    L8:
        i r6 = (i) ZeusTransformUtils.preCheckCast(r5, i.class, "com.obric.aiagent.plugin");
        if (o.a(this.f22051a, r6.f22051a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f22052b, r6.f22052b) == true) goto L15;
        return false;
    L15:
        if (o.a(this.f22053c, r6.f22053c) == true) goto L18;
        return false;
    L18:
        if (this.f22054d == r6.f22054d) goto L21;
        return false;
    L21:
        if (o.a(this.f22055e, r6.f22055e) == true) goto L24;
        return false;
    L24:
        if (o.a(this.f, r6.f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        int r0 = ((((((this.f22051a.hashCode() * 31) + this.f22052b.hashCode()) * 31) + this.f22053c.hashCode()) * 31) + this.f22054d.hashCode()) * 31;
        Integer r1 = this.f22055e;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.f;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "ShellCallingSnapshot(id=" + this.f22051a + ", groupId=" + this.f22052b + ", command=" + this.f22053c + ", status=" + this.f22054d + ", exitCode=" + this.f22055e + ", clientEgressResultJson=" + this.f + ')';
    }

    public i(String r2, String r3, String r4, j r5, Integer r6, String r7) {
        o.e(r2, DbHelper.COL_ID);
        o.e(r3, "groupId");
        o.e(r4, "command");
        o.e(r5, "status");
        this.f22051a = r2;
        this.f22052b = r3;
        this.f22053c = r4;
        this.f22054d = r5;
        this.f22055e = r6;
        this.f = r7;
    }

    public final String a() {
        return this.f22052b;
    }

    public final j b() {
        return this.f22054d;
    }

    public final Integer c() {
        return this.f22055e;
    }

    public final String d() {
        return this.f;
    }

    public final boolean e() {
        return this.f22054d.b();
    }

    public final boolean f() {
        if (this.f22054d != j.f) goto L5;
        return true;
    L5:
        return false;
    }
}
