package com.obric.aiagent.skill.manager.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;

/* JADX INFO: compiled from: SkillFileReader.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class cf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f19652a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final File f19653b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final File f19654c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final da f19655d;

    public static /* synthetic */ cf a(cf r0, String r1, File r2, File r3, da r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.f19652a;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.f19653b;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.f19654c;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.f19655d;
    L15:
        return r0.a(r1, r2, r3, r4);
    }

    public final cf a(String r1, File r2, File r3, da r4) {
        d.h.b.o.e(r1, "selectedFileName");
        d.h.b.o.e(r2, "packageDir");
        d.h.b.o.e(r3, "stagingDir");
        d.h.b.o.e(r4, "document");
        return new cf(r1, r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, cf.class) == true) goto L8;
        return false;
    L8:
        cf r6 = (cf) ZeusTransformUtils.preCheckCast(r5, cf.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f19652a, r6.f19652a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f19653b, r6.f19653b) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f19654c, r6.f19654c) == true) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f19655d, r6.f19655d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.f19652a.hashCode() * 31) + this.f19653b.hashCode()) * 31) + this.f19654c.hashCode()) * 31) + this.f19655d.hashCode();
    }

    public String toString() {
        return "SkillImportDraft(selectedFileName=" + this.f19652a + ", packageDir=" + this.f19653b + ", stagingDir=" + this.f19654c + ", document=" + this.f19655d + ')';
    }

    public cf(String r2, File r3, File r4, da r5) {
        d.h.b.o.e(r2, "selectedFileName");
        d.h.b.o.e(r3, "packageDir");
        d.h.b.o.e(r4, "stagingDir");
        d.h.b.o.e(r5, "document");
        this.f19652a = r2;
        this.f19653b = r3;
        this.f19654c = r4;
        this.f19655d = r5;
    }

    public final String a() {
        return this.f19652a;
    }

    public final File b() {
        return this.f19653b;
    }

    public final File c() {
        return this.f19654c;
    }

    public final da d() {
        return this.f19655d;
    }

    public final void e() {
        d.f.k.h(this.f19654c);
    }
}
