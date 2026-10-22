package com.bytedance.android.livesdk.gift.platform.format.service;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f132263a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f132264b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f132265c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f132266d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f132267e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f132268f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f132269g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f132270h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Map<String, String> f132271i;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L24;
        a r101 = (a) r100;
        if (this.f132263a == r101.f132263a) goto L8;
        return false;
    L8:
        if (this.f132264b == r101.f132264b) goto L10;
        return false;
    L10:
        if (this.f132265c == r101.f132265c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f132266d, r101.f132266d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f132267e, r101.f132267e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f132268f, r101.f132268f) == true) goto L18;
        return false;
    L18:
        if (this.f132269g == r101.f132269g) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f132270h, r101.f132270h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f132271i, r101.f132271i) == true) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    public final int hashCode() {
        long r100 = this.f132263a;
        int r101 = ((((((int) (r100 ^ (r100 >>> 32))) * 31) + this.f132264b) * 31) + this.f132265c) * 31;
        String r102 = this.f132266d;
        int r103 = 0;
        if (r102 == null) goto L5;
        int r104 = r102.hashCode();
    L6:
        int r105 = (r101 + r104) * 31;
        String r106 = this.f132267e;
        if (r106 == null) goto L9;
        int r107 = r106.hashCode();
    L10:
        int r108 = (r105 + r107) * 31;
        String r109 = this.f132268f;
        if (r109 == null) goto L13;
        int r110 = r109.hashCode();
    L14:
        int r111 = (((r108 + r110) * 31) + this.f132269g) * 31;
        String r112 = this.f132270h;
        if (r112 == null) goto L17;
        int r113 = r112.hashCode();
    L18:
        int r114 = (r111 + r113) * 31;
        Map<String, String> r115 = this.f132271i;
        if (r115 == null) goto L22;
        r103 = r115.hashCode();
    L22:
        return r114 + r103;
    L17:
        r113 = 0;
        goto L18
    L13:
        r110 = 0;
        goto L14
    L9:
        r107 = 0;
        goto L10
    L5:
        r104 = 0;
        goto L6
    }

    public final String toString() {
        return "FormatGiftInfo(giftId=" + this.f132263a + ", diamond=" + this.f132264b + ", sendCount=" + this.f132265c + ", toUserId=" + this.f132266d + ", requestPage=" + this.f132267e + ", giftSourceLog=" + this.f132268f + ", buffLevel=" + this.f132269g + ", giftShowFrom=" + this.f132270h + ", sendGiftLog=" + this.f132271i + ")";
    }

    public a(long r100, int r101, int r102, String r103, String r104, String r105, int r106, String r110, Map<String, String> r111) {
        Intrinsics.checkNotNullParameter(r103, "toUserId");
        Intrinsics.checkNotNullParameter(r104, "requestPage");
        Intrinsics.checkNotNullParameter(r105, "giftSourceLog");
        Intrinsics.checkNotNullParameter(r110, "giftShowFrom");
        this.f132263a = r100;
        this.f132264b = r101;
        this.f132265c = r102;
        this.f132266d = r103;
        this.f132267e = r104;
        this.f132268f = r105;
        this.f132269g = r106;
        this.f132270h = r110;
        this.f132271i = r111;
    }
}
