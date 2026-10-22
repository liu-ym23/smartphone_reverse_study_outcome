package com.bytedance.android.livesdk.livecommerce.room.widgets.start_live;

import android.content.Context;
import com.larus.nova.R;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes10.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f152806a;

    public c(Context r100) {
        this.f152806a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        Context r102 = this.f152806a;
        com.bytedance.android.livesdk.livecommerce.utils.k.n(r102, th.a.g(r102, R.string.ec_net_error));
    }
}
