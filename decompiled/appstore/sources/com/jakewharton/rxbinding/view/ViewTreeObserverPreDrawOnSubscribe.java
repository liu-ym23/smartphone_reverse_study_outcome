package com.jakewharton.rxbinding.view;

import android.view.View;
import android.view.ViewTreeObserver;
import kg.a;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Func0;

/* JADX INFO: loaded from: classes3.dex */
final class ViewTreeObserverPreDrawOnSubscribe implements Observable.OnSubscribe<Void> {
    final Func0<Boolean> proceedDrawingPass;
    final View view;

    public ViewTreeObserverPreDrawOnSubscribe(View r10, Func0<Boolean> r11) {
        this.view = r10;
        this.proceedDrawingPass = r11;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Subscriber r10) {
        call2(r10);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public void call2(final Subscriber r10) {
        a.verifyMainThread();
        final ViewTreeObserver.OnPreDrawListener r11 = new AnonymousClass1(this, r10);
        r10.add(new AnonymousClass2(this, r11));
        this.view.getViewTreeObserver().addOnPreDrawListener(r11);
    }
}
