package com.bytedance.android.live.revlink.impl.multianchor.transfer;

import com.bytedance.android.livesdkapi.eventbus.HorizontalPlayEvent;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class a<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f94679a = null;

    static {
        f94679a = new a();
    }

    public a() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Integer r101 = (Integer) r100;
        xs2.b.a().post(new HorizontalPlayEvent(1));
    }
}
