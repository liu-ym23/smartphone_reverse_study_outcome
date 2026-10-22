package com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PortraitSimpleZDanmakuPresenter f141742a;

    public b(PortraitSimpleZDanmakuPresenter r100) {
        this.f141742a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        int r102 = i.f141754a;
        StringBuilder r103 = new StringBuilder("history danmaku timeout, residue count: ");
        PortraitSimpleZDanmakuPresenter.IView r104 = (PortraitSimpleZDanmakuPresenter.IView) this.f141742a.f531633a;
        if (r104 == null) goto L5;
        Integer r105 = Integer.valueOf(r104.U());
    L6:
        r103.append(r105);
        i.c(r103.toString());
        PortraitSimpleZDanmakuPresenter.IView r106 = (PortraitSimpleZDanmakuPresenter.IView) this.f141742a.f531633a;
        if (r106 == null) goto L9;
        r106.ps();
    L9:
        this.f141742a.i0(4);
        return;
    L5:
        r105 = null;
        goto L6
    }
}
