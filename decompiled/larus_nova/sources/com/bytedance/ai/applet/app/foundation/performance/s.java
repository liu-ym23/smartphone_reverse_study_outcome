package com.bytedance.ai.applet.app.foundation.performance;

/* JADX INFO: loaded from: classes43.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f34376a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f34377b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f34378c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f34379d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof s) == true) goto L8;
        return false;
    L8:
        s r101 = (s) r100;
        if (this.f34376a == r101.f34376a) goto L12;
        return false;
    L12:
        if (this.f34377b == r101.f34377b) goto L15;
        return false;
    L15:
        if (this.f34378c == r101.f34378c) goto L18;
        return false;
    L18:
        if (this.f34379d == r101.f34379d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        if (this.f34376a == false) goto L5;
        int r100 = 1231;
    L6:
        long r101 = this.f34377b;
        int r102 = ((r100 * 31) + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = this.f34378c;
        int r104 = (r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        long r105 = this.f34379d;
        return r104 + ((int) (r105 ^ (r105 >>> 32)));
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "PendingWidgetPerformanceTiming(isAppColdLaunch=" + this.f34376a + ", bindingStartTime=" + this.f34377b + ", widgetResourceLoadDuration=" + this.f34378c + ", manifestResourceLoadDuration=" + this.f34379d + ')';
    }

    public s(boolean r100, long r101, long r102, long r103) {
        this.f34376a = r100;
        this.f34377b = r101;
        this.f34378c = r102;
        this.f34379d = r103;
    }
}
