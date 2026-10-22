package com.obric.aiagent.skill.manager.api;

import com.bytedance.bdturing.localstorage.DbHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: compiled from: SkillSettings.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ah {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f19174a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ag f19175b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f19176c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final af f19177d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List<String> f19178e;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ah.class) == true) goto L8;
        return false;
    L8:
        ah r6 = (ah) ZeusTransformUtils.preCheckCast(r5, ah.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f19174a, r6.f19174a) == true) goto L12;
        return false;
    L12:
        if (this.f19175b == r6.f19175b) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f19176c, r6.f19176c) == true) goto L18;
        return false;
    L18:
        if (this.f19177d == r6.f19177d) goto L21;
        return false;
    L21:
        if (d.h.b.o.a(this.f19178e, r6.f19178e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        return (((((((this.f19174a.hashCode() * 31) + this.f19175b.hashCode()) * 31) + this.f19176c.hashCode()) * 31) + this.f19177d.hashCode()) * 31) + this.f19178e.hashCode();
    }

    public String toString() {
        return "SkillPurgeRule(id=" + this.f19174a + ", root=" + this.f19175b + ", relativePath=" + this.f19176c + ", operation=" + this.f19177d + ", excludes=" + this.f19178e + ')';
    }

    public ah(String r3, ag r4, String r5, af r6, List<String> r7) {
        List<String> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, DbHelper.COL_ID);
        d.h.b.o.e(r4, "root");
        d.h.b.o.e(r5, "relativePath");
        d.h.b.o.e(r6, "operation");
        d.h.b.o.e(r8, "excludes");
        this.f19174a = r3;
        this.f19175b = r4;
        this.f19176c = r5;
        this.f19177d = r6;
        this.f19178e = r8;
    }

    public final String a() {
        return this.f19174a;
    }

    public final ag b() {
        return this.f19175b;
    }

    public final String c() {
        return this.f19176c;
    }

    public /* synthetic */ ah(String r7, ag r8, String r9, af r10, List r11, int r12, d.h.b.h r13) {
        List r14 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin");
        if ((r12 & 4) == 0) goto L5;
        r9 = "";
    L5:
        String r3 = r9;
        if ((r12 & 8) == 0) goto L8;
        r10 = af.f19166a;
    L8:
        af r4 = r10;
        if ((r12 & 16) == 0) goto L11;
        r14 = d.a.p.b();
    L11:
        this(r7, r8, r3, r4, r14);
    }

    public final af d() {
        return this.f19177d;
    }

    public final List<String> e() {
        return this.f19178e;
    }
}
