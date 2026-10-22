package com.bytedance.android.shopping.mall.homepage.card.live;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f177986a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f177987b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f177988c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f177989d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f177990e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f177991f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f177992g;

    public e() {
        this(null, null, null, null, 127);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L20;
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f177986a, r101.f177986a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f177987b, r101.f177987b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f177988c, r101.f177988c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f177989d, r101.f177989d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f177990e, r101.f177990e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f177991f, r101.f177991f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f177992g, r101.f177992g) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f177986a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f177987b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f177988c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f177989d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f177990e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f177991f;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f177992g;
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
        return "LiveOrVideoImageXMonitorTag(bizTag=" + this.f177986a + ", coverSceneTag=" + this.f177987b + ", avatarSceneTag=" + this.f177988c + ", productTag=" + this.f177989d + ", redPackSceneTag=" + this.f177990e + ", simpleProductTag=" + this.f177991f + ", coverBlurSceneTag=" + this.f177992g + ")";
    }

    public /* synthetic */ e(String r110, String r111, String r112, String r113, int r114) {
        if ((r114 & 1) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r114 & 2) == 0) goto L9;
        String r101 = "";
    L11:
        if ((r114 & 4) == 0) goto L13;
        String r102 = "";
    L15:
        if ((r114 & 8) == 0) goto L17;
        String r103 = "";
    L19:
        if ((r114 & 16) == 0) goto L21;
        String r104 = "";
    L23:
        if ((r114 & 32) == 0) goto L25;
        String r105 = "";
    L27:
        if ((r114 & 64) == 0) goto L29;
        String r106 = "";
    L30:
        this(r100, r101, r102, r103, r104, r105, r106);
        return;
    L29:
        r106 = null;
        goto L30
    L25:
        r105 = null;
        goto L27
    L21:
        r104 = null;
        goto L23
    L17:
        r103 = r113;
        goto L19
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }

    public e(String r100, String r101, String r102, String r103, String r104, String r105, String r106) {
        Intrinsics.checkNotNullParameter(r100, "bizTag");
        Intrinsics.checkNotNullParameter(r101, "coverSceneTag");
        Intrinsics.checkNotNullParameter(r102, "avatarSceneTag");
        Intrinsics.checkNotNullParameter(r103, "productTag");
        Intrinsics.checkNotNullParameter(r104, "redPackSceneTag");
        Intrinsics.checkNotNullParameter(r105, "simpleProductTag");
        Intrinsics.checkNotNullParameter(r106, "coverBlurSceneTag");
        this.f177986a = r100;
        this.f177987b = r101;
        this.f177988c = r102;
        this.f177989d = r103;
        this.f177990e = r104;
        this.f177991f = r105;
        this.f177992g = r106;
    }
}
