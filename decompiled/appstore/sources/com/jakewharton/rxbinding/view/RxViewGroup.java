package com.jakewharton.rxbinding.view;

import android.view.ViewGroup;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import com.jakewharton.rxbinding.internal.Preconditions;
import rx.Observable;

/* JADX INFO: loaded from: classes3.dex */
public final class RxViewGroup {
    private RxViewGroup() {
        throw new AssertionError("No instances.");
    }

    @NonNull
    @CheckResult
    public static Observable changeEvents(@NonNull ViewGroup r10) {
        Preconditions.checkNotNull(r10, "viewGroup == null");
        return Observable.b(new ViewGroupHierarchyChangeEventOnSubscribe(r10));
    }
}
