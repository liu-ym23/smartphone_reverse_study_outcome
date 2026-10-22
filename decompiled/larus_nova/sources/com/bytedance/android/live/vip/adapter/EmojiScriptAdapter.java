package com.bytedance.android.live.vip.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.uicomponent.text.BorderTextView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rc1.b;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/vip/adapter/EmojiScriptAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/live/vip/adapter/EmojiScriptAdapter$EmojiScriptViewHolder;", "EmojiScriptViewHolder", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class EmojiScriptAdapter extends RecyclerView.Adapter<EmojiScriptViewHolder> {

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/vip/adapter/EmojiScriptAdapter$EmojiScriptViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class EmojiScriptViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final BorderTextView f102589a;

        public EmojiScriptViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            this.f102589a = (BorderTextView) r100.findViewById(R.id.script_text);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        throw null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        EmojiScriptViewHolder r102 = (EmojiScriptViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        String r103 = (String) ListProtector.get(null, r101);
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "text");
        r102.f102589a.setText(r103);
        r102.itemView.setOnClickListener(new b(this, r101));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return new EmojiScriptViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.ttlive_vip_emoji_template_script_viewholder, r100, false));
    }
}
