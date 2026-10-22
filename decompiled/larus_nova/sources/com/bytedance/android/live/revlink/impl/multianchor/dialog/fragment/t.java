package com.bytedance.android.live.revlink.impl.multianchor.dialog.fragment;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class t<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f93509a;

    public t(View r100) {
        this.f93509a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Bitmap r101 = (Bitmap) r100;
        View r102 = this.f93509a;
        if (r102 == null) goto L6;
        r102.setBackground(new BitmapDrawable(r101));
        return;
    }
}
