package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.utils;

import android.graphics.drawable.Drawable;
import android.view.View;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public final class i<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f116810a;

    public i(View r100) {
        this.f116810a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        View r101 = this.f116810a;
        r101.setBackgroundDrawable((Drawable) r100);
    }
}
