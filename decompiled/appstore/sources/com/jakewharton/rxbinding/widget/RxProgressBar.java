package com.jakewharton.rxbinding.widget;

import android.widget.ProgressBar;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import com.jakewharton.rxbinding.internal.Preconditions;
import rx.functions.Action1;

/* JADX INFO: loaded from: classes3.dex */
public final class RxProgressBar {
    private RxProgressBar() {
        throw new AssertionError("No instances.");
    }

    @NonNull
    @CheckResult
    public static Action1<? super Integer> incrementProgressBy(@NonNull final ProgressBar r10) {
        Preconditions.checkNotNull(r10, "view == null");
        return new AnonymousClass1(r10);
    }

    @NonNull
    @CheckResult
    public static Action1<? super Integer> incrementSecondaryProgressBy(@NonNull final ProgressBar r10) {
        Preconditions.checkNotNull(r10, "view == null");
        return new AnonymousClass2(r10);
    }

    @NonNull
    @CheckResult
    public static Action1<? super Boolean> indeterminate(@NonNull final ProgressBar r10) {
        Preconditions.checkNotNull(r10, "view == null");
        return new AnonymousClass3(r10);
    }

    @NonNull
    @CheckResult
    public static Action1<? super Integer> max(@NonNull final ProgressBar r10) {
        Preconditions.checkNotNull(r10, "view == null");
        return new AnonymousClass4(r10);
    }

    @NonNull
    @CheckResult
    public static Action1<? super Integer> progress(@NonNull final ProgressBar r10) {
        Preconditions.checkNotNull(r10, "view == null");
        return new AnonymousClass5(r10);
    }

    @NonNull
    @CheckResult
    public static Action1<? super Integer> secondaryProgress(@NonNull final ProgressBar r10) {
        Preconditions.checkNotNull(r10, "view == null");
        return new AnonymousClass6(r10);
    }
}
