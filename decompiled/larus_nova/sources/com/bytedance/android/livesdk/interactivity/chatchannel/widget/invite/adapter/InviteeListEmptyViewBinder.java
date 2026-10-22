package com.bytedance.android.livesdk.interactivity.chatchannel.widget.invite.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.livesdk.utils.x0;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class InviteeListEmptyViewBinder extends me.drakeet.multitype.b<b, ItemViewHolder> {

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/chatchannel/widget/invite/adapter/InviteeListEmptyViewBinder$ItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ItemViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f134657a;

        public ItemViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            this.f134657a = r100.findViewById(R.id.create_channel);
        }
    }

    public interface a {
        void cd();
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a f134658a;

        public b(a r100) {
            this.f134658a = r100;
        }
    }

    public InviteeListEmptyViewBinder() {
    }

    @Override // me.drakeet.multitype.b
    public final void b(RecyclerView.ViewHolder r100, b r101) {
        ItemViewHolder r102 = (ItemViewHolder) r100;
        final b r103 = r101;
        Intrinsics.checkNotNullParameter(r102, "holder");
        Intrinsics.checkNotNullParameter(r103, MapController.ITEM_LAYER_TAG);
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, MapController.ITEM_LAYER_TAG);
        r102.f134657a.setOnClickListener(x0.a(new InviteeListEmptyViewBinder$ItemViewHolder$bindItem$1(r103)));
    }

    @Override // me.drakeet.multitype.b
    public final RecyclerView.ViewHolder d(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, "parent");
        return new ItemViewHolder(r100.inflate(R.layout.ttlive_item_invite_list_empty, r101, false));
    }
}
