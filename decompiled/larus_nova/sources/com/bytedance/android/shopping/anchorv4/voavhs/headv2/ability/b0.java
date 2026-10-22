package com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f169058a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f169059b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Object> f169060c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b0) == false) goto L12;
        b0 r101 = (b0) r100;
        if (Intrinsics.areEqual(this.f169058a, r101.f169058a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f169059b, r101.f169059b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f169060c, r101.f169060c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f169058a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f169059b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Map<String, Object> r107 = this.f169060c;
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
        return "PlayerEventInfo(eventScene=" + this.f169058a + ", eventName=" + this.f169059b + ", eventParams=" + this.f169060c + ")";
    }

    public b0(String r100, String r101, Map<String, ? extends Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "eventScene");
        Intrinsics.checkNotNullParameter(r101, "eventName");
        Intrinsics.checkNotNullParameter(r102, "eventParams");
        this.f169058a = r100;
        this.f169059b = r101;
        this.f169060c = r102;
    }
}
