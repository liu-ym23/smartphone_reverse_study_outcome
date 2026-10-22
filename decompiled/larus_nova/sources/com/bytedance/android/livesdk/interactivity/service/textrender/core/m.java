package com.bytedance.android.livesdk.interactivity.service.textrender.core;

import android.graphics.drawable.Drawable;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Drawable f141025a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f141026b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Object> f141027c;

    public m() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof m) == false) goto L12;
        m r101 = (m) r100;
        if (Intrinsics.areEqual(this.f141025a, r101.f141025a) == true) goto L8;
        return false;
    L8:
        if (this.f141026b == r101.f141026b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f141027c, r101.f141027c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        Drawable r100 = this.f141025a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((r102 * 31) + this.f141026b) * 31;
        Map<String, Object> r104 = this.f141027c;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "LoadedImages(drawable=" + this.f141025a + ", index=" + this.f141026b + ", extra=" + this.f141027c + ")";
    }

    public m(Drawable r100, int r101) {
        HashMap r102 = new HashMap();
        Intrinsics.checkNotNullParameter(r102, "extra");
        this.f141025a = r100;
        this.f141026b = r101;
        this.f141027c = r102;
    }
}
