package com.obric.aiagent.skill.manager.impl.ui;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillSourceIconBinder.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class cj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f20751a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f20752b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f20753c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f20754d;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, cj.class) == true) goto L8;
        return false;
    L8:
        cj r6 = (cj) ZeusTransformUtils.preCheckCast(r5, cj.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f20751a, r6.f20751a) == true) goto L12;
        return false;
    L12:
        if (this.f20752b == r6.f20752b) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f20753c, r6.f20753c) == true) goto L18;
        return false;
    L18:
        if (this.f20754d == r6.f20754d) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.f20751a.hashCode() * 31) + Integer.hashCode(this.f20752b)) * 31) + this.f20753c.hashCode()) * 31) + Boolean.hashCode(this.f20754d);
    }

    public String toString() {
        return "SkillSourceIconBindingToken(canonicalUrl=" + this.f20751a + ", targetSizePx=" + this.f20752b + ", requestUrl=" + this.f20753c + ", loaded=" + this.f20754d + ')';
    }

    public cj(String r2, int r3, String r4, boolean r5) {
        d.h.b.o.e(r2, "canonicalUrl");
        d.h.b.o.e(r4, "requestUrl");
        this.f20751a = r2;
        this.f20752b = r3;
        this.f20753c = r4;
        this.f20754d = r5;
    }

    public /* synthetic */ cj(String r1, int r2, String r3, boolean r4, int r5, d.h.b.h r6) {
        if ((r5 & 8) == 0) goto L5;
        r4 = false;
    L5:
        this(r1, r2, r3, r4);
    }

    public final String a() {
        return this.f20751a;
    }

    public final int b() {
        return this.f20752b;
    }

    public final void a(String r2) {
        d.h.b.o.e(r2, "<set-?>");
        this.f20753c = r2;
    }
}
