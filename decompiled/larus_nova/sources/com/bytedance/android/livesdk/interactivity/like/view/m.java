package com.bytedance.android.livesdk.interactivity.like.view;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class m<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DiggCountFlipperLayout f137948a;

    public m(DiggCountFlipperLayout r100) {
        this.f137948a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        n81.a.b("user digg");
        this.f137948a.h();
    }
}
