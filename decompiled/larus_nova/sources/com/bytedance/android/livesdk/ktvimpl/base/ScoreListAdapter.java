package com.bytedance.android.livesdk.ktvimpl.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/ScoreListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/livesdk/ktvimpl/base/ScoreListAdapter$ScoreViewHolder;", "ScoreViewHolder", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ScoreListAdapter extends RecyclerView.Adapter<ScoreViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<q> f142389a;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/ScoreListAdapter$ScoreViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public final class ScoreViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f142390a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f142391b;

        public ScoreViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            this.f142390a = (TextView) r100.findViewById(R.id.tvLabel);
            this.f142391b = (TextView) r100.findViewById(R.id.tvValue);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f142389a.size();
    }

    public ScoreListAdapter(List<q> r100) {
        Intrinsics.checkNotNullParameter(r100, "scoreItems");
        this.f142389a = r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        ScoreViewHolder r102 = (ScoreViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        q r103 = (q) ListProtector.get(this.f142389a, r101);
        r102.f142390a.setText(r103.f143299a);
        TextView r104 = r102.f142391b;
        StringCompanionObject r105 = StringCompanionObject.INSTANCE;
        r104.setText(String.format("%.4f", Arrays.copyOf(new Object[]{Double.valueOf(r103.f143300b)}, 1)));
        if (r103.f143301c == false) goto L6;
        r102.f142391b.setTextColor(ColorProtector.parseColor("#FF4081"));
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return new ScoreViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.item_score, r100, false));
    }
}
