package com.bytedance.android.livedress.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f102886a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f102887b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f102888c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L12;
        a r101 = (a) r100;
        if (this.f102886a == r101.f102886a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f102887b, r101.f102887b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f102888c, r101.f102888c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public final int hashCode() {
        boolean r100 = this.f102886a;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        int r102 = r101 * 31;
        String r103 = this.f102887b;
        int r104 = 0;
        if (r103 == null) goto L8;
        int r105 = r103.hashCode();
    L9:
        int r106 = (r102 + r105) * 31;
        String r107 = this.f102888c;
        if (r107 == null) goto L13;
        r104 = r107.hashCode();
    L13:
        return r106 + r104;
    L8:
        r105 = 0;
        goto L9
    }

    public final String toString() {
        return "DecodeResult(success=" + this.f102886a + ", result=" + this.f102887b + ", error=" + this.f102888c + ")";
    }

    public /* synthetic */ a(String r100) {
        this(false, null, r100);
    }

    public a(boolean r100, String r101, String r102) {
        this.f102886a = r100;
        this.f102887b = r101;
        this.f102888c = r102;
    }
}
