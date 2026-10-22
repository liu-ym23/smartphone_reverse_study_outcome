package com.obric.aiagent.skill.ovirt.impl.f;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: SkillProjectionModels.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<a> f21238a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f21239b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f21240c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f21241d;

    public static /* synthetic */ b a(b r1, List r2, boolean r3, boolean r4, String r5, int r6, Object r7) {
        List<a> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        if ((r6 & 1) == 0) goto L6;
        r8 = r1.f21238a;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = r1.f21239b;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = r1.f21240c;
    L12:
        if ((r6 & 8) == 0) goto L15;
        r5 = r1.f21241d;
    L15:
        return r1.a(r8, r3, r4, r5);
    }

    public final b a(List<a> r2, boolean r3, boolean r4, String r5) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        o.e(r1, "items");
        return new b(r1, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
        return false;
    L8:
        b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
        if (o.a(this.f21238a, r6.f21238a) == true) goto L12;
        return false;
    L12:
        if (this.f21239b == r6.f21239b) goto L15;
        return false;
    L15:
        if (this.f21240c == r6.f21240c) goto L18;
        return false;
    L18:
        if (o.a(this.f21241d, r6.f21241d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r0 = ((((this.f21238a.hashCode() * 31) + Boolean.hashCode(this.f21239b)) * 31) + Boolean.hashCode(this.f21240c)) * 31;
        String r2 = this.f21241d;
        if (r2 != null) goto L5;
        int r3 = 0;
    L7:
        return r0 + r3;
    L5:
        r3 = r2.hashCode();
        goto L7
    }

    public String toString() {
        return "SkillProjectionResult(items=" + this.f21238a + ", rootPrepared=" + this.f21239b + ", rootLinked=" + this.f21240c + ", rootErrorReason=" + this.f21241d + ')';
    }

    public b(List<a> r3, boolean r4, boolean r5, String r6) {
        List<a> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        o.e(r7, "items");
        this.f21238a = r7;
        this.f21239b = r4;
        this.f21240c = r5;
        this.f21241d = r6;
    }

    public final List<a> a() {
        return this.f21238a;
    }

    public final boolean b() {
        return this.f21239b;
    }

    public final boolean c() {
        return this.f21240c;
    }

    public final String d() {
        return this.f21241d;
    }
}
