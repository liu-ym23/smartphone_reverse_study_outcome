package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import android.graphics.drawable.Drawable;
import android.view.View;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class b1 implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f115758a;

    public /* synthetic */ b1(View r100) {
        this.f115758a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        this.f115758a.setBackgroundDrawable((Drawable) r100);
    }
}
