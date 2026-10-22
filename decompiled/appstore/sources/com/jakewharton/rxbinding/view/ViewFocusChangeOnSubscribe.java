package com.jakewharton.rxbinding.view;

import android.view.View;
import kg.a;
import rx.Observable;
import rx.Subscriber;

/* JADX INFO: loaded from: classes3.dex */
final class ViewFocusChangeOnSubscribe implements Observable.OnSubscribe<Boolean> {
    final View view;

    public ViewFocusChangeOnSubscribe(View r10) {
        this.view = r10;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Subscriber r10) {
        call2(r10);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public void call2(final Subscriber r10) {
        a.verifyMainThread();
        View.OnFocusChangeListener r11 = new AnonymousClass1(this, r10);
        r10.add(new AnonymousClass2(this));
        this.view.setOnFocusChangeListener(r11);
        r10.onNext(Boolean.valueOf(this.view.hasFocus()));
    }
}
