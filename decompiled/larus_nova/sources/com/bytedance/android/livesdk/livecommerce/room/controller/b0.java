package com.bytedance.android.livesdk.livecommerce.room.controller;

import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f151452a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f151453b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WeakReference<Object> f151454c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final w f151455d;

    public b0() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b0) == false) goto L14;
        b0 r101 = (b0) r100;
        if (Intrinsics.areEqual(this.f151452a, r101.f151452a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f151453b, r101.f151453b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f151454c, r101.f151454c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f151455d, r101.f151455d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f151452a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f151453b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        WeakReference<Object> r107 = this.f151454c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        w r110 = this.f151455d;
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
        return "RoomInfoForActivity(roomId=" + this.f151452a + ", uniqueKey=" + this.f151453b + ", controller=" + this.f151454c + ", enterRoomParamsKeeper=" + this.f151455d + ")";
    }

    public b0(String r100, String r101, WeakReference r102) {
        w r103 = new w();
        Intrinsics.checkNotNullParameter(r100, "roomId");
        Intrinsics.checkNotNullParameter(r101, "uniqueKey");
        Intrinsics.checkNotNullParameter(r102, "controller");
        Intrinsics.checkNotNullParameter(r103, "enterRoomParamsKeeper");
        this.f151452a = r100;
        this.f151453b = r101;
        this.f151454c = r102;
        this.f151455d = r103;
    }
}
