package com.jakewharton.rxbinding.widget;

import android.database.DataSetObserver;
import android.widget.Adapter;
import kg.a;
import rx.Observable;
import rx.Subscriber;

/* JADX INFO: loaded from: classes3.dex */
final class AdapterDataChangeOnSubscribe<T extends Adapter> implements Observable.OnSubscribe<T> {
    final T adapter;

    public AdapterDataChangeOnSubscribe(T r10) {
        this.adapter = r10;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Subscriber r10) {
        call2(r10);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public void call2(final Subscriber r10) {
        a.verifyMainThread();
        final DataSetObserver r11 = new AnonymousClass1(this, r10);
        r10.add(new AnonymousClass2(this, r11));
        this.adapter.registerDataSetObserver(r11);
        r10.onNext(this.adapter);
    }
}
