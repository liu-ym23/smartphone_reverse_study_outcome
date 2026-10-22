package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public final class g<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CastScreenCompositeWidget f113342a;

    public g(CastScreenCompositeWidget r100) {
        this.f113342a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        h80.c r101 = (h80.c) r100;
        this.f113342a.wq();
    }
}
