package com.obric.autogui.common.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ComputerControlRuntimeConfig.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f28967a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f28968b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f28969c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f28970d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f28971e;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
        return false;
    L8:
        b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
        if (this.f28967a == r6.f28967a) goto L12;
        return false;
    L12:
        if (this.f28968b == r6.f28968b) goto L15;
        return false;
    L15:
        if (this.f28969c == r6.f28969c) goto L18;
        return false;
    L18:
        if (this.f28970d == r6.f28970d) goto L21;
        return false;
    L21:
        if (this.f28971e == r6.f28971e) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        return (((((((Boolean.hashCode(this.f28967a) * 31) + Boolean.hashCode(this.f28968b)) * 31) + Boolean.hashCode(this.f28969c)) * 31) + Boolean.hashCode(this.f28970d)) * 31) + Boolean.hashCode(this.f28971e);
    }

    public String toString() {
        return "ComputerControlConfigSnapshot(settingEnabled=" + this.f28967a + ", systemSupported=" + this.f28968b + ", enabled=" + this.f28969c + ", guiActionEnabled=" + this.f28970d + ", mirrorViewEnabled=" + this.f28971e + ')';
    }

    public b(boolean r1, boolean r2, boolean r3, boolean r4, boolean r5) {
        this.f28967a = r1;
        this.f28968b = r2;
        this.f28969c = r3;
        this.f28970d = r4;
        this.f28971e = r5;
    }

    public final boolean a() {
        return this.f28967a;
    }

    public final boolean b() {
        return this.f28968b;
    }

    public final boolean c() {
        return this.f28969c;
    }

    public final boolean d() {
        return this.f28970d;
    }

    public final boolean e() {
        return this.f28971e;
    }
}
