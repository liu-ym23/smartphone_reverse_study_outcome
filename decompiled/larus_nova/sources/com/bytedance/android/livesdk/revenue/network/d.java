package com.bytedance.android.livesdk.revenue.network;

import com.google.gson.JsonObject;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f157204a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, String> f157205b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, String> f157206c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, String> f157207d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, List<String>> f157208e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, List<String>> f157209f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final JsonObject f157210g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L20;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f157204a, r101.f157204a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f157205b, r101.f157205b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f157206c, r101.f157206c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f157207d, r101.f157207d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f157208e, r101.f157208e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f157209f, r101.f157209f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f157210g, r101.f157210g) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f157204a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Map<String, String> r104 = this.f157205b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Map<String, String> r107 = this.f157206c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Map<String, String> r110 = this.f157207d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Map<String, List<String>> r113 = this.f157208e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Map<String, List<String>> r116 = this.f157209f;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        JsonObject r119 = this.f157210g;
        if (r119 == null) goto L30;
        r101 = r119.hashCode();
    L30:
        return r118 + r101;
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "NetworkRequest(path=" + this.f157204a + ", headerMap=" + this.f157205b + ", queryMap=" + this.f157206c + ", fieldMap=" + this.f157207d + ", queryListMap=" + this.f157208e + ", fieldListMap=" + this.f157209f + ", jsonBody=" + this.f157210g + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(String r100, Map<String, String> r101, Map<String, String> r102, Map<String, String> r103, Map<String, ? extends List<String>> r104, Map<String, ? extends List<String>> r105, JsonObject r106) {
        Intrinsics.checkNotNullParameter(r100, "path");
        Intrinsics.checkNotNullParameter(r101, "headerMap");
        Intrinsics.checkNotNullParameter(r102, "queryMap");
        Intrinsics.checkNotNullParameter(r103, "fieldMap");
        Intrinsics.checkNotNullParameter(r104, "queryListMap");
        Intrinsics.checkNotNullParameter(r105, "fieldListMap");
        this.f157204a = r100;
        this.f157205b = r101;
        this.f157206c = r102;
        this.f157207d = r103;
        this.f157208e = r104;
        this.f157209f = r105;
        this.f157210g = r106;
    }
}
