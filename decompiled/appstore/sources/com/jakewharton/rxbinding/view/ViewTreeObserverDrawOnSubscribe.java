package com.jakewharton.rxbinding.view;

import android.annotation.TargetApi;
import android.view.View;
import android.view.ViewTreeObserver;
import kg.a;
import rx.Observable;
import rx.Subscriber;

/* JADX INFO: loaded from: classes3.dex */
@TargetApi(16)
final class ViewTreeObserverDrawOnSubscribe implements Observable.OnSubscribe<Void> {
    final View view;

    public ViewTreeObserverDrawOnSubscribe(View r10) {
        this.view = r10;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Subscriber r10) {
        call2(r10);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public void call2(final Subscriber r10) {
        a.verifyMainThread();
        final ViewTreeObserver.OnDrawListener r11 = new AnonymousClass1(this, r10);
        r10.add(new AnonymousClass2(this, r11));
        this.view.getViewTreeObserver().addOnDrawListener(r11);
    }
}
