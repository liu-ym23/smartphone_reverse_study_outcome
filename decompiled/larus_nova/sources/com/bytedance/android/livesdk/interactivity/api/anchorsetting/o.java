package com.bytedance.android.livesdk.interactivity.api.anchorsetting;

import com.bytedance.android.live.core.utils.f2;
import com.larus.nova.R;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class o<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o f132867a = null;

    static {
        f132867a = new o();
    }

    public o() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        f2.b(R.string.ttlive_web_network_error, 0);
    }
}
