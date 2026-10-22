package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.imagepreview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.widget.HSImageView;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/topcontainer/likeegg/imagepreview/PreviewItemAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/livesdk/interactivity/publicscreen/topcontainer/likeegg/imagepreview/PreviewItemAdapter$PreviewItemViewHolder;", "<init>", "()V", "PreviewItemViewHolder", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PreviewItemAdapter extends RecyclerView.Adapter<PreviewItemViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<k> f139968a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function2<? super Integer, ? super k, Unit> f139969b;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/topcontainer/likeegg/imagepreview/PreviewItemAdapter$PreviewItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class PreviewItemViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final HSImageView f139970a;

        public PreviewItemViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            this.f139970a = (HSImageView) r100.findViewById(R.id.preview_image);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return ((ArrayList) this.f139968a).size();
    }

    public PreviewItemAdapter() {
        this.f139968a = new ArrayList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        PreviewItemViewHolder r102 = (PreviewItemViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        k r103 = (k) CollectionsKt.getOrNull(this.f139968a, r101);
        r102.itemView.setOnClickListener(new d(this, r103, r101));
        ImageLoader.bindImage(r102.f139970a, r103, R.drawable.ttlive_like_egg_preview_loading);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return new PreviewItemViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.ttlive_like_egg_preview_item, r100, false));
    }
}
