package com.obric.oui.scrollbar;

import android.view.ViewTreeObserver;
import android.widget.ListView;

/* JADX INFO: compiled from: ListViewScrollBarHelper.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ListViewScrollBarHelper$adjustScrollBarVisibility$1 implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ float $maxScreens;
    final /* synthetic */ ListView $this_adjustScrollBarVisibility;

    ListViewScrollBarHelper$adjustScrollBarVisibility$1(ListView r1, float r2) {
        this.$this_adjustScrollBarVisibility = r1;
        this.$maxScreens = r2;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        a.a(a.f36130a, this.$this_adjustScrollBarVisibility, this.$maxScreens);
    }
}
