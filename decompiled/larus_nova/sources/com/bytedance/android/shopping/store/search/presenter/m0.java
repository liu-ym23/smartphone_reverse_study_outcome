package com.bytedance.android.shopping.store.search.presenter;

import com.bytedance.android.ec.store.search.recyclerview.searchsug.adapter.SearchSugListAdapter;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class m0<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ StoreSearchSugListPresenter f186100a;

    public m0(StoreSearchSugListPresenter r100) {
        this.f186100a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        uj3.g r101 = (uj3.g) r100;
        SearchSugListAdapter r102 = this.f186100a.f186065g;
        if (r102 == null) goto L6;
        Intrinsics.checkNotNullParameter(r101, "data");
        ((ArrayList) r102.f48557a).clear();
        List<uj3.f> r103 = r102.f48557a;
        ArrayList r104 = (ArrayList) r103;
        r104.addAll(r101.f550286a);
        r102.notifyDataSetChanged();
        return;
    }
}
