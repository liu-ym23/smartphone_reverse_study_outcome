package com.bytedance.android.live.broadcastgame.channel;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes45.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ContinuousTimeTicker f59567a;

    public b(ContinuousTimeTicker r100) {
        this.f59567a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ALogger.e("AAM.ContinuousTimeTicker", "[" + this.f59567a.f59565f + "]@{" + this.f59567a.hashCode() + "} sender error: " + ((Throwable) r100));
    }
}
