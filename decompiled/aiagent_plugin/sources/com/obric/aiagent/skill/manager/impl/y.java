package com.obric.aiagent.skill.manager.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;

/* JADX INFO: compiled from: SkillCoverStore.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f20934a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final File f20935b;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, y.class) == true) goto L8;
        return false;
    L8:
        y r6 = (y) ZeusTransformUtils.preCheckCast(r5, y.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f20934a, r6.f20934a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f20935b, r6.f20935b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f20934a.hashCode() * 31) + this.f20935b.hashCode();
    }

    public String toString() {
        return "ManagedSkillCover(url=" + this.f20934a + ", file=" + this.f20935b + ')';
    }

    public y(String r2, File r3) {
        d.h.b.o.e(r2, "url");
        d.h.b.o.e(r3, "file");
        this.f20934a = r2;
        this.f20935b = r3;
    }

    public final String a() {
        return this.f20934a;
    }
}
