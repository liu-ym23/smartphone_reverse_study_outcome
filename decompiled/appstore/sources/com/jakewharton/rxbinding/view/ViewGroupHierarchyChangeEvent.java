package com.jakewharton.rxbinding.view;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ViewGroupHierarchyChangeEvent extends ViewEvent<ViewGroup> {
    private final View child;

    public ViewGroupHierarchyChangeEvent(@NonNull ViewGroup r10, View r11) {
        super(r10);
        this.child = r11;
    }

    @NonNull
    public final View child() {
        return this.child;
    }
}
