package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.selected.view;

import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/dialog/selected/view/MultiUserAvatarViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiUserAvatarViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f144216a;

    public MultiUserAvatarViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f144216a = (ImageView) r100.findViewById(R.id.multi_user_avatar);
    }
}
