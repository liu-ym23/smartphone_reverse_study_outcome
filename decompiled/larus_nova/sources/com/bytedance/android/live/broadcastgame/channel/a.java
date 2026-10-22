package com.bytedance.android.live.broadcastgame.channel;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes45.dex */
public final class a<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ContinuousTimeTicker f59566a;

    public a(ContinuousTimeTicker r100) {
        this.f59566a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        ALogger.d("AAM.ContinuousTimeTicker", "[" + this.f59566a.f59565f + "]@{" + this.f59566a.hashCode() + "} Tick " + r101);
        this.f59566a.f59562c = System.currentTimeMillis();
        Function1<? super Long, Unit> r102 = this.f59566a.f59560a;
        if (r102 == null) goto L6;
        Unit r103 = r102.invoke(r101);
        return;
    }
}
