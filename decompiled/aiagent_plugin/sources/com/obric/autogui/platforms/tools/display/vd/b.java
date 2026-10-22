package com.obric.autogui.platforms.tools.display.vd;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: TaskFrontLiveTopGate.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f30191a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f30192b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f30193c;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
        return false;
    L8:
        b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
        if (this.f30191a == r6.f30191a) goto L12;
        return false;
    L12:
        if (o.a(this.f30192b, r6.f30192b) == true) goto L15;
        return false;
    L15:
        if (o.a(this.f30193c, r6.f30193c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r0 = Integer.hashCode(this.f30191a) * 31;
        String r1 = this.f30192b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.f30193c;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "TaskFrontIdentity(taskId=" + this.f30191a + ", packageName=" + this.f30192b + ", className=" + this.f30193c + ')';
    }

    public b(int r1, String r2, String r3) {
        this.f30191a = r1;
        this.f30192b = r2;
        this.f30193c = r3;
    }

    public final int a() {
        return this.f30191a;
    }

    public final String b() {
        return this.f30192b;
    }

    public final String c() {
        return this.f30193c;
    }
}
