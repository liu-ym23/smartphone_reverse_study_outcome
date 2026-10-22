package com.bytedance.android.shopping.anchorv4.bottom;

import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f165896a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f165897b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f165898c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f165899d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f165900e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f165901f;

    public y() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof y) == false) goto L18;
        y r101 = (y) r100;
        if (Intrinsics.areEqual(this.f165896a, r101.f165896a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f165897b, r101.f165897b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f165898c, r101.f165898c) == true) goto L12;
        return false;
    L12:
        if (this.f165899d == r101.f165899d) goto L14;
        return false;
    L14:
        if (this.f165900e == r101.f165900e) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f165901f, r101.f165901f) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        String r100 = this.f165896a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f165897b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f165898c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        boolean r110 = this.f165899d;
        ?? r111 = 1;
        ?? r112 = r110;
        if (r110 == false) goto L17;
        r112 = 1;
    L17:
        int r113 = (r109 + r112) * 31;
        boolean r114 = this.f165900e;
        if (r114 == true) goto L21;
        r111 = r114;
    L21:
        int r115 = (r113 + r111) * 31;
        String r116 = this.f165901f;
        if (r116 == null) goto L25;
        r101 = r116.hashCode();
    L25:
        return r115 + r101;
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
        return "DepositPreSaleAppointmentMeta(liveRoomId=" + this.f165896a + ", authorId=" + this.f165897b + ", productId=" + this.f165898c + ", fromLive=" + this.f165899d + ", fromVideo=" + this.f165900e + ", promotionId=" + this.f165901f + ")";
    }

    public y(int r100) {
        this.f165896a = null;
        this.f165897b = null;
        this.f165898c = null;
        this.f165899d = false;
        this.f165900e = false;
        this.f165901f = null;
    }

    public final void a(CommonMeta r100) {
        String r101 = null;
        if (r100 == null) goto L5;
        String r102 = r100.getLiveRoomId();
    L6:
        this.f165896a = r102;
        if (r100 == null) goto L9;
        String r103 = r100.getAuthorId();
    L10:
        this.f165897b = r103;
        if (r100 == null) goto L13;
        String r104 = r100.getProductId();
    L14:
        this.f165898c = r104;
        if (r100 == null) goto L17;
        Boolean r105 = Boolean.valueOf(r100.getFromLive());
    L18:
        this.f165899d = com.bytedance.android.shopping.extensions.k.i(r105);
        if (r100 == null) goto L21;
        Boolean r106 = Boolean.valueOf(r100.getFromVideo());
    L22:
        this.f165900e = com.bytedance.android.shopping.extensions.k.i(r106);
        if (r100 == null) goto L25;
        r101 = r100.getPromotionId();
    L25:
        this.f165901f = r101;
        return;
    L21:
        r106 = null;
        goto L22
    L17:
        r105 = null;
        goto L18
    L13:
        r104 = null;
        goto L14
    L9:
        r103 = null;
        goto L10
    L5:
        r102 = null;
        goto L6
    }
}
