package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes8.dex */
public final class u4<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function2 f117397a;

    public u4(Function2 r100) {
        this.f117397a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        com.bytedance.android.live.network.response.a r101 = (com.bytedance.android.live.network.response.a) r100;
        this.f117397a.invoke(Boolean.TRUE, null);
    }
}
