package com.bytedance.android.live.livepullstream.service;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.videoarch.strategy.LiveStrategyManager;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ JSONObject f82518a;

    public f(JSONObject r100) {
        this.f82518a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        LiveStrategyManager.inst().executeCommand(4, 406, 0, this.f82518a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
