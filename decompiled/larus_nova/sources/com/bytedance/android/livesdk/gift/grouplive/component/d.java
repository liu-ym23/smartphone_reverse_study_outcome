package com.bytedance.android.livesdk.gift.grouplive.component;

import com.bytedance.android.live.network.response.ExtraResponse;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f126289a = null;

    static {
        f126289a = new d();
    }

    public d() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        jy0.b.a("GroupComponentView", "request success: " + ((ExtraResponse) r100).data);
    }
}
