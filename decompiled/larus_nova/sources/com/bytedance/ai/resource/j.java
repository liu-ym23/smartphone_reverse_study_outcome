package com.bytedance.ai.resource;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f37494a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f37495b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f37496c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.f37494a, r101.f37494a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f37495b, r101.f37495b) == true) goto L15;
        return false;
    L15:
        if (this.f37496c == r101.f37496c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f37494a.hashCode() * 31) + this.f37495b.hashCode()) * 31;
        if (this.f37496c == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "AppletGeckoConfig(accessKey=" + this.f37494a + ", dirName=" + this.f37495b + ", isRelative=" + this.f37496c + ')';
    }

    public j(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "accessKey");
        Intrinsics.checkNotNullParameter(r101, "dirName");
        this.f37494a = r100;
        this.f37495b = r101;
        this.f37496c = true;
    }
}
