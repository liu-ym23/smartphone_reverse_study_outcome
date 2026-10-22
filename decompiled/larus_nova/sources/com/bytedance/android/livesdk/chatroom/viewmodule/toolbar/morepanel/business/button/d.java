package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.button;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f116515a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f116516b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Context f116517c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ lp1.a f116518d;

    public d(e r100, View r101, Context r102, lp1.a r103) {
        this.f116515a = r100;
        this.f116516b = r101;
        this.f116517c = r102;
        this.f116518d = r103;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        View r101 = this.f116516b;
        Resources r102 = this.f116517c.getResources();
        r101.setBackgroundDrawable(new BitmapDrawable(r102, (Bitmap) r100));
        e r103 = this.f116515a;
        View r104 = this.f116516b;
        lp1.a r105 = this.f116518d;
        r103.getClass();
        e.a(r104, r105);
    }
}
