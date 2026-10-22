package com.obric.appstore.buss.rank;

import androidx.fragment.app.Fragment;
import com.obric.appstore.R;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends j0.a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Integer[] f10799i;

    public d(Fragment r10, Integer[] r11) {
        q.g(r10, "fragment");
        q.g(r11, "titles");
        super(r10);
        this.f10799i = r11;
    }

    @Override // j0.a
    public Fragment c(int r10) {
        if (this.f10799i[r10].intValue() != R.string.title_rank_game) goto L6;
        return new b();
    L6:
        return new a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f10799i.length;
    }
}
