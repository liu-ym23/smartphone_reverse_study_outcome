package com.bytedance.android.livesdk.chatroom.replay.toolbar.dailog;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/replay/toolbar/dailog/ReplayToolbarMoreDialogViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ReplayToolbarMoreDialogViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f110099a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f110100b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f110101c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f110102d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f110103e;

    public ReplayToolbarMoreDialogViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f110099a = r100.findViewById(R.id.icon);
        this.f110100b = (TextView) r100.findViewById(R.id.name);
        this.f110101c = r100.findViewById(R.id.red_dot);
        this.f110102d = r100.findViewById(R.id.action_area);
        this.f110103e = r100.findViewById(R.id.icon_bg);
    }
}
