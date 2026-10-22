package com.bytedance.android.live.revlink.impl.behavior;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PkPanelType f92155a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f92156b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f92157c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f92158d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof h) == false) goto L14;
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f92155a, r101.f92155a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f92156b, r101.f92156b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f92157c, r101.f92157c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f92158d, r101.f92158d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        PkPanelType r100 = this.f92155a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        e r104 = this.f92156b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f92157c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f92158d;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "PkButtonStatus(type=" + this.f92155a + ", iconRes=" + this.f92156b + ", text=" + this.f92157c + ", wordType=" + this.f92158d + ")";
    }

    public final PkPanelType getType() {
        return this.f92155a;
    }

    public h(PkPanelType r100, e r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "iconRes");
        Intrinsics.checkNotNullParameter(r102, "text");
        Intrinsics.checkNotNullParameter(r103, "wordType");
        this.f92155a = r100;
        this.f92156b = r101;
        this.f92157c = r102;
        this.f92158d = r103;
    }
}
