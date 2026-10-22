package com.bytedance.android.annie.monitor.common.performance;

import android.view.View;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f39612a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeakReference<View> f39613b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicInteger f39614c;

    public d() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f39612a, r101.f39612a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f39613b, r101.f39613b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f39614c, r101.f39614c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f39612a.hashCode() * 31) + this.f39613b.hashCode()) * 31) + this.f39614c.hashCode();
    }

    public final String toString() {
        return "PageInfo(url=" + this.f39612a + ", viewRef=" + this.f39613b + ", reportTimes=" + this.f39614c + ')';
    }

    public d(String r100, WeakReference r101) {
        AtomicInteger r102 = new AtomicInteger();
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "viewRef");
        Intrinsics.checkNotNullParameter(r102, "reportTimes");
        this.f39612a = r100;
        this.f39613b = r101;
        this.f39614c = r102;
    }
}
