package com.bytedance.android.live.effect.beauty;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/effect/beauty/BeautyModeSelectorAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/live/effect/beauty/BeautyModeSelectorAdapter$BeautyModeItemView;", "<init>", "()V", "BeautyModeItemView", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BeautyModeSelectorAdapter extends RecyclerView.Adapter<BeautyModeItemView> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Pair<String, String>> f67028a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f67029b;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/effect/beauty/BeautyModeSelectorAdapter$BeautyModeItemView;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class BeautyModeItemView extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f67030a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ImageView f67031b;

        public BeautyModeItemView(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            this.f67030a = (TextView) r100.findViewById(R.id.tv_mode_name);
            this.f67031b = (ImageView) r100.findViewById(R.id.iv_select);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return ((ArrayList) this.f67028a).size();
    }

    public BeautyModeSelectorAdapter() {
        this.f67028a = new ArrayList();
        this.f67029b = "normal";
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        BeautyModeItemView r102 = (BeautyModeItemView) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        String r103 = (String) ((Pair) ListProtector.get(this.f67028a, r101)).getFirst();
        String r104 = (String) ((Pair) ListProtector.get(this.f67028a, r101)).getSecond();
        r102.f67030a.setText(r104);
        ImageView r105 = r102.f67031b;
        if (Intrinsics.areEqual(this.f67029b, r103) == false) goto L5;
        int r106 = 0;
    L6:
        r105.setVisibility(r106);
        r102.itemView.setOnClickListener(new b(this, r103, r104, r102));
        return;
    L5:
        r106 = 4;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return new BeautyModeItemView(LayoutInflater.from(r100.getContext()).inflate(R.layout.ttlive_effect_beauty_mode_item, r100, false));
    }
}
