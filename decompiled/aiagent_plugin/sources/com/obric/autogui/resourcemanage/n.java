package com.obric.autogui.resourcemanage;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: compiled from: ScriptResourceManager.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f30639a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<String> f30640b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<String> f30641c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<String> f30642d;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, n.class) == true) goto L8;
        return false;
    L8:
        n r6 = (n) ZeusTransformUtils.preCheckCast(r5, n.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f30639a, r6.f30639a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f30640b, r6.f30640b) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f30641c, r6.f30641c) == true) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f30642d, r6.f30642d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.f30639a.hashCode() * 31) + this.f30640b.hashCode()) * 31) + this.f30641c.hashCode()) * 31) + this.f30642d.hashCode();
    }

    public String toString() {
        return "ResourceClearResult(packageName=" + this.f30639a + ", deletedPaths=" + this.f30640b + ", failedPaths=" + this.f30641c + ", remainingPaths=" + this.f30642d + ')';
    }

    public n(String r3, List<String> r4, List<String> r5, List<String> r6) {
        List<String> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        List<String> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        List<String> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "packageName");
        d.h.b.o.e(r7, "deletedPaths");
        d.h.b.o.e(r8, "failedPaths");
        d.h.b.o.e(r9, "remainingPaths");
        this.f30639a = r3;
        this.f30640b = r7;
        this.f30641c = r8;
        this.f30642d = r9;
    }

    public final String a() {
        return this.f30639a;
    }

    public final List<String> b() {
        return this.f30640b;
    }

    public final List<String> c() {
        return this.f30641c;
    }

    public final List<String> d() {
        return this.f30642d;
    }

    public final boolean e() {
        if (this.f30641c.isEmpty() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f30642d.isEmpty() == false) goto L7;
        return true;
    }
}
