package com.bytedance.android.shopping.commentv3.uitree.title;

import android.view.View;
import com.bytedance.android.shopping.commentv3.data.interfaces.SubTitle;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a implements com.bytedance.android.shopping.commentv3.base.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f172904a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f172905b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final p53.e f172906c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SubTitle f172907d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L14;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f172904a, r101.f172904a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f172905b, r101.f172905b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f172906c, r101.f172906c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f172907d, r101.f172907d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f172904a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        View r104 = this.f172905b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        p53.e r107 = this.f172906c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        SubTitle r110 = this.f172907d;
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
        return "CommentTitleState(titleText=" + this.f172904a + ", injectView=" + this.f172905b + ", commentSkuV0=" + this.f172906c + ", subTitle=" + this.f172907d + ")";
    }

    public a(String r100, View r101, p53.e r102, SubTitle r103) {
        Intrinsics.checkNotNullParameter(r100, "titleText");
        this.f172904a = r100;
        this.f172905b = r101;
        this.f172906c = r102;
        this.f172907d = r103;
    }

    public static a a(a r100, String r101, View r102, p53.e r103, SubTitle r104, int r105) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.f172904a;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.f172905b;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.f172906c;
    L12:
        if ((r105 & 8) == 0) goto L14;
        r104 = r100.f172907d;
    L14:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "titleText");
        return new a(r101, r102, r103, r104);
    }
}
