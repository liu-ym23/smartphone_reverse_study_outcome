package com.bytedance.android.livesdk.chatroom.replay.toolbar.presenter;

import android.view.View;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f110155a;

    public b(View r100) {
        this.f110155a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        String r101 = (String) r100;
        View r102 = this.f110155a;
        if (r102 == null) goto L6;
        r102.setContentDescription(r101);
        return;
    }
}
