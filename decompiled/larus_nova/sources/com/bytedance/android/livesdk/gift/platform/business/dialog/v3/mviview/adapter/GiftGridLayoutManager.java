package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.adapter;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.chatroom.ui.SSGridLayoutManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/mviview/adapter/GiftGridLayoutManager;", "Lcom/bytedance/android/livesdk/chatroom/ui/SSGridLayoutManager;", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GiftGridLayoutManager extends SSGridLayoutManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function4<Integer, RecyclerView.Recycler, RecyclerView.State, Boolean, Unit> f127766a;

    public GiftGridLayoutManager(Context r100, Function4 r101) {
        Intrinsics.checkNotNullParameter(r101, "scrollVerticalCallback");
        super(r100, 4, 1);
        this.f127766a = r101;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.SSGridLayoutManager, androidx.recyclerview.widget.GridLayoutManager, androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onLayoutChildren(RecyclerView.Recycler r100, RecyclerView.State r101) {
        long r102 = System.currentTimeMillis();
        super.onLayoutChildren(r100, r101);
        if (com.bytedance.android.live.core.utils.v.a() == true) goto L5;
        return;
    L5:
        if ((System.currentTimeMillis() - r102) <= 10) goto L9;
        jy0.b.a("ttlive_gift_panel_metrics", "grid onLayoutChildren cost " + (System.currentTimeMillis() - r102) + "ms");
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.SSGridLayoutManager, androidx.recyclerview.widget.GridLayoutManager, androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int scrollVerticallyBy(int r100, RecyclerView.Recycler r101, RecyclerView.State r102) {
        long r103 = System.currentTimeMillis();
        int r104 = super.scrollVerticallyBy(r100, r101, r102);
        jy0.b.a("yz-debug-SSGridLayoutManager", "dy " + r100 + ", scroll " + r104);
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L7;
        long r105 = System.currentTimeMillis() - r103;
        if (r105 <= 6) goto L7;
        jy0.b.a("ttlive_gift_panel_metrics", "grid scrollVerticallyBy cost " + r105 + "ms");
    L7:
        Function4<Integer, RecyclerView.Recycler, RecyclerView.State, Boolean, Unit> r106 = this.f127766a;
        Integer r107 = Integer.valueOf(r100);
        if (r100 != r104) goto L10;
        boolean r108 = true;
    L11:
        r106.invoke(r107, r101, r102, Boolean.valueOf(r108));
        return r104;
    L10:
        r108 = false;
        goto L11
    }
}
