package com.bytedance.android.livesdk.chatroom.gamestickerv2.componentv2;

import com.bytedance.android.livesdkapi.hybridapi.SubscriberJsEvent;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes7.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f106343a;

    public f(Function1 r100) {
        this.f106343a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Function1 r101 = this.f106343a;
        r101.invoke((SubscriberJsEvent) r100);
    }
}
