package com.bytedance.android.window.shop.innerflow;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, String> f189039a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f189040b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f189041c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L12;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f189039a, r101.f189039a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f189040b, r101.f189040b) == true) goto L10;
        return false;
    L10:
        if (this.f189041c == r101.f189041c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        Map<String, String> r100 = this.f189039a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f189040b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return ((r103 + r101) * 31) + this.f189041c;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ECWindowInnerFlowParam(schemaParams=" + this.f189039a + ", secAuthorId=" + this.f189040b + ", innerFlowType=" + this.f189041c + ")";
    }

    public b(Map<String, String> r100, String r101, @WindowInnerFlowType int r102) {
        Intrinsics.checkNotNullParameter(r100, "schemaParams");
        Intrinsics.checkNotNullParameter(r101, "secAuthorId");
        this.f189039a = r100;
        this.f189040b = r101;
        this.f189041c = r102;
    }
}
