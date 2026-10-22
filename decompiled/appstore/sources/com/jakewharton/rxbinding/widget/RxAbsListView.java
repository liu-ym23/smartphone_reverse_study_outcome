package com.jakewharton.rxbinding.widget;

import android.widget.AbsListView;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import com.jakewharton.rxbinding.internal.Preconditions;
import rx.Observable;

/* JADX INFO: loaded from: classes3.dex */
public final class RxAbsListView {
    private RxAbsListView() {
        throw new AssertionError("No instances.");
    }

    @NonNull
    @CheckResult
    public static Observable scrollEvents(@NonNull AbsListView r10) {
        Preconditions.checkNotNull(r10, "absListView == null");
        return Observable.b(new AbsListViewScrollEventOnSubscribe(r10));
    }
}
