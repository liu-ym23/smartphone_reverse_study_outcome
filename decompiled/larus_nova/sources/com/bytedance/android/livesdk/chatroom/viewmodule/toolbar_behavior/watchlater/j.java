package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.watchlater;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public final class j<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f117467a;

    public j(k r100) {
        this.f117467a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Bitmap r101 = (Bitmap) r100;
        View r102 = this.f117467a.f117470c;
        if (r102 == null) goto L6;
        r102.setBackground(new BitmapDrawable(this.f117467a.getContext().getResources(), r101));
        return;
    }
}
