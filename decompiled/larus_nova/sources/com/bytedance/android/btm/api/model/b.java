package com.bytedance.android.btm.api.model;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f42008a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f42009b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f42010c;

    public b() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L12;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f42008a, r101.f42008a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f42009b, r101.f42009b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f42010c, r101.f42010c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f42008a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        b r104 = this.f42009b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f42010c;
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
        JSONObject r100 = new JSONObject();
        r100.put("btm_show_id", this.f42008a);
        r100.put("btm_id", this.f42010c);
        b r101 = this.f42009b;
        if (r101 == null) goto L5;
        String r102 = r101.f42010c;
    L6:
        r100.put("pre_btm_id", r102);
        return r100.toString();
    L5:
        r102 = null;
        goto L6
    }

    public b(int r100) {
        this.f42008a = null;
        this.f42009b = null;
        this.f42010c = null;
    }
}
