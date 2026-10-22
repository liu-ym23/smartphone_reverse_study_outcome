package com.bytedance.safetyguard.lxc.internal.e.a.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: OAuthPollingModels.kt */
/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f10321a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f10322b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f10323c;

    public static /* synthetic */ g a(g r0, int r1, int r2, boolean r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.f10321a;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.f10322b;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.f10323c;
    L12:
        return r0.a(r1, r2, r3);
    }

    public final g a(int r1, int r2, boolean r3) {
        return new g(r1, r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, g.class) == true) goto L8;
        return false;
    L8:
        g r6 = (g) ZeusTransformUtils.preCheckCast(r5, g.class, "com.obric.aiagent.plugin");
        if (this.f10321a == r6.f10321a) goto L12;
        return false;
    L12:
        if (this.f10322b == r6.f10322b) goto L15;
        return false;
    L15:
        if (this.f10323c == r6.f10323c) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.f10321a) * 31) + Integer.hashCode(this.f10322b)) * 31) + Boolean.hashCode(this.f10323c);
    }

    public String toString() {
        return "OAuthPollSchedule(intervalSec=" + this.f10321a + ", attempts=" + this.f10322b + ", waitBeforeNextPoll=" + this.f10323c + ')';
    }

    public g(int r1, int r2, boolean r3) {
        this.f10321a = r1;
        this.f10322b = r2;
        this.f10323c = r3;
    }

    public final int a() {
        return this.f10321a;
    }

    public final int b() {
        return this.f10322b;
    }

    public final boolean c() {
        return this.f10323c;
    }
}
