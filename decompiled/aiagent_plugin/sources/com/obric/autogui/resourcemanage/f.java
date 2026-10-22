package com.obric.autogui.resourcemanage;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: WifiEligibility.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f30620a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f30621b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f30622c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f30623d;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, f.class) == true) goto L8;
        return false;
    L8:
        f r6 = (f) ZeusTransformUtils.preCheckCast(r5, f.class, "com.obric.aiagent.plugin");
        if (this.f30620a == r6.f30620a) goto L12;
        return false;
    L12:
        if (this.f30621b == r6.f30621b) goto L15;
        return false;
    L15:
        if (this.f30622c == r6.f30622c) goto L18;
        return false;
    L18:
        if (this.f30623d == r6.f30623d) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((Boolean.hashCode(this.f30620a) * 31) + Boolean.hashCode(this.f30621b)) * 31) + Boolean.hashCode(this.f30622c)) * 31) + Boolean.hashCode(this.f30623d);
    }

    public String toString() {
        return "NetworkCapabilitySnapshot(isWifi=" + this.f30620a + ", hasInternet=" + this.f30621b + ", isValidated=" + this.f30622c + ", isNotMetered=" + this.f30623d + ')';
    }

    public f(boolean r1, boolean r2, boolean r3, boolean r4) {
        this.f30620a = r1;
        this.f30621b = r2;
        this.f30622c = r3;
        this.f30623d = r4;
    }

    public final boolean a() {
        return this.f30620a;
    }

    public final boolean b() {
        return this.f30621b;
    }

    public final boolean c() {
        return this.f30622c;
    }

    public final boolean d() {
        return this.f30623d;
    }
}
