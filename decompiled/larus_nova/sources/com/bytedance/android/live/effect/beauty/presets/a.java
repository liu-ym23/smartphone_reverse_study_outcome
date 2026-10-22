package com.bytedance.android.live.effect.beauty.presets;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ApplyStatus f67475a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BeautifyPreset f67476b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f67477c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L12;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f67475a, r101.f67475a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f67476b, r101.f67476b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f67477c, r101.f67477c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        ApplyStatus r100 = this.f67475a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        BeautifyPreset r104 = this.f67476b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f67477c;
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
        return "ApplyPresetResult(status=" + this.f67475a + ", preset=" + this.f67476b + ", failedPanel=" + this.f67477c + ")";
    }

    public a(ApplyStatus r100, BeautifyPreset r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "status");
        Intrinsics.checkNotNullParameter(r101, "preset");
        this.f67475a = r100;
        this.f67476b = r101;
        this.f67477c = r102;
    }
}
