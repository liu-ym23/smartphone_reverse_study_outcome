package com.bytedance.android.livesdk.feed.drawerfeed.singledraw.viewholder;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.viewmodel.SingleDrawViewModel;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/feed/drawerfeed/singledraw/viewholder/SingleDrawTabViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "livefeed_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SingleDrawTabViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f123839a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f123840b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SingleDrawViewModel f123841c;

    public SingleDrawTabViewHolder(View r100, SingleDrawViewModel r101) {
        Intrinsics.checkNotNullParameter(r100, "itemview");
        super(r100);
        this.f123840b = r100;
        this.f123841c = r101;
        this.f123839a = (TextView) this.itemView.findViewById(R.id.single_drawer_tab_textview);
    }
}
