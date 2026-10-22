package com.bytedance.android.livesdk.chatroom.widget.landscape;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public final class k<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LandscapeQuickShotObserveWidget f119099a;

    public k(LandscapeQuickShotObserveWidget r100) {
        this.f119099a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        LandscapeQuickShotObserveWidget.wq(this.f119099a);
    }
}
