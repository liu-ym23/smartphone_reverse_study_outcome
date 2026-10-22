package com.bytedance.android.livesdk.chatroom.utils;

import com.bytedance.android.livesdkapi.coin.CoinTaskStatus;
import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f114647a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CoinTaskStatus f114648b;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof v) == false) goto L10;
        v r101 = (v) r100;
        if (Intrinsics.areEqual(this.f114647a, r101.f114647a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f114648b, r101.f114648b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f114647a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        CoinTaskStatus r104 = this.f114648b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "EnterForTaskModel(channelId=" + this.f114647a + ", coinTaskStatus=" + this.f114648b + ")";
    }

    public v(CoinTaskStatus r100) {
        Intrinsics.checkNotNullParameter("164001", RemoteMessageConst.Notification.CHANNEL_ID);
        Intrinsics.checkNotNullParameter(r100, "coinTaskStatus");
        this.f114647a = "164001";
        this.f114648b = r100;
    }
}
