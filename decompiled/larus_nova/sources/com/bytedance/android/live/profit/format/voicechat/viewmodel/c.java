package com.bytedance.android.live.profit.format.voicechat.viewmodel;

import com.bytedance.android.live.network.response.ExtraResponse;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class c<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f87807a = null;

    static {
        f87807a = new c();
    }

    public c() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        ExtraResponse r101 = (ExtraResponse) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        return (com.bytedance.android.live.profit.format.voicechat.model.d) r101.data;
    }
}
