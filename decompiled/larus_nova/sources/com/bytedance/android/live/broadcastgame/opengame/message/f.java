package com.bytedance.android.live.broadcastgame.opengame.message;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class f extends m {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f60199d;

    public final String toString() {
        return "{roomId:" + this.f60249b + ", appId:" + this.f60248a + ", connId:" + this.f60250c + ", data:" + this.f60199d + '}';
    }

    public f(long r100, String r101, long r110, String r111) {
        Intrinsics.checkNotNullParameter(r101, "appId");
        Intrinsics.checkNotNullParameter(r111, "data");
        super(r101, r100, r110);
        this.f60199d = r111;
    }
}
