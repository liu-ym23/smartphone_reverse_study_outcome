package com.obric.aiagent.apm;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ALogConfigInfo.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f16104a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f16105b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f16106c;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
        return false;
    L8:
        a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
        if (this.f16104a == r6.f16104a) goto L12;
        return false;
    L12:
        if (this.f16105b == r6.f16105b) goto L15;
        return false;
    L15:
        if (this.f16106c == r6.f16106c) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((Boolean.hashCode(this.f16104a) * 31) + Integer.hashCode(this.f16105b)) * 31) + Integer.hashCode(this.f16106c);
    }

    public String toString() {
        return "ALogConfigInfo(isDebug=" + this.f16104a + ", logLevel=" + this.f16105b + ", maxALogDirSizeMb=" + this.f16106c + ')';
    }

    public a(boolean r1, int r2, int r3) {
        this.f16104a = r1;
        this.f16105b = r2;
        this.f16106c = r3;
    }

    public final boolean a() {
        return this.f16104a;
    }

    public final int b() {
        return this.f16105b;
    }

    public final int c() {
        return this.f16106c;
    }
}
