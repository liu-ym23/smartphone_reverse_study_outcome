package com.bytedance.android.livesdk.chatroom.broadcast.v2.scene;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Boolean f105460a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Long f105461b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Long f105462c;

    public g() {
        this(null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof g) == false) goto L12;
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f105460a, r101.f105460a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f105461b, r101.f105461b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f105462c, r101.f105462c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        Boolean r100 = this.f105460a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Long r104 = this.f105461b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.f105462c;
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
        return "LastAnchorRoomInfo(isDirectGoEndPage=" + this.f105460a + ", roomId=" + this.f105461b + ", streamId=" + this.f105462c + ")";
    }

    public g(Boolean r100, Long r101, Long r102) {
        this.f105460a = r100;
        this.f105461b = r101;
        this.f105462c = r102;
    }
}
