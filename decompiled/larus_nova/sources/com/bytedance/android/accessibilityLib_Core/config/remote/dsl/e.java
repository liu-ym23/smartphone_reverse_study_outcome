package com.bytedance.android.accessibilityLib_Core.config.remote.dsl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f38186a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f38187b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h f38188c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L12;
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f38186a, r101.f38186a) == true) goto L8;
        return false;
    L8:
        if (this.f38187b == r101.f38187b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f38188c, r101.f38188c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    public final int hashCode() {
        String r100 = this.f38186a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        boolean r104 = this.f38187b;
        ?? r105 = r104;
        if (r104 == false) goto L9;
        r105 = 1;
    L9:
        int r106 = (r103 + r105) * 31;
        h r107 = this.f38188c;
        if (r107 == null) goto L13;
        r101 = r107.hashCode();
    L13:
        return r106 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "LabelDsl(label='" + this.f38186a + "', direct=" + this.f38187b + ", viewIdentifyDsl=" + this.f38188c + ')';
    }

    public e(String r100, boolean r101, h r102) {
        this.f38186a = r100;
        this.f38187b = r101;
        this.f38188c = r102;
    }
}
