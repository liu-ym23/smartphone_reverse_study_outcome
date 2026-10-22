package com.bytedance.android.live.messagewindow.framework.handler;

import com.bytedance.android.live.room.api.messagewindow.monitor.CardAlogParamsBuilder;
import com.bytedance.android.live.room.api.messagewindow.monitor.i;
import io.reactivex.functions.Consumer;
import kotlin.Unit;

/* JADX INFO: loaded from: classes46.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BottomRightCommonCardHandler f83110a;

    public c(BottomRightCommonCardHandler r100) {
        this.f83110a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        i r102 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r102 == null) goto L7;
        CardAlogParamsBuilder r103 = new CardAlogParamsBuilder();
        r103.d(this.f83110a.f83089b);
        r103.c("recreateCard error, " + r101);
        Unit r104 = Unit.INSTANCE;
        r102.d(r103.b());
        return;
    }
}
