package com.obric.appstore.buss.search;

import androidx.fragment.app.Fragment;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes3.dex */
public final class i extends j0.a {
    public i(Fragment r10) {
        q.g(r10, "fragment");
        super(r10);
    }

    @Override // j0.a
    public Fragment c(int r10) {
        if (r10 != 1) goto L6;
        return new SearchAppFragment();
    L6:
        return new SearchSuggestFragment();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return 2;
    }
}
