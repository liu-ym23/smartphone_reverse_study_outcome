package com.bytedance.android.live.vip.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.profit.vip.model.e;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import py.k;
import rc1.a;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/vip/adapter/EmojiBubbleAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/live/vip/adapter/EmojiBubbleAdapter$EmojiBubbleViewHolder;", "EmojiBubbleViewHolder", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class EmojiBubbleAdapter extends RecyclerView.Adapter<EmojiBubbleViewHolder> {

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/vip/adapter/EmojiBubbleAdapter$EmojiBubbleViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class EmojiBubbleViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f102587a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final HSImageView f102588b;

        public EmojiBubbleViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            this.f102587a = r100.findViewById(R.id.border);
            this.f102588b = (HSImageView) r100.findViewById(R.id.bubble);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        throw null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        EmojiBubbleViewHolder r102 = (EmojiBubbleViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        int r103 = 0;
        r102.setIsRecyclable(false);
        e r104 = (e) ListProtector.get(null, r101);
        Intrinsics.checkNotNullParameter(r104, "bubble");
        HSImageView r105 = r102.f102588b;
        k r106 = r104.getImg();
        Intrinsics.checkNotNullParameter(r105, "$this$bindImage");
        ImageLoader.bindImage(r105, r106);
        if (r101 != 0) goto L5;
        boolean r107 = true;
    L6:
        View r108 = r102.f102587a;
        if (r107 == true) goto L10;
        r103 = 8;
    L10:
        r108.setVisibility(r103);
        r102.itemView.setOnClickListener(new a(this, r101));
        return;
    L5:
        r107 = false;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return new EmojiBubbleViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.ttlive_vip_emoji_template_bubble_viewholder, r100, false));
    }
}
