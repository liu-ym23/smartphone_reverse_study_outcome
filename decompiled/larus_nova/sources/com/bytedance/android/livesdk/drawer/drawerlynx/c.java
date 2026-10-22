package com.bytedance.android.livesdk.drawer.drawerlynx;

import com.bytedance.android.live.core.utils.f2;
import com.larus.nova.R;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f122426a;

    public c(d r100) {
        this.f122426a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        f2.b(R.string.ttlive_castscreen_scan_tip_no_net, 0);
        this.f122426a.finishWithFailure();
    }
}
