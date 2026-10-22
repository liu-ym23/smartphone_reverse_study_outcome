package com.bytedance.android.livesdk.gift.platform.business.effect.service.feed;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f129518a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f129519b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f129520c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f129521d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f129522e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f129523f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f129524g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L20;
        a r101 = (a) r100;
        if (this.f129518a == r101.f129518a) goto L8;
        return false;
    L8:
        if (this.f129519b == r101.f129519b) goto L10;
        return false;
    L10:
        if (this.f129520c == r101.f129520c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f129521d, r101.f129521d) == true) goto L14;
        return false;
    L14:
        if (this.f129522e == r101.f129522e) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f129523f, r101.f129523f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f129524g, r101.f129524g) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public final int hashCode() {
        int r100 = ((this.f129518a * 31) + this.f129519b) * 31;
        boolean r101 = this.f129520c;
        ?? r102 = 1;
        ?? r103 = r101;
        if (r101 == false) goto L5;
        r103 = 1;
    L5:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f129521d;
        int r106 = 0;
        if (r105 == null) goto L8;
        int r107 = r105.hashCode();
    L9:
        int r108 = (r104 + r107) * 31;
        boolean r109 = this.f129522e;
        if (r109 == true) goto L13;
        r102 = r109;
    L13:
        int r110 = (r108 + r102) * 31;
        String r111 = this.f129523f;
        if (r111 == null) goto L16;
        int r112 = r111.hashCode();
    L17:
        int r113 = (r110 + r112) * 31;
        String r114 = this.f129524g;
        if (r114 == null) goto L21;
        r106 = r114.hashCode();
    L21:
        return r113 + r106;
    L16:
        r112 = 0;
        goto L17
    L8:
        r107 = 0;
        goto L9
    }

    public final String toString() {
        return "EffectRequestParam(action=" + this.f129518a + ", type=" + this.f129519b + ", draggable=" + this.f129520c + ", schema=" + this.f129521d + ", touchable=" + this.f129522e + ", channel=" + this.f129523f + ", superViewIdentifier=" + this.f129524g + ")";
    }

    public final int getType() {
        return this.f129519b;
    }

    public a(int r100, int r101, boolean r102, String r103, boolean r104, String r105, String r106) {
        Intrinsics.checkNotNullParameter(r103, "schema");
        this.f129518a = r100;
        this.f129519b = r101;
        this.f129520c = r102;
        this.f129521d = r103;
        this.f129522e = r104;
        this.f129523f = r105;
        this.f129524g = r106;
    }
}
