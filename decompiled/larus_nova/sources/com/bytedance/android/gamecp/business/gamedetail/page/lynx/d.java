package com.bytedance.android.gamecp.business.gamedetail.page.lynx;

import com.bytedance.ies.sve_core.p;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class d implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f55412a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f55413b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f55414c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f55415d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f55416e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f55417f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<String, String> f55418g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L20;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f55412a, r101.f55412a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f55413b, r101.f55413b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f55414c, r101.f55414c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f55415d, r101.f55415d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f55416e, r101.f55416e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f55417f, r101.f55417f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f55418g, r101.f55418g) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f55412a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f55413b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f55414c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f55415d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f55416e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f55417f;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        Map<String, String> r119 = this.f55418g;
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
        return "GameLynxTabPropsV4(tabId=" + this.f55412a + ", tabName=" + this.f55413b + ", name=" + this.f55414c + ", schema=" + this.f55415d + ", lynxContentData=" + this.f55416e + ", commonParams=" + this.f55417f + ", lynxCardLocation=" + this.f55418g + ")";
    }

    public d(String r100, String r101, String r102, String r103, String r104, String r105, Map<String, String> r106) {
        Intrinsics.checkNotNullParameter(r100, "tabId");
        Intrinsics.checkNotNullParameter(r101, "tabName");
        this.f55412a = r100;
        this.f55413b = r101;
        this.f55414c = r102;
        this.f55415d = r103;
        this.f55416e = r104;
        this.f55417f = r105;
        this.f55418g = r106;
    }
}
