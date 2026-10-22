package com.bytedance.android.livesdk.interactivity.square.common;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.interactivity.api.publicscreenV2.base.AbsPublicScreenMessageViewHolder;
import com.bytedance.android.livesdk.interactivity.square.common.common.CommonSquarePublicScreenViewHolder;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/square/common/BaseMessageModelAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreenV2/base/AbsPublicScreenMessageViewHolder;", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class BaseMessageModelAdapter extends RecyclerView.Adapter<AbsPublicScreenMessageViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<? extends h52.c> f141109a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.livesdk.interactivity.api.publicscreen.l f141110b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f141111c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final k52.a f141112d;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f141109a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        return ((h52.c) ListProtector.get(this.f141109a, r100)).a().getType();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        AbsPublicScreenMessageViewHolder r102 = (AbsPublicScreenMessageViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        int r103 = r102.getItemViewType();
        com.bytedance.android.livesdk.interactivity.api.publicscreen.l r104 = this.f141110b;
        Intrinsics.checkNotNullParameter(r104, "$this$getViewBinder");
        h52.b<? extends h52.c> r105 = r104.getViewBinderPluginByItemType(r103);
        if (r105 == null) goto L6;
        r105.b(r102, (h52.c) ListProtector.get(this.f141109a, r101), r101);
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        com.bytedance.android.livesdk.interactivity.api.publicscreen.l r102 = this.f141110b;
        Intrinsics.checkNotNullParameter(r102, "$this$getViewBinder");
        h52.b<? extends h52.c> r103 = r102.getViewBinderPluginByItemType(r101);
        if (r103 == null) goto L6;
        CommonSquarePublicScreenViewHolder r104 = r103.a(LayoutInflater.from(this.f141111c), r100);
        if (r104 == null) goto L6;
        return r104;
    L6:
        View r105 = LayoutInflater.from(this.f141111c).inflate(R.layout.ttlive_item_public_screen_common_message_layout, r100, false);
        if (r105.getLayoutParams() != null) goto L10;
        r105.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
    L10:
        return new CommonSquarePublicScreenViewHolder(r105, this.f141112d);
    }

    public BaseMessageModelAdapter(com.bytedance.android.livesdk.interactivity.api.publicscreen.l r100, Context r101, k52.a r102) {
        Intrinsics.checkNotNullParameter(r100, "publicScreenContext");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "pipelineConfig");
        this.f141110b = r100;
        this.f141111c = r101;
        this.f141112d = r102;
        this.f141109a = new ArrayList();
    }
}
