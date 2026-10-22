package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.utils;

import android.view.View;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public final class h<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f116809a;

    public h(View r100) {
        this.f116809a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        View r101 = this.f116809a;
        r101.setContentDescription((String) r100);
    }
}
