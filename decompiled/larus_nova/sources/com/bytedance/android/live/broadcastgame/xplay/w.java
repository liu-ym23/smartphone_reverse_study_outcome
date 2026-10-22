package com.bytedance.android.live.broadcastgame.xplay;

import com.bytedance.android.live.broadcastgame.api.InteractGameContext;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes45.dex */
public final class w<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ u f62483a;

    public w(u r100) {
        this.f62483a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        InteractGameContext r102 = InteractGameContext.Companion.getContext();
        if (r102 == null) goto L7;
        com.bytedance.live.datacontext.n<com.bytedance.android.live.broadcastgame.api.model.h0.c> r103 = r102.getOpenGameLaunchResult();
        if (r103 == null) goto L7;
        r103.setValue(new com.bytedance.android.live.broadcastgame.api.model.h0.a(null));
    L7:
        ExceptionUtils.handleException(this.f62483a.f62477b.getContext(), r101, "该场景暂不支持此玩法");
    }
}
