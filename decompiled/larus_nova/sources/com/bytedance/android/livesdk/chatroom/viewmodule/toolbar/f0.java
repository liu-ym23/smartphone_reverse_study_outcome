package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public final class f0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LandscapeTopMoreHolder f116301a;

    public f0(LandscapeTopMoreHolder r100) {
        this.f116301a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        View r101 = this.f116301a.f115657c;
        Resources r102 = this.f116301a.getContext().getResources();
        r101.setBackground(new BitmapDrawable(r102, (Bitmap) r100));
    }
}
