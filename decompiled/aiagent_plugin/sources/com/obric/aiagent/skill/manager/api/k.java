package com.obric.aiagent.skill.manager.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;

/* JADX INFO: compiled from: SkillManagerContracts.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j f19271a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final File f19272b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f19273c;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, k.class) == true) goto L8;
        return false;
    L8:
        k r6 = (k) ZeusTransformUtils.preCheckCast(r5, k.class, "com.obric.aiagent.plugin");
        if (this.f19271a == r6.f19271a) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f19272b, r6.f19272b) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f19273c, r6.f19273c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.f19271a.hashCode() * 31) + this.f19272b.hashCode()) * 31;
        String r2 = this.f19273c;
        if (r2 != null) goto L5;
        int r3 = 0;
    L7:
        return r0 + r3;
    L5:
        r3 = r2.hashCode();
        goto L7
    }

    public String toString() {
        return "SkillApplyRequest(mode=" + this.f19271a + ", packageFile=" + this.f19272b + ", skillSlug=" + this.f19273c + ')';
    }

    public k(j r2, File r3, String r4) {
        d.h.b.o.e(r2, "mode");
        d.h.b.o.e(r3, "packageFile");
        this.f19271a = r2;
        this.f19272b = r3;
        this.f19273c = r4;
    }

    public final j a() {
        return this.f19271a;
    }

    public final File b() {
        return this.f19272b;
    }

    public final String c() {
        return this.f19273c;
    }
}
