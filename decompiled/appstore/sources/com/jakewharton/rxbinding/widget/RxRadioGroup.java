package com.jakewharton.rxbinding.widget;

import android.widget.RadioGroup;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import com.jakewharton.rxbinding.internal.Preconditions;
import rx.Observable;
import rx.functions.Action1;

/* JADX INFO: loaded from: classes3.dex */
public final class RxRadioGroup {
    private RxRadioGroup() {
        throw new AssertionError("No instances.");
    }

    @NonNull
    @CheckResult
    public static Action1<? super Integer> checked(@NonNull final RadioGroup r10) {
        Preconditions.checkNotNull(r10, "view == null");
        return new AnonymousClass1(r10);
    }

    @NonNull
    @CheckResult
    public static Observable checkedChanges(@NonNull RadioGroup r10) {
        Preconditions.checkNotNull(r10, "view == null");
        return Observable.b(new RadioGroupCheckedChangeOnSubscribe(r10)).c();
    }
}
