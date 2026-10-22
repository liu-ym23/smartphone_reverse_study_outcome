package com.bytedance.android.live.broadcastgame.opengame.performance;

import com.bytedance.android.live.broadcastgame.api.AnchorGameContext;
import com.bytedance.live.datacontext.m;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes45.dex */
public final class j<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OpenPlatformPerfRuntime f60741a;

    public j(OpenPlatformPerfRuntime r100) {
        this.f60741a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Boolean r101 = (Boolean) r100;
        AnchorGameContext.Companion.getClass();
        AnchorGameContext r102 = AnchorGameContext.a.a();
        if (r102 == null) goto L9;
        m<Boolean> r103 = r102.getOpenGamePerfUploadState();
        if (r103 == null) goto L9;
        if (r103.getValue().booleanValue() == true) goto L9;
        return;
    L9:
        this.f60741a.c(2);
    }
}
