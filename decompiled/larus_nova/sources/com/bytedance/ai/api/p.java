package com.bytedance.ai.api;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f34060a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f34061b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f34062c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f34063d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f34064e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f34065f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f34066g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f34067h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p) == true) goto L8;
        return false;
    L8:
        p r101 = (p) r100;
        if (Intrinsics.areEqual(this.f34060a, r101.f34060a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f34061b, r101.f34061b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f34062c, r101.f34062c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f34063d, r101.f34063d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f34064e, r101.f34064e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f34065f, r101.f34065f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f34066g, r101.f34066g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f34067h, r101.f34067h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.f34060a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f34061b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (((((((((((r103 + r105) * 31) + this.f34062c.hashCode()) * 31) + this.f34063d.hashCode()) * 31) + this.f34064e.hashCode()) * 31) + this.f34065f.hashCode()) * 31) + this.f34066g.hashCode()) * 31;
        String r107 = this.f34067h;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "MiniApplicationDialogConfig(iconRes=" + this.f34060a + ", iconResUrl=" + this.f34061b + ", applicationName=" + this.f34062c + ", mainTitle=" + this.f34063d + ", subtitle=" + this.f34064e + ", confirmText=" + this.f34065f + ", cancelText=" + this.f34066g + ", confirmSubText=" + this.f34067h + ')';
    }

    public p(Integer r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107) {
        Intrinsics.checkNotNullParameter(r102, "applicationName");
        Intrinsics.checkNotNullParameter(r103, "mainTitle");
        Intrinsics.checkNotNullParameter(r104, "subtitle");
        Intrinsics.checkNotNullParameter(r105, "confirmText");
        Intrinsics.checkNotNullParameter(r106, "cancelText");
        this.f34060a = r100;
        this.f34061b = r101;
        this.f34062c = r102;
        this.f34063d = r103;
        this.f34064e = r104;
        this.f34065f = r105;
        this.f34066g = r106;
        this.f34067h = r107;
    }
}
