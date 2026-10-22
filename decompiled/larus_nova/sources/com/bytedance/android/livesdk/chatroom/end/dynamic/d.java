package com.bytedance.android.livesdk.chatroom.end.dynamic;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.ViewGroup;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f106047a;

    public d(ViewGroup r100) {
        this.f106047a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Bitmap r101 = (Bitmap) r100;
        if (r101 == null) goto L6;
        this.f106047a.setBackground(new BitmapDrawable(r101));
        return;
    }
}
