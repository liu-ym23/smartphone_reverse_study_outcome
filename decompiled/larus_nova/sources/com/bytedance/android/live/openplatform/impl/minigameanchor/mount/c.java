package com.bytedance.android.live.openplatform.impl.minigameanchor.mount;

import com.bytedance.android.live.network.response.Response;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes46.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f85226a;

    public c(Function1 r100) {
        this.f85226a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        this.f85226a.invoke(((Response) r100).data);
    }
}
