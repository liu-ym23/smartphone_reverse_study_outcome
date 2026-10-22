package com.bytedance.android.live.revlink.impl.multianchor.utils;

import com.bytedance.android.live.revenuelink.connect.ConnectDataContext;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKtKt;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class k<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f94944a;

    public k(i r100) {
        this.f94944a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        sh6.b r101 = (sh6.b) r100;
        com.bytedance.android.livesdk.revenue.service.room.c r102 = this.f94944a.f94940d;
        if (r102 == null) goto L9;
        com.bytedance.android.livesdk.revenue.room.a r103 = r102.getRoomContext();
        if (r103 == null) goto L9;
        IRoomBase r104 = r103.getCommonRoom();
        if (r104 == null) goto L9;
        Long r105 = Long.valueOf(IRoomKtKt.getId(r104));
    L10:
        StringBuilder r106 = new StringBuilder("liveStartTime=");
        r106.append(this.f94944a.f94938b);
        r106.append(", current live duration=");
        i97.a r107 = i97.a.f488802a;
        r106.append((System.currentTimeMillis() - this.f94944a.f94938b) / ((long) 1000));
        r106.append("s roomId=");
        r106.append(r105);
        jy0.b.f(ConnectDataContext.TAG, r106.toString(), null, 4);
        return;
    L9:
        r105 = null;
        goto L10
    }
}
