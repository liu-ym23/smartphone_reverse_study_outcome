package com.obric.aiagent.skill.manager.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;

/* JADX INFO: compiled from: SkillManagerContracts.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final File f19245a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f19246b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f19247c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final b f19248d;

    public static /* synthetic */ d a(d r0, File r1, String r2, boolean r3, b r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.f19245a;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.f19246b;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.f19247c;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.f19248d;
    L15:
        return r0.a(r1, r2, r3, r4);
    }

    public final d a(File r1, String r2, boolean r3, b r4) {
        d.h.b.o.e(r1, "packageDir");
        d.h.b.o.e(r2, "coverUrl");
        return new d(r1, r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, d.class) == true) goto L8;
        return false;
    L8:
        d r6 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f19245a, r6.f19245a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f19246b, r6.f19246b) == true) goto L15;
        return false;
    L15:
        if (this.f19247c == r6.f19247c) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f19248d, r6.f19248d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r0 = ((((this.f19245a.hashCode() * 31) + this.f19246b.hashCode()) * 31) + Boolean.hashCode(this.f19247c)) * 31;
        b r2 = this.f19248d;
        if (r2 != null) goto L5;
        int r3 = 0;
    L7:
        return r0 + r3;
    L5:
        r3 = r2.hashCode();
        goto L7
    }

    public String toString() {
        return "PreparedSkillImport(packageDir=" + this.f19245a + ", coverUrl=" + this.f19246b + ", isUpdate=" + this.f19247c + ", appFunctionImportInfo=" + this.f19248d + ')';
    }

    public d(File r2, String r3, boolean r4, b r5) {
        d.h.b.o.e(r2, "packageDir");
        d.h.b.o.e(r3, "coverUrl");
        this.f19245a = r2;
        this.f19246b = r3;
        this.f19247c = r4;
        this.f19248d = r5;
    }

    public /* synthetic */ d(File r1, String r2, boolean r3, b r4, int r5, d.h.b.h r6) {
        if ((r5 & 2) == 0) goto L6;
        r2 = "";
    L6:
        if ((r5 & 4) == 0) goto L9;
        r3 = false;
    L9:
        if ((r5 & 8) == 0) goto L11;
        r4 = null;
    L11:
        this(r1, r2, r3, r4);
    }

    public final File a() {
        return this.f19245a;
    }

    public final String b() {
        return this.f19246b;
    }

    public final boolean c() {
        return this.f19247c;
    }

    public final b d() {
        return this.f19248d;
    }
}
