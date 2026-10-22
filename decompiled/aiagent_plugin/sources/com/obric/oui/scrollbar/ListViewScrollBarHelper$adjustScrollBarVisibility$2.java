package com.obric.oui.scrollbar;

import android.widget.AbsListView;
import android.widget.ListView;

/* JADX INFO: compiled from: ListViewScrollBarHelper.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ListViewScrollBarHelper$adjustScrollBarVisibility$2 implements AbsListView.OnScrollListener {
    final /* synthetic */ float $maxScreens;
    final /* synthetic */ ListView $this_adjustScrollBarVisibility;

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView r1, int r2, int r3, int r4) {
    }

    ListViewScrollBarHelper$adjustScrollBarVisibility$2(ListView r1, float r2) {
        this.$this_adjustScrollBarVisibility = r1;
        this.$maxScreens = r2;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView r1, int r2) {
        a.a(a.f36130a, this.$this_adjustScrollBarVisibility, this.$maxScreens);
    }
}
