package com.bytedance.android.live.recharge.order;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public final class i {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f90105d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f90106a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f90107b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f90108c;

    public static final class a {
        @JvmStatic
        public static i a(com.bytedance.android.live.recharge.model.d r100) {
            i r101 = new i(null, null, 7);
            String r102 = "";
            if (r100 != null) goto L5;
        L7:
            String r103 = "";
        L8:
            r101.f90107b = r103;
            if (r100 == null) goto L14;
            String r104 = r100.f90013b;
            if (r104 == null) goto L14;
            r102 = r104;
        L14:
            r101.f90108c = r102;
            return r101;
        L5:
            if (r100.f90012a != true) goto L7;
            r103 = "room";
            goto L8
        }
    }

    static {
    }

    public i() {
        this(null, null, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof i) == false) goto L12;
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f90106a, r101.f90106a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f90107b, r101.f90107b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f90108c, r101.f90108c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f90106a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f90107b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f90108c;
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
        return "RechargeChannelPrams(platform=" + this.f90106a + ", bizPage=" + this.f90107b + ", bizScene=" + this.f90108c + ")";
    }

    public final String a() {
        JSONObject r100 = new JSONObject();
        r100.put("l1", this.f90106a);
        r100.put("l2", this.f90107b);
        r100.put("l3", this.f90108c);
        return r100.toString();
    }

    public i(String r100, String r101, int r102) {
        if ((r102 & 1) == 0) goto L5;
        String r103 = "android";
    L7:
        if ((r102 & 2) == 0) goto L10;
        r100 = "";
    L10:
        if ((r102 & 4) == 0) goto L12;
        r101 = "";
    L12:
        this.f90106a = r103;
        this.f90107b = r100;
        this.f90108c = r101;
        return;
    L5:
        r103 = null;
        goto L7
    }
}
