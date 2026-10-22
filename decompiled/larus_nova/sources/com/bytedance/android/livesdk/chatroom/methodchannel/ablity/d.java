package com.bytedance.android.livesdk.chatroom.methodchannel.ablity;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Disposable f106842a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ sy.a f106843b;

    public d(Disposable r100, sy.a r101) {
        this.f106842a = r100;
        this.f106843b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ALogger.w("CheckLiveRoomMethod", ((Throwable) r100).getMessage());
        this.f106842a.dispose();
        this.f106843b.invoke(Boolean.TRUE);
    }
}
