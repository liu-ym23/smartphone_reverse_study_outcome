package com.bytedance.android.live.liveinteract.revenue.adventure.linkcore;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f77929a;

    public c(b r100) {
        this.f77929a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        b r102 = this.f77929a;
        r102.getClass();
        ALogger.i("AdventureLinkSecurityManager", "executeCheckRtcRoomTask");
        r102.f77928c.a("count_down");
    }
}
