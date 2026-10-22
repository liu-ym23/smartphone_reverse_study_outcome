package com.bytedance.android.livesdk.widget;

import com.bytedance.android.livesdk.z8;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public z8 f162265a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f162266b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f162267c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a0 f162268d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f162269e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof z) == false) goto L10;
        z r101 = (z) r100;
        if (Intrinsics.areEqual(this.f162268d, r101.f162268d) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f162269e, r101.f162269e) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        a0 r100 = this.f162268d;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f162269e;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "GuideInfo(type=" + this.f162268d + ", text=" + this.f162269e + ")";
    }

    public final a0 getType() {
        return this.f162268d;
    }

    public z(a0 r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "text");
        this.f162268d = r100;
        this.f162269e = r101;
        this.f162267c = -1;
    }
}
