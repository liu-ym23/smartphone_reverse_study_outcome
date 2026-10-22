package com.bytedance.android.livesdk.chatroom.widget;

import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public final class m1<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PlayerControlWidget f119137a;

    public m1(PlayerControlWidget r100) {
        this.f119137a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        if (((Boolean) r100).booleanValue() == false) goto L5;
        PlayerControlWidget.zq(this.f119137a);
        return;
    L5:
        ILivePlayerClient r101 = PlayerControlWidget.xq(this.f119137a);
        if (r101 == null) goto L10;
        r101.pause();
        return;
    }
}
