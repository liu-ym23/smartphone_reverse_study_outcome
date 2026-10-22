package com.jakewharton.rxbinding.widget;

import android.text.TextWatcher;
import android.widget.TextView;
import kg.a;
import rx.Observable;
import rx.Subscriber;

/* JADX INFO: loaded from: classes3.dex */
final class TextViewAfterTextChangeEventOnSubscribe implements Observable.OnSubscribe<TextViewAfterTextChangeEvent> {
    final TextView view;

    public TextViewAfterTextChangeEventOnSubscribe(TextView r10) {
        this.view = r10;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Subscriber r10) {
        call2(r10);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public void call2(final Subscriber r10) {
        a.verifyMainThread();
        final TextWatcher r11 = new AnonymousClass1(this, r10);
        r10.add(new AnonymousClass2(this, r11));
        this.view.addTextChangedListener(r11);
        TextView r12 = this.view;
        r10.onNext(TextViewAfterTextChangeEvent.create(r12, r12.getEditableText()));
    }
}
