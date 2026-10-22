package com.bytedance.android.live.openplatform.impl.minigameaudience.toolbar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/minigameaudience/toolbar/GameTagsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/live/openplatform/impl/minigameaudience/toolbar/GameTagsAdapter$TagItemHolder;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "TagItemHolder", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GameTagsAdapter extends RecyclerView.Adapter<TagItemHolder> {

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/minigameaudience/toolbar/GameTagsAdapter$TagItemHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public final class TagItemHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f85317a;

        public TagItemHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
            super(r100);
            this.f85317a = r100;
        }
    }

    public GameTagsAdapter() {
        throw null;
    }

    public final Context getContext() {
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        TagItemHolder r102 = (TagItemHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        View r103 = r102.f85317a;
        if (r103 == null) goto L7;
        ((TextView) r103).setText("");
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return new TagItemHolder(LayoutInflater.from(null).inflate(R.layout.ttlive_open_platform_mg_detail_tag_item, r100, false));
    }
}
