package com.obric.aiagent.executionengine.capabilitymanager.api.appfunction;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: BuiltAppFunctionSkill.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f16416a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f16417b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f16418c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f16419d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f16420e;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
        return false;
    L8:
        c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
        if (o.a(this.f16416a, r6.f16416a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f16417b, r6.f16417b) == true) goto L15;
        return false;
    L15:
        if (o.a(this.f16418c, r6.f16418c) == true) goto L18;
        return false;
    L18:
        if (o.a(this.f16419d, r6.f16419d) == true) goto L21;
        return false;
    L21:
        if (o.a(this.f16420e, r6.f16420e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        return (((((((this.f16416a.hashCode() * 31) + this.f16417b.hashCode()) * 31) + this.f16418c.hashCode()) * 31) + this.f16419d.hashCode()) * 31) + this.f16420e.hashCode();
    }

    public String toString() {
        return "BuiltAppFunctionSkill(packageName=" + this.f16416a + ", skillName=" + this.f16417b + ", skillMdContent=" + this.f16418c + ", toolSchema=" + this.f16419d + ", contentFingerprint=" + this.f16420e + ')';
    }

    public c(String r2, String r3, String r4, String r5, String r6) {
        o.e(r2, "packageName");
        o.e(r3, "skillName");
        o.e(r4, "skillMdContent");
        o.e(r5, "toolSchema");
        o.e(r6, "contentFingerprint");
        this.f16416a = r2;
        this.f16417b = r3;
        this.f16418c = r4;
        this.f16419d = r5;
        this.f16420e = r6;
    }

    public final String a() {
        return this.f16416a;
    }

    public final String b() {
        return this.f16417b;
    }

    public final String c() {
        return this.f16418c;
    }

    public final String d() {
        return this.f16419d;
    }

    public final String e() {
        return this.f16420e;
    }
}
