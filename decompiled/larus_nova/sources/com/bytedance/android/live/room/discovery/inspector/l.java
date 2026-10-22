package com.bytedance.android.live.room.discovery.inspector;

import android.text.Spannable;
import com.bytedance.android.live.base.model.ImageModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f99558a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageModel f99559b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f99560c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f99561d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Spannable f99562e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Spannable f99563f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof l) == false) goto L18;
        l r101 = (l) r100;
        if (this.f99558a == r101.f99558a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f99559b, r101.f99559b) == true) goto L10;
        return false;
    L10:
        if (this.f99560c == r101.f99560c) goto L12;
        return false;
    L12:
        if (this.f99561d == r101.f99561d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f99562e, r101.f99562e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f99563f, r101.f99563f) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    public final int hashCode() {
        boolean r100 = this.f99558a;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        int r102 = r101 * 31;
        ImageModel r103 = this.f99559b;
        int r104 = 0;
        if (r103 == null) goto L8;
        int r105 = r103.hashCode();
    L9:
        int r106 = (((((r102 + r105) * 31) + this.f99560c) * 31) + this.f99561d) * 31;
        Spannable r107 = this.f99562e;
        if (r107 == null) goto L12;
        int r108 = r107.hashCode();
    L13:
        int r109 = (r106 + r108) * 31;
        Spannable r110 = this.f99563f;
        if (r110 == null) goto L17;
        r104 = r110.hashCode();
    L17:
        return r109 + r104;
    L12:
        r108 = 0;
        goto L13
    L8:
        r105 = 0;
        goto L9
    }

    public final String toString() {
        return "OfficialInspectorWidgetConfig(isAnimation=" + this.f99558a + ", actionIcon=" + this.f99559b + ", foldDuration=" + this.f99560c + ", displayDuration=" + this.f99561d + ", animTitle=" + this.f99562e + ", suffixTitle=" + this.f99563f + ")";
    }

    public l(boolean r100, ImageModel r101, int r102, int r103, Spannable r104, Spannable r105) {
        Intrinsics.checkNotNullParameter(r104, "animTitle");
        Intrinsics.checkNotNullParameter(r105, "suffixTitle");
        this.f99558a = r100;
        this.f99559b = r101;
        this.f99560c = r102;
        this.f99561d = r103;
        this.f99562e = r104;
        this.f99563f = r105;
    }
}
