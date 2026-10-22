package com.obric.autogui.resourcemanage;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Set;

/* JADX INFO: compiled from: ResourceUpdateSwitchPolicy.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set<k> f30697a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f30698b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f30699c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f30700d;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, y.class) == true) goto L8;
        return false;
    L8:
        y r6 = (y) ZeusTransformUtils.preCheckCast(r5, y.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f30697a, r6.f30697a) == true) goto L12;
        return false;
    L12:
        if (this.f30698b == r6.f30698b) goto L15;
        return false;
    L15:
        if (this.f30699c == r6.f30699c) goto L18;
        return false;
    L18:
        if (this.f30700d == r6.f30700d) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.f30697a.hashCode() * 31) + Boolean.hashCode(this.f30698b)) * 31) + Boolean.hashCode(this.f30699c)) * 31) + Boolean.hashCode(this.f30700d);
    }

    public String toString() {
        return "ResourceUpdateSwitchDecision(replayScenes=" + this.f30697a + ", cancelActiveRound=" + this.f30698b + ", periodicShouldRun=" + this.f30699c + ", dropPendingWork=" + this.f30700d + ')';
    }

    public y(Set<? extends k> r3, boolean r4, boolean r5, boolean r6) {
        Set<k> r7 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r7, "replayScenes");
        this.f30697a = r7;
        this.f30698b = r4;
        this.f30699c = r5;
        this.f30700d = r6;
    }

    public final Set<k> a() {
        return this.f30697a;
    }

    public final boolean b() {
        return this.f30698b;
    }

    public final boolean c() {
        return this.f30699c;
    }

    public final boolean d() {
        return this.f30700d;
    }
}
