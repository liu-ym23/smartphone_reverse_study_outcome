package com.google.android.material.internal;

import android.content.Context;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.m;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class NavigationSubMenu extends m {
    public NavigationSubMenu(Context r10, NavigationMenu r11, g r12) {
        super(r10, r11, r12);
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    public void onItemsChanged(boolean r10) {
        super.onItemsChanged(r10);
        ((MenuBuilder) getParentMenu()).onItemsChanged(r10);
    }
}
