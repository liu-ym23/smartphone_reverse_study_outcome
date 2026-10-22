package com.bytedance.ai.applet.app.foundation.performance;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f34384a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f34385b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f34386c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f34387d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f34388e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f34389f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof v) == true) goto L8;
        return false;
    L8:
        v r101 = (v) r100;
        if (this.f34384a == r101.f34384a) goto L12;
        return false;
    L12:
        if (this.f34385b == r101.f34385b) goto L15;
        return false;
    L15:
        if (this.f34386c == r101.f34386c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f34387d, r101.f34387d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f34388e, r101.f34388e) == true) goto L24;
        return false;
    L24:
        if (this.f34389f == r101.f34389f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f34384a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.f34385b;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = this.f34386c;
        int r105 = (((((r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31) + this.f34387d.hashCode()) * 31) + this.f34388e.hashCode()) * 31;
        if (this.f34389f == false) goto L5;
        int r106 = 1231;
    L7:
        return r105 + r106;
    L5:
        r106 = 1237;
        goto L7
    }

    public final String toString() {
        return "WidgetPerformanceTraceConfig(startTime=" + this.f34384a + ", widgetResourceLoadDuration=" + this.f34385b + ", manifestResourceLoadDuration=" + this.f34386c + ", widgetId=" + this.f34387d + ", widgetInstanceId=" + this.f34388e + ", isAppColdLaunch=" + this.f34389f + ')';
    }

    public v(long r100, long r101, long r102, String r103, String r104, boolean r110) {
        Intrinsics.checkNotNullParameter(r103, "widgetId");
        Intrinsics.checkNotNullParameter(r104, "widgetInstanceId");
        this.f34384a = r100;
        this.f34385b = r101;
        this.f34386c = r102;
        this.f34387d = r103;
        this.f34388e = r104;
        this.f34389f = r110;
    }
}
