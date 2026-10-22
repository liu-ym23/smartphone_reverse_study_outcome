package com.google.android.material.internal;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class NavigationMenuView extends RecyclerView implements MenuView {
    public NavigationMenuView(Context r10) {
        this(r10, null);
    }

    @Override // androidx.appcompat.view.menu.MenuView
    public int getWindowAnimations() {
        return 0;
    }

    @Override // androidx.appcompat.view.menu.MenuView
    public void initialize(MenuBuilder r10) {
    }

    public NavigationMenuView(Context r10, AttributeSet r11) {
        this(r10, r11, 0);
    }

    public NavigationMenuView(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        setLayoutManager(new LinearLayoutManager(r10, 1, false));
    }
}
