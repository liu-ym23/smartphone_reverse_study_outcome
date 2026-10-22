package com.bytedance.android.live.effect.common;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.effect.base.BeautifyAdjustPercentBar;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/effect/common/AdjustBarListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/live/effect/common/AdjustBarListAdapter$AdjustBarViewHolder;", "AdjustBarViewHolder", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AdjustBarListAdapter extends RecyclerView.Adapter<AdjustBarViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Sticker f67801a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Integer> f67802b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f67803c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f67804d;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/effect/common/AdjustBarListAdapter$AdjustBarViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
    public final class AdjustBarViewHolder extends RecyclerView.ViewHolder {
        public AdjustBarViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        Sticker r100 = this.f67801a;
        if (r100 == null) goto L7;
        List<Sticker.ComposerConfig> r101 = r100.getComposerConfigList();
        if (r101 == null) goto L7;
        return r101.size();
    L7:
        return 0;
    }

    public AdjustBarListAdapter(d r100, g r101) {
        Intrinsics.checkNotNullParameter(r100, "config");
        Intrinsics.checkNotNullParameter(r101, "onLevelChangeListener");
        this.f67803c = r100;
        this.f67804d = r101;
        this.f67802b = new LinkedHashMap();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        AdjustBarViewHolder r102 = (AdjustBarViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        BeautifyAdjustPercentBar r103 = (BeautifyAdjustPercentBar) r102.itemView.findViewById(R.id.item_adjust_bar);
        if (r103 == null) goto L21;
        Sticker r104 = this.f67801a;
        if (r104 == null) goto L22;
        List<Sticker.ComposerConfig> r105 = r104.getComposerConfigList();
        if (r105 == null) goto L23;
        Sticker.ComposerConfig r106 = (Sticker.ComposerConfig) ListProtector.get(r105, r102.getAdapterPosition());
        if (r106 == null) goto L24;
        d r107 = this.f67803c;
        r103.U5(r107.f67851a, r107.f67852b, r107.f67853c);
        r103.V5(this.f67803c.f67854d, r106.getName());
        r103.setEnableSingeAdjust(this.f67803c.f67855e);
        if (r106.getDoubleDirection() == false) goto L14;
        r103.Y5(50, -50, r106.getDefaultValue(), false);
    L15:
        Map<String, Integer> r108 = this.f67802b;
        LinkedHashMap r109 = (LinkedHashMap) r108;
        Integer r110 = (Integer) r109.get(r106.getTag());
        if (r110 == null) goto L18;
        int r111 = r110.intValue();
    L19:
        r103.setPercent(r111);
        r103.setOnLevelChangeListener(new c(r106, this));
        return;
    L18:
        r111 = r106.getDefaultValue();
        goto L19
    L14:
        r103.Y5(100, 0, r106.getDefaultValue(), true);
        goto L15
    L24:
        return;
    L23:
        return;
    L22:
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return new AdjustBarViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.ttlive_effect_adjust_bar_item, r100, false));
    }
}
