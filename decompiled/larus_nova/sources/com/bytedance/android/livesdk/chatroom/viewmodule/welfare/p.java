package com.bytedance.android.livesdk.chatroom.viewmodule.welfare;

import com.bytedance.android.live.core.utils.f2;
import com.larus.nova.R;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public final class p<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p f117634a = null;

    static {
        f117634a = new p();
    }

    public p() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        f2.b(R.string.ttlive_network_error, 0);
    }
}
