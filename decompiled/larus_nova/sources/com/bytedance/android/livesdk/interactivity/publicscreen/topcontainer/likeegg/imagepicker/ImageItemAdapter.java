package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.imagepicker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.widget.HSImageView;
import com.larus.nova.R;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/topcontainer/likeegg/imagepicker/ImageItemAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/livesdk/interactivity/publicscreen/topcontainer/likeegg/imagepicker/ImageItemAdapter$ImageItemViewHolder;", "<init>", "()V", "ImageItemViewHolder", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ImageItemAdapter extends RecyclerView.Adapter<ImageItemViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<String> f139935a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function2<? super Integer, ? super String, Unit> f139936b;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/topcontainer/likeegg/imagepicker/ImageItemAdapter$ImageItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ImageItemViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final HSImageView f139937a;

        public ImageItemViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            this.f139937a = (HSImageView) r100.findViewById(R.id.album_image);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f139935a.size();
    }

    public ImageItemAdapter() {
        this.f139935a = new ArrayList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        ImageItemViewHolder r102 = (ImageItemViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        r102.itemView.setOnClickListener(new a(this, r101));
        String r103 = (String) CollectionsKt.getOrNull(this.f139935a, r101);
        if (r103 != null) goto L5;
        return;
    L5:
        if (r103.length() <= 0) goto L7;
        boolean r104 = true;
    L8:
        if (r104 != true) goto L12;
        ImageLoader.loadSdcardImage(r102.f139937a, r103);
        return;
    L12:
        return;
    L7:
        r104 = false;
        goto L8
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return new ImageItemViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.ttlive_like_egg_image_pick_item, r100, false));
    }
}
