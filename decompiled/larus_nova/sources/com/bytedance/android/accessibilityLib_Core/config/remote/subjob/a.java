package com.bytedance.android.accessibilityLib_Core.config.remote.subjob;

import com.ss.android.downloadlib.constants.MimeType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f38233a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f38234b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f38235c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f38236d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f38237e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f38238f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L18;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f38233a, r101.f38233a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f38234b, r101.f38234b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f38235c, r101.f38235c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f38236d, r101.f38236d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f38237e, r101.f38237e) == true) goto L16;
        return false;
    L16:
        if (this.f38238f == r101.f38238f) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public final int hashCode() {
        String r100 = this.f38233a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f38234b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f38235c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f38236d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f38237e;
        if (r113 == null) goto L21;
        r101 = r113.hashCode();
    L21:
        int r114 = (r112 + r101) * 31;
        boolean r115 = this.f38238f;
        ?? r116 = r115;
        if (r115 == false) goto L25;
        r116 = 1;
    L25:
        return r114 + r116;
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
        return "DownloadParam(url='" + this.f38233a + "', fileName='" + this.f38235c + "', savepath = " + this.f38234b + ", saveName='" + this.f38236d + "', mimeType='" + this.f38237e + "')";
    }

    public a(String r100, String r101) {
        this.f38233a = r100;
        this.f38234b = r101;
        this.f38235c = "r_accessibility.txt";
        this.f38236d = "r_accessibility.txt.zip";
        this.f38237e = MimeType.ZIP;
        this.f38238f = false;
    }
}
