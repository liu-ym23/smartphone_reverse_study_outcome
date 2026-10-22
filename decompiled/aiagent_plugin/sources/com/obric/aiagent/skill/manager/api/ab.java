package com.obric.aiagent.skill.manager.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;

/* JADX INFO: compiled from: SkillManagerContracts.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ab {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f19154a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final File f19155b;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ab.class) == true) goto L8;
        return false;
    L8:
        ab r6 = (ab) ZeusTransformUtils.preCheckCast(r5, ab.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f19154a, r6.f19154a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f19155b, r6.f19155b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f19154a.hashCode() * 31) + this.f19155b.hashCode();
    }

    public String toString() {
        return "SkillProjectionCliTool(name=" + this.f19154a + ", sourceFile=" + this.f19155b + ')';
    }

    public ab(String r2, File r3) {
        d.h.b.o.e(r2, "name");
        d.h.b.o.e(r3, "sourceFile");
        this.f19154a = r2;
        this.f19155b = r3;
    }

    public final String a() {
        return this.f19154a;
    }

    public final File b() {
        return this.f19155b;
    }
}
