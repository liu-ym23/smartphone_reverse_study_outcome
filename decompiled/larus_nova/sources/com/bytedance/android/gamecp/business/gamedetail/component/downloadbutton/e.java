package com.bytedance.android.gamecp.business.gamedetail.component.downloadbutton;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class e extends com.bytedance.android.gamecp.business.gamedetail.component.c {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f54285h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final d f54286i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final i f54287j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final com.bytedance.android.gamecp.business.gamedetail.base.model.h f54288k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Float f54289l;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L16;
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f54285h, r101.f54285h) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f54286i, r101.f54286i) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f54287j, r101.f54287j) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f54288k, r101.f54288k) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f54289l, r101.f54289l) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f54285h;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        d r104 = this.f54286i;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        i r107 = this.f54287j;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        com.bytedance.android.gamecp.business.gamedetail.base.model.h r110 = this.f54288k;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Float r113 = this.f54289l;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
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
        return "GameDownloadButtonItemProps(buttonID=" + this.f54285h + ", buttonData=" + this.f54286i + ", buttonStyle=" + this.f54287j + ", buttonCommonData=" + this.f54288k + ", slideOffset=" + this.f54289l + ")";
    }

    public e(String r100, d r110, i r111, com.bytedance.android.gamecp.business.gamedetail.base.model.h r112, Float r113) {
        Intrinsics.checkNotNullParameter(r100, "buttonID");
        super(r100, 9, r110, r111, r112, r113);
        this.f54285h = r100;
        this.f54286i = r110;
        this.f54287j = r111;
        this.f54288k = r112;
        this.f54289l = r113;
    }
}
