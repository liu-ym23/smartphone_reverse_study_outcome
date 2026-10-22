package com.bytedance.android.live.revenue.platform.network.dynamic;

import io.reactivex.functions.Consumer;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes47.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f91519a;

    public e(Function1 r100) {
        this.f91519a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        com.ss.ugc.live.sdk.message.wrsc.data.a r101 = (com.ss.ugc.live.sdk.message.wrsc.data.a) ((Pair) r100).component2();
        this.f91519a.invoke(r101);
    }
}
