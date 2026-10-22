package com.bytedance.android.live.revlink.impl.pk.dialog.fragment;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f95967a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f95968b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f95969c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f95970d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f95971e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f95972f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f95973g;

    public o() {
        this(0, null, 0, null, null, null, 127);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof o) == false) goto L20;
        o r101 = (o) r100;
        if (this.f95967a == r101.f95967a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f95968b, r101.f95968b) == true) goto L10;
        return false;
    L10:
        if (this.f95969c == r101.f95969c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f95970d, r101.f95970d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f95971e, r101.f95971e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f95972f, r101.f95972f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f95973g, r101.f95973g) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        long r100 = this.f95967a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        String r102 = this.f95968b;
        int r103 = 0;
        if (r102 == null) goto L5;
        int r104 = r102.hashCode();
    L6:
        long r105 = this.f95969c;
        int r106 = (((r101 + r104) * 31) + ((int) (r105 ^ (r105 >>> 32)))) * 31;
        String r107 = this.f95970d;
        if (r107 == null) goto L9;
        int r108 = r107.hashCode();
    L10:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f95971e;
        if (r110 == null) goto L13;
        int r111 = r110.hashCode();
    L14:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f95972f;
        if (r113 == null) goto L17;
        int r114 = r113.hashCode();
    L18:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f95973g;
        if (r116 == null) goto L22;
        r103 = r116.hashCode();
    L22:
        return r115 + r103;
    L17:
        r114 = 0;
        goto L18
    L13:
        r111 = 0;
        goto L14
    L9:
        r108 = 0;
        goto L10
    L5:
        r104 = 0;
        goto L6
    }

    public final String toString() {
        return "ReserveReplyParms(roomId=" + this.f95967a + ", inviteUserId=" + this.f95968b + ", inviteRoomId=" + this.f95969c + ", clientAttachedInfo=" + this.f95970d + ", battleAttachedInfo=" + this.f95971e + ", reserveId=" + this.f95972f + ", inviteOpenId=" + this.f95973g + ")";
    }

    public o(long r100, String r101, long r102, String r110, String r111, String r112, int r113) {
        if ((r113 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r113 & 2) == 0) goto L9;
        r101 = "";
    L9:
        if ((r113 & 4) == 0) goto L12;
        r102 = 0;
    L12:
        if ((r113 & 8) == 0) goto L14;
        String r103 = "";
    L16:
        if ((r113 & 16) == 0) goto L19;
        r110 = "";
    L19:
        if ((r113 & 32) == 0) goto L22;
        r111 = "";
    L22:
        if ((r113 & 64) == 0) goto L24;
        r112 = "";
    L24:
        Intrinsics.checkNotNullParameter(r101, "inviteUserId");
        Intrinsics.checkNotNullParameter(r103, "clientAttachedInfo");
        Intrinsics.checkNotNullParameter(r110, "battleAttachedInfo");
        Intrinsics.checkNotNullParameter(r111, "reserveId");
        Intrinsics.checkNotNullParameter(r112, "inviteOpenId");
        this.f95967a = r100;
        this.f95968b = r101;
        this.f95969c = r102;
        this.f95970d = r103;
        this.f95971e = r110;
        this.f95972f = r111;
        this.f95973g = r112;
        return;
    L14:
        r103 = null;
        goto L16
    }
}
