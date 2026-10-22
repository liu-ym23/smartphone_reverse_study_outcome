package com.bytedance.android.gamecp.base.gamedetail;

import android.view.Window;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f51538a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f51539b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AudienceReverseBtnConfig.a f51540c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e0 f51541d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f51542e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Window f51543f;

    public a1() {
        this(false, 63);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a1) == false) goto L18;
        a1 r101 = (a1) r100;
        if (this.f51538a == r101.f51538a) goto L8;
        return false;
    L8:
        if (this.f51539b == r101.f51539b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f51540c, r101.f51540c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f51541d, r101.f51541d) == true) goto L14;
        return false;
    L14:
        if (this.f51542e == r101.f51542e) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f51543f, r101.f51543f) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public final int hashCode() {
        int r100 = this.f51538a * 31;
        boolean r101 = this.f51539b;
        ?? r102 = 1;
        ?? r103 = r101;
        if (r101 == false) goto L5;
        r103 = 1;
    L5:
        int r104 = (r100 + r103) * 31;
        AudienceReverseBtnConfig.a r105 = this.f51540c;
        int r106 = 0;
        if (r105 == null) goto L8;
        int r107 = r105.hashCode();
    L9:
        int r108 = (r104 + r107) * 31;
        e0 r109 = this.f51541d;
        if (r109 == null) goto L12;
        int r110 = r109.hashCode();
    L13:
        int r111 = (r108 + r110) * 31;
        boolean r112 = this.f51542e;
        if (r112 == true) goto L17;
        r102 = r112;
    L17:
        int r113 = (r111 + r102) * 31;
        Window r114 = this.f51543f;
        if (r114 == null) goto L21;
        r106 = r114.hashCode();
    L21:
        return r113 + r106;
    L12:
        r110 = 0;
        goto L13
    L8:
        r107 = 0;
        goto L9
    }

    public final String toString() {
        return "TitleBarUIStyle(titleBarTopMargin=" + this.f51538a + ", closeBtnVisible=" + this.f51539b + ", reverseBtnUIStyle=" + this.f51540c + ", downloadBtnUIStyle=" + this.f51541d + ", enableStatusBarShow=" + this.f51542e + ", window=" + this.f51543f + ")";
    }

    public /* synthetic */ a1(boolean r110, int r111) {
        if ((r111 & 2) == 0) goto L5;
        boolean r100 = false;
    L7:
        if ((r111 & 4) == 0) goto L9;
        AudienceReverseBtnConfig.a r101 = new AudienceReverseBtnConfig.a(null);
    L11:
        if ((r111 & 8) == 0) goto L13;
        e0 r102 = new e0(0, 0, 0, 0, 127);
    L14:
        this(0, r100, r101, r102, false, null);
        return;
    L13:
        r102 = null;
        goto L14
    L9:
        r101 = null;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }

    public a1(int r100, boolean r101, AudienceReverseBtnConfig.a r102, e0 r103, boolean r104, Window r105) {
        Intrinsics.checkNotNullParameter(r102, "reverseBtnUIStyle");
        Intrinsics.checkNotNullParameter(r103, "downloadBtnUIStyle");
        this.f51538a = r100;
        this.f51539b = r101;
        this.f51540c = r102;
        this.f51541d = r103;
        this.f51542e = r104;
        this.f51543f = r105;
    }
}
