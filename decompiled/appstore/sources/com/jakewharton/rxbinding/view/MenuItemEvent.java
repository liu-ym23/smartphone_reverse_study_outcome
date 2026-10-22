package com.jakewharton.rxbinding.view;

import android.view.MenuItem;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public abstract class MenuItemEvent<T extends MenuItem> {
    private final T menuItem;

    public MenuItemEvent(@NonNull T r10) {
        this.menuItem = r10;
    }

    @NonNull
    public T menuItem() {
        return this.menuItem;
    }
}
