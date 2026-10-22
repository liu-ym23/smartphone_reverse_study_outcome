package com.bytedance.android.live.revenue.platform.network.dynamic;

import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes47.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f91520a;

    public f(Function1 r100) {
        this.f91520a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Function1 r101 = this.f91520a;
        r101.invoke((com.ss.ugc.live.sdk.message.wrsc.data.a) r100);
    }
}
