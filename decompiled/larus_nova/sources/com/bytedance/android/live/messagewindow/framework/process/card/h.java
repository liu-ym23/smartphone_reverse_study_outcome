package com.bytedance.android.live.messagewindow.framework.process.card;

import com.bytedance.android.live.room.api.messagewindow.lifecycle.ICardLifecycle$State;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class h<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Runnable f83189a;

    public h(g r100) {
        this.f83189a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        if (((ICardLifecycle$State) r100) != ICardLifecycle$State.Hidden) goto L6;
        this.f83189a.run();
        return;
    }
}
