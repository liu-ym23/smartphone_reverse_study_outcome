package com.jakewharton.rxbinding.widget;

import android.widget.TextSwitcher;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import com.jakewharton.rxbinding.internal.Preconditions;
import rx.functions.Action1;

/* JADX INFO: loaded from: classes3.dex */
public final class RxTextSwitcher {
    private RxTextSwitcher() {
        throw new AssertionError("No instances.");
    }

    @NonNull
    @CheckResult
    public static Action1<? super CharSequence> currentText(@NonNull final TextSwitcher r10) {
        Preconditions.checkNotNull(r10, "view == null");
        return new AnonymousClass2(r10);
    }

    @NonNull
    @CheckResult
    public static Action1<? super CharSequence> text(@NonNull final TextSwitcher r10) {
        Preconditions.checkNotNull(r10, "view == null");
        return new AnonymousClass1(r10);
    }
}
