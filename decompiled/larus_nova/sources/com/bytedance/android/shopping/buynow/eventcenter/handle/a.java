package com.bytedance.android.shopping.buynow.eventcenter.handle;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f170933a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f170934b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f170935c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f170936d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, Object> f170937e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Boolean f170938f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Boolean f170939g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L20;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f170933a, r101.f170933a) == true) goto L8;
        return false;
    L8:
        if (this.f170934b == r101.f170934b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f170935c, r101.f170935c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f170936d, r101.f170936d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f170937e, r101.f170937e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f170938f, r101.f170938f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f170939g, r101.f170939g) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        b r100 = this.f170933a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((r102 * 31) + this.f170934b) * 31;
        Integer r104 = this.f170935c;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f170936d;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Map<String, Object> r110 = this.f170937e;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Boolean r113 = this.f170938f;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Boolean r116 = this.f170939g;
        if (r116 == null) goto L26;
        r101 = r116.hashCode();
    L26:
        return r115 + r101;
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
        return "CheckParams(checkPayStatusWrapper=" + this.f170933a + ", payCode=" + this.f170934b + ", orderPayType=" + this.f170935c + ", status=" + this.f170936d + ", payParams=" + this.f170937e + ", payWidthWechatOrAlipay=" + this.f170938f + ", isAppPay=" + this.f170939g + ")";
    }

    public a(b r100, int r101, Integer r102, String r103, Map<String, ? extends Object> r104, Boolean r105, Boolean r106) {
        Intrinsics.checkNotNullParameter(r100, "checkPayStatusWrapper");
        Intrinsics.checkNotNullParameter(r103, "status");
        this.f170933a = r100;
        this.f170934b = r101;
        this.f170935c = r102;
        this.f170936d = r103;
        this.f170937e = r104;
        this.f170938f = r105;
        this.f170939g = r106;
    }
}
