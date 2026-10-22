package com.bytedance.android.live.liveinteract.voicechat.emoji.panel;

import com.bytedance.android.live.network.response.BaseResponse;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class c0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f80199a;

    public c0(Function1 r100) {
        this.f80199a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        BaseResponse r101 = (BaseResponse) r100;
        Intrinsics.checkNotNullParameter(r101, "response");
        this.f80199a.invoke(r101.data);
    }
}
