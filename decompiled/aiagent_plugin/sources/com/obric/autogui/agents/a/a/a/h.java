package com.obric.autogui.agents.a.a.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Set;

/* JADX INFO: compiled from: ActionEffectActionEvidence.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set<String> f26182a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f26183b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f26184c;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, h.class) == true) goto L8;
        return false;
    L8:
        h r6 = (h) ZeusTransformUtils.preCheckCast(r5, h.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f26182a, r6.f26182a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f26183b, r6.f26183b) == true) goto L15;
        return false;
    L15:
        if (this.f26184c == r6.f26184c) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r0 = this.f26182a.hashCode() * 31;
        String r1 = this.f26183b;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((r0 + r2) * 31) + Boolean.hashCode(this.f26184c);
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "OpenAppActionEffectEvidence(expectedPackages=" + this.f26182a + ", resolvedPackage=" + this.f26183b + ", callbackSucceeded=" + this.f26184c + ')';
    }

    public final Set<String> a() {
        return this.f26182a;
    }

    public final String b() {
        return this.f26183b;
    }

    public final boolean c() {
        return this.f26184c;
    }

    public h(Set<String> r3, String r4, boolean r5) {
        Set<String> r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r6, "expectedPackages");
        super(null);
        this.f26182a = r6;
        this.f26183b = r4;
        this.f26184c = r5;
    }
}
