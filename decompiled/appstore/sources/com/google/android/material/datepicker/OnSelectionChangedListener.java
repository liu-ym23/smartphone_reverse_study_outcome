package com.google.android.material.datepicker;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public abstract class OnSelectionChangedListener<S> {
    public OnSelectionChangedListener() {
    }

    public void onIncompleteSelectionChanged() {
    }

    public abstract void onSelectionChanged(@NonNull S r10);
}
