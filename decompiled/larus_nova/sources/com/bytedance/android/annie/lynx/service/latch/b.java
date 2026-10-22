package com.bytedance.android.annie.lynx.service.latch;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f39548c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f39549a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f39550b;

    public static final class a {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f39549a, r101.f39549a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f39550b, r101.f39550b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f39549a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        return (r101 * 31) + this.f39550b.hashCode();
    L5:
        r101 = r100.hashCode();
        goto L7
    }

    public final String toString() {
        return "ChanneledConfig(channel=" + this.f39549a + ", configString=" + this.f39550b + ')';
    }

    static {
        f39548c = new b("__invalid__", "");
    }

    public b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "configString");
        this.f39549a = r100;
        this.f39550b = r101;
    }
}
