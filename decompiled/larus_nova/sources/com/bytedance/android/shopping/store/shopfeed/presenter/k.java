package com.bytedance.android.shopping.store.shopfeed.presenter;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.store.shopfeed.list.AbsShopFeedListAdapter;
import com.bytedance.android.shopping.store.shopfeed.list.ShopFeedLayoutManager;
import com.bytedance.android.shopping.store.shopfeed.list.ShopFeedListSnapHelper;
import com.bytedance.common.utility.Logger;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f186313a = 0;

    static {
    }

    public static void a(final RecyclerView r100, Context r101, String r102, RecyclerView.OnScrollListener r103, AbsShopFeedListAdapter r104, ShopFeedListSnapHelper r105, RecyclerView.ItemDecoration r106) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "tag");
        Intrinsics.checkNotNullParameter(r103, "onScrollListener");
        Intrinsics.checkNotNullParameter(r104, "adapter");
        Intrinsics.checkNotNullParameter(r105, "snapHelper");
        r100.setLayoutManager(new ShopFeedLayoutManager(r101));
        r100.setItemAnimator(null);
        if (r106 == null) goto L5;
        r100.addItemDecoration(r106);
    L5:
        r100.addOnScrollListener(r103);
        r104.registerAdapterDataObserver(new ShopFeedRecyclerViewInitHelper$$special$$inlined$also$lambda$1(r100));
        Unit r107 = Unit.INSTANCE;
        r100.setAdapter(r104);
        r105.attachToRecyclerView(r100);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        Logger.e(r102, "initRecyclerView", e);
        dm.a.b r108 = dm.a.f469202a;
        dm.a.a(r102).b("initRecyclerView attachToRecyclerView error", e);
    }
}
