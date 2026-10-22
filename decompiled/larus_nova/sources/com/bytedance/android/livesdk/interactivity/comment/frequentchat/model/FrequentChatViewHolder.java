package com.bytedance.android.livesdk.interactivity.comment.frequentchat.model;

import android.view.View;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/frequentchat/model/FrequentChatViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FrequentChatViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f134878a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CardView f134879b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f134880c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f134881d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f134882e;

    public FrequentChatViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super(r100);
        this.f134878a = (TextView) r100.findViewById(R.id.comment_view);
        this.f134879b = (CardView) r100.findViewById(R.id.comment_layout);
        this.f134880c = (TextView) r100.findViewById(R.id.edit_btn);
        this.f134881d = (TextView) r100.findViewById(R.id.remove_btn);
        this.f134882e = r100.findViewById(R.id.sort_icon);
    }
}
