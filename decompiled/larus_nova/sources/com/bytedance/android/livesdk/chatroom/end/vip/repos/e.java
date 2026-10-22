package com.bytedance.android.livesdk.chatroom.end.vip.repos;

import com.bytedance.android.livesdkapi.hybridapi.SubscriberJsEvent;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;

/* JADX INFO: loaded from: classes7.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VipStateRepository f106160a;

    public e(VipStateRepository r100) {
        this.f106160a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        SubscriberJsEvent r101 = (SubscriberJsEvent) r100;
        ((BehaviorSubject) this.f106160a.f106154c.getValue()).onNext(Boolean.TRUE);
    }
}
