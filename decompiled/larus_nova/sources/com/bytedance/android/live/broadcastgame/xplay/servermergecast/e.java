package com.bytedance.android.live.broadcastgame.xplay.servermergecast;

import io.reactivex.functions.Consumer;
import kotlin.Unit;

/* JADX INFO: loaded from: classes45.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ XplayRTCManager f62413a;

    public e(XplayRTCManager r100) {
        this.f62413a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Unit r101 = (Unit) r100;
        ei6.a r102 = this.f62413a.f62393h;
        if (r102 == null) goto L8;
        vi6.a r103 = r102.v();
        if (r103 == null) goto L9;
        r103.f();
        return;
    L9:
        return;
    }
}
