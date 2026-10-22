package com.bytedance.android.livesdk.chatroom.replay.player.seekbar.thumbprogress;

import android.widget.TextView;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class h<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f109822a;

    public h(f r100) {
        this.f109822a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        TextView r101 = (TextView) this.f109822a.f109782i.getValue();
        int r102 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.o.f117947a;
        r101.setText(com.bytedance.android.livesdk.chatroom.vs_base.base.util.o.b(((Long) r100).longValue()));
    }
}
