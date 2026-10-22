package com.jakewharton.rxbinding.widget;

import android.widget.RatingBar;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import com.jakewharton.rxbinding.internal.Preconditions;
import rx.Observable;
import rx.functions.Action1;

/* JADX INFO: loaded from: classes3.dex */
public final class RxRatingBar {
    private RxRatingBar() {
        throw new AssertionError("No instances.");
    }

    @NonNull
    @CheckResult
    public static Action1<? super Boolean> isIndicator(@NonNull final RatingBar r10) {
        Preconditions.checkNotNull(r10, "view == null");
        return new AnonymousClass2(r10);
    }

    @NonNull
    @CheckResult
    public static Action1<? super Float> rating(@NonNull final RatingBar r10) {
        Preconditions.checkNotNull(r10, "view == null");
        return new AnonymousClass1(r10);
    }

    @NonNull
    @CheckResult
    public static Observable ratingChangeEvents(@NonNull RatingBar r10) {
        Preconditions.checkNotNull(r10, "view == null");
        return Observable.b(new RatingBarRatingChangeEventOnSubscribe(r10));
    }

    @NonNull
    @CheckResult
    public static Observable ratingChanges(@NonNull RatingBar r10) {
        Preconditions.checkNotNull(r10, "view == null");
        return Observable.b(new RatingBarRatingChangeOnSubscribe(r10));
    }
}
