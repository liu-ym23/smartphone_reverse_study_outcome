package com.obric.aiagent.skill.manager.impl.ui;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillFormSheetController.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class am {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f20539a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f20540b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d.h.a.a<d.x> f20541c;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, am.class) == true) goto L8;
        return false;
    L8:
        am r6 = (am) ZeusTransformUtils.preCheckCast(r5, am.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f20539a, r6.f20539a) == true) goto L12;
        return false;
    L12:
        if (this.f20540b == r6.f20540b) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f20541c, r6.f20541c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.f20539a.hashCode() * 31) + Boolean.hashCode(this.f20540b)) * 31) + this.f20541c.hashCode();
    }

    public String toString() {
        return "SkillFormCoverConfig(initialUrl=" + this.f20539a + ", editable=" + this.f20540b + ", onSelect=" + this.f20541c + ')';
    }

    public am(String r3, boolean r4, d.h.a.a<d.x> r5) {
        d.h.a.a<d.x> r6 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "initialUrl");
        d.h.b.o.e(r6, "onSelect");
        this.f20539a = r3;
        this.f20540b = r4;
        this.f20541c = r6;
    }

    public /* synthetic */ am(String r2, boolean r3, d.h.a.a r4, int r5, d.h.b.h r6) {
        d.h.a.a r7 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
        if ((r5 & 1) == 0) goto L6;
        r2 = "";
    L6:
        if ((r5 & 2) == 0) goto L8;
        r3 = true;
    L8:
        this(r2, r3, r7);
    }

    public final String a() {
        return this.f20539a;
    }

    public final boolean b() {
        return this.f20540b;
    }

    public final d.h.a.a<d.x> c() {
        return this.f20541c;
    }
}
