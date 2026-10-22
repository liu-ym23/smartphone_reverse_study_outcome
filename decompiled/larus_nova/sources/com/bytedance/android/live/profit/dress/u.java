package com.bytedance.android.live.profit.dress;

import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.profit.dress.config.TextAlignType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class u extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f87174a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f87175b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f87176c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a5 f87177d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f87178e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextAlignType f87179f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f87180g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof u) == false) goto L20;
        u r101 = (u) r100;
        if (this.f87174a == r101.f87174a) goto L8;
        return false;
    L8:
        if (this.f87175b == r101.f87175b) goto L10;
        return false;
    L10:
        if (this.f87176c == r101.f87176c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f87177d, r101.f87177d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f87178e, r101.f87178e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f87179f, r101.f87179f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f87180g, r101.f87180g) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        long r100 = this.f87174a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.f87175b;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = this.f87176c;
        int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        a5 r106 = this.f87177d;
        int r107 = 0;
        if (r106 == null) goto L5;
        int r108 = r106.hashCode();
    L6:
        int r109 = (r105 + r108) * 31;
        String r110 = this.f87178e;
        if (r110 == null) goto L9;
        int r111 = r110.hashCode();
    L10:
        int r112 = (r109 + r111) * 31;
        TextAlignType r113 = this.f87179f;
        if (r113 == null) goto L13;
        int r114 = r113.hashCode();
    L14:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f87180g;
        if (r116 == null) goto L18;
        r107 = r116.hashCode();
    L18:
        return r115 + r107;
    L13:
        r114 = 0;
        goto L14
    L9:
        r111 = 0;
        goto L10
    L5:
        r108 = 0;
        goto L6
    }

    public final String toString() {
        return "OpenAssetDress(assetId=" + this.f87174a + ", textWidth=" + this.f87175b + ", textHeight=" + this.f87176c + ", templateText=" + this.f87177d + ", avatarBorderDressId=" + this.f87178e + ", textAlignType=" + this.f87179f + ", schema=" + this.f87180g + ")";
    }

    public u(long r100, long r101, long r102, a5 r103, String r104, TextAlignType r110, String r111) {
        Intrinsics.checkNotNullParameter(r110, "textAlignType");
        this.f87174a = r100;
        this.f87175b = r101;
        this.f87176c = r102;
        this.f87177d = r103;
        this.f87178e = r104;
        this.f87179f = r110;
        this.f87180g = r111;
    }
}
