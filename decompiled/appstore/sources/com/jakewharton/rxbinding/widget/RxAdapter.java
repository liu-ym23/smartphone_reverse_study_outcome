package com.jakewharton.rxbinding.widget;

import android.widget.Adapter;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import com.jakewharton.rxbinding.internal.Preconditions;
import rx.Observable;

/* JADX INFO: loaded from: classes3.dex */
public final class RxAdapter {
    private RxAdapter() {
        throw new AssertionError("No instances.");
    }

    @NonNull
    @CheckResult
    public static <T extends Adapter> Observable dataChanges(@NonNull T r10) {
        Preconditions.checkNotNull(r10, "adapter == null");
        return Observable.b(new AdapterDataChangeOnSubscribe(r10));
    }
}
