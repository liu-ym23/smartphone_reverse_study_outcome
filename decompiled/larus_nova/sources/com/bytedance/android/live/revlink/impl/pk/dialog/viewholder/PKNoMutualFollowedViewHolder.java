package com.bytedance.android.live.revlink.impl.pk.dialog.viewholder;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes47.dex */
public class PKNoMutualFollowedViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f96189a;

    public PKNoMutualFollowedViewHolder(View r100) {
        super(r100);
        this.f96189a = (TextView) r100.findViewById(R.id.tv_live_no_mutual_concern_user_list_tip);
    }
}
