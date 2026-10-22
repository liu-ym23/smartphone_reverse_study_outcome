package com.bytedance.android.shopping.store.router.hybridpage.view;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.hybrid.list.ability.l0;
import com.bytedance.android.ec.hybrid.list.holder.ECLoadMoreViewHolder;
import com.bytedance.android.shopping.store.hybridproduct.holder.ECShopHybridProductLoadMoreViewHolder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class g extends l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Fragment f185973a;

    public g(Fragment r100) {
        this.f185973a = r100;
    }

    @Override // com.bytedance.android.ec.hybrid.list.ability.l0
    public final ECLoadMoreViewHolder a(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        int r101 = ECShopHybridProductLoadMoreViewHolder.f185051q;
        return ECShopHybridProductLoadMoreViewHolder.a.a(r100, this.f185973a);
    }
}
