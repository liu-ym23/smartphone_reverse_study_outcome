package com.bytedance.android.live.revlink.impl.multianchor.dialog.viewholder;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes47.dex */
public class AnchorLinkNoFollowedViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f93730a;

    public AnchorLinkNoFollowedViewHolder(View r100) {
        super(r100);
        this.f93730a = (TextView) r100.findViewById(R.id.tv_no_followed_anchor_tips);
    }
}
