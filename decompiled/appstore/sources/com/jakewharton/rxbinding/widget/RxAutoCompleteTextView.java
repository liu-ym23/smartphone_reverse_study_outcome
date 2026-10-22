package com.jakewharton.rxbinding.widget;

import android.widget.AutoCompleteTextView;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import com.jakewharton.rxbinding.internal.Preconditions;
import rx.Observable;
import rx.functions.Action1;

/* JADX INFO: loaded from: classes3.dex */
public final class RxAutoCompleteTextView {
    private RxAutoCompleteTextView() {
        throw new AssertionError("No instances.");
    }

    @NonNull
    @CheckResult
    public static Action1<? super CharSequence> completionHint(@NonNull final AutoCompleteTextView r10) {
        Preconditions.checkNotNull(r10, "view == null");
        return new AnonymousClass1(r10);
    }

    @NonNull
    @CheckResult
    public static Observable itemClickEvents(@NonNull AutoCompleteTextView r10) {
        Preconditions.checkNotNull(r10, "view == null");
        return Observable.b(new AutoCompleteTextViewItemClickEventOnSubscribe(r10));
    }

    @NonNull
    @CheckResult
    public static Action1<? super Integer> threshold(@NonNull final AutoCompleteTextView r10) {
        Preconditions.checkNotNull(r10, "view == null");
        return new AnonymousClass2(r10);
    }
}
