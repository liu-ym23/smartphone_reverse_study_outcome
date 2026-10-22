package com.obric.aiagent.skill.manager.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: compiled from: SkillOperationResult.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e f19242a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f19243b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<String> f19244c;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
        return false;
    L8:
        c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f19242a, r6.f19242a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f19243b, r6.f19243b) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f19244c, r6.f19244c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.f19242a.hashCode() * 31) + this.f19243b.hashCode()) * 31) + this.f19244c.hashCode();
    }

    public String toString() {
        return "LoadedSkill(skill=" + this.f19242a + ", projectedDir=" + this.f19243b + ", requiredCliNames=" + this.f19244c + ')';
    }

    public c(e r3, String r4, List<String> r5) {
        List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "skill");
        d.h.b.o.e(r4, "projectedDir");
        d.h.b.o.e(r6, "requiredCliNames");
        this.f19242a = r3;
        this.f19243b = r4;
        this.f19244c = r6;
    }

    public final e a() {
        return this.f19242a;
    }

    public final String b() {
        return this.f19243b;
    }

    public final List<String> c() {
        return this.f19244c;
    }
}
