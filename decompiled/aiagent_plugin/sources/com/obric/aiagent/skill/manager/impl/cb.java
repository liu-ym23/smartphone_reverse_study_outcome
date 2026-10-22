package com.obric.aiagent.skill.manager.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillFileReader.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class cb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f19636a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f19637b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f19638c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f19639d;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, cb.class) == true) goto L8;
        return false;
    L8:
        cb r6 = (cb) ZeusTransformUtils.preCheckCast(r5, cb.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f19636a, r6.f19636a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f19637b, r6.f19637b) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f19638c, r6.f19638c) == true) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f19639d, r6.f19639d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.f19636a.hashCode() * 31) + this.f19637b.hashCode()) * 31) + this.f19638c.hashCode()) * 31) + this.f19639d.hashCode();
    }

    public String toString() {
        return "SkillFormDraft(selectedFileName=" + this.f19636a + ", name=" + this.f19637b + ", description=" + this.f19638c + ", body=" + this.f19639d + ')';
    }

    public cb(String r2, String r3, String r4, String r5) {
        d.h.b.o.e(r2, "selectedFileName");
        d.h.b.o.e(r3, "name");
        d.h.b.o.e(r4, "description");
        d.h.b.o.e(r5, "body");
        this.f19636a = r2;
        this.f19637b = r3;
        this.f19638c = r4;
        this.f19639d = r5;
    }

    public final String a() {
        return this.f19636a;
    }

    public final String b() {
        return this.f19637b;
    }

    public final String c() {
        return this.f19638c;
    }

    public final String d() {
        return this.f19639d;
    }
}
