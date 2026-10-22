package com.jakewharton.rxbinding.widget;

import android.widget.CompoundButton;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import com.jakewharton.rxbinding.internal.Preconditions;
import rx.Observable;
import rx.functions.Action1;

/* JADX INFO: loaded from: classes3.dex */
public final class RxCompoundButton {
    private RxCompoundButton() {
        throw new AssertionError("No instances.");
    }

    @NonNull
    @CheckResult
    public static Action1<? super Boolean> checked(@NonNull final CompoundButton r10) {
        Preconditions.checkNotNull(r10, "view == null");
        return new AnonymousClass1(r10);
    }

    @NonNull
    @CheckResult
    public static Observable checkedChanges(@NonNull CompoundButton r10) {
        Preconditions.checkNotNull(r10, "view == null");
        return Observable.b(new CompoundButtonCheckedChangeOnSubscribe(r10));
    }

    @NonNull
    @CheckResult
    public static Action1<? super Object> toggle(@NonNull final CompoundButton r10) {
        Preconditions.checkNotNull(r10, "view == null");
        return new AnonymousClass2(r10);
    }
}
