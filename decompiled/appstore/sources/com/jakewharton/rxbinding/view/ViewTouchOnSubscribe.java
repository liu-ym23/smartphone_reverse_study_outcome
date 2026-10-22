package com.jakewharton.rxbinding.view;

import android.view.MotionEvent;
import android.view.View;
import kg.a;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

/* JADX INFO: loaded from: classes3.dex */
final class ViewTouchOnSubscribe implements Observable.OnSubscribe<MotionEvent> {
    final Func1<? super MotionEvent, Boolean> handled;
    final View view;

    public ViewTouchOnSubscribe(View r10, Func1<? super MotionEvent, Boolean> r11) {
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
        View.OnTouchListener r11 = new AnonymousClass1(this, r10);
        r10.add(new AnonymousClass2(this));
        this.view.setOnTouchListener(r11);
    }
}
