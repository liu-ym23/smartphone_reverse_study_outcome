package com.bytedance.android.live.messagewindow.framework.manager;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a.e f83124a;

    public c(a.e r100) {
        this.f83124a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        a r101 = this.f83124a.f83120c;
        String r102 = "getPublicScreenDataSource " + this.f83124a.hashCode() + ' ' + ((i32.a) r100);
        int r103 = a.f83112d;
        r101.getClass();
        a.a(r102);
    }
}
