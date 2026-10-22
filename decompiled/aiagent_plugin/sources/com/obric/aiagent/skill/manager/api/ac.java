package com.obric.aiagent.skill.manager.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.List;

/* JADX INFO: compiled from: SkillManagerContracts.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ac {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f19156a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final File f19157b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<ab> f19158c;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ac.class) == true) goto L8;
        return false;
    L8:
        ac r6 = (ac) ZeusTransformUtils.preCheckCast(r5, ac.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f19156a, r6.f19156a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f19157b, r6.f19157b) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f19158c, r6.f19158c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.f19156a.hashCode() * 31) + this.f19157b.hashCode()) * 31) + this.f19158c.hashCode();
    }

    public String toString() {
        return "SkillProjectionItem(slug=" + this.f19156a + ", packageDir=" + this.f19157b + ", cliTools=" + this.f19158c + ')';
    }

    public ac(String r3, File r4, List<ab> r5) {
        List<ab> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "slug");
        d.h.b.o.e(r4, "packageDir");
        d.h.b.o.e(r6, "cliTools");
        this.f19156a = r3;
        this.f19157b = r4;
        this.f19158c = r6;
    }

    public final String a() {
        return this.f19156a;
    }

    public final File b() {
        return this.f19157b;
    }

    public final List<ab> c() {
        return this.f19158c;
    }
}
