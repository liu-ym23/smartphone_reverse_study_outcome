package com.bytedance.android.livesdk.chatroom.broadcast.v2.service;

import com.bytedance.android.live.core.log.ALogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class i implements com.bytedance.android.scope.o, com.bytedance.android.live.broadcast.api.scope.service.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i00.a f105518a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j f105519b;

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
        if (this.f105518a.h() == false) goto L5;
        return;
    L5:
        ALogger.i("BroadcastInLiveInstanceScope", "BroadcastShellRoomStateService start");
        i00.a r100 = this.f105518a;
        r100.d(com.bytedance.android.live.broadcast.api.scope.service.c.class, r100.getScope());
    }

    public i(i00.a r100, j r101) {
        Intrinsics.checkNotNullParameter(r100, "inst");
        Intrinsics.checkNotNullParameter(r101, "shellStateDispatcher");
        this.f105518a = r100;
        this.f105519b = r101;
    }
}
