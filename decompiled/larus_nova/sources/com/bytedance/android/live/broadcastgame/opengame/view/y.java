package com.bytedance.android.live.broadcastgame.opengame.view;

import com.bytedance.common.utility.Logger;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes45.dex */
public final class y implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RewardMsgContainer f61333a;

    public y(RewardMsgContainer r100) {
        this.f61333a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f61333a.c();     // Catch: Throwable -> L6
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L9;
        Logger.d("RewardMsgContainer", "RewardMsgContainer,  延时 2s 到，尝试拉取新消息");     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
