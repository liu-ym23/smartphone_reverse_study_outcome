package com.bytedance.android.livesdk.livecommerce.room.api;

import com.bytedance.android.livesdk.livecommerce.room.LiveRoomProvider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f151385a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f151386b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LiveRoomProvider.ECProviderSource f151387c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof i) == false) goto L12;
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f151385a, r101.f151385a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f151386b, r101.f151386b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f151387c, r101.f151387c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f151385a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f151386b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        LiveRoomProvider.ECProviderSource r107 = this.f151387c;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "RoomApiInfo(roomId=" + this.f151385a + ", uniqueKey=" + this.f151386b + ", source=" + this.f151387c + ")";
    }

    public i(String r100, String r101, LiveRoomProvider.ECProviderSource r102) {
        Intrinsics.checkNotNullParameter(r100, "roomId");
        Intrinsics.checkNotNullParameter(r101, "uniqueKey");
        Intrinsics.checkNotNullParameter(r102, "source");
        this.f151385a = r100;
        this.f151386b = r101;
        this.f151387c = r102;
    }
}
