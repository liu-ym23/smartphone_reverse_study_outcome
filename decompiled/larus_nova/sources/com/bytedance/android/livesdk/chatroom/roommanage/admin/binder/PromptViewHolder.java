package com.bytedance.android.livesdk.chatroom.roommanage.admin.binder;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/roommanage/admin/binder/PromptViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PromptViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f111256a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f111257b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f111258c;

    public PromptViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f111256a = (TextView) r100.findViewById(R.id.tv_send_time);
        this.f111257b = (TextView) r100.findViewById(R.id.tv_showing);
        this.f111258c = (TextView) r100.findViewById(R.id.tv_content);
    }
}
