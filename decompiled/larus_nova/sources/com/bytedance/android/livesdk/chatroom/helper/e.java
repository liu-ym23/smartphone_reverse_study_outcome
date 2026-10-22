package com.bytedance.android.livesdk.chatroom.helper;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f106436a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final hl0.a f106437b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L10;
        e r101 = (e) r100;
        if (this.f106436a == r101.f106436a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f106437b, r101.f106437b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        int r100 = this.f106436a * 31;
        hl0.a r101 = this.f106437b;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public final String toString() {
        return "EnterRoomApiState(roomEnterApiStatus=" + this.f106436a + ", error=" + this.f106437b + ")";
    }

    public e(int r100, hl0.a r101) {
        this.f106436a = r100;
        this.f106437b = r101;
    }
}
