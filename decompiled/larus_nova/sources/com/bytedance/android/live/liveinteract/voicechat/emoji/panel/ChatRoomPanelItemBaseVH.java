package com.bytedance.android.live.liveinteract.voicechat.emoji.panel;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/voicechat/emoji/panel/ChatRoomPanelItemBaseVH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public abstract class ChatRoomPanelItemBaseVH extends RecyclerView.ViewHolder {
    public abstract void T3(g r100);

    public abstract void U3(ChatRoomPanelItemBaseVH r100);

    public ChatRoomPanelItemBaseVH(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super(r100);
    }
}
