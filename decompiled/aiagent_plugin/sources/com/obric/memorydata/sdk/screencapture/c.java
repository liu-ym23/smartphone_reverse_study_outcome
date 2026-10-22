package com.obric.memorydata.sdk.screencapture;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.x;

/* JADX INFO: compiled from: ScreenCaptureManager.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TaskOptions f33851a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f33852b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d.h.a.b<ScreenData, x> f33853c;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
        return false;
    L8:
        c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
        if (o.a(this.f33851a, r6.f33851a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f33852b, r6.f33852b) == true) goto L15;
        return false;
    L15:
        if (o.a(this.f33853c, r6.f33853c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.f33851a.hashCode() * 31) + this.f33852b.hashCode()) * 31) + this.f33853c.hashCode();
    }

    public String toString() {
        return "PendingCaptureOperation(taskOptions=" + this.f33851a + ", targetPackage=" + this.f33852b + ", callback=" + this.f33853c + ')';
    }

    public c(TaskOptions r3, String r4, d.h.a.b<? super ScreenData, x> r5) {
        d.h.a.b<ScreenData, x> r6 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.b.class, "com.obric.aiagent.plugin");
        o.e(r3, "taskOptions");
        o.e(r4, "targetPackage");
        o.e(r6, "callback");
        this.f33851a = r3;
        this.f33852b = r4;
        this.f33853c = r6;
    }

    public final TaskOptions a() {
        return this.f33851a;
    }

    public final String b() {
        return this.f33852b;
    }

    public final d.h.a.b<ScreenData, x> c() {
        return this.f33853c;
    }
}
