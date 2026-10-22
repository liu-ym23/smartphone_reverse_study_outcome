package com.jakewharton.rxbinding.widget;

import android.widget.CheckedTextView;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import com.jakewharton.rxbinding.internal.Preconditions;
import rx.functions.Action1;

/* JADX INFO: loaded from: classes3.dex */
public final class RxCheckedTextView {
    private RxCheckedTextView() {
        throw new AssertionError("No instances.");
    }

    @NonNull
    @CheckResult
    public static Action1<? super Boolean> check(@NonNull final CheckedTextView r10) {
        Preconditions.checkNotNull(r10, "view == null");
        return new AnonymousClass1(r10);
    }
}
