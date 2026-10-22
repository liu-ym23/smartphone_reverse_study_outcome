package com.jakewharton.rxbinding.widget;

import android.widget.RatingBar;
import kg.a;
import rx.Observable;
import rx.Subscriber;

/* JADX INFO: loaded from: classes3.dex */
final class RatingBarRatingChangeOnSubscribe implements Observable.OnSubscribe<Float> {
    final RatingBar view;

    public RatingBarRatingChangeOnSubscribe(RatingBar r10) {
        this.view = r10;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Subscriber r10) {
        call2(r10);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public void call2(final Subscriber r10) {
        a.verifyMainThread();
        RatingBar.OnRatingBarChangeListener r11 = new AnonymousClass1(this, r10);
        r10.add(new AnonymousClass2(this));
        this.view.setOnRatingBarChangeListener(r11);
        r10.onNext(Float.valueOf(this.view.getRating()));
    }
}
