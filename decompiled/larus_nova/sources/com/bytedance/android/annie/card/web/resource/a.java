package com.bytedance.android.annie.card.web.resource;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f39216a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f39217b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f39218c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f39219d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f39216a == r101.f39216a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f39217b, r101.f39217b) == true) goto L15;
        return false;
    L15:
        if (this.f39218c == r101.f39218c) goto L18;
        return false;
    L18:
        if (this.f39219d == r101.f39219d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f39216a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = ((r101 * 31) + this.f39217b.hashCode()) * 31;
        long r103 = this.f39218c;
        int r104 = (r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        if (this.f39219d == true) goto L11;
        r100 = 1237;
    L11:
        return r104 + r100;
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "ResourceInfo(isOffline=" + this.f39216a + ", resFrom=" + this.f39217b + ", version=" + this.f39218c + ", useForest=" + this.f39219d + ')';
    }

    public a(boolean r100, String r101, long r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r101, "resFrom");
        this.f39216a = r100;
        this.f39217b = r101;
        this.f39218c = r102;
        this.f39219d = r103;
    }
}
