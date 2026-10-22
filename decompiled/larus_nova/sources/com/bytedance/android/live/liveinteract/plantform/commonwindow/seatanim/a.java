package com.bytedance.android.live.liveinteract.plantform.commonwindow.seatanim;

import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.SeatAnimManager;
import fd2.z;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class a<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SeatAnimEngineWrapper f75871a;

    public a(SeatAnimEngineWrapper r100) {
        this.f75871a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        z r101 = (z) r100;
        SeatAnimManager r102 = this.f75871a.f75864a;
        if (r102 == null) goto L6;
        r102.d(r101.f476512a);
        return;
    }
}
