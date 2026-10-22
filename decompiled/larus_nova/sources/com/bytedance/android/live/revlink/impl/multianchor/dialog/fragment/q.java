package com.bytedance.android.live.revlink.impl.multianchor.dialog.fragment;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.widget.TextView;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class q<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TextView f93504a;

    public q(TextView r100) {
        this.f93504a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        this.f93504a.setBackground(new BitmapDrawable((Bitmap) r100));
    }
}
