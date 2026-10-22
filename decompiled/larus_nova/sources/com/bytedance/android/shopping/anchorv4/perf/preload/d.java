package com.bytedance.android.shopping.anchorv4.perf.preload;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class d implements Comparable<d> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f167310a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f167311b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f167312c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f167313d;

    @Override // java.lang.Comparable
    public final int compareTo(d r100) {
        d r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "other");
        boolean r102 = this.f167313d;
        if (r102 == r101.f167313d) goto L8;
        if (r102 == false) goto L6;
        return -1;
    L6:
        return 1;
    L8:
        return r101.f167312c - this.f167312c;
    }

    public d(View r100, int r101, int r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "view");
        this.f167310a = r100;
        this.f167311b = r101;
        this.f167312c = r102;
        this.f167313d = r103;
    }
}
