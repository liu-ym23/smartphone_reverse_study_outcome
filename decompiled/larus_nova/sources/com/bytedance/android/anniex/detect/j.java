package com.bytedance.android.anniex.detect;

import android.graphics.Bitmap;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<View> f40697a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Bitmap f40698b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l f40699c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, Object> f40700d;

    public j() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.f40697a, r101.f40697a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f40698b, r101.f40698b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f40699c, r101.f40699c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f40700d, r101.f40700d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f40697a.hashCode() * 31;
        Bitmap r101 = this.f40698b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return ((((r100 + r102) * 31) + this.f40699c.hashCode()) * 31) + this.f40700d.hashCode();
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "SnapShotContext(view=" + this.f40697a + ", bitmap=" + this.f40698b + ", SnapShotStats=" + this.f40699c + ", extras=" + this.f40700d + ')';
    }

    public j(WeakReference r100) {
        l r101 = new l();
        LinkedHashMap r102 = new LinkedHashMap();
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "SnapShotStats");
        Intrinsics.checkNotNullParameter(r102, "extras");
        this.f40697a = r100;
        this.f40698b = null;
        this.f40699c = r101;
        this.f40700d = r102;
    }
}
