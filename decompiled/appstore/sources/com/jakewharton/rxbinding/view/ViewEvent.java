package com.jakewharton.rxbinding.view;

import android.view.View;
import androidx.annotation.NonNull;
import com.jakewharton.rxbinding.internal.Preconditions;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ViewEvent<T extends View> {
    private final T view;

    public ViewEvent(@NonNull T r10) {
        this.view = (T) Preconditions.checkNotNull(r10, "view == null");
    }

    @NonNull
    public T view() {
        return this.view;
    }
}
