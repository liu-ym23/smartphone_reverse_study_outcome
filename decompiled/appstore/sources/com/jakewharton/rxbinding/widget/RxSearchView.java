package com.jakewharton.rxbinding.widget;

import android.widget.SearchView;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import com.jakewharton.rxbinding.internal.Preconditions;
import rx.Observable;
import rx.functions.Action1;

/* JADX INFO: loaded from: classes3.dex */
public final class RxSearchView {
    private RxSearchView() {
        throw new AssertionError("No instances.");
    }

    @NonNull
    @CheckResult
    public static Action1<? super CharSequence> query(@NonNull final SearchView r10, final boolean r11) {
        Preconditions.checkNotNull(r10, "view == null");
        return new AnonymousClass1(r10, r11);
    }

    @NonNull
    @CheckResult
    public static Observable queryTextChangeEvents(@NonNull SearchView r10) {
        Preconditions.checkNotNull(r10, "view == null");
        return Observable.b(new SearchViewQueryTextChangeEventsOnSubscribe(r10));
    }

    @NonNull
    @CheckResult
    public static Observable queryTextChanges(@NonNull SearchView r10) {
        Preconditions.checkNotNull(r10, "view == null");
        return Observable.b(new SearchViewQueryTextChangesOnSubscribe(r10));
    }
}
