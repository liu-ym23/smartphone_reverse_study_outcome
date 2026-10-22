package com.bytedance.android.live.effect.composer;

import com.bytedance.android.livesdkapi.depend.model.Sticker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f67925a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Sticker f67926b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f67927c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f67928d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Long f67929e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f67930f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L18;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f67925a, r101.f67925a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f67926b, r101.f67926b) == true) goto L10;
        return false;
    L10:
        if (this.f67927c == r101.f67927c) goto L12;
        return false;
    L12:
        if (this.f67928d == r101.f67928d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f67929e, r101.f67929e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f67930f, r101.f67930f) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        String r100 = this.f67925a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Sticker r104 = this.f67926b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        boolean r107 = this.f67927c;
        ?? r108 = 1;
        ?? r109 = r107;
        if (r107 == false) goto L13;
        r109 = 1;
    L13:
        int r110 = (r106 + r109) * 31;
        boolean r111 = this.f67928d;
        if (r111 == true) goto L17;
        r108 = r111;
    L17:
        int r112 = (r110 + r108) * 31;
        Long r113 = this.f67929e;
        if (r113 == null) goto L20;
        int r114 = r113.hashCode();
    L21:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f67930f;
        if (r116 == null) goto L25;
        r101 = r116.hashCode();
    L25:
        return r115 + r101;
    L20:
        r114 = 0;
        goto L21
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "AddStickerInfo(panel=" + this.f67925a + ", sticker=" + this.f67926b + ", refresh=" + this.f67927c + ", use=" + this.f67928d + ", updateTime=" + this.f67929e + ", trace=" + this.f67930f + ")";
    }

    public a(String r100, Sticker r101, boolean r102, boolean r103, Long r104, String r105) {
        Intrinsics.checkNotNullParameter(r100, "panel");
        Intrinsics.checkNotNullParameter(r101, "sticker");
        Intrinsics.checkNotNullParameter(r105, "trace");
        this.f67925a = r100;
        this.f67926b = r101;
        this.f67927c = r102;
        this.f67928d = r103;
        this.f67929e = r104;
        this.f67930f = r105;
    }
}
