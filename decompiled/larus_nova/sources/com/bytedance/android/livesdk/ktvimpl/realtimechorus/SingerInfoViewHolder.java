package com.bytedance.android.livesdk.ktvimpl.realtimechorus;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.widget.HSImageView;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/realtimechorus/SingerInfoViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SingerInfoViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HSImageView f146464a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f146465b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CheckBox f146466c;

    public SingerInfoViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f146464a = (HSImageView) r100.findViewById(R.id.chorus_singer_info_avatar);
        this.f146465b = (TextView) r100.findViewById(R.id.chorus_singer_info_name);
        this.f146466c = (CheckBox) r100.findViewById(R.id.chorus_push_status);
    }
}
