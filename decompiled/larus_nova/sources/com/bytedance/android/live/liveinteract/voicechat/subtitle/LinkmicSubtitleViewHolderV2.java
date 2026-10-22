package com.bytedance.android.live.liveinteract.voicechat.subtitle;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/voicechat/subtitle/LinkmicSubtitleViewHolderV2;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LinkmicSubtitleViewHolderV2 extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f80681a;

    public LinkmicSubtitleViewHolderV2(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f80681a = (TextView) r100.findViewById(R.id.subtitle);
    }
}
