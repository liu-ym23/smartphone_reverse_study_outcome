package com.bytedance.android.livesdk.chatroom.indicator.shortterm.framework;

import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes7.dex */
public final class g implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f106640a;

    public g(Function1 r100) {
        this.f106640a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final /* synthetic */ void accept(Object r100) {
        this.f106640a.invoke(r100);
    }
}
