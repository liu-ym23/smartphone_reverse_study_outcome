package com.bytedance.android.live.broadcastgame.opengame.performance;

import com.bytedance.android.live.broadcastgame.opengame.message.j0;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class k<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OpenPlatformPerfRuntime f60742a;

    public k(OpenPlatformPerfRuntime r100) {
        this.f60742a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        j0 r101 = (j0) r100;
        if (Intrinsics.areEqual(this.f60742a.f60712f, r101.f60237a) == true) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(this.f60742a.f60711e, r101.f60238b) == false) goto L9;
        this.f60742a.c(1);
        return;
    }
}
