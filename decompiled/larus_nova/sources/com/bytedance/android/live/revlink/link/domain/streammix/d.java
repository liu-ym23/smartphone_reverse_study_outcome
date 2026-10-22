package com.bytedance.android.live.revlink.link.domain.streammix;

import android.graphics.RectF;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes47.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JSONArray f98558a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f98559b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RectF f98560c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L12;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f98558a, r101.f98558a) == true) goto L8;
        return false;
    L8:
        if (this.f98559b == r101.f98559b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f98560c, r101.f98560c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        JSONArray r100 = this.f98558a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((r102 * 31) + this.f98559b) * 31;
        RectF r104 = this.f98560c;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "MixSeiInfo(mixGrids=" + this.f98558a + ", mixOwnerIndex=" + this.f98559b + ", contentRectF=" + this.f98560c + ")";
    }

    public d(JSONArray r100, int r101, RectF r102) {
        Intrinsics.checkNotNullParameter(r100, "mixGrids");
        Intrinsics.checkNotNullParameter(r102, "contentRectF");
        this.f98558a = r100;
        this.f98559b = r101;
        this.f98560c = r102;
    }
}
