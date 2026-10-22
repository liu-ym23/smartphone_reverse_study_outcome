package com.jakewharton.rxbinding.view;

import android.view.View;
import kg.a;
import rx.Observable;
import rx.Subscriber;

/* JADX INFO: loaded from: classes3.dex */
final class ViewAttachesOnSubscribe implements Observable.OnSubscribe<Void> {
    final boolean callOnAttach;
    final View view;

    public ViewAttachesOnSubscribe(View r10, boolean r11) {
        this.view = r10;
        this.callOnAttach = r11;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Subscriber r10) {
        call2(r10);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public void call2(final Subscriber r10) {
        a.verifyMainThread();
        final View.OnAttachStateChangeListener r11 = new AnonymousClass1(this, r10);
        r10.add(new AnonymousClass2(this, r11));
        this.view.addOnAttachStateChangeListener(r11);
    }
}
