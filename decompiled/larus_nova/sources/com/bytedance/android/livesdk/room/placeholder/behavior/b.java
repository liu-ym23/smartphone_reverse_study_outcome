package com.bytedance.android.livesdk.room.placeholder.behavior;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes11.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AnchorCommerceWrapper f157713a;

    public b(AnchorCommerceWrapper r100) {
        this.f157713a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        u71.a r101 = (u71.a) r100;
        com.bytedance.android.live.room.api.messagewindow.builder.card.c r102 = this.f157713a.f157679e;
        if (r102 == null) goto L12;
        com.bytedance.android.live.room.api.messagewindow.builder.card.b r103 = r102.f98972a;
        if (r103 != null) goto L7;
        return;
    L7:
        if (r103.getType() != r101.f549033a) goto L14;
        ALogger.i("EcommerceCommonCard", "onCommonCardCycleDisplayEvent");
        com.bytedance.android.live.room.api.messagewindow.builder.card.c r104 = this.f157713a.f157679e;
        if (r104 == null) goto L15;
        r104.c(null);
        return;
    L15:
        return;
    L14:
        return;
    }
}
