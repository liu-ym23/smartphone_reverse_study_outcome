package com.bytedance.android.live.revlink.impl.behavior;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f92145d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IconResMode f92146a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final py.k f92147b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f92148c;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L12;
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f92146a, r101.f92146a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f92147b, r101.f92147b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f92148c, r101.f92148c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        IconResMode r100 = this.f92146a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        py.k r104 = this.f92147b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.f92148c;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "IconRes(mode=" + this.f92146a + ", image=" + this.f92147b + ", drawable=" + this.f92148c + ")";
    }

    public e(IconResMode r100, py.k r101, Integer r102) {
        Intrinsics.checkNotNullParameter(r100, "mode");
        this.f92146a = r100;
        this.f92147b = r101;
        this.f92148c = r102;
    }
}
