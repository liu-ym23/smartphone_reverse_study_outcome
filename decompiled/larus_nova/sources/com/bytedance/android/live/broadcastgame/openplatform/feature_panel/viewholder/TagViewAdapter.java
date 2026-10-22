package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.broadcastgame.api.model.v;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/openplatform/feature_panel/viewholder/TagViewAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/live/broadcastgame/openplatform/feature_panel/viewholder/TagViewAdapter$TagViewHolder;", "TagViewHolder", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TagViewAdapter extends RecyclerView.Adapter<TagViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<v> f61662a;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/openplatform/feature_panel/viewholder/TagViewAdapter$TagViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class TagViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f61663a;

        public TagViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            super(r100);
            this.f61663a = (TextView) r100.findViewById(R.id.tag_view);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f61662a.size();
    }

    public TagViewAdapter(List<v> r100) {
        Intrinsics.checkNotNullParameter(r100, "dataList");
        this.f61662a = r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        TagViewHolder r102 = (TagViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        v r103 = (v) ListProtector.get(this.f61662a, r101);
        if (r103.text.length() != 0) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == false) goto L8;
        UtilityKotlinExtentionsKt.t(r102.f61663a);
    L9:
        r102.f61663a.setText(r103.text);
        return;
    L8:
        UtilityKotlinExtentionsKt.w(r102.f61663a);
        goto L9
    L5:
        r104 = false;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return new TagViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.ttlive_open_feature_list_interact_tools_tag_item, r100, false));
    }
}
