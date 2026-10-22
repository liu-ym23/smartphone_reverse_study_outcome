package com.bytedance.android.livesdk.chatroom.replay.toolbar.widget;

import io.reactivex.functions.Consumer;
import mq1.u;

/* JADX INFO: loaded from: classes7.dex */
public final class j<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ u f110233a;

    public j(u r100) {
        this.f110233a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        this.f110233a.hidePlayerTip("schedule_close");
    }
}
