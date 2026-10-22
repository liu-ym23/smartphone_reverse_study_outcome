package com.bytedance.android.live.broadcastgame.opengame.message;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class w implements com.bytedance.android.live.broadcastgame.v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.live.broadcastgame.api.openplatform.a f60284a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof w) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f60284a, ((w) r100).f60284a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        com.bytedance.android.live.broadcastgame.api.openplatform.a r100 = this.f60284a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "GameIntroCardMessage(cardInfo=" + this.f60284a + ")";
    }

    public w(com.bytedance.android.live.broadcastgame.api.openplatform.a r100) {
        Intrinsics.checkNotNullParameter(r100, "cardInfo");
        this.f60284a = r100;
    }
}
