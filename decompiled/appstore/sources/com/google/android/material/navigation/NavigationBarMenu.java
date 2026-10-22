package com.google.android.material.navigation;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.g;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class NavigationBarMenu extends MenuBuilder {
    private final int maxItemCount;

    @NonNull
    private final Class<?> viewClass;

    public NavigationBarMenu(@NonNull Context r10, @NonNull Class<?> r11, int r12) {
        super(r10);
        this.viewClass = r11;
        this.maxItemCount = r12;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    @NonNull
    public MenuItem addInternal(int r10, int r11, int r12, @NonNull CharSequence r13) {
        if ((size() + 1) > this.maxItemCount) goto L9;
        stopDispatchingItemsChanged();
        MenuItem r14 = super.addInternal(r10, r11, r12, r13);
        if ((r14 instanceof g) == false) goto L7;
        ((g) r14).q(true);
    L7:
        startDispatchingItemsChanged();
        return r14;
    L9:
        String r15 = this.viewClass.getSimpleName();
        throw new IllegalArgumentException("Maximum number of items supported by " + r15 + " is " + this.maxItemCount + ". Limit can be checked with " + r15 + "#getMaxItemCount()");
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder, android.view.Menu
    @NonNull
    public SubMenu addSubMenu(int r10, int r11, int r12, @NonNull CharSequence r13) {
        throw new UnsupportedOperationException(this.viewClass.getSimpleName() + " does not support submenus");
    }

    public int getMaxItemCount() {
        return this.maxItemCount;
    }
}
