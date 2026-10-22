package com.bytedance.android.livesdk.feed.openui.view;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HorizontalLiveListView f124268a;

    public c(HorizontalLiveListView r100) {
        this.f124268a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Integer r101 = (Integer) r100;
        this.f124268a.refresh();
    }
}
