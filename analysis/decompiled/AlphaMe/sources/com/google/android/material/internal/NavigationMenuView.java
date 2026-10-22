package com.google.android.material.internal;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.RestrictTo;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import e.EnumC0546d;
import k.C0661o;
import k.InterfaceC0642C;

@RestrictTo({EnumC0546d.f12493b})
/* loaded from: classes.dex */
public class NavigationMenuView extends RecyclerView implements InterfaceC0642C {
    public NavigationMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // k.InterfaceC0642C
    public final void f(C0661o c0661o) {
    }

    public int getWindowAnimations() {
        return 0;
    }

    public NavigationMenuView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, 0);
        setLayoutManager(new LinearLayoutManager(context, 1, false));
    }
}
