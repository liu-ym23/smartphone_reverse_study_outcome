package com.jakewharton.rxbinding.view;

import android.view.KeyEvent;
import android.view.View;
import kg.a;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

/* JADX INFO: loaded from: classes3.dex */
final class ViewKeyOnSubscribe implements Observable.OnSubscribe<KeyEvent> {
    private final Func1<? super KeyEvent, Boolean> handled;
    private final View view;

    public ViewKeyOnSubscribe(View r10, Func1<? super KeyEvent, Boolean> r11) {
        this.view = r10;
        this.handled = r11;
    }

    public static /* synthetic */ Func1 access$000(ViewKeyOnSubscribe r10) {
        return r10.handled;
    }

    public static /* synthetic */ View access$100(ViewKeyOnSubscribe r10) {
        return r10.view;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Subscriber r10) {
        call2(r10);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public void call2(final Subscriber r10) {
        a.verifyMainThread();
        View.OnKeyListener r11 = new AnonymousClass1(this, r10);
        r10.add(new AnonymousClass2(this));
        this.view.setOnKeyListener(r11);
    }
}
