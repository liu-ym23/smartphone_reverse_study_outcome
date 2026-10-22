package com.bytedance.android.shopping.anchorv4.data;

import android.net.Uri;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class z0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f166504c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f166505a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p83.h f166506b;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof z0) == false) goto L10;
        z0 r101 = (z0) r100;
        if (Intrinsics.areEqual(this.f166505a, r101.f166505a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f166506b, r101.f166506b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        Uri r100 = this.f166505a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        p83.h r104 = this.f166506b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "PdpStarterParamSnapshot(uri=" + this.f166505a + ", pdpParams=" + this.f166506b + ")";
    }

    public z0(Uri r100, p83.h r101) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        Intrinsics.checkNotNullParameter(r101, "pdpParams");
        this.f166505a = r100;
        this.f166506b = r101;
    }
}
