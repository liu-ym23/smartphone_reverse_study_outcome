package com.bytedance.android.livesdk.livecommerce.room.controller.business;

import android.content.Context;
import com.larus.nova.R;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes10.dex */
public final class p<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f151666a;

    public p(Context r100) {
        this.f151666a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        Context r102 = this.f151666a;
        com.bytedance.android.livesdk.livecommerce.utils.k.n(r102, th.a.g(r102, R.string.ec_net_error_retry));
    }
}
