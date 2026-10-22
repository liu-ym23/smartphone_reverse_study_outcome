package com.obric.autogui.resourcemanage;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ResourceUpdateSwitchPolicy.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class aa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f30589a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f30590b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f30591c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f30592d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f30593e;
    private final boolean f;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, aa.class) == true) goto L8;
        return false;
    L8:
        aa r6 = (aa) ZeusTransformUtils.preCheckCast(r5, aa.class, "com.obric.aiagent.plugin");
        if (this.f30589a == r6.f30589a) goto L12;
        return false;
    L12:
        if (this.f30590b == r6.f30590b) goto L15;
        return false;
    L15:
        if (this.f30591c == r6.f30591c) goto L18;
        return false;
    L18:
        if (this.f30592d == r6.f30592d) goto L21;
        return false;
    L21:
        if (this.f30593e == r6.f30593e) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        return (((((((((Boolean.hashCode(this.f30589a) * 31) + Boolean.hashCode(this.f30590b)) * 31) + Boolean.hashCode(this.f30591c)) * 31) + Boolean.hashCode(this.f30592d)) * 31) + Boolean.hashCode(this.f30593e)) * 31) + Boolean.hashCode(this.f);
    }

    public String toString() {
        return "ResourceUpdateSwitchSnapshot(scriptEnable=" + this.f30589a + ", foundationEnable=" + this.f30590b + ", screenOffEnable=" + this.f30591c + ", periodicEnable=" + this.f30592d + ", wifiEnable=" + this.f30593e + ", startFailedEnable=" + this.f + ')';
    }

    public aa(boolean r1, boolean r2, boolean r3, boolean r4, boolean r5, boolean r6) {
        this.f30589a = r1;
        this.f30590b = r2;
        this.f30591c = r3;
        this.f30592d = r4;
        this.f30593e = r5;
        this.f = r6;
    }

    public final boolean a() {
        return this.f30589a;
    }

    public final boolean b() {
        return this.f30590b;
    }

    public final boolean c() {
        return this.f30591c;
    }

    public final boolean d() {
        return this.f30592d;
    }

    public final boolean e() {
        return this.f30593e;
    }

    public final boolean f() {
        return this.f;
    }
}
