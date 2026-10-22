package com.bytedance.android.livesdk.chatroom.replay.toolbar.presenter;

import android.view.View;
import com.bytedance.android.live.core.utils.v;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class h<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f110164a;

    public h(View r100) {
        this.f110164a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        if (v.a() == false) goto L5;
        r101.printStackTrace();
    L5:
        this.f110164a.setVisibility(8);
    }
}
