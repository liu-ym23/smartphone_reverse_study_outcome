package com.bytedance.android.window.shop.home;

import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes14.dex */
public final class h<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f188194a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f188195b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ECWindowParam f188196c;

    public h(k r100, String r101, ECWindowParam r102) {
        this.f188194a = r100;
        this.f188195b = r101;
        this.f188196c = r102;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        if (((Boolean) r100).booleanValue() == false) goto L7;
        List<Runnable> r101 = this.f188194a.f188232a;
        ArrayList r102 = (ArrayList) r101;
        r102.add(new g(this.f188195b, this.f188196c.getAuthorId(), this.f188196c.getSecAuthorId()));
        return;
    }
}
