package com.bytedance.applet.task;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f192242a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f192243b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f192244c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f192245d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n) == true) goto L8;
        return false;
    L8:
        n r101 = (n) r100;
        if (Intrinsics.areEqual(this.f192242a, r101.f192242a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f192243b, r101.f192243b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f192244c, r101.f192244c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f192245d, r101.f192245d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f192242a.hashCode() * 31) + this.f192243b.hashCode()) * 31) + this.f192244c.hashCode()) * 31) + this.f192245d.hashCode();
    }

    public final String toString() {
        return "MediaInfo(appId=" + this.f192242a + ", title=" + this.f192243b + ", subtitle=" + this.f192244c + ", iconUri=" + this.f192245d + ')';
    }

    public n(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "appId");
        Intrinsics.checkNotNullParameter(r101, "title");
        Intrinsics.checkNotNullParameter(r102, "subtitle");
        Intrinsics.checkNotNullParameter(r103, "iconUri");
        this.f192242a = r100;
        this.f192243b = r101;
        this.f192244c = r102;
        this.f192245d = r103;
    }
}
