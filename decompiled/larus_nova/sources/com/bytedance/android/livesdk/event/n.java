package com.bytedance.android.livesdk.event;

import android.text.style.ImageSpan;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class n implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f123352a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f123353b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f123354c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f123355d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f123356e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ImageSpan f123357f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final py.k f123358g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f123359h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f123360i;

    public final String toString() {
        return "ImageSendInfo(type=" + getType() + ", value=" + this.f123353b + ", text=" + this.f123354c + ", start=" + this.f123355d + ", length=" + this.f123356e + ", imageSpan=" + this.f123357f + ", imageModel=" + this.f123358g + ", selfPublicScreenScale=" + this.f123359h + ", selfDanmakuScale=" + this.f123360i + ")";
    }

    public final int hashCode() {
        int r100 = getType() * 31;
        String r101 = this.f123353b;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f123354c;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (((((r104 + r106) * 31) + this.f123355d) * 31) + this.f123356e) * 31;
        ImageSpan r108 = this.f123357f;
        if (r108 == null) goto L13;
        int r109 = r108.hashCode();
    L14:
        int r110 = (r107 + r109) * 31;
        py.k r111 = this.f123358g;
        if (r111 == null) goto L18;
        r102 = r111.hashCode();
    L18:
        return ((((r110 + r102) * 31) + Float.floatToIntBits(this.f123359h)) * 31) + Float.floatToIntBits(this.f123360i);
    L13:
        r109 = 0;
        goto L14
    L9:
        r106 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.event.l
    public final int getLength() {
        return this.f123356e;
    }

    @Override // com.bytedance.android.livesdk.event.l
    public final int getStart() {
        return this.f123355d;
    }

    @Override // com.bytedance.android.livesdk.event.l
    public int getType() {
        return this.f123352a;
    }

    @Override // com.bytedance.android.livesdk.event.l
    public final String getValue() {
        return this.f123353b;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof n) == false) goto L24;
        n r101 = (n) r100;
        if (getType() == r101.getType()) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f123353b, r101.f123353b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f123354c, r101.f123354c) == true) goto L12;
        return false;
    L12:
        if (this.f123355d == r101.f123355d) goto L14;
        return false;
    L14:
        if (this.f123356e == r101.f123356e) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f123357f, r101.f123357f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f123358g, r101.f123358g) == true) goto L20;
        return false;
    L20:
        if (Float.compare(this.f123359h, r101.f123359h) == 0) goto L22;
        return false;
    L22:
        if (Float.compare(this.f123360i, r101.f123360i) == 0) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    public n(int r100, String r101, String r102, int r103, int r104, com.bytedance.android.livesdk.interactivity.comment.input.b r105, py.k r106, float r107) {
        Intrinsics.checkNotNullParameter(r101, "value");
        Intrinsics.checkNotNullParameter(r102, "text");
        Intrinsics.checkNotNullParameter(r105, "imageSpan");
        Intrinsics.checkNotNullParameter(r106, "imageModel");
        this.f123352a = r100;
        this.f123353b = r101;
        this.f123354c = r102;
        this.f123355d = r103;
        this.f123356e = r104;
        this.f123357f = r105;
        this.f123358g = r106;
        this.f123359h = r107;
        this.f123360i = 1.0f;
    }
}
