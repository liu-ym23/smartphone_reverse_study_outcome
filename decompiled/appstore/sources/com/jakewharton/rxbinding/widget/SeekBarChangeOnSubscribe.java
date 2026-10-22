package com.jakewharton.rxbinding.widget;

import android.widget.SeekBar;
import androidx.annotation.Nullable;
import kg.a;
import rx.Observable;
import rx.Subscriber;

/* JADX INFO: loaded from: classes3.dex */
final class SeekBarChangeOnSubscribe implements Observable.OnSubscribe<Integer> {

    @Nullable
    final Boolean shouldBeFromUser;
    final SeekBar view;

    public SeekBarChangeOnSubscribe(SeekBar r10, @Nullable Boolean r11) {
        this.view = r10;
        this.shouldBeFromUser = r11;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Subscriber r10) {
        call2(r10);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public void call2(final Subscriber r10) {
        a.verifyMainThread();
        SeekBar.OnSeekBarChangeListener r11 = new AnonymousClass1(this, r10);
        r10.add(new AnonymousClass2(this));
        this.view.setOnSeekBarChangeListener(r11);
        r10.onNext(Integer.valueOf(this.view.getProgress()));
    }
}
