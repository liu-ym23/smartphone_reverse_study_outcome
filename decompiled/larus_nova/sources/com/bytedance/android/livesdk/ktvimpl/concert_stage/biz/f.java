package com.bytedance.android.livesdk.ktvimpl.concert_stage.biz;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes10.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f143739a;

    public f(c r100) {
        this.f143739a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Boolean r101 = (Boolean) r100;
        c r102 = this.f143739a;
        com.bytedance.android.livesdk.chatroom.o r103 = com.bytedance.android.live.liveinteract.api.utils.m.i();
        if (r103 == null) goto L9;
        com.bytedance.live.datacontext.m<Boolean> r104 = r103.X1();
        if (r104 == null) goto L9;
        Boolean r105 = r104.getValue();
        if (r105 == null) goto L9;
        boolean r106 = r105.booleanValue();
    L10:
        r102.l(r106);
        return;
    L9:
        r106 = false;
        goto L10
    }
}
