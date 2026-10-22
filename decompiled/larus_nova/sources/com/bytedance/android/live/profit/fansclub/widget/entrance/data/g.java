package com.bytedance.android.live.profit.fansclub.widget.entrance.data;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class g<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ EntranceDataSource$subscribeEvent$6 f87404a;

    public g(EntranceDataSource$subscribeEvent$6 r100) {
        this.f87404a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        IRoom r101 = (IRoom) sh6.c.b((sh6.b) r100);
        if (r101 == null) goto L6;
        this.f87404a.invoke2(r101);
        return;
    }
}
