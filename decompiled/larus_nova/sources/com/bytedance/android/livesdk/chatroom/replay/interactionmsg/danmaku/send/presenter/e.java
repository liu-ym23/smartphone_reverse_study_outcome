package com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.send.presenter;

import com.bytedance.android.livesdk.utils.t2;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InputDanmuTextPresenter f109133a;

    public e(InputDanmuTextPresenter r100) {
        this.f109133a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Boolean r101 = (Boolean) r100;
        t2.a(this.f109133a.getContext(), InputDanmuTextPresenter.n(this.f109133a));
    }
}
