package com.bytedance.android.live.broadcastgame.openplatform.behavior;

import android.view.View;
import com.bytedance.android.live.broadcast.api.IBroadcastService;
import io.reactivex.functions.Consumer;
import nz.h;

/* JADX INFO: loaded from: classes45.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f61372a;

    public e(View r100) {
        this.f61372a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        IBroadcastService r102 = (IBroadcastService) va1.b.a.f553922a.a(IBroadcastService.class);
        if (r102 == null) goto L8;
        h r103 = r102.getBroadcastBubbleManager();
        if (r103 == null) goto L9;
        r103.b(this.f61372a.getContext(), this.f61372a, String.valueOf(6));
        return;
    L9:
        return;
    }
}
