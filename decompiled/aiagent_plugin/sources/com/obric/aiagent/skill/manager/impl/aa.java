package com.obric.aiagent.skill.manager.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: compiled from: ObricSkillPackageMetadata.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class aa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f19430a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f19431b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f19432c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<String> f19433d;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, aa.class) == true) goto L8;
        return false;
    L8:
        aa r6 = (aa) ZeusTransformUtils.preCheckCast(r5, aa.class, "com.obric.aiagent.plugin");
        if (this.f19430a == r6.f19430a) goto L12;
        return false;
    L12:
        if (this.f19431b == r6.f19431b) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f19432c, r6.f19432c) == true) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f19433d, r6.f19433d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.f19430a) * 31) + Boolean.hashCode(this.f19431b)) * 31) + this.f19432c.hashCode()) * 31) + this.f19433d.hashCode();
    }

    public String toString() {
        return "ObricPackageDescriptor(version=" + this.f19430a + ", isSecret=" + this.f19431b + ", toolSchemaPath=" + this.f19432c + ", requiredCliBins=" + this.f19433d + ')';
    }

    public aa(int r3, boolean r4, String r5, List<String> r6) {
        List<String> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "toolSchemaPath");
        d.h.b.o.e(r7, "requiredCliBins");
        this.f19430a = r3;
        this.f19431b = r4;
        this.f19432c = r5;
        this.f19433d = r7;
    }

    public final String a() {
        return this.f19432c;
    }

    public final List<String> b() {
        return this.f19433d;
    }
}
