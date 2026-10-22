package com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class v<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f93614a;

    public v(View r100) {
        this.f93614a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        this.f93614a.setBackground(new BitmapDrawable((Bitmap) r100));
    }
}
