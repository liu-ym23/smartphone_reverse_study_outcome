package com.bytedance.android.live.liveinteract.linkpanel.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.core.utils.s1;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class ListTitleItemBinder extends me.drakeet.multitype.b<q, ViewHolder> {

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/linkpanel/list/ListTitleItemBinder$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
        }
    }

    public ListTitleItemBinder() {
    }

    @Override // me.drakeet.multitype.b
    public final void b(RecyclerView.ViewHolder r100, q r101) {
        ViewHolder r102 = (ViewHolder) r100;
        q r103 = r101;
        Intrinsics.checkNotNullParameter(r102, "holder");
        Intrinsics.checkNotNullParameter(r103, MapController.ITEM_LAYER_TAG);
        View r104 = r102.itemView;
        if (r104 == null) goto L20;
        TextView r105 = (TextView) r104;
        byte r106 = r103.getType();
        if (r106 != 1) goto L7;
        String r107 = s1.B(R.string.ttlive_interact_talk_invite_title_audience);
    L17:
        r105.setText(r107);
        return;
    L7:
        if (r106 != 2) goto L9;
        r107 = s1.B(R.string.ttlive_interact_talk_invite_title_friends);
        goto L17
    L9:
        if (r106 != 4) goto L11;
        r107 = s1.B(R.string.ttlive_paid_live_enable_invite_has_ticket_user);
        goto L17
    L11:
        if (r106 == 8) goto L13;
        r107 = null;
        goto L17
    L13:
        r107 = s1.B(R.string.ttlive_paid_live_click_ai_guest_title);
        goto L17
    L20:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    }

    @Override // me.drakeet.multitype.b
    public final RecyclerView.ViewHolder d(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, "parent");
        return new ViewHolder(r100.inflate(R.layout.ttlive_item_talk_invite_list_title, r101, false));
    }
}
