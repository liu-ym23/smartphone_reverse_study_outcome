package com.bytedance.android.live.broadcastgame.opengame.network;

import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class x implements com.bytedance.android.live.broadcastgame.api.openplatform.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x f60300a = null;

    public x() {
    }

    static {
        f60300a = new x();
    }

    @Override // com.bytedance.android.live.broadcastgame.api.openplatform.c
    public final <T> T getService(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "cls");
        Lazy r101 = LiveOpenGameClient.f60290d;
        return (T) LiveOpenGameClient.a.a().a(r100);
    }
}
