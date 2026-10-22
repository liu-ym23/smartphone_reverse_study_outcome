package com.bytedance.android.gamecp.business.gamedetail.component.titlebar.downloadbtn;

import com.bytedance.android.gamecp.business.gamedetail.base.model.h;
import com.bytedance.android.gamecp.business.gamedetail.component.downloadbutton.d;
import com.bytedance.android.gamecp.business.gamedetail.component.downloadbutton.i;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class b extends a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f55184g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final d f55185h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final i f55186i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final h f55187j;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L14;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f55184g, r101.f55184g) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f55185h, r101.f55185h) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f55186i, r101.f55186i) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f55187j, r101.f55187j) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f55184g;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        d r104 = this.f55185h;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        i r107 = this.f55186i;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        h r110 = this.f55187j;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
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
        return "TitleBetaTestDownloadButtonItemProps(buttonID=" + this.f55184g + ", buttonData=" + this.f55185h + ", buttonStyle=" + this.f55186i + ", buttonCommonData=" + this.f55187j + ")";
    }

    public b(String r100, d r101, i r110, h r111) {
        Intrinsics.checkNotNullParameter(r100, "buttonID");
        super(r100, r101, r110, r111, 31);
        this.f55184g = r100;
        this.f55185h = r101;
        this.f55186i = r110;
        this.f55187j = r111;
    }
}
