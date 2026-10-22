package com.bytedance.android.ec.store.floatlayout;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f48256a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f48257b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final JSONObject f48258c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L12;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f48256a, r101.f48256a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f48257b, r101.f48257b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f48258c, r101.f48258c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f48256a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f48257b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        JSONObject r107 = this.f48258c;
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
        return "StoreFloatLynxEvent(eventBusName=" + this.f48256a + ", id=" + this.f48257b + ", data=" + this.f48258c + ")";
    }

    public c(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter("ecom.shop.show_float_layer", "eventBusName");
        this.f48256a = "ecom.shop.show_float_layer";
        this.f48257b = r100;
        this.f48258c = r101;
    }
}
