package com.bytedance.android.livesdk.ktvimpl.feed;

import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes10.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ KtvComponentMidiFeedViewModel f143917a;

    public c(KtvComponentMidiFeedViewModel r100) {
        this.f143917a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        KtvComponentFeedViewModel r102 = this.f143917a.f143854p;
        if (r102 == null) goto L5;
        KtvRoomLyricsStateMachineConfig.d r103 = r102.f143828b.b();
    L7:
        if ((r103 instanceof KtvRoomLyricsStateMachineConfig.d.f) == true) goto L9;
        this.f143917a.f143845g.setValue(Boolean.TRUE);
        return;
    L9:
        this.f143917a.f143850l = true;
        return;
    L5:
        r103 = null;
        goto L7
    }
}
