package com.bytedance.android.livesdk.gift.platform.business.giftwall;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f129643a;

    public c(String r100) {
        this.f129643a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        jy0.b.a("ttlive_gift_wall", "fetchExhibitionData uid=" + this.f129643a + " failed " + ((Throwable) r100));
    }
}
