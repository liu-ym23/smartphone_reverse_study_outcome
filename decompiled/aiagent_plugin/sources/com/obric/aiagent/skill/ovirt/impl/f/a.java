package com.obric.aiagent.skill.ovirt.impl.f;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: SkillProjectionModels.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f21235a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e f21236b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f21237c;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
        return false;
    L8:
        a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
        if (o.a(this.f21235a, r6.f21235a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f21236b, r6.f21236b) == true) goto L15;
        return false;
    L15:
        if (o.a(this.f21237c, r6.f21237c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r0 = this.f21235a.hashCode() * 31;
        e r1 = this.f21236b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.f21237c;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "SkillProjectionItemResult(slug=" + this.f21235a + ", binding=" + this.f21236b + ", errorReason=" + this.f21237c + ')';
    }

    public a(String r2, e r3, String r4) {
        o.e(r2, "slug");
        this.f21235a = r2;
        this.f21236b = r3;
        this.f21237c = r4;
    }

    public /* synthetic */ a(String r2, e r3, String r4, int r5, h r6) {
        if ((r5 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = null;
    L8:
        this(r2, r3, r4);
    }

    public final boolean a() {
        if (this.f21236b != null) goto L5;
    L7:
        return false;
    L5:
        if (this.f21237c != null) goto L7;
        return true;
    }
}
