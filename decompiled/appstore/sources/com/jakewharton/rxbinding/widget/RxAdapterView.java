package com.jakewharton.rxbinding.widget;

import android.widget.Adapter;
import android.widget.AdapterView;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import com.jakewharton.rxbinding.internal.Functions;
import com.jakewharton.rxbinding.internal.Preconditions;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func0;
import rx.functions.Func1;

/* JADX INFO: loaded from: classes3.dex */
public final class RxAdapterView {
    private RxAdapterView() {
        throw new AssertionError("No instances.");
    }

    @NonNull
    @CheckResult
    public static <T extends Adapter> Observable itemClickEvents(@NonNull AdapterView<T> r10) {
        Preconditions.checkNotNull(r10, "view == null");
        return Observable.b(new AdapterViewItemClickEventOnSubscribe(r10));
    }

    @NonNull
    @CheckResult
    public static <T extends Adapter> Observable itemClicks(@NonNull AdapterView<T> r10) {
        Preconditions.checkNotNull(r10, "view == null");
        return Observable.b(new AdapterViewItemClickOnSubscribe(r10));
    }

    @NonNull
    @CheckResult
    public static <T extends Adapter> Observable itemLongClickEvents(@NonNull AdapterView<T> r10) {
        Preconditions.checkNotNull(r10, "view == null");
        return itemLongClickEvents(r10, Functions.FUNC1_ALWAYS_TRUE);
    }

    @NonNull
    @CheckResult
    public static <T extends Adapter> Observable itemLongClicks(@NonNull AdapterView<T> r10) {
        Preconditions.checkNotNull(r10, "view == null");
        return itemLongClicks(r10, Functions.FUNC0_ALWAYS_TRUE);
    }

    @NonNull
    @CheckResult
    public static <T extends Adapter> Observable itemSelections(@NonNull AdapterView<T> r10) {
        Preconditions.checkNotNull(r10, "view == null");
        return Observable.b(new AdapterViewItemSelectionOnSubscribe(r10));
    }

    @NonNull
    @CheckResult
    public static <T extends Adapter> Action1<? super Integer> selection(@NonNull final AdapterView<T> r10) {
        Preconditions.checkNotNull(r10, "view == null");
        return new AnonymousClass1(r10);
    }

    @NonNull
    @CheckResult
    public static <T extends Adapter> Observable selectionEvents(@NonNull AdapterView<T> r10) {
        Preconditions.checkNotNull(r10, "view == null");
        return Observable.b(new AdapterViewSelectionOnSubscribe(r10));
    }

    @NonNull
    @CheckResult
    public static <T extends Adapter> Observable itemLongClickEvents(@NonNull AdapterView<T> r10, @NonNull Func1<? super AdapterViewItemLongClickEvent, Boolean> r11) {
        Preconditions.checkNotNull(r10, "view == null");
        Preconditions.checkNotNull(r11, "handled == null");
        return Observable.b(new AdapterViewItemLongClickEventOnSubscribe(r10, r11));
    }

    @NonNull
    @CheckResult
    public static <T extends Adapter> Observable itemLongClicks(@NonNull AdapterView<T> r10, @NonNull Func0<Boolean> r11) {
        Preconditions.checkNotNull(r10, "view == null");
        Preconditions.checkNotNull(r11, "handled == null");
        return Observable.b(new AdapterViewItemLongClickOnSubscribe(r10, r11));
    }
}
