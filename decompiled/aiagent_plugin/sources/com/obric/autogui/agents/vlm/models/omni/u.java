package com.obric.autogui.agents.vlm.models.omni;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: OmniTerminationPolicy.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f28526a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f28527b;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, u.class) == true) goto L8;
        return false;
    L8:
        u r6 = (u) ZeusTransformUtils.preCheckCast(r5, u.class, "com.obric.aiagent.plugin");
        if (this.f28526a == r6.f28526a) goto L12;
        return false;
    L12:
        if (this.f28527b == r6.f28527b) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (Boolean.hashCode(this.f28526a) * 31) + Boolean.hashCode(this.f28527b);
    }

    public String toString() {
        return "OmniTerminationPolicy(stopRemoteTask=" + this.f28526a + ", closeLocalSession=" + this.f28527b + ')';
    }

    public u(boolean r1, boolean r2) {
        this.f28526a = r1;
        this.f28527b = r2;
    }

    public final boolean a() {
        return this.f28526a;
    }

    public final boolean b() {
        return this.f28527b;
    }
}
