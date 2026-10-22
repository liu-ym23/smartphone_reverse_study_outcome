package com.bytedance.android.shopping.commentfeed.view;

import bc3.d;
import com.bytedance.android.shopping.commentfeed.widget.RecyclerViewPageChangeListener;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes13.dex */
public final class c implements RecyclerViewPageChangeListener.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CommentItemFragment f172381a;

    @Override // com.bytedance.android.shopping.commentfeed.widget.RecyclerViewPageChangeListener.a
    public final void c() {
    }

    public c(CommentItemFragment r100) {
        this.f172381a = r100;
    }

    @Override // com.bytedance.android.shopping.commentfeed.widget.RecyclerViewPageChangeListener.a
    public final void a(int r100) {
        Iterator r101 = ((ArrayList) this.f172381a.f172367m).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((d) r101.next()).onItemSelected(r100);
        goto L4
    }

    @Override // com.bytedance.android.shopping.commentfeed.widget.RecyclerViewPageChangeListener.a
    public final void onPageSelected(int r100) {
        Iterator r101 = ((ArrayList) this.f172381a.f172367m).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((d) r101.next()).onItemSelected(r100);
        goto L4
    L6:
        this.f172381a.f172374t.add(Integer.valueOf(r100));
    }
}
