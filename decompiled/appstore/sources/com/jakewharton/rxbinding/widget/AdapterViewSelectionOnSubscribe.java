package com.jakewharton.rxbinding.widget;

import android.view.View;
import android.widget.AdapterView;
import kg.a;
import rx.Observable;
import rx.Subscriber;

/* JADX INFO: loaded from: classes3.dex */
final class AdapterViewSelectionOnSubscribe implements Observable.OnSubscribe<AdapterViewSelectionEvent> {
    final AdapterView<?> view;

    public AdapterViewSelectionOnSubscribe(AdapterView<?> r10) {
        this.view = r10;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Subscriber r10) {
        call2(r10);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public void call2(final Subscriber r10) {
        a.verifyMainThread();
        AdapterView.OnItemSelectedListener r11 = new AnonymousClass1(this, r10);
        r10.add(new AnonymousClass2(this));
        this.view.setOnItemSelectedListener(r11);
        int r12 = this.view.getSelectedItemPosition();
        if (r12 != (-1)) goto L5;
        r10.onNext(AdapterViewNothingSelectionEvent.create(this.view));
        return;
    L5:
        View r13 = this.view.getSelectedView();
        long r14 = this.view.getSelectedItemId();
        r10.onNext(AdapterViewItemSelectionEvent.create(this.view, r13, r12, r14));
    }
}
