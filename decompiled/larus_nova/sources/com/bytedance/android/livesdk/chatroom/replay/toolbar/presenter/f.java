package com.bytedance.android.livesdk.chatroom.replay.toolbar.presenter;

import android.view.View;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f110162a;

    public f(View r100) {
        this.f110162a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        View r101 = this.f110162a;
        r101.setContentDescription((String) r100);
    }
}
