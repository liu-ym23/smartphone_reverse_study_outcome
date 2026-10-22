package com.jakewharton.rxbinding.widget;

import android.widget.AdapterView;
import kg.a;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Func0;

/* JADX INFO: loaded from: classes3.dex */
final class AdapterViewItemLongClickOnSubscribe implements Observable.OnSubscribe<Integer> {
    final Func0<Boolean> handled;
    final AdapterView<?> view;

    public AdapterViewItemLongClickOnSubscribe(AdapterView<?> r10, Func0<Boolean> r11) {
        this.view = r10;
        this.handled = r11;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Subscriber r10) {
        call2(r10);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public void call2(final Subscriber r10) {
        a.verifyMainThread();
        AdapterView.OnItemLongClickListener r11 = new AnonymousClass1(this, r10);
        r10.add(new AnonymousClass2(this));
        this.view.setOnItemLongClickListener(r11);
    }
}
