package com.bytedance.ai.applet.douyinAuth;

import com.bytedance.ai.monitor.auth.AppletAuthTaskMonitor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f34621a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AppletAuthTaskMonitor.a f34622b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f34621a, r101.f34621a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f34622b, r101.f34622b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f34621a.hashCode() * 31;
        AppletAuthTaskMonitor.a r101 = this.f34622b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "DouyinGeneralAuthPrepareResult(subtitle=" + this.f34621a + ", failure=" + this.f34622b + ')';
    }

    public c(String r100, AppletAuthTaskMonitor.a r101) {
        Intrinsics.checkNotNullParameter(r100, "subtitle");
        this.f34621a = r100;
        this.f34622b = r101;
    }
}
