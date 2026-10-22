package com.bytedance.android.live.broadcastgame.effectgame.base;

import com.bytedance.android.livesdkapi.depend.model.Sticker;

/* JADX INFO: loaded from: classes45.dex */
public final class d<T1, T2> implements ttc.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f59621a;

    public d(e r100) {
        this.f59621a = r100;
    }

    @Override // ttc.a
    public final void accept(Object r100, Object r101) {
        Throwable r102 = (Throwable) r101;
        e r103 = this.f59621a;
        c.a r104 = r103.f59622a;
        String r105 = r103.f59623b;
        r104.a(r105, (Sticker) r100);
    }
}
