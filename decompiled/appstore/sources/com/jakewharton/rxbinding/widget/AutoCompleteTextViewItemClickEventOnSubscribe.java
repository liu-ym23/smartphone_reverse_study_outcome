package com.jakewharton.rxbinding.widget;

import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import kg.a;
import rx.Observable;
import rx.Subscriber;

/* JADX INFO: loaded from: classes3.dex */
final class AutoCompleteTextViewItemClickEventOnSubscribe implements Observable.OnSubscribe<AdapterViewItemClickEvent> {
    final AutoCompleteTextView view;

    public AutoCompleteTextViewItemClickEventOnSubscribe(AutoCompleteTextView r10) {
        this.view = r10;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Subscriber r10) {
        call2(r10);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public void call2(final Subscriber r10) {
        a.verifyMainThread();
        AdapterView.OnItemClickListener r11 = new AnonymousClass1(this, r10);
        r10.add(new AnonymousClass2(this));
        this.view.setOnItemClickListener(r11);
    }
}
