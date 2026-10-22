package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AbsAudienceToolbarButtonMoreDialog f115756a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f115757b;

    public b(AbsAudienceToolbarButtonMoreDialog r100, View r101) {
        this.f115756a = r100;
        this.f115757b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        View r101 = this.f115757b;
        Resources r102 = this.f115756a.getContext().getResources();
        r101.setBackgroundDrawable(new BitmapDrawable(r102, (Bitmap) r100));
    }
}
