package com.bytedance.android.live.liveinteract.api.utils;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class h implements com.bytedance.android.scope.o, b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bn0.b f71514a;

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    public h(bn0.b r100) {
        Intrinsics.checkNotNullParameter(r100, "myScope");
        this.f71514a = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.api.utils.b
    public final void Eh(Throwable r100) {
        g.r("join_fail", r100);
    }

    @Override // com.bytedance.android.live.liveinteract.api.utils.b
    public final void r6(Map r100) {
        g.n("server_sys_kickout", r100, tc0.c.h(), true);
    }
}
