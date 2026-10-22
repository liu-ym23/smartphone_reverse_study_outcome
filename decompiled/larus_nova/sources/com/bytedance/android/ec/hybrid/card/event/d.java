package com.bytedance.android.ec.hybrid.card.event;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f46489a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Object> f46490b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L10;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f46489a, r101.f46489a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f46490b, r101.f46490b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f46489a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Map<String, Object> r104 = this.f46490b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ECJs2NativeEvent(eventName=" + this.f46489a + ", params=" + this.f46490b + ")";
    }

    public d(String r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        this.f46489a = r100;
        this.f46490b = r101;
    }
}
