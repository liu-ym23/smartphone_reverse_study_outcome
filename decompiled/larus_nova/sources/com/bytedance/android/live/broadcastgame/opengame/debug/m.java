package com.bytedance.android.live.broadcastgame.opengame.debug;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes45.dex */
public final class m<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OpenPlatformMiniAppDebugger f60026a;

    public m(OpenPlatformMiniAppDebugger r100) {
        this.f60026a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        OpenPlatformMiniAppDebugger r102 = this.f60026a;
        if (r102.f59983c == true) goto L6;
        r102.g(r102.getContextWeakRef().get());
        this.f60026a.f(false, new Throwable("OpenPlatformMiniAppDebugger 初始化失败。原因：未收到校验消息通知"));
        return;
    }
}
