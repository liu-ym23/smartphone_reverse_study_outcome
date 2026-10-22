package com.obric.aiagent.skill.manager.api;

import com.bytedance.apm.battery.dao.DBHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillManagerContracts.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final z f19322a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f19323b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final q f19324c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f19325d;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, x.class) == true) goto L8;
        return false;
    L8:
        x r6 = (x) ZeusTransformUtils.preCheckCast(r5, x.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f19322a, r6.f19322a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f19323b, r6.f19323b) == true) goto L15;
        return false;
    L15:
        if (this.f19324c == r6.f19324c) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f19325d, r6.f19325d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r0 = ((((this.f19322a.hashCode() * 31) + this.f19323b.hashCode()) * 31) + this.f19324c.hashCode()) * 31;
        String r2 = this.f19325d;
        if (r2 != null) goto L5;
        int r3 = 0;
    L7:
        return r0 + r3;
    L5:
        r3 = r2.hashCode();
        goto L7
    }

    public String toString() {
        return "SkillPackageInstallRequest(source=" + this.f19322a + ", sourceUrl=" + this.f19323b + ", installMethod=" + this.f19324c + ", expectedSha256=" + this.f19325d + ')';
    }

    public x(z r3, String r4, q r5, String r6) {
        z r7 = (z) ZeusTransformUtils.wrapperContextForParams(r3, z.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r7, DBHelper.BATTERY_COL_SOURCE);
        d.h.b.o.e(r4, "sourceUrl");
        d.h.b.o.e(r5, "installMethod");
        this.f19322a = r7;
        this.f19323b = r4;
        this.f19324c = r5;
        this.f19325d = r6;
    }

    public final z a() {
        return this.f19322a;
    }

    public final String b() {
        return this.f19323b;
    }

    public final q c() {
        return this.f19324c;
    }

    public final String d() {
        return this.f19325d;
    }
}
