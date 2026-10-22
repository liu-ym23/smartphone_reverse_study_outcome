package com.bytedance.android.livesdk.chatroom.replay.highlight;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class a<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ReplayInnerHighLightService f108763a;

    public a(ReplayInnerHighLightService r100) {
        this.f108763a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Boolean r101 = (Boolean) r100;
        this.f108763a.c();
    }
}
