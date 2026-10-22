package com.bytedance.android.shopping.inflow.view;

import com.bytedance.android.shopping.feed.widget.searchsimilar.SearchSimilarView;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes13.dex */
public final class d implements SearchSimilarView.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f176374a;

    @Override // com.bytedance.android.shopping.feed.widget.searchsimilar.SearchSimilarView.a
    public final void onClick() {
        ce3.b r100 = (ce3.b) this.f176374a.element;
        if (r100 == null) goto L6;
        r100.qa();
        return;
    }

    public d(Ref.ObjectRef r100) {
        this.f176374a = r100;
    }
}
