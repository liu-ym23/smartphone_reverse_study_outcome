package com.jakewharton.rxbinding.widget;

import android.widget.AbsListView;
import kg.a;
import rx.Observable;
import rx.Subscriber;

/* JADX INFO: loaded from: classes3.dex */
final class AbsListViewScrollEventOnSubscribe implements Observable.OnSubscribe<AbsListViewScrollEvent> {
    final AbsListView view;

    public AbsListViewScrollEventOnSubscribe(AbsListView r10) {
        this.view = r10;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Subscriber r10) {
        call2(r10);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public void call2(final Subscriber r10) {
        a.verifyMainThread();
        AbsListView.OnScrollListener r11 = new AnonymousClass1(this, r10);
        r10.add(new AnonymousClass2(this));
        this.view.setOnScrollListener(r11);
    }
}
