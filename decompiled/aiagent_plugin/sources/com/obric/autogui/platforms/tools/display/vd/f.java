package com.obric.autogui.platforms.tools.display.vd;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: TaskFrontLiveTopGate.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f30203a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f30204b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f30205c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f30206d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f30207e;
    private final String f;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, f.class) == true) goto L8;
        return false;
    L8:
        f r6 = (f) ZeusTransformUtils.preCheckCast(r5, f.class, "com.obric.aiagent.plugin");
        if (this.f30203a == r6.f30203a) goto L12;
        return false;
    L12:
        if (this.f30204b == r6.f30204b) goto L15;
        return false;
    L15:
        if (this.f30205c == r6.f30205c) goto L18;
        return false;
    L18:
        if (this.f30206d == r6.f30206d) goto L21;
        return false;
    L21:
        if (this.f30207e == r6.f30207e) goto L24;
        return false;
    L24:
        if (o.a(this.f, r6.f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        return (((((((((Integer.hashCode(this.f30203a) * 31) + Integer.hashCode(this.f30204b)) * 31) + Integer.hashCode(this.f30205c)) * 31) + Integer.hashCode(this.f30206d)) * 31) + Integer.hashCode(this.f30207e)) * 31) + this.f.hashCode();
    }

    public String toString() {
        return "TaskFrontUpdateTargets(cacheTaskId=" + this.f30203a + ", trackingTaskId=" + this.f30204b + ", taskChangedTaskId=" + this.f30205c + ", reducerTaskId=" + this.f30206d + ", displayCacheTaskId=" + this.f30207e + ", targetPackage=" + this.f + ')';
    }

    public f(int r2, int r3, int r4, int r5, int r6, String r7) {
        o.e(r7, "targetPackage");
        this.f30203a = r2;
        this.f30204b = r3;
        this.f30205c = r4;
        this.f30206d = r5;
        this.f30207e = r6;
        this.f = r7;
    }
}
