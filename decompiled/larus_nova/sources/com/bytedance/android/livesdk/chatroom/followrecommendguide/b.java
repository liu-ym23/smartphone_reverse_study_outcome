package com.bytedance.android.livesdk.chatroom.followrecommendguide;

import com.bytedance.android.live.base.model.feed.FeedExtra;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f106243a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FeedExtra f106244b;

    public b() {
        this(0, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L10;
        b r101 = (b) r100;
        if (this.f106243a == r101.f106243a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f106244b, r101.f106244b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        int r100 = this.f106243a * 31;
        FeedExtra r101 = this.f106244b;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public final String toString() {
        return "RecommendLoadRetryEvent(curIndex=" + this.f106243a + ", extra=" + this.f106244b + ")";
    }

    public b(int r100, FeedExtra r101) {
        this.f106243a = r100;
        this.f106244b = r101;
    }
}
