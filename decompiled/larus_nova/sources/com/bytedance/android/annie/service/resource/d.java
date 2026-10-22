package com.bytedance.android.annie.service.resource;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f40029a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f40030b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f40031c;

    public d() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f40029a, r101.f40029a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f40030b, r101.f40030b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f40031c, r101.f40031c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f40029a.hashCode() * 31) + this.f40030b.hashCode()) * 31) + this.f40031c.hashCode();
    }

    public final String toString() {
        return "GeckoResourceInfo(accessKey=" + this.f40029a + ", channel=" + this.f40030b + ", bundle=" + this.f40031c + ')';
    }

    public /* synthetic */ d(int r100) {
        this("", "", "");
    }

    public d(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "accessKey");
        Intrinsics.checkNotNullParameter(r101, "channel");
        Intrinsics.checkNotNullParameter(r102, "bundle");
        this.f40029a = r100;
        this.f40030b = r101;
        this.f40031c = r102;
    }
}
